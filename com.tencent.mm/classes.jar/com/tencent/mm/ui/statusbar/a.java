package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class a
{
  public static void ad(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(133798);
    paramView = lZ(paramView);
    if (paramView != null) {
      paramView.MU(paramBoolean);
    }
    AppMethodBeat.o(133798);
  }
  
  public static int cg(Activity paramActivity)
  {
    AppMethodBeat.i(249911);
    if (!c.afCQ)
    {
      AppMethodBeat.o(249911);
      return 0;
    }
    if (paramActivity == null)
    {
      AppMethodBeat.o(249911);
      return 0;
    }
    int i = c.ch(paramActivity).afCS;
    AppMethodBeat.o(249911);
    return i;
  }
  
  public static void h(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133797);
    if (paramView == null)
    {
      AppMethodBeat.o(133797);
      return;
    }
    if (!c.afCQ)
    {
      AppMethodBeat.o(133797);
      return;
    }
    b localb = lZ(paramView);
    if (localb != null)
    {
      localb.aj(paramInt, paramBoolean);
      AppMethodBeat.o(133797);
      return;
    }
    paramView = AndroidContextUtil.castActivityOrNull(paramView.getContext());
    if (paramView != null)
    {
      paramView.getWindow().setStatusBarColor(paramInt);
      d.c(paramView.getWindow(), paramBoolean);
    }
    AppMethodBeat.o(133797);
  }
  
  private static b lZ(View paramView)
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