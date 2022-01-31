package com.tencent.rtmp.sharp.jni;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.nio.ByteBuffer;

public class AudioDecoder
{
  private static final String TAG = "AudioDecoder";
  boolean IsTenFramesReady = false;
  int channels = 0;
  private boolean codeOver = true;
  private RingBuffer decRingBuffer = null;
  private MediaCodec.BufferInfo decodeBufferInfo = null;
  private ByteBuffer[] decodeInputBuffers = null;
  private ByteBuffer[] decodeOutputBuffers = null;
  private long fileTotalMs = 0L;
  int m_nIndex = 0;
  private MediaCodec mediaDecode = null;
  private MediaExtractor mediaExtractor = null;
  int nFirstThreeFrameInfo = 3;
  int nFrameSize = 3840;
  private a onCompleteListener = null;
  private b onProgressListener = null;
  int sampleRate = 0;
  private String srcPath;
  
  private int initMediaDecode(int paramInt)
  {
    AppMethodBeat.i(146908);
    try
    {
      this.mediaExtractor = new MediaExtractor();
      this.mediaExtractor.setDataSource(this.srcPath);
      if (this.mediaExtractor.getTrackCount() > 1)
      {
        a.dUd();
        a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " initMediaDecode mediaExtractor container video, getTrackCount: " + this.mediaExtractor.getTrackCount());
        this.codeOver = true;
        AppMethodBeat.o(146908);
        return -2;
      }
      int i = 0;
      for (;;)
      {
        if (i < this.mediaExtractor.getTrackCount())
        {
          MediaFormat localMediaFormat = this.mediaExtractor.getTrackFormat(i);
          String str = localMediaFormat.getString("mime");
          a.dUd();
          a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " initMediaDecode mediaExtractor audio type:" + str);
          if (str.startsWith("audio/mpeg"))
          {
            this.mediaExtractor.selectTrack(i);
            this.mediaDecode = MediaCodec.createDecoderByType(str);
            this.mediaDecode.configure(localMediaFormat, null, null, 0);
            this.sampleRate = localMediaFormat.getInteger("sample-rate");
            this.channels = localMediaFormat.getInteger("channel-count");
            this.fileTotalMs = (localMediaFormat.getLong("durationUs") / 1000L);
            this.nFrameSize = (this.sampleRate * this.channels * 2 * 20 / 1000);
            this.decRingBuffer = new RingBuffer(this.nFrameSize * paramInt);
            a.dUd();
            a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " initMediaDecode open succeed, mp3 format:(" + this.sampleRate + "," + this.channels + "), fileTotalMs:" + this.fileTotalMs + "ms RingBufferFrame:" + paramInt);
          }
        }
        else
        {
          if (this.mediaDecode != null) {
            break;
          }
          new StringBuilder("m_nIndex: ").append(this.m_nIndex).append(" initMediaDecode create mediaDecode failed");
          this.codeOver = true;
          AppMethodBeat.o(146908);
          return -1;
        }
        i += 1;
      }
      if (this.decRingBuffer != null) {
        break label448;
      }
    }
    catch (IOException localIOException)
    {
      this.codeOver = true;
      AppMethodBeat.o(146908);
      return -1;
    }
    new StringBuilder("m_nIndex: ").append(this.m_nIndex).append(" initMediaDecode create decRingBuffer failed");
    this.codeOver = true;
    AppMethodBeat.o(146908);
    return -1;
    label448:
    this.mediaDecode.start();
    this.decodeInputBuffers = this.mediaDecode.getInputBuffers();
    this.decodeOutputBuffers = this.mediaDecode.getOutputBuffers();
    this.decodeBufferInfo = new MediaCodec.BufferInfo();
    this.codeOver = false;
    this.IsTenFramesReady = false;
    this.nFirstThreeFrameInfo = 3;
    AppMethodBeat.o(146908);
    return 0;
  }
  
  private void showLog(String paramString) {}
  
  private void srcAudioFormatToPCM()
  {
    AppMethodBeat.i(146909);
    if (this.decodeInputBuffers.length <= 1)
    {
      a.dUd();
      a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM decodeInputBuffers.length to small," + this.decodeInputBuffers.length);
      this.codeOver = true;
      AppMethodBeat.o(146909);
      return;
    }
    int i = this.mediaDecode.dequeueInputBuffer(-1L);
    if (i < 0)
    {
      a.dUd();
      a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM decodeInputBuffers.inputIndex <0");
      this.codeOver = true;
      AppMethodBeat.o(146909);
      return;
    }
    int j = Build.VERSION.SDK_INT;
    int k;
    if (j >= 21)
    {
      localByteBuffer = this.mediaDecode.getInputBuffer(i);
      localByteBuffer.clear();
      k = this.mediaExtractor.readSampleData(localByteBuffer, 0);
      if (k >= 0) {
        break label426;
      }
      a.dUd();
      a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM readSampleData over,end");
      this.codeOver = true;
      label204:
      i = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000L);
      if (i < 0) {
        break label511;
      }
      if (j < 21) {
        break label449;
      }
    }
    for (ByteBuffer localByteBuffer = this.mediaDecode.getOutputBuffer(i);; localByteBuffer = this.decodeOutputBuffers[i])
    {
      for (;;)
      {
        byte[] arrayOfByte = new byte[this.decodeBufferInfo.size];
        try
        {
          localByteBuffer.get(arrayOfByte);
          localByteBuffer.clear();
          if ((this.decRingBuffer != null) && (this.decodeBufferInfo.size > 0))
          {
            this.decRingBuffer.Push(arrayOfByte, this.decodeBufferInfo.size);
            k = this.nFirstThreeFrameInfo;
            this.nFirstThreeFrameInfo = (k - 1);
            if (k > 0)
            {
              a.dUd();
              a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " DecodeOneFrame size: " + this.decodeBufferInfo.size + " Remain: " + this.decRingBuffer.RemainRead() / this.nFrameSize);
            }
          }
          this.mediaDecode.releaseOutputBuffer(i, false);
          if (this.decodeBufferInfo.size > 0) {
            break;
          }
          i = this.mediaDecode.dequeueOutputBuffer(this.decodeBufferInfo, 10000L);
        }
        catch (Exception localException)
        {
          label426:
          label449:
          a.dUd();
          a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " srcAudioFormatToPCM wrong outputIndex: " + i);
          this.codeOver = true;
          AppMethodBeat.o(146909);
          return;
        }
      }
      localByteBuffer = this.decodeInputBuffers[i];
      break;
      this.mediaDecode.queueInputBuffer(i, 0, k, 0L, 0);
      this.mediaExtractor.advance();
      break label204;
    }
    label511:
    AppMethodBeat.o(146909);
  }
  
  public int ReadOneFrame(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 20;
    AppMethodBeat.i(146911);
    int i = j;
    if (!this.IsTenFramesReady)
    {
      i = 20;
      while ((this.decRingBuffer.RemainRead() / this.nFrameSize < 10) && (i > 0) && (!this.codeOver))
      {
        srcAudioFormatToPCM();
        i -= 1;
      }
      a.dUd();
      a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " 10 FramesReady Remain frame: " + this.decRingBuffer.RemainRead() / this.nFrameSize);
      this.IsTenFramesReady = true;
      i = j;
    }
    while ((!this.codeOver) && (this.decRingBuffer.RemainRead() / this.nFrameSize < 10) && (i > 0))
    {
      srcAudioFormatToPCM();
      i -= 1;
    }
    if (this.decRingBuffer.RemainRead() >= paramInt) {
      this.decRingBuffer.Pop(paramArrayOfByte, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(146911);
      return paramInt;
      paramInt = -1;
    }
  }
  
  public int SeekTo(int paramInt)
  {
    AppMethodBeat.i(146910);
    if (this.mediaExtractor != null)
    {
      long l1 = this.mediaExtractor.getSampleTime();
      paramInt = this.decRingBuffer.RemainRead() * 20 / this.nFrameSize + paramInt;
      a.dUd();
      a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " current PlayMs: " + l1 / 1000L + " SeekTo: " + paramInt);
      this.mediaExtractor.seekTo(paramInt * 1000, 2);
      long l2 = this.mediaExtractor.getSampleTime();
      paramInt = (int)((l2 - l1) / 1000L);
      a.dUd();
      a.iP("TRAE", "m_nIndex: " + this.m_nIndex + " total SeekTo time: " + paramInt + " t2:" + l2 / 1000L);
      AppMethodBeat.o(146910);
      return paramInt;
    }
    AppMethodBeat.o(146910);
    return 0;
  }
  
  public int getChannels()
  {
    return this.channels;
  }
  
  public long getFileTotalMs()
  {
    return this.fileTotalMs;
  }
  
  public int getFrameSize()
  {
    return this.nFrameSize;
  }
  
  public int getSampleRate()
  {
    return this.sampleRate;
  }
  
  public int prepare(int paramInt)
  {
    AppMethodBeat.i(146907);
    if (this.srcPath == null)
    {
      AppMethodBeat.o(146907);
      return -1;
    }
    paramInt = initMediaDecode(paramInt);
    AppMethodBeat.o(146907);
    return paramInt;
  }
  
  public void release()
  {
    AppMethodBeat.i(146912);
    if (this.mediaDecode != null)
    {
      this.mediaDecode.stop();
      this.mediaDecode.release();
      this.mediaDecode = null;
    }
    if (this.mediaExtractor != null)
    {
      this.mediaExtractor.release();
      this.mediaExtractor = null;
    }
    if (this.onCompleteListener != null) {
      this.onCompleteListener = null;
    }
    if (this.onProgressListener != null) {
      this.onProgressListener = null;
    }
    showLog("release");
    AppMethodBeat.o(146912);
  }
  
  public void setIOPath(String paramString)
  {
    this.srcPath = paramString;
  }
  
  public void setIndex(int paramInt)
  {
    this.m_nIndex = paramInt;
  }
  
  public void setOnCompleteListener(a parama)
  {
    this.onCompleteListener = parama;
  }
  
  public void setOnProgressListener(b paramb)
  {
    this.onProgressListener = paramb;
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */