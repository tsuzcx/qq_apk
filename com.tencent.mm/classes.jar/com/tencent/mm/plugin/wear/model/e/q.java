package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class q
{
  public HashMap<Integer, a> qSM = new HashMap();
  
  public final a Bj(int paramInt)
  {
    return (a)this.qSM.get(Integer.valueOf(paramInt));
  }
  
  public final void a(a parama)
  {
    Iterator localIterator = parama.bYY().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      y.d("MicroMsg.Wear.WearHttpServerLogic", "add funId %d %s", new Object[] { Integer.valueOf(i), parama });
      this.qSM.put(Integer.valueOf(i), parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.q
 * JD-Core Version:    0.7.0.1
 */