package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.l.b.a.b.d.a.ab;
import kotlin.l.b.a.b.d.a.c.a;
import kotlin.l.b.a.b.d.a.e.y;
import kotlin.l.b.a.b.d.a.n;
import kotlin.l.b.a.b.d.a.t;
import kotlin.o;

public final class a
{
  public static final h a(h paramh, kotlin.l.b.a.b.b.l paraml, y paramy, int paramInt)
  {
    AppMethodBeat.i(57739);
    kotlin.g.b.s.u(paramh, "<this>");
    kotlin.g.b.s.u(paraml, "containingDeclaration");
    kotlin.g.b.s.u(paramy, "typeParameterOwner");
    paramh = a(paramh, paraml, paramy, paramInt, paramh.aiSr);
    AppMethodBeat.o(57739);
    return paramh;
  }
  
  private static final h a(h paramh, kotlin.l.b.a.b.b.l paraml, y paramy, int paramInt, j<t> paramj)
  {
    AppMethodBeat.i(57738);
    c localc = paramh.aiSp;
    if (paramy == null)
    {
      paraml = null;
      if (paraml != null) {
        break label61;
      }
    }
    label61:
    for (paramh = paramh.aiSq;; paramh = (l)paraml)
    {
      paramh = new h(localc, paramh, paramj);
      AppMethodBeat.o(57738);
      return paramh;
      paraml = new i(paramh, paraml, paramy, paramInt);
      break;
    }
  }
  
  public static final t a(h paramh, kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(192129);
    kotlin.g.b.s.u(paramh, "<this>");
    kotlin.g.b.s.u(paramg, "additionalAnnotations");
    if (paramh.aiSp.aiOo.aiPg)
    {
      paramh = paramh.ksj();
      AppMethodBeat.o(192129);
      return paramh;
    }
    paramg = (Iterable)paramg;
    Object localObject2 = (Collection)new ArrayList();
    Iterator localIterator = paramg.iterator();
    Object localObject1;
    Object localObject3;
    label118:
    int i;
    label316:
    label455:
    while (localIterator.hasNext())
    {
      localObject1 = (kotlin.l.b.a.b.b.a.c)localIterator.next();
      localObject3 = paramh.aiSp.aiRX;
      kotlin.g.b.s.u(localObject1, "annotationDescriptor");
      if (((kotlin.l.b.a.b.d.a.c)localObject3).aiOo.aiPg)
      {
        paramg = null;
        if (paramg == null) {
          break label316;
        }
      }
      for (;;)
      {
        if (paramg == null) {
          break label455;
        }
        ((Collection)localObject2).add(paramg);
        break;
        Object localObject4 = (n)kotlin.l.b.a.b.d.a.b.krw().get(((kotlin.l.b.a.b.b.a.c)localObject1).koY());
        if (localObject4 == null)
        {
          paramg = null;
          break label118;
        }
        paramg = ((kotlin.l.b.a.b.b.a.c)localObject1).koY();
        if ((paramg != null) && (kotlin.l.b.a.b.d.a.b.krv().containsKey(paramg)))
        {
          paramg = (ab)((kotlin.l.b.a.b.d.a.c)localObject3).aiOo.aiPf.invoke(paramg);
          label210:
          if (paramg == ab.aiQh) {
            break label243;
          }
          i = 1;
          label219:
          if (i == 0) {
            break label248;
          }
        }
        for (;;)
        {
          if (paramg != null) {
            break label253;
          }
          paramg = null;
          break;
          paramg = ((kotlin.l.b.a.b.d.a.c)localObject3).g((kotlin.l.b.a.b.b.a.c)localObject1);
          break label210;
          label243:
          i = 0;
          break label219;
          label248:
          paramg = null;
        }
        label253:
        paramg = kotlin.l.b.a.b.d.a.f.i.a(((n)localObject4).aiOM, paramg.krU());
        Object localObject5 = ((n)localObject4).aiON;
        boolean bool1 = ((n)localObject4).aiOO;
        boolean bool2 = ((n)localObject4).aiOP;
        kotlin.g.b.s.u(paramg, "nullabilityQualifier");
        kotlin.g.b.s.u(localObject5, "qualifierApplicabilityTypes");
        paramg = new n(paramg, (Collection)localObject5, bool1, bool2);
        break label118;
        paramg = ((kotlin.l.b.a.b.d.a.c)localObject3).e((kotlin.l.b.a.b.b.a.c)localObject1);
        if (paramg == null)
        {
          paramg = null;
        }
        else
        {
          localObject5 = paramg.aiOq;
          localObject4 = paramg.component2();
          localObject1 = ((kotlin.l.b.a.b.d.a.c)localObject3).h((kotlin.l.b.a.b.b.a.c)localObject1);
          paramg = (kotlin.l.b.a.b.b.a.g)localObject1;
          if (localObject1 == null) {
            paramg = ((kotlin.l.b.a.b.d.a.c)localObject3).g((kotlin.l.b.a.b.b.a.c)localObject5);
          }
          if (paramg.eDZ())
          {
            paramg = null;
          }
          else
          {
            bool1 = paramh.aiSp.aiSa.ksi();
            localObject1 = paramh.aiSp.aiRY.a((kotlin.l.b.a.b.b.a.c)localObject5, bool1, false);
            if (localObject1 == null) {}
            for (paramg = null;; paramg = kotlin.l.b.a.b.d.a.f.i.a((kotlin.l.b.a.b.d.a.f.i)localObject1, paramg.krU()))
            {
              if (paramg != null) {
                break label440;
              }
              paramg = null;
              break;
            }
            paramg = new n(paramg, (Collection)localObject4);
          }
        }
      }
    }
    label440:
    localObject2 = (List)localObject2;
    if (((List)localObject2).isEmpty())
    {
      paramh = paramh.ksj();
      AppMethodBeat.o(192129);
      return paramh;
    }
    paramg = paramh.ksj();
    if (paramg == null) {
      paramg = null;
    }
    for (;;)
    {
      localObject1 = paramg;
      if (paramg == null) {
        localObject1 = new EnumMap(kotlin.l.b.a.b.d.a.a.class);
      }
      paramg = ((List)localObject2).iterator();
      i = 0;
      while (paramg.hasNext())
      {
        localObject2 = (n)paramg.next();
        localIterator = ((n)localObject2).aiON.iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (kotlin.l.b.a.b.d.a.a)localIterator.next();
          ((Map)localObject1).put(localObject3, localObject2);
          i = 1;
        }
      }
      paramg = paramg.aiPj;
      if (paramg == null) {
        paramg = null;
      } else {
        paramg = new EnumMap(paramg);
      }
    }
    if (i == 0)
    {
      paramh = paramh.ksj();
      AppMethodBeat.o(192129);
      return paramh;
    }
    paramh = new t((EnumMap)localObject1);
    AppMethodBeat.o(192129);
    return paramh;
  }
  
  public static final h b(h paramh, final kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(57741);
    kotlin.g.b.s.u(paramh, "<this>");
    kotlin.g.b.s.u(paramg, "additionalAnnotations");
    if (paramg.isEmpty())
    {
      AppMethodBeat.o(57741);
      return paramh;
    }
    paramh = new h(paramh.aiSp, paramh.aiSq, k.a(o.aiuH, (kotlin.g.a.a)new b(paramh, paramg)));
    AppMethodBeat.o(57741);
    return paramh;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<t>
  {
    a(h paramh, kotlin.l.b.a.b.b.g paramg)
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements kotlin.g.a.a<t>
  {
    b(h paramh, kotlin.l.b.a.b.b.a.g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a
 * JD-Core Version:    0.7.0.1
 */