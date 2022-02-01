package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  final l KOQ;
  final String name;
  final c uzE;
  
  public d(c paramc, String paramString)
  {
    this(paramc, paramString, o.KPd);
  }
  
  private d(c paramc, String paramString, l paraml)
  {
    this.uzE = paramc;
    this.name = paramString;
    this.KOQ = paraml;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9835);
    c localc = this.uzE;
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
    public abstract void cIg();
    
    public abstract void db(Object paramObject);
    
    public abstract void e(String paramString1, String paramString2, Object paramObject);
  }
  
  final class b
    implements c.a
  {
    private final d.c KOR;
    final AtomicReference<d.a> KOS;
    
    b(d.c paramc)
    {
      AppMethodBeat.i(9843);
      this.KOS = new AtomicReference(null);
      this.KOR = paramc;
      AppMethodBeat.o(9843);
    }
    
    public final void a(ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(9844);
      paramByteBuffer = d.this.KOQ.J(paramByteBuffer);
      if (paramByteBuffer.method.equals("listen"))
      {
        paramByteBuffer = new a((byte)0);
        if ((d.a)this.KOS.getAndSet(paramByteBuffer) != null) {}
        try
        {
          this.KOR.rr();
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            try
            {
              this.KOR.a(paramByteBuffer);
              paramb.H(d.this.KOQ.eE(null));
              AppMethodBeat.o(9844);
              return;
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.KOS.set(null);
              new StringBuilder("EventChannel#").append(d.this.name);
              paramb.H(d.this.KOQ.i("error", paramByteBuffer.getMessage(), null));
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
        if ((d.a)this.KOS.getAndSet(null) != null) {
          try
          {
            this.KOR.rr();
            paramb.H(d.this.KOQ.eE(null));
            AppMethodBeat.o(9844);
            return;
          }
          catch (RuntimeException paramByteBuffer)
          {
            new StringBuilder("EventChannel#").append(d.this.name);
            paramb.H(d.this.KOQ.i("error", paramByteBuffer.getMessage(), null));
            AppMethodBeat.o(9844);
            return;
          }
        }
        paramb.H(d.this.KOQ.i("error", "No active stream to cancel", null));
        AppMethodBeat.o(9844);
        return;
      }
      paramb.H(null);
      AppMethodBeat.o(9844);
    }
    
    final class a
      implements d.a
    {
      final AtomicBoolean KOU;
      
      private a()
      {
        AppMethodBeat.i(9831);
        this.KOU = new AtomicBoolean(false);
        AppMethodBeat.o(9831);
      }
      
      public final void cIg()
      {
        AppMethodBeat.i(9834);
        if ((this.KOU.getAndSet(true)) || (d.b.this.KOS.get() != this))
        {
          AppMethodBeat.o(9834);
          return;
        }
        d.this.uzE.a(d.this.name, null);
        AppMethodBeat.o(9834);
      }
      
      public final void db(Object paramObject)
      {
        AppMethodBeat.i(9832);
        if ((this.KOU.get()) || (d.b.this.KOS.get() != this))
        {
          AppMethodBeat.o(9832);
          return;
        }
        d.this.uzE.a(d.this.name, d.this.KOQ.eE(paramObject));
        AppMethodBeat.o(9832);
      }
      
      public final void e(String paramString1, String paramString2, Object paramObject)
      {
        AppMethodBeat.i(9833);
        if ((this.KOU.get()) || (d.b.this.KOS.get() != this))
        {
          AppMethodBeat.o(9833);
          return;
        }
        d.this.uzE.a(d.this.name, d.this.KOQ.i(paramString1, paramString2, paramObject));
        AppMethodBeat.o(9833);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(d.a parama);
    
    public abstract void rr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */