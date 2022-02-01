package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.b.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.a.g.a;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.h;
import d.l.b.a.b.j.f.m;
import d.l.b.a.b.j.f.m.a;
import d.l.b.a.b.m.a.i;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class aa
  implements at
{
  public final LinkedHashSet<ab> NZl;
  private final int aHQ;
  
  public aa(Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(60760);
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (d.ac.Nhs) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Attempt to create an empty intersection");
      AppMethodBeat.o(60760);
      throw paramCollection;
    }
    this.NZl = new LinkedHashSet(paramCollection);
    this.aHQ = this.NZl.hashCode();
    AppMethodBeat.o(60760);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60758);
    if ((aa)this == paramObject)
    {
      AppMethodBeat.o(60758);
      return true;
    }
    if (!(paramObject instanceof aa))
    {
      AppMethodBeat.o(60758);
      return false;
    }
    boolean bool = p.i(this.NZl, ((aa)paramObject).NZl);
    AppMethodBeat.o(60758);
    return bool;
  }
  
  public final List<as> getParameters()
  {
    return (List)v.NhH;
  }
  
  public final h gmq()
  {
    return null;
  }
  
  public final boolean gms()
  {
    return false;
  }
  
  public final d.l.b.a.b.a.g gnF()
  {
    AppMethodBeat.i(60756);
    d.l.b.a.b.a.g localg = ((ab)this.NZl.iterator().next()).gxB().gnF();
    p.g(localg, "intersectedTypes.iterato…xt().constructor.builtIns");
    AppMethodBeat.o(60756);
    return localg;
  }
  
  public final Collection<ab> got()
  {
    return (Collection)this.NZl;
  }
  
  public final aj gyB()
  {
    AppMethodBeat.i(60759);
    Object localObject = d.l.b.a.b.b.a.g.NsU;
    localObject = g.a.gon();
    at localat = (at)this;
    List localList = (List)v.NhH;
    m.a locala = m.NVm;
    localObject = ac.a((d.l.b.a.b.b.a.g)localObject, localat, localList, false, m.a.c("member scope for intersection type ".concat(String.valueOf(this)), (Collection)this.NZl), (b)new a(this));
    AppMethodBeat.o(60759);
    return localObject;
  }
  
  public final int hashCode()
  {
    return this.aHQ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60757);
    String str = j.a((Iterable)j.a((Iterable)this.NZl, (Comparator)new b()), (CharSequence)" & ", (CharSequence)"{", (CharSequence)"}", 0, null, null, 56);
    AppMethodBeat.o(60757);
    return str;
  }
  
  static final class a
    extends q
    implements b<i, aj>
  {
    a(aa paramaa)
    {
      super();
    }
  }
  
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(60755);
      int i = a.a((Comparable)((ab)paramT1).toString(), (Comparable)((ab)paramT2).toString());
      AppMethodBeat.o(60755);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.aa
 * JD-Core Version:    0.7.0.1
 */