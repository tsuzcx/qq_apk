package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class b<T>
{
  public final c aauy;
  final i<T> aauz;
  public final String name;
  
  public b(c paramc, String paramString, i<T> parami)
  {
    this.aauy = paramc;
    this.name = paramString;
    this.aauz = parami;
  }
  
  public final void b(T paramT, d<T> paramd)
  {
    AppMethodBeat.i(253821);
    c localc = this.aauy;
    String str = this.name;
    ByteBuffer localByteBuffer = this.aauz.eU(paramT);
    if (paramd == null) {}
    for (paramT = null;; paramT = new b(paramd, (byte)0))
    {
      localc.a(str, localByteBuffer, paramT);
      AppMethodBeat.o(253821);
      return;
    }
  }
  
  public final class a
    implements c.a
  {
    private final b.c<T> aauA;
    
    private a()
    {
      Object localObject;
      this.aauA = localObject;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9830);
      try
      {
        this.aauA.a(b.this.aauz.F(paramByteBuffer), new b.d()
        {
          public final void eT(T paramAnonymousT)
          {
            AppMethodBeat.i(255965);
            paramb.E(b.this.aauz.eU(paramAnonymousT));
            AppMethodBeat.o(255965);
          }
        });
        AppMethodBeat.o(9830);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        new StringBuilder("BasicMessageChannel#").append(b.this.name);
        io.flutter.b.iAi();
        paramb.E(null);
        AppMethodBeat.o(9830);
      }
    }
  }
  
  final class b
    implements c.b
  {
    private final b.d<T> aauE;
    
    private b()
    {
      Object localObject;
      this.aauE = localObject;
    }
    
    public final void E(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(253912);
      try
      {
        this.aauE.eT(b.this.aauz.F(paramByteBuffer));
        AppMethodBeat.o(253912);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        new StringBuilder("BasicMessageChannel#").append(b.this.name);
        io.flutter.b.iAi();
        AppMethodBeat.o(253912);
      }
    }
  }
  
  public static abstract interface c<T>
  {
    public abstract void a(T paramT, b.d<T> paramd);
  }
  
  public static abstract interface d<T>
  {
    public abstract void eT(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */