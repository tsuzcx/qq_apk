package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static int a(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(100303);
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      if (f(paramViewGroup.getChildAt(i), paramFloat1, paramFloat2))
      {
        AppMethodBeat.o(100303);
        return i;
      }
      i -= 1;
    }
    AppMethodBeat.o(100303);
    return -1;
  }
  
  public static boolean f(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(100304);
    if ((paramView != null) && (paramFloat1 >= paramView.getLeft()) && (paramFloat1 <= paramView.getRight()) && (paramFloat2 >= paramView.getTop()) && (paramFloat2 <= paramView.getBottom()))
    {
      AppMethodBeat.o(100304);
      return true;
    }
    AppMethodBeat.o(100304);
    return false;
  }
  
  public static float fE(View paramView)
  {
    AppMethodBeat.i(100301);
    float f = Math.abs((paramView.getRight() - paramView.getLeft()) / 2);
    AppMethodBeat.o(100301);
    return f;
  }
  
  public static float fF(View paramView)
  {
    AppMethodBeat.i(100302);
    float f = Math.abs((paramView.getBottom() - paramView.getTop()) / 2);
    AppMethodBeat.o(100302);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.f
 * JD-Core Version:    0.7.0.1
 */