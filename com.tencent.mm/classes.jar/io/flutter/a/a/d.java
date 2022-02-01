package io.flutter.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  final l Jbm;
  final String name;
  final c trm;
  
  public d(c paramc, String paramString)
  {
    this(paramc, paramString, o.Jbz);
  }
  
  private d(c paramc, String paramString, l paraml)
  {
    this.trm = paramc;
    this.name = paramString;
    this.Jbm = paraml;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9835);
    c localc = this.trm;
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
    public abstract void a(String paramString1, String paramString2, Object paramObject);
    
    public abstract void ay(Object paramObject);
    
    public abstract void cuU();
  }
  
  final class b
    implements c.a
  {
    private final d.c Jbn;
    final AtomicReference<d.a> Jbo;
    
    b(d.c paramc)
    {
      AppMethodBeat.i(9843);
      this.Jbo = new AtomicReference(null);
      this.Jbn = paramc;
      AppMethodBeat.o(9843);
    }
    
    public final void a(ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(9844);
      paramByteBuffer = d.this.Jbm.J(paramByteBuffer);
      if (paramByteBuffer.method.equals("listen"))
      {
        paramByteBuffer = new a((byte)0);
        if ((d.a)this.Jbo.getAndSet(paramByteBuffer) != null) {}
        try
        {
          this.Jbn.cuT();
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            try
            {
              this.Jbn.a(paramByteBuffer);
              paramb.H(d.this.Jbm.eC(null));
              AppMethodBeat.o(9844);
              return;
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.Jbo.set(null);
              new StringBuilder("EventChannel#").append(d.this.name);
              paramb.H(d.this.Jbm.i("error", paramByteBuffer.getMessage(), null));
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
        if ((d.a)this.Jbo.getAndSet(null) != null) {
          try
          {
            this.Jbn.cuT();
            paramb.H(d.this.Jbm.eC(null));
            AppMethodBeat.o(9844);
            return;
          }
          catch (RuntimeException paramByteBuffer)
          {
            new StringBuilder("EventChannel#").append(d.this.name);
            paramb.H(d.this.Jbm.i("error", paramByteBuffer.getMessage(), null));
            AppMethodBeat.o(9844);
            return;
          }
        }
        paramb.H(d.this.Jbm.i("error", "No active stream to cancel", null));
        AppMethodBeat.o(9844);
        return;
      }
      paramb.H(null);
      AppMethodBeat.o(9844);
    }
    
    final class a
      implements d.a
    {
      final AtomicBoolean Jbq;
      
      private a()
      {
        AppMethodBeat.i(9831);
        this.Jbq = new AtomicBoolean(false);
        AppMethodBeat.o(9831);
      }
      
      public final void a(String paramString1, String paramString2, Object paramObject)
      {
        AppMethodBeat.i(9833);
        if ((this.Jbq.get()) || (d.b.this.Jbo.get() != this))
        {
          AppMethodBeat.o(9833);
          return;
        }
        d.this.trm.a(d.this.name, d.this.Jbm.i(paramString1, paramString2, paramObject));
        AppMethodBeat.o(9833);
      }
      
      public final void ay(Object paramObject)
      {
        AppMethodBeat.i(9832);
        if ((this.Jbq.get()) || (d.b.this.Jbo.get() != this))
        {
          AppMethodBeat.o(9832);
          return;
        }
        d.this.trm.a(d.this.name, d.this.Jbm.eC(paramObject));
        AppMethodBeat.o(9832);
      }
      
      public final void cuU()
      {
        AppMethodBeat.i(9834);
        if ((this.Jbq.getAndSet(true)) || (d.b.this.Jbo.get() != this))
        {
          AppMethodBeat.o(9834);
          return;
        }
        d.this.trm.a(d.this.name, null);
        AppMethodBeat.o(9834);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(d.a parama);
    
    public abstract void cuT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.a.d
 * JD-Core Version:    0.7.0.1
 */