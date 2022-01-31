package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.List;

final class i$3
  implements Runnable
{
  i$3(i parami, List paramList, m paramm, String paramString) {}
  
  public final void run()
  {
    Iterator localIterator = this.rXv.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (bk.pm(locald.acb()).equals(this.fDU.groupId)) {
        locald.SD(this.rWl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.i.3
 * JD-Core Version:    0.7.0.1
 */