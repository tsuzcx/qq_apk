package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bn;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class c
  implements b
{
  public static final c.a gtq;
  
  static
  {
    AppMethodBeat.i(114133);
    gtq = new c.a((byte)0);
    AppMethodBeat.o(114133);
  }
  
  public final void a(e parame, q paramq, bn parambn, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114131);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(parambn, "storage");
    p.h(paramh1, "newFunctionMsgItem");
    if (paramh2 != null)
    {
      paramh1.bZ(true);
      paramh2.ba(paramh2.getVersion());
      paramh2.aZ(paramh1.getVersion());
      if (0L < paramh1.Lg()) {
        paramh2.bc(paramh1.Lg() + paramh1.Lf());
      }
      for (;;)
      {
        paramh2.eN(paramh1.Lc());
        paramq = paramh2.La();
        p.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
        bn.a(paramq, paramh2);
        ae.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + paramh1.La() + ", op delay! update the exist one, new ActionTime:" + paramh1.Lg() + " new delay:" + paramh1.Lf() + " reslt:" + paramh2);
        parame.a(101, paramh2, (b)this);
        AppMethodBeat.o(114131);
        return;
        paramh2.bc(paramh2.Lg() + paramh1.Lf());
      }
    }
    ae.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ".concat(String.valueOf(paramh1)));
    AppMethodBeat.o(114131);
  }
  
  public final void a(e parame, final q paramq, final d paramd)
  {
    AppMethodBeat.i(114132);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(paramd, "task");
    final h localh = paramd.gtk;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.u.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd, localh, paramq)).agI();
      AppMethodBeat.o(114132);
      return;
    }
    if ((localh.getStatus() == 2) || (localh.getStatus() == -2))
    {
      ae.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + localh.La() + " actionTime:" + localh.Lg());
      if (localh.Lg() <= ch.aDa() / 1000L)
      {
        paramq.a(localh.La(), localh, localh.Ld());
        AppMethodBeat.o(114132);
        return;
      }
      parame.a(localh.KZ(), localh, paramd.gtl);
    }
    AppMethodBeat.o(114132);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/executor/OpDelayExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, h paramh, q paramq) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114130);
      p.h(paramh, "item");
      ae.i("FunctionMsg.OpDelayExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.Lg() > ch.aDa() / 1000L)
      {
        this.gtr.a(101, paramh, paramd.gtl);
        AppMethodBeat.o(114130);
        return;
      }
      ae.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] to show! id" + localh.La());
      paramq.a(paramh.La(), paramh, paramh.Ld());
      AppMethodBeat.o(114130);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114129);
      p.h(paramh, "item");
      ae.w("FunctionMsg.OpDelayExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.gtr.a(-1, paramh, paramd.gtl);
      }
      AppMethodBeat.o(114129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.v.c
 * JD-Core Version:    0.7.0.1
 */