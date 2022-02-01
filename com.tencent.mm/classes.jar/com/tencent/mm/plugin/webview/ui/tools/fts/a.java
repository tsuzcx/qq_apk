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
  protected int JoK;
  protected int JoL;
  protected int JoM;
  protected View JoN;
  protected View JoO;
  protected View JoP;
  protected View JoQ;
  protected View JoR;
  protected View JoS;
  protected View JoT;
  protected float[][] JoU;
  protected float[] JoV;
  protected b JoW;
  protected a JoX;
  protected ValueAnimator.AnimatorUpdateListener JoY;
  protected ValueAnimator.AnimatorUpdateListener JoZ;
  protected ValueAnimator.AnimatorUpdateListener Jpa;
  protected ValueAnimator.AnimatorUpdateListener Jpb;
  protected boolean isAnimating;
  protected View nmd;
  protected int zSh;
  protected int zSm;
  
  public a(Context paramContext, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8)
  {
    AppMethodBeat.i(211295);
    this.JoW = b.Jph;
    this.JoY = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80732);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.JoU[1][1];
        float f3 = a.this.JoU[1][0];
        float f4 = a.this.JoU[1][0];
        float f5 = a.this.JoU[0][1];
        float f6 = a.this.JoU[0][0];
        float f7 = a.this.JoU[0][0];
        a.this.JoN.setX((f2 - f3) * f1 + f4);
        a.this.JoN.setY((f5 - f6) * f1 + f7);
        f2 = a.this.JoV[1];
        f3 = a.this.JoV[0];
        f4 = a.this.JoV[0];
        a.this.nmd.setY((f2 - f3) * f1 + f4);
        a.this.nmd.setAlpha(1.0F - f1);
        a.this.JoN.setPadding((int)((a.this.JoM - a.this.JoL) * f1 + a.this.JoL), 0, 0, 0);
        Log.v("MicroMsg.WebSearch.SosAnimatorBaseController", "searchBarView.paddingLeft %d value %f", new Object[] { Integer.valueOf(a.this.JoN.getPaddingLeft()), Float.valueOf(f1) });
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.JoN.getLayoutParams();
        int i = (int)((1.0F - f1) * a.this.zSm);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.JoU[2][0];
        paramAnonymousValueAnimator.width = ((a.this.zSm - i) * 2 + j);
        a.this.JoN.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80732);
      }
    };
    this.JoZ = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80733);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        a.this.JoN.setAlpha(f);
        a.this.nmd.setAlpha(f);
        a.this.JoN.setX(a.this.JoU[1][1]);
        a.this.JoN.setY(a.this.JoU[0][1]);
        a.this.nmd.setY(a.this.JoV[1]);
        a.this.JoN.setPadding((int)(f * (a.this.JoM - a.this.JoL) + a.this.JoL), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.JoN.getLayoutParams();
        if (paramAnonymousValueAnimator.leftMargin != 0)
        {
          paramAnonymousValueAnimator.leftMargin = 0;
          paramAnonymousValueAnimator.rightMargin = 0;
          paramAnonymousValueAnimator.width = ((int)a.this.JoU[2][0] + a.this.zSm * 2);
          a.this.JoN.setLayoutParams(paramAnonymousValueAnimator);
        }
        AppMethodBeat.o(80733);
      }
    };
    this.Jpa = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(80734);
        float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        float f2 = a.this.JoU[1][0];
        float f3 = a.this.JoU[1][1];
        float f4 = a.this.JoU[1][1];
        float f5 = a.this.JoU[0][0];
        float f6 = a.this.JoU[0][1];
        float f7 = a.this.JoU[0][1];
        a.this.JoN.setX((f2 - f3) * f1 + f4);
        a.this.JoN.setY((f5 - f6) * f1 + f7);
        f2 = a.this.JoV[0];
        f3 = a.this.JoV[1];
        f4 = a.this.JoV[1];
        a.this.nmd.setY((f2 - f3) * f1 + f4);
        a.this.nmd.setAlpha(f1);
        a.this.JoN.setPadding((int)((a.this.JoL - a.this.JoM) * f1 + a.this.JoM), 0, 0, 0);
        paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.JoN.getLayoutParams();
        int i = (int)(f1 * a.this.zSm);
        paramAnonymousValueAnimator.leftMargin = i;
        paramAnonymousValueAnimator.rightMargin = i;
        int j = (int)a.this.JoU[2][0];
        paramAnonymousValueAnimator.width = ((a.this.zSm - i) * 2 + j);
        a.this.JoN.setLayoutParams(paramAnonymousValueAnimator);
        AppMethodBeat.o(80734);
      }
    };
    this.Jpb = new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(211293);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (Math.abs(f - 1.0F) <= 0.001D)
        {
          a.this.JoN.setX(a.this.JoU[1][0]);
          a.this.JoN.setY(a.this.JoU[0][0]);
          a.this.nmd.setY(a.this.JoV[0]);
          a.this.JoN.setPadding(0, 0, 0, 0);
          paramAnonymousValueAnimator = (RelativeLayout.LayoutParams)a.this.JoN.getLayoutParams();
          paramAnonymousValueAnimator.leftMargin = a.this.zSm;
          paramAnonymousValueAnimator.rightMargin = a.this.zSm;
          paramAnonymousValueAnimator.width = ((int)a.this.JoU[2][0]);
          a.this.JoN.setLayoutParams(paramAnonymousValueAnimator);
          a.this.JoN.setAlpha(1.0F);
          a.this.nmd.setAlpha(1.0F);
          AppMethodBeat.o(211293);
          return;
        }
        a.this.nmd.setAlpha(1.0F - f);
        a.this.JoN.setAlpha(1.0F - f);
        AppMethodBeat.o(211293);
      }
    };
    this.zSm = com.tencent.mm.cb.a.fromDPToPix(paramContext, 24);
    this.zSh = com.tencent.mm.cb.a.fromDPToPix(paramContext, 14);
    this.JoU = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 2 }));
    this.JoV = new float[2];
    this.JoN = paramView1;
    this.nmd = paramView2;
    this.JoO = paramView3;
    this.JoP = paramView4;
    this.JoQ = paramView5;
    this.JoR = paramView6;
    this.JoS = paramView7;
    this.JoT = paramView8;
    this.JoL = 0;
    this.JoM = (this.zSm * 2);
    this.JoN.postDelayed(new a.1(this, paramView1), 100L);
    this.nmd.postDelayed(new a.2(this, paramView2, paramView1), 150L);
    this.JoS.post(new a.3(this, paramView7));
    AppMethodBeat.o(211295);
  }
  
  public final void a(a parama)
  {
    this.JoX = parama;
  }
  
  public final void a(b paramb)
  {
    this.JoW = paramb;
  }
  
  public final void agW(int paramInt)
  {
    this.JoU[0][0] = paramInt;
  }
  
  public void b(b paramb)
  {
    AppMethodBeat.i(80740);
    if (paramb == this.JoW)
    {
      AppMethodBeat.o(80740);
      return;
    }
    switch (8.Jpg[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.JoW = paramb;
      AppMethodBeat.o(80740);
      return;
      gha();
      continue;
      ghb();
    }
  }
  
  protected void gha() {}
  
  protected void ghb() {}
  
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
      Jph = new b("Init", 0);
      Jpi = new b("Search", 1);
      Jpj = new b[] { Jph, Jpi };
      AppMethodBeat.o(80738);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a
 * JD-Core Version:    0.7.0.1
 */