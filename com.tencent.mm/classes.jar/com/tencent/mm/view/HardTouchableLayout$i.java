package com.tencent.mm.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/view/HardTouchableLayout$setOnLongClickListener$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnLongClickListener;", "onLongClick", "", "view", "Landroid/view/View;", "libmmui_release"})
public final class HardTouchableLayout$i
  implements HardTouchableLayout.d
{
  HardTouchableLayout$i(View.OnLongClickListener paramOnLongClickListener) {}
  
  public final void gv(View paramView)
  {
    AppMethodBeat.i(164498);
    p.h(paramView, "view");
    View.OnLongClickListener localOnLongClickListener = this.LLd;
    if (localOnLongClickListener != null)
    {
      localOnLongClickListener.onLongClick(paramView);
      AppMethodBeat.o(164498);
      return;
    }
    AppMethodBeat.o(164498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.HardTouchableLayout.i
 * JD-Core Version:    0.7.0.1
 */