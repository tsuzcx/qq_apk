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
  private final FlutterJNI MZl;
  private final Map<String, c.a> Naf;
  private final Map<Integer, c.b> Nag;
  private int Nah;
  
  a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10206);
    this.Nah = 1;
    this.MZl = paramFlutterJNI;
    this.Naf = new HashMap();
    this.Nag = new HashMap();
    AppMethodBeat.o(10206);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10207);
    if (parama == null)
    {
      new StringBuilder("Removing handler for channel '").append(paramString).append("'");
      io.flutter.a.giD();
      this.Naf.remove(paramString);
      AppMethodBeat.o(10207);
      return;
    }
    new StringBuilder("Setting handler for channel '").append(paramString).append("'");
    io.flutter.a.giD();
    this.Naf.put(paramString, parama);
    AppMethodBeat.o(10207);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10208);
    new StringBuilder("Sending message over channel '").append(paramString).append("'");
    io.flutter.a.giD();
    a(paramString, paramByteBuffer, null);
    AppMethodBeat.o(10208);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10209);
    new StringBuilder("Sending message with callback over channel '").append(paramString).append("'");
    io.flutter.a.giD();
    int i = 0;
    if (paramb != null)
    {
      i = this.Nah;
      this.Nah = (i + 1);
      this.Nag.put(Integer.valueOf(i), paramb);
    }
    if (paramByteBuffer == null)
    {
      this.MZl.dispatchEmptyPlatformMessage(paramString, i);
      AppMethodBeat.o(10209);
      return;
    }
    this.MZl.dispatchPlatformMessage(paramString, paramByteBuffer, paramByteBuffer.position(), i);
    AppMethodBeat.o(10209);
  }
  
  public final void g(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(10210);
    new StringBuilder("Received message from Dart over channel '").append(paramString).append("'");
    io.flutter.a.giD();
    c.a locala = (c.a)this.Naf.get(paramString);
    if (locala != null) {
      try
      {
        io.flutter.a.giD();
        if (paramArrayOfByte == null) {}
        for (paramString = null;; paramString = ByteBuffer.wrap(paramArrayOfByte))
        {
          locala.a(paramString, new a(this.MZl, paramInt));
          AppMethodBeat.o(10210);
          return;
        }
        io.flutter.a.giD();
      }
      catch (Exception paramString)
      {
        io.flutter.a.giI();
        this.MZl.invokePlatformMessageEmptyResponseCallback(paramInt);
        AppMethodBeat.o(10210);
        return;
      }
    }
    this.MZl.invokePlatformMessageEmptyResponseCallback(paramInt);
    AppMethodBeat.o(10210);
  }
  
  public final void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10211);
    io.flutter.a.giD();
    c.b localb = (c.b)this.Nag.remove(Integer.valueOf(paramInt));
    if (localb != null) {
      try
      {
        io.flutter.a.giD();
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
        io.flutter.a.giI();
      }
    }
  }
  
  static final class a
    implements c.b
  {
    private final FlutterJNI MZl;
    private final int Nai;
    private final AtomicBoolean Naj;
    
    a(FlutterJNI paramFlutterJNI, int paramInt)
    {
      AppMethodBeat.i(10215);
      this.Naj = new AtomicBoolean(false);
      this.MZl = paramFlutterJNI;
      this.Nai = paramInt;
      AppMethodBeat.o(10215);
    }
    
    public final void I(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(10216);
      if (this.Naj.getAndSet(true))
      {
        paramByteBuffer = new IllegalStateException("Reply already submitted");
        AppMethodBeat.o(10216);
        throw paramByteBuffer;
      }
      if (paramByteBuffer == null)
      {
        this.MZl.invokePlatformMessageEmptyResponseCallback(this.Nai);
        AppMethodBeat.o(10216);
        return;
      }
      this.MZl.invokePlatformMessageResponseCallback(this.Nai, paramByteBuffer, paramByteBuffer.position());
      AppMethodBeat.o(10216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.a
 * JD-Core Version:    0.7.0.1
 */