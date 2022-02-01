package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
import d.b.a;
import d.g.a.b;
import d.g.b.k;
import d.g.b.l;
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
  public final LinkedHashSet<ab> LLj;
  private final int aFZ;
  
  public aa(Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(60760);
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (d.aa.KTq) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Attempt to create an empty intersection");
      AppMethodBeat.o(60760);
      throw paramCollection;
    }
    this.LLj = new LinkedHashSet(paramCollection);
    this.aFZ = this.LLj.hashCode();
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
    boolean bool = k.g(this.LLj, ((aa)paramObject).LLj);
    AppMethodBeat.o(60758);
    return bool;
  }
  
  public final h fQq()
  {
    return null;
  }
  
  public final boolean fQs()
  {
    return false;
  }
  
  public final d.l.b.a.b.a.g fRE()
  {
    AppMethodBeat.i(60756);
    d.l.b.a.b.a.g localg = ((ab)this.LLj.iterator().next()).gbz().fRE();
    k.g(localg, "intersectedTypes.iterato…xt().constructor.builtIns");
    AppMethodBeat.o(60756);
    return localg;
  }
  
  public final Collection<ab> fSt()
  {
    return (Collection)this.LLj;
  }
  
  public final aj gcy()
  {
    AppMethodBeat.i(60759);
    Object localObject = d.l.b.a.b.b.a.g.LeU;
    localObject = g.a.fSm();
    at localat = (at)this;
    List localList = (List)v.KTF;
    m.a locala = m.LHh;
    localObject = ac.a((d.l.b.a.b.b.a.g)localObject, localat, localList, false, m.a.b("member scope for intersection type ".concat(String.valueOf(this)), (Collection)this.LLj), (b)new a(this));
    AppMethodBeat.o(60759);
    return localObject;
  }
  
  public final List<as> getParameters()
  {
    return (List)v.KTF;
  }
  
  public final int hashCode()
  {
    return this.aFZ;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60757);
    String str = j.a((Iterable)j.a((Iterable)this.LLj, (Comparator)new b()), (CharSequence)" & ", (CharSequence)"{", (CharSequence)"}", 0, null, null, 56);
    AppMethodBeat.o(60757);
    return str;
  }
  
  static final class a
    extends l
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