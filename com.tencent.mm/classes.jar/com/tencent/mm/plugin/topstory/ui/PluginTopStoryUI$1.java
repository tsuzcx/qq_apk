package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.br;

final class PluginTopStoryUI$1
  implements Runnable
{
  PluginTopStoryUI$1(PluginTopStoryUI paramPluginTopStoryUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(125854);
    long l = ad.WL(1);
    if (((Long)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYZ, Long.valueOf(0L))).longValue() != l)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(17040, new Object[] { Integer.valueOf(1), Long.valueOf(l) });
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYZ, Long.valueOf(l));
      com.tencent.mm.kernel.g.ajR().ajA().fuc();
    }
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aUY("topstoryapp");
    ae.i("MicroMsg.TopStory.PluginTopStoryUI", "Delete TopStory Conversation Entry");
    AppMethodBeat.o(125854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.1
 * JD-Core Version:    0.7.0.1
 */