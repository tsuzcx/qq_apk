package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  final l aauF;
  final c aauy;
  final String name;
  
  public d(c paramc, String paramString)
  {
    this(paramc, paramString, o.aauS);
  }
  
  private d(c paramc, String paramString, l paraml)
  {
    this.aauy = paramc;
    this.name = paramString;
    this.aauF = paraml;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9835);
    c localc = this.aauy;
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
    public abstract void aEn();
    
    public abstract void b(String paramString1, String paramString2, Object paramObject);
    
    public abstract void bb(Object paramObject);
  }
  
  final class b
    implements c.a
  {
    private final d.c aauG;
    final AtomicReference<d.a> aauH;
    
    b(d.c paramc)
    {
      AppMethodBeat.i(9843);
      this.aauH = new AtomicReference(null);
      this.aauG = paramc;
      AppMethodBeat.o(9843);
    }
    
    public final void a(ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(9844);
      paramByteBuffer = d.this.aauF.G(paramByteBuffer);
      if (paramByteBuffer.method.equals("listen"))
      {
        paramByteBuffer = new a((byte)0);
        if ((d.a)this.aauH.getAndSet(paramByteBuffer) != null) {}
        try
        {
          this.aauG.qH();
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            try
            {
              this.aauG.a(paramByteBuffer);
              paramb.E(d.this.aauF.eV(null));
              AppMethodBeat.o(9844);
              return;
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.aauH.set(null);
              new StringBuilder("EventChannel#").append(d.this.name);
              b.iAi();
              paramb.E(d.this.aauF.h("error", paramByteBuffer.getMessage(), null));
              AppMethodBeat.o(9844);
              return;
            }
            localRuntimeException = localRuntimeException;
            new StringBuilder("EventChannel#").append(d.this.name);
            b.iAi();
          }
        }
      }
      if (paramByteBuffer.method.equals("cancel"))
      {
        if ((d.a)this.aauH.getAndSet(null) != null) {
          try
          {
            this.aauG.qH();
            paramb.E(d.this.aauF.eV(null));
            AppMethodBeat.o(9844);
            return;
          }
          catch (RuntimeException paramByteBuffer)
          {
            new StringBuilder("EventChannel#").append(d.this.name);
            b.iAi();
            paramb.E(d.this.aauF.h("error", paramByteBuffer.getMessage(), null));
            AppMethodBeat.o(9844);
            return;
          }
        }
        paramb.E(d.this.aauF.h("error", "No active stream to cancel", null));
        AppMethodBeat.o(9844);
        return;
      }
      paramb.E(null);
      AppMethodBeat.o(9844);
    }
    
    final class a
      implements d.a
    {
      final AtomicBoolean aauJ;
      
      private a()
      {
        AppMethodBeat.i(9831);
        this.aauJ = new AtomicBoolean(false);
        AppMethodBeat.o(9831);
      }
      
      public final void aEn()
      {
        AppMethodBeat.i(9834);
        if ((this.aauJ.getAndSet(true)) || (d.b.this.aauH.get() != this))
        {
          AppMethodBeat.o(9834);
          return;
        }
        d.this.aauy.a(d.this.name, null);
        AppMethodBeat.o(9834);
      }
      
      public final void b(String paramString1, String paramString2, Object paramObject)
      {
        AppMethodBeat.i(9833);
        if ((this.aauJ.get()) || (d.b.this.aauH.get() != this))
        {
          AppMethodBeat.o(9833);
          return;
        }
        d.this.aauy.a(d.this.name, d.this.aauF.h(paramString1, paramString2, paramObject));
        AppMethodBeat.o(9833);
      }
      
      public final void bb(Object paramObject)
      {
        AppMethodBeat.i(9832);
        if ((this.aauJ.get()) || (d.b.this.aauH.get() != this))
        {
          AppMethodBeat.o(9832);
          return;
        }
        d.this.aauy.a(d.this.name, d.this.aauF.eV(paramObject));
        AppMethodBeat.o(9832);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(d.a parama);
    
    public abstract void qH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */