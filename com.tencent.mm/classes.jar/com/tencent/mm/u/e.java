package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.h;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.v.b;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/engine/FunctionMsgTimer;", "", "callback", "Lcom/tencent/mm/engine/ITimerCallback;", "(Lcom/tencent/mm/engine/ITimerCallback;)V", "mCallback", "mQueue", "Lcom/tencent/mm/engine/FunctionMsgQueue;", "add", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "check", "handleTask", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e
{
  public static final e.a gto;
  final f gtm;
  private final c gtn;
  
  static
  {
    AppMethodBeat.i(114126);
    gto = new e.a((byte)0);
    AppMethodBeat.o(114126);
  }
  
  public e(f paramf)
  {
    AppMethodBeat.i(114125);
    this.gtm = paramf;
    this.gtn = new c(this);
    AppMethodBeat.o(114125);
  }
  
  public final void a(int paramInt, h paramh, b paramb)
  {
    AppMethodBeat.i(114123);
    p.h(paramh, "item");
    p.h(paramb, "executor");
    long l = System.currentTimeMillis();
    ae.i("FunctionMsg.FunctionMsgTimer", "[add] op:%s delay:%ss id:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramh.Lg() - ch.aDa() / 1000L), paramh.La() });
    this.gtn.a(new d(paramInt, paramh, paramb));
    ae.i("FunctionMsg.FunctionMsgTimer", "[add] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(114123);
  }
  
  public final void agJ()
  {
    AppMethodBeat.i(114124);
    long l = System.currentTimeMillis();
    this.gtn.loop();
    ae.i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(114124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.u.e
 * JD-Core Version:    0.7.0.1
 */