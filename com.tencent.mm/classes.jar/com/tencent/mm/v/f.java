package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.j;
import com.tencent.mm.api.u;
import com.tencent.mm.model.cn;
import com.tencent.mm.s.d;
import com.tencent.mm.s.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bu;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements b
{
  public static final f.a mqi;
  
  static
  {
    AppMethodBeat.i(114144);
    mqi = new f.a((byte)0);
    AppMethodBeat.o(114144);
  }
  
  public final void a(e parame, u paramu, d paramd)
  {
    AppMethodBeat.i(114143);
    s.u(parame, "timer");
    s.u(paramu, "dispatcher");
    s.u(paramd, "task");
    parame = paramd.mpT;
    paramu.a(parame.field_functionmsgid, parame, parame.field_addMsg, (List)parame.aBt());
    AppMethodBeat.o(114143);
  }
  
  public final void a(e parame, u paramu, bu parambu, j paramj1, j paramj2, long paramLong)
  {
    AppMethodBeat.i(114142);
    s.u(parame, "timer");
    s.u(paramu, "dispatcher");
    s.u(parambu, "storage");
    s.u(paramj1, "newFunctionMsgItem");
    Log.i("FunctionMsg.OpShowExecutor", s.X("[OpShowExecutor] op show, old functionMsgItem:", paramj2));
    paramj1.field_needShow = true;
    if (paramj2 != null)
    {
      paramu = new StringBuilder("[OpShowExecutor] op show!,").append(paramj1.field_version).append(", ").append(paramj2.field_version).append(',');
      if (paramj2.field_addMsg != null) {
        break label233;
      }
    }
    label233:
    for (boolean bool = true;; bool = false)
    {
      Log.i("FunctionMsg.OpShowExecutor", bool);
      paramj2.field_needShow = true;
      if ((paramj2.field_addMsg != null) && (paramj2.field_status == 2))
      {
        Log.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", new Object[] { Long.valueOf(paramLong) });
        paramu = paramj2.field_addMsg;
        if (paramu != null) {
          paramu.CreateTime = ((int)(cn.bDu() / 1000L));
        }
      }
      paramj2.field_actionTime = paramj1.field_actionTime;
      paramj2.hL(paramj1.field_custombuff);
      paramu = paramj2.field_functionmsgid;
      s.s(paramu, "oldFunctionMsgItem!!.functionMsgId");
      bu.a(paramu, paramj2);
      parame.a(3, paramj2, (b)this);
      AppMethodBeat.o(114142);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.v.f
 * JD-Core Version:    0.7.0.1
 */