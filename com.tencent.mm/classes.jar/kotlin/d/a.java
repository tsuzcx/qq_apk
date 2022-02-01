package kotlin.d;

import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"})
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
    p.h(paramm, "operation");
    return f.b.a.a(this, paramR, paramm);
  }
  
  public <E extends f.b> E get(f.c<E> paramc)
  {
    p.h(paramc, "key");
    return f.b.a.a(this, paramc);
  }
  
  public f.c<?> getKey()
  {
    return this.key;
  }
  
  public f minusKey(f.c<?> paramc)
  {
    p.h(paramc, "key");
    return f.b.a.b(this, paramc);
  }
  
  public f plus(f paramf)
  {
    p.h(paramf, "context");
    return f.b.a.a(this, paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.d.a
 * JD-Core Version:    0.7.0.1
 */