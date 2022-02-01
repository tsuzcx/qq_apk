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
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.se.a;
import com.tencent.mm.g.a.um;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.k;
import com.tencent.mm.vfs.i;

public abstract class SnsBaseGalleryUI
  extends MMActivity
  implements a.a<String, com.tencent.mm.plugin.scanner.word.b>, b.b, SnsInfoFlip.b, u.a
{
  private com.tencent.mm.plugin.scanner.word.a qOU;
  private int qOV = 0;
  private int qOW = 0;
  private ImageView qOY;
  private ImageView qOZ;
  private ImageView qPa;
  private ValueAnimator qPb;
  private c<se> qPc = new c() {};
  private n qPd = new n.a()
  {
    public final void onNetworkChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(98487);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98486);
          if ((com.tencent.mm.kernel.g.agi().aBK() != 6) && (com.tencent.mm.kernel.g.agi().aBK() != 4) && (SnsBaseGalleryUI.e(SnsBaseGalleryUI.this) == 1))
          {
            com.tencent.mm.ui.base.h.c(SnsBaseGalleryUI.this, SnsBaseGalleryUI.this.getString(2131755828), "", true);
            SnsBaseGalleryUI.this.cqS();
          }
          AppMethodBeat.o(98486);
        }
      });
      AppMethodBeat.o(98487);
    }
  };
  private boolean xkQ = true;
  private boolean yIA = true;
  private TextView yIB = null;
  protected SnsInfoFlip yIC;
  protected Button yID;
  private int yIE = -1;
  private c<um> yIF = new c() {};
  private LinearLayout yIw;
  t yIx;
  private LinearLayout yIy;
  u yIz;
  
  private void cqU()
  {
    this.qPb.setRepeatMode(1);
    this.qPb.setRepeatCount(0);
    this.qPb.end();
  }
  
  private boolean dPk()
  {
    return dPj() == 3;
  }
  
  @SuppressLint({"ResourceAsColor"})
  public final void Q(boolean paramBoolean, int paramInt)
  {
    this.yIx = new t(this, paramInt, paramBoolean);
    this.yIx.setBackgroundColor(2131101053);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.yIx.getBackground().setAlpha(50);
    this.yIy.addView(this.yIx, localLayoutParams);
    paramInt = getIntent().getIntExtra("sns_source", 0);
    this.yIx.setSnsSource(paramInt);
  }
  
  public void a(btz parambtz, int paramInt, String paramString)
  {
    if ((parambtz.ndI == 2) && (com.tencent.mm.plugin.scanner.h.dyY()) && (dPi()))
    {
      if (paramInt != this.yIE)
      {
        this.yIC.setNeedTranslationImg(false);
        this.qOV = 0;
      }
      this.yIE = paramInt;
      if (this.qOU == null) {
        this.qOU = new ImageWordScanDetailEngine(this);
      }
      paramString = af.dHR().auT(paramString);
      if ((paramString != null) && (!paramString.dMv()))
      {
        parambtz = f.C(parambtz);
        if (!bs.isNullOrNil(parambtz)) {
          this.qOU.a(parambtz, this);
        }
      }
      return;
    }
    this.yIC.setNeedTranslationImg(false);
  }
  
  public void addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.yIw.addView(paramView, localLayoutParams);
  }
  
  public final void atn(String paramString) {}
  
  public final void bF(String paramString, boolean paramBoolean)
  {
    if ((com.tencent.mm.plugin.scanner.h.dyY()) && (dPi()) && (paramBoolean) && (!bs.isNullOrNil(paramString)) && (paramString.equals(this.yIC.getSelectedMediaId())))
    {
      if (this.qOU == null) {
        this.qOU = new ImageWordScanDetailEngine(this);
      }
      paramString = f.C(this.yIC.getCntMedia());
      if (!bs.isNullOrNil(paramString)) {
        this.qOU.a(paramString, this);
      }
    }
  }
  
  public final void bG(String paramString, boolean paramBoolean) {}
  
  public final void cqS()
  {
    this.qOW = 0;
    this.qOY.setVisibility(8);
    this.qOZ.setVisibility(8);
    this.qPa.setVisibility(8);
    cqU();
  }
  
  public final void dGO() {}
  
  public void dNx()
  {
    int j = 8;
    boolean bool = false;
    if (!this.xkQ) {
      return;
    }
    t localt;
    if (this.yIA)
    {
      i = 8;
      setTitleVisibility(i);
      if (this.yIx != null)
      {
        localt = this.yIx;
        if (!this.yIA) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localt.setVisibility(i);
      if (!this.yIA) {
        bool = true;
      }
      this.yIA = bool;
      return;
      i = 0;
      break;
    }
  }
  
  protected boolean dPi()
  {
    return false;
  }
  
  protected int dPj()
  {
    return 3;
  }
  
  public void eI(String paramString, int paramInt) {}
  
  public void eJ(String paramString, int paramInt)
  {
    if ((!this.xkQ) || (af.dHA())) {
      return;
    }
    paramString = af.dHR().auT(paramString);
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
  
  public final void jI(String paramString1, String paramString2)
  {
    if (!this.xkQ) {
      return;
    }
    setMMTitle(paramString1);
    setMMSubTitle(paramString2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    af.dHM().ar(3, true);
    this.yIw = ((LinearLayout)findViewById(2131301356));
    this.yIy = ((LinearLayout)findViewById(2131298739));
    this.yIz = new u(this, this);
    paramBundle = this.yIz;
    ac.i("MicroMsg.GalleryTitleManager", "onAttach");
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(218, paramBundle);
    com.tencent.mm.sdk.b.a.GpY.c(paramBundle.qMM);
    com.tencent.mm.sdk.b.a.GpY.c(paramBundle.yzx);
    if (dPi())
    {
      this.qOY = ((ImageView)findViewById(2131304343));
      this.qOZ = ((ImageView)findViewById(2131304342));
      this.qPa = ((ImageView)findViewById(2131304340));
      paramBundle = (FrameLayout.LayoutParams)this.qPa.getLayoutParams();
      paramBundle.bottomMargin += aj.ej(this);
      this.qPa.setLayoutParams(paramBundle);
      this.qOY = ((ImageView)findViewById(2131304343));
      this.qPb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.qPb.setDuration(5000L);
      this.qPb.addListener(new SnsBaseGalleryUI.1(this));
      int i = getWindowManager().getDefaultDisplay().getHeight();
      this.qPb.addUpdateListener(new SnsBaseGalleryUI.2(this, i));
    }
    af.dHM().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.yIz != null)
    {
      localObject = this.yIz;
      ac.i("MicroMsg.GalleryTitleManager", "onDetach");
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.b(218, (com.tencent.mm.ak.g)localObject);
      com.tencent.mm.sdk.b.a.GpY.d(((u)localObject).qMM);
      com.tencent.mm.sdk.b.a.GpY.d(((u)localObject).yzx);
    }
    if (this.yIC != null)
    {
      this.yIC.sRJ.HAz.removeMessages(1);
      localObject = this.yIC;
      ac.i("MicroMsg.SnsInfoFlip", "sns info flip on detach.");
      if (((SnsInfoFlip)localObject).yMd != null)
      {
        ((SnsInfoFlip)localObject).yMd.dPL();
        ((SnsInfoFlip)localObject).yMd.clear();
      }
      af.dHM().b((b.b)localObject);
      this.yIC.onDestroy();
    }
    if (dPi()) {
      cqS();
    }
    com.tencent.mm.kernel.g.agQ().b(this.qPd);
    com.tencent.mm.sdk.b.a.GpY.d(this.qPc);
    af.dHM().b(this);
  }
  
  public void onPause()
  {
    if (this.yIC != null) {
      this.yIC.onPause();
    }
    if (this.yIz != null)
    {
      u localu = this.yIz;
      if (localu.yzo != null)
      {
        as localas = new as();
        localas.dal.activity = ((Activity)localu.context);
        localas.dal.dam = localu.yzo;
        com.tencent.mm.sdk.b.a.GpY.l(localas);
        localu.yzo = null;
        localu.dbY = 0;
        localu.dbX = 0;
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.yIx != null) {
      this.yIx.refresh();
    }
    if (dPi())
    {
      com.tencent.mm.kernel.g.agQ().a(this.qPd);
      com.tencent.mm.sdk.b.a.GpY.c(this.yIF);
      com.tencent.mm.sdk.b.a.GpY.c(this.qPc);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.b.a.GpY.d(this.yIF);
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