package com.tencent.tencentmap.mapsdk.a;

import java.util.Iterator;
import java.util.List;

class jf$3
  implements Runnable
{
  jf$3(jf paramjf, jo.c paramc) {}
  
  public void run()
  {
    Iterator localIterator = jf.b(this.b).iterator();
    while (localIterator.hasNext())
    {
      iq localiq = (iq)localIterator.next();
      if (localiq != null) {
        localiq.a(this.a);
      }
    }
    jf.c(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jf.3
 * JD-Core Version:    0.7.0.1
 */