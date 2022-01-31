package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import java.util.Iterator;
import java.util.List;

final class i$12
  implements Runnable
{
  i$12(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(25858);
    synchronized (this.tdk.callbacks)
    {
      Iterator localIterator = this.tdk.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).akX();
      }
    }
    AppMethodBeat.o(25858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.12
 * JD-Core Version:    0.7.0.1
 */