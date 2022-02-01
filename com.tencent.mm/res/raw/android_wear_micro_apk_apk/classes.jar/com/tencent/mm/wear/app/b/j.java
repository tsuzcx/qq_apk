package com.tencent.mm.wear.app.b;

import com.tencent.mm.b.a.f;
import com.tencent.mm.sdk.a.e;
import com.tencent.mm.wear.a.c.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class j
{
  private HashMap<Integer, com.tencent.mm.wear.app.d.b.a> aeP = new HashMap();
  private com.tencent.mm.wear.app.d.a.a.j aeQ;
  private e aef = new e() {};
  
  public j()
  {
    com.tencent.mm.sdk.a.a.YM.a(this.aef);
    this.aeQ = new com.tencent.mm.wear.app.d.a.a.j();
  }
  
  public final void a(com.tencent.mm.wear.app.d.b.a parama)
  {
    Iterator localIterator = parama.nE().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      d.d("MicroMsg.MMMessageCore", "add handler %d %s", new Object[] { Integer.valueOf(i), parama });
      this.aeP.put(Integer.valueOf(i), parama);
    }
  }
  
  public final void finish()
  {
    this.aeP.clear();
    this.aeQ.finish();
    com.tencent.mm.sdk.a.a.YM.b(this.aef);
  }
  
  public final com.tencent.mm.wear.app.d.a.a.j nh()
  {
    return this.aeQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.b.j
 * JD-Core Version:    0.7.0.1
 */