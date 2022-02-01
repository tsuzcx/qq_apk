package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.w.b;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/engine/FunctionMsgTimer;", "", "callback", "Lcom/tencent/mm/engine/ITimerCallback;", "(Lcom/tencent/mm/engine/ITimerCallback;)V", "mCallback", "mQueue", "Lcom/tencent/mm/engine/FunctionMsgQueue;", "add", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "check", "handleTask", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e
{
  public static final e.a gqO;
  final f gqM;
  private final c gqN;
  
  static
  {
    AppMethodBeat.i(114126);
    gqO = new e.a((byte)0);
    AppMethodBeat.o(114126);
  }
  
  public e(f paramf)
  {
    AppMethodBeat.i(114125);
    this.gqM = paramf;
    this.gqN = new c(this);
    AppMethodBeat.o(114125);
  }
  
  public final void a(int paramInt, h paramh, b paramb)
  {
    AppMethodBeat.i(114123);
    p.h(paramh, "item");
    p.h(paramb, "executor");
    long l = System.currentTimeMillis();
    ad.i("FunctionMsg.FunctionMsgTimer", "[add] op:%s delay:%ss id:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramh.KY() - cf.aCK() / 1000L), paramh.KS() });
    this.gqN.a(new d(paramInt, paramh, paramb));
    ad.i("FunctionMsg.FunctionMsgTimer", "[add] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(114123);
  }
  
  public final void agv()
  {
    AppMethodBeat.i(114124);
    long l = System.currentTimeMillis();
    this.gqN.loop();
    ad.i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(114124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.v.e
 * JD-Core Version:    0.7.0.1
 */