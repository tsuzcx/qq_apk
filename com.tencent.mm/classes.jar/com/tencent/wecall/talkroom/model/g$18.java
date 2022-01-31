package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$18
  implements Runnable
{
  g$18(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(127965);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).dXC();
      }
    }
    AppMethodBeat.o(127965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.18
 * JD-Core Version:    0.7.0.1
 */