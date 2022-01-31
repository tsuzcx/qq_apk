package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView
  extends MMTextureView
  implements f
{
  private float auT = -1.0F;
  private boolean dnJ = false;
  private boolean eFF = false;
  private boolean gHF;
  private int gHR = 0;
  private int gHS = 0;
  private MediaPlayer gHZ = null;
  MediaPlayer.OnPreparedListener gIa = new VideoTextureView.3(this);
  MediaPlayer.OnVideoSizeChangedListener gIb = new VideoTextureView.2(this);
  private MediaPlayer.OnCompletionListener gIc = new VideoTextureView.7(this);
  private MediaPlayer.OnErrorListener gIf = new VideoTextureView.8(this);
  private long joK = 0L;
  private f.a joM;
  private f.d joP;
  private boolean joT = false;
  private boolean joU = false;
  private int mDuration;
  private Surface mSurface = null;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private int snA = 0;
  private MediaPlayer.OnSeekCompleteListener snB = new VideoTextureView.4(this);
  private MediaPlayer.OnBufferingUpdateListener snC = new VideoTextureView.5(this);
  private MediaPlayer.OnInfoListener snD = new VideoTextureView.6(this);
  private boolean snE = false;
  private boolean snh = false;
  private f.e sni;
  private f.c snj;
  TextureView.SurfaceTextureListener snk = new VideoTextureView.9(this);
  private p snl = new p();
  private String snu;
  private boolean snv;
  private f.b sny;
  private long snz = 0L;
  private long startTime = 0L;
  
  public VideoTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSurfaceTextureListener(this.snk);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void aKM()
  {
    if ((bk.bl(this.snu)) || (this.mSurface == null)) {}
    do
    {
      return;
      cos();
      y.i("MicroMsg.VideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.snu });
      try
      {
        this.gHZ = new j();
        this.gHZ.setOnPreparedListener(this.gIa);
        this.gHZ.setOnVideoSizeChangedListener(this.gIb);
        this.snv = false;
        y.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
        this.mDuration = -1;
        this.snA = 0;
        this.gHZ.setOnCompletionListener(this.gIc);
        this.gHZ.setOnErrorListener(this.gIf);
        this.gHZ.setOnSeekCompleteListener(this.snB);
        this.gHZ.setOnBufferingUpdateListener(this.snC);
        this.gHZ.setOnInfoListener(this.snD);
        this.gHZ.setDataSource(this.snu);
        this.gHZ.setSurface(this.mSurface);
        this.gHZ.setAudioStreamType(3);
        this.gHZ.setScreenOnWhilePlaying(true);
        this.gHZ.prepareAsync();
        this.mVideoHeight = this.gHZ.getVideoHeight();
        this.mVideoWidth = this.gHZ.getVideoWidth();
        setMute(this.dnJ);
        aj(this.auT);
        y.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.gHZ.hashCode()) });
        return;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.VideoTextureView", localException, "prepare async error path", new Object[0]);
      }
    } while (this.joM == null);
    this.joM.onError(-1, -1);
  }
  
  private boolean aL(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      if ((this.gHZ != null) && (d.gF(23)))
      {
        PlaybackParams localPlaybackParams2 = this.gHZ.getPlaybackParams();
        PlaybackParams localPlaybackParams1 = localPlaybackParams2;
        if (localPlaybackParams2 == null) {
          localPlaybackParams1 = new PlaybackParams();
        }
        this.gHZ.setPlaybackParams(localPlaybackParams1.setSpeed(paramFloat));
      }
      return true;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.VideoTextureView", localException, "%s handle play rate error", new Object[] { Integer.valueOf(hashCode()) });
    }
    return false;
  }
  
  private void cos()
  {
    boolean bool1 = true;
    int i = hashCode();
    boolean bool2 = this.snv;
    if (this.gHZ == null) {}
    for (;;)
    {
      y.i("MicroMsg.VideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.gHZ != null)
      {
        this.gHZ.setOnErrorListener(null);
        this.gHZ.setOnVideoSizeChangedListener(null);
      }
      try
      {
        this.gHZ.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.gHZ.reset();
            this.gHZ.release();
            this.gHZ = null;
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            y.printErrStackTrace("MicroMsg.VideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.VideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  public final boolean aj(float paramFloat)
  {
    if (paramFloat <= 0.0F) {}
    do
    {
      return false;
      this.auT = paramFloat;
    } while (!d.gF(23));
    return aL(this.auT);
  }
  
  public final void biz()
  {
    if ((this.gHZ != null) && (this.snv) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      y.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.snE = true;
      this.gHZ.setVolume(0.0F, 0.0F);
      this.gHZ.start();
    }
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    x(paramDouble);
    this.gHF = paramBoolean;
  }
  
  public int getCurrentPosition()
  {
    if ((this.gHZ != null) && (this.snv)) {
      return this.gHZ.getCurrentPosition();
    }
    if (this.gHZ == null) {
      return -1;
    }
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.snA;
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
    return this.joK;
  }
  
  public String getVideoPath()
  {
    return this.snu;
  }
  
  public final boolean isPlaying()
  {
    if ((this.gHZ != null) && (this.snv) && (!this.joU)) {}
    for (boolean bool = this.gHZ.isPlaying();; bool = false)
    {
      y.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.joU), Boolean.valueOf(this.snv) });
      return bool;
    }
  }
  
  public final void onDetach() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.mVideoWidth;
    int j = this.mVideoHeight;
    this.snl.B(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.snl.gHT, this.snl.gHU);
  }
  
  public final void pause()
  {
    if ((this.gHZ != null) && (this.snv) && (this.gHZ.isPlaying()))
    {
      y.d("MicroMsg.VideoTextureView", "pause video.");
      this.gHZ.pause();
    }
    this.gHF = false;
  }
  
  public final boolean s(Context paramContext, boolean paramBoolean)
  {
    return start();
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.snh = paramBoolean;
    this.snl.snh = this.snh;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    if (this.gHZ != null) {
      this.gHZ.setLooping(paramBoolean);
    }
    this.eFF = true;
  }
  
  public void setMute(boolean paramBoolean)
  {
    y.i("MicroMsg.VideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
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
    this.gHZ.setVolume(1.0F, 1.0F);
  }
  
  public void setOnInfoCallback(f.b paramb)
  {
    this.sny = paramb;
  }
  
  public void setOnSeekCompleteCallback(f.c paramc)
  {
    this.snj = paramc;
  }
  
  public void setOnSurfaceCallback(f.d paramd)
  {
    this.joP = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(f.e parame)
  {
    this.sni = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(h.d paramd)
  {
    this.snl.setScaleType(paramd);
    requestLayout();
  }
  
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
    if (this.mSurface == null)
    {
      y.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.joT = true;
      this.gHF = true;
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bk.UX();; l = this.startTime)
    {
      this.startTime = l;
      y.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.snv), Boolean.valueOf(this.joU) });
      if ((this.gHZ == null) || (!this.snv)) {
        break;
      }
      if (this.joU)
      {
        this.joU = false;
        setMute(this.dnJ);
      }
      this.gHZ.start();
      this.gHF = true;
      return true;
    }
    if ((this.gHZ == null) && (this.snv))
    {
      this.gHF = true;
      aKM();
      requestLayout();
      return true;
    }
    this.gHF = true;
    return false;
  }
  
  public final void stop()
  {
    long l1;
    long l3;
    if (this.snz > 0L)
    {
      l1 = this.snz - this.startTime;
      l3 = bk.UX() - this.startTime;
      if (l1 <= l3) {
        break label512;
      }
    }
    label512:
    for (long l2 = l3;; l2 = l1)
    {
      int j = (int)l2 * 1000;
      int i = j;
      if (j > getDuration()) {
        i = getDuration();
      }
      y.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.joM != null) {
        this.joM.cv(i, getDuration());
      }
      cos();
      this.snl.reset();
      try
      {
        if ((this.mSurface != null) && (this.snv))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            y.i("MicroMsg.VideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
            EGL10 localEGL10 = (EGL10)EGLContext.getEGL();
            EGLDisplay localEGLDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            localEGL10.eglInitialize(localEGLDisplay, null);
            Object localObject2 = new EGLConfig[1];
            int[] arrayOfInt = new int[1];
            localEGL10.eglChooseConfig(localEGLDisplay, new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344 }, (EGLConfig[])localObject2, 1, arrayOfInt);
            arrayOfInt = localObject2[0];
            localObject2 = localEGL10.eglCreateContext(localEGLDisplay, arrayOfInt, EGL10.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 });
            localObject1 = localEGL10.eglCreateWindowSurface(localEGLDisplay, arrayOfInt, localObject1, new int[] { 12344 });
            localEGL10.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject1, (EGLSurface)localObject1, (EGLContext)localObject2);
            GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            GLES20.glClear(16384);
            localEGL10.eglSwapBuffers(localEGLDisplay, (EGLSurface)localObject1);
            localEGL10.eglDestroySurface(localEGLDisplay, (EGLSurface)localObject1);
            localEGL10.eglMakeCurrent(localEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject2);
            localEGL10.eglTerminate(localEGLDisplay);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.VideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.snu = "";
      this.snA = 0;
      this.snv = false;
      this.gHF = false;
      this.joK = 0L;
      return;
      l1 = 2147483647L;
      break;
    }
  }
  
  public final void x(double paramDouble)
  {
    if (this.gHZ != null)
    {
      this.gHZ.seekTo((int)paramDouble);
      this.gHF = true;
      y.d("MicroMsg.VideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.gHZ.getCurrentPosition());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView
 * JD-Core Version:    0.7.0.1
 */