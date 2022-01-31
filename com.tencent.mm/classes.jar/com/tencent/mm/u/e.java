package com.tencent.mm.u;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.v.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/engine/FunctionMsgTimer;", "", "callback", "Lcom/tencent/mm/engine/ITimerCallback;", "(Lcom/tencent/mm/engine/ITimerCallback;)V", "mCallback", "mQueue", "Lcom/tencent/mm/engine/FunctionMsgQueue;", "add", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "check", "handleTask", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e
{
  public static final e.a eyT;
  final f eyR;
  public final c eyS;
  
  static
  {
    AppMethodBeat.i(35473);
    eyT = new e.a((byte)0);
    AppMethodBeat.o(35473);
  }
  
  public e(f paramf)
  {
    AppMethodBeat.i(35472);
    this.eyR = paramf;
    this.eyS = new c(this);
    AppMethodBeat.o(35472);
  }
  
  public final void a(int paramInt, com.tencent.mm.api.f paramf, b paramb)
  {
    AppMethodBeat.i(35471);
    j.q(paramf, "item");
    j.q(paramb, "executor");
    long l = System.currentTimeMillis();
    ab.i("FunctionMsg.FunctionMsgTimer", "[add] op:%s delay:%ss id:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramf.Ai() - cb.abp() / 1000L), paramf.Ad() });
    this.eyS.a(new d(paramInt, paramf, paramb));
    ab.i("FunctionMsg.FunctionMsgTimer", "[add] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(35471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.u.e
 * JD-Core Version:    0.7.0.1
 */