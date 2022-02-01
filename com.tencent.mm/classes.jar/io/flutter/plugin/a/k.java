package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class k
{
  final l MFN;
  final String name;
  private final c vCh;
  
  public k(c paramc, String paramString)
  {
    this(paramc, paramString, o.MGa);
  }
  
  public k(c paramc, String paramString, l paraml)
  {
    this.vCh = paramc;
    this.name = paramString;
    this.MFN = paraml;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9838);
    c localc = this.vCh;
    String str = this.name;
    if (paramc == null) {}
    for (paramc = null;; paramc = new a(paramc))
    {
      localc.a(str, paramc);
      AppMethodBeat.o(9838);
      return;
    }
  }
  
  public final void a(String paramString, Object paramObject, k.d paramd)
  {
    AppMethodBeat.i(9837);
    c localc = this.vCh;
    String str = this.name;
    paramObject = this.MFN.b(new j(paramString, paramObject));
    if (paramd == null) {}
    for (paramString = null;; paramString = new k.b(this, paramd))
    {
      localc.a(str, paramObject, paramString);
      AppMethodBeat.o(9837);
      return;
    }
  }
  
  final class a
    implements c.a
  {
    private final k.c vCk;
    
    a(k.c paramc)
    {
      this.vCk = paramc;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9867);
      paramByteBuffer = k.this.MFN.K(paramByteBuffer);
      try
      {
        this.vCk.a(paramByteBuffer, new k.d()
        {
          public final void de(Object paramAnonymousObject)
          {
            AppMethodBeat.i(9839);
            paramb.I(k.this.MFN.eH(paramAnonymousObject));
            AppMethodBeat.o(9839);
          }
          
          public final void djR()
          {
            AppMethodBeat.i(9841);
            paramb.I(null);
            AppMethodBeat.o(9841);
          }
          
          public final void f(String paramAnonymousString1, String paramAnonymousString2, Object paramAnonymousObject)
          {
            AppMethodBeat.i(9840);
            paramb.I(k.this.MFN.k(paramAnonymousString1, paramAnonymousString2, paramAnonymousObject));
            AppMethodBeat.o(9840);
          }
        });
        AppMethodBeat.o(9867);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        new StringBuilder("MethodChannel#").append(k.this.name);
        paramb.I(k.this.MFN.k("error", paramByteBuffer.getMessage(), null));
        AppMethodBeat.o(9867);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(j paramj, k.d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.a.k
 * JD-Core Version:    0.7.0.1
 */