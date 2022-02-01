package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.d;

public final class c
{
  public static final c aiBl;
  private static final Set<b> aiBm;
  
  static
  {
    AppMethodBeat.i(56653);
    aiBl = new c();
    Object localObject = (Iterable)i.aiBG;
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(k.c((i)((Iterator)localObject).next()));
    }
    localCollection = (Collection)localCollection;
    localObject = k.a.aiCE.kxX();
    s.s(localObject, "string.toSafe()");
    localCollection = (Collection)p.b(localCollection, localObject);
    localObject = k.a.aiCG.kxX();
    s.s(localObject, "_boolean.toSafe()");
    localCollection = (Collection)p.b(localCollection, localObject);
    localObject = k.a.aiCP.kxX();
    s.s(localObject, "_enum.toSafe()");
    localObject = (Iterable)p.b(localCollection, localObject);
    localCollection = (Collection)new LinkedHashSet();
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(b.s((kotlin.l.b.a.b.f.c)((Iterator)localObject).next()));
    }
    aiBm = (Set)localCollection;
    AppMethodBeat.o(56653);
  }
  
  public static Set<b> kmF()
  {
    return aiBm;
  }
  
  public static Set<b> kmG()
  {
    AppMethodBeat.i(56651);
    Set localSet = aiBm;
    AppMethodBeat.o(56651);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.c
 * JD-Core Version:    0.7.0.1
 */