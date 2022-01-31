package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import java.util.Iterator;
import java.util.List;

final class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(25847);
    synchronized (this.tdk.callbacks)
    {
      Iterator localIterator = this.tdk.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).akV();
      }
    }
    AppMethodBeat.o(25847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.1
 * JD-Core Version:    0.7.0.1
 */