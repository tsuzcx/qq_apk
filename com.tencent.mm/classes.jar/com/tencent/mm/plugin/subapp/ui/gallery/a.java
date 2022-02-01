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
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ba;
import com.tencent.mm.f.a.ba.a;
import com.tencent.mm.f.a.ur;
import com.tencent.mm.f.a.ur.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.u;

public final class a
{
  a MeQ;
  boolean MeR;
  MMActivity activity;
  com.tencent.mm.plugin.scanner.word.a.a wNa;
  com.tencent.mm.plugin.scanner.word.a wNb;
  volatile int wNc;
  int wNd;
  ImageView wNf;
  ImageView wNg;
  ImageView wNh;
  ValueAnimator wNi;
  IListener<ur> wNj;
  p wNk;
  
  public a(MMActivity paramMMActivity, a parama, com.tencent.mm.plugin.scanner.word.a.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(29062);
    this.wNd = 0;
    this.wNj = new IListener() {};
    this.wNk = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29057);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29056);
            if ((com.tencent.mm.kernel.h.aGY().bih() != 6) && (com.tencent.mm.kernel.h.aGY().bih() != 4) && (a.this.wNd == 1))
            {
              com.tencent.mm.ui.base.h.c(a.this.activity, a.this.activity.getString(R.l.app_network_unavailable), "", true);
              a.this.dlo();
            }
            AppMethodBeat.o(29056);
          }
        });
        AppMethodBeat.o(29057);
      }
    };
    this.wNa = parama1;
    this.activity = paramMMActivity;
    this.MeQ = parama;
    this.MeR = paramBoolean;
    this.wNg = ((ImageView)this.activity.findViewById(R.h.scan_translate_layer));
    this.wNh = ((ImageView)this.activity.findViewById(R.h.scan_translate_close_btn));
    this.wNf = ((ImageView)this.activity.findViewById(R.h.scan_translate_line));
    paramMMActivity = (FrameLayout.LayoutParams)this.wNh.getLayoutParams();
    paramMMActivity.bottomMargin += ar.aB(this.activity);
    this.wNh.setLayoutParams(paramMMActivity);
    this.wNh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29058);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = new ba();
        localObject = paramAnonymousView.fwL;
        if (a.this.MeR) {}
        for (int i = 6;; i = 5)
        {
          ((ba.a)localObject).scene = i;
          paramAnonymousView.fwL.fwM = a.this.wNc;
          EventCenter.instance.publish(paramAnonymousView);
          a.this.dlo();
          a.this.wNc = 0;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29058);
          return;
        }
      }
    });
    this.wNi = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.wNi.setDuration(5000L);
    this.wNi.addListener(new a.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.wNi.addUpdateListener(new a.5(this, i));
    this.wNj.alive();
    AppMethodBeat.o(29062);
  }
  
  public final void dlo()
  {
    AppMethodBeat.i(29063);
    this.wNd = 0;
    this.wNf.setVisibility(8);
    this.wNg.setVisibility(8);
    this.wNh.setVisibility(8);
    dlq();
    AppMethodBeat.o(29063);
  }
  
  final void dlq()
  {
    AppMethodBeat.i(29064);
    this.wNi.setRepeatMode(1);
    this.wNi.setRepeatCount(0);
    this.wNi.end();
    AppMethodBeat.o(29064);
  }
  
  public static abstract interface a
  {
    public abstract String dlb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.a
 * JD-Core Version:    0.7.0.1
 */