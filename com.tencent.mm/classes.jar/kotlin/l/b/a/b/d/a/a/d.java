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
  private static final Map<String, EnumSet<n>> Tqf;
  private static final Map<String, kotlin.l.b.a.b.b.a.m> Tqg;
  public static final d Tqh;
  
  static
  {
    AppMethodBeat.i(57665);
    Tqh = new d();
    Tqf = ae.e(new o[] { s.U("PACKAGE", EnumSet.noneOf(n.class)), s.U("TYPE", EnumSet.of((Enum)n.TiV, (Enum)n.Tji)), s.U("ANNOTATION_TYPE", EnumSet.of((Enum)n.TiW)), s.U("TYPE_PARAMETER", EnumSet.of((Enum)n.TiX)), s.U("FIELD", EnumSet.of((Enum)n.TiZ)), s.U("LOCAL_VARIABLE", EnumSet.of((Enum)n.Tja)), s.U("PARAMETER", EnumSet.of((Enum)n.Tjb)), s.U("CONSTRUCTOR", EnumSet.of((Enum)n.Tjc)), s.U("METHOD", EnumSet.of((Enum)n.Tjd, (Enum)n.Tje, (Enum)n.Tjf)), s.U("TYPE_USE", EnumSet.of((Enum)n.Tjg)) });
    Tqg = ae.e(new o[] { s.U("RUNTIME", kotlin.l.b.a.b.b.a.m.TiR), s.U("CLASS", kotlin.l.b.a.b.b.a.m.TiS), s.U("SOURCE", kotlin.l.b.a.b.b.a.m.TiT) });
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
        Object localObject = Tqg;
        paramb = paramb.hCZ();
        if (paramb != null)
        {
          paramb = paramb.sG();
          localObject = (kotlin.l.b.a.b.b.a.m)((Map)localObject).get(paramb);
          if (localObject == null) {
            break label115;
          }
          paramb = a.p(kotlin.l.b.a.b.a.g.TcO.Tdx);
          p.g(paramb, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
          localObject = f.btY(((kotlin.l.b.a.b.b.a.m)localObject).name());
          p.g(localObject, "Name.identifier(retention.name)");
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
  
  public static kotlin.l.b.a.b.j.b.g<?> kE(List<? extends kotlin.l.b.a.b.d.a.e.b> paramList)
  {
    AppMethodBeat.i(57663);
    p.h(paramList, "arguments");
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
      paramList = ((kotlin.l.b.a.b.d.a.e.m)((Iterator)localObject2).next()).hCZ();
      if (paramList != null)
      {
        paramList = paramList.sG();
        label127:
        paramList = (EnumSet)Tqf.get(paramList);
        if (paramList == null) {
          break label166;
        }
      }
      label166:
      for (paramList = (Set)paramList;; paramList = (Set)x.SXt)
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
      localObject2 = a.p(kotlin.l.b.a.b.a.g.TcO.Tdw);
      p.g(localObject2, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
      localObject3 = f.btY(((n)localObject3).name());
      p.g(localObject3, "Name.identifier(kotlinTarget.name)");
      paramList.add(new kotlin.l.b.a.b.j.b.j((a)localObject2, (f)localObject3));
    }
    paramList = (kotlin.l.b.a.b.j.b.g)new kotlin.l.b.a.b.j.b.b((List)paramList, (kotlin.g.a.b)a.Tqi);
    AppMethodBeat.o(57663);
    return paramList;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.b<y, ab>
  {
    public static final a Tqi;
    
    static
    {
      AppMethodBeat.i(57662);
      Tqi = new a();
      AppMethodBeat.o(57662);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */