package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Array;

public class a
{
  protected int EzD;
  protected int EzE;
  protected int EzF;
  protected View EzG;
  protected View EzH;
  protected View EzI;
  protected View EzJ;
  protected View EzK;
  protected View EzL;
  protected View EzM;
  protected float[][] EzN;
  protected float[] EzO;
  protected b EzP;
  protected a EzQ;
  protected ValueAnimator.AnimatorUpdateListener EzR;
  protected ValueAnimator.AnimatorUpdateListener EzS;
  protected ValueAnimator.AnimatorUpdateListener EzT;
  protected ValueAnimator.AnimatorUpdateListener EzU;
  protected boolean isAnimating;
  protected View tTA;
  protected int wvi;
  protected int wvm;
  
  public a(Context paramContext, final View paramView1, final View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, final View paramView7, View paramView8)
  {
    AppMethodBeat.i(198389);
    this.EzP = b.EAa;
    this.EzR = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80732);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.EzN[1][1];
        float f3 = a.this.EzN[1][0];
        float f4 = a.this.EzN[1][0];
        float f5 = a.this.EzN[0][1];
        float f6 = a.this.EzN[0][0];
        float f7 = a.this.EzN[0][0];
        a.this.EzG.setX((f2 - f3) * f1 + f4);
        a.this.EzG.setY((f5 - f6) * f1 + f7);
        f2 = a.this.EzO[1];
        f3 = a.this.EzO[0];
        f4 = a.this.EzO[0];
        a.this.tTA.setY((f2 - f3) * f1 + f4);
        a.this.tTA.setAlpha(1.0F - f1);
        a.this.EzG.setPadding((int)((a.this.EzF - a.this.EzE) * f1 + a.this.EzE), 0, 0, 0);
        ae.v("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarView.paddingLeft %d value %f", new Object[] { Integer.valueOf(a.this.EzG.getPaddingLeft()), Float.valueOf(f1) });
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.EzG.getLayoutParams();
        int i = (int)((1.0F - f1) * a.this.wvm);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.EzN[2][0];
        paramAnonymousValueAnimator.width = ((a.this.wvm - i) * 2 + j);
        a.this.EzG.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80732);
      }
    };
    this.EzS = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80733);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        a.this.EzG.setAlpha(f);
        a.this.tTA.setAlpha(f);
        a.this.EzG.setX(a.this.EzN[1][1]);
        a.this.EzG.setY(a.this.EzN[0][1]);
        a.this.tTA.setY(a.this.EzO[1]);
        a.this.EzG.setPadding((int)(f * (a.this.EzF - a.this.EzE) + a.this.EzE), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.EzG.getLayoutParams();
        if (paramAnonymousValueAnimator.leftMargin != 0)
        {
          paramAnonymousValueAnimator.leftMargin = 0;
          paramAnonymousValueAnimator.rightMargin = 0;
          paramAnonymousValueAnimator.width = ((int)a.this.EzN[2][0] + a.this.wvm * 2);
          a.this.EzG.setLayoutParams(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(80733);
      }
    };
    this.EzT = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80734);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.EzN[1][0];
        float f3 = a.this.EzN[1][1];
        float f4 = a.this.EzN[1][1];
        float f5 = a.this.EzN[0][0];
        float f6 = a.this.EzN[0][1];
        float f7 = a.this.EzN[0][1];
        a.this.EzG.setX((f2 - f3) * f1 + f4);
        a.this.EzG.setY((f5 - f6) * f1 + f7);
        f2 = a.this.EzO[0];
        f3 = a.this.EzO[1];
        f4 = a.this.EzO[1];
        a.this.tTA.setY((f2 - f3) * f1 + f4);
        a.this.tTA.setAlpha(f1);
        a.this.EzG.setPadding((int)((a.this.EzE - a.this.EzF) * f1 + a.this.EzF), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.EzG.getLayoutParams();
        int i = (int)(f1 * a.this.wvm);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.EzN[2][0];
        paramAnonymousValueAnimator.width = ((a.this.wvm - i) * 2 + j);
        a.this.EzG.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80734);
      }
    };
    this.EzU = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(198387);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (Math.abs(f - 1.0F) <= 0.001D)
        {
          a.this.EzG.setX(a.this.EzN[1][0]);
          a.this.EzG.setY(a.this.EzN[0][0]);
          a.this.tTA.setY(a.this.EzO[0]);
          a.this.EzG.setPadding(0, 0, 0, 0);
          paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.EzG.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = a.this.wvm;
          paramAnonymousValueAnimator.rightMargin = a.this.wvm;
          paramAnonymousValueAnimator.width = ((int)a.this.EzN[2][0]);
          a.this.EzG.setLayoutParams(paramAnonymousValueAnimator);
          a.this.EzG.setAlpha(1.0F);
          a.this.tTA.setAlpha(1.0F);
          AppMethodBeat.o(198387);
          return;
        }
        a.this.tTA.setAlpha(1.0F - f);
        a.this.EzG.setAlpha(1.0F - f);
        AppMethodBeat.o(198387);
      }
    };
    this.wvm = com.tencent.mm.cb.a.fromDPToPix(paramContext, 24);
    this.wvi = com.tencent.mm.cb.a.fromDPToPix(paramContext, 14);
    this.EzN = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 2 }));
    this.EzO = new float[2];
    this.EzG = paramView1;
    this.tTA = paramView2;
    this.EzH = paramView3;
    this.EzI = paramView4;
    this.EzJ = paramView5;
    this.EzK = paramView6;
    this.EzL = paramView7;
    this.EzM = paramView8;
    this.EzE = 0;
    this.EzF = (this.wvm * 2);
    this.EzG.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80729);
        a.this.EzN[0][0] = paramView1.getY();
        a.this.EzN[0][1] = 0;
        a.this.EzN[1][0] = paramView1.getX();
        a.this.EzN[1][1] = 0;
        a.this.EzN[2][0] = paramView1.getMeasuredWidth();
        a.this.EzN[2][1] = (paramView1.getMeasuredWidth() + a.this.wvm * 2);
        float[][] arrayOfFloat = a.this.EzN;
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        while (i < arrayOfFloat.length)
        {
          int j = 0;
          while (j < arrayOfFloat[i].length)
          {
            localStringBuffer.append(String.format("[%d,%d]: %.2f,", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Float.valueOf(arrayOfFloat[i][j]) }));
            j += 1;
          }
          i += 1;
        }
        ae.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + localStringBuffer.toString());
        AppMethodBeat.o(80729);
      }
    }, 100L);
    this.tTA.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80730);
        a.this.EzO[0] = paramView2.getY();
        a.this.EzO[1] = (paramView2.getY() - paramView1.getY());
        float[] arrayOfFloat = a.this.EzO;
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        while (i < arrayOfFloat.length)
        {
          localStringBuffer.append(String.format("[%d]: %.2f,", new Object[] { Integer.valueOf(i), Float.valueOf(arrayOfFloat[i]) }));
          i += 1;
        }
        ae.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + localStringBuffer.toString());
        AppMethodBeat.o(80730);
      }
    }, 150L);
    this.EzL.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198386);
        a.this.EzD = paramView7.getMeasuredHeight();
        AppMethodBeat.o(198386);
      }
    });
    AppMethodBeat.o(198389);
  }
  
  public final void Yn(int paramInt)
  {
    this.EzN[0][0] = paramInt;
  }
  
  public final void a(a parama)
  {
    this.EzQ = parama;
  }
  
  public final void a(b paramb)
  {
    this.EzP = paramb;
  }
  
  public void b(b paramb)
  {
    AppMethodBeat.i(80740);
    if (paramb == this.EzP)
    {
      AppMethodBeat.o(80740);
      return;
    }
    switch (8.EzZ[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.EzP = paramb;
      AppMethodBeat.o(80740);
      return;
      eXV();
      continue;
      eXW();
    }
  }
  
  protected void eXV() {}
  
  protected void eXW() {}
  
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
      EAa = new b("Init", 0);
      EAb = new b("Search", 1);
      EAc = new b[] { EAa, EAb };
      AppMethodBeat.o(80738);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a
 * JD-Core Version:    0.7.0.1
 */