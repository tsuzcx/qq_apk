package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.view.View;
import android.view.ViewGroup;

public final class f
{
  public static int a(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    int i = paramViewGroup.getChildCount() - 1;
    while (i >= 0)
    {
      if (d(paramViewGroup.getChildAt(i), paramFloat1, paramFloat2)) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  public static boolean d(View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 >= paramView.getLeft()) && (paramFloat1 <= paramView.getRight()) && (paramFloat2 >= paramView.getTop()) && (paramFloat2 <= paramView.getBottom());
  }
  
  public static float de(View paramView)
  {
    return Math.abs((paramView.getRight() - paramView.getLeft()) / 2);
  }
  
  public static float df(View paramView)
  {
    return Math.abs((paramView.getBottom() - paramView.getTop()) / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.f
 * JD-Core Version:    0.7.0.1
 */