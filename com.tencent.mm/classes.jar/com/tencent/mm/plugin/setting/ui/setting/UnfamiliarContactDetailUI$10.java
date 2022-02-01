package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.HashMap;

final class UnfamiliarContactDetailUI$10
  implements VerticalScrollBar.a
{
  UnfamiliarContactDetailUI$10(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void DP(String paramString)
  {
    AppMethodBeat.i(74583);
    Object localObject = this.Dfg;
    if ((((UnfamiliarContactDetailUI)localObject).DeY != null) && (((UnfamiliarContactDetailUI)localObject).DeY.containsKey(paramString))) {}
    for (int i = ((Integer)((UnfamiliarContactDetailUI)localObject).DeY.get(paramString)).intValue();; i = -1)
    {
      Log.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[] { paramString, Integer.valueOf(i) });
      if (i != -1)
      {
        paramString = UnfamiliarContactDetailUI.j(this.Dfg);
        localObject = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
      }
      AppMethodBeat.o(74583);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.10
 * JD-Core Version:    0.7.0.1
 */