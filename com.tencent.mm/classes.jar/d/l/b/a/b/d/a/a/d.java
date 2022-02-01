package d.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.x;
import d.g.b.k;
import d.g.b.l;
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
  private static final Map<String, EnumSet<n>> Lmv;
  private static final Map<String, d.l.b.a.b.b.a.m> Lmw;
  public static final d Lmx;
  
  static
  {
    AppMethodBeat.i(57665);
    Lmx = new d();
    Lmv = ae.a(new o[] { u.Q("PACKAGE", EnumSet.noneOf(n.class)), u.Q("TYPE", EnumSet.of((Enum)n.Lfl, (Enum)n.Lfy)), u.Q("ANNOTATION_TYPE", EnumSet.of((Enum)n.Lfm)), u.Q("TYPE_PARAMETER", EnumSet.of((Enum)n.Lfn)), u.Q("FIELD", EnumSet.of((Enum)n.Lfp)), u.Q("LOCAL_VARIABLE", EnumSet.of((Enum)n.Lfq)), u.Q("PARAMETER", EnumSet.of((Enum)n.Lfr)), u.Q("CONSTRUCTOR", EnumSet.of((Enum)n.Lfs)), u.Q("METHOD", EnumSet.of((Enum)n.Lft, (Enum)n.Lfu, (Enum)n.Lfv)), u.Q("TYPE_USE", EnumSet.of((Enum)n.Lfw)) });
    Lmw = ae.a(new o[] { u.Q("RUNTIME", d.l.b.a.b.b.a.m.Lfh), u.Q("CLASS", d.l.b.a.b.b.a.m.Lfi), u.Q("SOURCE", d.l.b.a.b.b.a.m.Lfj) });
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
        Object localObject = Lmw;
        paramb = paramb.fTw();
        if (paramb != null)
        {
          paramb = paramb.rf();
          localObject = (d.l.b.a.b.b.a.m)((Map)localObject).get(paramb);
          if (localObject == null) {
            break label115;
          }
          paramb = a.p(d.l.b.a.b.a.g.KZg.KZP);
          k.g(paramb, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
          localObject = f.aWB(((d.l.b.a.b.b.a.m)localObject).name());
          k.g(localObject, "Name.identifier(retention.name)");
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
  
  public static d.l.b.a.b.j.b.g<?> jb(List<? extends d.l.b.a.b.d.a.e.b> paramList)
  {
    AppMethodBeat.i(57663);
    k.h(paramList, "arguments");
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
      paramList = ((d.l.b.a.b.d.a.e.m)((Iterator)localObject2).next()).fTw();
      if (paramList != null)
      {
        paramList = paramList.rf();
        label127:
        paramList = (EnumSet)Lmv.get(paramList);
        if (paramList == null) {
          break label166;
        }
      }
      label166:
      for (paramList = (Set)paramList;; paramList = (Set)x.KTH)
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
      localObject2 = a.p(d.l.b.a.b.a.g.KZg.KZO);
      k.g(localObject2, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
      localObject3 = f.aWB(((n)localObject3).name());
      k.g(localObject3, "Name.identifier(kotlinTarget.name)");
      paramList.add(new d.l.b.a.b.j.b.j((a)localObject2, (f)localObject3));
    }
    paramList = (d.l.b.a.b.j.b.g)new d.l.b.a.b.j.b.b((List)paramList, (d.g.a.b)a.Lmy);
    AppMethodBeat.o(57663);
    return paramList;
  }
  
  static final class a
    extends l
    implements d.g.a.b<y, ab>
  {
    public static final a Lmy;
    
    static
    {
      AppMethodBeat.i(57662);
      Lmy = new a();
      AppMethodBeat.o(57662);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */