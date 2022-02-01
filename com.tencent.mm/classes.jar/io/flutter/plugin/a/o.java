package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class o
  implements l
{
  public static final o aauS;
  private final n aauT;
  
  static
  {
    AppMethodBeat.i(9873);
    aauS = new o(n.aauQ);
    AppMethodBeat.o(9873);
  }
  
  private o(n paramn)
  {
    this.aauT = paramn;
  }
  
  public final j G(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9869);
    paramByteBuffer.order(ByteOrder.nativeOrder());
    Object localObject1 = this.aauT.K(paramByteBuffer);
    Object localObject2 = this.aauT.K(paramByteBuffer);
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
  
  public final Object H(ByteBuffer paramByteBuffer)
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
      localObject1 = this.aauT.K(paramByteBuffer);
      if (!paramByteBuffer.hasRemaining())
      {
        AppMethodBeat.o(9872);
        return localObject1;
      }
      localObject1 = this.aauT.K(paramByteBuffer);
      localObject2 = this.aauT.K(paramByteBuffer);
      localObject3 = this.aauT.K(paramByteBuffer);
    } while ((!(localObject1 instanceof String)) || ((localObject2 != null) && (!(localObject2 instanceof String))) || (paramByteBuffer.hasRemaining()));
    paramByteBuffer = new e((String)localObject1, (String)localObject2, localObject3);
    AppMethodBeat.o(9872);
    throw paramByteBuffer;
  }
  
  public final ByteBuffer b(j paramj)
  {
    AppMethodBeat.i(9868);
    n.a locala = new n.a();
    this.aauT.a(locala, paramj.method);
    this.aauT.a(locala, paramj.ZZe);
    paramj = ByteBuffer.allocateDirect(locala.size());
    paramj.put(locala.iBo(), 0, locala.size());
    AppMethodBeat.o(9868);
    return paramj;
  }
  
  public final ByteBuffer bw(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(254803);
    n.a locala = new n.a();
    locala.write(1);
    this.aauT.a(locala, paramString1);
    this.aauT.a(locala, paramString2);
    this.aauT.a(locala, null);
    this.aauT.a(locala, paramString3);
    paramString1 = ByteBuffer.allocateDirect(locala.size());
    paramString1.put(locala.iBo(), 0, locala.size());
    AppMethodBeat.o(254803);
    return paramString1;
  }
  
  public final ByteBuffer eV(Object paramObject)
  {
    AppMethodBeat.i(9870);
    n.a locala = new n.a();
    locala.write(0);
    this.aauT.a(locala, paramObject);
    paramObject = ByteBuffer.allocateDirect(locala.size());
    paramObject.put(locala.iBo(), 0, locala.size());
    AppMethodBeat.o(9870);
    return paramObject;
  }
  
  public final ByteBuffer h(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(9871);
    n.a locala = new n.a();
    locala.write(1);
    this.aauT.a(locala, paramString1);
    this.aauT.a(locala, paramString2);
    if ((paramObject instanceof Throwable))
    {
      paramString1 = this.aauT;
      paramString2 = (Throwable)paramObject;
      paramObject = new StringWriter();
      paramString2.printStackTrace(new PrintWriter(paramObject));
      paramString1.a(locala, paramObject.toString());
    }
    for (;;)
    {
      paramString1 = ByteBuffer.allocateDirect(locala.size());
      paramString1.put(locala.iBo(), 0, locala.size());
      AppMethodBeat.o(9871);
      return paramString1;
      this.aauT.a(locala, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.a.o
 * JD-Core Version:    0.7.0.1
 */