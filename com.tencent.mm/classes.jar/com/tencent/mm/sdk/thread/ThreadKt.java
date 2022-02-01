package com.tencent.mm.sdk.thread;

import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"uiThread", "", "block", "Lkotlin/Function0;", "wechat-sdk_release"})
public final class ThreadKt
{
  public static final void uiThread(a<x> parama)
  {
    AppMethodBeat.i(189234);
    p.k(parama, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.j(localLooper, "Looper.getMainLooper()");
    if (p.h(localThread, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(189234);
      return;
    }
    h.ZvG.bc((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187806);
        this.$block.invoke();
        AppMethodBeat.o(187806);
      }
    });
    AppMethodBeat.o(189234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.thread.ThreadKt
 * JD-Core Version:    0.7.0.1
 */