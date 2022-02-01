package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.ai;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bi;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.o;
import kotlin.l.b.a.b.m.x;

public final class g
  extends o
  implements ai
{
  private final al aiUV;
  
  public g(al paramal)
  {
    AppMethodBeat.i(58036);
    this.aiUV = paramal;
    AppMethodBeat.o(58036);
  }
  
  private static al b(al paramal)
  {
    AppMethodBeat.i(58029);
    al localal = paramal.Pq(false);
    if (!a.aA((ad)paramal))
    {
      AppMethodBeat.o(58029);
      return localal;
    }
    paramal = (al)new g(localal);
    AppMethodBeat.o(58029);
    return paramal;
  }
  
  private g c(kotlin.l.b.a.b.b.a.g paramg)
  {
    AppMethodBeat.i(58030);
    s.u(paramg, "newAnnotations");
    paramg = new g(this.aiUV.d(paramg));
    AppMethodBeat.o(58030);
    return paramg;
  }
  
  public final ad H(ad paramad)
  {
    AppMethodBeat.i(58028);
    s.u(paramad, "replacement");
    paramad = paramad.kAK();
    if ((!a.aA((ad)paramad)) && (!bg.aw((ad)paramad)))
    {
      paramad = (ad)paramad;
      AppMethodBeat.o(58028);
      return paramad;
    }
    if ((paramad instanceof al))
    {
      paramad = (ad)b((al)paramad);
      AppMethodBeat.o(58028);
      return paramad;
    }
    if ((paramad instanceof x))
    {
      paramad = (ad)bi.b(ae.a(b(((x)paramad).ajpE), b(((x)paramad).ajpF)), bi.aC((ad)paramad));
      AppMethodBeat.o(58028);
      return paramad;
    }
    paramad = (Throwable)new IllegalStateException(s.X("Incorrect type: ", paramad).toString());
    AppMethodBeat.o(58028);
    throw paramad;
  }
  
  public final al Pq(boolean paramBoolean)
  {
    AppMethodBeat.i(58033);
    if (paramBoolean)
    {
      localal = this.aiUV.Pq(true);
      AppMethodBeat.o(58033);
      return localal;
    }
    al localal = (al)this;
    AppMethodBeat.o(58033);
    return localal;
  }
  
  public final boolean ksA()
  {
    return true;
  }
  
  public final boolean ksB()
  {
    return false;
  }
  
  public final al ksx()
  {
    return this.aiUV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.g
 * JD-Core Version:    0.7.0.1
 */