package com.tencent.mm.ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public class VideoView
  extends SurfaceView
{
  SurfaceHolder.Callback Yux;
  private MediaPlayer.OnPreparedListener afRs;
  private int afRt;
  private int afRu;
  private a afRv;
  private int cam;
  public boolean eDv;
  private Context mContext;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private int mVideoHeight;
  private int mVideoWidth;
  private MediaPlayer.OnCompletionListener pee;
  private MediaPlayer.OnErrorListener pef;
  private SurfaceHolder rsd;
  public MediaPlayer sFf;
  MediaPlayer.OnPreparedListener sFg;
  MediaPlayer.OnVideoSizeChangedListener sFh;
  private MediaPlayer.OnCompletionListener sFi;
  private MediaPlayer.OnErrorListener sFl;
  private MediaPlayer.OnBufferingUpdateListener sFm;
  private String sIs;
  public boolean sIt;
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(39499);
    this.mContext = paramContext;
    jEw();
    AppMethodBeat.o(39499);
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39500);
    this.rsd = null;
    this.sFf = null;
    this.sFh = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39490);
        VideoView.a(VideoView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoView.b(VideoView.this, paramAnonymousMediaPlayer.getVideoHeight());
        Log.v("MicroMsg.VideoView", "on size change size:( " + VideoView.a(VideoView.this) + " , " + VideoView.b(VideoView.this) + " )");
        VideoView.this.jEv();
        if (VideoView.a(VideoView.this) != 0) {
          VideoView.b(VideoView.this);
        }
        AppMethodBeat.o(39490);
      }
    };
    this.sFg = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(39491);
        VideoView.c(VideoView.this);
        if (VideoView.d(VideoView.this) != null) {
          VideoView.d(VideoView.this).onPrepared(VideoView.e(VideoView.this));
        }
        VideoView.a(VideoView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoView.b(VideoView.this, paramAnonymousMediaPlayer.getVideoHeight());
        VideoView.this.jEv();
        if ((VideoView.a(VideoView.this) != 0) && (VideoView.b(VideoView.this) != 0))
        {
          if (VideoView.f(VideoView.this))
          {
            VideoView.e(VideoView.this).start();
            VideoView.g(VideoView.this);
          }
          if ((VideoView.h(VideoView.this) == VideoView.a(VideoView.this)) && (VideoView.i(VideoView.this) == VideoView.b(VideoView.this)))
          {
            if (VideoView.j(VideoView.this) != 0)
            {
              VideoView.e(VideoView.this).seekTo(VideoView.j(VideoView.this));
              VideoView.k(VideoView.this);
            }
            if ((VideoView.f(VideoView.this)) || (VideoView.this.isPlaying()) || (VideoView.j(VideoView.this) != 0) || (VideoView.this.getCurrentPosition() <= 0)) {}
          }
        }
        for (;;)
        {
          if ((VideoView.e(VideoView.this).isPlaying()) && (VideoView.l(VideoView.this) != null))
          {
            VideoView.l(VideoView.this);
            VideoView.m(VideoView.this);
          }
          AppMethodBeat.o(39491);
          return;
          if (VideoView.j(VideoView.this) != 0)
          {
            VideoView.e(VideoView.this).seekTo(VideoView.j(VideoView.this));
            VideoView.k(VideoView.this);
          }
          if (VideoView.f(VideoView.this))
          {
            VideoView.e(VideoView.this).start();
            VideoView.g(VideoView.this);
          }
        }
      }
    };
    this.sFi = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(39492);
        if (VideoView.n(VideoView.this) != null) {
          VideoView.n(VideoView.this).onCompletion(VideoView.e(VideoView.this));
        }
        AppMethodBeat.o(39492);
      }
    };
    this.sFl = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39493);
        Log.d("MicroMsg.VideoView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        if ((VideoView.o(VideoView.this) != null) && (VideoView.o(VideoView.this).onError(VideoView.e(VideoView.this), paramAnonymousInt1, paramAnonymousInt2)))
        {
          AppMethodBeat.o(39493);
          return true;
        }
        VideoView.this.getWindowToken();
        AppMethodBeat.o(39493);
        return true;
      }
    };
    this.sFm = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(39494);
        VideoView.c(VideoView.this, paramAnonymousInt);
        AppMethodBeat.o(39494);
      }
    };
    this.Yux = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(39495);
        VideoView.d(VideoView.this, paramAnonymousInt2);
        VideoView.e(VideoView.this, paramAnonymousInt3);
        if ((VideoView.e(VideoView.this) != null) && (VideoView.p(VideoView.this)) && (VideoView.a(VideoView.this) == paramAnonymousInt2) && (VideoView.b(VideoView.this) == paramAnonymousInt3))
        {
          if (VideoView.j(VideoView.this) != 0)
          {
            VideoView.e(VideoView.this).seekTo(VideoView.j(VideoView.this));
            VideoView.k(VideoView.this);
          }
          VideoView.e(VideoView.this).start();
        }
        AppMethodBeat.o(39495);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(39496);
        VideoView.a(VideoView.this, paramAnonymousSurfaceHolder);
        VideoView.q(VideoView.this);
        AppMethodBeat.o(39496);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(39497);
        VideoView.a(VideoView.this, null);
        if (VideoView.e(VideoView.this) != null)
        {
          VideoView.e(VideoView.this).reset();
          VideoView.e(VideoView.this).release();
          VideoView.r(VideoView.this);
        }
        AppMethodBeat.o(39497);
      }
    };
    this.mContext = paramContext;
    jEw();
    AppMethodBeat.o(39500);
  }
  
  private void cxo()
  {
    AppMethodBeat.i(39506);
    if ((this.sIs == null) || (this.rsd == null))
    {
      AppMethodBeat.o(39506);
      return;
    }
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    this.mContext.sendBroadcast(localIntent);
    if (this.sFf != null)
    {
      this.sFf.reset();
      this.sFf.release();
      this.sFf = null;
    }
    try
    {
      this.sFf = new k();
      this.sFf.setOnPreparedListener(this.sFg);
      this.sFf.setOnVideoSizeChangedListener(this.sFh);
      this.sIt = false;
      Log.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
      this.cam = -1;
      this.sFf.setOnCompletionListener(this.sFi);
      this.sFf.setOnErrorListener(this.sFl);
      this.sFf.setOnBufferingUpdateListener(this.sFm);
      this.afRt = 0;
      this.sFf.setDataSource(this.sIs);
      this.sFf.setDisplay(this.rsd);
      this.sFf.setAudioStreamType(3);
      this.sFf.setScreenOnWhilePlaying(true);
      this.sFf.prepareAsync();
      this.mVideoHeight = this.sFf.getVideoHeight();
      this.mVideoWidth = this.sFf.getVideoWidth();
      AppMethodBeat.o(39506);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(39506);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(39506);
    }
  }
  
  private void jEw()
  {
    AppMethodBeat.i(39501);
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.Yux);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    AppMethodBeat.o(39501);
  }
  
  public int getAudioSessionId()
  {
    return 0;
  }
  
  public int getBufferPercentage()
  {
    if (this.sFf != null) {
      return this.afRt;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(39508);
    if ((this.sFf != null) && (this.sIt))
    {
      int i = this.sFf.getCurrentPosition();
      AppMethodBeat.o(39508);
      return i;
    }
    AppMethodBeat.o(39508);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(39507);
    if ((this.sFf != null) && (this.sIt))
    {
      if (this.cam > 0)
      {
        i = this.cam;
        AppMethodBeat.o(39507);
        return i;
      }
      this.cam = this.sFf.getDuration();
      i = this.cam;
      AppMethodBeat.o(39507);
      return i;
    }
    this.cam = -1;
    int i = this.cam;
    AppMethodBeat.o(39507);
    return i;
  }
  
  public int getVideoHeight()
  {
    return this.mVideoHeight;
  }
  
  public int getVideoTimeLeft()
  {
    AppMethodBeat.i(39505);
    if (this.sFf == null)
    {
      AppMethodBeat.o(39505);
      return 0;
    }
    int i = this.sFf.getDuration();
    int j = this.sFf.getCurrentPosition();
    AppMethodBeat.o(39505);
    return i - j;
  }
  
  public String getVideoURI()
  {
    return this.sIs;
  }
  
  public int getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(39509);
    if ((this.sFf != null) && (this.sIt))
    {
      boolean bool = this.sFf.isPlaying();
      AppMethodBeat.o(39509);
      return bool;
    }
    AppMethodBeat.o(39509);
    return false;
  }
  
  public final void jEv()
  {
    AppMethodBeat.i(39498);
    if ((this.mVideoHeight == 0) || (this.mVideoWidth == 0))
    {
      AppMethodBeat.o(39498);
      return;
    }
    int k = this.mVideoWidth;
    int m = this.mVideoHeight;
    Log.v("MicroMsg.VideoView", "video size before:" + k + "   " + m);
    Log.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
    int i = getWidth();
    int j = getHeight();
    if (i <= 0) {
      i = k;
    }
    for (;;)
    {
      if (j <= 0) {
        j = m;
      }
      for (;;)
      {
        float f1 = i * 1.0F / k;
        float f2 = j * 1.0F / m;
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
        if (f1 > f2) {
          localLayoutParams.width = ((int)(k * f2));
        }
        for (localLayoutParams.height = j;; localLayoutParams.height = ((int)(m * f1)))
        {
          localLayoutParams.addRule(13);
          setLayoutParams(localLayoutParams);
          invalidate();
          Log.v("MicroMsg.VideoView", "video size after:" + this.sFf.getVideoWidth() + "   " + this.sFf.getVideoHeight());
          Log.v("MicroMsg.VideoView", "layout size after:" + localLayoutParams.width + "   " + localLayoutParams.height);
          AppMethodBeat.o(39498);
          return;
          localLayoutParams.width = i;
        }
      }
    }
  }
  
  public final void jEx()
  {
    AppMethodBeat.i(39504);
    if (this.sFf != null)
    {
      this.sFf.stop();
      this.sFf.release();
      this.sFf = null;
    }
    AppMethodBeat.o(39504);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(39503);
    if (this.sFf != null) {
      this.sFf.setLooping(paramBoolean);
    }
    AppMethodBeat.o(39503);
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.pee = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.pef = paramOnErrorListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.afRs = paramOnPreparedListener;
  }
  
  public void setVideoURI(String paramString)
  {
    AppMethodBeat.i(39502);
    this.sIs = paramString;
    this.eDv = false;
    this.afRu = 0;
    cxo();
    requestLayout();
    invalidate();
    AppMethodBeat.o(39502);
  }
  
  public void setVideoViewIm(a parama)
  {
    this.afRv = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView
 * JD-Core Version:    0.7.0.1
 */