package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class c
  implements b
{
  public static final c.a fTA;
  
  static
  {
    AppMethodBeat.i(114133);
    fTA = new c.a((byte)0);
    AppMethodBeat.o(114133);
  }
  
  public final void a(e parame, q paramq, bd parambd, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114131);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(parambd, "storage");
    k.h(paramh1, "newFunctionMsgItem");
    if (paramh2 != null)
    {
      paramh1.bW(true);
      paramh2.be(paramh2.getVersion());
      paramh2.bd(paramh1.getVersion());
      if (0L < paramh1.getActionTime()) {
        paramh2.setActionTime(paramh1.getActionTime() + paramh1.JP());
      }
      for (;;)
      {
        paramh2.dY(paramh1.JM());
        paramq = paramh2.JK();
        k.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
        bd.a(paramq, paramh2);
        ad.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + paramh1.JK() + ", op delay! update the exist one, new ActionTime:" + paramh1.getActionTime() + " new delay:" + paramh1.JP() + " reslt:" + paramh2);
        parame.a(101, paramh2, (b)this);
        AppMethodBeat.o(114131);
        return;
        paramh2.setActionTime(paramh2.getActionTime() + paramh1.JP());
      }
    }
    ad.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ".concat(String.valueOf(paramh1)));
    AppMethodBeat.o(114131);
  }
  
  public final void a(e parame, final q paramq, final d paramd)
  {
    AppMethodBeat.i(114132);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(paramd, "task");
    final h localh = paramd.fTu;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.u.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd, localh, paramq)).acI();
      AppMethodBeat.o(114132);
      return;
    }
    if ((localh.getStatus() == 2) || (localh.getStatus() == -2))
    {
      ad.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + localh.JK() + " actionTime:" + localh.getActionTime());
      if (localh.getActionTime() <= ce.asQ() / 1000L)
      {
        paramq.a(localh.JK(), localh, localh.JN());
        AppMethodBeat.o(114132);
        return;
      }
      parame.a(localh.JJ(), localh, paramd.fTv);
    }
    AppMethodBeat.o(114132);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/executor/OpDelayExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, h paramh, q paramq) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114130);
      k.h(paramh, "item");
      ad.i("FunctionMsg.OpDelayExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getActionTime() > ce.asQ() / 1000L)
      {
        this.fTB.a(101, paramh, paramd.fTv);
        AppMethodBeat.o(114130);
        return;
      }
      ad.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] to show! id" + localh.JK());
      paramq.a(paramh.JK(), paramh, paramh.JN());
      AppMethodBeat.o(114130);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114129);
      k.h(paramh, "item");
      ad.w("FunctionMsg.OpDelayExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.fTB.a(-1, paramh, paramd.fTv);
      }
      AppMethodBeat.o(114129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.c
 * JD-Core Version:    0.7.0.1
 */