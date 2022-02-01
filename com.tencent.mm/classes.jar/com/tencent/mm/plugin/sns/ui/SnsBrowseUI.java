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
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.ib.b;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.d.k;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.b;
import com.tencent.mm.ui.tools.e.a;
import com.tencent.mm.ui.tools.e.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class SnsBrowseUI
  extends SnsBaseGalleryUI
  implements v.a
{
  private int Aad;
  private boolean Aae;
  private boolean Aaf;
  private boolean Aag;
  private com.tencent.mm.pluginsdk.model.u Aah;
  private int Aai;
  private int Aaj;
  private int Aak;
  private float Aal;
  private int Aam;
  private int Aan;
  private String drH;
  private int duC;
  private ImageView iUP;
  private boolean isAnimated;
  private int ltA;
  private int ltB;
  private ap mHandler;
  Bundle oGn;
  com.tencent.mm.ui.tools.e oGo;
  private int scene;
  private Rect yuZ;
  
  public SnsBrowseUI()
  {
    AppMethodBeat.i(98508);
    this.Aad = 0;
    this.duC = 0;
    this.Aae = false;
    this.Aaf = false;
    this.Aag = false;
    this.isAnimated = false;
    this.ltA = 0;
    this.ltB = 0;
    this.mHandler = new ap();
    this.Aak = 0;
    this.scene = 0;
    this.Aal = 1.0F;
    this.Aam = 0;
    this.Aan = 0;
    AppMethodBeat.o(98508);
  }
  
  public final void bWL()
  {
    AppMethodBeat.i(98516);
    if (this.yuZ == null) {
      this.yuZ = new Rect();
    }
    if (!this.Aaf)
    {
      localObject = new ib();
      ((ib)localObject).duA.duD = this.zZW.getGallery().getCurrentItem();
      ((ib)localObject).duA.duC = this.duC;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      this.yuZ.left = ((ib)localObject).duB.dlZ;
      this.yuZ.top = ((ib)localObject).duB.dma;
      this.yuZ.right = (((ib)localObject).duB.dmb + this.yuZ.left);
      this.yuZ.bottom = (((ib)localObject).duB.dmc + this.yuZ.top);
    }
    this.Aai = this.zZW.getWidth();
    this.Aaj = this.zZW.getHeight();
    ag.dUb();
    Object localObject = com.tencent.mm.plugin.sns.model.f.C(this.zZW.getCntMedia());
    int i;
    if (localObject != null)
    {
      localObject = com.tencent.mm.sdk.platformtools.g.aQc((String)localObject);
      float f = this.Aai / ((BitmapFactory.Options)localObject).outWidth;
      this.Aaj = ((int)(((BitmapFactory.Options)localObject).outHeight * f));
      if (this.Aaj > this.zZW.getHeight())
      {
        if (this.Aaj < this.zZW.getHeight() * 2.5D)
        {
          this.Aak = (this.Aaj - this.zZW.getHeight());
          if (this.zZW.getCount() == 1)
          {
            i = this.zZW.getHeight() * this.yuZ.height() / this.Aaj;
            this.yuZ.bottom = (i + this.yuZ.top);
            this.Aak = 0;
          }
        }
        this.Aaj = this.zZW.getHeight();
      }
    }
    this.oGo.jZ(this.Aai, this.Aaj);
    this.oGo.R(this.yuZ.left, this.yuZ.top, this.yuZ.width(), this.yuZ.height());
    if (this.Aal != 1.0D)
    {
      this.oGo.KIl = (1.0F / this.Aal);
      if ((this.Aam != 0) || (this.Aan != 0))
      {
        i = (int)(this.zZW.getWidth() / 2 * (1.0F - this.Aal));
        int j = this.Aam;
        int k = (int)(this.zZW.getHeight() / 2 + this.Aan - this.Aaj / 2 * this.Aal);
        this.oGo.kb(i + j, k);
      }
    }
    this.oGo.KIp = this.Aak;
    this.oGo.a(this.zZW, this.iUP, new e.c()new e.a
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
        SnsInfoFlip localSnsInfoFlip = SnsBrowseUI.this.zZW;
        if (localSnsInfoFlip.AdK != null) {
          localSnsInfoFlip.AdK.setVisibility(8);
        }
        SnsBrowseUI.e(SnsBrowseUI.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98501);
            Object localObject = SnsBrowseUI.this.zZW;
            if (((SnsInfoFlip)localObject).tOn != null)
            {
              localObject = ((SnsInfoFlip)localObject).tOn.getSelectedView();
              if ((localObject instanceof com.tencent.mm.ui.base.g)) {
                ((com.tencent.mm.ui.base.g)localObject).fyy();
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
        if ((SnsBrowseUI.this.zZW.getGallery() != null) && (Build.VERSION.SDK_INT >= 18)) {
          SnsBrowseUI.this.zZW.getGallery().setClipBounds(new Rect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
        }
        AppMethodBeat.o(98505);
      }
    });
    AppMethodBeat.o(98516);
  }
  
  public final void dZM() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98514);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      bWL();
      AppMethodBeat.o(98514);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98514);
    return bool;
  }
  
  protected final int ebA()
  {
    return 3;
  }
  
  public final void ebH()
  {
    AppMethodBeat.i(98517);
    final MMViewPager localMMViewPager = this.zZW.getGallery();
    localMMViewPager.setGalleryScaleListener(new MMViewPager.b()
    {
      public final void O(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        AppMethodBeat.i(98506);
        if (((SnsBrowseUI.f(SnsBrowseUI.this) == 0) || (SnsBrowseUI.g(SnsBrowseUI.this) == 0)) && (SnsBrowseUI.this.zZW != null))
        {
          SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.zZW.getHeight());
          SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.zZW.getWidth());
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
      
      public final void ah(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(98507);
        SnsBrowseUI.e(SnsBrowseUI.this, (int)paramAnonymousFloat1);
        SnsBrowseUI.f(SnsBrowseUI.this, (int)paramAnonymousFloat2);
        AppMethodBeat.o(98507);
      }
    });
    AppMethodBeat.o(98517);
  }
  
  protected final boolean ebz()
  {
    return true;
  }
  
  public final void fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(98518);
    ad.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE, paramString });
    if (this.zZW != null) {
      this.zZW.rR(true);
    }
    AppMethodBeat.o(98518);
  }
  
  public final void fb(String paramString, int paramInt)
  {
    AppMethodBeat.i(98520);
    this.Aad = paramInt;
    if (this.scene == 2)
    {
      paramString = com.tencent.mm.plugin.sns.storage.h.aAa(paramString);
      com.tencent.mm.plugin.sns.j.e.ztz.d(paramString, paramInt);
      com.tencent.mm.plugin.sns.j.e.ztz.e(paramString, paramInt);
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
    this.oGo = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    Object localObject1 = bt.bI(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.drH = bt.bI(getIntent().getStringExtra("sns_gallery_localId"), "");
    this.Aad = getIntent().getIntExtra("sns_gallery_position", 0);
    this.duC = getIntent().getIntExtra("sns_position", 0);
    this.Aae = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
    this.Aaf = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
    this.Aag = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
    this.scene = getIntent().getIntExtra("K_source", 0);
    p localp = ag.dUe().aAa(this.drH);
    this.iUP = ((ImageView)findViewById(2131300336));
    this.zZW = new SnsInfoFlip(this);
    this.zZW.setIsFromMainTimeline(this.Aae);
    this.zZW.setNeedScanImage(true);
    Object localObject2 = ak.ayZ(this.drH);
    this.zZW.setShowPageControl(true);
    this.zZW.setTouchFinish(true);
    this.zZW.setIsSoonEnterPhotoEditUI(this.Aag);
    this.zZW.a((List)localObject2, (String)localObject1, this.Aad, this.zZR, this);
    localObject1 = this.zZW;
    localObject2 = bj.frn();
    ((bj)localObject2).hbR = localp.field_createTime;
    ((SnsInfoFlip)localObject1).setFromScene((bj)localObject2);
    this.zZW.setOnPageSelectListener(this);
    addView(this.zZW);
    if ((localp != null) && (localp.QM(32))) {
      this.zZW.setIsAd(true);
    }
    this.zZX = ((Button)findViewById(2131300511));
    int i = ar.ej(this);
    localObject1 = (ViewGroup.MarginLayoutParams)this.zZX.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (i + getResources().getDimensionPixelSize(2131166829));
    this.zZX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject2 = localp.dYl();
    if (localObject2 != null)
    {
      localObject1 = ((TimeLineObject)localObject2).znQ;
      bi localbi = new bi();
      al.a(this, localbi, ((TimeLineObject)localObject2).znQ);
      if (!localbi.Anq) {
        break label525;
      }
      this.zZX.setVisibility(0);
      this.zZX.setText(localbi.Ans);
      this.zZX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98499);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          if (this.Aap.Fsy == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.sns.c.a.iRH.fw(this.Aap.Fsy.iht);
          int i = 0;
          if (this.Aaq.HAT.GaP == 1) {
            i = 2;
          }
          while (i.a(this.Aaq, SnsBrowseUI.this))
          {
            com.tencent.mm.plugin.sns.c.a.iRH.a(SnsBrowseUI.this, this.Aap.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 18, 9, this.Aap.Fsy.Fss, this.Aaq.Id);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
            if (this.Aaq.HAT.GaP == 3) {
              i = 5;
            } else if (this.Aaq.HAT.GaP == 15) {
              i = 4;
            }
          }
          switch (this.Aap.nEf)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", this.Aap.Url);
            com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject, SnsBrowseUI.this);
            com.tencent.mm.plugin.sns.c.a.iRH.a(SnsBrowseUI.this, this.Aap.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 18, 1, this.Aap.Fsy.Fss, this.Aaq.Id);
            continue;
            if (this.Aap.Scene == 1)
            {
              localObject = new ic();
              ((ic)localObject).duF.actionCode = 2;
              ((ic)localObject).duF.scene = 3;
              ((ic)localObject).duF.appId = this.Aap.Fsy.iht;
              ((ic)localObject).duF.context = SnsBrowseUI.this;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.c.a.iRH.a(SnsBrowseUI.this, this.Aap.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 18, 6, this.Aap.Fsy.Fss, this.Aaq.Id);
              continue;
              int j = al.a(SnsBrowseUI.this, this.Aap);
              if (j == 1)
              {
                localObject = new ic();
                ((ic)localObject).duF.context = SnsBrowseUI.this;
                ((ic)localObject).duF.actionCode = 2;
                ((ic)localObject).duF.appId = this.Aap.Fsy.iht;
                ((ic)localObject).duF.messageAction = this.Aap.Fsy.Fsu;
                ((ic)localObject).duF.messageExt = this.Aap.Fsy.Fst;
                ((ic)localObject).duF.scene = 3;
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                com.tencent.mm.plugin.sns.c.a.iRH.a(SnsBrowseUI.this, this.Aap.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 18, 6, this.Aap.Fsy.Fss, this.Aaq.Id);
              }
              else if (j == 2)
              {
                localObject = new ic();
                ((ic)localObject).duF.context = SnsBrowseUI.this;
                ((ic)localObject).duF.actionCode = 1;
                ((ic)localObject).duF.appId = this.Aap.Fsy.iht;
                ((ic)localObject).duF.messageAction = this.Aap.Fsy.Fsu;
                ((ic)localObject).duF.messageExt = this.Aap.Fsy.Fst;
                ((ic)localObject).duF.scene = 3;
                com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
                com.tencent.mm.plugin.sns.c.a.iRH.a(SnsBrowseUI.this, this.Aap.Fsy.iht, paramAnonymousView, this.Aaq.nDo, i, 18, 3, this.Aap.Fsy.Fss, this.Aaq.Id);
              }
            }
          }
        }
      });
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.sns.lucky.a.m.p(localp)) {
        break label537;
      }
      ad.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + localp.field_userName + " " + localp.field_snsId);
      finish();
      AppMethodBeat.o(98515);
      return;
      localObject1 = null;
      break;
      label525:
      this.zZX.setVisibility(8);
    }
    label537:
    if ((localp.field_type == 21) && (!localp.field_userName.equals(com.tencent.mm.model.u.aAm())))
    {
      this.Aah = new com.tencent.mm.pluginsdk.model.u(com.tencent.mm.loader.j.b.arO() + "/Pictures/Screenshots/", new u.a()
      {
        public final void dyR()
        {
          AppMethodBeat.i(98498);
          com.tencent.mm.plugin.sns.lucky.a.b.ma(44);
          com.tencent.mm.plugin.sns.lucky.b.a.a(4, ag.dUe().aAa(SnsBrowseUI.a(SnsBrowseUI.this)));
          AppMethodBeat.o(98498);
        }
      });
      this.Aah.start();
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
    this.oGn = paramBundle;
    AppMethodBeat.o(98509);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98510);
    int j;
    int k;
    long l3;
    SnsInfoFlip localSnsInfoFlip;
    if (this.zZW != null)
    {
      j = getIntent().getIntExtra("K_ad_scene", -1);
      k = getIntent().getIntExtra("K_ad_source", 0);
      l3 = getIntent().getLongExtra("sns_ad_exposure_start_time", 0L);
      localSnsInfoFlip = this.zZW;
      localObject1 = this.drH;
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
      localObject1 = com.tencent.mm.modelsns.e.w(getIntent());
      if (localObject1 != null)
      {
        this.zZW.getSelectCount();
        i = this.zZW.getNumOfFileExist();
        ((com.tencent.mm.modelsns.e)localObject1).pY(this.zZW.getCount()).pY(i);
        ((com.tencent.mm.modelsns.e)localObject1).update();
        ((com.tencent.mm.modelsns.e)localObject1).aLk();
      }
      ag.dUb().aD(this);
      if (this.Aae) {
        this.zZW.ecb();
      }
      if (this.Aah != null) {
        this.Aah.stop();
      }
      super.onDestroy();
      AppMethodBeat.o(98510);
      return;
      localp = ag.dUe().aAa((String)localObject1);
    } while (localp == null);
    long l1;
    long l2;
    if (localSnsInfoFlip.zZY >= 0)
    {
      if (!localSnsInfoFlip.AdC.containsKey(Integer.valueOf(localSnsInfoFlip.zZY))) {
        break label622;
      }
      l1 = ((Long)localSnsInfoFlip.AdC.get(Integer.valueOf(localSnsInfoFlip.zZY))).longValue();
      if (l1 > 0L)
      {
        if (!localSnsInfoFlip.AdD.containsKey(Integer.valueOf(localSnsInfoFlip.zZY))) {
          break label628;
        }
        l2 = ((Long)localSnsInfoFlip.AdD.get(Integer.valueOf(localSnsInfoFlip.zZY))).longValue();
        label310:
        l1 = bt.aO(l1);
        l2 += l1;
        localSnsInfoFlip.AdD.put(Integer.valueOf(localSnsInfoFlip.zZY), Long.valueOf(l2));
        ad.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + localSnsInfoFlip.zZY + " curtime " + l2 + " passtime " + l1);
      }
    }
    com.tencent.mm.plugin.sns.storage.e locale = localp.dYU();
    label413:
    label455:
    Integer localInteger;
    int m;
    if (k == 2)
    {
      localp.dYi();
      localObject1 = new StringBuffer();
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject1).append("<desc>");
      Iterator localIterator = localSnsInfoFlip.AdB.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label648;
      }
      localInteger = (Integer)localIterator.next();
      m = ((Integer)localSnsInfoFlip.AdB.get(localInteger)).intValue();
      if (!localSnsInfoFlip.AdD.containsKey(localInteger)) {
        break label643;
      }
    }
    label643:
    for (int i = (int)(((Long)localSnsInfoFlip.AdD.get(localInteger)).longValue() * 1L);; i = 0)
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
      localp.dRK();
      break label413;
    }
    label648:
    ((StringBuffer)localObject1).append("</desc>");
    Object localObject2 = ((StringBuffer)localObject2).toString();
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("&")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    if ((localp == null) || (!localp.dWk())) {
      ag.dTY().f(12014, new Object[] { com.tencent.mm.plugin.sns.ad.d.h.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId), localp.dYT(), Integer.valueOf(j), Long.valueOf(localSnsInfoFlip.AdO), Long.valueOf(System.currentTimeMillis()), localObject1, Integer.valueOf(localSnsInfoFlip.getCount()) }) });
    }
    if (!locale.dRL().dVZ()) {
      if (k != 0) {
        break label943;
      }
    }
    label943:
    for (i = 1;; i = 2)
    {
      localObject2 = new SnsAdClick(k, i, localp.field_snsId, 6, 0);
      ((SnsAdClick)localObject2).ina = l3;
      com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
      localObject2 = com.tencent.mm.modelsns.e.pV(729);
      ((com.tencent.mm.modelsns.e)localObject2).Gs(com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId)).Gs(localp.dYT()).pY(j).Gs(localSnsInfoFlip.AdO).Gs(System.currentTimeMillis()).Gs((String)localObject1).pY(localSnsInfoFlip.getCount());
      ((com.tencent.mm.modelsns.e)localObject2).aLk();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98511);
    if (this.zZW != null) {
      this.zZW.onPause();
    }
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(98511);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98512);
    super.onResume();
    if (this.zZW != null) {
      this.zZW.rR(false);
    }
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    AppMethodBeat.o(98512);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98513);
    Bundle localBundle = this.oGn;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.yuZ = ((Rect)getIntent().getParcelableExtra("sns_gallery_thumb_location"));
        if (this.yuZ == null) {
          this.yuZ = new Rect();
        }
        this.oGo.R(this.yuZ.left, this.yuZ.top, this.yuZ.width(), this.yuZ.height());
        if (localBundle == null) {
          this.zZW.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98500);
              SnsBrowseUI.this.zZW.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.zZW.getWidth());
              SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.zZW.getHeight());
              SnsBrowseUI.c(SnsBrowseUI.this, SnsBrowseUI.this.zZW.getWidth());
              SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.zZW.getHeight());
              ag.dUb();
              Object localObject = com.tencent.mm.plugin.sns.model.f.C(SnsBrowseUI.this.zZW.getCntMedia());
              if (localObject != null)
              {
                localObject = com.tencent.mm.sdk.platformtools.g.aQc((String)localObject);
                SnsBrowseUI localSnsBrowseUI = SnsBrowseUI.this;
                float f = SnsBrowseUI.b(SnsBrowseUI.this) / ((BitmapFactory.Options)localObject).outWidth;
                SnsBrowseUI.d(localSnsBrowseUI, (int)(((BitmapFactory.Options)localObject).outHeight * f));
                if (SnsBrowseUI.c(SnsBrowseUI.this) > SnsBrowseUI.this.zZW.getHeight()) {
                  SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.zZW.getHeight());
                }
              }
              SnsBrowseUI.this.oGo.jZ(SnsBrowseUI.b(SnsBrowseUI.this), SnsBrowseUI.c(SnsBrowseUI.this));
              SnsBrowseUI.this.oGo.a(SnsBrowseUI.this.zZW, SnsBrowseUI.d(SnsBrowseUI.this), null);
              SnsBrowseUI.this.ebH();
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