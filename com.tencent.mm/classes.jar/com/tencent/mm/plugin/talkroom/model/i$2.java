package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import java.util.Iterator;
import java.util.List;

final class i$2
  implements Runnable
{
  i$2(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(25848);
    synchronized (this.tdk.callbacks)
    {
      Iterator localIterator = this.tdk.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).akY();
      }
    }
    AppMethodBeat.o(25848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.2
 * JD-Core Version:    0.7.0.1
 */