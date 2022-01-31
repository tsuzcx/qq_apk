package com.tencent.mm.w;

import com.tencent.mm.api.k;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ba;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.d;
import java.util.LinkedList;
import java.util.List;

public final class g
  implements b
{
  public static final g.a dBM = new g.a((byte)0);
  
  public final void a(com.tencent.mm.v.e parame, k paramk, ba paramba, com.tencent.mm.api.e parame1, com.tencent.mm.api.e parame2, long paramLong)
  {
    a.d.b.g.k(parame, "timer");
    a.d.b.g.k(paramk, "dispatcher");
    a.d.b.g.k(paramba, "storage");
    a.d.b.g.k(parame1, "newFunctionMsgItem");
    parame1.aM(true);
    if (parame2 == null)
    {
      y.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, insert a new one! " + parame1);
      paramba.b((c)parame1);
      parame.a(0, parame1, (b)this);
    }
    do
    {
      return;
      if (parame2.rP() < parame1.rP())
      {
        y.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, update the exist one! [%s:%s]", new Object[] { parame1, parame2 });
        parame2.ag(parame2.rP());
        parame1.ag(parame2.rP());
        paramk = parame2.rO();
        a.d.b.g.j(paramk, "oldFunctionMsgItem!!.functionMsgId");
        ba.a(paramk, parame1);
        parame.a(0, parame1, (b)this);
        return;
      }
    } while (parame2.rP() < parame1.rP());
    y.e("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor], id:%s old:new [%s:%s]", new Object[] { parame2.rO(), Long.valueOf(parame2.rP()), Long.valueOf(parame1.rP()) });
  }
  
  public final void a(com.tencent.mm.v.e parame, k paramk, d paramd)
  {
    a.d.b.g.k(parame, "timer");
    a.d.b.g.k(paramk, "dispatcher");
    a.d.b.g.k(paramd, "task");
    com.tencent.mm.api.e locale = paramd.dBy;
    if (locale.getStatus() == -1)
    {
      localLinkedList = new LinkedList();
      localLinkedList.add(locale);
      new com.tencent.mm.v.b((List)localLinkedList, paramk, (b.a)new g.b(parame, paramd, locale, paramk)).By();
    }
    while ((locale.getStatus() != 2) && (locale.getStatus() != -2))
    {
      LinkedList localLinkedList;
      return;
    }
    y.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] id" + locale.rO() + " actionTime:" + locale.rU());
    if (locale.rU() <= bz.Is() / 1000L)
    {
      paramk.a(locale.rO(), locale, locale.rS());
      return;
    }
    parame.a(locale.rN(), locale, paramd.dBz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.w.g
 * JD-Core Version:    0.7.0.1
 */