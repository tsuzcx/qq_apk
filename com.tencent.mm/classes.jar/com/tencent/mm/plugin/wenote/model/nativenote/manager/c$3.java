package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.plugin.wenote.model.a.i;
import java.util.ArrayList;
import java.util.Iterator;

final class c$3
  implements Runnable
{
  c$3(c paramc) {}
  
  public final void run()
  {
    int i;
    synchronized (this.rHC)
    {
      if (c.d(this.rHC) == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = c.d(this.rHC).iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        com.tencent.mm.plugin.wenote.model.a.c localc1 = (com.tencent.mm.plugin.wenote.model.a.c)localIterator.next();
        if (localc1.getType() != 1) {
          i += 1;
        } else {
          localStringBuilder.append(((i)localc1).content);
        }
      }
    }
    c.a(this.rHC, com.tencent.mm.plugin.wenote.b.c.UE(localObject.toString()));
    c.b(this.rHC, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.manager.c.3
 * JD-Core Version:    0.7.0.1
 */