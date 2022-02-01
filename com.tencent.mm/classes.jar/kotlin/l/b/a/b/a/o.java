package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bg;
import kotlin.r;
import kotlin.v;

public final class o
{
  public static final o aiEq;
  private static final Set<f> aiEr;
  private static final Set<f> aiEs;
  private static final HashMap<b, b> aiEt;
  private static final HashMap<b, b> aiEu;
  private static final HashMap<m, f> aiEv;
  private static final Set<f> aiEw;
  
  static
  {
    AppMethodBeat.i(56704);
    aiEq = new o();
    Object localObject = n.values();
    Collection localCollection = (Collection)new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(localObject[i].aiBC);
      i += 1;
    }
    aiEr = p.r((Iterable)localCollection);
    localObject = m.values();
    localCollection = (Collection)new ArrayList(localObject.length);
    j = localObject.length;
    i = 0;
    while (i < j)
    {
      localCollection.add(localObject[i].aiBC);
      i += 1;
    }
    aiEs = p.r((Iterable)localCollection);
    aiEt = new HashMap();
    aiEu = new HashMap();
    aiEv = ak.g(new r[] { v.Y(m.aiEf, f.bJe("ubyteArrayOf")), v.Y(m.aiEg, f.bJe("ushortArrayOf")), v.Y(m.aiEh, f.bJe("uintArrayOf")), v.Y(m.aiEi, f.bJe("ulongArrayOf")) });
    localObject = n.values();
    localCollection = (Collection)new LinkedHashSet();
    j = localObject.length;
    i = 0;
    while (i < j)
    {
      localCollection.add(localObject[i].aiEk.kxN());
      i += 1;
    }
    aiEw = (Set)localCollection;
    localObject = n.values();
    j = localObject.length;
    i = 0;
    while (i < j)
    {
      localCollection = localObject[i];
      ((Map)aiEt).put(localCollection.aiEk, localCollection.aiEe);
      ((Map)aiEu).put(localCollection.aiEe, localCollection.aiEk);
      i += 1;
    }
    AppMethodBeat.o(56704);
  }
  
  public static b a(b paramb)
  {
    AppMethodBeat.i(56702);
    s.u(paramb, "arrayClassId");
    paramb = (b)aiEt.get(paramb);
    AppMethodBeat.o(56702);
    return paramb;
  }
  
  public static boolean c(f paramf)
  {
    AppMethodBeat.i(56701);
    s.u(paramf, "name");
    boolean bool = aiEw.contains(paramf);
    AppMethodBeat.o(56701);
    return bool;
  }
  
  public static final boolean x(ad paramad)
  {
    AppMethodBeat.i(56703);
    s.u(paramad, "type");
    if (bg.ar(paramad))
    {
      AppMethodBeat.o(56703);
      return false;
    }
    paramad = paramad.kzm().knA();
    if (paramad == null)
    {
      AppMethodBeat.o(56703);
      return false;
    }
    paramad = (l)paramad;
    s.u(paramad, "descriptor");
    l locall = paramad.knp();
    if (((locall instanceof ah)) && (s.p(((ah)locall).koY(), k.aiCr)) && (aiEr.contains(paramad.kok())))
    {
      AppMethodBeat.o(56703);
      return true;
    }
    AppMethodBeat.o(56703);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.o
 * JD-Core Version:    0.7.0.1
 */