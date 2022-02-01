package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  final l NcT;
  final String name;
  final c vOl;
  
  public d(c paramc, String paramString)
  {
    this(paramc, paramString, o.Ndg);
  }
  
  private d(c paramc, String paramString, l paraml)
  {
    this.vOl = paramc;
    this.name = paramString;
    this.NcT = paraml;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9835);
    c localc = this.vOl;
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
    public abstract void cTa();
    
    public abstract void df(Object paramObject);
    
    public abstract void f(String paramString1, String paramString2, Object paramObject);
  }
  
  final class b
    implements c.a
  {
    private final d.c NcU;
    final AtomicReference<d.a> NcV;
    
    b(d.c paramc)
    {
      AppMethodBeat.i(9843);
      this.NcV = new AtomicReference(null);
      this.NcU = paramc;
      AppMethodBeat.o(9843);
    }
    
    public final void a(ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(9844);
      paramByteBuffer = d.this.NcT.K(paramByteBuffer);
      if (paramByteBuffer.method.equals("listen"))
      {
        paramByteBuffer = new a((byte)0);
        if ((d.a)this.NcV.getAndSet(paramByteBuffer) != null) {}
        try
        {
          this.NcU.sQ();
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            try
            {
              this.NcU.a(paramByteBuffer);
              paramb.I(d.this.NcT.eK(null));
              AppMethodBeat.o(9844);
              return;
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.NcV.set(null);
              new StringBuilder("EventChannel#").append(d.this.name);
              paramb.I(d.this.NcT.k("error", paramByteBuffer.getMessage(), null));
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
        if ((d.a)this.NcV.getAndSet(null) != null) {
          try
          {
            this.NcU.sQ();
            paramb.I(d.this.NcT.eK(null));
            AppMethodBeat.o(9844);
            return;
          }
          catch (RuntimeException paramByteBuffer)
          {
            new StringBuilder("EventChannel#").append(d.this.name);
            paramb.I(d.this.NcT.k("error", paramByteBuffer.getMessage(), null));
            AppMethodBeat.o(9844);
            return;
          }
        }
        paramb.I(d.this.NcT.k("error", "No active stream to cancel", null));
        AppMethodBeat.o(9844);
        return;
      }
      paramb.I(null);
      AppMethodBeat.o(9844);
    }
    
    final class a
      implements d.a
    {
      final AtomicBoolean NcX;
      
      private a()
      {
        AppMethodBeat.i(9831);
        this.NcX = new AtomicBoolean(false);
        AppMethodBeat.o(9831);
      }
      
      public final void cTa()
      {
        AppMethodBeat.i(9834);
        if ((this.NcX.getAndSet(true)) || (d.b.this.NcV.get() != this))
        {
          AppMethodBeat.o(9834);
          return;
        }
        d.this.vOl.a(d.this.name, null);
        AppMethodBeat.o(9834);
      }
      
      public final void df(Object paramObject)
      {
        AppMethodBeat.i(9832);
        if ((this.NcX.get()) || (d.b.this.NcV.get() != this))
        {
          AppMethodBeat.o(9832);
          return;
        }
        d.this.vOl.a(d.this.name, d.this.NcT.eK(paramObject));
        AppMethodBeat.o(9832);
      }
      
      public final void f(String paramString1, String paramString2, Object paramObject)
      {
        AppMethodBeat.i(9833);
        if ((this.NcX.get()) || (d.b.this.NcV.get() != this))
        {
          AppMethodBeat.o(9833);
          return;
        }
        d.this.vOl.a(d.this.name, d.this.NcT.k(paramString1, paramString2, paramObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */