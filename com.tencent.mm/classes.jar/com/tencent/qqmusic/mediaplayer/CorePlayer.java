package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
import com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer;
import com.tencent.qqmusic.mediaplayer.seektable.NativeSeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import com.tencent.qqmusic.mediaplayer.upstream.INativeDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class CorePlayer
  implements BaseDecodeDataComponent.HandleDecodeDataCallback, Runnable
{
  private static final AtomicInteger PLAYER_ID_CREATOR;
  private static final String TAG = "CorePlayer";
  final List<IAudioListener> mAudioEffectList;
  private final PlayerCallback mCallback;
  private IDataSource mDataSource;
  private final BaseDecoder mDecoder;
  private final Handler mEventHandler;
  private final QMThreadExecutor mExecutor;
  protected AudioInformation mInformation;
  private boolean mIsAudioEffectParamPrepared;
  volatile boolean mIsExit;
  private INativeDataSource mNativeDataSource;
  private BaseDecodeDataComponent mPcmCompnent;
  private String mPlayPath;
  private int mPlayerID;
  private int mPlayerMode;
  private Float mSpeedToSet;
  private final PlayerStateRunner mStateRunner;
  private int mTargetBitDepth;
  final List<IAudioListener> mTerminalAudioEffectList;
  private String mThreadName;
  private PerformanceTracer performanceTracer;
  
  static
  {
    AppMethodBeat.i(76711);
    PLAYER_ID_CREATOR = new AtomicInteger(0);
    AppMethodBeat.o(76711);
  }
  
  CorePlayer(IDataSource paramIDataSource, INativeDataSource paramINativeDataSource, PlayerCallback paramPlayerCallback, Looper paramLooper, BaseDecoder paramBaseDecoder, QMThreadExecutor paramQMThreadExecutor)
  {
    AppMethodBeat.i(76677);
    this.mTargetBitDepth = 2;
    this.mIsAudioEffectParamPrepared = false;
    this.mStateRunner = new PlayerStateRunner(Integer.valueOf(0));
    this.mPlayerID = PLAYER_ID_CREATOR.addAndGet(1);
    this.mAudioEffectList = new CopyOnWriteArrayList();
    this.mTerminalAudioEffectList = new CopyOnWriteArrayList();
    this.mSpeedToSet = null;
    this.mThreadName = "Unnamed";
    this.mPlayerMode = 0;
    this.mIsExit = false;
    this.performanceTracer = null;
    this.mPlayPath = null;
    if ((paramIDataSource != null) && (paramINativeDataSource != null))
    {
      paramIDataSource = new IllegalArgumentException("you can't set IDataSource and INativeDataSource at the same time!");
      AppMethodBeat.o(76677);
      throw paramIDataSource;
    }
    if ((paramIDataSource == null) && (paramINativeDataSource == null))
    {
      paramIDataSource = new IllegalArgumentException("at least on data source is required!");
      AppMethodBeat.o(76677);
      throw paramIDataSource;
    }
    this.mEventHandler = new Handler(paramLooper);
    this.mDecoder = paramBaseDecoder;
    this.mDataSource = paramIDataSource;
    this.mNativeDataSource = paramINativeDataSource;
    this.mCallback = paramPlayerCallback;
    this.mStateRunner.transfer(Integer.valueOf(1));
    this.mExecutor = paramQMThreadExecutor;
    AppMethodBeat.o(76677);
  }
  
  private String axiliary(String paramString)
  {
    AppMethodBeat.i(76684);
    paramString = "ID: " + this.mPlayerID + ". " + paramString;
    AppMethodBeat.o(76684);
    return paramString;
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76682);
    callExceptionCallback(paramInt1, paramInt2, 0);
    AppMethodBeat.o(76682);
  }
  
  private void callExceptionCallback(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76683);
    this.mCallback.playerException(this, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(76683);
  }
  
  private void decodeEndOrFailed(int paramInt1, int paramInt2)
  {
    int j = 68;
    AppMethodBeat.i(76685);
    Logger.d("CorePlayer", axiliary("decodeEndOrFailed"));
    try
    {
      if (this.mPcmCompnent == null)
      {
        Logger.e("CorePlayer", axiliary("mPcmCompnent null! Exiting"));
        AppMethodBeat.o(76685);
        return;
      }
      int i = paramInt1;
      if (this.mInformation != null)
      {
        Logger.i("CorePlayer", axiliary(String.format("current: %d, duration: %d, isExit: %b, decodeSucc: %b", new Object[] { Long.valueOf(this.mDecoder.getCurrentTime()), Long.valueOf(this.mInformation.getDuration()), Boolean.valueOf(this.mIsExit), Boolean.valueOf(this.mPcmCompnent.hasDecodeDataSuccess()) })));
        i = paramInt1 & this.mDecoder.getErrorCodeMask();
      }
      if ((this.mIsExit) || (!this.mPcmCompnent.hasDecodeDataSuccess()))
      {
        Logger.i("CorePlayer", axiliary("不留痕迹的退出 时机：解码时退出  step = 4"));
        exitNotCallback();
        this.mStateRunner.transfer(Integer.valueOf(9));
        if ((!TextUtils.isEmpty(this.mPlayPath)) && (isPathExternalStorage(this.mPlayPath))) {}
        for (;;)
        {
          callExceptionCallback(paramInt2, j, i);
          AppMethodBeat.o(76685);
          return;
          j = 67;
        }
      }
      if (getCurPositionByDecoder() < getDuration() - 5000L)
      {
        Logger.e("CorePlayer", axiliary("Decode failed! Exiting."));
        if ((!TextUtils.isEmpty(this.mPlayPath)) && (isPathExternalStorage(this.mPlayPath))) {}
        for (;;)
        {
          callExceptionCallback(paramInt2, j, i);
          this.mStateRunner.transfer(Integer.valueOf(6));
          AppMethodBeat.o(76685);
          return;
          j = 67;
        }
      }
      if (paramInt2 == 92)
      {
        Logger.i("CorePlayer", axiliary("Decode ended! Exiting."));
        this.mStateRunner.transfer(Integer.valueOf(7));
      }
      AppMethodBeat.o(76685);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("CorePlayer", localThrowable);
      AppMethodBeat.o(76685);
    }
  }
  
  private void exitNotCallback()
  {
    AppMethodBeat.i(76678);
    Logger.i("CorePlayer", axiliary("exitNotCallback"));
    this.mIsExit = true;
    AppMethodBeat.o(76678);
  }
  
  private boolean isPathExternalStorage(String paramString)
  {
    AppMethodBeat.i(76680);
    if ((!paramString.contains("emulated/0")) && (!paramString.contains("sdcard0")))
    {
      AppMethodBeat.o(76680);
      return true;
    }
    AppMethodBeat.o(76680);
    return false;
  }
  
  void addAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(76693);
    if (paramIAudioListener.isTerminal()) {
      if (!this.mTerminalAudioEffectList.contains(paramIAudioListener))
      {
        this.mTerminalAudioEffectList.add(paramIAudioListener);
        Logger.i("CorePlayer", "[addAudioListener] terminal audio added: ".concat(String.valueOf(paramIAudioListener)));
      }
    }
    for (;;)
    {
      if (this.mIsAudioEffectParamPrepared) {
        try
        {
          l = paramIAudioListener.onPlayerReady(this.mTargetBitDepth, this.mInformation, getCurPosition());
          if (l != 0L) {
            Logger.e("CorePlayer", "[addAudioListener] failed to init audio %s, ret: %d", new Object[] { paramIAudioListener, Long.valueOf(l) });
          }
          AppMethodBeat.o(76693);
          return;
          if (!this.mAudioEffectList.contains(paramIAudioListener))
          {
            this.mAudioEffectList.add(paramIAudioListener);
            Logger.i("CorePlayer", "[addAudioListener] audio added: ".concat(String.valueOf(paramIAudioListener)));
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Logger.e("CorePlayer", "[addAudioListener] failed to init audio: ".concat(String.valueOf(paramIAudioListener)), localThrowable);
            long l = 0L;
          }
        }
      }
    }
    Logger.i("CorePlayer", "[addAudioListener] audio information not ready. init will be delayed.");
    AppMethodBeat.o(76693);
  }
  
  void changePlayThreadPriorityImmediately()
  {
    AppMethodBeat.i(76679);
    Logger.d("CorePlayer", axiliary("changePlayThreadPriorityImmediately"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76679);
      return;
    }
    this.mPcmCompnent.changePlayThreadPriorityImmediately();
    AppMethodBeat.o(76679);
  }
  
  SeekTable createSeekTable()
  {
    AppMethodBeat.i(76704);
    if (this.mDecoder == null)
    {
      localObject = new IllegalStateException("please setDataSource before creating seek table!");
      AppMethodBeat.o(76704);
      throw ((Throwable)localObject);
    }
    Object localObject = new NativeSeekTable(this.mDecoder);
    AppMethodBeat.o(76704);
    return localObject;
  }
  
  void flush()
  {
    AppMethodBeat.i(76701);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.flush();
    }
    AppMethodBeat.o(76701);
  }
  
  long getCurPosition()
  {
    AppMethodBeat.i(76688);
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76688);
      return 0L;
    }
    long l = this.mPcmCompnent.getCurPosition();
    AppMethodBeat.o(76688);
    return l;
  }
  
  public long getCurPositionByDecoder()
  {
    AppMethodBeat.i(76706);
    try
    {
      long l = this.mDecoder.getCurrentTime();
      AppMethodBeat.o(76706);
      return l;
    }
    catch (SoNotFindException localSoNotFindException)
    {
      Logger.e("CorePlayer", localSoNotFindException);
      AppMethodBeat.o(76706);
      return 0L;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.e("CorePlayer", "Strange Exception!", localThrowable);
      }
    }
  }
  
  AudioInformation getCurrentAudioInformation()
  {
    return this.mInformation;
  }
  
  long getDuration()
  {
    AppMethodBeat.i(76686);
    if (this.mInformation != null) {
      try
      {
        long l = this.mInformation.getDuration();
        AppMethodBeat.o(76686);
        return l;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("CorePlayer", localThrowable);
      }
    }
    AppMethodBeat.o(76686);
    return 0L;
  }
  
  public long getMinPcmBufferSize()
  {
    AppMethodBeat.i(76707);
    long l = this.mDecoder.getMinBufferSize();
    AppMethodBeat.o(76707);
    return l;
  }
  
  int getPlayerMode()
  {
    return this.mPlayerMode;
  }
  
  int getPlayerState()
  {
    AppMethodBeat.i(76687);
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76687);
      return 0;
    }
    int i = this.mPcmCompnent.getPlayerState();
    AppMethodBeat.o(76687);
    return i;
  }
  
  int getSessionId()
  {
    AppMethodBeat.i(76692);
    if (this.mPcmCompnent != null)
    {
      int i = this.mPcmCompnent.getSessionId();
      AppMethodBeat.o(76692);
      return i;
    }
    AppMethodBeat.o(76692);
    return 0;
  }
  
  float getSpeed()
  {
    AppMethodBeat.i(244510);
    float f = 1.0F;
    if (this.mPcmCompnent != null) {
      f = this.mPcmCompnent.getSpeed();
    }
    for (;;)
    {
      AppMethodBeat.o(244510);
      return f;
      if (this.mSpeedToSet != null) {
        f = this.mSpeedToSet.floatValue();
      }
    }
  }
  
  /* Error */
  boolean hasDecodeData()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 392
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   12: ifnonnull +15 -> 27
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc_w 392
    //   20: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   31: invokevirtual 394	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeData	()Z
    //   34: istore_1
    //   35: ldc_w 392
    //   38: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	CorePlayer
    //   16	19	1	bool	boolean
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	44	finally
    //   17	23	44	finally
    //   27	41	44	finally
  }
  
  /* Error */
  boolean hasDecodeDataSuccess()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 395
    //   5: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   12: ifnonnull +15 -> 27
    //   15: iconst_0
    //   16: istore_1
    //   17: ldc_w 395
    //   20: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   31: invokevirtual 239	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:hasDecodeDataSuccess	()Z
    //   34: istore_1
    //   35: ldc_w 395
    //   38: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	CorePlayer
    //   16	19	1	bool	boolean
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	44	finally
    //   17	23	44	finally
    //   27	41	44	finally
  }
  
  boolean isInit()
  {
    AppMethodBeat.i(76691);
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76691);
      return false;
    }
    boolean bool = this.mPcmCompnent.isInit();
    AppMethodBeat.o(76691);
    return bool;
  }
  
  public void onAudioTrackChanged(AudioTrack paramAudioTrack)
  {
    AppMethodBeat.i(76710);
    this.mDecoder.setAudioTrack(paramAudioTrack);
    AppMethodBeat.o(76710);
  }
  
  public void onPullDecodeDataEndOrFailed(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(76709);
    decodeEndOrFailed(paramInt1, paramInt2);
    AppMethodBeat.o(76709);
  }
  
  void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(76697);
    Logger.i("CorePlayer", axiliary("pause"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76697);
      return;
    }
    this.mPcmCompnent.pause(paramBoolean);
    AppMethodBeat.o(76697);
  }
  
  void play()
  {
    AppMethodBeat.i(76696);
    Logger.i("CorePlayer", axiliary("play"));
    if (this.mPcmCompnent == null)
    {
      AppMethodBeat.o(76696);
      return;
    }
    this.mPcmCompnent.play();
    AppMethodBeat.o(76696);
  }
  
  public void prepare()
  {
    AppMethodBeat.i(76695);
    Logger.i("CorePlayer", axiliary("prepare"));
    this.mStateRunner.transfer(Integer.valueOf(3));
    this.mExecutor.execute(this, null);
    AppMethodBeat.o(76695);
  }
  
  public int pullDecodeData(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76708);
    paramInt = this.mDecoder.decodeData(paramInt, paramArrayOfByte);
    AppMethodBeat.o(76708);
    return paramInt;
  }
  
  public void release()
  {
    AppMethodBeat.i(76699);
    Logger.i("CorePlayer", axiliary("release"));
    this.mEventHandler.removeCallbacksAndMessages(null);
    exitNotCallback();
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.releaseNotify();
    }
    this.mStateRunner.transfer(Integer.valueOf(8));
    AppMethodBeat.o(76699);
  }
  
  void removeAudioListener(IAudioListener paramIAudioListener)
  {
    AppMethodBeat.i(76694);
    if (this.mAudioEffectList.remove(paramIAudioListener)) {
      Logger.i("CorePlayer", "[removeAudioListener] audio removed: ".concat(String.valueOf(paramIAudioListener)));
    }
    if (this.mTerminalAudioEffectList.remove(paramIAudioListener)) {
      Logger.i("CorePlayer", "[removeAudioListener] terminal audio removed: ".concat(String.valueOf(paramIAudioListener)));
    }
    AppMethodBeat.o(76694);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 458
    //   3: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 463	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:startProcessInfoOutput	()V
    //   9: ldc 17
    //   11: aload_0
    //   12: new 159	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 465
    //   19: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: invokestatic 471	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: invokevirtual 474	java/lang/Thread:getName	()Ljava/lang/String;
    //   28: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 144	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   44: aload_0
    //   45: invokeinterface 478 2 0
    //   50: aload_0
    //   51: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   54: ifnull +368 -> 422
    //   57: aload_0
    //   58: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   61: aload_0
    //   62: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   65: invokevirtual 482	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;)I
    //   68: istore_1
    //   69: ldc 17
    //   71: aload_0
    //   72: ldc_w 484
    //   75: iload_1
    //   76: invokestatic 487	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   79: invokevirtual 313	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload_1
    //   89: bipush 247
    //   91: if_icmpne +698 -> 789
    //   94: ldc 17
    //   96: aload_0
    //   97: ldc_w 489
    //   100: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   103: invokestatic 208	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   110: bipush 9
    //   112: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   115: invokevirtual 148	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   118: pop
    //   119: aload_0
    //   120: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   123: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   126: ifne +651 -> 777
    //   129: aload_0
    //   130: aload_0
    //   131: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   134: invokespecial 266	com/tencent/qqmusic/mediaplayer/CorePlayer:isPathExternalStorage	(Ljava/lang/String;)Z
    //   137: ifeq +640 -> 777
    //   140: aload_0
    //   141: bipush 91
    //   143: bipush 100
    //   145: invokespecial 491	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   148: invokestatic 497	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:getInstance	()Lcom/tencent/qqmusic/mediaplayer/PlayerConfigManager;
    //   151: aload_0
    //   152: invokevirtual 500	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:setCommonPlayerRef	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;)V
    //   155: aload_0
    //   156: getfield 210	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   159: ifnull +129 -> 288
    //   162: aload_0
    //   163: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   166: ifne +122 -> 288
    //   169: aload_0
    //   170: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   173: ifnonnull +115 -> 288
    //   176: aload_0
    //   177: getfield 210	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   180: invokevirtual 228	com/tencent/qqmusic/mediaplayer/AudioInformation:getDuration	()J
    //   183: ldc2_w 501
    //   186: lcmp
    //   187: iflt +11 -> 198
    //   190: aload_0
    //   191: getfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   194: iconst_1
    //   195: if_icmpne +987 -> 1182
    //   198: aload_0
    //   199: getfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   202: iconst_1
    //   203: if_icmpeq +8 -> 211
    //   206: aload_0
    //   207: iconst_1
    //   208: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   211: aload_0
    //   212: new 504	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent
    //   215: dup
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   221: aload_0
    //   222: getfield 210	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   225: aload_0
    //   226: getfield 144	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   229: aload_0
    //   230: aload_0
    //   231: getfield 136	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   234: aload_0
    //   235: getfield 99	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   238: new 10	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate
    //   241: dup
    //   242: aload_0
    //   243: iconst_0
    //   244: invokespecial 507	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Z)V
    //   247: new 10	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate
    //   250: dup
    //   251: aload_0
    //   252: iconst_1
    //   253: invokespecial 507	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Z)V
    //   256: invokespecial 510	com/tencent/qqmusic/mediaplayer/StaticDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;ILcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;)V
    //   259: putfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   262: aload_0
    //   263: getfield 108	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   266: ifnull +22 -> 288
    //   269: aload_0
    //   270: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   273: aload_0
    //   274: getfield 108	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   277: invokevirtual 390	java/lang/Float:floatValue	()F
    //   280: invokevirtual 514	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:setSpeed	(F)V
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 108	com/tencent/qqmusic/mediaplayer/CorePlayer:mSpeedToSet	Ljava/lang/Float;
    //   288: aload_0
    //   289: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   292: ifnull +10 -> 302
    //   295: aload_0
    //   296: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   299: invokevirtual 517	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:handleDecodeData	()V
    //   302: aload_0
    //   303: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   306: ifnull +1057 -> 1363
    //   309: ldc 17
    //   311: aload_0
    //   312: new 159	java/lang/StringBuilder
    //   315: dup
    //   316: ldc_w 519
    //   319: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   322: aload_0
    //   323: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   326: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   329: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   335: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: invokestatic 525	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   341: aload_0
    //   342: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   345: invokevirtual 527	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   348: pop
    //   349: aload_0
    //   350: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   353: ifnull +12 -> 365
    //   356: aload_0
    //   357: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   360: invokeinterface 532 1 0
    //   365: aload_0
    //   366: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   369: ifnull +10 -> 379
    //   372: aload_0
    //   373: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   376: invokevirtual 534	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   379: aload_0
    //   380: iconst_0
    //   381: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   384: ldc 17
    //   386: aload_0
    //   387: new 159	java/lang/StringBuilder
    //   390: dup
    //   391: ldc_w 536
    //   394: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   397: invokestatic 471	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   400: invokevirtual 474	java/lang/Thread:getName	()Ljava/lang/String;
    //   403: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   412: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   415: ldc_w 458
    //   418: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   421: return
    //   422: aload_0
    //   423: getfield 142	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   426: ifnull +212 -> 638
    //   429: aload_0
    //   430: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   433: aload_0
    //   434: getfield 142	com/tencent/qqmusic/mediaplayer/CorePlayer:mNativeDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;
    //   437: invokevirtual 539	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:init	(Lcom/tencent/qqmusic/mediaplayer/upstream/INativeDataSource;)I
    //   440: istore_1
    //   441: ldc 17
    //   443: aload_0
    //   444: ldc_w 541
    //   447: iload_1
    //   448: invokestatic 487	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   451: invokevirtual 313	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   454: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   457: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   460: goto -372 -> 88
    //   463: astore_3
    //   464: bipush 62
    //   466: istore_1
    //   467: aload_3
    //   468: instanceof 360
    //   471: ifeq +613 -> 1084
    //   474: bipush 69
    //   476: istore_1
    //   477: ldc 17
    //   479: aload_0
    //   480: ldc_w 543
    //   483: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   486: invokestatic 208	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_0
    //   490: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   493: bipush 9
    //   495: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: invokevirtual 148	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   501: pop
    //   502: aload_0
    //   503: bipush 91
    //   505: iload_1
    //   506: invokespecial 491	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   509: ldc 17
    //   511: ldc_w 545
    //   514: aload_3
    //   515: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   518: aload_0
    //   519: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   522: ifnull +577 -> 1099
    //   525: ldc 17
    //   527: aload_0
    //   528: new 159	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 519
    //   535: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: aload_0
    //   539: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   542: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   545: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   551: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: invokestatic 525	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   557: aload_0
    //   558: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   561: invokevirtual 527	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   564: pop
    //   565: aload_0
    //   566: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   569: ifnull +12 -> 581
    //   572: aload_0
    //   573: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   576: invokeinterface 532 1 0
    //   581: aload_0
    //   582: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   585: ifnull +10 -> 595
    //   588: aload_0
    //   589: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   592: invokevirtual 534	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   595: aload_0
    //   596: iconst_0
    //   597: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   600: ldc 17
    //   602: aload_0
    //   603: new 159	java/lang/StringBuilder
    //   606: dup
    //   607: ldc_w 536
    //   610: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: invokestatic 471	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   616: invokevirtual 474	java/lang/Thread:getName	()Ljava/lang/String;
    //   619: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   628: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: ldc_w 458
    //   634: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   637: return
    //   638: iconst_m1
    //   639: istore_1
    //   640: ldc 17
    //   642: aload_0
    //   643: ldc_w 547
    //   646: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   649: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: goto -564 -> 88
    //   655: astore_3
    //   656: aload_0
    //   657: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   660: ifnull +869 -> 1529
    //   663: ldc 17
    //   665: aload_0
    //   666: new 159	java/lang/StringBuilder
    //   669: dup
    //   670: ldc_w 519
    //   673: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   676: aload_0
    //   677: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   680: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   683: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   689: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: invokestatic 525	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   695: aload_0
    //   696: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   699: invokevirtual 527	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   702: pop
    //   703: aload_0
    //   704: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   707: ifnull +12 -> 719
    //   710: aload_0
    //   711: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   714: invokeinterface 532 1 0
    //   719: aload_0
    //   720: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   723: ifnull +10 -> 733
    //   726: aload_0
    //   727: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   730: invokevirtual 534	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   733: aload_0
    //   734: iconst_0
    //   735: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   738: ldc 17
    //   740: aload_0
    //   741: new 159	java/lang/StringBuilder
    //   744: dup
    //   745: ldc_w 536
    //   748: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   751: invokestatic 471	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   754: invokevirtual 474	java/lang/Thread:getName	()Ljava/lang/String;
    //   757: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   763: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   766: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: ldc_w 458
    //   772: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   775: aload_3
    //   776: athrow
    //   777: aload_0
    //   778: bipush 91
    //   780: sipush 200
    //   783: invokespecial 491	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   786: goto -638 -> 148
    //   789: iload_1
    //   790: ifeq +280 -> 1070
    //   793: ldc 17
    //   795: aload_0
    //   796: ldc_w 549
    //   799: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   802: invokestatic 208	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: aload_0
    //   806: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   809: bipush 9
    //   811: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   814: invokevirtual 148	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   817: pop
    //   818: iload_1
    //   819: bipush 254
    //   821: if_icmpne +160 -> 981
    //   824: aload_0
    //   825: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   828: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   831: ifne +144 -> 975
    //   834: aload_0
    //   835: aload_0
    //   836: getfield 120	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayPath	Ljava/lang/String;
    //   839: invokespecial 266	com/tencent/qqmusic/mediaplayer/CorePlayer:isPathExternalStorage	(Ljava/lang/String;)Z
    //   842: ifeq +133 -> 975
    //   845: bipush 56
    //   847: istore_1
    //   848: aload_0
    //   849: bipush 91
    //   851: iload_1
    //   852: invokespecial 491	com/tencent/qqmusic/mediaplayer/CorePlayer:callExceptionCallback	(II)V
    //   855: aload_0
    //   856: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   859: ifnull +128 -> 987
    //   862: ldc 17
    //   864: aload_0
    //   865: new 159	java/lang/StringBuilder
    //   868: dup
    //   869: ldc_w 519
    //   872: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   875: aload_0
    //   876: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   879: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   882: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   888: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   891: invokestatic 525	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   894: aload_0
    //   895: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   898: invokevirtual 527	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   901: pop
    //   902: aload_0
    //   903: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   906: ifnull +12 -> 918
    //   909: aload_0
    //   910: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   913: invokeinterface 532 1 0
    //   918: aload_0
    //   919: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   922: ifnull +10 -> 932
    //   925: aload_0
    //   926: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   929: invokevirtual 534	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   932: aload_0
    //   933: iconst_0
    //   934: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   937: ldc 17
    //   939: aload_0
    //   940: new 159	java/lang/StringBuilder
    //   943: dup
    //   944: ldc_w 536
    //   947: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   950: invokestatic 471	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   953: invokevirtual 474	java/lang/Thread:getName	()Ljava/lang/String;
    //   956: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   962: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   965: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   968: ldc_w 458
    //   971: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   974: return
    //   975: bipush 55
    //   977: istore_1
    //   978: goto -130 -> 848
    //   981: bipush 62
    //   983: istore_1
    //   984: goto -136 -> 848
    //   987: ldc 17
    //   989: aload_0
    //   990: ldc_w 551
    //   993: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   996: invokestatic 208	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   999: goto -108 -> 891
    //   1002: astore_3
    //   1003: ldc 17
    //   1005: aload_0
    //   1006: new 159	java/lang/StringBuilder
    //   1009: dup
    //   1010: ldc_w 553
    //   1013: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1016: aload_3
    //   1017: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1020: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1026: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1029: aload_3
    //   1030: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1033: goto -131 -> 902
    //   1036: astore_3
    //   1037: ldc 17
    //   1039: aload_0
    //   1040: new 159	java/lang/StringBuilder
    //   1043: dup
    //   1044: ldc_w 558
    //   1047: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1050: aload_3
    //   1051: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1054: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1063: aload_3
    //   1064: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1067: goto -149 -> 918
    //   1070: aload_0
    //   1071: aload_0
    //   1072: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1075: invokevirtual 562	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:getAudioInformation	()Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1078: putfield 210	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1081: goto -933 -> 148
    //   1084: aload_3
    //   1085: instanceof 564
    //   1088: istore_2
    //   1089: iload_2
    //   1090: ifeq -613 -> 477
    //   1093: bipush 60
    //   1095: istore_1
    //   1096: goto -619 -> 477
    //   1099: ldc 17
    //   1101: aload_0
    //   1102: ldc_w 551
    //   1105: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1108: invokestatic 208	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1111: goto -557 -> 554
    //   1114: astore_3
    //   1115: ldc 17
    //   1117: aload_0
    //   1118: new 159	java/lang/StringBuilder
    //   1121: dup
    //   1122: ldc_w 553
    //   1125: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1128: aload_3
    //   1129: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1132: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1141: aload_3
    //   1142: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1145: goto -580 -> 565
    //   1148: astore_3
    //   1149: ldc 17
    //   1151: aload_0
    //   1152: new 159	java/lang/StringBuilder
    //   1155: dup
    //   1156: ldc_w 558
    //   1159: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1162: aload_3
    //   1163: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1166: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1172: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1175: aload_3
    //   1176: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1179: goto -598 -> 581
    //   1182: aload_0
    //   1183: new 566	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent
    //   1186: dup
    //   1187: aload_0
    //   1188: aload_0
    //   1189: getfield 93	com/tencent/qqmusic/mediaplayer/CorePlayer:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   1192: aload_0
    //   1193: getfield 210	com/tencent/qqmusic/mediaplayer/CorePlayer:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1196: aload_0
    //   1197: getfield 144	com/tencent/qqmusic/mediaplayer/CorePlayer:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   1200: aload_0
    //   1201: aload_0
    //   1202: getfield 136	com/tencent/qqmusic/mediaplayer/CorePlayer:mEventHandler	Landroid/os/Handler;
    //   1205: aload_0
    //   1206: getfield 99	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerID	I
    //   1209: new 10	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate
    //   1212: dup
    //   1213: aload_0
    //   1214: iconst_0
    //   1215: invokespecial 507	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Z)V
    //   1218: new 10	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate
    //   1221: dup
    //   1222: aload_0
    //   1223: iconst_1
    //   1224: invokespecial 507	com/tencent/qqmusic/mediaplayer/CorePlayer$AudioListenerDelegate:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Z)V
    //   1227: invokespecial 567	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:<init>	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;Lcom/tencent/qqmusic/mediaplayer/AudioInformation;Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;Landroid/os/Handler;ILcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;)V
    //   1230: putfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1233: goto -971 -> 262
    //   1236: astore_3
    //   1237: ldc 17
    //   1239: aload_3
    //   1240: invokestatic 279	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1243: aload_0
    //   1244: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1247: ifnull +199 -> 1446
    //   1250: ldc 17
    //   1252: aload_0
    //   1253: new 159	java/lang/StringBuilder
    //   1256: dup
    //   1257: ldc_w 519
    //   1260: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1263: aload_0
    //   1264: getfield 116	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   1267: invokevirtual 522	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1270: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1276: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1279: invokestatic 525	com/tencent/qqmusic/mediaplayer/util/CpuInfoUtil:stopProcessInfoOutput	()V
    //   1282: aload_0
    //   1283: getfield 138	com/tencent/qqmusic/mediaplayer/CorePlayer:mDecoder	Lcom/tencent/qqmusic/mediaplayer/codec/BaseDecoder;
    //   1286: invokevirtual 527	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:release	()I
    //   1289: pop
    //   1290: aload_0
    //   1291: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1294: ifnull +12 -> 1306
    //   1297: aload_0
    //   1298: getfield 140	com/tencent/qqmusic/mediaplayer/CorePlayer:mDataSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   1301: invokeinterface 532 1 0
    //   1306: aload_0
    //   1307: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1310: ifnull +10 -> 1320
    //   1313: aload_0
    //   1314: getfield 203	com/tencent/qqmusic/mediaplayer/CorePlayer:mPcmCompnent	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent;
    //   1317: invokevirtual 534	com/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent:release	()V
    //   1320: aload_0
    //   1321: iconst_0
    //   1322: putfield 114	com/tencent/qqmusic/mediaplayer/CorePlayer:mPlayerMode	I
    //   1325: ldc 17
    //   1327: aload_0
    //   1328: new 159	java/lang/StringBuilder
    //   1331: dup
    //   1332: ldc_w 536
    //   1335: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1338: invokestatic 471	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1341: invokevirtual 474	java/lang/Thread:getName	()Ljava/lang/String;
    //   1344: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1347: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1350: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1353: invokestatic 247	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1356: ldc_w 458
    //   1359: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1362: return
    //   1363: ldc 17
    //   1365: aload_0
    //   1366: ldc_w 551
    //   1369: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1372: invokestatic 208	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: goto -1037 -> 338
    //   1378: astore_3
    //   1379: ldc 17
    //   1381: aload_0
    //   1382: new 159	java/lang/StringBuilder
    //   1385: dup
    //   1386: ldc_w 553
    //   1389: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1392: aload_3
    //   1393: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1396: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1402: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1405: aload_3
    //   1406: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1409: goto -1060 -> 349
    //   1412: astore_3
    //   1413: ldc 17
    //   1415: aload_0
    //   1416: new 159	java/lang/StringBuilder
    //   1419: dup
    //   1420: ldc_w 558
    //   1423: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1426: aload_3
    //   1427: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1430: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1433: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1436: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1439: aload_3
    //   1440: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1443: goto -1078 -> 365
    //   1446: ldc 17
    //   1448: aload_0
    //   1449: ldc_w 551
    //   1452: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1455: invokestatic 208	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1458: goto -179 -> 1279
    //   1461: astore_3
    //   1462: ldc 17
    //   1464: aload_0
    //   1465: new 159	java/lang/StringBuilder
    //   1468: dup
    //   1469: ldc_w 553
    //   1472: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1475: aload_3
    //   1476: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1479: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1488: aload_3
    //   1489: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1492: goto -202 -> 1290
    //   1495: astore_3
    //   1496: ldc 17
    //   1498: aload_0
    //   1499: new 159	java/lang/StringBuilder
    //   1502: dup
    //   1503: ldc_w 558
    //   1506: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1509: aload_3
    //   1510: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1513: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1519: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1522: aload_3
    //   1523: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1526: goto -220 -> 1306
    //   1529: ldc 17
    //   1531: aload_0
    //   1532: ldc_w 551
    //   1535: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1538: invokestatic 208	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1541: goto -849 -> 692
    //   1544: astore 4
    //   1546: ldc 17
    //   1548: aload_0
    //   1549: new 159	java/lang/StringBuilder
    //   1552: dup
    //   1553: ldc_w 553
    //   1556: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1559: aload 4
    //   1561: invokevirtual 556	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1564: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1567: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1570: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1573: aload 4
    //   1575: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1578: goto -875 -> 703
    //   1581: astore 4
    //   1583: ldc 17
    //   1585: aload_0
    //   1586: new 159	java/lang/StringBuilder
    //   1589: dup
    //   1590: ldc_w 558
    //   1593: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1596: aload 4
    //   1598: invokevirtual 559	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1601: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1607: invokespecial 195	com/tencent/qqmusic/mediaplayer/CorePlayer:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1610: aload 4
    //   1612: invokestatic 332	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1615: goto -896 -> 719
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1618	0	this	CorePlayer
    //   68	1028	1	i	int
    //   1088	2	2	bool	boolean
    //   463	52	3	localThrowable1	Throwable
    //   655	121	3	localObject	Object
    //   1002	28	3	localThrowable2	Throwable
    //   1036	49	3	localIOException1	java.io.IOException
    //   1114	28	3	localThrowable3	Throwable
    //   1148	28	3	localIOException2	java.io.IOException
    //   1236	4	3	localThrowable4	Throwable
    //   1378	28	3	localThrowable5	Throwable
    //   1412	28	3	localIOException3	java.io.IOException
    //   1461	28	3	localThrowable6	Throwable
    //   1495	28	3	localIOException4	java.io.IOException
    //   1544	30	4	localThrowable7	Throwable
    //   1581	30	4	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   40	88	463	java/lang/Throwable
    //   94	148	463	java/lang/Throwable
    //   422	460	463	java/lang/Throwable
    //   640	652	463	java/lang/Throwable
    //   777	786	463	java/lang/Throwable
    //   793	818	463	java/lang/Throwable
    //   824	845	463	java/lang/Throwable
    //   848	855	463	java/lang/Throwable
    //   1070	1081	463	java/lang/Throwable
    //   40	88	655	finally
    //   94	148	655	finally
    //   148	198	655	finally
    //   198	211	655	finally
    //   211	262	655	finally
    //   262	288	655	finally
    //   288	302	655	finally
    //   422	460	655	finally
    //   467	474	655	finally
    //   477	518	655	finally
    //   640	652	655	finally
    //   777	786	655	finally
    //   793	818	655	finally
    //   824	845	655	finally
    //   848	855	655	finally
    //   1070	1081	655	finally
    //   1084	1089	655	finally
    //   1182	1233	655	finally
    //   1237	1243	655	finally
    //   894	902	1002	java/lang/Throwable
    //   909	918	1036	java/io/IOException
    //   557	565	1114	java/lang/Throwable
    //   572	581	1148	java/io/IOException
    //   148	198	1236	java/lang/Throwable
    //   198	211	1236	java/lang/Throwable
    //   211	262	1236	java/lang/Throwable
    //   262	288	1236	java/lang/Throwable
    //   288	302	1236	java/lang/Throwable
    //   467	474	1236	java/lang/Throwable
    //   477	518	1236	java/lang/Throwable
    //   1084	1089	1236	java/lang/Throwable
    //   1182	1233	1236	java/lang/Throwable
    //   341	349	1378	java/lang/Throwable
    //   356	365	1412	java/io/IOException
    //   1282	1290	1461	java/lang/Throwable
    //   1297	1306	1495	java/io/IOException
    //   695	703	1544	java/lang/Throwable
    //   710	719	1581	java/io/IOException
  }
  
  public void seek(int paramInt)
  {
    AppMethodBeat.i(76703);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.seek(paramInt);
    }
    AppMethodBeat.o(76703);
  }
  
  public int seekTo(int paramInt)
  {
    AppMethodBeat.i(76705);
    paramInt = this.mDecoder.seekTo(paramInt);
    AppMethodBeat.o(76705);
    return paramInt;
  }
  
  void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(76702);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setAudioStreamType(paramInt);
    }
    AppMethodBeat.o(76702);
  }
  
  public void setLeastCommonMultiple(int paramInt)
  {
    AppMethodBeat.i(175613);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setLeastCommonMultiple(paramInt);
    }
    AppMethodBeat.o(175613);
  }
  
  public void setPlayPath(String paramString)
  {
    this.mPlayPath = paramString;
  }
  
  void setPlayerMode(int paramInt)
  {
    this.mPlayerMode = paramInt;
  }
  
  void setSpeed(float paramFloat)
  {
    AppMethodBeat.i(175612);
    if (this.mPcmCompnent == null)
    {
      this.mSpeedToSet = Float.valueOf(paramFloat);
      AppMethodBeat.o(175612);
      return;
    }
    this.mPcmCompnent.setSpeed(paramFloat);
    AppMethodBeat.o(175612);
  }
  
  void setThreadName(String paramString)
  {
    this.mThreadName = paramString;
  }
  
  void setVolume(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(76700);
    if (this.mPcmCompnent != null) {
      this.mPcmCompnent.setVolume(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(76700);
  }
  
  void stop()
  {
    AppMethodBeat.i(76698);
    Logger.i("CorePlayer", axiliary("stop"));
    if (this.mPcmCompnent == null)
    {
      exitNotCallback();
      AppMethodBeat.o(76698);
      return;
    }
    this.mPcmCompnent.stop();
    AppMethodBeat.o(76698);
  }
  
  class AudioListenerDelegate
    implements IAudioListener
  {
    private final boolean mIsTerminal;
    
    AudioListenerDelegate(boolean paramBoolean)
    {
      this.mIsTerminal = paramBoolean;
    }
    
    public long getActualTime(long paramLong)
    {
      AppMethodBeat.i(244491);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        paramLong = ((IAudioListener)localIterator.next()).getActualTime(paramLong);
      }
      AppMethodBeat.o(244491);
      return paramLong;
    }
    
    List<IAudioListener> getAudioListeners()
    {
      if (this.mIsTerminal) {
        return CorePlayer.this.mTerminalAudioEffectList;
      }
      return CorePlayer.this.mAudioEffectList;
    }
    
    public boolean isEnabled()
    {
      AppMethodBeat.i(244483);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        if (((IAudioListener)localIterator.next()).isEnabled())
        {
          AppMethodBeat.o(244483);
          return true;
        }
      }
      AppMethodBeat.o(244483);
      return false;
    }
    
    public boolean isTerminal()
    {
      return this.mIsTerminal;
    }
    
    public boolean onPcm(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong)
    {
      AppMethodBeat.i(244484);
      Object localObject1;
      if (!this.mIsTerminal)
      {
        localObject1 = CorePlayer.this.mAudioEffectList;
        if (((List)localObject1).size() == 0) {
          paramBufferInfo1.fillInto(paramBufferInfo2);
        }
      }
      Object localObject2;
      boolean bool;
      for (;;)
      {
        AppMethodBeat.o(244484);
        return true;
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = paramBufferInfo2;
        localObject2 = paramBufferInfo1;
        while (localIterator.hasNext())
        {
          Object localObject3 = (IAudioListener)localIterator.next();
          if (((IAudioListener)localObject3).isEnabled()) {
            try
            {
              ((BufferInfo)localObject1).setByteBufferCapacity(((BufferInfo)localObject2).bufferSize);
              bool = ((IAudioListener)localObject3).onPcm((BufferInfo)localObject2, (BufferInfo)localObject1, paramLong);
              if (bool)
              {
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
              }
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                Logger.e("CorePlayer", "[onPcm] failed. audio: " + localObject3 + " e: " + localThrowable2);
                bool = false;
              }
              ((BufferInfo)localObject2).fillInto((BufferInfo)localObject1);
            }
          } else {
            ((BufferInfo)localObject2).fillInto((BufferInfo)localObject1);
          }
        }
        if (localObject2 == paramBufferInfo1)
        {
          paramBufferInfo1.fillInto(paramBufferInfo2);
          continue;
          localObject2 = CorePlayer.this.mTerminalAudioEffectList;
          if (((List)localObject2).size() != 0) {
            break;
          }
          paramBufferInfo1.fillInto(paramBufferInfo2);
        }
      }
      int i = ((List)localObject2).size() - 1;
      label251:
      if (i >= 0)
      {
        localObject1 = (IAudioListener)((List)localObject2).get(i);
        if (!((IAudioListener)localObject1).isEnabled()) {}
      }
      for (;;)
      {
        try
        {
          paramBufferInfo2.setByteBufferCapacity(paramBufferInfo1.bufferSize);
          bool = ((IAudioListener)localObject1).onPcm(paramBufferInfo1, paramBufferInfo2, paramLong);
          if (bool)
          {
            localObject1 = paramBufferInfo2;
            if (localObject1 != paramBufferInfo1) {
              break;
            }
            paramBufferInfo1.fillInto(paramBufferInfo2);
          }
        }
        catch (Throwable localThrowable1)
        {
          Logger.e("CorePlayer", "[onPcm] failed. audio: " + localObject1 + " e: " + localThrowable1);
          bool = false;
          continue;
          paramBufferInfo1.fillInto(paramBufferInfo2);
          localObject1 = paramBufferInfo1;
          continue;
        }
        paramBufferInfo1.fillInto(paramBufferInfo2);
        i -= 1;
        break label251;
        localObject1 = paramBufferInfo1;
      }
    }
    
    public boolean onPcm(FloatBufferInfo paramFloatBufferInfo1, FloatBufferInfo paramFloatBufferInfo2, long paramLong)
    {
      AppMethodBeat.i(244487);
      Object localObject1;
      if (!this.mIsTerminal)
      {
        localObject1 = CorePlayer.this.mAudioEffectList;
        if (((List)localObject1).size() == 0) {
          paramFloatBufferInfo1.copy(paramFloatBufferInfo2);
        }
      }
      Object localObject2;
      boolean bool;
      for (;;)
      {
        AppMethodBeat.o(244487);
        return true;
        Iterator localIterator = ((List)localObject1).iterator();
        localObject1 = paramFloatBufferInfo2;
        localObject2 = paramFloatBufferInfo1;
        while (localIterator.hasNext())
        {
          Object localObject3 = (IAudioListener)localIterator.next();
          if (((IAudioListener)localObject3).isEnabled()) {
            try
            {
              ((FloatBufferInfo)localObject1).setFloatBufferCapacity(((FloatBufferInfo)localObject2).bufferSize);
              bool = ((IAudioListener)localObject3).onPcm((FloatBufferInfo)localObject2, (FloatBufferInfo)localObject1, paramLong);
              if (bool)
              {
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
              }
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                Logger.e("CorePlayer", "[onPcm] failed. audio: " + localObject3 + " e: " + localThrowable2);
                bool = false;
              }
              ((FloatBufferInfo)localObject2).copy((FloatBufferInfo)localObject1);
            }
          } else {
            ((FloatBufferInfo)localObject2).copy((FloatBufferInfo)localObject1);
          }
        }
        if (localObject2 == paramFloatBufferInfo1)
        {
          paramFloatBufferInfo1.copy(paramFloatBufferInfo2);
          continue;
          localObject2 = CorePlayer.this.mTerminalAudioEffectList;
          if (((List)localObject2).size() != 0) {
            break;
          }
          paramFloatBufferInfo1.copy(paramFloatBufferInfo2);
        }
      }
      int i = ((List)localObject2).size() - 1;
      label251:
      if (i >= 0)
      {
        localObject1 = (IAudioListener)((List)localObject2).get(i);
        if (!((IAudioListener)localObject1).isEnabled()) {}
      }
      for (;;)
      {
        try
        {
          paramFloatBufferInfo2.setFloatBufferCapacity(paramFloatBufferInfo1.bufferSize);
          bool = ((IAudioListener)localObject1).onPcm(paramFloatBufferInfo1, paramFloatBufferInfo2, paramLong);
          if (bool)
          {
            localObject1 = paramFloatBufferInfo2;
            if (localObject1 != paramFloatBufferInfo1) {
              break;
            }
            paramFloatBufferInfo1.copy(paramFloatBufferInfo2);
          }
        }
        catch (Throwable localThrowable1)
        {
          Logger.e("CorePlayer", "[onPcm] failed. audio: " + localObject1 + " e: " + localThrowable1);
          bool = false;
          continue;
          paramFloatBufferInfo1.copy(paramFloatBufferInfo2);
          localObject1 = paramFloatBufferInfo1;
          continue;
        }
        paramFloatBufferInfo1.copy(paramFloatBufferInfo2);
        i -= 1;
        break label251;
        localObject1 = paramFloatBufferInfo1;
      }
    }
    
    public long onPlayerReady(int paramInt, AudioInformation paramAudioInformation, long paramLong)
    {
      AppMethodBeat.i(244488);
      CorePlayer.access$002(CorePlayer.this, paramInt);
      CorePlayer.access$102(CorePlayer.this, true);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        ((IAudioListener)localIterator.next()).onPlayerReady(paramInt, paramAudioInformation, paramLong);
      }
      AppMethodBeat.o(244488);
      return 0L;
    }
    
    public void onPlayerSeekComplete(long paramLong)
    {
      AppMethodBeat.i(244489);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        ((IAudioListener)localIterator.next()).onPlayerSeekComplete(paramLong);
      }
      AppMethodBeat.o(244489);
    }
    
    public void onPlayerStopped()
    {
      AppMethodBeat.i(244490);
      Iterator localIterator = getAudioListeners().iterator();
      while (localIterator.hasNext()) {
        ((IAudioListener)localIterator.next()).onPlayerStopped();
      }
      AppMethodBeat.o(244490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CorePlayer
 * JD-Core Version:    0.7.0.1
 */