package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bm;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.d;
import com.tencent.mm.v.e;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class c
  implements b
{
  public static final c.a gqQ;
  
  static
  {
    AppMethodBeat.i(114133);
    gqQ = new c.a((byte)0);
    AppMethodBeat.o(114133);
  }
  
  public final void a(e parame, q paramq, bm parambm, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114131);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(parambm, "storage");
    p.h(paramh1, "newFunctionMsgItem");
    if (paramh2 != null)
    {
      paramh1.bZ(true);
      paramh2.ba(paramh2.getVersion());
      paramh2.aZ(paramh1.getVersion());
      if (0L < paramh1.KY()) {
        paramh2.bc(paramh1.KY() + paramh1.KX());
      }
      for (;;)
      {
        paramh2.eI(paramh1.KU());
        paramq = paramh2.KS();
        p.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
        bm.a(paramq, paramh2);
        ad.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + paramh1.KS() + ", op delay! update the exist one, new ActionTime:" + paramh1.KY() + " new delay:" + paramh1.KX() + " reslt:" + paramh2);
        parame.a(101, paramh2, (b)this);
        AppMethodBeat.o(114131);
        return;
        paramh2.bc(paramh2.KY() + paramh1.KX());
      }
    }
    ad.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ".concat(String.valueOf(paramh1)));
    AppMethodBeat.o(114131);
  }
  
  public final void a(e parame, final q paramq, final d paramd)
  {
    AppMethodBeat.i(114132);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(paramd, "task");
    final h localh = paramd.gqK;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.v.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd, localh, paramq)).agu();
      AppMethodBeat.o(114132);
      return;
    }
    if ((localh.getStatus() == 2) || (localh.getStatus() == -2))
    {
      ad.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + localh.KS() + " actionTime:" + localh.KY());
      if (localh.KY() <= cf.aCK() / 1000L)
      {
        paramq.a(localh.KS(), localh, localh.KV());
        AppMethodBeat.o(114132);
        return;
      }
      parame.a(localh.KR(), localh, paramd.gqL);
    }
    AppMethodBeat.o(114132);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/executor/OpDelayExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, h paramh, q paramq) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114130);
      p.h(paramh, "item");
      ad.i("FunctionMsg.OpDelayExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.KY() > cf.aCK() / 1000L)
      {
        this.gqR.a(101, paramh, paramd.gqL);
        AppMethodBeat.o(114130);
        return;
      }
      ad.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] to show! id" + localh.KS());
      paramq.a(paramh.KS(), paramh, paramh.KV());
      AppMethodBeat.o(114130);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114129);
      p.h(paramh, "item");
      ad.w("FunctionMsg.OpDelayExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.gqR.a(-1, paramh, paramd.gqL);
      }
      AppMethodBeat.o(114129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.w.c
 * JD-Core Version:    0.7.0.1
 */