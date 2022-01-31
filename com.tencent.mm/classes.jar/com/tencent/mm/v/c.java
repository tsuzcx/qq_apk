package com.tencent.mm.v;

import a.d.b.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public final class c
{
  public static final c.a dBx = new c.a((byte)0);
  final HashMap<String, d> cJ = new HashMap();
  final e dBo;
  final LinkedList<d> dBw = new LinkedList();
  
  public c(e parame)
  {
    this.dBo = parame;
  }
  
  public final void loop()
  {
    y.i("FunctionMsg.FunctionMsgQueue", "[loop] size:" + this.dBw.size());
    ListIterator localListIterator = this.dBw.listIterator();
    while (localListIterator.hasNext())
    {
      d locald = (d)localListIterator.next();
      if (locald.dBy.rU() <= bz.Is() / 1000L)
      {
        localListIterator.remove();
        this.cJ.remove(locald.dBy.rO());
        e locale = this.dBo;
        g.j(locald, "task");
        g.k(locald, "task");
        locale.dBA.a(locald.bMU, locald);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.v.c
 * JD-Core Version:    0.7.0.1
 */