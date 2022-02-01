package com.tencent.mm.ui.widget.cedit.b;

import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.method.MetaKeyKeyListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public final class f
{
  public static void a(CustomTextView paramCustomTextView, Layout paramLayout, int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(206115);
    int j = paramCustomTextView.getTotalPaddingLeft();
    int k = paramCustomTextView.getTotalPaddingRight();
    int n = paramCustomTextView.getWidth() - (j + k);
    int m = paramLayout.getLineForVertical(paramInt2);
    Layout.Alignment localAlignment = paramLayout.getParagraphAlignment(m);
    if (paramLayout.getParagraphDirection(m) > 0) {
      k = 1;
    }
    while (paramCustomTextView.getHorizontallyScrolling())
    {
      i = paramCustomTextView.getTotalPaddingTop();
      j = paramCustomTextView.getTotalPaddingBottom();
      int i1 = paramLayout.getLineForVertical(paramCustomTextView.getHeight() + paramInt2 - (i + j));
      j = 2147483647;
      i = 0;
      for (;;)
      {
        if (m <= i1)
        {
          j = (int)Math.min(j, paramLayout.getLineLeft(m));
          i = (int)Math.max(i, paramLayout.getLineRight(m));
          m += 1;
          continue;
          k = 0;
          break;
        }
      }
      m = j;
      j = i;
      i = m;
      m = j - i;
      if (m >= n) {
        break label270;
      }
      if (localAlignment != Layout.Alignment.ALIGN_CENTER) {
        break label219;
      }
      paramInt1 = i - (n - m) / 2;
    }
    label270:
    for (;;)
    {
      paramCustomTextView.scrollTo(paramInt1, paramInt2);
      AppMethodBeat.o(206115);
      return;
      j = n;
      break;
      label219:
      if (((k != 0) && (localAlignment == Layout.Alignment.ALIGN_OPPOSITE)) || ((k == 0) && (localAlignment == Layout.Alignment.ALIGN_NORMAL)))
      {
        Log.i("Touch", "scrollto may err");
        paramInt1 = i - (n - m);
      }
      else
      {
        paramInt1 = i;
        continue;
        paramInt1 = Math.max(Math.min(paramInt1, j - n), i);
      }
    }
  }
  
  public static boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206116);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    a[] arrayOfa;
    int i;
    do
    {
      do
      {
        AppMethodBeat.o(206116);
        return false;
        arrayOfa = (a[])paramSpannable.getSpans(0, paramSpannable.length(), a.class);
        i = 0;
        while (i < arrayOfa.length)
        {
          paramSpannable.removeSpan(arrayOfa[i]);
          i += 1;
        }
        paramSpannable.setSpan(new a(paramMotionEvent.getX(), paramMotionEvent.getY(), paramCustomTextView.getScrollX(), paramCustomTextView.getScrollY()), 0, 0, 17);
        AppMethodBeat.o(206116);
        return true;
        paramCustomTextView = (a[])paramSpannable.getSpans(0, paramSpannable.length(), a.class);
        i = 0;
        while (i < paramCustomTextView.length)
        {
          paramSpannable.removeSpan(paramCustomTextView[i]);
          i += 1;
        }
        if ((paramCustomTextView.length > 0) && (paramCustomTextView[0].ovs))
        {
          AppMethodBeat.o(206116);
          return true;
        }
        AppMethodBeat.o(206116);
        return false;
        arrayOfa = (a[])paramSpannable.getSpans(0, paramSpannable.length(), a.class);
      } while (arrayOfa.length <= 0);
      if (!arrayOfa[0].ovr)
      {
        i = ViewConfiguration.get(paramCustomTextView.getContext()).getScaledTouchSlop();
        if ((Math.abs(paramMotionEvent.getX() - arrayOfa[0].mX) >= i) || (Math.abs(paramMotionEvent.getY() - arrayOfa[0].mY) >= i)) {
          arrayOfa[0].ovr = true;
        }
      }
    } while (!arrayOfa[0].ovr);
    arrayOfa[0].ovs = true;
    float f2;
    if (((paramMotionEvent.getMetaState() & 0x1) != 0) || (MetaKeyKeyListener.getMetaState(paramSpannable, 1) == 1) || (MetaKeyKeyListener.getMetaState(paramSpannable, 2048) != 0))
    {
      i = 1;
      if (i == 0) {
        break label539;
      }
      f2 = paramMotionEvent.getX() - arrayOfa[0].mX;
    }
    for (float f1 = paramMotionEvent.getY() - arrayOfa[0].mY;; f1 = arrayOfa[0].mY - paramMotionEvent.getY())
    {
      arrayOfa[0].mX = paramMotionEvent.getX();
      arrayOfa[0].mY = paramMotionEvent.getY();
      i = paramCustomTextView.getScrollX();
      int j = (int)f2;
      int k = paramCustomTextView.getScrollY();
      int m = (int)f1;
      int n = paramCustomTextView.getTotalPaddingTop();
      int i1 = paramCustomTextView.getTotalPaddingBottom();
      paramSpannable = paramCustomTextView.getLayout();
      k = Math.max(Math.min(m + k, paramSpannable.getHeight() - (paramCustomTextView.getHeight() - (n + i1))), 0);
      m = paramCustomTextView.getScrollX();
      n = paramCustomTextView.getScrollY();
      a(paramCustomTextView, paramSpannable, i + j, k);
      if ((m != paramCustomTextView.getScrollX()) || (n != paramCustomTextView.getScrollY())) {
        paramCustomTextView.cancelLongPress();
      }
      AppMethodBeat.o(206116);
      return true;
      i = 0;
      break;
      label539:
      f2 = arrayOfa[0].mX - paramMotionEvent.getX();
    }
  }
  
  static class a
    implements NoCopySpan
  {
    public float mX;
    public float mY;
    public int ovp;
    public int ovq;
    public boolean ovr;
    public boolean ovs;
    
    public a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
    {
      this.mX = paramFloat1;
      this.mY = paramFloat2;
      this.ovp = paramInt1;
      this.ovq = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.b.f
 * JD-Core Version:    0.7.0.1
 */