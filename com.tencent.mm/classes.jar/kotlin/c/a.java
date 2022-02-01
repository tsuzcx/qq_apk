package kotlin.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class a
{
  public static Thread cn(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(190815);
    s.u(parama, "block");
    parama = new a(parama);
    parama.start();
    parama = (Thread)parama;
    AppMethodBeat.o(190815);
    return parama;
  }
  
  @Metadata(d1={""}, d2={"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
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