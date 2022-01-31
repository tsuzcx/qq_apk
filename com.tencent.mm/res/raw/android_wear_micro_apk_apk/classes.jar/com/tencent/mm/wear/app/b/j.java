package com.tencent.mm.wear.app.b;

import com.tencent.mm.b.a.f;
import com.tencent.mm.sdk.a.e;
import com.tencent.mm.wear.a.c.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class j
{
  private e aaE = new e() {};
  private HashMap<Integer, com.tencent.mm.wear.app.d.b.a> abo = new HashMap();
  private com.tencent.mm.wear.app.d.a.a.j abp;
  
  public j()
  {
    com.tencent.mm.sdk.a.a.WJ.a(this.aaE);
    this.abp = new com.tencent.mm.wear.app.d.a.a.j();
  }
  
  public final void a(com.tencent.mm.wear.app.d.b.a parama)
  {
    Iterator localIterator = parama.mS().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      d.e("MicroMsg.MMMessageCore", "add handler %d %s", new Object[] { Integer.valueOf(i), parama });
      this.abo.put(Integer.valueOf(i), parama);
    }
  }
  
  public final void finish()
  {
    this.abo.clear();
    this.abp.finish();
    com.tencent.mm.sdk.a.a.WJ.b(this.aaE);
  }
  
  public final com.tencent.mm.wear.app.d.a.a.j mv()
  {
    return this.abp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.b.j
 * JD-Core Version:    0.7.0.1
 */