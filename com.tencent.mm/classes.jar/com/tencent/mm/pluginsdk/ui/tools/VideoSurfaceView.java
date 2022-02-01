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
import com.tencent.mm.sdk.platformtools.ac;

public class VideoSurfaceView
  extends SurfaceView
  implements h
{
  SurfaceHolder.Callback DGd;
  private int asf;
  private boolean ckh;
  private boolean ftN;
  private SurfaceHolder jSi;
  private MediaPlayer kTD;
  MediaPlayer.OnPreparedListener kTE;
  MediaPlayer.OnVideoSizeChangedListener kTF;
  private MediaPlayer.OnCompletionListener kTG;
  private MediaPlayer.OnErrorListener kTJ;
  private String kVA;
  private boolean kVB;
  private int mVideoHeight;
  private int mVideoWidth;
  private h.a prg;
  
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
    this.jSi = null;
    this.kTD = null;
    this.kTF = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116294);
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoSurfaceView.b(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoHeight());
        ac.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.a(VideoSurfaceView.this) + " , " + VideoSurfaceView.b(VideoSurfaceView.this) + " )");
        VideoSurfaceView.c(VideoSurfaceView.this);
        AppMethodBeat.o(116294);
      }
    };
    this.kTE = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(116295);
        VideoSurfaceView.d(VideoSurfaceView.this);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).rB();
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
    this.kTG = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(116296);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null)
        {
          VideoSurfaceView.e(VideoSurfaceView.this).eP(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.e(VideoSurfaceView.this).onCompletion();
        }
        AppMethodBeat.o(116296);
      }
    };
    this.kTJ = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116297);
        ac.d("MicroMsg.VideoSurfaceView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(116297);
        return true;
      }
    };
    this.DGd = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(116298);
        ac.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        if ((VideoSurfaceView.g(VideoSurfaceView.this) != null) && (VideoSurfaceView.i(VideoSurfaceView.this)) && (VideoSurfaceView.a(VideoSurfaceView.this) == paramAnonymousInt2) && (VideoSurfaceView.b(VideoSurfaceView.this) == paramAnonymousInt3)) {
          VideoSurfaceView.g(VideoSurfaceView.this).start();
        }
        AppMethodBeat.o(116298);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(116299);
        ac.i("MicroMsg.VideoSurfaceView", "on surface created");
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousSurfaceHolder);
        VideoSurfaceView.j(VideoSurfaceView.this);
        AppMethodBeat.o(116299);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(116300);
        ac.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
        VideoSurfaceView.a(VideoSurfaceView.this, null);
        if (VideoSurfaceView.g(VideoSurfaceView.this) != null)
        {
          VideoSurfaceView.e(VideoSurfaceView.this).eP(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.g(VideoSurfaceView.this).reset();
          VideoSurfaceView.g(VideoSurfaceView.this).release();
          VideoSurfaceView.k(VideoSurfaceView.this);
        }
        AppMethodBeat.o(116300);
      }
    };
    this.ftN = false;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.DGd);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    AppMethodBeat.o(116301);
  }
  
  private void blc()
  {
    AppMethodBeat.i(116304);
    if ((this.kVA == null) || (this.jSi == null))
    {
      AppMethodBeat.o(116304);
      return;
    }
    if (this.kTD != null)
    {
      this.kTD.stop();
      this.kTD.release();
      this.kTD = null;
    }
    try
    {
      this.kTD = new k();
      this.kTD.setOnPreparedListener(this.kTE);
      this.kTD.setOnVideoSizeChangedListener(this.kTF);
      this.kVB = false;
      ac.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
      this.asf = -1;
      this.kTD.setOnCompletionListener(this.kTG);
      this.kTD.setOnErrorListener(this.kTJ);
      this.kTD.setDataSource(this.kVA);
      this.kTD.setDisplay(this.jSi);
      this.kTD.setAudioStreamType(3);
      this.kTD.setScreenOnWhilePlaying(true);
      this.kTD.prepareAsync();
      this.mVideoHeight = this.kTD.getVideoHeight();
      this.mVideoWidth = this.kTD.getVideoWidth();
      setMute(this.ftN);
      AppMethodBeat.o(116304);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.VideoSurfaceView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      if (this.prg != null) {
        this.prg.onError(-1, -1);
      }
      AppMethodBeat.o(116304);
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(116314);
    p(paramDouble);
    AppMethodBeat.o(116314);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(116307);
    if ((this.kTD != null) && (this.kVB))
    {
      int i = this.kTD.getCurrentPosition();
      AppMethodBeat.o(116307);
      return i;
    }
    AppMethodBeat.o(116307);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116306);
    if ((this.kTD != null) && (this.kVB))
    {
      if (this.asf > 0)
      {
        i = this.asf;
        AppMethodBeat.o(116306);
        return i;
      }
      this.asf = this.kTD.getDuration();
      i = this.asf;
      AppMethodBeat.o(116306);
      return i;
    }
    this.asf = -1;
    int i = this.asf;
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
    return this.kVA;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116308);
    if ((this.kTD != null) && (this.kVB))
    {
      boolean bool = this.kTD.isPlaying();
      AppMethodBeat.o(116308);
      return bool;
    }
    AppMethodBeat.o(116308);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(116312);
    if (this.kTD != null)
    {
      ac.d("MicroMsg.VideoSurfaceView", "seek to time: ".concat(String.valueOf(paramDouble)));
      this.kTD.seekTo((int)paramDouble);
      start();
    }
    AppMethodBeat.o(116312);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116305);
    if ((this.kTD != null) && (this.kVB) && (this.kTD.isPlaying())) {
      this.kTD.pause();
    }
    this.ckh = false;
    AppMethodBeat.o(116305);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116309);
    if (this.kTD != null) {
      this.kTD.setLooping(paramBoolean);
    }
    AppMethodBeat.o(116309);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(116313);
    this.ftN = paramBoolean;
    if (this.kTD != null)
    {
      if (this.ftN)
      {
        this.kTD.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(116313);
        return;
      }
      this.kTD.setVolume(0.5F, 0.5F);
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
    this.prg = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116302);
    this.kVA = paramString;
    this.ckh = false;
    blc();
    requestLayout();
    AppMethodBeat.o(116302);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116310);
    if ((this.kTD != null) && (this.kVB)) {
      this.kTD.start();
    }
    for (this.ckh = false;; this.ckh = true)
    {
      AppMethodBeat.o(116310);
      return true;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116303);
    if (this.kTD != null)
    {
      this.kTD.stop();
      this.kTD.release();
      this.kTD = null;
    }
    AppMethodBeat.o(116303);
  }
  
  public final boolean z(Context paramContext, boolean paramBoolean)
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