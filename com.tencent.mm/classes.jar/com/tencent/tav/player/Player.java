package com.tencent.tav.player;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.RenderContextParams;

public class Player
  implements Handler.Callback, IPlayer
{
  private static final int DEFAULT_MAX_CACHE_SIZE = 60;
  public static final String TAG = "PlayerThreadMain";
  public static final int TYPE_PROGRESS = 2;
  public static final int TYPE_STATES = 1;
  public static String time = "time";
  private AVPlayerActionAtItemEnd actionAtItemEnd;
  private Asset asset;
  private int bgColor;
  private PlayerItem currentItem;
  private ErrorMsg errMsg;
  private boolean loop;
  private AudioFocusHelper mAudioFocuser;
  private boolean mHasPostedSeek;
  private CMTime mLastSeekTargetTimeUs;
  Handler mMainHandler;
  private CMTimeRange mPlayRange;
  private PlayerThread mPlayThread;
  private IPlayer.PlayerListener mPlayerListener;
  private IPlayer.PlayerStatus mPlayerStatus;
  private CMTime mPosition;
  private CMTime mSeekTargetTimeUs;
  private boolean muted;
  private OnCompositionUpdateListener onCompositionUpdateListener;
  private PlayerLayer playerLayer;
  private float rate;
  private volatile boolean released;
  private PlayerStatus status;
  private float volume;
  
  public Player(PlayerItem paramPlayerItem)
  {
    AppMethodBeat.i(202108);
    this.mPlayerStatus = IPlayer.PlayerStatus.IDLE;
    this.loop = false;
    this.released = false;
    this.bgColor = -16777216;
    this.currentItem = paramPlayerItem;
    this.mMainHandler = new Handler(Looper.getMainLooper(), this);
    this.asset = this.currentItem.getAsset();
    this.currentItem.start(this);
    this.mPlayThread = this.currentItem.getPlayerThreadMain();
    AppMethodBeat.o(202108);
  }
  
  public Player(String paramString)
  {
    this(new PlayerItem(paramString));
    AppMethodBeat.i(202107);
    AppMethodBeat.o(202107);
  }
  
  private void checkAndReady()
  {
    try
    {
      AppMethodBeat.i(202140);
      if (this.mPlayerStatus == IPlayer.PlayerStatus.IDLE) {
        this.mPlayThread.sendMessage(1, "main");
      }
      AppMethodBeat.o(202140);
      return;
    }
    finally {}
  }
  
  void bindLayer(PlayerLayer paramPlayerLayer)
  {
    AppMethodBeat.i(202123);
    this.playerLayer = paramPlayerLayer;
    this.currentItem.bindLayer(paramPlayerLayer);
    AppMethodBeat.o(202123);
  }
  
  public IPlayer.PlayerStatus currentStatus()
  {
    try
    {
      IPlayer.PlayerStatus localPlayerStatus = this.mPlayerStatus;
      return localPlayerStatus;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public CMTime currentTime()
  {
    AppMethodBeat.i(202111);
    if (this.mPlayThread == null)
    {
      localCMTime = CMTime.CMTimeZero;
      AppMethodBeat.o(202111);
      return localCMTime;
    }
    CMTime localCMTime = this.mPlayThread.getPosition();
    AppMethodBeat.o(202111);
    return localCMTime;
  }
  
  /* Error */
  public CMTime duration()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 176
    //   4: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 121	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   11: ifnonnull +16 -> 27
    //   14: getstatic 171	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   17: astore_1
    //   18: ldc 176
    //   20: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aload_0
    //   28: getfield 121	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   31: invokevirtual 181	com/tencent/tav/asset/Asset:getDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   34: astore_1
    //   35: ldc 176
    //   37: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -17 -> 23
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	Player
    //   17	18	1	localCMTime	CMTime
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	43	finally
    //   27	40	43	finally
  }
  
  public void enAbleAudioFocus(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(202120);
    if (paramBoolean)
    {
      if (this.mAudioFocuser == null)
      {
        this.mAudioFocuser = new AudioFocusHelper(paramContext, this);
        AppMethodBeat.o(202120);
      }
    }
    else if (this.mAudioFocuser != null) {
      this.mAudioFocuser.release();
    }
    AppMethodBeat.o(202120);
  }
  
  public int getBgColor()
  {
    return this.bgColor;
  }
  
  public PlayerItem getCurrentItem()
  {
    return this.currentItem;
  }
  
  public ErrorMsg getErrMsg()
  {
    return this.errMsg;
  }
  
  public CGRect getGlViewport()
  {
    AppMethodBeat.i(202126);
    if (this.mPlayThread == null)
    {
      AppMethodBeat.o(202126);
      return null;
    }
    CGRect localCGRect = this.mPlayThread.getGlViewportRect();
    AppMethodBeat.o(202126);
    return localCGRect;
  }
  
  public float getRate()
  {
    return this.rate;
  }
  
  public RenderContextParams getRenderContextParams()
  {
    AppMethodBeat.i(202112);
    if (this.mPlayThread != null)
    {
      RenderContextParams localRenderContextParams = this.mPlayThread.getRenderContextParams();
      AppMethodBeat.o(202112);
      return localRenderContextParams;
    }
    AppMethodBeat.o(202112);
    return null;
  }
  
  public PlayerStatus getStatus()
  {
    return this.status;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(202141);
    if (this.released)
    {
      AppMethodBeat.o(202141);
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(202141);
      return false;
    case 2: 
      this.mPosition = ((CMTime)paramMessage.obj);
      if ((this.mPlayerListener != null) && (!this.mMainHandler.hasMessages(2))) {
        this.mPlayerListener.onPositionChanged(this.mPosition);
      }
      if ((this.mPlayRange != null) && (!this.mPosition.smallThan(this.mPlayRange.getEnd())) && (isPlaying()))
      {
        if (!this.loop) {
          break label149;
        }
        seekToTime(this.mPlayRange.getStart());
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(202141);
      return true;
      label149:
      pause();
      continue;
      IPlayer.PlayerStatus localPlayerStatus = this.mPlayerStatus;
      paramMessage = (PlayerStatusMsg)paramMessage.obj;
      this.mPlayerStatus = paramMessage.getPlayerStatus();
      if ((localPlayerStatus == IPlayer.PlayerStatus.PLAYING) && ((this.mPlayerStatus == IPlayer.PlayerStatus.FINISHED) || (this.mPlayerStatus == IPlayer.PlayerStatus.ERROR)) && (this.loop))
      {
        try
        {
          if ((this.mPlayThread.hasMessage(3)) || (this.mPlayThread.hasMessage(6)) || (this.mPlayThread.hasMessage(4)) || (this.mPlayThread.hasMessage(11)) || (this.mMainHandler.hasMessages(1))) {
            continue;
          }
        }
        finally
        {
          AppMethodBeat.o(202141);
        }
        if ((this.mPlayRange != null) && (this.mPlayRange.getDuration().getValue() > 0L)) {
          seekToTime(this.mPlayRange.getStart());
        }
        for (;;)
        {
          play();
          break;
          seekToTime(CMTime.CMTimeZero);
        }
      }
      else
      {
        if (this.mPlayerListener != null) {
          this.mPlayerListener.onStatusChanged(this.mPlayerStatus);
        }
        if (this.mPlayerStatus == IPlayer.PlayerStatus.ERROR) {
          this.errMsg = new ErrorMsg(-1, paramMessage.getErrorMsg());
        }
      }
    }
  }
  
  /* Error */
  public boolean isPlaying()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 91	com/tencent/tav/player/Player:mPlayerStatus	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   6: astore_2
    //   7: getstatic 279	com/tencent/tav/player/IPlayer$PlayerStatus:PLAYING	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   10: astore_3
    //   11: aload_2
    //   12: aload_3
    //   13: if_acmpne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	Player
    //   17	7	1	bool	boolean
    //   6	6	2	localPlayerStatus1	IPlayer.PlayerStatus
    //   27	4	2	localObject	Object
    //   10	3	3	localPlayerStatus2	IPlayer.PlayerStatus
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
  }
  
  public boolean isReleased()
  {
    try
    {
      boolean bool = this.released;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 310
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 310
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: iconst_3
    //   29: ldc 148
    //   31: invokevirtual 154	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   34: ldc_w 310
    //   37: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -19 -> 21
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	Player
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	43	finally
    //   24	40	43	finally
  }
  
  /* Error */
  public void play()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 311
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 311
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 249	com/tencent/tav/player/Player:mPlayRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   28: ifnull +28 -> 56
    //   31: aload_0
    //   32: getfield 249	com/tencent/tav/player/Player:mPlayRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   35: aload_0
    //   36: invokevirtual 313	com/tencent/tav/player/Player:currentTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   39: invokevirtual 316	com/tencent/tav/coremedia/CMTimeRange:containsTime	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   42: ifne +14 -> 56
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 249	com/tencent/tav/player/Player:mPlayRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   50: invokevirtual 265	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   53: invokevirtual 268	com/tencent/tav/player/Player:seekToTime	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   56: aload_0
    //   57: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   60: iconst_2
    //   61: ldc 148
    //   63: invokevirtual 154	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   66: aload_0
    //   67: getfield 186	com/tencent/tav/player/Player:mAudioFocuser	Lcom/tencent/tav/player/AudioFocusHelper;
    //   70: ifnull +10 -> 80
    //   73: aload_0
    //   74: getfield 186	com/tencent/tav/player/Player:mAudioFocuser	Lcom/tencent/tav/player/AudioFocusHelper;
    //   77: invokevirtual 319	com/tencent/tav/player/AudioFocusHelper:requestFocus	()V
    //   80: ldc_w 311
    //   83: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: goto -65 -> 21
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	Player
    //   89	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	89	finally
    //   24	56	89	finally
    //   56	80	89	finally
    //   80	86	89	finally
  }
  
  /* Error */
  public CMTime position()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 321
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   12: ifnonnull +17 -> 29
    //   15: getstatic 171	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   18: astore_1
    //   19: ldc_w 321
    //   22: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   33: invokevirtual 174	com/tencent/tav/player/PlayerThread:getPosition	()Lcom/tencent/tav/coremedia/CMTime;
    //   36: astore_1
    //   37: ldc_w 321
    //   40: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -18 -> 25
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	Player
    //   18	19	1	localCMTime	CMTime
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	46	finally
    //   29	43	46	finally
  }
  
  public void prepare(PlayerPrepareListener paramPlayerPrepareListener)
  {
    paramPlayerPrepareListener = IPlayer.PlayerStatus.IDLE;
  }
  
  public void readSnapShootBitmap(OnReadSnapShootListener paramOnReadSnapShootListener)
  {
    AppMethodBeat.i(202129);
    if (this.mPlayThread == null)
    {
      AppMethodBeat.o(202129);
      return;
    }
    this.mPlayThread.sendMessage(24, paramOnReadSnapShootListener, "readSnapShootBitmap");
    AppMethodBeat.o(202129);
  }
  
  public void refreshSurface(Callback paramCallback)
  {
    AppMethodBeat.i(202119);
    if (this.released)
    {
      AppMethodBeat.o(202119);
      return;
    }
    this.mPlayThread.sendMessage(25, paramCallback, "main");
    AppMethodBeat.o(202119);
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(202142);
      release(null);
      AppMethodBeat.o(202142);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void release(Runnable paramRunnable)
  {
    try
    {
      AppMethodBeat.i(202143);
      if (!this.released)
      {
        this.released = true;
        this.mMainHandler.removeCallbacksAndMessages(null);
        this.mMainHandler = null;
        this.mPlayThread.sendMessage(4, "main");
        this.mPlayThread.sendMessage(6, paramRunnable, "main");
        this.mPlayThread = null;
        if (this.mAudioFocuser != null) {
          this.mAudioFocuser.release();
        }
        if (this.currentItem != null) {
          this.currentItem.release();
        }
        this.currentItem = null;
      }
      AppMethodBeat.o(202143);
      return;
    }
    finally {}
  }
  
  public void replaceCurrentItemWithPlayerItem(PlayerItem paramPlayerItem)
  {
    AppMethodBeat.i(202114);
    update(paramPlayerItem, position());
    AppMethodBeat.o(202114);
  }
  
  public void seekToTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(202115);
    seekToTime(paramCMTime, null);
    AppMethodBeat.o(202115);
  }
  
  public void seekToTime(CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3)
  {
    AppMethodBeat.i(202116);
    seekToTime(paramCMTime1, paramCMTime2, paramCMTime3, null);
    AppMethodBeat.o(202116);
  }
  
  public void seekToTime(CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3, Callback paramCallback)
  {
    AppMethodBeat.i(202118);
    if (this.released)
    {
      AppMethodBeat.o(202118);
      return;
    }
    this.mSeekTargetTimeUs = paramCMTime1;
    this.mLastSeekTargetTimeUs = this.mSeekTargetTimeUs;
    this.mPlayThread.updatePositionRightAway(this.mSeekTargetTimeUs);
    this.mPlayThread.cancelAllPendingSeeks();
    this.mPlayThread.sendMessage(5, this.mSeekTargetTimeUs, "main", paramCallback);
    AppMethodBeat.o(202118);
  }
  
  public void seekToTime(CMTime paramCMTime, Callback paramCallback)
  {
    AppMethodBeat.i(202117);
    CMTime localCMTime = CMTime.CMTimeZero;
    seekToTime(paramCMTime, localCMTime, localCMTime, paramCallback);
    AppMethodBeat.o(202117);
  }
  
  public void setBgColor(int paramInt)
  {
    this.bgColor = paramInt;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    try
    {
      this.loop = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setOnCompositionUpdateListener(OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    this.onCompositionUpdateListener = paramOnCompositionUpdateListener;
  }
  
  public void setPlayRange(CMTimeRange paramCMTimeRange)
  {
    try
    {
      AppMethodBeat.i(202131);
      this.mPlayRange = paramCMTimeRange;
      if ((paramCMTimeRange != null) && (!paramCMTimeRange.containsTime(currentTime())) && (isPlaying())) {
        seekToTime(paramCMTimeRange.getStart());
      }
      AppMethodBeat.o(202131);
      return;
    }
    finally {}
  }
  
  public void setPlayerListener(IPlayer.PlayerListener paramPlayerListener)
  {
    this.mPlayerListener = paramPlayerListener;
  }
  
  public void setRate(float paramFloat)
  {
    AppMethodBeat.i(202109);
    setRate(paramFloat, 60);
    AppMethodBeat.o(202109);
  }
  
  public void setRate(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(202110);
    if ((this.mPlayerStatus != IPlayer.PlayerStatus.PLAYING) && (this.mPlayerStatus != IPlayer.PlayerStatus.PAUSED))
    {
      this.rate = paramFloat;
      this.currentItem.setRate(paramFloat, paramInt);
    }
    AppMethodBeat.o(202110);
  }
  
  public void setRateAtTimeAndHostTime(float paramFloat, CMTime paramCMTime1, CMTime paramCMTime2) {}
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(202113);
    if (this.mPlayThread != null) {
      this.mPlayThread.setRenderContextParams(paramRenderContextParams);
    }
    AppMethodBeat.o(202113);
  }
  
  /* Error */
  public void setVolume(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 405
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 405
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 7
    //   30: fload_1
    //   31: invokestatic 411	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   34: ldc 148
    //   36: invokevirtual 330	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   39: ldc_w 405
    //   42: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: goto -24 -> 21
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	Player
    //   0	53	1	paramFloat	float
    //   48	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	48	finally
    //   24	45	48	finally
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 413
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 413
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: iconst_4
    //   29: getstatic 419	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   32: ldc 148
    //   34: invokevirtual 330	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   37: ldc_w 413
    //   40: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -22 -> 21
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	Player
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	46	finally
    //   24	43	46	finally
  }
  
  /* Error */
  public void update(PlayerItem paramPlayerItem, CMTime paramCMTime)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 420
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 420
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: putfield 100	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 119	com/tencent/tav/player/PlayerItem:getAsset	()Lcom/tencent/tav/asset/Asset;
    //   34: putfield 121	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   37: aload_0
    //   38: getfield 100	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   41: invokevirtual 423	com/tencent/tav/player/PlayerItem:updateDecoderTrack	()V
    //   44: aload_0
    //   45: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   48: aload_2
    //   49: invokevirtual 368	com/tencent/tav/player/PlayerThread:updatePositionRightAway	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   52: aload_0
    //   53: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   56: bipush 11
    //   58: new 425	com/tencent/tav/player/UpdateCompositionMessage
    //   61: dup
    //   62: aload_1
    //   63: aload_0
    //   64: getfield 144	com/tencent/tav/player/Player:onCompositionUpdateListener	Lcom/tencent/tav/player/OnCompositionUpdateListener;
    //   67: invokespecial 428	com/tencent/tav/player/UpdateCompositionMessage:<init>	(Lcom/tencent/tav/player/PlayerItem;Lcom/tencent/tav/player/OnCompositionUpdateListener;)V
    //   70: ldc_w 430
    //   73: invokevirtual 330	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   76: aload_0
    //   77: getstatic 171	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   80: putfield 365	com/tencent/tav/player/Player:mLastSeekTargetTimeUs	Lcom/tencent/tav/coremedia/CMTime;
    //   83: ldc_w 420
    //   86: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -68 -> 21
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	Player
    //   0	97	1	paramPlayerItem	PlayerItem
    //   0	97	2	paramCMTime	CMTime
    // Exception table:
    //   from	to	target	type
    //   2	21	92	finally
    //   24	89	92	finally
  }
  
  /* Error */
  public void update(PlayerItem paramPlayerItem, CMTime paramCMTime, final OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 432
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 432
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: putfield 100	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 119	com/tencent/tav/player/PlayerItem:getAsset	()Lcom/tencent/tav/asset/Asset;
    //   34: putfield 121	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   37: aload_0
    //   38: getfield 100	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   41: invokevirtual 423	com/tencent/tav/player/PlayerItem:updateDecoderTrack	()V
    //   44: aload_0
    //   45: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   48: aload_2
    //   49: invokevirtual 368	com/tencent/tav/player/PlayerThread:updatePositionRightAway	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   52: aload_0
    //   53: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   56: bipush 11
    //   58: new 425	com/tencent/tav/player/UpdateCompositionMessage
    //   61: dup
    //   62: aload_1
    //   63: new 10	com/tencent/tav/player/Player$1
    //   66: dup
    //   67: aload_0
    //   68: aload_3
    //   69: invokespecial 435	com/tencent/tav/player/Player$1:<init>	(Lcom/tencent/tav/player/Player;Lcom/tencent/tav/player/OnCompositionUpdateListener;)V
    //   72: invokespecial 428	com/tencent/tav/player/UpdateCompositionMessage:<init>	(Lcom/tencent/tav/player/PlayerItem;Lcom/tencent/tav/player/OnCompositionUpdateListener;)V
    //   75: ldc_w 430
    //   78: invokevirtual 330	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getstatic 171	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   85: putfield 365	com/tencent/tav/player/Player:mLastSeekTargetTimeUs	Lcom/tencent/tav/coremedia/CMTime;
    //   88: ldc_w 432
    //   91: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -73 -> 21
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	Player
    //   0	102	1	paramPlayerItem	PlayerItem
    //   0	102	2	paramCMTime	CMTime
    //   0	102	3	paramOnCompositionUpdateListener	OnCompositionUpdateListener
    // Exception table:
    //   from	to	target	type
    //   2	21	97	finally
    //   24	94	97	finally
  }
  
  /* Error */
  public void updateAllProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 437
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 437
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 20
    //   30: ldc 148
    //   32: invokevirtual 154	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   35: ldc_w 437
    //   38: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -20 -> 21
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	Player
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   24	41	44	finally
  }
  
  /* Error */
  public void updateAudioClipsProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 439
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 439
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 22
    //   30: ldc 148
    //   32: invokevirtual 154	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   35: ldc_w 439
    //   38: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -20 -> 21
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	Player
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   24	41	44	finally
  }
  
  /* Error */
  public void updateAudioVolumeProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 441
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 441
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 23
    //   30: ldc 148
    //   32: invokevirtual 154	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   35: ldc_w 441
    //   38: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -20 -> 21
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	Player
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   24	41	44	finally
  }
  
  /* Error */
  public void updateProperties()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 443
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 95	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 443
    //   18: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 131	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 10
    //   30: ldc 148
    //   32: invokevirtual 154	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   35: ldc_w 443
    //   38: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -20 -> 21
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	Player
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	44	finally
    //   24	41	44	finally
  }
  
  public void updateViewport(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202138);
    if (this.released)
    {
      AppMethodBeat.o(202138);
      return;
    }
    this.mPlayThread.sendMessage(21, new CGSize(paramInt1, paramInt2), "main");
    AppMethodBeat.o(202138);
  }
  
  public int videoHeight()
  {
    AppMethodBeat.i(202122);
    if (this.currentItem == null)
    {
      AppMethodBeat.o(202122);
      return 0;
    }
    int i = (int)this.currentItem.getPresentationSize().height;
    AppMethodBeat.o(202122);
    return i;
  }
  
  public int videoWidth()
  {
    AppMethodBeat.i(202121);
    if (this.currentItem == null)
    {
      AppMethodBeat.o(202121);
      return 0;
    }
    int i = (int)this.currentItem.getPresentationSize().width;
    AppMethodBeat.o(202121);
    return i;
  }
  
  public void waitForRelease(long paramLong) {}
  
  static enum AVPlayerActionAtItemEnd
  {
    static
    {
      AppMethodBeat.i(202103);
      AVPlayerActionAtItemEndAdvance = new AVPlayerActionAtItemEnd("AVPlayerActionAtItemEndAdvance", 0);
      AVPlayerActionAtItemEndPause = new AVPlayerActionAtItemEnd("AVPlayerActionAtItemEndPause", 1);
      AVPlayerActionAtItemEndNone = new AVPlayerActionAtItemEnd("AVPlayerActionAtItemEndNone", 2);
      $VALUES = new AVPlayerActionAtItemEnd[] { AVPlayerActionAtItemEndAdvance, AVPlayerActionAtItemEndPause, AVPlayerActionAtItemEndNone };
      AppMethodBeat.o(202103);
    }
    
    private AVPlayerActionAtItemEnd() {}
  }
  
  static enum PlayerStatus
  {
    static
    {
      AppMethodBeat.i(202106);
      PlayerStatusUnknown = new PlayerStatus("PlayerStatusUnknown", 0);
      PlayerStatusReadyToPlay = new PlayerStatus("PlayerStatusReadyToPlay", 1);
      PlayerStatusFailed = new PlayerStatus("PlayerStatusFailed", 2);
      $VALUES = new PlayerStatus[] { PlayerStatusUnknown, PlayerStatusReadyToPlay, PlayerStatusFailed };
      AppMethodBeat.o(202106);
    }
    
    private PlayerStatus() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.player.Player
 * JD-Core Version:    0.7.0.1
 */