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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView
  extends MMTextureView
  implements e
{
  protected long aNW;
  protected long aPF;
  private boolean bHF;
  private MediaPlayer bIo;
  MediaPlayer.OnPreparedListener bIp;
  MediaPlayer.OnVideoSizeChangedListener bIq;
  private MediaPlayer.OnCompletionListener bIr;
  private MediaPlayer.OnErrorListener bIu;
  private boolean efg;
  private boolean fVw;
  protected FileDescriptor fd;
  private int iiW;
  private int iiX;
  private e.a lxA;
  private e.d lxD;
  private boolean lxH;
  private boolean lxI;
  private long lxy;
  private int mDuration;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  TextureView.SurfaceTextureListener rBp;
  private float speed;
  private long startTime;
  private boolean wfC;
  private e.e wfD;
  private e.c wfE;
  private r wfF;
  private String wfP;
  private boolean wfQ;
  private e.b wfT;
  private long wfU;
  private int wfV;
  private MediaPlayer.OnSeekCompleteListener wfW;
  private MediaPlayer.OnBufferingUpdateListener wfX;
  private MediaPlayer.OnInfoListener wfY;
  private boolean wfZ;
  
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
    AppMethodBeat.i(118021);
    this.mSurface = null;
    this.bIo = null;
    this.startTime = 0L;
    this.wfU = 0L;
    this.iiW = 0;
    this.iiX = 0;
    this.wfV = 0;
    this.fVw = false;
    this.wfC = false;
    this.bIq = new VideoTextureView.3(this);
    this.bIp = new VideoTextureView.4(this);
    this.wfW = new VideoTextureView.5(this);
    this.wfX = new VideoTextureView.6(this);
    this.wfY = new VideoTextureView.7(this);
    this.bIr = new VideoTextureView.8(this);
    this.bIu = new VideoTextureView.9(this);
    this.lxy = 0L;
    this.lxH = false;
    this.lxI = false;
    this.wfZ = false;
    this.rBp = new VideoTextureView.10(this);
    this.efg = false;
    this.wfF = new r();
    this.speed = -1.0F;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.rBp);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(118021);
  }
  
  private void boV()
  {
    AppMethodBeat.i(118025);
    if (((bo.isNullOrNil(this.wfP)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      AppMethodBeat.o(118025);
      return;
    }
    dpI();
    ab.i("MicroMsg.VideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.wfP });
    try
    {
      this.bIo = new k();
      this.bIo.setOnPreparedListener(this.bIp);
      this.bIo.setOnVideoSizeChangedListener(this.bIq);
      this.wfQ = false;
      ab.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
      this.mDuration = -1;
      this.wfV = 0;
      this.bIo.setOnCompletionListener(this.bIr);
      this.bIo.setOnErrorListener(this.bIu);
      this.bIo.setOnSeekCompleteListener(this.wfW);
      this.bIo.setOnBufferingUpdateListener(this.wfX);
      this.bIo.setOnInfoListener(this.wfY);
      if (!bo.isNullOrNil(this.wfP)) {
        this.bIo.setDataSource(this.wfP);
      }
      for (;;)
      {
        this.bIo.setSurface(this.mSurface);
        this.bIo.setAudioStreamType(3);
        this.bIo.setScreenOnWhilePlaying(true);
        this.bIo.prepareAsync();
        this.mVideoHeight = this.bIo.getVideoHeight();
        this.mVideoWidth = this.bIo.getVideoWidth();
        setMute(this.efg);
        ay(this.speed);
        ab.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.bIo.hashCode()) });
        AppMethodBeat.o(118025);
        return;
        if (this.fd != null) {
          this.bIo.setDataSource(this.fd, this.aNW, this.aPF);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.VideoTextureView", localException, "prepare async error path", new Object[0]);
      if (this.lxA != null) {
        this.lxA.onError(-1, -1);
      }
      AppMethodBeat.o(118025);
    }
  }
  
  private boolean bp(float paramFloat)
  {
    AppMethodBeat.i(118040);
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      if ((this.bIo != null) && (com.tencent.mm.compatible.util.d.fv(23)))
      {
        PlaybackParams localPlaybackParams2 = this.bIo.getPlaybackParams();
        PlaybackParams localPlaybackParams1 = localPlaybackParams2;
        if (localPlaybackParams2 == null) {
          localPlaybackParams1 = new PlaybackParams();
        }
        this.bIo.setPlaybackParams(localPlaybackParams1.setSpeed(paramFloat));
      }
      AppMethodBeat.o(118040);
      return true;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.VideoTextureView", localException, "%s handle play rate error", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(118040);
    }
    return false;
  }
  
  private void dpI()
  {
    boolean bool1 = true;
    AppMethodBeat.i(118024);
    int i = hashCode();
    boolean bool2 = this.wfQ;
    if (this.bIo == null) {}
    for (;;)
    {
      ab.i("MicroMsg.VideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.bIo != null)
      {
        this.bIo.setOnErrorListener(null);
        this.bIo.setOnVideoSizeChangedListener(null);
      }
      try
      {
        this.bIo.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.bIo.reset();
            this.bIo.release();
            this.bIo = null;
            AppMethodBeat.o(118024);
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            ab.printErrStackTrace("MicroMsg.VideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.VideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  public final void A(double paramDouble)
  {
    AppMethodBeat.i(118034);
    if (this.bIo != null)
    {
      this.bIo.seekTo((int)paramDouble);
      this.bHF = true;
      ab.d("MicroMsg.VideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.bIo.getCurrentPosition());
    }
    AppMethodBeat.o(118034);
  }
  
  public final boolean ay(float paramFloat)
  {
    AppMethodBeat.i(118039);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(118039);
      return false;
    }
    this.speed = paramFloat;
    if (com.tencent.mm.compatible.util.d.fv(23))
    {
      boolean bool = bp(this.speed);
      AppMethodBeat.o(118039);
      return bool;
    }
    AppMethodBeat.o(118039);
    return false;
  }
  
  public final void bQB()
  {
    AppMethodBeat.i(118026);
    if ((this.bIo != null) && (this.wfQ) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      ab.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.wfZ = true;
      this.bIo.setVolume(0.0F, 0.0F);
      this.bIo.start();
    }
    AppMethodBeat.o(118026);
  }
  
  public final void e(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(118035);
    A(paramDouble);
    this.bHF = paramBoolean;
    AppMethodBeat.o(118035);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(118029);
    if ((this.bIo != null) && (this.wfQ))
    {
      int i = this.bIo.getCurrentPosition();
      AppMethodBeat.o(118029);
      return i;
    }
    if (this.bIo == null)
    {
      AppMethodBeat.o(118029);
      return -1;
    }
    AppMethodBeat.o(118029);
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.wfV;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(118028);
    if ((this.bIo != null) && (this.wfQ))
    {
      if (this.mDuration > 0)
      {
        i = this.mDuration;
        AppMethodBeat.o(118028);
        return i;
      }
      this.mDuration = this.bIo.getDuration();
      i = this.mDuration;
      AppMethodBeat.o(118028);
      return i;
    }
    this.mDuration = -1;
    int i = this.mDuration;
    AppMethodBeat.o(118028);
    return i;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.lxy;
  }
  
  public String getVideoPath()
  {
    return this.wfP;
  }
  
  protected final void h(Surface paramSurface)
  {
    AppMethodBeat.i(146031);
    com.tencent.mm.sdk.g.d.ysm.execute(new VideoTextureView.2(this, paramSurface));
    AppMethodBeat.o(146031);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(118030);
    if ((this.bIo != null) && (this.wfQ) && (!this.lxI)) {}
    for (boolean bool = this.bIo.isPlaying();; bool = false)
    {
      ab.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.lxI), Boolean.valueOf(this.wfQ) });
      AppMethodBeat.o(118030);
      return bool;
    }
  }
  
  public final void onDetach() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118038);
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(118038);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.mVideoWidth;
    int j = this.mVideoHeight;
    this.wfF.H(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.wfF.iiY, this.wfF.iiZ);
    AppMethodBeat.o(118038);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(118027);
    if ((this.bIo != null) && (this.wfQ) && (this.bIo.isPlaying()))
    {
      ab.d("MicroMsg.VideoTextureView", "pause video.");
      this.bIo.pause();
    }
    this.bHF = false;
    AppMethodBeat.o(118027);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.wfC = paramBoolean;
    this.wfF.wfC = this.wfC;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(118031);
    if (this.bIo != null) {
      this.bIo.setLooping(paramBoolean);
    }
    this.fVw = true;
    AppMethodBeat.o(118031);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(118036);
    ab.i("MicroMsg.VideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.efg = paramBoolean;
    if (this.bIo != null)
    {
      if (this.efg)
      {
        this.bIo.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(118036);
        return;
      }
      this.bIo.setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(118036);
  }
  
  public void setOnInfoCallback(e.b paramb)
  {
    this.wfT = paramb;
  }
  
  public void setOnSeekCompleteCallback(e.c paramc)
  {
    this.wfE = paramc;
  }
  
  public void setOnSurfaceCallback(e.d paramd)
  {
    this.lxD = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(e.e parame)
  {
    this.wfD = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(h.d paramd)
  {
    AppMethodBeat.i(118037);
    this.wfF.setScaleType(paramd);
    requestLayout();
    AppMethodBeat.o(118037);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(e.a parama)
  {
    this.lxA = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(118022);
    this.wfP = paramString;
    this.bHF = false;
    boV();
    requestLayout();
    AppMethodBeat.o(118022);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(118032);
    if (this.mSurface == null)
    {
      ab.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.lxH = true;
      this.bHF = true;
      AppMethodBeat.o(118032);
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bo.aox();; l = this.startTime)
    {
      this.startTime = l;
      ab.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.wfQ), Boolean.valueOf(this.lxI) });
      if ((this.bIo == null) || (!this.wfQ)) {
        break;
      }
      if (this.lxI)
      {
        this.lxI = false;
        setMute(this.efg);
      }
      this.bIo.start();
      this.bHF = true;
      AppMethodBeat.o(118032);
      return true;
    }
    if ((this.bIo == null) && (this.wfQ))
    {
      this.bHF = true;
      boV();
      requestLayout();
      AppMethodBeat.o(118032);
      return true;
    }
    this.bHF = true;
    AppMethodBeat.o(118032);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(118023);
    long l1;
    long l3;
    if (this.wfU > 0L)
    {
      l1 = this.wfU - this.startTime;
      l3 = bo.aox() - this.startTime;
      if (l1 <= l3) {
        break label527;
      }
    }
    label527:
    for (long l2 = l3;; l2 = l1)
    {
      int j = (int)l2 * 1000;
      int i = j;
      if (j > getDuration()) {
        i = getDuration();
      }
      ab.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.lxA != null) {
        this.lxA.dP(i, getDuration());
      }
      dpI();
      this.wfF.reset();
      try
      {
        if ((this.mSurface != null) && (this.wfQ))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            ab.i("MicroMsg.VideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
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
            localObject1 = EGL10.EGL_NO_SURFACE;
            localEGL10.eglMakeCurrent(localEGLDisplay, (EGLSurface)localObject1, (EGLSurface)localObject1, EGL10.EGL_NO_CONTEXT);
            localEGL10.eglDestroyContext(localEGLDisplay, (EGLContext)localObject2);
            localEGL10.eglTerminate(localEGLDisplay);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.VideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.wfP = "";
      this.wfV = 0;
      this.wfQ = false;
      this.bHF = false;
      this.lxy = 0L;
      AppMethodBeat.o(118023);
      return;
      l1 = 2147483647L;
      break;
    }
  }
  
  public final boolean w(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(118033);
    paramBoolean = start();
    AppMethodBeat.o(118033);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView
 * JD-Core Version:    0.7.0.1
 */