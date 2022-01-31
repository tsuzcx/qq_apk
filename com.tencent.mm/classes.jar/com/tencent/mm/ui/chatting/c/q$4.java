package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b;
import com.tencent.mm.ui.chatting.d.a;

final class q$4
  implements ChatFooter.b
{
  q$4(q paramq) {}
  
  public final String getTalkerUserName()
  {
    AppMethodBeat.i(31410);
    String str = this.zGa.caz.getTalkerUserName();
    AppMethodBeat.o(31410);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.q.4
 * JD-Core Version:    0.7.0.1
 */