package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Array;
import java.util.Arrays;

public class a
{
  protected int BlD;
  protected int BlE;
  protected int BlF;
  protected View BlG;
  protected View BlH;
  protected View BlI;
  protected View BlJ;
  protected View BlK;
  protected View BlL;
  protected View BlM;
  protected View BlN;
  protected float[][] BlO;
  protected float[] BlP;
  protected b BlQ;
  protected a BlR;
  protected ValueAnimator.AnimatorUpdateListener BlS;
  protected ValueAnimator.AnimatorUpdateListener BlT;
  protected ValueAnimator.AnimatorUpdateListener BlU;
  protected ValueAnimator.AnimatorUpdateListener BlV;
  protected boolean isAnimating;
  protected View rDk;
  protected int tRP;
  protected int tRT;
  
  public a(Context paramContext, final View paramView1, final View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, final View paramView8, View paramView9)
  {
    AppMethodBeat.i(80739);
    this.BlQ = b.Bmb;
    this.BlS = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80731);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.BlO[1][1];
        float f3 = a.this.BlO[1][0];
        float f4 = a.this.BlO[1][0];
        float f5 = a.this.BlO[0][1];
        float f6 = a.this.BlO[0][0];
        float f7 = a.this.BlO[0][0];
        a.this.BlG.setX((f2 - f3) * f1 + f4);
        a.this.BlG.setY((f5 - f6) * f1 + f7);
        f2 = a.this.BlP[1];
        f3 = a.this.BlP[0];
        f4 = a.this.BlP[0];
        a.this.rDk.setY((f2 - f3) * f1 + f4);
        a.this.rDk.setAlpha(1.0F - f1);
        a.this.BlG.setPadding((int)((a.this.BlF - a.this.BlE) * f1 + a.this.BlE), 0, 0, 0);
        ad.v("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarView.paddingLeft %d value %f", new Object[] { Integer.valueOf(a.this.BlG.getPaddingLeft()), Float.valueOf(f1) });
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.BlG.getLayoutParams();
        int i = (int)((1.0F - f1) * a.this.tRT);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.BlO[2][0];
        paramAnonymousValueAnimator.width = ((a.this.tRT - i) * 2 + j);
        a.this.BlG.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80731);
      }
    };
    this.BlT = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80732);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        a.this.BlG.setAlpha(f);
        a.this.rDk.setAlpha(f);
        a.this.BlG.setX(a.this.BlO[1][1]);
        a.this.BlG.setY(a.this.BlO[0][1]);
        a.this.rDk.setY(a.this.BlP[1]);
        a.this.BlG.setPadding((int)(f * (a.this.BlF - a.this.BlE) + a.this.BlE), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.BlG.getLayoutParams();
        if (paramAnonymousValueAnimator.leftMargin != 0)
        {
          paramAnonymousValueAnimator.leftMargin = 0;
          paramAnonymousValueAnimator.rightMargin = 0;
          paramAnonymousValueAnimator.width = ((int)a.this.BlO[2][0] + a.this.tRT * 2);
          a.this.BlG.setLayoutParams(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(80732);
      }
    };
    this.BlU = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80733);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.BlO[1][0];
        float f3 = a.this.BlO[1][1];
        float f4 = a.this.BlO[1][1];
        float f5 = a.this.BlO[0][0];
        float f6 = a.this.BlO[0][1];
        float f7 = a.this.BlO[0][1];
        a.this.BlG.setX((f2 - f3) * f1 + f4);
        a.this.BlG.setY((f5 - f6) * f1 + f7);
        f2 = a.this.BlP[0];
        f3 = a.this.BlP[1];
        f4 = a.this.BlP[1];
        a.this.rDk.setY((f2 - f3) * f1 + f4);
        a.this.rDk.setAlpha(f1);
        a.this.BlG.setPadding((int)((a.this.BlE - a.this.BlF) * f1 + a.this.BlF), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.BlG.getLayoutParams();
        int i = (int)(f1 * a.this.tRT);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.BlO[2][0];
        paramAnonymousValueAnimator.width = ((a.this.tRT - i) * 2 + j);
        a.this.BlG.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80733);
      }
    };
    this.BlV = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80734);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (Math.abs(f - 1.0F) <= 0.001D)
        {
          a.this.BlG.setX(a.this.BlO[1][0]);
          a.this.BlG.setY(a.this.BlO[0][0]);
          a.this.rDk.setY(a.this.BlP[0]);
          a.this.BlG.setPadding(0, 0, 0, 0);
          paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.BlG.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = a.this.tRT;
          paramAnonymousValueAnimator.rightMargin = a.this.tRT;
          paramAnonymousValueAnimator.width = ((int)a.this.BlO[2][0]);
          a.this.BlG.setLayoutParams(paramAnonymousValueAnimator);
          a.this.BlG.setAlpha(1.0F);
          a.this.rDk.setAlpha(1.0F);
          AppMethodBeat.o(80734);
          return;
        }
        a.this.rDk.setAlpha(1.0F - f);
        a.this.BlG.setAlpha(1.0F - f);
        AppMethodBeat.o(80734);
      }
    };
    this.tRT = com.tencent.mm.cd.a.fromDPToPix(paramContext, 24);
    this.tRP = com.tencent.mm.cd.a.fromDPToPix(paramContext, 14);
    this.BlO = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 2 }));
    this.BlP = new float[2];
    this.BlG = paramView1;
    this.rDk = paramView2;
    this.BlH = paramView3;
    this.BlI = paramView4;
    this.BlJ = paramView5;
    this.BlK = paramView6;
    this.BlL = paramView7;
    this.BlM = paramView8;
    this.BlN = paramView9;
    this.BlE = 0;
    this.BlF = (this.tRT * 2);
    this.BlG.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80729);
        a.this.BlO[0][0] = paramView1.getY();
        a.this.BlO[0][1] = 0;
        a.this.BlP[0] = paramView2.getY();
        a.this.BlP[1] = (paramView2.getY() - paramView1.getY());
        a.this.BlO[1][0] = paramView1.getX();
        a.this.BlO[1][1] = 0;
        a.this.BlO[2][0] = paramView1.getMeasuredWidth();
        a.this.BlO[2][1] = (paramView1.getMeasuredWidth() + a.this.tRT * 2);
        ad.i("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarData %s", new Object[] { Arrays.toString(a.this.BlO) });
        AppMethodBeat.o(80729);
      }
    });
    this.BlM.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80730);
        a.this.BlD = paramView8.getMeasuredHeight();
        AppMethodBeat.o(80730);
      }
    });
    AppMethodBeat.o(80739);
  }
  
  public final void TI(int paramInt)
  {
    this.BlO[0][0] = paramInt;
  }
  
  public final void a(a parama)
  {
    this.BlR = parama;
  }
  
  public final void a(b paramb)
  {
    this.BlQ = paramb;
  }
  
  public void b(b paramb)
  {
    AppMethodBeat.i(80740);
    if (paramb == this.BlQ)
    {
      AppMethodBeat.o(80740);
      return;
    }
    switch (7.Bma[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.BlQ = paramb;
      AppMethodBeat.o(80740);
      return;
      epS();
      continue;
      epT();
    }
  }
  
  protected void epS() {}
  
  protected void epT() {}
  
  public static abstract interface a
  {
    public abstract void onAnimationEnd();
    
    public abstract void onAnimationStart();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(80738);
      Bmb = new b("Init", 0);
      Bmc = new b("Search", 1);
      Bmd = new b[] { Bmb, Bmc };
      AppMethodBeat.o(80738);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a
 * JD-Core Version:    0.7.0.1
 */