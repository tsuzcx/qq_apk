package kotlin.d;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/AbstractCoroutineContextKey;", "B", "Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "safeCast", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "topmostKey", "isSubKey", "", "key", "isSubKey$kotlin_stdlib", "tryCast", "tryCast$kotlin_stdlib", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract class b<B extends f.b, E extends B>
  implements f.c<E>
{
  private final f.c<?> aivX;
  private final kotlin.g.a.b<f.b, E> aivY;
  
  public b(f.c<B> paramc, kotlin.g.a.b<? super f.b, ? extends E> paramb)
  {
    this.aivY = paramb;
    paramb = paramc;
    if ((paramc instanceof b)) {
      paramb = ((b)paramc).aivX;
    }
    this.aivX = paramb;
  }
  
  public final E a(f.b paramb)
  {
    s.u(paramb, "element");
    return (f.b)this.aivY.invoke(paramb);
  }
  
  public final boolean a(f.c<?> paramc)
  {
    s.u(paramc, "key");
    return (paramc == (b)this) || (this.aivX == paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.d.b
 * JD-Core Version:    0.7.0.1
 */