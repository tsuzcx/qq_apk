package kotlin.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.f;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class c
  implements d<Object>
{
  public static final c aiwr;
  
  static
  {
    AppMethodBeat.i(129607);
    aiwr = new c();
    AppMethodBeat.o(129607);
  }
  
  public final f getContext()
  {
    AppMethodBeat.i(129605);
    Throwable localThrowable = (Throwable)new IllegalStateException("This continuation is already complete".toString());
    AppMethodBeat.o(129605);
    throw localThrowable;
  }
  
  public final void resumeWith(Object paramObject)
  {
    AppMethodBeat.i(129606);
    paramObject = (Throwable)new IllegalStateException("This continuation is already complete".toString());
    AppMethodBeat.o(129606);
    throw paramObject;
  }
  
  public final String toString()
  {
    return "This continuation is already complete";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.b.a.c
 * JD-Core Version:    0.7.0.1
 */