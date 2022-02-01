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
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.ad;

public class VideoSurfaceView
  extends SurfaceView
  implements h
{
  SurfaceHolder.Callback CnK;
  private int ark;
  private boolean cnf;
  private boolean fqj;
  private SurfaceHolder jrQ;
  private MediaPlayer ksn;
  MediaPlayer.OnPreparedListener kso;
  MediaPlayer.OnVideoSizeChangedListener ksp;
  private MediaPlayer.OnCompletionListener ksq;
  private MediaPlayer.OnErrorListener kst;
  private String kul;
  private boolean kum;
  private int mVideoHeight;
  private int mVideoWidth;
  private h.a oNM;
  
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
    this.jrQ = null;
    this.ksn = null;
    this.ksp = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116294);
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoSurfaceView.b(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoHeight());
        ad.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.a(VideoSurfaceView.this) + " , " + VideoSurfaceView.b(VideoSurfaceView.this) + " )");
        VideoSurfaceView.c(VideoSurfaceView.this);
        AppMethodBeat.o(116294);
      }
    };
    this.kso = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(116295);
        VideoSurfaceView.d(VideoSurfaceView.this);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).rq();
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
    this.ksq = new VideoSurfaceView.3(this);
    this.kst = new VideoSurfaceView.4(this);
    this.CnK = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(116298);
        ad.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        if ((VideoSurfaceView.g(VideoSurfaceView.this) != null) && (VideoSurfaceView.i(VideoSurfaceView.this)) && (VideoSurfaceView.a(VideoSurfaceView.this) == paramAnonymousInt2) && (VideoSurfaceView.b(VideoSurfaceView.this) == paramAnonymousInt3)) {
          VideoSurfaceView.g(VideoSurfaceView.this).start();
        }
        AppMethodBeat.o(116298);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(116299);
        ad.i("MicroMsg.VideoSurfaceView", "on surface created");
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousSurfaceHolder);
        VideoSurfaceView.j(VideoSurfaceView.this);
        AppMethodBeat.o(116299);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(116300);
        ad.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
        VideoSurfaceView.a(VideoSurfaceView.this, null);
        if (VideoSurfaceView.g(VideoSurfaceView.this) != null)
        {
          VideoSurfaceView.e(VideoSurfaceView.this).eM(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.g(VideoSurfaceView.this).reset();
          VideoSurfaceView.g(VideoSurfaceView.this).release();
          VideoSurfaceView.k(VideoSurfaceView.this);
        }
        AppMethodBeat.o(116300);
      }
    };
    this.fqj = false;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.CnK);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    AppMethodBeat.o(116301);
  }
  
  private void bei()
  {
    AppMethodBeat.i(116304);
    if ((this.kul == null) || (this.jrQ == null))
    {
      AppMethodBeat.o(116304);
      return;
    }
    if (this.ksn != null)
    {
      this.ksn.stop();
      this.ksn.release();
      this.ksn = null;
    }
    try
    {
      this.ksn = new k();
      this.ksn.setOnPreparedListener(this.kso);
      this.ksn.setOnVideoSizeChangedListener(this.ksp);
      this.kum = false;
      ad.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
      this.ark = -1;
      this.ksn.setOnCompletionListener(this.ksq);
      this.ksn.setOnErrorListener(this.kst);
      this.ksn.setDataSource(this.kul);
      this.ksn.setDisplay(this.jrQ);
      this.ksn.setAudioStreamType(3);
      this.ksn.setScreenOnWhilePlaying(true);
      this.ksn.prepareAsync();
      this.mVideoHeight = this.ksn.getVideoHeight();
      this.mVideoWidth = this.ksn.getVideoWidth();
      setMute(this.fqj);
      AppMethodBeat.o(116304);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.VideoSurfaceView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      if (this.oNM != null) {
        this.oNM.onError(-1, -1);
      }
      AppMethodBeat.o(116304);
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116314);
    q(paramDouble);
    AppMethodBeat.o(116314);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116307);
    if ((this.ksn != null) && (this.kum))
    {
      int i = this.ksn.getCurrentPosition();
      AppMethodBeat.o(116307);
      return i;
    }
    AppMethodBeat.o(116307);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116306);
    if ((this.ksn != null) && (this.kum))
    {
      if (this.ark > 0)
      {
        i = this.ark;
        AppMethodBeat.o(116306);
        return i;
      }
      this.ark = this.ksn.getDuration();
      i = this.ark;
      AppMethodBeat.o(116306);
      return i;
    }
    this.ark = -1;
    int i = this.ark;
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
    return this.kul;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116308);
    if ((this.ksn != null) && (this.kum))
    {
      boolean bool = this.ksn.isPlaying();
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
    if ((this.ksn != null) && (this.kum) && (this.ksn.isPlaying())) {
      this.ksn.pause();
    }
    this.cnf = false;
    AppMethodBeat.o(116305);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(116312);
    if (this.ksn != null)
    {
      ad.d("MicroMsg.VideoSurfaceView", "seek to time: ".concat(String.valueOf(paramDouble)));
      this.ksn.seekTo((int)paramDouble);
      start();
    }
    AppMethodBeat.o(116312);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116309);
    if (this.ksn != null) {
      this.ksn.setLooping(paramBoolean);
    }
    AppMethodBeat.o(116309);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(116313);
    this.fqj = paramBoolean;
    if (this.ksn != null)
    {
      if (this.fqj)
      {
        this.ksn.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(116313);
        return;
      }
      this.ksn.setVolume(0.5F, 0.5F);
    }
    AppMethodBeat.o(116313);
  }
  
  public void setOnInfoCallback(h.b paramb) {}
  
  public void setOnSeekCompleteCallback(h.c paramc) {}
  
  public void setOnSurfaceCallback(h.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(h.a parama)
  {
    this.oNM = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116302);
    this.kul = paramString;
    this.cnf = false;
    bei();
    requestLayout();
    AppMethodBeat.o(116302);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116310);
    if ((this.ksn != null) && (this.kum)) {
      this.ksn.start();
    }
    for (this.cnf = false;; this.cnf = true)
    {
      AppMethodBeat.o(116310);
      return true;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116303);
    if (this.ksn != null)
    {
      this.ksn.stop();
      this.ksn.release();
      this.ksn = null;
    }
    AppMethodBeat.o(116303);
  }
  
  public final boolean y(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116311);
    paramBoolean = start();
    AppMethodBeat.o(116311);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView
 * JD-Core Version:    0.7.0.1
 */