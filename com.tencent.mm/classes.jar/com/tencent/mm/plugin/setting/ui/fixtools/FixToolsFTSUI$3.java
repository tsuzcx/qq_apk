package com.tencent.mm.plugin.setting.ui.fixtools;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.e;

final class FixToolsFTSUI$3
  implements View.OnClickListener
{
  FixToolsFTSUI$3(FixToolsFTSUI paramFixToolsFTSUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155885);
    d.i("MicroMsg.FTS.FixToolsFTSUI", "set fts index ready");
    e.wq(25);
    ((PluginFTS)g.G(PluginFTS.class)).setFTSIndexReady(true);
    AppMethodBeat.o(155885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsFTSUI.3
 * JD-Core Version:    0.7.0.1
 */