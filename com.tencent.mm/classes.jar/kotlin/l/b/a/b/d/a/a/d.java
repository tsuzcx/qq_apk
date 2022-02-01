package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g.a;
import kotlin.l.b.a.b.b.a.n;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;
import kotlin.s;

public final class d
{
  private static final Map<String, EnumSet<n>> aaSZ;
  private static final Map<String, kotlin.l.b.a.b.b.a.m> aaTa;
  public static final d aaTb;
  
  static
  {
    AppMethodBeat.i(57665);
    aaTb = new d();
    aaSZ = ae.e(new o[] { s.M("PACKAGE", EnumSet.noneOf(n.class)), s.M("TYPE", EnumSet.of((Enum)n.aaLP, (Enum)n.aaMc)), s.M("ANNOTATION_TYPE", EnumSet.of((Enum)n.aaLQ)), s.M("TYPE_PARAMETER", EnumSet.of((Enum)n.aaLR)), s.M("FIELD", EnumSet.of((Enum)n.aaLT)), s.M("LOCAL_VARIABLE", EnumSet.of((Enum)n.aaLU)), s.M("PARAMETER", EnumSet.of((Enum)n.aaLV)), s.M("CONSTRUCTOR", EnumSet.of((Enum)n.aaLW)), s.M("METHOD", EnumSet.of((Enum)n.aaLX, (Enum)n.aaLY, (Enum)n.aaLZ)), s.M("TYPE_USE", EnumSet.of((Enum)n.aaMa)) });
    aaTa = ae.e(new o[] { s.M("RUNTIME", kotlin.l.b.a.b.b.a.m.aaLL), s.M("CLASS", kotlin.l.b.a.b.b.a.m.aaLM), s.M("SOURCE", kotlin.l.b.a.b.b.a.m.aaLN) });
    AppMethodBeat.o(57665);
  }
  
  public static kotlin.l.b.a.b.j.b.g<?> a(kotlin.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57664);
    if (!(paramb instanceof kotlin.l.b.a.b.d.a.e.m)) {
      paramb = null;
    }
    for (;;)
    {
      paramb = (kotlin.l.b.a.b.d.a.e.m)paramb;
      if (paramb != null)
      {
        Object localObject = aaTa;
        paramb = paramb.iHt();
        if (paramb != null)
        {
          paramb = paramb.qu();
          localObject = (kotlin.l.b.a.b.b.a.m)((Map)localObject).get(paramb);
          if (localObject == null) {
            break label115;
          }
          paramb = a.p(kotlin.l.b.a.b.a.g.aaFI.aaGr);
          p.j(paramb, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
          localObject = f.bHb(((kotlin.l.b.a.b.b.a.m)localObject).name());
          p.j(localObject, "Name.identifier(retention.name)");
          paramb = new kotlin.l.b.a.b.j.b.j(paramb, (f)localObject);
        }
      }
      for (;;)
      {
        paramb = (kotlin.l.b.a.b.j.b.g)paramb;
        AppMethodBeat.o(57664);
        return paramb;
        paramb = null;
        break;
        label115:
        paramb = null;
        continue;
        paramb = null;
      }
    }
  }
  
  public static kotlin.l.b.a.b.j.b.g<?> lB(List<? extends kotlin.l.b.a.b.d.a.e.b> paramList)
  {
    AppMethodBeat.i(57663);
    p.k(paramList, "arguments");
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
      paramList = ((kotlin.l.b.a.b.d.a.e.m)((Iterator)localObject2).next()).iHt();
      if (paramList != null)
      {
        paramList = paramList.qu();
        label127:
        paramList = (EnumSet)aaSZ.get(paramList);
        if (paramList == null) {
          break label166;
        }
      }
      label166:
      for (paramList = (Set)paramList;; paramList = (Set)x.aaAf)
      {
        kotlin.a.j.a((Collection)localObject1, (Iterable)paramList);
        break;
        paramList = null;
        break label127;
      }
    }
    localObject1 = (Iterable)localObject1;
    paramList = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (n)((Iterator)localObject1).next();
      localObject2 = a.p(kotlin.l.b.a.b.a.g.aaFI.aaGq);
      p.j(localObject2, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
      localObject3 = f.bHb(((n)localObject3).name());
      p.j(localObject3, "Name.identifier(kotlinTarget.name)");
      paramList.add(new kotlin.l.b.a.b.j.b.j((a)localObject2, (f)localObject3));
    }
    paramList = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.b((List)paramList, (kotlin.g.a.b)a.aaTc);
    AppMethodBeat.o(57663);
    return paramList;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<y, ab>
  {
    public static final a aaTc;
    
    static
    {
      AppMethodBeat.i(57662);
      aaTc = new a();
      AppMethodBeat.o(57662);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */