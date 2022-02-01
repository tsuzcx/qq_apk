package com.tencent.mm.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bm;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.d;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/executor/OpNoShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e
  implements b
{
  public static final e.a gqW;
  
  static
  {
    AppMethodBeat.i(114141);
    gqW = new e.a((byte)0);
    AppMethodBeat.o(114141);
  }
  
  public final void a(com.tencent.mm.v.e parame, q paramq, bm parambm, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114139);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(parambm, "storage");
    p.h(paramh1, "newFunctionMsgItem");
    paramh1.bZ(false);
    if (paramh2 != null)
    {
      if (paramh2.getVersion() < paramh1.getVersion())
      {
        ad.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, update the exist one, preVersion: %s oldFunctionMsgItem:%s", new Object[] { Long.valueOf(paramh2.KT()), paramh2 });
        paramh2.ba(paramh2.getVersion());
        paramh1.ba(paramh2.getVersion());
        paramh2.bc(paramh1.KY());
        paramh2.eI(paramh1.KU());
        paramq = paramh2.KS();
        p.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
        bm.a(paramq, paramh1);
        parame.a(2, paramh1, (b)this);
        AppMethodBeat.o(114139);
        return;
      }
      ad.w("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show! but version is smaller");
      AppMethodBeat.o(114139);
      return;
    }
    paramq = (e)this;
    ad.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, insert a new one! %s", new Object[] { paramh1 });
    parambm.insert((c)paramh1);
    parame.a(2, paramh1, (b)paramq);
    AppMethodBeat.o(114139);
  }
  
  public final void a(com.tencent.mm.v.e parame, q paramq, final d paramd)
  {
    AppMethodBeat.i(114140);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(paramd, "task");
    h localh = paramd.gqK;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.v.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd)).agu();
    }
    AppMethodBeat.o(114140);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/executor/OpNoShowExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(com.tencent.mm.v.e parame, d paramd) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114138);
      p.h(paramh, "item");
      ad.i("FunctionMsg.OpNoShowExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.KY() > cf.aCK() / 1000L) {
        this.gqR.a(2, paramh, paramd.gqL);
      }
      AppMethodBeat.o(114138);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114137);
      p.h(paramh, "item");
      ad.w("FunctionMsg.OpNoShowExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.gqR.a(-1, paramh, paramd.gqL);
      }
      AppMethodBeat.o(114137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.w.e
 * JD-Core Version:    0.7.0.1
 */