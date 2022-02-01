package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.d.a;
import kotlin.m;
import kotlin.t;
import kotlin.z;

public final class w
  extends v
  implements k
{
  public static boolean abpM;
  public static final a abqy;
  private boolean abqx;
  
  static
  {
    AppMethodBeat.i(60738);
    abqy = new a((byte)0);
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
    p.k(parami, "kotlinTypeRefiner");
    Object localObject = parami.aK((ab)this.abqv);
    if (localObject == null)
    {
      parami = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60734);
      throw parami;
    }
    localObject = (aj)localObject;
    parami = parami.aK((ab)this.abqw);
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
  
  public final bg Jm(boolean paramBoolean)
  {
    AppMethodBeat.i(60733);
    bg localbg = ac.a(this.abqv.Jn(paramBoolean), this.abqw.Jn(paramBoolean));
    AppMethodBeat.o(60733);
    return localbg;
  }
  
  public final ab Q(ab paramab)
  {
    AppMethodBeat.i(60730);
    p.k(paramab, "replacement");
    bg localbg = paramab.iPX();
    if ((localbg instanceof v)) {}
    for (paramab = localbg;; paramab = ac.a((aj)localbg, ((aj)localbg).Jn(true)))
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
    p.k(paramc, "renderer");
    p.k(parami, "options");
    if (parami.iOm())
    {
      paramc = "(" + paramc.b((ab)this.abqv) + ".." + paramc.b((ab)this.abqw) + ')';
      AppMethodBeat.o(60732);
      return paramc;
    }
    paramc = paramc.a(paramc.b((ab)this.abqv), paramc.b((ab)this.abqw), a.aM(this));
    AppMethodBeat.o(60732);
    return paramc;
  }
  
  public final bg b(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60731);
    p.k(paramg, "newAnnotations");
    paramg = ac.a(this.abqv.d(paramg), this.abqw.d(paramg));
    AppMethodBeat.o(60731);
    return paramg;
  }
  
  public final aj iIq()
  {
    int j = 1;
    AppMethodBeat.i(60728);
    if ((!abpM) || (this.abqx)) {}
    boolean bool;
    do
    {
      localObject = this.abqv;
      AppMethodBeat.o(60728);
      return localObject;
      this.abqx = true;
      if (!y.al((ab)this.abqv)) {}
      for (int i = 1; (z.aazO) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Lower bound of a flexible type can not be flexible: " + this.abqv);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      if (!y.al((ab)this.abqw)) {}
      for (i = j; (z.aazO) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Upper bound of a flexible type can not be flexible: " + this.abqw);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      bool = p.h(this.abqv, this.abqw);
      if ((z.aazO) && (!(bool ^ true)))
      {
        localObject = (Throwable)new AssertionError("Lower and upper bounds are equal: " + this.abqv + " == " + this.abqw);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      bool = kotlin.l.b.a.b.m.a.g.abrB.c((ab)this.abqv, (ab)this.abqw);
    } while ((!z.aazO) || (bool));
    Object localObject = (Throwable)new AssertionError("Lower bound " + this.abqv + " of a flexible type must be a subtype of the upper bound " + this.abqw);
    AppMethodBeat.o(60728);
    throw ((Throwable)localObject);
  }
  
  public final boolean iIt()
  {
    AppMethodBeat.i(60729);
    if (((this.abqv.iOU().iEf() instanceof as)) && (p.h(this.abqv.iOU(), this.abqw.iOU())))
    {
      AppMethodBeat.o(60729);
      return true;
    }
    AppMethodBeat.o(60729);
    return false;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.m.w
 * JD-Core Version:    0.7.0.1
 */