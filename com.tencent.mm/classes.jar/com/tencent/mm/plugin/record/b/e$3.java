package com.tencent.mm.plugin.record.b;

import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.f;
import java.util.Iterator;
import java.util.Vector;

final class e$3
  implements Runnable
{
  e$3(e parame, int paramInt, f paramf) {}
  
  public final void run()
  {
    Iterator localIterator = e.a(this.ntc).iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).a(this.bns, this.ntd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.e.3
 * JD-Core Version:    0.7.0.1
 */