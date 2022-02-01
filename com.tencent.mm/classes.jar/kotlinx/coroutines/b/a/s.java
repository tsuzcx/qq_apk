package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/NoOpContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class s
  implements d<Object>
{
  private static final f aMa;
  public static final s ajzL;
  
  static
  {
    AppMethodBeat.i(189230);
    ajzL = new s();
    aMa = (f)g.aiwf;
    AppMethodBeat.o(189230);
  }
  
  public final f getContext()
  {
    return aMa;
  }
  
  public final void resumeWith(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.coroutines.b.a.s
 * JD-Core Version:    0.7.0.1
 */