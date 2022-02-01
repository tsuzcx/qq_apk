package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class b<T>
{
  final i<T> KOL;
  public final String name;
  public final c uzE;
  
  public b(c paramc, String paramString, i<T> parami)
  {
    this.uzE = paramc;
    this.name = paramString;
    this.KOL = parami;
  }
  
  public final void eC(T paramT)
  {
    AppMethodBeat.i(9842);
    this.uzE.a(this.name, this.KOL.eD(paramT), null);
    AppMethodBeat.o(9842);
  }
  
  public final class a
    implements c.a
  {
    private final b.b<T> KOM;
    
    private a()
    {
      Object localObject;
      this.KOM = localObject;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9830);
      try
      {
        b.b localb = this.KOM;
        paramByteBuffer = b.this.KOL.I(paramByteBuffer);
        new Object() {};
        localb.eB(paramByteBuffer);
        AppMethodBeat.o(9830);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        new StringBuilder("BasicMessageChannel#").append(b.this.name);
        paramb.H(null);
        AppMethodBeat.o(9830);
      }
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void eB(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */