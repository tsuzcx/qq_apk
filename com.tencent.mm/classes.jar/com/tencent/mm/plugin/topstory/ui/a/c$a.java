package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.vfs.s;

final class c$a
  implements Runnable
{
  private c$a(c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(126557);
    String str = String.format("%s/%s", new Object[] { ai.afr(1).fYs(), "app.html" });
    this.Gqs.Gqp = s.aW(str, 0, -1);
    AppMethodBeat.o(126557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.c.a
 * JD-Core Version:    0.7.0.1
 */