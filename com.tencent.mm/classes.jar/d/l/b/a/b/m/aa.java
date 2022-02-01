package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.v;
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
  public final LinkedHashSet<ab> JXQ;
  private final int aFj;
  
  public aa(Collection<? extends ab> paramCollection)
  {
    AppMethodBeat.i(60760);
    if (!paramCollection.isEmpty()) {}
    for (int i = 1; (d.aa.JfW) && (i == 0); i = 0)
    {
      paramCollection = (Throwable)new AssertionError("Attempt to create an empty intersection");
      AppMethodBeat.o(60760);
      throw paramCollection;
    }
    this.JXQ = new LinkedHashSet(paramCollection);
    this.aFj = this.JXQ.hashCode();
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
    boolean bool = k.g(this.JXQ, ((aa)paramObject).JXQ);
    AppMethodBeat.o(60758);
    return bool;
  }
  
  public final aj fJV()
  {
    AppMethodBeat.i(60759);
    Object localObject = d.l.b.a.b.b.a.g.JrB;
    localObject = g.a.fzI();
    at localat = (at)this;
    List localList = (List)v.Jgl;
    m.a locala = m.JTO;
    localObject = ac.a((d.l.b.a.b.b.a.g)localObject, localat, localList, false, m.a.b("member scope for intersection type ".concat(String.valueOf(this)), (Collection)this.JXQ), (b)new a(this));
    AppMethodBeat.o(60759);
    return localObject;
  }
  
  public final h fxM()
  {
    return null;
  }
  
  public final boolean fxO()
  {
    return false;
  }
  
  public final Collection<ab> fzP()
  {
    return (Collection)this.JXQ;
  }
  
  public final d.l.b.a.b.a.g fza()
  {
    AppMethodBeat.i(60756);
    d.l.b.a.b.a.g localg = ((ab)this.JXQ.iterator().next()).fIW().fza();
    k.g(localg, "intersectedTypes.iterato…xt().constructor.builtIns");
    AppMethodBeat.o(60756);
    return localg;
  }
  
  public final List<as> getParameters()
  {
    return (List)v.Jgl;
  }
  
  public final int hashCode()
  {
    return this.aFj;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60757);
    String str = j.a((Iterable)j.a((Iterable)this.JXQ, (Comparator)new aa.b()), (CharSequence)" & ", (CharSequence)"{", (CharSequence)"}", 0, null, null, 56);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.aa
 * JD-Core Version:    0.7.0.1
 */