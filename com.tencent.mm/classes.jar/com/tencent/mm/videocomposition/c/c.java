package com.tencent.mm.videocomposition.c;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"currentTicks", "", "stackTraceToString", "", "throwable", "", "ticksToNow", "before", "uiThread", "", "block", "Lkotlin/Function0;", "wxRemoveIf", "", "T", "Ljava/util/LinkedList;", "func", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "video_composition_release"})
public final class c
{
  public static final void h(a<x> parama)
  {
    AppMethodBeat.i(216871);
    p.h(parama, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    p.g(localLooper, "Looper.getMainLooper()");
    if (p.j(localThread, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(216871);
      return;
    }
    new Handler(Looper.getMainLooper()).post((Runnable)new d(parama));
    AppMethodBeat.o(216871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.videocomposition.c.c
 * JD-Core Version:    0.7.0.1
 */