package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.a.k.a;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.v;

public final class q
  extends g<q.b>
{
  public static final a ajjS;
  
  static
  {
    AppMethodBeat.i(60106);
    ajjS = new a((byte)0);
    AppMethodBeat.o(60106);
  }
  
  public q(b paramb, int paramInt)
  {
    this(new f(paramb, paramInt));
    AppMethodBeat.i(60105);
    AppMethodBeat.o(60105);
  }
  
  public q(f paramf)
  {
    this((q.b)new q.b.b(paramf));
    AppMethodBeat.i(60104);
    AppMethodBeat.o(60104);
  }
  
  public q(q.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(60103);
    AppMethodBeat.o(60103);
  }
  
  private ad d(kotlin.l.b.a.b.b.ae paramae)
  {
    AppMethodBeat.i(60102);
    s.u(paramae, "module");
    Object localObject1 = (q.b)getValue();
    if ((localObject1 instanceof q.b.a))
    {
      paramae = ((q.b.a)getValue()).aiAd;
      AppMethodBeat.o(60102);
      return paramae;
    }
    if ((localObject1 instanceof q.b.b))
    {
      Object localObject2 = ((q.b.b)getValue()).ajjT;
      localObject1 = ((f)localObject2).aiEe;
      int j = ((f)localObject2).ajjD;
      localObject2 = w.b(paramae, (b)localObject1);
      if (localObject2 == null)
      {
        paramae = v.bJt("Unresolved type: " + localObject1 + " (arrayDimensions=" + j + ')');
        s.s(paramae, "createErrorType(\"Unresol…sions=$arrayDimensions)\")");
        paramae = (ad)paramae;
        AppMethodBeat.o(60102);
        return paramae;
      }
      localObject1 = ((e)localObject2).koj();
      s.s(localObject1, "descriptor.defaultType");
      localObject1 = kotlin.l.b.a.b.m.d.a.aG((ad)localObject1);
      int i = 0;
      while (i < j)
      {
        localObject1 = paramae.koV().a(bl.ajqM, (ad)localObject1);
        s.s(localObject1, "module.builtIns.getArray…Variance.INVARIANT, type)");
        i += 1;
      }
      paramae = (ad)localObject1;
      AppMethodBeat.o(60102);
      return paramae;
    }
    paramae = new kotlin.p();
    AppMethodBeat.o(60102);
    throw paramae;
  }
  
  public final ad c(kotlin.l.b.a.b.b.ae paramae)
  {
    AppMethodBeat.i(60101);
    s.u(paramae, "module");
    Object localObject = kotlin.l.b.a.b.b.a.g.aiIh;
    localObject = g.a.kpB();
    e locale = paramae.koV().a(k.a.aiDA.kxX());
    if (locale == null) {
      kotlin.l.b.a.b.a.h.aKu(21);
    }
    s.s(locale, "module.builtIns.kClass");
    paramae = (ad)kotlin.l.b.a.b.m.ae.a((kotlin.l.b.a.b.b.a.g)localObject, locale, kotlin.a.p.listOf(new bb(d(paramae))));
    AppMethodBeat.o(60101);
    return paramae;
  }
  
  public static final class a
  {
    public static g<?> U(ad paramad)
    {
      AppMethodBeat.i(60092);
      s.u(paramad, "argumentType");
      if (af.ai(paramad))
      {
        AppMethodBeat.o(60092);
        return null;
      }
      int i = 0;
      Object localObject = paramad;
      while (kotlin.l.b.a.b.a.h.m((ad)localObject))
      {
        localObject = ((az)kotlin.a.p.oO(((ad)localObject).klR())).koG();
        s.s(localObject, "type.arguments.single().type");
        i += 1;
      }
      localObject = ((ad)localObject).kzm().knA();
      if ((localObject instanceof e))
      {
        localObject = kotlin.l.b.a.b.j.d.a.d((kotlin.l.b.a.b.b.h)localObject);
        if (localObject == null)
        {
          paramad = (g)new q((q.b)new q.b.a(paramad));
          AppMethodBeat.o(60092);
          return paramad;
        }
        paramad = (g)new q((b)localObject, i);
        AppMethodBeat.o(60092);
        return paramad;
      }
      if ((localObject instanceof ba))
      {
        paramad = b.s(k.a.aiCy.kxX());
        s.s(paramad, "topLevel(StandardNames.FqNames.any.toSafe())");
        paramad = (g)new q(paramad, 0);
        AppMethodBeat.o(60092);
        return paramad;
      }
      AppMethodBeat.o(60092);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.q
 * JD-Core Version:    0.7.0.1
 */