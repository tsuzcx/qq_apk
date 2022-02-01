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
import com.tencent.mm.f.a.jh;
import com.tencent.mm.f.a.jh.b;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.sns.ad.f.k;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.model.z.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.ui.widget.pulldown.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
@c(0)
public class SnsBrowseUI
  extends SnsBaseGalleryUI
  implements y.a
{
  private Rect IUo;
  private int KOm;
  private boolean KOn;
  private boolean KOo;
  private boolean KOp;
  private com.tencent.mm.pluginsdk.model.z KOq;
  private int KOr;
  private int KOs;
  private int KOt;
  private float KOu;
  private int KOv;
  private int KOw;
  private String fCM;
  private int fGA;
  private boolean isAnimated;
  private MMHandler mHandler;
  private ImageView mLT;
  private int pEj;
  private int pEk;
  private int scene;
  Bundle twA;
  com.tencent.mm.ui.tools.f twB;
  
  public SnsBrowseUI()
  {
    AppMethodBeat.i(98508);
    this.KOm = 0;
    this.fGA = 0;
    this.KOn = false;
    this.KOo = false;
    this.KOp = false;
    this.isAnimated = false;
    this.pEj = 0;
    this.pEk = 0;
    this.mHandler = new MMHandler();
    this.KOt = 0;
    this.scene = 0;
    this.KOu = 1.0F;
    this.KOv = 0;
    this.KOw = 0;
    AppMethodBeat.o(98508);
  }
  
  public final void cJs()
  {
    AppMethodBeat.i(98516);
    if (this.IUo == null) {
      this.IUo = new Rect();
    }
    if (!this.KOo)
    {
      localObject = new jh();
      ((jh)localObject).fGy.fGB = this.KNW.getGallery().getCurrentItem();
      ((jh)localObject).fGy.fGA = this.fGA;
      EventCenter.instance.publish((IEvent)localObject);
      this.IUo.left = ((jh)localObject).fGz.fxe;
      this.IUo.top = ((jh)localObject).fGz.fxf;
      this.IUo.right = (((jh)localObject).fGz.fxg + this.IUo.left);
      this.IUo.bottom = (((jh)localObject).fGz.fxh + this.IUo.top);
    }
    this.KOr = this.KNW.getWidth();
    this.KOs = this.KNW.getHeight();
    aj.fOF();
    Object localObject = com.tencent.mm.plugin.sns.model.g.D(this.KNW.getCntMedia());
    int i;
    if (localObject != null)
    {
      localObject = BitmapUtil.getImageOptions((String)localObject);
      float f = this.KOr / ((BitmapFactory.Options)localObject).outWidth;
      this.KOs = ((int)(((BitmapFactory.Options)localObject).outHeight * f));
      if (this.KOs > this.KNW.getHeight())
      {
        if (this.KOs < this.KNW.getHeight() * 2.5D)
        {
          this.KOt = (this.KOs - this.KNW.getHeight());
          if (this.KNW.getCount() == 1)
          {
            i = this.KNW.getHeight() * this.IUo.height() / this.KOs;
            this.IUo.bottom = (i + this.IUo.top);
            this.KOt = 0;
          }
        }
        this.KOs = this.KNW.getHeight();
      }
    }
    this.twB.mJ(this.KOr, this.KOs);
    this.twB.V(this.IUo.left, this.IUo.top, this.IUo.width(), this.IUo.height());
    if (this.KOu != 1.0D)
    {
      this.twB.XRS = (1.0F / this.KOu);
      if ((this.KOv != 0) || (this.KOw != 0))
      {
        i = (int)(this.KNW.getWidth() / 2 * (1.0F - this.KOu));
        int j = this.KOv;
        int k = (int)(this.KNW.getHeight() / 2 + this.KOw - this.KOs / 2 * this.KOu);
        this.twB.mL(i + j, k);
      }
    }
    this.twB.XRW = this.KOt;
    this.twB.a(this.KNW, this.mLT, new f.c()new f.a
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
        SnsInfoFlip localSnsInfoFlip = SnsBrowseUI.this.KNW;
        if (localSnsInfoFlip.KRZ != null) {
          localSnsInfoFlip.KRZ.setVisibility(8);
        }
        SnsBrowseUI.e(SnsBrowseUI.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98501);
            Object localObject = SnsBrowseUI.this.KNW;
            if (((SnsInfoFlip)localObject).CcM != null)
            {
              localObject = ((SnsInfoFlip)localObject).CcM.getSelectedView();
              if ((localObject instanceof com.tencent.mm.ui.base.g)) {
                ((com.tencent.mm.ui.base.g)localObject).hJx();
              }
            }
            AppMethodBeat.o(98501);
          }
        }, 20L);
        AppMethodBeat.o(98503);
      }
    }, new f.a()
    {
      public final void Q(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(98505);
        if ((SnsBrowseUI.this.KNW.getGallery() != null) && (Build.VERSION.SDK_INT >= 18)) {
          SnsBrowseUI.this.KNW.getGallery().setClipBounds(new Rect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
        }
        AppMethodBeat.o(98505);
      }
    });
    AppMethodBeat.o(98516);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98514);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
      if ((this.KNZ != null) && (this.KNZ.getVisibility() == 0))
      {
        long l = 0L;
        if (this.KNW != null) {
          l = this.KNW.BrO.longValue();
        }
        this.KNZ.F(l, false);
        AppMethodBeat.o(98514);
        return true;
      }
      setResult(-1, new Intent());
      fVO();
      cJs();
      AppMethodBeat.o(98514);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98514);
    return bool;
  }
  
  public final void fTH() {}
  
  protected final boolean fVP()
  {
    return true;
  }
  
  protected final int fVQ()
  {
    return 3;
  }
  
  protected final int fVR()
  {
    return 3;
  }
  
  public final void fVZ()
  {
    AppMethodBeat.i(98517);
    final MMViewPager localMMViewPager = this.KNW.getGallery();
    localMMViewPager.setGalleryScaleListener(new MMViewPager.c()
    {
      public final void U(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        AppMethodBeat.i(98506);
        if (((SnsBrowseUI.f(SnsBrowseUI.this) == 0) || (SnsBrowseUI.g(SnsBrowseUI.this) == 0)) && (SnsBrowseUI.this.KNW != null))
        {
          SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.KNW.getHeight());
          SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.KNW.getWidth());
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
      
      public final void aq(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(98507);
        SnsBrowseUI.e(SnsBrowseUI.this, (int)paramAnonymousFloat1);
        SnsBrowseUI.f(SnsBrowseUI.this, (int)paramAnonymousFloat2);
        AppMethodBeat.o(98507);
      }
    });
    AppMethodBeat.o(98517);
  }
  
  public int getLayoutId()
  {
    return i.g.sns_browse_img;
  }
  
  public final void gl(String paramString, int paramInt)
  {
    AppMethodBeat.i(98518);
    Log.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE, paramString });
    if (this.KNW != null) {
      this.KNW.yY(true);
    }
    AppMethodBeat.o(98518);
  }
  
  public final void gm(String paramString, int paramInt)
  {
    AppMethodBeat.i(98520);
    this.KOm = paramInt;
    if (this.scene == 2)
    {
      paramString = com.tencent.mm.plugin.sns.storage.f.bbl(paramString);
      com.tencent.mm.plugin.sns.k.g.Kia.e(paramString, paramInt);
      com.tencent.mm.plugin.sns.k.g.Kia.f(paramString, paramInt);
    }
    AppMethodBeat.o(98520);
  }
  
  public void initView()
  {
    AppMethodBeat.i(98515);
    this.twB = new com.tencent.mm.ui.tools.f(getContext());
    this.isAnimated = false;
    Object localObject1 = Util.nullAs(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.fCM = Util.nullAs(getIntent().getStringExtra("sns_gallery_localId"), "");
    this.KOm = getIntent().getIntExtra("sns_gallery_position", 0);
    this.fGA = getIntent().getIntExtra("sns_position", 0);
    this.KOn = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
    this.KOo = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
    this.KOp = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
    this.scene = getIntent().getIntExtra("K_source", 0);
    SnsInfo localSnsInfo = aj.fOI().bbl(this.fCM);
    this.mLT = ((ImageView)findViewById(i.f.gallery_bg));
    this.KNW = new SnsInfoFlip(this);
    this.KNW.setIsFromMainTimeline(this.KOn);
    this.KNW.setNeedScanImage(true);
    Object localObject2 = an.bah(this.fCM);
    this.KNW.setShowPageControl(true);
    this.KNW.setTouchFinish(true);
    this.KNW.setIsSoonEnterPhotoEditUI(this.KOp);
    this.KNW.a((List)localObject2, (String)localObject1, this.KOm, this.KNR, this);
    localObject1 = this.KNW;
    localObject2 = bp.hzh();
    ((bp)localObject2).time = localSnsInfo.field_createTime;
    ((SnsInfoFlip)localObject1).setFromScene((bp)localObject2);
    this.KNW.setUIFromScene(getFromScene());
    this.KNW.setOnPageSelectListener(this);
    addView(this.KNW);
    if ((localSnsInfo != null) && (localSnsInfo.isAd())) {
      this.KNW.setIsAd(true);
    }
    this.KNX = ((Button)findViewById(i.f.game_more_button));
    int i = ax.aB(this);
    localObject1 = (ViewGroup.MarginLayoutParams)this.KNX.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (i + getResources().getDimensionPixelSize(i.d.sns_game_more_button_bottom_margin));
    this.KNX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject2 = localSnsInfo.getTimeLine();
    if (localObject2 != null)
    {
      localObject1 = ((TimeLineObject)localObject2).actionInfo;
      bn localbn = new bn();
      aq.a(this, localbn, ((TimeLineObject)localObject2).actionInfo);
      if (!localbn.Lcb) {
        break label534;
      }
      this.KNX.setVisibility(0);
      this.KNX.setText(localbn.Lcc);
      this.KNX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98499);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          if (this.KOy.RFO == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.sns.c.a.mIH.gY(this.KOy.RFO.lVG);
          int i = 0;
          if (this.KOz.ContentObj.Sqq == 1) {
            i = 2;
          }
          while (i.a(this.KOz, SnsBrowseUI.this))
          {
            com.tencent.mm.plugin.sns.c.a.mIH.a(SnsBrowseUI.this, this.KOy.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 18, 9, this.KOy.RFO.RFI, this.KOz.Id);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
            if (this.KOz.ContentObj.Sqq == 3) {
              i = 5;
            } else if (this.KOz.ContentObj.Sqq == 15) {
              i = 4;
            }
          }
          switch (this.KOy.rWu)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", this.KOy.Url);
            com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject, SnsBrowseUI.this);
            com.tencent.mm.plugin.sns.c.a.mIH.a(SnsBrowseUI.this, this.KOy.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 18, 1, this.KOy.RFO.RFI, this.KOz.Id);
            continue;
            if (this.KOy.CPw == 1)
            {
              localObject = new ji();
              ((ji)localObject).fGD.actionCode = 2;
              ((ji)localObject).fGD.scene = 3;
              ((ji)localObject).fGD.appId = this.KOy.RFO.lVG;
              ((ji)localObject).fGD.context = SnsBrowseUI.this;
              EventCenter.instance.publish((IEvent)localObject);
              com.tencent.mm.plugin.sns.c.a.mIH.a(SnsBrowseUI.this, this.KOy.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 18, 6, this.KOy.RFO.RFI, this.KOz.Id);
              continue;
              int j = aq.b(SnsBrowseUI.this, this.KOy);
              if (j == 1)
              {
                localObject = new ji();
                ((ji)localObject).fGD.context = SnsBrowseUI.this;
                ((ji)localObject).fGD.actionCode = 2;
                ((ji)localObject).fGD.appId = this.KOy.RFO.lVG;
                ((ji)localObject).fGD.messageAction = this.KOy.RFO.RFK;
                ((ji)localObject).fGD.messageExt = this.KOy.RFO.RFJ;
                ((ji)localObject).fGD.scene = 3;
                EventCenter.instance.publish((IEvent)localObject);
                com.tencent.mm.plugin.sns.c.a.mIH.a(SnsBrowseUI.this, this.KOy.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 18, 6, this.KOy.RFO.RFI, this.KOz.Id);
              }
              else if (j == 2)
              {
                localObject = new ji();
                ((ji)localObject).fGD.context = SnsBrowseUI.this;
                ((ji)localObject).fGD.actionCode = 1;
                ((ji)localObject).fGD.appId = this.KOy.RFO.lVG;
                ((ji)localObject).fGD.messageAction = this.KOy.RFO.RFK;
                ((ji)localObject).fGD.messageExt = this.KOy.RFO.RFJ;
                ((ji)localObject).fGD.scene = 3;
                EventCenter.instance.publish((IEvent)localObject);
                com.tencent.mm.plugin.sns.c.a.mIH.a(SnsBrowseUI.this, this.KOy.RFO.lVG, paramAnonymousView, this.KOz.UserName, i, 18, 3, this.KOy.RFO.RFI, this.KOz.Id);
              }
            }
          }
        }
      });
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.sns.lucky.a.m.x(localSnsInfo)) {
        break label546;
      }
      Log.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + localSnsInfo.getUserName() + " " + localSnsInfo.field_snsId);
      finish();
      AppMethodBeat.o(98515);
      return;
      localObject1 = null;
      break;
      label534:
      this.KNX.setVisibility(8);
    }
    label546:
    if ((localSnsInfo.getTypeFlag() == 21) && (!localSnsInfo.getUserName().equals(com.tencent.mm.model.z.bcZ())))
    {
      this.KOq = new com.tencent.mm.pluginsdk.model.z(com.tencent.mm.loader.j.b.aSF() + "/Pictures/Screenshots/", new z.a()
      {
        public final void fok()
        {
          AppMethodBeat.i(98498);
          com.tencent.mm.plugin.sns.lucky.a.b.rE(44);
          com.tencent.mm.plugin.sns.lucky.b.a.c(4, aj.fOI().bbl(SnsBrowseUI.a(SnsBrowseUI.this)));
          AppMethodBeat.o(98498);
        }
      });
      this.KOq.start();
    }
    AppMethodBeat.o(98515);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98519);
    Log.i("MicroMsg.SnsPopMediasUI", "onActivityResult requestCode:".concat(String.valueOf(paramInt1)));
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
    ar.bs(this);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(134218752, 134218752);
      getWindow().addFlags(67108864);
    }
    setLightNavigationbarIcon();
    initView();
    this.twA = paramBundle;
    AppMethodBeat.o(98509);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98510);
    int j;
    int k;
    long l3;
    SnsInfoFlip localSnsInfoFlip;
    if (this.KNW != null)
    {
      j = getIntent().getIntExtra("K_ad_scene", -1);
      k = getIntent().getIntExtra("K_ad_source", 0);
      l3 = getIntent().getLongExtra("sns_ad_exposure_start_time", 0L);
      localSnsInfoFlip = this.KNW;
      localObject1 = this.fCM;
      if (localSnsInfoFlip.isAd)
      {
        if (j >= 0) {
          break label194;
        }
        Log.i("MicroMsg.SnsInfoFlip", "pass by scene ".concat(String.valueOf(j)));
      }
    }
    label194:
    SnsInfo localSnsInfo;
    do
    {
      localObject1 = com.tencent.mm.modelsns.l.x(getIntent());
      if (localObject1 != null)
      {
        this.KNW.getSelectCount();
        i = this.KNW.getNumOfFileExist();
        ((com.tencent.mm.modelsns.l)localObject1).wR(this.KNW.getCount()).wR(i);
        ((com.tencent.mm.modelsns.l)localObject1).update();
        ((com.tencent.mm.modelsns.l)localObject1).bpa();
      }
      aj.fOF().aO(this);
      if (this.KOn) {
        this.KNW.fWu();
      }
      if (this.KOq != null) {
        this.KOq.stop();
      }
      super.onDestroy();
      AppMethodBeat.o(98510);
      return;
      localSnsInfo = aj.fOI().bbl((String)localObject1);
    } while (localSnsInfo == null);
    long l1;
    long l2;
    if (localSnsInfoFlip.KOa >= 0)
    {
      if (!localSnsInfoFlip.KRQ.containsKey(Integer.valueOf(localSnsInfoFlip.KOa))) {
        break label622;
      }
      l1 = ((Long)localSnsInfoFlip.KRQ.get(Integer.valueOf(localSnsInfoFlip.KOa))).longValue();
      if (l1 > 0L)
      {
        if (!localSnsInfoFlip.KRR.containsKey(Integer.valueOf(localSnsInfoFlip.KOa))) {
          break label628;
        }
        l2 = ((Long)localSnsInfoFlip.KRR.get(Integer.valueOf(localSnsInfoFlip.KOa))).longValue();
        label310:
        l1 = Util.ticksToNow(l1);
        l2 += l1;
        localSnsInfoFlip.KRR.put(Integer.valueOf(localSnsInfoFlip.KOa), Long.valueOf(l2));
        Log.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + localSnsInfoFlip.KOa + " curtime " + l2 + " passtime " + l1);
      }
    }
    AdSnsInfo localAdSnsInfo = localSnsInfo.getAdSnsInfo();
    label413:
    label455:
    Integer localInteger;
    int m;
    if (k == 2)
    {
      localSnsInfo.getAtAdInfo();
      localObject1 = new StringBuffer();
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject1).append("<desc>");
      Iterator localIterator = localSnsInfoFlip.KRP.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label648;
      }
      localInteger = (Integer)localIterator.next();
      m = ((Integer)localSnsInfoFlip.KRP.get(localInteger)).intValue();
      if (!localSnsInfoFlip.KRR.containsKey(localInteger)) {
        break label643;
      }
    }
    label643:
    for (int i = (int)(((Long)localSnsInfoFlip.KRR.get(localInteger)).longValue() * 1L);; i = 0)
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
      localSnsInfo.getAdInfo();
      break label413;
    }
    label648:
    ((StringBuffer)localObject1).append("</desc>");
    Object localObject2 = ((StringBuffer)localObject2).toString();
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("&")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    if ((localSnsInfo == null) || (!localSnsInfo.isRecExpAd())) {
      aj.fOC().a(12014, new Object[] { k.a(localSnsInfo.field_snsId, new Object[] { t.Qu(localSnsInfo.field_snsId), localSnsInfo.getUxinfo(), Integer.valueOf(j), Long.valueOf(localSnsInfoFlip.KSd), Long.valueOf(System.currentTimeMillis()), localObject1, Integer.valueOf(localSnsInfoFlip.getCount()) }) });
    }
    if (!localAdSnsInfo.getAdXml().isCardAd()) {
      if (k != 0) {
        break label943;
      }
    }
    label943:
    for (i = 1;; i = 2)
    {
      localObject2 = new SnsAdClick(k, i, localSnsInfo.field_snsId, 6, 0);
      ((SnsAdClick)localObject2).mbc = l3;
      t.a((SnsAdClick)localObject2);
      localObject2 = com.tencent.mm.modelsns.l.wO(729);
      ((com.tencent.mm.modelsns.l)localObject2).Xf(t.Qu(localSnsInfo.field_snsId)).Xf(localSnsInfo.getUxinfo()).wR(j).Xf(localSnsInfoFlip.KSd).Xf(System.currentTimeMillis()).Xf((String)localObject1).wR(localSnsInfoFlip.getCount());
      ((com.tencent.mm.modelsns.l)localObject2).bpa();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98511);
    if (this.KNW != null) {
      this.KNW.onPause();
    }
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(98511);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98512);
    super.onResume();
    if (this.KNW != null) {
      this.KNW.yY(false);
    }
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    AppMethodBeat.o(98512);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98513);
    Bundle localBundle = this.twA;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.IUo = ((Rect)getIntent().getParcelableExtra("sns_gallery_thumb_location"));
        if (this.IUo == null) {
          this.IUo = new Rect();
        }
        this.twB.V(this.IUo.left, this.IUo.top, this.IUo.width(), this.IUo.height());
        if (localBundle == null) {
          this.KNW.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98500);
              SnsBrowseUI.this.KNW.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.KNW.getWidth());
              SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.KNW.getHeight());
              SnsBrowseUI.c(SnsBrowseUI.this, SnsBrowseUI.this.KNW.getWidth());
              SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.KNW.getHeight());
              aj.fOF();
              Object localObject = com.tencent.mm.plugin.sns.model.g.D(SnsBrowseUI.this.KNW.getCntMedia());
              if (localObject != null)
              {
                localObject = BitmapUtil.getImageOptions((String)localObject);
                SnsBrowseUI localSnsBrowseUI = SnsBrowseUI.this;
                float f = SnsBrowseUI.b(SnsBrowseUI.this) / ((BitmapFactory.Options)localObject).outWidth;
                SnsBrowseUI.d(localSnsBrowseUI, (int)(((BitmapFactory.Options)localObject).outHeight * f));
                if (SnsBrowseUI.c(SnsBrowseUI.this) > SnsBrowseUI.this.KNW.getHeight()) {
                  SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.KNW.getHeight());
                }
              }
              SnsBrowseUI.this.twB.mJ(SnsBrowseUI.b(SnsBrowseUI.this), SnsBrowseUI.c(SnsBrowseUI.this));
              SnsBrowseUI.this.twB.a(SnsBrowseUI.this.KNW, SnsBrowseUI.d(SnsBrowseUI.this), null);
              SnsBrowseUI.this.fVZ();
              AppMethodBeat.o(98500);
              return true;
            }
          });
        }
      }
    }
    super.onStart();
    Log.d("MicroMsg.SnsPopMediasUI", "onStart ");
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