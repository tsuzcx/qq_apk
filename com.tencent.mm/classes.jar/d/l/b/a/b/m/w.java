package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.as;
import d.l.b.a.b.i.c;
import d.l.b.a.b.m.d.a;
import d.m;

public final class w
  extends v
  implements k
{
  public static final a NBY;
  public static boolean NBk;
  private boolean NBX;
  
  static
  {
    AppMethodBeat.i(60738);
    NBY = new a((byte)0);
    AppMethodBeat.o(60738);
  }
  
  public w(aj paramaj1, aj paramaj2)
  {
    super(paramaj1, paramaj2);
    AppMethodBeat.i(60737);
    AppMethodBeat.o(60737);
  }
  
  private v c(d.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60734);
    p.h(parami, "kotlinTypeRefiner");
    Object localObject = parami.aL((ab)this.NBV);
    if (localObject == null)
    {
      parami = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60734);
      throw parami;
    }
    localObject = (aj)localObject;
    parami = parami.aL((ab)this.NBW);
    if (parami == null)
    {
      parami = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60734);
      throw parami;
    }
    parami = (v)new w((aj)localObject, (aj)parami);
    AppMethodBeat.o(60734);
    return parami;
  }
  
  public final bg Ab(boolean paramBoolean)
  {
    AppMethodBeat.i(60733);
    bg localbg = ac.a(this.NBV.Ac(paramBoolean), this.NBW.Ac(paramBoolean));
    AppMethodBeat.o(60733);
    return localbg;
  }
  
  public final ab R(ab paramab)
  {
    AppMethodBeat.i(60730);
    p.h(paramab, "replacement");
    bg localbg = paramab.gua();
    if ((localbg instanceof v)) {}
    for (paramab = localbg;; paramab = ac.a((aj)localbg, ((aj)localbg).Ac(true)))
    {
      paramab = (ab)be.a(paramab, (ab)localbg);
      AppMethodBeat.o(60730);
      return paramab;
      if (!(localbg instanceof aj)) {
        break;
      }
    }
    paramab = new m();
    AppMethodBeat.o(60730);
    throw paramab;
  }
  
  public final String a(c paramc, d.l.b.a.b.i.i parami)
  {
    AppMethodBeat.i(60732);
    p.h(paramc, "renderer");
    p.h(parami, "options");
    if (parami.gsr())
    {
      paramc = "(" + paramc.b((ab)this.NBV) + ".." + paramc.b((ab)this.NBW) + ')';
      AppMethodBeat.o(60732);
      return paramc;
    }
    paramc = paramc.a(paramc.b((ab)this.NBV), paramc.b((ab)this.NBW), a.aN(this));
    AppMethodBeat.o(60732);
    return paramc;
  }
  
  public final bg b(d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60731);
    p.h(paramg, "newAnnotations");
    paramg = ac.a(this.NBV.d(paramg), this.NBW.d(paramg));
    AppMethodBeat.o(60731);
    return paramg;
  }
  
  public final aj glS()
  {
    int j = 1;
    AppMethodBeat.i(60728);
    if ((!NBk) || (this.NBX)) {}
    boolean bool;
    do
    {
      localObject = this.NBV;
      AppMethodBeat.o(60728);
      return localObject;
      this.NBX = true;
      if (!y.am((ab)this.NBV)) {}
      for (int i = 1; (d.ac.MKp) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Lower bound of a flexible type can not be flexible: " + this.NBV);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      if (!y.am((ab)this.NBW)) {}
      for (i = j; (d.ac.MKp) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Upper bound of a flexible type can not be flexible: " + this.NBW);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      bool = p.i(this.NBV, this.NBW);
      if ((d.ac.MKp) && (!(bool ^ true)))
      {
        localObject = (Throwable)new AssertionError("Lower and upper bounds are equal: " + this.NBV + " == " + this.NBW);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      bool = d.l.b.a.b.m.a.g.NDb.c((ab)this.NBV, (ab)this.NBW);
    } while ((!d.ac.MKp) || (bool));
    Object localObject = (Throwable)new AssertionError("Lower bound " + this.NBV + " of a flexible type must be a subtype of the upper bound " + this.NBW);
    AppMethodBeat.o(60728);
    throw ((Throwable)localObject);
  }
  
  public final boolean glV()
  {
    AppMethodBeat.i(60729);
    if (((this.NBV.gsZ().ghO() instanceof as)) && (p.i(this.NBV.gsZ(), this.NBW.gsZ())))
    {
      AppMethodBeat.o(60729);
      return true;
    }
    AppMethodBeat.o(60729);
    return false;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.m.w
 * JD-Core Version:    0.7.0.1
 */