package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$16
  implements Runnable
{
  g$16(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(127963);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).bTn();
      }
    }
    AppMethodBeat.o(127963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.16
 * JD-Core Version:    0.7.0.1
 */