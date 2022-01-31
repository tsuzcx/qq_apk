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
import com.tencent.mm.sdk.platformtools.ab;

public class VideoSurfaceView
  extends SurfaceView
  implements e
{
  private boolean bHF;
  private MediaPlayer bIo;
  MediaPlayer.OnPreparedListener bIp;
  MediaPlayer.OnVideoSizeChangedListener bIq;
  private MediaPlayer.OnCompletionListener bIr;
  private MediaPlayer.OnErrorListener bIu;
  private boolean efg;
  private e.a lxA;
  private int mDuration;
  private int mVideoHeight;
  private int mVideoWidth;
  private SurfaceHolder taW;
  private String wfP;
  private boolean wfQ;
  SurfaceHolder.Callback wfR;
  
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
    AppMethodBeat.i(70447);
    this.taW = null;
    this.bIo = null;
    this.bIq = new VideoSurfaceView.1(this);
    this.bIp = new VideoSurfaceView.2(this);
    this.bIr = new VideoSurfaceView.3(this);
    this.bIu = new VideoSurfaceView.4(this);
    this.wfR = new VideoSurfaceView.5(this);
    this.efg = false;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    getHolder().addCallback(this.wfR);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    AppMethodBeat.o(70447);
  }
  
  private void boV()
  {
    AppMethodBeat.i(70450);
    if ((this.wfP == null) || (this.taW == null))
    {
      AppMethodBeat.o(70450);
      return;
    }
    if (this.bIo != null)
    {
      this.bIo.stop();
      this.bIo.release();
      this.bIo = null;
    }
    try
    {
      this.bIo = new k();
      this.bIo.setOnPreparedListener(this.bIp);
      this.bIo.setOnVideoSizeChangedListener(this.bIq);
      this.wfQ = false;
      ab.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
      this.mDuration = -1;
      this.bIo.setOnCompletionListener(this.bIr);
      this.bIo.setOnErrorListener(this.bIu);
      this.bIo.setDataSource(this.wfP);
      this.bIo.setDisplay(this.taW);
      this.bIo.setAudioStreamType(3);
      this.bIo.setScreenOnWhilePlaying(true);
      this.bIo.prepareAsync();
      this.mVideoHeight = this.bIo.getVideoHeight();
      this.mVideoWidth = this.bIo.getVideoWidth();
      setMute(this.efg);
      AppMethodBeat.o(70450);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.VideoSurfaceView", localException, "prepare async error %s", new Object[] { localException.getMessage() });
      if (this.lxA != null) {
        this.lxA.onError(-1, -1);
      }
      AppMethodBeat.o(70450);
    }
  }
  
  public final void A(double paramDouble)
  {
    AppMethodBeat.i(70458);
    if (this.bIo != null)
    {
      ab.d("MicroMsg.VideoSurfaceView", "seek to time: ".concat(String.valueOf(paramDouble)));
      this.bIo.seekTo((int)paramDouble);
      start();
    }
    AppMethodBeat.o(70458);
  }
  
  public final void e(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(70460);
    A(paramDouble);
    AppMethodBeat.o(70460);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(70453);
    if ((this.bIo != null) && (this.wfQ))
    {
      int i = this.bIo.getCurrentPosition();
      AppMethodBeat.o(70453);
      return i;
    }
    AppMethodBeat.o(70453);
    return 0;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(70452);
    if ((this.bIo != null) && (this.wfQ))
    {
      if (this.mDuration > 0)
      {
        i = this.mDuration;
        AppMethodBeat.o(70452);
        return i;
      }
      this.mDuration = this.bIo.getDuration();
      i = this.mDuration;
      AppMethodBeat.o(70452);
      return i;
    }
    this.mDuration = -1;
    int i = this.mDuration;
    AppMethodBeat.o(70452);
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
    return this.wfP;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(70454);
    if ((this.bIo != null) && (this.wfQ))
    {
      boolean bool = this.bIo.isPlaying();
      AppMethodBeat.o(70454);
      return bool;
    }
    AppMethodBeat.o(70454);
    return false;
  }
  
  public final void onDetach() {}
  
  public final void pause()
  {
    AppMethodBeat.i(70451);
    if ((this.bIo != null) && (this.wfQ) && (this.bIo.isPlaying())) {
      this.bIo.pause();
    }
    this.bHF = false;
    AppMethodBeat.o(70451);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean) {}
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(70455);
    if (this.bIo != null) {
      this.bIo.setLooping(paramBoolean);
    }
    AppMethodBeat.o(70455);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(70459);
    this.efg = paramBoolean;
    if (this.bIo != null)
    {
      if (this.efg)
      {
        this.bIo.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(70459);
        return;
      }
      this.bIo.setVolume(0.5F, 0.5F);
    }
    AppMethodBeat.o(70459);
  }
  
  public void setOnInfoCallback(e.b paramb) {}
  
  public void setOnSeekCompleteCallback(e.c paramc) {}
  
  public void setOnSurfaceCallback(e.d paramd) {}
  
  public void setOneTimeVideoTextureUpdateCallback(e.e parame) {}
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(e.a parama)
  {
    this.lxA = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(70448);
    this.wfP = paramString;
    this.bHF = false;
    boV();
    requestLayout();
    AppMethodBeat.o(70448);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(70456);
    if ((this.bIo != null) && (this.wfQ)) {
      this.bIo.start();
    }
    for (this.bHF = false;; this.bHF = true)
    {
      AppMethodBeat.o(70456);
      return true;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(70449);
    if (this.bIo != null)
    {
      this.bIo.stop();
      this.bIo.release();
      this.bIo = null;
    }
    AppMethodBeat.o(70449);
  }
  
  public final boolean w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(70457);
    paramBoolean = start();
    AppMethodBeat.o(70457);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView
 * JD-Core Version:    0.7.0.1
 */