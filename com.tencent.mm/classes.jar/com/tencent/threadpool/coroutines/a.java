package com.tencent.threadpool.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/threadpool/coroutines/DefaultDispatcher;", "Lcom/tencent/threadpool/coroutines/ThreadPoolDispatcher;", "()V", "execute", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "threadpool-coroutines_release"}, k=1, mv={1, 1, 16})
final class a
  extends e
{
  public static final a ahAK;
  
  static
  {
    AppMethodBeat.i(226869);
    ahAK = new a();
    AppMethodBeat.o(226869);
  }
  
  private a()
  {
    super((byte)0);
  }
  
  protected final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(226871);
    s.t(paramRunnable, "block");
    h.ahAA.bm(paramRunnable);
    AppMethodBeat.o(226871);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.threadpool.coroutines.a
 * JD-Core Version:    0.7.0.1
 */