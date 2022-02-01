package com.tencent.threadpool.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/threadpool/stub/ThreadPoolImpl;", "", "()V", "implementation", "Lcom/tencent/threadpool/stub/IThreadPoolStub;", "implementation$annotations", "getImplementation", "()Lcom/tencent/threadpool/stub/IThreadPoolStub;", "setImplementation", "(Lcom/tencent/threadpool/stub/IThreadPoolStub;)V", "threadpool-stub_release"}, k=1, mv={1, 1, 16})
public final class b
{
  private static volatile a ahCN;
  public static final b ahCO;
  
  static
  {
    AppMethodBeat.i(226861);
    ahCO = new b();
    ahCN = (a)d.ahCS;
    AppMethodBeat.o(226861);
  }
  
  public static final void a(a parama)
  {
    AppMethodBeat.i(226855);
    s.t(parama, "<set-?>");
    ahCN = parama;
    AppMethodBeat.o(226855);
  }
  
  public static final a jZF()
  {
    return ahCN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.k.b
 * JD-Core Version:    0.7.0.1
 */