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
  private Player.AVPlayerActionAtItemEnd actionAtItemEnd;
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
  private Player.PlayerStatus status;
  private float volume;
  
  public Player(PlayerItem paramPlayerItem)
  {
    AppMethodBeat.i(198169);
    this.mPlayerStatus = IPlayer.PlayerStatus.IDLE;
    this.loop = false;
    this.released = false;
    this.bgColor = -16777216;
    this.currentItem = paramPlayerItem;
    this.mMainHandler = new Handler(Looper.getMainLooper(), this);
    this.asset = this.currentItem.getAsset();
    this.currentItem.start(this);
    this.mPlayThread = this.currentItem.getPlayerThreadMain();
    AppMethodBeat.o(198169);
  }
  
  public Player(String paramString)
  {
    this(new PlayerItem(paramString));
    AppMethodBeat.i(198168);
    AppMethodBeat.o(198168);
  }
  
  private void checkAndReady()
  {
    try
    {
      AppMethodBeat.i(198201);
      if (this.mPlayerStatus == IPlayer.PlayerStatus.IDLE) {
        this.mPlayThread.sendMessage(1, "main");
      }
      AppMethodBeat.o(198201);
      return;
    }
    finally {}
  }
  
  void bindLayer(PlayerLayer paramPlayerLayer)
  {
    AppMethodBeat.i(198184);
    this.playerLayer = paramPlayerLayer;
    this.currentItem.bindLayer(paramPlayerLayer);
    AppMethodBeat.o(198184);
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
    AppMethodBeat.i(198172);
    if (this.mPlayThread == null)
    {
      localCMTime = CMTime.CMTimeZero;
      AppMethodBeat.o(198172);
      return localCMTime;
    }
    CMTime localCMTime = this.mPlayThread.getPosition();
    AppMethodBeat.o(198172);
    return localCMTime;
  }
  
  /* Error */
  public CMTime duration()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 174
    //   4: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 119	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   11: ifnonnull +16 -> 27
    //   14: getstatic 169	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   17: astore_1
    //   18: ldc 174
    //   20: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aload_0
    //   28: getfield 119	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   31: invokevirtual 179	com/tencent/tav/asset/Asset:getDuration	()Lcom/tencent/tav/coremedia/CMTime;
    //   34: astore_1
    //   35: ldc 174
    //   37: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(198181);
    if (paramBoolean)
    {
      if (this.mAudioFocuser == null)
      {
        this.mAudioFocuser = new AudioFocusHelper(paramContext, this);
        AppMethodBeat.o(198181);
      }
    }
    else if (this.mAudioFocuser != null) {
      this.mAudioFocuser.release();
    }
    AppMethodBeat.o(198181);
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
    AppMethodBeat.i(198187);
    if (this.mPlayThread == null)
    {
      AppMethodBeat.o(198187);
      return null;
    }
    CGRect localCGRect = this.mPlayThread.getGlViewportRect();
    AppMethodBeat.o(198187);
    return localCGRect;
  }
  
  public float getRate()
  {
    return this.rate;
  }
  
  public RenderContextParams getRenderContextParams()
  {
    AppMethodBeat.i(198173);
    if (this.mPlayThread != null)
    {
      RenderContextParams localRenderContextParams = this.mPlayThread.getRenderContextParams();
      AppMethodBeat.o(198173);
      return localRenderContextParams;
    }
    AppMethodBeat.o(198173);
    return null;
  }
  
  public Player.PlayerStatus getStatus()
  {
    return this.status;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(198202);
    if (this.released)
    {
      AppMethodBeat.o(198202);
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(198202);
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
      AppMethodBeat.o(198202);
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
          AppMethodBeat.o(198202);
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
    //   3: getfield 89	com/tencent/tav/player/Player:mPlayerStatus	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   6: astore_2
    //   7: getstatic 277	com/tencent/tav/player/IPlayer$PlayerStatus:PLAYING	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
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
    //   2: ldc_w 308
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 308
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: iconst_3
    //   29: ldc 146
    //   31: invokevirtual 152	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   34: ldc_w 308
    //   37: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 309
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 309
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 247	com/tencent/tav/player/Player:mPlayRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   28: ifnull +28 -> 56
    //   31: aload_0
    //   32: getfield 247	com/tencent/tav/player/Player:mPlayRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   35: aload_0
    //   36: invokevirtual 311	com/tencent/tav/player/Player:currentTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   39: invokevirtual 314	com/tencent/tav/coremedia/CMTimeRange:containsTime	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   42: ifne +14 -> 56
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 247	com/tencent/tav/player/Player:mPlayRange	Lcom/tencent/tav/coremedia/CMTimeRange;
    //   50: invokevirtual 263	com/tencent/tav/coremedia/CMTimeRange:getStart	()Lcom/tencent/tav/coremedia/CMTime;
    //   53: invokevirtual 266	com/tencent/tav/player/Player:seekToTime	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   56: aload_0
    //   57: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   60: iconst_2
    //   61: ldc 146
    //   63: invokevirtual 152	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   66: aload_0
    //   67: getfield 184	com/tencent/tav/player/Player:mAudioFocuser	Lcom/tencent/tav/player/AudioFocusHelper;
    //   70: ifnull +10 -> 80
    //   73: aload_0
    //   74: getfield 184	com/tencent/tav/player/Player:mAudioFocuser	Lcom/tencent/tav/player/AudioFocusHelper;
    //   77: invokevirtual 317	com/tencent/tav/player/AudioFocusHelper:requestFocus	()V
    //   80: ldc_w 309
    //   83: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 319
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   12: ifnonnull +17 -> 29
    //   15: getstatic 169	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   18: astore_1
    //   19: ldc_w 319
    //   22: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   33: invokevirtual 172	com/tencent/tav/player/PlayerThread:getPosition	()Lcom/tencent/tav/coremedia/CMTime;
    //   36: astore_1
    //   37: ldc_w 319
    //   40: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(198190);
    if (this.mPlayThread == null)
    {
      AppMethodBeat.o(198190);
      return;
    }
    this.mPlayThread.sendMessage(24, paramOnReadSnapShootListener, "readSnapShootBitmap");
    AppMethodBeat.o(198190);
  }
  
  public void refreshSurface(Callback paramCallback)
  {
    AppMethodBeat.i(198180);
    if (this.released)
    {
      AppMethodBeat.o(198180);
      return;
    }
    this.mPlayThread.sendMessage(25, paramCallback, "main");
    AppMethodBeat.o(198180);
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(198203);
      release(null);
      AppMethodBeat.o(198203);
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
      AppMethodBeat.i(198204);
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
      AppMethodBeat.o(198204);
      return;
    }
    finally {}
  }
  
  public void replaceCurrentItemWithPlayerItem(PlayerItem paramPlayerItem)
  {
    AppMethodBeat.i(198175);
    update(paramPlayerItem, position());
    AppMethodBeat.o(198175);
  }
  
  public void seekToTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(198176);
    seekToTime(paramCMTime, null);
    AppMethodBeat.o(198176);
  }
  
  public void seekToTime(CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3)
  {
    AppMethodBeat.i(198177);
    seekToTime(paramCMTime1, paramCMTime2, paramCMTime3, null);
    AppMethodBeat.o(198177);
  }
  
  public void seekToTime(CMTime paramCMTime1, CMTime paramCMTime2, CMTime paramCMTime3, Callback paramCallback)
  {
    AppMethodBeat.i(198179);
    if (this.released)
    {
      AppMethodBeat.o(198179);
      return;
    }
    this.mSeekTargetTimeUs = paramCMTime1;
    this.mLastSeekTargetTimeUs = this.mSeekTargetTimeUs;
    this.mPlayThread.updatePositionRightAway(this.mSeekTargetTimeUs);
    this.mPlayThread.cancelAllPendingSeeks();
    this.mPlayThread.sendMessage(5, this.mSeekTargetTimeUs, "main", paramCallback);
    AppMethodBeat.o(198179);
  }
  
  public void seekToTime(CMTime paramCMTime, Callback paramCallback)
  {
    AppMethodBeat.i(198178);
    CMTime localCMTime = CMTime.CMTimeZero;
    seekToTime(paramCMTime, localCMTime, localCMTime, paramCallback);
    AppMethodBeat.o(198178);
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
      AppMethodBeat.i(198192);
      this.mPlayRange = paramCMTimeRange;
      if ((paramCMTimeRange != null) && (!paramCMTimeRange.containsTime(currentTime())) && (isPlaying())) {
        seekToTime(paramCMTimeRange.getStart());
      }
      AppMethodBeat.o(198192);
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
    AppMethodBeat.i(198170);
    setRate(paramFloat, 60);
    AppMethodBeat.o(198170);
  }
  
  public void setRate(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(198171);
    if ((this.mPlayerStatus != IPlayer.PlayerStatus.PLAYING) && (this.mPlayerStatus != IPlayer.PlayerStatus.PAUSED))
    {
      this.rate = paramFloat;
      this.currentItem.setRate(paramFloat, paramInt);
    }
    AppMethodBeat.o(198171);
  }
  
  public void setRateAtTimeAndHostTime(float paramFloat, CMTime paramCMTime1, CMTime paramCMTime2) {}
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(198174);
    if (this.mPlayThread != null) {
      this.mPlayThread.setRenderContextParams(paramRenderContextParams);
    }
    AppMethodBeat.o(198174);
  }
  
  /* Error */
  public void setVolume(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 403
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 403
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 7
    //   30: fload_1
    //   31: invokestatic 409	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   34: ldc 146
    //   36: invokevirtual 328	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   39: ldc_w 403
    //   42: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 411
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 411
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: iconst_4
    //   29: getstatic 417	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   32: ldc 146
    //   34: invokevirtual 328	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   37: ldc_w 411
    //   40: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 418
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 418
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: putfield 98	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 117	com/tencent/tav/player/PlayerItem:getAsset	()Lcom/tencent/tav/asset/Asset;
    //   34: putfield 119	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   37: aload_0
    //   38: getfield 98	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   41: invokevirtual 421	com/tencent/tav/player/PlayerItem:updateDecoderTrack	()V
    //   44: aload_0
    //   45: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   48: aload_2
    //   49: invokevirtual 366	com/tencent/tav/player/PlayerThread:updatePositionRightAway	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   52: aload_0
    //   53: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   56: bipush 11
    //   58: new 423	com/tencent/tav/player/UpdateCompositionMessage
    //   61: dup
    //   62: aload_1
    //   63: aload_0
    //   64: getfield 142	com/tencent/tav/player/Player:onCompositionUpdateListener	Lcom/tencent/tav/player/OnCompositionUpdateListener;
    //   67: invokespecial 426	com/tencent/tav/player/UpdateCompositionMessage:<init>	(Lcom/tencent/tav/player/PlayerItem;Lcom/tencent/tav/player/OnCompositionUpdateListener;)V
    //   70: ldc_w 428
    //   73: invokevirtual 328	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   76: aload_0
    //   77: getstatic 169	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   80: putfield 363	com/tencent/tav/player/Player:mLastSeekTargetTimeUs	Lcom/tencent/tav/coremedia/CMTime;
    //   83: ldc_w 418
    //   86: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 430
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 430
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: putfield 98	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   29: aload_0
    //   30: aload_1
    //   31: invokevirtual 117	com/tencent/tav/player/PlayerItem:getAsset	()Lcom/tencent/tav/asset/Asset;
    //   34: putfield 119	com/tencent/tav/player/Player:asset	Lcom/tencent/tav/asset/Asset;
    //   37: aload_0
    //   38: getfield 98	com/tencent/tav/player/Player:currentItem	Lcom/tencent/tav/player/PlayerItem;
    //   41: invokevirtual 421	com/tencent/tav/player/PlayerItem:updateDecoderTrack	()V
    //   44: aload_0
    //   45: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   48: aload_2
    //   49: invokevirtual 366	com/tencent/tav/player/PlayerThread:updatePositionRightAway	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   52: aload_0
    //   53: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   56: bipush 11
    //   58: new 423	com/tencent/tav/player/UpdateCompositionMessage
    //   61: dup
    //   62: aload_1
    //   63: new 10	com/tencent/tav/player/Player$1
    //   66: dup
    //   67: aload_0
    //   68: aload_3
    //   69: invokespecial 433	com/tencent/tav/player/Player$1:<init>	(Lcom/tencent/tav/player/Player;Lcom/tencent/tav/player/OnCompositionUpdateListener;)V
    //   72: invokespecial 426	com/tencent/tav/player/UpdateCompositionMessage:<init>	(Lcom/tencent/tav/player/PlayerItem;Lcom/tencent/tav/player/OnCompositionUpdateListener;)V
    //   75: ldc_w 428
    //   78: invokevirtual 328	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/Object;Ljava/lang/String;)V
    //   81: aload_0
    //   82: getstatic 169	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   85: putfield 363	com/tencent/tav/player/Player:mLastSeekTargetTimeUs	Lcom/tencent/tav/coremedia/CMTime;
    //   88: ldc_w 430
    //   91: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 435
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 435
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 20
    //   30: ldc 146
    //   32: invokevirtual 152	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   35: ldc_w 435
    //   38: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 437
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 437
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 22
    //   30: ldc 146
    //   32: invokevirtual 152	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   35: ldc_w 437
    //   38: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 439
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 439
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 23
    //   30: ldc 146
    //   32: invokevirtual 152	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   35: ldc_w 439
    //   38: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   2: ldc_w 441
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 93	com/tencent/tav/player/Player:released	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 441
    //   18: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 129	com/tencent/tav/player/Player:mPlayThread	Lcom/tencent/tav/player/PlayerThread;
    //   28: bipush 10
    //   30: ldc 146
    //   32: invokevirtual 152	com/tencent/tav/player/PlayerThread:sendMessage	(ILjava/lang/String;)V
    //   35: ldc_w 441
    //   38: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(198199);
    if (this.released)
    {
      AppMethodBeat.o(198199);
      return;
    }
    this.mPlayThread.sendMessage(21, new CGSize(paramInt1, paramInt2), "main");
    AppMethodBeat.o(198199);
  }
  
  public int videoHeight()
  {
    AppMethodBeat.i(198183);
    if (this.currentItem == null)
    {
      AppMethodBeat.o(198183);
      return 0;
    }
    int i = (int)this.currentItem.getPresentationSize().height;
    AppMethodBeat.o(198183);
    return i;
  }
  
  public int videoWidth()
  {
    AppMethodBeat.i(198182);
    if (this.currentItem == null)
    {
      AppMethodBeat.o(198182);
      return 0;
    }
    int i = (int)this.currentItem.getPresentationSize().width;
    AppMethodBeat.o(198182);
    return i;
  }
  
  public void waitForRelease(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.player.Player
 * JD-Core Version:    0.7.0.1
 */