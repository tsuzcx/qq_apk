package com.tencent.mm.plugin.transvoice.ui;

import a.f.b.j;
import a.l;
import android.support.design.widget.MMBottomSheetBehavior;
import android.support.design.widget.MMBottomSheetBehavior.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$6", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
public final class a$g
  extends MMBottomSheetBehavior.a
{
  public final void b(View paramView, float paramFloat)
  {
    AppMethodBeat.i(155216);
    j.q(paramView, "bottomSheet");
    paramView = this.tpR;
    if (0.7F >= paramFloat) {}
    for (boolean bool = true;; bool = false)
    {
      a.a(paramView, bool);
      AppMethodBeat.o(155216);
      return;
    }
  }
  
  public final void j(View paramView, int paramInt)
  {
    AppMethodBeat.i(155217);
    j.q(paramView, "bottomSheet");
    if (2 == paramInt)
    {
      if (a.b(this.tpR))
      {
        this.tpR.dismiss();
        AppMethodBeat.o(155217);
        return;
      }
      paramView = a.c(this.tpR);
      if (paramView != null)
      {
        paramView.bC();
        AppMethodBeat.o(155217);
        return;
      }
    }
    AppMethodBeat.o(155217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.a.g
 * JD-Core Version:    0.7.0.1
 */