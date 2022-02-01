package d.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.l.b.a.b.b.as;
import d.l.b.a.b.i.c;
import d.l.b.a.b.m.d.a;
import d.m;

public final class w
  extends v
  implements k
{
  public static boolean LKl;
  public static final a LLd;
  private boolean LLc;
  
  static
  {
    AppMethodBeat.i(60738);
    LLd = new a((byte)0);
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
    d.g.b.k.h(parami, "kotlinTypeRefiner");
    Object localObject = parami.aL((ab)this.LLa);
    if (localObject == null)
    {
      parami = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
      AppMethodBeat.o(60734);
      throw parami;
    }
    localObject = (aj)localObject;
    parami = parami.aL((ab)this.LLb);
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
  
  public final ab R(ab paramab)
  {
    AppMethodBeat.i(60730);
    d.g.b.k.h(paramab, "replacement");
    bg localbg = paramab.gcz();
    if ((localbg instanceof v)) {}
    for (paramab = localbg;; paramab = ac.a((aj)localbg, ((aj)localbg).zo(true)))
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
    d.g.b.k.h(paramc, "renderer");
    d.g.b.k.h(parami, "options");
    if (parami.gaS())
    {
      paramc = "(" + paramc.b((ab)this.LLa) + ".." + paramc.b((ab)this.LLb) + ')';
      AppMethodBeat.o(60732);
      return paramc;
    }
    paramc = paramc.a(paramc.b((ab)this.LLa), paramc.b((ab)this.LLb), a.aN(this));
    AppMethodBeat.o(60732);
    return paramc;
  }
  
  public final bg b(d.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60731);
    d.g.b.k.h(paramg, "newAnnotations");
    paramg = ac.a(this.LLa.d(paramg), this.LLb.d(paramg));
    AppMethodBeat.o(60731);
    return paramg;
  }
  
  public final aj fUt()
  {
    int j = 1;
    AppMethodBeat.i(60728);
    if ((!LKl) || (this.LLc)) {}
    boolean bool;
    do
    {
      localObject = this.LLa;
      AppMethodBeat.o(60728);
      return localObject;
      this.LLc = true;
      if (!y.am((ab)this.LLa)) {}
      for (int i = 1; (aa.KTq) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Lower bound of a flexible type can not be flexible: " + this.LLa);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      if (!y.am((ab)this.LLb)) {}
      for (i = j; (aa.KTq) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Upper bound of a flexible type can not be flexible: " + this.LLb);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      bool = d.g.b.k.g(this.LLa, this.LLb);
      if ((aa.KTq) && (!(bool ^ true)))
      {
        localObject = (Throwable)new AssertionError("Lower and upper bounds are equal: " + this.LLa + " == " + this.LLb);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      bool = d.l.b.a.b.m.a.g.LMg.c((ab)this.LLa, (ab)this.LLb);
    } while ((!aa.KTq) || (bool));
    Object localObject = (Throwable)new AssertionError("Lower bound " + this.LLa + " of a flexible type must be a subtype of the upper bound " + this.LLb);
    AppMethodBeat.o(60728);
    throw ((Throwable)localObject);
  }
  
  public final boolean fUw()
  {
    AppMethodBeat.i(60729);
    if (((this.LLa.gbz().fQq() instanceof as)) && (d.g.b.k.g(this.LLa.gbz(), this.LLb.gbz())))
    {
      AppMethodBeat.o(60729);
      return true;
    }
    AppMethodBeat.o(60729);
    return false;
  }
  
  public final bg zn(boolean paramBoolean)
  {
    AppMethodBeat.i(60733);
    bg localbg = ac.a(this.LLa.zo(paramBoolean), this.LLb.zo(paramBoolean));
    AppMethodBeat.o(60733);
    return localbg;
  }
  
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.m.w
 * JD-Core Version:    0.7.0.1
 */