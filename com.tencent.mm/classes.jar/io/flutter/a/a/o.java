package io.flutter.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class o
  implements l
{
  public static final o Jbz;
  private final n JbA;
  
  static
  {
    AppMethodBeat.i(9873);
    Jbz = new o(n.Jbx);
    AppMethodBeat.o(9873);
  }
  
  private o(n paramn)
  {
    this.JbA = paramn;
  }
  
  public final j J(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9869);
    paramByteBuffer.order(ByteOrder.nativeOrder());
    Object localObject1 = this.JbA.N(paramByteBuffer);
    Object localObject2 = this.JbA.N(paramByteBuffer);
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
      localObject1 = this.JbA.N(paramByteBuffer);
      if (!paramByteBuffer.hasRemaining())
      {
        AppMethodBeat.o(9872);
        return localObject1;
      }
      localObject1 = this.JbA.N(paramByteBuffer);
      localObject2 = this.JbA.N(paramByteBuffer);
      localObject3 = this.JbA.N(paramByteBuffer);
    } while ((!(localObject1 instanceof String)) || ((localObject2 != null) && (!(localObject2 instanceof String))) || (paramByteBuffer.hasRemaining()));
    paramByteBuffer = new e((String)localObject1, (String)localObject2, localObject3);
    AppMethodBeat.o(9872);
    throw paramByteBuffer;
  }
  
  public final ByteBuffer a(j paramj)
  {
    AppMethodBeat.i(9868);
    n.a locala = new n.a();
    this.JbA.a(locala, paramj.method);
    this.JbA.a(locala, paramj.fTP);
    paramj = ByteBuffer.allocateDirect(locala.size());
    paramj.put(locala.buffer(), 0, locala.size());
    AppMethodBeat.o(9868);
    return paramj;
  }
  
  public final ByteBuffer eC(Object paramObject)
  {
    AppMethodBeat.i(9870);
    n.a locala = new n.a();
    locala.write(0);
    this.JbA.a(locala, paramObject);
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
    this.JbA.a(locala, paramString1);
    this.JbA.a(locala, paramString2);
    this.JbA.a(locala, paramObject);
    paramString1 = ByteBuffer.allocateDirect(locala.size());
    paramString1.put(locala.buffer(), 0, locala.size());
    AppMethodBeat.o(9871);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.a.a.o
 * JD-Core Version:    0.7.0.1
 */