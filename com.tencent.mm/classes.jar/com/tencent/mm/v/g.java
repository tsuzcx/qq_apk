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
import com.tencent.mm.u.e;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/executor/OpUpdateExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class g
  implements b
{
  public static final g.a fXC;
  
  static
  {
    AppMethodBeat.i(114149);
    fXC = new g.a((byte)0);
    AppMethodBeat.o(114149);
  }
  
  public final void a(e parame, q paramq, bg parambg, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114147);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(parambg, "storage");
    k.h(paramh1, "newFunctionMsgItem");
    paramh1.bX(true);
    if (paramh2 == null)
    {
      ac.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, insert a new one! ".concat(String.valueOf(paramh1)));
      parambg.insert((c)paramh1);
      parame.a(0, paramh1, (b)this);
      AppMethodBeat.o(114147);
      return;
    }
    if (paramh2.getVersion() < paramh1.getVersion())
    {
      ac.i("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor] op update, update the exist one! [%s:%s]", new Object[] { paramh1, paramh2 });
      paramh2.ba(paramh2.getVersion());
      paramh1.ba(paramh2.getVersion());
      paramq = paramh2.Jt();
      k.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
      bg.a(paramq, paramh1);
      parame.a(0, paramh1, (b)this);
      AppMethodBeat.o(114147);
      return;
    }
    if (paramh2.getVersion() >= paramh1.getVersion()) {
      ac.e("FunctionMsg.OpUpdateExecutor", "[OpUpdateExecutor], id:%s old:new [%s:%s]", new Object[] { paramh2.Jt(), Long.valueOf(paramh2.getVersion()), Long.valueOf(paramh1.getVersion()) });
    }
    AppMethodBeat.o(114147);
  }
  
  public final void a(e parame, final q paramq, final d paramd)
  {
    AppMethodBeat.i(114148);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(paramd, "task");
    final h localh = paramd.fXo;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.u.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd, localh, paramq)).adO();
      AppMethodBeat.o(114148);
      return;
    }
    if ((localh.getStatus() == 2) || (localh.getStatus() == -2))
    {
      ac.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] id" + localh.Jt() + " actionTime:" + localh.Jz());
      if (localh.Jz() <= ce.azH() / 1000L)
      {
        paramq.a(localh.Jt(), localh, localh.Jw());
        AppMethodBeat.o(114148);
        return;
      }
      parame.a(localh.Js(), localh, paramd.fXp);
    }
    AppMethodBeat.o(114148);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/executor/OpUpdateExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, h paramh, q paramq) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114146);
      k.h(paramh, "item");
      ac.i("FunctionMsg.OpUpdateExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.Jz() > ce.azH() / 1000L)
      {
        this.fXv.a(0, paramh, paramd.fXp);
        AppMethodBeat.o(114146);
        return;
      }
      ac.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] to show! id:" + localh.Jt());
      paramq.a(paramh.Jt(), paramh, paramh.Jw());
      AppMethodBeat.o(114146);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114145);
      k.h(paramh, "item");
      ac.w("FunctionMsg.OpUpdateExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.fXv.a(-1, paramh, paramd.fXp);
      }
      AppMethodBeat.o(114145);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.v.g
 * JD-Core Version:    0.7.0.1
 */