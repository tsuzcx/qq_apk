package d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.k;
import d.g.b.v.c;
import d.v;
import d.y;
import java.io.Serializable;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"})
public final class c
  implements f, Serializable
{
  private final f Jgw;
  private final f.b Jgx;
  
  public c(f paramf, f.b paramb)
  {
    AppMethodBeat.i(129619);
    this.Jgw = paramf;
    this.Jgx = paramb;
    AppMethodBeat.o(129619);
  }
  
  private final boolean b(f.b paramb)
  {
    AppMethodBeat.i(129614);
    boolean bool = k.g(get(paramb.getKey()), paramb);
    AppMethodBeat.o(129614);
    return bool;
  }
  
  private final int size()
  {
    Object localObject = (c)this;
    int i = 2;
    for (;;)
    {
      f localf = ((c)localObject).Jgw;
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
    final v.c localc = new v.c();
    localc.Jhu = 0;
    fold(y.JfV, (m)new c((f[])localObject, localc));
    if (localc.Jhu == i) {}
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
      if (localc.b(paramObject.Jgx)) {
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
      paramObject = paramObject.Jgw;
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        break;
      }
      if (paramObject == null)
      {
        paramObject = new v("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
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
    k.h(paramm, "operation");
    paramR = paramm.n(this.Jgw.fold(paramR, paramm), this.Jgx);
    AppMethodBeat.o(129612);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(129611);
    k.h(paramc, "key");
    for (Object localObject = (c)this;; localObject = (c)localObject)
    {
      f.b localb = ((c)localObject).Jgx.get(paramc);
      if (localb != null)
      {
        AppMethodBeat.o(129611);
        return localb;
      }
      localObject = ((c)localObject).Jgw;
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
    int i = this.Jgw.hashCode();
    int j = this.Jgx.hashCode();
    AppMethodBeat.o(129616);
    return i + j;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(129613);
    k.h(paramc, "key");
    if (this.Jgx.get(paramc) != null)
    {
      paramc = this.Jgw;
      AppMethodBeat.o(129613);
      return paramc;
    }
    paramc = this.Jgw.minusKey(paramc);
    if (paramc == this.Jgw)
    {
      paramc = (f)this;
      AppMethodBeat.o(129613);
      return paramc;
    }
    if (paramc == g.JgF)
    {
      paramc = (f)this.Jgx;
      AppMethodBeat.o(129613);
      return paramc;
    }
    paramc = (f)new c(paramc, this.Jgx);
    AppMethodBeat.o(129613);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(129620);
    k.h(paramf, "context");
    paramf = f.a.a(this, paramf);
    AppMethodBeat.o(129620);
    return paramf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129617);
    String str = "[" + (String)fold("", (m)c.b.JgA) + "]";
    AppMethodBeat.o(129617);
    return str;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"})
  static final class a
    implements Serializable
  {
    public static final a Jgz;
    private final f[] Jgy;
    
    static
    {
      AppMethodBeat.i(129633);
      Jgz = new a((byte)0);
      AppMethodBeat.o(129633);
    }
    
    public a(f[] paramArrayOff)
    {
      AppMethodBeat.i(129632);
      this.Jgy = paramArrayOff;
      AppMethodBeat.o(129632);
    }
    
    private final Object readResolve()
    {
      AppMethodBeat.i(129631);
      f[] arrayOff = this.Jgy;
      Object localObject = g.JgF;
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
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
    public static final class a {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"})
  static final class c
    extends d.g.b.l
    implements m<y, f.b, y>
  {
    c(f[] paramArrayOff, v.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.d.c
 * JD-Core Version:    0.7.0.1
 */