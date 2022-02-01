package com.tencent.mm.plugin.subapp.ui.gallery;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.aw.a;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sq.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public final class a
{
  a BiJ;
  boolean BiK;
  MMActivity activity;
  com.tencent.mm.plugin.scanner.word.a.a ryS;
  com.tencent.mm.plugin.scanner.word.a ryT;
  volatile int ryU;
  int ryV;
  ImageView ryX;
  ImageView ryY;
  ImageView ryZ;
  ValueAnimator rza;
  c<sq> rzb;
  n rzc;
  
  public a(MMActivity paramMMActivity, a parama, com.tencent.mm.plugin.scanner.word.a.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(29062);
    this.ryV = 0;
    this.rzb = new c() {};
    this.rzc = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29057);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29056);
            if ((g.aiU().aEN() != 6) && (g.aiU().aEN() != 4) && (a.this.ryV == 1))
            {
              h.c(a.this.activity, a.this.activity.getString(2131755828), "", true);
              a.this.cwC();
            }
            AppMethodBeat.o(29056);
          }
        });
        AppMethodBeat.o(29057);
      }
    };
    this.ryS = parama1;
    this.activity = paramMMActivity;
    this.BiJ = parama;
    this.BiK = paramBoolean;
    this.ryY = ((ImageView)this.activity.findViewById(2131304342));
    this.ryZ = ((ImageView)this.activity.findViewById(2131304340));
    this.ryX = ((ImageView)this.activity.findViewById(2131304343));
    paramMMActivity = (FrameLayout.LayoutParams)this.ryZ.getLayoutParams();
    paramMMActivity.bottomMargin += al.ej(this.activity);
    this.ryZ.setLayoutParams(paramMMActivity);
    this.ryZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29058);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = new aw();
        localObject = paramAnonymousView.dlJ;
        if (a.this.BiK) {}
        for (int i = 6;; i = 5)
        {
          ((aw.a)localObject).scene = i;
          paramAnonymousView.dlJ.dlK = a.this.ryU;
          com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
          a.this.cwC();
          a.this.ryU = 0;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29058);
          return;
        }
      }
    });
    this.rza = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rza.setDuration(5000L);
    this.rza.addListener(new a.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.rza.addUpdateListener(new a.5(this, i));
    this.rzb.alive();
    AppMethodBeat.o(29062);
  }
  
  public final void cwC()
  {
    AppMethodBeat.i(29063);
    this.ryV = 0;
    this.ryX.setVisibility(8);
    this.ryY.setVisibility(8);
    this.ryZ.setVisibility(8);
    cwE();
    AppMethodBeat.o(29063);
  }
  
  final void cwE()
  {
    AppMethodBeat.i(29064);
    this.rza.setRepeatMode(1);
    this.rza.setRepeatCount(0);
    this.rza.end();
    AppMethodBeat.o(29064);
  }
  
  public static abstract interface a
  {
    public abstract String cwq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.a
 * JD-Core Version:    0.7.0.1
 */