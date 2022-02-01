package kotlin.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public final class b
  implements h
{
  public static final a ablP;
  private final String ablN;
  private final List<h> ablO;
  
  static
  {
    AppMethodBeat.i(60193);
    ablP = new a((byte)0);
    AppMethodBeat.o(60193);
  }
  
  public b(String paramString, List<? extends h> paramList)
  {
    AppMethodBeat.i(60192);
    this.ablN = paramString;
    this.ablO = paramList;
    AppMethodBeat.o(60192);
  }
  
  public final Collection<ah> a(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60187);
    p.k(paramf, "name");
    p.k(parama, "location");
    Object localObject = this.ablO;
    if (((List)localObject).isEmpty())
    {
      paramf = (Collection)x.aaAf;
      AppMethodBeat.o(60187);
      return paramf;
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (localObject = null; localIterator.hasNext(); localObject = kotlin.l.b.a.b.n.b.a.a((Collection)localObject, ((h)localIterator.next()).a(paramf, parama))) {}
    if (localObject == null) {}
    for (paramf = (Collection)x.aaAf;; paramf = (f)localObject)
    {
      AppMethodBeat.o(60187);
      return paramf;
    }
  }
  
  public final Collection<l> a(d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(60189);
    p.k(paramd, "kindFilter");
    p.k(paramb, "nameFilter");
    Object localObject = this.ablO;
    if (((List)localObject).isEmpty())
    {
      paramd = (Collection)x.aaAf;
      AppMethodBeat.o(60189);
      return paramd;
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (localObject = null; localIterator.hasNext(); localObject = kotlin.l.b.a.b.n.b.a.a((Collection)localObject, ((h)localIterator.next()).a(paramd, paramb))) {}
    if (localObject == null) {}
    for (paramd = (Collection)x.aaAf;; paramd = (d)localObject)
    {
      AppMethodBeat.o(60189);
      return paramd;
    }
  }
  
  public final Collection<am> b(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60188);
    p.k(paramf, "name");
    p.k(parama, "location");
    Object localObject = this.ablO;
    if (((List)localObject).isEmpty())
    {
      paramf = (Collection)x.aaAf;
      AppMethodBeat.o(60188);
      return paramf;
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (localObject = null; localIterator.hasNext(); localObject = kotlin.l.b.a.b.n.b.a.a((Collection)localObject, ((h)localIterator.next()).b(paramf, parama))) {}
    if (localObject == null) {}
    for (paramf = (Collection)x.aaAf;; paramf = (f)localObject)
    {
      AppMethodBeat.o(60188);
      return paramf;
    }
  }
  
  public final kotlin.l.b.a.b.b.h c(f paramf, kotlin.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60186);
    p.k(paramf, "name");
    p.k(parama, "location");
    Iterator localIterator = this.ablO.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      kotlin.l.b.a.b.b.h localh = ((h)localIterator.next()).c(paramf, parama);
      if (localh != null) {
        if (((localh instanceof i)) && (((i)localh).iDV()))
        {
          if (localObject == null) {
            localObject = localh;
          }
        }
        else
        {
          AppMethodBeat.o(60186);
          return localh;
        }
      }
    }
    AppMethodBeat.o(60186);
    return localObject;
  }
  
  public final Set<f> iGp()
  {
    AppMethodBeat.i(60190);
    Object localObject2 = (Iterable)this.ablO;
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      j.a((Collection)localObject1, (Iterable)((h)((Iterator)localObject2).next()).iGp());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(60190);
    return localObject1;
  }
  
  public final Set<f> iGq()
  {
    AppMethodBeat.i(60191);
    Object localObject2 = (Iterable)this.ablO;
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      j.a((Collection)localObject1, (Iterable)((h)((Iterator)localObject2).next()).iGq());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(60191);
    return localObject1;
  }
  
  public final String toString()
  {
    return this.ablN;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.b
 * JD-Core Version:    0.7.0.1
 */