package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/view/HardTouchableLayout$setOnClickListener$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "libmmui_release"})
public final class HardTouchableLayout$h
  implements HardTouchableLayout.g
{
  HardTouchableLayout$h(View.OnClickListener paramOnClickListener) {}
  
  public final void dV(View paramView)
  {
    AppMethodBeat.i(164497);
    k.h(paramView, "view");
    View.OnClickListener localOnClickListener = this.Jvp;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick(paramView);
      AppMethodBeat.o(164497);
      return;
    }
    AppMethodBeat.o(164497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.HardTouchableLayout.h
 * JD-Core Version:    0.7.0.1
 */