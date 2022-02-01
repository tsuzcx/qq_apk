package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.d.a;
import kotlin.m;
import kotlin.t;

public final class w
  extends v
  implements k
{
  public static final a TNY;
  public static boolean TNk;
  private boolean TNX;
  
  static
  {
    AppMethodBeat.i(60738);
    TNY = new a((byte)0);
    AppMethodBeat.o(60738);
  }
  
  public w(aj paramaj1, aj paramaj2)
  {
    super(paramaj1, paramaj2);
    AppMethodBeat.i(60737);
    AppMethodBeat.o(60737);
  }
  
  private v c(kotlin.l.b.a.b.m.a.i parami)
  {
    AppMethodBeat.i(60734);
    p.h(parami, "kotlinTypeRefiner");
    Object localObject = parami.aK((ab)this.TNV);
    if (localObject == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60734);
      throw parami;
    }
    localObject = (aj)localObject;
    parami = parami.aK((ab)this.TNW);
    if (parami == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60734);
      throw parami;
    }
    parami = (v)new w((aj)localObject, (aj)parami);
    AppMethodBeat.o(60734);
    return parami;
  }
  
  public final bg EF(boolean paramBoolean)
  {
    AppMethodBeat.i(60733);
    bg localbg = ac.a(this.TNV.EG(paramBoolean), this.TNW.EG(paramBoolean));
    AppMethodBeat.o(60733);
    return localbg;
  }
  
  public final ab Q(ab paramab)
  {
    AppMethodBeat.i(60730);
    p.h(paramab, "replacement");
    bg localbg = paramab.hLF();
    if ((localbg instanceof v)) {}
    for (paramab = localbg;; paramab = ac.a((aj)localbg, ((aj)localbg).EG(true)))
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
  
  public final String a(c paramc, kotlin.l.b.a.b.i.i parami)
  {
    AppMethodBeat.i(60732);
    p.h(paramc, "renderer");
    p.h(parami, "options");
    if (parami.hJW())
    {
      paramc = "(" + paramc.b((ab)this.TNV) + ".." + paramc.b((ab)this.TNW) + ')';
      AppMethodBeat.o(60732);
      return paramc;
    }
    paramc = paramc.a(paramc.b((ab)this.TNV), paramc.b((ab)this.TNW), a.aM(this));
    AppMethodBeat.o(60732);
    return paramc;
  }
  
  public final bg b(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60731);
    p.h(paramg, "newAnnotations");
    paramg = ac.a(this.TNV.d(paramg), this.TNW.d(paramg));
    AppMethodBeat.o(60731);
    return paramg;
  }
  
  public final aj hDW()
  {
    int j = 1;
    AppMethodBeat.i(60728);
    if ((!TNk) || (this.TNX)) {}
    boolean bool;
    do
    {
      localObject = this.TNV;
      AppMethodBeat.o(60728);
      return localObject;
      this.TNX = true;
      if (!y.al((ab)this.TNV)) {}
      for (int i = 1; (aa.SXc) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Lower bound of a flexible type can not be flexible: " + this.TNV);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      if (!y.al((ab)this.TNW)) {}
      for (i = j; (aa.SXc) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Upper bound of a flexible type can not be flexible: " + this.TNW);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      bool = p.j(this.TNV, this.TNW);
      if ((aa.SXc) && (!(bool ^ true)))
      {
        localObject = (Throwable)new AssertionError("Lower and upper bounds are equal: " + this.TNV + " == " + this.TNW);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      bool = kotlin.l.b.a.b.m.a.g.TPc.c((ab)this.TNV, (ab)this.TNW);
    } while ((!aa.SXc) || (bool));
    Object localObject = (Throwable)new AssertionError("Lower bound " + this.TNV + " of a flexible type must be a subtype of the upper bound " + this.TNW);
    AppMethodBeat.o(60728);
    throw ((Throwable)localObject);
  }
  
  public final boolean hDZ()
  {
    AppMethodBeat.i(60729);
    if (((this.TNV.hKE().hzS() instanceof as)) && (p.j(this.TNV.hKE(), this.TNW.hKE())))
    {
      AppMethodBeat.o(60729);
      return true;
    }
    AppMethodBeat.o(60729);
    return false;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.m.w
 * JD-Core Version:    0.7.0.1
 */