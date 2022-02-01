package com.tencent.mm.plugin.sns.ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.rv.a;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public abstract class SnsBaseGalleryUI
  extends MMActivity
  implements a.a<String, Integer>, b.b, SnsInfoFlip.b, u.a
{
  private c<rv> qgA = new c() {};
  private n qgB = new n.a()
  {
    public final void onNetworkChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(98487);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98486);
          if ((com.tencent.mm.kernel.g.aeS().auR() != 6) && (com.tencent.mm.kernel.g.aeS().auR() != 4) && (SnsBaseGalleryUI.e(SnsBaseGalleryUI.this) == 1))
          {
            h.c(SnsBaseGalleryUI.this, SnsBaseGalleryUI.this.getString(2131755828), "", true);
            SnsBaseGalleryUI.this.cjl();
          }
          AppMethodBeat.o(98486);
        }
      });
      AppMethodBeat.o(98487);
    }
  };
  private com.tencent.mm.plugin.scanner.word.a<String, Integer> qgs;
  private int qgt = 0;
  private int qgu = 0;
  private ImageView qgw;
  private ImageView qgx;
  private ImageView qgy;
  private ValueAnimator qgz;
  private boolean vZK = true;
  private LinearLayout xvG;
  t xvH;
  private LinearLayout xvI;
  u xvJ;
  private boolean xvK = true;
  private TextView xvL = null;
  protected SnsInfoFlip xvM;
  protected Button xvN;
  private int xvO = -1;
  private c<uc> xvP = new c() {};
  
  private void cjn()
  {
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(0);
    this.qgz.end();
  }
  
  private boolean dAN()
  {
    return dAM() == 3;
  }
  
  @SuppressLint({"ResourceAsColor"})
  public final void O(boolean paramBoolean, int paramInt)
  {
    this.xvH = new t(this, paramInt, paramBoolean);
    this.xvH.setBackgroundColor(2131101053);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.xvH.getBackground().setAlpha(50);
    this.xvI.addView(this.xvH, localLayoutParams);
    paramInt = getIntent().getIntExtra("sns_source", 0);
    this.xvH.setSnsSource(paramInt);
  }
  
  public void a(bpi parambpi, int paramInt, String paramString)
  {
    if ((parambpi.mBH == 2) && (com.tencent.mm.plugin.scanner.g.dkW()) && (dAL()))
    {
      if (paramInt != this.xvO)
      {
        this.xvM.setNeedTranslationImg(false);
        this.qgt = 0;
      }
      this.xvO = paramInt;
      if (this.qgs == null) {
        this.qgs = new ImageWordScanEngineImpl(this);
      }
      paramString = af.dtu().apK(paramString);
      if ((paramString != null) && (!paramString.dxY()))
      {
        parambpi = f.C(parambpi);
        if (!bt.isNullOrNil(parambpi)) {
          this.qgs.a(parambpi, this);
        }
      }
      return;
    }
    this.xvM.setNeedTranslationImg(false);
  }
  
  public void addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.xvG.addView(paramView, localLayoutParams);
  }
  
  public final void aob(String paramString) {}
  
  public final void by(String paramString, boolean paramBoolean)
  {
    if ((com.tencent.mm.plugin.scanner.g.dkW()) && (dAL()) && (paramBoolean) && (!bt.isNullOrNil(paramString)) && (paramString.equals(this.xvM.getSelectedMediaId())))
    {
      if (this.qgs == null) {
        this.qgs = new ImageWordScanEngineImpl(this);
      }
      paramString = f.C(this.xvM.getCntMedia());
      if (!bt.isNullOrNil(paramString)) {
        this.qgs.a(paramString, this);
      }
    }
  }
  
  public final void bz(String paramString, boolean paramBoolean) {}
  
  public final void cjl()
  {
    this.qgu = 0;
    this.qgw.setVisibility(8);
    this.qgx.setVisibility(8);
    this.qgy.setVisibility(8);
    cjn();
  }
  
  protected boolean dAL()
  {
    return false;
  }
  
  protected int dAM()
  {
    return 3;
  }
  
  public final void dsp() {}
  
  public void dza()
  {
    int j = 8;
    boolean bool = false;
    if (!this.vZK) {
      return;
    }
    t localt;
    if (this.xvK)
    {
      i = 8;
      setTitleVisibility(i);
      if (this.xvH != null)
      {
        localt = this.xvH;
        if (!this.xvK) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localt.setVisibility(i);
      if (!this.xvK) {
        bool = true;
      }
      this.xvK = bool;
      return;
      i = 0;
      break;
    }
  }
  
  public void eA(String paramString, int paramInt) {}
  
  public void eB(String paramString, int paramInt)
  {
    if ((!this.vZK) || (af.dtd())) {
      return;
    }
    paramString = af.dtu().apK(paramString);
    if ((paramString == null) || (paramString.field_snsId == 0L))
    {
      enableOptionMenu(false);
      return;
    }
    enableOptionMenu(true);
  }
  
  public int getLayoutId()
  {
    return 2131495548;
  }
  
  public final void jk(String paramString1, String paramString2)
  {
    if (!this.vZK) {
      return;
    }
    setMMTitle(paramString1);
    setMMSubTitle(paramString2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    af.dtp().ao(3, true);
    this.xvG = ((LinearLayout)findViewById(2131301356));
    this.xvI = ((LinearLayout)findViewById(2131298739));
    this.xvJ = new u(this, this);
    paramBundle = this.xvJ;
    ad.i("MicroMsg.GalleryTitleManager", "onAttach");
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(218, paramBundle);
    com.tencent.mm.sdk.b.a.ESL.c(paramBundle.qej);
    com.tencent.mm.sdk.b.a.ESL.c(paramBundle.xmF);
    if (dAL())
    {
      this.qgw = ((ImageView)findViewById(2131304343));
      this.qgx = ((ImageView)findViewById(2131304342));
      this.qgy = ((ImageView)findViewById(2131304340));
      paramBundle = (FrameLayout.LayoutParams)this.qgy.getLayoutParams();
      paramBundle.bottomMargin += ai.eb(this);
      this.qgy.setLayoutParams(paramBundle);
      this.qgw = ((ImageView)findViewById(2131304343));
      this.qgz = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.qgz.setDuration(5000L);
      this.qgz.addListener(new SnsBaseGalleryUI.1(this));
      int i = getWindowManager().getDefaultDisplay().getHeight();
      this.qgz.addUpdateListener(new SnsBaseGalleryUI.2(this, i));
    }
    af.dtp().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.xvJ != null)
    {
      localObject = this.xvJ;
      ad.i("MicroMsg.GalleryTitleManager", "onDetach");
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.b(218, (com.tencent.mm.al.g)localObject);
      com.tencent.mm.sdk.b.a.ESL.d(((u)localObject).qej);
      com.tencent.mm.sdk.b.a.ESL.d(((u)localObject).xmF);
    }
    if (this.xvM != null)
    {
      this.xvM.rJU.GaL.removeMessages(1);
      localObject = this.xvM;
      ad.i("MicroMsg.SnsInfoFlip", "sns info flip on detach.");
      if (((SnsInfoFlip)localObject).xzp != null)
      {
        ((SnsInfoFlip)localObject).xzp.dBo();
        ((SnsInfoFlip)localObject).xzp.clear();
      }
      af.dtp().b((b.b)localObject);
      this.xvM.onDestroy();
    }
    if (dAL()) {
      cjl();
    }
    com.tencent.mm.kernel.g.afA().b(this.qgB);
    com.tencent.mm.sdk.b.a.ESL.d(this.qgA);
    af.dtp().b(this);
  }
  
  public void onPause()
  {
    if (this.xvM != null) {
      this.xvM.onPause();
    }
    if (this.xvJ != null)
    {
      u localu = this.xvJ;
      if (localu.xmw != null)
      {
        ar localar = new ar();
        localar.dcN.activity = ((Activity)localu.context);
        localar.dcN.dcO = localu.xmw;
        com.tencent.mm.sdk.b.a.ESL.l(localar);
        localu.xmw = null;
        localu.deC = 0;
        localu.deB = 0;
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.xvH != null) {
      this.xvH.refresh();
    }
    if (dAL())
    {
      com.tencent.mm.kernel.g.afA().a(this.qgB);
      com.tencent.mm.sdk.b.a.ESL.c(this.xvP);
      com.tencent.mm.sdk.b.a.ESL.c(this.qgA);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.b.a.ESL.d(this.xvP);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBaseGalleryUI
 * JD-Core Version:    0.7.0.1
 */