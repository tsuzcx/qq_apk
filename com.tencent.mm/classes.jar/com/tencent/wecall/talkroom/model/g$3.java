package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$3
  implements Runnable
{
  g$3(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(127950);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).akV();
      }
    }
    AppMethodBeat.o(127950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.3
 * JD-Core Version:    0.7.0.1
 */