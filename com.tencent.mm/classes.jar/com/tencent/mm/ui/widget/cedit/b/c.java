package com.tencent.mm.ui.widget.cedit.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.NoCopySpan.Concrete;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.textclassifier.TextLinks.TextLinkSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public final class c
  extends e
{
  private static c agcD;
  private static Object mHr;
  private String TAG = "cmEdit.LinkMovementMethod";
  
  static
  {
    AppMethodBeat.i(252121);
    mHr = new NoCopySpan.Concrete();
    AppMethodBeat.o(252121);
  }
  
  private static boolean a(int paramInt, CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252104);
    Object localObject = paramCustomTextView.getLayout();
    int j = paramCustomTextView.getTotalPaddingTop();
    int k = paramCustomTextView.getTotalPaddingBottom();
    int m = paramCustomTextView.getScrollY();
    int n = paramCustomTextView.getHeight();
    int i = ((Layout)localObject).getLineForVertical(m);
    j = ((Layout)localObject).getLineForVertical(n + m - (j + k));
    n = ((Layout)localObject).getLineStart(i);
    int i1 = ((Layout)localObject).getLineEnd(j);
    localObject = (ClickableSpan[])paramSpannable.getSpans(n, i1, ClickableSpan.class);
    i = Selection.getSelectionStart(paramSpannable);
    j = Selection.getSelectionEnd(paramSpannable);
    k = Math.min(i, j);
    m = Math.max(i, j);
    i = k;
    j = m;
    if (k < 0)
    {
      i = k;
      j = m;
      if (paramSpannable.getSpanStart(mHr) >= 0)
      {
        j = paramSpannable.length();
        i = j;
      }
    }
    k = i;
    if (i > i1)
    {
      k = 2147483647;
      j = 2147483647;
    }
    if (j < n)
    {
      i = -1;
      j = -1;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
      case 1: 
        for (;;)
        {
          AppMethodBeat.o(252104);
          return false;
          if (i == j)
          {
            AppMethodBeat.o(252104);
            return false;
          }
          paramSpannable = (ClickableSpan[])paramSpannable.getSpans(i, j, ClickableSpan.class);
          if (paramSpannable.length != 1)
          {
            AppMethodBeat.o(252104);
            return false;
          }
          paramSpannable = paramSpannable[0];
          if (Build.VERSION.SDK_INT >= 28) {
            if ((paramSpannable instanceof TextLinks.TextLinkSpan)) {
              paramSpannable.onClick(paramCustomTextView);
            } else {
              paramSpannable.onClick(paramCustomTextView);
            }
          }
        }
      case 2: 
        k = 0;
        m = -1;
        paramInt = -1;
        label311:
        if (k < localObject.length)
        {
          n = paramSpannable.getSpanEnd(localObject[k]);
          if (((n >= j) && (i != j)) || (n <= m)) {
            break label512;
          }
          paramInt = paramSpannable.getSpanStart(localObject[k]);
          m = n;
        }
        break;
      }
      label512:
      for (;;)
      {
        k += 1;
        break label311;
        if (paramInt < 0) {
          break;
        }
        Selection.setSelection(paramSpannable, m, paramInt);
        AppMethodBeat.o(252104);
        return true;
        paramInt = 0;
        n = 2147483647;
        for (k = 2147483647; paramInt < localObject.length; k = m)
        {
          int i2 = paramSpannable.getSpanStart(localObject[paramInt]);
          if (i2 <= i)
          {
            i1 = n;
            m = k;
            if (i != j) {}
          }
          else
          {
            i1 = n;
            m = k;
            if (i2 < k)
            {
              i1 = paramSpannable.getSpanEnd(localObject[paramInt]);
              m = i2;
            }
          }
          paramInt += 1;
          n = i1;
        }
        if (n >= 2147483647) {
          break;
        }
        Selection.setSelection(paramSpannable, k, n);
        AppMethodBeat.o(252104);
        return true;
      }
      i = k;
    }
  }
  
  public static d jHj()
  {
    AppMethodBeat.i(252112);
    if (agcD == null) {
      agcD = new c();
    }
    c localc = agcD;
    AppMethodBeat.o(252112);
    return localc;
  }
  
  public final void a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt)
  {
    AppMethodBeat.i(252202);
    Selection.removeSelection(paramSpannable);
    if ((paramInt & 0x1) != 0)
    {
      paramSpannable.setSpan(mHr, 0, 0, 34);
      AppMethodBeat.o(252202);
      return;
    }
    paramSpannable.removeSpan(mHr);
    AppMethodBeat.o(252202);
  }
  
  protected final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252162);
    if (a(2, paramCustomTextView, paramSpannable))
    {
      AppMethodBeat.o(252162);
      return true;
    }
    boolean bool = super.a(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(252162);
    return bool;
  }
  
  protected final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252136);
    switch (paramInt1)
    {
    }
    do
    {
      boolean bool = super.a(paramCustomTextView, paramSpannable, paramInt1, paramInt2, paramKeyEvent);
      AppMethodBeat.o(252136);
      return bool;
    } while ((!KeyEvent.metaStateHasNoModifiers(paramInt2)) || (paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0) || (!a(1, paramCustomTextView, paramSpannable)));
    AppMethodBeat.o(252136);
    return true;
  }
  
  public final boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252188);
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramCustomTextView.getTotalPaddingLeft();
      int n = paramCustomTextView.getTotalPaddingTop();
      int i1 = paramCustomTextView.getScrollX();
      int i2 = paramCustomTextView.getScrollY();
      Object localObject = paramCustomTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
      if (localObject.length != 0)
      {
        paramMotionEvent = localObject[0];
        if (i == 1) {
          if (Build.VERSION.SDK_INT >= 28) {
            paramMotionEvent.onClick(paramCustomTextView);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(252188);
          return true;
          if (i == 0)
          {
            if (paramCustomTextView.getContext().getApplicationInfo().targetSdkVersion >= 28) {
              paramCustomTextView.aEu(200);
            }
            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(paramMotionEvent), paramSpannable.getSpanEnd(paramMotionEvent));
          }
        }
      }
      Selection.removeSelection(paramSpannable);
    }
    boolean bool = super.a(paramCustomTextView, paramSpannable, paramMotionEvent);
    AppMethodBeat.o(252188);
    return bool;
  }
  
  protected final boolean b(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252172);
    if (a(3, paramCustomTextView, paramSpannable))
    {
      AppMethodBeat.o(252172);
      return true;
    }
    boolean bool = super.b(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(252172);
    return bool;
  }
  
  protected final boolean c(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252144);
    if (a(2, paramCustomTextView, paramSpannable))
    {
      AppMethodBeat.o(252144);
      return true;
    }
    boolean bool = super.c(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(252144);
    return bool;
  }
  
  protected final boolean d(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252153);
    if (a(3, paramCustomTextView, paramSpannable))
    {
      AppMethodBeat.o(252153);
      return true;
    }
    boolean bool = super.d(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(252153);
    return bool;
  }
  
  public final void j(Spannable paramSpannable)
  {
    AppMethodBeat.i(252193);
    Selection.removeSelection(paramSpannable);
    paramSpannable.removeSpan(mHr);
    AppMethodBeat.o(252193);
  }
  
  public final boolean jHi()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.b.c
 * JD-Core Version:    0.7.0.1
 */