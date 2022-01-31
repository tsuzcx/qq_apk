package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$2
  implements Runnable
{
  g$2(g paramg, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(127949);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).Tp(this.val$errCode);
      }
    }
    AppMethodBeat.o(127949);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.2
 * JD-Core Version:    0.7.0.1
 */