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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private h.e CnA;
  private h.c CnB;
  private h.b CnM;
  private MediaPlayer.OnSeekCompleteListener CnN;
  private MediaPlayer.OnBufferingUpdateListener CnO;
  private MediaPlayer.OnInfoListener CnP;
  private float aSD;
  private int ark;
  protected long bjw;
  private boolean cnf;
  protected FileDescriptor fd;
  private boolean fqj;
  private boolean hyg;
  private MediaPlayer ksn;
  MediaPlayer.OnPreparedListener kso;
  MediaPlayer.OnVideoSizeChangedListener ksp;
  private MediaPlayer.OnCompletionListener ksq;
  private MediaPlayer.OnErrorListener kst;
  private long kuC;
  private boolean kuD;
  private boolean kuE;
  private boolean kuF;
  TextureView.SurfaceTextureListener kuG;
  private String kul;
  private boolean kum;
  private long kus;
  private int kut;
  private boolean kuu;
  private int kvn;
  private int kvo;
  protected long length;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private u nng;
  private h.a oNM;
  private h.d oNO;
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
    this.ksn = null;
    this.startTime = 0L;
    this.kus = 0L;
    this.kvn = 0;
    this.kvo = 0;
    this.kut = 0;
    this.hyg = false;
    this.kuu = false;
    this.ksp = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134066);
        try
        {
          if (paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this))
          {
            ad.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
            AppMethodBeat.o(134066);
            return;
          }
          VideoTextureView.a(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoWidth());
          VideoTextureView.b(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoHeight());
          ad.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.b(VideoTextureView.this) + " , " + VideoTextureView.c(VideoTextureView.this) + " )");
          if (VideoTextureView.d(VideoTextureView.this) != null) {
            VideoTextureView.d(VideoTextureView.this).dY(VideoTextureView.b(VideoTextureView.this), VideoTextureView.c(VideoTextureView.this));
          }
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.VideoTextureView", paramAnonymousMediaPlayer, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
        }
        VideoTextureView.e(VideoTextureView.this);
        AppMethodBeat.o(134066);
      }
    };
    this.kso = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134067);
        if ((paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this)) && (paramAnonymousMediaPlayer != null))
        {
          ad.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
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
          ad.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(VideoTextureView.b(VideoTextureView.this)), Integer.valueOf(VideoTextureView.c(VideoTextureView.this)), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)) });
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
            VideoTextureView.d(VideoTextureView.this).rq();
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
    this.CnN = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134068);
        if (paramAnonymousMediaPlayer != null) {}
        for (int i = paramAnonymousMediaPlayer.getCurrentPosition();; i = -1)
        {
          ad.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)), Boolean.valueOf(VideoTextureView.j(VideoTextureView.this)) });
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
            VideoTextureView.k(VideoTextureView.this).ey(VideoTextureView.g(VideoTextureView.this));
          }
          VideoTextureView.a(VideoTextureView.this, 0L);
          AppMethodBeat.o(134068);
          return;
          label141:
          VideoTextureView.this.pause();
        }
      }
    };
    this.CnO = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(134069);
        ad.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        VideoTextureView.c(VideoTextureView.this, paramAnonymousInt);
        AppMethodBeat.o(134069);
      }
    };
    this.CnP = new VideoTextureView.7(this);
    this.ksq = new VideoTextureView.8(this);
    this.kst = new VideoTextureView.9(this);
    this.kuC = 0L;
    this.kuD = false;
    this.kuE = false;
    this.kuF = false;
    this.kuG = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134076);
        VideoTextureView.d(VideoTextureView.this, paramAnonymousInt1);
        VideoTextureView.e(VideoTextureView.this, paramAnonymousInt2);
        VideoTextureView.this.eTg();
        VideoTextureView.this.i(VideoTextureView.t(VideoTextureView.this));
        VideoTextureView.a(VideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
        ad.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)), Integer.valueOf(VideoTextureView.t(VideoTextureView.this).hashCode()) });
        if ((VideoTextureView.a(VideoTextureView.this) == null) || (!VideoTextureView.s(VideoTextureView.this)))
        {
          VideoTextureView.v(VideoTextureView.this);
          if (VideoTextureView.x(VideoTextureView.this) != null) {
            VideoTextureView.x(VideoTextureView.this).aCw();
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
        ad.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)) });
        VideoTextureView.this.i(VideoTextureView.t(VideoTextureView.this));
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
        ad.i("MicroMsg.VideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
        if ((VideoTextureView.a(VideoTextureView.this) != null) && (VideoTextureView.s(VideoTextureView.this)) && (VideoTextureView.b(VideoTextureView.this) == paramAnonymousInt1) && (VideoTextureView.c(VideoTextureView.this) == paramAnonymousInt2)) {
          VideoTextureView.a(VideoTextureView.this).start();
        }
        AppMethodBeat.o(134074);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134073);
        ad.d("MicroMsg.VideoTextureView", "on surface texture updated");
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
            VideoTextureView.o(VideoTextureView.this).beo();
            VideoTextureView.p(VideoTextureView.this);
          }
          VideoTextureView.a(VideoTextureView.this, System.currentTimeMillis());
          if (VideoTextureView.q(VideoTextureView.this))
          {
            ad.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(VideoTextureView.this.getCurrentPosition()) });
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
    this.fqj = false;
    this.nng = new u();
    this.aSD = -1.0F;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.kuG);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134077);
  }
  
  private boolean bA(float paramFloat)
  {
    AppMethodBeat.i(134097);
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      if ((this.ksn != null) && (d.lf(23)))
      {
        PlaybackParams localPlaybackParams2 = this.ksn.getPlaybackParams();
        PlaybackParams localPlaybackParams1 = localPlaybackParams2;
        if (localPlaybackParams2 == null) {
          localPlaybackParams1 = new PlaybackParams();
        }
        this.ksn.setPlaybackParams(localPlaybackParams1.setSpeed(paramFloat));
      }
      AppMethodBeat.o(134097);
      return true;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.VideoTextureView", localException, "%s handle play rate error", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134097);
    }
    return false;
  }
  
  private void beh()
  {
    boolean bool1 = true;
    AppMethodBeat.i(134080);
    int i = hashCode();
    boolean bool2 = this.kum;
    if (this.ksn == null) {}
    for (;;)
    {
      ad.i("MicroMsg.VideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.ksn != null)
      {
        this.ksn.setOnErrorListener(null);
        this.ksn.setOnVideoSizeChangedListener(null);
      }
      try
      {
        this.ksn.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.ksn.reset();
            this.ksn.release();
            this.ksn.setOnBufferingUpdateListener(null);
            this.ksn = null;
            AppMethodBeat.o(134080);
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            ad.printErrStackTrace("MicroMsg.VideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.VideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  private void bei()
  {
    AppMethodBeat.i(134081);
    if (((bt.isNullOrNil(this.kul)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      AppMethodBeat.o(134081);
      return;
    }
    beh();
    ad.i("MicroMsg.VideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.kul });
    try
    {
      this.ksn = new k();
      this.ksn.setOnPreparedListener(this.kso);
      this.ksn.setOnVideoSizeChangedListener(this.ksp);
      this.kum = false;
      ad.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
      this.ark = -1;
      this.kut = 0;
      this.ksn.setOnCompletionListener(this.ksq);
      this.ksn.setOnErrorListener(this.kst);
      this.ksn.setOnSeekCompleteListener(this.CnN);
      this.ksn.setOnBufferingUpdateListener(this.CnO);
      this.ksn.setOnInfoListener(this.CnP);
      if (!bt.isNullOrNil(this.kul)) {
        this.ksn.setDataSource(this.kul);
      }
      for (;;)
      {
        this.ksn.setSurface(this.mSurface);
        this.ksn.setAudioStreamType(3);
        this.ksn.setScreenOnWhilePlaying(true);
        this.ksn.prepareAsync();
        this.mVideoHeight = this.ksn.getVideoHeight();
        this.mVideoWidth = this.ksn.getVideoWidth();
        setMute(this.fqj);
        ax(this.aSD);
        ad.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.ksn.hashCode()) });
        AppMethodBeat.o(134081);
        return;
        if (this.fd != null) {
          this.ksn.setDataSource(this.fd, this.bjw, this.length);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.VideoTextureView", localException, "prepare async error path", new Object[0]);
      if (this.oNM != null) {
        this.oNM.onError(-1, -1);
      }
      AppMethodBeat.o(134081);
    }
  }
  
  public final boolean ax(float paramFloat)
  {
    AppMethodBeat.i(134096);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(134096);
      return false;
    }
    this.aSD = paramFloat;
    if (d.lf(23))
    {
      boolean bool = bA(this.aSD);
      AppMethodBeat.o(134096);
      return bool;
    }
    AppMethodBeat.o(134096);
    return false;
  }
  
  public final void bej()
  {
    AppMethodBeat.i(134082);
    if ((this.ksn != null) && (this.kum) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      ad.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.kuF = true;
      this.ksn.setVolume(0.0F, 0.0F);
      this.ksn.start();
    }
    AppMethodBeat.o(134082);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134092);
    q(paramDouble);
    this.cnf = paramBoolean;
    AppMethodBeat.o(134092);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(134086);
    if ((this.ksn != null) && (this.kum))
    {
      int i = this.ksn.getCurrentPosition();
      AppMethodBeat.o(134086);
      return i;
    }
    if (this.ksn == null)
    {
      AppMethodBeat.o(134086);
      return -1;
    }
    AppMethodBeat.o(134086);
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.kut;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(134085);
    if ((this.ksn != null) && (this.kum))
    {
      if (this.ark > 0)
      {
        i = this.ark;
        AppMethodBeat.o(134085);
        return i;
      }
      this.ark = this.ksn.getDuration();
      i = this.ark;
      AppMethodBeat.o(134085);
      return i;
    }
    this.ark = -1;
    int i = this.ark;
    AppMethodBeat.o(134085);
    return i;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.kuC;
  }
  
  public String getVideoPath()
  {
    return this.kul;
  }
  
  protected final void i(Surface paramSurface)
  {
    AppMethodBeat.i(134083);
    com.tencent.e.h.Iye.aP(new VideoTextureView.2(this, paramSurface));
    AppMethodBeat.o(134083);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134087);
    if ((this.ksn != null) && (this.kum) && (!this.kuE) && (!this.kuF)) {}
    for (;;)
    {
      try
      {
        bool = this.ksn.isPlaying();
        ad.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.kuE), Boolean.valueOf(this.kum) });
        AppMethodBeat.o(134087);
        return bool;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.VideoTextureView", localException, "isPlaying", new Object[0]);
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
    this.nng.x(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.nng.kvp, this.nng.kvq);
    AppMethodBeat.o(134095);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(134084);
    if ((this.ksn != null) && (this.kum) && (this.ksn.isPlaying()))
    {
      ad.d("MicroMsg.VideoTextureView", "pause video.");
      this.ksn.pause();
    }
    this.cnf = false;
    AppMethodBeat.o(134084);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(134091);
    if (this.ksn != null)
    {
      this.ksn.seekTo((int)paramDouble);
      this.cnf = true;
      ad.d("MicroMsg.VideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.ksn.getCurrentPosition());
    }
    AppMethodBeat.o(134091);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.kuu = paramBoolean;
    this.nng.kuu = this.kuu;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(134088);
    if (this.ksn != null) {
      this.ksn.setLooping(paramBoolean);
    }
    this.hyg = true;
    AppMethodBeat.o(134088);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134093);
    ad.i("MicroMsg.VideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.fqj = paramBoolean;
    if (this.ksn != null)
    {
      if (this.fqj)
      {
        this.ksn.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(134093);
        return;
      }
      this.ksn.setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(134093);
  }
  
  public void setOnInfoCallback(h.b paramb)
  {
    this.CnM = paramb;
  }
  
  public void setOnSeekCompleteCallback(h.c paramc)
  {
    this.CnB = paramc;
  }
  
  public void setOnSurfaceCallback(h.d paramd)
  {
    this.oNO = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame)
  {
    this.CnA = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(com.tencent.mm.pluginsdk.ui.h.e parame)
  {
    AppMethodBeat.i(134094);
    this.nng.a(parame);
    requestLayout();
    AppMethodBeat.o(134094);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(h.a parama)
  {
    this.oNM = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134078);
    this.kul = paramString;
    this.cnf = false;
    bei();
    requestLayout();
    AppMethodBeat.o(134078);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(134089);
    if (this.mSurface == null)
    {
      ad.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.kuD = true;
      this.cnf = true;
      AppMethodBeat.o(134089);
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bt.aGK();; l = this.startTime)
    {
      this.startTime = l;
      ad.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.kum), Boolean.valueOf(this.kuE) });
      if ((this.ksn == null) || (!this.kum)) {
        break;
      }
      if (this.kuE)
      {
        this.kuE = false;
        setMute(this.fqj);
      }
      this.ksn.start();
      this.cnf = true;
      AppMethodBeat.o(134089);
      return true;
    }
    if ((this.ksn == null) && (this.kum))
    {
      this.cnf = true;
      bei();
      requestLayout();
      AppMethodBeat.o(134089);
      return true;
    }
    this.cnf = true;
    AppMethodBeat.o(134089);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(134079);
    long l1;
    long l3;
    if (this.kus > 0L)
    {
      l1 = this.kus - this.startTime;
      l3 = bt.aGK() - this.startTime;
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
      ad.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.oNM != null) {
        this.oNM.eM(i, getDuration());
      }
      beh();
      this.nng.reset();
      try
      {
        if ((this.mSurface != null) && (this.kum))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            ad.i("MicroMsg.VideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
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
          ad.printErrStackTrace("MicroMsg.VideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.kul = "";
      this.kut = 0;
      this.kum = false;
      this.cnf = false;
      this.kuC = 0L;
      AppMethodBeat.o(134079);
      return;
      l1 = 2147483647L;
      break;
    }
  }
  
  public final boolean y(Context paramContext, boolean paramBoolean)
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