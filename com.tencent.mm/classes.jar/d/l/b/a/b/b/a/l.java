package d.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class l
  implements g
{
  private final g JrM;
  private final d.g.a.b<d.l.b.a.b.f.b, Boolean> JrN;
  
  public l(g paramg, d.g.a.b<? super d.l.b.a.b.f.b, Boolean> paramb)
  {
    AppMethodBeat.i(56975);
    this.JrM = paramg;
    this.JrN = paramb;
    AppMethodBeat.o(56975);
  }
  
  private final boolean c(c paramc)
  {
    AppMethodBeat.i(56974);
    paramc = paramc.fzd();
    if ((paramc != null) && (((Boolean)this.JrN.aA(paramc)).booleanValue()))
    {
      AppMethodBeat.o(56974);
      return true;
    }
    AppMethodBeat.o(56974);
    return false;
  }
  
  public final c g(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56971);
    k.h(paramb, "fqName");
    if (((Boolean)this.JrN.aA(paramb)).booleanValue())
    {
      paramb = this.JrM.g(paramb);
      AppMethodBeat.o(56971);
      return paramb;
    }
    AppMethodBeat.o(56971);
    return null;
  }
  
  public final boolean h(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56970);
    k.h(paramb, "fqName");
    if (((Boolean)this.JrN.aA(paramb)).booleanValue())
    {
      boolean bool = this.JrM.h(paramb);
      AppMethodBeat.o(56970);
      return bool;
    }
    AppMethodBeat.o(56970);
    return false;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(56973);
    Object localObject = (Iterable)this.JrM;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        if (((l)this).c(localc))
        {
          AppMethodBeat.o(56973);
          return true;
        }
      }
    }
    AppMethodBeat.o(56973);
    return false;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(56972);
    Object localObject2 = (Iterable)this.JrM;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      c localc = (c)localObject3;
      if (((l)this).c(localc)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    AppMethodBeat.o(56972);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.b.a.l
 * JD-Core Version:    0.7.0.1
 */