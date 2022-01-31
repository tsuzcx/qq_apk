package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class UnfamiliarContactDetailUI$8
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$8(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127644);
    paramView = new d(this.qLi, 1, false);
    paramView.sao = new UnfamiliarContactDetailUI.8.1(this);
    paramView.sap = new UnfamiliarContactDetailUI.8.2(this);
    paramView.crd();
    AppMethodBeat.o(127644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.8
 * JD-Core Version:    0.7.0.1
 */