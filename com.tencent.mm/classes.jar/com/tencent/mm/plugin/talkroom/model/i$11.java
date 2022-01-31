package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class i$11
  implements Runnable
{
  i$11(i parami, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(25857);
    synchronized (this.tdk.callbacks)
    {
      Iterator localIterator = this.tdk.callbacks.iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    AppMethodBeat.o(25857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.11
 * JD-Core Version:    0.7.0.1
 */