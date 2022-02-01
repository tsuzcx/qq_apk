package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.byp.b.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class k$3
  implements Runnable
{
  k$3(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(199006);
    List localList = ((n)h.ae(n.class)).eSe().fY(Collections.singletonList("gamelifemessage"));
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ca localca = (ca)localIterator.next();
      a.a locala = com.tencent.mm.plugin.byp.b.a.sWz;
      if (!com.tencent.mm.plugin.byp.b.a.cFf().contains(Long.valueOf(localca.field_msgId)))
      {
        localca.setStatus(5);
        ((n)h.ae(n.class)).eSe().a(localca.field_msgId, localca);
      }
    }
    Log.i("GameLife.ChattingComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), this.WIj.fgR.hOp(), this.WIj.fgR.getTalkerUserName() });
    AppMethodBeat.o(199006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.k.3
 * JD-Core Version:    0.7.0.1
 */