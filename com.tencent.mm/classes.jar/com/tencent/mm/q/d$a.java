package com.tencent.mm.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.smiley.l;
import com.tencent.mm.smiley.m;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/easteregg/EasterEggProcessor$matchEasterEgg$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
  implements m
{
  public d$a(LinkedList<c> paramLinkedList) {}
  
  public final boolean a(l paraml, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231286);
    s.u(paraml, "item");
    if ((paraml instanceof a)) {
      this.mdz.add(new c(((a)paraml).mdu, ((a)paraml).mdw, paramInt1, paramInt2));
    }
    AppMethodBeat.o(231286);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.q.d.a
 * JD-Core Version:    0.7.0.1
 */