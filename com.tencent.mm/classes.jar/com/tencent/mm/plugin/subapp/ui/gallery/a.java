package com.tencent.mm.plugin.subapp.ui.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.bg;
import com.tencent.mm.autogen.a.bg.a;
import com.tencent.mm.autogen.a.wh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.api.a.c;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;

public final class a
{
  int AjA;
  ImageView AjC;
  ImageView AjD;
  ImageView AjE;
  ValueAnimator AjF;
  IListener<wh> AjG;
  p AjH;
  com.tencent.mm.plugin.scanner.word.a.a Ajx;
  private com.tencent.mm.plugin.scanner.word.a Ajy;
  volatile int Ajz;
  long RnP;
  com.tencent.mm.plugin.scanner.api.a.a RnQ;
  c RnS;
  b SGj;
  a SGk;
  boolean SGl;
  MMActivity activity;
  
  public a(GestureGalleryUI paramGestureGalleryUI, b paramb, com.tencent.mm.plugin.scanner.word.a.a parama, a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(292082);
    this.AjA = 0;
    this.AjG = new GestureGalleryTransAndOcrLogic.1(this, f.hfK);
    this.AjH = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(292066);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(292079);
            if ((h.aZW().bFQ() != 6) && (h.aZW().bFQ() != 4) && (a.this.AjA == 1))
            {
              k.c(a.this.activity, a.this.activity.getString(R.l.app_network_unavailable), "", true);
              a.this.dSe();
            }
            AppMethodBeat.o(292079);
          }
        });
        AppMethodBeat.o(292066);
      }
    };
    this.RnQ = null;
    this.RnP = 0L;
    this.RnS = new c()
    {
      public final void gPE()
      {
        AppMethodBeat.i(292073);
        if (a.this.SGk != null) {
          a.this.SGk.hBe();
        }
        AppMethodBeat.o(292073);
      }
      
      public final void gPF()
      {
        AppMethodBeat.i(292108);
        Log.i("MicroMsg.GestureGalleryTransLogic", "dealWithImageOcr onDialogShow");
        if (a.this.SGk != null) {
          a.this.SGk.hBg();
        }
        a.this.hBd();
        AppMethodBeat.o(292108);
      }
      
      public final void gPG()
      {
        AppMethodBeat.i(292089);
        if (a.this.SGk != null) {
          a.this.SGk.hBf();
        }
        AppMethodBeat.o(292089);
      }
      
      public final void gPH()
      {
        AppMethodBeat.i(292094);
        if (a.this.SGk != null) {
          a.this.SGk.hBf();
        }
        AppMethodBeat.o(292094);
      }
      
      public final void gPI()
      {
        AppMethodBeat.i(292080);
        if (a.this.SGk != null) {
          a.this.SGk.hBf();
        }
        a.this.hBd();
        AppMethodBeat.o(292080);
      }
    };
    this.Ajx = parama;
    this.activity = paramGestureGalleryUI;
    this.SGj = paramb;
    this.SGl = paramBoolean;
    this.SGk = parama1;
    this.AjD = ((ImageView)this.activity.findViewById(R.h.scan_translate_layer));
    this.AjE = ((ImageView)this.activity.findViewById(R.h.scan_translate_close_btn));
    this.AjC = ((ImageView)this.activity.findViewById(R.h.scan_translate_line));
    paramGestureGalleryUI = (FrameLayout.LayoutParams)this.AjE.getLayoutParams();
    paramGestureGalleryUI.bottomMargin += aw.bk(this.activity);
    this.AjE.setLayoutParams(paramGestureGalleryUI);
    this.AjE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(292069);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransAndOcrLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (a.this.SGk != null) {
          a.this.SGk.hBf();
        }
        a.this.hoc();
        paramAnonymousView = new bg();
        localObject = paramAnonymousView.hBl;
        if (a.this.SGl) {}
        for (int i = 6;; i = 5)
        {
          ((bg.a)localObject).scene = i;
          paramAnonymousView.hBl.hBm = a.this.Ajz;
          paramAnonymousView.publish();
          a.this.dSe();
          a.this.Ajz = 0;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransAndOcrLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(292069);
          return;
        }
      }
    });
    this.AjF = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.AjF.setDuration(5000L);
    this.AjF.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(292075);
        a.this.AjC.setAlpha(0.0F);
        AppMethodBeat.o(292075);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(292070);
        a.this.AjC.setAlpha(0.0F);
        AppMethodBeat.o(292070);
      }
    });
    final int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.AjF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(292065);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f <= 0.1F) {
          a.this.AjC.setAlpha(f * 10.0F);
        }
        for (;;)
        {
          a.this.AjC.setTranslationY(f * (i - a.this.AjC.getHeight()));
          AppMethodBeat.o(292065);
          return;
          if (f >= 0.9F) {
            a.this.AjC.setAlpha((1.0F - f) * 10.0F);
          }
        }
      }
    });
    this.AjG.alive();
    AppMethodBeat.o(292082);
  }
  
  public final void dSe()
  {
    AppMethodBeat.i(292091);
    this.AjA = 0;
    this.AjC.setVisibility(8);
    this.AjD.setVisibility(8);
    this.AjE.setVisibility(8);
    dSg();
    AppMethodBeat.o(292091);
  }
  
  public final void dSf()
  {
    AppMethodBeat.i(292100);
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(-1);
    this.AjF.start();
    AppMethodBeat.o(292100);
  }
  
  public final void dSg()
  {
    AppMethodBeat.i(292107);
    this.AjF.setRepeatMode(1);
    this.AjF.setRepeatCount(0);
    this.AjF.end();
    AppMethodBeat.o(292107);
  }
  
  public final void hBd()
  {
    AppMethodBeat.i(292096);
    this.AjC.setVisibility(8);
    this.AjD.setVisibility(8);
    this.AjE.setVisibility(8);
    dSg();
    AppMethodBeat.o(292096);
  }
  
  public final boolean hoc()
  {
    AppMethodBeat.i(292112);
    if ((this.RnQ != null) && (!this.RnQ.gPD()))
    {
      if (this.SGk != null) {
        this.SGk.hBf();
      }
      if ((this.RnQ != null) && (this.RnQ.tP(this.RnP)))
      {
        this.RnP = 0L;
        AppMethodBeat.o(292112);
        return true;
      }
    }
    AppMethodBeat.o(292112);
    return false;
  }
  
  public final void scan(String paramString)
  {
    AppMethodBeat.i(292088);
    if ((this.activity == null) || (this.activity.isFinishing()))
    {
      AppMethodBeat.o(292088);
      return;
    }
    if (this.Ajy == null) {
      this.Ajy = new ImageWordScanDetailEngine(this.activity, (byte)0);
    }
    this.Ajy.a(paramString, this.Ajx);
    AppMethodBeat.o(292088);
  }
  
  public static abstract interface a
  {
    public abstract void hBe();
    
    public abstract void hBf();
    
    public abstract void hBg();
  }
  
  public static abstract interface b
  {
    public abstract String dRR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.a
 * JD-Core Version:    0.7.0.1
 */