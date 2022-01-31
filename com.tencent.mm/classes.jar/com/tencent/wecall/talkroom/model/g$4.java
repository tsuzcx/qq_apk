package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$4
  implements Runnable
{
  g$4(g paramg, int paramInt, Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(127951);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).l(this.val$errCode, this.rNd);
      }
    }
    AppMethodBeat.o(127951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.4
 * JD-Core Version:    0.7.0.1
 */