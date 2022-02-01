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
    AppMethodBeat.i(223798);
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
    AppMethodBeat.o(223798);
  }
  
  protected boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223754);
    boolean bool = b(paramCustomTextView, 1);
    AppMethodBeat.o(223754);
    return bool;
  }
  
  public boolean a(CustomTextView paramCustomTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(223792);
    boolean bool = f.a(paramCustomTextView, paramSpannable, paramMotionEvent);
    AppMethodBeat.o(223792);
    return bool;
  }
  
  protected boolean b(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223757);
    boolean bool = c(paramCustomTextView, 1);
    AppMethodBeat.o(223757);
    return bool;
  }
  
  protected boolean c(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223760);
    boolean bool = d(paramCustomTextView, 1);
    AppMethodBeat.o(223760);
    return bool;
  }
  
  protected boolean d(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223765);
    boolean bool = e(paramCustomTextView, 1);
    AppMethodBeat.o(223765);
    return bool;
  }
  
  protected final boolean e(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223768);
    boolean bool = l(paramCustomTextView);
    AppMethodBeat.o(223768);
    return bool;
  }
  
  protected final boolean f(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223771);
    boolean bool = m(paramCustomTextView);
    AppMethodBeat.o(223771);
    return bool;
  }
  
  protected final boolean g(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223774);
    boolean bool = n(paramCustomTextView);
    AppMethodBeat.o(223774);
    return bool;
  }
  
  protected final boolean h(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223776);
    boolean bool = o(paramCustomTextView);
    AppMethodBeat.o(223776);
    return bool;
  }
  
  protected final boolean i(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223781);
    boolean bool = p(paramCustomTextView);
    AppMethodBeat.o(223781);
    return bool;
  }
  
  protected final boolean j(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223784);
    boolean bool = q(paramCustomTextView);
    AppMethodBeat.o(223784);
    return bool;
  }
  
  protected final boolean k(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223787);
    boolean bool = n(paramCustomTextView);
    AppMethodBeat.o(223787);
    return bool;
  }
  
  protected final boolean l(CustomTextView paramCustomTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(223789);
    boolean bool = o(paramCustomTextView);
    AppMethodBeat.o(223789);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.b.e
 * JD-Core Version:    0.7.0.1
 */