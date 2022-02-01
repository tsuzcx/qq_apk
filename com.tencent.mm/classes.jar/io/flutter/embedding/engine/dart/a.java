package io.flutter.embedding.engine.dart;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.c;
import io.flutter.a.a.c.a;
import io.flutter.a.a.c.b;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class a
  implements c, b
{
  private final Map<String, c.a> IYX;
  private final Map<Integer, c.b> IYY;
  private int IYZ;
  private final FlutterJNI IYd;
  
  a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10206);
    this.IYZ = 1;
    this.IYd = paramFlutterJNI;
    this.IYX = new HashMap();
    this.IYY = new HashMap();
    AppMethodBeat.o(10206);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10207);
    if (parama == null)
    {
      new StringBuilder("Removing handler for channel '").append(paramString).append("'");
      io.flutter.a.ftS();
      this.IYX.remove(paramString);
      AppMethodBeat.o(10207);
      return;
    }
    new StringBuilder("Setting handler for channel '").append(paramString).append("'");
    io.flutter.a.ftS();
    this.IYX.put(paramString, parama);
    AppMethodBeat.o(10207);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10208);
    new StringBuilder("Sending message over channel '").append(paramString).append("'");
    io.flutter.a.ftS();
    a(paramString, paramByteBuffer, null);
    AppMethodBeat.o(10208);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10209);
    new StringBuilder("Sending message with callback over channel '").append(paramString).append("'");
    io.flutter.a.ftS();
    int i = 0;
    if (paramb != null)
    {
      i = this.IYZ;
      this.IYZ = (i + 1);
      this.IYY.put(Integer.valueOf(i), paramb);
    }
    if (paramByteBuffer == null)
    {
      this.IYd.dispatchEmptyPlatformMessage(paramString, i);
      AppMethodBeat.o(10209);
      return;
    }
    this.IYd.dispatchPlatformMessage(paramString, paramByteBuffer, paramByteBuffer.position(), i);
    AppMethodBeat.o(10209);
  }
  
  public final void g(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(10210);
    new StringBuilder("Received message from Dart over channel '").append(paramString).append("'");
    io.flutter.a.ftS();
    c.a locala = (c.a)this.IYX.get(paramString);
    if (locala != null) {
      try
      {
        io.flutter.a.ftS();
        if (paramArrayOfByte == null) {}
        for (paramString = null;; paramString = ByteBuffer.wrap(paramArrayOfByte))
        {
          locala.a(paramString, new a(this.IYd, paramInt));
          AppMethodBeat.o(10210);
          return;
        }
        io.flutter.a.ftS();
      }
      catch (Exception paramString)
      {
        io.flutter.a.ftW();
        this.IYd.invokePlatformMessageEmptyResponseCallback(paramInt);
        AppMethodBeat.o(10210);
        return;
      }
    }
    this.IYd.invokePlatformMessageEmptyResponseCallback(paramInt);
    AppMethodBeat.o(10210);
  }
  
  public final void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10211);
    io.flutter.a.ftS();
    c.b localb = (c.b)this.IYY.remove(Integer.valueOf(paramInt));
    if (localb != null) {
      try
      {
        io.flutter.a.ftS();
        if (paramArrayOfByte == null) {}
        for (paramArrayOfByte = null;; paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte))
        {
          localb.H(paramArrayOfByte);
          AppMethodBeat.o(10211);
          return;
        }
        AppMethodBeat.o(10211);
      }
      catch (Exception paramArrayOfByte)
      {
        io.flutter.a.ftW();
      }
    }
  }
  
  static final class a
    implements c.b
  {
    private final FlutterJNI IYd;
    private final int IZa;
    private final AtomicBoolean IZb;
    
    a(FlutterJNI paramFlutterJNI, int paramInt)
    {
      AppMethodBeat.i(10215);
      this.IZb = new AtomicBoolean(false);
      this.IYd = paramFlutterJNI;
      this.IZa = paramInt;
      AppMethodBeat.o(10215);
    }
    
    public final void H(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(10216);
      if (this.IZb.getAndSet(true))
      {
        paramByteBuffer = new IllegalStateException("Reply already submitted");
        AppMethodBeat.o(10216);
        throw paramByteBuffer;
      }
      if (paramByteBuffer == null)
      {
        this.IYd.invokePlatformMessageEmptyResponseCallback(this.IZa);
        AppMethodBeat.o(10216);
        return;
      }
      this.IYd.invokePlatformMessageResponseCallback(this.IZa, paramByteBuffer, paramByteBuffer.position());
      AppMethodBeat.o(10216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.a
 * JD-Core Version:    0.7.0.1
 */