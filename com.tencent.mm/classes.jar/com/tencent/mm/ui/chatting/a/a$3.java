package com.tencent.mm.ui.chatting.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;

final class a$3
  implements h.a
{
  a$3(a parama) {}
  
  public final void a(h paramh, h.c paramc)
  {
    AppMethodBeat.i(31097);
    if ((paramh == null) || (paramc == null))
    {
      AppMethodBeat.o(31097);
      return;
    }
    if ((paramc.talker == null) || (a.a(this.zDD).getTalkerUserName() == null))
    {
      AppMethodBeat.o(31097);
      return;
    }
    if (paramc.talker.equals(a.a(this.zDD).getTalkerUserName())) {
      this.zDD.dHc();
    }
    AppMethodBeat.o(31097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a.3
 * JD-Core Version:    0.7.0.1
 */