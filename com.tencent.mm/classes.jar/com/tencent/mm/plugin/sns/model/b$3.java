package com.tencent.mm.plugin.sns.model;

import java.util.Iterator;
import java.util.Set;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, String paramString1, String paramString2) {}
  
  public final void run()
  {
    if (b.b(this.ooN) != null)
    {
      Iterator localIterator = b.b(this.ooN).iterator();
      while (localIterator.hasNext())
      {
        b.a locala = (b.a)localIterator.next();
        if (locala != null) {
          locala.eG(this.BF, this.dlh);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.3
 * JD-Core Version:    0.7.0.1
 */