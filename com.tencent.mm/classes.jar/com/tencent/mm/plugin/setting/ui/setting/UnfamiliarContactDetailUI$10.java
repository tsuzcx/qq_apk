package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.HashMap;

final class UnfamiliarContactDetailUI$10
  implements VerticalScrollBar.a
{
  UnfamiliarContactDetailUI$10(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void lf(String paramString)
  {
    AppMethodBeat.i(127647);
    UnfamiliarContactDetailUI localUnfamiliarContactDetailUI = this.qLi;
    if ((localUnfamiliarContactDetailUI.qLa != null) && (localUnfamiliarContactDetailUI.qLa.containsKey(paramString))) {}
    for (int i = ((Integer)localUnfamiliarContactDetailUI.qLa.get(paramString)).intValue();; i = -1)
    {
      ab.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[] { paramString, Integer.valueOf(i) });
      if (i != -1) {
        UnfamiliarContactDetailUI.j(this.qLi).bJ(i);
      }
      AppMethodBeat.o(127647);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.10
 * JD-Core Version:    0.7.0.1
 */