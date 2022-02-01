package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.api.s;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bs;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class c
  implements b
{
  public static final c.a hfa;
  
  static
  {
    AppMethodBeat.i(114133);
    hfa = new c.a((byte)0);
    AppMethodBeat.o(114133);
  }
  
  public final void a(e parame, s params, bs parambs, i parami1, i parami2, long paramLong)
  {
    AppMethodBeat.i(114131);
    p.h(parame, "timer");
    p.h(params, "dispatcher");
    p.h(parambs, "storage");
    p.h(parami1, "newFunctionMsgItem");
    if (parami2 != null)
    {
      parami1.cI(true);
      parami2.bp(parami2.getVersion());
      parami2.bo(parami1.getVersion());
      if (0L < parami1.Vq()) {
        parami2.br(parami1.Vq() + parami1.Vp());
      }
      for (;;)
      {
        parami2.fz(parami1.Vm());
        params = parami2.Vk();
        p.g(params, "oldFunctionMsgItem!!.functionMsgId");
        bs.a(params, parami2);
        Log.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + parami1.Vk() + ", op delay! update the exist one, new ActionTime:" + parami1.Vq() + " new delay:" + parami1.Vp() + " reslt:" + parami2);
        parame.a(101, parami2, (b)this);
        AppMethodBeat.o(114131);
        return;
        parami2.br(parami2.Vq() + parami1.Vp());
      }
    }
    Log.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ".concat(String.valueOf(parami1)));
    AppMethodBeat.o(114131);
  }
  
  public final void a(e parame, final s params, final d paramd)
  {
    AppMethodBeat.i(114132);
    p.h(parame, "timer");
    p.h(params, "dispatcher");
    p.h(paramd, "task");
    final i locali = paramd.heU;
    if (locali.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(locali);
      new com.tencent.mm.u.b((List)localLinkedList, params, (b.a)new b(parame, paramd, locali, params)).awH();
      AppMethodBeat.o(114132);
      return;
    }
    if ((locali.getStatus() == 2) || (locali.getStatus() == -2))
    {
      Log.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + locali.Vk() + " actionTime:" + locali.Vq());
      if (locali.Vq() <= cl.aWy() / 1000L)
      {
        params.a(locali.Vk(), locali, locali.Vn());
        AppMethodBeat.o(114132);
        return;
      }
      parame.a(locali.Vj(), locali, paramd.heV);
    }
    AppMethodBeat.o(114132);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/executor/OpDelayExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, i parami, s params) {}
    
    public final void a(i parami)
    {
      AppMethodBeat.i(114130);
      p.h(parami, "item");
      Log.i("FunctionMsg.OpDelayExecutor", "[onSuccessFetch] item:".concat(String.valueOf(parami)));
      if (parami.Vq() > cl.aWy() / 1000L)
      {
        this.hfb.a(101, parami, paramd.heV);
        AppMethodBeat.o(114130);
        return;
      }
      Log.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] to show! id" + locali.Vk());
      params.a(parami.Vk(), parami, parami.Vn());
      AppMethodBeat.o(114130);
    }
    
    public final void b(i parami)
    {
      AppMethodBeat.i(114129);
      p.h(parami, "item");
      Log.w("FunctionMsg.OpDelayExecutor", "[onFailFetch] item:".concat(String.valueOf(parami)));
      if (parami.getStatus() == -1) {
        this.hfb.a(-1, parami, paramd.heV);
      }
      AppMethodBeat.o(114129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.v.c
 * JD-Core Version:    0.7.0.1
 */