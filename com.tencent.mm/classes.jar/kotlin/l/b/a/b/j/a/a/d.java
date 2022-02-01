package kotlin.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.l.e;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ag;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.n;

public final class d
{
  public static final boolean T(ad paramad)
  {
    AppMethodBeat.i(60035);
    s.u(paramad, "<this>");
    boolean bool = paramad.kzm() instanceof b;
    AppMethodBeat.o(60035);
    return bool;
  }
  
  static final az a(az paramaz, ba paramba)
  {
    AppMethodBeat.i(60037);
    if ((paramba == null) || (paramaz.kAN() == bl.ajqM))
    {
      AppMethodBeat.o(60037);
      return paramaz;
    }
    if (paramba.kom() == paramaz.kAN())
    {
      if (paramaz.kAM())
      {
        paramba = e.ajos;
        s.s(paramba, "NO_LOCKS");
        paramaz = (az)new bb((ad)new ag(paramba, (kotlin.g.a.a)new a(paramaz)));
        AppMethodBeat.o(60037);
        return paramaz;
      }
      paramaz = (az)new bb(paramaz.koG());
      AppMethodBeat.o(60037);
      return paramaz;
    }
    paramaz = (az)new bb(b(paramaz));
    AppMethodBeat.o(60037);
    return paramaz;
  }
  
  private static ad b(az paramaz)
  {
    AppMethodBeat.i(60034);
    s.u(paramaz, "typeProjection");
    paramaz = (ad)new a(paramaz);
    AppMethodBeat.o(60034);
    return paramaz;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<ad>
  {
    a(az paramaz)
    {
      super();
    }
  }
  
  public static final class b
    extends n
  {
    b(bc parambc)
    {
      super();
    }
    
    public final az G(ad paramad)
    {
      AppMethodBeat.i(60033);
      s.u(paramad, "key");
      az localaz = super.G(paramad);
      if (localaz == null)
      {
        AppMethodBeat.o(60033);
        return null;
      }
      paramad = paramad.kzm().knA();
      if ((paramad instanceof ba)) {}
      for (paramad = (ba)paramad;; paramad = null)
      {
        paramad = d.a(localaz, paramad);
        AppMethodBeat.o(60033);
        return paramad;
      }
    }
    
    public final boolean kzo()
    {
      return this.ajjA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a.a.d
 * JD-Core Version:    0.7.0.1
 */