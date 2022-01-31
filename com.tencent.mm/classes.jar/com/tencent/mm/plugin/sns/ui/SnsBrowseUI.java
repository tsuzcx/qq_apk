package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.b;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.f;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.e.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(3)
public class SnsBrowseUI
  extends SnsBaseGalleryUI
  implements s.a
{
  private String ctV;
  private int cvJ;
  private int iiW;
  private int iiX;
  private boolean isAnimated;
  com.tencent.mm.ui.tools.e kip;
  Bundle kuF;
  private int kuG;
  private int kuH;
  private int kuI;
  private int kuJ;
  private ImageView mBi;
  private com.tencent.mm.sdk.platformtools.ak mHandler;
  private int rNV;
  private boolean rNW;
  private boolean rNX;
  private boolean rNY;
  private s rNZ;
  private int rOa;
  private int rOb;
  private int rOc;
  private float rOd;
  private int rOe;
  private int rOf;
  
  public SnsBrowseUI()
  {
    AppMethodBeat.i(38759);
    this.rNV = 0;
    this.cvJ = 0;
    this.rNW = false;
    this.rNX = false;
    this.rNY = false;
    this.isAnimated = false;
    this.iiW = 0;
    this.iiX = 0;
    this.kuG = 0;
    this.kuH = 0;
    this.kuI = 0;
    this.kuJ = 0;
    this.mHandler = new com.tencent.mm.sdk.platformtools.ak();
    this.rOc = 0;
    this.rOd = 1.0F;
    this.rOe = 0;
    this.rOf = 0;
    AppMethodBeat.o(38759);
  }
  
  public final void bdV()
  {
    AppMethodBeat.i(38768);
    int n = this.kuI;
    int i = this.kuJ;
    int m = this.kuH;
    int k = this.kuG;
    if (!this.rNX)
    {
      localObject = new gt();
      ((gt)localObject).cvH.cvK = this.rNT.getGallery().getSelectedItemPosition();
      ((gt)localObject).cvH.cvJ = this.cvJ;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      n = ((gt)localObject).cvI.col;
      i = ((gt)localObject).cvI.com;
      m = ((gt)localObject).cvI.coj;
      k = ((gt)localObject).cvI.cok;
    }
    this.rOa = this.rNT.getWidth();
    this.rOb = this.rNT.getHeight();
    ag.cpc();
    Object localObject = g.C(this.rNT.getCntMedia());
    int j = i;
    if (localObject != null)
    {
      localObject = d.aoT((String)localObject);
      float f = this.rOa / ((BitmapFactory.Options)localObject).outWidth;
      this.rOb = ((int)(((BitmapFactory.Options)localObject).outHeight * f));
      j = i;
      if (this.rOb > this.rNT.getHeight())
      {
        j = i;
        if (this.rOb < this.rNT.getHeight() * 2.5D)
        {
          this.rOc = (this.rOb - this.rNT.getHeight());
          j = i;
          if (this.rNT.getCount() == 1)
          {
            j = i * this.rNT.getHeight() / this.rOb;
            this.rOc = 0;
          }
        }
        this.rOb = this.rNT.getHeight();
      }
    }
    this.kip.hO(this.rOa, this.rOb);
    this.kip.L(m, k, n, j);
    if (this.rOd != 1.0D)
    {
      this.kip.AuR = (1.0F / this.rOd);
      if ((this.rOe != 0) || (this.rOf != 0))
      {
        i = (int)(this.rNT.getWidth() / 2 * (1.0F - this.rOd));
        j = this.rOe;
        k = (int)(this.rNT.getHeight() / 2 + this.rOf - this.rOb / 2 * this.rOd);
        this.kip.hQ(i + j, k);
      }
    }
    this.kip.AuV = this.rOc;
    this.kip.a(this.rNT, this.mBi, new SnsBrowseUI.4(this), new e.a()
    {
      public final void E(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(38756);
        if ((SnsBrowseUI.this.rNT.getGallery() != null) && (Build.VERSION.SDK_INT >= 18)) {
          SnsBrowseUI.this.rNT.getGallery().setClipBounds(new Rect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
        }
        AppMethodBeat.o(38756);
      }
    });
    AppMethodBeat.o(38768);
  }
  
  public final void ctA() {}
  
  public final void cuS()
  {
    AppMethodBeat.i(38769);
    Gallery localGallery = this.rNT.getGallery();
    if ((localGallery instanceof MMGestureGallery)) {
      ((MMGestureGallery)localGallery).setGalleryScaleListener(new SnsBrowseUI.6(this, localGallery));
    }
    AppMethodBeat.o(38769);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(38765);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ab.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      bdV();
      AppMethodBeat.o(38765);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(38765);
    return bool;
  }
  
  public final void ds(String paramString, int paramInt)
  {
    AppMethodBeat.i(38770);
    ab.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[] { Integer.valueOf(paramInt), Boolean.TRUE, paramString });
    if (this.rNT != null) {
      this.rNT.bvl();
    }
    AppMethodBeat.o(38770);
  }
  
  public final void dt(String paramString, int paramInt)
  {
    this.rNV = paramInt;
  }
  
  public int getForceOrientation()
  {
    return 2;
  }
  
  public int getLayoutId()
  {
    return 2130970810;
  }
  
  public void initView()
  {
    AppMethodBeat.i(38766);
    this.kip = new com.tencent.mm.ui.tools.e(getContext());
    this.isAnimated = false;
    Object localObject1 = bo.bf(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.ctV = bo.bf(getIntent().getStringExtra("sns_gallery_localId"), "");
    this.rNV = getIntent().getIntExtra("sns_gallery_position", 0);
    this.cvJ = getIntent().getIntExtra("sns_position", 0);
    this.rNW = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
    this.rNX = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
    this.rNY = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
    n localn = ag.cpf().abv(this.ctV);
    this.mBi = ((ImageView)findViewById(2131822135));
    this.mBi.setLayerType(2, null);
    this.rNT = new SnsInfoFlip(this);
    this.rNT.setLayerType(2, null);
    this.rNT.setIsFromMainTimeline(this.rNW);
    this.rNT.setNeedScanImage(true);
    Object localObject2 = com.tencent.mm.plugin.sns.model.ak.aaA(this.ctV);
    this.rNT.setShowPageControl(true);
    this.rNT.setOreitaion(true);
    this.rNT.setTouchFinish(true);
    this.rNT.setInfoType(localn.field_type);
    this.rNT.setIsSoonEnterPhotoEditUI(this.rNY);
    this.rNT.a((List)localObject2, (String)localObject1, this.rNV, this.rNO, this);
    localObject1 = this.rNT;
    localObject2 = az.dxB();
    ((az)localObject2).oLs = localn.field_createTime;
    ((SnsInfoFlip)localObject1).setFromScene((az)localObject2);
    addView(this.rNT);
    if ((localn != null) && (localn.Ex(32))) {
      this.rNT.setIsAd(true);
    }
    this.rNU = ((Button)findViewById(2131827918));
    int i = am.fx(this);
    localObject1 = (ViewGroup.MarginLayoutParams)this.rNU.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (i + getResources().getDimensionPixelSize(2131428702));
    this.rNU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject2 = localn.csh();
    if (localObject2 != null)
    {
      localObject1 = ((TimeLineObject)localObject2).rjv;
      aw localaw = new aw();
      af.a(this, localaw, ((TimeLineObject)localObject2).rjv);
      if (!localaw.sak) {
        break label539;
      }
      this.rNU.setVisibility(0);
      this.rNU.setText(localaw.sal);
      this.rNU.setOnClickListener(new SnsBrowseUI.2(this, (av)localObject1, (TimeLineObject)localObject2));
    }
    for (;;)
    {
      if (m.k(localn)) {
        break label551;
      }
      ab.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + localn.field_userName + " " + localn.field_snsId);
      finish();
      AppMethodBeat.o(38766);
      return;
      localObject1 = null;
      break;
      label539:
      this.rNU.setVisibility(8);
    }
    label551:
    if ((localn.field_type == 21) && (!localn.field_userName.equals(r.Zn())))
    {
      this.rNZ = new s(com.tencent.mm.compatible.util.e.eQx + "/Pictures/Screenshots/", new SnsBrowseUI.1(this));
      this.rNZ.start();
    }
    AppMethodBeat.o(38766);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38771);
    ab.i("MicroMsg.SnsPopMediasUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38771);
      return;
    }
    AppMethodBeat.o(38771);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38760);
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
    this.kuF = paramBundle;
    AppMethodBeat.o(38760);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38761);
    int j;
    int k;
    long l3;
    SnsInfoFlip localSnsInfoFlip;
    if (this.rNT != null)
    {
      j = getIntent().getIntExtra("K_ad_scene", -1);
      k = getIntent().getIntExtra("K_ad_source", 0);
      l3 = getIntent().getLongExtra("sns_ad_exposure_start_time", 0L);
      localSnsInfoFlip = this.rNT;
      localObject1 = this.ctV;
      if (localSnsInfoFlip.raZ)
      {
        if (j >= 0) {
          break label208;
        }
        ab.i("MicroMsg.SnsInfoFlip", "pass by scene ".concat(String.valueOf(j)));
      }
    }
    label208:
    n localn;
    do
    {
      localObject1 = com.tencent.mm.modelsns.b.w(getIntent());
      if (localObject1 != null)
      {
        this.rNT.getSelectCount();
        i = this.rNT.getNumOfFileExist();
        ((com.tencent.mm.modelsns.b)localObject1).lY(this.rNT.getCount()).lY(i);
        ((com.tencent.mm.modelsns.b)localObject1).update();
        ((com.tencent.mm.modelsns.b)localObject1).ake();
      }
      this.rNT.cvl();
      this.rNT.onDestroy();
      ag.cpc().ah(this);
      if (this.rNW) {
        this.rNT.cvn();
      }
      if (this.rNZ != null) {
        this.rNZ.stop();
      }
      super.onDestroy();
      AppMethodBeat.o(38761);
      return;
      localn = ag.cpf().abv((String)localObject1);
    } while (localn == null);
    long l1;
    long l2;
    if (localSnsInfoFlip.rRv >= 0)
    {
      if (!localSnsInfoFlip.rQX.containsKey(Integer.valueOf(localSnsInfoFlip.rRv))) {
        break label636;
      }
      l1 = ((Long)localSnsInfoFlip.rQX.get(Integer.valueOf(localSnsInfoFlip.rRv))).longValue();
      if (l1 > 0L)
      {
        if (!localSnsInfoFlip.rQY.containsKey(Integer.valueOf(localSnsInfoFlip.rRv))) {
          break label642;
        }
        l2 = ((Long)localSnsInfoFlip.rQY.get(Integer.valueOf(localSnsInfoFlip.rRv))).longValue();
        label324:
        l1 = bo.av(l1);
        l2 += l1;
        localSnsInfoFlip.rQY.put(Integer.valueOf(localSnsInfoFlip.rRv), Long.valueOf(l2));
        ab.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + localSnsInfoFlip.rRv + " curtime " + l2 + " passtime " + l1);
      }
    }
    com.tencent.mm.plugin.sns.storage.e locale = localn.csQ();
    label427:
    label469:
    Integer localInteger;
    int m;
    if (k == 2)
    {
      localn.cse();
      localObject1 = new StringBuffer();
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject1).append("<desc>");
      Iterator localIterator = localSnsInfoFlip.rQW.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label662;
      }
      localInteger = (Integer)localIterator.next();
      m = ((Integer)localSnsInfoFlip.rQW.get(localInteger)).intValue();
      if (!localSnsInfoFlip.rQY.containsKey(localInteger)) {
        break label657;
      }
    }
    label642:
    label657:
    for (int i = (int)(((Long)localSnsInfoFlip.rQY.get(localInteger)).longValue() * 1L);; i = 0)
    {
      ((StringBuffer)localObject1).append(String.format("<item><id>%d</id><duration>%d</duration><count>%d</count></item>", new Object[] { localInteger, Integer.valueOf(i), Integer.valueOf(m) }));
      ((StringBuffer)localObject2).append(String.format("%d|%d|%d", new Object[] { localInteger, Integer.valueOf(i), Integer.valueOf(m) }) + "&");
      break label469;
      label636:
      l1 = 0L;
      break;
      l2 = 0L;
      break label324;
      localn.csd();
      break label427;
    }
    label662:
    ((StringBuffer)localObject1).append("</desc>");
    Object localObject2 = ((StringBuffer)localObject2).toString();
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("&")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    if ((localn == null) || (!localn.cqx())) {
      ag.coZ().e(12014, new Object[] { f.a(localn.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId), localn.csP(), Integer.valueOf(j), Long.valueOf(localSnsInfoFlip.rRn), Long.valueOf(System.currentTimeMillis()), localObject1, Integer.valueOf(localSnsInfoFlip.getCount()) }) });
    }
    if (!locale.csb().cqp()) {
      if (k != 0) {
        break label957;
      }
    }
    label957:
    for (i = 1;; i = 2)
    {
      localObject2 = new SnsAdClick(k, i, localn.field_snsId, 6, 0);
      ((SnsAdClick)localObject2).fQA = l3;
      com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject2);
      localObject2 = com.tencent.mm.modelsns.b.lV(729);
      ((com.tencent.mm.modelsns.b)localObject2).uv(com.tencent.mm.plugin.sns.data.i.lq(localn.field_snsId)).uv(localn.csP()).lY(j).uv(localSnsInfoFlip.rRn).uv(System.currentTimeMillis()).uv((String)localObject1).lY(localSnsInfoFlip.getCount());
      ((com.tencent.mm.modelsns.b)localObject2).ake();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38762);
    if (this.rNT != null) {
      this.rNT.onPause();
    }
    super.onPause();
    com.tencent.mm.plugin.webview.ui.tools.widget.o.La(2);
    AppMethodBeat.o(38762);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38763);
    super.onResume();
    if (this.rNT != null) {
      this.rNT.bvl();
    }
    com.tencent.mm.plugin.webview.ui.tools.widget.o.La(1);
    AppMethodBeat.o(38763);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(38764);
    Bundle localBundle = this.kuF;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.kuG = getIntent().getIntExtra("img_gallery_top", 0);
        this.kuH = getIntent().getIntExtra("img_gallery_left", 0);
        this.kuI = getIntent().getIntExtra("img_gallery_width", 0);
        this.kuJ = getIntent().getIntExtra("img_gallery_height", 0);
        this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
        if (localBundle == null) {
          this.rNT.getViewTreeObserver().addOnPreDrawListener(new SnsBrowseUI.3(this));
        }
      }
    }
    super.onStart();
    ab.d("MicroMsg.SnsPopMediasUI", "onStart ");
    AppMethodBeat.o(38764);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI
 * JD-Core Version:    0.7.0.1
 */