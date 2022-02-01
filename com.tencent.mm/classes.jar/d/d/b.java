package d.d;

import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/AbstractCoroutineContextKey;", "B", "Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "safeCast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "topmostKey", "isSubKey", "", "key", "isSubKey$kotlin_stdlib", "tryCast", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "kotlin-stdlib"})
public abstract class b<B extends f.b, E extends B>
  implements f.c<E>
{
  private final f.c<?> Jgu;
  private final d.g.a.b<f.b, E> Jgv;
  
  public b(f.c<B> paramc, d.g.a.b<? super f.b, ? extends E> paramb)
  {
    this.Jgv = paramb;
    paramb = paramc;
    if ((paramc instanceof b)) {
      paramb = ((b)paramc).Jgu;
    }
    this.Jgu = paramb;
  }
  
  public final E a(f.b paramb)
  {
    k.h(paramb, "element");
    return (f.b)this.Jgv.aA(paramb);
  }
  
  public final boolean a(f.c<?> paramc)
  {
    k.h(paramc, "key");
    return (paramc == (b)this) || (this.Jgu == paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.d.b
 * JD-Core Version:    0.7.0.1
 */