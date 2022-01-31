package com.tencent.mm.plugin.setting.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SwitchAccountGridView$3
  implements View.OnClickListener
{
  SwitchAccountGridView$3(SwitchAccountGridView paramSwitchAccountGridView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127704);
    ab.i("MicroMsg.SwitchAccountGridView", "click addBtn");
    if (SwitchAccountGridView.b(this.qMx) != null) {
      SwitchAccountGridView.b(this.qMx).YW(null);
    }
    AppMethodBeat.o(127704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.3
 * JD-Core Version:    0.7.0.1
 */