package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$1
  implements Runnable
{
  g$1(g paramg, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(127948);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).zE(this.BBN);
      }
    }
    AppMethodBeat.o(127948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.1
 * JD-Core Version:    0.7.0.1
 */