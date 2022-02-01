package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bg;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/executor/OpNoShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e
  implements b
{
  public static final e.a fXA;
  
  static
  {
    AppMethodBeat.i(114141);
    fXA = new e.a((byte)0);
    AppMethodBeat.o(114141);
  }
  
  public final void a(com.tencent.mm.u.e parame, q paramq, bg parambg, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114139);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(parambg, "storage");
    k.h(paramh1, "newFunctionMsgItem");
    paramh1.bX(false);
    if (paramh2 != null)
    {
      if (paramh2.getVersion() < paramh1.getVersion())
      {
        ac.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, update the exist one, preVersion: %s oldFunctionMsgItem:%s", new Object[] { Long.valueOf(paramh2.Ju()), paramh2 });
        paramh2.ba(paramh2.getVersion());
        paramh1.ba(paramh2.getVersion());
        paramh2.bc(paramh1.Jz());
        paramh2.dN(paramh1.Jv());
        paramq = paramh2.Jt();
        k.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
        bg.a(paramq, paramh1);
        parame.a(2, paramh1, (b)this);
        AppMethodBeat.o(114139);
        return;
      }
      ac.w("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show! but version is smaller");
      AppMethodBeat.o(114139);
      return;
    }
    paramq = (e)this;
    ac.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, insert a new one! %s", new Object[] { paramh1 });
    parambg.insert((c)paramh1);
    parame.a(2, paramh1, (b)paramq);
    AppMethodBeat.o(114139);
  }
  
  public final void a(com.tencent.mm.u.e parame, q paramq, final d paramd)
  {
    AppMethodBeat.i(114140);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(paramd, "task");
    h localh = paramd.fXo;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.u.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd)).adO();
    }
    AppMethodBeat.o(114140);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/executor/OpNoShowExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(com.tencent.mm.u.e parame, d paramd) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114138);
      k.h(paramh, "item");
      ac.i("FunctionMsg.OpNoShowExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.Jz() > ce.azH() / 1000L) {
        this.fXv.a(2, paramh, paramd.fXp);
      }
      AppMethodBeat.o(114138);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114137);
      k.h(paramh, "item");
      ac.w("FunctionMsg.OpNoShowExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.fXv.a(-1, paramh, paramd.fXp);
      }
      AppMethodBeat.o(114137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.v.e
 * JD-Core Version:    0.7.0.1
 */