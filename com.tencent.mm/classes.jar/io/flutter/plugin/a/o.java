package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class o
  implements l
{
  public static final o KPd;
  private final n KPe;
  
  static
  {
    AppMethodBeat.i(9873);
    KPd = new o(n.KPb);
    AppMethodBeat.o(9873);
  }
  
  private o(n paramn)
  {
    this.KPe = paramn;
  }
  
  public final j J(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9869);
    paramByteBuffer.order(ByteOrder.nativeOrder());
    Object localObject1 = this.KPe.N(paramByteBuffer);
    Object localObject2 = this.KPe.N(paramByteBuffer);
    if (((localObject1 instanceof String)) && (!paramByteBuffer.hasRemaining()))
    {
      paramByteBuffer = new j((String)localObject1, localObject2);
      AppMethodBeat.o(9869);
      return paramByteBuffer;
    }
    paramByteBuffer = new IllegalArgumentException("Method call corrupted");
    AppMethodBeat.o(9869);
    throw paramByteBuffer;
  }
  
  public final Object K(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9872);
    paramByteBuffer.order(ByteOrder.nativeOrder());
    switch (paramByteBuffer.get())
    {
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    do
    {
      paramByteBuffer = new IllegalArgumentException("Envelope corrupted");
      AppMethodBeat.o(9872);
      throw paramByteBuffer;
      localObject1 = this.KPe.N(paramByteBuffer);
      if (!paramByteBuffer.hasRemaining())
      {
        AppMethodBeat.o(9872);
        return localObject1;
      }
      localObject1 = this.KPe.N(paramByteBuffer);
      localObject2 = this.KPe.N(paramByteBuffer);
      localObject3 = this.KPe.N(paramByteBuffer);
    } while ((!(localObject1 instanceof String)) || ((localObject2 != null) && (!(localObject2 instanceof String))) || (paramByteBuffer.hasRemaining()));
    paramByteBuffer = new e((String)localObject1, (String)localObject2, localObject3);
    AppMethodBeat.o(9872);
    throw paramByteBuffer;
  }
  
  public final ByteBuffer b(j paramj)
  {
    AppMethodBeat.i(9868);
    n.a locala = new n.a();
    this.KPe.a(locala, paramj.method);
    this.KPe.a(locala, paramj.fXJ);
    paramj = ByteBuffer.allocateDirect(locala.size());
    paramj.put(locala.buffer(), 0, locala.size());
    AppMethodBeat.o(9868);
    return paramj;
  }
  
  public final ByteBuffer eE(Object paramObject)
  {
    AppMethodBeat.i(9870);
    n.a locala = new n.a();
    locala.write(0);
    this.KPe.a(locala, paramObject);
    paramObject = ByteBuffer.allocateDirect(locala.size());
    paramObject.put(locala.buffer(), 0, locala.size());
    AppMethodBeat.o(9870);
    return paramObject;
  }
  
  public final ByteBuffer i(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(9871);
    n.a locala = new n.a();
    locala.write(1);
    this.KPe.a(locala, paramString1);
    this.KPe.a(locala, paramString2);
    this.KPe.a(locala, paramObject);
    paramString1 = ByteBuffer.allocateDirect(locala.size());
    paramString1.put(locala.buffer(), 0, locala.size());
    AppMethodBeat.o(9871);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.plugin.a.o
 * JD-Core Version:    0.7.0.1
 */