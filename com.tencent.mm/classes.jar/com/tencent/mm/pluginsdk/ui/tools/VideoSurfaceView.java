package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class VideoSurfaceView
  extends SurfaceView
  implements k
{
  SurfaceHolder.Callback Ryb;
  private int alM;
  private boolean cJM;
  private boolean iYs;
  private SurfaceHolder jAv;
  private int mVideoHeight;
  private int mVideoWidth;
  private MediaPlayer.OnCompletionListener pAa;
  private MediaPlayer.OnErrorListener pAd;
  private String pDg;
  private boolean pDh;
  private MediaPlayer pzX;
  MediaPlayer.OnPreparedListener pzY;
  MediaPlayer.OnVideoSizeChangedListener pzZ;
  private k.a uXU;
  
  public VideoSurfaceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(116301);
    this.jAv = null;
    this.pzX = null;
    this.pzZ = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116294);
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoSurfaceView.b(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoHeight());
        Log.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.a(VideoSurfaceView.this) + " , " + VideoSurfaceView.b(VideoSurfaceView.this) + " )");
        VideoSurfaceView.c(VideoSurfaceView.this);
        AppMethodBeat.o(116294);
      }
    };
    this.pzY = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(116295);
        VideoSurfaceView.d(VideoSurfaceView.this);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).qX();
        }
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoSurfaceView.b(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoHeight());
        VideoSurfaceView.c(VideoSurfaceView.this);
        if ((VideoSurfaceView.a(VideoSurfaceView.this) != 0) && (VideoSurfaceView.b(VideoSurfaceView.this) != 0))
        {
          if (VideoSurfaceView.f(VideoSurfaceView.this))
          {
            VideoSurfaceView.g(VideoSurfaceView.this).start();
            VideoSurfaceView.h(VideoSurfaceView.this);
            AppMethodBeat.o(116295);
          }
        }
        else if (VideoSurfaceView.f(VideoSurfaceView.this))
        {
          VideoSurfaceView.g(VideoSurfaceView.this).start();
          VideoSurfaceView.h(VideoSurfaceView.this);
        }
        AppMethodBeat.o(116295);
      }
    };
    this.pAa = new VideoSurfaceView.3(this);
    this.pAd = new VideoSurfaceView.4(this);
    this.Ryb = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(116298);
        Log.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        if ((VideoSurfaceView.g(VideoSurfaceView.this) != null) && (VideoSurfaceView.i(VideoSurfaceView.this)) && (VideoSurfaceView.a(VideoSurfaceView.this) == paramAnonymousInt2) && (VideoSurfaceView.b(VideoSurfaceView.this) == paramAnonymousInt3)) {
          VideoSurfaceView.g(VideoSurfaceView.this).start();
        }
        AppMethodBeat.o(116298);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(116299);
        Log.i("MicroMsg.VideoSurfaceView", "on surface created");
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousSurfaceHolder);
        VideoSurfaceView.j(VideoSurfaceView.this);
        AppMethodBeat.o(116299);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(116300);
        Log.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
        VideoSurfaceView.a(VideoSurfaceView.this, null);
        if (VideoSurfaceView.g(VideoSurfaceView.this) != null)
        {
          VideoSurfaceView.e(VideoSurfaceView.this).fE(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.g(VideoSurfaceView.this).reset();
          VideoSurfaceView.g(VideoSurfaceView.this).release();
          VideoSurfaceView.k(VideoSurfaceView.this);
        }
        AppMethodBeat.o(116300);
      }
    };
    this.iYs = false;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.Ryb);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    AppMethodBeat.o(116301);
  }
  
  private void bXd()
  {
    AppMethodBeat.i(116304);
    if ((this.pDg == null) || (this.jAv == null))
    {
      AppMethodBeat.o(116304);
      return;
    }
    if (this.pzX != null)
    {
      this.pzX.stop();
      this.pzX.release();
      this.pzX = null;
    }
    try
    {
      this.pzX = new com.tencent.mm.compatible.b.k();
      this.pzX.setOnPreparedListener(this.pzY);
      this.pzX.setOnVideoSizeChangedListener(this.pzZ);
      this.pDh = false;
      Log.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
      this.alM = -1;
      this.pzX.setOnCompletionListener(this.pAa);
      this.pzX.setOnErrorListener(this.pAd);
      this.pzX.setDataSource(this.pDg);
      this.pzX.setDisplay(this.jAv);
      this.pzX.setAudioStreamType(3);
      this.pzX.setScreenOnWhilePlaying(true);
      this.pzX.prepareAsync();
      this.mVideoHeight = this.pzX.getVideoHeight();
      this.mVideoWidth = this.pzX.getVideoWidth();
      setMute(this.iYs);
      AppMethodBeat.o(116304);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.VideoSurfaceView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      if (this.uXU != null) {
        this.uXU.onError(-1, -1);
      }
      AppMethodBeat.o(116304);
    }
  }
  
  public final boolean I(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116311);
    paramBoolean = start();
    AppMethodBeat.o(116311);
    return paramBoolean;
  }
  
  public final void b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116314);
    q(paramDouble);
    AppMethodBeat.o(116314);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116307);
    if ((this.pzX != null) && (this.pDh))
    {
      int i = this.pzX.getCurrentPosition();
      AppMethodBeat.o(116307);
      return i;
    }
    AppMethodBeat.o(116307);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116306);
    if ((this.pzX != null) && (this.pDh))
    {
      if (this.alM > 0)
      {
        i = this.alM;
        AppMethodBeat.o(116306);
        return i;
      }
      this.alM = this.pzX.getDuration();
      i = this.alM;
      AppMethodBeat.o(116306);
      return i;
    }
    this.alM = -1;
    int i = this.alM;
    AppMethodBeat.o(116306);
    return i;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return 0L;
  }
  
  public String getVideoPath()
  {
    return this.pDg;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116308);
    if ((this.pzX != null) && (this.pDh))
    {
      boolean bool = this.pzX.isPlaying();
      AppMethodBeat.o(116308);
      return bool;
    }
    AppMethodBeat.o(116308);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void pause()
  {
    AppMethodBeat.i(116305);
    if ((this.pzX != null) && (this.pDh) && (this.pzX.isPlaying())) {
      this.pzX.pause();
    }
    this.cJM = false;
    AppMethodBeat.o(116305);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(116312);
    if (this.pzX != null)
    {
      Log.d("MicroMsg.VideoSurfaceView", "seek to time: ".concat(String.valueOf(paramDouble)));
      this.pzX.seekTo((int)paramDouble);
      start();
    }
    AppMethodBeat.o(116312);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116309);
    if (this.pzX != null) {
      this.pzX.setLooping(paramBoolean);
    }
    AppMethodBeat.o(116309);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(116313);
    this.iYs = paramBoolean;
    if (this.pzX != null)
    {
      if (this.iYs)
      {
        this.pzX.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(116313);
        return;
      }
      this.pzX.setVolume(0.5F, 0.5F);
    }
    AppMethodBeat.o(116313);
  }
  
  public void setOnInfoCallback(k.b paramb) {}
  
  public void setOnSeekCompleteCallback(k.c paramc) {}
  
  public void setOnSurfaceCallback(k.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(k.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(k.a parama)
  {
    this.uXU = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116302);
    this.pDg = paramString;
    this.cJM = false;
    bXd();
    requestLayout();
    AppMethodBeat.o(116302);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116310);
    if ((this.pzX != null) && (this.pDh)) {
      this.pzX.start();
    }
    for (this.cJM = false;; this.cJM = true)
    {
      AppMethodBeat.o(116310);
      return true;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116303);
    if (this.pzX != null)
    {
      this.pzX.stop();
      this.pzX.release();
      this.pzX = null;
    }
    AppMethodBeat.o(116303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView
 * JD-Core Version:    0.7.0.1
 */