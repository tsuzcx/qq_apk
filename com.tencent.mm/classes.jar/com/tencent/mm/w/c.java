package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class c
  implements b
{
  public static final c.a jQS;
  
  static
  {
    AppMethodBeat.i(114133);
    jQS = new c.a((byte)0);
    AppMethodBeat.o(114133);
  }
  
  public final void a(e parame, s params, bs parambs, i parami1, i parami2, long paramLong)
  {
    AppMethodBeat.i(114131);
    p.k(parame, "timer");
    p.k(params, "dispatcher");
    p.k(parambs, "storage");
    p.k(parami1, "newFunctionMsgItem");
    if (parami2 != null)
    {
      parami1.de(true);
      parami2.bC(parami2.getVersion());
      parami2.bB(parami1.getVersion());
      if (0L < parami1.ZJ()) {
        parami2.bE(parami1.ZJ() + parami1.ZI());
      }
      for (;;)
      {
        parami2.gk(parami1.ZF());
        params = parami2.ZD();
        p.j(params, "oldFunctionMsgItem!!.functionMsgId");
        bs.a(params, parami2);
        Log.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + parami1.ZD() + ", op delay! update the exist one, new ActionTime:" + parami1.ZJ() + " new delay:" + parami1.ZI() + " reslt:" + parami2);
        parame.a(101, parami2, (b)this);
        AppMethodBeat.o(114131);
        return;
        parami2.bE(parami2.ZJ() + parami1.ZI());
      }
    }
    Log.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ".concat(String.valueOf(parami1)));
    AppMethodBeat.o(114131);
  }
  
  public final void a(e parame, final s params, final d paramd)
  {
    AppMethodBeat.i(114132);
    p.k(parame, "timer");
    p.k(params, "dispatcher");
    p.k(paramd, "task");
    final i locali = paramd.jQM;
    if (locali.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(locali);
      new com.tencent.mm.u.b((List)localLinkedList, params, (b.a)new b(parame, paramd, locali, params)).aDZ();
      AppMethodBeat.o(114132);
      return;
    }
    if ((locali.getStatus() == 2) || (locali.getStatus() == -2))
    {
      Log.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + locali.ZD() + " actionTime:" + locali.ZJ());
      if (locali.ZJ() <= cm.bfC() / 1000L)
      {
        params.a(locali.ZD(), locali, locali.ZG(), (List)locali.ZC());
        AppMethodBeat.o(114132);
        return;
      }
      parame.a(locali.ZB(), locali, paramd.jQN);
    }
    AppMethodBeat.o(114132);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/executor/OpDelayExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, i parami, s params) {}
    
    public final void a(i parami)
    {
      AppMethodBeat.i(114130);
      p.k(parami, "item");
      Log.i("FunctionMsg.OpDelayExecutor", "[onSuccessFetch] item:".concat(String.valueOf(parami)));
      if (parami.ZJ() > cm.bfC() / 1000L)
      {
        this.jQT.a(101, parami, paramd.jQN);
        AppMethodBeat.o(114130);
        return;
      }
      Log.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] to show! id" + locali.ZD());
      params.a(parami.ZD(), parami, parami.ZG(), (List)parami.ZC());
      AppMethodBeat.o(114130);
    }
    
    public final void b(i parami)
    {
      AppMethodBeat.i(114129);
      p.k(parami, "item");
      Log.w("FunctionMsg.OpDelayExecutor", "[onFailFetch] item:".concat(String.valueOf(parami)));
      if (parami.getStatus() == -1) {
        this.jQT.a(-1, parami, paramd.jQN);
      }
      AppMethodBeat.o(114129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.w.c
 * JD-Core Version:    0.7.0.1
 */