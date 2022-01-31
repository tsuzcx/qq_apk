package com.tencent.mm.ui.chatting.i;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.c.a;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;

final class a$1
  implements c.a
{
  a$1(a parama) {}
  
  public final void z(LinkedList<e> paramLinkedList)
  {
    AppMethodBeat.i(32507);
    paramLinkedList = new a.1.1(this, paramLinkedList);
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      al.d(paramLinkedList);
      AppMethodBeat.o(32507);
      return;
    }
    paramLinkedList.run();
    AppMethodBeat.o(32507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a.1
 * JD-Core Version:    0.7.0.1
 */