package com.tencent.mm.sdk.thread;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"uiThread", "", "block", "Lkotlin/Function0;", "wechat-sdk_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ThreadKt
{
  public static final void uiThread(a<ah> parama)
  {
    AppMethodBeat.i(243143);
    s.u(parama, "block");
    if (s.p(Thread.currentThread(), Looper.getMainLooper().getThread()))
    {
      parama.invoke();
      AppMethodBeat.o(243143);
      return;
    }
    h.ahAA.bk(new ThreadKt..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(243143);
  }
  
  private static final void uiThread$lambda-0(a parama)
  {
    AppMethodBeat.i(243147);
    s.u(parama, "$block");
    parama.invoke();
    AppMethodBeat.o(243147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.thread.ThreadKt
 * JD-Core Version:    0.7.0.1
 */