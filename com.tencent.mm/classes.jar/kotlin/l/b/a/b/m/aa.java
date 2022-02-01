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
import kotlin.z;

public final class aa
  implements at
{
  private final int aNf;
  public final LinkedHashSet<ab> abqE;
  
  public aa(Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(60760);
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (z.aazO) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Attempt to create an empty intersection");
      AppMethodBeat.o(60760);
      throw paramCollection;
    }
    this.abqE = new LinkedHashSet(paramCollection);
    this.aNf = this.abqE.hashCode();
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
    boolean bool = p.h(this.abqE, ((aa)paramObject).abqE);
    AppMethodBeat.o(60758);
    return bool;
  }
  
  public final int hashCode()
  {
    return this.aNf;
  }
  
  public final List<as> iCb()
  {
    return (List)v.aaAd;
  }
  
  public final h iEf()
  {
    return null;
  }
  
  public final boolean iEh()
  {
    return false;
  }
  
  public final kotlin.l.b.a.b.a.g iFv()
  {
    AppMethodBeat.i(60756);
    kotlin.l.b.a.b.a.g localg = ((ab)this.abqE.iterator().next()).iOU().iFv();
    p.j(localg, "intersectedTypes.iterato…xt().constructor.builtIns");
    AppMethodBeat.o(60756);
    return localg;
  }
  
  public final Collection<ab> iGk()
  {
    return (Collection)this.abqE;
  }
  
  public final aj iPW()
  {
    AppMethodBeat.i(60759);
    Object localObject = kotlin.l.b.a.b.b.a.g.aaLw;
    localObject = g.a.iGe();
    at localat = (at)this;
    List localList = (List)v.aaAd;
    m.a locala = m.abmK;
    localObject = ac.a((kotlin.l.b.a.b.b.a.g)localObject, localat, localList, false, m.a.c("member scope for intersection type ".concat(String.valueOf(this)), (Collection)this.abqE), (b)new a(this));
    AppMethodBeat.o(60759);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60757);
    String str = j.a((Iterable)j.a((Iterable)this.abqE, (Comparator)new aa.b()), (CharSequence)" & ", (CharSequence)"{", (CharSequence)"}", 0, null, null, 56);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.aa
 * JD-Core Version:    0.7.0.1
 */