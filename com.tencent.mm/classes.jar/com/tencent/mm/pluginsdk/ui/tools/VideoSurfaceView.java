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
import com.tencent.mm.sdk.platformtools.ae;

public class VideoSurfaceView
  extends SurfaceView
  implements h
{
  SurfaceHolder.Callback FDG;
  private int atW;
  private boolean cvk;
  private boolean fOX;
  private SurfaceHolder kpM;
  private MediaPlayer luF;
  MediaPlayer.OnPreparedListener luG;
  MediaPlayer.OnVideoSizeChangedListener luH;
  private MediaPlayer.OnCompletionListener luI;
  private MediaPlayer.OnErrorListener luL;
  private String lwY;
  private boolean lwZ;
  private int mVideoHeight;
  private int mVideoWidth;
  private h.a qbr;
  
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
    this.kpM = null;
    this.luF = null;
    this.luH = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116294);
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoSurfaceView.b(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoHeight());
        ae.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.a(VideoSurfaceView.this) + " , " + VideoSurfaceView.b(VideoSurfaceView.this) + " )");
        VideoSurfaceView.c(VideoSurfaceView.this);
        AppMethodBeat.o(116294);
      }
    };
    this.luG = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(116295);
        VideoSurfaceView.d(VideoSurfaceView.this);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).ta();
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
    this.luI = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(116296);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null)
        {
          VideoSurfaceView.e(VideoSurfaceView.this).eU(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.e(VideoSurfaceView.this).onCompletion();
        }
        AppMethodBeat.o(116296);
      }
    };
    this.luL = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116297);
        ae.d("MicroMsg.VideoSurfaceView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(116297);
        return true;
      }
    };
    this.FDG = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(116298);
        ae.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", new Object[] { Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt3) });
        if ((VideoSurfaceView.g(VideoSurfaceView.this) != null) && (VideoSurfaceView.i(VideoSurfaceView.this)) && (VideoSurfaceView.a(VideoSurfaceView.this) == paramAnonymousInt2) && (VideoSurfaceView.b(VideoSurfaceView.this) == paramAnonymousInt3)) {
          VideoSurfaceView.g(VideoSurfaceView.this).start();
        }
        AppMethodBeat.o(116298);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(116299);
        ae.i("MicroMsg.VideoSurfaceView", "on surface created");
        VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousSurfaceHolder);
        VideoSurfaceView.j(VideoSurfaceView.this);
        AppMethodBeat.o(116299);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(116300);
        ae.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
        VideoSurfaceView.a(VideoSurfaceView.this, null);
        if (VideoSurfaceView.g(VideoSurfaceView.this) != null)
        {
          VideoSurfaceView.e(VideoSurfaceView.this).eU(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.g(VideoSurfaceView.this).reset();
          VideoSurfaceView.g(VideoSurfaceView.this).release();
          VideoSurfaceView.k(VideoSurfaceView.this);
        }
        AppMethodBeat.o(116300);
      }
    };
    this.fOX = false;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.FDG);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    AppMethodBeat.o(116301);
  }
  
  private void bpx()
  {
    AppMethodBeat.i(116304);
    if ((this.lwY == null) || (this.kpM == null))
    {
      AppMethodBeat.o(116304);
      return;
    }
    if (this.luF != null)
    {
      this.luF.stop();
      this.luF.release();
      this.luF = null;
    }
    try
    {
      this.luF = new k();
      this.luF.setOnPreparedListener(this.luG);
      this.luF.setOnVideoSizeChangedListener(this.luH);
      this.lwZ = false;
      ae.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
      this.atW = -1;
      this.luF.setOnCompletionListener(this.luI);
      this.luF.setOnErrorListener(this.luL);
      this.luF.setDataSource(this.lwY);
      this.luF.setDisplay(this.kpM);
      this.luF.setAudioStreamType(3);
      this.luF.setScreenOnWhilePlaying(true);
      this.luF.prepareAsync();
      this.mVideoHeight = this.luF.getVideoHeight();
      this.mVideoWidth = this.luF.getVideoWidth();
      setMute(this.fOX);
      AppMethodBeat.o(116304);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.VideoSurfaceView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      if (this.qbr != null) {
        this.qbr.onError(-1, -1);
      }
      AppMethodBeat.o(116304);
    }
  }
  
  public final boolean B(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116311);
    paramBoolean = start();
    AppMethodBeat.o(116311);
    return paramBoolean;
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
    if ((this.luF != null) && (this.lwZ))
    {
      int i = this.luF.getCurrentPosition();
      AppMethodBeat.o(116307);
      return i;
    }
    AppMethodBeat.o(116307);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116306);
    if ((this.luF != null) && (this.lwZ))
    {
      if (this.atW > 0)
      {
        i = this.atW;
        AppMethodBeat.o(116306);
        return i;
      }
      this.atW = this.luF.getDuration();
      i = this.atW;
      AppMethodBeat.o(116306);
      return i;
    }
    this.atW = -1;
    int i = this.atW;
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
    return this.lwY;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116308);
    if ((this.luF != null) && (this.lwZ))
    {
      boolean bool = this.luF.isPlaying();
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
    if (this.luF != null)
    {
      ae.d("MicroMsg.VideoSurfaceView", "seek to time: ".concat(String.valueOf(paramDouble)));
      this.luF.seekTo((int)paramDouble);
      start();
    }
    AppMethodBeat.o(116312);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(116305);
    if ((this.luF != null) && (this.lwZ) && (this.luF.isPlaying())) {
      this.luF.pause();
    }
    this.cvk = false;
    AppMethodBeat.o(116305);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116309);
    if (this.luF != null) {
      this.luF.setLooping(paramBoolean);
    }
    AppMethodBeat.o(116309);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(116313);
    this.fOX = paramBoolean;
    if (this.luF != null)
    {
      if (this.fOX)
      {
        this.luF.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(116313);
        return;
      }
      this.luF.setVolume(0.5F, 0.5F);
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
    this.qbr = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116302);
    this.lwY = paramString;
    this.cvk = false;
    bpx();
    requestLayout();
    AppMethodBeat.o(116302);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116310);
    if ((this.luF != null) && (this.lwZ)) {
      this.luF.start();
    }
    for (this.cvk = false;; this.cvk = true)
    {
      AppMethodBeat.o(116310);
      return true;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116303);
    if (this.luF != null)
    {
      this.luF.stop();
      this.luF.release();
      this.luF = null;
    }
    AppMethodBeat.o(116303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView
 * JD-Core Version:    0.7.0.1
 */