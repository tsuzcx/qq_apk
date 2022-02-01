package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class b<T>
{
  final i<T> MFI;
  public final String name;
  public final c vCh;
  
  public b(c paramc, String paramString, i<T> parami)
  {
    this.vCh = paramc;
    this.name = paramString;
    this.MFI = parami;
  }
  
  public final void eF(T paramT)
  {
    AppMethodBeat.i(9842);
    this.vCh.a(this.name, this.MFI.eG(paramT), null);
    AppMethodBeat.o(9842);
  }
  
  public final class a
    implements c.a
  {
    private final b.b<T> MFJ;
    
    private a()
    {
      Object localObject;
      this.MFJ = localObject;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9830);
      try
      {
        b.b localb = this.MFJ;
        paramByteBuffer = b.this.MFI.J(paramByteBuffer);
        new Object() {};
        localb.eE(paramByteBuffer);
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
    public abstract void eE(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */