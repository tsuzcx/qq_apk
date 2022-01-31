package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.bf.d;
import java.util.Iterator;
import java.util.List;

final class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public final void run()
  {
    synchronized (this.pBA.dhm)
    {
      Iterator localIterator = this.pBA.dhm.iterator();
      if (localIterator.hasNext()) {
        ((d)localIterator.next()).RM();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.1
 * JD-Core Version:    0.7.0.1
 */