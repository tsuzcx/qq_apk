package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import java.util.Iterator;
import java.util.List;

final class i$5
  implements Runnable
{
  i$5(i parami, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(25851);
    synchronized (this.tdk.callbacks)
    {
      Iterator localIterator = this.tdk.callbacks.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).t(this.tdl, this.tdm, this.tdn);
      }
    }
    AppMethodBeat.o(25851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.5
 * JD-Core Version:    0.7.0.1
 */