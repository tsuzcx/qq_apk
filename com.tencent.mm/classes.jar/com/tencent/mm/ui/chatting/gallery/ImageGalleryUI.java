package com.tencent.mm.ui.chatting.gallery;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.an;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.av.b;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.b.a.m;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.b;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.d;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI
  extends MMActivity
  implements View.OnClickListener, a.a<String, Integer>, ap.a
{
  protected String chatroomName;
  private View contentView;
  public long cpO;
  private int igY;
  private int igZ;
  private boolean isAnimated;
  public long jUy;
  com.tencent.mm.ui.tools.e kip;
  Bundle kuF;
  int kuG;
  int kuH;
  int kuI;
  int kuJ;
  private n.d loG;
  private ImageView mBi;
  private ak mHandler;
  public boolean muT;
  private com.tencent.mm.sdk.b.c mwt;
  protected MMViewPager nga;
  private boolean oFA;
  private ValueAnimator qAO;
  private n qAV;
  private ImageView qwk;
  private String rGA;
  private String rGB;
  private boolean rGC;
  private com.tencent.mm.sdk.b.c rGI;
  private com.tencent.mm.ui.widget.b.d rGv;
  private String rGw;
  private String rGz;
  int rOa;
  int rOb;
  int rOc;
  private float rOd;
  private int rOe;
  private int rOf;
  private boolean sYz;
  protected String talker;
  private HashSet<Long> zFa;
  private boolean zHu;
  protected boolean zHv;
  public c zJI;
  private final boolean zJT;
  private c.b zLJ;
  private RelativeLayout zLK;
  private RelativeLayout zLL;
  private boolean zLM;
  private ImageView zLN;
  private RelativeLayout zLO;
  private RelativeLayout zLP;
  private FrameLayout zLQ;
  View zLR;
  Button zLS;
  Button zLT;
  View zLU;
  private View zLV;
  protected VideoPlayerSeekBar zLW;
  int zLX;
  int zLY;
  boolean zLZ;
  private boolean zMA;
  private ap zMB;
  private boolean zMC;
  private boolean zMD;
  ArrayList<Integer> zMa;
  private boolean zMb;
  protected boolean zMc;
  protected boolean zMd;
  private boolean zMe;
  private int zMf;
  private com.tencent.mm.plugin.scanner.word.a<String, Integer> zMg;
  private volatile int zMh;
  private boolean zMi;
  private int zMj;
  private String zMk;
  private boolean zMl;
  private ImageView zMm;
  private ImageView zMn;
  public ImageGalleryUI.a zMo;
  private View zMp;
  private CheckBox zMq;
  private View zMr;
  private boolean zMs;
  private com.tencent.mm.sdk.b.c<qd> zMt;
  private int zMu;
  private ViewPager.OnPageChangeListener zMv;
  boolean zMw;
  ap zMx;
  private HashMap<Long, String> zMy;
  private boolean zMz;
  
  public ImageGalleryUI()
  {
    AppMethodBeat.i(32227);
    this.sYz = false;
    this.rOc = 0;
    this.zLX = 0;
    this.zLY = 0;
    this.kuG = 0;
    this.kuH = 0;
    this.kuI = 0;
    this.kuJ = 0;
    this.zMa = new ArrayList();
    this.zHu = false;
    this.muT = false;
    this.rGC = false;
    this.zMc = false;
    this.zHv = false;
    this.zMd = false;
    this.isAnimated = false;
    this.zMj = 0;
    this.zJT = false;
    this.zMk = null;
    this.mwt = new ImageGalleryUI.12(this);
    this.rGI = new ImageGalleryUI.21(this);
    this.qAV = new ImageGalleryUI.22(this);
    this.zMs = true;
    this.rOd = 1.0F;
    this.rOe = 0;
    this.rOf = 0;
    this.loG = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(153869);
        ab.i("MicroMsg.ImageGalleryUI", "curTransState %d", new Object[] { Integer.valueOf(ImageGalleryUI.f(ImageGalleryUI.this)) });
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(153869);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.j(ImageGalleryUI.this).dJX();
          Object localObject;
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.byj()))
          {
            localObject = u.vr(paramAnonymousMenuItem.field_imgPath);
            if ((localObject != null) && (((s)localObject).status != 199) && (((s)localObject).status != 199))
            {
              ImageGalleryUI.e(ImageGalleryUI.this, u.e(paramAnonymousMenuItem.field_msgId, 1));
              ImageGalleryUI.j(ImageGalleryUI.this).PW(ImageGalleryUI.this.nga.getCurrentItem());
              AppMethodBeat.o(153869);
              return;
            }
            ImageGalleryUI.j(ImageGalleryUI.this).PR(ImageGalleryUI.this.nga.getCurrentItem());
            AppMethodBeat.o(153869);
            return;
          }
          ImageGalleryUI.j(ImageGalleryUI.this).PR(ImageGalleryUI.this.nga.getCurrentItem());
          AppMethodBeat.o(153869);
          return;
          paramAnonymousMenuItem = ImageGalleryUI.j(ImageGalleryUI.this).dJX();
          if ((paramAnonymousMenuItem != null) && (paramAnonymousMenuItem.byj()))
          {
            localObject = u.vr(paramAnonymousMenuItem.field_imgPath);
            if ((((s)localObject).status != 199) && (((s)localObject).status != 199))
            {
              ImageGalleryUI.e(ImageGalleryUI.this, u.e(paramAnonymousMenuItem.field_msgId, 2));
              ImageGalleryUI.j(ImageGalleryUI.this).PW(ImageGalleryUI.this.nga.getCurrentItem());
              AppMethodBeat.o(153869);
              return;
            }
            paramAnonymousMenuItem = new ArrayList();
            paramAnonymousMenuItem.add(ImageGalleryUI.j(ImageGalleryUI.this).dJX());
            c.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
            AppMethodBeat.o(153869);
            return;
          }
          paramAnonymousMenuItem = new ArrayList();
          paramAnonymousMenuItem.add(ImageGalleryUI.j(ImageGalleryUI.this).dJX());
          com.tencent.mm.modelstat.b.fRu.H((bi)paramAnonymousMenuItem.get(0));
          c.f(ImageGalleryUI.this.getContext(), paramAnonymousMenuItem);
          AppMethodBeat.o(153869);
          return;
          ImageGalleryUI.j(ImageGalleryUI.this).PS(ImageGalleryUI.this.nga.getCurrentItem());
          AppMethodBeat.o(153869);
          return;
          if (com.tencent.mm.bq.d.ahR("favorite"))
          {
            ImageGalleryUI.j(ImageGalleryUI.this).PT(ImageGalleryUI.this.nga.getCurrentItem());
            AppMethodBeat.o(153869);
            return;
            ImageGalleryUI.D(ImageGalleryUI.this);
            AppMethodBeat.o(153869);
            return;
            if (ImageGalleryUI.j(ImageGalleryUI.this) != null)
            {
              if (c.c(ImageGalleryUI.j(ImageGalleryUI.this).dJX())) {
                ImageGalleryUI.E(ImageGalleryUI.this);
              }
              AppMethodBeat.o(153869);
              return;
              paramAnonymousMenuItem = ImageGalleryUI.F(ImageGalleryUI.this);
              if (((ImageGalleryUI.f(ImageGalleryUI.this) == 0) || (ImageGalleryUI.f(ImageGalleryUI.this) == 2)) && (!bo.isNullOrNil(paramAnonymousMenuItem)))
              {
                localObject = new m();
                if (ImageGalleryUI.f(ImageGalleryUI.this) == 2) {}
                for (long l = 1L;; l = 0L)
                {
                  ((m)localObject).cRG = l;
                  ((m)localObject).cRH = 3L;
                  ((m)localObject).ake();
                  ImageGalleryUI.e(ImageGalleryUI.this, (int)(r.Zn().hashCode() + System.currentTimeMillis() & 0xFFFFFFFF));
                  localObject = ag.cE(paramAnonymousMenuItem + com.tencent.mm.vfs.e.avJ(paramAnonymousMenuItem));
                  if (com.tencent.mm.plugin.scanner.e.chX().cic().Yz((String)localObject) == null) {
                    break;
                  }
                  localObject = new Intent();
                  ((Intent)localObject).putExtra("original_file_path", paramAnonymousMenuItem);
                  ((Intent)localObject).putExtra("msg_id", ImageGalleryUI.j(ImageGalleryUI.this).Pz(ImageGalleryUI.G(ImageGalleryUI.this)).field_msgId);
                  ImageGalleryUI.a(ImageGalleryUI.this, TranslationResultUI.class, (Intent)localObject);
                  ImageGalleryUI.this.finish();
                  ImageGalleryUI.this.overridePendingTransition(2131034130, 2131034130);
                  AppMethodBeat.o(153869);
                  return;
                }
                ImageGalleryUI.H(ImageGalleryUI.this);
                ab.i("MicroMsg.ImageGalleryUI", "try to translate img %s, sessionId %d", new Object[] { paramAnonymousMenuItem, Integer.valueOf(ImageGalleryUI.h(ImageGalleryUI.this)) });
                localObject = new qc();
                ((qc)localObject).cGF.scene = 1;
                ((qc)localObject).cGF.filePath = paramAnonymousMenuItem;
                ((qc)localObject).cGF.cnU = ImageGalleryUI.h(ImageGalleryUI.this);
                com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
              }
            }
          }
        }
      }
    };
    this.zMt = new com.tencent.mm.sdk.b.c() {};
    this.zMu = 0;
    this.zMv = new ImageGalleryUI.14(this);
    this.zMw = false;
    this.zMx = new ap(new ImageGalleryUI.15(this), false);
    this.zMy = new HashMap();
    this.zMz = false;
    this.zMA = false;
    this.mHandler = new ak(Looper.getMainLooper());
    this.zMC = false;
    this.zMD = false;
    this.zFa = new HashSet();
    AppMethodBeat.o(32227);
  }
  
  private void Qh(int paramInt)
  {
    AppMethodBeat.i(32263);
    ab.i("MicroMsg.ImageGalleryUI", "enterGrid source : ".concat(String.valueOf(paramInt)));
    if (this.zJI == null)
    {
      ab.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
      AppMethodBeat.o(32263);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 13L, 1L, true);
    int i = this.zJI.getRealCount();
    if (this.zJI.dJX() == null)
    {
      ab.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
      AppMethodBeat.o(32263);
      return;
    }
    int j = this.zJI.zJL.Qa(this.nga.getCurrentItem());
    if (!this.zMc)
    {
      Intent localIntent = new Intent();
      localIntent.setClass(getContext(), MediaHistoryGalleryUI.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("kintent_intent_source", paramInt);
      localIntent.putExtra("kintent_talker", dKl());
      localIntent.putExtra("kintent_image_count", i);
      localIntent.putExtra("kintent_image_index", j);
      localIntent.putExtra("key_biz_chat_id", this.jUy);
      localIntent.putExtra("key_is_biz_chat", this.muT);
      startActivity(localIntent);
      this.mHandler.postDelayed(new ImageGalleryUI.16(this), 50L);
      AppMethodBeat.o(32263);
      return;
    }
    bdV();
    AppMethodBeat.o(32263);
  }
  
  static Animation Qj(int paramInt)
  {
    AppMethodBeat.i(32275);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator(10.0F));
    AppMethodBeat.o(32275);
    return localAlphaAnimation;
  }
  
  private View a(c paramc, MMViewPager paramMMViewPager)
  {
    AppMethodBeat.i(32243);
    boolean bool1;
    if (paramc == null)
    {
      bool1 = true;
      if (paramMMViewPager != null) {
        break label75;
      }
    }
    label75:
    for (boolean bool2 = true;; bool2 = false)
    {
      ab.d("MicroMsg.ImageGalleryUI", "get current view adapter is null %b, gallery is null %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((paramc == null) || (paramMMViewPager == null)) {
        break label172;
      }
      if (paramc.dJX() != null) {
        break label81;
      }
      AppMethodBeat.o(32243);
      return null;
      bool1 = false;
      break;
    }
    label81:
    Object localObject;
    if ((paramc.dJX().dvX()) || (paramc.dJX().dxV()))
    {
      MultiTouchImageView localMultiTouchImageView = paramc.wT(paramMMViewPager.getCurrentItem());
      localObject = localMultiTouchImageView;
      if (localMultiTouchImageView == null) {
        localObject = paramc.wU(paramMMViewPager.getCurrentItem());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(32243);
      return localObject;
      if ((paramc.dJX().byj()) || (paramc.dJX().byk()))
      {
        localObject = paramc.PU(paramMMViewPager.getCurrentItem());
        continue;
        label172:
        ab.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[] { Integer.valueOf(hashCode()) });
      }
      else
      {
        localObject = null;
      }
    }
  }
  
  private static void ap(View paramView, int paramInt)
  {
    AppMethodBeat.i(32233);
    if (paramView != null) {
      paramView.setVisibility(paramInt);
    }
    AppMethodBeat.o(32233);
  }
  
  private boolean aug(String paramString)
  {
    AppMethodBeat.i(32247);
    if (this.zMf == 1)
    {
      AppMethodBeat.o(32247);
      return false;
    }
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32247);
      return false;
    }
    if (!this.zMe)
    {
      AppMethodBeat.o(32247);
      return true;
    }
    String[] arrayOfString = ((String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDp, "")).split("\\|");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!bo.isNullOrNil(str)) && (paramString.startsWith(str)))
        {
          ab.i("MicroMsg.ImageGalleryUI", "curDealQBarStr:%s, blockQrcodeStr:%s", new Object[] { paramString, str });
          AppMethodBeat.o(32247);
          return false;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(32247);
    return true;
  }
  
  private void auh(String paramString)
  {
    AppMethodBeat.i(153891);
    paramString = RecordConfigProvider.fS(paramString, "");
    paramString.scene = this.zMf;
    com.tencent.mm.plugin.recordvideo.jumper.a locala = com.tencent.mm.plugin.recordvideo.jumper.a.qbG;
    com.tencent.mm.plugin.recordvideo.jumper.a.a(getContext(), 4369, paramString, 1, 2);
    AppMethodBeat.o(153891);
  }
  
  private void bdV()
  {
    AppMethodBeat.i(32244);
    if ((this.sYz) || (this.zJI == null))
    {
      ab.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
      AppMethodBeat.o(32244);
      return;
    }
    dKn();
    if (this.zLM)
    {
      finish();
      com.tencent.mm.ui.base.b.jdMethod_if(getContext());
      AppMethodBeat.o(32244);
      return;
    }
    ab.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
    int m = this.nga.getWidth() / 2;
    int k = this.nga.getHeight() / 2;
    this.zJI.dJV();
    Object localObject1;
    int n;
    int i;
    int j;
    label415:
    Object localObject2;
    if (this.zMc)
    {
      localObject1 = new gt();
      ((gt)localObject1).cvH.cpO = this.zJI.Pz(this.nga.getCurrentItem()).field_msgId;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      n = ((gt)localObject1).cvI.col;
      i = ((gt)localObject1).cvI.com;
      m = ((gt)localObject1).cvI.coj;
      k = ((gt)localObject1).cvI.cok;
      this.rOa = this.nga.getWidth();
      this.rOb = this.nga.getHeight();
      j = i;
      if (this.zJI.dJX() != null)
      {
        if ((this.zJI.dJX().byk()) || (this.zJI.dJX().byj())) {
          this.rOb = ((int)(this.rOa / n * i));
        }
        if (!this.zJI.dJX().dvX())
        {
          j = i;
          if (!this.zJI.dJX().dxV()) {}
        }
        else
        {
          localObject1 = (com.tencent.mm.ui.base.g)a(this.zJI, this.nga);
          j = i;
          if (localObject1 != null)
          {
            float f = this.rOa / ((com.tencent.mm.ui.base.g)localObject1).getImageWidth();
            this.rOb = ((int)(((com.tencent.mm.ui.base.g)localObject1).getImageHeight() * f));
            j = i;
            if (this.rOb > this.nga.getHeight())
            {
              j = i;
              if (this.rOb < this.nga.getHeight() * 1.5D)
              {
                if (!this.zMc) {
                  break label828;
                }
                this.rOc = (this.rOb - this.nga.getHeight());
                j = i;
              }
              this.rOb = this.nga.getHeight();
            }
          }
        }
      }
      this.kip.hP(this.zLX, this.zLY);
      this.kip.AuV = this.rOc;
      this.kip.hO(this.rOa, this.rOb);
      this.kip.L(m, k, n, j);
      localObject1 = this.nga;
      localObject2 = a(this.zJI, this.nga);
      if (localObject2 == null) {
        break label846;
      }
      localObject1 = localObject2;
      if (this.rOd != 1.0D)
      {
        this.kip.AuR = (1.0F / this.rOd);
        if (this.rOe == 0)
        {
          localObject1 = localObject2;
          if (this.rOf == 0) {}
        }
        else
        {
          i = (int)(this.nga.getWidth() / 2 * (1.0F - this.rOd));
          j = this.rOe;
          k = (int)(this.nga.getHeight() / 2 + this.rOf - this.rOb / 2 * this.rOd);
          this.kip.hQ(i + j, k);
          localObject1 = localObject2;
        }
      }
      label622:
      this.kip.a((View)localObject1, this.mBi, new ImageGalleryUI.7(this), null);
      AppMethodBeat.o(32244);
    }
    else
    {
      localObject1 = this.zJI.Pz(this.nga.getCurrentItem());
      if (localObject1 == null) {
        break label849;
      }
      localObject2 = new av();
      ((av)localObject2).coh.cmQ = ((bi)localObject1);
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      j = ((av)localObject2).coi.col;
      i = ((av)localObject2).coi.com;
      m = ((av)localObject2).coi.coj;
      k = ((av)localObject2).coi.cok;
    }
    for (;;)
    {
      if ((m == 0) && (k == 0))
      {
        m = this.nga.getWidth() / 2;
        k = this.nga.getHeight() / 2;
        n = j;
        break;
      }
      if (localObject1 != null)
      {
        if (((dd)localObject1).field_isSend == 0) {
          this.zLX = com.tencent.mm.cb.a.fromDPToPix(getContext(), 5);
        }
        if (((dd)localObject1).field_isSend == 1) {
          this.zLY = com.tencent.mm.cb.a.fromDPToPix(getContext(), 5);
        }
      }
      n = j;
      break;
      label828:
      j = this.nga.getHeight() * i / this.rOb;
      break label415;
      label846:
      break label622;
      label849:
      i = 0;
      j = 0;
    }
  }
  
  private void cjh()
  {
    AppMethodBeat.i(32250);
    this.qAO.setRepeatMode(1);
    this.qAO.setRepeatCount(0);
    this.qAO.end();
    AppMethodBeat.o(32250);
  }
  
  private boolean dKA()
  {
    AppMethodBeat.i(32277);
    if ((eT(this.zLR) == 0) && (eT(this.zLS) == 0))
    {
      AppMethodBeat.o(32277);
      return true;
    }
    AppMethodBeat.o(32277);
    return false;
  }
  
  private void dKC()
  {
    AppMethodBeat.i(32279);
    ab.d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
    this.zMB.stopTimer();
    AppMethodBeat.o(32279);
  }
  
  private void dKE()
  {
    AppMethodBeat.i(32287);
    boolean bool = af.hO(this);
    int i = af.fx(this);
    ab.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.oFA), Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((this.oFA) && (bool))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.zLK.getLayoutParams());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, i);
      this.zLK.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(this.zLL.getLayoutParams());
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, 0, localLayoutParams.bottomMargin);
      this.zLL.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(32287);
  }
  
  private void dKF()
  {
    AppMethodBeat.i(32288);
    boolean bool = af.hO(this);
    int i = af.fx(this);
    ab.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.oFA), Boolean.valueOf(bool), Integer.valueOf(i) });
    if ((this.oFA) && (bool))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.zLK.getLayoutParams());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, i, 0);
      this.zLK.setLayoutParams(localLayoutParams);
      localLayoutParams = new RelativeLayout.LayoutParams(this.zLL.getLayoutParams());
      localLayoutParams.addRule(10);
      localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, i, localLayoutParams.bottomMargin);
      this.zLL.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(32288);
  }
  
  private void dKG()
  {
    AppMethodBeat.i(32290);
    bi localbi = this.zJI.dJX();
    String str = e.a(localbi, e.d(localbi));
    ab.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[] { str, Long.valueOf(localbi.field_msgId) });
    auh(str);
    AppMethodBeat.o(32290);
  }
  
  private ImageGalleryUI dKj()
  {
    AppMethodBeat.i(32231);
    if (this.zLO == null) {
      this.zLO = ((RelativeLayout)((ViewStub)findViewById(2131825089)).inflate());
    }
    AppMethodBeat.o(32231);
    return this;
  }
  
  private ImageGalleryUI dKk()
  {
    AppMethodBeat.i(32232);
    if (this.zLP == null)
    {
      this.zLP = ((RelativeLayout)((ViewStub)findViewById(2131825093)).inflate());
      this.zLP.findViewById(2131825097).setOnClickListener(this);
    }
    AppMethodBeat.o(32232);
    return this;
  }
  
  private String dKl()
  {
    AppMethodBeat.i(32240);
    if ((this.chatroomName != null) && (this.chatroomName.length() > 0))
    {
      str = this.chatroomName;
      AppMethodBeat.o(32240);
      return str;
    }
    String str = this.talker;
    AppMethodBeat.o(32240);
    return str;
  }
  
  private String dKm()
  {
    AppMethodBeat.i(32245);
    bi localbi = this.zJI.Pz(this.zMu);
    String str = null;
    if (c.c(localbi))
    {
      com.tencent.mm.at.e locale = this.zJI.f(localbi, true);
      if (locale != null) {
        str = e.a(localbi, locale);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(32245);
      return str;
      if (c.bs(localbi)) {
        str = c.e(localbi);
      }
    }
  }
  
  private void dKn()
  {
    AppMethodBeat.i(32248);
    this.zMj = 0;
    this.qwk.setVisibility(8);
    this.zMm.setVisibility(8);
    this.zMn.setVisibility(8);
    dKp();
    dKB();
    hX(true);
    cjh();
    AppMethodBeat.o(32248);
  }
  
  private void dKo()
  {
    AppMethodBeat.i(32253);
    if ((this.zJI == null) || (this.zLM))
    {
      AppMethodBeat.o(32253);
      return;
    }
    if (!this.zJI.dJW())
    {
      AppMethodBeat.o(32253);
      return;
    }
    if (dKj().zLO == null)
    {
      AppMethodBeat.o(32253);
      return;
    }
    if (h.a.dKg().mCm)
    {
      dKq();
      AppMethodBeat.o(32253);
      return;
    }
    if (this.zHu)
    {
      dKq();
      AppMethodBeat.o(32253);
      return;
    }
    ab.d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(dKr()) });
    if ((this.zMj == 0) || (this.zMj == 2)) {
      dKp();
    }
    dKB();
    AppMethodBeat.o(32253);
  }
  
  private void dKp()
  {
    int j = 0;
    AppMethodBeat.i(32254);
    Object localObject = dKj().zLO;
    int i;
    if (this.zMb)
    {
      i = 0;
      ap((View)localObject, i);
      localObject = null;
      if (this.zJI != null) {
        localObject = this.zJI.dJX();
      }
      i = 1;
      if (this.zLJ != c.b.zKp) {
        i = 0;
      }
      if ((localObject == null) || (!bh.o((bi)localObject))) {
        break label112;
      }
      i = 0;
    }
    label112:
    for (;;)
    {
      localObject = dKk().zLP;
      if (i != 0) {}
      for (i = j;; i = 8)
      {
        ap((View)localObject, i);
        AppMethodBeat.o(32254);
        return;
        i = 8;
        break;
      }
    }
  }
  
  private void dKq()
  {
    AppMethodBeat.i(32255);
    ap(dKj().zLO, 8);
    ap(dKk().zLP, 8);
    AppMethodBeat.o(32255);
  }
  
  private boolean dKr()
  {
    return this.zLJ == c.b.zKq;
  }
  
  private void dKv()
  {
    AppMethodBeat.i(32270);
    if ((dKj().zLO == null) || (this.zMC))
    {
      AppMethodBeat.o(32270);
      return;
    }
    if (this.zLO.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.ImageGalleryUI", "fadeOutEnterGirdBtn: %B", new Object[] { Boolean.valueOf(bool) });
      Animation localAnimation = Qj(300);
      localAnimation.setFillAfter(false);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(153877);
          ImageGalleryUI.N(ImageGalleryUI.this);
          ImageGalleryUI.O(ImageGalleryUI.this);
          AppMethodBeat.o(153877);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      dKj().zLO.startAnimation(localAnimation);
      this.zMC = true;
      AppMethodBeat.o(32270);
      return;
    }
  }
  
  private void dKw()
  {
    AppMethodBeat.i(32271);
    if ((dKj().zLQ == null) || (this.zMD))
    {
      AppMethodBeat.o(32271);
      return;
    }
    dKj().zLQ.startAnimation(Qj(300));
    this.zMD = true;
    AppMethodBeat.o(32271);
  }
  
  private void dKx()
  {
    AppMethodBeat.i(32272);
    if ((dKj().zLO == null) || (!this.zMC) || (dKr()))
    {
      AppMethodBeat.o(32272);
      return;
    }
    if (dKj().zLO.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.ImageGalleryUI", "fadeInEnterGirdBtn: %B %s", new Object[] { Boolean.valueOf(bool), bo.dtY() });
      dKj().zLO.startAnimation(dKz());
      dKk().zLP.startAnimation(dKz());
      this.zMC = false;
      AppMethodBeat.o(32272);
      return;
    }
  }
  
  private void dKy()
  {
    boolean bool = true;
    AppMethodBeat.i(32273);
    if ((dKj().zLQ == null) || (!this.zMD))
    {
      AppMethodBeat.o(32273);
      return;
    }
    if (dKj().zLQ.getVisibility() == 0) {}
    for (;;)
    {
      ab.d("MicroMsg.ImageGalleryUI", "fadeInPositionAtChatRecordBtn: %B", new Object[] { Boolean.valueOf(bool) });
      dKj().zLQ.startAnimation(dKz());
      this.zMD = false;
      AppMethodBeat.o(32273);
      return;
      bool = false;
    }
  }
  
  private static Animation dKz()
  {
    AppMethodBeat.i(32274);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(150L);
    localAlphaAnimation.setFillAfter(true);
    AppMethodBeat.o(32274);
    return localAlphaAnimation;
  }
  
  private static int eT(View paramView)
  {
    AppMethodBeat.i(32234);
    if (paramView != null)
    {
      int i = paramView.getVisibility();
      AppMethodBeat.o(32234);
      return i;
    }
    AppMethodBeat.o(32234);
    return 8;
  }
  
  private static boolean f(bi parambi, com.tencent.mm.at.e parame)
  {
    AppMethodBeat.i(32256);
    if (parame == null)
    {
      AppMethodBeat.o(32256);
      return false;
    }
    try
    {
      if ((c.c(parambi, parame) == 0) && (parame.ahh()))
      {
        boolean bool = parambi.dyc();
        if (!bool)
        {
          AppMethodBeat.o(32256);
          return true;
        }
      }
    }
    catch (NullPointerException parambi)
    {
      ab.e("MicroMsg.ImageGalleryUI", "error:".concat(String.valueOf(parambi)));
      AppMethodBeat.o(32256);
    }
    return false;
  }
  
  private static void ra(boolean paramBoolean)
  {
    AppMethodBeat.i(32261);
    ab.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(32261);
  }
  
  public final void Qg(int paramInt)
  {
    AppMethodBeat.i(32257);
    bG(this.zJI.Pz(paramInt));
    AppMethodBeat.o(32257);
  }
  
  public final void Qi(int paramInt)
  {
    AppMethodBeat.i(32268);
    if (dKi().zLV == null)
    {
      AppMethodBeat.o(32268);
      return;
    }
    dKi().zLV.post(new ImageGalleryUI.17(this, paramInt));
    AppMethodBeat.o(32268);
  }
  
  public final void Qk(int paramInt)
  {
    AppMethodBeat.i(32280);
    hX(true);
    dKu();
    dKh().zLR.setVisibility(0);
    dKh().zLS.setVisibility(8);
    dKh().zLT.setVisibility(0);
    dKh().zLU.setVisibility(8);
    dKv();
    dKw();
    dKh().zLT.setText(paramInt + "%");
    AppMethodBeat.o(32280);
  }
  
  protected final void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(138626);
    if (this.zJI == null)
    {
      AppMethodBeat.o(138626);
      return;
    }
    if (this.zMu < 0)
    {
      AppMethodBeat.o(138626);
      return;
    }
    Object localObject1 = this.zJI.Pz(this.zMu);
    int i = this.zJI.zJP.bB((bi)localObject1);
    if ((i == 5) || (i == 6))
    {
      ab.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
      AppMethodBeat.o(138626);
      return;
    }
    if (this.zJI.bt((bi)localObject1))
    {
      ab.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
      AppMethodBeat.o(138626);
      return;
    }
    if ((c.f((bi)localObject1)) && (j.bH((bi)localObject1) == null))
    {
      ab.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
      AppMethodBeat.o(138626);
      return;
    }
    Object localObject2 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    ((List)localObject2).add(Integer.valueOf(0));
    localArrayList.add(getString(2131302657));
    if (com.tencent.mm.bq.d.ahR("favorite"))
    {
      ((List)localObject2).add(Integer.valueOf(2));
      localArrayList.add(getString(2131302102));
    }
    long l;
    if ((c.c((bi)localObject1)) || (c.bs((bi)localObject1)))
    {
      ((List)localObject2).add(Integer.valueOf(1));
      localArrayList.add(getString(2131302869));
      Object localObject3;
      if ((this.zMi) && (!bo.isNullOrNil(dKm())))
      {
        ((List)localObject2).add(Integer.valueOf(7));
        localArrayList.add(getString(2131298195));
        localObject3 = new m();
        if (this.zMj != 2) {
          break label791;
        }
        l = 1L;
        label336:
        ((m)localObject3).cRG = l;
        ((m)localObject3).cRH = 2L;
        ((m)localObject3).ake();
      }
      if ((c.c((bi)localObject1)) || (c.bq((bi)localObject1)))
      {
        localObject3 = new dr();
        ((dr)localObject3).crt.cpO = ((dd)localObject1).field_msgId;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
        if ((((dr)localObject3).cru.cqS) || (com.tencent.mm.pluginsdk.model.app.g.ag(getContext(), ((bi)localObject1).getType())))
        {
          ((List)localObject2).add(Integer.valueOf(4));
          localArrayList.add(getString(2131298238));
        }
      }
      if (c.c((bi)localObject1))
      {
        if (this.zMf != 1) {
          break label797;
        }
        i = 0;
        label475:
        if (i != 0)
        {
          ((List)localObject2).add(Integer.valueOf(6));
          localArrayList.add(getString(2131298194));
        }
      }
      if ((this.rGz != null) && (aug(this.rGz)))
      {
        ((List)localObject2).add(Integer.valueOf(3));
        if (!com.tencent.mm.plugin.scanner.a.CB(this.igY)) {
          break label802;
        }
        localArrayList.add(getString(2131302336));
      }
      label562:
      if (bh.o((bi)localObject1))
      {
        ((List)localObject2).clear();
        localArrayList.clear();
      }
      if ((this.zMe) || (this.zMf == 1) || (this.zHu) || (this.muT) || (h.a.dKg().mCm)) {
        break label880;
      }
    }
    label791:
    label797:
    label802:
    label880:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        ((List)localObject2).add(Integer.valueOf(5));
        localArrayList.add(getString(2131298193));
      }
      if (this.rGv == null) {
        this.rGv = new com.tencent.mm.ui.widget.b.d(getContext(), 1, false);
      }
      this.rGv.sao = new ImageGalleryUI.8(this, (List)localObject2, localArrayList);
      if (((List)localObject2).size() != 0) {
        break label885;
      }
      AppMethodBeat.o(138626);
      return;
      if ((c.f((bi)localObject1)) || (c.bq((bi)localObject1)))
      {
        ((List)localObject2).add(Integer.valueOf(1));
        localArrayList.add(getString(2131302872));
        break;
      }
      ((List)localObject2).add(Integer.valueOf(1));
      localArrayList.add(getString(2131302871));
      break;
      l = 0L;
      break label336;
      i = 1;
      break label475;
      if (com.tencent.mm.plugin.scanner.a.ba(this.igY, this.rGz))
      {
        localArrayList.add(getString(2131302341));
        break label562;
      }
      if (com.tencent.mm.plugin.scanner.a.CA(this.igY))
      {
        localArrayList.add(getString(2131302335));
        break label562;
      }
      localArrayList.add(getString(2131302336));
      break label562;
    }
    label885:
    this.rGv.sap = this.loG;
    this.rGv.AGQ = new ImageGalleryUI.9(this);
    this.rGv.crd();
    localObject1 = dKm();
    if (!bo.isNullOrNil((String)localObject1))
    {
      if ((paramBoolean1) && (aw.Rc().adt() != 0))
      {
        localObject2 = new nw();
        ((nw)localObject2).cEv.filePath = ((String)localObject1);
        this.rGw = ((String)localObject1);
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
      }
      if (paramBoolean2)
      {
        if (this.zMg == null) {
          this.zMg = new ImageWordScanEngineImpl(this);
        }
        this.zMg.a(localObject1, this);
      }
    }
    AppMethodBeat.o(138626);
  }
  
  public final void bG(bi parambi)
  {
    int j = 0;
    label122:
    int i;
    com.tencent.mm.at.e locale;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(32262);
        this.zLJ = c.bu(parambi);
        ab.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.zLJ);
        if ((h.a.dKg().mCm) && (this.zMq != null)) {
          this.zMq.setChecked(h.a.dKg().bF(parambi));
        }
        switch (ImageGalleryUI.20.zJZ[this.zLJ.ordinal()])
        {
        case 1: 
          AppMethodBeat.o(32262);
          return;
        }
      }
      finally {}
      dKu();
      ap(this.zLR, 8);
      rb(true);
      parambi = j.bH(parambi);
      if (parambi == null)
      {
        AppMethodBeat.o(32262);
      }
      else
      {
        dKi().zLW.setVideoTotalTime(parambi.fXx);
        i = j;
        try
        {
          if (this.zJI.dJY() != null)
          {
            i = j;
            if (this.zJI.dJY().zNt != null) {
              i = this.zJI.dJY().zNt.getCurrentPosition() / 1000;
            }
          }
        }
        catch (Exception parambi)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.ImageGalleryUI", parambi, "", new Object[0]);
            i = j;
          }
        }
        dKi().zLW.seek(i);
        AppMethodBeat.o(32262);
        continue;
        locale = this.zJI.f(parambi, false);
        dKu();
        dKo();
        if (locale != null) {
          break;
        }
        ab.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
        AppMethodBeat.o(32262);
      }
    }
    this.nga.getCurrentItem();
    Object localObject2;
    if ((f(parambi, locale)) && (!parambi.dyc()) && (locale.ahg()))
    {
      dKh().zLS.setVisibility(0);
      dKh().zLT.setVisibility(8);
      dKh().zLU.setVisibility(8);
      String str = (String)this.zMy.get(Long.valueOf(locale.fDL));
      localObject2 = str;
      if (str == null)
      {
        localObject2 = br.F(locale.fDX, "msg");
        if (localObject2 != null) {
          break label588;
        }
        ab.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[] { locale.fDX });
        i = -1;
        break label908;
      }
    }
    for (;;)
    {
      label452:
      this.zMy.put(Long.valueOf(locale.fDL), localObject2);
      dKh().zLS.setText(getString(2131298893, new Object[] { localObject2 }));
      ap(this.zLR, 0);
      label504:
      if ((this.zLZ) && (locale.ahg()) && (this.zJI.dJX() != null) && (parambi.field_msgId == this.zJI.dJX().field_msgId))
      {
        ab.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[] { Long.valueOf(parambi.field_msgId) });
        dKG();
        this.zLZ = false;
        AppMethodBeat.o(32262);
        break label122;
        j = bo.getInt((String)((Map)localObject2).get(".msg.img.$hdlength"), 0);
        i = j;
        if (j != 0) {
          break label908;
        }
        i = bo.getInt((String)((Map)localObject2).get(".msg.img.$tphdlength"), 0);
        break label908;
      }
      label588:
      long l;
      label908:
      do
      {
        Object localObject1;
        localObject2 = new BigDecimal(localObject1);
        float f = ((BigDecimal)localObject2).divide(new BigDecimal(1048576), 2, 0).floatValue();
        if (f > 1.0F)
        {
          localObject2 = (int)f + "M";
          break label452;
        }
        f = ((BigDecimal)localObject2).divide(new BigDecimal(1024), 2, 0).floatValue();
        localObject2 = (int)f + "K";
        break label452;
        ap(this.zLR, 8);
        break label504;
        localObject2 = this.zJI.dJX();
        boolean bool = this.zLZ;
        l = parambi.field_msgId;
        if (localObject2 == null) {}
        for (parambi = "null";; parambi = Long.valueOf(((dd)localObject2).field_msgId))
        {
          ab.w("MicroMsg.ImageGalleryUI", "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l), parambi, Boolean.valueOf(locale.ahg()) });
          AppMethodBeat.o(32262);
          break;
        }
        dKu();
        dKo();
        AppMethodBeat.o(32262);
        break label122;
        dKu();
        dKo();
        ap(this.zLR, 8);
        this.zJI.PZ(this.nga.getCurrentItem());
        break;
        break;
        l = i;
      } while (l >= 0L);
      localObject2 = "";
    }
  }
  
  public final boolean cKj()
  {
    AppMethodBeat.i(32267);
    boolean bool = dKi().zLW.bwz();
    AppMethodBeat.o(32267);
    return bool;
  }
  
  protected final void dKB()
  {
    AppMethodBeat.i(32278);
    if ((dKA()) || (this.zJI == null))
    {
      AppMethodBeat.o(32278);
      return;
    }
    ab.d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
    this.zMB.ag(4000L, 4000L);
    AppMethodBeat.o(32278);
  }
  
  public final void dKD()
  {
    AppMethodBeat.i(32281);
    hX(true);
    dKu();
    dKh().zLR.setVisibility(0);
    dKh().zLS.setVisibility(8);
    dKh().zLT.setVisibility(0);
    dKh().zLU.setVisibility(8);
    dKv();
    dKw();
    dKh().zLT.setText("0%");
    AppMethodBeat.o(32281);
  }
  
  final ImageGalleryUI dKh()
  {
    AppMethodBeat.i(32229);
    if (this.zLR == null)
    {
      this.zLR = ((ViewStub)findViewById(2131825092)).inflate();
      this.zLS = ((Button)this.zLR.findViewById(2131823287));
      this.zLT = ((Button)this.zLR.findViewById(2131825099));
      this.zLU = this.zLR.findViewById(2131825100);
    }
    AppMethodBeat.o(32229);
    return this;
  }
  
  protected final ImageGalleryUI dKi()
  {
    AppMethodBeat.i(32230);
    if (this.zLV == null)
    {
      this.zLV = ((ViewStub)findViewById(2131822973)).inflate();
      this.zLW = ((VideoPlayerSeekBar)findViewById(2131822974));
      this.zLW.setPlayBtnOnClickListener(this);
    }
    AppMethodBeat.o(32230);
    return this;
  }
  
  protected final void dKs()
  {
    AppMethodBeat.i(32258);
    if (this.zMw) {
      this.zMx.ag(4000L, 4000L);
    }
    AppMethodBeat.o(32258);
  }
  
  public final void dKt()
  {
    AppMethodBeat.i(32259);
    ab.i("MicroMsg.ImageGalleryUI", "show video tool bar");
    hX(true);
    ra(true);
    ap(this.zLR, 8);
    ap(dKi().zLV, 0);
    ap(this.zLN, 0);
    dKj().zLO.clearAnimation();
    if (this.zLM) {
      dKq();
    }
    for (;;)
    {
      dKC();
      this.zMw = true;
      dKs();
      AppMethodBeat.o(32259);
      return;
      if ((this.zMj == 0) || (this.zMj == 2)) {
        dKp();
      }
    }
  }
  
  public final void dKu()
  {
    AppMethodBeat.i(32260);
    ab.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
    ra(false);
    ap(dKi().zLV, 8);
    ap(this.zLN, 8);
    if (dKr())
    {
      dKC();
      dKq();
    }
    this.zMw = false;
    AppMethodBeat.o(32260);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32269);
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      if (this.rGv != null)
      {
        this.rGv.cre();
        this.rGv = null;
      }
      for (;;)
      {
        AppMethodBeat.o(32269);
        return true;
        if ((this.zMj == 0) || (this.zMj == 2)) {
          al(true, com.tencent.mm.plugin.scanner.d.chW());
        } else {
          al(true, false);
        }
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(32269);
    return bool;
  }
  
  public void finish()
  {
    AppMethodBeat.i(32283);
    this.zFa.clear();
    super.finish();
    AppMethodBeat.o(32283);
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(156909);
    int i = this.nga.getCurrentItem();
    AppMethodBeat.o(156909);
    return i;
  }
  
  public int getForceOrientation()
  {
    return 2;
  }
  
  public int getLayoutId()
  {
    return 2130969883;
  }
  
  public final void hX(boolean paramBoolean)
  {
    int i = 8;
    AppMethodBeat.i(32251);
    if (this.zLK == null)
    {
      AppMethodBeat.o(32251);
      return;
    }
    if (((paramBoolean) && (this.zLK.getVisibility() == 0)) || ((!paramBoolean) && (this.zLK.getVisibility() == 8)))
    {
      AppMethodBeat.o(32251);
      return;
    }
    Object localObject = this.zLK;
    if (paramBoolean) {
      i = 0;
    }
    ((RelativeLayout)localObject).setVisibility(i);
    localObject = getContext();
    if (paramBoolean) {}
    for (i = 2131034125;; i = 2131034126)
    {
      localObject = AnimationUtils.loadAnimation((Context)localObject, i);
      this.zLK.startAnimation((Animation)localObject);
      AppMethodBeat.o(32251);
      return;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(32241);
    this.kip = new com.tencent.mm.ui.tools.e(getContext());
    this.zMB = new ap(this, false);
    this.isAnimated = false;
    this.talker = getIntent().getStringExtra("img_gallery_talker");
    this.zMc = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
    this.zHv = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
    this.zMe = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
    this.zHu = getIntent().getBooleanExtra("show_search_chat_content_result", false);
    this.zMb = getIntent().getBooleanExtra("show_enter_grid", true);
    this.muT = getIntent().getBooleanExtra("key_is_biz_chat", false);
    this.jUy = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.zLM = getIntent().getBooleanExtra("img_preview_only", false);
    this.zMf = getIntent().getIntExtra("img_gallery_enter_from_scene", 0);
    if ((!this.zLM) && (bo.isNullOrNil(this.talker))) {
      ab.e("MicroMsg.ImageGalleryUI", " initView, talker is null. intent: " + getIntent());
    }
    this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
    this.zMd = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    this.zMk = getIntent().getStringExtra("img_gallery_enter_video_opcode");
    boolean bool2 = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
    Object localObject1 = getIntent().getStringExtra("img_gallery_directly_send_name");
    this.zMm = ((ImageView)findViewById(2131825085));
    this.zMn = ((ImageView)findViewById(2131825087));
    Object localObject2 = (FrameLayout.LayoutParams)this.zMn.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).bottomMargin += af.fx(this);
    this.zMn.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.zMn.setOnClickListener(new ImageGalleryUI.23(this));
    this.qwk = ((ImageView)findViewById(2131825086));
    this.qAO = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qAO.setDuration(5000L);
    this.qAO.addListener(new ImageGalleryUI.3(this));
    final int i = getWindowManager().getDefaultDisplay().getHeight();
    this.qAO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(153855);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f <= 0.1F) {
          ImageGalleryUI.p(ImageGalleryUI.this).setAlpha(f * 10.0F);
        }
        for (;;)
        {
          ImageGalleryUI.p(ImageGalleryUI.this).setTranslationY(f * (i - ImageGalleryUI.p(ImageGalleryUI.this).getHeight()));
          AppMethodBeat.o(153855);
          return;
          if (f >= 0.9F) {
            ImageGalleryUI.p(ImageGalleryUI.this).setAlpha((1.0F - f) * 10.0F);
          }
        }
      }
    });
    this.cpO = getIntent().getLongExtra("img_gallery_msg_id", 0L);
    long l = getIntent().getLongExtra("img_gallery_msg_svr_id", 0L);
    if ((this.cpO <= 0L) && (l == 0L))
    {
      ab.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.cpO + ", msgSvrId = " + l + ", stack = " + bo.dtY());
      finish();
      AppMethodBeat.o(32241);
      return;
    }
    if (this.cpO == 0L)
    {
      aw.aaz();
      this.cpO = com.tencent.mm.model.c.YC().ag(dKl(), l).field_msgId;
    }
    aw.aaz();
    localObject2 = com.tencent.mm.model.c.YC().kB(this.cpO);
    if (((dd)localObject2).field_msgId <= 0L)
    {
      ab.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.cpO + ", msgSvrId = " + l + ", stack = " + bo.dtY());
      finish();
      AppMethodBeat.o(32241);
      return;
    }
    boolean bool1;
    if (oM(this.cpO) == 3)
    {
      bool1 = true;
      this.zMl = bool1;
      this.zJI = new c(this, this.cpO, dKl(), this.muT, this.jUy, bool2, (String)localObject1, Boolean.valueOf(this.zMd));
      this.zJI.zJT = false;
      this.zJI.zJN = getIntent().getBooleanExtra("start_chatting_ui", true);
      this.zJI.zJS = new ImageGalleryUI.24(this);
      this.zLK = ((RelativeLayout)findViewById(2131823286));
      this.zLL = ((RelativeLayout)findViewById(2131825088));
      int j = this.zLL.getPaddingTop();
      i = j;
      if (af.hW(getContext())) {
        i = j + af.hV(getContext());
      }
      this.zLL.setPadding(0, i, 0, 0);
      this.zLN = ((ImageView)findViewById(2131825090));
      this.zLN.setOnClickListener(this);
      localObject1 = getWindowManager().getDefaultDisplay();
      j = ((Display)localObject1).getWidth();
      int k = ((Display)localObject1).getHeight();
      if (j >= k) {
        break label1313;
      }
      i = 1;
      label915:
      ab.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      if (i != 0) {
        break label1318;
      }
      i = 0;
      label965:
      if (i == 0) {
        break label1323;
      }
      dKE();
      label973:
      this.mBi = ((ImageView)findViewById(2131822135));
      this.mBi.setLayerType(2, null);
      this.nga = ((MMViewPager)findViewById(2131822137));
      this.nga.setLayerType(2, null);
      this.nga.setVerticalFadingEdgeEnabled(false);
      this.nga.setHorizontalFadingEdgeEnabled(false);
      this.nga.setSingleClickOverListener(new ImageGalleryUI.25(this));
      if (!this.zLM)
      {
        this.nga.setOnPageChangeListener(this.zMv);
        this.nga.setLongClickOverListener(new ImageGalleryUI.26(this));
      }
      this.nga.setOffscreenPageLimit(1);
      this.nga.setAdapter(this.zJI);
      Qg(100000);
      this.nga.setCurrentItem(100000);
      this.nga.postDelayed(new ImageGalleryUI.27(this), 0L);
      if (h.a.dKg().mCm)
      {
        this.zMp = ((ViewStub)findViewById(2131825084)).inflate();
        this.zMp.setVisibility(0);
        this.zMq = ((CheckBox)this.zMp.findViewById(2131824025));
        this.zMr = this.zMp.findViewById(2131824026);
      }
      this.zLZ = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
      localObject1 = this.zJI.f((bi)localObject2, true);
      if (localObject1 == null) {
        ab.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[] { Boolean.valueOf(this.zLZ) });
      }
      if ((!this.zLZ) || (localObject1 == null) || (!((com.tencent.mm.at.e)localObject1).ahg())) {
        break label1330;
      }
      dKG();
      this.zLZ = false;
    }
    for (;;)
    {
      this.nga.setOnTouchListener(new ImageGalleryUI.2(this));
      AppMethodBeat.o(32241);
      return;
      bool1 = false;
      break;
      label1313:
      i = 0;
      break label915;
      label1318:
      i = 1;
      break label965;
      label1323:
      dKF();
      break label973;
      label1330:
      if (this.zLZ) {
        ab.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
      }
    }
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public final int oM(long paramLong)
  {
    AppMethodBeat.i(32284);
    if (bo.isNullOrNil(this.zMk))
    {
      AppMethodBeat.o(32284);
      return 0;
    }
    try
    {
      int j = u.f(paramLong, this.zMk);
      int i = j;
      if (j == -1)
      {
        this.zMk = null;
        i = 0;
      }
      ab.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[] { Integer.valueOf(i), this.zMk });
      AppMethodBeat.o(32284);
      return i;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + localException.toString());
      AppMethodBeat.o(32284);
    }
    return 0;
  }
  
  public final void oN(long paramLong)
  {
    AppMethodBeat.i(32285);
    if ((bo.isNullOrNil(this.zMk)) || (paramLong == 0L))
    {
      AppMethodBeat.o(32285);
      return;
    }
    if (this.zMl)
    {
      this.zMk = u.e(paramLong, 3);
      ab.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.zMk });
      AppMethodBeat.o(32285);
      return;
    }
    if (u.f(paramLong, this.zMk) == -1)
    {
      this.zMk = null;
      ab.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[] { this.zMk });
    }
    AppMethodBeat.o(32285);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(32239);
    ab.i("MicroMsg.ImageGalleryUI", "onBackPressed");
    if (this.zMc)
    {
      Qh(1);
      AppMethodBeat.o(32239);
      return;
    }
    try
    {
      h.a.dKg().detach();
      bdV();
      AppMethodBeat.o(32239);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ImageGalleryUI", localException.getMessage());
      finish();
      AppMethodBeat.o(32239);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    AppMethodBeat.i(32265);
    if (this.zJI == null)
    {
      AppMethodBeat.o(32265);
      return;
    }
    if (paramView.getId() == 2131825089)
    {
      Qh(0);
      AppMethodBeat.o(32265);
      return;
    }
    if (paramView.getId() == 2131825097)
    {
      ab.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[] { Integer.valueOf(this.nga.getCurrentItem()) });
      ap(dKk().zLP, 8);
      paramView = this.zJI.Pz(this.nga.getCurrentItem());
      com.tencent.mm.at.e locale = this.zJI.f(paramView, false);
      this.nga.getCurrentItem();
      if ((f(paramView, locale)) && (!paramView.dyc()) && (locale.ahg()))
      {
        this.zJI.aI(this.nga.getCurrentItem(), true);
        AppMethodBeat.o(32265);
        return;
      }
      c.b(getContext(), this.zJI.dJX(), true);
      AppMethodBeat.o(32265);
      return;
    }
    if (paramView.getId() == 2131823287)
    {
      this.zMj = 2;
      this.zMh = 0;
      this.zJI.aI(this.nga.getCurrentItem(), false);
      AppMethodBeat.o(32265);
      return;
    }
    if (paramView.getId() == 2131825099)
    {
      this.zJI.PY(this.nga.getCurrentItem());
      Qg(this.nga.getCurrentItem());
      dKx();
      dKy();
      dKB();
      AppMethodBeat.o(32265);
      return;
    }
    if (paramView.getId() == 2131820988)
    {
      onBackPressed();
      AppMethodBeat.o(32265);
      return;
    }
    if (paramView.getId() == 2131825090)
    {
      onBackPressed();
      AppMethodBeat.o(32265);
      return;
    }
    if (paramView.getId() == 2131824026)
    {
      boolean bool2 = this.zMq.isChecked();
      if ((!bool2) && (h.a.dKg().mCl.size() >= 9))
      {
        Toast.makeText(this, getResources().getString(2131300308, new Object[] { Integer.valueOf(9) }), 1).show();
        AppMethodBeat.o(32265);
        return;
      }
      paramView = this.zMq;
      if (!bool2) {}
      for (;;)
      {
        paramView.setChecked(bool1);
        if (!this.zMq.isChecked()) {
          break;
        }
        h.a.dKg().bD(this.zJI.dJX());
        AppMethodBeat.o(32265);
        return;
        bool1 = false;
      }
      h.a.dKg().bE(this.zJI.dJX());
      AppMethodBeat.o(32265);
      return;
    }
    if (paramView.getId() == 2131821295) {
      this.zJI.PV(this.nga.getCurrentItem());
    }
    AppMethodBeat.o(32265);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(32286);
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 1)
    {
      ab.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[] { Integer.valueOf(hashCode()) });
      dKE();
      AppMethodBeat.o(32286);
      return;
    }
    if (paramConfiguration.orientation == 2)
    {
      ab.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[] { Integer.valueOf(hashCode()) });
      dKF();
      AppMethodBeat.o(32286);
      return;
    }
    AppMethodBeat.o(32286);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(32235);
    requestWindowFeature(1);
    long l = System.currentTimeMillis();
    this.zMs = true;
    super.onCreate(paramBundle);
    if (com.tencent.mm.compatible.util.d.fv(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (this.oFA = true;; this.oFA = false)
    {
      setLightNavigationbarIcon();
      initView();
      this.kuF = paramBundle;
      com.tencent.mm.sdk.b.a.ymk.c(this.mwt);
      com.tencent.mm.sdk.b.a.ymk.c(this.rGI);
      com.tencent.mm.sdk.b.a.ymk.c(this.zMt);
      this.sYz = false;
      ab.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(32235);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(32252);
    super.onCreateBeforeSetContentView();
    AppMethodBeat.o(32252);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(32238);
    ab.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[] { Integer.valueOf(hashCode()) });
    try
    {
      if (this.zJI != null)
      {
        this.zJI.detach();
        this.zJI = null;
      }
      dKC();
      this.zMx.stopTimer();
      cjh();
      this.qAO.removeAllUpdateListeners();
      com.tencent.mm.sdk.b.a.ymk.d(this.mwt);
      com.tencent.mm.sdk.b.a.ymk.d(this.rGI);
      com.tencent.mm.sdk.b.a.ymk.d(this.zMt);
      com.tencent.mm.kernel.g.RK().b(this.qAV);
      if (this.zLW != null) {
        this.zLW.setPlayBtnOnClickListener(null);
      }
      this.zLW = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ImageGalleryUI", localException, "", new Object[0]);
      }
    }
    if (com.tencent.mm.graphics.b.c.eAP.eAT) {
      com.tencent.mm.graphics.b.c.eAP.stop();
    }
    super.onDestroy();
    AppMethodBeat.o(32238);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(32282);
    if (paramInt == 82)
    {
      AppMethodBeat.o(32282);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(32282);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(32228);
    ab.i("MicroMsg.ImageGalleryUI", "on pause");
    super.onPause();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    Object localObject;
    if ((!isFinishing()) && (this.zJI != null))
    {
      localObject = this.zJI;
      ((c)localObject).zJQ.zMX.sendEmptyMessageDelayed(1, 200L);
      ((c)localObject).zJR.Dm();
    }
    if (this.rGz != null)
    {
      localObject = new an();
      ((an)localObject).cnQ.activity = this;
      ((an)localObject).cnQ.cnR = this.rGz;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      this.rGz = null;
      this.igZ = 0;
      this.igY = 0;
    }
    o.La(2);
    AppMethodBeat.o(32228);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(32236);
    super.onResume();
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    if ((!this.zMs) && (this.zJI != null)) {
      Qg(this.nga.getCurrentItem());
    }
    this.zMs = false;
    if (this.zJI != null) {
      this.zJI.dJZ();
    }
    com.tencent.mm.kernel.g.RK().a(this.qAV);
    o.La(1);
    AppMethodBeat.o(32236);
  }
  
  public void onStart()
  {
    boolean bool = true;
    AppMethodBeat.i(32237);
    this.zMd = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
    Bundle localBundle;
    if (!this.zLM)
    {
      localBundle = this.kuF;
      ab.i("MicroMsg.ImageGalleryUI", "[handleAnimation] isAnimated:" + this.isAnimated);
      if (!this.isAnimated)
      {
        this.isAnimated = true;
        if (Build.VERSION.SDK_INT >= 12)
        {
          this.kuG = getIntent().getIntExtra("img_gallery_top", 0);
          this.kuH = getIntent().getIntExtra("img_gallery_left", 0);
          this.kuI = getIntent().getIntExtra("img_gallery_width", 0);
          this.kuJ = getIntent().getIntExtra("img_gallery_height", 0);
          if ((this.kuG == 0) && (this.kuH == 0) && (this.kuI == 0) && (this.kuJ == 0))
          {
            bi localbi = this.zJI.Pz(this.nga.getCurrentItem());
            if (localbi != null)
            {
              av localav = new av();
              localav.coh.cmQ = localbi;
              com.tencent.mm.sdk.b.a.ymk.l(localav);
              this.kuI = localav.coi.col;
              this.kuJ = localav.coi.com;
              this.kuH = localav.coi.coj;
              this.kuG = localav.coi.cok;
            }
          }
          this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
          if (localBundle != null) {
            break label343;
          }
        }
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.ImageGalleryUI", "[handleAnimation] savedInstanceState is null?%s", new Object[] { Boolean.valueOf(bool) });
      if (localBundle == null) {
        this.nga.getViewTreeObserver().addOnPreDrawListener(new ImageGalleryUI.5(this));
      }
      super.onStart();
      AppMethodBeat.o(32237);
      return;
      label343:
      bool = false;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(156340);
    super.onStop();
    com.tencent.mm.graphics.b.d.eAV.Py();
    if (com.tencent.mm.graphics.b.c.eAP.eAT) {
      com.tencent.mm.graphics.b.c.eAP.stop();
    }
    AppMethodBeat.o(156340);
  }
  
  public boolean onTimerExpired()
  {
    AppMethodBeat.i(32276);
    dKv();
    dKw();
    AppMethodBeat.o(32276);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rb(boolean paramBoolean)
  {
    AppMethodBeat.i(32266);
    try
    {
      VideoPlayerSeekBar localVideoPlayerSeekBar = dKi().zLW;
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localVideoPlayerSeekBar.setIsPlay(paramBoolean);
        AppMethodBeat.o(32266);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + localException.toString());
      AppMethodBeat.o(32266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI
 * JD-Core Version:    0.7.0.1
 */