package com.tencent.mm.plugin.subapp.ui.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.ay.a;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.a.tp.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;

public final class a
{
  a FKT;
  boolean FKU;
  MMActivity activity;
  com.tencent.mm.plugin.scanner.word.a.a tgK;
  com.tencent.mm.plugin.scanner.word.a tgL;
  volatile int tgM;
  int tgN;
  ImageView tgP;
  ImageView tgQ;
  ImageView tgR;
  ValueAnimator tgS;
  IListener<tp> tgT;
  p tgU;
  
  public a(MMActivity paramMMActivity, a parama, com.tencent.mm.plugin.scanner.word.a.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(29062);
    this.tgN = 0;
    this.tgT = new IListener() {};
    this.tgU = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29057);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29056);
            if ((g.azz().aYS() != 6) && (g.azz().aYS() != 4) && (a.this.tgN == 1))
            {
              h.c(a.this.activity, a.this.activity.getString(2131755914), "", true);
              a.this.cWh();
            }
            AppMethodBeat.o(29056);
          }
        });
        AppMethodBeat.o(29057);
      }
    };
    this.tgK = parama1;
    this.activity = paramMMActivity;
    this.FKT = parama;
    this.FKU = paramBoolean;
    this.tgQ = ((ImageView)this.activity.findViewById(2131307274));
    this.tgR = ((ImageView)this.activity.findViewById(2131307272));
    this.tgP = ((ImageView)this.activity.findViewById(2131307275));
    paramMMActivity = (FrameLayout.LayoutParams)this.tgR.getLayoutParams();
    paramMMActivity.bottomMargin += ao.aD(this.activity);
    this.tgR.setLayoutParams(paramMMActivity);
    this.tgR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29058);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = new ay();
        localObject = paramAnonymousView.dEa;
        if (a.this.FKU) {}
        for (int i = 6;; i = 5)
        {
          ((ay.a)localObject).scene = i;
          paramAnonymousView.dEa.dEb = a.this.tgM;
          EventCenter.instance.publish(paramAnonymousView);
          a.this.cWh();
          a.this.tgM = 0;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29058);
          return;
        }
      }
    });
    this.tgS = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.tgS.setDuration(5000L);
    this.tgS.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(29060);
        a.this.tgP.setAlpha(0.0F);
        AppMethodBeat.o(29060);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(29059);
        a.this.tgP.setAlpha(0.0F);
        AppMethodBeat.o(29059);
      }
    });
    final int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(29061);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f <= 0.1F) {
          a.this.tgP.setAlpha(f * 10.0F);
        }
        for (;;)
        {
          a.this.tgP.setTranslationY(f * (i - a.this.tgP.getHeight()));
          AppMethodBeat.o(29061);
          return;
          if (f >= 0.9F) {
            a.this.tgP.setAlpha((1.0F - f) * 10.0F);
          }
        }
      }
    });
    this.tgT.alive();
    AppMethodBeat.o(29062);
  }
  
  public final void cWh()
  {
    AppMethodBeat.i(29063);
    this.tgN = 0;
    this.tgP.setVisibility(8);
    this.tgQ.setVisibility(8);
    this.tgR.setVisibility(8);
    cWj();
    AppMethodBeat.o(29063);
  }
  
  final void cWj()
  {
    AppMethodBeat.i(29064);
    this.tgS.setRepeatMode(1);
    this.tgS.setRepeatCount(0);
    this.tgS.end();
    AppMethodBeat.o(29064);
  }
  
  public static abstract interface a
  {
    public abstract String cVV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.a
 * JD-Core Version:    0.7.0.1
 */