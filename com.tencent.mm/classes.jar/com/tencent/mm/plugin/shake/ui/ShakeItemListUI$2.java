package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeItemListUI$2
  implements View.OnClickListener
{
  ShakeItemListUI$2(ShakeItemListUI paramShakeItemListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24721);
    ShakeItemListUI.a(this.qPL, ShakeItemListUI.a(this.qPL) ^ 0xFFFFFFFF);
    this.qPL.Dq(ShakeItemListUI.a(this.qPL));
    AppMethodBeat.o(24721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.2
 * JD-Core Version:    0.7.0.1
 */