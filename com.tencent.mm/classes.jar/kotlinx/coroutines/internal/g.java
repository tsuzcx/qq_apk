package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.f;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/ContextScope;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements aq
{
  private final f bGV;
  
  public g(f paramf)
  {
    this.bGV = paramf;
  }
  
  public final f getCoroutineContext()
  {
    return this.bGV;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189405);
    String str = "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    AppMethodBeat.o(189405);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.g
 * JD-Core Version:    0.7.0.1
 */