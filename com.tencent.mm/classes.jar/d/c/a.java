package d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", "T", "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"})
public final class a
{
  public static Thread P(d.g.a.a<z> parama)
  {
    AppMethodBeat.i(199606);
    p.h(parama, "block");
    parama = new a(parama);
    parama.start();
    parama = (Thread)parama;
    AppMethodBeat.o(199606);
    return parama;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"})
  public static final class a
    extends Thread
  {
    a(d.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(168704);
      this.gFS.invoke();
      AppMethodBeat.o(168704);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.c.a
 * JD-Core Version:    0.7.0.1
 */