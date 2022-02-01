package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ai;
import kotlin.l.b.a.b.b.aj;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;

public final class i
  implements kotlin.l.b.a.b.b.ak
{
  private final List<ai> providers;
  private final String roK;
  
  public i(List<? extends ai> paramList, String paramString)
  {
    AppMethodBeat.i(191900);
    this.providers = paramList;
    this.roK = paramString;
    if (this.providers.size() == p.r((Iterable)this.providers).size()) {}
    for (int i = 1; (kotlin.ak.aiuY) && (i == 0); i = 0)
    {
      paramList = (Throwable)new AssertionError("providers.size is " + this.providers.size() + " while only " + p.r((Iterable)this.providers).size() + " unique providers");
      AppMethodBeat.o(191900);
      throw paramList;
    }
    AppMethodBeat.o(191900);
  }
  
  public final Collection<c> a(c paramc, b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57059);
    s.u(paramc, "fqName");
    s.u(paramb, "nameFilter");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.providers.iterator();
    while (localIterator.hasNext()) {
      localHashSet.addAll(((ai)localIterator.next()).a(paramc, paramb));
    }
    paramc = (Collection)localHashSet;
    AppMethodBeat.o(57059);
    return paramc;
  }
  
  public final void a(c paramc, Collection<ah> paramCollection)
  {
    AppMethodBeat.i(191905);
    s.u(paramc, "fqName");
    s.u(paramCollection, "packageFragments");
    Iterator localIterator = this.providers.iterator();
    while (localIterator.hasNext()) {
      aj.a((ai)localIterator.next(), paramc, paramCollection);
    }
    AppMethodBeat.o(191905);
  }
  
  public final List<ah> f(c paramc)
  {
    AppMethodBeat.i(57058);
    s.u(paramc, "fqName");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.providers.iterator();
    while (localIterator.hasNext()) {
      aj.a((ai)localIterator.next(), paramc, (Collection)localArrayList);
    }
    paramc = p.p((Iterable)localArrayList);
    AppMethodBeat.o(57058);
    return paramc;
  }
  
  public final boolean g(c paramc)
  {
    AppMethodBeat.i(191907);
    s.u(paramc, "fqName");
    Object localObject = (Iterable)this.providers;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!aj.b((ai)((Iterator)localObject).next(), paramc))
        {
          AppMethodBeat.o(191907);
          return false;
        }
      }
    }
    AppMethodBeat.o(191907);
    return true;
  }
  
  public final String toString()
  {
    return this.roK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.c.i
 * JD-Core Version:    0.7.0.1
 */