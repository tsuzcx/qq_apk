package com.tencent.mm.ui.widget.cedit.b;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public class e
  extends b
{
  public void a(CustomTextView paramCustomTextView, Spannable paramSpannable, int paramInt)
  {
    AppMethodBeat.i(252207);
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
    AppMethodBeat.o(252207);
  }
  
  protected boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252103);
    boolean bool = b(paramCustomTextView, 1);
    AppMethodBeat.o(252103);
    return bool;
  }
  
  public boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252200);
    boolean bool = f.a(paramCustomTextView, paramSpannable, paramMotionEvent);
    AppMethodBeat.o(252200);
    return bool;
  }
  
  protected boolean b(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252111);
    boolean bool = c(paramCustomTextView, 1);
    AppMethodBeat.o(252111);
    return bool;
  }
  
  protected boolean c(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252119);
    boolean bool = d(paramCustomTextView, 1);
    AppMethodBeat.o(252119);
    return bool;
  }
  
  protected boolean d(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252126);
    boolean bool = e(paramCustomTextView, 1);
    AppMethodBeat.o(252126);
    return bool;
  }
  
  protected final boolean e(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252131);
    boolean bool = l(paramCustomTextView);
    AppMethodBeat.o(252131);
    return bool;
  }
  
  protected final boolean f(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252138);
    boolean bool = m(paramCustomTextView);
    AppMethodBeat.o(252138);
    return bool;
  }
  
  protected final boolean g(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252146);
    boolean bool = n(paramCustomTextView);
    AppMethodBeat.o(252146);
    return bool;
  }
  
  protected final boolean h(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252155);
    boolean bool = o(paramCustomTextView);
    AppMethodBeat.o(252155);
    return bool;
  }
  
  protected final boolean i(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252163);
    boolean bool = p(paramCustomTextView);
    AppMethodBeat.o(252163);
    return bool;
  }
  
  protected final boolean j(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252173);
    boolean bool = q(paramCustomTextView);
    AppMethodBeat.o(252173);
    return bool;
  }
  
  protected final boolean k(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252181);
    boolean bool = n(paramCustomTextView);
    AppMethodBeat.o(252181);
    return bool;
  }
  
  protected final boolean l(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252190);
    boolean bool = o(paramCustomTextView);
    AppMethodBeat.o(252190);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.b.e
 * JD-Core Version:    0.7.0.1
 */