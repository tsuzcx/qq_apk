package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.l.b.a.b.b.as;
import d.l.b.a.b.b.e;
import d.l.b.a.b.b.h;
import d.l.b.a.b.b.s;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.c;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.ac;
import d.l.b.a.b.m.ad;
import d.l.b.a.b.m.at;
import d.l.b.a.b.m.av;
import d.l.b.a.b.m.ax;
import d.l.b.a.b.m.bh;
import d.l.b.a.b.m.u;
import d.m;

public final class r
  extends g<r.b>
{
  public static final a JSq;
  
  static
  {
    AppMethodBeat.i(60106);
    JSq = new a((byte)0);
    AppMethodBeat.o(60106);
  }
  
  public r(d.l.b.a.b.f.a parama, int paramInt)
  {
    this(new f(parama, paramInt));
    AppMethodBeat.i(60105);
    AppMethodBeat.o(60105);
  }
  
  public r(f paramf)
  {
    this((r.b)new r.b.b(paramf));
    AppMethodBeat.i(60104);
    AppMethodBeat.o(60104);
  }
  
  public r(r.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(60103);
    AppMethodBeat.o(60103);
  }
  
  private ab c(y paramy)
  {
    AppMethodBeat.i(60102);
    k.h(paramy, "module");
    Object localObject1 = (r.b)getValue();
    if ((localObject1 instanceof r.b.a))
    {
      paramy = ((r.b.a)getValue()).Jko;
      AppMethodBeat.o(60102);
      return paramy;
    }
    if ((localObject1 instanceof r.b.b))
    {
      Object localObject2 = ((r.b.b)getValue()).JSr;
      localObject1 = ((f)localObject2).Joh;
      int j = ((f)localObject2).JSa;
      localObject2 = s.b(paramy, (d.l.b.a.b.f.a)localObject1);
      if (localObject2 == null)
      {
        paramy = u.aQS("Unresolved type: " + localObject1 + " (arrayDimensions=" + j + ')');
        k.g(paramy, "ErrorUtils.createErrorTy…sions=$arrayDimensions)\")");
        paramy = (ab)paramy;
        AppMethodBeat.o(60102);
        return paramy;
      }
      localObject1 = ((e)localObject2).fyA();
      k.g(localObject1, "descriptor.defaultType");
      localObject1 = d.l.b.a.b.m.d.a.aP((ab)localObject1);
      int i = 0;
      while (i < j)
      {
        localObject1 = paramy.fza().a(bh.JYC, (ab)localObject1);
        k.g(localObject1, "module.builtIns.getArray…Variance.INVARIANT, type)");
        localObject1 = (ab)localObject1;
        i += 1;
      }
      AppMethodBeat.o(60102);
      return localObject1;
    }
    paramy = new m();
    AppMethodBeat.o(60102);
    throw paramy;
  }
  
  public final ab b(y paramy)
  {
    AppMethodBeat.i(60101);
    k.h(paramy, "module");
    Object localObject = d.l.b.a.b.b.a.g.JrB;
    localObject = d.l.b.a.b.b.a.g.a.fzI();
    e locale = paramy.fza().a(d.l.b.a.b.a.g.JlM.JmR.fHh());
    if (locale == null) {
      d.l.b.a.b.a.g.adP(19);
    }
    k.g(locale, "module.builtIns.kClass");
    paramy = (ab)ac.a((d.l.b.a.b.b.a.g)localObject, locale, j.listOf(new ax(c(paramy))));
    AppMethodBeat.o(60101);
    return paramy;
  }
  
  public static final class a
  {
    public static g<?> af(ab paramab)
    {
      AppMethodBeat.i(60092);
      k.h(paramab, "argumentType");
      if (ad.aq(paramab))
      {
        AppMethodBeat.o(60092);
        return null;
      }
      int i = 0;
      Object localObject = paramab;
      while (d.l.b.a.b.a.g.m((ab)localObject))
      {
        localObject = ((av)j.iC(((ab)localObject).fIT())).fzr();
        k.g(localObject, "type.arguments.single().type");
        i += 1;
      }
      localObject = ((ab)localObject).fIW().fxM();
      if ((localObject instanceof e))
      {
        localObject = d.l.b.a.b.j.d.a.c((h)localObject);
        if (localObject == null)
        {
          paramab = (g)new r((r.b)new r.b.a(paramab));
          AppMethodBeat.o(60092);
          return paramab;
        }
        paramab = (g)new r((d.l.b.a.b.f.a)localObject, i);
        AppMethodBeat.o(60092);
        return paramab;
      }
      if ((localObject instanceof as))
      {
        paramab = d.l.b.a.b.f.a.p(d.l.b.a.b.a.g.JlM.JlQ.fHh());
        k.g(paramab, "ClassId.topLevel(KotlinB…ns.FQ_NAMES.any.toSafe())");
        paramab = (g)new r(paramab, 0);
        AppMethodBeat.o(60092);
        return paramab;
      }
      AppMethodBeat.o(60092);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.b.r
 * JD-Core Version:    0.7.0.1
 */