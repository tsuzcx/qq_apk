package d.d;

import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/AbstractCoroutineContextKey;", "B", "Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "safeCast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "topmostKey", "isSubKey", "", "key", "isSubKey$kotlin_stdlib", "tryCast", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "kotlin-stdlib"})
public abstract class b<B extends f.b, E extends B>
  implements f.c<E>
{
  private final f.c<?> NhQ;
  private final d.g.a.b<f.b, E> NhR;
  
  public b(f.c<B> paramc, d.g.a.b<? super f.b, ? extends E> paramb)
  {
    this.NhR = paramb;
    paramb = paramc;
    if ((paramc instanceof b)) {
      paramb = ((b)paramc).NhQ;
    }
    this.NhQ = paramb;
  }
  
  public final E a(f.b paramb)
  {
    p.h(paramb, "element");
    return (f.b)this.NhR.invoke(paramb);
  }
  
  public final boolean a(f.c<?> paramc)
  {
    p.h(paramc, "key");
    return (paramc == (b)this) || (this.NhQ == paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.b
 * JD-Core Version:    0.7.0.1
 */