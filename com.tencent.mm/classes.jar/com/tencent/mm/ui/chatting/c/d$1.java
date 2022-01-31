package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.chatting.d.a;

final class d$1
  implements q.a
{
  d$1(d paramd, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(31237);
    this.zEu.caz.hideVKB();
    if (paramBoolean)
    {
      g.bPJ().q(this.fwC, this.zEs, this.zEt);
      g.bPJ().fh(paramString, this.zEs);
    }
    AppMethodBeat.o(31237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.d.1
 * JD-Core Version:    0.7.0.1
 */