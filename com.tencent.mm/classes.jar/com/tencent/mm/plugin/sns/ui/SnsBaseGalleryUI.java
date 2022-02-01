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
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sq.a;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.k;
import com.tencent.mm.vfs.i;

public abstract class SnsBaseGalleryUI
  extends MMActivity
  implements a.a<String, com.tencent.mm.plugin.scanner.word.b>, b.b, SnsInfoFlip.b, v.a
{
  private com.tencent.mm.plugin.scanner.word.a ryT;
  private int ryU = 0;
  private int ryV = 0;
  private ImageView ryX;
  private ImageView ryY;
  private ImageView ryZ;
  private ValueAnimator rza;
  private c<sq> rzb = new c() {};
  private n rzc = new n.a()
  {
    public final void onNetworkChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(98487);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98486);
          if ((g.aiU().aEN() != 6) && (g.aiU().aEN() != 4) && (SnsBaseGalleryUI.e(SnsBaseGalleryUI.this) == 1))
          {
            com.tencent.mm.ui.base.h.c(SnsBaseGalleryUI.this, SnsBaseGalleryUI.this.getString(2131755828), "", true);
            SnsBaseGalleryUI.this.cwC();
          }
          AppMethodBeat.o(98486);
        }
      });
      AppMethodBeat.o(98487);
    }
  };
  private boolean yyS = true;
  private LinearLayout zZQ;
  u zZR;
  private LinearLayout zZS;
  v zZT;
  private boolean zZU = true;
  private TextView zZV = null;
  protected SnsInfoFlip zZW;
  protected Button zZX;
  private int zZY = -1;
  private c<vf> zZZ = new c() {};
  
  private void cwE()
  {
    this.rza.setRepeatMode(1);
    this.rza.setRepeatCount(0);
    this.rza.end();
  }
  
  private boolean ebB()
  {
    return ebA() == 3;
  }
  
  @SuppressLint({"ResourceAsColor"})
  public final void R(boolean paramBoolean, int paramInt)
  {
    this.zZR = new u(this, paramInt, paramBoolean);
    this.zZR.setBackgroundColor(2131101053);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.zZR.getBackground().setAlpha(50);
    this.zZS.addView(this.zZR, localLayoutParams);
    paramInt = getIntent().getIntExtra("sns_source", 0);
    this.zZR.setSnsSource(paramInt);
  }
  
  public void a(byn parambyn, int paramInt, String paramString)
  {
    if ((parambyn.nEf == 2) && (com.tencent.mm.plugin.scanner.h.dKw()) && (ebz()))
    {
      if (paramInt != this.zZY)
      {
        this.zZW.setNeedTranslationImg(false);
        this.ryU = 0;
      }
      this.zZY = paramInt;
      if (this.ryT == null) {
        this.ryT = new ImageWordScanDetailEngine(this);
      }
      paramString = ag.dUe().aAa(paramString);
      if ((paramString != null) && (!paramString.dYL()))
      {
        parambyn = com.tencent.mm.plugin.sns.model.f.C(parambyn);
        if (!bt.isNullOrNil(parambyn)) {
          this.ryT.a(parambyn, this);
        }
      }
      return;
    }
    this.zZW.setNeedTranslationImg(false);
  }
  
  public void addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.zZQ.addView(paramView, localLayoutParams);
  }
  
  public final void ays(String paramString) {}
  
  public final void bM(String paramString, boolean paramBoolean)
  {
    if ((com.tencent.mm.plugin.scanner.h.dKw()) && (ebz()) && (paramBoolean) && (!bt.isNullOrNil(paramString)) && (paramString.equals(this.zZW.getSelectedMediaId())))
    {
      if (this.ryT == null) {
        this.ryT = new ImageWordScanDetailEngine(this);
      }
      paramString = com.tencent.mm.plugin.sns.model.f.C(this.zZW.getCntMedia());
      if (!bt.isNullOrNil(paramString)) {
        this.ryT.a(paramString, this);
      }
    }
  }
  
  public final void bN(String paramString, boolean paramBoolean) {}
  
  public final void cwC()
  {
    this.ryV = 0;
    this.ryX.setVisibility(8);
    this.ryY.setVisibility(8);
    this.ryZ.setVisibility(8);
    cwE();
  }
  
  public final void dTb() {}
  
  public void dZM()
  {
    int j = 8;
    boolean bool = false;
    if (!this.yyS) {
      return;
    }
    u localu;
    if (this.zZU)
    {
      i = 8;
      setTitleVisibility(i);
      if (this.zZR != null)
      {
        localu = this.zZR;
        if (!this.zZU) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localu.setVisibility(i);
      if (!this.zZU) {
        bool = true;
      }
      this.zZU = bool;
      return;
      i = 0;
      break;
    }
  }
  
  protected int ebA()
  {
    return 3;
  }
  
  protected boolean ebz()
  {
    return false;
  }
  
  public void fa(String paramString, int paramInt) {}
  
  public void fb(String paramString, int paramInt)
  {
    if ((!this.yyS) || (ag.dTN())) {
      return;
    }
    paramString = ag.dUe().aAa(paramString);
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
  
  public final void jV(String paramString1, String paramString2)
  {
    if (!this.yyS) {
      return;
    }
    setMMTitle(paramString1);
    setMMSubTitle(paramString2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ag.dTZ().aw(3, true);
    this.zZQ = ((LinearLayout)findViewById(2131301356));
    this.zZS = ((LinearLayout)findViewById(2131298739));
    this.zZT = new v(this, this);
    paramBundle = this.zZT;
    ad.i("MicroMsg.GalleryTitleManager", "onAttach");
    g.ajD();
    g.ajB().gAO.a(218, paramBundle);
    com.tencent.mm.sdk.b.a.IbL.c(paramBundle.rwO);
    com.tencent.mm.sdk.b.a.IbL.c(paramBundle.zQO);
    if (ebz())
    {
      this.ryX = ((ImageView)findViewById(2131304343));
      this.ryY = ((ImageView)findViewById(2131304342));
      this.ryZ = ((ImageView)findViewById(2131304340));
      paramBundle = (FrameLayout.LayoutParams)this.ryZ.getLayoutParams();
      paramBundle.bottomMargin += al.ej(this);
      this.ryZ.setLayoutParams(paramBundle);
      this.ryX = ((ImageView)findViewById(2131304343));
      this.rza = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.rza.setDuration(5000L);
      this.rza.addListener(new SnsBaseGalleryUI.1(this));
      int i = getWindowManager().getDefaultDisplay().getHeight();
      this.rza.addUpdateListener(new SnsBaseGalleryUI.2(this, i));
    }
    ag.dTZ().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.zZT != null)
    {
      localObject = this.zZT;
      ad.i("MicroMsg.GalleryTitleManager", "onDetach");
      g.ajD();
      g.ajB().gAO.b(218, (com.tencent.mm.al.f)localObject);
      com.tencent.mm.sdk.b.a.IbL.d(((v)localObject).rwO);
      com.tencent.mm.sdk.b.a.IbL.d(((v)localObject).zQO);
    }
    if (this.zZW != null)
    {
      this.zZW.tOn.Joq.removeMessages(1);
      localObject = this.zZW;
      ad.i("MicroMsg.SnsInfoFlip", "sns info flip on detach.");
      if (((SnsInfoFlip)localObject).Adz != null)
      {
        ((SnsInfoFlip)localObject).Adz.ecc();
        ((SnsInfoFlip)localObject).Adz.clear();
      }
      ag.dTZ().b((b.b)localObject);
      this.zZW.onDestroy();
    }
    if (ebz()) {
      cwC();
    }
    g.ajB().b(this.rzc);
    com.tencent.mm.sdk.b.a.IbL.d(this.rzb);
    ag.dTZ().b(this);
  }
  
  public void onPause()
  {
    if (this.zZW != null) {
      this.zZW.onPause();
    }
    if (this.zZT != null)
    {
      v localv = this.zZT;
      if (localv.zQF != null)
      {
        au localau = new au();
        localau.dlF.activity = ((Activity)localv.context);
        localau.dlF.dlG = localv.zQF;
        com.tencent.mm.sdk.b.a.IbL.l(localau);
        localv.zQF = null;
        localv.dnu = 0;
        localv.dnt = 0;
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.zZR != null) {
      this.zZR.refresh();
    }
    if (ebz())
    {
      g.ajB().a(this.rzc);
      com.tencent.mm.sdk.b.a.IbL.c(this.zZZ);
      com.tencent.mm.sdk.b.a.IbL.c(this.rzb);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.b.a.IbL.d(this.zZZ);
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