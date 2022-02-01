package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView
  extends MMTextureView
  implements h
{
  private h.e DFT;
  private h.c DFU;
  private h.b DGf;
  private MediaPlayer.OnSeekCompleteListener DGg;
  private MediaPlayer.OnBufferingUpdateListener DGh;
  private MediaPlayer.OnInfoListener DGi;
  private float aTw;
  private int asf;
  protected long bkb;
  private boolean ckh;
  protected FileDescriptor fd;
  private boolean ftN;
  private boolean hYH;
  private MediaPlayer kTD;
  MediaPlayer.OnPreparedListener kTE;
  MediaPlayer.OnVideoSizeChangedListener kTF;
  private MediaPlayer.OnCompletionListener kTG;
  private MediaPlayer.OnErrorListener kTJ;
  private String kVA;
  private boolean kVB;
  private long kVH;
  private int kVI;
  private boolean kVJ;
  private long kVR;
  private boolean kVS;
  private boolean kVT;
  private boolean kVU;
  TextureView.SurfaceTextureListener kVV;
  private int kWB;
  private int kWC;
  protected long length;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private u nQg;
  private h.a prg;
  private h.d pri;
  private long startTime;
  
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
    AppMethodBeat.i(134077);
    this.mSurface = null;
    this.kTD = null;
    this.startTime = 0L;
    this.kVH = 0L;
    this.kWB = 0;
    this.kWC = 0;
    this.kVI = 0;
    this.hYH = false;
    this.kVJ = false;
    this.kTF = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134066);
        try
        {
          if (paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this))
          {
            ac.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
            AppMethodBeat.o(134066);
            return;
          }
          VideoTextureView.a(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoWidth());
          VideoTextureView.b(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoHeight());
          ac.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.b(VideoTextureView.this) + " , " + VideoTextureView.c(VideoTextureView.this) + " )");
          if (VideoTextureView.d(VideoTextureView.this) != null) {
            VideoTextureView.d(VideoTextureView.this).dZ(VideoTextureView.b(VideoTextureView.this), VideoTextureView.c(VideoTextureView.this));
          }
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.VideoTextureView", paramAnonymousMediaPlayer, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
        }
        VideoTextureView.e(VideoTextureView.this);
        AppMethodBeat.o(134066);
      }
    };
    this.kTE = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134067);
        if ((paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this)) && (paramAnonymousMediaPlayer != null))
        {
          ac.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
          VideoTextureView.a(VideoTextureView.this, paramAnonymousMediaPlayer);
          AppMethodBeat.o(134067);
          return;
        }
        VideoTextureView.f(VideoTextureView.this);
        VideoTextureView localVideoTextureView = VideoTextureView.this;
        int i;
        if (paramAnonymousMediaPlayer != null)
        {
          i = paramAnonymousMediaPlayer.getVideoWidth();
          VideoTextureView.a(localVideoTextureView, i);
          localVideoTextureView = VideoTextureView.this;
          if (paramAnonymousMediaPlayer == null) {
            break label262;
          }
          i = paramAnonymousMediaPlayer.getVideoHeight();
          label101:
          VideoTextureView.b(localVideoTextureView, i);
          ac.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(VideoTextureView.b(VideoTextureView.this)), Integer.valueOf(VideoTextureView.c(VideoTextureView.this)), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)) });
          VideoTextureView.e(VideoTextureView.this);
          if ((VideoTextureView.b(VideoTextureView.this) == 0) || (VideoTextureView.c(VideoTextureView.this) == 0)) {
            break label267;
          }
          if (VideoTextureView.g(VideoTextureView.this))
          {
            VideoTextureView.a(VideoTextureView.this).start();
            VideoTextureView.a(VideoTextureView.this).setLooping(VideoTextureView.h(VideoTextureView.this));
            VideoTextureView.i(VideoTextureView.this);
          }
        }
        for (;;)
        {
          if (VideoTextureView.d(VideoTextureView.this) != null) {
            VideoTextureView.d(VideoTextureView.this).rB();
          }
          AppMethodBeat.o(134067);
          return;
          i = 0;
          break;
          label262:
          i = 0;
          break label101;
          label267:
          if (VideoTextureView.g(VideoTextureView.this))
          {
            VideoTextureView.a(VideoTextureView.this).start();
            VideoTextureView.i(VideoTextureView.this);
            VideoTextureView.a(VideoTextureView.this).setLooping(VideoTextureView.h(VideoTextureView.this));
          }
        }
      }
    };
    this.DGg = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134068);
        if (paramAnonymousMediaPlayer != null) {}
        for (int i = paramAnonymousMediaPlayer.getCurrentPosition();; i = -1)
        {
          ac.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)), Boolean.valueOf(VideoTextureView.j(VideoTextureView.this)) });
          if (!VideoTextureView.g(VideoTextureView.this)) {
            break label141;
          }
          if (!VideoTextureView.j(VideoTextureView.this)) {
            break;
          }
          AppMethodBeat.o(134068);
          return;
        }
        VideoTextureView.this.start();
        for (;;)
        {
          if (VideoTextureView.k(VideoTextureView.this) != null) {
            VideoTextureView.k(VideoTextureView.this).eS(VideoTextureView.g(VideoTextureView.this));
          }
          VideoTextureView.a(VideoTextureView.this, 0L);
          AppMethodBeat.o(134068);
          return;
          label141:
          VideoTextureView.this.pause();
        }
      }
    };
    this.DGh = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(134069);
        ac.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        VideoTextureView.c(VideoTextureView.this, paramAnonymousInt);
        AppMethodBeat.o(134069);
      }
    };
    this.DGi = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134070);
        ac.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (VideoTextureView.l(VideoTextureView.this) != null) {
          VideoTextureView.l(VideoTextureView.this).ea(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134070);
        return false;
      }
    };
    this.kTG = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134071);
        ac.i("MicroMsg.VideoTextureView", "video on completion");
        VideoTextureView.b(VideoTextureView.this, bs.aNx());
        if (VideoTextureView.d(VideoTextureView.this) != null) {
          VideoTextureView.d(VideoTextureView.this).onCompletion();
        }
        AppMethodBeat.o(134071);
      }
    };
    this.kTJ = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134072);
        ac.w("MicroMsg.VideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        if (VideoTextureView.d(VideoTextureView.this) != null) {
          VideoTextureView.d(VideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134072);
        return true;
      }
    };
    this.kVR = 0L;
    this.kVS = false;
    this.kVT = false;
    this.kVU = false;
    this.kVV = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134076);
        VideoTextureView.d(VideoTextureView.this, paramAnonymousInt1);
        VideoTextureView.e(VideoTextureView.this, paramAnonymousInt2);
        VideoTextureView.this.fiQ();
        VideoTextureView.this.h(VideoTextureView.t(VideoTextureView.this));
        VideoTextureView.a(VideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
        ac.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)), Integer.valueOf(VideoTextureView.t(VideoTextureView.this).hashCode()) });
        if ((VideoTextureView.a(VideoTextureView.this) == null) || (!VideoTextureView.s(VideoTextureView.this)))
        {
          VideoTextureView.v(VideoTextureView.this);
          if (VideoTextureView.x(VideoTextureView.this) != null) {
            VideoTextureView.x(VideoTextureView.this).aJn();
          }
          AppMethodBeat.o(134076);
          return;
        }
        VideoTextureView.a(VideoTextureView.this).setSurface(VideoTextureView.t(VideoTextureView.this));
        if (VideoTextureView.w(VideoTextureView.this)) {
          VideoTextureView.a(VideoTextureView.this).start();
        }
        for (;;)
        {
          VideoTextureView.b(VideoTextureView.this, false);
          break;
          VideoTextureView.a(VideoTextureView.this, true);
          VideoTextureView.a(VideoTextureView.this).setVolume(0.0F, 0.0F);
          VideoTextureView.a(VideoTextureView.this).start();
        }
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134075);
        ac.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)) });
        VideoTextureView.this.h(VideoTextureView.t(VideoTextureView.this));
        VideoTextureView.a(VideoTextureView.this, null);
        if ((VideoTextureView.a(VideoTextureView.this) != null) && (VideoTextureView.s(VideoTextureView.this))) {
          if (VideoTextureView.this.isPlaying())
          {
            VideoTextureView.b(VideoTextureView.this, true);
            VideoTextureView.a(VideoTextureView.this).pause();
          }
        }
        for (;;)
        {
          AppMethodBeat.o(134075);
          return false;
          VideoTextureView.u(VideoTextureView.this);
          VideoTextureView.b(VideoTextureView.this, false);
        }
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134074);
        ac.i("MicroMsg.VideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
        if ((VideoTextureView.a(VideoTextureView.this) != null) && (VideoTextureView.s(VideoTextureView.this)) && (VideoTextureView.b(VideoTextureView.this) == paramAnonymousInt1) && (VideoTextureView.c(VideoTextureView.this) == paramAnonymousInt2)) {
          VideoTextureView.a(VideoTextureView.this).start();
        }
        AppMethodBeat.o(134074);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134073);
        ac.d("MicroMsg.VideoTextureView", "on surface texture updated");
        if (VideoTextureView.j(VideoTextureView.this)) {
          if (VideoTextureView.a(VideoTextureView.this) != null)
          {
            VideoTextureView.a(VideoTextureView.this).pause();
            if (!VideoTextureView.m(VideoTextureView.this)) {
              break label221;
            }
            VideoTextureView.a(VideoTextureView.this).setVolume(0.0F, 0.0F);
          }
        }
        for (;;)
        {
          VideoTextureView.a(VideoTextureView.this, false);
          if ((VideoTextureView.n(VideoTextureView.this) > 0L) && (VideoTextureView.o(VideoTextureView.this) != null))
          {
            VideoTextureView.o(VideoTextureView.this).bli();
            VideoTextureView.p(VideoTextureView.this);
          }
          VideoTextureView.a(VideoTextureView.this, System.currentTimeMillis());
          if (VideoTextureView.q(VideoTextureView.this))
          {
            ac.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(VideoTextureView.this.getCurrentPosition()) });
            if (VideoTextureView.a(VideoTextureView.this) != null)
            {
              VideoTextureView.a(VideoTextureView.this).pause();
              VideoTextureView.this.setMute(VideoTextureView.m(VideoTextureView.this));
            }
            VideoTextureView.r(VideoTextureView.this);
          }
          AppMethodBeat.o(134073);
          return;
          label221:
          VideoTextureView.a(VideoTextureView.this).setVolume(1.0F, 1.0F);
        }
      }
    };
    this.ftN = false;
    this.nQg = new u();
    this.aTw = -1.0F;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.kVV);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134077);
  }
  
  private boolean bI(float paramFloat)
  {
    AppMethodBeat.i(134097);
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      if ((this.kTD != null) && (d.kZ(23)))
      {
        PlaybackParams localPlaybackParams2 = this.kTD.getPlaybackParams();
        PlaybackParams localPlaybackParams1 = localPlaybackParams2;
        if (localPlaybackParams2 == null) {
          localPlaybackParams1 = new PlaybackParams();
        }
        this.kTD.setPlaybackParams(localPlaybackParams1.setSpeed(paramFloat));
      }
      AppMethodBeat.o(134097);
      return true;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.VideoTextureView", localException, "%s handle play rate error", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134097);
    }
    return false;
  }
  
  private void blb()
  {
    boolean bool1 = true;
    AppMethodBeat.i(134080);
    int i = hashCode();
    boolean bool2 = this.kVB;
    if (this.kTD == null) {}
    for (;;)
    {
      ac.i("MicroMsg.VideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.kTD != null)
      {
        this.kTD.setOnErrorListener(null);
        this.kTD.setOnVideoSizeChangedListener(null);
      }
      try
      {
        this.kTD.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.kTD.reset();
            this.kTD.release();
            this.kTD.setOnBufferingUpdateListener(null);
            this.kTD = null;
            AppMethodBeat.o(134080);
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            ac.printErrStackTrace("MicroMsg.VideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.VideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  private void blc()
  {
    AppMethodBeat.i(134081);
    if (((bs.isNullOrNil(this.kVA)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      AppMethodBeat.o(134081);
      return;
    }
    blb();
    ac.i("MicroMsg.VideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.kVA });
    try
    {
      this.kTD = new k();
      this.kTD.setOnPreparedListener(this.kTE);
      this.kTD.setOnVideoSizeChangedListener(this.kTF);
      this.kVB = false;
      ac.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
      this.asf = -1;
      this.kVI = 0;
      this.kTD.setOnCompletionListener(this.kTG);
      this.kTD.setOnErrorListener(this.kTJ);
      this.kTD.setOnSeekCompleteListener(this.DGg);
      this.kTD.setOnBufferingUpdateListener(this.DGh);
      this.kTD.setOnInfoListener(this.DGi);
      if (!bs.isNullOrNil(this.kVA)) {
        this.kTD.setDataSource(this.kVA);
      }
      for (;;)
      {
        this.kTD.setSurface(this.mSurface);
        this.kTD.setAudioStreamType(3);
        this.kTD.setScreenOnWhilePlaying(true);
        this.kTD.prepareAsync();
        this.mVideoHeight = this.kTD.getVideoHeight();
        this.mVideoWidth = this.kTD.getVideoWidth();
        setMute(this.ftN);
        aB(this.aTw);
        ac.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.kTD.hashCode()) });
        AppMethodBeat.o(134081);
        return;
        if (this.fd != null) {
          this.kTD.setDataSource(this.fd, this.bkb, this.length);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.VideoTextureView", localException, "prepare async error path", new Object[0]);
      if (this.prg != null) {
        this.prg.onError(-1, -1);
      }
      AppMethodBeat.o(134081);
    }
  }
  
  public final boolean aB(float paramFloat)
  {
    AppMethodBeat.i(134096);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(134096);
      return false;
    }
    this.aTw = paramFloat;
    if (d.kZ(23))
    {
      boolean bool = bI(this.aTw);
      AppMethodBeat.o(134096);
      return bool;
    }
    AppMethodBeat.o(134096);
    return false;
  }
  
  public final void bld()
  {
    AppMethodBeat.i(134082);
    if ((this.kTD != null) && (this.kVB) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      ac.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.kVU = true;
      this.kTD.setVolume(0.0F, 0.0F);
      this.kTD.start();
    }
    AppMethodBeat.o(134082);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134092);
    p(paramDouble);
    this.ckh = paramBoolean;
    AppMethodBeat.o(134092);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(134086);
    if ((this.kTD != null) && (this.kVB))
    {
      int i = this.kTD.getCurrentPosition();
      AppMethodBeat.o(134086);
      return i;
    }
    if (this.kTD == null)
    {
      AppMethodBeat.o(134086);
      return -1;
    }
    AppMethodBeat.o(134086);
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.kVI;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(134085);
    if ((this.kTD != null) && (this.kVB))
    {
      if (this.asf > 0)
      {
        i = this.asf;
        AppMethodBeat.o(134085);
        return i;
      }
      this.asf = this.kTD.getDuration();
      i = this.asf;
      AppMethodBeat.o(134085);
      return i;
    }
    this.asf = -1;
    int i = this.asf;
    AppMethodBeat.o(134085);
    return i;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.kVR;
  }
  
  public String getVideoPath()
  {
    return this.kVA;
  }
  
  protected final void h(Surface paramSurface)
  {
    AppMethodBeat.i(134083);
    com.tencent.e.h.JZN.aS(new VideoTextureView.2(this, paramSurface));
    AppMethodBeat.o(134083);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134087);
    if ((this.kTD != null) && (this.kVB) && (!this.kVT) && (!this.kVU)) {}
    for (;;)
    {
      try
      {
        bool = this.kTD.isPlaying();
        ac.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.kVT), Boolean.valueOf(this.kVB) });
        AppMethodBeat.o(134087);
        return bool;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.VideoTextureView", localException, "isPlaying", new Object[0]);
      }
      boolean bool = false;
    }
  }
  
  public final void onDetach() {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(134095);
    if ((this.mVideoWidth == 0) || (this.mVideoHeight == 0))
    {
      setMeasuredDimension(1, 1);
      AppMethodBeat.o(134095);
      return;
    }
    paramInt1 = getDefaultSize(1, paramInt1);
    paramInt2 = getDefaultSize(1, paramInt2);
    int i = this.mVideoWidth;
    int j = this.mVideoHeight;
    this.nQg.x(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.nQg.kWD, this.nQg.kWE);
    AppMethodBeat.o(134095);
  }
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(134091);
    if (this.kTD != null)
    {
      this.kTD.seekTo((int)paramDouble);
      this.ckh = true;
      ac.d("MicroMsg.VideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.kTD.getCurrentPosition());
    }
    AppMethodBeat.o(134091);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(134084);
    if ((this.kTD != null) && (this.kVB) && (this.kTD.isPlaying()))
    {
      ac.d("MicroMsg.VideoTextureView", "pause video.");
      this.kTD.pause();
    }
    this.ckh = false;
    AppMethodBeat.o(134084);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.kVJ = paramBoolean;
    this.nQg.kVJ = this.kVJ;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(134088);
    if (this.kTD != null) {
      this.kTD.setLooping(paramBoolean);
    }
    this.hYH = true;
    AppMethodBeat.o(134088);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134093);
    ac.i("MicroMsg.VideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.ftN = paramBoolean;
    if (this.kTD != null)
    {
      if (this.ftN)
      {
        this.kTD.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(134093);
        return;
      }
      this.kTD.setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(134093);
  }
  
  public void setOnInfoCallback(h.b paramb)
  {
    this.DGf = paramb;
  }
  
  public void setOnSeekCompleteCallback(h.c paramc)
  {
    this.DFU = paramc;
  }
  
  public void setOnSurfaceCallback(h.d paramd)
  {
    this.pri = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame)
  {
    this.DFT = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(com.tencent.mm.pluginsdk.ui.h.e parame)
  {
    AppMethodBeat.i(134094);
    this.nQg.a(parame);
    requestLayout();
    AppMethodBeat.o(134094);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(h.a parama)
  {
    this.prg = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134078);
    this.kVA = paramString;
    this.ckh = false;
    blc();
    requestLayout();
    AppMethodBeat.o(134078);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(134089);
    if (this.mSurface == null)
    {
      ac.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.kVS = true;
      this.ckh = true;
      AppMethodBeat.o(134089);
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bs.aNx();; l = this.startTime)
    {
      this.startTime = l;
      ac.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.kVB), Boolean.valueOf(this.kVT) });
      if ((this.kTD == null) || (!this.kVB)) {
        break;
      }
      if (this.kVT)
      {
        this.kVT = false;
        setMute(this.ftN);
      }
      this.kTD.start();
      this.ckh = true;
      AppMethodBeat.o(134089);
      return true;
    }
    if ((this.kTD == null) && (this.kVB))
    {
      this.ckh = true;
      blc();
      requestLayout();
      AppMethodBeat.o(134089);
      return true;
    }
    this.ckh = true;
    AppMethodBeat.o(134089);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(134079);
    long l1;
    long l3;
    if (this.kVH > 0L)
    {
      l1 = this.kVH - this.startTime;
      l3 = bs.aNx() - this.startTime;
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
      ac.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.prg != null) {
        this.prg.eP(i, getDuration());
      }
      blb();
      this.nQg.reset();
      try
      {
        if ((this.mSurface != null) && (this.kVB))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            ac.i("MicroMsg.VideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
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
          ac.printErrStackTrace("MicroMsg.VideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.kVA = "";
      this.kVI = 0;
      this.kVB = false;
      this.ckh = false;
      this.kVR = 0L;
      AppMethodBeat.o(134079);
      return;
      l1 = 2147483647L;
      break;
    }
  }
  
  public final boolean z(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(134090);
    paramBoolean = start();
    AppMethodBeat.o(134090);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView
 * JD-Core Version:    0.7.0.1
 */