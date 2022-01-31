package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.mm.h.a.gp;
import com.tencent.mm.h.a.gp.b;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.a.b.f;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
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
  private String bMB;
  private int bOs = 0;
  private int gHR = 0;
  private int gHS = 0;
  com.tencent.mm.ui.tools.e itA;
  private int itB = 0;
  private int itC = 0;
  private int itD = 0;
  private int itE = 0;
  Bundle ity;
  private boolean itz = false;
  private ImageView kgw;
  private ah mHandler = new ah();
  private int oVA = 0;
  private boolean oVB = false;
  private boolean oVC = false;
  private boolean oVD = false;
  private t oVE;
  private int oVF;
  private int oVG;
  private int oVH = 0;
  private float oVI = 1.0F;
  private int oVJ = 0;
  private int oVK = 0;
  
  public final void aBR()
  {
    int n = this.itD;
    int i = this.itE;
    int m = this.itC;
    int k = this.itB;
    if (!this.oVC)
    {
      localObject = new gp();
      ((gp)localObject).bOq.bOt = this.oVy.getGallery().getSelectedItemPosition();
      ((gp)localObject).bOq.bOs = this.bOs;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
      n = ((gp)localObject).bOr.bGW;
      i = ((gp)localObject).bOr.bGX;
      m = ((gp)localObject).bOr.bGU;
      k = ((gp)localObject).bOr.bGV;
    }
    this.oVF = this.oVy.getWidth();
    this.oVG = this.oVy.getHeight();
    com.tencent.mm.plugin.sns.model.af.bDC();
    Object localObject = g.C(this.oVy.getCntMedia());
    int j = i;
    if (localObject != null)
    {
      localObject = c.YU((String)localObject);
      float f = this.oVF / ((BitmapFactory.Options)localObject).outWidth;
      this.oVG = ((int)(((BitmapFactory.Options)localObject).outHeight * f));
      j = i;
      if (this.oVG > this.oVy.getHeight())
      {
        j = i;
        if (this.oVG < this.oVy.getHeight() * 2.5D)
        {
          this.oVH = (this.oVG - this.oVy.getHeight());
          j = i;
          if (this.oVy.getCount() == 1)
          {
            j = i * this.oVy.getHeight() / this.oVG;
            this.oVH = 0;
          }
        }
        this.oVG = this.oVy.getHeight();
      }
    }
    this.itA.fH(this.oVF, this.oVG);
    this.itA.E(m, k, n, j);
    if (this.oVI != 1.0D)
    {
      this.itA.wcx = (1.0F / this.oVI);
      if ((this.oVJ != 0) || (this.oVK != 0))
      {
        i = (int)(this.oVy.getWidth() / 2 * (1.0F - this.oVI));
        j = this.oVJ;
        k = (int)(this.oVy.getHeight() / 2 + this.oVK - this.oVG / 2 * this.oVI);
        this.itA.fI(i + j, k);
      }
    }
    this.itA.wcB = this.oVH;
    this.itA.a(this.oVy, this.kgw, new SnsBrowseUI.4(this), new e.a()
    {
      public final void y(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        if ((SnsBrowseUI.this.oVy.getGallery() != null) && (Build.VERSION.SDK_INT >= 18)) {
          SnsBrowseUI.this.oVy.getGallery().setClipBounds(new Rect(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4));
        }
      }
    });
  }
  
  public final void awQ() {}
  
  public final void bIx()
  {
    Gallery localGallery = this.oVy.getGallery();
    if ((localGallery instanceof MMGestureGallery)) {
      ((MMGestureGallery)localGallery).setGalleryScaleListener(new SnsBrowseUI.6(this, localGallery));
    }
  }
  
  public final void cw(String paramString, int paramInt)
  {
    y.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(true), paramString });
    if (this.oVy != null) {
      this.oVy.aPg();
    }
  }
  
  public final void cx(String paramString, int paramInt)
  {
    this.oVA = paramInt;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      y.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
      setResult(-1, new Intent());
      aBR();
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final int getForceOrientation()
  {
    return 2;
  }
  
  protected final int getLayoutId()
  {
    return i.g.sns_browse_img;
  }
  
  protected final void initView()
  {
    this.itA = new com.tencent.mm.ui.tools.e(this.mController.uMN);
    this.itz = false;
    Object localObject1 = bk.aM(getIntent().getStringExtra("sns_gallery_userName"), "");
    this.bMB = bk.aM(getIntent().getStringExtra("sns_gallery_localId"), "");
    this.oVA = getIntent().getIntExtra("sns_gallery_position", 0);
    this.bOs = getIntent().getIntExtra("sns_position", 0);
    this.oVB = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
    this.oVC = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
    this.oVD = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
    n localn = com.tencent.mm.plugin.sns.model.af.bDF().OB(this.bMB);
    this.kgw = ((ImageView)findViewById(i.f.gallery_bg));
    this.kgw.setLayerType(2, null);
    this.oVy = new SnsInfoFlip(this);
    this.oVy.setLayerType(2, null);
    this.oVy.setIsFromMainTimeline(this.oVB);
    this.oVy.setNeedScanImage(true);
    Object localObject2 = aj.NG(this.bMB);
    this.oVy.setShowPageControl(true);
    this.oVy.setOreitaion(true);
    this.oVy.setTouchFinish(true);
    this.oVy.setInfoType(localn.field_type);
    this.oVy.setIsSoonEnterPhotoEditUI(this.oVD);
    this.oVy.a((List)localObject2, (String)localObject1, this.oVA, this.oVt, this);
    localObject1 = this.oVy;
    localObject2 = az.cuY();
    ((az)localObject2).time = localn.field_createTime;
    ((SnsInfoFlip)localObject1).setFromScene((az)localObject2);
    addView(this.oVy);
    if ((localn != null) && (localn.yr(32))) {
      this.oVy.setIsAd(true);
    }
    this.oVz = ((Button)findViewById(i.f.game_more_button));
    localObject2 = localn.bGe();
    if (localObject2 != null)
    {
      localObject1 = ((bxk)localObject2).ouC;
      ax localax = new ax();
      af.a(this, localax, ((bxk)localObject2).ouC);
      if (!localax.phD) {
        break label479;
      }
      this.oVz.setVisibility(0);
      this.oVz.setText(localax.phE);
      this.oVz.setOnClickListener(new SnsBrowseUI.2(this, (av)localObject1, (bxk)localObject2));
      label424:
      if (m.k(localn)) {
        break label491;
      }
      y.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + localn.field_userName + " " + localn.field_snsId);
      finish();
    }
    label479:
    label491:
    while ((localn.field_type != 21) || (localn.field_userName.equals(q.Gj())))
    {
      return;
      localObject1 = null;
      break;
      this.oVz.setVisibility(8);
      break label424;
    }
    this.oVE = new t(com.tencent.mm.compatible.util.e.bkF + "/Pictures/Screenshots/", new SnsBrowseUI.1(this));
    this.oVE.start();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.SnsPopMediasUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {}
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    if (getIntent().getExtras() != null) {
      getIntent().getExtras().setClassLoader(getClass().getClassLoader());
    }
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(1024, 1024);
    }
    initView();
    this.ity = paramBundle;
  }
  
  public void onDestroy()
  {
    int j;
    int k;
    SnsInfoFlip localSnsInfoFlip;
    if (this.oVy != null)
    {
      j = getIntent().getIntExtra("K_ad_scene", -1);
      k = getIntent().getIntExtra("K_ad_source", 0);
      localSnsInfoFlip = this.oVy;
      localObject1 = this.bMB;
      if (localSnsInfoFlip.omL)
      {
        if (j >= 0) {
          break label190;
        }
        y.i("MicroMsg.SnsInfoFlip", "pass by scene " + j);
      }
    }
    label190:
    n localn;
    do
    {
      localObject1 = com.tencent.mm.modelsns.b.i(getIntent());
      if (localObject1 != null)
      {
        this.oVy.getSelectCount();
        i = this.oVy.getNumOfFileExist();
        ((com.tencent.mm.modelsns.b)localObject1).jg(this.oVy.getCount()).jg(i);
        ((com.tencent.mm.modelsns.b)localObject1).update();
        ((com.tencent.mm.modelsns.b)localObject1).QX();
      }
      this.oVy.bIQ();
      this.oVy.onDestroy();
      com.tencent.mm.plugin.sns.model.af.bDC().M(this);
      if (this.oVB) {
        this.oVy.bIS();
      }
      if (this.oVE != null) {
        this.oVE.stop();
      }
      super.onDestroy();
      return;
      localn = com.tencent.mm.plugin.sns.model.af.bDF().OB((String)localObject1);
    } while (localn == null);
    long l1;
    long l2;
    if (localSnsInfoFlip.oZc >= 0)
    {
      if (!localSnsInfoFlip.oYE.containsKey(Integer.valueOf(localSnsInfoFlip.oZc))) {
        break label618;
      }
      l1 = ((Long)localSnsInfoFlip.oYE.get(Integer.valueOf(localSnsInfoFlip.oZc))).longValue();
      if (l1 > 0L)
      {
        if (!localSnsInfoFlip.oYF.containsKey(Integer.valueOf(localSnsInfoFlip.oZc))) {
          break label624;
        }
        l2 = ((Long)localSnsInfoFlip.oYF.get(Integer.valueOf(localSnsInfoFlip.oZc))).longValue();
        label306:
        l1 = bk.cp(l1);
        l2 += l1;
        localSnsInfoFlip.oYF.put(Integer.valueOf(localSnsInfoFlip.oZc), Long.valueOf(l2));
        y.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + localSnsInfoFlip.oZc + " curtime " + l2 + " passtime " + l1);
      }
    }
    com.tencent.mm.plugin.sns.storage.e locale = localn.bGN();
    label409:
    label451:
    Integer localInteger;
    int m;
    if (k == 2)
    {
      localn.bGc();
      localObject1 = new StringBuffer();
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject1).append("<desc>");
      Iterator localIterator = localSnsInfoFlip.oYD.keySet().iterator();
      if (!localIterator.hasNext()) {
        break label644;
      }
      localInteger = (Integer)localIterator.next();
      m = ((Integer)localSnsInfoFlip.oYD.get(localInteger)).intValue();
      if (!localSnsInfoFlip.oYF.containsKey(localInteger)) {
        break label639;
      }
    }
    label618:
    label624:
    label639:
    for (int i = (int)(((Long)localSnsInfoFlip.oYF.get(localInteger)).longValue() * 1L);; i = 0)
    {
      ((StringBuffer)localObject1).append(String.format("<item><id>%d</id><duration>%d</duration><count>%d</count></item>", new Object[] { localInteger, Integer.valueOf(i), Integer.valueOf(m) }));
      ((StringBuffer)localObject2).append(String.format("%d|%d|%d", new Object[] { localInteger, Integer.valueOf(i), Integer.valueOf(m) }) + "&");
      break label451;
      l1 = 0L;
      break;
      l2 = 0L;
      break label306;
      localn.bGb();
      break label409;
    }
    label644:
    ((StringBuffer)localObject1).append("</desc>");
    Object localObject2 = ((StringBuffer)localObject2).toString();
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("&")) {
      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
    }
    if ((localn == null) || (!localn.bEQ())) {
      com.tencent.mm.plugin.sns.model.af.bDz().f(12014, new Object[] { f.a(localn.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId), localn.bGM(), Integer.valueOf(j), Long.valueOf(localSnsInfoFlip.oYU), Long.valueOf(System.currentTimeMillis()), localObject1, Integer.valueOf(localSnsInfoFlip.getCount()) }) });
    }
    if (!locale.bFZ().bEJ()) {
      if (k != 0) {
        break label928;
      }
    }
    label928:
    for (i = 1;; i = 2)
    {
      com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(k, i, localn.field_snsId, 6, 0));
      localObject2 = com.tencent.mm.modelsns.b.jd(729);
      ((com.tencent.mm.modelsns.b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId)).ni(localn.bGM()).jg(j).ni(localSnsInfoFlip.oYU).ni(System.currentTimeMillis()).ni((String)localObject1).jg(localSnsInfoFlip.getCount());
      ((com.tencent.mm.modelsns.b)localObject2).QX();
      break;
    }
  }
  
  protected void onPause()
  {
    if (this.oVy != null) {
      this.oVy.onPause();
    }
    super.onPause();
    com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(2);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.oVy != null) {
      this.oVy.aPg();
    }
    com.tencent.mm.plugin.webview.ui.tools.widget.o.Dh(1);
  }
  
  public void onStart()
  {
    Bundle localBundle = this.ity;
    if (!this.itz)
    {
      this.itz = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.itB = getIntent().getIntExtra("img_gallery_top", 0);
        this.itC = getIntent().getIntExtra("img_gallery_left", 0);
        this.itD = getIntent().getIntExtra("img_gallery_width", 0);
        this.itE = getIntent().getIntExtra("img_gallery_height", 0);
        this.itA.E(this.itC, this.itB, this.itD, this.itE);
        if (localBundle == null) {
          this.oVy.getViewTreeObserver().addOnPreDrawListener(new SnsBrowseUI.3(this));
        }
      }
    }
    super.onStart();
    y.d("MicroMsg.SnsPopMediasUI", "onStart ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI
 * JD-Core Version:    0.7.0.1
 */