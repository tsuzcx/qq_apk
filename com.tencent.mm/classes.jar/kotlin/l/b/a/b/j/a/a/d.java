package kotlin.l.b.a.b.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.m;

public final class d
{
  static final av a(av paramav, as paramas)
  {
    AppMethodBeat.i(60037);
    if ((paramas == null) || (paramav.iQa() == bh.abrp))
    {
      AppMethodBeat.o(60037);
      return paramav;
    }
    if (paramas.iEW() == paramav.iQa())
    {
      if (paramav.iPZ())
      {
        paramas = kotlin.l.b.a.b.l.b.abpp;
        p.j(paramas, "LockBasedStorageManager.NO_LOCKS");
        paramav = (av)new ax((ab)new ae(paramas, (kotlin.g.a.a)new a(paramav)));
        AppMethodBeat.o(60037);
        return paramav;
      }
      paramav = (av)new ax(paramav.iFN());
      AppMethodBeat.o(60037);
      return paramav;
    }
    paramav = (av)new ax(b(paramav));
    AppMethodBeat.o(60037);
    return paramav;
  }
  
  public static final boolean ad(ab paramab)
  {
    AppMethodBeat.i(60035);
    p.k(paramab, "$this$isCaptured");
    boolean bool = paramab.iOU() instanceof b;
    AppMethodBeat.o(60035);
    return bool;
  }
  
  private static ab b(av paramav)
  {
    AppMethodBeat.i(60034);
    p.k(paramav, "typeProjection");
    paramav = (ab)new a(paramav);
    AppMethodBeat.o(60034);
    return paramav;
  }
  
  static final class a
    extends q
    implements kotlin.g.a.a<ab>
  {
    a(av paramav)
    {
      super();
    }
  }
  
  public static final class b
    extends m
  {
    b(ay paramay1, ay paramay2)
    {
      super();
    }
    
    public final av N(ab paramab)
    {
      Object localObject = null;
      AppMethodBeat.i(60033);
      p.k(paramab, "key");
      av localav = super.N(paramab);
      if (localav != null)
      {
        paramab = paramab.iOU().iEf();
        if ((paramab instanceof as)) {
          break label65;
        }
        paramab = localObject;
      }
      label65:
      for (;;)
      {
        paramab = d.a(localav, (as)paramab);
        AppMethodBeat.o(60033);
        return paramab;
        AppMethodBeat.o(60033);
        return null;
      }
    }
    
    public final boolean iOW()
    {
      return this.abkV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.a.a.d
 * JD-Core Version:    0.7.0.1
 */