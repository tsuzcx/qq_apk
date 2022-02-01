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
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.au.a;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.se.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public final class a
{
  MMActivity activity;
  com.tencent.mm.plugin.scanner.word.a.a qOT;
  com.tencent.mm.plugin.scanner.word.a qOU;
  volatile int qOV;
  int qOW;
  ImageView qOY;
  ImageView qOZ;
  ImageView qPa;
  ValueAnimator qPb;
  c<se> qPc;
  n qPd;
  a zRh;
  boolean zRi;
  
  public a(MMActivity paramMMActivity, a parama, com.tencent.mm.plugin.scanner.word.a.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(29062);
    this.qOW = 0;
    this.qPc = new c() {};
    this.qPd = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29057);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29056);
            if ((g.agi().aBK() != 6) && (g.agi().aBK() != 4) && (a.this.qOW == 1))
            {
              h.c(a.this.activity, a.this.activity.getString(2131755828), "", true);
              a.this.cqS();
            }
            AppMethodBeat.o(29056);
          }
        });
        AppMethodBeat.o(29057);
      }
    };
    this.qOT = parama1;
    this.activity = paramMMActivity;
    this.zRh = parama;
    this.zRi = paramBoolean;
    this.qOZ = ((ImageView)this.activity.findViewById(2131304342));
    this.qPa = ((ImageView)this.activity.findViewById(2131304340));
    this.qOY = ((ImageView)this.activity.findViewById(2131304343));
    paramMMActivity = (FrameLayout.LayoutParams)this.qPa.getLayoutParams();
    paramMMActivity.bottomMargin += aj.ej(this.activity);
    this.qPa.setLayoutParams(paramMMActivity);
    this.qPa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29058);
        paramAnonymousView = new au();
        au.a locala = paramAnonymousView.dap;
        if (a.this.zRi) {}
        for (int i = 6;; i = 5)
        {
          locala.scene = i;
          paramAnonymousView.dap.daq = a.this.qOV;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
          a.this.cqS();
          a.this.qOV = 0;
          AppMethodBeat.o(29058);
          return;
        }
      }
    });
    this.qPb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qPb.setDuration(5000L);
    this.qPb.addListener(new a.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.qPb.addUpdateListener(new a.5(this, i));
    this.qPc.alive();
    AppMethodBeat.o(29062);
  }
  
  public final void cqS()
  {
    AppMethodBeat.i(29063);
    this.qOW = 0;
    this.qOY.setVisibility(8);
    this.qOZ.setVisibility(8);
    this.qPa.setVisibility(8);
    cqU();
    AppMethodBeat.o(29063);
  }
  
  final void cqU()
  {
    AppMethodBeat.i(29064);
    this.qPb.setRepeatMode(1);
    this.qPb.setRepeatCount(0);
    this.qPb.end();
    AppMethodBeat.o(29064);
  }
  
  public static abstract interface a
  {
    public abstract String cqG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.a
 * JD-Core Version:    0.7.0.1
 */