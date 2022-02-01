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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import java.io.FileDescriptor;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView
  extends MMTextureView
  implements j
{
  private j.e KwA;
  private j.c KwB;
  private j.b KwM;
  private MediaPlayer.OnSeekCompleteListener KwN;
  private MediaPlayer.OnBufferingUpdateListener KwO;
  private MediaPlayer.OnInfoListener KwP;
  private int atU;
  private float bdN;
  protected long buq;
  private boolean cJi;
  protected FileDescriptor fd;
  private boolean guh;
  private boolean jqj;
  protected long length;
  private MediaPlayer mBq;
  MediaPlayer.OnPreparedListener mBr;
  MediaPlayer.OnVideoSizeChangedListener mBs;
  private MediaPlayer.OnCompletionListener mBt;
  private MediaPlayer.OnErrorListener mBw;
  private String mDV;
  private boolean mDW;
  private int mEX;
  private int mEY;
  private long mEc;
  private int mEd;
  private boolean mEe;
  private long mEm;
  private boolean mEn;
  private boolean mEo;
  private boolean mEp;
  TextureView.SurfaceTextureListener mEq;
  private Surface mSurface;
  private int mVideoHeight;
  private int mVideoWidth;
  private w pMX;
  private j.a rso;
  private j.d rsq;
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
    this.mBq = null;
    this.startTime = 0L;
    this.mEc = 0L;
    this.mEX = 0;
    this.mEY = 0;
    this.mEd = 0;
    this.jqj = false;
    this.mEe = false;
    this.mBs = new MediaPlayer.OnVideoSizeChangedListener()
    {
      public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134066);
        try
        {
          if (paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this))
          {
            Log.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
            AppMethodBeat.o(134066);
            return;
          }
          VideoTextureView.a(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoWidth());
          VideoTextureView.b(VideoTextureView.this, paramAnonymousMediaPlayer.getVideoHeight());
          Log.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.b(VideoTextureView.this) + " , " + VideoTextureView.c(VideoTextureView.this) + " )");
          if (VideoTextureView.d(VideoTextureView.this) != null) {
            VideoTextureView.d(VideoTextureView.this).eo(VideoTextureView.b(VideoTextureView.this), VideoTextureView.c(VideoTextureView.this));
          }
        }
        catch (Exception paramAnonymousMediaPlayer)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.VideoTextureView", paramAnonymousMediaPlayer, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          }
        }
        VideoTextureView.e(VideoTextureView.this);
        AppMethodBeat.o(134066);
      }
    };
    this.mBr = new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134067);
        if ((paramAnonymousMediaPlayer != VideoTextureView.a(VideoTextureView.this)) && (paramAnonymousMediaPlayer != null))
        {
          Log.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramAnonymousMediaPlayer, VideoTextureView.a(VideoTextureView.this) });
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
          Log.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(VideoTextureView.b(VideoTextureView.this)), Integer.valueOf(VideoTextureView.c(VideoTextureView.this)), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)) });
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
            VideoTextureView.d(VideoTextureView.this).tf();
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
    this.KwN = new MediaPlayer.OnSeekCompleteListener()
    {
      public final void onSeekComplete(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134068);
        if (paramAnonymousMediaPlayer != null) {}
        for (int i = paramAnonymousMediaPlayer.getCurrentPosition();; i = -1)
        {
          Log.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(VideoTextureView.g(VideoTextureView.this)), Boolean.valueOf(VideoTextureView.j(VideoTextureView.this)) });
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
            VideoTextureView.k(VideoTextureView.this).fN(VideoTextureView.g(VideoTextureView.this));
          }
          VideoTextureView.a(VideoTextureView.this, 0L);
          AppMethodBeat.o(134068);
          return;
          label141:
          VideoTextureView.this.pause();
        }
      }
    };
    this.KwO = new MediaPlayer.OnBufferingUpdateListener()
    {
      public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
      {
        AppMethodBeat.i(134069);
        Log.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
        VideoTextureView.c(VideoTextureView.this, paramAnonymousInt);
        AppMethodBeat.o(134069);
      }
    };
    this.KwP = new MediaPlayer.OnInfoListener()
    {
      public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134070);
        Log.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (VideoTextureView.l(VideoTextureView.this) != null) {
          VideoTextureView.l(VideoTextureView.this).ep(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134070);
        return false;
      }
    };
    this.mBt = new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(134071);
        Log.i("MicroMsg.VideoTextureView", "video on completion");
        VideoTextureView.b(VideoTextureView.this, Util.nowSecond());
        if (VideoTextureView.d(VideoTextureView.this) != null) {
          VideoTextureView.d(VideoTextureView.this).onCompletion();
        }
        AppMethodBeat.o(134071);
      }
    };
    this.mBw = new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134072);
        Log.w("MicroMsg.VideoTextureView", "Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
        if (VideoTextureView.d(VideoTextureView.this) != null) {
          VideoTextureView.d(VideoTextureView.this).onError(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(134072);
        return true;
      }
    };
    this.mEm = 0L;
    this.mEn = false;
    this.mEo = false;
    this.mEp = false;
    this.mEq = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(134076);
        VideoTextureView.d(VideoTextureView.this, paramAnonymousInt1);
        VideoTextureView.e(VideoTextureView.this, paramAnonymousInt2);
        VideoTextureView.this.gLi();
        VideoTextureView.this.h(VideoTextureView.t(VideoTextureView.this));
        VideoTextureView.a(VideoTextureView.this, new Surface(paramAnonymousSurfaceTexture));
        Log.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)), Integer.valueOf(VideoTextureView.t(VideoTextureView.this).hashCode()) });
        if ((VideoTextureView.a(VideoTextureView.this) == null) || (!VideoTextureView.s(VideoTextureView.this)))
        {
          VideoTextureView.v(VideoTextureView.this);
          if (VideoTextureView.x(VideoTextureView.this) != null) {
            VideoTextureView.x(VideoTextureView.this).bgX();
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
        Log.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Boolean.valueOf(VideoTextureView.s(VideoTextureView.this)) });
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
        Log.i("MicroMsg.VideoTextureView", "on texture size changed width : " + paramAnonymousInt1 + " height : " + paramAnonymousInt2);
        if ((VideoTextureView.a(VideoTextureView.this) != null) && (VideoTextureView.s(VideoTextureView.this)) && (VideoTextureView.b(VideoTextureView.this) == paramAnonymousInt1) && (VideoTextureView.c(VideoTextureView.this) == paramAnonymousInt2)) {
          VideoTextureView.a(VideoTextureView.this).start();
        }
        AppMethodBeat.o(134074);
      }
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(134073);
        Log.d("MicroMsg.VideoTextureView", "on surface texture updated");
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
            VideoTextureView.o(VideoTextureView.this).bLh();
            VideoTextureView.p(VideoTextureView.this);
          }
          VideoTextureView.a(VideoTextureView.this, System.currentTimeMillis());
          if (VideoTextureView.q(VideoTextureView.this))
          {
            Log.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", new Object[] { Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(VideoTextureView.this.getCurrentPosition()) });
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
    this.guh = false;
    this.pMX = new w();
    this.bdN = -1.0F;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    setSurfaceTextureListener(this.mEq);
    setFocusable(true);
    setFocusableInTouchMode(true);
    AppMethodBeat.o(134077);
  }
  
  private void bLc()
  {
    boolean bool1 = true;
    AppMethodBeat.i(134080);
    int i = hashCode();
    boolean bool2 = this.mDW;
    if (this.mBq == null) {}
    for (;;)
    {
      Log.i("MicroMsg.VideoTextureView", "%d release media player isPrepared[%b] player is null[%b] ", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if (this.mBq != null)
      {
        this.mBq.setOnErrorListener(null);
        this.mBq.setOnVideoSizeChangedListener(null);
      }
      try
      {
        this.mBq.stop();
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            this.mBq.reset();
            this.mBq.release();
            this.mBq.setOnBufferingUpdateListener(null);
            this.mBq = null;
            AppMethodBeat.o(134080);
            return;
            bool1 = false;
            break;
            localException1 = localException1;
            Log.printErrStackTrace("MicroMsg.VideoTextureView", localException1, "stop media player error", new Object[0]);
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.VideoTextureView", localException2, "reset media player error", new Object[0]);
          }
        }
      }
    }
  }
  
  private void bLd()
  {
    AppMethodBeat.i(134081);
    if (((Util.isNullOrNil(this.mDV)) && ((this.fd == null) || (!this.fd.valid()))) || (this.mSurface == null))
    {
      AppMethodBeat.o(134081);
      return;
    }
    bLc();
    Log.i("MicroMsg.VideoTextureView", "%d open video %s", new Object[] { Integer.valueOf(hashCode()), this.mDV });
    try
    {
      this.mBq = new k();
      this.mBq.setOnPreparedListener(this.mBr);
      this.mBq.setOnVideoSizeChangedListener(this.mBs);
      this.mDW = false;
      Log.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
      this.atU = -1;
      this.mEd = 0;
      this.mBq.setOnCompletionListener(this.mBt);
      this.mBq.setOnErrorListener(this.mBw);
      this.mBq.setOnSeekCompleteListener(this.KwN);
      this.mBq.setOnBufferingUpdateListener(this.KwO);
      this.mBq.setOnInfoListener(this.KwP);
      if (!Util.isNullOrNil(this.mDV)) {
        this.mBq.setDataSource(this.mDV);
      }
      for (;;)
      {
        this.mBq.setSurface(this.mSurface);
        this.mBq.setAudioStreamType(3);
        this.mBq.setScreenOnWhilePlaying(true);
        this.mBq.prepareAsync();
        this.mVideoHeight = this.mBq.getVideoHeight();
        this.mVideoWidth = this.mBq.getVideoWidth();
        setMute(this.guh);
        aO(this.bdN);
        Log.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mBq.hashCode()) });
        AppMethodBeat.o(134081);
        return;
        if (this.fd != null) {
          this.mBq.setDataSource(this.fd, this.buq, this.length);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.VideoTextureView", localException, "prepare async error path", new Object[0]);
      if (this.rso != null) {
        this.rso.onError(-1, -1);
      }
      AppMethodBeat.o(134081);
    }
  }
  
  private boolean cj(float paramFloat)
  {
    AppMethodBeat.i(134097);
    if (Build.VERSION.SDK_INT >= 23) {}
    try
    {
      if ((this.mBq != null) && (d.oD(23)))
      {
        PlaybackParams localPlaybackParams2 = this.mBq.getPlaybackParams();
        PlaybackParams localPlaybackParams1 = localPlaybackParams2;
        if (localPlaybackParams2 == null) {
          localPlaybackParams1 = new PlaybackParams();
        }
        this.mBq.setPlaybackParams(localPlaybackParams1.setSpeed(paramFloat));
      }
      AppMethodBeat.o(134097);
      return true;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.VideoTextureView", localException, "%s handle play rate error", new Object[] { Integer.valueOf(hashCode()) });
      AppMethodBeat.o(134097);
    }
    return false;
  }
  
  public final boolean E(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(134090);
    paramBoolean = start();
    AppMethodBeat.o(134090);
    return paramBoolean;
  }
  
  public final void a(FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(208753);
    this.fd = paramFileDescriptor;
    this.buq = paramLong1;
    this.length = paramLong2;
    this.cJi = false;
    bLd();
    requestLayout();
    AppMethodBeat.o(208753);
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(134096);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(134096);
      return false;
    }
    this.bdN = paramFloat;
    if (d.oD(23))
    {
      boolean bool = cj(this.bdN);
      AppMethodBeat.o(134096);
      return bool;
    }
    AppMethodBeat.o(134096);
    return false;
  }
  
  public final void bLe()
  {
    AppMethodBeat.i(134082);
    if ((this.mBq != null) && (this.mDW) && (this.mSurface != null) && (this.mSurface.isValid()))
    {
      Log.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()) });
      this.mEp = true;
      this.mBq.setVolume(0.0F, 0.0F);
      this.mBq.start();
    }
    AppMethodBeat.o(134082);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(134092);
    q(paramDouble);
    this.cJi = paramBoolean;
    AppMethodBeat.o(134092);
  }
  
  public int getCurrentPosition()
  {
    AppMethodBeat.i(134086);
    if ((this.mBq != null) && (this.mDW))
    {
      int i = this.mBq.getCurrentPosition();
      AppMethodBeat.o(134086);
      return i;
    }
    if (this.mBq == null)
    {
      AppMethodBeat.o(134086);
      return -1;
    }
    AppMethodBeat.o(134086);
    return 0;
  }
  
  public int getDownloadPercent()
  {
    return this.mEd;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(134085);
    if ((this.mBq != null) && (this.mDW))
    {
      if (this.atU > 0)
      {
        i = this.atU;
        AppMethodBeat.o(134085);
        return i;
      }
      this.atU = this.mBq.getDuration();
      i = this.atU;
      AppMethodBeat.o(134085);
      return i;
    }
    this.atU = -1;
    int i = this.atU;
    AppMethodBeat.o(134085);
    return i;
  }
  
  public double getLastProgresstime()
  {
    return 0.0D;
  }
  
  public long getLastSurfaceUpdateTime()
  {
    return this.mEm;
  }
  
  public String getVideoPath()
  {
    return this.mDV;
  }
  
  protected final void h(Surface paramSurface)
  {
    AppMethodBeat.i(134083);
    h.RTc.aX(new VideoTextureView.2(this, paramSurface));
    AppMethodBeat.o(134083);
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(134087);
    if ((this.mBq != null) && (this.mDW) && (!this.mEo) && (!this.mEp)) {}
    for (;;)
    {
      try
      {
        bool = this.mBq.isPlaying();
        Log.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(bool), Boolean.valueOf(this.mEo), Boolean.valueOf(this.mDW) });
        AppMethodBeat.o(134087);
        return bool;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.VideoTextureView", localException, "isPlaying", new Object[0]);
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
    this.pMX.y(paramInt1, paramInt2, i, j);
    setMeasuredDimension(this.pMX.mEZ, this.pMX.mFa);
    AppMethodBeat.o(134095);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(134084);
    if ((this.mBq != null) && (this.mDW) && (this.mBq.isPlaying()))
    {
      Log.d("MicroMsg.VideoTextureView", "pause video.");
      this.mBq.pause();
    }
    this.cJi = false;
    AppMethodBeat.o(134084);
  }
  
  public final void q(double paramDouble)
  {
    AppMethodBeat.i(134091);
    if (this.mBq != null)
    {
      this.mBq.seekTo((int)paramDouble);
      this.cJi = true;
      Log.d("MicroMsg.VideoTextureView", "seek to time: " + paramDouble + " curr pos : " + this.mBq.getCurrentPosition());
    }
    AppMethodBeat.o(134091);
  }
  
  public void setForceScaleFullScreen(boolean paramBoolean)
  {
    this.mEe = paramBoolean;
    this.pMX.mEe = this.mEe;
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(134088);
    if (this.mBq != null) {
      this.mBq.setLooping(paramBoolean);
    }
    this.jqj = true;
    AppMethodBeat.o(134088);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(134093);
    Log.i("MicroMsg.VideoTextureView", "%d set mute %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean) });
    this.guh = paramBoolean;
    if (this.mBq != null)
    {
      if (this.guh)
      {
        this.mBq.setVolume(0.0F, 0.0F);
        AppMethodBeat.o(134093);
        return;
      }
      this.mBq.setVolume(1.0F, 1.0F);
    }
    AppMethodBeat.o(134093);
  }
  
  public void setOnInfoCallback(j.b paramb)
  {
    this.KwM = paramb;
  }
  
  public void setOnSeekCompleteCallback(j.c paramc)
  {
    this.KwB = paramc;
  }
  
  public void setOnSurfaceCallback(j.d paramd)
  {
    this.rsq = paramd;
  }
  
  public void setOneTimeVideoTextureUpdateCallback(j.e parame)
  {
    this.KwA = parame;
  }
  
  public void setPlayProgressCallback(boolean paramBoolean) {}
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(134094);
    this.pMX.a(parame);
    requestLayout();
    AppMethodBeat.o(134094);
  }
  
  public void setThumb(Bitmap paramBitmap) {}
  
  public void setVideoCallback(j.a parama)
  {
    this.rso = parama;
  }
  
  public void setVideoPath(String paramString)
  {
    AppMethodBeat.i(134078);
    this.mDV = paramString;
    this.cJi = false;
    bLd();
    requestLayout();
    AppMethodBeat.o(134078);
  }
  
  public final boolean start()
  {
    AppMethodBeat.i(134089);
    if (this.mSurface == null)
    {
      Log.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", new Object[] { Integer.valueOf(hashCode()) });
      this.mEn = true;
      this.cJi = true;
      AppMethodBeat.o(134089);
      return false;
    }
    if (this.startTime == 0L) {}
    for (long l = Util.nowSecond();; l = this.startTime)
    {
      this.startTime = l;
      Log.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", new Object[] { Long.valueOf(this.startTime), Boolean.valueOf(this.mDW), Boolean.valueOf(this.mEo) });
      if ((this.mBq == null) || (!this.mDW)) {
        break;
      }
      if (this.mEo)
      {
        this.mEo = false;
        setMute(this.guh);
      }
      this.mBq.start();
      this.cJi = true;
      AppMethodBeat.o(134089);
      return true;
    }
    if ((this.mBq == null) && (this.mDW))
    {
      this.cJi = true;
      bLd();
      requestLayout();
      AppMethodBeat.o(134089);
      return true;
    }
    this.cJi = true;
    AppMethodBeat.o(134089);
    return false;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(134079);
    long l1;
    long l3;
    if (this.mEc > 0L)
    {
      l1 = this.mEc - this.startTime;
      l3 = Util.nowSecond() - this.startTime;
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
      Log.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[] { Integer.valueOf(getDuration()), Long.valueOf(l3), Long.valueOf(l1) });
      if (this.rso != null) {
        this.rso.fh(i, getDuration());
      }
      bLc();
      this.pMX.reset();
      try
      {
        if ((this.mSurface != null) && (this.mDW))
        {
          Object localObject1 = getSurfaceTexture();
          if (localObject1 != null)
          {
            Log.i("MicroMsg.VideoTextureView", "%d releaseSurface", new Object[] { Integer.valueOf(hashCode()) });
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
          Log.printErrStackTrace("MicroMsg.VideoTextureView", localException, "release surface", new Object[0]);
        }
      }
      this.mDV = "";
      this.mEd = 0;
      this.mDW = false;
      this.cJi = false;
      this.mEm = 0L;
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