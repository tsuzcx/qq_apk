package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.a.c;
import d.l.b.a.b.d.a.e.x;
import d.l.b.a.b.o.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  public static final d a(h paramh, d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(57737);
    p.h(paramh, "$this$computeNewDefaultTypeQualifiers");
    p.h(paramg, "additionalAnnotations");
    if (paramh.NeI.Neq.CKM)
    {
      paramh = paramh.glF();
      AppMethodBeat.o(57737);
      return paramh;
    }
    paramg = (Iterable)paramg;
    Object localObject2 = (Collection)new ArrayList();
    Object localObject3 = paramg.iterator();
    Object localObject4;
    label118:
    int i;
    label205:
    label350:
    while (((Iterator)localObject3).hasNext())
    {
      c localc1 = (c)((Iterator)localObject3).next();
      localObject4 = paramh.NeI.Neq;
      p.h(localc1, "annotationDescriptor");
      if (((d.l.b.a.b.d.a.a)localObject4).Nbo.guo())
      {
        paramg = null;
        localObject1 = paramg;
        if (paramg == null)
        {
          paramg = ((d.l.b.a.b.d.a.a)localObject4).e(localc1);
          if (paramg != null) {
            break label254;
          }
          localObject1 = null;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label350;
        }
        ((Collection)localObject2).add(localObject1);
        break;
        paramg = (k)d.l.b.a.b.d.a.b.glm().get(localc1.gjg());
        if (paramg != null)
        {
          localObject1 = paramg.NeP;
          localObject5 = paramg.NeQ;
          paramg = ((d.l.b.a.b.d.a.a)localObject4).f(localc1);
          if (paramg != d.l.b.a.b.o.g.NFU)
          {
            i = 1;
            if (i == 0) {
              break label223;
            }
          }
          for (;;)
          {
            if (paramg != null) {
              break label228;
            }
            paramg = null;
            break;
            i = 0;
            break label205;
            label223:
            paramg = null;
          }
          label228:
          paramg = new k(d.l.b.a.b.d.a.f.h.a((d.l.b.a.b.d.a.f.h)localObject1, paramg.gup()), (Collection)localObject5);
          break label118;
        }
        paramg = null;
        break label118;
        label254:
        c localc2 = paramg.Nbu;
        Object localObject5 = paramg.gli();
        localObject1 = ((d.l.b.a.b.d.a.a)localObject4).g(localc1);
        paramg = (d.l.b.a.b.b.a.g)localObject1;
        if (localObject1 == null) {
          paramg = ((d.l.b.a.b.d.a.a)localObject4).f(localc2);
        }
        if (paramg.guq())
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = paramh.NeI.Ner.i(localc2);
          if (localObject1 != null)
          {
            paramg = d.l.b.a.b.d.a.f.h.a((d.l.b.a.b.d.a.f.h)localObject1, paramg.gup());
            if (paramg != null) {}
          }
          else
          {
            localObject1 = null;
            continue;
          }
          localObject1 = new k(paramg, (Collection)localObject5);
        }
      }
    }
    Object localObject1 = (List)localObject2;
    if (((List)localObject1).isEmpty())
    {
      paramh = paramh.glF();
      AppMethodBeat.o(57737);
      return paramh;
    }
    paramg = paramh.glF();
    if (paramg != null)
    {
      paramg = paramg.Ney;
      if (paramg != null)
      {
        paramg = new EnumMap(paramg);
        localObject1 = ((List)localObject1).iterator();
        i = 0;
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label511;
      }
      localObject3 = (k)((Iterator)localObject1).next();
      localObject2 = ((k)localObject3).NeP;
      localObject3 = ((k)localObject3).NeQ.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (d.l.b.a.b.d.a.a.a)((Iterator)localObject3).next();
          ((Map)paramg).put(localObject4, localObject2);
          i = 1;
          continue;
          paramg = new EnumMap(d.l.b.a.b.d.a.a.a.class);
          break;
        }
      }
    }
    label511:
    if (i == 0)
    {
      paramh = paramh.glF();
      AppMethodBeat.o(57737);
      return paramh;
    }
    paramh = new d(paramg);
    AppMethodBeat.o(57737);
    return paramh;
  }
  
  public static final h a(h paramh, d.l.b.a.b.b.l paraml, x paramx, int paramInt)
  {
    AppMethodBeat.i(57739);
    p.h(paramh, "$this$childForMethod");
    p.h(paraml, "containingDeclaration");
    p.h(paramx, "typeParameterOwner");
    paramh = a(paramh, paraml, paramx, paramInt, paramh.NeK);
    AppMethodBeat.o(57739);
    return paramh;
  }
  
  private static final h a(h paramh, d.l.b.a.b.b.l paraml, x paramx, int paramInt, f<d> paramf)
  {
    AppMethodBeat.i(57738);
    b localb = paramh.NeI;
    if (paramx != null) {}
    for (paramh = (m)new i(paramh, paraml, paramx, paramInt);; paramh = paramh.NeJ)
    {
      paramh = new h(localb, paramh, paramf);
      AppMethodBeat.o(57738);
      return paramh;
    }
  }
  
  public static final h b(h paramh, final d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(57741);
    p.h(paramh, "$this$copyWithNewDefaultTypeQualifiers");
    p.h(paramg, "additionalAnnotations");
    if (paramg.isEmpty())
    {
      AppMethodBeat.o(57741);
      return paramh;
    }
    paramh = new h(paramh.NeI, paramh.NeJ, d.g.a(d.k.MKc, (d.g.a.a)new b(paramh, paramg)));
    AppMethodBeat.o(57741);
    return paramh;
  }
  
  static final class a
    extends q
    implements d.g.a.a<d>
  {
    a(h paramh, d.l.b.a.b.b.g paramg)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements d.g.a.a<d>
  {
    b(h paramh, d.l.b.a.b.b.a.g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */