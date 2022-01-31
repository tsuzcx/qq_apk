package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import java.util.Iterator;
import java.util.List;

final class i$10
  implements Runnable
{
  i$10(i parami, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(25856);
    synchronized (this.tdk.callbacks)
    {
      Iterator localIterator = this.tdk.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).aX(this.obA, this.obB);
      }
    }
    AppMethodBeat.o(25856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.10
 * JD-Core Version:    0.7.0.1
 */