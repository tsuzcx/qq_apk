package com.tencent.mm.plugin.talkroom.model;

import java.util.Iterator;
import java.util.List;

final class i$11
  implements Runnable
{
  i$11(i parami, String paramString) {}
  
  public final void run()
  {
    synchronized (this.pBA.dhm)
    {
      Iterator localIterator = this.pBA.dhm.iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i.11
 * JD-Core Version:    0.7.0.1
 */