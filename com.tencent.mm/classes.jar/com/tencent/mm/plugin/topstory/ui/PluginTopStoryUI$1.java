package com.tencent.mm.plugin.topstory.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;

final class PluginTopStoryUI$1
  implements Runnable
{
  PluginTopStoryUI$1(PluginTopStoryUI paramPluginTopStoryUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(1518);
    long l = aa.Jf(1);
    if (((Long)g.RL().Ru().get(ac.a.yKO, Long.valueOf(0L))).longValue() != l)
    {
      h.qsU.e(17040, new Object[] { Integer.valueOf(1), Long.valueOf(l) });
      g.RL().Ru().set(ac.a.yKO, Long.valueOf(l));
      g.RL().Ru().dww();
    }
    ((j)g.E(j.class)).YF().arF("topstoryapp");
    ab.i("MicroMsg.TopStory.PluginTopStoryUI", "Delete TopStory Conversation Entry");
    AppMethodBeat.o(1518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI.1
 * JD-Core Version:    0.7.0.1
 */