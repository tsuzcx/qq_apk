package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$15
  implements Runnable
{
  g$15(g paramg, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(127962);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).Tq(this.BBR);
      }
    }
    AppMethodBeat.o(127962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.15
 * JD-Core Version:    0.7.0.1
 */