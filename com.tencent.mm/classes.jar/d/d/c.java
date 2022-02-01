package d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.l;
import d.v;
import d.z;
import java.io.Serializable;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"})
public final class c
  implements f, Serializable
{
  private final f NhS;
  private final f.b NhT;
  
  public c(f paramf, f.b paramb)
  {
    AppMethodBeat.i(129619);
    this.NhS = paramf;
    this.NhT = paramb;
    AppMethodBeat.o(129619);
  }
  
  private final boolean b(f.b paramb)
  {
    AppMethodBeat.i(129614);
    boolean bool = p.i(get(paramb.getKey()), paramb);
    AppMethodBeat.o(129614);
    return bool;
  }
  
  private final int size()
  {
    Object localObject = (c)this;
    int i = 2;
    for (;;)
    {
      f localf = ((c)localObject).NhS;
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
    final y.d locald = new y.d();
    locald.NiW = 0;
    fold(z.Nhr, (m)new c((f[])localObject, locald));
    if (locald.NiW == i) {}
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
      if (localc.b(paramObject.NhT)) {
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
      paramObject = paramObject.NhS;
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
    p.h(paramm, "operation");
    paramR = paramm.p(this.NhS.fold(paramR, paramm), this.NhT);
    AppMethodBeat.o(129612);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(129611);
    p.h(paramc, "key");
    for (Object localObject = (c)this;; localObject = (c)localObject)
    {
      f.b localb = ((c)localObject).NhT.get(paramc);
      if (localb != null)
      {
        AppMethodBeat.o(129611);
        return localb;
      }
      localObject = ((c)localObject).NhS;
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
    int i = this.NhS.hashCode();
    int j = this.NhT.hashCode();
    AppMethodBeat.o(129616);
    return i + j;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(129613);
    p.h(paramc, "key");
    if (this.NhT.get(paramc) != null)
    {
      paramc = this.NhS;
      AppMethodBeat.o(129613);
      return paramc;
    }
    paramc = this.NhS.minusKey(paramc);
    if (paramc == this.NhS)
    {
      paramc = (f)this;
      AppMethodBeat.o(129613);
      return paramc;
    }
    if (paramc == g.Nib)
    {
      paramc = (f)this.NhT;
      AppMethodBeat.o(129613);
      return paramc;
    }
    paramc = (f)new c(paramc, this.NhT);
    AppMethodBeat.o(129613);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(129620);
    p.h(paramf, "context");
    paramf = f.a.a(this, paramf);
    AppMethodBeat.o(129620);
    return paramf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129617);
    String str = "[" + (String)fold("", (m)c.b.NhW) + "]";
    AppMethodBeat.o(129617);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"})
  static final class a
    implements Serializable
  {
    public static final a NhV;
    private final f[] NhU;
    
    static
    {
      AppMethodBeat.i(129633);
      NhV = new a((byte)0);
      AppMethodBeat.o(129633);
    }
    
    public a(f[] paramArrayOff)
    {
      AppMethodBeat.i(129632);
      this.NhU = paramArrayOff;
      AppMethodBeat.o(129632);
    }
    
    private final Object readResolve()
    {
      AppMethodBeat.i(129631);
      f[] arrayOff = this.NhU;
      Object localObject = g.Nib;
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
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"})
  static final class c
    extends q
    implements m<z, f.b, z>
  {
    c(f[] paramArrayOff, y.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.c
 * JD-Core Version:    0.7.0.1
 */