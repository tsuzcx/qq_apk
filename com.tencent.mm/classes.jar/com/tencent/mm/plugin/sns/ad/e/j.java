package com.tencent.mm.plugin.sns.ad.e;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class j
{
  public static void O(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(221344);
    if (paramView != null) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(221344);
      return;
    }
  }
  
  public static boolean a(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    AppMethodBeat.i(197712);
    if ((paramViewGroup == null) || (paramView == null)) {}
    try
    {
      AppMethodBeat.o(197712);
      return false;
    }
    catch (Throwable paramViewGroup)
    {
      ViewParent localViewParent;
      Log.e("ViewUtils", "ViewUtils:: Add view to view group failed!");
      AppMethodBeat.o(197712);
    }
    if (paramInt > paramViewGroup.getChildCount())
    {
      AppMethodBeat.o(197712);
      return false;
    }
    localViewParent = paramView.getParent();
    if (localViewParent == paramViewGroup)
    {
      AppMethodBeat.o(197712);
      return true;
    }
    if (localViewParent == null) {
      paramViewGroup.addView(paramView, paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(197712);
      return true;
      ((ViewGroup)localViewParent).removeView(paramView);
      paramViewGroup.addView(paramView);
    }
    return false;
  }
  
  public static boolean eP(View paramView)
  {
    AppMethodBeat.i(197717);
    if (paramView != null)
    {
      if (paramView.getParent() != null)
      {
        AppMethodBeat.o(197717);
        return true;
      }
      AppMethodBeat.o(197717);
      return false;
    }
    AppMethodBeat.o(197717);
    return false;
  }
  
  public static void eQ(View paramView)
  {
    AppMethodBeat.i(197718);
    if (paramView == null)
    {
      AppMethodBeat.o(197718);
      return;
    }
    try
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      AppMethodBeat.o(197718);
      return;
    }
    catch (Throwable paramView)
    {
      AppMethodBeat.o(197718);
    }
  }
  
  public static void v(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197714);
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
          AppMethodBeat.o(197714);
          return;
          localLayoutParams = new ViewGroup.LayoutParams(paramInt1, paramInt2);
        }
        AppMethodBeat.o(197714);
      }
      catch (Throwable paramView) {}
    }
  }
  
  public static void w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(197715);
    if (paramViewGroup != null) {
      paramViewGroup.removeAllViews();
    }
    AppMethodBeat.o(197715);
  }
  
  public static boolean x(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(197716);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(197716);
      return false;
    }
    if (paramViewGroup.getChildCount() > 0)
    {
      AppMethodBeat.o(197716);
      return true;
    }
    AppMethodBeat.o(197716);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.j
 * JD-Core Version:    0.7.0.1
 */