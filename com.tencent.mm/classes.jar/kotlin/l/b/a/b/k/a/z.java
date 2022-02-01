package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.e.a.b.b;
import kotlin.l.b.a.b.e.a.j;
import kotlin.l.b.a.b.e.a.p.a.b;
import kotlin.l.b.a.b.e.a.r.b;
import kotlin.l.b.a.b.m.bl;
import kotlin.p;

public final class z
{
  public static final z ajmO;
  
  static
  {
    AppMethodBeat.i(60356);
    ajmO = new z();
    AppMethodBeat.o(60356);
  }
  
  public static ab a(a.j paramj)
  {
    AppMethodBeat.i(60351);
    if (paramj == null) {}
    for (int i = -1;; i = a.$EnumSwitchMapping$0[paramj.ordinal()]) {
      switch (i)
      {
      default: 
        paramj = ab.aiGY;
        AppMethodBeat.o(60351);
        return paramj;
      }
    }
    paramj = ab.aiGY;
    AppMethodBeat.o(60351);
    return paramj;
    paramj = ab.aiHa;
    AppMethodBeat.o(60351);
    return paramj;
    paramj = ab.aiHb;
    AppMethodBeat.o(60351);
    return paramj;
    paramj = ab.aiGZ;
    AppMethodBeat.o(60351);
    return paramj;
  }
  
  public static f a(a.b.b paramb)
  {
    AppMethodBeat.i(60353);
    if (paramb == null) {}
    for (int i = -1;; i = a.bOL[paramb.ordinal()]) {
      switch (i)
      {
      default: 
        paramb = f.aiGt;
        AppMethodBeat.o(60353);
        return paramb;
      }
    }
    paramb = f.aiGt;
    AppMethodBeat.o(60353);
    return paramb;
    paramb = f.aiGu;
    AppMethodBeat.o(60353);
    return paramb;
    paramb = f.aiGv;
    AppMethodBeat.o(60353);
    return paramb;
    paramb = f.aiGw;
    AppMethodBeat.o(60353);
    return paramb;
    paramb = f.aiGx;
    AppMethodBeat.o(60353);
    return paramb;
    paramb = f.aiGy;
    AppMethodBeat.o(60353);
    return paramb;
  }
  
  public static bl b(a.p.a.b paramb)
  {
    AppMethodBeat.i(60355);
    s.u(paramb, "projection");
    switch (a.bPq[paramb.ordinal()])
    {
    default: 
      paramb = new p();
      AppMethodBeat.o(60355);
      throw paramb;
    case 1: 
      paramb = bl.ajqN;
      AppMethodBeat.o(60355);
      return paramb;
    case 2: 
      paramb = bl.ajqO;
      AppMethodBeat.o(60355);
      return paramb;
    case 3: 
      paramb = bl.ajqM;
      AppMethodBeat.o(60355);
      return paramb;
    }
    paramb = new IllegalArgumentException(s.X("Only IN, OUT and INV are supported. Actual argument: ", paramb));
    AppMethodBeat.o(60355);
    throw paramb;
  }
  
  public static bl b(a.r.b paramb)
  {
    AppMethodBeat.i(60354);
    s.u(paramb, "variance");
    switch (a.bPp[paramb.ordinal()])
    {
    default: 
      paramb = new p();
      AppMethodBeat.o(60354);
      throw paramb;
    case 1: 
      paramb = bl.ajqN;
      AppMethodBeat.o(60354);
      return paramb;
    case 2: 
      paramb = bl.ajqO;
      AppMethodBeat.o(60354);
      return paramb;
    }
    paramb = bl.ajqM;
    AppMethodBeat.o(60354);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.z
 * JD-Core Version:    0.7.0.1
 */