package kotlin.d;

import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class a
  implements f.b
{
  private final f.c<?> key;
  
  public a(f.c<?> paramc)
  {
    this.key = paramc;
  }
  
  public <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    s.u(paramm, "operation");
    return f.b.a.a(this, paramR, paramm);
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    s.u(paramc, "key");
    return f.b.a.a(this, paramc);
  }
  
  public f.c<?> getKey()
  {
    return this.key;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    s.u(paramc, "key");
    return f.b.a.b(this, paramc);
  }
  
  public f plus(f paramf)
  {
    s.u(paramf, "context");
    return f.b.a.a(this, paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.a
 * JD-Core Version:    0.7.0.1
 */