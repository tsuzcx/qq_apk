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
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hn.b;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
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
  private String diQ;
  private int dlh;
  private boolean isAnimated;
  private int kvn;
  private int kvo;
  private com.tencent.mm.sdk.platformtools.ap mHandler;
  Bundle nzU;
  com.tencent.mm.ui.tools.e nzV;
  private ImageView qdk;
  private int scene;
  private Rect vWl;
  private int xvT;
  private boolean xvU;
  private boolean xvV;
  private boolean xvW;
  private com.tencent.mm.pluginsdk.model.u xvX;
  private int xvY;
  private int xvZ;
  private int xwa;
  private float xwb;
  private int xwc;
  private int xwd;
  
  public SnsBrowseUI()
  {
    AppMethodBeat.i(98508);
    this.xvT = 0;
    this.dlh = 0;
    this.xvU = false;
    this.xvV = false;
    this.xvW = false;
    this.isAnimated = false;
    this.kvn = 0;
    this.kvo = 0;
    this.mHandler = new com.tencent.mm.sdk.platformtools.ap();
    this.xwa = 0;
    this.scene = 0;
    this.xwb = 1.0F;
    this.xwc = 0;
    this.xwd = 0;
    AppMethodBeat.o(98508);
  }
  
  public final void bKT()
  {
    AppMethodBeat.i(98516);
    if (this.vWl == null) {
      this.vWl = new Rect();
    }
    if (!this.xvV)
    {
      localObject = new hn();
      ((hn)localObject).dlf.dli = this.xvM.getGallery().getCurrentItem();
      ((hn)localObject).dlf.dlh = this.dlh;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      this.vWl.left = ((hn)localObject).dlg.ddh;
      this.vWl.top = ((hn)localObject).dlg.ddi;
      this.vWl.right = (((hn)localObject).dlg.ddj + this.vWl.left);
      this.vWl.bottom = (((hn)localObject).dlg.ddk + this.vWl.top);
    }
    this.xvY = this.xvM.getWidth();
    this.xvZ = this.xvM.getHeight();
    af.dtr();
    Object localObject = com.tencent.mm.plugin.sns.model.f.C(this.xvM.getCntMedia());
    int i;
    if (localObject != null)
    {
      localObject = com.tencent.mm.sdk.platformtools.f.aFf((String)localObject);
      float f = this.xvY / ((BitmapFactory.Options)localObject).outWidth;
      this.xvZ = ((int)(((BitmapFactory.Options)localObject).outHeight * f));
      if (this.xvZ > this.xvM.getHeight())
      {
        if (this.xvZ < this.xvM.getHeight() * 2.5D)
        {
          this.xwa = (this.xvZ - this.xvM.getHeight());
          if (this.xvM.getCount() == 1)
          {
            i = this.xvM.getHeight() * this.vWl.height() / this.xvZ;
            this.vWl.bottom = (i + this.vWl.top);
            this.xwa = 0;
          }
        }
        this.xvZ = this.xvM.getHeight();
      }
    }
    this.nzV.jB(this.xvY, this.xvZ);
    this.nzV.P(this.vWl.left, this.vWl.top, this.vWl.width(), this.vWl.height());
    if (this.xwb != 1.0D)
    {
      this.nzV.HqK = (1.0F / this.xwb);
      if ((this.xwc != 0) || (this.xwd != 0))
      {
        i = (int)(this.xvM.getWidth() / 2 * (1.0F - this.xwb));
        int j = this.xwc;
        int k = (int)(this.xvM.getHeight() / 2 + this.xwd - this.xvZ / 2 * this.xwb);
        this.nzV.jD(i + j, k);
      }
    }
    this.nzV.HqO = this.xwa;
    this.nzV.a(this.xvM, this.qdk, new e.c()new e.a
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
        SnsInfoFlip localSnsInfoFlip = SnsBrowseUI.this.xvM;
        if (localSnsInfoFlip.xzA != null) {
          localSnsInfoFlip.xzA.setVisibility(8);
        }
        SnsBrowseUI.e(SnsBrowseUI.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98501);
            Object localObject = SnsBrowseUI.this.xvM;
            if (((SnsInfoFlip)localObject).rJU != null)
            {
              localObject = ((SnsInfoFlip)localObject).rJU.getSelectedView();
              if ((localObject instanceof g)) {
                ((g)localObject).eSz();
              }
            }
            AppMethodBeat.o(98501);
          }
        }, 20L);
        AppMethodBeat.o(98503);
      }
    }, new e.a()
    {
      public final void I(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(98505);
        if ((SnsBrowseUI.this.xvM.getGallery() != null) && (Build.VERSION.SDK_INT >= 18)) {
          SnsBrowseUI.this.xvM.getGallery().setClipBounds(new Rect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
        }
        AppMethodBeat.o(98505);
      }
    });
    AppMethodBeat.o(98516);
  }
  
  protected final boolean dAL()
  {
    return true;
  }
  
  protected final int dAM()
  {
    return 3;
  }
  
  public final void dAT()
  {
    AppMethodBeat.i(98517);
    final MMViewPager localMMViewPager = this.xvM.getGallery();
    localMMViewPager.setGalleryScaleListener(new MMViewPager.b()
    {
      public final void J(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        AppMethodBeat.i(98506);
        if (((SnsBrowseUI.f(SnsBrowseUI.this) == 0) || (SnsBrowseUI.g(SnsBrowseUI.this) == 0)) && (SnsBrowseUI.this.xvM != null))
        {
          SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.xvM.getHeight());
          SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.xvM.getWidth());
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
      
      public final void Y(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
      ad.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      bKT();
      AppMethodBeat.o(98514);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98514);
    return bool;
  }
  
  public final void dza() {}
  
  public final void eA(String paramString, int paramInt)
  {
    AppMethodBeat.i(98518);
    ad.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE, paramString });
    if (this.xvM != null) {
      this.xvM.qp(true);
    }
    AppMethodBeat.o(98518);
  }
  
  public final void eB(String paramString, int paramInt)
  {
    AppMethodBeat.i(98520);
    this.xvT = paramInt;
    if (this.scene == 2)
    {
      paramString = com.tencent.mm.plugin.sns.storage.h.apK(paramString);
      com.tencent.mm.plugin.sns.k.f.wQY.c(paramString, paramInt);
      com.tencent.mm.plugin.sns.k.f.wQY.d(paramString, paramInt);
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
    this.nzV = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    Object localObject1 = bt.by(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.diQ = bt.by(getIntent().getStringExtra("sns_gallery_localId"), "");
    this.xvT = getIntent().getIntExtra("sns_gallery_position", 0);
    this.dlh = getIntent().getIntExtra("sns_position", 0);
    this.xvU = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
    this.xvV = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
    this.xvW = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
    this.scene = getIntent().getIntExtra("K_source", 0);
    p localp = af.dtu().apK(this.diQ);
    this.qdk = ((ImageView)findViewById(2131300336));
    this.xvM = new SnsInfoFlip(this);
    this.xvM.setIsFromMainTimeline(this.xvU);
    this.xvM.setNeedScanImage(true);
    Object localObject2 = aj.aoI(this.diQ);
    this.xvM.setShowPageControl(true);
    this.xvM.setTouchFinish(true);
    this.xvM.setIsSoonEnterPhotoEditUI(this.xvW);
    this.xvM.a((List)localObject2, (String)localObject1, this.xvT, this.xvH, this);
    localObject1 = this.xvM;
    localObject2 = bc.eLG();
    ((bc)localObject2).tGD = localp.field_createTime;
    ((SnsInfoFlip)localObject1).setFromScene((bc)localObject2);
    this.xvM.setOnPageSelectListener(this);
    addView(this.xvM);
    if ((localp != null) && (localp.Nb(32))) {
      this.xvM.setIsAd(true);
    }
    this.xvN = ((Button)findViewById(2131300511));
    int i = com.tencent.mm.ui.ap.eb(this);
    localObject1 = (ViewGroup.MarginLayoutParams)this.xvN.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (i + getResources().getDimensionPixelSize(2131166829));
    this.xvN.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject2 = localp.dxy();
    if (localObject2 != null)
    {
      localObject1 = ((TimeLineObject)localObject2).wLl;
      bf localbf = new bf();
      ai.a(this, localbf, ((TimeLineObject)localObject2).wLl);
      if (!localbf.xIR) {
        break label525;
      }
      this.xvN.setVisibility(0);
      this.xvN.setText(localbf.xIS);
      this.xvN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98499);
          if (this.xwf.CuY == null)
          {
            AppMethodBeat.o(98499);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.sns.d.a.hYu.eL(this.xwf.CuY.hnC);
          int i = 0;
          if (this.xwg.Etm.DaB == 1) {
            i = 2;
          }
          while (i.a(this.xwg, SnsBrowseUI.this))
          {
            com.tencent.mm.plugin.sns.d.a.hYu.a(SnsBrowseUI.this, this.xwf.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 18, 9, this.xwf.CuY.CuS, this.xwg.Id);
            AppMethodBeat.o(98499);
            return;
            if (this.xwg.Etm.DaB == 3) {
              i = 5;
            } else if (this.xwg.Etm.DaB == 15) {
              i = 4;
            }
          }
          switch (this.xwf.mBH)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(98499);
            return;
            Object localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", this.xwf.Url);
            com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject, SnsBrowseUI.this);
            com.tencent.mm.plugin.sns.d.a.hYu.a(SnsBrowseUI.this, this.xwf.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 18, 1, this.xwf.CuY.CuS, this.xwg.Id);
            AppMethodBeat.o(98499);
            return;
            if (this.xwf.Scene == 1)
            {
              localObject = new ho();
              ((ho)localObject).dlk.actionCode = 2;
              ((ho)localObject).dlk.scene = 3;
              ((ho)localObject).dlk.appId = this.xwf.CuY.hnC;
              ((ho)localObject).dlk.context = SnsBrowseUI.this;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.d.a.hYu.a(SnsBrowseUI.this, this.xwf.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 18, 6, this.xwf.CuY.CuS, this.xwg.Id);
              AppMethodBeat.o(98499);
              return;
              int j = ai.a(SnsBrowseUI.this, this.xwf);
              if (j == 1)
              {
                localObject = new ho();
                ((ho)localObject).dlk.context = SnsBrowseUI.this;
                ((ho)localObject).dlk.actionCode = 2;
                ((ho)localObject).dlk.appId = this.xwf.CuY.hnC;
                ((ho)localObject).dlk.messageAction = this.xwf.CuY.CuU;
                ((ho)localObject).dlk.messageExt = this.xwf.CuY.CuT;
                ((ho)localObject).dlk.scene = 3;
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                com.tencent.mm.plugin.sns.d.a.hYu.a(SnsBrowseUI.this, this.xwf.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 18, 6, this.xwf.CuY.CuS, this.xwg.Id);
                AppMethodBeat.o(98499);
                return;
              }
              if (j == 2)
              {
                localObject = new ho();
                ((ho)localObject).dlk.context = SnsBrowseUI.this;
                ((ho)localObject).dlk.actionCode = 1;
                ((ho)localObject).dlk.appId = this.xwf.CuY.hnC;
                ((ho)localObject).dlk.messageAction = this.xwf.CuY.CuU;
                ((ho)localObject).dlk.messageExt = this.xwf.CuY.CuT;
                ((ho)localObject).dlk.scene = 3;
                com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
                com.tencent.mm.plugin.sns.d.a.hYu.a(SnsBrowseUI.this, this.xwf.CuY.hnC, paramAnonymousView, this.xwg.mAQ, i, 18, 3, this.xwf.CuY.CuS, this.xwg.Id);
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
      ad.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + localp.field_userName + " " + localp.field_snsId);
      finish();
      AppMethodBeat.o(98515);
      return;
      localObject1 = null;
      break;
      label525:
      this.xvN.setVisibility(8);
    }
    label537:
    if ((localp.field_type == 21) && (!localp.field_userName.equals(com.tencent.mm.model.u.aqG())))
    {
      this.xvX = new com.tencent.mm.pluginsdk.model.u(com.tencent.mm.loader.j.b.aib() + "/Pictures/Screenshots/", new com.tencent.mm.pluginsdk.model.u.a()
      {
        public final void daM()
        {
          AppMethodBeat.i(98498);
          com.tencent.mm.plugin.sns.lucky.a.b.lI(44);
          com.tencent.mm.plugin.sns.lucky.b.a.a(4, af.dtu().apK(SnsBrowseUI.a(SnsBrowseUI.this)));
          AppMethodBeat.o(98498);
        }
      });
      this.xvX.start();
    }
    AppMethodBeat.o(98515);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98519);
    ad.i("MicroMsg.SnsPopMediasUI", "onActivityResult requestCode:".concat(String.valueOf(paramInt1)));
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
    this.nzU = paramBundle;
    AppMethodBeat.o(98509);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98510);
    int j;
    int k;
    long l3;
    SnsInfoFlip localSnsInfoFlip;
    if (this.xvM != null)
    {
      j = getIntent().getIntExtra("K_ad_scene", -1);
      k = getIntent().getIntExtra("K_ad_source", 0);
      l3 = getIntent().getLongExtra("sns_ad_exposure_start_time", 0L);
      localSnsInfoFlip = this.xvM;
      localObject1 = this.diQ;
      if (localSnsInfoFlip.isAd)
      {
        if (j >= 0) {
          break label194;
        }
        ad.i("MicroMsg.SnsInfoFlip", "pass by scene ".concat(String.valueOf(j)));
      }
    }
    label194:
    p localp;
    do
    {
      localObject1 = d.w(getIntent());
      if (localObject1 != null)
      {
        this.xvM.getSelectCount();
        i = this.xvM.getNumOfFileExist();
        ((d)localObject1).oH(this.xvM.getCount()).oH(i);
        ((d)localObject1).update();
        ((d)localObject1).aBj();
      }
      af.dtr().az(this);
      if (this.xvU) {
        this.xvM.dBn();
      }
      if (this.xvX != null) {
        this.xvX.stop();
      }
      super.onDestroy();
      AppMethodBeat.o(98510);
      return;
      localp = af.dtu().apK((String)localObject1);
    } while (localp == null);
    long l1;
    long l2;
    if (localSnsInfoFlip.xvO >= 0)
    {
      if (!localSnsInfoFlip.xzs.containsKey(Integer.valueOf(localSnsInfoFlip.xvO))) {
        break label622;
      }
      l1 = ((Long)localSnsInfoFlip.xzs.get(Integer.valueOf(localSnsInfoFlip.xvO))).longValue();
      if (l1 > 0L)
      {
        if (!localSnsInfoFlip.xzt.containsKey(Integer.valueOf(localSnsInfoFlip.xvO))) {
          break label628;
        }
        l2 = ((Long)localSnsInfoFlip.xzt.get(Integer.valueOf(localSnsInfoFlip.xvO))).longValue();
        label310:
        l1 = bt.aS(l1);
        l2 += l1;
        localSnsInfoFlip.xzt.put(Integer.valueOf(localSnsInfoFlip.xvO), Long.valueOf(l2));
        ad.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + localSnsInfoFlip.xvO + " curtime " + l2 + " passtime " + l1);
      }
    }
    com.tencent.mm.plugin.sns.storage.e locale = localp.dyh();
    label413:
    label455:
    Integer localInteger;
    int m;
    if (k == 2)
    {
      localp.dxv();
      localObject1 = new StringBuffer();
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject1).append("<desc>");
      Iterator localIterator = localSnsInfoFlip.xzr.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label648;
      }
      localInteger = (Integer)localIterator.next();
      m = ((Integer)localSnsInfoFlip.xzr.get(localInteger)).intValue();
      if (!localSnsInfoFlip.xzt.containsKey(localInteger)) {
        break label643;
      }
    }
    label643:
    for (int i = (int)(((Long)localSnsInfoFlip.xzt.get(localInteger)).longValue() * 1L);; i = 0)
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
      localp.dxu();
      break label413;
    }
    label648:
    ((StringBuffer)localObject1).append("</desc>");
    Object localObject2 = ((StringBuffer)localObject2).toString();
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("&")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    if ((localp == null) || (!localp.dvv())) {
      af.dto().f(12014, new Object[] { com.tencent.mm.plugin.sns.a.b.h.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId), localp.dyg(), Integer.valueOf(j), Long.valueOf(localSnsInfoFlip.xzE), Long.valueOf(System.currentTimeMillis()), localObject1, Integer.valueOf(localSnsInfoFlip.getCount()) }) });
    }
    if (!locale.dxs().dvm()) {
      if (k != 0) {
        break label943;
      }
    }
    label943:
    for (i = 1;; i = 2)
    {
      localObject2 = new SnsAdClick(k, i, localp.field_snsId, 6, 0);
      ((SnsAdClick)localObject2).hte = l3;
      com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
      localObject2 = d.oE(729);
      ((d)localObject2).zi(com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId)).zi(localp.dyg()).oH(j).zi(localSnsInfoFlip.xzE).zi(System.currentTimeMillis()).zi((String)localObject1).oH(localSnsInfoFlip.getCount());
      ((d)localObject2).aBj();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98511);
    if (this.xvM != null) {
      this.xvM.onPause();
    }
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(98511);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98512);
    super.onResume();
    if (this.xvM != null) {
      this.xvM.qp(false);
    }
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    AppMethodBeat.o(98512);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98513);
    Bundle localBundle = this.nzU;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.vWl = ((Rect)getIntent().getParcelableExtra("sns_gallery_thumb_location"));
        if (this.vWl == null) {
          this.vWl = new Rect();
        }
        this.nzV.P(this.vWl.left, this.vWl.top, this.vWl.width(), this.vWl.height());
        if (localBundle == null) {
          this.xvM.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98500);
              SnsBrowseUI.this.xvM.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.xvM.getWidth());
              SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.xvM.getHeight());
              SnsBrowseUI.c(SnsBrowseUI.this, SnsBrowseUI.this.xvM.getWidth());
              SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.xvM.getHeight());
              af.dtr();
              Object localObject = com.tencent.mm.plugin.sns.model.f.C(SnsBrowseUI.this.xvM.getCntMedia());
              if (localObject != null)
              {
                localObject = com.tencent.mm.sdk.platformtools.f.aFf((String)localObject);
                SnsBrowseUI localSnsBrowseUI = SnsBrowseUI.this;
                float f = SnsBrowseUI.b(SnsBrowseUI.this) / ((BitmapFactory.Options)localObject).outWidth;
                SnsBrowseUI.d(localSnsBrowseUI, (int)(((BitmapFactory.Options)localObject).outHeight * f));
                if (SnsBrowseUI.c(SnsBrowseUI.this) > SnsBrowseUI.this.xvM.getHeight()) {
                  SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.xvM.getHeight());
                }
              }
              SnsBrowseUI.this.nzV.jB(SnsBrowseUI.b(SnsBrowseUI.this), SnsBrowseUI.c(SnsBrowseUI.this));
              SnsBrowseUI.this.nzV.a(SnsBrowseUI.this.xvM, SnsBrowseUI.d(SnsBrowseUI.this), null);
              SnsBrowseUI.this.dAT();
              AppMethodBeat.o(98500);
              return true;
            }
          });
        }
      }
    }
    super.onStart();
    ad.d("MicroMsg.SnsPopMediasUI", "onStart ");
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