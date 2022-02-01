package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.n;
import d.g.b.q;
import d.g.b.t;
import d.g.b.w;
import d.l.h;

public class z
  extends d.g.b.aa
{
  private static i a(d.g.b.e parame)
  {
    AppMethodBeat.i(56530);
    parame = parame.HD();
    if ((parame instanceof i))
    {
      parame = (i)parame;
      AppMethodBeat.o(56530);
      return parame;
    }
    parame = a.NjN;
    AppMethodBeat.o(56530);
    return parame;
  }
  
  public final d.l.e a(n paramn)
  {
    AppMethodBeat.i(56526);
    paramn = new j(a(paramn), paramn.getName(), paramn.HC(), paramn.gkr());
    AppMethodBeat.o(56526);
    return paramn;
  }
  
  public final h a(t paramt)
  {
    AppMethodBeat.i(56529);
    paramt = new l(a(paramt), paramt.getName(), paramt.HC(), paramt.gkr());
    AppMethodBeat.o(56529);
    return paramt;
  }
  
  public final d.l.m a(w paramw)
  {
    AppMethodBeat.i(56528);
    paramw = new p(a(paramw), paramw.getName(), paramw.HC(), paramw.gkr());
    AppMethodBeat.o(56528);
    return paramw;
  }
  
  public final String a(d.g.b.m paramm)
  {
    AppMethodBeat.i(56525);
    Object localObject = d.l.b.b.a(paramm);
    if (localObject != null)
    {
      localObject = ae.fc(localObject);
      if (localObject != null)
      {
        paramm = aa.NlX;
        paramm = aa.b(((j)localObject).glb());
        AppMethodBeat.o(56525);
        return paramm;
      }
    }
    paramm = super.a(paramm);
    AppMethodBeat.o(56525);
    return paramm;
  }
  
  public final String a(q paramq)
  {
    AppMethodBeat.i(56524);
    paramq = a(paramq);
    AppMethodBeat.o(56524);
    return paramq;
  }
  
  public final d.l.b bp(Class paramClass)
  {
    AppMethodBeat.i(56523);
    paramClass = f.bq(paramClass);
    AppMethodBeat.o(56523);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.z
 * JD-Core Version:    0.7.0.1
 */