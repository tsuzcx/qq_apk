package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MultiSelectContactView$b$4
  implements View.OnFocusChangeListener
{
  MultiSelectContactView$b$4(MultiSelectContactView.b paramb, MultiSelectContactView paramMultiSelectContactView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(146171);
    if (paramBoolean)
    {
      MultiSelectContactView.f(this.vRo.vRm).setBackgroundResource(2130839162);
      MultiSelectContactView.f(this.vRo.vRm).setPadding(MultiSelectContactView.g(this.vRo.vRm), MultiSelectContactView.g(this.vRo.vRm), MultiSelectContactView.g(this.vRo.vRm), MultiSelectContactView.g(this.vRo.vRm));
    }
    for (;;)
    {
      if (MultiSelectContactView.h(this.vRo.vRm) != null) {
        MultiSelectContactView.h(this.vRo.vRm).dnj();
      }
      AppMethodBeat.o(146171);
      return;
      MultiSelectContactView.f(this.vRo.vRm).setBackgroundResource(2130839163);
      MultiSelectContactView.f(this.vRo.vRm).setPadding(MultiSelectContactView.g(this.vRo.vRm), MultiSelectContactView.g(this.vRo.vRm), MultiSelectContactView.g(this.vRo.vRm), MultiSelectContactView.g(this.vRo.vRm));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b.4
 * JD-Core Version:    0.7.0.1
 */