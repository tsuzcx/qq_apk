package d.d;

import d.g.a.m;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)V", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.a
 * JD-Core Version:    0.7.0.1
 */