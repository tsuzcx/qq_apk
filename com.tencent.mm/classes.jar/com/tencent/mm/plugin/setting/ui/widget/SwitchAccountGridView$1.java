package com.tencent.mm.plugin.setting.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class SwitchAccountGridView$1
  implements View.OnClickListener
{
  SwitchAccountGridView$1(SwitchAccountGridView paramSwitchAccountGridView, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127702);
    ab.i("MicroMsg.SwitchAccountGridView", "click %s", new Object[] { this.qMw });
    if ((!SwitchAccountGridView.a(this.qMx)) && (SwitchAccountGridView.b(this.qMx) != null)) {
      SwitchAccountGridView.b(this.qMx).YW(this.qMw);
    }
    AppMethodBeat.o(127702);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.1
 * JD-Core Version:    0.7.0.1
 */