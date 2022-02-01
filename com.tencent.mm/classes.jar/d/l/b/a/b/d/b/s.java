package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.c.a.b;
import d.l.b.a.b.e.c.a.e;
import d.l.b.a.b.e.c.a.e.a;
import d.l.b.a.b.e.c.a.e.b;
import d.m;

public final class s
{
  public static final a Lsh;
  final String signature;
  
  static
  {
    AppMethodBeat.i(58237);
    Lsh = new a((byte)0);
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
        if (!k.g(this.signature, paramObject.signature)) {}
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
      k.h(params, "signature");
      params = new s(params.signature + '@' + paramInt, (byte)0);
      AppMethodBeat.o(58236);
      return params;
    }
    
    public static s a(c paramc, a.b paramb)
    {
      AppMethodBeat.i(58232);
      k.h(paramc, "nameResolver");
      k.h(paramb, "signature");
      paramc = mV(paramc.getString(paramb.LuF), paramc.getString(paramb.Lyq));
      AppMethodBeat.o(58232);
      return paramc;
    }
    
    public static s a(e parame)
    {
      AppMethodBeat.i(58235);
      k.h(parame, "signature");
      if ((parame instanceof e.b))
      {
        parame = mV(parame.getName(), parame.getDesc());
        AppMethodBeat.o(58235);
        return parame;
      }
      if ((parame instanceof e.a))
      {
        parame = mW(parame.getName(), parame.getDesc());
        AppMethodBeat.o(58235);
        return parame;
      }
      parame = new m();
      AppMethodBeat.o(58235);
      throw parame;
    }
    
    public static s mV(String paramString1, String paramString2)
    {
      AppMethodBeat.i(58233);
      k.h(paramString1, "name");
      k.h(paramString2, "desc");
      paramString1 = new s(paramString1 + paramString2, (byte)0);
      AppMethodBeat.o(58233);
      return paramString1;
    }
    
    public static s mW(String paramString1, String paramString2)
    {
      AppMethodBeat.i(58234);
      k.h(paramString1, "name");
      k.h(paramString2, "desc");
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