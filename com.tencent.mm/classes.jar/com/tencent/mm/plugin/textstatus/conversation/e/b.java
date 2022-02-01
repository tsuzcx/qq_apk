package com.tencent.mm.plugin.textstatus.conversation.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.conversation.d.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isGreetingConversation", "", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final boolean a(a parama)
  {
    AppMethodBeat.i(290831);
    s.u(parama, "<this>");
    boolean bool = s.p(parama.field_sessionId, "textstatussayhisessionholder");
    AppMethodBeat.o(290831);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.e.b
 * JD-Core Version:    0.7.0.1
 */