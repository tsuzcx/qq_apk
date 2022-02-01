package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.lang.reflect.Array;

public class a
{
  protected int LtV;
  protected int LtY;
  protected int Lua;
  boolean Xcn;
  protected View XeA;
  protected View XeB;
  protected View XeC;
  protected View XeD;
  protected float[][] XeE;
  protected float[] XeF;
  protected a.b XeG;
  protected a XeH;
  protected ValueAnimator.AnimatorUpdateListener XeI;
  protected ValueAnimator.AnimatorUpdateListener XeJ;
  protected ValueAnimator.AnimatorUpdateListener XeK;
  protected ValueAnimator.AnimatorUpdateListener XeL;
  protected int Xes;
  protected int Xet;
  protected int Xeu;
  protected View Xev;
  protected View Xew;
  protected View Xex;
  protected View Xey;
  protected View Xez;
  protected boolean isAnimating;
  protected View tss;
  
  public a(Context paramContext, final View paramView1, final View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, final View paramView7, View paramView8, View paramView9, View paramView10)
  {
    AppMethodBeat.i(296907);
    this.XeG = a.b.XeR;
    this.Xcn = true;
    this.XeI = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80732);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.XeE[1][1];
        float f3 = a.this.XeE[1][0];
        float f4 = a.this.XeE[1][0];
        float f5 = a.this.XeE[0][1];
        float f6 = a.this.XeE[0][0];
        float f7 = a.this.XeE[0][0];
        a.this.Xev.setX((f2 - f3) * f1 + f4);
        a.this.Xev.setY((f5 - f6) * f1 + f7);
        f2 = a.this.XeF[1];
        f3 = a.this.XeF[0];
        f4 = a.this.XeF[0];
        a.this.tss.setY((f2 - f3) * f1 + f4);
        a.this.tss.setAlpha(1.0F - f1);
        if (!a.this.Xcn)
        {
          if (a.this.XeC != null)
          {
            a.this.XeC.setAlpha(f1);
            a.this.XeC.setVisibility(0);
            if (a.this.XeC != null)
            {
              i = (int)(a.this.LtY * (1.0F - f1));
              paramAnonymousValueAnimator = (FrameLayout.LayoutParams)a.this.XeC.getLayoutParams();
              paramAnonymousValueAnimator.leftMargin = i;
              a.this.XeC.setLayoutParams(paramAnonymousValueAnimator);
            }
          }
          if (a.this.XeD != null)
          {
            a.this.XeD.setVisibility(0);
            a.this.XeD.setAlpha(f1);
          }
        }
        a.this.Xev.setPadding((int)((a.this.Xeu - a.this.Xet) * f1 + a.this.Xet), 0, 0, 0);
        Log.v("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarView.paddingLeft %d value %f", new Object[] { Integer.valueOf(a.this.Xev.getPaddingLeft()), Float.valueOf(f1) });
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.Xev.getLayoutParams();
        int i = (int)((1.0F - f1) * a.this.Lua);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.XeE[2][0];
        paramAnonymousValueAnimator.width = ((a.this.Lua - i) * 2 + j);
        a.this.Xev.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80732);
      }
    };
    this.XeJ = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80733);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        a.this.Xev.setAlpha(f);
        a.this.tss.setAlpha(f);
        a.this.Xev.setX(a.this.XeE[1][1]);
        a.this.Xev.setY(a.this.XeE[0][1]);
        a.this.tss.setY(a.this.XeF[1]);
        a.this.Xev.setPadding((int)(f * (a.this.Xeu - a.this.Xet) + a.this.Xet), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.Xev.getLayoutParams();
        if (paramAnonymousValueAnimator.leftMargin != 0)
        {
          paramAnonymousValueAnimator.leftMargin = 0;
          paramAnonymousValueAnimator.rightMargin = 0;
          paramAnonymousValueAnimator.width = ((int)a.this.XeE[2][0] + a.this.Lua * 2);
          a.this.Xev.setLayoutParams(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(80733);
      }
    };
    this.XeK = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80734);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.XeE[1][0];
        float f3 = a.this.XeE[1][1];
        float f4 = a.this.XeE[1][1];
        float f5 = a.this.XeE[0][0];
        float f6 = a.this.XeE[0][1];
        float f7 = a.this.XeE[0][1];
        a.this.Xev.setX((f2 - f3) * f1 + f4);
        a.this.Xev.setY((f5 - f6) * f1 + f7);
        f2 = a.this.XeF[0];
        f3 = a.this.XeF[1];
        f4 = a.this.XeF[1];
        a.this.tss.setY((f2 - f3) * f1 + f4);
        a.this.tss.setAlpha(f1);
        if (!a.this.Xcn)
        {
          if (a.this.XeC != null)
          {
            a.this.XeC.setAlpha(1.0F - f1);
            a.this.XeC.setVisibility(0);
            if (a.this.XeC != null)
            {
              i = (int)(a.this.LtY * f1);
              paramAnonymousValueAnimator = (FrameLayout.LayoutParams)a.this.XeC.getLayoutParams();
              paramAnonymousValueAnimator.leftMargin = i;
              a.this.XeC.setLayoutParams(paramAnonymousValueAnimator);
            }
          }
          if (a.this.XeD != null)
          {
            a.this.XeD.setVisibility(0);
            a.this.XeD.setAlpha(1.0F - f1);
          }
        }
        a.this.Xev.setPadding((int)((a.this.Xet - a.this.Xeu) * f1 + a.this.Xeu), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.Xev.getLayoutParams();
        int i = (int)(f1 * a.this.Lua);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.XeE[2][0];
        paramAnonymousValueAnimator.width = ((a.this.Lua - i) * 2 + j);
        a.this.Xev.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80734);
      }
    };
    this.XeL = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(296812);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (Math.abs(f - 1.0F) <= 0.001D)
        {
          a.this.Xev.setX(a.this.XeE[1][0]);
          a.this.Xev.setY(a.this.XeE[0][0]);
          a.this.tss.setY(a.this.XeF[0]);
          a.this.Xev.setPadding(0, 0, 0, 0);
          paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.Xev.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = a.this.Lua;
          paramAnonymousValueAnimator.rightMargin = a.this.Lua;
          paramAnonymousValueAnimator.width = ((int)a.this.XeE[2][0]);
          a.this.Xev.setLayoutParams(paramAnonymousValueAnimator);
          a.this.Xev.setAlpha(1.0F);
          a.this.tss.setAlpha(1.0F);
          AppMethodBeat.o(296812);
          return;
        }
        a.this.tss.setAlpha(1.0F - f);
        a.this.Xev.setAlpha(1.0F - f);
        AppMethodBeat.o(296812);
      }
    };
    this.Lua = com.tencent.mm.cd.a.fromDPToPix(paramContext, 24);
    this.LtV = com.tencent.mm.cd.a.fromDPToPix(paramContext, 14);
    this.LtY = com.tencent.mm.cd.a.fromDPToPix(paramContext, 16);
    this.XeE = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 2 }));
    this.XeF = new float[2];
    this.Xev = paramView1;
    this.tss = paramView2;
    this.Xew = paramView3;
    this.Xex = paramView4;
    this.Xey = paramView5;
    this.Xez = paramView6;
    this.XeA = paramView7;
    this.XeB = paramView8;
    this.XeC = paramView9;
    this.XeD = paramView10;
    this.Xet = 0;
    this.Xeu = (this.Lua * 2);
    this.Xev.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80729);
        a.this.XeE[0][0] = paramView1.getY();
        a.this.XeE[0][1] = 0;
        a.this.XeE[1][0] = paramView1.getX();
        a.this.XeE[1][1] = 0;
        a.this.XeE[2][0] = paramView1.getMeasuredWidth();
        a.this.XeE[2][1] = (paramView1.getMeasuredWidth() + a.this.Lua * 2);
        float[][] arrayOfFloat = a.this.XeE;
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
        Log.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + localStringBuffer.toString());
        AppMethodBeat.o(80729);
      }
    }, 100L);
    this.tss.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80730);
        a.this.XeF[0] = paramView2.getY();
        a.this.XeF[1] = (paramView2.getY() - paramView1.getY());
        float[] arrayOfFloat = a.this.XeF;
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        while (i < arrayOfFloat.length)
        {
          localStringBuffer.append(String.format("[%d]: %.2f,", new Object[] { Integer.valueOf(i), Float.valueOf(arrayOfFloat[i]) }));
          i += 1;
        }
        Log.i("MicroMsg.WebSearch.SosAnimatorBaseController", "printArray:" + localStringBuffer.toString());
        AppMethodBeat.o(80730);
      }
    }, 150L);
    this.XeA.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(296814);
        a.this.Xes = paramView7.getMeasuredHeight();
        AppMethodBeat.o(296814);
      }
    });
    this.Xcn = FTSEditTextView.jCA();
    AppMethodBeat.o(296907);
  }
  
  public final void a(a parama)
  {
    this.XeH = parama;
  }
  
  public final void a(a.b paramb)
  {
    this.XeG = paramb;
  }
  
  public final void auI(int paramInt)
  {
    this.XeE[0][0] = paramInt;
  }
  
  public void b(a.b paramb)
  {
    AppMethodBeat.i(80740);
    if (paramb == this.XeG)
    {
      AppMethodBeat.o(80740);
      return;
    }
    switch (a.8.XeQ[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.XeG = paramb;
      AppMethodBeat.o(80740);
      return;
      iAG();
      continue;
      iAH();
    }
  }
  
  public final a.b iAF()
  {
    return this.XeG;
  }
  
  protected void iAG() {}
  
  protected void iAH() {}
  
  public static abstract interface a
  {
    public abstract void onAnimationEnd();
    
    public abstract void onAnimationStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a
 * JD-Core Version:    0.7.0.1
 */