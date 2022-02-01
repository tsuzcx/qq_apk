package io.flutter.plugin.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class StandardMethodCodec
  implements MethodCodec
{
  public static final StandardMethodCodec INSTANCE;
  private final StandardMessageCodec messageCodec;
  
  static
  {
    AppMethodBeat.i(9873);
    INSTANCE = new StandardMethodCodec(StandardMessageCodec.INSTANCE);
    AppMethodBeat.o(9873);
  }
  
  public StandardMethodCodec(StandardMessageCodec paramStandardMessageCodec)
  {
    this.messageCodec = paramStandardMessageCodec;
  }
  
  private static String getStackTrace(Throwable paramThrowable)
  {
    AppMethodBeat.i(189843);
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    paramThrowable = localStringWriter.toString();
    AppMethodBeat.o(189843);
    return paramThrowable;
  }
  
  public final Object decodeEnvelope(ByteBuffer paramByteBuffer)
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
      localObject1 = this.messageCodec.readValue(paramByteBuffer);
      if (!paramByteBuffer.hasRemaining())
      {
        AppMethodBeat.o(9872);
        return localObject1;
      }
      localObject1 = this.messageCodec.readValue(paramByteBuffer);
      localObject2 = this.messageCodec.readValue(paramByteBuffer);
      localObject3 = this.messageCodec.readValue(paramByteBuffer);
    } while ((!(localObject1 instanceof String)) || ((localObject2 != null) && (!(localObject2 instanceof String))) || (paramByteBuffer.hasRemaining()));
    paramByteBuffer = new FlutterException((String)localObject1, (String)localObject2, localObject3);
    AppMethodBeat.o(9872);
    throw paramByteBuffer;
  }
  
  public final MethodCall decodeMethodCall(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9869);
    paramByteBuffer.order(ByteOrder.nativeOrder());
    Object localObject1 = this.messageCodec.readValue(paramByteBuffer);
    Object localObject2 = this.messageCodec.readValue(paramByteBuffer);
    if (((localObject1 instanceof String)) && (!paramByteBuffer.hasRemaining()))
    {
      paramByteBuffer = new MethodCall((String)localObject1, localObject2);
      AppMethodBeat.o(9869);
      return paramByteBuffer;
    }
    paramByteBuffer = new IllegalArgumentException("Method call corrupted");
    AppMethodBeat.o(9869);
    throw paramByteBuffer;
  }
  
  public final ByteBuffer encodeErrorEnvelope(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(9871);
    StandardMessageCodec.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
    localExposedByteArrayOutputStream.write(1);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString1);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString2);
    if ((paramObject instanceof Throwable)) {
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, getStackTrace((Throwable)paramObject));
    }
    for (;;)
    {
      paramString1 = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
      paramString1.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
      AppMethodBeat.o(9871);
      return paramString1;
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramObject);
    }
  }
  
  public final ByteBuffer encodeErrorEnvelopeWithStacktrace(String paramString1, String paramString2, Object paramObject, String paramString3)
  {
    AppMethodBeat.i(189885);
    StandardMessageCodec.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
    localExposedByteArrayOutputStream.write(1);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString1);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString2);
    if ((paramObject instanceof Throwable)) {
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, getStackTrace((Throwable)paramObject));
    }
    for (;;)
    {
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramString3);
      paramString1 = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
      paramString1.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
      AppMethodBeat.o(189885);
      return paramString1;
      this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramObject);
    }
  }
  
  public final ByteBuffer encodeMethodCall(MethodCall paramMethodCall)
  {
    AppMethodBeat.i(9868);
    StandardMessageCodec.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramMethodCall.method);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramMethodCall.arguments);
    paramMethodCall = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
    paramMethodCall.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
    AppMethodBeat.o(9868);
    return paramMethodCall;
  }
  
  public final ByteBuffer encodeSuccessEnvelope(Object paramObject)
  {
    AppMethodBeat.i(9870);
    StandardMessageCodec.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
    localExposedByteArrayOutputStream.write(0);
    this.messageCodec.writeValue(localExposedByteArrayOutputStream, paramObject);
    paramObject = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
    paramObject.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
    AppMethodBeat.o(9870);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.plugin.common.StandardMethodCodec
 * JD-Core Version:    0.7.0.1
 */