package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public class a
{
  protected boolean isAnimating;
  protected int oVq;
  protected View vlA;
  protected View vlB;
  protected View vlC;
  protected View vlD;
  protected View vlE;
  protected View vlF;
  protected View vlG;
  protected View vlH;
  protected float[][] vlI;
  protected b vlJ;
  protected a.a vlK;
  protected ValueAnimator.AnimatorUpdateListener vlL;
  protected ValueAnimator.AnimatorUpdateListener vlM;
  protected ValueAnimator.AnimatorUpdateListener vlN;
  protected ValueAnimator.AnimatorUpdateListener vlO;
  protected int vlv;
  protected int vlw;
  protected int vlx;
  protected int vly;
  protected View vlz;
  
  public a(Context paramContext, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8, View paramView9)
  {
    AppMethodBeat.i(8571);
    this.vlJ = b.vlT;
    this.vlL = new a.3(this);
    this.vlM = new a.4(this);
    this.vlN = new a.5(this);
    this.vlO = new a.6(this);
    this.vlv = (com.tencent.mm.cb.a.fromDPToPix(paramContext, 48) / 2);
    this.oVq = ((int)paramContext.getResources().getDimension(2131428726));
    this.vlI = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 2 }));
    this.vlz = paramView1;
    this.vlA = paramView2;
    this.vlB = paramView3;
    this.vlC = paramView4;
    this.vlD = paramView5;
    this.vlE = paramView6;
    this.vlF = paramView7;
    this.vlG = paramView8;
    this.vlH = paramView9;
    this.vlz.post(new a.1(this, paramView1));
    this.vlG.post(new a.2(this, paramView8));
    AppMethodBeat.o(8571);
  }
  
  public final void KN(int paramInt)
  {
    this.vlI[0][0] = paramInt;
  }
  
  public final void a(a.a parama)
  {
    this.vlK = parama;
  }
  
  public final void a(b paramb)
  {
    this.vlJ = paramb;
  }
  
  public void b(b paramb)
  {
    AppMethodBeat.i(8572);
    if (paramb == this.vlJ)
    {
      AppMethodBeat.o(8572);
      return;
    }
    switch (a.7.vlS[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.vlJ = paramb;
      AppMethodBeat.o(8572);
      return;
      dfT();
      continue;
      dfU();
    }
  }
  
  protected void dfT() {}
  
  protected void dfU() {}
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(8570);
      vlT = new b("Init", 0);
      vlU = new b("Search", 1);
      vlV = new b[] { vlT, vlU };
      AppMethodBeat.o(8570);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a
 * JD-Core Version:    0.7.0.1
 */