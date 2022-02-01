package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Array;

public class a
{
  protected int EhA;
  protected int EhB;
  protected View EhC;
  protected View EhD;
  protected View EhE;
  protected View EhF;
  protected View EhG;
  protected View EhH;
  protected View EhI;
  protected float[][] EhJ;
  protected float[] EhK;
  protected b EhL;
  protected a EhM;
  protected ValueAnimator.AnimatorUpdateListener EhN;
  protected ValueAnimator.AnimatorUpdateListener EhO;
  protected ValueAnimator.AnimatorUpdateListener EhP;
  protected ValueAnimator.AnimatorUpdateListener EhQ;
  protected int Ehz;
  protected boolean isAnimating;
  protected View tIJ;
  protected int wfF;
  protected int wfJ;
  
  public a(Context paramContext, final View paramView1, final View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, final View paramView7, View paramView8)
  {
    AppMethodBeat.i(208208);
    this.EhL = b.EhW;
    this.EhN = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80732);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.EhJ[1][1];
        float f3 = a.this.EhJ[1][0];
        float f4 = a.this.EhJ[1][0];
        float f5 = a.this.EhJ[0][1];
        float f6 = a.this.EhJ[0][0];
        float f7 = a.this.EhJ[0][0];
        a.this.EhC.setX((f2 - f3) * f1 + f4);
        a.this.EhC.setY((f5 - f6) * f1 + f7);
        f2 = a.this.EhK[1];
        f3 = a.this.EhK[0];
        f4 = a.this.EhK[0];
        a.this.tIJ.setY((f2 - f3) * f1 + f4);
        a.this.tIJ.setAlpha(1.0F - f1);
        a.this.EhC.setPadding((int)((a.this.EhB - a.this.EhA) * f1 + a.this.EhA), 0, 0, 0);
        ad.v("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarView.paddingLeft %d value %f", new Object[] { Integer.valueOf(a.this.EhC.getPaddingLeft()), Float.valueOf(f1) });
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.EhC.getLayoutParams();
        int i = (int)((1.0F - f1) * a.this.wfJ);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.EhJ[2][0];
        paramAnonymousValueAnimator.width = ((a.this.wfJ - i) * 2 + j);
        a.this.EhC.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80732);
      }
    };
    this.EhO = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80733);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        a.this.EhC.setAlpha(f);
        a.this.tIJ.setAlpha(f);
        a.this.EhC.setX(a.this.EhJ[1][1]);
        a.this.EhC.setY(a.this.EhJ[0][1]);
        a.this.tIJ.setY(a.this.EhK[1]);
        a.this.EhC.setPadding((int)(f * (a.this.EhB - a.this.EhA) + a.this.EhA), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.EhC.getLayoutParams();
        if (paramAnonymousValueAnimator.leftMargin != 0)
        {
          paramAnonymousValueAnimator.leftMargin = 0;
          paramAnonymousValueAnimator.rightMargin = 0;
          paramAnonymousValueAnimator.width = ((int)a.this.EhJ[2][0] + a.this.wfJ * 2);
          a.this.EhC.setLayoutParams(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(80733);
      }
    };
    this.EhP = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80734);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.EhJ[1][0];
        float f3 = a.this.EhJ[1][1];
        float f4 = a.this.EhJ[1][1];
        float f5 = a.this.EhJ[0][0];
        float f6 = a.this.EhJ[0][1];
        float f7 = a.this.EhJ[0][1];
        a.this.EhC.setX((f2 - f3) * f1 + f4);
        a.this.EhC.setY((f5 - f6) * f1 + f7);
        f2 = a.this.EhK[0];
        f3 = a.this.EhK[1];
        f4 = a.this.EhK[1];
        a.this.tIJ.setY((f2 - f3) * f1 + f4);
        a.this.tIJ.setAlpha(f1);
        a.this.EhC.setPadding((int)((a.this.EhA - a.this.EhB) * f1 + a.this.EhB), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.EhC.getLayoutParams();
        int i = (int)(f1 * a.this.wfJ);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.EhJ[2][0];
        paramAnonymousValueAnimator.width = ((a.this.wfJ - i) * 2 + j);
        a.this.EhC.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80734);
      }
    };
    this.EhQ = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(221659);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (Math.abs(f - 1.0F) <= 0.001D)
        {
          a.this.EhC.setX(a.this.EhJ[1][0]);
          a.this.EhC.setY(a.this.EhJ[0][0]);
          a.this.tIJ.setY(a.this.EhK[0]);
          a.this.EhC.setPadding(0, 0, 0, 0);
          paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.EhC.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = a.this.wfJ;
          paramAnonymousValueAnimator.rightMargin = a.this.wfJ;
          paramAnonymousValueAnimator.width = ((int)a.this.EhJ[2][0]);
          a.this.EhC.setLayoutParams(paramAnonymousValueAnimator);
          a.this.EhC.setAlpha(1.0F);
          a.this.tIJ.setAlpha(1.0F);
          AppMethodBeat.o(221659);
          return;
        }
        a.this.tIJ.setAlpha(1.0F - f);
        a.this.EhC.setAlpha(1.0F - f);
        AppMethodBeat.o(221659);
      }
    };
    this.wfJ = com.tencent.mm.cc.a.fromDPToPix(paramContext, 24);
    this.wfF = com.tencent.mm.cc.a.fromDPToPix(paramContext, 14);
    this.EhJ = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 2 }));
    this.EhK = new float[2];
    this.EhC = paramView1;
    this.tIJ = paramView2;
    this.EhD = paramView3;
    this.EhE = paramView4;
    this.EhF = paramView5;
    this.EhG = paramView6;
    this.EhH = paramView7;
    this.EhI = paramView8;
    this.EhA = 0;
    this.EhB = (this.wfJ * 2);
    this.EhC.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80729);
        a.this.EhJ[0][0] = paramView1.getY();
        a.this.EhJ[0][1] = 0;
        a.this.EhJ[1][0] = paramView1.getX();
        a.this.EhJ[1][1] = 0;
        a.this.EhJ[2][0] = paramView1.getMeasuredWidth();
        a.this.EhJ[2][1] = (paramView1.getMeasuredWidth() + a.this.wfJ * 2);
        float[][] arrayOfFloat = a.this.EhJ;
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
        ad.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + localStringBuffer.toString());
        AppMethodBeat.o(80729);
      }
    }, 100L);
    this.tIJ.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80730);
        a.this.EhK[0] = paramView2.getY();
        a.this.EhK[1] = (paramView2.getY() - paramView1.getY());
        float[] arrayOfFloat = a.this.EhK;
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        while (i < arrayOfFloat.length)
        {
          localStringBuffer.append(String.format("[%d]: %.2f,", new Object[] { Integer.valueOf(i), Float.valueOf(arrayOfFloat[i]) }));
          i += 1;
        }
        ad.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + localStringBuffer.toString());
        AppMethodBeat.o(80730);
      }
    }, 150L);
    this.EhH.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221658);
        a.this.Ehz = paramView7.getMeasuredHeight();
        AppMethodBeat.o(221658);
      }
    });
    AppMethodBeat.o(208208);
  }
  
  public final void XH(int paramInt)
  {
    this.EhJ[0][0] = paramInt;
  }
  
  public final void a(a parama)
  {
    this.EhM = parama;
  }
  
  public final void a(b paramb)
  {
    this.EhL = paramb;
  }
  
  public void b(b paramb)
  {
    AppMethodBeat.i(80740);
    if (paramb == this.EhL)
    {
      AppMethodBeat.o(80740);
      return;
    }
    switch (a.8.EhV[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.EhL = paramb;
      AppMethodBeat.o(80740);
      return;
      eUi();
      continue;
      eUj();
    }
  }
  
  protected void eUi() {}
  
  protected void eUj() {}
  
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
      EhW = new b("Init", 0);
      EhX = new b("Search", 1);
      EhY = new b[] { EhW, EhX };
      AppMethodBeat.o(80738);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a
 * JD-Core Version:    0.7.0.1
 */