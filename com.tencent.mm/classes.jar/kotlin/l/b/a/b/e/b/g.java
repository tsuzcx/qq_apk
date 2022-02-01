package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.p.a;
import kotlin.l.b.a.b.e.a.t;

public final class g
{
  public static final a.p a(a.h paramh, h paramh1)
  {
    AppMethodBeat.i(59073);
    p.h(paramh, "$this$returnType");
    p.h(paramh1, "typeTable");
    if (paramh.hGb())
    {
      paramh = paramh.Tyy;
      p.g(paramh, "returnType");
      AppMethodBeat.o(59073);
      return paramh;
    }
    if (paramh.hGc())
    {
      paramh = paramh1.avo(paramh.Tyz);
      AppMethodBeat.o(59073);
      return paramh;
    }
    paramh = (Throwable)new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    AppMethodBeat.o(59073);
    throw paramh;
  }
  
  public static final a.p a(a.m paramm, h paramh)
  {
    AppMethodBeat.i(59076);
    p.h(paramm, "$this$returnType");
    p.h(paramh, "typeTable");
    if (paramm.hGb())
    {
      paramm = paramm.Tyy;
      p.g(paramm, "returnType");
      AppMethodBeat.o(59076);
      return paramm;
    }
    if (paramm.hGc())
    {
      paramm = paramh.avo(paramm.Tyz);
      AppMethodBeat.o(59076);
      return paramm;
    }
    paramm = (Throwable)new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    AppMethodBeat.o(59076);
    throw paramm;
  }
  
  public static final a.p a(a.p.a parama, h paramh)
  {
    AppMethodBeat.i(59071);
    p.h(parama, "$this$type");
    p.h(paramh, "typeTable");
    if (parama.Cm())
    {
      parama = parama.Tzy;
      AppMethodBeat.o(59071);
      return parama;
    }
    if (parama.hHi())
    {
      parama = paramh.avo(parama.Tzz);
      AppMethodBeat.o(59071);
      return parama;
    }
    AppMethodBeat.o(59071);
    return null;
  }
  
  public static final a.p a(a.p paramp, h paramh)
  {
    AppMethodBeat.i(59072);
    p.h(paramp, "$this$flexibleUpperBound");
    p.h(paramh, "typeTable");
    if (paramp.hGV())
    {
      paramp = paramp.Tzm;
      AppMethodBeat.o(59072);
      return paramp;
    }
    if (paramp.hGW())
    {
      paramp = paramh.avo(paramp.Tzn);
      AppMethodBeat.o(59072);
      return paramp;
    }
    AppMethodBeat.o(59072);
    return null;
  }
  
  public static final a.p a(a.t paramt, h paramh)
  {
    AppMethodBeat.i(59079);
    p.h(paramt, "$this$type");
    p.h(paramh, "typeTable");
    if (paramt.Cm())
    {
      paramt = paramt.Tzy;
      p.g(paramt, "type");
      AppMethodBeat.o(59079);
      return paramt;
    }
    if (paramt.hHi())
    {
      paramt = paramh.avo(paramt.Tzz);
      AppMethodBeat.o(59079);
      return paramt;
    }
    paramt = (Throwable)new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    AppMethodBeat.o(59079);
    throw paramt;
  }
  
  public static final a.p b(a.h paramh, h paramh1)
  {
    AppMethodBeat.i(59075);
    p.h(paramh, "$this$receiverType");
    p.h(paramh1, "typeTable");
    if (paramh.hGd())
    {
      paramh = paramh.TyA;
      AppMethodBeat.o(59075);
      return paramh;
    }
    if (paramh.hGe())
    {
      paramh = paramh1.avo(paramh.TyB);
      AppMethodBeat.o(59075);
      return paramh;
    }
    AppMethodBeat.o(59075);
    return null;
  }
  
  public static final a.p b(a.m paramm, h paramh)
  {
    AppMethodBeat.i(59078);
    p.h(paramm, "$this$receiverType");
    p.h(paramh, "typeTable");
    if (paramm.hGd())
    {
      paramm = paramm.TyA;
      AppMethodBeat.o(59078);
      return paramm;
    }
    if (paramm.hGe())
    {
      paramm = paramh.avo(paramm.TyB);
      AppMethodBeat.o(59078);
      return paramm;
    }
    AppMethodBeat.o(59078);
    return null;
  }
  
  public static final a.p b(a.p paramp, h paramh)
  {
    AppMethodBeat.i(59081);
    p.h(paramp, "$this$outerType");
    p.h(paramh, "typeTable");
    if (paramp.hHb())
    {
      paramp = paramp.Tzs;
      AppMethodBeat.o(59081);
      return paramp;
    }
    if (paramp.hHc())
    {
      paramp = paramh.avo(paramp.Tzt);
      AppMethodBeat.o(59081);
      return paramp;
    }
    AppMethodBeat.o(59081);
    return null;
  }
  
  public static final a.p b(a.t paramt, h paramh)
  {
    AppMethodBeat.i(59080);
    p.h(paramt, "$this$varargElementType");
    p.h(paramh, "typeTable");
    if (paramt.hHO())
    {
      paramt = paramt.TzZ;
      AppMethodBeat.o(59080);
      return paramt;
    }
    if (paramt.hHP())
    {
      paramt = paramh.avo(paramt.TAa);
      AppMethodBeat.o(59080);
      return paramt;
    }
    AppMethodBeat.o(59080);
    return null;
  }
  
  public static final a.p c(a.p paramp, h paramh)
  {
    AppMethodBeat.i(59082);
    p.h(paramp, "$this$abbreviatedType");
    p.h(paramh, "typeTable");
    if (paramp.hHd())
    {
      paramp = paramp.Tzu;
      AppMethodBeat.o(59082);
      return paramp;
    }
    if (paramp.hHe())
    {
      paramp = paramh.avo(paramp.Tzv);
      AppMethodBeat.o(59082);
      return paramp;
    }
    AppMethodBeat.o(59082);
    return null;
  }
  
  public static final boolean e(a.m paramm)
  {
    AppMethodBeat.i(59077);
    p.h(paramm, "$this$hasReceiver");
    if ((paramm.hGd()) || (paramm.hGe()))
    {
      AppMethodBeat.o(59077);
      return true;
    }
    AppMethodBeat.o(59077);
    return false;
  }
  
  public static final boolean f(a.h paramh)
  {
    AppMethodBeat.i(59074);
    p.h(paramh, "$this$hasReceiver");
    if ((paramh.hGd()) || (paramh.hGe()))
    {
      AppMethodBeat.o(59074);
      return true;
    }
    AppMethodBeat.o(59074);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     kotlin.l.b.a.b.e.b.g
 * JD-Core Version:    0.7.0.1
 */