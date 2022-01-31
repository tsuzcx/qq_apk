package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ShakeSayHiListUI$1
  implements View.OnClickListener
{
  ShakeSayHiListUI$1(ShakeSayHiListUI paramShakeSayHiListUI, View paramView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24873);
    ShakeSayHiListUI.a(this.qRC, ShakeSayHiListUI.a(this.qRC) + 8);
    ab.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + ShakeSayHiListUI.a(this.qRC));
    ShakeSayHiListUI.b(this.qRC).Dp(ShakeSayHiListUI.a(this.qRC));
    if (ShakeSayHiListUI.c(this.qRC) <= ShakeSayHiListUI.a(this.qRC))
    {
      ShakeSayHiListUI.d(this.qRC).removeFooterView(this.pdQ);
      ab.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + ShakeSayHiListUI.a(this.qRC));
    }
    AppMethodBeat.o(24873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI.1
 * JD-Core Version:    0.7.0.1
 */