package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$14
  implements Runnable
{
  g$14(g paramg, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(127961);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).jx(this.kLR);
      }
    }
    AppMethodBeat.o(127961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.14
 * JD-Core Version:    0.7.0.1
 */