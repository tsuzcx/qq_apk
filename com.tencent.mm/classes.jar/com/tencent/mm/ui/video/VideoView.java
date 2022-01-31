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
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public class VideoView
  extends SurfaceView
{
  private MediaPlayer.OnCompletionListener eKv;
  private MediaPlayer.OnErrorListener eKw;
  public boolean gHF;
  public MediaPlayer gHZ = null;
  MediaPlayer.OnPreparedListener gIa = new VideoView.2(this);
  MediaPlayer.OnVideoSizeChangedListener gIb = new VideoView.1(this);
  private MediaPlayer.OnCompletionListener gIc = new VideoView.3(this);
  private MediaPlayer.OnErrorListener gIf = new VideoView.4(this);
  private MediaPlayer.OnBufferingUpdateListener gIg = new VideoView.5(this);
  private Context mContext;
  private int mDuration;
  private int mVideoHeight;
  private int mVideoWidth;
  private SurfaceHolder pzi = null;
  private String snu;
  public boolean snv;
  SurfaceHolder.Callback snw = new SurfaceHolder.Callback()
  {
    public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      VideoView.d(VideoView.this, paramAnonymousInt2);
      VideoView.e(VideoView.this, paramAnonymousInt3);
      if ((VideoView.e(VideoView.this) != null) && (VideoView.n(VideoView.this)) && (VideoView.a(VideoView.this) == paramAnonymousInt2) && (VideoView.b(VideoView.this) == paramAnonymousInt3))
      {
        if (VideoView.j(VideoView.this) != 0)
        {
          VideoView.e(VideoView.this).seekTo(VideoView.j(VideoView.this));
          VideoView.k(VideoView.this);
        }
        VideoView.e(VideoView.this).start();
      }
    }
    
    public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      VideoView.a(VideoView.this, paramAnonymousSurfaceHolder);
      VideoView.o(VideoView.this);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      VideoView.a(VideoView.this, null);
      if (VideoView.e(VideoView.this) != null)
      {
        VideoView.e(VideoView.this).reset();
        VideoView.e(VideoView.this).release();
        VideoView.p(VideoView.this);
      }
    }
  };
  private int wiA;
  private int wiB;
  private a wiC;
  private int wix;
  private int wiy;
  private MediaPlayer.OnPreparedListener wiz;
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.mContext = paramContext;
    cJM();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    cJM();
  }
  
  private void aKM()
  {
    if ((this.snu == null) || (this.pzi == null)) {
      return;
    }
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    this.mContext.sendBroadcast(localIntent);
    if (this.gHZ != null)
    {
      this.gHZ.reset();
      this.gHZ.release();
      this.gHZ = null;
    }
    try
    {
      this.gHZ = new j();
      this.gHZ.setOnPreparedListener(this.gIa);
      this.gHZ.setOnVideoSizeChangedListener(this.gIb);
      this.snv = false;
      y.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
      this.mDuration = -1;
      this.gHZ.setOnCompletionListener(this.gIc);
      this.gHZ.setOnErrorListener(this.gIf);
      this.gHZ.setOnBufferingUpdateListener(this.gIg);
      this.wiA = 0;
      this.gHZ.setDataSource(this.snu);
      this.gHZ.setDisplay(this.pzi);
      this.gHZ.setAudioStreamType(3);
      this.gHZ.setScreenOnWhilePlaying(true);
      this.gHZ.prepareAsync();
      this.mVideoHeight = this.gHZ.getVideoHeight();
      this.mVideoWidth = this.gHZ.getVideoWidth();
      return;
    }
    catch (IOException localIOException) {}catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  private void cJM()
  {
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.snw);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
  }
  
  public final void cJL()
  {
    if ((this.mVideoHeight == 0) || (this.mVideoWidth == 0)) {
      return;
    }
    int k = this.mVideoWidth;
    int m = this.mVideoHeight;
    y.v("MicroMsg.VideoView", "video size before:" + k + "   " + m);
    y.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
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
          y.v("MicroMsg.VideoView", "video size after:" + this.gHZ.getVideoWidth() + "   " + this.gHZ.getVideoHeight());
          y.v("MicroMsg.VideoView", "layout size after:" + localLayoutParams.width + "   " + localLayoutParams.height);
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
    if (this.gHZ != null) {
      return this.wiA;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if ((this.gHZ != null) && (this.snv)) {
      return this.gHZ.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if ((this.gHZ != null) && (this.snv))
    {
      if (this.mDuration > 0) {
        return this.mDuration;
      }
      this.mDuration = this.gHZ.getDuration();
      return this.mDuration;
    }
    this.mDuration = -1;
    return this.mDuration;
  }
  
  public int getVideoHeight()
  {
    return this.mVideoHeight;
  }
  
  public int getVideoTimeLeft()
  {
    if (this.gHZ == null) {
      return 0;
    }
    return this.gHZ.getDuration() - this.gHZ.getCurrentPosition();
  }
  
  public String getVideoURI()
  {
    return this.snu;
  }
  
  public int getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public final boolean isPlaying()
  {
    if ((this.gHZ != null) && (this.snv)) {
      return this.gHZ.isPlaying();
    }
    return false;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    if (this.gHZ != null) {
      this.gHZ.setLooping(paramBoolean);
    }
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.eKv = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.eKw = paramOnErrorListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.wiz = paramOnPreparedListener;
  }
  
  public void setVideoURI(String paramString)
  {
    this.snu = paramString;
    this.gHF = false;
    this.wiB = 0;
    aKM();
    requestLayout();
    invalidate();
  }
  
  public void setVideoViewIm(a parama)
  {
    this.wiC = parama;
  }
  
  public final void stopPlayback()
  {
    if (this.gHZ != null)
    {
      this.gHZ.stop();
      this.gHZ.release();
      this.gHZ = null;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView
 * JD-Core Version:    0.7.0.1
 */