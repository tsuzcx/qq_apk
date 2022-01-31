package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$13
  implements Runnable
{
  g$13(g paramg, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(127960);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).fh(this.kLx, this.val$errCode);
      }
    }
    AppMethodBeat.o(127960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.13
 * JD-Core Version:    0.7.0.1
 */