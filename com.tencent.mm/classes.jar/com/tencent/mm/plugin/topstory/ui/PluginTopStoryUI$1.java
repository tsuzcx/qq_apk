package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bh;

final class PluginTopStoryUI$1
  implements Runnable
{
  PluginTopStoryUI$1(PluginTopStoryUI paramPluginTopStoryUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(125854);
    long l = aa.Sb(1);
    if (((Long)g.afB().afk().get(ae.a.Fub, Long.valueOf(0L))).longValue() != l)
    {
      h.vKh.f(17040, new Object[] { Integer.valueOf(1), Long.valueOf(l) });
      g.afB().afk().set(ae.a.Fub, Long.valueOf(l));
      g.afB().afk().eKy();
    }
    ((k)g.ab(k.class)).apR().aIl("topstoryapp");
    ad.i("MicroMsg.TopStory.PluginTopStoryUI", "Delete TopStory Conversation Entry");
    AppMethodBeat.o(125854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.1
 * JD-Core Version:    0.7.0.1
 */