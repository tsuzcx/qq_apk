package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$19
  implements Runnable
{
  g$19(g paramg, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(127966);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).fM(this.BBT);
      }
    }
    AppMethodBeat.o(127966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.19
 * JD-Core Version:    0.7.0.1
 */