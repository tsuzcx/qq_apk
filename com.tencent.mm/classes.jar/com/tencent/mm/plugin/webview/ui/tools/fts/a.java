package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Array;

public class a
{
  protected int FxJ;
  protected int FxO;
  protected int Qme;
  protected int Qmf;
  protected int Qmg;
  protected View Qmh;
  protected View Qmi;
  protected View Qmj;
  protected View Qmk;
  protected View Qml;
  protected View Qmm;
  protected View Qmn;
  protected float[][] Qmo;
  protected float[] Qmp;
  protected b Qmq;
  protected a Qmr;
  protected ValueAnimator.AnimatorUpdateListener Qms;
  protected ValueAnimator.AnimatorUpdateListener Qmt;
  protected ValueAnimator.AnimatorUpdateListener Qmu;
  protected ValueAnimator.AnimatorUpdateListener Qmv;
  protected boolean isAnimating;
  protected View qnL;
  
  public a(Context paramContext, final View paramView1, final View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, final View paramView7, View paramView8)
  {
    AppMethodBeat.i(244405);
    this.Qmq = b.QmB;
    this.Qms = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80732);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.Qmo[1][1];
        float f3 = a.this.Qmo[1][0];
        float f4 = a.this.Qmo[1][0];
        float f5 = a.this.Qmo[0][1];
        float f6 = a.this.Qmo[0][0];
        float f7 = a.this.Qmo[0][0];
        a.this.Qmh.setX((f2 - f3) * f1 + f4);
        a.this.Qmh.setY((f5 - f6) * f1 + f7);
        f2 = a.this.Qmp[1];
        f3 = a.this.Qmp[0];
        f4 = a.this.Qmp[0];
        a.this.qnL.setY((f2 - f3) * f1 + f4);
        a.this.qnL.setAlpha(1.0F - f1);
        a.this.Qmh.setPadding((int)((a.this.Qmg - a.this.Qmf) * f1 + a.this.Qmf), 0, 0, 0);
        Log.v("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarView.paddingLeft %d value %f", new Object[] { Integer.valueOf(a.this.Qmh.getPaddingLeft()), Float.valueOf(f1) });
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.Qmh.getLayoutParams();
        int i = (int)((1.0F - f1) * a.this.FxO);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.Qmo[2][0];
        paramAnonymousValueAnimator.width = ((a.this.FxO - i) * 2 + j);
        a.this.Qmh.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80732);
      }
    };
    this.Qmt = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80733);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        a.this.Qmh.setAlpha(f);
        a.this.qnL.setAlpha(f);
        a.this.Qmh.setX(a.this.Qmo[1][1]);
        a.this.Qmh.setY(a.this.Qmo[0][1]);
        a.this.qnL.setY(a.this.Qmp[1]);
        a.this.Qmh.setPadding((int)(f * (a.this.Qmg - a.this.Qmf) + a.this.Qmf), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.Qmh.getLayoutParams();
        if (paramAnonymousValueAnimator.leftMargin != 0)
        {
          paramAnonymousValueAnimator.leftMargin = 0;
          paramAnonymousValueAnimator.rightMargin = 0;
          paramAnonymousValueAnimator.width = ((int)a.this.Qmo[2][0] + a.this.FxO * 2);
          a.this.Qmh.setLayoutParams(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(80733);
      }
    };
    this.Qmu = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80734);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.Qmo[1][0];
        float f3 = a.this.Qmo[1][1];
        float f4 = a.this.Qmo[1][1];
        float f5 = a.this.Qmo[0][0];
        float f6 = a.this.Qmo[0][1];
        float f7 = a.this.Qmo[0][1];
        a.this.Qmh.setX((f2 - f3) * f1 + f4);
        a.this.Qmh.setY((f5 - f6) * f1 + f7);
        f2 = a.this.Qmp[0];
        f3 = a.this.Qmp[1];
        f4 = a.this.Qmp[1];
        a.this.qnL.setY((f2 - f3) * f1 + f4);
        a.this.qnL.setAlpha(f1);
        a.this.Qmh.setPadding((int)((a.this.Qmf - a.this.Qmg) * f1 + a.this.Qmg), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.Qmh.getLayoutParams();
        int i = (int)(f1 * a.this.FxO);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.Qmo[2][0];
        paramAnonymousValueAnimator.width = ((a.this.FxO - i) * 2 + j);
        a.this.Qmh.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80734);
      }
    };
    this.Qmv = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(268493);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (Math.abs(f - 1.0F) <= 0.001D)
        {
          a.this.Qmh.setX(a.this.Qmo[1][0]);
          a.this.Qmh.setY(a.this.Qmo[0][0]);
          a.this.qnL.setY(a.this.Qmp[0]);
          a.this.Qmh.setPadding(0, 0, 0, 0);
          paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.Qmh.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = a.this.FxO;
          paramAnonymousValueAnimator.rightMargin = a.this.FxO;
          paramAnonymousValueAnimator.width = ((int)a.this.Qmo[2][0]);
          a.this.Qmh.setLayoutParams(paramAnonymousValueAnimator);
          a.this.Qmh.setAlpha(1.0F);
          a.this.qnL.setAlpha(1.0F);
          AppMethodBeat.o(268493);
          return;
        }
        a.this.qnL.setAlpha(1.0F - f);
        a.this.Qmh.setAlpha(1.0F - f);
        AppMethodBeat.o(268493);
      }
    };
    this.FxO = com.tencent.mm.ci.a.fromDPToPix(paramContext, 24);
    this.FxJ = com.tencent.mm.ci.a.fromDPToPix(paramContext, 14);
    this.Qmo = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 2 }));
    this.Qmp = new float[2];
    this.Qmh = paramView1;
    this.qnL = paramView2;
    this.Qmi = paramView3;
    this.Qmj = paramView4;
    this.Qmk = paramView5;
    this.Qml = paramView6;
    this.Qmm = paramView7;
    this.Qmn = paramView8;
    this.Qmf = 0;
    this.Qmg = (this.FxO * 2);
    this.Qmh.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80729);
        a.this.Qmo[0][0] = paramView1.getY();
        a.this.Qmo[0][1] = 0;
        a.this.Qmo[1][0] = paramView1.getX();
        a.this.Qmo[1][1] = 0;
        a.this.Qmo[2][0] = paramView1.getMeasuredWidth();
        a.this.Qmo[2][1] = (paramView1.getMeasuredWidth() + a.this.FxO * 2);
        float[][] arrayOfFloat = a.this.Qmo;
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
    this.qnL.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80730);
        a.this.Qmp[0] = paramView2.getY();
        a.this.Qmp[1] = (paramView2.getY() - paramView1.getY());
        float[] arrayOfFloat = a.this.Qmp;
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
    this.Qmm.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(265017);
        a.this.Qme = paramView7.getMeasuredHeight();
        AppMethodBeat.o(265017);
      }
    });
    AppMethodBeat.o(244405);
  }
  
  public final void a(a parama)
  {
    this.Qmr = parama;
  }
  
  public final void a(b paramb)
  {
    this.Qmq = paramb;
  }
  
  public final void aoN(int paramInt)
  {
    this.Qmo[0][0] = paramInt;
  }
  
  public void b(b paramb)
  {
    AppMethodBeat.i(80740);
    if (paramb == this.Qmq)
    {
      AppMethodBeat.o(80740);
      return;
    }
    switch (8.QmA[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.Qmq = paramb;
      AppMethodBeat.o(80740);
      return;
      hat();
      continue;
      hau();
    }
  }
  
  protected void hat() {}
  
  protected void hau() {}
  
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
      QmB = new b("Init", 0);
      QmC = new b("Search", 1);
      QmD = new b[] { QmB, QmC };
      AppMethodBeat.o(80738);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a
 * JD-Core Version:    0.7.0.1
 */