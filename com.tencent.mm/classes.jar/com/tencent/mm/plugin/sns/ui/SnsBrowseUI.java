package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.autogen.a.ki;
import com.tencent.mm.autogen.a.ki.b;
import com.tencent.mm.autogen.a.kj;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.g.n;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.pluginsdk.model.ab;
import com.tencent.mm.pluginsdk.model.ab.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.c;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.bf;
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
  implements z.a
{
  private Rect Pdg;
  private int RnZ;
  private boolean Roa;
  private boolean Rob;
  private boolean Roc;
  private ab Rod;
  private int Roe;
  private int Rof;
  private int Rog;
  private float Roh;
  private int Roi;
  private int Roj;
  private String hHB;
  private int hLW;
  private String hQX;
  private boolean isAnimated;
  private MMHandler mHandler;
  private ImageView pIB;
  private int pvg;
  private int sJv;
  private int scene;
  Bundle wAX;
  com.tencent.mm.ui.tools.f wAY;
  
  public SnsBrowseUI()
  {
    AppMethodBeat.i(98508);
    this.RnZ = 0;
    this.hLW = 0;
    this.Roa = false;
    this.Rob = false;
    this.Roc = false;
    this.isAnimated = false;
    this.sJv = 0;
    this.pvg = 0;
    this.mHandler = new MMHandler();
    this.Rog = 0;
    this.scene = 0;
    this.Roh = 1.0F;
    this.Roi = 0;
    this.Roj = 0;
    AppMethodBeat.o(98508);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98514);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
      if ((this.RnL != null) && (this.RnL.getVisibility() == 0))
      {
        long l = 0L;
        if (this.RnH != null) {
          l = this.RnH.GYk.longValue();
        }
        this.RnL.P(l, false);
        AppMethodBeat.o(98514);
        return true;
      }
      setResult(-1, new Intent());
      hoc();
      dmJ();
      AppMethodBeat.o(98514);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98514);
    return bool;
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(98516);
    if (this.Pdg == null) {
      this.Pdg = new Rect();
    }
    if (!this.Rob)
    {
      localObject = new ki();
      ((ki)localObject).hLU.hLX = this.RnH.getGallery().getCurrentItem();
      ((ki)localObject).hLU.hLW = this.hLW;
      ((ki)localObject).publish();
      this.Pdg.left = ((ki)localObject).hLV.hBJ;
      this.Pdg.top = ((ki)localObject).hLV.hBK;
      this.Pdg.right = (((ki)localObject).hLV.hBL + this.Pdg.left);
      this.Pdg.bottom = (((ki)localObject).hLV.hBM + this.Pdg.top);
    }
    this.Roe = this.RnH.getWidth();
    this.Rof = this.RnH.getHeight();
    al.hgy();
    Object localObject = g.D(this.RnH.getCntMedia());
    int i;
    if (localObject != null)
    {
      localObject = BitmapUtil.getImageOptions((String)localObject);
      float f = this.Roe / ((BitmapFactory.Options)localObject).outWidth;
      this.Rof = ((int)(((BitmapFactory.Options)localObject).outHeight * f));
      if (this.Rof > this.RnH.getHeight())
      {
        if (this.Rof < this.RnH.getHeight() * 2.5D)
        {
          this.Rog = (this.Rof - this.RnH.getHeight());
          if (this.RnH.getCount() == 1)
          {
            i = this.RnH.getHeight() * this.Pdg.height() / this.Rof;
            this.Pdg.bottom = (i + this.Pdg.top);
            this.Rog = 0;
          }
        }
        this.Rof = this.RnH.getHeight();
      }
    }
    this.wAY.oC(this.Roe, this.Rof);
    this.wAY.af(this.Pdg.left, this.Pdg.top, this.Pdg.width(), this.Pdg.height());
    if (this.Roh != 1.0D)
    {
      this.wAY.afIg = (1.0F / this.Roh);
      if ((this.Roi != 0) || (this.Roj != 0))
      {
        i = (int)(this.RnH.getWidth() / 2 * (1.0F - this.Roh));
        int j = this.Roi;
        int k = (int)(this.RnH.getHeight() / 2 + this.Roj - this.Rof / 2 * this.Roh);
        this.wAY.oE(i + j, k);
      }
    }
    this.wAY.afIk = this.Rog;
    this.wAY.a(this.RnH, this.pIB, new f.c()new f.a
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
        SnsInfoFlip localSnsInfoFlip = SnsBrowseUI.this.RnH;
        if (localSnsInfoFlip.RrY != null) {
          localSnsInfoFlip.RrY.setVisibility(8);
        }
        SnsBrowseUI.e(SnsBrowseUI.this).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98501);
            Object localObject = SnsBrowseUI.this.RnH;
            if (((SnsInfoFlip)localObject).HOP != null)
            {
              localObject = ((SnsInfoFlip)localObject).HOP.getSelectedView();
              if ((localObject instanceof i)) {
                ((i)localObject).jma();
              }
            }
            AppMethodBeat.o(98501);
          }
        }, 20L);
        AppMethodBeat.o(98503);
      }
    }, new f.a()
    {
      public final void Z(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(98505);
        if ((SnsBrowseUI.this.RnH.getGallery() != null) && (Build.VERSION.SDK_INT >= 18)) {
          SnsBrowseUI.this.RnH.getGallery().setClipBounds(new Rect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
        }
        AppMethodBeat.o(98505);
      }
    });
    AppMethodBeat.o(98516);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_browse_img;
  }
  
  public final void hf(String paramString, int paramInt)
  {
    AppMethodBeat.i(98518);
    Log.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE, paramString });
    if (this.RnH != null) {
      this.RnH.Ei(true);
    }
    AppMethodBeat.o(98518);
  }
  
  public final void hg(String paramString, int paramInt)
  {
    AppMethodBeat.i(98520);
    this.RnZ = paramInt;
    if (this.scene == 2)
    {
      paramString = com.tencent.mm.plugin.sns.storage.l.aZL(paramString);
      j.QFS.f(paramString, paramInt);
      j.QFS.g(paramString, paramInt);
    }
    AppMethodBeat.o(98520);
  }
  
  public final void hma() {}
  
  protected final boolean hod()
  {
    return true;
  }
  
  protected final int hoe()
  {
    return 3;
  }
  
  protected final int hof()
  {
    return 3;
  }
  
  public final void hon()
  {
    AppMethodBeat.i(98517);
    final MMViewPager localMMViewPager = this.RnH.getGallery();
    localMMViewPager.setGalleryScaleListener(new MMViewPager.c()
    {
      public final void aW(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(98507);
        SnsBrowseUI.e(SnsBrowseUI.this, (int)paramAnonymousFloat1);
        SnsBrowseUI.f(SnsBrowseUI.this, (int)paramAnonymousFloat2);
        AppMethodBeat.o(98507);
      }
      
      public final void onGalleryScale(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        AppMethodBeat.i(98506);
        if (((SnsBrowseUI.f(SnsBrowseUI.this) == 0) || (SnsBrowseUI.g(SnsBrowseUI.this) == 0)) && (SnsBrowseUI.this.RnH != null))
        {
          SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.RnH.getHeight());
          SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.RnH.getWidth());
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
    });
    AppMethodBeat.o(98517);
  }
  
  public void initView()
  {
    AppMethodBeat.i(98515);
    this.wAY = new com.tencent.mm.ui.tools.f(getContext());
    this.isAnimated = false;
    Object localObject2 = Util.nullAs(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.hHB = Util.nullAs(getIntent().getStringExtra("sns_gallery_localId"), "");
    this.hQX = Util.nullAs(getIntent().getStringExtra("sns_gallery_pcid"), "");
    this.RnZ = getIntent().getIntExtra("sns_gallery_position", 0);
    this.hLW = getIntent().getIntExtra("sns_position", 0);
    this.Roa = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
    this.Rob = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
    this.Roc = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
    this.scene = getIntent().getIntExtra("K_source", 0);
    SnsInfo localSnsInfo = al.hgB().aZL(this.hHB);
    if (localSnsInfo == null) {
      localSnsInfo = al.hgB().aZK(this.hQX);
    }
    for (;;)
    {
      this.pIB = ((ImageView)findViewById(b.f.gallery_bg));
      this.RnH = new SnsInfoFlip(this);
      this.RnH.setIsFromMainTimeline(this.Roa);
      this.RnH.setNeedScanImage(true);
      Object localObject1 = ap.aYx(this.hHB);
      if (this.hHB.equals("")) {
        localObject1 = ap.aYy(this.hQX);
      }
      this.RnH.setShowPageControl(true);
      this.RnH.setTouchFinish(true);
      this.RnH.setIsSoonEnterPhotoEditUI(this.Roc);
      this.RnH.a((List)localObject1, (String)localObject2, this.RnZ, this.RnC, this);
      localObject1 = this.RnH;
      localObject2 = br.jbh();
      ((br)localObject2).time = localSnsInfo.field_createTime;
      ((SnsInfoFlip)localObject1).setFromScene((br)localObject2);
      this.RnH.setUIFromScene(getFromScene());
      this.RnH.setOnPageSelectListener(this);
      addView(this.RnH);
      if ((localSnsInfo != null) && (localSnsInfo.isAd())) {
        this.RnH.setIsAd(true);
      }
      this.RnI = ((Button)findViewById(b.f.game_more_button));
      int i = bf.bk(this);
      localObject1 = (ViewGroup.MarginLayoutParams)this.RnI.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (i + getResources().getDimensionPixelSize(b.d.sns_game_more_button_bottom_margin));
      this.RnI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject2 = localSnsInfo.getTimeLine();
      if (localObject2 != null)
      {
        localObject1 = ((TimeLineObject)localObject2).actionInfo;
        bo localbo = new bo();
        ar.a(this, localbo, ((TimeLineObject)localObject2).actionInfo);
        if (!localbo.RCf) {
          break label589;
        }
        this.RnI.setVisibility(0);
        this.RnI.setText(localbo.RCg);
        this.RnI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98499);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if (this.Rol.YCC == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98499);
              return;
            }
            paramAnonymousView = com.tencent.mm.plugin.sns.d.a.pFo.iz(this.Rol.YCC.oOI);
            int i = 0;
            if (this.Rom.ContentObj.Zpq == 1) {
              i = 2;
            }
            while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(this.Rom, SnsBrowseUI.this))
            {
              com.tencent.mm.plugin.sns.d.a.pFo.a(SnsBrowseUI.this, this.Rol.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 18, 9, this.Rol.YCC.YCm, this.Rom.Id);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98499);
              return;
              if (this.Rom.ContentObj.Zpq == 3) {
                i = 5;
              } else if (this.Rom.ContentObj.Zpq == 15) {
                i = 4;
              }
            }
            switch (this.Rol.vhJ)
            {
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsBrowseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98499);
              return;
              localObject = new Intent();
              ((Intent)localObject).putExtra("rawUrl", this.Rol.Url);
              com.tencent.mm.plugin.sns.d.a.pFn.h((Intent)localObject, SnsBrowseUI.this);
              com.tencent.mm.plugin.sns.d.a.pFo.a(SnsBrowseUI.this, this.Rol.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 18, 1, this.Rol.YCC.YCm, this.Rom.Id);
              continue;
              if (this.Rol.IJG == 1)
              {
                localObject = new kj();
                ((kj)localObject).hLZ.actionCode = 2;
                ((kj)localObject).hLZ.scene = 3;
                ((kj)localObject).hLZ.appId = this.Rol.YCC.oOI;
                ((kj)localObject).hLZ.context = SnsBrowseUI.this;
                ((kj)localObject).publish();
                com.tencent.mm.plugin.sns.d.a.pFo.a(SnsBrowseUI.this, this.Rol.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 18, 6, this.Rol.YCC.YCm, this.Rom.Id);
                continue;
                int j = ar.b(SnsBrowseUI.this, this.Rol);
                if (j == 1)
                {
                  localObject = new kj();
                  ((kj)localObject).hLZ.context = SnsBrowseUI.this;
                  ((kj)localObject).hLZ.actionCode = 2;
                  ((kj)localObject).hLZ.appId = this.Rol.YCC.oOI;
                  ((kj)localObject).hLZ.messageAction = this.Rol.YCC.YCo;
                  ((kj)localObject).hLZ.messageExt = this.Rol.YCC.YCn;
                  ((kj)localObject).hLZ.scene = 3;
                  ((kj)localObject).publish();
                  com.tencent.mm.plugin.sns.d.a.pFo.a(SnsBrowseUI.this, this.Rol.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 18, 6, this.Rol.YCC.YCm, this.Rom.Id);
                }
                else if (j == 2)
                {
                  localObject = new kj();
                  ((kj)localObject).hLZ.context = SnsBrowseUI.this;
                  ((kj)localObject).hLZ.actionCode = 1;
                  ((kj)localObject).hLZ.appId = this.Rol.YCC.oOI;
                  ((kj)localObject).hLZ.messageAction = this.Rol.YCC.YCo;
                  ((kj)localObject).hLZ.messageExt = this.Rol.YCC.YCn;
                  ((kj)localObject).hLZ.scene = 3;
                  ((kj)localObject).publish();
                  com.tencent.mm.plugin.sns.d.a.pFo.a(SnsBrowseUI.this, this.Rol.YCC.oOI, paramAnonymousView, this.Rom.UserName, i, 18, 3, this.Rol.YCC.YCm, this.Rom.Id);
                }
              }
            }
          }
        });
      }
      for (;;)
      {
        if (com.tencent.mm.plugin.sns.lucky.a.m.y(localSnsInfo)) {
          break label601;
        }
        Log.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + localSnsInfo.getUserName() + " " + localSnsInfo.field_snsId);
        finish();
        AppMethodBeat.o(98515);
        return;
        localObject1 = null;
        break;
        label589:
        this.RnI.setVisibility(8);
      }
      label601:
      if ((localSnsInfo.getTypeFlag() == 21) && (!localSnsInfo.getUserName().equals(z.bAM())))
      {
        this.Rod = new ab(com.tencent.mm.loader.i.b.bmt() + "/Pictures/Screenshots/", new ab.a()
        {
          public final void gzf()
          {
            AppMethodBeat.i(98498);
            if (SnsBrowseUI.a(SnsBrowseUI.this).equals(""))
            {
              AppMethodBeat.o(98498);
              return;
            }
            com.tencent.mm.plugin.sns.lucky.a.b.rG(44);
            com.tencent.mm.plugin.sns.lucky.b.a.e(4, al.hgB().aZL(SnsBrowseUI.a(SnsBrowseUI.this)));
            AppMethodBeat.o(98498);
          }
        });
        this.Rod.start();
      }
      AppMethodBeat.o(98515);
      return;
    }
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
    aw.bW(this);
    super.onCreate(paramBundle);
    hideTitleView();
    aw.bW(this);
    getIntent().setExtrasClassLoader(getClass().getClassLoader());
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().setFlags(134218752, 134218752);
      getWindow().addFlags(67108864);
    }
    setLightNavigationbarIcon();
    initView();
    this.wAX = paramBundle;
    AppMethodBeat.o(98509);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98510);
    int j;
    int k;
    long l3;
    SnsInfoFlip localSnsInfoFlip;
    if (this.RnH != null)
    {
      j = getIntent().getIntExtra("K_ad_scene", -1);
      k = getIntent().getIntExtra("K_ad_source", 0);
      l3 = getIntent().getLongExtra("sns_ad_exposure_start_time", 0L);
      localSnsInfoFlip = this.RnH;
      localObject1 = this.hHB;
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
      localObject1 = com.tencent.mm.modelsns.l.y(getIntent());
      if (localObject1 != null)
      {
        this.RnH.getSelectCount();
        i = this.RnH.getNumOfFileExist();
        ((com.tencent.mm.modelsns.l)localObject1).wR(this.RnH.getCount()).wR(i);
        ((com.tencent.mm.modelsns.l)localObject1).update();
        ((com.tencent.mm.modelsns.l)localObject1).bMH();
      }
      al.hgy().bq(this);
      if (this.Roa) {
        this.RnH.hoL();
      }
      if (this.Rod != null) {
        this.Rod.stop();
      }
      super.onDestroy();
      AppMethodBeat.o(98510);
      return;
      localSnsInfo = al.hgB().aZL((String)localObject1);
    } while (localSnsInfo == null);
    long l1;
    long l2;
    if (localSnsInfoFlip.RnM >= 0)
    {
      if (!localSnsInfoFlip.RrP.containsKey(Integer.valueOf(localSnsInfoFlip.RnM))) {
        break label622;
      }
      l1 = ((Long)localSnsInfoFlip.RrP.get(Integer.valueOf(localSnsInfoFlip.RnM))).longValue();
      if (l1 > 0L)
      {
        if (!localSnsInfoFlip.RrQ.containsKey(Integer.valueOf(localSnsInfoFlip.RnM))) {
          break label628;
        }
        l2 = ((Long)localSnsInfoFlip.RrQ.get(Integer.valueOf(localSnsInfoFlip.RnM))).longValue();
        label310:
        l1 = Util.ticksToNow(l1);
        l2 += l1;
        localSnsInfoFlip.RrQ.put(Integer.valueOf(localSnsInfoFlip.RnM), Long.valueOf(l2));
        Log.i("MicroMsg.SnsInfoFlip", "curSelectPosition " + localSnsInfoFlip.RnM + " curtime " + l2 + " passtime " + l1);
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
      Iterator localIterator = localSnsInfoFlip.RrO.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label648;
      }
      localInteger = (Integer)localIterator.next();
      m = ((Integer)localSnsInfoFlip.RrO.get(localInteger)).intValue();
      if (!localSnsInfoFlip.RrQ.containsKey(localInteger)) {
        break label643;
      }
    }
    label643:
    for (int i = (int)(((Long)localSnsInfoFlip.RrQ.get(localInteger)).longValue() * 1L);; i = 0)
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
      al.hgv().b(12014, new Object[] { k.a(localSnsInfo.field_snsId, new Object[] { t.uA(localSnsInfo.field_snsId), localSnsInfo.getUxinfo(), Integer.valueOf(j), Long.valueOf(localSnsInfoFlip.Rsc), Long.valueOf(System.currentTimeMillis()), localObject1, Integer.valueOf(localSnsInfoFlip.getCount()) }) });
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
      ((SnsAdClick)localObject2).oTW = l3;
      t.a((SnsAdClick)localObject2);
      localObject2 = com.tencent.mm.modelsns.l.wO(729);
      ((com.tencent.mm.modelsns.l)localObject2).Ph(t.uA(localSnsInfo.field_snsId)).Ph(localSnsInfo.getUxinfo()).wR(j).Ph(localSnsInfoFlip.Rsc).Ph(System.currentTimeMillis()).Ph((String)localObject1).wR(localSnsInfoFlip.getCount());
      ((com.tencent.mm.modelsns.l)localObject2).bMH();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98511);
    if (this.RnH != null) {
      this.RnH.onPause();
    }
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(98511);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98512);
    super.onResume();
    if (this.RnH != null) {
      this.RnH.Ei(false);
    }
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    AppMethodBeat.o(98512);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(98513);
    Bundle localBundle = this.wAX;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.Pdg = ((Rect)getIntent().getParcelableExtra("sns_gallery_thumb_location"));
        if (this.Pdg == null) {
          this.Pdg = new Rect();
        }
        this.wAY.af(this.Pdg.left, this.Pdg.top, this.Pdg.width(), this.Pdg.height());
        if (localBundle == null) {
          this.RnH.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(98500);
              SnsBrowseUI.this.RnH.getViewTreeObserver().removeOnPreDrawListener(this);
              SnsBrowseUI.a(SnsBrowseUI.this, SnsBrowseUI.this.RnH.getWidth());
              SnsBrowseUI.b(SnsBrowseUI.this, SnsBrowseUI.this.RnH.getHeight());
              SnsBrowseUI.c(SnsBrowseUI.this, SnsBrowseUI.this.RnH.getWidth());
              SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.RnH.getHeight());
              al.hgy();
              Object localObject = g.D(SnsBrowseUI.this.RnH.getCntMedia());
              if (localObject != null)
              {
                localObject = BitmapUtil.getImageOptions((String)localObject);
                SnsBrowseUI localSnsBrowseUI = SnsBrowseUI.this;
                float f = SnsBrowseUI.b(SnsBrowseUI.this) / ((BitmapFactory.Options)localObject).outWidth;
                SnsBrowseUI.d(localSnsBrowseUI, (int)(((BitmapFactory.Options)localObject).outHeight * f));
                if (SnsBrowseUI.c(SnsBrowseUI.this) > SnsBrowseUI.this.RnH.getHeight()) {
                  SnsBrowseUI.d(SnsBrowseUI.this, SnsBrowseUI.this.RnH.getHeight());
                }
              }
              SnsBrowseUI.this.wAY.oC(SnsBrowseUI.b(SnsBrowseUI.this), SnsBrowseUI.c(SnsBrowseUI.this));
              SnsBrowseUI.this.wAY.a(SnsBrowseUI.this.RnH, SnsBrowseUI.d(SnsBrowseUI.this), null);
              SnsBrowseUI.this.hon();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI
 * JD-Core Version:    0.7.0.1
 */