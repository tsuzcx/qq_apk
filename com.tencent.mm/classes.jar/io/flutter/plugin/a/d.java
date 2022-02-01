package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  final l MFN;
  final String name;
  final c vCh;
  
  public d(c paramc, String paramString)
  {
    this(paramc, paramString, o.MGa);
  }
  
  private d(c paramc, String paramString, l paraml)
  {
    this.vCh = paramc;
    this.name = paramString;
    this.MFN = paraml;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9835);
    c localc = this.vCh;
    String str = this.name;
    if (paramc == null) {}
    for (paramc = null;; paramc = new b(paramc))
    {
      localc.a(str, paramc);
      AppMethodBeat.o(9835);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cQv();
    
    public abstract void de(Object paramObject);
    
    public abstract void f(String paramString1, String paramString2, Object paramObject);
  }
  
  final class b
    implements c.a
  {
    private final d.c MFO;
    final AtomicReference<d.a> MFP;
    
    b(d.c paramc)
    {
      AppMethodBeat.i(9843);
      this.MFP = new AtomicReference(null);
      this.MFO = paramc;
      AppMethodBeat.o(9843);
    }
    
    public final void a(ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(9844);
      paramByteBuffer = d.this.MFN.K(paramByteBuffer);
      if (paramByteBuffer.method.equals("listen"))
      {
        paramByteBuffer = new a((byte)0);
        if ((d.a)this.MFP.getAndSet(paramByteBuffer) != null) {}
        try
        {
          this.MFO.sQ();
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            try
            {
              this.MFO.a(paramByteBuffer);
              paramb.I(d.this.MFN.eH(null));
              AppMethodBeat.o(9844);
              return;
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.MFP.set(null);
              new StringBuilder("EventChannel#").append(d.this.name);
              paramb.I(d.this.MFN.k("error", paramByteBuffer.getMessage(), null));
              AppMethodBeat.o(9844);
              return;
            }
            localRuntimeException = localRuntimeException;
            new StringBuilder("EventChannel#").append(d.this.name);
          }
        }
      }
      if (paramByteBuffer.method.equals("cancel"))
      {
        if ((d.a)this.MFP.getAndSet(null) != null) {
          try
          {
            this.MFO.sQ();
            paramb.I(d.this.MFN.eH(null));
            AppMethodBeat.o(9844);
            return;
          }
          catch (RuntimeException paramByteBuffer)
          {
            new StringBuilder("EventChannel#").append(d.this.name);
            paramb.I(d.this.MFN.k("error", paramByteBuffer.getMessage(), null));
            AppMethodBeat.o(9844);
            return;
          }
        }
        paramb.I(d.this.MFN.k("error", "No active stream to cancel", null));
        AppMethodBeat.o(9844);
        return;
      }
      paramb.I(null);
      AppMethodBeat.o(9844);
    }
    
    final class a
      implements d.a
    {
      final AtomicBoolean MFR;
      
      private a()
      {
        AppMethodBeat.i(9831);
        this.MFR = new AtomicBoolean(false);
        AppMethodBeat.o(9831);
      }
      
      public final void cQv()
      {
        AppMethodBeat.i(9834);
        if ((this.MFR.getAndSet(true)) || (d.b.this.MFP.get() != this))
        {
          AppMethodBeat.o(9834);
          return;
        }
        d.this.vCh.a(d.this.name, null);
        AppMethodBeat.o(9834);
      }
      
      public final void de(Object paramObject)
      {
        AppMethodBeat.i(9832);
        if ((this.MFR.get()) || (d.b.this.MFP.get() != this))
        {
          AppMethodBeat.o(9832);
          return;
        }
        d.this.vCh.a(d.this.name, d.this.MFN.eH(paramObject));
        AppMethodBeat.o(9832);
      }
      
      public final void f(String paramString1, String paramString2, Object paramObject)
      {
        AppMethodBeat.i(9833);
        if ((this.MFR.get()) || (d.b.this.MFP.get() != this))
        {
          AppMethodBeat.o(9833);
          return;
        }
        d.this.vCh.a(d.this.name, d.this.MFN.k(paramString1, paramString2, paramObject));
        AppMethodBeat.o(9833);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(d.a parama);
    
    public abstract void sQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */