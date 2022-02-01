package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.c.a.b;
import d.l.b.a.b.e.c.a.e;
import d.l.b.a.b.e.c.a.e.a;
import d.l.b.a.b.e.c.a.e.b;
import d.m;

public final class s
{
  public static final a Nje;
  final String signature;
  
  static
  {
    AppMethodBeat.i(58237);
    Nje = new a((byte)0);
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
        if (!p.i(this.signature, paramObject.signature)) {}
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
      p.h(params, "signature");
      params = new s(params.signature + '@' + paramInt, (byte)0);
      AppMethodBeat.o(58236);
      return params;
    }
    
    public static s a(c paramc, a.b paramb)
    {
      AppMethodBeat.i(58232);
      p.h(paramc, "nameResolver");
      p.h(paramb, "signature");
      paramc = nt(paramc.getString(paramb.NlC), paramc.getString(paramb.Npn));
      AppMethodBeat.o(58232);
      return paramc;
    }
    
    public static s a(e parame)
    {
      AppMethodBeat.i(58235);
      p.h(parame, "signature");
      if ((parame instanceof e.b))
      {
        parame = nt(parame.getName(), parame.getDesc());
        AppMethodBeat.o(58235);
        return parame;
      }
      if ((parame instanceof e.a))
      {
        parame = nu(parame.getName(), parame.getDesc());
        AppMethodBeat.o(58235);
        return parame;
      }
      parame = new m();
      AppMethodBeat.o(58235);
      throw parame;
    }
    
    public static s nt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(58233);
      p.h(paramString1, "name");
      p.h(paramString2, "desc");
      paramString1 = new s(paramString1 + paramString2, (byte)0);
      AppMethodBeat.o(58233);
      return paramString1;
    }
    
    public static s nu(String paramString1, String paramString2)
    {
      AppMethodBeat.i(58234);
      p.h(paramString1, "name");
      p.h(paramString2, "desc");
      paramString1 = new s(paramString1 + '#' + paramString2, (byte)0);
      AppMethodBeat.o(58234);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.s
 * JD-Core Version:    0.7.0.1
 */