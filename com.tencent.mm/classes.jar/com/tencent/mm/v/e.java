package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.api.q;
import com.tencent.mm.model.ce;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.u.b.a;
import com.tencent.mm.u.d;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/executor/OpNoShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e
  implements b
{
  public static final e.a fTG;
  
  static
  {
    AppMethodBeat.i(114141);
    fTG = new e.a((byte)0);
    AppMethodBeat.o(114141);
  }
  
  public final void a(com.tencent.mm.u.e parame, q paramq, bd parambd, h paramh1, h paramh2, long paramLong)
  {
    AppMethodBeat.i(114139);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(parambd, "storage");
    k.h(paramh1, "newFunctionMsgItem");
    paramh1.bW(false);
    if (paramh2 != null)
    {
      if (paramh2.getVersion() < paramh1.getVersion())
      {
        ad.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, update the exist one, preVersion: %s oldFunctionMsgItem:%s", new Object[] { Long.valueOf(paramh2.JL()), paramh2 });
        paramh2.be(paramh2.getVersion());
        paramh1.be(paramh2.getVersion());
        paramh2.setActionTime(paramh1.getActionTime());
        paramh2.dY(paramh1.JM());
        paramq = paramh2.JK();
        k.g(paramq, "oldFunctionMsgItem!!.functionMsgId");
        bd.a(paramq, paramh1);
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
    parambd.insert((c)paramh1);
    parame.a(2, paramh1, (b)paramq);
    AppMethodBeat.o(114139);
  }
  
  public final void a(com.tencent.mm.u.e parame, q paramq, final d paramd)
  {
    AppMethodBeat.i(114140);
    k.h(parame, "timer");
    k.h(paramq, "dispatcher");
    k.h(paramd, "task");
    h localh = paramd.fTu;
    if (localh.getStatus() == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localh);
      new com.tencent.mm.u.b((List)localLinkedList, paramq, (b.a)new b(parame, paramd)).acI();
    }
    AppMethodBeat.o(114140);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/executor/OpNoShowExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"})
  public static final class b
    implements b.a
  {
    b(com.tencent.mm.u.e parame, d paramd) {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(114138);
      k.h(paramh, "item");
      ad.i("FunctionMsg.OpNoShowExecutor", "[onSuccessFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getActionTime() > ce.asQ() / 1000L) {
        this.fTB.a(2, paramh, paramd.fTv);
      }
      AppMethodBeat.o(114138);
    }
    
    public final void b(h paramh)
    {
      AppMethodBeat.i(114137);
      k.h(paramh, "item");
      ad.w("FunctionMsg.OpNoShowExecutor", "[onFailFetch] item:".concat(String.valueOf(paramh)));
      if (paramh.getStatus() == -1) {
        this.fTB.a(-1, paramh, paramd.fTv);
      }
      AppMethodBeat.o(114137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.e
 * JD-Core Version:    0.7.0.1
 */