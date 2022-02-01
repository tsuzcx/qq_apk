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
  private int KmP;
  private boolean Oxj;
  private a Oxk;
  private View Oxl;
  private int Oxm;
  private ViewGroup.LayoutParams Oxn;
  private int Oxo;
  private Context mContext;
  
  private b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(141275);
    this.Oxj = false;
    this.mContext = paramActivity;
    this.Oxj = paramBoolean;
    paramActivity = (FrameLayout)paramActivity.findViewById(16908290);
    if (paramActivity == null)
    {
      AppMethodBeat.o(141275);
      return;
    }
    this.Oxl = paramActivity.getChildAt(0);
    this.Oxl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141271);
        b.a(b.this);
        AppMethodBeat.o(141271);
      }
    });
    this.Oxn = this.Oxl.getLayoutParams();
    AppMethodBeat.o(141275);
  }
  
  private b(Activity paramActivity, boolean paramBoolean, View paramView, a parama)
  {
    AppMethodBeat.i(141276);
    this.Oxj = false;
    this.mContext = paramActivity;
    this.Oxj = paramBoolean;
    this.Oxl = paramView;
    this.Oxk = parama;
    this.Oxl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141272);
        b.a(b.this);
        AppMethodBeat.o(141272);
      }
    });
    this.Oxn = this.Oxl.getLayoutParams();
    AppMethodBeat.o(141276);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, View paramView, a parama)
  {
    AppMethodBeat.i(141274);
    new b(paramActivity, paramBoolean, paramView, parama);
    AppMethodBeat.o(141274);
  }
  
  public static void e(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(141273);
    new b(paramActivity, paramBoolean);
    AppMethodBeat.o(141273);
  }
  
  public static abstract interface a
  {
    public abstract void bQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.b
 * JD-Core Version:    0.7.0.1
 */