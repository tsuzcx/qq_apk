package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Array;
import java.util.Arrays;

public class a
{
  protected int CDO;
  protected int CDP;
  protected int CDQ;
  protected View CDR;
  protected View CDS;
  protected View CDT;
  protected View CDU;
  protected View CDV;
  protected View CDW;
  protected View CDX;
  protected float[][] CDY;
  protected float[] CDZ;
  protected b CEa;
  protected a CEb;
  protected ValueAnimator.AnimatorUpdateListener CEc;
  protected ValueAnimator.AnimatorUpdateListener CEd;
  protected ValueAnimator.AnimatorUpdateListener CEe;
  protected ValueAnimator.AnimatorUpdateListener CEf;
  protected boolean isAnimating;
  protected View sMc;
  protected int vaA;
  protected int vaw;
  
  public a(Context paramContext, final View paramView1, final View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, final View paramView7, View paramView8)
  {
    AppMethodBeat.i(188538);
    this.CEa = b.CEl;
    this.CEc = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80731);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.CDY[1][1];
        float f3 = a.this.CDY[1][0];
        float f4 = a.this.CDY[1][0];
        float f5 = a.this.CDY[0][1];
        float f6 = a.this.CDY[0][0];
        float f7 = a.this.CDY[0][0];
        a.this.CDR.setX((f2 - f3) * f1 + f4);
        a.this.CDR.setY((f5 - f6) * f1 + f7);
        f2 = a.this.CDZ[1];
        f3 = a.this.CDZ[0];
        f4 = a.this.CDZ[0];
        a.this.sMc.setY((f2 - f3) * f1 + f4);
        a.this.sMc.setAlpha(1.0F - f1);
        a.this.CDR.setPadding((int)((a.this.CDQ - a.this.CDP) * f1 + a.this.CDP), 0, 0, 0);
        ac.v("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarView.paddingLeft %d value %f", new Object[] { Integer.valueOf(a.this.CDR.getPaddingLeft()), Float.valueOf(f1) });
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.CDR.getLayoutParams();
        int i = (int)((1.0F - f1) * a.this.vaA);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.CDY[2][0];
        paramAnonymousValueAnimator.width = ((a.this.vaA - i) * 2 + j);
        a.this.CDR.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80731);
      }
    };
    this.CEd = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80732);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        a.this.CDR.setAlpha(f);
        a.this.sMc.setAlpha(f);
        a.this.CDR.setX(a.this.CDY[1][1]);
        a.this.CDR.setY(a.this.CDY[0][1]);
        a.this.sMc.setY(a.this.CDZ[1]);
        a.this.CDR.setPadding((int)(f * (a.this.CDQ - a.this.CDP) + a.this.CDP), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.CDR.getLayoutParams();
        if (paramAnonymousValueAnimator.leftMargin != 0)
        {
          paramAnonymousValueAnimator.leftMargin = 0;
          paramAnonymousValueAnimator.rightMargin = 0;
          paramAnonymousValueAnimator.width = ((int)a.this.CDY[2][0] + a.this.vaA * 2);
          a.this.CDR.setLayoutParams(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(80732);
      }
    };
    this.CEe = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80733);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.CDY[1][0];
        float f3 = a.this.CDY[1][1];
        float f4 = a.this.CDY[1][1];
        float f5 = a.this.CDY[0][0];
        float f6 = a.this.CDY[0][1];
        float f7 = a.this.CDY[0][1];
        a.this.CDR.setX((f2 - f3) * f1 + f4);
        a.this.CDR.setY((f5 - f6) * f1 + f7);
        f2 = a.this.CDZ[0];
        f3 = a.this.CDZ[1];
        f4 = a.this.CDZ[1];
        a.this.sMc.setY((f2 - f3) * f1 + f4);
        a.this.sMc.setAlpha(f1);
        a.this.CDR.setPadding((int)((a.this.CDP - a.this.CDQ) * f1 + a.this.CDQ), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.CDR.getLayoutParams();
        int i = (int)(f1 * a.this.vaA);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.CDY[2][0];
        paramAnonymousValueAnimator.width = ((a.this.vaA - i) * 2 + j);
        a.this.CDR.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80733);
      }
    };
    this.CEf = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80734);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (Math.abs(f - 1.0F) <= 0.001D)
        {
          a.this.CDR.setX(a.this.CDY[1][0]);
          a.this.CDR.setY(a.this.CDY[0][0]);
          a.this.sMc.setY(a.this.CDZ[0]);
          a.this.CDR.setPadding(0, 0, 0, 0);
          paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.CDR.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = a.this.vaA;
          paramAnonymousValueAnimator.rightMargin = a.this.vaA;
          paramAnonymousValueAnimator.width = ((int)a.this.CDY[2][0]);
          a.this.CDR.setLayoutParams(paramAnonymousValueAnimator);
          a.this.CDR.setAlpha(1.0F);
          a.this.sMc.setAlpha(1.0F);
          AppMethodBeat.o(80734);
          return;
        }
        a.this.sMc.setAlpha(1.0F - f);
        a.this.CDR.setAlpha(1.0F - f);
        AppMethodBeat.o(80734);
      }
    };
    this.vaA = com.tencent.mm.cc.a.fromDPToPix(paramContext, 24);
    this.vaw = com.tencent.mm.cc.a.fromDPToPix(paramContext, 14);
    this.CDY = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 2 }));
    this.CDZ = new float[2];
    this.CDR = paramView1;
    this.sMc = paramView2;
    this.CDS = paramView3;
    this.CDT = paramView4;
    this.CDU = paramView5;
    this.CDV = paramView6;
    this.CDW = paramView7;
    this.CDX = paramView8;
    this.CDP = 0;
    this.CDQ = (this.vaA * 2);
    this.CDR.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80729);
        a.this.CDY[0][0] = paramView1.getY();
        a.this.CDY[0][1] = 0;
        a.this.CDZ[0] = paramView2.getY();
        a.this.CDZ[1] = (paramView2.getY() - paramView1.getY());
        a.this.CDY[1][0] = paramView1.getX();
        a.this.CDY[1][1] = 0;
        a.this.CDY[2][0] = paramView1.getMeasuredWidth();
        a.this.CDY[2][1] = (paramView1.getMeasuredWidth() + a.this.vaA * 2);
        ac.i("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarData %s", new Object[] { Arrays.toString(a.this.CDY) });
        AppMethodBeat.o(80729);
      }
    });
    this.CDW.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(80730);
        a.this.CDO = paramView7.getMeasuredHeight();
        AppMethodBeat.o(80730);
      }
    });
    AppMethodBeat.o(188538);
  }
  
  public final void VQ(int paramInt)
  {
    this.CDY[0][0] = paramInt;
  }
  
  public final void a(a parama)
  {
    this.CEb = parama;
  }
  
  public final void a(b paramb)
  {
    this.CEa = paramb;
  }
  
  public void b(b paramb)
  {
    AppMethodBeat.i(80740);
    if (paramb == this.CEa)
    {
      AppMethodBeat.o(80740);
      return;
    }
    switch (7.CEk[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.CEa = paramb;
      AppMethodBeat.o(80740);
      return;
      eFm();
      continue;
      eFn();
    }
  }
  
  protected void eFm() {}
  
  protected void eFn() {}
  
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
      CEl = new b("Init", 0);
      CEm = new b("Search", 1);
      CEn = new b[] { CEl, CEm };
      AppMethodBeat.o(80738);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a
 * JD-Core Version:    0.7.0.1
 */