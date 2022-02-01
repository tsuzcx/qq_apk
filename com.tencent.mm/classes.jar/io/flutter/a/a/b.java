package io.flutter.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class b<T>
{
  final i<T> Jbh;
  public final String name;
  public final c trm;
  
  public b(c paramc, String paramString, i<T> parami)
  {
    this.trm = paramc;
    this.name = paramString;
    this.Jbh = parami;
  }
  
  public final void eA(T paramT)
  {
    AppMethodBeat.i(9842);
    this.trm.a(this.name, this.Jbh.eB(paramT), null);
    AppMethodBeat.o(9842);
  }
  
  public final class a
    implements c.a
  {
    private final b.b<T> Jbi;
    
    private a()
    {
      Object localObject;
      this.Jbi = localObject;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9830);
      try
      {
        b.b localb = this.Jbi;
        paramByteBuffer = b.this.Jbh.I(paramByteBuffer);
        new Object() {};
        localb.ez(paramByteBuffer);
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
    public abstract void ez(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.a.b
 * JD-Core Version:    0.7.0.1
 */