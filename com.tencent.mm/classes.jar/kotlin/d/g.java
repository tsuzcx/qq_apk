package kotlin.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/EmptyCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "plus", "context", "readResolve", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class g
  implements Serializable, f
{
  public static final g aiwf;
  
  static
  {
    AppMethodBeat.i(129603);
    aiwf = new g();
    AppMethodBeat.o(129603);
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(129600);
    s.u(paramm, "operation");
    AppMethodBeat.o(129600);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(129599);
    s.u(paramc, "key");
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
    s.u(paramc, "key");
    paramc = (f)this;
    AppMethodBeat.o(129602);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(129601);
    s.u(paramf, "context");
    AppMethodBeat.o(129601);
    return paramf;
  }
  
  public final String toString()
  {
    return "EmptyCoroutineContext";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.g
 * JD-Core Version:    0.7.0.1
 */