package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.o.e;

public final class a
{
  public static final d a(h paramh, kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(57737);
    p.k(paramh, "$this$computeNewDefaultTypeQualifiers");
    p.k(paramg, "additionalAnnotations");
    if (paramh.aaUp.aaTX.Dlq)
    {
      paramh = paramh.iIc();
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
      localObject4 = paramh.aaUp.aaTX;
      p.k(localc1, "annotationDescriptor");
      if (((kotlin.l.b.a.b.d.a.a)localObject4).aaQV.iQl())
      {
        paramg = null;
        localObject1 = paramg;
        if (paramg == null)
        {
          paramg = ((kotlin.l.b.a.b.d.a.a)localObject4).e(localc1);
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
        paramg = (k)kotlin.l.b.a.b.d.a.b.iHJ().get(localc1.iFy());
        if (paramg != null)
        {
          localObject1 = paramg.aaUw;
          localObject5 = paramg.aaUx;
          paramg = ((kotlin.l.b.a.b.d.a.a)localObject4).f(localc1);
          if (paramg != kotlin.l.b.a.b.o.g.abut)
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
          paramg = new k(kotlin.l.b.a.b.d.a.f.h.a((kotlin.l.b.a.b.d.a.f.h)localObject1, paramg.iQm()), (Collection)localObject5);
          break label118;
        }
        paramg = null;
        break label118;
        label254:
        c localc2 = paramg.aaRb;
        Object localObject5 = paramg.component2();
        localObject1 = ((kotlin.l.b.a.b.d.a.a)localObject4).g(localc1);
        paramg = (kotlin.l.b.a.b.b.a.g)localObject1;
        if (localObject1 == null) {
          paramg = ((kotlin.l.b.a.b.d.a.a)localObject4).f(localc2);
        }
        if (paramg.dLi())
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = paramh.aaUp.aaTY.i(localc2);
          if (localObject1 != null)
          {
            paramg = kotlin.l.b.a.b.d.a.f.h.a((kotlin.l.b.a.b.d.a.f.h)localObject1, paramg.iQm());
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
      paramh = paramh.iIc();
      AppMethodBeat.o(57737);
      return paramh;
    }
    paramg = paramh.iIc();
    if (paramg != null)
    {
      paramg = paramg.aaUf;
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
      localObject2 = ((k)localObject3).aaUw;
      localObject3 = ((k)localObject3).aaUx.iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (kotlin.l.b.a.b.d.a.a.a)((Iterator)localObject3).next();
          ((Map)paramg).put(localObject4, localObject2);
          i = 1;
          continue;
          paramg = new EnumMap(kotlin.l.b.a.b.d.a.a.a.class);
          break;
        }
      }
    }
    label511:
    if (i == 0)
    {
      paramh = paramh.iIc();
      AppMethodBeat.o(57737);
      return paramh;
    }
    paramh = new d(paramg);
    AppMethodBeat.o(57737);
    return paramh;
  }
  
  public static final h a(h paramh, kotlin.l.b.a.b.b.l paraml, x paramx, int paramInt)
  {
    AppMethodBeat.i(57739);
    p.k(paramh, "$this$childForMethod");
    p.k(paraml, "containingDeclaration");
    p.k(paramx, "typeParameterOwner");
    paramh = a(paramh, paraml, paramx, paramInt, paramh.aaUr);
    AppMethodBeat.o(57739);
    return paramh;
  }
  
  private static final h a(h paramh, kotlin.l.b.a.b.b.l paraml, x paramx, int paramInt, f<d> paramf)
  {
    AppMethodBeat.i(57738);
    b localb = paramh.aaUp;
    if (paramx != null) {}
    for (paramh = (m)new i(paramh, paraml, paramx, paramInt);; paramh = paramh.aaUq)
    {
      paramh = new h(localb, paramh, paramf);
      AppMethodBeat.o(57738);
      return paramh;
    }
  }
  
  public static final h b(h paramh, final kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(57741);
    p.k(paramh, "$this$copyWithNewDefaultTypeQualifiers");
    p.k(paramg, "additionalAnnotations");
    if (paramg.isEmpty())
    {
      AppMethodBeat.o(57741);
      return paramh;
    }
    paramh = new h(paramh.aaUp, paramh.aaUq, kotlin.g.a(kotlin.k.aazD, (kotlin.g.a.a)new b(paramh, paramg)));
    AppMethodBeat.o(57741);
    return paramh;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<d>
  {
    a(h paramh, kotlin.l.b.a.b.b.g paramg)
    {
      super();
    }
  }
  
  static final class b
    extends q
    implements kotlin.g.a.a<d>
  {
    b(h paramh, kotlin.l.b.a.b.b.a.g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */