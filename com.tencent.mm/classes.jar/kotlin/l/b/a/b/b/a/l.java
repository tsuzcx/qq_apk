package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.s;

public final class l
  implements g
{
  private final g aiIs;
  private final boolean aiIt;
  private final b<kotlin.l.b.a.b.f.c, Boolean> aiIu;
  
  private l(g paramg, b<? super kotlin.l.b.a.b.f.c, Boolean> paramb)
  {
    AppMethodBeat.i(56975);
    this.aiIs = paramg;
    this.aiIt = false;
    this.aiIu = paramb;
    AppMethodBeat.o(56975);
  }
  
  public l(g paramg, b<? super kotlin.l.b.a.b.f.c, Boolean> paramb, byte paramByte)
  {
    this(paramg, paramb);
    AppMethodBeat.i(191861);
    AppMethodBeat.o(191861);
  }
  
  private final boolean c(c paramc)
  {
    AppMethodBeat.i(56974);
    paramc = paramc.koY();
    if ((paramc != null) && (((Boolean)this.aiIu.invoke(paramc)).booleanValue()))
    {
      AppMethodBeat.o(56974);
      return true;
    }
    AppMethodBeat.o(56974);
    return false;
  }
  
  public final c h(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56971);
    s.u(paramc, "fqName");
    if (((Boolean)this.aiIu.invoke(paramc)).booleanValue())
    {
      paramc = this.aiIs.h(paramc);
      AppMethodBeat.o(56971);
      return paramc;
    }
    AppMethodBeat.o(56971);
    return null;
  }
  
  public final boolean i(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56970);
    s.u(paramc, "fqName");
    if (((Boolean)this.aiIu.invoke(paramc)).booleanValue())
    {
      boolean bool = this.aiIs.i(paramc);
      AppMethodBeat.o(56970);
      return bool;
    }
    AppMethodBeat.o(56970);
    return false;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(56973);
    Object localObject = (Iterable)this.aiIs;
    boolean bool;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (c((c)((Iterator)localObject).next())) {
          bool = true;
        }
      }
    }
    while (this.aiIt) {
      if (!bool)
      {
        AppMethodBeat.o(56973);
        return true;
        bool = false;
      }
      else
      {
        AppMethodBeat.o(56973);
        return false;
      }
    }
    AppMethodBeat.o(56973);
    return bool;
  }
  
  public final Iterator<c> iterator()
  {
    AppMethodBeat.i(56972);
    Object localObject2 = (Iterable)this.aiIs;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (c((c)localObject3)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    AppMethodBeat.o(56972);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.a.l
 * JD-Core Version:    0.7.0.1
 */