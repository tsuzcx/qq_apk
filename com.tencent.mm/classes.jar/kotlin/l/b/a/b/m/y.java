package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.i.f;
import kotlin.l.b.a.b.m.a.e;
import kotlin.l.b.a.b.m.d.a;
import kotlin.p;

public final class y
  extends x
  implements l
{
  public static boolean ajoT;
  public static final y.a ajpG;
  private boolean ajpH;
  
  static
  {
    AppMethodBeat.i(60738);
    ajpG = new y.a((byte)0);
    AppMethodBeat.o(60738);
  }
  
  public y(al paramal1, al paramal2)
  {
    super(paramal1, paramal2);
    AppMethodBeat.i(60737);
    AppMethodBeat.o(60737);
  }
  
  private x d(kotlin.l.b.a.b.m.a.g paramg)
  {
    AppMethodBeat.i(60734);
    s.u(paramg, "kotlinTypeRefiner");
    paramg = (x)new y((al)paramg.aD((ad)this.ajpE), (al)paramg.aD((ad)this.ajpF));
    AppMethodBeat.o(60734);
    return paramg;
  }
  
  public final ad H(ad paramad)
  {
    AppMethodBeat.i(60730);
    s.u(paramad, "replacement");
    bk localbk = paramad.kAK();
    if ((localbk instanceof x)) {}
    for (paramad = localbk;; paramad = ae.a((al)localbk, ((al)localbk).Pq(true)))
    {
      paramad = (ad)bi.a(paramad, (ad)localbk);
      AppMethodBeat.o(60730);
      return paramad;
      if (!(localbk instanceof al)) {
        break;
      }
    }
    paramad = new p();
    AppMethodBeat.o(60730);
    throw paramad;
  }
  
  public final bk Pp(boolean paramBoolean)
  {
    AppMethodBeat.i(60733);
    bk localbk = ae.a(this.ajpE.Pq(paramBoolean), this.ajpF.Pq(paramBoolean));
    AppMethodBeat.o(60733);
    return localbk;
  }
  
  public final String a(c paramc, f paramf)
  {
    AppMethodBeat.i(60732);
    s.u(paramc, "renderer");
    s.u(paramf, "options");
    if (paramf.kyH())
    {
      paramc = "(" + paramc.b((ad)this.ajpE) + ".." + paramc.b((ad)this.ajpF) + ')';
      AppMethodBeat.o(60732);
      return paramc;
    }
    paramc = paramc.a(paramc.b((ad)this.ajpE), paramc.b((ad)this.ajpF), a.aE((ad)this));
    AppMethodBeat.o(60732);
    return paramc;
  }
  
  public final bk b(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(60731);
    s.u(paramg, "newAnnotations");
    paramg = ae.a(this.ajpE.d(paramg), this.ajpF.d(paramg));
    AppMethodBeat.o(60731);
    return paramg;
  }
  
  public final boolean ksA()
  {
    AppMethodBeat.i(60729);
    if (((this.ajpE.kzm().knA() instanceof ba)) && (s.p(this.ajpE.kzm(), this.ajpF.kzm())))
    {
      AppMethodBeat.o(60729);
      return true;
    }
    AppMethodBeat.o(60729);
    return false;
  }
  
  public final al ksx()
  {
    int j = 1;
    AppMethodBeat.i(60728);
    if ((!ajoT) || (this.ajpH)) {}
    boolean bool;
    do
    {
      localObject = this.ajpE;
      AppMethodBeat.o(60728);
      return localObject;
      this.ajpH = true;
      if (!aa.ac((ad)this.ajpE)) {}
      for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError(s.X("Lower bound of a flexible type can not be flexible: ", this.ajpE));
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      if (!aa.ac((ad)this.ajpF)) {}
      for (i = 1; (ak.aiuY) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError(s.X("Upper bound of a flexible type can not be flexible: ", this.ajpF));
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      if (!s.p(this.ajpE, this.ajpF)) {}
      for (i = j; (ak.aiuY) && (i == 0); i = 0)
      {
        localObject = (Throwable)new AssertionError("Lower and upper bounds are equal: " + this.ajpE + " == " + this.ajpF);
        AppMethodBeat.o(60728);
        throw ((Throwable)localObject);
      }
      bool = e.ajqY.d((ad)this.ajpE, (ad)this.ajpF);
    } while ((!ak.aiuY) || (bool));
    Object localObject = (Throwable)new AssertionError("Lower bound " + this.ajpE + " of a flexible type must be a subtype of the upper bound " + this.ajpF);
    AppMethodBeat.o(60728);
    throw ((Throwable)localObject);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191634);
    String str = "(" + this.ajpE + ".." + this.ajpF + ')';
    AppMethodBeat.o(191634);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.y
 * JD-Core Version:    0.7.0.1
 */