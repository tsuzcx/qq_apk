package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import java.util.LinkedList;

final class t$10$2
  implements ao.b.a
{
  t$10$2(t.10 param10, String paramString) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(31490);
    com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(this.zGJ.zGC.caz.zJz.getContext(), new t.10.2.1(this));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(3));
    aw.aaz();
    paramString = c.YA().arw(t.e(this.zGJ.zGC));
    if (paramString != null) {}
    for (paramString = bo.bf(paramString.dra, "");; paramString = "")
    {
      locala.amg(paramString);
      locala.c(t.e(this.zGJ.zGC), this.pxB, localLinkedList);
      AppMethodBeat.o(31490);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.t.10.2
 * JD-Core Version:    0.7.0.1
 */