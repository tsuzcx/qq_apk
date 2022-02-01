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
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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
  private h.b FDI;
  private MediaPlayer.OnSeekCompleteListener FDJ;
  private MediaPlayer.OnBufferingUpdateListener FDK;
  private MediaPlayer.OnInfoListener FDL;
  private h.e FDw;
  private h.c FDx;
  private int atW;
  private float bdQ;
  protected long buw;
  private boolean cvk;
  private boolean fOX;
  protected FileDescriptor fd;
  private boolean iuX;
  protected long length;
  private MediaPlayer luF;
  MediaPlayer.OnPreparedListener luG;
  MediaPlayer.OnVideoSizeChangedListener luH;
  private MediaPlayer.OnCompletionListener luI;
  private MediaPlayer.OnErrorListener luL;
  private String lwY;
  private boolean lwZ;
  private int lxZ;
  private long lxf;
  private int lxg;
  private boolean lxh;
  private long lxp;
  private boolean lxq;
  private boolean lxr;
  private boolean lxs;
  TextureView.SurfaceTextureListener lxt;
  private int lya;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private u ozo;
  private h.a qbr;
  private h.d qbt;
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
    this.luF = null;
    this.startTime = 0L;
    this.lxf = 0L;
    this.lxZ = 0;
    this.lya = 0;
    this.lxg = 0;
    this.iuX = false;
    this.lxh = false;
    this.luH = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134066);
        try
        {
          if (paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this))
          {
            ae.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
            AppMethodBeat.o(134066);
            return;
          }
          VideoTextureView.a(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoWidth());
          VideoTextureView.b(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoHeight());
          ae.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.b(VideoTextureView.this) + " , " + VideoTextureView.c(VideoTextureView.this) + " )");
          if (VideoTextureView.d(VideoTextureView.this) != null) {
            VideoTextureView.d(VideoTextureView.this).eb(VideoTextureView.b(VideoTextureView.this), VideoTextureView.c(VideoTextureView.this));
          }
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.VideoTextureView", paramAnonymousMediaPlayer, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
        }
        VideoTextureView.e(VideoTextureView.this);
        AppMethodBeat.o(134066);
      }
    };
    this.luG = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134067);
        if ((paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this)) && (paramAnonymousMediaPlayer != null))
        {
          ae.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
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
          ae.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(VideoTextureView.b(VideoTextureView.this)), Integer.valueOf(VideoTextureView.c(VideoTextureView.this)), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)) });
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
            VideoTextureView.d(VideoTextureView.this).ta();
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
    this.FDJ = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134068);
        if (paramAnonymousMediaPlayer != null) {}
        for (int i = paramAnonymousMediaPlayer.getCurrentPosition();; i = -1)
        {
          ae.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)), Boolean.valueOf(VideoTextureView.j(VideoTextureView.this)) });
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
            VideoTextureView.k(VideoTextureView.this).eX(VideoTextureView.g(VideoTextureView.this));
          }
          VideoTextureView.a(VideoTextureView.this, 0L);
          AppMethodBeat.o(134068);
          return;
          label141:
          VideoTextureView.this.pause();
        }
      }
    };
    this.FDK = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(134069);
        ae.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        VideoTextureView.c(VideoTextureView.this, paramAnonymousInt);
        AppMethodBeat.o(134069);
      }
    };
    this.FDL = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134070);
        ae.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (VideoTextureView.l(VideoTextureView.this) != null) {
          VideoTextureView.l(VideoTextureView.this).ec(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134070);
        return false;
      }
    };
    this.luI = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134071);
        ae.i("MicroMsg.VideoTextureView", "video on completion");
        VideoTextureView.b(VideoTextureView.this, bu.aRi());
        if (VideoTextureView.d(VideoTextureView.this) != null) {
          VideoTextureView.d(VideoTextureView.this).onCompletion();
        }
        AppMethodBeat.o(134071);
      }
    };
    this.luL = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134072);
        ae.w("MicroMsg.VideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        if (VideoTextureView.d(VideoTextureView.this) != null) {
          VideoTextureView.d(VideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134072);
        return true;
      }
    };
    this.lxp = 0L;
    this.lxq = false;
    this.lxr = false;
    this.lxs = false;
    this.lxt = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134076);
        VideoTextureView.d(VideoTextureView.this, paramAnonymousInt1);
        VideoTextureView.e(VideoTextureView.this, paramAnonymousInt2);
        VideoTextureView.this.fDh();
        VideoTextureView.this.h(VideoTextureView.t(VideoTextureView.this));
        VideoTextureView.a(VideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
        ae.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)), Integer.valueOf(VideoTextureView.t(VideoTextureView.this).hashCode()) });
        if ((VideoTextureView.a(VideoTextureView.this) == null) || (!VideoTextureView.s(VideoTextureView.this)))
        {
          VideoTextureView.v(VideoTextureView.this);
          if (VideoTextureView.x(VideoTextureView.this) != null) {
            VideoTextureView.x(VideoTextureView.this).aMV();
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
        ae.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)) });
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
        ae.i("MicroMsg.VideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
        if ((VideoTextureView.a(VideoTextureView.this) != null) && (VideoTextureView.s(VideoTextureView.this)) && (VideoTextureView.b(VideoTextureView.this) == paramAnonymousInt1) && (VideoTextureView.c(VideoTextureView.this) == paramAnonymousInt2)) {
          VideoTextureView.a(VideoTextureView.this).start();
        }
        AppMethodBeat.o(134074);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134073);
        ae.d("MicroMsg.VideoTextureView", "on surface texture updated");
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
            VideoTextureView.o(VideoTextureView.this).bpD();
            VideoTextureView.p(VideoTextureView.this);
          }
          VideoTextureView.a(VideoTextureView.this, System.currentTimeMillis());
          if (VideoTextureView.q(VideoTextureView.this))
          {
            ae.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(VideoTextureView.this.getCurrentPosition()) });
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
    this.fOX = false;
    this.ozo = new u();
    this.bdQ = -1.0F;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.lxt);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134077);
  }
  
  private boolean bL(float paramFloat)
  {
    AppMethodBeat.i(134097);
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      if ((this.luF != null) && (d.lA(23)))
      {
        PlaybackParams localPlaybackParams2 = this.luF.getPlaybackParams();
        PlaybackParams localPlaybackParams1 = localPlaybackParams2;
        if (localPlaybackParams2 == null) {
          localPlaybackParams1 = new PlaybackParams();
        }
        this.luF.setPlaybackParams(localPlaybackParams1.setSpeed(paramFloat));
      }
      AppMethodBeat.o(134097);
      return true;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.VideoTextureView", localException, "%s handle play rate error", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134097);
    }
    return false;
  }
  
  private void bpw()
  {
    boolean bool1 = true;
    AppMethodBeat.i(134080);
    int i = hashCode();
    boolean bool2 = this.lwZ;
    if (this.luF == null) {}
    for (;;)
    {
      ae.i("MicroMsg.VideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.luF != null)
      {
        this.luF.setOnErrorListener(null);
        this.luF.setOnVideoSizeChangedListener(null);
      }
      try
      {
        this.luF.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.luF.reset();
            this.luF.release();
            this.luF.setOnBufferingUpdateListener(null);
            this.luF = null;
            AppMethodBeat.o(134080);
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            ae.printErrStackTrace("MicroMsg.VideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.VideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  private void bpx()
  {
    AppMethodBeat.i(134081);
    if (((bu.isNullOrNil(this.lwY)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      AppMethodBeat.o(134081);
      return;
    }
    bpw();
    ae.i("MicroMsg.VideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.lwY });
    try
    {
      this.luF = new k();
      this.luF.setOnPreparedListener(this.luG);
      this.luF.setOnVideoSizeChangedListener(this.luH);
      this.lwZ = false;
      ae.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
      this.atW = -1;
      this.lxg = 0;
      this.luF.setOnCompletionListener(this.luI);
      this.luF.setOnErrorListener(this.luL);
      this.luF.setOnSeekCompleteListener(this.FDJ);
      this.luF.setOnBufferingUpdateListener(this.FDK);
      this.luF.setOnInfoListener(this.FDL);
      if (!bu.isNullOrNil(this.lwY)) {
        this.luF.setDataSource(this.lwY);
      }
      for (;;)
      {
        this.luF.setSurface(this.mSurface);
        this.luF.setAudioStreamType(3);
        this.luF.setScreenOnWhilePlaying(true);
        this.luF.prepareAsync();
        this.mVideoHeight = this.luF.getVideoHeight();
        this.mVideoWidth = this.luF.getVideoWidth();
        setMute(this.fOX);
        aE(this.bdQ);
        ae.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.luF.hashCode()) });
        AppMethodBeat.o(134081);
        return;
        if (this.fd != null) {
          this.luF.setDataSource(this.fd, this.buw, this.length);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.VideoTextureView", localException, "prepare async error path", new Object[0]);
      if (this.qbr != null) {
        this.qbr.onError(-1, -1);
      }
      AppMethodBeat.o(134081);
    }
  }
  
  public final boolean B(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(134090);
    paramBoolean = start();
    AppMethodBeat.o(134090);
    return paramBoolean;
  }
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(134096);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(134096);
      return false;
    }
    this.bdQ = paramFloat;
    if (d.lA(23))
    {
      boolean bool = bL(this.bdQ);
      AppMethodBeat.o(134096);
      return bool;
    }
    AppMethodBeat.o(134096);
    return false;
  }
  
  public final void bpy()
  {
    AppMethodBeat.i(134082);
    if ((this.luF != null) && (this.lwZ) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      ae.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.lxs = true;
      this.luF.setVolume(0.0F, 0.0F);
      this.luF.start();
    }
    AppMethodBeat.o(134082);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134092);
    p(paramDouble);
    this.cvk = paramBoolean;
    AppMethodBeat.o(134092);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(134086);
    if ((this.luF != null) && (this.lwZ))
    {
      int i = this.luF.getCurrentPosition();
      AppMethodBeat.o(134086);
      return i;
    }
    if (this.luF == null)
    {
      AppMethodBeat.o(134086);
      return -1;
    }
    AppMethodBeat.o(134086);
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.lxg;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(134085);
    if ((this.luF != null) && (this.lwZ))
    {
      if (this.atW > 0)
      {
        i = this.atW;
        AppMethodBeat.o(134085);
        return i;
      }
      this.atW = this.luF.getDuration();
      i = this.atW;
      AppMethodBeat.o(134085);
      return i;
    }
    this.atW = -1;
    int i = this.atW;
    AppMethodBeat.o(134085);
    return i;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.lxp;
  }
  
  public String getVideoPath()
  {
    return this.lwY;
  }
  
  protected final void h(Surface paramSurface)
  {
    AppMethodBeat.i(134083);
    com.tencent.e.h.MqF.aO(new VideoTextureView.2(this, paramSurface));
    AppMethodBeat.o(134083);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134087);
    if ((this.luF != null) && (this.lwZ) && (!this.lxr) && (!this.lxs)) {}
    for (;;)
    {
      try
      {
        bool = this.luF.isPlaying();
        ae.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.lxr), Boolean.valueOf(this.lwZ) });
        AppMethodBeat.o(134087);
        return bool;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.VideoTextureView", localException, "isPlaying", new Object[0]);
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
    this.ozo.y(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.ozo.lyb, this.ozo.lyc);
    AppMethodBeat.o(134095);
  }
  
  public final void p(double paramDouble)
  {
    AppMethodBeat.i(134091);
    if (this.luF != null)
    {
      this.luF.seekTo((int)paramDouble);
      this.cvk = true;
      ae.d("MicroMsg.VideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.luF.getCurrentPosition());
    }
    AppMethodBeat.o(134091);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(134084);
    if ((this.luF != null) && (this.lwZ) && (this.luF.isPlaying()))
    {
      ae.d("MicroMsg.VideoTextureView", "pause video.");
      this.luF.pause();
    }
    this.cvk = false;
    AppMethodBeat.o(134084);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.lxh = paramBoolean;
    this.ozo.lxh = this.lxh;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(134088);
    if (this.luF != null) {
      this.luF.setLooping(paramBoolean);
    }
    this.iuX = true;
    AppMethodBeat.o(134088);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134093);
    ae.i("MicroMsg.VideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.fOX = paramBoolean;
    if (this.luF != null)
    {
      if (this.fOX)
      {
        this.luF.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(134093);
        return;
      }
      this.luF.setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(134093);
  }
  
  public void setOnInfoCallback(h.b paramb)
  {
    this.FDI = paramb;
  }
  
  public void setOnSeekCompleteCallback(h.c paramc)
  {
    this.FDx = paramc;
  }
  
  public void setOnSurfaceCallback(h.d paramd)
  {
    this.qbt = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(h.e parame)
  {
    this.FDw = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(134094);
    this.ozo.a(parame);
    requestLayout();
    AppMethodBeat.o(134094);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(h.a parama)
  {
    this.qbr = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134078);
    this.lwY = paramString;
    this.cvk = false;
    bpx();
    requestLayout();
    AppMethodBeat.o(134078);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(134089);
    if (this.mSurface == null)
    {
      ae.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.lxq = true;
      this.cvk = true;
      AppMethodBeat.o(134089);
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = bu.aRi();; l = this.startTime)
    {
      this.startTime = l;
      ae.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.lwZ), Boolean.valueOf(this.lxr) });
      if ((this.luF == null) || (!this.lwZ)) {
        break;
      }
      if (this.lxr)
      {
        this.lxr = false;
        setMute(this.fOX);
      }
      this.luF.start();
      this.cvk = true;
      AppMethodBeat.o(134089);
      return true;
    }
    if ((this.luF == null) && (this.lwZ))
    {
      this.cvk = true;
      bpx();
      requestLayout();
      AppMethodBeat.o(134089);
      return true;
    }
    this.cvk = true;
    AppMethodBeat.o(134089);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(134079);
    long l1;
    long l3;
    if (this.lxf > 0L)
    {
      l1 = this.lxf - this.startTime;
      l3 = bu.aRi() - this.startTime;
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
      ae.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.qbr != null) {
        this.qbr.eU(i, getDuration());
      }
      bpw();
      this.ozo.reset();
      try
      {
        if ((this.mSurface != null) && (this.lwZ))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            ae.i("MicroMsg.VideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
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
          ae.printErrStackTrace("MicroMsg.VideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.lwY = "";
      this.lxg = 0;
      this.lwZ = false;
      this.cvk = false;
      this.lxp = 0L;
      AppMethodBeat.o(134079);
      return;
      l1 = 2147483647L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView
 * JD-Core Version:    0.7.0.1
 */