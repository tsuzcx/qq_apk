package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void N(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(133798);
    paramView = gX(paramView);
    if (paramView != null) {
      paramView.yL(paramBoolean);
    }
    AppMethodBeat.o(133798);
  }
  
  public static void e(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133797);
    if (paramView == null)
    {
      AppMethodBeat.o(133797);
      return;
    }
    if (!c.KZw)
    {
      AppMethodBeat.o(133797);
      return;
    }
    b localb = gX(paramView);
    if (localb != null)
    {
      localb.M(paramInt, paramBoolean);
      AppMethodBeat.o(133797);
      return;
    }
    paramView = com.tencent.mm.sdk.f.a.jw(paramView.getContext());
    if (paramView != null)
    {
      paramView.getWindow().setStatusBarColor(paramInt);
      d.c(paramView.getWindow(), paramBoolean);
    }
    AppMethodBeat.o(133797);
  }
  
  private static b gX(View paramView)
  {
    AppMethodBeat.i(133796);
    if (paramView == null)
    {
      AppMethodBeat.o(133796);
      return null;
      paramView = (View)paramView;
    }
    for (;;)
    {
      if ((paramView instanceof b))
      {
        paramView = (b)paramView;
        AppMethodBeat.o(133796);
        return paramView;
      }
      paramView = paramView.getParent();
      if ((paramView != null) && ((paramView instanceof ViewGroup))) {
        break;
      }
      AppMethodBeat.o(133796);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.a
 * JD-Core Version:    0.7.0.1
 */