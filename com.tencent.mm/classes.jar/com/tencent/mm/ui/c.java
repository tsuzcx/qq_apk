package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private int RnB;
  private boolean VQn;
  private a VQo;
  public View VQp;
  private int VQq;
  public ViewGroup.LayoutParams VQr;
  private int VQs;
  private Context mContext;
  public ViewTreeObserver.OnGlobalLayoutListener qc;
  
  private c(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(141275);
    this.VQn = false;
    this.qc = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141271);
        c.a(c.this);
        AppMethodBeat.o(141271);
      }
    };
    this.mContext = paramActivity;
    this.VQn = paramBoolean;
    paramActivity = (FrameLayout)paramActivity.findViewById(16908290);
    if (paramActivity == null)
    {
      AppMethodBeat.o(141275);
      return;
    }
    this.VQp = paramActivity.getChildAt(0);
    this.VQp.getViewTreeObserver().addOnGlobalLayoutListener(this.qc);
    this.VQr = this.VQp.getLayoutParams();
    AppMethodBeat.o(141275);
  }
  
  private c(Activity paramActivity, boolean paramBoolean, View paramView, a parama)
  {
    AppMethodBeat.i(141276);
    this.VQn = false;
    this.qc = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141271);
        c.a(c.this);
        AppMethodBeat.o(141271);
      }
    };
    this.mContext = paramActivity;
    this.VQn = paramBoolean;
    this.VQp = paramView;
    this.VQo = parama;
    this.VQp.getViewTreeObserver().addOnGlobalLayoutListener(this.qc);
    this.VQr = this.VQp.getLayoutParams();
    AppMethodBeat.o(141276);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, View paramView, a parama)
  {
    AppMethodBeat.i(141274);
    new c(paramActivity, paramBoolean, paramView, parama);
    AppMethodBeat.o(141274);
  }
  
  public static c bh(Activity paramActivity)
  {
    AppMethodBeat.i(219343);
    paramActivity = new c(paramActivity, false);
    AppMethodBeat.o(219343);
    return paramActivity;
  }
  
  public static void f(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(141273);
    new c(paramActivity, paramBoolean);
    AppMethodBeat.o(141273);
  }
  
  public static abstract interface a
  {
    public abstract void ca(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.c
 * JD-Core Version:    0.7.0.1
 */