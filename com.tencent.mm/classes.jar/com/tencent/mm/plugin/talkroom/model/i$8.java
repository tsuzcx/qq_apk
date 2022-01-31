package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import java.util.Iterator;
import java.util.List;

final class i$8
  implements Runnable
{
  i$8(i parami, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(25854);
    synchronized (this.tdk.callbacks)
    {
      Iterator localIterator = this.tdk.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).uM(this.cat);
      }
    }
    AppMethodBeat.o(25854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.8
 * JD-Core Version:    0.7.0.1
 */