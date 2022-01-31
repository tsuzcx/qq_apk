package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

public final class a
{
  public static int ae(Activity paramActivity)
  {
    if (!c.vXv) {}
    while (paramActivity == null) {
      return 0;
    }
    return c.af(paramActivity).vXy;
  }
  
  public static void d(View paramView, int paramInt, boolean paramBoolean)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
      } while (!c.vXv);
      b localb = eh(paramView);
      if (localb != null)
      {
        localb.av(paramInt, paramBoolean);
        return;
      }
      paramView = d.cx(paramView.getContext());
    } while (paramView == null);
    paramView.getWindow().setStatusBarColor(paramInt);
    d.a(paramView.getWindow(), paramBoolean);
  }
  
  private static b eh(View paramView)
  {
    if (paramView == null)
    {
      return null;
      paramView = (View)paramView;
    }
    for (;;)
    {
      if ((paramView instanceof b)) {
        return (b)paramView;
      }
      paramView = paramView.getParent();
      if ((paramView != null) && ((paramView instanceof ViewGroup))) {
        break;
      }
      return null;
    }
  }
  
  public static void w(View paramView, boolean paramBoolean)
  {
    paramView = eh(paramView);
    if (paramView != null) {
      paramView.dN(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.statusbar.a
 * JD-Core Version:    0.7.0.1
 */