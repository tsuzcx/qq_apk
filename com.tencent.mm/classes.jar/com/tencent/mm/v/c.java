package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bg;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class c
  implements b
{
  public static final c.a fXu;
  
  static
  {
    AppMethodBeat.i(114133);
    fXu = new c.a((byte)0);
    AppMethodBeat.o(114133);
  }
  
  public final void a(e parame, q paramq, bg parambg, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114131);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(parambg, "storage");
    k.h(paramh1, "newFunctionMsgItem");
    if (paramh2 != null)
    {
      paramh1.bX(true);
      paramh2.ba(paramh2.getVersion());
      paramh2.aZ(paramh1.getVersion());
      if (0L < paramh1.Jz()) {
        paramh2.bc(paramh1.Jz() + paramh1.Jy());
      }
      for (;;)
      {
        paramh2.dN(paramh1.Jv());
        paramq = paramh2.Jt();
        k.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
        bg.a(paramq, paramh2);
        ac.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + paramh1.Jt() + ", op delay! update the exist one, new ActionTime:" + paramh1.Jz() + " new delay:" + paramh1.Jy() + " reslt:" + paramh2);
        parame.a(101, paramh2, (b)this);
        AppMethodBeat.o(114131);
        return;
        paramh2.bc(paramh2.Jz() + paramh1.Jy());
      }
    }
    ac.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ".concat(String.valueOf(paramh1)));
    AppMethodBeat.o(114131);
  }
  
  public final void a(e parame, final q paramq, final d paramd)
  {
    AppMethodBeat.i(114132);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(paramd, "task");
    final h localh = paramd.fXo;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.u.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd, localh, paramq)).adO();
      AppMethodBeat.o(114132);
      return;
    }
    if ((localh.getStatus() == 2) || (localh.getStatus() == -2))
    {
      ac.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + localh.Jt() + " actionTime:" + localh.Jz());
      if (localh.Jz() <= ce.azH() / 1000L)
      {
        paramq.a(localh.Jt(), localh, localh.Jw());
        AppMethodBeat.o(114132);
        return;
      }
      parame.a(localh.Js(), localh, paramd.fXp);
    }
    AppMethodBeat.o(114132);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/executor/OpDelayExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, h paramh, q paramq) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114130);
      k.h(paramh, "item");
      ac.i("FunctionMsg.OpDelayExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.Jz() > ce.azH() / 1000L)
      {
        this.fXv.a(101, paramh, paramd.fXp);
        AppMethodBeat.o(114130);
        return;
      }
      ac.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] to show! id" + localh.Jt());
      paramq.a(paramh.Jt(), paramh, paramh.Jw());
      AppMethodBeat.o(114130);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114129);
      k.h(paramh, "item");
      ac.w("FunctionMsg.OpDelayExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.fXv.a(-1, paramh, paramd.fXp);
      }
      AppMethodBeat.o(114129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.v.c
 * JD-Core Version:    0.7.0.1
 */