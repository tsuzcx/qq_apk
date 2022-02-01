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
  private int YjR;
  private int aduA;
  private boolean aduv;
  private a aduw;
  public View adux;
  private int aduy;
  public ViewGroup.LayoutParams aduz;
  private Context mContext;
  public ViewTreeObserver.OnGlobalLayoutListener qZ;
  
  private c(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(141275);
    this.aduv = false;
    this.qZ = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141271);
        c.a(c.this);
        AppMethodBeat.o(141271);
      }
    };
    this.mContext = paramActivity;
    this.aduv = paramBoolean;
    paramActivity = (FrameLayout)paramActivity.findViewById(16908290);
    if (paramActivity == null)
    {
      AppMethodBeat.o(141275);
      return;
    }
    this.adux = paramActivity.getChildAt(0);
    this.adux.getViewTreeObserver().addOnGlobalLayoutListener(this.qZ);
    this.aduz = this.adux.getLayoutParams();
    AppMethodBeat.o(141275);
  }
  
  private c(Activity paramActivity, boolean paramBoolean, View paramView, a parama)
  {
    AppMethodBeat.i(141276);
    this.aduv = false;
    this.qZ = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141271);
        c.a(c.this);
        AppMethodBeat.o(141271);
      }
    };
    this.mContext = paramActivity;
    this.aduv = paramBoolean;
    this.adux = paramView;
    this.aduw = parama;
    this.adux.getViewTreeObserver().addOnGlobalLayoutListener(this.qZ);
    this.aduz = this.adux.getLayoutParams();
    AppMethodBeat.o(141276);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, View paramView, a parama)
  {
    AppMethodBeat.i(141274);
    new c(paramActivity, paramBoolean, paramView, parama);
    AppMethodBeat.o(141274);
  }
  
  public static c bM(Activity paramActivity)
  {
    AppMethodBeat.i(249373);
    paramActivity = new c(paramActivity, false);
    AppMethodBeat.o(249373);
    return paramActivity;
  }
  
  public static void h(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(141273);
    new c(paramActivity, paramBoolean);
    AppMethodBeat.o(141273);
  }
  
  public static abstract interface a
  {
    public abstract void cK(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.c
 * JD-Core Version:    0.7.0.1
 */