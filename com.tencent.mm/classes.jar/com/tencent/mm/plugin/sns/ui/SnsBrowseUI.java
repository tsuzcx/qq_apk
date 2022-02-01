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
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.ic.b;
import com.tencent.mm.g.a.id;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.u.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
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
  private int ArA;
  private int Arq;
  private boolean Arr;
  private boolean Ars;
  private boolean Art;
  private u Aru;
  private int Arv;
  private int Arw;
  private int Arx;
  private float Ary;
  private int Arz;
  private String dsN;
  private int dvH;
  private ImageView iXI;
  private boolean isAnimated;
  private int lxZ;
  private int lya;
  private aq mHandler;
  Bundle oMP;
  com.tencent.mm.ui.tools.e oMQ;
  private int scene;
  private Rect yKZ;
  
  public SnsBrowseUI()
  {
    AppMethodBeat.i(98508);
    this.Arq = 0;
    this.dvH = 0;
    this.Arr = false;
    this.Ars = false;
    this.Art = false;
    this.isAnimated = false;
    this.lxZ = 0;
    this.lya = 0;
    this.mHandler = new aq();
    this.Arx = 0;
    this.scene = 0;
    this.Ary = 1.0F;
    this.Arz = 0;
    this.ArA = 0;
    AppMethodBeat.o(98508);
  }
  
  public final void bYa()
  {
    AppMethodBeat.i(98516);
    if (this.yKZ == null) {
      this.yKZ = new Rect();
    }
    if (!this.Ars)
    {
      localObject = new ic();
      ((ic)localObject).dvF.dvI = this.Arj.getGallery().getCurrentItem();
      ((ic)localObject).dvF.dvH = this.dvH;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      this.yKZ.left = ((ic)localObject).dvG.dnb;
      this.yKZ.top = ((ic)localObject).dvG.dnc;
      this.yKZ.right = (((ic)localObject).dvG.dnd + this.yKZ.left);
      this.yKZ.bottom = (((ic)localObject).dvG.dne + this.yKZ.top);
    }
    this.Arv = this.Arj.getWidth();
    this.Arw = this.Arj.getHeight();
    ah.dXB();
    Object localObject = com.tencent.mm.plugin.sns.model.g.C(this.Arj.getCntMedia());
    int i;
    if (localObject != null)
    {
      localObject = com.tencent.mm.sdk.platformtools.h.aRz((String)localObject);
      float f = this.Arv / ((BitmapFactory.Options)localObject).outWidth;
      this.Arw = ((int)(((BitmapFactory.Options)localObject).outHeight * f));
      if (this.Arw > this.Arj.getHeight())
      {
        if (this.Arw < this.Arj.getHeight() * 2.5D)
        {
          this.Arx = (this.Arw - this.Arj.getHeight());
          if (this.Arj.getCount() == 1)
          {
            i = this.Arj.getHeight() * this.yKZ.height() / this.Arw;
            this.yKZ.bottom = (i + this.yKZ.top);
            this.Arx = 0;
          }
        }
        this.Arw = this.Arj.getHeight();
      }
    }
    this.oMQ.kg(this.Arv, this.Arw);
    this.oMQ.R(this.yKZ.left, this.yKZ.top, this.yKZ.width(), this.yKZ.height());
    if (this.Ary != 1.0D)
    {
      this.oMQ.LeF = (1.0F / this.Ary);
      if ((this.Arz != 0) || (this.ArA != 0))
      {
        i = (int)(this.Arj.getWidth() / 2 * (1.0F - this.Ary));
        int j = this.Arz;
        int k = (int)(this.Arj.getHeight() / 2 + this.ArA - this.Arw / 2 * this.Ary);
        this.oMQ.ki(i + j, k);
      }
    }
    this.oMQ.LeJ = this.Arx;
    this.oMQ.a(this.Arj, this.iXI, new e.c()new e.a
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
        SnsInfoFlip localSnsInfoFlip = SnsBrowseUI.this.Arj;
        if (localSnsInfoFlip.AuW != null) {
          localSnsInfoFlip.AuW.setVisibility(8);
        }
        SnsBrowseUI.e(SnsBrowseUI.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98501);
            Object localObject = SnsBrowseUI.this.Arj;
            if (((SnsInfoFlip)localObject).tZe != null)
            {
              localObject = ((SnsInfoFlip)localObject).tZe.getSelectedView();
              if ((localObject instanceof com.tencent.mm.ui.base.g)) {
                ((com.tencent.mm.ui.base.g)localObject).fCA();
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
        if ((SnsBrowseUI.this.Arj.getGallery() != null) && (Build.VERSION.SDK_INT >= 18)) {
          SnsBrowseUI.this.Arj.getGallery().setClipBounds(new Rect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
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
      ae.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      bYa();
      AppMethodBeat.o(98514);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98514);
    return bool;
  }
  
  public final void eds() {}
  
  protected final boolean efg()
  {
    return true;
  }
  
  protected final int efh()
  {
    return 3;
  }
  
  public final void efo()
  {
    AppMethodBeat.i(98517);
    final MMViewPager localMMViewPager = this.Arj.getGallery();
    localMMViewPager.setGalleryScaleListener(new MMViewPager.b()
    {
      public final void O(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        AppMethodBeat.i(98506);
        if (((SnsBrowseUI.f(SnsBrowseUI.this) == 0) || (SnsBrowseUI.g(SnsBrowseUI.this) == 0)) && (SnsBrowseUI.this.Arj != null))
        {
          SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.Arj.getHeight());
          SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.Arj.getWidth());
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
  
  public final void fj(String paramString, int paramInt)
  {
    AppMethodBeat.i(98518);
    ae.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE, paramString });
    if (this.Arj != null) {
      this.Arj.rY(true);
    }
    AppMethodBeat.o(98518);
  }
  
  public final void fk(String paramString, int paramInt)
  {
    AppMethodBeat.i(98520);
    this.Arq = paramInt;
    if (this.scene == 2)
    {
      paramString = com.tencent.mm.plugin.sns.storage.h.aBr(paramString);
      com.tencent.mm.plugin.sns.j.e.zKO.d(paramString, paramInt);
      com.tencent.mm.plugin.sns.j.e.zKO.e(paramString, paramInt);
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
    this.oMQ = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    Object localObject1 = bu.bI(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.dsN = bu.bI(getIntent().getStringExtra("sns_gallery_localId"), "");
    this.Arq = getIntent().getIntExtra("sns_gallery_position", 0);
    this.dvH = getIntent().getIntExtra("sns_position", 0);
    this.Arr = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
    this.Ars = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
    this.Art = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
    this.scene = getIntent().getIntExtra("K_source", 0);
    p localp = ah.dXE().aBr(this.dsN);
    this.iXI = ((ImageView)findViewById(2131300336));
    this.Arj = new SnsInfoFlip(this);
    this.Arj.setIsFromMainTimeline(this.Arr);
    this.Arj.setNeedScanImage(true);
    Object localObject2 = com.tencent.mm.plugin.sns.model.al.aAq(this.dsN);
    this.Arj.setShowPageControl(true);
    this.Arj.setTouchFinish(true);
    this.Arj.setIsSoonEnterPhotoEditUI(this.Art);
    this.Arj.a((List)localObject2, (String)localObject1, this.Arq, this.Are, this);
    localObject1 = this.Arj;
    localObject2 = bk.fvn();
    ((bk)localObject2).heF = localp.field_createTime;
    ((SnsInfoFlip)localObject1).setFromScene((bk)localObject2);
    this.Arj.setOnPageSelectListener(this);
    addView(this.Arj);
    if ((localp != null) && (localp.Rt(32))) {
      this.Arj.setIsAd(true);
    }
    this.Ark = ((Button)findViewById(2131300511));
    int i = ar.en(this);
    localObject1 = (ViewGroup.MarginLayoutParams)this.Ark.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (i + getResources().getDimensionPixelSize(2131166829));
    this.Ark.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject2 = localp.ebP();
    if (localObject2 != null)
    {
      localObject1 = ((TimeLineObject)localObject2).zFf;
      bi localbi = new bi();
      al.a(this, localbi, ((TimeLineObject)localObject2).zFf);
      if (!localbi.AEE) {
        break label525;
      }
      this.Ark.setVisibility(0);
      this.Ark.setText(localbi.AEF);
      this.Ark.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98499);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          if (this.ArC.FKW == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
          }
          paramAnonymousView = com.tencent.mm.plugin.sns.c.a.iUA.fC(this.ArC.FKW.ikm);
          int i = 0;
          if (this.ArD.HUG.Gtw == 1) {
            i = 2;
          }
          while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.ArD, SnsBrowseUI.this))
          {
            com.tencent.mm.plugin.sns.c.a.iUA.a(SnsBrowseUI.this, this.ArC.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 18, 9, this.ArC.FKW.FKQ, this.ArD.Id);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
            if (this.ArD.HUG.Gtw == 3) {
              i = 5;
            } else if (this.ArD.HUG.Gtw == 15) {
              i = 4;
            }
          }
          switch (this.ArC.nJA)
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98499);
            return;
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", this.ArC.Url);
            com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject, SnsBrowseUI.this);
            com.tencent.mm.plugin.sns.c.a.iUA.a(SnsBrowseUI.this, this.ArC.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 18, 1, this.ArC.FKW.FKQ, this.ArD.Id);
            continue;
            if (this.ArC.Scene == 1)
            {
              localObject = new id();
              ((id)localObject).dvK.actionCode = 2;
              ((id)localObject).dvK.scene = 3;
              ((id)localObject).dvK.appId = this.ArC.FKW.ikm;
              ((id)localObject).dvK.context = SnsBrowseUI.this;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.c.a.iUA.a(SnsBrowseUI.this, this.ArC.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 18, 6, this.ArC.FKW.FKQ, this.ArD.Id);
              continue;
              int j = al.a(SnsBrowseUI.this, this.ArC);
              if (j == 1)
              {
                localObject = new id();
                ((id)localObject).dvK.context = SnsBrowseUI.this;
                ((id)localObject).dvK.actionCode = 2;
                ((id)localObject).dvK.appId = this.ArC.FKW.ikm;
                ((id)localObject).dvK.messageAction = this.ArC.FKW.FKS;
                ((id)localObject).dvK.messageExt = this.ArC.FKW.FKR;
                ((id)localObject).dvK.scene = 3;
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                com.tencent.mm.plugin.sns.c.a.iUA.a(SnsBrowseUI.this, this.ArC.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 18, 6, this.ArC.FKW.FKQ, this.ArD.Id);
              }
              else if (j == 2)
              {
                localObject = new id();
                ((id)localObject).dvK.context = SnsBrowseUI.this;
                ((id)localObject).dvK.actionCode = 1;
                ((id)localObject).dvK.appId = this.ArC.FKW.ikm;
                ((id)localObject).dvK.messageAction = this.ArC.FKW.FKS;
                ((id)localObject).dvK.messageExt = this.ArC.FKW.FKR;
                ((id)localObject).dvK.scene = 3;
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
                com.tencent.mm.plugin.sns.c.a.iUA.a(SnsBrowseUI.this, this.ArC.FKW.ikm, paramAnonymousView, this.ArD.nIJ, i, 18, 3, this.ArC.FKW.FKQ, this.ArD.Id);
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
      ae.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + localp.field_userName + " " + localp.field_snsId);
      finish();
      AppMethodBeat.o(98515);
      return;
      localObject1 = null;
      break;
      label525:
      this.Ark.setVisibility(8);
    }
    label537:
    if ((localp.field_type == 21) && (!localp.field_userName.equals(v.aAC())))
    {
      this.Aru = new u(com.tencent.mm.loader.j.b.asd() + "/Pictures/Screenshots/", new u.a()
      {
        public final void dCi()
        {
          AppMethodBeat.i(98498);
          com.tencent.mm.plugin.sns.lucky.a.b.md(44);
          com.tencent.mm.plugin.sns.lucky.b.a.a(4, ah.dXE().aBr(SnsBrowseUI.a(SnsBrowseUI.this)));
          AppMethodBeat.o(98498);
        }
      });
      this.Aru.start();
    }
    AppMethodBeat.o(98515);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98519);
    ae.i("MicroMsg.SnsPopMediasUI", "onActivityResult requestCode:".concat(String.valueOf(paramInt1)));
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
    this.oMP = paramBundle;
    AppMethodBeat.o(98509);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98510);
    int j;
    int k;
    long l3;
    SnsInfoFlip localSnsInfoFlip;
    if (this.Arj != null)
    {
      j = getIntent().getIntExtra("K_ad_scene", -1);
      k = getIntent().getIntExtra("K_ad_source", 0);
      l3 = getIntent().getLongExtra("sns_ad_exposure_start_time", 0L);
      localSnsInfoFlip = this.Arj;
      localObject1 = this.dsN;
      if (localSnsInfoFlip.isAd)
      {
        if (j >= 0) {
          break label194;
        }
        ae.i("MicroMsg.SnsInfoFlip", "pass by scene ".concat(String.valueOf(j)));
      }
    }
    label194:
    p localp;
    do
    {
      localObject1 = com.tencent.mm.modelsns.e.w(getIntent());
      if (localObject1 != null)
      {
        this.Arj.getSelectCount();
        i = this.Arj.getNumOfFileExist();
        ((com.tencent.mm.modelsns.e)localObject1).qb(this.Arj.getCount()).qb(i);
        ((com.tencent.mm.modelsns.e)localObject1).update();
        ((com.tencent.mm.modelsns.e)localObject1).aLH();
      }
      ah.dXB().aE(this);
      if (this.Arr) {
        this.Arj.efI();
      }
      if (this.Aru != null) {
        this.Aru.stop();
      }
      super.onDestroy();
      AppMethodBeat.o(98510);
      return;
      localp = ah.dXE().aBr((String)localObject1);
    } while (localp == null);
    long l1;
    long l2;
    if (localSnsInfoFlip.Arl >= 0)
    {
      if (!localSnsInfoFlip.AuO.containsKey(Integer.valueOf(localSnsInfoFlip.Arl))) {
        break label622;
      }
      l1 = ((Long)localSnsInfoFlip.AuO.get(Integer.valueOf(localSnsInfoFlip.Arl))).longValue();
      if (l1 > 0L)
      {
        if (!localSnsInfoFlip.AuP.containsKey(Integer.valueOf(localSnsInfoFlip.Arl))) {
          break label628;
        }
        l2 = ((Long)localSnsInfoFlip.AuP.get(Integer.valueOf(localSnsInfoFlip.Arl))).longValue();
        label310:
        l1 = bu.aO(l1);
        l2 += l1;
        localSnsInfoFlip.AuP.put(Integer.valueOf(localSnsInfoFlip.Arl), Long.valueOf(l2));
        ae.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + localSnsInfoFlip.Arl + " curtime " + l2 + " passtime " + l1);
      }
    }
    com.tencent.mm.plugin.sns.storage.e locale = localp.ecy();
    label413:
    label455:
    Integer localInteger;
    int m;
    if (k == 2)
    {
      localp.ebM();
      localObject1 = new StringBuffer();
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject1).append("<desc>");
      Iterator localIterator = localSnsInfoFlip.AuN.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label648;
      }
      localInteger = (Integer)localIterator.next();
      m = ((Integer)localSnsInfoFlip.AuN.get(localInteger)).intValue();
      if (!localSnsInfoFlip.AuP.containsKey(localInteger)) {
        break label643;
      }
    }
    label643:
    for (int i = (int)(((Long)localSnsInfoFlip.AuP.get(localInteger)).longValue() * 1L);; i = 0)
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
      localp.dVi();
      break label413;
    }
    label648:
    ((StringBuffer)localObject1).append("</desc>");
    Object localObject2 = ((StringBuffer)localObject2).toString();
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("&")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    if ((localp == null) || (!localp.dZL())) {
      ah.dXy().f(12014, new Object[] { com.tencent.mm.plugin.sns.ad.e.i.a(localp.field_snsId, new Object[] { r.zV(localp.field_snsId), localp.ecx(), Integer.valueOf(j), Long.valueOf(localSnsInfoFlip.Ava), Long.valueOf(System.currentTimeMillis()), localObject1, Integer.valueOf(localSnsInfoFlip.getCount()) }) });
    }
    if (!locale.dVj().dZA()) {
      if (k != 0) {
        break label943;
      }
    }
    label943:
    for (i = 1;; i = 2)
    {
      localObject2 = new SnsAdClick(k, i, localp.field_snsId, 6, 0);
      ((SnsAdClick)localObject2).ipU = l3;
      r.a((SnsAdClick)localObject2);
      localObject2 = com.tencent.mm.modelsns.e.pY(729);
      ((com.tencent.mm.modelsns.e)localObject2).GU(r.zV(localp.field_snsId)).GU(localp.ecx()).qb(j).GU(localSnsInfoFlip.Ava).GU(System.currentTimeMillis()).GU((String)localObject1).qb(localSnsInfoFlip.getCount());
      ((com.tencent.mm.modelsns.e)localObject2).aLH();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98511);
    if (this.Arj != null) {
      this.Arj.onPause();
    }
    super.onPause();
    f.e(false, true, true);
    AppMethodBeat.o(98511);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98512);
    super.onResume();
    if (this.Arj != null) {
      this.Arj.rY(false);
    }
    f.e(true, true, true);
    AppMethodBeat.o(98512);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98513);
    Bundle localBundle = this.oMP;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.yKZ = ((Rect)getIntent().getParcelableExtra("sns_gallery_thumb_location"));
        if (this.yKZ == null) {
          this.yKZ = new Rect();
        }
        this.oMQ.R(this.yKZ.left, this.yKZ.top, this.yKZ.width(), this.yKZ.height());
        if (localBundle == null) {
          this.Arj.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98500);
              SnsBrowseUI.this.Arj.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.Arj.getWidth());
              SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.Arj.getHeight());
              SnsBrowseUI.c(SnsBrowseUI.this, SnsBrowseUI.this.Arj.getWidth());
              SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.Arj.getHeight());
              ah.dXB();
              Object localObject = com.tencent.mm.plugin.sns.model.g.C(SnsBrowseUI.this.Arj.getCntMedia());
              if (localObject != null)
              {
                localObject = com.tencent.mm.sdk.platformtools.h.aRz((String)localObject);
                SnsBrowseUI localSnsBrowseUI = SnsBrowseUI.this;
                float f = SnsBrowseUI.b(SnsBrowseUI.this) / ((BitmapFactory.Options)localObject).outWidth;
                SnsBrowseUI.d(localSnsBrowseUI, (int)(((BitmapFactory.Options)localObject).outHeight * f));
                if (SnsBrowseUI.c(SnsBrowseUI.this) > SnsBrowseUI.this.Arj.getHeight()) {
                  SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.Arj.getHeight());
                }
              }
              SnsBrowseUI.this.oMQ.kg(SnsBrowseUI.b(SnsBrowseUI.this), SnsBrowseUI.c(SnsBrowseUI.this));
              SnsBrowseUI.this.oMQ.a(SnsBrowseUI.this.Arj, SnsBrowseUI.d(SnsBrowseUI.this), null);
              SnsBrowseUI.this.efo();
              AppMethodBeat.o(98500);
              return true;
            }
          });
        }
      }
    }
    super.onStart();
    ae.d("MicroMsg.SnsPopMediasUI", "onStart ");
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