package kotlin.d.b.a;

import kotlin.Metadata;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class i
  extends a
{
  public i(d<Object> paramd)
  {
    super(paramd);
    if (paramd != null)
    {
      if (paramd.getContext() == g.aiwf) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString()));
      }
    }
  }
  
  public f getContext()
  {
    return (f)g.aiwf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.b.a.i
 * JD-Core Version:    0.7.0.1
 */