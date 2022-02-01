package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class d
{
  final l SSe;
  final String name;
  final c wJt;
  
  public d(c paramc, String paramString)
  {
    this(paramc, paramString, o.SSr);
  }
  
  private d(c paramc, String paramString, l paraml)
  {
    this.wJt = paramc;
    this.name = paramString;
    this.SSe = paraml;
  }
  
  public final void a(d.c paramc)
  {
    AppMethodBeat.i(9835);
    c localc = this.wJt;
    String str = this.name;
    if (paramc == null) {}
    for (paramc = null;; paramc = new b(paramc))
    {
      localc.a(str, paramc);
      AppMethodBeat.o(9835);
      return;
    }
  }
  
  final class b
    implements c.a
  {
    private final d.c SSf;
    final AtomicReference<d.a> SSg;
    
    b(d.c paramc)
    {
      AppMethodBeat.i(9843);
      this.SSg = new AtomicReference(null);
      this.SSf = paramc;
      AppMethodBeat.o(9843);
    }
    
    public final void a(ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(9844);
      paramByteBuffer = d.this.SSe.K(paramByteBuffer);
      if (paramByteBuffer.method.equals("listen"))
      {
        paramByteBuffer = paramByteBuffer.SxX;
        a locala = new a((byte)0);
        if ((d.a)this.SSg.getAndSet(locala) != null) {}
        try
        {
          this.SSf.sT();
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            try
            {
              this.SSf.a(paramByteBuffer, locala);
              paramb.I(d.this.SSe.eQ(null));
              AppMethodBeat.o(9844);
              return;
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.SSg.set(null);
              new StringBuilder("EventChannel#").append(d.this.name);
              paramb.I(d.this.SSe.h("error", paramByteBuffer.getMessage(), null));
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
        if ((d.a)this.SSg.getAndSet(null) != null) {
          try
          {
            this.SSf.sT();
            paramb.I(d.this.SSe.eQ(null));
            AppMethodBeat.o(9844);
            return;
          }
          catch (RuntimeException paramByteBuffer)
          {
            new StringBuilder("EventChannel#").append(d.this.name);
            paramb.I(d.this.SSe.h("error", paramByteBuffer.getMessage(), null));
            AppMethodBeat.o(9844);
            return;
          }
        }
        paramb.I(d.this.SSe.h("error", "No active stream to cancel", null));
        AppMethodBeat.o(9844);
        return;
      }
      paramb.I(null);
      AppMethodBeat.o(9844);
    }
    
    final class a
      implements d.a
    {
      final AtomicBoolean SSi;
      
      private a()
      {
        AppMethodBeat.i(9831);
        this.SSi = new AtomicBoolean(false);
        AppMethodBeat.o(9831);
      }
      
      public final void awU()
      {
        AppMethodBeat.i(9834);
        if ((this.SSi.getAndSet(true)) || (d.b.this.SSg.get() != this))
        {
          AppMethodBeat.o(9834);
          return;
        }
        d.this.wJt.a(d.this.name, null);
        AppMethodBeat.o(9834);
      }
      
      public final void b(String paramString1, String paramString2, Object paramObject)
      {
        AppMethodBeat.i(9833);
        if ((this.SSi.get()) || (d.b.this.SSg.get() != this))
        {
          AppMethodBeat.o(9833);
          return;
        }
        d.this.wJt.a(d.this.name, d.this.SSe.h(paramString1, paramString2, paramObject));
        AppMethodBeat.o(9833);
      }
      
      public final void ba(Object paramObject)
      {
        AppMethodBeat.i(9832);
        if ((this.SSi.get()) || (d.b.this.SSg.get() != this))
        {
          AppMethodBeat.o(9832);
          return;
        }
        d.this.wJt.a(d.this.name, d.this.SSe.eQ(paramObject));
        AppMethodBeat.o(9832);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */