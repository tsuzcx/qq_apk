package d.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.a.p;
import d.l.b.a.b.e.a.p.a;
import d.l.b.a.b.e.a.t;

public final class g
{
  public static final a.p a(a.h paramh, h paramh1)
  {
    AppMethodBeat.i(59073);
    p.h(paramh, "$this$returnType");
    p.h(paramh1, "typeTable");
    if (paramh.gsD())
    {
      paramh = paramh.NIW;
      p.g(paramh, "returnType");
      AppMethodBeat.o(59073);
      return paramh;
    }
    if (paramh.gsE())
    {
      paramh = paramh1.aly(paramh.NIX);
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
    if (paramm.gsD())
    {
      paramm = paramm.NIW;
      p.g(paramm, "returnType");
      AppMethodBeat.o(59076);
      return paramm;
    }
    if (paramm.gsE())
    {
      paramm = paramh.aly(paramm.NIX);
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
    if (parama.grh())
    {
      parama = parama.NJW;
      AppMethodBeat.o(59071);
      return parama;
    }
    if (parama.gtL())
    {
      parama = paramh.aly(parama.NJX);
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
    if (paramp.gty())
    {
      paramp = paramp.NJK;
      AppMethodBeat.o(59072);
      return paramp;
    }
    if (paramp.gtz())
    {
      paramp = paramh.aly(paramp.NJL);
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
    if (paramt.grh())
    {
      paramt = paramt.NJW;
      p.g(paramt, "type");
      AppMethodBeat.o(59079);
      return paramt;
    }
    if (paramt.gtL())
    {
      paramt = paramh.aly(paramt.NJX);
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
    if (paramh.gsF())
    {
      paramh = paramh.NIY;
      AppMethodBeat.o(59075);
      return paramh;
    }
    if (paramh.gsG())
    {
      paramh = paramh1.aly(paramh.NIZ);
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
    if (paramm.gsF())
    {
      paramm = paramm.NIY;
      AppMethodBeat.o(59078);
      return paramm;
    }
    if (paramm.gsG())
    {
      paramm = paramh.aly(paramm.NIZ);
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
    if (paramp.gtE())
    {
      paramp = paramp.NJQ;
      AppMethodBeat.o(59081);
      return paramp;
    }
    if (paramp.gtF())
    {
      paramp = paramh.aly(paramp.NJR);
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
    if (paramt.gur())
    {
      paramt = paramt.NKx;
      AppMethodBeat.o(59080);
      return paramt;
    }
    if (paramt.gus())
    {
      paramt = paramh.aly(paramt.NKy);
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
    if (paramp.gtG())
    {
      paramp = paramp.NJS;
      AppMethodBeat.o(59082);
      return paramp;
    }
    if (paramp.gtH())
    {
      paramp = paramh.aly(paramp.NJT);
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
    if ((paramm.gsF()) || (paramm.gsG()))
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
    if ((paramh.gsF()) || (paramh.gsG()))
    {
      AppMethodBeat.o(59074);
      return true;
    }
    AppMethodBeat.o(59074);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.l.b.a.b.e.b.g
 * JD-Core Version:    0.7.0.1
 */