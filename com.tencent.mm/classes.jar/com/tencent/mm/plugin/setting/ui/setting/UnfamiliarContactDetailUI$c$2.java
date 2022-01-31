package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class UnfamiliarContactDetailUI$c$2
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$c$2(UnfamiliarContactDetailUI.c paramc, UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127659);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = UnfamiliarContactDetailUI.e(this.qLv.qLi).Dg(i);
    ab.i("MicroMsg.UnfamiliarContactUI", "position:%s", new Object[] { Integer.valueOf(i), paramView.elx });
    UnfamiliarContactDetailUI.c.a(this.qLv, paramView, i);
    AppMethodBeat.o(127659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.c.2
 * JD-Core Version:    0.7.0.1
 */