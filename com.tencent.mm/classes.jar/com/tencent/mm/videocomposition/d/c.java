package com.tencent.mm.videocomposition.d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"currentTicks", "", "stackTraceToString", "", "throwable", "", "ticksToNow", "before", "uiThread", "", "block", "Lkotlin/Function0;", "wxRemoveIf", "", "T", "Ljava/util/LinkedList;", "func", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "video_composition_release"}, k=2, mv={1, 1, 15})
public final class c
{
  public static final void uiThread(a<ah> parama)
  {
    AppMethodBeat.i(233681);
    s.t(parama, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    s.r(localLooper, "Looper.getMainLooper()");
    if (s.p(localThread, localLooper.getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(233681);
      return;
    }
    new Handler(Looper.getMainLooper()).post((Runnable)new d(parama));
    AppMethodBeat.o(233681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.videocomposition.d.c
 * JD-Core Version:    0.7.0.1
 */