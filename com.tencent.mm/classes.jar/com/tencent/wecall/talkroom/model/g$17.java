package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class g$17
  implements Runnable
{
  g$17(g paramg, String paramString, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(127964);
    synchronized (this.BBO.callbacks)
    {
      Iterator localIterator = this.BBO.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((g.a)localIterator.next()).H(this.kLx, this.BBS);
      }
    }
    AppMethodBeat.o(127964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.17
 * JD-Core Version:    0.7.0.1
 */