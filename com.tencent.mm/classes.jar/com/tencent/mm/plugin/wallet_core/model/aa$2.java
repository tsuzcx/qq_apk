package com.tencent.mm.plugin.wallet_core.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

final class aa$2
  implements Runnable
{
  aa$2(int paramInt, Map paramMap) {}
  
  public final void run()
  {
    if (aa.Pq() != null)
    {
      Iterator localIterator = aa.Pq().iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if (localj != null) {
          localj.tz(this.qyH);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aa.2
 * JD-Core Version:    0.7.0.1
 */