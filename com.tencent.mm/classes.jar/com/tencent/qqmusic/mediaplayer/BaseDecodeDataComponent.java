package com.tencent.qqmusic.mediaplayer;

import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioFormat.Builder;
import android.media.AudioTrack;
import android.media.AudioTrack.Builder;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.PcmConvertionUtil;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener;
import java.lang.reflect.Field;

abstract class BaseDecodeDataComponent
{
  static final int CALL_PREPARED_DELAY_TIME = 20;
  private static int MAX_PLAY_SAMPLE_RATE = 0;
  private static final String TAG = "BaseDecodeDataComponent";
  boolean isUseFloatForHighDepth = false;
  final IAudioListener mAudioEffectListener;
  int mAudioStreamType = getAudioStreamType();
  AudioTrack mAudioTrack;
  int mBuffSize;
  final PlayerCallback mCallback;
  final CorePlayer mCorePlayer;
  boolean mCreateAudioTrackFail = false;
  long mCurPosition = 0L;
  final BufferInfo mDecodeBufferInfo = new BufferInfo();
  private final Handler mEventHandler;
  final FloatBufferInfo mFloatBufferInfo = new FloatBufferInfo();
  final HandleDecodeDataCallback mHandleDecodeDataCallback;
  boolean mHasDecode = false;
  boolean mHasDecodeSuccess = false;
  boolean mHasInit = false;
  final AudioInformation mInformation;
  int mLeastCommonMultiple = 1;
  volatile boolean mNeedChangePlayThreadPriority = false;
  private final int mPlayerID;
  final WaitNotify mSignalControl = new WaitNotify();
  Float mSpeedToSet = null;
  final PlayerStateRunner mStateRunner;
  int mTargetBitDepth = 2;
  long mTargetPlaySample;
  final IAudioListener mTerminalAudioEffectListener;
  PerformanceTracer performanceTracer = null;
  
  BaseDecodeDataComponent(CorePlayer paramCorePlayer, PlayerStateRunner paramPlayerStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt, IAudioListener paramIAudioListener1, IAudioListener paramIAudioListener2)
  {
    this.mCorePlayer = paramCorePlayer;
    this.mStateRunner = paramPlayerStateRunner;
    this.mInformation = paramAudioInformation;
    this.mCallback = paramPlayerCallback;
    this.mHandleDecodeDataCallback = paramHandleDecodeDataCallback;
    this.mEventHandler = paramHandler;
    this.mPlayerID = paramInt;
    this.mAudioEffectListener = paramIAudioListener1;
    this.mTerminalAudioEffectListener = paramIAudioListener2;
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCallback.playerException(this.mCorePlayer, paramInt1, paramInt2, paramInt3);
  }
  
  private void destroyAudioListeners()
  {
    this.mAudioEffectListener.onPlayerStopped();
    this.mTerminalAudioEffectListener.onPlayerStopped();
  }
  
  static int getAudioTrackPosition(long paramLong, AudioTrack paramAudioTrack)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramAudioTrack != null) {}
    try
    {
      l1 = Math.round((paramAudioTrack.getPlaybackHeadPosition() + paramLong) / paramAudioTrack.getSampleRate() * 1000.0D);
      return (int)l1;
    }
    catch (Exception paramAudioTrack)
    {
      for (;;)
      {
        Logger.e("BaseDecodeDataComponent", "getAudioTrackPosition", paramAudioTrack);
        l1 = l2;
      }
    }
  }
  
  static AudioTrack instantiateAudioTrackCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      AudioAttributes.Builder localBuilder = new AudioAttributes.Builder();
      localBuilder.setLegacyStreamType(paramInt1);
      AudioFormat.Builder localBuilder1 = new AudioFormat.Builder();
      localBuilder1.setSampleRate(paramInt2);
      localBuilder1.setEncoding(paramInt4);
      localBuilder1.setChannelMask(paramInt3);
      if (Build.VERSION.SDK_INT >= 23) {
        return new AudioTrack.Builder().setAudioAttributes(localBuilder.build()).setAudioFormat(localBuilder1.build()).setBufferSizeInBytes(paramInt5).setTransferMode(paramInt6).build();
      }
      return new AudioTrack(localBuilder.build(), localBuilder1.build(), paramInt5, paramInt6, 0);
    }
    return new AudioTrack(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  String axiliary(String paramString)
  {
    return "ID: " + this.mPlayerID + ". " + paramString;
  }
  
  protected long calculatePcmPlayTime(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramLong == 0L)) {
      return 0L;
    }
    return (paramArrayOfByte.length * 1000.0F / paramInt1 / paramInt2 / (float)paramLong);
  }
  
  protected long calculatePcmPlayTime(float[] paramArrayOfFloat, int paramInt, long paramLong)
  {
    if ((paramInt == 0) || (paramLong == 0L)) {
      return 0L;
    }
    return (paramArrayOfFloat.length * 1000.0F / paramInt / (float)paramLong);
  }
  
  void callExceptionCallback(int paramInt1, int paramInt2)
  {
    callExceptionCallback(paramInt1, paramInt2, 0);
  }
  
  void changePlayThreadPriorityImmediately()
  {
    Logger.d("BaseDecodeDataComponent", axiliary("changePlayThreadPriorityImmediately"));
    this.mNeedChangePlayThreadPriority = true;
  }
  
  void convertBytePcmToFloatPcm(BufferInfo paramBufferInfo, FloatBufferInfo paramFloatBufferInfo)
  {
    try
    {
      PcmConvertionUtil.convertByteBufferToFloatBuffer(paramBufferInfo, paramFloatBufferInfo, this.mInformation.getBitDepth());
      return;
    }
    finally
    {
      Logger.e("BaseDecodeDataComponent", paramBufferInfo);
    }
  }
  
  void doWaitForPaused()
  {
    this.mSignalControl.doWait(2000L, 5, new WaitNotify.WaitListener()
    {
      public boolean keepWaiting()
      {
        AppMethodBeat.i(76569);
        boolean bool = BaseDecodeDataComponent.this.isPaused();
        AppMethodBeat.o(76569);
        return bool;
      }
    });
  }
  
  void flush() {}
  
  abstract int getAudioStreamType();
  
  abstract long getCurPosition();
  
  int getMaxSupportSampleRate()
  {
    if (MAX_PLAY_SAMPLE_RATE > 0) {
      return MAX_PLAY_SAMPLE_RATE;
    }
    try
    {
      Field localField1 = AudioFormat.class.getDeclaredField("SAMPLE_RATE_HZ_MAX");
      localField1.setAccessible(true);
      MAX_PLAY_SAMPLE_RATE = localField1.getInt(null);
      Logger.i("BaseDecodeDataComponent", axiliary("get the max sample rate support by system from AudioFormat = " + MAX_PLAY_SAMPLE_RATE));
      i = MAX_PLAY_SAMPLE_RATE;
      return i;
    }
    finally
    {
      try
      {
        Field localField2 = AudioTrack.class.getDeclaredField("SAMPLE_RATE_HZ_MAX");
        localField2.setAccessible(true);
        MAX_PLAY_SAMPLE_RATE = localField2.getInt(null);
        Logger.i("BaseDecodeDataComponent", axiliary("get the max sample rate support by system from AudioTrack = " + MAX_PLAY_SAMPLE_RATE));
        int i = MAX_PLAY_SAMPLE_RATE;
        return i;
      }
      finally
      {
        Logger.i("BaseDecodeDataComponent", axiliary("can't reflect max sample rate, use default sample rate"));
        if (Build.VERSION.SDK_INT < 21) {
          return 48000;
        }
        if (Build.VERSION.SDK_INT < 22) {
          return 96000;
        }
      }
    }
    return 192000;
  }
  
  int getMinBufferSize(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = AudioTrack.getMinBufferSize((int)paramLong, paramInt1, paramInt2);
    int i = j;
    if (j < 0)
    {
      Logger.i("BaseDecodeDataComponent", axiliary("minBufferSize = " + j + " mTargetPlaySample = " + paramLong + "  channelConfiguration = " + paramInt1 + "   pcmEncoding = " + paramInt2));
      i = paramInt3 * 3536 * paramInt4;
    }
    return i;
  }
  
  int getPlayerState()
  {
    return this.mStateRunner.get().intValue();
  }
  
  int getSessionId()
  {
    if (this.mAudioTrack != null) {
      return this.mAudioTrack.getAudioSessionId();
    }
    return 0;
  }
  
  float getSpeed()
  {
    float f2 = 1.0F;
    float f1;
    if (this.mSpeedToSet != null) {
      f1 = this.mSpeedToSet.floatValue();
    }
    do
    {
      do
      {
        return f1;
        f1 = f2;
      } while (Build.VERSION.SDK_INT < 23);
      f1 = f2;
    } while (this.mAudioTrack == null);
    return this.mAudioTrack.getPlaybackParams().getSpeed();
  }
  
  abstract void handleDecodeData();
  
  void handleHighBitDepth(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2)
  {
    if (this.isUseFloatForHighDepth)
    {
      paramBufferInfo1.fillInto(paramBufferInfo2);
      return;
    }
    try
    {
      PcmConvertionUtil.convertBitDepthTo16(paramBufferInfo1, paramBufferInfo2, this.mInformation.getBitDepth());
      return;
    }
    finally
    {
      Logger.e("BaseDecodeDataComponent", paramBufferInfo1);
    }
  }
  
  void handleHighSample(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2)
  {
    try
    {
      PcmConvertionUtil.reSample(paramBufferInfo1, paramBufferInfo2, this.mInformation.getSampleRate(), this.mTargetPlaySample, this.mTargetBitDepth);
      return;
    }
    finally
    {
      Logger.e("BaseDecodeDataComponent", paramBufferInfo1);
    }
  }
  
  boolean hasDecodeData()
  {
    try
    {
      boolean bool = this.mHasDecode;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean hasDecodeDataSuccess()
  {
    try
    {
      boolean bool = this.mHasDecodeSuccess;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void initAudioListeners(int paramInt, AudioInformation paramAudioInformation, long paramLong)
  {
    this.mAudioEffectListener.onPlayerReady(paramInt, paramAudioInformation, paramLong);
    this.mTerminalAudioEffectListener.onPlayerReady(paramInt, paramAudioInformation, paramLong);
  }
  
  boolean isCompleted()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(7) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected boolean isError()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(9) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected boolean isIdle()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(0) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean isInit()
  {
    return this.mHasInit;
  }
  
  protected boolean isPaused()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(5) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean isPlaying()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(4) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected boolean isStopped()
  {
    try
    {
      boolean bool = this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(6) });
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean isSupportHighBitDepth()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  void notifySeekCompleteForAudioListeners(long paramLong)
  {
    this.mAudioEffectListener.onPlayerSeekComplete(paramLong);
    this.mTerminalAudioEffectListener.onPlayerSeekComplete(paramLong);
  }
  
  void pause(boolean paramBoolean)
  {
    Logger.i("BaseDecodeDataComponent", axiliary("pause"));
    this.mStateRunner.transfer(Integer.valueOf(5), new Integer[] { Integer.valueOf(4), Integer.valueOf(2) });
  }
  
  void play()
  {
    Logger.i("BaseDecodeDataComponent", axiliary("play"));
    this.mStateRunner.transfer(Integer.valueOf(4), new Integer[] { Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(6), Integer.valueOf(4) });
    if (this.mSignalControl.isWaiting())
    {
      Logger.d("BaseDecodeDataComponent", axiliary("lock is Waiting, event: play, doNotify"));
      this.mSignalControl.doNotify();
    }
  }
  
  void postRunnable(Runnable paramRunnable, int paramInt)
  {
    this.mEventHandler.postDelayed(paramRunnable, paramInt);
  }
  
  void refreshTimeAndNotify(int paramInt)
  {
    if ((this.mSignalControl.isWaiting()) && (isPlaying()))
    {
      Logger.d("BaseDecodeDataComponent", axiliary("lock is Waiting, event: seek, doNotify"));
      this.mSignalControl.doNotify();
    }
  }
  
  /* Error */
  void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 362	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   4: ifnull +45 -> 49
    //   7: aload_0
    //   8: getfield 362	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   11: invokevirtual 464	android/media/AudioTrack:stop	()V
    //   14: aload_0
    //   15: getfield 362	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   18: invokevirtual 466	android/media/AudioTrack:flush	()V
    //   21: aload_0
    //   22: getfield 362	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   25: invokevirtual 468	android/media/AudioTrack:release	()V
    //   28: aload_0
    //   29: invokespecial 470	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:destroyAudioListeners	()V
    //   32: aload_0
    //   33: aconst_null
    //   34: invokevirtual 474	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:setAudioTrack	(Landroid/media/AudioTrack;)V
    //   37: ldc 18
    //   39: aload_0
    //   40: ldc_w 476
    //   43: invokevirtual 265	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 269	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 114	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   53: getfield 481	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   56: ifne +38 -> 94
    //   59: aload_0
    //   60: getfield 116	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   63: iconst_1
    //   64: anewarray 356	java/lang/Integer
    //   67: dup
    //   68: iconst_0
    //   69: bipush 7
    //   71: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokevirtual 418	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:isEqual	([Ljava/lang/Integer;)Z
    //   78: ifeq +60 -> 138
    //   81: aload_0
    //   82: getfield 120	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   85: aload_0
    //   86: getfield 114	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   89: invokeinterface 485 2 0
    //   94: return
    //   95: astore_1
    //   96: ldc 18
    //   98: aload_1
    //   99: invokestatic 285	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: goto -88 -> 14
    //   105: astore_1
    //   106: ldc 18
    //   108: aload_1
    //   109: invokestatic 285	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: goto -91 -> 21
    //   115: astore_1
    //   116: ldc 18
    //   118: aload_1
    //   119: invokestatic 285	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: goto -94 -> 28
    //   125: astore_1
    //   126: ldc 18
    //   128: ldc_w 487
    //   131: aload_1
    //   132: invokestatic 489	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: goto -103 -> 32
    //   138: aload_0
    //   139: getfield 120	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   142: aload_0
    //   143: getfield 114	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   146: invokeinterface 492 2 0
    //   151: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	BaseDecodeDataComponent
    //   95	4	1	localThrowable1	java.lang.Throwable
    //   105	4	1	localThrowable2	java.lang.Throwable
    //   115	4	1	localThrowable3	java.lang.Throwable
    //   125	7	1	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   7	14	95	finally
    //   14	21	105	finally
    //   21	28	115	finally
    //   28	32	125	finally
  }
  
  void releaseNotify()
  {
    if (this.mSignalControl.isWaiting())
    {
      Logger.d("BaseDecodeDataComponent", axiliary("lock is Waiting, event: release, doNotify"));
      this.mSignalControl.doNotify();
    }
  }
  
  void seek(int paramInt) {}
  
  void setAudioStreamType(int paramInt)
  {
    if (paramInt == this.mAudioStreamType) {
      return;
    }
    this.mAudioStreamType = paramInt;
  }
  
  void setAudioTrack(AudioTrack paramAudioTrack)
  {
    this.mAudioTrack = paramAudioTrack;
    this.mHandleDecodeDataCallback.onAudioTrackChanged(paramAudioTrack);
  }
  
  void setLeastCommonMultiple(int paramInt)
  {
    if (paramInt <= 0)
    {
      Logger.e("BaseDecodeDataComponent", "wrong least common multiple: ".concat(String.valueOf(paramInt)));
      return;
    }
    this.mLeastCommonMultiple = paramInt;
  }
  
  void setPerformanceTracer(PerformanceTracer paramPerformanceTracer)
  {
    this.performanceTracer = paramPerformanceTracer;
  }
  
  void setSpeed(float paramFloat)
  {
    this.mSpeedToSet = Float.valueOf(paramFloat);
  }
  
  void setVolume(float paramFloat1, float paramFloat2)
  {
    if (this.mAudioTrack != null) {}
    try
    {
      this.mAudioTrack.setStereoVolume(paramFloat1, paramFloat2);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logger.e("BaseDecodeDataComponent", "setVolume", localIllegalStateException);
    }
  }
  
  void stop()
  {
    Logger.i("BaseDecodeDataComponent", axiliary("stop"));
    if ((this.mStateRunner.transfer(Integer.valueOf(6), new Integer[] { Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(2) })) && (this.mSignalControl.isWaiting()))
    {
      Logger.d("BaseDecodeDataComponent", axiliary("lock is Waiting, event: stop, doNotify"));
      this.mSignalControl.doNotify();
    }
  }
  
  static abstract interface HandleDecodeDataCallback
  {
    public abstract long getCurPositionByDecoder();
    
    public abstract long getMinPcmBufferSize();
    
    public abstract void onAudioTrackChanged(AudioTrack paramAudioTrack);
    
    public abstract void onPullDecodeDataEndOrFailed(int paramInt1, int paramInt2);
    
    public abstract int pullDecodeData(int paramInt, byte[] paramArrayOfByte);
    
    public abstract int seekTo(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.BaseDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */