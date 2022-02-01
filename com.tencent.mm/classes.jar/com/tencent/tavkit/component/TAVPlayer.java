package com.tencent.tavkit.component;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tav.player.OnCompositionUpdateListener;
import com.tencent.tav.player.Player;
import com.tencent.tav.player.PlayerItem;
import com.tencent.tav.player.PlayerLayer;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.tavkit.composition.builder.TAVCompositionBuilder;

public class TAVPlayer
{
  public static final int VIDEO_PLAYER_HEIGHT = 960;
  public static final int VIDEO_PLAYER_WIDTH = 540;
  private final String TAG;
  private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  private AudioManager audioManager;
  private boolean audioTracksMerge;
  private int bgColor;
  private OnCompositionUpdateListener compositionUpdateListener;
  private Context context;
  private boolean isAllowInterrupt;
  private boolean isAutoPlay;
  private boolean isResetting;
  private boolean loopPlay;
  private FrameLayout mPlayerLayout;
  private CMTimeRange playRange;
  private Player player;
  private IPlayer.PlayerListener playerListener;
  private CMTime position;
  private PostUpdateThread postUpdateThread;
  private float rate;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  private TAVComposition tavComposition;
  private boolean videoTracksMerge;
  private float volume;
  
  public TAVPlayer()
  {
    AppMethodBeat.i(218705);
    this.TAG = ("GameTemplatePlayer@" + Integer.toHexString(hashCode()));
    this.isAllowInterrupt = true;
    this.isAutoPlay = true;
    this.loopPlay = false;
    this.volume = 1.0F;
    this.position = CMTime.CMTimeZero;
    this.videoTracksMerge = true;
    this.audioTracksMerge = true;
    this.rate = 1.0F;
    this.bgColor = -16777216;
    this.isResetting = false;
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(218664);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(218664);
          return;
          if (!TAVPlayer.this.isAllowInterrupt)
          {
            AppMethodBeat.o(218664);
            return;
          }
          if (TAVPlayer.this.player != null)
          {
            TAVPlayer.this.player.pause();
            AppMethodBeat.o(218664);
            return;
            if (TAVPlayer.this.player != null) {
              TAVPlayer.this.player.play();
            }
          }
        }
      }
    };
    AppMethodBeat.o(218705);
  }
  
  public TAVPlayer(Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218716);
    this.TAG = ("GameTemplatePlayer@" + Integer.toHexString(hashCode()));
    this.isAllowInterrupt = true;
    this.isAutoPlay = true;
    this.loopPlay = false;
    this.volume = 1.0F;
    this.position = CMTime.CMTimeZero;
    this.videoTracksMerge = true;
    this.audioTracksMerge = true;
    this.rate = 1.0F;
    this.bgColor = -16777216;
    this.isResetting = false;
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(218664);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(218664);
          return;
          if (!TAVPlayer.this.isAllowInterrupt)
          {
            AppMethodBeat.o(218664);
            return;
          }
          if (TAVPlayer.this.player != null)
          {
            TAVPlayer.this.player.pause();
            AppMethodBeat.o(218664);
            return;
            if (TAVPlayer.this.player != null) {
              TAVPlayer.this.player.play();
            }
          }
        }
      }
    };
    onSurfaceCreate(paramSurface, paramInt2, paramInt1);
    AppMethodBeat.o(218716);
  }
  
  public TAVPlayer(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(218726);
    this.TAG = ("GameTemplatePlayer@" + Integer.toHexString(hashCode()));
    this.isAllowInterrupt = true;
    this.isAutoPlay = true;
    this.loopPlay = false;
    this.volume = 1.0F;
    this.position = CMTime.CMTimeZero;
    this.videoTracksMerge = true;
    this.audioTracksMerge = true;
    this.rate = 1.0F;
    this.bgColor = -16777216;
    this.isResetting = false;
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(218664);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(218664);
          return;
          if (!TAVPlayer.this.isAllowInterrupt)
          {
            AppMethodBeat.o(218664);
            return;
          }
          if (TAVPlayer.this.player != null)
          {
            TAVPlayer.this.player.pause();
            AppMethodBeat.o(218664);
            return;
            if (TAVPlayer.this.player != null) {
              TAVPlayer.this.player.play();
            }
          }
        }
      }
    };
    this.context = paramFrameLayout.getContext();
    this.mPlayerLayout = paramFrameLayout;
    initContentView();
    AppMethodBeat.o(218726);
  }
  
  private void abandonAudioFocus()
  {
    AppMethodBeat.i(218810);
    if (this.audioManager == null)
    {
      AppMethodBeat.o(218810);
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    AppMethodBeat.o(218810);
  }
  
  private PlayerItem buildPlayerItem(TAVComposition paramTAVComposition)
  {
    AppMethodBeat.i(218766);
    Logger.d(this.TAG, "buildPlayerItem() called with: tavComposition = [" + paramTAVComposition + "]");
    paramTAVComposition = new TAVCompositionBuilder(paramTAVComposition);
    paramTAVComposition.setVideoTracksMerge(this.videoTracksMerge);
    paramTAVComposition.setAudioTracksMerge(this.audioTracksMerge);
    paramTAVComposition = paramTAVComposition.buildSource();
    PlayerItem localPlayerItem = new PlayerItem(paramTAVComposition.getAsset());
    localPlayerItem.setVideoComposition(paramTAVComposition.getVideoComposition());
    localPlayerItem.setAudioMix(paramTAVComposition.getAudioMix());
    AppMethodBeat.o(218766);
    return localPlayerItem;
  }
  
  private void initContentView()
  {
    AppMethodBeat.i(218738);
    if (this.mPlayerLayout == null)
    {
      AppMethodBeat.o(218738);
      return;
    }
    this.mPlayerLayout.removeAllViews();
    TextureView localTextureView = new TextureView(this.context);
    localTextureView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.mPlayerLayout.addView(localTextureView);
    localTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
    {
      private final String TAG;
      
      public void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(218674);
        paramAnonymousSurfaceTexture = new Surface(paramAnonymousSurfaceTexture);
        TAVPlayer.this.onSurfaceCreate(paramAnonymousSurfaceTexture, paramAnonymousInt2, paramAnonymousInt1);
        AppMethodBeat.o(218674);
      }
      
      public boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(218684);
        TAVPlayer.this.onSurfaceDestory();
        AppMethodBeat.o(218684);
        return false;
      }
      
      public void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(218678);
        TAVPlayer.this.onSurfaceSizeChanged(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(218678);
      }
      
      public void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    });
    AppMethodBeat.o(218738);
  }
  
  private Player newPlayer(PlayerItem paramPlayerItem, CMTime paramCMTime, boolean paramBoolean)
  {
    AppMethodBeat.i(218791);
    Logger.d(this.TAG, "newPlayer() called with: playerItem = [" + paramPlayerItem + "], position = [" + paramCMTime + "], autoPlay = [" + paramBoolean + "]");
    paramPlayerItem = new Player(paramPlayerItem);
    paramPlayerItem.setPlayerListener(this.playerListener);
    paramPlayerItem.setLoop(this.loopPlay);
    paramPlayerItem.setRate(this.rate);
    paramPlayerItem.setBgColor(this.bgColor);
    paramPlayerItem.setPlayRange(this.playRange);
    paramPlayerItem.setVolume(this.volume);
    paramPlayerItem.seekToTime(paramCMTime);
    new PlayerLayer(this.surface, this.surfaceWidth, this.surfaceHeight).setPlayer(paramPlayerItem);
    if ((paramBoolean) && (requestAudioFocus())) {
      paramPlayerItem.play();
    }
    if (this.compositionUpdateListener != null) {
      this.compositionUpdateListener.onUpdated(paramPlayerItem, false);
    }
    this.isResetting = false;
    AppMethodBeat.o(218791);
    return paramPlayerItem;
  }
  
  private boolean requestAudioFocus()
  {
    AppMethodBeat.i(218800);
    if (this.context == null)
    {
      AppMethodBeat.o(218800);
      return true;
    }
    if (this.audioManager == null) {
      this.audioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    if (this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 1) == 1)
    {
      AppMethodBeat.o(218800);
      return true;
    }
    AppMethodBeat.o(218800);
    return false;
  }
  
  private void setPlayerListener(IPlayer.PlayerListener paramPlayerListener)
  {
    AppMethodBeat.i(218748);
    Logger.d(this.TAG, "setPlayerListener() called with: playerListener = [" + paramPlayerListener + "],player = " + this.player);
    this.playerListener = paramPlayerListener;
    if (this.player != null) {
      this.player.setPlayerListener(paramPlayerListener);
    }
    AppMethodBeat.o(218748);
  }
  
  /* Error */
  public IPlayer.PlayerStatus getCurrentStatus()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 362
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   12: ifnonnull +17 -> 29
    //   15: getstatic 368	com/tencent/tav/player/IPlayer$PlayerStatus:ERROR	Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   18: astore_1
    //   19: ldc_w 362
    //   22: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: areturn
    //   29: aload_0
    //   30: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   33: invokevirtual 371	com/tencent/tav/player/Player:currentStatus	()Lcom/tencent/tav/player/IPlayer$PlayerStatus;
    //   36: astore_1
    //   37: ldc_w 362
    //   40: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -18 -> 25
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	TAVPlayer
    //   18	19	1	localPlayerStatus	IPlayer.PlayerStatus
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	46	finally
    //   29	43	46	finally
  }
  
  /* Error */
  public CMTime getDuration()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 374
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   19: invokevirtual 377	com/tencent/tav/player/Player:duration	()Lcom/tencent/tav/coremedia/CMTime;
    //   22: astore_1
    //   23: ldc_w 374
    //   26: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: getstatic 120	com/tencent/tav/coremedia/CMTime:CMTimeZero	Lcom/tencent/tav/coremedia/CMTime;
    //   36: astore_1
    //   37: ldc_w 374
    //   40: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -14 -> 29
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	TAVPlayer
    //   22	15	1	localCMTime	CMTime
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	46	finally
    //   33	43	46	finally
  }
  
  /* Error */
  public CMTime getPosition()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 379
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   19: invokevirtual 381	com/tencent/tav/player/Player:position	()Lcom/tencent/tav/coremedia/CMTime;
    //   22: astore_1
    //   23: ldc_w 379
    //   26: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: getstatic 384	com/tencent/tav/coremedia/CMTime:CMTimeInvalid	Lcom/tencent/tav/coremedia/CMTime;
    //   36: astore_1
    //   37: ldc_w 379
    //   40: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: goto -14 -> 29
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	TAVPlayer
    //   22	15	1	localCMTime	CMTime
    //   46	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	46	finally
    //   33	43	46	finally
  }
  
  public float getVolume()
  {
    try
    {
      float f = this.volume;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean isPlaying()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 388
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   12: ifnull +21 -> 33
    //   15: aload_0
    //   16: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   19: invokevirtual 390	com/tencent/tav/player/Player:isPlaying	()Z
    //   22: istore_1
    //   23: ldc_w 388
    //   26: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iconst_0
    //   34: istore_1
    //   35: ldc_w 388
    //   38: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -12 -> 29
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	TAVPlayer
    //   22	13	1	bool	boolean
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   35	41	44	finally
  }
  
  public boolean isResetting()
  {
    return this.isResetting;
  }
  
  public void onSurfaceCreate(Surface paramSurface, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218851);
    this.surfaceWidth = paramInt2;
    this.surfaceHeight = paramInt1;
    this.surface = paramSurface;
    updateComposition(this.tavComposition, this.position, this.isAutoPlay, this.compositionUpdateListener);
    AppMethodBeat.o(218851);
  }
  
  public void onSurfaceDestory()
  {
    AppMethodBeat.i(218879);
    if ((this.player != null) && (!this.player.isReleased()))
    {
      this.position = this.player.position();
      this.player.release();
    }
    this.surface = null;
    AppMethodBeat.o(218879);
  }
  
  public void onSurfaceSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218862);
    if (this.player != null) {
      this.player.updateViewport(paramInt1, paramInt2);
    }
    AppMethodBeat.o(218862);
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 412
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 107	com/tencent/tavkit/component/TAVPlayer:TAG	Ljava/lang/String;
    //   12: new 82	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 414
    //   19: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   26: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 197	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   39: ifnull +23 -> 62
    //   42: aload_0
    //   43: invokespecial 416	com/tencent/tavkit/component/TAVPlayer:abandonAudioFocus	()V
    //   46: aload_0
    //   47: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   50: invokevirtual 418	com/tencent/tav/player/Player:pause	()V
    //   53: ldc_w 412
    //   56: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: aload_0
    //   63: iconst_0
    //   64: putfield 111	com/tencent/tavkit/component/TAVPlayer:isAutoPlay	Z
    //   67: ldc_w 412
    //   70: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: goto -14 -> 59
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	TAVPlayer
    //   76	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	59	76	finally
    //   62	73	76	finally
  }
  
  /* Error */
  public void play()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 419
    //   5: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 107	com/tencent/tavkit/component/TAVPlayer:TAG	Ljava/lang/String;
    //   12: new 82	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 421
    //   19: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   26: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 197	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   39: ifnull +26 -> 65
    //   42: aload_0
    //   43: invokespecial 331	com/tencent/tavkit/component/TAVPlayer:requestAudioFocus	()Z
    //   46: ifeq +24 -> 70
    //   49: aload_0
    //   50: getfield 175	com/tencent/tavkit/component/TAVPlayer:player	Lcom/tencent/tav/player/Player;
    //   53: invokevirtual 334	com/tencent/tav/player/Player:play	()V
    //   56: ldc_w 419
    //   59: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 111	com/tencent/tavkit/component/TAVPlayer:isAutoPlay	Z
    //   70: ldc_w 419
    //   73: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -14 -> 62
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	TAVPlayer
    //   79	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	62	79	finally
    //   65	70	79	finally
    //   70	76	79	finally
  }
  
  public void postUpdate(ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(219132);
      if (this.postUpdateThread == null)
      {
        this.postUpdateThread = new PostUpdateThread("PostUpdateThread", null);
        this.postUpdateThread.start();
      }
      PostUpdateThread.access$400(this.postUpdateThread, paramICompositionBuilder, paramBoolean);
      AppMethodBeat.o(219132);
      return;
    }
    finally {}
  }
  
  public void postUpdate(final TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(219121);
      postUpdate(new ICompositionBuilder()
      {
        public TAVComposition buildComposition()
        {
          return paramTAVComposition;
        }
        
        public void onUpdated(Player paramAnonymousPlayer, boolean paramAnonymousBoolean) {}
      }, paramBoolean);
      AppMethodBeat.o(219121);
      return;
    }
    finally
    {
      paramTAVComposition = finally;
      throw paramTAVComposition;
    }
  }
  
  public void release()
  {
    try
    {
      AppMethodBeat.i(219056);
      Logger.d(this.TAG, "release: player = " + this.player);
      if (this.player != null)
      {
        this.position = this.player.position();
        abandonAudioFocus();
        this.player.release();
        this.player = null;
      }
      if (this.postUpdateThread != null)
      {
        this.postUpdateThread.quit();
        this.postUpdateThread = null;
      }
      this.isResetting = false;
      AppMethodBeat.o(219056);
      return;
    }
    finally {}
  }
  
  public void reset()
  {
    try
    {
      AppMethodBeat.i(219049);
      this.isResetting = true;
      initContentView();
      AppMethodBeat.o(219049);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void seekToTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(218968);
    Logger.d(this.TAG, "seekToTime() called with: cmTime = [" + paramCMTime + "],player = " + this.player);
    if (this.player != null) {
      this.player.seekToTime(paramCMTime);
    }
    AppMethodBeat.o(218968);
  }
  
  public void setAllowInterrupt(boolean paramBoolean)
  {
    this.isAllowInterrupt = paramBoolean;
  }
  
  public void setAudioTracksMerge(boolean paramBoolean)
  {
    this.audioTracksMerge = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    try
    {
      this.isAutoPlay = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setBgColor(int paramInt)
  {
    AppMethodBeat.i(218928);
    this.bgColor = paramInt;
    if (this.player != null) {
      this.player.setBgColor(paramInt);
    }
    AppMethodBeat.o(218928);
  }
  
  public void setLoopPlay(boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(218905);
      Logger.d(this.TAG, "setLoopPlay() called with: loopPlay = [" + paramBoolean + "],player = " + this.player);
      this.loopPlay = paramBoolean;
      if (this.player != null) {
        this.player.setLoop(paramBoolean);
      }
      AppMethodBeat.o(218905);
      return;
    }
    finally {}
  }
  
  public void setPlayRange(CMTimeRange paramCMTimeRange)
  {
    try
    {
      AppMethodBeat.i(218939);
      Logger.d(this.TAG, "setPlayRange() called with: playRange = [" + paramCMTimeRange + "],player = " + this.player);
      this.playRange = paramCMTimeRange;
      if (this.player != null) {
        this.player.setPlayRange(paramCMTimeRange);
      }
      AppMethodBeat.o(218939);
      return;
    }
    finally {}
  }
  
  public void setPlayerListener(final PlayerListener paramPlayerListener)
  {
    AppMethodBeat.i(218893);
    Logger.d(this.TAG, "setPlayerListener() called with: playerListener = [" + paramPlayerListener + "],player = " + this.player);
    setPlayerListener(new IPlayer.PlayerListener()
    {
      public void onPositionChanged(CMTime paramAnonymousCMTime)
      {
        AppMethodBeat.i(218670);
        if ((paramPlayerListener != null) && (TAVPlayer.this.player != null)) {
          paramPlayerListener.onPositionChanged(paramAnonymousCMTime, TAVPlayer.this.player.duration());
        }
        AppMethodBeat.o(218670);
      }
      
      public void onStatusChanged(IPlayer.PlayerStatus paramAnonymousPlayerStatus)
      {
        AppMethodBeat.i(218686);
        if ((paramPlayerListener != null) && (TAVPlayer.this.player != null)) {
          paramPlayerListener.onStatusChanged(paramAnonymousPlayerStatus, TAVPlayer.this.player);
        }
        AppMethodBeat.o(218686);
      }
    });
    AppMethodBeat.o(218893);
  }
  
  public void setRate(float paramFloat)
  {
    try
    {
      AppMethodBeat.i(218919);
      Logger.d(this.TAG, "setLoopPlay() called with: loopPlay = [" + this.loopPlay + "],player = " + this.player);
      this.rate = paramFloat;
      if (this.player != null) {
        this.player.setRate(paramFloat);
      }
      AppMethodBeat.o(218919);
      return;
    }
    finally {}
  }
  
  public void setVideoTracksMerge(boolean paramBoolean)
  {
    this.videoTracksMerge = paramBoolean;
  }
  
  public void setVolume(float paramFloat)
  {
    try
    {
      AppMethodBeat.i(218949);
      Logger.d(this.TAG, "setVolume() called with: volume = [" + paramFloat + "],player = " + this.player);
      this.volume = paramFloat;
      if (this.player != null) {
        this.player.setVolume(paramFloat);
      }
      AppMethodBeat.o(218949);
      return;
    }
    finally {}
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, CMTime paramCMTime, boolean paramBoolean)
  {
    AppMethodBeat.i(219079);
    updateComposition(paramTAVComposition, paramCMTime, paramBoolean, null);
    AppMethodBeat.o(219079);
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, final CMTime paramCMTime, final boolean paramBoolean, OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    AppMethodBeat.i(219093);
    Logger.d(this.TAG, "updateComposition() called with: tavComposition = [" + paramTAVComposition + "], position = [" + paramCMTime + "], autoPlay = [" + paramBoolean + "]");
    this.tavComposition = paramTAVComposition;
    this.position = paramCMTime;
    this.compositionUpdateListener = paramOnCompositionUpdateListener;
    if (paramTAVComposition == null)
    {
      this.isResetting = false;
      AppMethodBeat.o(219093);
      return;
    }
    if (this.surface == null)
    {
      this.isAutoPlay = paramBoolean;
      this.isResetting = false;
      AppMethodBeat.o(219093);
      return;
    }
    paramTAVComposition = buildPlayerItem(paramTAVComposition);
    if ((this.player == null) || (this.player.isReleased()))
    {
      this.player = newPlayer(paramTAVComposition, paramCMTime, paramBoolean);
      AppMethodBeat.o(219093);
      return;
    }
    Player localPlayer = this.player;
    if (paramOnCompositionUpdateListener != null) {}
    for (;;)
    {
      localPlayer.update(paramTAVComposition, paramCMTime, paramOnCompositionUpdateListener);
      this.compositionUpdateListener = null;
      AppMethodBeat.o(219093);
      return;
      paramOnCompositionUpdateListener = new OnCompositionUpdateListener()
      {
        public void onUpdated(Player paramAnonymousPlayer, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(218660);
          TAVPlayer.this.seekToTime(paramCMTime);
          if ((paramBoolean) && (paramAnonymousBoolean)) {
            TAVPlayer.this.play();
          }
          TAVPlayer.access$102(TAVPlayer.this, false);
          AppMethodBeat.o(218660);
        }
      };
    }
  }
  
  public void updateComposition(TAVComposition paramTAVComposition, boolean paramBoolean)
  {
    AppMethodBeat.i(219068);
    updateComposition(paramTAVComposition, CMTime.CMTimeZero, paramBoolean);
    AppMethodBeat.o(219068);
  }
  
  public static abstract interface ICompositionBuilder
    extends OnCompositionUpdateListener
  {
    public abstract TAVComposition buildComposition();
  }
  
  public static abstract interface PlayerListener
  {
    public abstract void onPositionChanged(CMTime paramCMTime1, CMTime paramCMTime2);
    
    public abstract void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus, Player paramPlayer);
  }
  
  class PostUpdateThread
    extends HandlerThread
    implements Handler.Callback
  {
    private static final int MSG_UNLOCK = 95;
    private static final int MSG_UPDATE = 223;
    private boolean autoPlay;
    private Handler handler;
    private volatile boolean msgLock = false;
    private TAVPlayer.ICompositionBuilder templateSource;
    
    private PostUpdateThread(String paramString)
    {
      super();
    }
    
    private void doUnlockMsg()
    {
      AppMethodBeat.i(218759);
      if (this.msgLock)
      {
        this.msgLock = false;
        if (this.templateSource != null) {
          update(this.templateSource, this.autoPlay);
        }
      }
      AppMethodBeat.o(218759);
    }
    
    private void doUpdateComposition(final TAVPlayer.ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
    {
      AppMethodBeat.i(218780);
      unlockMsg(1000);
      TAVComposition localTAVComposition = paramICompositionBuilder.buildComposition();
      TAVPlayer.this.updateComposition(localTAVComposition, CMTime.CMTimeZero, paramBoolean, new OnCompositionUpdateListener()
      {
        public void onUpdated(Player paramAnonymousPlayer, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(218709);
          paramICompositionBuilder.onUpdated(paramAnonymousPlayer, paramAnonymousBoolean);
          TAVPlayer.PostUpdateThread.access$600(TAVPlayer.PostUpdateThread.this, 0);
          AppMethodBeat.o(218709);
        }
      });
      AppMethodBeat.o(218780);
    }
    
    private void doUpdateMsg()
    {
      AppMethodBeat.i(218747);
      if ((!this.msgLock) && (this.templateSource != null))
      {
        this.msgLock = true;
        doUpdateComposition(this.templateSource, this.autoPlay);
        this.templateSource = null;
        this.autoPlay = false;
      }
      AppMethodBeat.o(218747);
    }
    
    private void unlockMsg(int paramInt)
    {
      try
      {
        AppMethodBeat.i(218737);
        Logger.d(TAVPlayer.this.TAG, "unlockMsg() called thread = " + Thread.currentThread().getName());
        this.handler.removeMessages(95);
        this.handler.sendEmptyMessageDelayed(95, paramInt);
        AppMethodBeat.o(218737);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    private void update(TAVPlayer.ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
    {
      try
      {
        AppMethodBeat.i(218727);
        Logger.d(TAVPlayer.this.TAG, "update() called with: thread = " + Thread.currentThread().getName() + ", templateSource = [" + paramICompositionBuilder + "], autoPlay = [" + paramBoolean + "]");
        this.templateSource = paramICompositionBuilder;
        this.autoPlay = paramBoolean;
        this.handler.removeMessages(223);
        this.handler.sendEmptyMessage(223);
        AppMethodBeat.o(218727);
        return;
      }
      finally
      {
        paramICompositionBuilder = finally;
        throw paramICompositionBuilder;
      }
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(218834);
      Logger.d(TAVPlayer.this.TAG, "handleMessage() called with: msg = [" + paramMessage + "] msgLock = " + this.msgLock + ",templateSource = " + this.templateSource);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(218834);
        return true;
        doUpdateMsg();
        continue;
        doUnlockMsg();
      }
    }
    
    protected void onLooperPrepared()
    {
      AppMethodBeat.i(218815);
      super.onLooperPrepared();
      AppMethodBeat.o(218815);
    }
    
    public void release()
    {
      AppMethodBeat.i(218840);
      this.templateSource = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacksAndMessages(null);
        this.handler = null;
      }
      quit();
      AppMethodBeat.o(218840);
    }
    
    public void start()
    {
      try
      {
        AppMethodBeat.i(218824);
        super.start();
        this.handler = new Handler(getLooper(), this);
        AppMethodBeat.o(218824);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer
 * JD-Core Version:    0.7.0.1
 */