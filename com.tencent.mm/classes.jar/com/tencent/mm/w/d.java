package com.tencent.mm.w;

import a.d.b.g;
import com.tencent.mm.api.k;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ba;

public final class d
  implements b
{
  public static final d.a dBJ = new d.a((byte)0);
  
  public final void a(com.tencent.mm.v.e parame, k paramk, ba paramba, com.tencent.mm.api.e parame1, com.tencent.mm.api.e parame2, long paramLong)
  {
    g.k(parame, "timer");
    g.k(paramk, "dispatcher");
    g.k(paramba, "storage");
    g.k(parame1, "newFunctionMsgItem");
    y.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete! id:" + parame1);
    if (parame2 != null)
    {
      y.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, %s", new Object[] { Long.valueOf(parame1.rP()), Long.valueOf(parame2.rP()), parame2 });
      if ((parame1.rP() == parame2.rP()) || (parame1.rP() == 0L))
      {
        parame2.ai(parame1.rU());
        paramba.a((c)parame2, new String[0]);
        parame.a(1, parame2, (b)this);
      }
      return;
    }
    y.i("FunctionMsg.OpDeleteExecutor", "[OpDeleteExecutor] op delete, the origin one not exist! " + parame1);
  }
  
  public final void a(com.tencent.mm.v.e parame, k paramk, com.tencent.mm.v.d paramd)
  {
    g.k(parame, "timer");
    g.k(paramk, "dispatcher");
    g.k(paramd, "task");
    y.i("FunctionMsg.OpDeleteExecutor", "[onTaskExpired] delete " + paramd.dBy.rO());
    parame = paramd.dBy;
    paramk.b(parame.rO(), parame, parame.rS());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.w.d
 * JD-Core Version:    0.7.0.1
 */