package com.tencent.mm.ui.widget.cedit.b;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public class e
  extends b
  implements d
{
  public void a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt)
  {
    AppMethodBeat.i(206114);
    paramSpannable = paramCustomTextView.getLayout();
    if ((paramSpannable != null) && ((paramInt & 0x2) != 0)) {
      paramCustomTextView.scrollTo(paramCustomTextView.getScrollX(), paramSpannable.getLineTop(0));
    }
    if ((paramSpannable != null) && ((paramInt & 0x1) != 0))
    {
      paramInt = paramCustomTextView.getTotalPaddingTop();
      int i = paramCustomTextView.getTotalPaddingBottom();
      int j = paramSpannable.getLineCount();
      paramCustomTextView.scrollTo(paramCustomTextView.getScrollX(), paramSpannable.getLineTop(j - 1 + 1) - (paramCustomTextView.getHeight() - (paramInt + i)));
    }
    AppMethodBeat.o(206114);
  }
  
  protected boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206101);
    boolean bool = b(paramCustomTextView, 1);
    AppMethodBeat.o(206101);
    return bool;
  }
  
  public boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206113);
    boolean bool = f.a(paramCustomTextView, paramSpannable, paramMotionEvent);
    AppMethodBeat.o(206113);
    return bool;
  }
  
  protected boolean b(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206102);
    boolean bool = c(paramCustomTextView, 1);
    AppMethodBeat.o(206102);
    return bool;
  }
  
  protected boolean c(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206103);
    boolean bool = d(paramCustomTextView, 1);
    AppMethodBeat.o(206103);
    return bool;
  }
  
  protected boolean d(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206104);
    boolean bool = e(paramCustomTextView, 1);
    AppMethodBeat.o(206104);
    return bool;
  }
  
  protected final boolean e(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206105);
    paramSpannable = paramCustomTextView.getLayout();
    int i = paramSpannable.getLineForVertical(paramCustomTextView.getScrollY() - b.h(paramCustomTextView));
    if (i >= 0)
    {
      f.a(paramCustomTextView, paramSpannable, paramCustomTextView.getScrollX(), paramSpannable.getLineTop(i));
      AppMethodBeat.o(206105);
      return true;
    }
    AppMethodBeat.o(206105);
    return false;
  }
  
  protected final boolean f(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206106);
    paramSpannable = paramCustomTextView.getLayout();
    int i = b.h(paramCustomTextView);
    int j = paramSpannable.getLineForVertical(paramCustomTextView.getScrollY() + i + i);
    if (j <= paramSpannable.getLineCount() - 1)
    {
      f.a(paramCustomTextView, paramSpannable, paramCustomTextView.getScrollX(), paramSpannable.getLineTop(j + 1) - i);
      AppMethodBeat.o(206106);
      return true;
    }
    AppMethodBeat.o(206106);
    return false;
  }
  
  protected final boolean g(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206107);
    paramSpannable = paramCustomTextView.getLayout();
    if (b.e(paramCustomTextView) >= 0)
    {
      f.a(paramCustomTextView, paramSpannable, paramCustomTextView.getScrollX(), paramSpannable.getLineTop(0));
      AppMethodBeat.o(206107);
      return true;
    }
    AppMethodBeat.o(206107);
    return false;
  }
  
  protected final boolean h(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206108);
    paramSpannable = paramCustomTextView.getLayout();
    int i = paramSpannable.getLineCount();
    if (b.f(paramCustomTextView) <= i - 1)
    {
      f.a(paramCustomTextView, paramSpannable, paramCustomTextView.getScrollX(), paramSpannable.getLineTop(i) - b.h(paramCustomTextView));
      AppMethodBeat.o(206108);
      return true;
    }
    AppMethodBeat.o(206108);
    return false;
  }
  
  protected final boolean i(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206109);
    int i = b.j(paramCustomTextView);
    if (paramCustomTextView.getScrollX() > i)
    {
      paramCustomTextView.scrollTo(i, paramCustomTextView.getScrollY());
      AppMethodBeat.o(206109);
      return true;
    }
    AppMethodBeat.o(206109);
    return false;
  }
  
  protected final boolean j(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206110);
    int i = b.k(paramCustomTextView) - b.g(paramCustomTextView);
    if (paramCustomTextView.getScrollX() < i)
    {
      paramCustomTextView.scrollTo(i, paramCustomTextView.getScrollY());
      AppMethodBeat.o(206110);
      return true;
    }
    AppMethodBeat.o(206110);
    return false;
  }
  
  protected final boolean k(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206111);
    boolean bool = g(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(206111);
    return bool;
  }
  
  protected final boolean l(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(206112);
    boolean bool = h(paramCustomTextView, paramSpannable);
    AppMethodBeat.o(206112);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.b.e
 * JD-Core Version:    0.7.0.1
 */