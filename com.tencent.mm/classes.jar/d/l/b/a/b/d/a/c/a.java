package d.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.f;
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
    d.g.b.k.h(paramh, "$this$computeNewDefaultTypeQualifiers");
    d.g.b.k.h(paramg, "additionalAnnotations");
    if (paramh.LnL.Lnt.Bky)
    {
      paramh = paramh.fUg();
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
      localObject4 = paramh.LnL.Lnt;
      d.g.b.k.h(localc1, "annotationDescriptor");
      if (((d.l.b.a.b.d.a.a)localObject4).Lkr.gcN())
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
        paramg = (k)d.l.b.a.b.d.a.b.fTN().get(localc1.fRH());
        if (paramg != null)
        {
          localObject1 = paramg.LnS;
          localObject5 = paramg.LnT;
          paramg = ((d.l.b.a.b.d.a.a)localObject4).f(localc1);
          if (paramg != d.l.b.a.b.o.g.LOZ)
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
          paramg = new k(d.l.b.a.b.d.a.f.h.a((d.l.b.a.b.d.a.f.h)localObject1, paramg.gcO()), (Collection)localObject5);
          break label118;
        }
        paramg = null;
        break label118;
        label254:
        c localc2 = paramg.Lkx;
        Object localObject5 = paramg.fTJ();
        localObject1 = ((d.l.b.a.b.d.a.a)localObject4).g(localc1);
        paramg = (d.l.b.a.b.b.a.g)localObject1;
        if (localObject1 == null) {
          paramg = ((d.l.b.a.b.d.a.a)localObject4).f(localc2);
        }
        if (paramg.gcP())
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = paramh.LnL.Lnu.i(localc2);
          if (localObject1 != null)
          {
            paramg = d.l.b.a.b.d.a.f.h.a((d.l.b.a.b.d.a.f.h)localObject1, paramg.gcO());
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
      paramh = paramh.fUg();
      AppMethodBeat.o(57737);
      return paramh;
    }
    paramg = paramh.fUg();
    if (paramg != null)
    {
      paramg = paramg.LnB;
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
      localObject2 = ((k)localObject3).LnS;
      localObject3 = ((k)localObject3).LnT.iterator();
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
      paramh = paramh.fUg();
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
    d.g.b.k.h(paramh, "$this$childForMethod");
    d.g.b.k.h(paraml, "containingDeclaration");
    d.g.b.k.h(paramx, "typeParameterOwner");
    paramh = a(paramh, paraml, paramx, paramInt, paramh.LnN);
    AppMethodBeat.o(57739);
    return paramh;
  }
  
  private static final h a(h paramh, d.l.b.a.b.b.l paraml, x paramx, int paramInt, f<d> paramf)
  {
    AppMethodBeat.i(57738);
    b localb = paramh.LnL;
    if (paramx != null) {}
    for (paramh = (m)new i(paramh, paraml, paramx, paramInt);; paramh = paramh.LnM)
    {
      paramh = new h(localb, paramh, paramf);
      AppMethodBeat.o(57738);
      return paramh;
    }
  }
  
  public static final h b(h paramh, final d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(57741);
    d.g.b.k.h(paramh, "$this$copyWithNewDefaultTypeQualifiers");
    d.g.b.k.h(paramg, "additionalAnnotations");
    if (paramg.isEmpty())
    {
      AppMethodBeat.o(57741);
      return paramh;
    }
    paramh = new h(paramh.LnL, paramh.LnM, d.g.a(d.k.KTe, (d.g.a.a)new b(paramh, paramg)));
    AppMethodBeat.o(57741);
    return paramh;
  }
  
  static final class a
    extends d.g.b.l
    implements d.g.a.a<d>
  {
    a(h paramh, d.l.b.a.b.b.g paramg)
    {
      super();
    }
  }
  
  static final class b
    extends d.g.b.l
    implements d.g.a.a<d>
  {
    b(h paramh, d.l.b.a.b.b.a.g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */