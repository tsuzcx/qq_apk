package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.model.cn;
import com.tencent.mm.s.b.a;
import com.tencent.mm.s.d;
import com.tencent.mm.s.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bu;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/executor/OpDelayExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements b
{
  public static final c.a mqb;
  
  static
  {
    AppMethodBeat.i(114133);
    mqb = new c.a((byte)0);
    AppMethodBeat.o(114133);
  }
  
  public final void a(e parame, final u paramu, final d paramd)
  {
    AppMethodBeat.i(114132);
    s.u(parame, "timer");
    s.u(paramu, "dispatcher");
    s.u(paramd, "task");
    final j localj = paramd.mpT;
    if (localj.field_status == -1)
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(localj);
      new com.tencent.mm.s.b((List)localLinkedList, paramu, (b.a)new b(parame, paramd, localj, paramu)).aXc();
      AppMethodBeat.o(114132);
      return;
    }
    if ((localj.field_status == 2) || (localj.field_status == -2))
    {
      Log.i("FunctionMsg.OpDelayExecutor", "[onTaskExpired] id" + localj.field_functionmsgid + " actionTime:" + localj.field_actionTime);
      if (localj.field_actionTime <= cn.bDu() / 1000L)
      {
        paramu.a(localj.field_functionmsgid, localj, localj.field_addMsg, (List)localj.aBt());
        AppMethodBeat.o(114132);
        return;
      }
      parame.a(localj.field_opCode, localj, paramd.mpU);
    }
    AppMethodBeat.o(114132);
  }
  
  public final void a(e parame, u paramu, bu parambu, j paramj1, j paramj2, long paramLong)
  {
    AppMethodBeat.i(114131);
    s.u(parame, "timer");
    s.u(paramu, "dispatcher");
    s.u(parambu, "storage");
    s.u(paramj1, "newFunctionMsgItem");
    if (paramj2 == null)
    {
      parame = null;
      if (parame == null) {
        Log.i("FunctionMsg.OpDelayExecutor", s.X("[OpDelayExecutor] op delay, oldFunctionMsgItem is null! newFunctionMsgItem: ", paramj1));
      }
      AppMethodBeat.o(114131);
      return;
    }
    paramj1.field_needShow = true;
    s.checkNotNull(paramj2);
    paramj2.field_preVersion = paramj2.field_version;
    paramj2.field_version = paramj1.field_version;
    if (0L < paramj1.field_actionTime) {}
    for (paramj1.field_actionTime += paramj1.field_delayTime;; paramj2.field_actionTime += paramj1.field_delayTime)
    {
      paramj2.hL(paramj1.field_custombuff);
      paramu = paramj2.field_functionmsgid;
      s.s(paramu, "oldFunctionMsgItem!!.functionMsgId");
      bu.a(paramu, paramj2);
      Log.i("FunctionMsg.OpDelayExecutor", "[OpDelayExecutor], functionMsgId: " + paramj1.field_functionmsgid + ", op delay! update the exist one, new ActionTime:" + paramj1.field_actionTime + " new delay:" + paramj1.field_delayTime + " reslt:" + paramj2);
      parame.a(101, paramj2, (b)this);
      parame = ah.aiuX;
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/executor/OpDelayExecutor$onTaskExpired$1", "Lcom/tencent/mm/engine/FunctionMsgFetcher$IFunctionMsgFetcherCallback;", "onFailFetch", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "onSuccessFetch", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements b.a
  {
    b(e parame, d paramd, j paramj, u paramu) {}
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(114130);
      s.u(paramj, "item");
      Log.i("FunctionMsg.OpDelayExecutor", s.X("[onSuccessFetch] item:", paramj));
      if (paramj.field_actionTime > cn.bDu() / 1000L)
      {
        this.mqc.a(101, paramj, paramd.mpU);
        AppMethodBeat.o(114130);
        return;
      }
      Log.i("FunctionMsg.OpDelayExecutor", s.X("[onTaskExpired] to show! id", localj.field_functionmsgid));
      paramu.a(paramj.field_functionmsgid, paramj, paramj.field_addMsg, (List)paramj.aBt());
      AppMethodBeat.o(114130);
    }
    
    public final void b(j paramj)
    {
      AppMethodBeat.i(114129);
      s.u(paramj, "item");
      Log.w("FunctionMsg.OpDelayExecutor", s.X("[onFailFetch] item:", paramj));
      if (paramj.field_status == -1) {
        this.mqc.a(-1, paramj, paramd.mpU);
      }
      AppMethodBeat.o(114129);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.c
 * JD-Core Version:    0.7.0.1
 */