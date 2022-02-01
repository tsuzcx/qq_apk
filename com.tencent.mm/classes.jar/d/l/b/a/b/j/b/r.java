package d.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
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
  extends g<b>
{
  public static final a NTN;
  
  static
  {
    AppMethodBeat.i(60106);
    NTN = new a((byte)0);
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
    this((b)new r.b.b(paramf));
    AppMethodBeat.i(60104);
    AppMethodBeat.o(60104);
  }
  
  public r(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(60103);
    AppMethodBeat.o(60103);
  }
  
  private ab c(y paramy)
  {
    AppMethodBeat.i(60102);
    p.h(paramy, "module");
    Object localObject1 = (b)getValue();
    if ((localObject1 instanceof r.b.a))
    {
      paramy = ((r.b.a)getValue()).NlK;
      AppMethodBeat.o(60102);
      return paramy;
    }
    if ((localObject1 instanceof r.b.b))
    {
      Object localObject2 = ((r.b.b)getValue()).NTO;
      localObject1 = ((f)localObject2).NpB;
      int j = ((f)localObject2).NTx;
      localObject2 = s.b(paramy, (d.l.b.a.b.f.a)localObject1);
      if (localObject2 == null)
      {
        paramy = u.bey("Unresolved type: " + localObject1 + " (arrayDimensions=" + j + ')');
        p.g(paramy, "ErrorUtils.createErrorTy…sions=$arrayDimensions)\")");
        paramy = (ab)paramy;
        AppMethodBeat.o(60102);
        return paramy;
      }
      localObject1 = ((e)localObject2).gne();
      p.g(localObject1, "descriptor.defaultType");
      localObject1 = d.l.b.a.b.m.d.a.aP((ab)localObject1);
      int i = 0;
      while (i < j)
      {
        localObject1 = paramy.gnF().a(bh.NZW, (ab)localObject1);
        p.g(localObject1, "module.builtIns.getArray…Variance.INVARIANT, type)");
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
    p.h(paramy, "module");
    Object localObject = d.l.b.a.b.b.a.g.NsU;
    localObject = d.l.b.a.b.b.a.g.a.gon();
    e locale = paramy.gnF().a(d.l.b.a.b.a.g.Nng.Nol.gvM());
    if (locale == null) {
      d.l.b.a.b.a.g.ajW(19);
    }
    p.g(locale, "module.builtIns.kClass");
    paramy = (ab)ac.a((d.l.b.a.b.b.a.g)localObject, locale, j.listOf(new ax(c(paramy))));
    AppMethodBeat.o(60101);
    return paramy;
  }
  
  public static final class a
  {
    public static g<?> af(ab paramab)
    {
      AppMethodBeat.i(60092);
      p.h(paramab, "argumentType");
      if (ad.aq(paramab))
      {
        AppMethodBeat.o(60092);
        return null;
      }
      int i = 0;
      Object localObject = paramab;
      while (d.l.b.a.b.a.g.m((ab)localObject))
      {
        localObject = ((av)j.jp(((ab)localObject).gxy())).gnW();
        p.g(localObject, "type.arguments.single().type");
        i += 1;
      }
      localObject = ((ab)localObject).gxB().gmq();
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
        paramab = d.l.b.a.b.f.a.p(d.l.b.a.b.a.g.Nng.Nnk.gvM());
        p.g(paramab, "ClassId.topLevel(KotlinB…ns.FQ_NAMES.any.toSafe())");
        paramab = (g)new r(paramab, 0);
        AppMethodBeat.o(60092);
        return paramab;
      }
      AppMethodBeat.o(60092);
      return null;
    }
  }
  
  public static abstract class b
  {
    public static final class a
      extends r.b
    {
      public final ab NlK;
      
      public a(ab paramab)
      {
        super();
        AppMethodBeat.i(60093);
        this.NlK = paramab;
        AppMethodBeat.o(60093);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(60096);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (!p.i(this.NlK, paramObject.NlK)) {}
          }
        }
        else
        {
          AppMethodBeat.o(60096);
          return true;
        }
        AppMethodBeat.o(60096);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(60095);
        ab localab = this.NlK;
        if (localab != null)
        {
          int i = localab.hashCode();
          AppMethodBeat.o(60095);
          return i;
        }
        AppMethodBeat.o(60095);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(60094);
        String str = "LocalClass(type=" + this.NlK + ")";
        AppMethodBeat.o(60094);
        return str;
      }
    }
    
    public static final class b
      extends r.b
    {
      public final f NTO;
      
      public b(f paramf)
      {
        super();
        AppMethodBeat.i(60097);
        this.NTO = paramf;
        AppMethodBeat.o(60097);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(60100);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if (!p.i(this.NTO, paramObject.NTO)) {}
          }
        }
        else
        {
          AppMethodBeat.o(60100);
          return true;
        }
        AppMethodBeat.o(60100);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(60099);
        f localf = this.NTO;
        if (localf != null)
        {
          int i = localf.hashCode();
          AppMethodBeat.o(60099);
          return i;
        }
        AppMethodBeat.o(60099);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(60098);
        String str = "NormalClass(value=" + this.NTO + ")";
        AppMethodBeat.o(60098);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.r
 * JD-Core Version:    0.7.0.1
 */