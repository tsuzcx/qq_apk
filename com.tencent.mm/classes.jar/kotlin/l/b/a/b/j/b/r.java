package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;
import kotlin.m;

public final class r
  extends g<r.b>
{
  public static final a ablm;
  
  static
  {
    AppMethodBeat.i(60106);
    ablm = new a((byte)0);
    AppMethodBeat.o(60106);
  }
  
  public r(kotlin.l.b.a.b.f.a parama, int paramInt)
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
    p.k(paramy, "module");
    Object localObject1 = (r.b)getValue();
    if ((localObject1 instanceof r.b.a))
    {
      paramy = ((r.b.a)getValue()).aaEm;
      AppMethodBeat.o(60102);
      return paramy;
    }
    if ((localObject1 instanceof r.b.b))
    {
      Object localObject2 = ((r.b.b)getValue()).abln;
      localObject1 = ((f)localObject2).aaId;
      int j = ((f)localObject2).abkX;
      localObject2 = s.b(paramy, (kotlin.l.b.a.b.f.a)localObject1);
      if (localObject2 == null)
      {
        paramy = u.bHp("Unresolved type: " + localObject1 + " (arrayDimensions=" + j + ')');
        p.j(paramy, "ErrorUtils.createErrorTy…sions=$arrayDimensions)\")");
        paramy = (ab)paramy;
        AppMethodBeat.o(60102);
        return paramy;
      }
      localObject1 = ((e)localObject2).iET();
      p.j(localObject1, "descriptor.defaultType");
      localObject1 = kotlin.l.b.a.b.m.d.a.aO((ab)localObject1);
      int i = 0;
      while (i < j)
      {
        localObject1 = paramy.iFv().a(bh.abrp, (ab)localObject1);
        p.j(localObject1, "module.builtIns.getArray…Variance.INVARIANT, type)");
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
    p.k(paramy, "module");
    Object localObject = kotlin.l.b.a.b.b.a.g.aaLw;
    localObject = kotlin.l.b.a.b.b.a.g.a.iGe();
    e locale = paramy.iFv().a(kotlin.l.b.a.b.a.g.aaFI.aaGN.iND());
    if (locale == null) {
      kotlin.l.b.a.b.a.g.aDG(19);
    }
    p.j(locale, "module.builtIns.kClass");
    paramy = (ab)ac.a((kotlin.l.b.a.b.b.a.g)localObject, locale, j.listOf(new ax(c(paramy))));
    AppMethodBeat.o(60101);
    return paramy;
  }
  
  public static final class a
  {
    public static g<?> ae(ab paramab)
    {
      AppMethodBeat.i(60092);
      p.k(paramab, "argumentType");
      if (ad.ap(paramab))
      {
        AppMethodBeat.o(60092);
        return null;
      }
      int i = 0;
      Object localObject = paramab;
      while (kotlin.l.b.a.b.a.g.m((ab)localObject))
      {
        localObject = ((av)j.ls(((ab)localObject).iOR())).iFN();
        p.j(localObject, "type.arguments.single().type");
        i += 1;
      }
      localObject = ((ab)localObject).iOU().iEf();
      if ((localObject instanceof e))
      {
        localObject = kotlin.l.b.a.b.j.d.a.c((h)localObject);
        if (localObject == null)
        {
          paramab = (g)new r((r.b)new r.b.a(paramab));
          AppMethodBeat.o(60092);
          return paramab;
        }
        paramab = (g)new r((kotlin.l.b.a.b.f.a)localObject, i);
        AppMethodBeat.o(60092);
        return paramab;
      }
      if ((localObject instanceof as))
      {
        paramab = kotlin.l.b.a.b.f.a.p(kotlin.l.b.a.b.a.g.aaFI.aaFM.iND());
        p.j(paramab, "ClassId.topLevel(KotlinB…ns.FQ_NAMES.any.toSafe())");
        paramab = (g)new r(paramab, 0);
        AppMethodBeat.o(60092);
        return paramab;
      }
      AppMethodBeat.o(60092);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.r
 * JD-Core Version:    0.7.0.1
 */