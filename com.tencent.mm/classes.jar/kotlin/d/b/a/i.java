package kotlin.d.b.a;

import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"})
public abstract class i
  extends a
{
  public i(d<Object> paramd)
  {
    super(paramd);
    if (paramd != null)
    {
      if (paramd.getContext() == g.SXK) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString()));
      }
    }
  }
  
  public f getContext()
  {
    return (f)g.SXK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.d.b.a.i
 * JD-Core Version:    0.7.0.1
 */