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
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.ir.b;
import com.tencent.mm.g.a.is;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.sns.ad.g.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.pluginsdk.model.v.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.tools.e.a;
import com.tencent.mm.ui.tools.e.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class SnsBrowseUI
  extends SnsBaseGalleryUI
  implements w.a
{
  private Rect COM;
  private int EAA;
  private int EAB;
  private float EAC;
  private int EAD;
  private int EAE;
  private int EAu;
  private boolean EAv;
  private boolean EAw;
  private boolean EAx;
  private v EAy;
  private int EAz;
  private String dJX;
  private int dNo;
  private boolean isAnimated;
  private ImageView jUG;
  private int mEX;
  private int mEY;
  private MMHandler mHandler;
  Bundle qaD;
  com.tencent.mm.ui.tools.e qaE;
  private int scene;
  
  public SnsBrowseUI()
  {
    AppMethodBeat.i(98508);
    this.EAu = 0;
    this.dNo = 0;
    this.EAv = false;
    this.EAw = false;
    this.EAx = false;
    this.isAnimated = false;
    this.mEX = 0;
    this.mEY = 0;
    this.mHandler = new MMHandler();
    this.EAB = 0;
    this.scene = 0;
    this.EAC = 1.0F;
    this.EAD = 0;
    this.EAE = 0;
    AppMethodBeat.o(98508);
  }
  
  public final void cvQ()
  {
    AppMethodBeat.i(98516);
    if (this.COM == null) {
      this.COM = new Rect();
    }
    if (!this.EAw)
    {
      localObject = new ir();
      ((ir)localObject).dNm.dNp = this.EAi.getGallery().getCurrentItem();
      ((ir)localObject).dNm.dNo = this.dNo;
      EventCenter.instance.publish((IEvent)localObject);
      this.COM.left = ((ir)localObject).dNn.dEq;
      this.COM.top = ((ir)localObject).dNn.dEr;
      this.COM.right = (((ir)localObject).dNn.dEs + this.COM.left);
      this.COM.bottom = (((ir)localObject).dNn.dEt + this.COM.top);
    }
    this.EAz = this.EAi.getWidth();
    this.EAA = this.EAi.getHeight();
    aj.faL();
    Object localObject = com.tencent.mm.plugin.sns.model.g.D(this.EAi.getCntMedia());
    int i;
    if (localObject != null)
    {
      localObject = BitmapUtil.getImageOptions((String)localObject);
      float f = this.EAz / ((BitmapFactory.Options)localObject).outWidth;
      this.EAA = ((int)(((BitmapFactory.Options)localObject).outHeight * f));
      if (this.EAA > this.EAi.getHeight())
      {
        if (this.EAA < this.EAi.getHeight() * 2.5D)
        {
          this.EAB = (this.EAA - this.EAi.getHeight());
          if (this.EAi.getCount() == 1)
          {
            i = this.EAi.getHeight() * this.COM.height() / this.EAA;
            this.COM.bottom = (i + this.COM.top);
            this.EAB = 0;
          }
        }
        this.EAA = this.EAi.getHeight();
      }
    }
    this.qaE.ls(this.EAz, this.EAA);
    this.qaE.Q(this.COM.left, this.COM.top, this.COM.width(), this.COM.height());
    if (this.EAC != 1.0D)
    {
      this.qaE.QtG = (1.0F / this.EAC);
      if ((this.EAD != 0) || (this.EAE != 0))
      {
        i = (int)(this.EAi.getWidth() / 2 * (1.0F - this.EAC));
        int j = this.EAD;
        int k = (int)(this.EAi.getHeight() / 2 + this.EAE - this.EAA / 2 * this.EAC);
        this.qaE.lu(i + j, k);
      }
    }
    this.qaE.QtK = this.EAB;
    this.qaE.a(this.EAi, this.jUG, new e.c()new e.a
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
        SnsInfoFlip localSnsInfoFlip = SnsBrowseUI.this.EAi;
        if (localSnsInfoFlip.EEk != null) {
          localSnsInfoFlip.EEk.setVisibility(8);
        }
        SnsBrowseUI.e(SnsBrowseUI.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98501);
            Object localObject = SnsBrowseUI.this.EAi;
            if (((SnsInfoFlip)localObject).xqs != null)
            {
              localObject = ((SnsInfoFlip)localObject).xqs.getSelectedView();
              if ((localObject instanceof com.tencent.mm.ui.base.g)) {
                ((com.tencent.mm.ui.base.g)localObject).gKy();
              }
            }
            AppMethodBeat.o(98501);
          }
        }, 20L);
        AppMethodBeat.o(98503);
      }
    }, new e.a()
    {
      public final void L(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(98505);
        if ((SnsBrowseUI.this.EAi.getGallery() != null) && (Build.VERSION.SDK_INT >= 18)) {
          SnsBrowseUI.this.EAi.getGallery().setClipBounds(new Rect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
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
      setResult(-1, new Intent());
      cvQ();
      AppMethodBeat.o(98514);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98514);
    return bool;
  }
  
  public final void fH(String paramString, int paramInt)
  {
    AppMethodBeat.i(98518);
    Log.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE, paramString });
    if (this.EAi != null) {
      this.EAi.vu(true);
    }
    AppMethodBeat.o(98518);
  }
  
  public final void fI(String paramString, int paramInt)
  {
    AppMethodBeat.i(98520);
    this.EAu = paramInt;
    if (this.scene == 2)
    {
      paramString = com.tencent.mm.plugin.sns.storage.f.aQm(paramString);
      com.tencent.mm.plugin.sns.k.e.DUQ.d(paramString, paramInt);
      com.tencent.mm.plugin.sns.k.e.DUQ.e(paramString, paramInt);
    }
    AppMethodBeat.o(98520);
  }
  
  public final void ffK() {}
  
  protected final boolean fhC()
  {
    return true;
  }
  
  protected final int fhD()
  {
    return 3;
  }
  
  protected final int fhE()
  {
    return 3;
  }
  
  public final void fhM()
  {
    AppMethodBeat.i(98517);
    final MMViewPager localMMViewPager = this.EAi.getGallery();
    localMMViewPager.setGalleryScaleListener(new MMViewPager.c()
    {
      public final void S(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        AppMethodBeat.i(98506);
        if (((SnsBrowseUI.f(SnsBrowseUI.this) == 0) || (SnsBrowseUI.g(SnsBrowseUI.this) == 0)) && (SnsBrowseUI.this.EAi != null))
        {
          SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.EAi.getHeight());
          SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.EAi.getWidth());
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
      
      public final void ao(float paramAnonymousFloat1, float paramAnonymousFloat2)
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
    return 2131496419;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98515);
    this.qaE = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    Object localObject1 = Util.nullAs(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.dJX = Util.nullAs(getIntent().getStringExtra("sns_gallery_localId"), "");
    this.EAu = getIntent().getIntExtra("sns_gallery_position", 0);
    this.dNo = getIntent().getIntExtra("sns_position", 0);
    this.EAv = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
    this.EAw = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
    this.EAx = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
    this.scene = getIntent().getIntExtra("K_source", 0);
    SnsInfo localSnsInfo = aj.faO().aQm(this.dJX);
    this.jUG = ((ImageView)findViewById(2131301854));
    this.EAi = new SnsInfoFlip(this);
    this.EAi.setIsFromMainTimeline(this.EAv);
    this.EAi.setNeedScanImage(true);
    Object localObject2 = an.aPm(this.dJX);
    this.EAi.setShowPageControl(true);
    this.EAi.setTouchFinish(true);
    this.EAi.setIsSoonEnterPhotoEditUI(this.EAx);
    this.EAi.a((List)localObject2, (String)localObject1, this.EAu, this.EAd, this);
    localObject1 = this.EAi;
    localObject2 = bp.gCU();
    ((bp)localObject2).hXs = localSnsInfo.field_createTime;
    ((SnsInfoFlip)localObject1).setFromScene((bp)localObject2);
    this.EAi.setUIFromScene(getFromScene());
    this.EAi.setOnPageSelectListener(this);
    addView(this.EAi);
    if ((localSnsInfo != null) && (localSnsInfo.isAd())) {
      this.EAi.setIsAd(true);
    }
    this.EAj = ((Button)findViewById(2131302038));
    int i = au.aD(this);
    localObject1 = (ViewGroup.MarginLayoutParams)this.EAj.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (i + getResources().getDimensionPixelSize(2131166956));
    this.EAj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject2 = localSnsInfo.getTimeLine();
    if (localObject2 != null)
    {
      localObject1 = ((TimeLineObject)localObject2).actionInfo;
      bl localbl = new bl();
      ao.a(this, localbl, ((TimeLineObject)localObject2).actionInfo);
      if (!localbl.EOf) {
        break label534;
      }
      this.EAj.setVisibility(0);
      this.EAj.setText(localbl.EOg);
      this.EAj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98499);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if (this.EAG.KEw == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.sns.c.a.jRu.go(this.EAG.KEw.jfi);
          int i = 0;
          if (this.EAH.ContentObj.LoU == 1) {
            i = 2;
          }
          while (i.a(this.EAH, SnsBrowseUI.this))
          {
            com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, this.EAG.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 18, 9, this.EAG.KEw.KEq, this.EAH.Id);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
            if (this.EAH.ContentObj.LoU == 3) {
              i = 5;
            } else if (this.EAH.ContentObj.LoU == 15) {
              i = 4;
            }
          }
          switch (this.EAG.oUv)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", this.EAG.Url);
            com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject, SnsBrowseUI.this);
            com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, this.EAG.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 18, 1, this.EAG.KEw.KEq, this.EAH.Id);
            continue;
            if (this.EAG.Scene == 1)
            {
              localObject = new is();
              ((is)localObject).dNr.actionCode = 2;
              ((is)localObject).dNr.scene = 3;
              ((is)localObject).dNr.appId = this.EAG.KEw.jfi;
              ((is)localObject).dNr.context = SnsBrowseUI.this;
              EventCenter.instance.publish((IEvent)localObject);
              com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, this.EAG.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 18, 6, this.EAG.KEw.KEq, this.EAH.Id);
              continue;
              int j = ao.b(SnsBrowseUI.this, this.EAG);
              if (j == 1)
              {
                localObject = new is();
                ((is)localObject).dNr.context = SnsBrowseUI.this;
                ((is)localObject).dNr.actionCode = 2;
                ((is)localObject).dNr.appId = this.EAG.KEw.jfi;
                ((is)localObject).dNr.messageAction = this.EAG.KEw.KEs;
                ((is)localObject).dNr.messageExt = this.EAG.KEw.KEr;
                ((is)localObject).dNr.scene = 3;
                EventCenter.instance.publish((IEvent)localObject);
                com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, this.EAG.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 18, 6, this.EAG.KEw.KEq, this.EAH.Id);
              }
              else if (j == 2)
              {
                localObject = new is();
                ((is)localObject).dNr.context = SnsBrowseUI.this;
                ((is)localObject).dNr.actionCode = 1;
                ((is)localObject).dNr.appId = this.EAG.KEw.jfi;
                ((is)localObject).dNr.messageAction = this.EAG.KEw.KEs;
                ((is)localObject).dNr.messageExt = this.EAG.KEw.KEr;
                ((is)localObject).dNr.scene = 3;
                EventCenter.instance.publish((IEvent)localObject);
                com.tencent.mm.plugin.sns.c.a.jRu.a(SnsBrowseUI.this, this.EAG.KEw.jfi, paramAnonymousView, this.EAH.UserName, i, 18, 3, this.EAG.KEw.KEq, this.EAH.Id);
              }
            }
          }
        }
      });
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.sns.lucky.a.m.w(localSnsInfo)) {
        break label546;
      }
      Log.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + localSnsInfo.getUserName() + " " + localSnsInfo.field_snsId);
      finish();
      AppMethodBeat.o(98515);
      return;
      localObject1 = null;
      break;
      label534:
      this.EAj.setVisibility(8);
    }
    label546:
    if ((localSnsInfo.getTypeFlag() == 21) && (!localSnsInfo.getUserName().equals(z.aTY())))
    {
      this.EAy = new v(com.tencent.mm.loader.j.b.aKD() + "/Pictures/Screenshots/", new v.a()
      {
        public final void eCy()
        {
          AppMethodBeat.i(98498);
          com.tencent.mm.plugin.sns.lucky.a.b.pl(44);
          com.tencent.mm.plugin.sns.lucky.b.a.c(4, aj.faO().aQm(SnsBrowseUI.a(SnsBrowseUI.this)));
          AppMethodBeat.o(98498);
        }
      });
      this.EAy.start();
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
    com.tencent.mm.ui.ao.bm(this);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(134218752, 134218752);
      getWindow().addFlags(67108864);
    }
    setLightNavigationbarIcon();
    initView();
    this.qaD = paramBundle;
    AppMethodBeat.o(98509);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98510);
    int j;
    int k;
    long l3;
    SnsInfoFlip localSnsInfoFlip;
    if (this.EAi != null)
    {
      j = getIntent().getIntExtra("K_ad_scene", -1);
      k = getIntent().getIntExtra("K_ad_source", 0);
      l3 = getIntent().getLongExtra("sns_ad_exposure_start_time", 0L);
      localSnsInfoFlip = this.EAi;
      localObject1 = this.dJX;
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
      localObject1 = k.w(getIntent());
      if (localObject1 != null)
      {
        this.EAi.getSelectCount();
        i = this.EAi.getNumOfFileExist();
        ((k)localObject1).tR(this.EAi.getCount()).tR(i);
        ((k)localObject1).update();
        ((k)localObject1).bfK();
      }
      aj.faL().aI(this);
      if (this.EAv) {
        this.EAi.fii();
      }
      if (this.EAy != null) {
        this.EAy.stop();
      }
      super.onDestroy();
      AppMethodBeat.o(98510);
      return;
      localSnsInfo = aj.faO().aQm((String)localObject1);
    } while (localSnsInfo == null);
    long l1;
    long l2;
    if (localSnsInfoFlip.EAk >= 0)
    {
      if (!localSnsInfoFlip.EEb.containsKey(Integer.valueOf(localSnsInfoFlip.EAk))) {
        break label622;
      }
      l1 = ((Long)localSnsInfoFlip.EEb.get(Integer.valueOf(localSnsInfoFlip.EAk))).longValue();
      if (l1 > 0L)
      {
        if (!localSnsInfoFlip.EEc.containsKey(Integer.valueOf(localSnsInfoFlip.EAk))) {
          break label628;
        }
        l2 = ((Long)localSnsInfoFlip.EEc.get(Integer.valueOf(localSnsInfoFlip.EAk))).longValue();
        label310:
        l1 = Util.ticksToNow(l1);
        l2 += l1;
        localSnsInfoFlip.EEc.put(Integer.valueOf(localSnsInfoFlip.EAk), Long.valueOf(l2));
        Log.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + localSnsInfoFlip.EAk + " curtime " + l2 + " passtime " + l1);
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
      Iterator localIterator = localSnsInfoFlip.EEa.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label648;
      }
      localInteger = (Integer)localIterator.next();
      m = ((Integer)localSnsInfoFlip.EEa.get(localInteger)).intValue();
      if (!localSnsInfoFlip.EEc.containsKey(localInteger)) {
        break label643;
      }
    }
    label643:
    for (int i = (int)(((Long)localSnsInfoFlip.EEc.get(localInteger)).longValue() * 1L);; i = 0)
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
      aj.faI().a(12014, new Object[] { j.a(localSnsInfo.field_snsId, new Object[] { r.Jb(localSnsInfo.field_snsId), localSnsInfo.getUxinfo(), Integer.valueOf(j), Long.valueOf(localSnsInfoFlip.EEo), Long.valueOf(System.currentTimeMillis()), localObject1, Integer.valueOf(localSnsInfoFlip.getCount()) }) });
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
      ((SnsAdClick)localObject2).jlb = l3;
      r.a((SnsAdClick)localObject2);
      localObject2 = k.tO(729);
      ((k)localObject2).PH(r.Jb(localSnsInfo.field_snsId)).PH(localSnsInfo.getUxinfo()).tR(j).PH(localSnsInfoFlip.EEo).PH(System.currentTimeMillis()).PH((String)localObject1).tR(localSnsInfoFlip.getCount());
      ((k)localObject2).bfK();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98511);
    if (this.EAi != null) {
      this.EAi.onPause();
    }
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(98511);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98512);
    super.onResume();
    if (this.EAi != null) {
      this.EAi.vu(false);
    }
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    AppMethodBeat.o(98512);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98513);
    Bundle localBundle = this.qaD;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.COM = ((Rect)getIntent().getParcelableExtra("sns_gallery_thumb_location"));
        if (this.COM == null) {
          this.COM = new Rect();
        }
        this.qaE.Q(this.COM.left, this.COM.top, this.COM.width(), this.COM.height());
        if (localBundle == null) {
          this.EAi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98500);
              SnsBrowseUI.this.EAi.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.EAi.getWidth());
              SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.EAi.getHeight());
              SnsBrowseUI.c(SnsBrowseUI.this, SnsBrowseUI.this.EAi.getWidth());
              SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.EAi.getHeight());
              aj.faL();
              Object localObject = com.tencent.mm.plugin.sns.model.g.D(SnsBrowseUI.this.EAi.getCntMedia());
              if (localObject != null)
              {
                localObject = BitmapUtil.getImageOptions((String)localObject);
                SnsBrowseUI localSnsBrowseUI = SnsBrowseUI.this;
                float f = SnsBrowseUI.b(SnsBrowseUI.this) / ((BitmapFactory.Options)localObject).outWidth;
                SnsBrowseUI.d(localSnsBrowseUI, (int)(((BitmapFactory.Options)localObject).outHeight * f));
                if (SnsBrowseUI.c(SnsBrowseUI.this) > SnsBrowseUI.this.EAi.getHeight()) {
                  SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.EAi.getHeight());
                }
              }
              SnsBrowseUI.this.qaE.ls(SnsBrowseUI.b(SnsBrowseUI.this), SnsBrowseUI.c(SnsBrowseUI.this));
              SnsBrowseUI.this.qaE.a(SnsBrowseUI.this.EAi, SnsBrowseUI.d(SnsBrowseUI.this), null);
              SnsBrowseUI.this.fhM();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI
 * JD-Core Version:    0.7.0.1
 */