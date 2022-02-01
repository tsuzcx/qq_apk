package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public final class a
{
  public static void X(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(133798);
    paramView = iD(paramView);
    if (paramView != null) {
      paramView.GZ(paramBoolean);
    }
    AppMethodBeat.o(133798);
  }
  
  public static int bz(Activity paramActivity)
  {
    AppMethodBeat.i(237569);
    if (!c.XMC)
    {
      AppMethodBeat.o(237569);
      return 0;
    }
    if (paramActivity == null)
    {
      AppMethodBeat.o(237569);
      return 0;
    }
    int i = c.bA(paramActivity).XMF;
    AppMethodBeat.o(237569);
    return i;
  }
  
  public static void f(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(133797);
    if (paramView == null)
    {
      AppMethodBeat.o(133797);
      return;
    }
    if (!c.XMC)
    {
      AppMethodBeat.o(133797);
      return;
    }
    b localb = iD(paramView);
    if (localb != null)
    {
      localb.T(paramInt, paramBoolean);
      AppMethodBeat.o(133797);
      return;
    }
    paramView = AndroidContextUtil.castActivityOrNull(paramView.getContext());
    if (paramView != null)
    {
      paramView.getWindow().setStatusBarColor(paramInt);
      d.d(paramView.getWindow(), paramBoolean);
    }
    AppMethodBeat.o(133797);
  }
  
  private static b iD(View paramView)
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