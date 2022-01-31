package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class MediaCodecDecoder
{
  private static final String TAG = "MediaCodecDecoder";
  private MediaCodec.BufferInfo mAACDecBufferInfo;
  private MediaCodec mAudioAACDecoder;
  private int mChannels;
  private ByteBuffer mDecInBuffer;
  private ByteBuffer mDecOutBuffer;
  ByteBuffer mInputBuffer;
  ByteBuffer mOutputBuffer;
  private int mSampleRate;
  private byte[] mTempBufDec;
  
  public MediaCodecDecoder()
  {
    AppMethodBeat.i(146950);
    this.mAudioAACDecoder = null;
    this.mChannels = 2;
    this.mSampleRate = 44100;
    this.mInputBuffer = null;
    this.mOutputBuffer = null;
    this.mAACDecBufferInfo = null;
    this.mDecInBuffer = ByteBuffer.allocateDirect(16384);
    this.mDecOutBuffer = ByteBuffer.allocateDirect(16384);
    this.mTempBufDec = new byte[16384];
    AppMethodBeat.o(146950);
  }
  
  @SuppressLint({"NewApi"})
  public int createAACDecoder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146951);
    try
    {
      this.mAudioAACDecoder = MediaCodec.createDecoderByType("audio/mp4a-latm");
      MediaFormat localMediaFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", paramInt1, paramInt2);
      localMediaFormat.setInteger("sample-rate", paramInt1);
      localMediaFormat.setInteger("channel-count", paramInt2);
      localMediaFormat.setInteger("aac-profile", 2);
      localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 17, -112 }));
      this.mAudioAACDecoder.configure(localMediaFormat, null, null, 0);
      if (this.mAudioAACDecoder != null)
      {
        this.mAudioAACDecoder.start();
        this.mAACDecBufferInfo = new MediaCodec.BufferInfo();
        a.dUd();
        a.iP("MediaCodecDecoder", "createAACDecoder succeed!!! : (" + paramInt1 + ", " + paramInt2 + ")");
      }
      AppMethodBeat.o(146951);
      return 0;
    }
    catch (Exception localException)
    {
      a.dUd();
      a.iO("TRAE", "Error when creating aac decode stream");
      AppMethodBeat.o(146951);
    }
    return -1;
  }
  
  public int decodeAACFrame(int paramInt)
  {
    AppMethodBeat.i(146952);
    this.mDecInBuffer.get(this.mTempBufDec, 0, paramInt);
    paramInt = decodeInternalAACFrame(paramInt);
    this.mDecOutBuffer.rewind();
    if (paramInt > 0) {
      this.mDecOutBuffer.put(this.mTempBufDec, 0, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(146952);
      return paramInt;
      paramInt = 0;
    }
  }
  
  @SuppressLint({"NewApi"})
  public int decodeInternalAACFrame(int paramInt)
  {
    AppMethodBeat.i(146953);
    for (;;)
    {
      int i;
      try
      {
        i = this.mAudioAACDecoder.dequeueInputBuffer(200L);
        if (i >= 0)
        {
          if (Build.VERSION.SDK_INT >= 21)
          {
            this.mInputBuffer = this.mAudioAACDecoder.getInputBuffer(i);
            this.mInputBuffer.clear();
            this.mInputBuffer.put(this.mTempBufDec, 0, paramInt);
            this.mDecInBuffer.rewind();
            this.mAudioAACDecoder.queueInputBuffer(i, 0, paramInt, 0L, 0);
          }
        }
        else
        {
          i = this.mAudioAACDecoder.dequeueOutputBuffer(this.mAACDecBufferInfo, 10000L);
          if (i >= 0) {
            break label133;
          }
          AppMethodBeat.o(146953);
          return 0;
        }
        this.mInputBuffer = this.mAudioAACDecoder.getInputBuffers()[i];
        continue;
        if (Build.VERSION.SDK_INT < 21) {}
      }
      catch (Exception localException1)
      {
        AppMethodBeat.o(146953);
        return 0;
      }
      label133:
      for (this.mOutputBuffer = this.mAudioAACDecoder.getOutputBuffer(i);; this.mOutputBuffer = this.mAudioAACDecoder.getOutputBuffers()[i])
      {
        int j = this.mAACDecBufferInfo.size;
        try
        {
          this.mOutputBuffer.limit(j);
          this.mOutputBuffer.get(this.mTempBufDec, 0, j);
          this.mOutputBuffer.position(0);
          this.mAudioAACDecoder.releaseOutputBuffer(i, false);
          AppMethodBeat.o(146953);
          return j;
        }
        catch (Exception localException2)
        {
          a.dUd();
          a.iO("TRAE", "Error when decoding aac stream");
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public int releaseAACDecoder()
  {
    AppMethodBeat.i(146954);
    try
    {
      if (this.mAudioAACDecoder != null)
      {
        this.mAudioAACDecoder.stop();
        this.mAudioAACDecoder.release();
        this.mAudioAACDecoder = null;
        a.dUd();
        a.iP("MediaCodecDecoder", "releaseAACDecoder, release aac decode stream succeed!!");
        AppMethodBeat.o(146954);
        return 0;
      }
    }
    catch (Exception localException)
    {
      a.dUd();
      a.iO("TRAE", "releaseAACDecoder, Error when releasing aac decode stream");
      AppMethodBeat.o(146954);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.MediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */