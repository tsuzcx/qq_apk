package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bk;

final class PluginTopStoryUI$1
  implements Runnable
{
  PluginTopStoryUI$1(PluginTopStoryUI paramPluginTopStoryUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(125854);
    long l = z.Ul(1);
    if (((Long)g.agR().agA().get(ah.a.GRV, Long.valueOf(0L))).longValue() != l)
    {
      h.wUl.f(17040, new Object[] { Integer.valueOf(1), Long.valueOf(l) });
      g.agR().agA().set(ah.a.GRV, Long.valueOf(l));
      g.agR().agA().faa();
    }
    ((k)g.ab(k.class)).awG().aNG("topstoryapp");
    ac.i("MicroMsg.TopStory.PluginTopStoryUI", "Delete TopStory Conversation Entry");
    AppMethodBeat.o(125854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.1
 * JD-Core Version:    0.7.0.1
 */