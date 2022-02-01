package com.tencent.mm.plugin.sns.ad.f;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class j
{
  public static boolean a(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(219184);
    if ((paramViewGroup == null) || (paramView == null)) {}
    try
    {
      AppMethodBeat.o(219184);
      return false;
    }
    catch (Throwable paramViewGroup)
    {
      ViewParent localViewParent;
      Log.e("ViewUtils", "ViewUtils:: Add view to view group failed!");
      AppMethodBeat.o(219184);
    }
    if (paramInt > paramViewGroup.getChildCount())
    {
      AppMethodBeat.o(219184);
      return false;
    }
    localViewParent = paramView.getParent();
    if (localViewParent == paramViewGroup)
    {
      AppMethodBeat.o(219184);
      return true;
    }
    if (localViewParent == null) {
      paramViewGroup.addView(paramView, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(219184);
      return true;
      ((ViewGroup)localViewParent).removeView(paramView);
      paramViewGroup.addView(paramView);
    }
    return false;
  }
  
  public static boolean eO(View paramView)
  {
    AppMethodBeat.i(219189);
    if (paramView != null)
    {
      if (paramView.getParent() != null)
      {
        AppMethodBeat.o(219189);
        return true;
      }
      AppMethodBeat.o(219189);
      return false;
    }
    AppMethodBeat.o(219189);
    return false;
  }
  
  public static void eP(View paramView)
  {
    AppMethodBeat.i(219190);
    if (paramView == null)
    {
      AppMethodBeat.o(219190);
      return;
    }
    try
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      AppMethodBeat.o(219190);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(219190);
    }
  }
  
  public static void t(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(219185);
    if (paramView != null) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(219185);
      return;
    }
  }
  
  public static void u(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219186);
    if (paramView != null) {
      try
      {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.width = paramInt1;
          localLayoutParams.height = paramInt2;
        }
        for (;;)
        {
          paramView.setLayoutParams(localLayoutParams);
          AppMethodBeat.o(219186);
          return;
          localLayoutParams = new ViewGroup.LayoutParams(paramInt1, paramInt2);
        }
        AppMethodBeat.o(219186);
      }
      catch (Throwable paramView) {}
    }
  }
  
  public static void w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(219187);
    if (paramViewGroup != null) {
      paramViewGroup.removeAllViews();
    }
    AppMethodBeat.o(219187);
  }
  
  public static boolean x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(219188);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(219188);
      return false;
    }
    if (paramViewGroup.getChildCount() > 0)
    {
      AppMethodBeat.o(219188);
      return true;
    }
    AppMethodBeat.o(219188);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.j
 * JD-Core Version:    0.7.0.1
 */