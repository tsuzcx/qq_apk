package com.tencent.mm.plugin.nearlife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class NearLifeCreatePoiUI$3
  implements View.OnClickListener
{
  NearLifeCreatePoiUI$3(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26599);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Mrw.findViewById(R.h.gaT).setVisibility(8);
    this.Mrw.findViewById(R.h.fNa).setVisibility(0);
    this.Mrw.findViewById(R.h.fNc).setVisibility(0);
    a.a(this, "com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26599);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.3
 * JD-Core Version:    0.7.0.1
 */