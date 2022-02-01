package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ad;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.l.m;
import kotlin.n.n;

public final class a
  implements kotlin.l.b.a.b.b.b.b
{
  private final m aiBu;
  private final ae aiEx;
  
  public a(m paramm, ae paramae)
  {
    AppMethodBeat.i(56714);
    this.aiBu = paramm;
    this.aiEx = paramae;
    AppMethodBeat.o(56714);
  }
  
  public final boolean a(kotlin.l.b.a.b.f.c paramc, kotlin.l.b.a.b.f.f paramf)
  {
    AppMethodBeat.i(56711);
    s.u(paramc, "packageFqName");
    s.u(paramf, "name");
    paramf = paramf.PF();
    s.s(paramf, "name.asString()");
    if ((n.U(paramf, "Function", false)) || (n.U(paramf, "KFunction", false)) || (n.U(paramf, "SuspendFunction", false)) || (n.U(paramf, "KSuspendFunction", false)))
    {
      c.a locala = c.aiEH;
      if (c.a.a(paramf, paramc) != null)
      {
        AppMethodBeat.o(56711);
        return true;
      }
    }
    AppMethodBeat.o(56711);
    return false;
  }
  
  public final Collection<e> b(kotlin.l.b.a.b.f.c paramc)
  {
    AppMethodBeat.i(56713);
    s.u(paramc, "packageFqName");
    paramc = (Collection)ad.aivA;
    AppMethodBeat.o(56713);
    return paramc;
  }
  
  public final e b(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56712);
    s.u(paramb, "classId");
    if ((paramb.NIH) || (paramb.kxP()))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    Object localObject1 = paramb.kxM().PF();
    s.s(localObject1, "classId.relativeClassName.asString()");
    if (!n.a((CharSequence)localObject1, (CharSequence)"Function", false))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    paramb = paramb.kxL();
    s.s(paramb, "classId.packageFqName");
    Object localObject2 = c.aiEH;
    localObject2 = c.a.a((String)localObject1, paramb);
    if (localObject2 == null)
    {
      AppMethodBeat.o(56712);
      return null;
    }
    localObject1 = ((c.a.a)localObject2).aiER;
    int i = ((c.a.a)localObject2).arity;
    localObject2 = (Iterable)this.aiEx.e(paramb).getFragments();
    paramb = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof kotlin.l.b.a.b.a.b)) {
        paramb.add(localObject3);
      }
    }
    paramb = (List)paramb;
    Object localObject3 = (Iterable)paramb;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if ((localObject4 instanceof kotlin.l.b.a.b.a.f)) {
        ((Collection)localObject2).add(localObject4);
      }
    }
    localObject2 = (kotlin.l.b.a.b.a.f)p.oL((List)localObject2);
    if (localObject2 == null) {}
    for (paramb = (kotlin.l.b.a.b.a.b)p.oK(paramb);; paramb = (kotlin.l.b.a.b.a.b)localObject2)
    {
      paramb = (e)new b(this.aiBu, (ah)paramb, (c)localObject1, i);
      AppMethodBeat.o(56712);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */