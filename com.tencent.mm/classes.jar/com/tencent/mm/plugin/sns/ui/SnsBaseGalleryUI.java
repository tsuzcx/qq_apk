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
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.a.sr.a;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MMViewPager.k;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;

public abstract class SnsBaseGalleryUI
  extends MMActivity
  implements a.a<String, com.tencent.mm.plugin.scanner.word.b>, c.b, SnsInfoFlip.b, v.a
{
  private LinearLayout Ard;
  u Are;
  private LinearLayout Arf;
  v Arg;
  private boolean Arh = true;
  private TextView Ari = null;
  protected SnsInfoFlip Arj;
  protected Button Ark;
  private int Arl = -1;
  private com.tencent.mm.sdk.b.c<vj> Arm = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.plugin.scanner.word.a rHe;
  private int rHf = 0;
  private int rHg = 0;
  private ImageView rHi;
  private ImageView rHj;
  private ImageView rHk;
  private ValueAnimator rHl;
  private com.tencent.mm.sdk.b.c<sr> rHm = new com.tencent.mm.sdk.b.c() {};
  private n rHn = new n.a()
  {
    public final void onNetworkChange(int paramAnonymousInt)
    {
      AppMethodBeat.i(98487);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98486);
          if ((com.tencent.mm.kernel.g.ajj().aFd() != 6) && (com.tencent.mm.kernel.g.ajj().aFd() != 4) && (SnsBaseGalleryUI.e(SnsBaseGalleryUI.this) == 1))
          {
            h.c(SnsBaseGalleryUI.this, SnsBaseGalleryUI.this.getString(2131755828), "", true);
            SnsBaseGalleryUI.this.cyd();
          }
          AppMethodBeat.o(98486);
        }
      });
      AppMethodBeat.o(98487);
    }
  };
  private boolean yOS = true;
  
  private void cyf()
  {
    this.rHl.setRepeatMode(1);
    this.rHl.setRepeatCount(0);
    this.rHl.end();
  }
  
  private boolean efi()
  {
    return efh() == 3;
  }
  
  @SuppressLint({"ResourceAsColor"})
  public final void U(boolean paramBoolean, int paramInt)
  {
    this.Are = new u(this, paramInt, paramBoolean);
    this.Are.setBackgroundColor(2131101053);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.Are.getBackground().setAlpha(50);
    this.Arf.addView(this.Are, localLayoutParams);
    paramInt = getIntent().getIntExtra("sns_source", 0);
    this.Are.setSnsSource(paramInt);
  }
  
  public void a(bzh parambzh, int paramInt, String paramString)
  {
    if ((parambzh.nJA == 2) && (i.dNO()) && (efg()))
    {
      if (paramInt != this.Arl)
      {
        this.Arj.setNeedTranslationImg(false);
        this.rHf = 0;
      }
      this.Arl = paramInt;
      if (this.rHe == null) {
        this.rHe = new ImageWordScanDetailEngine(this);
      }
      paramString = ah.dXE().aBr(paramString);
      if ((paramString != null) && (!paramString.ecp()))
      {
        parambzh = com.tencent.mm.plugin.sns.model.g.C(parambzh);
        if (!bu.isNullOrNil(parambzh)) {
          this.rHe.a(parambzh, this);
        }
      }
      return;
    }
    this.Arj.setNeedTranslationImg(false);
  }
  
  public void addView(View paramView)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.Ard.addView(paramView, localLayoutParams);
  }
  
  public final void azJ(String paramString) {}
  
  public final void bQ(String paramString, boolean paramBoolean)
  {
    if ((i.dNO()) && (efg()) && (paramBoolean) && (!bu.isNullOrNil(paramString)) && (paramString.equals(this.Arj.getSelectedMediaId())))
    {
      if (this.rHe == null) {
        this.rHe = new ImageWordScanDetailEngine(this);
      }
      paramString = com.tencent.mm.plugin.sns.model.g.C(this.Arj.getCntMedia());
      if (!bu.isNullOrNil(paramString)) {
        this.rHe.a(paramString, this);
      }
    }
  }
  
  public final void bR(String paramString, boolean paramBoolean) {}
  
  public final void cyd()
  {
    this.rHg = 0;
    this.rHi.setVisibility(8);
    this.rHj.setVisibility(8);
    this.rHk.setVisibility(8);
    cyf();
  }
  
  public final void dWB() {}
  
  public void eds()
  {
    int j = 8;
    boolean bool = false;
    if (!this.yOS) {
      return;
    }
    u localu;
    if (this.Arh)
    {
      i = 8;
      setTitleVisibility(i);
      if (this.Are != null)
      {
        localu = this.Are;
        if (!this.Arh) {
          break label76;
        }
      }
    }
    label76:
    for (int i = j;; i = 0)
    {
      localu.setVisibility(i);
      if (!this.Arh) {
        bool = true;
      }
      this.Arh = bool;
      return;
      i = 0;
      break;
    }
  }
  
  protected boolean efg()
  {
    return false;
  }
  
  protected int efh()
  {
    return 3;
  }
  
  public void fj(String paramString, int paramInt) {}
  
  public void fk(String paramString, int paramInt)
  {
    if ((!this.yOS) || (ah.dXn())) {
      return;
    }
    paramString = ah.dXE().aBr(paramString);
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
  
  public final void kc(String paramString1, String paramString2)
  {
    if (!this.yOS) {
      return;
    }
    setMMTitle(paramString1);
    setMMSubTitle(paramString2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ah.dXz().az(3, true);
    this.Ard = ((LinearLayout)findViewById(2131301356));
    this.Arf = ((LinearLayout)findViewById(2131298739));
    this.Arg = new v(this, this);
    paramBundle = this.Arg;
    ae.i("MicroMsg.GalleryTitleManager", "onAttach");
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.a(218, paramBundle);
    com.tencent.mm.sdk.b.a.IvT.c(paramBundle.rFa);
    com.tencent.mm.sdk.b.a.IvT.c(paramBundle.AhV);
    if (efg())
    {
      this.rHi = ((ImageView)findViewById(2131304343));
      this.rHj = ((ImageView)findViewById(2131304342));
      this.rHk = ((ImageView)findViewById(2131304340));
      paramBundle = (FrameLayout.LayoutParams)this.rHk.getLayoutParams();
      paramBundle.bottomMargin += al.en(this);
      this.rHk.setLayoutParams(paramBundle);
      this.rHi = ((ImageView)findViewById(2131304343));
      this.rHl = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.rHl.setDuration(5000L);
      this.rHl.addListener(new SnsBaseGalleryUI.1(this));
      int i = getWindowManager().getDefaultDisplay().getHeight();
      this.rHl.addUpdateListener(new SnsBaseGalleryUI.2(this, i));
    }
    ah.dXz().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject;
    if (this.Arg != null)
    {
      localObject = this.Arg;
      ae.i("MicroMsg.GalleryTitleManager", "onDetach");
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.b(218, (f)localObject);
      com.tencent.mm.sdk.b.a.IvT.d(((v)localObject).rFa);
      com.tencent.mm.sdk.b.a.IvT.d(((v)localObject).AhV);
    }
    if (this.Arj != null)
    {
      this.Arj.tZe.JJf.removeMessages(1);
      localObject = this.Arj;
      ae.i("MicroMsg.SnsInfoFlip", "sns info flip on detach.");
      if (((SnsInfoFlip)localObject).AuL != null)
      {
        ((SnsInfoFlip)localObject).AuL.efJ();
        ((SnsInfoFlip)localObject).AuL.clear();
      }
      ah.dXz().b((c.b)localObject);
      this.Arj.onDestroy();
    }
    if (efg()) {
      cyd();
    }
    com.tencent.mm.kernel.g.ajQ().b(this.rHn);
    com.tencent.mm.sdk.b.a.IvT.d(this.rHm);
    ah.dXz().b(this);
  }
  
  public void onPause()
  {
    if (this.Arj != null) {
      this.Arj.onPause();
    }
    if (this.Arg != null)
    {
      v localv = this.Arg;
      if (localv.AhM != null)
      {
        au localau = new au();
        localau.dmH.activity = ((Activity)localv.context);
        localau.dmH.dmI = localv.AhM;
        com.tencent.mm.sdk.b.a.IvT.l(localau);
        localv.AhM = null;
        localv.dow = 0;
        localv.dov = 0;
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.Are != null) {
      this.Are.refresh();
    }
    if (efg())
    {
      com.tencent.mm.kernel.g.ajQ().a(this.rHn);
      com.tencent.mm.sdk.b.a.IvT.c(this.Arm);
      com.tencent.mm.sdk.b.a.IvT.c(this.rHm);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.b.a.IvT.d(this.Arm);
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