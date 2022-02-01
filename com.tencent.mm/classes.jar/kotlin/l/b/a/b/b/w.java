package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.s;
import kotlin.l.b.a.b.c.a.d;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.n;
import kotlin.m.k;

public final class w
{
  public static final e a(ae paramae, kotlin.l.b.a.b.f.b paramb, ag paramag)
  {
    AppMethodBeat.i(56858);
    s.u(paramae, "<this>");
    s.u(paramb, "classId");
    s.u(paramag, "notFoundClasses");
    paramae = b(paramae, paramb);
    if (paramae != null)
    {
      AppMethodBeat.o(56858);
      return paramae;
    }
    paramae = paramag.a(paramb, k.d(k.d(k.b(paramb, (kotlin.g.a.b)a.aiGT), (kotlin.g.a.b)w.b.aiGU)));
    AppMethodBeat.o(56858);
    return paramae;
  }
  
  public static final h a(ae paramae, kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56856);
    s.u(paramae, "<this>");
    s.u(paramb, "classId");
    Object localObject1 = n.b(paramae);
    if (localObject1 == null)
    {
      localObject1 = paramb.kxL();
      s.s(localObject1, "classId.packageFqName");
      paramae = paramae.e((c)localObject1);
      paramb = paramb.kxM().kxV();
      s.s(paramb, "classId.relativeClassName.pathSegments()");
      paramae = paramae.knP();
      localObject1 = kotlin.a.p.oK(paramb);
      s.s(localObject1, "segments.first()");
      paramae = paramae.c((f)localObject1, (kotlin.l.b.a.b.c.a.b)d.aiNM);
      if (paramae == null)
      {
        AppMethodBeat.o(56856);
        return null;
      }
      paramb = paramb.subList(1, paramb.size()).iterator();
      while (paramb.hasNext())
      {
        localObject1 = (f)paramb.next();
        if (!(paramae instanceof e))
        {
          AppMethodBeat.o(56856);
          return null;
        }
        paramae = ((e)paramae).kou();
        s.s(localObject1, "name");
        paramae = paramae.c((f)localObject1, (kotlin.l.b.a.b.c.a.b)d.aiNM);
        if ((paramae instanceof e)) {}
        for (paramae = (e)paramae; paramae == null; paramae = null)
        {
          AppMethodBeat.o(56856);
          return null;
        }
        paramae = (h)paramae;
      }
      AppMethodBeat.o(56856);
      return paramae;
    }
    Object localObject2 = paramb.kxL();
    s.s(localObject2, "classId.packageFqName");
    localObject2 = ((ae)localObject1).e((c)localObject2);
    localObject1 = paramb.kxM().kxV();
    s.s(localObject1, "classId.relativeClassName.pathSegments()");
    localObject2 = ((al)localObject2).knP();
    Object localObject3 = kotlin.a.p.oK((List)localObject1);
    s.s(localObject3, "segments.first()");
    localObject2 = ((kotlin.l.b.a.b.j.g.h)localObject2).c((f)localObject3, (kotlin.l.b.a.b.c.a.b)d.aiNM);
    if (localObject2 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label634;
      }
      localObject1 = paramb.kxL();
      s.s(localObject1, "classId.packageFqName");
      paramae = paramae.e((c)localObject1);
      paramb = paramb.kxM().kxV();
      s.s(paramb, "classId.relativeClassName.pathSegments()");
      paramae = paramae.knP();
      localObject1 = kotlin.a.p.oK(paramb);
      s.s(localObject1, "segments.first()");
      paramae = paramae.c((f)localObject1, (kotlin.l.b.a.b.c.a.b)d.aiNM);
      if (paramae == null)
      {
        AppMethodBeat.o(56856);
        return null;
      }
    }
    else
    {
      localObject3 = ((List)localObject1).subList(1, ((List)localObject1).size()).iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (f)((Iterator)localObject3).next();
        if (!(localObject2 instanceof e))
        {
          localObject1 = null;
          break;
        }
        localObject2 = ((e)localObject2).kou();
        s.s(localObject1, "name");
        localObject1 = ((kotlin.l.b.a.b.j.g.h)localObject2).c((f)localObject1, (kotlin.l.b.a.b.c.a.b)d.aiNM);
        if ((localObject1 instanceof e)) {}
        for (localObject1 = (e)localObject1;; localObject1 = null)
        {
          if (localObject1 != null) {
            break label501;
          }
          localObject1 = null;
          break;
        }
        label501:
        localObject2 = (h)localObject1;
      }
    }
    paramb = paramb.subList(1, paramb.size()).iterator();
    while (paramb.hasNext())
    {
      localObject1 = (f)paramb.next();
      if (!(paramae instanceof e))
      {
        AppMethodBeat.o(56856);
        return null;
      }
      paramae = ((e)paramae).kou();
      s.s(localObject1, "name");
      paramae = paramae.c((f)localObject1, (kotlin.l.b.a.b.c.a.b)d.aiNM);
      if ((paramae instanceof e)) {}
      for (paramae = (e)paramae; paramae == null; paramae = null)
      {
        AppMethodBeat.o(56856);
        return null;
      }
      paramae = (h)paramae;
    }
    AppMethodBeat.o(56856);
    return paramae;
    label634:
    AppMethodBeat.o(56856);
    return localObject1;
  }
  
  public static final e b(ae paramae, kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56857);
    s.u(paramae, "<this>");
    s.u(paramb, "classId");
    paramae = a(paramae, paramb);
    if ((paramae instanceof e))
    {
      paramae = (e)paramae;
      AppMethodBeat.o(56857);
      return paramae;
    }
    AppMethodBeat.o(56857);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.w
 * JD-Core Version:    0.7.0.1
 */