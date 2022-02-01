package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.model.cn;
import com.tencent.mm.s.b.a;
import com.tencent.mm.s.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/executor/OpNoShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements b
{
  public static final e.a mqh;
  
  static
  {
    AppMethodBeat.i(114141);
    mqh = new e.a((byte)0);
    AppMethodBeat.o(114141);
  }
  
  public final void a(com.tencent.mm.s.e parame, u paramu, final d paramd)
  {
    AppMethodBeat.i(114140);
    s.u(parame, "timer");
    s.u(paramu, "dispatcher");
    s.u(paramd, "task");
    j localj = paramd.mpT;
    if (localj.field_status == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localj);
      new com.tencent.mm.s.b((List)localLinkedList, paramu, (b.a)new b(parame, paramd)).aXc();
    }
    AppMethodBeat.o(114140);
  }
  
  public final void a(com.tencent.mm.s.e parame, u paramu, bu parambu, j paramj1, j paramj2, long paramLong)
  {
    AppMethodBeat.i(114139);
    s.u(parame, "timer");
    s.u(paramu, "dispatcher");
    s.u(parambu, "storage");
    s.u(paramj1, "newFunctionMsgItem");
    paramj1.field_needShow = false;
    if (paramj2 == null)
    {
      paramu = null;
      if (paramu == null)
      {
        paramu = (e)this;
        Log.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, insert a new one! %s", new Object[] { paramj1 });
        parambu.insert((IAutoDBItem)paramj1);
        parame.a(2, paramj1, (b)paramu);
      }
      AppMethodBeat.o(114139);
      return;
    }
    s.checkNotNull(paramj2);
    if (paramj2.field_version < paramj1.field_version)
    {
      Log.i("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show, update the exist one, preVersion: %s oldFunctionMsgItem:%s", new Object[] { Long.valueOf(paramj2.field_preVersion), paramj2 });
      paramj2.field_preVersion = paramj2.field_version;
      paramj1.field_preVersion = paramj2.field_version;
      paramj2.field_actionTime = paramj1.field_actionTime;
      paramj2.hL(paramj1.field_custombuff);
      paramu = paramj2.field_functionmsgid;
      s.s(paramu, "oldFunctionMsgItem!!.functionMsgId");
      bu.a(paramu, paramj1);
      parame.a(2, paramj1, (b)this);
    }
    for (;;)
    {
      paramu = ah.aiuX;
      break;
      Log.w("FunctionMsg.OpNoShowExecutor", "[OpNoShowExecutor] op update but no show! but version is smaller");
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/executor/OpNoShowExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.a
  {
    b(com.tencent.mm.s.e parame, d paramd) {}
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(114138);
      s.u(paramj, "item");
      Log.i("FunctionMsg.OpNoShowExecutor", s.X("[onSuccessFetch] item:", paramj));
      if (paramj.field_actionTime > cn.bDu() / 1000L) {
        this.mqc.a(2, paramj, paramd.mpU);
      }
      AppMethodBeat.o(114138);
    }
    
    public final void b(j paramj)
    {
      AppMethodBeat.i(114137);
      s.u(paramj, "item");
      Log.w("FunctionMsg.OpNoShowExecutor", s.X("[onFailFetch] item:", paramj));
      if (paramj.field_status == -1) {
        this.mqc.a(-1, paramj, paramd.mpU);
      }
      AppMethodBeat.o(114137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.e
 * JD-Core Version:    0.7.0.1
 */