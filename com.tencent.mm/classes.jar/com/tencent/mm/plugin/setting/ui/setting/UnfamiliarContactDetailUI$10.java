package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.HashMap;

final class UnfamiliarContactDetailUI$10
  implements VerticalScrollBar.a
{
  UnfamiliarContactDetailUI$10(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void eU(String paramString)
  {
    UnfamiliarContactDetailUI localUnfamiliarContactDetailUI = this.nWX;
    if ((localUnfamiliarContactDetailUI.nWP != null) && (localUnfamiliarContactDetailUI.nWP.containsKey(paramString))) {}
    for (int i = ((Integer)localUnfamiliarContactDetailUI.nWP.get(paramString)).intValue();; i = -1)
    {
      y.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[] { paramString, Integer.valueOf(i) });
      if (i != -1) {
        UnfamiliarContactDetailUI.j(this.nWX).bE(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.10
 * JD-Core Version:    0.7.0.1
 */