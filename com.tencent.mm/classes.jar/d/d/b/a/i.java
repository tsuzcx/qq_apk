package d.d.b.a;

import d.d.d;
import d.d.f;
import d.d.g;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"})
public abstract class i
  extends a
{
  public i(d<Object> paramd)
  {
    super(paramd);
    if (paramd != null)
    {
      if (paramd.gkg() == g.Nib) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString()));
      }
    }
  }
  
  public final f gkg()
  {
    return (f)g.Nib;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.i
 * JD-Core Version:    0.7.0.1
 */