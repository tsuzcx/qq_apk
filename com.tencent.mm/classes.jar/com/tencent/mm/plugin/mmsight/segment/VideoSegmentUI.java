package com.tencent.mm.plugin.mmsight.segment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@com.tencent.mm.ui.base.a(3)
public class VideoSegmentUI
  extends MMActivity
{
  private CountDownLatch cJf;
  private ProgressDialog fOC;
  private com.tencent.mm.remoteservice.d gkS;
  private int ipL;
  private Surface mSurface;
  private String pYH;
  private RelativeLayout rJz;
  private String thumbPath;
  private VideoTransPara vZX;
  private String wfn;
  private f wfo;
  private com.tencent.mm.plugin.mmsight.segment.a.c wfp;
  private boolean wfq;
  private c wfr;
  private int wfs;
  private boolean wft;
  private boolean wfu;
  private boolean wfv;
  private c.b wfw;
  private com.tencent.mm.plugin.mmsight.segment.a.c.a wfx;
  private a.d wfy;
  
  public VideoSegmentUI()
  {
    AppMethodBeat.i(94488);
    this.wfn = null;
    this.wfq = false;
    this.cJf = new CountDownLatch(2);
    this.wfs = 10000;
    this.fOC = null;
    this.gkS = new com.tencent.mm.remoteservice.d(this);
    this.pYH = "";
    this.wft = false;
    this.wfu = false;
    this.wfv = false;
    this.wfw = new c.b()
    {
      public final void S(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(94463);
        if (VideoSegmentUI.d(VideoSegmentUI.this) == null)
        {
          AppMethodBeat.o(94463);
          return;
        }
        int i = VideoSegmentUI.e(VideoSegmentUI.this);
        VideoSegmentUI.d(VideoSegmentUI.this).setLoop((int)(i * paramAnonymousFloat1), (int)(i * paramAnonymousFloat2));
        VideoSegmentUI.d(VideoSegmentUI.this).seekTo((int)(i * paramAnonymousFloat1));
        AppMethodBeat.o(94463);
      }
      
      public final void T(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(94464);
        if (VideoSegmentUI.d(VideoSegmentUI.this) == null)
        {
          AppMethodBeat.o(94464);
          return;
        }
        VideoSegmentUI.d(VideoSegmentUI.this).pause();
        AppMethodBeat.o(94464);
      }
      
      public final void U(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(94465);
        if (VideoSegmentUI.d(VideoSegmentUI.this) == null)
        {
          AppMethodBeat.o(94465);
          return;
        }
        int i = (int)(VideoSegmentUI.e(VideoSegmentUI.this) * paramAnonymousFloat1);
        int j = (int)(VideoSegmentUI.e(VideoSegmentUI.this) * paramAnonymousFloat2);
        VideoSegmentUI.d(VideoSegmentUI.this).setLoop(i, j);
        VideoSegmentUI.d(VideoSegmentUI.this).seekTo(i);
        AppMethodBeat.o(94465);
      }
      
      public final void V(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(94466);
        if ((paramAnonymousFloat2 - paramAnonymousFloat1) * VideoSegmentUI.e(VideoSegmentUI.this) <= VideoSegmentUI.p(VideoSegmentUI.this))
        {
          VideoSegmentUI.this.enableOptionMenu(true);
          AppMethodBeat.o(94466);
          return;
        }
        VideoSegmentUI.this.enableOptionMenu(false);
        AppMethodBeat.o(94466);
      }
    };
    this.wfx = new com.tencent.mm.plugin.mmsight.segment.a.c.a()
    {
      private Runnable wfA;
      
      public final void KR(int paramAnonymousInt)
      {
        AppMethodBeat.i(94467);
        if (VideoSegmentUI.j(VideoSegmentUI.this) == null)
        {
          AppMethodBeat.o(94467);
          return;
        }
        if (this.wfA != null) {
          ((View)VideoSegmentUI.j(VideoSegmentUI.this)).removeCallbacks(this.wfA);
        }
        this.wfA = new VideoSegmentUI.c(VideoSegmentUI.j(VideoSegmentUI.this), paramAnonymousInt, VideoSegmentUI.e(VideoSegmentUI.this));
        ((View)VideoSegmentUI.j(VideoSegmentUI.this)).post(this.wfA);
        AppMethodBeat.o(94467);
      }
    };
    this.wfy = new a.d()
    {
      public final void ak(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(94468);
        if ((paramAnonymousInt1 <= 0) || (paramAnonymousInt2 <= 0))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(VideoSegmentUI.q(VideoSegmentUI.this)) });
          AppMethodBeat.o(94468);
          return;
        }
        if (VideoSegmentUI.q(VideoSegmentUI.this))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
          AppMethodBeat.o(94468);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoSegmentUI.r(VideoSegmentUI.this);
        if ((paramAnonymousInt2 <= 0) || (paramAnonymousInt1 <= 0))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          VideoSegmentUI.m(VideoSegmentUI.this);
          VideoSegmentUI.this.finish();
          VideoSegmentUI.b(VideoSegmentUI.this);
          AppMethodBeat.o(94468);
          return;
        }
        VideoSegmentUI.a locala = new VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.s(VideoSegmentUI.this), paramAnonymousInt2, paramAnonymousInt1, paramAnonymousInt3, new VideoSegmentUI.b(VideoSegmentUI.this, (byte)0), (byte)0);
        if ((VideoSegmentUI.s(VideoSegmentUI.this).getWidth() <= 0) || (VideoSegmentUI.s(VideoSegmentUI.this).getHeight() <= 0))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
          VideoSegmentUI.s(VideoSegmentUI.this).post(locala);
          AppMethodBeat.o(94468);
          return;
        }
        locala.run();
        AppMethodBeat.o(94468);
      }
    };
    AppMethodBeat.o(94488);
  }
  
  private void a(boolean paramBoolean, Surface paramSurface)
  {
    AppMethodBeat.i(94491);
    if (this.wfp != null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
      AppMethodBeat.o(94491);
      return;
    }
    this.wfp = new com.tencent.mm.plugin.mmsight.segment.a.c();
    this.wfq = false;
    this.wfp.setDataSource(this.wfn);
    this.wfp.a(new a.a()
    {
      public final boolean gB(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(94475);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoSegmentUI.m(VideoSegmentUI.this);
        VideoSegmentUI.this.finish();
        VideoSegmentUI.b(VideoSegmentUI.this);
        AppMethodBeat.o(94475);
        return true;
      }
    });
    if (paramBoolean) {
      this.wfp.a(this.wfy);
    }
    this.wfp.setAudioStreamType(3);
    this.wfp.setLooping(true);
    if (paramSurface != null) {
      this.wfp.setSurface(paramSurface);
    }
    this.wfp.wfx = this.wfx;
    this.wfp.a(new a.b()
    {
      public final void dw(Object paramAnonymousObject)
      {
        AppMethodBeat.i(94476);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", new Object[] { paramAnonymousObject });
        try
        {
          if (VideoSegmentUI.d(VideoSegmentUI.this) != null)
          {
            VideoSegmentUI.n(VideoSegmentUI.this);
            VideoSegmentUI.d(VideoSegmentUI.this).start();
          }
          AppMethodBeat.o(94476);
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.VideoSegmentUI", paramAnonymousObject, "hy: exception when onPrepared waiting for starting", new Object[0]);
          AppMethodBeat.o(94476);
        }
      }
    });
    this.wfp.prepareAsync();
    this.wfp.a(new a.c()
    {
      public final void dx(Object paramAnonymousObject)
      {
        AppMethodBeat.i(94477);
        try
        {
          if (VideoSegmentUI.d(VideoSegmentUI.this) != null) {
            VideoSegmentUI.d(VideoSegmentUI.this).start();
          }
          AppMethodBeat.o(94477);
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.VideoSegmentUI", paramAnonymousObject, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
          AppMethodBeat.o(94477);
        }
      }
    });
    AppMethodBeat.o(94491);
  }
  
  public int getLayoutId()
  {
    return 2131495842;
  }
  
  public void initView()
  {
    AppMethodBeat.i(94490);
    this.wfr = ((c)findViewById(2131304490));
    this.rJz = ((RelativeLayout)findViewById(2131304239));
    AppMethodBeat.o(94490);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94489);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.gkS));
    this.gkS.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94462);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "has connect");
        if (CaptureMMProxy.getInstance() != null) {
          com.tencent.mm.compatible.deviceinfo.ae.vE(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        VideoSegmentUI.a(VideoSegmentUI.this);
        AppMethodBeat.o(94462);
      }
    });
    AppMethodBeat.o(94489);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94494);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "onDestroy");
    super.onDestroy();
    getWindow().clearFlags(128);
    this.gkS.release();
    if (this.wfr != null) {
      this.wfr.release();
    }
    if (this.wfp != null) {
      this.wfp.release();
    }
    if (this.mSurface != null) {
      this.mSurface.release();
    }
    if (this.wfo != null) {
      this.wfo.release();
    }
    k.wcg.ayL();
    AppMethodBeat.o(94494);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94493);
    if (this.wfp != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "onPause pause player");
      this.wfp.pause();
    }
    super.onPause();
    AppMethodBeat.o(94493);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(94492);
    if ((this.wfp != null) && (this.wfq))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "onResume start player");
      this.wfp.start();
    }
    super.onResume();
    AppMethodBeat.o(94492);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    implements Runnable
  {
    private Context context;
    private ViewGroup gJt;
    private int wfF;
    private int wfG;
    private int wfH;
    private VideoSegmentUI.b wfI;
    
    private a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, VideoSegmentUI.b paramb)
    {
      AppMethodBeat.i(94480);
      this.wfF = paramInt1;
      this.wfG = paramInt2;
      this.wfH = paramInt3;
      this.context = paramViewGroup.getContext();
      this.gJt = paramViewGroup;
      this.wfI = paramb;
      AppMethodBeat.o(94480);
    }
    
    public final void run()
    {
      AppMethodBeat.i(94481);
      if (VideoSegmentUI.this.isFinishing())
      {
        AppMethodBeat.o(94481);
        return;
      }
      Object localObject = new MMTextureView(this.context)
      {
        protected final void onMeasure(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(94479);
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", new Object[] { Integer.valueOf(VideoSegmentUI.a.a(VideoSegmentUI.a.this)), Integer.valueOf(VideoSegmentUI.a.b(VideoSegmentUI.a.this)), Integer.valueOf(VideoSegmentUI.a.c(VideoSegmentUI.a.this)), Integer.valueOf(View.getDefaultSize(1, paramAnonymousInt1)), Integer.valueOf(View.getDefaultSize(1, paramAnonymousInt2)) });
          if ((VideoSegmentUI.a.c(VideoSegmentUI.a.this) == 90) || (VideoSegmentUI.a.c(VideoSegmentUI.a.this) == 270))
          {
            Matrix localMatrix = new Matrix();
            localMatrix.set(getMatrix());
            int i = View.getDefaultSize(1, paramAnonymousInt1);
            int j = View.getDefaultSize(1, paramAnonymousInt2);
            float f1 = i / 2.0F;
            float f2 = j / 2.0F;
            float f3 = j / i;
            localMatrix.postRotate(VideoSegmentUI.a.c(VideoSegmentUI.a.this), f1, f2);
            localMatrix.postScale(1.0F / f3, f3, f1, f2);
            setTransform(localMatrix);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", new Object[] { Integer.valueOf(VideoSegmentUI.a.c(VideoSegmentUI.a.this)), Integer.valueOf(i), Integer.valueOf(j) });
          }
          super.onMeasure(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(94479);
        }
      };
      int i = this.gJt.getWidth();
      int j = com.tencent.mm.cb.a.ax(this.context, 2131166957);
      int k = ((View)VideoSegmentUI.j(VideoSegmentUI.this)).getTop() - j * 2;
      int m = this.wfG;
      int n = this.wfF;
      Point localPoint = new Point();
      if (n / m > k / i) {}
      for (float f = k / n;; f = i / m)
      {
        localPoint.x = ((int)(m * f));
        localPoint.y = ((int)(f * n));
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.wfG), Integer.valueOf(this.wfF), Integer.valueOf(this.wfH), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
        if ((localPoint.x > 0) && (localPoint.y > 0)) {
          break;
        }
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.wfG), Integer.valueOf(this.wfF), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
        if (this.wfI != null)
        {
          localObject = this.wfI;
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
          VideoSegmentUI.m(((VideoSegmentUI.b)localObject).wfz);
          ((VideoSegmentUI.b)localObject).wfz.finish();
          VideoSegmentUI.b(((VideoSegmentUI.b)localObject).wfz);
        }
        AppMethodBeat.o(94481);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(localPoint.x, localPoint.y);
      j += (int)((k - localPoint.y) / 2.0F);
      localLayoutParams.topMargin = j;
      localLayoutParams.bottomMargin = j;
      i = (int)((i - localPoint.x) / 2.0F);
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      ((MMTextureView)localObject).setSurfaceTextureListener(this.wfI);
      this.gJt.addView((View)localObject, 0, localLayoutParams);
      AppMethodBeat.o(94481);
    }
  }
  
  final class b
    implements TextureView.SurfaceTextureListener
  {
    private b() {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(94482);
      boolean bool2 = VideoSegmentUI.w(VideoSegmentUI.this);
      boolean bool1;
      if (VideoSegmentUI.d(VideoSegmentUI.this) == null) {
        bool1 = true;
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        VideoSegmentUI.b(VideoSegmentUI.this, new Surface(paramSurfaceTexture));
        if ((VideoSegmentUI.d(VideoSegmentUI.this) == null) && (VideoSegmentUI.w(VideoSegmentUI.this))) {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
        }
        try
        {
          VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.u(VideoSegmentUI.this));
          if ((VideoSegmentUI.j(VideoSegmentUI.this) != null) && (VideoSegmentUI.d(VideoSegmentUI.this) != null)) {
            VideoSegmentUI.d(VideoSegmentUI.this).setLoop((int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).dqx()), (int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).dqy()));
          }
          VideoSegmentUI.a(VideoSegmentUI.this, false);
          VideoSegmentUI.o(VideoSegmentUI.this).countDown();
          AppMethodBeat.o(94482);
          return;
          bool1 = false;
        }
        catch (Exception paramSurfaceTexture)
        {
          for (;;)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.VideoSegmentUI", paramSurfaceTexture, "ResumeMediaPlayer error %s", new Object[] { paramSurfaceTexture.getMessage() });
          }
        }
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(94483);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", new Object[] { bu.fpN() });
      try
      {
        if (VideoSegmentUI.d(VideoSegmentUI.this) != null)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
          VideoSegmentUI.d(VideoSegmentUI.this).release();
          VideoSegmentUI.v(VideoSegmentUI.this);
          VideoSegmentUI.a(VideoSegmentUI.this, true);
        }
        VideoSegmentUI.b(VideoSegmentUI.this, null);
      }
      catch (Exception paramSurfaceTexture)
      {
        label75:
        break label75;
      }
      AppMethodBeat.o(94483);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
  
  static final class c
    implements Runnable
  {
    private int ipL;
    private WeakReference<c> og;
    private int wfK;
    
    public c(c paramc, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(94484);
      this.og = new WeakReference(paramc);
      this.wfK = paramInt1;
      this.ipL = paramInt2;
      AppMethodBeat.o(94484);
    }
    
    public final void run()
    {
      AppMethodBeat.i(94485);
      c localc = (c)this.og.get();
      if (localc == null)
      {
        AppMethodBeat.o(94485);
        return;
      }
      localc.setCurrentCursorPosition(this.wfK / this.ipL);
      AppMethodBeat.o(94485);
    }
  }
  
  final class d
    implements Runnable
  {
    private d() {}
    
    public final void run()
    {
      AppMethodBeat.i(94487);
      for (;;)
      {
        try
        {
          bool1 = VideoSegmentUI.o(VideoSegmentUI.this).await(5L, TimeUnit.SECONDS);
          if ((!bool1) || (VideoSegmentUI.t(VideoSegmentUI.this)) || (VideoSegmentUI.this.isFinishing()) || (VideoSegmentUI.u(VideoSegmentUI.this) == null) || (!VideoSegmentUI.u(VideoSegmentUI.this).isValid()))
          {
            boolean bool3 = VideoSegmentUI.t(VideoSegmentUI.this);
            boolean bool4 = VideoSegmentUI.this.isFinishing();
            if (VideoSegmentUI.u(VideoSegmentUI.this) != null) {
              break label336;
            }
            bool2 = true;
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.VideoSegmentUI", "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool2) });
            VideoSegmentUI.this.finish();
            AppMethodBeat.o(94487);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.VideoSegmentUI", "count down latch error %s", new Object[] { localInterruptedException });
          boolean bool1 = false;
          continue;
          if (VideoSegmentUI.d(VideoSegmentUI.this) != null)
          {
            VideoSegmentUI.d(VideoSegmentUI.this).a(null);
            VideoSegmentUI.d(VideoSegmentUI.this).a(null);
            VideoSegmentUI.d(VideoSegmentUI.this).release();
            VideoSegmentUI.v(VideoSegmentUI.this);
          }
          try
          {
            VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.u(VideoSegmentUI.this));
            VideoSegmentUI.d(VideoSegmentUI.this).setSurface(VideoSegmentUI.u(VideoSegmentUI.this));
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94486);
                if ((VideoSegmentUI.t(VideoSegmentUI.this)) || (VideoSegmentUI.this.isFinishing()) || (VideoSegmentUI.j(VideoSegmentUI.this) == null) || (VideoSegmentUI.d(VideoSegmentUI.this) == null))
                {
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
                  AppMethodBeat.o(94486);
                  return;
                }
                ((View)VideoSegmentUI.j(VideoSegmentUI.this)).setAlpha(0.0F);
                ((View)VideoSegmentUI.j(VideoSegmentUI.this)).setVisibility(0);
                ((View)VideoSegmentUI.j(VideoSegmentUI.this)).animate().setDuration(300L).setStartDelay(200L).alpha(1.0F);
                float f1 = VideoSegmentUI.j(VideoSegmentUI.this).dqx();
                float f2 = VideoSegmentUI.j(VideoSegmentUI.this).dqy();
                if ((f2 - f1) * VideoSegmentUI.e(VideoSegmentUI.this) <= VideoSegmentUI.p(VideoSegmentUI.this)) {
                  VideoSegmentUI.this.enableOptionMenu(true);
                }
                VideoSegmentUI.d(VideoSegmentUI.this).setLoop((int)(f1 * VideoSegmentUI.e(VideoSegmentUI.this)), (int)(f2 * VideoSegmentUI.e(VideoSegmentUI.this)));
                AppMethodBeat.o(94486);
              }
            });
            AppMethodBeat.o(94487);
            return;
          }
          catch (IOException localIOException)
          {
            com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.VideoSegmentUI", localIOException, "init segmentPlayer second time %s", new Object[] { localIOException.getMessage() });
            VideoSegmentUI.this.finish();
            AppMethodBeat.o(94487);
            return;
          }
        }
        catch (Exception localException)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.VideoSegmentUI", localException, "Finished when init", new Object[0]);
          VideoSegmentUI.this.finish();
          AppMethodBeat.o(94487);
          return;
        }
        label336:
        boolean bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI
 * JD-Core Version:    0.7.0.1
 */