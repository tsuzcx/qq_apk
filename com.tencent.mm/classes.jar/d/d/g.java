package d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;
import d.l;
import java.io.Serializable;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/EmptyCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "plus", "context", "readResolve", "", "toString", "", "kotlin-stdlib"})
public final class g
  implements f, Serializable
{
  public static final g JgF;
  
  static
  {
    AppMethodBeat.i(129603);
    JgF = new g();
    AppMethodBeat.o(129603);
  }
  
  private final Object readResolve()
  {
    return JgF;
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(129600);
    k.h(paramm, "operation");
    AppMethodBeat.o(129600);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(129599);
    k.h(paramc, "key");
    AppMethodBeat.o(129599);
    return null;
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(129602);
    k.h(paramc, "key");
    paramc = (f)this;
    AppMethodBeat.o(129602);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(129601);
    k.h(paramf, "context");
    AppMethodBeat.o(129601);
    return paramf;
  }
  
  public final String toString()
  {
    return "EmptyCoroutineContext";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.d.g
 * JD-Core Version:    0.7.0.1
 */