package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VideoParam;
import com.tencent.ttpic.util.FrameRateUtil;
import com.tencent.ttpic.util.FrameRateUtil.DOWNGRADE_LEVEL;
import java.nio.ByteBuffer;

@TargetApi(18)
public class MyRecorder
{
  private static final String TAG;
  private MediaCodec.BufferInfo mBufferInfo = null;
  private MediaCodec mMediaCodec = null;
  private MediaMuxer mMediaMuxer = null;
  private boolean mMuxerStarted = false;
  private String mOutput;
  private float mPlayRate = 1.0F;
  private Surface mSurface;
  private int mTrackIndex = -1;
  
  static
  {
    AppMethodBeat.i(83706);
    TAG = MyRecorder.class.getSimpleName();
    AppMethodBeat.o(83706);
  }
  
  public MyRecorder(String paramString)
  {
    this.mOutput = paramString;
  }
  
  private void drainEncoder(boolean paramBoolean)
  {
    AppMethodBeat.i(83704);
    if (!isValid())
    {
      AppMethodBeat.o(83704);
      return;
    }
    if (paramBoolean) {}
    int i;
    label313:
    do
    {
      MediaFormat localMediaFormat;
      for (;;)
      {
        try
        {
          this.mMediaCodec.signalEndOfInputStream();
          ByteBuffer[] arrayOfByteBuffer = this.mMediaCodec.getOutputBuffers();
          i = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, 0L);
          if (i == -1)
          {
            if (paramBoolean) {
              continue;
            }
            AppMethodBeat.o(83704);
            return;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          AppMethodBeat.o(83704);
          return;
        }
        if (i != -3) {
          if (i == -2)
          {
            if (this.mMuxerStarted)
            {
              this.mMediaCodec.releaseOutputBuffer(i, false);
            }
            else
            {
              localMediaFormat = this.mMediaCodec.getOutputFormat();
              this.mTrackIndex = this.mMediaMuxer.addTrack(localMediaFormat);
              this.mMediaMuxer.start();
              this.mMuxerStarted = true;
            }
          }
          else
          {
            localMediaFormat = localRuntimeException[i];
            if (localMediaFormat == null)
            {
              new StringBuilder("encoderOutputBuffer ").append(i).append(" was null");
              this.mMediaCodec.releaseOutputBuffer(i, false);
            }
            else
            {
              if ((this.mBufferInfo.flags & 0x2) != 0) {
                this.mBufferInfo.size = 0;
              }
              if (this.mBufferInfo.size == 0) {
                break label313;
              }
              if (this.mMuxerStarted) {
                break;
              }
              this.mMediaCodec.releaseOutputBuffer(i, false);
            }
          }
        }
      }
      localMediaFormat.position(this.mBufferInfo.offset);
      localMediaFormat.limit(this.mBufferInfo.offset + this.mBufferInfo.size);
      if (Float.compare(this.mPlayRate, 1.0F) != 0) {
        this.mBufferInfo.presentationTimeUs = (((float)this.mBufferInfo.presentationTimeUs * this.mPlayRate));
      }
      this.mMediaMuxer.writeSampleData(this.mTrackIndex, localMediaFormat, this.mBufferInfo);
      this.mMediaCodec.releaseOutputBuffer(i, false);
      i = this.mBufferInfo.flags;
    } while ((i & 0x4) == 0);
    AppMethodBeat.o(83704);
  }
  
  private boolean isValid()
  {
    return (this.mMediaCodec != null) && (this.mMediaMuxer != null) && (this.mBufferInfo != null);
  }
  
  public Surface getInputSurface()
  {
    return this.mSurface;
  }
  
  public String getOutputPath()
  {
    return this.mOutput;
  }
  
  public boolean isRecording()
  {
    return this.mMediaCodec != null;
  }
  
  public boolean prepareEncoder(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(83700);
    if (this.mMediaCodec != null)
    {
      AppMethodBeat.o(83700);
      return true;
    }
    this.mBufferInfo = new MediaCodec.BufferInfo();
    try
    {
      MediaFormat localMediaFormat = MediaFormat.createVideoFormat(VideoParam.mMime, paramInt1, paramInt2);
      localMediaFormat.setInteger("color-format", 2130708361);
      localMediaFormat.setInteger("bitrate", FrameRateUtil.getRenderLevel().bps);
      localMediaFormat.setInteger("frame-rate", 18);
      localMediaFormat.setInteger("i-frame-interval", VideoParam.mIfi);
      this.mMediaCodec = MediaCodec.createEncoderByType(VideoParam.mMime);
      if (this.mMediaCodec != null) {
        this.mMediaCodec.configure(localMediaFormat, null, null, 1);
      }
      this.mMediaMuxer = new MediaMuxer(this.mOutput, 0);
      this.mMuxerStarted = false;
      if ((this.mSurface == null) && (this.mMediaCodec != null)) {
        this.mSurface = this.mMediaCodec.createInputSurface();
      }
      AppMethodBeat.o(83700);
      return true;
    }
    catch (Exception localException)
    {
      releaseEncoder();
      AppMethodBeat.o(83700);
    }
    return false;
  }
  
  public void releaseEncoder()
  {
    AppMethodBeat.i(83703);
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.stop();
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      if (this.mMediaMuxer != null)
      {
        this.mMediaMuxer.stop();
        this.mMediaMuxer.release();
        this.mMediaMuxer = null;
      }
      this.mBufferInfo = null;
      AppMethodBeat.o(83703);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      AppMethodBeat.o(83703);
    }
  }
  
  public void setPlayRate(float paramFloat)
  {
    this.mPlayRate = paramFloat;
  }
  
  public void start()
  {
    AppMethodBeat.i(83705);
    if (this.mMediaCodec != null) {
      this.mMediaCodec.start();
    }
    AppMethodBeat.o(83705);
  }
  
  public void stop()
  {
    AppMethodBeat.i(83702);
    drainEncoder(true);
    releaseEncoder();
    AppMethodBeat.o(83702);
  }
  
  public void swapBuffers()
  {
    AppMethodBeat.i(83701);
    if ((!isRecording()) || (!isValid()))
    {
      AppMethodBeat.o(83701);
      return;
    }
    drainEncoder(false);
    AppMethodBeat.o(83701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.recorder.MyRecorder
 * JD-Core Version:    0.7.0.1
 */