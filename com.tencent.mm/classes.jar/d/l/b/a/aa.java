package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.c;
import d.g.b.r;
import d.g.b.t;
import d.g.b.x;
import d.l.d;
import d.l.e;
import d.l.h;
import d.l.m;

public class aa
  extends x
{
  private static i a(c paramc)
  {
    AppMethodBeat.i(56530);
    paramc = paramc.Ga();
    if ((paramc instanceof i))
    {
      paramc = (i)paramc;
      AppMethodBeat.o(56530);
      return paramc;
    }
    paramc = a.KVC;
    AppMethodBeat.o(56530);
    return paramc;
  }
  
  public final e a(d.g.b.j paramj)
  {
    AppMethodBeat.i(56526);
    paramj = new j(a(paramj), paramj.getName(), paramj.FZ(), paramj.fOp());
    AppMethodBeat.o(56526);
    return paramj;
  }
  
  public final h a(d.g.b.n paramn)
  {
    AppMethodBeat.i(56529);
    paramn = new l(a(paramn), paramn.getName(), paramn.FZ(), paramn.fOp());
    AppMethodBeat.o(56529);
    return paramn;
  }
  
  public final d.l.l a(r paramr)
  {
    AppMethodBeat.i(56527);
    paramr = new p(a(paramr), paramr.getName(), paramr.FZ(), paramr.fOp());
    AppMethodBeat.o(56527);
    return paramr;
  }
  
  public final m a(t paramt)
  {
    AppMethodBeat.i(56528);
    paramt = new q(a(paramt), paramt.getName(), paramt.FZ(), paramt.fOp());
    AppMethodBeat.o(56528);
    return paramt;
  }
  
  public final String a(d.g.b.i parami)
  {
    AppMethodBeat.i(56525);
    Object localObject = d.l.b.b.a(parami);
    if (localObject != null)
    {
      localObject = af.eX(localObject);
      if (localObject != null)
      {
        parami = ab.KXV;
        parami = ab.b(((j)localObject).fPa());
        AppMethodBeat.o(56525);
        return parami;
      }
    }
    parami = super.a(parami);
    AppMethodBeat.o(56525);
    return parami;
  }
  
  public final String a(d.g.b.l paraml)
  {
    AppMethodBeat.i(56524);
    paraml = a(paraml);
    AppMethodBeat.o(56524);
    return paraml;
  }
  
  public final d.l.b bn(Class paramClass)
  {
    AppMethodBeat.i(56523);
    paramClass = f.bo(paramClass);
    AppMethodBeat.o(56523);
    return paramClass;
  }
  
  public final d g(Class paramClass, String paramString)
  {
    AppMethodBeat.i(56522);
    paramClass = new n(paramClass, paramString);
    AppMethodBeat.o(56522);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.aa
 * JD-Core Version:    0.7.0.1
 */