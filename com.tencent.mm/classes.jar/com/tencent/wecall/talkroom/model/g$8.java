package com.tencent.wecall.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class g$8
  implements Runnable
{
  g$8(g paramg, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(127955);
    synchronized (this.BBO.callbacks)
    {
      ArrayList localArrayList = new ArrayList(this.BBO.callbacks);
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((g.a)((Iterator)???).next()).cx(this.kLx, this.BBP);
      }
    }
    AppMethodBeat.o(127955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g.8
 * JD-Core Version:    0.7.0.1
 */