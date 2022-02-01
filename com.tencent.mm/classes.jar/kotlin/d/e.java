package kotlin.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/coroutines/ContinuationInterceptor;", "Lkotlin/coroutines/CoroutineContext$Element;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "interceptContinuation", "Lkotlin/coroutines/Continuation;", "T", "continuation", "minusKey", "Lkotlin/coroutines/CoroutineContext;", "releaseInterceptedContinuation", "", "Key", "kotlin-stdlib"})
public abstract interface e
  extends f.b
{
  public static final a SXH = a.SXI;
  
  public abstract <T> d<T> c(d<? super T> paramd);
  
  public abstract void d(d<?> paramd);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/coroutines/ContinuationInterceptor$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/ContinuationInterceptor;", "()V", "kotlin-stdlib"})
  public static final class a
    implements f.c<e>
  {
    static
    {
      AppMethodBeat.i(129591);
      SXI = new a();
      AppMethodBeat.o(129591);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.d.e
 * JD-Core Version:    0.7.0.1
 */