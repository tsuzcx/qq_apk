package kotlin.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.g.a.m;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"})
public final class c
  implements Serializable, f
{
  private final f aaAn;
  private final f.b aaAo;
  
  public c(f paramf, f.b paramb)
  {
    AppMethodBeat.i(129619);
    this.aaAn = paramf;
    this.aaAo = paramb;
    AppMethodBeat.o(129619);
  }
  
  private final boolean b(f.b paramb)
  {
    AppMethodBeat.i(129614);
    boolean bool = p.h(get(paramb.getKey()), paramb);
    AppMethodBeat.o(129614);
    return bool;
  }
  
  private final int size()
  {
    Object localObject = (c)this;
    int i = 2;
    for (;;)
    {
      f localf = ((c)localObject).aaAn;
      localObject = localf;
      if (!(localf instanceof c)) {
        localObject = null;
      }
      localObject = (c)localObject;
      if (localObject == null) {
        return i;
      }
      i += 1;
    }
  }
  
  private final Object writeReplace()
  {
    AppMethodBeat.i(129618);
    int i = size();
    Object localObject = new f[i];
    final aa.d locald = new aa.d();
    locald.aaBA = 0;
    fold(x.aazN, (m)new c((f[])localObject, locald));
    if (locald.aaBA == i) {}
    for (i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(129618);
      throw ((Throwable)localObject);
    }
    localObject = new a((f[])localObject);
    AppMethodBeat.o(129618);
    return localObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129615);
    c localc;
    if ((c)this != paramObject)
    {
      if ((!(paramObject instanceof c)) || (((c)paramObject).size() != size())) {
        break label118;
      }
      localc = (c)paramObject;
      paramObject = this;
      if (localc.b(paramObject.aaAo)) {
        break label65;
      }
    }
    for (boolean bool = false;; bool = localc.b((f.b)paramObject))
    {
      if (!bool) {
        break label118;
      }
      AppMethodBeat.o(129615);
      return true;
      label65:
      paramObject = paramObject.aaAn;
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        break;
      }
      if (paramObject == null)
      {
        paramObject = new t("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        AppMethodBeat.o(129615);
        throw paramObject;
      }
    }
    label118:
    AppMethodBeat.o(129615);
    return false;
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(129612);
    p.k(paramm, "operation");
    paramR = paramm.invoke(this.aaAn.fold(paramR, paramm), this.aaAo);
    AppMethodBeat.o(129612);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(129611);
    p.k(paramc, "key");
    for (Object localObject = (c)this;; localObject = (c)localObject)
    {
      f.b localb = ((c)localObject).aaAo.get(paramc);
      if (localb != null)
      {
        AppMethodBeat.o(129611);
        return localb;
      }
      localObject = ((c)localObject).aaAn;
      if (!(localObject instanceof c)) {
        break;
      }
    }
    paramc = ((f)localObject).get(paramc);
    AppMethodBeat.o(129611);
    return paramc;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(129616);
    int i = this.aaAn.hashCode();
    int j = this.aaAo.hashCode();
    AppMethodBeat.o(129616);
    return i + j;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(129613);
    p.k(paramc, "key");
    if (this.aaAo.get(paramc) != null)
    {
      paramc = this.aaAn;
      AppMethodBeat.o(129613);
      return paramc;
    }
    paramc = this.aaAn.minusKey(paramc);
    if (paramc == this.aaAn)
    {
      paramc = (f)this;
      AppMethodBeat.o(129613);
      return paramc;
    }
    if (paramc == g.aaAw)
    {
      paramc = (f)this.aaAo;
      AppMethodBeat.o(129613);
      return paramc;
    }
    paramc = (f)new c(paramc, this.aaAo);
    AppMethodBeat.o(129613);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(129620);
    p.k(paramf, "context");
    paramf = f.a.a(this, paramf);
    AppMethodBeat.o(129620);
    return paramf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129617);
    String str = "[" + (String)fold("", (m)c.b.aaAr) + "]";
    AppMethodBeat.o(129617);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"})
  static final class a
    implements Serializable
  {
    public static final c.a.a aaAq;
    private final f[] aaAp;
    
    static
    {
      AppMethodBeat.i(129633);
      aaAq = new c.a.a((byte)0);
      AppMethodBeat.o(129633);
    }
    
    public a(f[] paramArrayOff)
    {
      AppMethodBeat.i(129632);
      this.aaAp = paramArrayOff;
      AppMethodBeat.o(129632);
    }
    
    private final Object readResolve()
    {
      AppMethodBeat.i(129631);
      f[] arrayOff = this.aaAp;
      Object localObject = g.aaAw;
      int j = arrayOff.length;
      int i = 0;
      while (i < j)
      {
        f localf = arrayOff[i];
        localObject = ((f)localObject).plus(localf);
        i += 1;
      }
      AppMethodBeat.o(129631);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"})
  static final class c
    extends q
    implements m<x, f.b, x>
  {
    c(f[] paramArrayOff, aa.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.d.c
 * JD-Core Version:    0.7.0.1
 */