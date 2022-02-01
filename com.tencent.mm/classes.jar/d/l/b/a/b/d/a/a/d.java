package d.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.x;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.a.g.a;
import d.l.b.a.b.b.a.n;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.f;
import d.l.b.a.b.m.ab;
import d.o;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static final Map<String, EnumSet<n>> Nds;
  private static final Map<String, d.l.b.a.b.b.a.m> Ndt;
  public static final d Ndu;
  
  static
  {
    AppMethodBeat.i(57665);
    Ndu = new d();
    Nds = ae.a(new o[] { u.S("PACKAGE", EnumSet.noneOf(n.class)), u.S("TYPE", EnumSet.of((Enum)n.MWh, (Enum)n.MWu)), u.S("ANNOTATION_TYPE", EnumSet.of((Enum)n.MWi)), u.S("TYPE_PARAMETER", EnumSet.of((Enum)n.MWj)), u.S("FIELD", EnumSet.of((Enum)n.MWl)), u.S("LOCAL_VARIABLE", EnumSet.of((Enum)n.MWm)), u.S("PARAMETER", EnumSet.of((Enum)n.MWn)), u.S("CONSTRUCTOR", EnumSet.of((Enum)n.MWo)), u.S("METHOD", EnumSet.of((Enum)n.MWp, (Enum)n.MWq, (Enum)n.MWr)), u.S("TYPE_USE", EnumSet.of((Enum)n.MWs)) });
    Ndt = ae.a(new o[] { u.S("RUNTIME", d.l.b.a.b.b.a.m.MWd), u.S("CLASS", d.l.b.a.b.b.a.m.MWe), u.S("SOURCE", d.l.b.a.b.b.a.m.MWf) });
    AppMethodBeat.o(57665);
  }
  
  public static d.l.b.a.b.j.b.g<?> a(d.l.b.a.b.d.a.e.b paramb)
  {
    AppMethodBeat.i(57664);
    if (!(paramb instanceof d.l.b.a.b.d.a.e.m)) {
      paramb = null;
    }
    for (;;)
    {
      paramb = (d.l.b.a.b.d.a.e.m)paramb;
      if (paramb != null)
      {
        Object localObject = Ndt;
        paramb = paramb.gkV();
        if (paramb != null)
        {
          paramb = paramb.sD();
          localObject = (d.l.b.a.b.b.a.m)((Map)localObject).get(paramb);
          if (localObject == null) {
            break label115;
          }
          paramb = a.p(d.l.b.a.b.a.g.MQb.MQK);
          p.g(paramb, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
          localObject = f.bcE(((d.l.b.a.b.b.a.m)localObject).name());
          p.g(localObject, "Name.identifier(retention.name)");
          paramb = new d.l.b.a.b.j.b.j(paramb, (f)localObject);
        }
      }
      for (;;)
      {
        paramb = (d.l.b.a.b.j.b.g)paramb;
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
  
  public static d.l.b.a.b.j.b.g<?> jp(List<? extends d.l.b.a.b.d.a.e.b> paramList)
  {
    AppMethodBeat.i(57663);
    p.h(paramList, "arguments");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof d.l.b.a.b.d.a.e.m)) {
        paramList.add(localObject2);
      }
    }
    paramList = (Iterable)paramList;
    localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      paramList = ((d.l.b.a.b.d.a.e.m)((Iterator)localObject2).next()).gkV();
      if (paramList != null)
      {
        paramList = paramList.sD();
        label127:
        paramList = (EnumSet)Nds.get(paramList);
        if (paramList == null) {
          break label166;
        }
      }
      label166:
      for (paramList = (Set)paramList;; paramList = (Set)x.MKG)
      {
        d.a.j.a((Collection)localObject1, (Iterable)paramList);
        break;
        paramList = null;
        break label127;
      }
    }
    localObject1 = (Iterable)localObject1;
    paramList = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (n)((Iterator)localObject1).next();
      localObject2 = a.p(d.l.b.a.b.a.g.MQb.MQJ);
      p.g(localObject2, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
      localObject3 = f.bcE(((n)localObject3).name());
      p.g(localObject3, "Name.identifier(kotlinTarget.name)");
      paramList.add(new d.l.b.a.b.j.b.j((a)localObject2, (f)localObject3));
    }
    paramList = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.b((List)paramList, (d.g.a.b)a.Ndv);
    AppMethodBeat.o(57663);
    return paramList;
  }
  
  static final class a
    extends q
    implements d.g.a.b<y, ab>
  {
    public static final a Ndv;
    
    static
    {
      AppMethodBeat.i(57662);
      Ndv = new a();
      AppMethodBeat.o(57662);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */