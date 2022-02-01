package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.j.f.m;
import kotlin.l.b.a.b.j.f.m.a;
import kotlin.l.b.a.b.m.a.i;

public final class aa
  implements at
{
  public final LinkedHashSet<ab> TOe;
  private final int aHK;
  
  public aa(Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(60760);
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (kotlin.aa.SXc) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Attempt to create an empty intersection");
      AppMethodBeat.o(60760);
      throw paramCollection;
    }
    this.TOe = new LinkedHashSet(paramCollection);
    this.aHK = this.TOe.hashCode();
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
    boolean bool = p.j(this.TOe, ((aa)paramObject).TOe);
    AppMethodBeat.o(60758);
    return bool;
  }
  
  public final List<as> getParameters()
  {
    return (List)v.SXr;
  }
  
  public final Collection<ab> hBV()
  {
    return (Collection)this.TOe;
  }
  
  public final kotlin.l.b.a.b.a.g hBh()
  {
    AppMethodBeat.i(60756);
    kotlin.l.b.a.b.a.g localg = ((ab)this.TOe.iterator().next()).hKE().hBh();
    p.g(localg, "intersectedTypes.iterato…xt().constructor.builtIns");
    AppMethodBeat.o(60756);
    return localg;
  }
  
  public final aj hLE()
  {
    AppMethodBeat.i(60759);
    Object localObject = kotlin.l.b.a.b.b.a.g.TiC;
    localObject = g.a.hBP();
    at localat = (at)this;
    List localList = (List)v.SXr;
    m.a locala = m.TKi;
    localObject = ac.a((kotlin.l.b.a.b.b.a.g)localObject, localat, localList, false, m.a.c("member scope for intersection type ".concat(String.valueOf(this)), (Collection)this.TOe), (b)new a(this));
    AppMethodBeat.o(60759);
    return localObject;
  }
  
  public final int hashCode()
  {
    return this.aHK;
  }
  
  public final h hzS()
  {
    return null;
  }
  
  public final boolean hzU()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60757);
    String str = j.a((Iterable)j.a((Iterable)this.TOe, (Comparator)new aa.b()), (CharSequence)" & ", (CharSequence)"{", (CharSequence)"}", 0, null, null, 56);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.aa
 * JD-Core Version:    0.7.0.1
 */