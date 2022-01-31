package com.tencent.qqmusic.mediaplayer.codec;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.FileDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public class MediaCodecDecoder
  extends BaseDecoder
{
  private static final String TAG = "MediaCodecDecoder";
  private static final int TIMEOUT_US = 500000;
  private long mCurrentDecodeTime;
  private boolean mDecoderFinished;
  private long mFileSize;
  private AudioInformation mInfo;
  private MediaCodec mMediaCodec;
  private final MediaExtractor mMediaExtractor;
  private MediaFormat mMediaFormat;
  private byte[] mRemainBuffer;
  private SeekTable mSeekTable;
  
  public MediaCodecDecoder()
  {
    AppMethodBeat.i(128535);
    this.mMediaExtractor = new MediaExtractor();
    this.mMediaFormat = null;
    this.mMediaCodec = null;
    this.mInfo = null;
    this.mDecoderFinished = false;
    this.mCurrentDecodeTime = 0L;
    this.mRemainBuffer = null;
    this.mSeekTable = null;
    this.mFileSize = 0L;
    AppMethodBeat.o(128535);
  }
  
  private void initAudioInformation(String paramString, int paramInt, MediaFormat paramMediaFormat, IDataSource paramIDataSource)
  {
    AppMethodBeat.i(128545);
    this.mMediaExtractor.selectTrack(paramInt);
    this.mMediaCodec = MediaCodec.createDecoderByType(paramString);
    this.mMediaCodec.configure(paramMediaFormat, null, null, 0);
    this.mMediaFormat = paramMediaFormat;
    int m = this.mMediaFormat.getInteger("sample-rate");
    int n = this.mMediaFormat.getInteger("channel-count");
    long l = this.mMediaFormat.getLong("durationUs") / 1000L;
    int i;
    if (this.mMediaFormat.containsKey("bitrate")) {
      i = this.mMediaFormat.getInteger("bitrate") / 1000;
    }
    for (;;)
    {
      label154:
      int j;
      if ((Build.VERSION.SDK_INT >= 24) && (this.mMediaFormat.containsKey("pcm-encoding"))) {
        switch (this.mMediaFormat.getInteger("pcm-encoding"))
        {
        default: 
          paramInt = 2;
          if (Build.VERSION.SDK_INT >= 21) {
            j = 0;
          }
          break;
        }
      }
      label277:
      try
      {
        int k = this.mMediaFormat.getInteger("bitrate-mode");
        j = k;
      }
      catch (Exception paramString)
      {
        label180:
        label204:
        break label180;
      }
      switch (j)
      {
      default: 
        this.mInfo.setSampleRate(m);
        this.mInfo.setChannels(n);
        this.mInfo.setDuration(l);
        this.mInfo.setBitrate(i);
        this.mInfo.setBitDept(paramInt);
        paramString = paramIDataSource.getAudioType();
        if (paramString == AudioFormat.AudioType.FLAC)
        {
          this.mSeekTable = new FlacSeekTable(m);
          if (this.mSeekTable == null) {
            break;
          }
        }
        break;
      }
      try
      {
        this.mSeekTable.parse(paramIDataSource);
        this.mMediaCodec.start();
        AppMethodBeat.o(128545);
        return;
        if (l > 0L)
        {
          i = (int)(paramIDataSource.getSize() / l * 8L);
          continue;
        }
        i = 0;
        continue;
        paramInt = 1;
        break label154;
        paramInt = 4;
        break label154;
        paramInt = 2;
        break label154;
        this.mInfo.setCbr(1);
        break label204;
        this.mInfo.setCbr(3);
        break label204;
        if ((paramString == AudioFormat.AudioType.M4A) || (paramString == AudioFormat.AudioType.MP4))
        {
          this.mSeekTable = new Mp4SeekTable();
          break label277;
        }
        if (paramString != AudioFormat.AudioType.MP3) {
          break label277;
        }
        this.mSeekTable = new Mp3SeekTable();
      }
      catch (InvalidBoxException paramString)
      {
        for (;;)
        {
          this.mSeekTable = null;
          Logger.e("MediaCodecDecoder", "seek table parse", paramString);
        }
      }
    }
  }
  
  private void initMediaCodecAndFormat(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(128544);
    int i = 0;
    while (i < this.mMediaExtractor.getTrackCount())
    {
      MediaFormat localMediaFormat = this.mMediaExtractor.getTrackFormat(i);
      String str = localMediaFormat.getString("mime");
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("audio")))
      {
        this.mInfo = new AudioInformation();
        this.mInfo.setAudioType(paramIDataSource.getAudioType());
        setAudioType(paramIDataSource.getAudioType());
        initAudioInformation(str, i, localMediaFormat, paramIDataSource);
        AppMethodBeat.o(128544);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(128544);
  }
  
  public int decodeData(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128539);
    int j;
    if ((this.mRemainBuffer != null) && (this.mRemainBuffer.length > 0)) {
      if (paramInt >= this.mRemainBuffer.length)
      {
        System.arraycopy(this.mRemainBuffer, 0, paramArrayOfByte, 0, this.mRemainBuffer.length);
        j = this.mRemainBuffer.length;
        this.mRemainBuffer = null;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(128539);
      return j;
      System.arraycopy(this.mRemainBuffer, 0, paramArrayOfByte, 0, paramInt);
      int i = this.mRemainBuffer.length - paramInt;
      paramArrayOfByte = new byte[i];
      System.arraycopy(this.mRemainBuffer, paramInt, paramArrayOfByte, 0, i);
      this.mRemainBuffer = paramArrayOfByte;
      j = paramInt;
      continue;
      if (this.mMediaCodec != null)
      {
        ByteBuffer[] arrayOfByteBuffer2 = this.mMediaCodec.getInputBuffers();
        ByteBuffer[] arrayOfByteBuffer1 = this.mMediaCodec.getOutputBuffers();
        MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
        i = 0;
        j = i;
        if (!this.mDecoderFinished)
        {
          j = i;
          if (i <= 0)
          {
            j = this.mMediaCodec.dequeueInputBuffer(500000L);
            ByteBuffer localByteBuffer;
            int k;
            if (j >= 0)
            {
              localByteBuffer = arrayOfByteBuffer2[j];
              k = this.mMediaExtractor.readSampleData(localByteBuffer, 0);
              if (k < 0)
              {
                Logger.i("MediaCodecDecoder", "InputBuffer BUFFER_FLAG_END_OF_STREAM");
                this.mMediaCodec.queueInputBuffer(j, 0, 0, 0L, 4);
              }
            }
            else
            {
              label224:
              j = this.mMediaCodec.dequeueOutputBuffer(localBufferInfo, 500000L);
              switch (j)
              {
              default: 
                localByteBuffer = arrayOfByteBuffer1[j];
                if (paramInt >= localBufferInfo.size) {
                  break;
                }
              }
            }
            for (i = paramInt;; i = localBufferInfo.size)
            {
              localByteBuffer.get(paramArrayOfByte, 0, i);
              if (localBufferInfo.size > paramInt)
              {
                k = localBufferInfo.size - paramInt;
                this.mRemainBuffer = new byte[k];
                localByteBuffer.get(this.mRemainBuffer, 0, k);
              }
              localByteBuffer.clear();
              this.mMediaCodec.releaseOutputBuffer(j, false);
              long l1 = this.mCurrentDecodeTime;
              this.mCurrentDecodeTime = (localBufferInfo.presentationTimeUs / 1000L);
              if ((this.mInfo != null) && (this.mInfo.getBitDept() == 0))
              {
                long l2 = this.mCurrentDecodeTime;
                j = AudioRecognition.calcBitDept(localBufferInfo.size, l2 - l1, this.mInfo.getChannels(), this.mInfo.getSampleRate());
                this.mInfo.setBitDept(j);
              }
              for (;;)
              {
                if ((localBufferInfo.flags & 0x4) != 0)
                {
                  this.mDecoderFinished = true;
                  Logger.i("MediaCodecDecoder", "OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                }
                break;
                this.mMediaCodec.queueInputBuffer(j, 0, k, this.mMediaExtractor.getSampleTime(), 0);
                this.mMediaExtractor.advance();
                break label224;
                Logger.i("MediaCodecDecoder", "INFO_OUTPUT_BUFFERS_CHANGED");
                arrayOfByteBuffer1 = this.mMediaCodec.getOutputBuffers();
                continue;
                this.mMediaFormat = this.mMediaCodec.getOutputFormat();
                Logger.i("MediaCodecDecoder", "New format " + this.mMediaFormat);
                continue;
                Logger.i("MediaCodecDecoder", "dequeueOutputBuffer timed out!");
              }
            }
          }
        }
      }
      else
      {
        j = 0;
      }
    }
  }
  
  public AudioInformation getAudioInformation()
  {
    return this.mInfo;
  }
  
  public long getBytePositionOfTime(long paramLong)
  {
    AppMethodBeat.i(128546);
    int i = this.mInfo.getBitrate();
    if (this.mSeekTable != null)
    {
      paramLong = this.mSeekTable.seek(paramLong);
      AppMethodBeat.o(128546);
      return paramLong;
    }
    if (i > 0)
    {
      long l = i;
      AppMethodBeat.o(128546);
      return l * paramLong;
    }
    if (getDuration() > 0L)
    {
      paramLong = this.mFileSize * paramLong / getDuration();
      AppMethodBeat.o(128546);
      return paramLong;
    }
    AppMethodBeat.o(128546);
    return 0L;
  }
  
  public long getCurrentTime()
  {
    return this.mCurrentDecodeTime;
  }
  
  public long getDuration()
  {
    AppMethodBeat.i(128542);
    long l = 0L;
    if (this.mInfo != null) {
      l = this.mInfo.getDuration();
    }
    AppMethodBeat.o(128542);
    return l;
  }
  
  public int getErrorCodeMask()
  {
    return -1;
  }
  
  public long getMinBufferSize()
  {
    int i = 4;
    AppMethodBeat.i(128543);
    int j;
    if (this.mInfo != null)
    {
      j = this.mInfo.getBitDept();
      if (j == 1) {
        i = 3;
      }
    }
    for (long l = AudioTrack.getMinBufferSize((int)this.mInfo.getSampleRate(), 12, i);; l = 0L)
    {
      AppMethodBeat.o(128543);
      return l;
      if ((j == 4) && (Build.VERSION.SDK_INT >= 21)) {
        break;
      }
      i = 2;
      break;
    }
  }
  
  protected List<NativeLibs> getNativeLibs()
  {
    AppMethodBeat.i(128536);
    ArrayList localArrayList = new ArrayList();
    AppMethodBeat.o(128536);
    return localArrayList;
  }
  
  @TargetApi(23)
  public int init(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(128538);
    j = -1;
    i = j;
    if (paramIDataSource != null) {}
    try
    {
      paramIDataSource.open();
      this.mMediaExtractor.setDataSource(new MediaCodecDecoder.1(this, paramIDataSource));
      this.mFileSize = paramIDataSource.getSize();
      initMediaCodecAndFormat(paramIDataSource);
      i = 0;
    }
    catch (IOException paramIDataSource)
    {
      for (;;)
      {
        Logger.e("MediaCodecDecoder", "init", paramIDataSource);
        i = j;
      }
    }
    AppMethodBeat.o(128538);
    return i;
  }
  
  public int init(INativeDataSource paramINativeDataSource)
  {
    return -1;
  }
  
  public int init(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(128537);
    int i = init(new FileDataSource(paramString));
    AppMethodBeat.o(128537);
    return i;
  }
  
  public int release()
  {
    AppMethodBeat.i(128541);
    this.mMediaExtractor.release();
    if (this.mMediaCodec != null) {
      this.mMediaCodec.release();
    }
    AppMethodBeat.o(128541);
    return 0;
  }
  
  public int seekTo(int paramInt)
  {
    AppMethodBeat.i(128540);
    this.mMediaExtractor.seekTo(paramInt * 1000, 2);
    AppMethodBeat.o(128540);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.MediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */