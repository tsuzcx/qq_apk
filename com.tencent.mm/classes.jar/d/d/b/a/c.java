package d.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.d;
import d.d.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public final class c
  implements d<Object>
{
  public static final c Nio;
  
  static
  {
    AppMethodBeat.i(129607);
    Nio = new c();
    AppMethodBeat.o(129607);
  }
  
  public final void eQ(Object paramObject)
  {
    AppMethodBeat.i(129606);
    paramObject = (Throwable)new IllegalStateException("This continuation is already complete".toString());
    AppMethodBeat.o(129606);
    throw paramObject;
  }
  
  public final f gkg()
  {
    AppMethodBeat.i(129605);
    Throwable localThrowable = (Throwable)new IllegalStateException("This continuation is already complete".toString());
    AppMethodBeat.o(129605);
    throw localThrowable;
  }
  
  public final String toString()
  {
    return "This continuation is already complete";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.d.b.a.c
 * JD-Core Version:    0.7.0.1
 */