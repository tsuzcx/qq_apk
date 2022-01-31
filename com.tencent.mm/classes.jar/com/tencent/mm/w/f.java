package com.tencent.mm.w;

import a.d.b.g;
import com.tencent.mm.api.k;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ba;
import com.tencent.mm.v.d;

public final class f
  implements b
{
  public static final f.a dBL = new f.a((byte)0);
  
  public final void a(com.tencent.mm.v.e parame, k paramk, ba paramba, com.tencent.mm.api.e parame1, com.tencent.mm.api.e parame2, long paramLong)
  {
    g.k(parame, "timer");
    g.k(paramk, "dispatcher");
    g.k(paramba, "storage");
    g.k(parame1, "newFunctionMsgItem");
    y.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:" + parame2);
    parame1.aM(true);
    if (parame2 != null)
    {
      paramk = new StringBuilder("[OpShowExecutor] op show!,").append(parame1.rP()).append(", ").append(parame2.rP()).append(',');
      if (parame2.rS() != null) {
        break label233;
      }
    }
    label233:
    for (boolean bool = true;; bool = false)
    {
      y.i("FunctionMsg.OpShowExecutor", bool);
      parame2.aM(true);
      if ((parame2.rS() != null) && (parame2.getStatus() == 2))
      {
        y.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", new Object[] { Long.valueOf(paramLong) });
        paramk = parame2.rS();
        if (paramk != null) {
          paramk.mPL = ((int)(bz.Is() / 1000L));
        }
      }
      parame2.ai(parame1.rU());
      parame2.bW(parame1.rR());
      paramk = parame2.rO();
      g.j(paramk, "oldFunctionMsgItem!!.functionMsgId");
      ba.a(paramk, parame2);
      parame.a(3, parame2, (b)this);
      return;
    }
  }
  
  public final void a(com.tencent.mm.v.e parame, k paramk, d paramd)
  {
    g.k(parame, "timer");
    g.k(paramk, "dispatcher");
    g.k(paramd, "task");
    parame = paramd.dBy;
    paramk.a(parame.rO(), parame, parame.rS());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.w.f
 * JD-Core Version:    0.7.0.1
 */