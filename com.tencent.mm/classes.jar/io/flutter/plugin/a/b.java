package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class b<T>
{
  final i<T> NcO;
  public final String name;
  public final c vOl;
  
  public b(c paramc, String paramString, i<T> parami)
  {
    this.vOl = paramc;
    this.name = paramString;
    this.NcO = parami;
  }
  
  public final void eI(T paramT)
  {
    AppMethodBeat.i(9842);
    this.vOl.a(this.name, this.NcO.eJ(paramT), null);
    AppMethodBeat.o(9842);
  }
  
  public final class a
    implements c.a
  {
    private final b.b<T> NcP;
    
    private a()
    {
      Object localObject;
      this.NcP = localObject;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9830);
      try
      {
        b.b localb = this.NcP;
        paramByteBuffer = b.this.NcO.J(paramByteBuffer);
        new Object() {};
        localb.eH(paramByteBuffer);
        AppMethodBeat.o(9830);
        return;
      }
      catch (RuntimeException paramByteBuffer)
      {
        new StringBuilder("BasicMessageChannel#").append(b.this.name);
        paramb.I(null);
        AppMethodBeat.o(9830);
      }
    }
  }
  
  public static abstract interface b<T>
  {
    public abstract void eH(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */