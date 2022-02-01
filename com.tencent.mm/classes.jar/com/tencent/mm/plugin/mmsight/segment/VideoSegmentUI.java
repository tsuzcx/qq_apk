package com.tencent.mm.plugin.mmsight.segment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@a(3)
public class VideoSegmentUI
  extends MMActivity
{
  private CountDownLatch cAs;
  private com.tencent.mm.remoteservice.d fLo;
  private ProgressDialog fpP;
  private int hsU;
  private Surface mSurface;
  private String oLh;
  private RelativeLayout qiM;
  private VideoTransPara tCr;
  private String tHD;
  private f tHE;
  private com.tencent.mm.plugin.mmsight.segment.a.c tHF;
  private boolean tHG;
  private c tHH;
  private int tHI;
  private boolean tHJ;
  private boolean tHK;
  private boolean tHL;
  private c.b tHM;
  private com.tencent.mm.plugin.mmsight.segment.a.c.a tHN;
  private a.d tHO;
  private String thumbPath;
  
  public VideoSegmentUI()
  {
    AppMethodBeat.i(94488);
    this.tHD = null;
    this.tHG = false;
    this.cAs = new CountDownLatch(2);
    this.tHI = 10000;
    this.fpP = null;
    this.fLo = new com.tencent.mm.remoteservice.d(this);
    this.oLh = "";
    this.tHJ = false;
    this.tHK = false;
    this.tHL = false;
    this.tHM = new c.b()
    {
      public final void M(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
      
      public final void N(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
      
      public final void O(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
      
      public final void P(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
    this.tHN = new com.tencent.mm.plugin.mmsight.segment.a.c.a()
    {
      private Runnable tHQ;
      
      public final void GY(int paramAnonymousInt)
      {
        AppMethodBeat.i(94467);
        if (VideoSegmentUI.j(VideoSegmentUI.this) == null)
        {
          AppMethodBeat.o(94467);
          return;
        }
        if (this.tHQ != null) {
          ((View)VideoSegmentUI.j(VideoSegmentUI.this)).removeCallbacks(this.tHQ);
        }
        this.tHQ = new VideoSegmentUI.c(VideoSegmentUI.j(VideoSegmentUI.this), paramAnonymousInt, VideoSegmentUI.e(VideoSegmentUI.this));
        ((View)VideoSegmentUI.j(VideoSegmentUI.this)).post(this.tHQ);
        AppMethodBeat.o(94467);
      }
    };
    this.tHO = new VideoSegmentUI.4(this);
    AppMethodBeat.o(94488);
  }
  
  private void a(boolean paramBoolean, Surface paramSurface)
  {
    AppMethodBeat.i(94491);
    if (this.tHF != null)
    {
      ad.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
      AppMethodBeat.o(94491);
      return;
    }
    this.tHF = new com.tencent.mm.plugin.mmsight.segment.a.c();
    this.tHG = false;
    this.tHF.setDataSource(this.tHD);
    this.tHF.a(new VideoSegmentUI.9(this));
    if (paramBoolean) {
      this.tHF.a(this.tHO);
    }
    this.tHF.setAudioStreamType(3);
    this.tHF.setLooping(true);
    if (paramSurface != null) {
      this.tHF.setSurface(paramSurface);
    }
    this.tHF.tHN = this.tHN;
    this.tHF.a(new a.b()
    {
      public final void dr(Object paramAnonymousObject)
      {
        AppMethodBeat.i(94476);
        ad.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", new Object[] { paramAnonymousObject });
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
          ad.printErrStackTrace("MicroMsg.VideoSegmentUI", paramAnonymousObject, "hy: exception when onPrepared waiting for starting", new Object[0]);
          AppMethodBeat.o(94476);
        }
      }
    });
    this.tHF.prepareAsync();
    this.tHF.a(new a.c()
    {
      public final void ds(Object paramAnonymousObject)
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
          ad.printErrStackTrace("MicroMsg.VideoSegmentUI", paramAnonymousObject, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
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
    this.tHH = ((c)findViewById(2131304490));
    this.qiM = ((RelativeLayout)findViewById(2131304239));
    AppMethodBeat.o(94490);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(94489);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    CaptureMMProxy.createProxy(new CaptureMMProxy(this.fLo));
    this.fLo.connect(new VideoSegmentUI.1(this));
    AppMethodBeat.o(94489);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(94494);
    ad.i("MicroMsg.VideoSegmentUI", "onDestroy");
    super.onDestroy();
    getWindow().clearFlags(128);
    this.fLo.release();
    if (this.tHH != null) {
      this.tHH.release();
    }
    if (this.tHF != null) {
      this.tHF.release();
    }
    if (this.mSurface != null) {
      this.mSurface.release();
    }
    if (this.tHE != null) {
      this.tHE.release();
    }
    j.tEA.aoS();
    AppMethodBeat.o(94494);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(94493);
    if (this.tHF != null)
    {
      ad.i("MicroMsg.VideoSegmentUI", "onPause pause player");
      this.tHF.pause();
    }
    super.onPause();
    AppMethodBeat.o(94493);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(94492);
    if ((this.tHF != null) && (this.tHG))
    {
      ad.i("MicroMsg.VideoSegmentUI", "onResume start player");
      this.tHF.start();
    }
    super.onResume();
    AppMethodBeat.o(94492);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
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
        ad.i("MicroMsg.VideoSegmentUI", "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        VideoSegmentUI.b(VideoSegmentUI.this, new Surface(paramSurfaceTexture));
        if ((VideoSegmentUI.d(VideoSegmentUI.this) == null) && (VideoSegmentUI.w(VideoSegmentUI.this))) {
          ad.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
        }
        try
        {
          VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.u(VideoSegmentUI.this));
          if ((VideoSegmentUI.j(VideoSegmentUI.this) != null) && (VideoSegmentUI.d(VideoSegmentUI.this) != null)) {
            VideoSegmentUI.d(VideoSegmentUI.this).setLoop((int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).cQt()), (int)(VideoSegmentUI.e(VideoSegmentUI.this) * VideoSegmentUI.j(VideoSegmentUI.this).cQu()));
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
            ad.printErrStackTrace("MicroMsg.VideoSegmentUI", paramSurfaceTexture, "ResumeMediaPlayer error %s", new Object[] { paramSurfaceTexture.getMessage() });
          }
        }
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(94483);
      ad.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", new Object[] { bt.eGN() });
      try
      {
        if (VideoSegmentUI.d(VideoSegmentUI.this) != null)
        {
          ad.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
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
    private int hsU;
    private WeakReference<c> lo;
    private int tIa;
    
    public c(c paramc, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(94484);
      this.lo = new WeakReference(paramc);
      this.tIa = paramInt1;
      this.hsU = paramInt2;
      AppMethodBeat.o(94484);
    }
    
    public final void run()
    {
      AppMethodBeat.i(94485);
      c localc = (c)this.lo.get();
      if (localc == null)
      {
        AppMethodBeat.o(94485);
        return;
      }
      localc.setCurrentCursorPosition(this.tIa / this.hsU);
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
            ad.w("MicroMsg.VideoSegmentUI", "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool2) });
            VideoSegmentUI.this.finish();
            AppMethodBeat.o(94487);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          ad.e("MicroMsg.VideoSegmentUI", "count down latch error %s", new Object[] { localInterruptedException });
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
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(94486);
                if ((VideoSegmentUI.t(VideoSegmentUI.this)) || (VideoSegmentUI.this.isFinishing()) || (VideoSegmentUI.j(VideoSegmentUI.this) == null) || (VideoSegmentUI.d(VideoSegmentUI.this) == null))
                {
                  ad.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
                  AppMethodBeat.o(94486);
                  return;
                }
                ((View)VideoSegmentUI.j(VideoSegmentUI.this)).setAlpha(0.0F);
                ((View)VideoSegmentUI.j(VideoSegmentUI.this)).setVisibility(0);
                ((View)VideoSegmentUI.j(VideoSegmentUI.this)).animate().setDuration(300L).setStartDelay(200L).alpha(1.0F);
                float f1 = VideoSegmentUI.j(VideoSegmentUI.this).cQt();
                float f2 = VideoSegmentUI.j(VideoSegmentUI.this).cQu();
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
            ad.printErrStackTrace("MicroMsg.VideoSegmentUI", localIOException, "init segmentPlayer second time %s", new Object[] { localIOException.getMessage() });
            VideoSegmentUI.this.finish();
            AppMethodBeat.o(94487);
            return;
          }
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.VideoSegmentUI", localException, "Finished when init", new Object[0]);
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