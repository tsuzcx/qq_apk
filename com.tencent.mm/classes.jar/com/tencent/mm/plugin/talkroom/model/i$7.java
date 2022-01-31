package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import java.util.Iterator;
import java.util.List;

final class i$7
  implements Runnable
{
  i$7(i parami, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(25853);
    synchronized (this.tdk.callbacks)
    {
      Iterator localIterator = this.tdk.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).mh(this.val$errCode);
      }
    }
    AppMethodBeat.o(25853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.7
 * JD-Core Version:    0.7.0.1
 */