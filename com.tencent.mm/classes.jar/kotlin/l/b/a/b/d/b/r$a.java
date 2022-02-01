package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a.b;
import kotlin.l.b.a.b.e.c.a.d;
import kotlin.l.b.a.b.e.c.a.d.a;
import kotlin.l.b.a.b.e.c.a.d.b;
import kotlin.p;

public final class r$a
{
  public static r a(r paramr, int paramInt)
  {
    AppMethodBeat.i(58236);
    s.u(paramr, "signature");
    paramr = new r(paramr.signature + '@' + paramInt, (byte)0);
    AppMethodBeat.o(58236);
    return paramr;
  }
  
  public static r a(c paramc, a.b paramb)
  {
    AppMethodBeat.i(58232);
    s.u(paramc, "nameResolver");
    s.u(paramb, "signature");
    paramc = rm(paramc.getString(paramb.aiZC), paramc.getString(paramb.ajdy));
    AppMethodBeat.o(58232);
    return paramc;
  }
  
  public static r a(d paramd)
  {
    AppMethodBeat.i(58235);
    s.u(paramd, "signature");
    if ((paramd instanceof d.b))
    {
      paramd = rm(paramd.getName(), paramd.getDesc());
      AppMethodBeat.o(58235);
      return paramd;
    }
    if ((paramd instanceof d.a))
    {
      paramd = rn(paramd.getName(), paramd.getDesc());
      AppMethodBeat.o(58235);
      return paramd;
    }
    paramd = new p();
    AppMethodBeat.o(58235);
    throw paramd;
  }
  
  public static r rm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58233);
    s.u(paramString1, "name");
    s.u(paramString2, "desc");
    paramString1 = new r(s.X(paramString1, paramString2), (byte)0);
    AppMethodBeat.o(58233);
    return paramString1;
  }
  
  public static r rn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(58234);
    s.u(paramString1, "name");
    s.u(paramString2, "desc");
    paramString1 = new r(paramString1 + '#' + paramString2, (byte)0);
    AppMethodBeat.o(58234);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.r.a
 * JD-Core Version:    0.7.0.1
 */