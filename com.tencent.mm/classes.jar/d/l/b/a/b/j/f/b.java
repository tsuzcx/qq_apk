package d.l.b.a.b.j.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.x;
import d.g.b.k;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.am;
import d.l.b.a.b.b.i;
import d.l.b.a.b.b.l;
import d.l.b.a.b.f.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class b
  implements h
{
  public static final a JST;
  private final String JSR;
  private final List<h> JSS;
  
  static
  {
    AppMethodBeat.i(60193);
    JST = new a((byte)0);
    AppMethodBeat.o(60193);
  }
  
  public b(String paramString, List<? extends h> paramList)
  {
    AppMethodBeat.i(60192);
    this.JSR = paramString;
    this.JSS = paramList;
    AppMethodBeat.o(60192);
  }
  
  public final Collection<ah> a(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60187);
    k.h(paramf, "name");
    k.h(parama, "location");
    Object localObject = this.JSS;
    if (((List)localObject).isEmpty())
    {
      paramf = (Collection)x.Jgn;
      AppMethodBeat.o(60187);
      return paramf;
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (localObject = null; localIterator.hasNext(); localObject = d.l.b.a.b.n.b.a.a((Collection)localObject, ((h)localIterator.next()).a(paramf, parama))) {}
    if (localObject == null) {}
    for (paramf = (Collection)x.Jgn;; paramf = (f)localObject)
    {
      AppMethodBeat.o(60187);
      return paramf;
    }
  }
  
  public final Collection<l> a(d paramd, d.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(60189);
    k.h(paramd, "kindFilter");
    k.h(paramb, "nameFilter");
    Object localObject = this.JSS;
    if (((List)localObject).isEmpty())
    {
      paramd = (Collection)x.Jgn;
      AppMethodBeat.o(60189);
      return paramd;
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (localObject = null; localIterator.hasNext(); localObject = d.l.b.a.b.n.b.a.a((Collection)localObject, ((h)localIterator.next()).a(paramd, paramb))) {}
    if (localObject == null) {}
    for (paramd = (Collection)x.Jgn;; paramd = (d)localObject)
    {
      AppMethodBeat.o(60189);
      return paramd;
    }
  }
  
  public final Collection<am> b(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60188);
    k.h(paramf, "name");
    k.h(parama, "location");
    Object localObject = this.JSS;
    if (((List)localObject).isEmpty())
    {
      paramf = (Collection)x.Jgn;
      AppMethodBeat.o(60188);
      return paramf;
    }
    Iterator localIterator = ((List)localObject).iterator();
    for (localObject = null; localIterator.hasNext(); localObject = d.l.b.a.b.n.b.a.a((Collection)localObject, ((h)localIterator.next()).b(paramf, parama))) {}
    if (localObject == null) {}
    for (paramf = (Collection)x.Jgn;; paramf = (f)localObject)
    {
      AppMethodBeat.o(60188);
      return paramf;
    }
  }
  
  public final d.l.b.a.b.b.h c(f paramf, d.l.b.a.b.c.a.a parama)
  {
    AppMethodBeat.i(60186);
    k.h(paramf, "name");
    k.h(parama, "location");
    Iterator localIterator = this.JSS.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      d.l.b.a.b.b.h localh = ((h)localIterator.next()).c(paramf, parama);
      if (localh != null) {
        if (((localh instanceof i)) && (((i)localh).fxC()))
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
  
  public final Set<f> fzU()
  {
    AppMethodBeat.i(60190);
    Object localObject2 = (Iterable)this.JSS;
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      j.a((Collection)localObject1, (Iterable)((h)((Iterator)localObject2).next()).fzU());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(60190);
    return localObject1;
  }
  
  public final Set<f> fzV()
  {
    AppMethodBeat.i(60191);
    Object localObject2 = (Iterable)this.JSS;
    Object localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      j.a((Collection)localObject1, (Iterable)((h)((Iterator)localObject2).next()).fzV());
    }
    localObject1 = (Set)localObject1;
    AppMethodBeat.o(60191);
    return localObject1;
  }
  
  public final String toString()
  {
    return this.JSR;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.b
 * JD-Core Version:    0.7.0.1
 */