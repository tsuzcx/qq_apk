package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiSelectContactView$b$1
  implements View.OnClickListener
{
  MultiSelectContactView$b$1(MultiSelectContactView.b paramb, MultiSelectContactView paramMultiSelectContactView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(146168);
    MultiSelectContactView.a(this.vRo.vRm, (String)paramView.getTag());
    AppMethodBeat.o(146168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b.1
 * JD-Core Version:    0.7.0.1
 */