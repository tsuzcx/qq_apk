package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/internal/ContextScope;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "toString", "", "kotlinx-coroutines-core"})
public final class e
  implements ak
{
  private final f abyU;
  
  public e(f paramf)
  {
    this.abyU = paramf;
  }
  
  public final f getCoroutineContext()
  {
    return this.abyU;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204981);
    String str = "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    AppMethodBeat.o(204981);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.internal.e
 * JD-Core Version:    0.7.0.1
 */