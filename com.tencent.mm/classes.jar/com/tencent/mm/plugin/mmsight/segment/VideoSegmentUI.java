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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@com.tencent.mm.ui.base.a(3)
public class VideoSegmentUI
  extends MMActivity
{
  private CountDownLatch cZC;
  private com.tencent.mm.remoteservice.d gVN;
  private ProgressDialog gtM;
  private int jkS;
  private Surface mSurface;
  private String rpE;
  private String thumbPath;
  private RelativeLayout tjk;
  private VideoTransPara zua;
  private String zzN;
  private f zzO;
  private com.tencent.mm.plugin.mmsight.segment.a.c zzP;
  private boolean zzQ;
  private c zzR;
  private int zzS;
  private boolean zzT;
  private boolean zzU;
  private boolean zzV;
  private c.b zzW;
  private com.tencent.mm.plugin.mmsight.segment.a.c.a zzX;
  private a.d zzY;
  
  public VideoSegmentUI()
  {
    AppMethodBeat.i(94488);
    this.zzN = null;
    this.zzQ = false;
    this.cZC = new CountDownLatch(2);
    this.zzS = 10000;
    this.gtM = null;
    this.gVN = new com.tencent.mm.remoteservice.d(this);
    this.rpE = "";
    this.zzT = false;
    this.zzU = false;
    this.zzV = false;
    this.zzW = new c.b()
    {
      public final void W(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
      
      public final void X(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
      
      public final void Y(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
      
      public final void Z(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
    this.zzX = new com.tencent.mm.plugin.mmsight.segment.a.c.a()
    {
      private Runnable zAa;
      
      public final void QR(int paramAnonymousInt)
      {
        AppMethodBeat.i(94467);
        if (VideoSegmentUI.j(VideoSegmentUI.this) == null)
        {
          AppMethodBeat.o(94467);
          return;
        }
        if (this.zAa != null) {
          ((View)VideoSegmentUI.j(VideoSegmentUI.this)).removeCallbacks(this.zAa);
        }
        this.zAa = new VideoSegmentUI.c(VideoSegmentUI.j(VideoSegmentUI.this), paramAnonymousInt, VideoSegmentUI.e(VideoSegmentUI.this));
        ((View)VideoSegmentUI.j(VideoSegmentUI.this)).post(this.zAa);
        AppMethodBeat.o(94467);
      }
    };
    this.zzY = new a.d()
    {
      public final void ap(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(94468);
        if ((paramAnonymousInt1 <= 0) || (paramAnonymousInt2 <= 0))
        {
          Log.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(VideoSegmentUI.q(VideoSegmentUI.this)) });
          AppMethodBeat.o(94468);
          return;
        }
        if (VideoSegmentUI.q(VideoSegmentUI.this))
        {
          Log.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
          AppMethodBeat.o(94468);
          return;
        }
        Log.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoSegmentUI.r(VideoSegmentUI.this);
        if ((paramAnonymousInt2 <= 0) || (paramAnonymousInt1 <= 0))
        {
          Log.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
          VideoSegmentUI.m(VideoSegmentUI.this);
          VideoSegmentUI.this.finish();
          VideoSegmentUI.b(VideoSegmentUI.this);
          AppMethodBeat.o(94468);
          return;
        }
        VideoSegmentUI.a locala = new VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.s(VideoSegmentUI.this), paramAnonymousInt2, paramAnonymousInt1, paramAnonymousInt3, new VideoSegmentUI.b(VideoSegmentUI.this, (byte)0), (byte)0);
        if ((VideoSegmentUI.s(VideoSegmentUI.this).getWidth() <= 0) || (VideoSegmentUI.s(VideoSegmentUI.this).getHeight() <= 0))
        {
          Log.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
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
    if (this.zzP != null)
    {
      Log.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
      AppMethodBeat.o(94491);
      return;
    }
    this.zzP = new com.tencent.mm.plugin.mmsight.segment.a.c();
    this.zzQ = false;
    this.zzP.setDataSource(this.zzN);
    this.zzP.a(new a.a()
    {
      public final boolean hc(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(94475);
        Log.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        VideoSegmentUI.m(VideoSegmentUI.this);
        VideoSegmentUI.this.finish();
        VideoSegmentUI.b(VideoSegmentUI.this);
        AppMethodBeat.o(94475);
        return true;
      }
    });
    if (paramBoolean) {
      this.zzP.a(this.zzY);
    }
    this.zzP.setAudioStreamType(3);
    this.zzP.setLooping(true);
    if (paramSurface != null) {
      this.zzP.setSurface(paramSurface);
    }
    this.zzP.zzX = this.zzX;
    this.zzP.a(new a.b()
    {
      public final void dD(Object paramAnonymousObject)
      {
        AppMethodBeat.i(94476);
        Log.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", new Object[] { paramAnonymousObject });
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
          Log.printErrStackTrace("MicroMsg.VideoSegmentUI", paramAnonymousObject, "hy: exception when onPrepared waiting for starting", new Object[0]);
          AppMethodBeat.o(94476);
        }
      }
    });
    this.zzP.prepareAsync();
    this.zzP.a(new a.c()
    {
      public final void dE(Object paramAnonymousObject)
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
          Log.printErrStackTrace("MicroMsg.VideoSegmentUI", paramAnonymousObject, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
          AppMethodBeat.o(94477);
        }
      }
    });
    AppMethodBeat.o(94491);
  }
  
  public int getLayoutId()
  {
    return 2131496811;
  }
  
  public void initView()
  {
    AppMethodBeat.i(94490);
    this.zzR = ((c)findViewById(2131307492));
    this.tjk = ((RelativeLayout)findViewById(2131307157));
    AppMethodBeat.o(94490);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94489);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.gVN));
    this.gVN.connect(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94462);
        Log.i("MicroMsg.VideoSegmentUI", "has connect");
        if (CaptureMMProxy.getInstance() != null) {
          ae.DV(CaptureMMProxy.getInstance().getDeviceInfoConfig());
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
    Log.i("MicroMsg.VideoSegmentUI", "onDestroy");
    super.onDestroy();
    getWindow().clearFlags(128);
    this.gVN.release();
    if (this.zzR != null) {
      this.zzR.release();
    }
    if (this.zzP != null) {
      this.zzP.release();
    }
    if (this.mSurface != null) {
      this.mSurface.release();
    }
    if (this.zzO != null) {
      this.zzO.release();
    }
    k.zwi.aRR();
    AppMethodBeat.o(94494);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94493);
    if (this.zzP != null)
    {
      Log.i("MicroMsg.VideoSegmentUI", "onPause pause player");
      this.zzP.pause();
    }
    super.onPause();
    AppMethodBeat.o(94493);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(94492);
    if ((this.zzP != null) && (this.zzQ))
    {
      Log.i("MicroMsg.VideoSegmentUI", "onResume start player");
      this.zzP.start();
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
    private ViewGroup hwr;
    private int zAf;
    private int zAg;
    private int zAh;
    private VideoSegmentUI.b zAi;
    
    private a(ViewGroup paramViewGroup, int paramInt1, int paramInt2, int paramInt3, VideoSegmentUI.b paramb)
    {
      AppMethodBeat.i(94480);
      this.zAf = paramInt1;
      this.zAg = paramInt2;
      this.zAh = paramInt3;
      this.context = paramViewGroup.getContext();
      this.hwr = paramViewGroup;
      this.zAi = paramb;
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
          Log.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", new Object[] { Integer.valueOf(VideoSegmentUI.a.a(VideoSegmentUI.a.this)), Integer.valueOf(VideoSegmentUI.a.b(VideoSegmentUI.a.this)), Integer.valueOf(VideoSegmentUI.a.c(VideoSegmentUI.a.this)), Integer.valueOf(View.getDefaultSize(1, paramAnonymousInt1)), Integer.valueOf(View.getDefaultSize(1, paramAnonymousInt2)) });
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
            Log.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", new Object[] { Integer.valueOf(VideoSegmentUI.a.c(VideoSegmentUI.a.this)), Integer.valueOf(i), Integer.valueOf(j) });
          }
          super.onMeasure(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(94479);
        }
      };
      int i = this.hwr.getWidth();
      int j = com.tencent.mm.cb.a.aG(this.context, 2131167092);
      int k = ((View)VideoSegmentUI.j(VideoSegmentUI.this)).getTop() - j * 2;
      int m = this.zAg;
      int n = this.zAf;
      Point localPoint = new Point();
      if (n / m > k / i) {}
      for (float f = k / n;; f = i / m)
      {
        localPoint.x = ((int)(m * f));
        localPoint.y = ((int)(f * n));
        Log.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.zAg), Integer.valueOf(this.zAf), Integer.valueOf(this.zAh), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
        if ((localPoint.x > 0) && (localPoint.y > 0)) {
          break;
        }
        Log.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[] { Integer.valueOf(this.zAg), Integer.valueOf(this.zAf), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), localPoint.toString() });
        if (this.zAi != null)
        {
          localObject = this.zAi;
          Log.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
          VideoSegmentUI.m(((VideoSegmentUI.b)localObject).zzZ);
          ((VideoSegmentUI.b)localObject).zzZ.finish();
          VideoSegmentUI.b(((VideoSegmentUI.b)localObject).zzZ);
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
      ((MMTextureView)localObject).setSurfaceTextureListener(this.zAi);
      this.hwr.addView((View)localObject, 0, localLayoutParams);
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
        Log.i("MicroMsg.VideoSegmentUI", "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        VideoSegmentUI.b(VideoSegmentUI.this, new Surface(paramSurfaceTexture));
        if ((VideoSegmentUI.d(VideoSegmentUI.this) == null) && (VideoSegmentUI.w(VideoSegmentUI.this))) {
          Log.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
        }
        try
        {
          VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.u(VideoSegmentUI.this));
          if ((VideoSegmentUI.j(VideoSegmentUI.this) != null) && (VideoSegmentUI.d(VideoSegmentUI.this) != null)) {
            VideoSegmentUI.d(VideoSegmentUI.this).setLoop((int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).eko()), (int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).ekp()));
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
            Log.printErrStackTrace("MicroMsg.VideoSegmentUI", paramSurfaceTexture, "ResumeMediaPlayer error %s", new Object[] { paramSurfaceTexture.getMessage() });
          }
        }
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(94483);
      Log.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", new Object[] { Util.getStack() });
      try
      {
        if (VideoSegmentUI.d(VideoSegmentUI.this) != null)
        {
          Log.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
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
    private int jkS;
    private WeakReference<c> oi;
    private int zAk;
    
    public c(c paramc, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(94484);
      this.oi = new WeakReference(paramc);
      this.zAk = paramInt1;
      this.jkS = paramInt2;
      AppMethodBeat.o(94484);
    }
    
    public final void run()
    {
      AppMethodBeat.i(94485);
      c localc = (c)this.oi.get();
      if (localc == null)
      {
        AppMethodBeat.o(94485);
        return;
      }
      localc.setCurrentCursorPosition(this.zAk / this.jkS);
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
            Log.w("MicroMsg.VideoSegmentUI", "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool2) });
            VideoSegmentUI.this.finish();
            AppMethodBeat.o(94487);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("MicroMsg.VideoSegmentUI", "count down latch error %s", new Object[] { localInterruptedException });
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
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94486);
                if ((VideoSegmentUI.t(VideoSegmentUI.this)) || (VideoSegmentUI.this.isFinishing()) || (VideoSegmentUI.j(VideoSegmentUI.this) == null) || (VideoSegmentUI.d(VideoSegmentUI.this) == null))
                {
                  Log.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
                  AppMethodBeat.o(94486);
                  return;
                }
                ((View)VideoSegmentUI.j(VideoSegmentUI.this)).setAlpha(0.0F);
                ((View)VideoSegmentUI.j(VideoSegmentUI.this)).setVisibility(0);
                ((View)VideoSegmentUI.j(VideoSegmentUI.this)).animate().setDuration(300L).setStartDelay(200L).alpha(1.0F);
                float f1 = VideoSegmentUI.j(VideoSegmentUI.this).eko();
                float f2 = VideoSegmentUI.j(VideoSegmentUI.this).ekp();
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
            Log.printErrStackTrace("MicroMsg.VideoSegmentUI", localIOException, "init segmentPlayer second time %s", new Object[] { localIOException.getMessage() });
            VideoSegmentUI.this.finish();
            AppMethodBeat.o(94487);
            return;
          }
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.VideoSegmentUI", localException, "Finished when init", new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI
 * JD-Core Version:    0.7.0.1
 */