package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import java.util.Iterator;
import java.util.List;

final class i$9
  implements Runnable
{
  i$9(i parami, int paramInt1, int paramInt2, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(25855);
    synchronized (this.tdk.callbacks)
    {
      Iterator localIterator = this.tdk.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).i(this.val$errType, this.val$errCode, this.tdo);
      }
    }
    AppMethodBeat.o(25855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.9
 * JD-Core Version:    0.7.0.1
 */