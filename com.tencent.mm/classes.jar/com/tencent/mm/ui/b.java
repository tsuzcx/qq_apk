package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int CfW;
  private boolean FGi;
  private a FGj;
  private View FGk;
  private int FGl;
  private ViewGroup.LayoutParams FGm;
  private int FGn;
  private Context mContext;
  
  private b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(141275);
    this.FGi = false;
    this.mContext = paramActivity;
    this.FGi = paramBoolean;
    paramActivity = (FrameLayout)paramActivity.findViewById(16908290);
    if (paramActivity == null)
    {
      AppMethodBeat.o(141275);
      return;
    }
    this.FGk = paramActivity.getChildAt(0);
    this.FGk.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141271);
        b.a(b.this);
        AppMethodBeat.o(141271);
      }
    });
    this.FGm = this.FGk.getLayoutParams();
    AppMethodBeat.o(141275);
  }
  
  private b(Activity paramActivity, boolean paramBoolean, View paramView, a parama)
  {
    AppMethodBeat.i(141276);
    this.FGi = false;
    this.mContext = paramActivity;
    this.FGi = paramBoolean;
    this.FGk = paramView;
    this.FGj = parama;
    this.FGk.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141272);
        b.a(b.this);
        AppMethodBeat.o(141272);
      }
    });
    this.FGm = this.FGk.getLayoutParams();
    AppMethodBeat.o(141276);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, View paramView, a parama)
  {
    AppMethodBeat.i(141274);
    new b(paramActivity, paramBoolean, paramView, parama);
    AppMethodBeat.o(141274);
  }
  
  public static void c(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(141273);
    new b(paramActivity, paramBoolean);
    AppMethodBeat.o(141273);
  }
  
  public static abstract interface a
  {
    public abstract void bu(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.b
 * JD-Core Version:    0.7.0.1
 */