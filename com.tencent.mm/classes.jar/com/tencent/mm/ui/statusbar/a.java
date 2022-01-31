package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static void E(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(67830);
    paramView = ft(paramView);
    if (paramView != null) {
      paramView.rq(paramBoolean);
    }
    AppMethodBeat.o(67830);
  }
  
  public static int aG(Activity paramActivity)
  {
    AppMethodBeat.i(67831);
    if (!c.ApJ)
    {
      AppMethodBeat.o(67831);
      return 0;
    }
    if (paramActivity == null)
    {
      AppMethodBeat.o(67831);
      return 0;
    }
    int i = c.aH(paramActivity).ApM;
    AppMethodBeat.o(67831);
    return i;
  }
  
  public static void d(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(67829);
    if (paramView == null)
    {
      AppMethodBeat.o(67829);
      return;
    }
    if (!c.ApJ)
    {
      AppMethodBeat.o(67829);
      return;
    }
    b localb = ft(paramView);
    if (localb != null)
    {
      localb.K(paramInt, paramBoolean);
      AppMethodBeat.o(67829);
      return;
    }
    paramView = com.tencent.mm.sdk.f.a.hr(paramView.getContext());
    if (paramView != null)
    {
      paramView.getWindow().setStatusBarColor(paramInt);
      d.a(paramView.getWindow(), paramBoolean);
    }
    AppMethodBeat.o(67829);
  }
  
  private static b ft(View paramView)
  {
    AppMethodBeat.i(67828);
    if (paramView == null)
    {
      AppMethodBeat.o(67828);
      return null;
      paramView = (View)paramView;
    }
    for (;;)
    {
      if ((paramView instanceof b))
      {
        paramView = (b)paramView;
        AppMethodBeat.o(67828);
        return paramView;
      }
      paramView = paramView.getParent();
      if ((paramView != null) && ((paramView instanceof ViewGroup))) {
        break;
      }
      AppMethodBeat.o(67828);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.a
 * JD-Core Version:    0.7.0.1
 */