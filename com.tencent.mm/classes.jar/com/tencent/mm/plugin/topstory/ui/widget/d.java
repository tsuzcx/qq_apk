package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.af;

public final class d
{
  public static int[] a(Context paramContext, View paramView1, View paramView2, boolean paramBoolean)
  {
    AppMethodBeat.i(2240);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    paramView1.getLocationInWindow(arrayOfInt2);
    int i = paramView1.getHeight();
    int j = af.hQ(paramContext).x;
    paramView2.measure(0, 0);
    int k = paramView2.getMeasuredHeight();
    int m = paramView2.getMeasuredWidth();
    if (paramBoolean)
    {
      arrayOfInt1[0] = ((j - m) / 2);
      arrayOfInt2[1] -= k;
    }
    for (;;)
    {
      AppMethodBeat.o(2240);
      return arrayOfInt1;
      arrayOfInt1[0] = ((j - m) / 2);
      arrayOfInt2[1] += i;
    }
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(2242);
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    AppMethodBeat.o(2242);
    return i;
  }
  
  public static int es(View paramView)
  {
    AppMethodBeat.i(2241);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int j = paramView.getWidth();
    int i = arrayOfInt[0];
    j /= 2;
    AppMethodBeat.o(2241);
    return i + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */