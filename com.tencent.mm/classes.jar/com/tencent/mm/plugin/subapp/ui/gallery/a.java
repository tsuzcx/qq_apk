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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.aw.a;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.a.sr.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;

public final class a
{
  a BAi;
  boolean BAj;
  MMActivity activity;
  com.tencent.mm.plugin.scanner.word.a.a rHd;
  com.tencent.mm.plugin.scanner.word.a rHe;
  volatile int rHf;
  int rHg;
  ImageView rHi;
  ImageView rHj;
  ImageView rHk;
  ValueAnimator rHl;
  c<sr> rHm;
  n rHn;
  
  public a(MMActivity paramMMActivity, a parama, com.tencent.mm.plugin.scanner.word.a.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(29062);
    this.rHg = 0;
    this.rHm = new c() {};
    this.rHn = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29057);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29056);
            if ((g.ajj().aFd() != 6) && (g.ajj().aFd() != 4) && (a.this.rHg == 1))
            {
              h.c(a.this.activity, a.this.activity.getString(2131755828), "", true);
              a.this.cyd();
            }
            AppMethodBeat.o(29056);
          }
        });
        AppMethodBeat.o(29057);
      }
    };
    this.rHd = parama1;
    this.activity = paramMMActivity;
    this.BAi = parama;
    this.BAj = paramBoolean;
    this.rHj = ((ImageView)this.activity.findViewById(2131304342));
    this.rHk = ((ImageView)this.activity.findViewById(2131304340));
    this.rHi = ((ImageView)this.activity.findViewById(2131304343));
    paramMMActivity = (FrameLayout.LayoutParams)this.rHk.getLayoutParams();
    paramMMActivity.bottomMargin += al.en(this.activity);
    this.rHk.setLayoutParams(paramMMActivity);
    this.rHk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29058);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = new aw();
        localObject = paramAnonymousView.dmL;
        if (a.this.BAj) {}
        for (int i = 6;; i = 5)
        {
          ((aw.a)localObject).scene = i;
          paramAnonymousView.dmL.dmM = a.this.rHf;
          com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
          a.this.cyd();
          a.this.rHf = 0;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29058);
          return;
        }
      }
    });
    this.rHl = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.rHl.setDuration(5000L);
    this.rHl.addListener(new a.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.rHl.addUpdateListener(new a.5(this, i));
    this.rHm.alive();
    AppMethodBeat.o(29062);
  }
  
  public final void cyd()
  {
    AppMethodBeat.i(29063);
    this.rHg = 0;
    this.rHi.setVisibility(8);
    this.rHj.setVisibility(8);
    this.rHk.setVisibility(8);
    cyf();
    AppMethodBeat.o(29063);
  }
  
  final void cyf()
  {
    AppMethodBeat.i(29064);
    this.rHl.setRepeatMode(1);
    this.rHl.setRepeatCount(0);
    this.rHl.end();
    AppMethodBeat.o(29064);
  }
  
  public static abstract interface a
  {
    public abstract String cxR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.a
 * JD-Core Version:    0.7.0.1
 */