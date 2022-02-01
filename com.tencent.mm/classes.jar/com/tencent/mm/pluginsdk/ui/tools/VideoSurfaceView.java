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
import com.tencent.mm.sdk.platformtools.Log;

public class VideoSurfaceView
  extends SurfaceView
  implements j
{
  SurfaceHolder.Callback KwK;
  private int atU;
  private boolean cJi;
  private SurfaceHolder gQc;
  private boolean guh;
  private MediaPlayer mBq;
  MediaPlayer.OnPreparedListener mBr;
  MediaPlayer.OnVideoSizeChangedListener mBs;
  private MediaPlayer.OnCompletionListener mBt;
  private MediaPlayer.OnErrorListener mBw;
  private String mDV;
  private boolean mDW;
  private int mVideoHeight;
  private int mVideoWidth;
  private j.a rso;
  
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
    this.gQc = null;
    this.mBq = null;
    this.mBs = new MediaPlayer.OnVideoSizeChangedListener()
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
    this.mBr = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(116295);
        VideoSurfaceView.d(VideoSurfaceView.this);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).tf();
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
    this.mBt = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(116296);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null)
        {
          VideoSurfaceView.e(VideoSurfaceView.this).fh(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.e(VideoSurfaceView.this).onCompletion();
        }
        AppMethodBeat.o(116296);
      }
    };
    this.mBw = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(116297);
        Log.d("MicroMsg.VideoSurfaceView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        if (VideoSurfaceView.e(VideoSurfaceView.this) != null) {
          VideoSurfaceView.e(VideoSurfaceView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(116297);
        return true;
      }
    };
    this.KwK = new SurfaceHolder.Callback()
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
          VideoSurfaceView.e(VideoSurfaceView.this).fh(VideoSurfaceView.g(VideoSurfaceView.this).getCurrentPosition(), VideoSurfaceView.g(VideoSurfaceView.this).getDuration());
          VideoSurfaceView.g(VideoSurfaceView.this).reset();
          VideoSurfaceView.g(VideoSurfaceView.this).release();
          VideoSurfaceView.k(VideoSurfaceView.this);
        }
        AppMethodBeat.o(116300);
      }
    };
    this.guh = false;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.KwK);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    AppMethodBeat.o(116301);
  }
  
  private void bLd()
  {
    AppMethodBeat.i(116304);
    if ((this.mDV == null) || (this.gQc == null))
    {
      AppMethodBeat.o(116304);
      return;
    }
    if (this.mBq != null)
    {
      this.mBq.stop();
      this.mBq.release();
      this.mBq = null;
    }
    try
    {
      this.mBq = new k();
      this.mBq.setOnPreparedListener(this.mBr);
      this.mBq.setOnVideoSizeChangedListener(this.mBs);
      this.mDW = false;
      Log.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
      this.atU = -1;
      this.mBq.setOnCompletionListener(this.mBt);
      this.mBq.setOnErrorListener(this.mBw);
      this.mBq.setDataSource(this.mDV);
      this.mBq.setDisplay(this.gQc);
      this.mBq.setAudioStreamType(3);
      this.mBq.setScreenOnWhilePlaying(true);
      this.mBq.prepareAsync();
      this.mVideoHeight = this.mBq.getVideoHeight();
      this.mVideoWidth = this.mBq.getVideoWidth();
      setMute(this.guh);
      AppMethodBeat.o(116304);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.VideoSurfaceView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      if (this.rso != null) {
        this.rso.onError(-1, -1);
      }
      AppMethodBeat.o(116304);
    }
  }
  
  public final boolean E(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(116311);
    paramBoolean = start();
    AppMethodBeat.o(116311);
    return paramBoolean;
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
    if ((this.mBq != null) && (this.mDW))
    {
      int i = this.mBq.getCurrentPosition();
      AppMethodBeat.o(116307);
      return i;
    }
    AppMethodBeat.o(116307);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(116306);
    if ((this.mBq != null) && (this.mDW))
    {
      if (this.atU > 0)
      {
        i = this.atU;
        AppMethodBeat.o(116306);
        return i;
      }
      this.atU = this.mBq.getDuration();
      i = this.atU;
      AppMethodBeat.o(116306);
      return i;
    }
    this.atU = -1;
    int i = this.atU;
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
    return this.mDV;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(116308);
    if ((this.mBq != null) && (this.mDW))
    {
      boolean bool = this.mBq.isPlaying();
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
    if ((this.mBq != null) && (this.mDW) && (this.mBq.isPlaying())) {
      this.mBq.pause();
    }
    this.cJi = false;
    AppMethodBeat.o(116305);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(116312);
    if (this.mBq != null)
    {
      Log.d("MicroMsg.VideoSurfaceView", "seek to time: ".concat(String.valueOf(paramDouble)));
      this.mBq.seekTo((int)paramDouble);
      start();
    }
    AppMethodBeat.o(116312);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(116309);
    if (this.mBq != null) {
      this.mBq.setLooping(paramBoolean);
    }
    AppMethodBeat.o(116309);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(116313);
    this.guh = paramBoolean;
    if (this.mBq != null)
    {
      if (this.guh)
      {
        this.mBq.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(116313);
        return;
      }
      this.mBq.setVolume(0.5F, 0.5F);
    }
    AppMethodBeat.o(116313);
  }
  
  public void setOnInfoCallback(j.b paramb) {}
  
  public void setOnSeekCompleteCallback(j.c paramc) {}
  
  public void setOnSurfaceCallback(j.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(j.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(j.a parama)
  {
    this.rso = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(116302);
    this.mDV = paramString;
    this.cJi = false;
    bLd();
    requestLayout();
    AppMethodBeat.o(116302);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(116310);
    if ((this.mBq != null) && (this.mDW)) {
      this.mBq.start();
    }
    for (this.cJi = false;; this.cJi = true)
    {
      AppMethodBeat.o(116310);
      return true;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(116303);
    if (this.mBq != null)
    {
      this.mBq.stop();
      this.mBq.release();
      this.mBq = null;
    }
    AppMethodBeat.o(116303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView
 * JD-Core Version:    0.7.0.1
 */