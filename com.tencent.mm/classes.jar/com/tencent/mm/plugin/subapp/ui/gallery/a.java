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
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.at.a;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.rv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

public final class a
{
  MMActivity activity;
  c<rv> qgA;
  n qgB;
  com.tencent.mm.plugin.scanner.word.a.a<String, Integer> qgr;
  com.tencent.mm.plugin.scanner.word.a<String, Integer> qgs;
  volatile int qgt;
  int qgu;
  ImageView qgw;
  ImageView qgx;
  ImageView qgy;
  ValueAnimator qgz;
  a yDT;
  boolean yDU;
  
  public a(MMActivity paramMMActivity, a parama, com.tencent.mm.plugin.scanner.word.a.a<String, Integer> parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(29062);
    this.qgu = 0;
    this.qgA = new c() {};
    this.qgB = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(29057);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(29056);
            if ((g.aeS().auR() != 6) && (g.aeS().auR() != 4) && (a.this.qgu == 1))
            {
              h.c(a.this.activity, a.this.activity.getString(2131755828), "", true);
              a.this.cjl();
            }
            AppMethodBeat.o(29056);
          }
        });
        AppMethodBeat.o(29057);
      }
    };
    this.qgr = parama1;
    this.activity = paramMMActivity;
    this.yDT = parama;
    this.yDU = paramBoolean;
    this.qgx = ((ImageView)this.activity.findViewById(2131304342));
    this.qgy = ((ImageView)this.activity.findViewById(2131304340));
    this.qgw = ((ImageView)this.activity.findViewById(2131304343));
    paramMMActivity = (FrameLayout.LayoutParams)this.qgy.getLayoutParams();
    paramMMActivity.bottomMargin += ai.eb(this.activity);
    this.qgy.setLayoutParams(paramMMActivity);
    this.qgy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29058);
        paramAnonymousView = new at();
        at.a locala = paramAnonymousView.dcR;
        if (a.this.yDU) {}
        for (int i = 6;; i = 5)
        {
          locala.scene = i;
          paramAnonymousView.dcR.dcS = a.this.qgt;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
          a.this.cjl();
          a.this.qgt = 0;
          AppMethodBeat.o(29058);
          return;
        }
      }
    });
    this.qgz = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.qgz.setDuration(5000L);
    this.qgz.addListener(new a.4(this));
    int i = this.activity.getWindowManager().getDefaultDisplay().getHeight();
    this.qgz.addUpdateListener(new a.5(this, i));
    this.qgA.alive();
    AppMethodBeat.o(29062);
  }
  
  public final void cjl()
  {
    AppMethodBeat.i(29063);
    this.qgu = 0;
    this.qgw.setVisibility(8);
    this.qgx.setVisibility(8);
    this.qgy.setVisibility(8);
    cjn();
    AppMethodBeat.o(29063);
  }
  
  final void cjn()
  {
    AppMethodBeat.i(29064);
    this.qgz.setRepeatMode(1);
    this.qgz.setRepeatCount(0);
    this.qgz.end();
    AppMethodBeat.o(29064);
  }
  
  public static abstract interface a
  {
    public abstract String ciZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.a
 * JD-Core Version:    0.7.0.1
 */