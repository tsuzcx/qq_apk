package com.tencent.mm.w;

import a.d.b.g;
import com.tencent.mm.api.k;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ba;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.d;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements b
{
  public static final c.a dBE = new c.a((byte)0);
  
  public final void a(com.tencent.mm.v.e parame, k paramk, ba paramba, com.tencent.mm.api.e parame1, com.tencent.mm.api.e parame2, long paramLong)
  {
    g.k(parame, "timer");
    g.k(paramk, "dispatcher");
    g.k(paramba, "storage");
    g.k(parame1, "newFunctionMsgItem");
    if (parame2 != null)
    {
      parame1.aM(true);
      parame2.ag(parame2.rP());
      parame2.af(parame1.rP());
      if (0L < parame1.rU()) {
        parame2.ai(parame1.rU() + parame1.rT());
      }
      for (;;)
      {
        parame2.bW(parame1.rR());
        paramk = parame2.rO();
        g.j(paramk, "oldFunctionMsgItem!!.functionMsgId");
        ba.a(paramk, parame2);
        y.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + parame1.rO() + ", op delay! update the exist one, new ActionTime:" + parame1.rU() + " new delay:" + parame1.rT() + " reslt:" + parame2);
        parame.a(101, parame2, (b)this);
        return;
        parame2.ai(parame2.rU() + parame1.rT());
      }
    }
    y.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: " + parame1);
  }
  
  public final void a(com.tencent.mm.v.e parame, final k paramk, final d paramd)
  {
    g.k(parame, "timer");
    g.k(paramk, "dispatcher");
    g.k(paramd, "task");
    final com.tencent.mm.api.e locale = paramd.dBy;
    if (locale.getStatus() == -1)
    {
      localLinkedList = new LinkedList();
      localLinkedList.add(locale);
      new com.tencent.mm.v.b((List)localLinkedList, paramk, (b.a)new b(parame, paramd, locale, paramk)).By();
    }
    while ((locale.getStatus() != 2) && (locale.getStatus() != -2))
    {
      LinkedList localLinkedList;
      return;
    }
    y.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + locale.rO() + " actionTime:" + locale.rU());
    if (locale.rU() <= bz.Is() / 1000L)
    {
      paramk.a(locale.rO(), locale, locale.rS());
      return;
    }
    parame.a(locale.rN(), locale, paramd.dBz);
  }
  
  public static final class b
    implements b.a
  {
    b(com.tencent.mm.v.e parame, d paramd, com.tencent.mm.api.e parame1, k paramk) {}
    
    public final void a(com.tencent.mm.api.e parame)
    {
      g.k(parame, "item");
      y.i("FunctionMsg.OpDelayExecutor", "[onSuccessFetch] item:" + parame);
      if (parame.rU() > bz.Is() / 1000L)
      {
        this.dBF.a(101, parame, paramd.dBz);
        return;
      }
      y.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] to show! id" + locale.rO());
      paramk.a(parame.rO(), parame, parame.rS());
    }
    
    public final void b(com.tencent.mm.api.e parame)
    {
      g.k(parame, "item");
      y.w("FunctionMsg.OpDelayExecutor", "[onFailFetch] item:" + parame);
      if (parame.getStatus() == -1) {
        this.dBF.a(-1, parame, paramd.dBz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.c
 * JD-Core Version:    0.7.0.1
 */