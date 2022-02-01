package kotlin.d;

import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/coroutines/AbstractCoroutineContextKey;", "B", "Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "safeCast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "topmostKey", "isSubKey", "", "key", "isSubKey$kotlin_stdlib", "tryCast", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "kotlin-stdlib"})
public abstract class b<B extends f.b, E extends B>
  implements f.c<E>
{
  private final f.c<?> aaAl;
  private final kotlin.g.a.b<f.b, E> aaAm;
  
  public b(f.c<B> paramc, kotlin.g.a.b<? super f.b, ? extends E> paramb)
  {
    this.aaAm = paramb;
    paramb = paramc;
    if ((paramc instanceof b)) {
      paramb = ((b)paramc).aaAl;
    }
    this.aaAl = paramb;
  }
  
  public final E a(f.b paramb)
  {
    p.k(paramb, "element");
    return (f.b)this.aaAm.invoke(paramb);
  }
  
  public final boolean a(f.c<?> paramc)
  {
    p.k(paramc, "key");
    return (paramc == (b)this) || (this.aaAl == paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.d.b
 * JD-Core Version:    0.7.0.1
 */