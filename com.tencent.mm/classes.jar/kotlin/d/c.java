package kotlin.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class c
  implements Serializable, f
{
  private final f aivZ;
  private final f.b aiwa;
  
  public c(f paramf, f.b paramb)
  {
    AppMethodBeat.i(129619);
    this.aivZ = paramf;
    this.aiwa = paramb;
    AppMethodBeat.o(129619);
  }
  
  private final boolean b(f.b paramb)
  {
    AppMethodBeat.i(129614);
    boolean bool = s.p(get(paramb.getKey()), paramb);
    AppMethodBeat.o(129614);
    return bool;
  }
  
  private final int size()
  {
    Object localObject = (c)this;
    int i = 2;
    for (;;)
    {
      f localf = ((c)localObject).aivZ;
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
      if (localc.b(paramObject.aiwa)) {
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
      paramObject = paramObject.aivZ;
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        break;
      }
      if (paramObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
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
    s.u(paramm, "operation");
    paramR = paramm.invoke(this.aivZ.fold(paramR, paramm), this.aiwa);
    AppMethodBeat.o(129612);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(129611);
    s.u(paramc, "key");
    for (Object localObject = (c)this;; localObject = (c)localObject)
    {
      f.b localb = ((c)localObject).aiwa.get(paramc);
      if (localb != null)
      {
        AppMethodBeat.o(129611);
        return localb;
      }
      localObject = ((c)localObject).aivZ;
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
    int i = this.aivZ.hashCode();
    int j = this.aiwa.hashCode();
    AppMethodBeat.o(129616);
    return i + j;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(129613);
    s.u(paramc, "key");
    if (this.aiwa.get(paramc) != null)
    {
      paramc = this.aivZ;
      AppMethodBeat.o(129613);
      return paramc;
    }
    paramc = this.aivZ.minusKey(paramc);
    if (paramc == this.aivZ)
    {
      paramc = (f)this;
      AppMethodBeat.o(129613);
      return paramc;
    }
    if (paramc == g.aiwf)
    {
      paramc = (f)this.aiwa;
      AppMethodBeat.o(129613);
      return paramc;
    }
    paramc = (f)new c(paramc, this.aiwa);
    AppMethodBeat.o(129613);
    return paramc;
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(129620);
    s.u(paramf, "context");
    paramf = f.a.a(this, paramf);
    AppMethodBeat.o(129620);
    return paramf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129617);
    String str = "[" + (String)fold("", (m)a.aiwb) + "]";
    AppMethodBeat.o(129617);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends u
    implements m<String, f.b, String>
  {
    public static final a aiwb;
    
    static
    {
      AppMethodBeat.i(129624);
      aiwb = new a();
      AppMethodBeat.o(129624);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.c
 * JD-Core Version:    0.7.0.1
 */