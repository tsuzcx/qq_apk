package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$11
  implements Runnable
{
  g$11(g paramg, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(127958);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).cp(this.BBQ);
      }
    }
    AppMethodBeat.o(127958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.11
 * JD-Core Version:    0.7.0.1
 */