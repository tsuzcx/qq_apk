package io.flutter.embedding.engine.dart;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.c.a;
import io.flutter.plugin.a.c.b;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class a
  implements b, c
{
  private final FlutterJNI MCg;
  private final Map<String, c.a> MDa;
  private final Map<Integer, c.b> MDb;
  private int MDc;
  
  a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10206);
    this.MDc = 1;
    this.MCg = paramFlutterJNI;
    this.MDa = new HashMap();
    this.MDb = new HashMap();
    AppMethodBeat.o(10206);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10207);
    if (parama == null)
    {
      new StringBuilder("Removing handler for channel '").append(paramString).append("'");
      io.flutter.a.gea();
      this.MDa.remove(paramString);
      AppMethodBeat.o(10207);
      return;
    }
    new StringBuilder("Setting handler for channel '").append(paramString).append("'");
    io.flutter.a.gea();
    this.MDa.put(paramString, parama);
    AppMethodBeat.o(10207);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10208);
    new StringBuilder("Sending message over channel '").append(paramString).append("'");
    io.flutter.a.gea();
    a(paramString, paramByteBuffer, null);
    AppMethodBeat.o(10208);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10209);
    new StringBuilder("Sending message with callback over channel '").append(paramString).append("'");
    io.flutter.a.gea();
    int i = 0;
    if (paramb != null)
    {
      i = this.MDc;
      this.MDc = (i + 1);
      this.MDb.put(Integer.valueOf(i), paramb);
    }
    if (paramByteBuffer == null)
    {
      this.MCg.dispatchEmptyPlatformMessage(paramString, i);
      AppMethodBeat.o(10209);
      return;
    }
    this.MCg.dispatchPlatformMessage(paramString, paramByteBuffer, paramByteBuffer.position(), i);
    AppMethodBeat.o(10209);
  }
  
  public final void g(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(10210);
    new StringBuilder("Received message from Dart over channel '").append(paramString).append("'");
    io.flutter.a.gea();
    c.a locala = (c.a)this.MDa.get(paramString);
    if (locala != null) {
      try
      {
        io.flutter.a.gea();
        if (paramArrayOfByte == null) {}
        for (paramString = null;; paramString = ByteBuffer.wrap(paramArrayOfByte))
        {
          locala.a(paramString, new a(this.MCg, paramInt));
          AppMethodBeat.o(10210);
          return;
        }
        io.flutter.a.gea();
      }
      catch (Exception paramString)
      {
        io.flutter.a.gef();
        this.MCg.invokePlatformMessageEmptyResponseCallback(paramInt);
        AppMethodBeat.o(10210);
        return;
      }
    }
    this.MCg.invokePlatformMessageEmptyResponseCallback(paramInt);
    AppMethodBeat.o(10210);
  }
  
  public final void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10211);
    io.flutter.a.gea();
    c.b localb = (c.b)this.MDb.remove(Integer.valueOf(paramInt));
    if (localb != null) {
      try
      {
        io.flutter.a.gea();
        if (paramArrayOfByte == null) {}
        for (paramArrayOfByte = null;; paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte))
        {
          localb.I(paramArrayOfByte);
          AppMethodBeat.o(10211);
          return;
        }
        AppMethodBeat.o(10211);
      }
      catch (Exception paramArrayOfByte)
      {
        io.flutter.a.gef();
      }
    }
  }
  
  static final class a
    implements c.b
  {
    private final FlutterJNI MCg;
    private final int MDd;
    private final AtomicBoolean MDe;
    
    a(FlutterJNI paramFlutterJNI, int paramInt)
    {
      AppMethodBeat.i(10215);
      this.MDe = new AtomicBoolean(false);
      this.MCg = paramFlutterJNI;
      this.MDd = paramInt;
      AppMethodBeat.o(10215);
    }
    
    public final void I(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(10216);
      if (this.MDe.getAndSet(true))
      {
        paramByteBuffer = new IllegalStateException("Reply already submitted");
        AppMethodBeat.o(10216);
        throw paramByteBuffer;
      }
      if (paramByteBuffer == null)
      {
        this.MCg.invokePlatformMessageEmptyResponseCallback(this.MDd);
        AppMethodBeat.o(10216);
        return;
      }
      this.MCg.invokePlatformMessageResponseCallback(this.MDd, paramByteBuffer, paramByteBuffer.position());
      AppMethodBeat.o(10216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.a
 * JD-Core Version:    0.7.0.1
 */