package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class a$6
  implements View.OnAttachStateChangeListener
{
  a$6(a parama) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(113122);
    ak.d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
    AppMethodBeat.o(113122);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(113123);
    ak.d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
    this.ANs.destroy();
    AppMethodBeat.o(113123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.6
 * JD-Core Version:    0.7.0.1
 */