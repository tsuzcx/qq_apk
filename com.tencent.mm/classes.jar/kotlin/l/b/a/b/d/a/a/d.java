package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.a.n;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.j.b.j;
import kotlin.r;
import kotlin.v;

public final class d
{
  public static final d aiRa;
  private static final Map<String, EnumSet<n>> aiRb;
  private static final Map<String, kotlin.l.b.a.b.b.a.m> aiRc;
  
  static
  {
    AppMethodBeat.i(57665);
    aiRa = new d();
    aiRb = ak.e(new r[] { v.Y("PACKAGE", EnumSet.noneOf(n.class)), v.Y("TYPE", EnumSet.of((Enum)n.aiID, (Enum)n.aiIQ)), v.Y("ANNOTATION_TYPE", EnumSet.of((Enum)n.aiIE)), v.Y("TYPE_PARAMETER", EnumSet.of((Enum)n.aiIF)), v.Y("FIELD", EnumSet.of((Enum)n.aiIH)), v.Y("LOCAL_VARIABLE", EnumSet.of((Enum)n.aiII)), v.Y("PARAMETER", EnumSet.of((Enum)n.aiIJ)), v.Y("CONSTRUCTOR", EnumSet.of((Enum)n.aiIK)), v.Y("METHOD", EnumSet.of((Enum)n.aiIL, (Enum)n.aiIM, (Enum)n.aiIN)), v.Y("TYPE_USE", EnumSet.of((Enum)n.aiIO)) });
    aiRc = ak.e(new r[] { v.Y("RUNTIME", kotlin.l.b.a.b.b.a.m.aiIv), v.Y("CLASS", kotlin.l.b.a.b.b.a.m.aiIw), v.Y("SOURCE", kotlin.l.b.a.b.b.a.m.aiIx) });
    AppMethodBeat.o(57665);
  }
  
  public static g<?> a(kotlin.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57664);
    if ((paramb instanceof kotlin.l.b.a.b.d.a.e.m))
    {
      paramb = (kotlin.l.b.a.b.d.a.e.m)paramb;
      if (paramb != null) {
        break label40;
      }
      paramb = null;
    }
    for (;;)
    {
      paramb = (g)paramb;
      AppMethodBeat.o(57664);
      return paramb;
      paramb = null;
      break;
      label40:
      Object localObject = aiRc;
      paramb = paramb.kra();
      if (paramb == null) {}
      for (paramb = null;; paramb = paramb.PF())
      {
        localObject = (kotlin.l.b.a.b.b.a.m)((Map)localObject).get(paramb);
        if (localObject != null) {
          break label85;
        }
        paramb = null;
        break;
      }
      label85:
      paramb = kotlin.l.b.a.b.f.b.s(k.a.aiDe);
      s.s(paramb, "topLevel(StandardNames.F…ames.annotationRetention)");
      localObject = f.bJe(((kotlin.l.b.a.b.b.a.m)localObject).name());
      s.s(localObject, "identifier(retention.name)");
      paramb = new j(paramb, (f)localObject);
    }
  }
  
  public static Set<n> bIR(String paramString)
  {
    AppMethodBeat.i(192122);
    paramString = (EnumSet)aiRb.get(paramString);
    if (paramString == null)
    {
      paramString = (Set)kotlin.a.ad.aivA;
      AppMethodBeat.o(192122);
      return paramString;
    }
    paramString = (Set)paramString;
    AppMethodBeat.o(192122);
    return paramString;
  }
  
  public static g<?> oZ(List<? extends kotlin.l.b.a.b.d.a.e.b> paramList)
  {
    AppMethodBeat.i(57663);
    s.u(paramList, "arguments");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof kotlin.l.b.a.b.d.a.e.m)) {
        paramList.add(localObject2);
      }
    }
    paramList = (Iterable)paramList;
    localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      paramList = ((kotlin.l.b.a.b.d.a.e.m)((Iterator)localObject2).next()).kra();
      if (paramList == null) {}
      for (paramList = null;; paramList = paramList.PF())
      {
        p.a((Collection)localObject1, (Iterable)bIR(paramList));
        break;
      }
    }
    localObject1 = (Iterable)localObject1;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (n)((Iterator)localObject1).next();
      localObject2 = kotlin.l.b.a.b.f.b.s(k.a.aiDd);
      s.s(localObject2, "topLevel(StandardNames.FqNames.annotationTarget)");
      localObject3 = f.bJe(((n)localObject3).name());
      s.s(localObject3, "identifier(kotlinTarget.name)");
      paramList.add(new j((kotlin.l.b.a.b.f.b)localObject2, (f)localObject3));
    }
    paramList = (g)new kotlin.l.b.a.b.j.b.b((List)paramList, (kotlin.g.a.b)a.aiRd);
    AppMethodBeat.o(57663);
    return paramList;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.b<ae, kotlin.l.b.a.b.m.ad>
  {
    public static final a aiRd;
    
    static
    {
      AppMethodBeat.i(57662);
      aiRd = new a();
      AppMethodBeat.o(57662);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */