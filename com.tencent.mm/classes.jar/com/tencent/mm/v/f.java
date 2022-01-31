package com.tencent.mm.v;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ba;
import com.tencent.mm.u.d;
import com.tencent.mm.u.e;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/executor/OpShowExecutor;", "Lcom/tencent/mm/executor/IOpExecutor;", "()V", "execute", "", "timer", "Lcom/tencent/mm/engine/FunctionMsgTimer;", "dispatcher", "Lcom/tencent/mm/api/IFunctionMsgDispatcher;", "storage", "Lcom/tencent/mm/storage/FunctionMsgStorage;", "newFunctionMsgItem", "Lcom/tencent/mm/api/FunctionMsgItem;", "oldFunctionMsgItem", "newXmlCreateTime", "", "onTaskExpired", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class f
  implements b
{
  public static final f.a ezc;
  
  static
  {
    AppMethodBeat.i(35491);
    ezc = new f.a((byte)0);
    AppMethodBeat.o(35491);
  }
  
  public final void a(e parame, com.tencent.mm.api.l paraml, ba paramba, com.tencent.mm.api.f paramf1, com.tencent.mm.api.f paramf2, long paramLong)
  {
    AppMethodBeat.i(35489);
    j.q(parame, "timer");
    j.q(paraml, "dispatcher");
    j.q(paramba, "storage");
    j.q(paramf1, "newFunctionMsgItem");
    ab.i("FunctionMsg.OpShowExecutor", "[OpShowExecutor] op show, old functionMsgItem:".concat(String.valueOf(paramf2)));
    paramf1.bl(true);
    if (paramf2 != null)
    {
      paraml = new StringBuilder("[OpShowExecutor] op show!,").append(paramf1.getVersion()).append(", ").append(paramf2.getVersion()).append(',');
      if (paramf2.Ag() != null) {
        break label236;
      }
    }
    label236:
    for (boolean bool = true;; bool = false)
    {
      ab.i("FunctionMsg.OpShowExecutor", bool);
      paramf2.bl(true);
      if ((paramf2.Ag() != null) && (paramf2.getStatus() == 2))
      {
        ab.i("FunctionMsg.OpShowExecutor", "show, update create time to: %s", new Object[] { Long.valueOf(paramLong) });
        paraml = paramf2.Ag();
        if (paraml != null) {
          paraml.CreateTime = ((int)(cb.abp() / 1000L));
        }
      }
      paramf2.aF(paramf1.Ai());
      paramf2.cY(paramf1.Af());
      paraml = paramf2.Ad();
      j.p(paraml, "oldFunctionMsgItem!!.functionMsgId");
      ba.a(paraml, paramf2);
      parame.a(3, paramf2, (b)this);
      AppMethodBeat.o(35489);
      return;
    }
  }
  
  public final void a(e parame, com.tencent.mm.api.l paraml, d paramd)
  {
    AppMethodBeat.i(35490);
    j.q(parame, "timer");
    j.q(paraml, "dispatcher");
    j.q(paramd, "task");
    parame = paramd.eyP;
    paraml.a(parame.Ad(), parame, parame.Ag());
    AppMethodBeat.o(35490);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.v.f
 * JD-Core Version:    0.7.0.1
 */