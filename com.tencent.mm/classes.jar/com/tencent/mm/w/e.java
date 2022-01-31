package com.tencent.mm.w;

import a.d.b.g;
import com.tencent.mm.api.k;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ba;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.d;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements b
{
  public static final e.a dBK = new e.a((byte)0);
  
  public final void a(com.tencent.mm.v.e parame, k paramk, ba paramba, com.tencent.mm.api.e parame1, com.tencent.mm.api.e parame2, long paramLong)
  {
    g.k(parame, "timer");
    g.k(paramk, "dispatcher");
    g.k(paramba, "storage");
    g.k(parame1, "newFunctionMsgItem");
    parame1.aM(false);
    if (parame2 != null)
    {
      if (parame2.rP() < parame1.rP())
      {
        y.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, update the exist one, preVersion: %s oldFunctionMsgItem:%s", new Object[] { Long.valueOf(parame2.rQ()), parame2 });
        parame2.ag(parame2.rP());
        parame1.ag(parame2.rP());
        parame2.ai(parame1.rU());
        parame2.bW(parame1.rR());
        paramk = parame2.rO();
        g.j(paramk, "oldFunctionMsgItem!!.functionMsgId");
        ba.a(paramk, parame1);
        parame.a(2, parame1, (b)this);
        return;
      }
      y.w("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show! but version is smaller");
      return;
    }
    paramk = (e)this;
    y.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, insert a new one! %s", new Object[] { parame1 });
    paramba.b((c)parame1);
    parame.a(2, parame1, (b)paramk);
  }
  
  public final void a(com.tencent.mm.v.e parame, k paramk, d paramd)
  {
    g.k(parame, "timer");
    g.k(paramk, "dispatcher");
    g.k(paramd, "task");
    com.tencent.mm.api.e locale = paramd.dBy;
    if (locale.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(locale);
      new com.tencent.mm.v.b((List)localLinkedList, paramk, (b.a)new e.b(parame, paramd)).By();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.w.e
 * JD-Core Version:    0.7.0.1
 */