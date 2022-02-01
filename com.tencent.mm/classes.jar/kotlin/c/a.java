package kotlin.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class a
{
  public static Thread as(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(217244);
    p.k(parama, "block");
    parama = new a(parama);
    parama.start();
    parama = (Thread)parama;
    AppMethodBeat.o(217244);
    return parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"})
  public static final class a
    extends Thread
  {
    a(kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(168704);
      this.$block.invoke();
      AppMethodBeat.o(168704);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.c.a
 * JD-Core Version:    0.7.0.1
 */