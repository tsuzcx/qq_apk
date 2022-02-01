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
  private final FlutterJNI SNV;
  private final Map<String, c.a> SOQ;
  private final Map<Integer, c.b> SOR;
  private int SOS;
  
  a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10206);
    this.SOS = 1;
    this.SNV = paramFlutterJNI;
    this.SOQ = new HashMap();
    this.SOR = new HashMap();
    AppMethodBeat.o(10206);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10207);
    if (parama == null)
    {
      new StringBuilder("Removing handler for channel '").append(paramString).append("'");
      io.flutter.a.hwd();
      this.SOQ.remove(paramString);
      AppMethodBeat.o(10207);
      return;
    }
    new StringBuilder("Setting handler for channel '").append(paramString).append("'");
    io.flutter.a.hwd();
    this.SOQ.put(paramString, parama);
    AppMethodBeat.o(10207);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10208);
    new StringBuilder("Sending message over channel '").append(paramString).append("'");
    io.flutter.a.hwd();
    a(paramString, paramByteBuffer, null);
    AppMethodBeat.o(10208);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10209);
    new StringBuilder("Sending message with callback over channel '").append(paramString).append("'");
    io.flutter.a.hwd();
    int i = 0;
    if (paramb != null)
    {
      i = this.SOS;
      this.SOS = (i + 1);
      this.SOR.put(Integer.valueOf(i), paramb);
    }
    if (paramByteBuffer == null)
    {
      this.SNV.dispatchEmptyPlatformMessage(paramString, i);
      AppMethodBeat.o(10209);
      return;
    }
    this.SNV.dispatchPlatformMessage(paramString, paramByteBuffer, paramByteBuffer.position(), i);
    AppMethodBeat.o(10209);
  }
  
  public final void g(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(10210);
    new StringBuilder("Received message from Dart over channel '").append(paramString).append("'");
    io.flutter.a.hwd();
    c.a locala = (c.a)this.SOQ.get(paramString);
    if (locala != null) {
      try
      {
        io.flutter.a.hwd();
        if (paramArrayOfByte == null) {}
        for (paramString = null;; paramString = ByteBuffer.wrap(paramArrayOfByte))
        {
          locala.a(paramString, new a(this.SNV, paramInt));
          AppMethodBeat.o(10210);
          return;
        }
        io.flutter.a.hwd();
      }
      catch (Exception paramString)
      {
        io.flutter.a.hwh();
        this.SNV.invokePlatformMessageEmptyResponseCallback(paramInt);
        AppMethodBeat.o(10210);
        return;
      }
    }
    this.SNV.invokePlatformMessageEmptyResponseCallback(paramInt);
    AppMethodBeat.o(10210);
  }
  
  public final void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10211);
    io.flutter.a.hwd();
    c.b localb = (c.b)this.SOR.remove(Integer.valueOf(paramInt));
    if (localb != null) {
      try
      {
        io.flutter.a.hwd();
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
        io.flutter.a.hwh();
      }
    }
  }
  
  static final class a
    implements c.b
  {
    private final FlutterJNI SNV;
    private final int SOT;
    private final AtomicBoolean SOU;
    
    a(FlutterJNI paramFlutterJNI, int paramInt)
    {
      AppMethodBeat.i(10215);
      this.SOU = new AtomicBoolean(false);
      this.SNV = paramFlutterJNI;
      this.SOT = paramInt;
      AppMethodBeat.o(10215);
    }
    
    public final void I(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(10216);
      if (this.SOU.getAndSet(true))
      {
        paramByteBuffer = new IllegalStateException("Reply already submitted");
        AppMethodBeat.o(10216);
        throw paramByteBuffer;
      }
      if (paramByteBuffer == null)
      {
        this.SNV.invokePlatformMessageEmptyResponseCallback(this.SOT);
        AppMethodBeat.o(10216);
        return;
      }
      this.SNV.invokePlatformMessageResponseCallback(this.SOT, paramByteBuffer, paramByteBuffer.position());
      AppMethodBeat.o(10216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.a
 * JD-Core Version:    0.7.0.1
 */