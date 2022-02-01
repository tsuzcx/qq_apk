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
import com.tencent.mm.u.e;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/executor/OpUpdateExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class g
  implements b
{
  public static final g.a gty;
  
  static
  {
    AppMethodBeat.i(114149);
    gty = new g.a((byte)0);
    AppMethodBeat.o(114149);
  }
  
  public final void a(e parame, q paramq, bn parambn, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114147);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(parambn, "storage");
    p.h(paramh1, "newFunctionMsgItem");
    paramh1.bZ(true);
    if (paramh2 == null)
    {
      ae.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, insert a new one! ".concat(String.valueOf(paramh1)));
      parambn.insert((c)paramh1);
      parame.a(0, paramh1, (b)this);
      AppMethodBeat.o(114147);
      return;
    }
    if (paramh2.getVersion() < paramh1.getVersion())
    {
      ae.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, update the exist one! [%s:%s]", new Object[] { paramh1, paramh2 });
      paramh2.ba(paramh2.getVersion());
      paramh1.ba(paramh2.getVersion());
      paramq = paramh2.La();
      p.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
      bn.a(paramq, paramh1);
      parame.a(0, paramh1, (b)this);
      AppMethodBeat.o(114147);
      return;
    }
    if (paramh2.getVersion() >= paramh1.getVersion()) {
      ae.e("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor], id:%s old:new [%s:%s]", new Object[] { paramh2.La(), Long.valueOf(paramh2.getVersion()), Long.valueOf(paramh1.getVersion()) });
    }
    AppMethodBeat.o(114147);
  }
  
  public final void a(e parame, final q paramq, final d paramd)
  {
    AppMethodBeat.i(114148);
    p.h(parame, "timer");
    p.h(paramq, "dispatcher");
    p.h(paramd, "task");
    final h localh = paramd.gtk;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.u.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd, localh, paramq)).agI();
      AppMethodBeat.o(114148);
      return;
    }
    if ((localh.getStatus() == 2) || (localh.getStatus() == -2))
    {
      ae.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] id" + localh.La() + " actionTime:" + localh.Lg());
      if (localh.Lg() <= ch.aDa() / 1000L)
      {
        paramq.a(localh.La(), localh, localh.Ld());
        AppMethodBeat.o(114148);
        return;
      }
      parame.a(localh.KZ(), localh, paramd.gtl);
    }
    AppMethodBeat.o(114148);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/executor/OpUpdateExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, h paramh, q paramq) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114146);
      p.h(paramh, "item");
      ae.i("FunctionMsg.OpUpdateExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.Lg() > ch.aDa() / 1000L)
      {
        this.gtr.a(0, paramh, paramd.gtl);
        AppMethodBeat.o(114146);
        return;
      }
      ae.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] to show! id:" + localh.La());
      paramq.a(paramh.La(), paramh, paramh.Ld());
      AppMethodBeat.o(114146);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114145);
      p.h(paramh, "item");
      ae.w("FunctionMsg.OpUpdateExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.gtr.a(-1, paramh, paramd.gtl);
      }
      AppMethodBeat.o(114145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.v.g
 * JD-Core Version:    0.7.0.1
 */