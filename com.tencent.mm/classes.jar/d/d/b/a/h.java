package d.d.b.a;

import d.d.d;
import d.d.f;
import d.d.g;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "completion", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"})
public abstract class h
  extends a
{
  public h(d<Object> paramd)
  {
    super(paramd);
    if (paramd != null)
    {
      if (paramd.fOf() == g.KTZ) {}
      for (int i = 1; i == 0; i = 0) {
        throw ((Throwable)new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString()));
      }
    }
  }
  
  public final f fOf()
  {
    return (f)g.KTZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b.a.h
 * JD-Core Version:    0.7.0.1
 */