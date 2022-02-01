package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.ai;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/internal/ContextScope;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "toString", "", "kotlinx-coroutines-core"})
public final class e
  implements ai
{
  private final f TVD;
  
  public e(f paramf)
  {
    this.TVD = paramf;
  }
  
  public final f hMk()
  {
    return this.TVD;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192445);
    String str = "CoroutineScope(coroutineContext=" + this.TVD + ')';
    AppMethodBeat.o(192445);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.internal.e
 * JD-Core Version:    0.7.0.1
 */