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
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.y;

public class VideoSurfaceView
  extends SurfaceView
  implements f
{
  private boolean dnJ = false;
  private boolean gHF;
  private MediaPlayer gHZ = null;
  MediaPlayer.OnPreparedListener gIa = new VideoSurfaceView.2(this);
  MediaPlayer.OnVideoSizeChangedListener gIb = new VideoSurfaceView.1(this);
  private MediaPlayer.OnCompletionListener gIc = new VideoSurfaceView.3(this);
  private MediaPlayer.OnErrorListener gIf = new VideoSurfaceView.4(this);
  private f.a joM;
  private int mDuration;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private SurfaceHolder pzi = null;
  private String snu;
  private boolean snv;
  SurfaceHolder.Callback snw = new VideoSurfaceView.5(this);
  
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
    getHolder().addCallback(this.snw);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
  }
  
  private void aKM()
  {
    if ((this.snu == null) || (this.pzi == null)) {}
    do
    {
      return;
      if (this.gHZ != null)
      {
        this.gHZ.stop();
        this.gHZ.release();
        this.gHZ = null;
      }
      try
      {
        this.gHZ = new j();
        this.gHZ.setOnPreparedListener(this.gIa);
        this.gHZ.setOnVideoSizeChangedListener(this.gIb);
        this.snv = false;
        y.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
        this.mDuration = -1;
        this.gHZ.setOnCompletionListener(this.gIc);
        this.gHZ.setOnErrorListener(this.gIf);
        this.gHZ.setDataSource(this.snu);
        this.gHZ.setDisplay(this.pzi);
        this.gHZ.setAudioStreamType(3);
        this.gHZ.setScreenOnWhilePlaying(true);
        this.gHZ.prepareAsync();
        this.mVideoHeight = this.gHZ.getVideoHeight();
        this.mVideoWidth = this.gHZ.getVideoWidth();
        setMute(this.dnJ);
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.VideoSurfaceView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      }
    } while (this.joM == null);
    this.joM.onError(-1, -1);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    x(paramDouble);
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
    return this.snu;
  }
  
  public final boolean isPlaying()
  {
    if ((this.gHZ != null) && (this.snv)) {
      return this.gHZ.isPlaying();
    }
    return false;
  }
  
  public final void onDetach() {}
  
  public final void pause()
  {
    if ((this.gHZ != null) && (this.snv) && (this.gHZ.isPlaying())) {
      this.gHZ.pause();
    }
    this.gHF = false;
  }
  
  public final boolean s(Context paramContext, boolean paramBoolean)
  {
    return start();
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.gHZ != null) {
      this.gHZ.setLooping(paramBoolean);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.dnJ = paramBoolean;
    if (this.gHZ != null)
    {
      if (this.dnJ) {
        this.gHZ.setVolume(0.0F, 0.0F);
      }
    }
    else {
      return;
    }
    this.gHZ.setVolume(0.5F, 0.5F);
  }
  
  public void setOnInfoCallback(f.b paramb) {}
  
  public void setOnSeekCompleteCallback(f.c paramc) {}
  
  public void setOnSurfaceCallback(f.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(f.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(f.a parama)
  {
    this.joM = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    this.snu = paramString;
    this.gHF = false;
    aKM();
    requestLayout();
  }
  
  public final boolean start()
  {
    if ((this.gHZ != null) && (this.snv))
    {
      this.gHZ.start();
      this.gHF = false;
      return true;
    }
    this.gHF = true;
    return true;
  }
  
  public final void stop()
  {
    if (this.gHZ != null)
    {
      this.gHZ.stop();
      this.gHZ.release();
      this.gHZ = null;
    }
  }
  
  public final void x(double paramDouble)
  {
    if (this.gHZ != null)
    {
      y.d("MicroMsg.VideoSurfaceView", "seek to time: " + paramDouble);
      this.gHZ.seekTo((int)paramDouble);
      start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView
 * JD-Core Version:    0.7.0.1
 */