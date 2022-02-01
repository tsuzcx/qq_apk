package com.tencent.mm.plugin.setting.ui.setting;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.HashMap;

final class UnfamiliarContactDetailUI$10
  implements VerticalScrollBar.a
{
  UnfamiliarContactDetailUI$10(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void KH(String paramString)
  {
    AppMethodBeat.i(74583);
    Object localObject = this.JkM;
    if ((((UnfamiliarContactDetailUI)localObject).JkE != null) && (((UnfamiliarContactDetailUI)localObject).JkE.containsKey(paramString))) {}
    for (int i = ((Integer)((UnfamiliarContactDetailUI)localObject).JkE.get(paramString)).intValue();; i = -1)
    {
      Log.i("MicroMsg.UnfamiliarContactUI", "[onScollBarTouch] showHead:%s pos:%s", new Object[] { paramString, Integer.valueOf(i) });
      if (i != -1)
      {
        paramString = UnfamiliarContactDetailUI.j(this.JkM);
        localObject = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
        paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/setting/ui/setting/UnfamiliarContactDetailUI$7", "onScollBarTouch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
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