package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.a.hu.b;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.e.a;
import com.tencent.mm.ui.tools.e.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class SnsBrowseUI
  extends SnsBaseGalleryUI
  implements u.a
{
  private String dgl;
  private int diQ;
  private ImageView iBF;
  private boolean isAnimated;
  private int kWB;
  private int kWC;
  private ao mHandler;
  Bundle ocU;
  com.tencent.mm.ui.tools.e ocV;
  private int scene;
  private Rect xgY;
  private int yIJ;
  private boolean yIK;
  private boolean yIL;
  private boolean yIM;
  private com.tencent.mm.pluginsdk.model.u yIN;
  private int yIO;
  private int yIP;
  private int yIQ;
  private float yIR;
  private int yIS;
  private int yIT;
  
  public SnsBrowseUI()
  {
    AppMethodBeat.i(98508);
    this.yIJ = 0;
    this.diQ = 0;
    this.yIK = false;
    this.yIL = false;
    this.yIM = false;
    this.isAnimated = false;
    this.kWB = 0;
    this.kWC = 0;
    this.mHandler = new ao();
    this.yIQ = 0;
    this.scene = 0;
    this.yIR = 1.0F;
    this.yIS = 0;
    this.yIT = 0;
    AppMethodBeat.o(98508);
  }
  
  public final void bSg()
  {
    AppMethodBeat.i(98516);
    if (this.xgY == null) {
      this.xgY = new Rect();
    }
    if (!this.yIL)
    {
      localObject = new hu();
      ((hu)localObject).diO.diR = this.yIC.getGallery().getCurrentItem();
      ((hu)localObject).diO.diQ = this.diQ;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      this.xgY.left = ((hu)localObject).diP.daF;
      this.xgY.top = ((hu)localObject).diP.daG;
      this.xgY.right = (((hu)localObject).diP.daH + this.xgY.left);
      this.xgY.bottom = (((hu)localObject).diP.daI + this.xgY.top);
    }
    this.yIO = this.yIC.getWidth();
    this.yIP = this.yIC.getHeight();
    af.dHO();
    Object localObject = com.tencent.mm.plugin.sns.model.f.C(this.yIC.getCntMedia());
    int i;
    if (localObject != null)
    {
      localObject = com.tencent.mm.sdk.platformtools.f.aKw((String)localObject);
      float f = this.yIO / ((BitmapFactory.Options)localObject).outWidth;
      this.yIP = ((int)(((BitmapFactory.Options)localObject).outHeight * f));
      if (this.yIP > this.yIC.getHeight())
      {
        if (this.yIP < this.yIC.getHeight() * 2.5D)
        {
          this.yIQ = (this.yIP - this.yIC.getHeight());
          if (this.yIC.getCount() == 1)
          {
            i = this.yIC.getHeight() * this.xgY.height() / this.yIP;
            this.xgY.bottom = (i + this.xgY.top);
            this.yIQ = 0;
          }
        }
        this.yIP = this.yIC.getHeight();
      }
    }
    this.ocV.jN(this.yIO, this.yIP);
    this.ocV.R(this.xgY.left, this.xgY.top, this.xgY.width(), this.xgY.height());
    if (this.yIR != 1.0D)
    {
      this.ocV.IRh = (1.0F / this.yIR);
      if ((this.yIS != 0) || (this.yIT != 0))
      {
        i = (int)(this.yIC.getWidth() / 2 * (1.0F - this.yIR));
        int j = this.yIS;
        int k = (int)(this.yIC.getHeight() / 2 + this.yIT - this.yIP / 2 * this.yIR);
        this.ocV.jP(i + j, k);
      }
    }
    this.ocV.IRl = this.yIQ;
    this.ocV.a(this.yIC, this.iBF, new e.c()new e.a
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(98504);
        SnsBrowseUI.e(SnsBrowseUI.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98502);
            SnsBrowseUI.this.finish();
            SnsBrowseUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.o(98502);
          }
        });
        AppMethodBeat.o(98504);
      }
      
      public final void onAnimationStart()
      {
        AppMethodBeat.i(98503);
        SnsInfoFlip localSnsInfoFlip = SnsBrowseUI.this.yIC;
        if (localSnsInfoFlip.yMo != null) {
          localSnsInfoFlip.yMo.setVisibility(8);
        }
        SnsBrowseUI.e(SnsBrowseUI.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98501);
            Object localObject = SnsBrowseUI.this.yIC;
            if (((SnsInfoFlip)localObject).sRJ != null)
            {
              localObject = ((SnsInfoFlip)localObject).sRJ.getSelectedView();
              if ((localObject instanceof g)) {
                ((g)localObject).fij();
              }
            }
            AppMethodBeat.o(98501);
          }
        }, 20L);
        AppMethodBeat.o(98503);
      }
    }, new e.a()
    {
      public final void K(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(98505);
        if ((SnsBrowseUI.this.yIC.getGallery() != null) && (Build.VERSION.SDK_INT >= 18)) {
          SnsBrowseUI.this.yIC.getGallery().setClipBounds(new Rect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
        }
        AppMethodBeat.o(98505);
      }
    });
    AppMethodBeat.o(98516);
  }
  
  public final void dNx() {}
  
  protected final boolean dPi()
  {
    return true;
  }
  
  protected final int dPj()
  {
    return 3;
  }
  
  public final void dPq()
  {
    AppMethodBeat.i(98517);
    final MMViewPager localMMViewPager = this.yIC.getGallery();
    localMMViewPager.setGalleryScaleListener(new MMViewPager.b()
    {
      public final void M(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        AppMethodBeat.i(98506);
        if (((SnsBrowseUI.f(SnsBrowseUI.this) == 0) || (SnsBrowseUI.g(SnsBrowseUI.this) == 0)) && (SnsBrowseUI.this.yIC != null))
        {
          SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.yIC.getHeight());
          SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.yIC.getWidth());
        }
        float f2;
        if (SnsBrowseUI.f(SnsBrowseUI.this) != 0)
        {
          f2 = 1.0F - paramAnonymousFloat2 / SnsBrowseUI.f(SnsBrowseUI.this);
          if (f2 <= 1.0F) {
            break label193;
          }
        }
        for (;;)
        {
          SnsBrowseUI.a(SnsBrowseUI.this, f1);
          View localView = localMMViewPager.getSelectedView();
          localView.setPivotX(SnsBrowseUI.g(SnsBrowseUI.this) / 2);
          localView.setPivotY(SnsBrowseUI.f(SnsBrowseUI.this) / 2);
          localView.setScaleX(f1);
          localView.setScaleY(f1);
          localView.setTranslationX(paramAnonymousFloat1);
          localView.setTranslationY(paramAnonymousFloat2);
          SnsBrowseUI.d(SnsBrowseUI.this).setAlpha(f1);
          AppMethodBeat.o(98506);
          return;
          label193:
          f1 = f2;
        }
      }
      
      public final void ac(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(98507);
        SnsBrowseUI.e(SnsBrowseUI.this, (int)paramAnonymousFloat1);
        SnsBrowseUI.f(SnsBrowseUI.this, (int)paramAnonymousFloat2);
        AppMethodBeat.o(98507);
      }
    });
    AppMethodBeat.o(98517);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98514);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      bSg();
      AppMethodBeat.o(98514);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98514);
    return bool;
  }
  
  public final void eI(String paramString, int paramInt)
  {
    AppMethodBeat.i(98518);
    ac.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE, paramString });
    if (this.yIC != null) {
      this.yIC.rn(true);
    }
    AppMethodBeat.o(98518);
  }
  
  public final void eJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(98520);
    this.yIJ = paramInt;
    if (this.scene == 2)
    {
      paramString = com.tencent.mm.plugin.sns.storage.h.auT(paramString);
      com.tencent.mm.plugin.sns.j.f.ydE.c(paramString, paramInt);
      com.tencent.mm.plugin.sns.j.f.ydE.d(paramString, paramInt);
    }
    AppMethodBeat.o(98520);
  }
  
  public int getLayoutId()
  {
    return 2131495531;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98515);
    this.ocV = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    Object localObject1 = bs.bG(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.dgl = bs.bG(getIntent().getStringExtra("sns_gallery_localId"), "");
    this.yIJ = getIntent().getIntExtra("sns_gallery_position", 0);
    this.diQ = getIntent().getIntExtra("sns_position", 0);
    this.yIK = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
    this.yIL = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
    this.yIM = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
    this.scene = getIntent().getIntExtra("K_source", 0);
    p localp = af.dHR().auT(this.dgl);
    this.iBF = ((ImageView)findViewById(2131300336));
    this.yIC = new SnsInfoFlip(this);
    this.yIC.setIsFromMainTimeline(this.yIK);
    this.yIC.setNeedScanImage(true);
    Object localObject2 = aj.atU(this.dgl);
    this.yIC.setShowPageControl(true);
    this.yIC.setTouchFinish(true);
    this.yIC.setIsSoonEnterPhotoEditUI(this.yIM);
    this.yIC.a((List)localObject2, (String)localObject1, this.yIJ, this.yIx, this);
    localObject1 = this.yIC;
    localObject2 = com.tencent.mm.storage.bf.fbk();
    ((com.tencent.mm.storage.bf)localObject2).gIh = localp.field_createTime;
    ((SnsInfoFlip)localObject1).setFromScene((com.tencent.mm.storage.bf)localObject2);
    this.yIC.setOnPageSelectListener(this);
    addView(this.yIC);
    if ((localp != null) && (localp.Pe(32))) {
      this.yIC.setIsAd(true);
    }
    this.yID = ((Button)findViewById(2131300511));
    int i = ap.ej(this);
    localObject1 = (ViewGroup.MarginLayoutParams)this.yID.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (i + getResources().getDimensionPixelSize(2131166829));
    this.yID.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject2 = localp.dLV();
    if (localObject2 != null)
    {
      localObject1 = ((TimeLineObject)localObject2).xXR;
      bf localbf = new bf();
      ai.a(this, localbf, ((TimeLineObject)localObject2).xXR);
      if (!localbf.yVH) {
        break label525;
      }
      this.yID.setVisibility(0);
      this.yID.setText(localbf.yVI);
      this.yID.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98499);
          if (this.yIV.DNt == null)
          {
            AppMethodBeat.o(98499);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.sns.c.a.iyy.eB(this.yIV.DNt.hOf);
          int i = 0;
          if (this.yIW.FQo.Ety == 1) {
            i = 2;
          }
          while (i.a(this.yIW, SnsBrowseUI.this))
          {
            com.tencent.mm.plugin.sns.c.a.iyy.a(SnsBrowseUI.this, this.yIV.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 18, 9, this.yIV.DNt.DNn, this.yIW.Id);
            AppMethodBeat.o(98499);
            return;
            if (this.yIW.FQo.Ety == 3) {
              i = 5;
            } else if (this.yIW.FQo.Ety == 15) {
              i = 4;
            }
          }
          switch (this.yIV.ndI)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(98499);
            return;
            Object localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", this.yIV.Url);
            com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject, SnsBrowseUI.this);
            com.tencent.mm.plugin.sns.c.a.iyy.a(SnsBrowseUI.this, this.yIV.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 18, 1, this.yIV.DNt.DNn, this.yIW.Id);
            AppMethodBeat.o(98499);
            return;
            if (this.yIV.Scene == 1)
            {
              localObject = new hv();
              ((hv)localObject).diT.actionCode = 2;
              ((hv)localObject).diT.scene = 3;
              ((hv)localObject).diT.appId = this.yIV.DNt.hOf;
              ((hv)localObject).diT.context = SnsBrowseUI.this;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.c.a.iyy.a(SnsBrowseUI.this, this.yIV.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 18, 6, this.yIV.DNt.DNn, this.yIW.Id);
              AppMethodBeat.o(98499);
              return;
              int j = ai.a(SnsBrowseUI.this, this.yIV);
              if (j == 1)
              {
                localObject = new hv();
                ((hv)localObject).diT.context = SnsBrowseUI.this;
                ((hv)localObject).diT.actionCode = 2;
                ((hv)localObject).diT.appId = this.yIV.DNt.hOf;
                ((hv)localObject).diT.messageAction = this.yIV.DNt.DNp;
                ((hv)localObject).diT.messageExt = this.yIV.DNt.DNo;
                ((hv)localObject).diT.scene = 3;
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                com.tencent.mm.plugin.sns.c.a.iyy.a(SnsBrowseUI.this, this.yIV.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 18, 6, this.yIV.DNt.DNn, this.yIW.Id);
                AppMethodBeat.o(98499);
                return;
              }
              if (j == 2)
              {
                localObject = new hv();
                ((hv)localObject).diT.context = SnsBrowseUI.this;
                ((hv)localObject).diT.actionCode = 1;
                ((hv)localObject).diT.appId = this.yIV.DNt.hOf;
                ((hv)localObject).diT.messageAction = this.yIV.DNt.DNp;
                ((hv)localObject).diT.messageExt = this.yIV.DNt.DNo;
                ((hv)localObject).diT.scene = 3;
                com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
                com.tencent.mm.plugin.sns.c.a.iyy.a(SnsBrowseUI.this, this.yIV.DNt.hOf, paramAnonymousView, this.yIW.ncR, i, 18, 3, this.yIV.DNt.DNn, this.yIW.Id);
              }
            }
          }
        }
      });
    }
    for (;;)
    {
      if (m.n(localp)) {
        break label537;
      }
      ac.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + localp.field_userName + " " + localp.field_snsId);
      finish();
      AppMethodBeat.o(98515);
      return;
      localObject1 = null;
      break;
      label525:
      this.yID.setVisibility(8);
    }
    label537:
    if ((localp.field_type == 21) && (!localp.field_userName.equals(com.tencent.mm.model.u.axw())))
    {
      this.yIN = new com.tencent.mm.pluginsdk.model.u(com.tencent.mm.loader.j.b.apb() + "/Pictures/Screenshots/", new com.tencent.mm.pluginsdk.model.u.a()
      {
        public final void dow()
        {
          AppMethodBeat.i(98498);
          com.tencent.mm.plugin.sns.lucky.a.b.lA(44);
          com.tencent.mm.plugin.sns.lucky.b.a.a(4, af.dHR().auT(SnsBrowseUI.a(SnsBrowseUI.this)));
          AppMethodBeat.o(98498);
        }
      });
      this.yIN.start();
    }
    AppMethodBeat.o(98515);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98519);
    ac.i("MicroMsg.SnsPopMediasUI", "onActivityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(98519);
      return;
    }
    AppMethodBeat.o(98519);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98509);
    super.onCreate(paramBundle);
    hideTitleView();
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(134218752, 134218752);
      getWindow().addFlags(67108864);
    }
    setLightNavigationbarIcon();
    initView();
    this.ocU = paramBundle;
    AppMethodBeat.o(98509);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98510);
    int j;
    int k;
    long l3;
    SnsInfoFlip localSnsInfoFlip;
    if (this.yIC != null)
    {
      j = getIntent().getIntExtra("K_ad_scene", -1);
      k = getIntent().getIntExtra("K_ad_source", 0);
      l3 = getIntent().getLongExtra("sns_ad_exposure_start_time", 0L);
      localSnsInfoFlip = this.yIC;
      localObject1 = this.dgl;
      if (localSnsInfoFlip.isAd)
      {
        if (j >= 0) {
          break label194;
        }
        ac.i("MicroMsg.SnsInfoFlip", "pass by scene ".concat(String.valueOf(j)));
      }
    }
    label194:
    p localp;
    do
    {
      localObject1 = d.w(getIntent());
      if (localObject1 != null)
      {
        this.yIC.getSelectCount();
        i = this.yIC.getNumOfFileExist();
        ((d)localObject1).pv(this.yIC.getCount()).pv(i);
        ((d)localObject1).update();
        ((d)localObject1).aHZ();
      }
      af.dHO().aD(this);
      if (this.yIK) {
        this.yIC.dPK();
      }
      if (this.yIN != null) {
        this.yIN.stop();
      }
      super.onDestroy();
      AppMethodBeat.o(98510);
      return;
      localp = af.dHR().auT((String)localObject1);
    } while (localp == null);
    long l1;
    long l2;
    if (localSnsInfoFlip.yIE >= 0)
    {
      if (!localSnsInfoFlip.yMg.containsKey(Integer.valueOf(localSnsInfoFlip.yIE))) {
        break label622;
      }
      l1 = ((Long)localSnsInfoFlip.yMg.get(Integer.valueOf(localSnsInfoFlip.yIE))).longValue();
      if (l1 > 0L)
      {
        if (!localSnsInfoFlip.yMh.containsKey(Integer.valueOf(localSnsInfoFlip.yIE))) {
          break label628;
        }
        l2 = ((Long)localSnsInfoFlip.yMh.get(Integer.valueOf(localSnsInfoFlip.yIE))).longValue();
        label310:
        l1 = bs.aO(l1);
        l2 += l1;
        localSnsInfoFlip.yMh.put(Integer.valueOf(localSnsInfoFlip.yIE), Long.valueOf(l2));
        ac.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + localSnsInfoFlip.yIE + " curtime " + l2 + " passtime " + l1);
      }
    }
    com.tencent.mm.plugin.sns.storage.e locale = localp.dME();
    label413:
    label455:
    Integer localInteger;
    int m;
    if (k == 2)
    {
      localp.dLS();
      localObject1 = new StringBuffer();
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject1).append("<desc>");
      Iterator localIterator = localSnsInfoFlip.yMf.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label648;
      }
      localInteger = (Integer)localIterator.next();
      m = ((Integer)localSnsInfoFlip.yMf.get(localInteger)).intValue();
      if (!localSnsInfoFlip.yMh.containsKey(localInteger)) {
        break label643;
      }
    }
    label643:
    for (int i = (int)(((Long)localSnsInfoFlip.yMh.get(localInteger)).longValue() * 1L);; i = 0)
    {
      ((StringBuffer)localObject1).append(String.format("<item><id>%d</id><duration>%d</duration><count>%d</count></item>", new Object[] { localInteger, Integer.valueOf(i), Integer.valueOf(m) }));
      ((StringBuffer)localObject2).append(String.format("%d|%d|%d", new Object[] { localInteger, Integer.valueOf(i), Integer.valueOf(m) }) + "&");
      break label455;
      label622:
      l1 = 0L;
      break;
      label628:
      l2 = 0L;
      break label310;
      localp.dFQ();
      break label413;
    }
    label648:
    ((StringBuffer)localObject1).append("</desc>");
    Object localObject2 = ((StringBuffer)localObject2).toString();
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("&")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    if ((localp == null) || (!localp.dJU())) {
      af.dHL().f(12014, new Object[] { com.tencent.mm.plugin.sns.ad.d.h.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId), localp.dMD(), Integer.valueOf(j), Long.valueOf(localSnsInfoFlip.yMs), Long.valueOf(System.currentTimeMillis()), localObject1, Integer.valueOf(localSnsInfoFlip.getCount()) }) });
    }
    if (!locale.dFR().dJL()) {
      if (k != 0) {
        break label943;
      }
    }
    label943:
    for (i = 1;; i = 2)
    {
      localObject2 = new SnsAdClick(k, i, localp.field_snsId, 6, 0);
      ((SnsAdClick)localObject2).hTG = l3;
      com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
      localObject2 = d.ps(729);
      ((d)localObject2).Dn(com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId)).Dn(localp.dMD()).pv(j).Dn(localSnsInfoFlip.yMs).Dn(System.currentTimeMillis()).Dn((String)localObject1).pv(localSnsInfoFlip.getCount());
      ((d)localObject2).aHZ();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98511);
    if (this.yIC != null) {
      this.yIC.onPause();
    }
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(98511);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98512);
    super.onResume();
    if (this.yIC != null) {
      this.yIC.rn(false);
    }
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    AppMethodBeat.o(98512);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98513);
    Bundle localBundle = this.ocU;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.xgY = ((Rect)getIntent().getParcelableExtra("sns_gallery_thumb_location"));
        if (this.xgY == null) {
          this.xgY = new Rect();
        }
        this.ocV.R(this.xgY.left, this.xgY.top, this.xgY.width(), this.xgY.height());
        if (localBundle == null) {
          this.yIC.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98500);
              SnsBrowseUI.this.yIC.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.yIC.getWidth());
              SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.yIC.getHeight());
              SnsBrowseUI.c(SnsBrowseUI.this, SnsBrowseUI.this.yIC.getWidth());
              SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.yIC.getHeight());
              af.dHO();
              Object localObject = com.tencent.mm.plugin.sns.model.f.C(SnsBrowseUI.this.yIC.getCntMedia());
              if (localObject != null)
              {
                localObject = com.tencent.mm.sdk.platformtools.f.aKw((String)localObject);
                SnsBrowseUI localSnsBrowseUI = SnsBrowseUI.this;
                float f = SnsBrowseUI.b(SnsBrowseUI.this) / ((BitmapFactory.Options)localObject).outWidth;
                SnsBrowseUI.d(localSnsBrowseUI, (int)(((BitmapFactory.Options)localObject).outHeight * f));
                if (SnsBrowseUI.c(SnsBrowseUI.this) > SnsBrowseUI.this.yIC.getHeight()) {
                  SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.yIC.getHeight());
                }
              }
              SnsBrowseUI.this.ocV.jN(SnsBrowseUI.b(SnsBrowseUI.this), SnsBrowseUI.c(SnsBrowseUI.this));
              SnsBrowseUI.this.ocV.a(SnsBrowseUI.this.yIC, SnsBrowseUI.d(SnsBrowseUI.this), null);
              SnsBrowseUI.this.dPq();
              AppMethodBeat.o(98500);
              return true;
            }
          });
        }
      }
    }
    super.onStart();
    ac.d("MicroMsg.SnsPopMediasUI", "onStart ");
    AppMethodBeat.o(98513);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI
 * JD-Core Version:    0.7.0.1
 */