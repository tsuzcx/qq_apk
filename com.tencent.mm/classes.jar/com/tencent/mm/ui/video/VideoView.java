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
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public class VideoView
  extends SurfaceView
{
  private MediaPlayer.OnPreparedListener ABr;
  private int ABs;
  private int ABt;
  private VideoView.a ABu;
  public boolean bHF;
  public MediaPlayer bIo;
  MediaPlayer.OnPreparedListener bIp;
  MediaPlayer.OnVideoSizeChangedListener bIq;
  private MediaPlayer.OnCompletionListener bIr;
  private MediaPlayer.OnErrorListener bIu;
  private MediaPlayer.OnBufferingUpdateListener bIv;
  private MediaPlayer.OnCompletionListener gab;
  private MediaPlayer.OnErrorListener gac;
  private Context mContext;
  private int mDuration;
  private int mSurfaceHeight;
  private int mSurfaceWidth;
  private int mVideoHeight;
  private int mVideoWidth;
  private SurfaceHolder taW;
  private String wfP;
  public boolean wfQ;
  SurfaceHolder.Callback wfR;
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(35292);
    this.mContext = paramContext;
    dOB();
    AppMethodBeat.o(35292);
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(35293);
    this.taW = null;
    this.bIo = null;
    this.bIq = new VideoView.1(this);
    this.bIp = new VideoView.2(this);
    this.bIr = new VideoView.3(this);
    this.bIu = new VideoView.4(this);
    this.bIv = new VideoView.5(this);
    this.wfR = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(35288);
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
        AppMethodBeat.o(35288);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(35289);
        VideoView.a(VideoView.this, paramAnonymousSurfaceHolder);
        VideoView.q(VideoView.this);
        AppMethodBeat.o(35289);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(35290);
        VideoView.a(VideoView.this, null);
        if (VideoView.e(VideoView.this) != null)
        {
          VideoView.e(VideoView.this).reset();
          VideoView.e(VideoView.this).release();
          VideoView.r(VideoView.this);
        }
        AppMethodBeat.o(35290);
      }
    };
    this.mContext = paramContext;
    dOB();
    AppMethodBeat.o(35293);
  }
  
  private void boV()
  {
    AppMethodBeat.i(35299);
    if ((this.wfP == null) || (this.taW == null))
    {
      AppMethodBeat.o(35299);
      return;
    }
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    this.mContext.sendBroadcast(localIntent);
    if (this.bIo != null)
    {
      this.bIo.reset();
      this.bIo.release();
      this.bIo = null;
    }
    try
    {
      this.bIo = new k();
      this.bIo.setOnPreparedListener(this.bIp);
      this.bIo.setOnVideoSizeChangedListener(this.bIq);
      this.wfQ = false;
      ab.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
      this.mDuration = -1;
      this.bIo.setOnCompletionListener(this.bIr);
      this.bIo.setOnErrorListener(this.bIu);
      this.bIo.setOnBufferingUpdateListener(this.bIv);
      this.ABs = 0;
      this.bIo.setDataSource(this.wfP);
      this.bIo.setDisplay(this.taW);
      this.bIo.setAudioStreamType(3);
      this.bIo.setScreenOnWhilePlaying(true);
      this.bIo.prepareAsync();
      this.mVideoHeight = this.bIo.getVideoHeight();
      this.mVideoWidth = this.bIo.getVideoWidth();
      AppMethodBeat.o(35299);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(35299);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      AppMethodBeat.o(35299);
    }
  }
  
  private void dOB()
  {
    AppMethodBeat.i(35294);
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.wfR);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    AppMethodBeat.o(35294);
  }
  
  public final void dOA()
  {
    AppMethodBeat.i(35291);
    if ((this.mVideoHeight == 0) || (this.mVideoWidth == 0))
    {
      AppMethodBeat.o(35291);
      return;
    }
    int k = this.mVideoWidth;
    int m = this.mVideoHeight;
    ab.v("MicroMsg.VideoView", "video size before:" + k + "   " + m);
    ab.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
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
          ab.v("MicroMsg.VideoView", "video size after:" + this.bIo.getVideoWidth() + "   " + this.bIo.getVideoHeight());
          ab.v("MicroMsg.VideoView", "layout size after:" + localLayoutParams.width + "   " + localLayoutParams.height);
          AppMethodBeat.o(35291);
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
    if (this.bIo != null) {
      return this.ABs;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(35301);
    if ((this.bIo != null) && (this.wfQ))
    {
      int i = this.bIo.getCurrentPosition();
      AppMethodBeat.o(35301);
      return i;
    }
    AppMethodBeat.o(35301);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(35300);
    if ((this.bIo != null) && (this.wfQ))
    {
      if (this.mDuration > 0)
      {
        i = this.mDuration;
        AppMethodBeat.o(35300);
        return i;
      }
      this.mDuration = this.bIo.getDuration();
      i = this.mDuration;
      AppMethodBeat.o(35300);
      return i;
    }
    this.mDuration = -1;
    int i = this.mDuration;
    AppMethodBeat.o(35300);
    return i;
  }
  
  public int getVideoHeight()
  {
    return this.mVideoHeight;
  }
  
  public int getVideoTimeLeft()
  {
    AppMethodBeat.i(35298);
    if (this.bIo == null)
    {
      AppMethodBeat.o(35298);
      return 0;
    }
    int i = this.bIo.getDuration();
    int j = this.bIo.getCurrentPosition();
    AppMethodBeat.o(35298);
    return i - j;
  }
  
  public String getVideoURI()
  {
    return this.wfP;
  }
  
  public int getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(35302);
    if ((this.bIo != null) && (this.wfQ))
    {
      boolean bool = this.bIo.isPlaying();
      AppMethodBeat.o(35302);
      return bool;
    }
    AppMethodBeat.o(35302);
    return false;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(35296);
    if (this.bIo != null) {
      this.bIo.setLooping(paramBoolean);
    }
    AppMethodBeat.o(35296);
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.gab = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.gac = paramOnErrorListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.ABr = paramOnPreparedListener;
  }
  
  public void setVideoURI(String paramString)
  {
    AppMethodBeat.i(35295);
    this.wfP = paramString;
    this.bHF = false;
    this.ABt = 0;
    boV();
    requestLayout();
    invalidate();
    AppMethodBeat.o(35295);
  }
  
  public void setVideoViewIm(VideoView.a parama)
  {
    this.ABu = parama;
  }
  
  public final void stopPlayback()
  {
    AppMethodBeat.i(35297);
    if (this.bIo != null)
    {
      this.bIo.stop();
      this.bIo.release();
      this.bIo = null;
    }
    AppMethodBeat.o(35297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView
 * JD-Core Version:    0.7.0.1
 */