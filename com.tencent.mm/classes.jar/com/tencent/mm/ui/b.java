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
  private int FvU;
  private boolean Jnp;
  private a Jnq;
  private View Jnr;
  private int Jns;
  private ViewGroup.LayoutParams Jnt;
  private int Jnu;
  private Context mContext;
  
  private b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(141275);
    this.Jnp = false;
    this.mContext = paramActivity;
    this.Jnp = paramBoolean;
    paramActivity = (FrameLayout)paramActivity.findViewById(16908290);
    if (paramActivity == null)
    {
      AppMethodBeat.o(141275);
      return;
    }
    this.Jnr = paramActivity.getChildAt(0);
    this.Jnr.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141271);
        b.a(b.this);
        AppMethodBeat.o(141271);
      }
    });
    this.Jnt = this.Jnr.getLayoutParams();
    AppMethodBeat.o(141275);
  }
  
  private b(Activity paramActivity, boolean paramBoolean, View paramView, a parama)
  {
    AppMethodBeat.i(141276);
    this.Jnp = false;
    this.mContext = paramActivity;
    this.Jnp = paramBoolean;
    this.Jnr = paramView;
    this.Jnq = parama;
    this.Jnr.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(141272);
        b.a(b.this);
        AppMethodBeat.o(141272);
      }
    });
    this.Jnt = this.Jnr.getLayoutParams();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.b
 * JD-Core Version:    0.7.0.1
 */