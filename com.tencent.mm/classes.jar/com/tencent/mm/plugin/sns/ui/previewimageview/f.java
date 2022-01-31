package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static int a(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(40341);
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      if (d(paramViewGroup.getChildAt(i), paramFloat1, paramFloat2))
      {
        AppMethodBeat.o(40341);
        return i;
      }
      i -= 1;
    }
    AppMethodBeat.o(40341);
    return -1;
  }
  
  public static boolean d(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(40342);
    if ((paramFloat1 >= paramView.getLeft()) && (paramFloat1 <= paramView.getRight()) && (paramFloat2 >= paramView.getTop()) && (paramFloat2 <= paramView.getBottom()))
    {
      AppMethodBeat.o(40342);
      return true;
    }
    AppMethodBeat.o(40342);
    return false;
  }
  
  public static float dV(View paramView)
  {
    AppMethodBeat.i(40339);
    float f = Math.abs((paramView.getRight() - paramView.getLeft()) / 2);
    AppMethodBeat.o(40339);
    return f;
  }
  
  public static float dW(View paramView)
  {
    AppMethodBeat.i(40340);
    float f = Math.abs((paramView.getBottom() - paramView.getTop()) / 2);
    AppMethodBeat.o(40340);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.f
 * JD-Core Version:    0.7.0.1
 */