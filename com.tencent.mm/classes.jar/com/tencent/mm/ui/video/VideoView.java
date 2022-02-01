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
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public class VideoView
  extends SurfaceView
{
  SurfaceHolder.Callback DGd;
  private MediaPlayer.OnPreparedListener IYm;
  private int IYn;
  private int IYo;
  private a IYp;
  private int asf;
  public boolean ckh;
  private MediaPlayer.OnCompletionListener idp;
  private MediaPlayer.OnErrorListener idq;
  private SurfaceHolder jSi;
  public MediaPlayer kTD;
  MediaPlayer.OnPreparedListener kTE;
  MediaPlayer.OnVideoSizeChangedListener kTF;
  private MediaPlayer.OnCompletionListener kTG;
  private MediaPlayer.OnErrorListener kTJ;
  private MediaPlayer.OnBufferingUpdateListener kTK;
  private String kVA;
  public boolean kVB;
  private Context mContext;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private int mVideoHeight;
  private int mVideoWidth;
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(39499);
    this.mContext = paramContext;
    fuA();
    AppMethodBeat.o(39499);
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(39500);
    this.jSi = null;
    this.kTD = null;
    this.kTF = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39490);
        VideoView.a(VideoView.this, paramAnonymousMediaPlayer.getVideoWidth());
        VideoView.b(VideoView.this, paramAnonymousMediaPlayer.getVideoHeight());
        ac.v("MicroMsg.VideoView", "on size change size:( " + VideoView.a(VideoView.this) + " , " + VideoView.b(VideoView.this) + " )");
        VideoView.this.fuz();
        if (VideoView.a(VideoView.this) != 0) {
          VideoView.b(VideoView.this);
        }
        AppMethodBeat.o(39490);
      }
    };
    this.kTE = new MediaPlayer.OnPreparedListener()
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
        VideoView.this.fuz();
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
    this.kTG = new MediaPlayer.OnCompletionListener()
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
    this.kTJ = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(39493);
        ac.d("MicroMsg.VideoView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
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
    this.kTK = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(39494);
        VideoView.c(VideoView.this, paramAnonymousInt);
        AppMethodBeat.o(39494);
      }
    };
    this.DGd = new SurfaceHolder.Callback()
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
    fuA();
    AppMethodBeat.o(39500);
  }
  
  private void blc()
  {
    AppMethodBeat.i(39506);
    if ((this.kVA == null) || (this.jSi == null))
    {
      AppMethodBeat.o(39506);
      return;
    }
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    this.mContext.sendBroadcast(localIntent);
    if (this.kTD != null)
    {
      this.kTD.reset();
      this.kTD.release();
      this.kTD = null;
    }
    try
    {
      this.kTD = new k();
      this.kTD.setOnPreparedListener(this.kTE);
      this.kTD.setOnVideoSizeChangedListener(this.kTF);
      this.kVB = false;
      ac.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
      this.asf = -1;
      this.kTD.setOnCompletionListener(this.kTG);
      this.kTD.setOnErrorListener(this.kTJ);
      this.kTD.setOnBufferingUpdateListener(this.kTK);
      this.IYn = 0;
      this.kTD.setDataSource(this.kVA);
      this.kTD.setDisplay(this.jSi);
      this.kTD.setAudioStreamType(3);
      this.kTD.setScreenOnWhilePlaying(true);
      this.kTD.prepareAsync();
      this.mVideoHeight = this.kTD.getVideoHeight();
      this.mVideoWidth = this.kTD.getVideoWidth();
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
  
  private void fuA()
  {
    AppMethodBeat.i(39501);
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.DGd);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    AppMethodBeat.o(39501);
  }
  
  public final void fuz()
  {
    AppMethodBeat.i(39498);
    if ((this.mVideoHeight == 0) || (this.mVideoWidth == 0))
    {
      AppMethodBeat.o(39498);
      return;
    }
    int k = this.mVideoWidth;
    int m = this.mVideoHeight;
    ac.v("MicroMsg.VideoView", "video size before:" + k + "   " + m);
    ac.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
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
          ac.v("MicroMsg.VideoView", "video size after:" + this.kTD.getVideoWidth() + "   " + this.kTD.getVideoHeight());
          ac.v("MicroMsg.VideoView", "layout size after:" + localLayoutParams.width + "   " + localLayoutParams.height);
          AppMethodBeat.o(39498);
          return;
          localLayoutParams.width = i;
        }
      }
    }
  }
  
  public int getAudioSessionId()
  {
    return 0;
  }
  
  public int getBufferPercentage()
  {
    if (this.kTD != null) {
      return this.IYn;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(39508);
    if ((this.kTD != null) && (this.kVB))
    {
      int i = this.kTD.getCurrentPosition();
      AppMethodBeat.o(39508);
      return i;
    }
    AppMethodBeat.o(39508);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(39507);
    if ((this.kTD != null) && (this.kVB))
    {
      if (this.asf > 0)
      {
        i = this.asf;
        AppMethodBeat.o(39507);
        return i;
      }
      this.asf = this.kTD.getDuration();
      i = this.asf;
      AppMethodBeat.o(39507);
      return i;
    }
    this.asf = -1;
    int i = this.asf;
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
    if (this.kTD == null)
    {
      AppMethodBeat.o(39505);
      return 0;
    }
    int i = this.kTD.getDuration();
    int j = this.kTD.getCurrentPosition();
    AppMethodBeat.o(39505);
    return i - j;
  }
  
  public String getVideoURI()
  {
    return this.kVA;
  }
  
  public int getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(39509);
    if ((this.kTD != null) && (this.kVB))
    {
      boolean bool = this.kTD.isPlaying();
      AppMethodBeat.o(39509);
      return bool;
    }
    AppMethodBeat.o(39509);
    return false;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(39503);
    if (this.kTD != null) {
      this.kTD.setLooping(paramBoolean);
    }
    AppMethodBeat.o(39503);
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.idp = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.idq = paramOnErrorListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.IYm = paramOnPreparedListener;
  }
  
  public void setVideoURI(String paramString)
  {
    AppMethodBeat.i(39502);
    this.kVA = paramString;
    this.ckh = false;
    this.IYo = 0;
    blc();
    requestLayout();
    invalidate();
    AppMethodBeat.o(39502);
  }
  
  public void setVideoViewIm(a parama)
  {
    this.IYp = parama;
  }
  
  public final void stopPlayback()
  {
    AppMethodBeat.i(39504);
    if (this.kTD != null)
    {
      this.kTD.stop();
      this.kTD.release();
      this.kTD = null;
    }
    AppMethodBeat.o(39504);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView
 * JD-Core Version:    0.7.0.1
 */