package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.layout.a;
import com.tencent.neattextview.textview.view.NeatTextView;

public final class b
{
  private static int a(View paramView, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(113168);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getOffsetForHorizontal(paramInt, paramFloat);
        AppMethodBeat.o(113168);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getOffsetForHorizontal(paramInt, paramFloat);
        AppMethodBeat.o(113168);
        return paramInt;
      }
    }
    AppMethodBeat.o(113168);
    return 0;
  }
  
  public static void a(View paramView, CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(113163);
    if ((paramView instanceof NeatTextView))
    {
      ((NeatTextView)paramView).a(paramCharSequence, paramBufferType);
      AppMethodBeat.o(113163);
      return;
    }
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setText(paramCharSequence, paramBufferType);
    }
    AppMethodBeat.o(113163);
  }
  
  public static int aA(View paramView, int paramInt)
  {
    AppMethodBeat.i(113172);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineStart(paramInt);
        AppMethodBeat.o(113172);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineStart(paramInt);
        AppMethodBeat.o(113172);
        return paramInt;
      }
    }
    AppMethodBeat.o(113172);
    return 0;
  }
  
  private static int aB(View paramView, int paramInt)
  {
    AppMethodBeat.i(113173);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineForVertical(paramInt);
        AppMethodBeat.o(113173);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineForVertical(paramInt);
        AppMethodBeat.o(113173);
        return paramInt;
      }
    }
    AppMethodBeat.o(113173);
    return 0;
  }
  
  private static float aC(View paramView, int paramInt)
  {
    AppMethodBeat.i(113174);
    float f;
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getLineRight(paramInt);
        AppMethodBeat.o(113174);
        return f;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getLineRight(paramInt);
        AppMethodBeat.o(113174);
        return f;
      }
    }
    AppMethodBeat.o(113174);
    return 0.0F;
  }
  
  private static boolean at(View paramView, int paramInt)
  {
    AppMethodBeat.i(113161);
    if ((paramInt > 0) && (av(paramView, paramInt) == av(paramView, paramInt - 1) + 1))
    {
      AppMethodBeat.o(113161);
      return true;
    }
    AppMethodBeat.o(113161);
    return false;
  }
  
  public static int au(View paramView, int paramInt)
  {
    AppMethodBeat.i(113165);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineBaseline(paramInt);
        AppMethodBeat.o(113165);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineBaseline(paramInt);
        AppMethodBeat.o(113165);
        return paramInt;
      }
    }
    AppMethodBeat.o(113165);
    return 0;
  }
  
  public static int av(View paramView, int paramInt)
  {
    AppMethodBeat.i(113166);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineForOffset(paramInt);
        AppMethodBeat.o(113166);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineForOffset(paramInt);
        AppMethodBeat.o(113166);
        return paramInt;
      }
    }
    AppMethodBeat.o(113166);
    return 0;
  }
  
  public static float aw(View paramView, int paramInt)
  {
    AppMethodBeat.i(113167);
    float f;
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getPrimaryHorizontal(paramInt);
        AppMethodBeat.o(113167);
        return f;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getPrimaryHorizontal(paramInt);
        AppMethodBeat.o(113167);
        return f;
      }
    }
    AppMethodBeat.o(113167);
    return 0.0F;
  }
  
  public static int ax(View paramView, int paramInt)
  {
    AppMethodBeat.i(113169);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineTop(paramInt);
        AppMethodBeat.o(113169);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineTop(paramInt);
        AppMethodBeat.o(113169);
        return paramInt;
      }
    }
    AppMethodBeat.o(113169);
    return 0;
  }
  
  private static int ay(View paramView, int paramInt)
  {
    AppMethodBeat.i(113170);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineBottom(paramInt);
        AppMethodBeat.o(113170);
        return paramInt;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        paramInt = paramView.getLineBottom(paramInt);
        AppMethodBeat.o(113170);
        return paramInt;
      }
    }
    AppMethodBeat.o(113170);
    return 0;
  }
  
  public static float az(View paramView, int paramInt)
  {
    AppMethodBeat.i(113171);
    float f;
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getLineWidth(paramInt);
        AppMethodBeat.o(113171);
        return f;
      }
    }
    else if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getLayout();
      if (paramView != null)
      {
        f = paramView.getLineWidth(paramInt);
        AppMethodBeat.o(113171);
        return f;
      }
    }
    AppMethodBeat.o(113171);
    return 0.0F;
  }
  
  public static int d(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(113160);
    int j = aB(paramView, paramInt2);
    int i = paramInt3;
    if (at(paramView, paramInt3))
    {
      k = (int)aw(paramView, paramInt3 - 1);
      m = (int)aC(paramView, j);
      i = paramInt3;
      if (paramInt1 > m - (m - k) / 2) {
        i = paramInt3 - 1;
      }
    }
    i = av(paramView, i);
    int k = ax(paramView, i);
    int m = ay(paramView, i);
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
      if ((paramInt2 < fz(paramView).length() - 1) && (at(paramView, paramInt2 + 1)))
      {
        i = (int)aw(paramView, paramInt2);
        paramInt3 = (int)aC(paramView, paramInt3);
        if (paramInt1 <= paramInt3 - (paramInt3 - i) / 2) {}
      }
      for (paramInt1 = paramInt2 + 1;; paramInt1 = paramInt2)
      {
        AppMethodBeat.o(113160);
        return paramInt1;
      }
    }
  }
  
  public static TextPaint fA(View paramView)
  {
    AppMethodBeat.i(113164);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).getPaint();
      AppMethodBeat.o(113164);
      return paramView;
    }
    if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getPaint();
      AppMethodBeat.o(113164);
      return paramView;
    }
    AppMethodBeat.o(113164);
    return null;
  }
  
  public static CharSequence fz(View paramView)
  {
    AppMethodBeat.i(113162);
    if ((paramView instanceof NeatTextView))
    {
      paramView = ((NeatTextView)paramView).dTB();
      AppMethodBeat.o(113162);
      return paramView;
    }
    if ((paramView instanceof TextView))
    {
      paramView = ((TextView)paramView).getText();
      AppMethodBeat.o(113162);
      return paramView;
    }
    AppMethodBeat.o(113162);
    return "";
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(113159);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(113159);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.b
 * JD-Core Version:    0.7.0.1
 */