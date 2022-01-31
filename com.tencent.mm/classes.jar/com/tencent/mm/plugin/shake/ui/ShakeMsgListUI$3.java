package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeMsgListUI$3
  implements View.OnClickListener
{
  ShakeMsgListUI$3(ShakeMsgListUI paramShakeMsgListUI, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24754);
    ShakeMsgListUI.a(this.qQa, ShakeMsgListUI.d(this.qQa) + 8);
    ShakeMsgListUI.b(this.qQa).Dp(ShakeMsgListUI.d(this.qQa));
    if (ShakeMsgListUI.e(this.qQa) <= ShakeMsgListUI.d(this.qQa)) {
      ShakeMsgListUI.f(this.qQa).removeFooterView(this.pdQ);
    }
    AppMethodBeat.o(24754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI.3
 * JD-Core Version:    0.7.0.1
 */