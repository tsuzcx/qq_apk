package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mm.R.f;
import java.lang.reflect.Array;

public class a
{
  protected View iaE;
  protected boolean isAnimating;
  protected int mvy;
  protected int rvg;
  protected int rvh;
  protected int rvi;
  protected int rvj;
  protected View rvk;
  protected View rvl;
  protected View rvm;
  protected View rvn;
  protected View rvo;
  protected View rvp;
  protected View rvq;
  protected View rvr;
  protected float[][] rvs;
  protected b rvt = b.rvD;
  protected a.a rvu;
  protected ValueAnimator.AnimatorUpdateListener rvv = new a.3(this);
  protected ValueAnimator.AnimatorUpdateListener rvw = new a.4(this);
  protected ValueAnimator.AnimatorUpdateListener rvx = new a.5(this);
  protected ValueAnimator.AnimatorUpdateListener rvy = new a.6(this);
  
  public a(Context paramContext, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, View paramView6, View paramView7, View paramView8, View paramView9)
  {
    this.rvg = (com.tencent.mm.cb.a.fromDPToPix(paramContext, 48) / 2);
    this.mvy = ((int)paramContext.getResources().getDimension(R.f.sos_search_edittext_margin));
    this.rvs = ((float[][])Array.newInstance(Float.TYPE, new int[] { 3, 2 }));
    this.rvk = paramView1;
    this.rvl = paramView2;
    this.rvm = paramView3;
    this.rvn = paramView4;
    this.rvo = paramView5;
    this.iaE = paramView6;
    this.rvp = paramView7;
    this.rvq = paramView8;
    this.rvr = paramView9;
    this.rvk.post(new a.1(this, paramView1));
    this.rvq.post(new a.2(this, paramView8));
  }
  
  public final void CS(int paramInt)
  {
    this.rvs[0][0] = paramInt;
  }
  
  public final void a(a.a parama)
  {
    this.rvu = parama;
  }
  
  public final void a(b paramb)
  {
    this.rvt = paramb;
  }
  
  public void b(b paramb)
  {
    if (paramb == this.rvt) {
      return;
    }
    switch (7.rvC[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.rvt = paramb;
      return;
      cfK();
      continue;
      cfL();
    }
  }
  
  protected void cfK() {}
  
  protected void cfL() {}
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.a
 * JD-Core Version:    0.7.0.1
 */