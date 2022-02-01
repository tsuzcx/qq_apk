package com.tencent.mm.ui.chatting.gallery;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextPaint;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.y;
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.az.b;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hn.b;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.ru;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.rv.a;
import com.tencent.mm.g.b.a.ao;
import com.tencent.mm.g.c.du;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.webview.ui.tools.media.g.a;
import com.tencent.mm.pluginsdk.ui.tools.RedesignVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.b;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.MMViewPager.e;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.a<String, Integer>
{
  public com.tencent.mm.plugin.webview.ui.tools.media.d Bit;
  public View Bsm;
  private boolean GAj;
  private final boolean GAk;
  private boolean GCA;
  private int GCB;
  private ScanCodeSheetItemLogic GCC;
  public a GCD;
  private View GCE;
  private CheckBox GCF;
  private View GCG;
  private boolean GCH;
  private int GCI;
  private boolean GCJ;
  private ViewPager.OnPageChangeListener GCK;
  public TextView GCL;
  public View GCN;
  public ImageView GCO;
  boolean GCP;
  private HashMap<Long, String> GCQ;
  private boolean GCR;
  private boolean GCS;
  private b.b GCc;
  private RelativeLayout GCd;
  private boolean GCe;
  private boolean GCf;
  public f GCg;
  private View GCh;
  private View GCi;
  private View GCj;
  View GCk;
  Button GCl;
  Button GCm;
  View GCn;
  int GCo;
  int GCp;
  boolean GCq;
  ArrayList<Integer> GCr;
  private String GCs;
  private String GCt;
  private boolean GCu;
  protected boolean GCv;
  protected boolean GCw;
  private boolean GCx;
  private int GCy;
  private String GCz;
  int GjV;
  private HashSet<Long> GtG;
  private boolean GxB;
  protected boolean GxC;
  public b GzZ;
  protected String chatroomName;
  private View contentView;
  public ImageView fuj;
  private boolean isAnimated;
  private int kxk;
  private int kxl;
  private com.tencent.mm.ui.widget.a.e mET;
  private com.tencent.mm.sdk.platformtools.ap mHandler;
  public long mUQ;
  public long msgId;
  public TextView nkb;
  public MMNeat7extView nkc;
  Bundle nzU;
  com.tencent.mm.ui.tools.e nzV;
  int nzW;
  int nzX;
  int nzY;
  int nzZ;
  private n.d oEU;
  public boolean qbB;
  private ImageView qdk;
  private boolean qeg;
  private com.tencent.mm.sdk.b.c qej;
  private com.tencent.mm.sdk.b.c<rv> qgA;
  private n qgB;
  private com.tencent.mm.plugin.scanner.word.a<String, Integer> qgs;
  private volatile int qgt;
  private int qgu;
  private ImageView qgw;
  private ImageView qgx;
  private ImageView qgy;
  private ValueAnimator qgz;
  private ImageView qmk;
  private RelativeLayout qmm;
  av qmv;
  public View qrN;
  protected MMViewPager rJU;
  private boolean tAJ;
  protected String talker;
  private boolean xmD;
  private com.tencent.mm.sdk.b.c xmF;
  private String xmt;
  private String xmw;
  private String xmx;
  private String xmy;
  int xvY;
  int xvZ;
  int xwa;
  private float xwb;
  private int xwc;
  private int xwd;
  private boolean yEG;
  protected RedesignVideoPlayerSeekBar yEw;
  
  public ImageGalleryUI()
  {
    AppMethodBeat.i(36149);
    this.yEG = false;
    this.GCf = false;
    this.GCg = new f();
    this.xwa = 0;
    this.GCo = 0;
    this.GCp = 0;
    this.nzW = 0;
    this.nzX = 0;
    this.nzY = 0;
    this.nzZ = 0;
    this.GCr = new ArrayList();
    this.GxB = false;
    this.qbB = false;
    this.xmD = false;
    this.GCv = false;
    this.GxC = false;
    this.GCw = false;
    this.isAnimated = false;
    this.GAj = false;
    this.qgu = 0;
    this.GAk = false;
    this.GCz = null;
    this.GCB = 0;
    this.qej = new com.tencent.mm.sdk.b.c() {};
    this.xmF = new com.tencent.mm.sdk.b.c() {};
    this.qgB = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(36144);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36143);
            if ((com.tencent.mm.kernel.g.aeS().auR() != 6) && (com.tencent.mm.kernel.g.aeS().auR() != 4))
            {
              if (ImageGalleryUI.l(ImageGalleryUI.this) == 1)
              {
                com.tencent.mm.ui.base.h.c(ImageGalleryUI.this, ImageGalleryUI.this.getString(2131755828), "", true);
                ImageGalleryUI.m(ImageGalleryUI.this);
                AppMethodBeat.o(36143);
              }
            }
            else
            {
              if (ImageGalleryUI.n(ImageGalleryUI.this) == null)
              {
                AppMethodBeat.o(36143);
                return;
              }
              int i = ImageGalleryUI.this.getCurrentItem();
              bl localbl = ImageGalleryUI.n(ImageGalleryUI.this).YE(i);
              if ((localbl != null) && (localbl.cjN()))
              {
                if (ImageGalleryUI.n(ImageGalleryUI.this).eZs() == null) {
                  ImageGalleryUI.n(ImageGalleryUI.this).eZs().fac();
                }
                if ((ImageGalleryUI.n(ImageGalleryUI.this).eZs().fac().GDO.getVisibility() == 0) || (ImageGalleryUI.n(ImageGalleryUI.this).eZs().fac().GDX.getVisibility() == 0)) {
                  ImageGalleryUI.n(ImageGalleryUI.this).Zc(i);
                }
              }
            }
            AppMethodBeat.o(36143);
          }
        });
        AppMethodBeat.o(36144);
      }
    };
    this.GCH = true;
    this.xwb = 1.0F;
    this.xwc = 0;
    this.xwd = 0;
    this.oEU = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(36123);
        if ((ImageGalleryUI.this == null) || (ImageGalleryUI.this.isDestroyed()) || (ImageGalleryUI.this.isFinishing()))
        {
          ad.i("MicroMsg.ImageGalleryUI", "receive onMMMenuItemSelected but activity is invalid");
          AppMethodBeat.o(36123);
          return;
        }
        ad.i("MicroMsg.ImageGalleryUI", "curTransState %d", new Object[] { Integer.valueOf(ImageGalleryUI.l(ImageGalleryUI.this)) });
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(36123);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.n(ImageGalleryUI.this).eZr();
          Object localObject;
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cjM()))
          {
            localObject = com.tencent.mm.modelvideo.u.Ae(paramAnonymousMenuItem.field_imgPath);
            if ((localObject != null) && (((s)localObject).status != 199) && (((s)localObject).status != 199))
            {
              ImageGalleryUI.b(ImageGalleryUI.this, com.tencent.mm.modelvideo.u.f(paramAnonymousMenuItem.field_msgId, 1));
              ImageGalleryUI.n(ImageGalleryUI.this).Zd(ImageGalleryUI.this.rJU.getCurrentItem());
            }
          }
          for (;;)
          {
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cjN()))
            {
              localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.Bsg;
              com.tencent.mm.plugin.webview.ui.tools.media.a.aB(1, ImageGalleryUI.F(ImageGalleryUI.this), ImageGalleryUI.G(ImageGalleryUI.this));
              paramAnonymousMenuItem = j.ci(paramAnonymousMenuItem);
              if (paramAnonymousMenuItem != null)
              {
                localObject = com.tencent.mm.plugin.webview.ui.tools.media.g.Btd;
                g.a.ac(paramAnonymousMenuItem.CEg, paramAnonymousMenuItem.CEf, ImageGalleryUI.this.GCg.niH);
              }
            }
            AppMethodBeat.o(36123);
            return;
            ImageGalleryUI.n(ImageGalleryUI.this).YY(ImageGalleryUI.this.rJU.getCurrentItem());
            continue;
            ImageGalleryUI.n(ImageGalleryUI.this).YY(ImageGalleryUI.this.rJU.getCurrentItem());
          }
          paramAnonymousMenuItem = ImageGalleryUI.n(ImageGalleryUI.this).eZr();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cjM()))
          {
            localObject = com.tencent.mm.modelvideo.u.Ae(paramAnonymousMenuItem.field_imgPath);
            if ((localObject != null) && (((s)localObject).status != 199) && (((s)localObject).status != 199))
            {
              ImageGalleryUI.b(ImageGalleryUI.this, com.tencent.mm.modelvideo.u.f(paramAnonymousMenuItem.field_msgId, 2));
              ImageGalleryUI.n(ImageGalleryUI.this).Zd(ImageGalleryUI.this.rJU.getCurrentItem());
              AppMethodBeat.o(36123);
              return;
            }
            paramAnonymousMenuItem = new ArrayList();
            paramAnonymousMenuItem.add(ImageGalleryUI.n(ImageGalleryUI.this).eZr());
            b.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
            AppMethodBeat.o(36123);
            return;
          }
          paramAnonymousMenuItem = new ArrayList();
          paramAnonymousMenuItem.add(ImageGalleryUI.n(ImageGalleryUI.this).eZr());
          com.tencent.mm.modelstat.b.huc.T((bl)paramAnonymousMenuItem.get(0));
          b.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
          AppMethodBeat.o(36123);
          return;
          ImageGalleryUI.n(ImageGalleryUI.this).YZ(ImageGalleryUI.this.rJU.getCurrentItem());
          AppMethodBeat.o(36123);
          return;
          if (com.tencent.mm.bs.d.axB("favorite"))
          {
            ImageGalleryUI.n(ImageGalleryUI.this).Za(ImageGalleryUI.this.rJU.getCurrentItem());
            paramAnonymousMenuItem = ImageGalleryUI.n(ImageGalleryUI.this).eZr();
            if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.cjN()))
            {
              paramAnonymousMenuItem = com.tencent.mm.plugin.webview.ui.tools.media.a.Bsg;
              com.tencent.mm.plugin.webview.ui.tools.media.a.aB(2, ImageGalleryUI.F(ImageGalleryUI.this), ImageGalleryUI.G(ImageGalleryUI.this));
            }
            AppMethodBeat.o(36123);
            return;
            ImageGalleryUI.I(ImageGalleryUI.this);
            AppMethodBeat.o(36123);
            return;
            if (ImageGalleryUI.n(ImageGalleryUI.this) != null)
            {
              if (b.j(ImageGalleryUI.n(ImageGalleryUI.this).eZr())) {
                ImageGalleryUI.J(ImageGalleryUI.this);
              }
              AppMethodBeat.o(36123);
              return;
              paramAnonymousMenuItem = ImageGalleryUI.K(ImageGalleryUI.this);
              if (((ImageGalleryUI.l(ImageGalleryUI.this) == 0) || (ImageGalleryUI.l(ImageGalleryUI.this) == 2)) && (!bt.isNullOrNil(paramAnonymousMenuItem)))
              {
                localObject = new ao();
                if (ImageGalleryUI.l(ImageGalleryUI.this) == 2) {}
                for (long l = 1L;; l = 0L)
                {
                  ((ao)localObject).dKe = l;
                  ((ao)localObject).dFd = 3L;
                  ((ao)localObject).dMB = 4L;
                  ((ao)localObject).aBj();
                  ImageGalleryUI.e(ImageGalleryUI.this, (int)(com.tencent.mm.model.u.aqG().hashCode() + System.currentTimeMillis()));
                  localObject = ((com.tencent.mm.plugin.scanner.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.scanner.c.class)).getTranslationResult(paramAnonymousMenuItem);
                  if ((localObject == null) || (!com.tencent.mm.vfs.i.eK(((fb)localObject).field_resultFile))) {
                    break label947;
                  }
                  if (ImageGalleryUI.n(ImageGalleryUI.this).YE(ImageGalleryUI.L(ImageGalleryUI.this)) == null) {
                    break;
                  }
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("original_file_path", paramAnonymousMenuItem);
                  ((Intent)localObject).putExtra("msg_id", ImageGalleryUI.n(ImageGalleryUI.this).YE(ImageGalleryUI.L(ImageGalleryUI.this)).field_msgId);
                  ImageGalleryUI.a(ImageGalleryUI.this, TranslationResultUI.class, (Intent)localObject);
                  ImageGalleryUI.this.finish();
                  ImageGalleryUI.this.overridePendingTransition(2130771986, 2130771986);
                  AppMethodBeat.o(36123);
                  return;
                }
                label947:
                ImageGalleryUI.M(ImageGalleryUI.this);
                ad.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", new Object[] { paramAnonymousMenuItem, Integer.valueOf(ImageGalleryUI.o(ImageGalleryUI.this)) });
                localObject = new ru();
                ((ru)localObject).dxr.scene = 1;
                ((ru)localObject).dxr.filePath = paramAnonymousMenuItem;
                ((ru)localObject).dxr.dcS = ImageGalleryUI.o(ImageGalleryUI.this);
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
              }
            }
          }
        }
      }
    };
    this.qgA = new com.tencent.mm.sdk.b.c() {};
    this.GCI = 0;
    this.GCJ = false;
    this.GCK = new ViewPager.OnPageChangeListener()
    {
      private boolean GCY = false;
      
      public final void onPageScrollStateChanged(int paramAnonymousInt)
      {
        AppMethodBeat.i(36128);
        ad.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 2) {
          ImageGalleryUI.c(ImageGalleryUI.this, true);
        }
        if (paramAnonymousInt == 0)
        {
          this.GCY = false;
          if (ImageGalleryUI.Q(ImageGalleryUI.this)) {
            ImageGalleryUI.this.eZH();
          }
          ImageGalleryUI.c(ImageGalleryUI.this, false);
        }
        if (ImageGalleryUI.n(ImageGalleryUI.this) != null)
        {
          Object localObject = ImageGalleryUI.n(ImageGalleryUI.this);
          if (((b)localObject).GAf != null)
          {
            localObject = ((b)localObject).GAf;
            ((d)localObject).mScrollState = paramAnonymousInt;
            if (((d)localObject).GBu != null) {
              ((d)localObject).GBu.onPageScrollStateChanged(paramAnonymousInt);
            }
          }
        }
        AppMethodBeat.o(36128);
      }
      
      public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36127);
        ad.v("MicroMsg.ImageGalleryUI", "position: %d, positionOffset: %f, positionOffsetPixels: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Float.valueOf(paramAnonymousFloat), Integer.valueOf(paramAnonymousInt2) });
        if ((!this.GCY) && (paramAnonymousInt2 > 0))
        {
          this.GCY = true;
          ImageGalleryUI.this.eZI();
        }
        AppMethodBeat.o(36127);
      }
      
      public final void onPageSelected(int paramAnonymousInt)
      {
        AppMethodBeat.i(36126);
        if (ImageGalleryUI.n(ImageGalleryUI.this) == null)
        {
          AppMethodBeat.o(36126);
          return;
        }
        if (ImageGalleryUI.L(ImageGalleryUI.this) != paramAnonymousInt)
        {
          ImageGalleryUI.N(ImageGalleryUI.this);
          if (ImageGalleryUI.l(ImageGalleryUI.this) == 1) {
            ImageGalleryUI.m(ImageGalleryUI.this);
          }
          ImageGalleryUI.O(ImageGalleryUI.this);
          ImageGalleryUI.p(ImageGalleryUI.this);
        }
        if (ImageGalleryUI.n(ImageGalleryUI.this).OT(paramAnonymousInt) == null) {
          ad.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[] { Integer.valueOf(paramAnonymousInt) });
        }
        ImageGalleryUI.z(ImageGalleryUI.this);
        ImageGalleryUI.f(ImageGalleryUI.this, ImageGalleryUI.L(ImageGalleryUI.this));
        ImageGalleryUI.this.GCg.a(ImageGalleryUI.this, ImageGalleryUI.L(ImageGalleryUI.this), paramAnonymousInt);
        ImageGalleryUI.g(ImageGalleryUI.this, paramAnonymousInt);
        Object localObject1;
        Object localObject2;
        int i;
        boolean bool;
        label347:
        long l;
        if (ImageGalleryUI.n(ImageGalleryUI.this) != null)
        {
          localObject1 = ImageGalleryUI.n(ImageGalleryUI.this);
          ((b)localObject1).GAg.MV();
          ((b)localObject1).GAh.MV();
          localObject1 = ImageGalleryUI.n(ImageGalleryUI.this).YE(paramAnonymousInt);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(((du)localObject1).field_talker);
          }
          if ((b.j((bl)localObject1)) || (b.bP((bl)localObject1)))
          {
            localObject2 = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.n(ImageGalleryUI.this), ImageGalleryUI.this.rJU);
            if ((localObject2 != null) && ((localObject2 instanceof com.tencent.mm.ui.base.g)))
            {
              if (!(localObject2 instanceof MultiTouchImageView)) {
                break label660;
              }
              ((MultiTouchImageView)localObject2).eSz();
            }
            i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getInt("EnableSessionPicTranslation", 0);
            localObject2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("PicTranslationSupportUserLanguage");
            if (i != 1) {
              break label682;
            }
            bool = true;
            ad.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject2, ac.eFu() });
            if ((i != 1) || (bt.isNullOrNil((String)localObject2))) {
              break label688;
            }
            localObject2 = ((String)localObject2).split(";");
            if ((localObject2 == null) || (!Arrays.asList((Object[])localObject2).contains(ac.eFu()))) {
              break label688;
            }
            i = 1;
            label422:
            if (i != 0)
            {
              if (ImageGalleryUI.P(ImageGalleryUI.this) == null) {
                ImageGalleryUI.a(ImageGalleryUI.this, new ImageWordScanEngineImpl(ImageGalleryUI.this));
              }
              ImageGalleryUI.P(ImageGalleryUI.this).a(ImageGalleryUI.K(ImageGalleryUI.this), ImageGalleryUI.this);
            }
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).af((bl)localObject1);
          }
          if (localObject1 != null) {
            ImageGalleryUI.this.wP(((du)localObject1).field_msgId);
          }
          if (ImageGalleryUI.n(ImageGalleryUI.this) == null) {
            break label710;
          }
          localObject2 = ImageGalleryUI.n(ImageGalleryUI.this).h((bl)localObject1, false);
          ImageGalleryUI.n(ImageGalleryUI.this);
          if (!b.b((bl)localObject1, (com.tencent.mm.aw.e)localObject2)) {
            break label718;
          }
          localObject1 = com.tencent.mm.aw.f.a((com.tencent.mm.aw.e)localObject2);
          i = ((com.tencent.mm.aw.e)localObject1).gTY;
          int j = ((com.tencent.mm.aw.e)localObject1).offset;
          if (i == 0) {
            break label704;
          }
          l = j * 100L / i - 1L;
          label589:
          i = Math.max(1, (int)l);
          ad.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()) });
          ImageGalleryUI.this.Zs(i);
        }
        for (;;)
        {
          if (ImageGalleryUI.n(ImageGalleryUI.this) != null) {
            ImageGalleryUI.n(ImageGalleryUI.this).onPageSelected(paramAnonymousInt);
          }
          AppMethodBeat.o(36126);
          return;
          label660:
          if (!(localObject2 instanceof WxImageView)) {
            break;
          }
          ((WxImageView)localObject2).eSz();
          break;
          label682:
          bool = false;
          break label347;
          label688:
          if (com.tencent.mm.protocal.d.CpO)
          {
            i = 1;
            break label422;
          }
          i = 0;
          break label422;
          label704:
          l = 0L;
          break label589;
          label710:
          ad.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
          label718:
          if (localObject1 == null)
          {
            ad.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = ".concat(String.valueOf(paramAnonymousInt)));
          }
          else
          {
            ImageGalleryUI.this.cg((bl)localObject1);
            ImageGalleryUI.a(ImageGalleryUI.this, (bl)localObject1);
            ImageGalleryUI.this.eZH();
          }
        }
      }
    };
    this.Bsm = null;
    this.GCP = false;
    this.qmv = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(36132);
        if (ImageGalleryUI.R(ImageGalleryUI.this)) {
          ImageGalleryUI.this.eZI();
        }
        AppMethodBeat.o(36132);
        return false;
      }
    }, false);
    this.GCQ = new HashMap();
    this.GCR = false;
    this.GCS = false;
    this.mHandler = new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper());
    this.GtG = new HashSet();
    AppMethodBeat.o(36149);
  }
  
  private void Zo(int paramInt)
  {
    AppMethodBeat.i(36181);
    bl localbl = this.GzZ.YE(paramInt);
    if ((localbl == null) || (!localbl.cjN()) || (this.GAj))
    {
      AppMethodBeat.o(36181);
      return;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(new h.c(localbl.field_talker, "update", localbl));
    AppMethodBeat.o(36181);
  }
  
  private void Zp(int paramInt)
  {
    AppMethodBeat.i(36189);
    ad.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(paramInt)));
    if (this.GzZ == null)
    {
      ad.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      AppMethodBeat.o(36189);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 13L, 1L, true);
    int i = this.GzZ.getRealCount();
    if (this.GzZ.eZr() == null)
    {
      ad.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      AppMethodBeat.o(36189);
      return;
    }
    int j = this.GzZ.GAb.Zh(this.rJU.getCurrentItem());
    if (!this.GCv)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(getContext(), MediaHistoryGalleryUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("kintent_intent_source", paramInt);
      ((Intent)localObject).putExtra("kintent_talker", eZF());
      ((Intent)localObject).putExtra("kintent_image_count", i);
      ((Intent)localObject).putExtra("kintent_image_index", j);
      ((Intent)localObject).putExtra("key_biz_chat_id", this.mUQ);
      ((Intent)localObject).putExtra("key_is_biz_chat", this.qbB);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI", "enterGrid", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mHandler.postDelayed(new ImageGalleryUI.22(this), 50L);
      AppMethodBeat.o(36189);
      return;
    }
    bKT();
    AppMethodBeat.o(36189);
  }
  
  static Animation Zr(int paramInt)
  {
    AppMethodBeat.i(36199);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    AppMethodBeat.o(36199);
    return localAlphaAnimation;
  }
  
  private void Zt(int paramInt)
  {
    AppMethodBeat.i(36209);
    if (this.Bsm != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Bsm.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, paramInt, 0);
      this.Bsm.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36209);
  }
  
  private View a(b paramb, MMViewPager paramMMViewPager)
  {
    AppMethodBeat.i(36164);
    boolean bool1;
    if (paramb == null)
    {
      bool1 = true;
      if (paramMMViewPager != null) {
        break label75;
      }
    }
    label75:
    for (boolean bool2 = true;; bool2 = false)
    {
      ad.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramb == null) || (paramMMViewPager == null)) {
        break label182;
      }
      if (paramb.eZr() != null) {
        break label81;
      }
      AppMethodBeat.o(36164);
      return null;
      bool1 = false;
      break;
    }
    label81:
    Object localObject;
    if ((paramb.eZr().eJO()) || (paramb.eZr().eMb()))
    {
      MultiTouchImageView localMultiTouchImageView = paramb.Ef(paramMMViewPager.getCurrentItem());
      localObject = localMultiTouchImageView;
      if (localMultiTouchImageView == null) {
        localObject = paramb.Eg(paramMMViewPager.getCurrentItem());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36164);
      return localObject;
      if ((paramb.eZr().cjM()) || (paramb.eZr().cjO()) || (paramb.eZr().cjN()))
      {
        localObject = paramb.Zb(paramMMViewPager.getCurrentItem());
        continue;
        label182:
        ad.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[] { Integer.valueOf(hashCode()) });
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private static void aC(View paramView, int paramInt)
  {
    AppMethodBeat.i(36156);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(36156);
  }
  
  private boolean aKU(String paramString)
  {
    AppMethodBeat.i(36169);
    if (this.GCy == 1)
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(36169);
      return false;
    }
    if (!this.GCx)
    {
      AppMethodBeat.o(36169);
      return true;
    }
    String[] arrayOfString = ((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FlN, "")).split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!bt.isNullOrNil(str)) && (paramString.startsWith(str)))
        {
          ad.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", new Object[] { paramString, str });
          AppMethodBeat.o(36169);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(36169);
    return true;
  }
  
  private void aKV(String paramString)
  {
    AppMethodBeat.i(36213);
    paramString = RecordConfigProvider.ic(paramString, "");
    paramString.scene = this.GCy;
    Object localObject = new UICustomParam.a();
    ((UICustomParam.a)localObject).Ya();
    ((UICustomParam.a)localObject).XZ();
    ((UICustomParam.a)localObject).cO(true);
    paramString.vhI = ((UICustomParam.a)localObject).fHa;
    localObject = com.tencent.mm.plugin.recordvideo.jumper.a.vih;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4369, 2130772137, -1, paramString, 1, 2);
    AppMethodBeat.o(36213);
  }
  
  private void bKT()
  {
    AppMethodBeat.i(36165);
    if ((this.yEG) || (this.GzZ == null))
    {
      ad.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(36165);
      return;
    }
    wm(true);
    if (this.GCe)
    {
      finish();
      com.tencent.mm.ui.base.b.jH(getContext());
      AppMethodBeat.o(36165);
      return;
    }
    ad.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int k = this.rJU.getWidth() / 2;
    int j = this.rJU.getHeight() / 2;
    this.GzZ.eZq();
    Object localObject1;
    int m;
    int i;
    int n;
    if (!eUl())
    {
      if (this.GCv)
      {
        localObject1 = new hn();
        ((hn)localObject1).dlf.msgId = this.GzZ.YE(this.rJU.getCurrentItem()).field_msgId;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        m = ((hn)localObject1).dlg.ddj;
        i = ((hn)localObject1).dlg.ddk;
        k = ((hn)localObject1).dlg.ddh;
        j = ((hn)localObject1).dlg.ddi;
        this.xvY = this.rJU.getWidth();
        this.xvZ = this.rJU.getHeight();
        n = i;
        if (this.GzZ.eZr() != null)
        {
          if ((this.GzZ.eZr().cjO()) || (this.GzZ.eZr().cjM()) || (this.GzZ.eZr().cjN())) {
            this.xvZ = ((int)(this.xvY / m * i));
          }
          if (!this.GzZ.eZr().eJO())
          {
            n = i;
            if (!this.GzZ.eZr().eMb()) {}
          }
          else
          {
            localObject1 = (com.tencent.mm.ui.base.g)a(this.GzZ, this.rJU);
            n = i;
            if (localObject1 != null)
            {
              float f = this.xvY / ((com.tencent.mm.ui.base.g)localObject1).getImageWidth();
              this.xvZ = ((int)(((com.tencent.mm.ui.base.g)localObject1).getImageHeight() * f));
              n = i;
              if (this.xvZ > this.rJU.getHeight())
              {
                n = i;
                if (this.xvZ < this.rJU.getHeight() * 1.5D)
                {
                  if (!this.GCv) {
                    break label874;
                  }
                  this.xwa = (this.xvZ - this.rJU.getHeight());
                  n = i;
                }
                label440:
                this.xvZ = this.rJU.getHeight();
              }
            }
          }
        }
        this.nzV.jC(this.GCo, this.GCp);
        this.nzV.HqO = this.xwa;
        this.nzV.jB(this.xvY, this.xvZ);
        this.nzV.P(k, j, m, n);
        localObject1 = this.rJU;
        localObject2 = a(this.GzZ, this.rJU);
        if (localObject2 == null) {
          break label893;
        }
        localObject1 = localObject2;
        if (this.xwb != 1.0D)
        {
          this.nzV.HqK = (1.0F / this.xwb);
          if (this.xwc == 0)
          {
            localObject1 = localObject2;
            if (this.xwd == 0) {}
          }
          else
          {
            i = (int)(this.rJU.getWidth() / 2 * (1.0F - this.xwb));
            j = this.xwc;
            k = (int)(this.rJU.getHeight() / 2 + this.xwd - this.xvZ / 2 * this.xwb);
            this.nzV.jD(i + j, k);
            localObject1 = localObject2;
          }
        }
        label647:
        eZI();
        this.nzV.a((View)localObject1, this.qdk, new e.c()
        {
          public final void onAnimationEnd()
          {
            AppMethodBeat.i(36118);
            ad.i("MicroMsg.ImageGalleryUI", "runExitAnimation onAnimationEnd");
            ImageGalleryUI.y(ImageGalleryUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36116);
                ImageGalleryUI.this.finish();
                ImageGalleryUI.this.overridePendingTransition(0, 0);
                AppMethodBeat.o(36116);
              }
            });
            ImageGalleryUI.b(ImageGalleryUI.this, false);
            AppMethodBeat.o(36118);
          }
          
          public final void onAnimationStart()
          {
            AppMethodBeat.i(36117);
            ImageGalleryUI.b(ImageGalleryUI.this, true);
            new com.tencent.mm.sdk.platformtools.ap().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(36115);
                View localView = ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.n(ImageGalleryUI.this), ImageGalleryUI.this.rJU);
                if ((localView != null) && ((localView instanceof com.tencent.mm.ui.base.g)))
                {
                  if ((localView instanceof MultiTouchImageView))
                  {
                    ((MultiTouchImageView)localView).eSz();
                    AppMethodBeat.o(36115);
                    return;
                  }
                  if ((localView instanceof WxImageView)) {
                    ((WxImageView)localView).eSz();
                  }
                }
                AppMethodBeat.o(36115);
              }
            }, 20L);
            AppMethodBeat.o(36117);
          }
        }, null);
        AppMethodBeat.o(36165);
        return;
      }
      localObject1 = this.GzZ.YE(this.rJU.getCurrentItem());
      if (localObject1 == null) {
        break label896;
      }
      Object localObject2 = new com.tencent.mm.g.a.az();
      ((com.tencent.mm.g.a.az)localObject2).ddf.dbD = ((bl)localObject1);
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
      m = ((com.tencent.mm.g.a.az)localObject2).ddg.ddj;
      i = ((com.tencent.mm.g.a.az)localObject2).ddg.ddk;
      k = ((com.tencent.mm.g.a.az)localObject2).ddg.ddh;
      j = ((com.tencent.mm.g.a.az)localObject2).ddg.ddi;
    }
    for (;;)
    {
      if ((k == 0) && (j == 0))
      {
        k = this.rJU.getWidth() / 2;
        j = this.rJU.getHeight() / 2;
        break;
      }
      if (localObject1 != null)
      {
        if (((du)localObject1).field_isSend == 0) {
          this.GCo = com.tencent.mm.cd.a.fromDPToPix(getContext(), 5);
        }
        if (((du)localObject1).field_isSend == 1) {
          this.GCp = com.tencent.mm.cd.a.fromDPToPix(getContext(), 5);
        }
      }
      break;
      m = this.nzY;
      i = this.nzZ;
      k = this.nzX;
      j = this.nzW;
      break;
      label874:
      n = this.rJU.getHeight() * i / this.xvZ;
      break label440;
      label893:
      break label647;
      label896:
      i = 0;
      m = 0;
    }
  }
  
  private boolean bf(Activity paramActivity)
  {
    AppMethodBeat.i(36211);
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    int j = paramActivity.getWidth();
    int k = paramActivity.getHeight();
    if (j < k) {}
    for (int i = 1;; i = 0)
    {
      ad.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(36211);
      return false;
    }
    AppMethodBeat.o(36211);
    return true;
  }
  
  private String ciZ()
  {
    AppMethodBeat.i(36166);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    bl localbl;
    if (this.GzZ != null)
    {
      localbl = this.GzZ.YE(this.GCI);
      if (!b.j(localbl)) {
        break label69;
      }
      com.tencent.mm.aw.e locale = this.GzZ.h(localbl, true);
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = d.a(localbl, locale);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(36166);
      return localObject1;
      label69:
      localObject1 = localObject2;
      if (b.bQ(localbl)) {
        localObject1 = b.l(localbl);
      }
    }
  }
  
  private void cjZ()
  {
    AppMethodBeat.i(36183);
    ad.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    wo(true);
    aC(this.GCk, 4);
    aC(eZC().yEw, 0);
    aC(this.qmk, 0);
    if (this.GCe) {
      eZI();
    }
    if (this.GzZ != null)
    {
      bl localbl = this.GzZ.eZr();
      if ((localbl != null) && (localbl.cjN())) {
        aC(this.Bsm, 0);
      }
    }
    AppMethodBeat.o(36183);
  }
  
  private void cjn()
  {
    AppMethodBeat.i(36171);
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(0);
    this.qgz.end();
    AppMethodBeat.o(36171);
  }
  
  private boolean eUl()
  {
    return this.GjV == 1;
  }
  
  private ImageGalleryUI eZD()
  {
    AppMethodBeat.i(36154);
    if (this.GCh == null) {
      this.GCh = findViewById(2131299498);
    }
    AppMethodBeat.o(36154);
    return this;
  }
  
  private ImageGalleryUI eZE()
  {
    AppMethodBeat.i(36155);
    if (this.GCj == null) {
      this.GCj = findViewById(2131299194);
    }
    AppMethodBeat.o(36155);
    return this;
  }
  
  private String eZF()
  {
    AppMethodBeat.i(36162);
    if ((this.chatroomName != null) && (this.chatroomName.length() > 0))
    {
      str = this.chatroomName;
      AppMethodBeat.o(36162);
      return str;
    }
    String str = this.talker;
    AppMethodBeat.o(36162);
    return str;
  }
  
  private boolean eZG()
  {
    AppMethodBeat.i(36168);
    if (this.GCx)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.GCy == 1)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if (this.GAj)
    {
      AppMethodBeat.o(36168);
      return false;
    }
    if ((!this.GxB) && (!this.qbB) && (!h.a.eZA().qjU))
    {
      AppMethodBeat.o(36168);
      return true;
    }
    AppMethodBeat.o(36168);
    return false;
  }
  
  private int eZK()
  {
    if (this.GAj)
    {
      locala = com.tencent.mm.plugin.webview.ui.tools.media.a.Bsg;
      return 2;
    }
    com.tencent.mm.plugin.webview.ui.tools.media.a locala = com.tencent.mm.plugin.webview.ui.tools.media.a.Bsg;
    return 1;
  }
  
  private int eZL()
  {
    if (this.GCf) {
      return 2;
    }
    return 3;
  }
  
  private boolean eZM()
  {
    return this.GCc == b.b.GAK;
  }
  
  private void eZP()
  {
    boolean bool = true;
    AppMethodBeat.i(36197);
    if (this.GCd.getVisibility() == 0) {}
    for (;;)
    {
      ad.d("MicroMsg.ImageGalleryUI", "fadeInOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      this.GCd.clearAnimation();
      this.GCd.startAnimation(eZQ());
      AppMethodBeat.o(36197);
      return;
      bool = false;
    }
  }
  
  private static Animation eZQ()
  {
    AppMethodBeat.i(36198);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    AppMethodBeat.o(36198);
    return localAlphaAnimation;
  }
  
  private void eZS()
  {
    AppMethodBeat.i(36210);
    if (this.Bsm != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Bsm.getLayoutParams();
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, 0);
      this.Bsm.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(36210);
  }
  
  private void eZT()
  {
    AppMethodBeat.i(36212);
    bl localbl = this.GzZ.eZr();
    String str = d.a(localbl, d.k(localbl));
    ad.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str, Long.valueOf(localbl.field_msgId) });
    aKV(str);
    AppMethodBeat.o(36212);
  }
  
  private void eqF()
  {
    boolean bool = true;
    AppMethodBeat.i(36196);
    if (this.GCd.getVisibility() == 0) {}
    for (;;)
    {
      ad.d("MicroMsg.ImageGalleryUI", "fadeOutOpLayout: %b", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = Zr(150);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(36137);
          if (!ImageGalleryUI.R(ImageGalleryUI.this)) {
            ImageGalleryUI.this.eZJ();
          }
          AppMethodBeat.o(36137);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.GCd.clearAnimation();
      this.GCd.startAnimation(localAnimation);
      AppMethodBeat.o(36196);
      return;
      bool = false;
    }
  }
  
  private void eqH()
  {
    AppMethodBeat.i(36207);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(36139);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ImageGalleryUI.V(ImageGalleryUI.this);
        AppMethodBeat.o(36139);
      }
    });
    AppMethodBeat.o(36207);
  }
  
  private void eqI()
  {
    AppMethodBeat.i(36208);
    final View localView = getWindow().getDecorView();
    localView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(36140);
        localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = com.tencent.mm.cd.a.hV(ImageGalleryUI.this);
        int j = com.tencent.mm.cd.a.hW(ImageGalleryUI.this);
        ad.i("MicroMsg.ImageGalleryUI", "handleHorizontalUI width = %d, height = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        if ((i <= j) || ((com.tencent.mm.compatible.util.d.lf(24)) && (ImageGalleryUI.this.isInMultiWindowMode())))
        {
          ImageGalleryUI.V(ImageGalleryUI.this);
          AppMethodBeat.o(36140);
          return;
        }
        ImageGalleryUI.W(ImageGalleryUI.this);
        AppMethodBeat.o(36140);
      }
    });
    AppMethodBeat.o(36208);
  }
  
  private static boolean f(bl parambl, com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(36179);
    if (parame == null)
    {
      AppMethodBeat.o(36179);
      return false;
    }
    try
    {
      if ((b.c(parambl, parame) == 0) && (parame.ayi()))
      {
        boolean bool = parambl.eMl();
        if (!bool)
        {
          AppMethodBeat.o(36179);
          return true;
        }
      }
    }
    catch (NullPointerException parambl)
    {
      ad.e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(parambl)));
      AppMethodBeat.o(36179);
    }
    return false;
  }
  
  private static int k(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(36187);
    Map localMap = bw.K(parame.hgv, "msg");
    if (localMap == null)
    {
      ad.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[] { parame.hgv });
      AppMethodBeat.o(36187);
      return -1;
    }
    int j = bt.getInt((String)localMap.get(".msg.img.$hdlength"), 0);
    int i = j;
    if (j == 0) {
      i = bt.getInt((String)localMap.get(".msg.img.$tphdlength"), 0);
    }
    AppMethodBeat.o(36187);
    return i;
  }
  
  private void lJ(boolean paramBoolean)
  {
    int i = 8;
    AppMethodBeat.i(36178);
    if (this.qmm == null)
    {
      AppMethodBeat.o(36178);
      return;
    }
    if (((paramBoolean) && (this.qmm.getVisibility() == 0)) || ((!paramBoolean) && (this.qmm.getVisibility() == 8)))
    {
      AppMethodBeat.o(36178);
      return;
    }
    Object localObject = this.qmm;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = getContext();
    if (paramBoolean) {}
    for (i = 2130771981;; i = 2130771982)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.qmm.startAnimation((Animation)localObject);
      AppMethodBeat.o(36178);
      return;
    }
  }
  
  private static String wN(long paramLong)
  {
    AppMethodBeat.i(36188);
    if (paramLong < 0L)
    {
      AppMethodBeat.o(36188);
      return "";
    }
    Object localObject = new BigDecimal(paramLong);
    float f = ((BigDecimal)localObject).divide(new BigDecimal(1048576), 2, 0).floatValue();
    if (f > 1.0F)
    {
      localObject = (int)f + "M";
      AppMethodBeat.o(36188);
      return localObject;
    }
    f = ((BigDecimal)localObject).divide(new BigDecimal(1024), 2, 0).floatValue();
    localObject = (int)f + "K";
    AppMethodBeat.o(36188);
    return localObject;
  }
  
  private void wm(boolean paramBoolean)
  {
    AppMethodBeat.i(36170);
    this.qgu = 0;
    this.qgw.setVisibility(8);
    this.qgx.setVisibility(8);
    this.qgy.setVisibility(8);
    if (!paramBoolean)
    {
      eZN();
      eZH();
    }
    cjn();
    AppMethodBeat.o(36170);
  }
  
  private void wn(boolean paramBoolean)
  {
    AppMethodBeat.i(36177);
    if (this.GCc != b.b.GAJ)
    {
      aC(this.GCk, 4);
      AppMethodBeat.o(36177);
      return;
    }
    Object localObject = null;
    if (this.GzZ != null) {
      localObject = this.GzZ.eZr();
    }
    if (localObject == null)
    {
      aC(this.GCk, 4);
      AppMethodBeat.o(36177);
      return;
    }
    com.tencent.mm.aw.e locale = this.GzZ.h((bl)localObject, false);
    if (paramBoolean)
    {
      this.rJU.getCurrentItem();
      if ((f((bl)localObject, locale)) && (!((bl)localObject).eMl()) && (locale.ayh()))
      {
        eZB().GCl.setVisibility(0);
        eZB().GCm.setVisibility(8);
        eZB().GCn.setVisibility(8);
        String str = (String)this.GCQ.get(Long.valueOf(locale.deI));
        localObject = str;
        if (str == null)
        {
          localObject = wN(k(locale));
          this.GCQ.put(Long.valueOf(locale.deI), localObject);
        }
        eZB().GCl.setText(getString(2131757973, new Object[] { localObject }));
        aC(this.GCk, 0);
        AppMethodBeat.o(36177);
        return;
      }
    }
    aC(this.GCk, 4);
    AppMethodBeat.o(36177);
  }
  
  private static void wo(boolean paramBoolean)
  {
    AppMethodBeat.i(36185);
    ad.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(36185);
  }
  
  public final void Zn(int paramInt)
  {
    AppMethodBeat.i(36180);
    cg(this.GzZ.YE(paramInt));
    AppMethodBeat.o(36180);
  }
  
  public final void Zq(final int paramInt)
  {
    AppMethodBeat.i(36194);
    if (eZC().yEw == null)
    {
      AppMethodBeat.o(36194);
      return;
    }
    eZC().yEw.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36136);
        if (ImageGalleryUI.n(ImageGalleryUI.this) == null)
        {
          AppMethodBeat.o(36136);
          return;
        }
        b localb = ImageGalleryUI.n(ImageGalleryUI.this);
        int i = paramInt;
        localb.GAg.pause(i);
        AppMethodBeat.o(36136);
      }
    });
    AppMethodBeat.o(36194);
  }
  
  public final void Zs(int paramInt)
  {
    AppMethodBeat.i(36200);
    cjY();
    eZH();
    eZB().GCk.setVisibility(0);
    eZB().GCl.setVisibility(8);
    eZB().GCm.setVisibility(0);
    eZB().GCn.setVisibility(8);
    eZB().GCm.setText(paramInt + "%");
    AppMethodBeat.o(36200);
  }
  
  public final void cg(bl parambl)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(36186);
        this.GCc = b.bS(parambl);
        ad.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.GCc);
        if ((h.a.eZA().qjU) && (this.GCF != null)) {
          this.GCF.setChecked(h.a.eZA().cf(parambl));
        }
        switch (28.GAt[this.GCc.ordinal()])
        {
        case 1: 
          AppMethodBeat.o(36186);
          return;
        }
      }
      finally {}
      aC(this.GCk, 4);
      setVideoStateIv(true);
      parambl = j.ch(parambl);
      if (parambl == null)
      {
        AppMethodBeat.o(36186);
      }
      else
      {
        eZC().yEw.setVideoTotalTime(parambl.gOY);
        int i = j;
        try
        {
          if (this.GzZ.eZs() != null)
          {
            i = j;
            if (this.GzZ.eZs().GDN != null) {
              i = this.GzZ.eZs().GDN.getCurrentPosition() / 1000;
            }
          }
        }
        catch (Exception parambl)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.ImageGalleryUI", parambl, "", new Object[0]);
            i = j;
          }
        }
        eZC().yEw.seek(i);
        AppMethodBeat.o(36186);
        continue;
        com.tencent.mm.aw.e locale = this.GzZ.h(parambl, false);
        cjY();
        eZH();
        if (locale == null)
        {
          ad.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
          AppMethodBeat.o(36186);
        }
        else if ((this.GCq) && (locale.ayh()) && (this.GzZ.eZr() != null) && (parambl.field_msgId == this.GzZ.eZr().field_msgId))
        {
          ad.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[] { Long.valueOf(parambl.field_msgId) });
          eZT();
          this.GCq = false;
          AppMethodBeat.o(36186);
        }
        else
        {
          bl localbl = this.GzZ.eZr();
          boolean bool = this.GCq;
          long l = parambl.field_msgId;
          if (localbl == null) {}
          for (parambl = "null";; parambl = Long.valueOf(localbl.field_msgId))
          {
            ad.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), parambl, Boolean.valueOf(locale.ayh()) });
            AppMethodBeat.o(36186);
            break;
          }
          cjY();
          eZH();
          AppMethodBeat.o(36186);
          continue;
          cjY();
          eZH();
          aC(this.GCk, 4);
          this.GzZ.Zg(this.rJU.getCurrentItem());
        }
      }
    }
  }
  
  public final void cjY()
  {
    AppMethodBeat.i(36184);
    ad.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    wo(false);
    aC(eZC().yEw, 8);
    aC(this.qmk, 8);
    aC(this.Bsm, 8);
    AppMethodBeat.o(36184);
  }
  
  public final boolean dPO()
  {
    AppMethodBeat.i(36193);
    boolean bool = eZC().yEw.bTK();
    AppMethodBeat.o(36193);
    return bool;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36195);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.mET != null)
      {
        this.mET.bfo();
        this.mET = null;
      }
      for (;;)
      {
        AppMethodBeat.o(36195);
        return true;
        if ((this.qgu == 0) || (this.qgu == 2)) {
          iD(true);
        } else {
          iD(true);
        }
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(36195);
    return bool;
  }
  
  final ImageGalleryUI eZB()
  {
    AppMethodBeat.i(36152);
    if (this.GCk == null)
    {
      this.GCk = findViewById(2131300930);
      this.GCl = ((Button)this.GCk.findViewById(2131298876));
      this.GCm = ((Button)this.GCk.findViewById(2131298877));
      this.GCn = this.GCk.findViewById(2131298878);
      TextView localTextView = (TextView)this.GCk.findViewById(2131298872);
      this.GCl.getPaint().setFakeBoldText(true);
      this.GCm.getPaint().setFakeBoldText(true);
      localTextView.getPaint().setFakeBoldText(true);
      float f = Math.min(1.125F, com.tencent.mm.cd.a.dT(this));
      this.GCl.setTextSize(1, 12.0F * f);
      this.GCm.setTextSize(1, f * 12.0F);
    }
    AppMethodBeat.o(36152);
    return this;
  }
  
  protected final ImageGalleryUI eZC()
  {
    AppMethodBeat.i(36153);
    if (this.yEw == null)
    {
      this.yEw = ((RedesignVideoPlayerSeekBar)findViewById(2131306375));
      this.yEw.setPlayBtnOnClickListener(this);
    }
    AppMethodBeat.o(36153);
    return this;
  }
  
  public final void eZH()
  {
    int j = 0;
    AppMethodBeat.i(36174);
    if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
      ad.d("MicroMsg.ImageGalleryUI", "showOpLayer %s", new Object[] { bt.eGN() });
    }
    if (this.GzZ != null) {}
    for (Object localObject = this.GzZ.eZr();; localObject = null)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(36174);
        return;
      }
      if (bk.z((bl)localObject))
      {
        ad.w("MicroMsg.ImageGalleryUI", "ignore show opLayer");
        AppMethodBeat.o(36174);
        return;
      }
      if (!this.GCP) {
        eZP();
      }
      this.GCP = true;
      this.GCd.setVisibility(0);
      eZN();
      if (!eUl())
      {
        this.GCi.setVisibility(0);
        View localView = eZD().GCh;
        if (this.GCu)
        {
          i = 0;
          aC(localView, i);
        }
      }
      else
      {
        if (this.GCc == b.b.GAJ) {
          break label245;
        }
      }
      label245:
      for (int i = 0;; i = 1)
      {
        if ((bk.x((bl)localObject)) || (bk.y((bl)localObject))) {
          i = 0;
        }
        if (eUl()) {
          i = 0;
        }
        localObject = eZE().GCj;
        if (i != 0) {}
        for (i = j;; i = 8)
        {
          aC((View)localObject, i);
          if (eZM()) {
            cjZ();
          }
          lJ(true);
          wn(true);
          AppMethodBeat.o(36174);
          return;
          i = 8;
          break;
        }
      }
    }
  }
  
  public final void eZI()
  {
    AppMethodBeat.i(36175);
    if (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
      ad.d("MicroMsg.ImageGalleryUI", "hideOpLayer %s", new Object[] { bt.eGN() });
    }
    if (!this.GCP)
    {
      AppMethodBeat.o(36175);
      return;
    }
    this.GCP = false;
    eqF();
    AppMethodBeat.o(36175);
  }
  
  public final void eZJ()
  {
    AppMethodBeat.i(36176);
    this.qmv.stopTimer();
    this.GCi.setVisibility(8);
    eZD().GCh.clearAnimation();
    aC(eZD().GCh, 8);
    aC(eZE().GCj, 8);
    cjY();
    lJ(false);
    wn(false);
    this.GCd.setVisibility(8);
    AppMethodBeat.o(36176);
  }
  
  protected final void eZN()
  {
    AppMethodBeat.i(36182);
    if (this.GCP) {
      this.qmv.av(4000L, 4000L);
    }
    AppMethodBeat.o(36182);
  }
  
  public final b eZO()
  {
    return this.GzZ;
  }
  
  public final void eZR()
  {
    AppMethodBeat.i(36201);
    cjY();
    eZB().GCk.setVisibility(0);
    eZB().GCl.setVisibility(8);
    eZB().GCm.setVisibility(0);
    eZB().GCn.setVisibility(8);
    eZB().GCm.setText("0%");
    AppMethodBeat.o(36201);
  }
  
  public void finish()
  {
    AppMethodBeat.i(36203);
    this.GtG.clear();
    super.finish();
    AppMethodBeat.o(36203);
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(204972);
    int i = this.rJU.getCurrentItem();
    AppMethodBeat.o(204972);
    return i;
  }
  
  public int getForceOrientation()
  {
    return 2;
  }
  
  public int getLayoutId()
  {
    return 2131494460;
  }
  
  protected final void iD(boolean paramBoolean)
  {
    AppMethodBeat.i(36167);
    int i = this.GCI;
    if (this.GzZ == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.ImageGalleryUI", "showMenu mSelectedPos %d, %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      if (this.GzZ != null) {
        break;
      }
      AppMethodBeat.o(36167);
      return;
    }
    if (this.GCI < 0)
    {
      AppMethodBeat.o(36167);
      return;
    }
    Object localObject1 = this.GzZ.YE(this.GCI);
    i = this.GzZ.GAf.bZ((bl)localObject1);
    if ((i == 5) || (i == 6))
    {
      ad.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
      AppMethodBeat.o(36167);
      return;
    }
    Object localObject2 = this.GzZ;
    if (localObject1 != null)
    {
      localObject2 = ((b)localObject2).h((bl)localObject1, false);
      if (localObject2 != null) {
        if ((localObject1 == null) || (localObject2 == null)) {
          bool = false;
        }
      }
    }
    while (bool)
    {
      ad.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
      AppMethodBeat.o(36167);
      return;
      if ((o.ayG().a(((com.tencent.mm.aw.e)localObject2).deI, ((du)localObject1).field_msgId, 0)) || (b.b((bl)localObject1, (com.tencent.mm.aw.e)localObject2)))
      {
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        localObject2 = j.ch((bl)localObject1);
        if ((localObject2 != null) && (localObject2 != null))
        {
          i = ((s)localObject2).status;
          int j = com.tencent.mm.modelvideo.u.g((s)localObject2);
          if (((i == 112) || (i == 122)) && (j < 100)) {}
          for (bool = true;; bool = false)
          {
            ad.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
            break;
          }
        }
        bool = false;
      }
    }
    if (b.m((bl)localObject1))
    {
      if ((j.ch((bl)localObject1) == null) && (!((bl)localObject1).cjN()))
      {
        ad.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
        AppMethodBeat.o(36167);
        return;
      }
      if (((bl)localObject1).cjN())
      {
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.media.a.Bsg;
        com.tencent.mm.plugin.webview.ui.tools.media.a.iF(eZL(), eZK());
      }
    }
    localObject2 = new ArrayList();
    final ArrayList localArrayList = new ArrayList();
    if (!bk.y((bl)localObject1))
    {
      ((List)localObject2).add(Integer.valueOf(0));
      localArrayList.add(getString(2131762566));
    }
    if (com.tencent.mm.bs.d.axB("favorite"))
    {
      ((List)localObject2).add(Integer.valueOf(2));
      localArrayList.add(getString(2131761941));
    }
    long l;
    if (!bk.y((bl)localObject1))
    {
      if ((b.j((bl)localObject1)) || (b.bQ((bl)localObject1)))
      {
        ((List)localObject2).add(Integer.valueOf(1));
        localArrayList.add(getString(2131762781));
      }
    }
    else
    {
      Object localObject3;
      if ((this.qeg) && (!bt.isNullOrNil(ciZ())))
      {
        ((List)localObject2).add(Integer.valueOf(7));
        localArrayList.add(getString(2131757184));
        localObject3 = new ao();
        if (this.qgu != 2) {
          break label1088;
        }
        l = 1L;
        label607:
        ((ao)localObject3).dKe = l;
        ((ao)localObject3).dFd = 2L;
        ((ao)localObject3).dMB = 4L;
        ((ao)localObject3).aBj();
      }
      if ((b.j((bl)localObject1)) || (b.bO((bl)localObject1)))
      {
        localObject3 = new dx();
        ((dx)localObject3).dgp.msgId = ((du)localObject1).field_msgId;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
        if ((((dx)localObject3).dgq.dfO) || (com.tencent.mm.pluginsdk.model.app.h.ag(getContext(), ((bl)localObject1).getType())))
        {
          ((List)localObject2).add(Integer.valueOf(4));
          localArrayList.add(getString(2131757228));
        }
      }
      if (b.j((bl)localObject1))
      {
        if (this.GCy != 1) {
          break label1094;
        }
        i = 0;
        label754:
        if (i != 0)
        {
          ((List)localObject2).add(Integer.valueOf(6));
          localArrayList.add(getString(2131757183));
        }
      }
      if ((this.xmw != null) && (aKU(this.xmw)))
      {
        ((List)localObject2).add(Integer.valueOf(3));
        localArrayList.add(this.GCC.dkU());
      }
      if ((eZG()) && (!eUl()))
      {
        ((List)localObject2).add(Integer.valueOf(5));
        localArrayList.add(getString(2131757182));
      }
      if ((!bk.x((bl)localObject1)) || (eUl())) {
        break label1099;
      }
      ((List)localObject2).clear();
      localArrayList.clear();
      if (eZG())
      {
        ((List)localObject2).add(Integer.valueOf(5));
        localArrayList.add(getString(2131757182));
      }
    }
    label1088:
    label1094:
    label1099:
    while (!bk.z((bl)localObject1))
    {
      if (this.mET == null) {
        this.mET = new com.tencent.mm.ui.widget.a.e(getContext(), 1, false);
      }
      this.mET.HrX = new n.c()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(36119);
          ImageGalleryUI.c(ImageGalleryUI.this).setFooterView(null);
          paramAnonymousl.clear();
          int i = 0;
          if (i < this.oEZ.size())
          {
            if (((Integer)this.oEZ.get(i)).intValue() == 3)
            {
              com.tencent.mm.ui.widget.a.e locale = ImageGalleryUI.c(ImageGalleryUI.this);
              ImageGalleryUI localImageGalleryUI = ImageGalleryUI.this;
              localArrayList.get(i);
              locale.setFooterView(ImageGalleryUI.D(localImageGalleryUI));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymousl.c(((Integer)this.oEZ.get(i)).intValue(), (CharSequence)localArrayList.get(i));
            }
          }
          AppMethodBeat.o(36119);
        }
      };
      if (((List)localObject2).size() != 0) {
        break label1114;
      }
      ad.w("MicroMsg.ImageGalleryUI", "show menu itemIds.size() == 0");
      AppMethodBeat.o(36167);
      return;
      if ((b.m((bl)localObject1)) || (b.bO((bl)localObject1)))
      {
        if (((bl)localObject1).cjN()) {
          break;
        }
        ((List)localObject2).add(Integer.valueOf(1));
        localArrayList.add(getString(2131762784));
        break;
      }
      ((List)localObject2).add(Integer.valueOf(1));
      localArrayList.add(getString(2131762783));
      break;
      l = 0L;
      break label607;
      i = 1;
      break label754;
    }
    AppMethodBeat.o(36167);
    return;
    label1114:
    this.mET.HrY = this.oEU;
    this.mET.GHn = new e.b()
    {
      public final void onDismiss()
      {
        AppMethodBeat.i(36120);
        as localas = new as();
        localas.dcP.filePath = ImageGalleryUI.g(ImageGalleryUI.this);
        com.tencent.mm.sdk.b.a.ESL.l(localas);
        ImageGalleryUI.E(ImageGalleryUI.this);
        ImageGalleryUI.k(ImageGalleryUI.this);
        ImageGalleryUI.a(ImageGalleryUI.this);
        ImageGalleryUI.b(ImageGalleryUI.this);
        ImageGalleryUI.a(ImageGalleryUI.this, null);
        ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.b(ImageGalleryUI.this, 0));
        ImageGalleryUI.a(ImageGalleryUI.this, false);
        ImageGalleryUI.d(ImageGalleryUI.this);
        ImageGalleryUI.e(ImageGalleryUI.this);
        ImageGalleryUI.f(ImageGalleryUI.this);
        ImageGalleryUI.j(ImageGalleryUI.this).vLD = null;
        AppMethodBeat.o(36120);
      }
    };
    this.mET.HES = new e.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(36121);
        if (ImageGalleryUI.n(ImageGalleryUI.this) == null)
        {
          AppMethodBeat.o(36121);
          return;
        }
        Object localObject = ImageGalleryUI.n(ImageGalleryUI.this).eZr();
        if ((localObject != null) && (((bl)localObject).cjN()))
        {
          localObject = com.tencent.mm.plugin.webview.ui.tools.media.a.Bsg;
          com.tencent.mm.plugin.webview.ui.tools.media.a.aB(3, ImageGalleryUI.F(ImageGalleryUI.this), ImageGalleryUI.G(ImageGalleryUI.this));
        }
        AppMethodBeat.o(36121);
      }
    };
    this.mET.csG();
    localObject1 = ciZ();
    if ((!bt.isNullOrNil((String)localObject1)) && (paramBoolean) && (com.tencent.mm.model.az.aeS().auR() != 0))
    {
      localObject2 = new pj();
      ((pj)localObject2).duX.dcQ = System.currentTimeMillis();
      ((pj)localObject2).duX.filePath = ((String)localObject1);
      this.xmt = ((String)localObject1);
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
    }
    AppMethodBeat.o(36167);
  }
  
  public void initView()
  {
    AppMethodBeat.i(36163);
    this.nzV = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    this.talker = getIntent().getStringExtra("img_gallery_talker");
    this.GCv = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.GxC = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.GCx = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.GxB = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.GCu = getIntent().getBooleanExtra("show_enter_grid", true);
    this.qbB = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.mUQ = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.GCe = getIntent().getBooleanExtra("img_preview_only", false);
    this.GCy = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
    this.GjV = getIntent().getIntExtra("msg_type", 0);
    if ((!this.GCe) && (bt.isNullOrNil(this.talker))) {
      ad.e("MicroMsg.ImageGalleryUI", " initView, talker is null. intent: " + getIntent());
    }
    this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
    this.GCw = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    this.GCz = getIntent().getStringExtra("img_gallery_enter_video_opcode");
    boolean bool2 = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
    String str = getIntent().getStringExtra("img_gallery_directly_send_name");
    this.qgx = ((ImageView)findViewById(2131304342));
    this.qgy = ((ImageView)findViewById(2131304340));
    Object localObject = (FrameLayout.LayoutParams)this.qgy.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin += com.tencent.mm.ui.ap.eb(this);
    this.qgy.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.qgy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36146);
        paramAnonymousView = new at();
        paramAnonymousView.dcR.scene = 1;
        paramAnonymousView.dcR.dcS = ImageGalleryUI.o(ImageGalleryUI.this);
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
        ImageGalleryUI.m(ImageGalleryUI.this);
        ImageGalleryUI.p(ImageGalleryUI.this);
        AppMethodBeat.o(36146);
      }
    });
    this.qgw = ((ImageView)findViewById(2131304343));
    this.qgz = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qgz.setDuration(5000L);
    this.qgz.addListener(new ImageGalleryUI.5(this));
    int i = getWindowManager().getDefaultDisplay().getHeight();
    this.qgz.addUpdateListener(new ImageGalleryUI.6(this, i));
    this.msgId = getIntent().getLongExtra("img_gallery_msg_id", 0L);
    this.GAj = getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    long l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
    if (!this.GAj)
    {
      if ((this.msgId <= 0L) && (l == 0L))
      {
        ad.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + bt.eGN());
        finish();
        AppMethodBeat.o(36163);
        return;
      }
      if (this.msgId == 0L)
      {
        com.tencent.mm.model.az.arV();
        this.msgId = com.tencent.mm.model.c.apO().aD(eZF(), l).field_msgId;
      }
      com.tencent.mm.model.az.arV();
      localObject = com.tencent.mm.model.c.apO().rm(this.msgId);
      if (((du)localObject).field_msgId <= 0L)
      {
        ad.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.msgId + ", msgSvrId = " + l + ", stack = " + bt.eGN());
        finish();
        AppMethodBeat.o(36163);
      }
    }
    else
    {
      localObject = j.b(this.talker, this);
    }
    for (;;)
    {
      boolean bool1;
      if (wO(this.msgId) == 3)
      {
        bool1 = true;
        this.GCA = bool1;
        this.GzZ = new b(this, this.msgId, eZF(), this.qbB, this.mUQ, bool2, str, Boolean.valueOf(this.GCw), this.GjV);
        this.GzZ.GAk = false;
        this.GzZ.GAd = getIntent().getBooleanExtra("start_chatting_ui", true);
        this.GzZ.GAi = new b.c()
        {
          public final void rq()
          {
            AppMethodBeat.i(36147);
            if (ImageGalleryUI.n(ImageGalleryUI.this) == null)
            {
              AppMethodBeat.o(36147);
              return;
            }
            ImageGalleryUI.this.eZH();
            ImageGalleryUI.q(ImageGalleryUI.this);
            ImageGalleryUI.n(ImageGalleryUI.this).onPageSelected(100000);
            AppMethodBeat.o(36147);
          }
        };
        this.qmm = ((RelativeLayout)findViewById(2131298875));
        this.GCd = ((RelativeLayout)findViewById(2131298880));
        this.qmm.setOnClickListener(new ImageGalleryUI.34(this));
        this.qmk = ((ImageView)findViewById(2131306316));
        this.qmk.setOnClickListener(this);
        this.GCi = ((ImageView)findViewById(2131306373));
        if (!bf(this)) {
          break label1280;
        }
        eqH();
        label919:
        this.qdk = ((ImageView)findViewById(2131300336));
        this.rJU = ((MMViewPager)findViewById(2131300335));
        this.rJU.setVerticalFadingEdgeEnabled(false);
        this.rJU.setHorizontalFadingEdgeEnabled(false);
        this.rJU.setSingleClickOverListener(new MMViewPager.e()
        {
          public final void aHo()
          {
            AppMethodBeat.i(36101);
            ImageGalleryUI.r(ImageGalleryUI.this);
            AppMethodBeat.o(36101);
          }
          
          public final void cAM()
          {
            AppMethodBeat.i(36102);
            ImageGalleryUI.s(ImageGalleryUI.this);
            AppMethodBeat.o(36102);
          }
        });
        if (!this.GCe)
        {
          this.rJU.setOnPageChangeListener(this.GCK);
          this.rJU.setLongClickOverListener(new MMViewPager.c()
          {
            public final void aHp()
            {
              AppMethodBeat.i(36103);
              if (ImageGalleryUI.l(ImageGalleryUI.this) == 1)
              {
                AppMethodBeat.o(36103);
                return;
              }
              ImageGalleryUI.t(ImageGalleryUI.this);
              ao localao;
              if ((ImageGalleryUI.l(ImageGalleryUI.this) == 0) || (ImageGalleryUI.l(ImageGalleryUI.this) == 2))
              {
                localao = new ao();
                if (ImageGalleryUI.l(ImageGalleryUI.this) != 2) {
                  break label108;
                }
              }
              label108:
              for (long l = 1L;; l = 0L)
              {
                localao.dKe = l;
                localao.dFd = 1L;
                localao.dMB = 4L;
                localao.aBj();
                ImageGalleryUI.this.iD(true);
                AppMethodBeat.o(36103);
                return;
              }
            }
          });
        }
        this.rJU.setOffscreenPageLimit(1);
        this.rJU.setAdapter(this.GzZ);
        Zn(100000);
        this.rJU.setCurrentItem(100000);
        this.rJU.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36104);
            if (ImageGalleryUI.n(ImageGalleryUI.this) == null)
            {
              AppMethodBeat.o(36104);
              return;
            }
            if ((h.a.eZA().qjU) && (ImageGalleryUI.u(ImageGalleryUI.this) != null))
            {
              ImageGalleryUI.u(ImageGalleryUI.this).setChecked(h.a.eZA().cf(ImageGalleryUI.n(ImageGalleryUI.this).eZr()));
              ImageGalleryUI.v(ImageGalleryUI.this).setOnClickListener(ImageGalleryUI.this);
            }
            if (ImageGalleryUI.this.rJU.getCurrentItem() != 100000)
            {
              AppMethodBeat.o(36104);
              return;
            }
            ImageGalleryUI.this.eZN();
            b.b localb = b.bS(ImageGalleryUI.n(ImageGalleryUI.this).YE(100000));
            if ((!ImageGalleryUI.this.GCw) && (localb == b.b.GAK)) {
              ImageGalleryUI.n(ImageGalleryUI.this).Zc(100000);
            }
            if (localb == b.b.GAL) {
              ImageGalleryUI.n(ImageGalleryUI.this).Zg(100000);
            }
            AppMethodBeat.o(36104);
          }
        }, 0L);
        if (h.a.eZA().qjU)
        {
          this.GCE = ((ViewStub)findViewById(2131304544)).inflate();
          this.GCE.setVisibility(0);
          this.GCF = ((CheckBox)this.GCE.findViewById(2131302204));
          this.GCG = this.GCE.findViewById(2131302205);
        }
        this.GCq = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
        localObject = this.GzZ.h((bl)localObject, true);
        if (localObject == null) {
          ad.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.GCq) });
        }
        if ((!this.GCq) || (localObject == null) || (!((com.tencent.mm.aw.e)localObject).ayh())) {
          break label1287;
        }
        eZT();
        this.GCq = false;
      }
      for (;;)
      {
        this.rJU.setOnTouchListener(new ImageGalleryUI.4(this));
        if (eUl())
        {
          this.GCi.setVisibility(8);
          aC(eZD().GCh, 8);
          aC(eZE().GCj, 8);
        }
        AppMethodBeat.o(36163);
        return;
        bool1 = false;
        break;
        label1280:
        eqI();
        break label919;
        label1287:
        if (this.GCq) {
          ad.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
        }
      }
    }
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(36173);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.Bit != null) && (this.Bit.c(this, paramInt1, paramInt2, paramIntent)))
    {
      AppMethodBeat.o(36173);
      return;
    }
    AppMethodBeat.o(36173);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(36161);
    ad.i("MicroMsg.ImageGalleryUI", "onBackPressed");
    if (this.GCv)
    {
      Zp(1);
      AppMethodBeat.o(36161);
      return;
    }
    try
    {
      h.a.eZA().detach();
      bKT();
      AppMethodBeat.o(36161);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ImageGalleryUI", localException.getMessage());
      finish();
      AppMethodBeat.o(36161);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    AppMethodBeat.i(36191);
    if (this.GzZ == null)
    {
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131299498)
    {
      Zp(0);
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131306373)
    {
      this.GCf = false;
      iD(true);
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131299194)
    {
      ad.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.rJU.getCurrentItem()) });
      paramView = this.GzZ.YE(this.rJU.getCurrentItem());
      com.tencent.mm.aw.e locale = this.GzZ.h(paramView, false);
      this.rJU.getCurrentItem();
      if ((f(paramView, locale)) && (!paramView.eMl()) && (locale.ayh()))
      {
        this.GzZ.aV(this.rJU.getCurrentItem(), true);
        AppMethodBeat.o(36191);
        return;
      }
      b.c(getContext(), this.GzZ.eZr(), true);
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131298876)
    {
      this.qgu = 2;
      this.qgt = 0;
      this.GzZ.aV(this.rJU.getCurrentItem(), false);
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131298877)
    {
      this.GzZ.Zf(this.rJU.getCurrentItem());
      Zn(this.rJU.getCurrentItem());
      eZH();
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131296416)
    {
      onBackPressed();
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131306316)
    {
      onBackPressed();
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131302205)
    {
      boolean bool2 = this.GCF.isChecked();
      if ((!bool2) && (h.a.eZA().qjT.size() >= 9))
      {
        Toast.makeText(this, getResources().getString(2131759803, new Object[] { Integer.valueOf(9) }), 1).show();
        AppMethodBeat.o(36191);
        return;
      }
      paramView = this.GCF;
      if (!bool2) {}
      for (;;)
      {
        paramView.setChecked(bool1);
        if (!this.GCF.isChecked()) {
          break;
        }
        h.a.eZA().cd(this.GzZ.eZr());
        AppMethodBeat.o(36191);
        return;
        bool1 = false;
      }
      h.a.eZA().ce(this.GzZ.eZr());
      AppMethodBeat.o(36191);
      return;
    }
    if (paramView.getId() == 2131303281)
    {
      this.GzZ.eZs();
      this.GzZ.Zc(this.rJU.getCurrentItem());
    }
    AppMethodBeat.o(36191);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(36206);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ad.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      eqH();
      AppMethodBeat.o(36206);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ad.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      eqI();
      AppMethodBeat.o(36206);
      return;
    }
    AppMethodBeat.o(36206);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(36157);
    requestWindowFeature(1);
    long l = System.currentTimeMillis();
    this.GCH = true;
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.lf(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.tAJ = true;; this.tAJ = false)
    {
      setLightNavigationbarIcon();
      initView();
      this.nzU = paramBundle;
      com.tencent.mm.sdk.b.a.ESL.c(this.qej);
      com.tencent.mm.sdk.b.a.ESL.c(this.xmF);
      com.tencent.mm.sdk.b.a.ESL.c(this.qgA);
      this.yEG = false;
      this.GCC = new ScanCodeSheetItemLogic(this, new ScanCodeSheetItemLogic.a()
      {
        public final void beE()
        {
          AppMethodBeat.i(36145);
          ImageGalleryUI.this.iD(false);
          AppMethodBeat.o(36145);
        }
      });
      ad.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(36157);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(36172);
    super.onCreateBeforeSetContentView();
    AppMethodBeat.o(36172);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(36160);
    ad.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      if (this.GzZ != null)
      {
        Zo(this.GCI);
        this.GCg.a(this, this.GCI, 0);
        this.GzZ.detach();
        this.GzZ = null;
      }
      this.qmv.stopTimer();
      cjn();
      this.qgz.removeAllUpdateListeners();
      com.tencent.mm.sdk.b.a.ESL.d(this.qej);
      com.tencent.mm.sdk.b.a.ESL.d(this.xmF);
      com.tencent.mm.sdk.b.a.ESL.d(this.qgA);
      com.tencent.mm.kernel.g.afA().b(this.qgB);
      pw localpw = new pw();
      localpw.dvy.activity = this;
      com.tencent.mm.sdk.b.a.ESL.l(localpw);
      if (this.yEw != null) {
        this.yEw.setPlayBtnOnClickListener(null);
      }
      this.yEw = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ImageGalleryUI", localException, "", new Object[0]);
      }
    }
    if (com.tencent.mm.graphics.b.c.fWs.fWx) {
      com.tencent.mm.graphics.b.c.fWs.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(36160);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(36202);
    if (paramInt == 82)
    {
      AppMethodBeat.o(36202);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(36202);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(36150);
    ad.i("MicroMsg.ImageGalleryUI", "on pause");
    super.onPause();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    Object localObject;
    if ((!isFinishing()) && (this.GzZ != null))
    {
      localObject = this.GzZ;
      ((b)localObject).GAg.GDo.sendEmptyMessageDelayed(1, 200L);
      ((b)localObject).GAh.MV();
    }
    if (this.xmw != null)
    {
      localObject = new ar();
      ((ar)localObject).dcN.activity = this;
      ((ar)localObject).dcN.dcO = this.xmw;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      this.xmw = null;
      this.kxl = 0;
      this.kxk = 0;
    }
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(36150);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(36158);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if ((!this.GCH) && (this.GzZ != null)) {
      Zn(this.rJU.getCurrentItem());
    }
    this.GCH = false;
    if (this.GzZ != null) {
      this.GzZ.eZt();
    }
    com.tencent.mm.kernel.g.afA().a(this.qgB);
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    AppMethodBeat.o(36158);
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(36159);
    this.GCw = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    Bundle localBundle;
    if (!this.GCe)
    {
      localBundle = this.nzU;
      ad.i("MicroMsg.ImageGalleryUI", "[handleAnimation] isAnimated:" + this.isAnimated);
      if (!this.isAnimated)
      {
        this.isAnimated = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.nzW = getIntent().getIntExtra("img_gallery_top", 0);
          this.nzX = getIntent().getIntExtra("img_gallery_left", 0);
          this.nzY = getIntent().getIntExtra("img_gallery_width", 0);
          this.nzZ = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.nzW == 0) && (this.nzX == 0) && (this.nzY == 0) && (this.nzZ == 0))
          {
            bl localbl = this.GzZ.YE(this.rJU.getCurrentItem());
            if (localbl != null)
            {
              com.tencent.mm.g.a.az localaz = new com.tencent.mm.g.a.az();
              localaz.ddf.dbD = localbl;
              com.tencent.mm.sdk.b.a.ESL.l(localaz);
              this.nzY = localaz.ddg.ddj;
              this.nzZ = localaz.ddg.ddk;
              this.nzX = localaz.ddg.ddh;
              this.nzW = localaz.ddg.ddi;
            }
          }
          this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
          if (localBundle != null) {
            break label343;
          }
        }
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.ImageGalleryUI", "[handleAnimation] savedInstanceState is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (localBundle == null) {
        this.rJU.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            AppMethodBeat.i(36112);
            ImageGalleryUI.this.rJU.getViewTreeObserver().removeOnPreDrawListener(this);
            ad.i("MicroMsg.ImageGalleryUI", "[handleAnimation] -> onPreDraw, isBackFromGrid:" + ImageGalleryUI.this.GCw);
            ImageGalleryUI.this.xvY = ImageGalleryUI.this.rJU.getWidth();
            ImageGalleryUI.this.xvZ = ImageGalleryUI.this.rJU.getHeight();
            if (ImageGalleryUI.n(ImageGalleryUI.this).eZr().cjO()) {
              ImageGalleryUI.this.xvZ = ((int)(ImageGalleryUI.this.xvY / ImageGalleryUI.this.nzY * ImageGalleryUI.this.nzZ));
            }
            if (ImageGalleryUI.n(ImageGalleryUI.this).eZr().eJO())
            {
              com.tencent.mm.ui.base.g localg = (com.tencent.mm.ui.base.g)ImageGalleryUI.a(ImageGalleryUI.this, ImageGalleryUI.n(ImageGalleryUI.this), ImageGalleryUI.this.rJU);
              if (localg != null)
              {
                ImageGalleryUI localImageGalleryUI = ImageGalleryUI.this;
                float f = ImageGalleryUI.this.xvY / localg.getImageWidth();
                localImageGalleryUI.xvZ = ((int)(localg.getImageHeight() * f));
                if (ImageGalleryUI.this.xvZ > ImageGalleryUI.this.rJU.getHeight()) {
                  ImageGalleryUI.this.xvZ = ImageGalleryUI.this.rJU.getHeight();
                }
              }
            }
            ImageGalleryUI.this.nzV.jB(ImageGalleryUI.this.xvY, ImageGalleryUI.this.xvZ);
            if (!ImageGalleryUI.this.GCw) {
              ImageGalleryUI.this.nzV.a(ImageGalleryUI.this.rJU, ImageGalleryUI.x(ImageGalleryUI.this), new e.c()
              {
                public final void onAnimationEnd()
                {
                  AppMethodBeat.i(36111);
                  ImageGalleryUI.y(ImageGalleryUI.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(36109);
                      if (ImageGalleryUI.this.GCD != null) {
                        ImageGalleryUI.this.GCD.o(Boolean.FALSE);
                      }
                      AppMethodBeat.o(36109);
                    }
                  });
                  AppMethodBeat.o(36111);
                }
                
                public final void onAnimationStart()
                {
                  AppMethodBeat.i(36110);
                  if (ImageGalleryUI.this.GCD != null) {
                    ImageGalleryUI.this.GCD.o(Boolean.TRUE);
                  }
                  AppMethodBeat.o(36110);
                }
              });
            }
            ImageGalleryUI.z(ImageGalleryUI.this);
            AppMethodBeat.o(36112);
            return true;
          }
        });
      }
      super.onStart();
      AppMethodBeat.o(36159);
      return;
      label343:
      bool = false;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(36151);
    super.onStop();
    com.tencent.mm.graphics.b.d.fWA.ade();
    if (com.tencent.mm.graphics.b.c.fWs.fWx) {
      com.tencent.mm.graphics.b.c.fWs.stop();
    }
    AppMethodBeat.o(36151);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setVideoStateIv(boolean paramBoolean)
  {
    AppMethodBeat.i(36192);
    try
    {
      RedesignVideoPlayerSeekBar localRedesignVideoPlayerSeekBar = eZC().yEw;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localRedesignVideoPlayerSeekBar.setIsPlay(paramBoolean);
        AppMethodBeat.o(36192);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + localException.toString());
      AppMethodBeat.o(36192);
    }
  }
  
  public final int wO(long paramLong)
  {
    AppMethodBeat.i(36204);
    if (bt.isNullOrNil(this.GCz))
    {
      AppMethodBeat.o(36204);
      return 0;
    }
    try
    {
      int j = com.tencent.mm.modelvideo.u.g(paramLong, this.GCz);
      int i = j;
      if (j == -1)
      {
        this.GCz = null;
        i = 0;
      }
      ad.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.GCz });
      AppMethodBeat.o(36204);
      return i;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + localException.toString());
      AppMethodBeat.o(36204);
    }
    return 0;
  }
  
  public final void wP(long paramLong)
  {
    AppMethodBeat.i(36205);
    if ((bt.isNullOrNil(this.GCz)) || (paramLong == 0L))
    {
      AppMethodBeat.o(36205);
      return;
    }
    if (this.GCA)
    {
      this.GCz = com.tencent.mm.modelvideo.u.f(paramLong, 3);
      ad.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.GCz });
      AppMethodBeat.o(36205);
      return;
    }
    if (com.tencent.mm.modelvideo.u.g(paramLong, this.GCz) == -1)
    {
      this.GCz = null;
      ad.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.GCz });
    }
    AppMethodBeat.o(36205);
  }
  
  public static abstract interface a
  {
    public abstract void o(Boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI
 * JD-Core Version:    0.7.0.1
 */