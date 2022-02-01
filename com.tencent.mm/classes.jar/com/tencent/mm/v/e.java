package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bn;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/executor/OpNoShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e
  implements b
{
  public static final e.a gtw;
  
  static
  {
    AppMethodBeat.i(114141);
    gtw = new e.a((byte)0);
    AppMethodBeat.o(114141);
  }
  
  public final void a(com.tencent.mm.u.e parame, q paramq, bn parambn, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114139);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(parambn, "storage");
    p.h(paramh1, "newFunctionMsgItem");
    paramh1.bZ(false);
    if (paramh2 != null)
    {
      if (paramh2.getVersion() < paramh1.getVersion())
      {
        ae.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, update the exist one, preVersion: %s oldFunctionMsgItem:%s", new Object[] { Long.valueOf(paramh2.Lb()), paramh2 });
        paramh2.ba(paramh2.getVersion());
        paramh1.ba(paramh2.getVersion());
        paramh2.bc(paramh1.Lg());
        paramh2.eN(paramh1.Lc());
        paramq = paramh2.La();
        p.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
        bn.a(paramq, paramh1);
        parame.a(2, paramh1, (b)this);
        AppMethodBeat.o(114139);
        return;
      }
      ae.w("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show! but version is smaller");
      AppMethodBeat.o(114139);
      return;
    }
    paramq = (e)this;
    ae.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, insert a new one! %s", new Object[] { paramh1 });
    parambn.insert((c)paramh1);
    parame.a(2, paramh1, (b)paramq);
    AppMethodBeat.o(114139);
  }
  
  public final void a(com.tencent.mm.u.e parame, q paramq, final d paramd)
  {
    AppMethodBeat.i(114140);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(paramd, "task");
    h localh = paramd.gtk;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.u.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd)).agI();
    }
    AppMethodBeat.o(114140);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/executor/OpNoShowExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(com.tencent.mm.u.e parame, d paramd) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114138);
      p.h(paramh, "item");
      ae.i("FunctionMsg.OpNoShowExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.Lg() > ch.aDa() / 1000L) {
        this.gtr.a(2, paramh, paramd.gtl);
      }
      AppMethodBeat.o(114138);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114137);
      p.h(paramh, "item");
      ae.w("FunctionMsg.OpNoShowExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.gtr.a(-1, paramh, paramd.gtl);
      }
      AppMethodBeat.o(114137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.v.e
 * JD-Core Version:    0.7.0.1
 */