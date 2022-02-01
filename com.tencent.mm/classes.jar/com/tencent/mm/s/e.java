package com.tencent.mm.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.j;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.v.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/engine/FunctionMsgTimer;", "", "callback", "Lcom/tencent/mm/engine/ITimerCallback;", "(Lcom/tencent/mm/engine/ITimerCallback;)V", "mCallback", "mQueue", "Lcom/tencent/mm/engine/FunctionMsgQueue;", "add", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "check", "handleTask", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a mpV;
  final f mpW;
  final c mpX;
  
  static
  {
    AppMethodBeat.i(114126);
    mpV = new e.a((byte)0);
    AppMethodBeat.o(114126);
  }
  
  public e(f paramf)
  {
    AppMethodBeat.i(114125);
    this.mpW = paramf;
    this.mpX = new c(this);
    AppMethodBeat.o(114125);
  }
  
  public final void a(int paramInt, j paramj, b paramb)
  {
    AppMethodBeat.i(114123);
    s.u(paramj, "item");
    s.u(paramb, "executor");
    long l = System.currentTimeMillis();
    Log.i("FunctionMsg.FunctionMsgTimer", "[add] op:%s delay:%ss id:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramj.field_actionTime - cn.bDu() / 1000L), paramj.field_functionmsgid });
    this.mpX.a(new d(paramInt, paramj, paramb));
    Log.i("FunctionMsg.FunctionMsgTimer", "[add] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(114123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.s.e
 * JD-Core Version:    0.7.0.1
 */