package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;

final class a$6
  implements View.OnAttachStateChangeListener
{
  a$6(a parama) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(159855);
    ap.d("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
    AppMethodBeat.o(159855);
  }
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(159856);
    ap.d("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
    this.LfZ.destroy();
    AppMethodBeat.o(159856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.6
 * JD-Core Version:    0.7.0.1
 */