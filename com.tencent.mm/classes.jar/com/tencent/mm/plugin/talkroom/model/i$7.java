package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.bf.d;
import java.util.Iterator;
import java.util.List;

final class i$7
  implements Runnable
{
  i$7(i parami, int paramInt) {}
  
  public final void run()
  {
    synchronized (this.pBA.dhm)
    {
      Iterator localIterator = this.pBA.dhm.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).jp(this.bEg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.7
 * JD-Core Version:    0.7.0.1
 */