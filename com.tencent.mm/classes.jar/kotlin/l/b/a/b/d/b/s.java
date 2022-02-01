package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a.b;
import kotlin.l.b.a.b.e.c.a.e;
import kotlin.l.b.a.b.e.c.a.e.a;
import kotlin.l.b.a.b.e.c.a.e.b;
import kotlin.m;

public final class s
{
  public static final a aaYG;
  final String signature;
  
  static
  {
    AppMethodBeat.i(58237);
    aaYG = new a((byte)0);
    AppMethodBeat.o(58237);
  }
  
  private s(String paramString)
  {
    this.signature = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(58240);
    if (this != paramObject)
    {
      if ((paramObject instanceof s))
      {
        paramObject = (s)paramObject;
        if (!p.h(this.signature, paramObject.signature)) {}
      }
    }
    else
    {
      AppMethodBeat.o(58240);
      return true;
    }
    AppMethodBeat.o(58240);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(58239);
    String str = this.signature;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(58239);
      return i;
    }
    AppMethodBeat.o(58239);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58238);
    String str = "MemberSignature(signature=" + this.signature + ")";
    AppMethodBeat.o(58238);
    return str;
  }
  
  public static final class a
  {
    public static s a(s params, int paramInt)
    {
      AppMethodBeat.i(58236);
      p.k(params, "signature");
      params = new s(params.signature + '@' + paramInt, (byte)0);
      AppMethodBeat.o(58236);
      return params;
    }
    
    public static s a(c paramc, a.b paramb)
    {
      AppMethodBeat.i(58232);
      p.k(paramc, "nameResolver");
      p.k(paramb, "signature");
      paramc = po(paramc.getString(paramb.abbb), paramc.getString(paramb.abeL));
      AppMethodBeat.o(58232);
      return paramc;
    }
    
    public static s a(e parame)
    {
      AppMethodBeat.i(58235);
      p.k(parame, "signature");
      if ((parame instanceof e.b))
      {
        parame = po(parame.getName(), parame.getDesc());
        AppMethodBeat.o(58235);
        return parame;
      }
      if ((parame instanceof e.a))
      {
        parame = pp(parame.getName(), parame.getDesc());
        AppMethodBeat.o(58235);
        return parame;
      }
      parame = new m();
      AppMethodBeat.o(58235);
      throw parame;
    }
    
    public static s po(String paramString1, String paramString2)
    {
      AppMethodBeat.i(58233);
      p.k(paramString1, "name");
      p.k(paramString2, "desc");
      paramString1 = new s(paramString1 + paramString2, (byte)0);
      AppMethodBeat.o(58233);
      return paramString1;
    }
    
    public static s pp(String paramString1, String paramString2)
    {
      AppMethodBeat.i(58234);
      p.k(paramString1, "name");
      p.k(paramString2, "desc");
      paramString1 = new s(paramString1 + '#' + paramString2, (byte)0);
      AppMethodBeat.o(58234);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.b.s
 * JD-Core Version:    0.7.0.1
 */