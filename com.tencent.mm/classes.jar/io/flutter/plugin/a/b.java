package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class b<T>
{
  final i<T> SRZ;
  final String name;
  private final c wJt;
  
  public b(c paramc, String paramString, i<T> parami)
  {
    this.wJt = paramc;
    this.name = paramString;
    this.SRZ = parami;
  }
  
  public final void a(b.b<T> paramb)
  {
    AppMethodBeat.i(214888);
    c localc = this.wJt;
    String str = this.name;
    if (paramb == null) {}
    for (paramb = null;; paramb = new a(paramb, (byte)0))
    {
      localc.a(str, paramb);
      AppMethodBeat.o(214888);
      return;
    }
  }
  
  public final void eN(T paramT)
  {
    AppMethodBeat.i(9842);
    this.wJt.a(this.name, this.SRZ.eP(paramT), null);
    AppMethodBeat.o(9842);
  }
  
  final class a
    implements c.a
  {
    private final b.b<T> SSa;
    
    private a()
    {
      Object localObject;
      this.SSa = localObject;
    }
    
    public final void a(ByteBuffer paramByteBuffer, final c.b paramb)
    {
      AppMethodBeat.i(9830);
      try
      {
        this.SSa.a(b.this.SRZ.J(paramByteBuffer), new b.c()
        {
          public final void eO(T paramAnonymousT)
          {
            AppMethodBeat.i(214887);
            paramb.I(b.this.SRZ.eP(paramAnonymousT));
            AppMethodBeat.o(214887);
          }
        });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.plugin.a.b
 * JD-Core Version:    0.7.0.1
 */