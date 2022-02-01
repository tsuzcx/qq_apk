package com.tencent.mm.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.i;
import com.tencent.mm.model.cl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.v.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/engine/FunctionMsgTimer;", "", "callback", "Lcom/tencent/mm/engine/ITimerCallback;", "(Lcom/tencent/mm/engine/ITimerCallback;)V", "mCallback", "mQueue", "Lcom/tencent/mm/engine/FunctionMsgQueue;", "add", "", "op", "", "item", "Lcom/tencent/mm/api/FunctionMsgItem;", "executor", "Lcom/tencent/mm/executor/IOpExecutor;", "check", "handleTask", "task", "Lcom/tencent/mm/engine/FunctionMsgTask;", "Companion", "plugin-functionmsg_release"})
public final class e
{
  public static final e.a heY;
  final f heW;
  private final c heX;
  
  static
  {
    AppMethodBeat.i(114126);
    heY = new e.a((byte)0);
    AppMethodBeat.o(114126);
  }
  
  public e(f paramf)
  {
    AppMethodBeat.i(114125);
    this.heW = paramf;
    this.heX = new c(this);
    AppMethodBeat.o(114125);
  }
  
  public final void a(int paramInt, i parami, b paramb)
  {
    AppMethodBeat.i(114123);
    p.h(parami, "item");
    p.h(paramb, "executor");
    long l = System.currentTimeMillis();
    Log.i("FunctionMsg.FunctionMsgTimer", "[add] op:%s delay:%ss id:%s", new Object[] { Integer.valueOf(paramInt), Long.valueOf(parami.Vq() - cl.aWy() / 1000L), parami.Vk() });
    this.heX.a(new d(paramInt, parami, paramb));
    Log.i("FunctionMsg.FunctionMsgTimer", "[add] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(114123);
  }
  
  public final void awI()
  {
    AppMethodBeat.i(114124);
    long l = System.currentTimeMillis();
    this.heX.loop();
    Log.i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(114124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.u.e
 * JD-Core Version:    0.7.0.1
 */