package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.a;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class b
{
  private static int a(View paramView, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(159905);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getOffsetForHorizontal(paramInt, paramFloat);
        AppMethodBeat.o(159905);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getOffsetForHorizontal(paramInt, paramFloat);
        AppMethodBeat.o(159905);
        return paramInt;
      }
    }
    AppMethodBeat.o(159905);
    return 0;
  }
  
  private static boolean aO(View paramView, int paramInt)
  {
    AppMethodBeat.i(159898);
    if ((paramInt > 0) && (aQ(paramView, paramInt) == aQ(paramView, paramInt - 1) + 1))
    {
      AppMethodBeat.o(159898);
      return true;
    }
    AppMethodBeat.o(159898);
    return false;
  }
  
  public static int aP(View paramView, int paramInt)
  {
    AppMethodBeat.i(159902);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineBaseline(paramInt);
        AppMethodBeat.o(159902);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineBaseline(paramInt);
        AppMethodBeat.o(159902);
        return paramInt;
      }
    }
    AppMethodBeat.o(159902);
    return 0;
  }
  
  public static int aQ(View paramView, int paramInt)
  {
    AppMethodBeat.i(159903);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineForOffset(paramInt);
        AppMethodBeat.o(159903);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineForOffset(paramInt);
        AppMethodBeat.o(159903);
        return paramInt;
      }
    }
    AppMethodBeat.o(159903);
    return 0;
  }
  
  public static float aR(View paramView, int paramInt)
  {
    AppMethodBeat.i(159904);
    float f;
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getPrimaryHorizontal(paramInt);
        AppMethodBeat.o(159904);
        return f;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getPrimaryHorizontal(paramInt);
        AppMethodBeat.o(159904);
        return f;
      }
    }
    AppMethodBeat.o(159904);
    return 0.0F;
  }
  
  public static int aS(View paramView, int paramInt)
  {
    AppMethodBeat.i(159906);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineTop(paramInt);
        AppMethodBeat.o(159906);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineTop(paramInt);
        AppMethodBeat.o(159906);
        return paramInt;
      }
    }
    AppMethodBeat.o(159906);
    return 0;
  }
  
  private static int aT(View paramView, int paramInt)
  {
    AppMethodBeat.i(159907);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineBottom(paramInt);
        AppMethodBeat.o(159907);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineBottom(paramInt);
        AppMethodBeat.o(159907);
        return paramInt;
      }
    }
    AppMethodBeat.o(159907);
    return 0;
  }
  
  public static float aU(View paramView, int paramInt)
  {
    AppMethodBeat.i(159908);
    float f;
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getLineWidth(paramInt);
        AppMethodBeat.o(159908);
        return f;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getLineWidth(paramInt);
        AppMethodBeat.o(159908);
        return f;
      }
    }
    AppMethodBeat.o(159908);
    return 0.0F;
  }
  
  public static int aV(View paramView, int paramInt)
  {
    AppMethodBeat.i(159909);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView == null) {
        break label78;
      }
      paramInt = paramView.getLineStart(paramInt);
    }
    for (;;)
    {
      if (paramInt >= 0)
      {
        AppMethodBeat.o(159909);
        return paramInt;
        if ((paramView instanceof TextView))
        {
          paramView = ((TextView)paramView).getLayout();
          if (paramView != null) {
            paramInt = paramView.getLineStart(paramInt);
          }
        }
      }
      else
      {
        AppMethodBeat.o(159909);
        return 0;
      }
      label78:
      paramInt = 0;
    }
  }
  
  private static int aW(View paramView, int paramInt)
  {
    AppMethodBeat.i(159910);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineForVertical(paramInt);
        AppMethodBeat.o(159910);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineForVertical(paramInt);
        AppMethodBeat.o(159910);
        return paramInt;
      }
    }
    AppMethodBeat.o(159910);
    return 0;
  }
  
  private static float aX(View paramView, int paramInt)
  {
    AppMethodBeat.i(159911);
    float f;
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getLineRight(paramInt);
        AppMethodBeat.o(159911);
        return f;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getLineRight(paramInt);
        AppMethodBeat.o(159911);
        return f;
      }
    }
    AppMethodBeat.o(159911);
    return 0.0F;
  }
  
  public static int f(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159897);
    int j = aW(paramView, paramInt2);
    int i = paramInt3;
    if (aO(paramView, paramInt3))
    {
      k = (int)aR(paramView, paramInt3 - 1);
      m = (int)aX(paramView, j);
      i = paramInt3;
      if (paramInt1 > m - (m - k) / 2) {
        i = paramInt3 - 1;
      }
    }
    i = aQ(paramView, i);
    int k = aS(paramView, i);
    int m = aT(paramView, i);
    int n = (m - k) / 2;
    if (j == i + 1)
    {
      paramInt3 = i;
      if (paramInt2 - m < n) {}
    }
    else
    {
      if ((j != i - 1) || (k - paramInt2 >= n)) {
        break label215;
      }
    }
    label215:
    for (paramInt3 = i;; paramInt3 = j)
    {
      paramInt2 = a(paramView, paramInt3, paramInt1);
      if ((paramInt2 < hB(paramView).length() - 1) && (aO(paramView, paramInt2 + 1)))
      {
        i = (int)aR(paramView, paramInt2);
        paramInt3 = (int)aX(paramView, paramInt3);
        if (paramInt1 <= paramInt3 - (paramInt3 - i) / 2) {}
      }
      for (paramInt1 = paramInt2 + 1;; paramInt1 = paramInt2)
      {
        AppMethodBeat.o(159897);
        return paramInt1;
      }
    }
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(159896);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(159896);
    return i;
  }
  
  public static CharSequence hB(View paramView)
  {
    AppMethodBeat.i(159899);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).hiT();
      AppMethodBeat.o(159899);
      return paramView;
    }
    if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getText();
      AppMethodBeat.o(159899);
      return paramView;
    }
    AppMethodBeat.o(159899);
    return "";
  }
  
  public static TextPaint hC(View paramView)
  {
    AppMethodBeat.i(159901);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getPaint();
      AppMethodBeat.o(159901);
      return paramView;
    }
    if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getPaint();
      AppMethodBeat.o(159901);
      return paramView;
    }
    AppMethodBeat.o(159901);
    return null;
  }
  
  public static int hD(View paramView)
  {
    AppMethodBeat.i(198545);
    int i;
    if ((paramView instanceof NeatTextView))
    {
      i = ((NeatTextView)paramView).getLineHeight();
      AppMethodBeat.o(198545);
      return i;
    }
    if ((paramView instanceof TextView))
    {
      i = ((TextView)paramView).getLineHeight();
      AppMethodBeat.o(198545);
      return i;
    }
    AppMethodBeat.o(198545);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.b
 * JD-Core Version:    0.7.0.1
 */