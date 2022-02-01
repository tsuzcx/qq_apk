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
  private final FlutterJNI aapT;
  private final Map<String, c.a> aaqP;
  private final Map<Integer, c.b> aaqQ;
  private int aaqR;
  
  a(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10206);
    this.aaqR = 1;
    this.aapT = paramFlutterJNI;
    this.aaqP = new HashMap();
    this.aaqQ = new HashMap();
    AppMethodBeat.o(10206);
  }
  
  private static void a(Error paramError)
  {
    AppMethodBeat.i(254938);
    Thread localThread = Thread.currentThread();
    if (localThread.getUncaughtExceptionHandler() == null)
    {
      AppMethodBeat.o(254938);
      throw paramError;
    }
    localThread.getUncaughtExceptionHandler().uncaughtException(localThread, paramError);
    AppMethodBeat.o(254938);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10207);
    if (parama == null)
    {
      new StringBuilder("Removing handler for channel '").append(paramString).append("'");
      io.flutter.b.iAd();
      this.aaqP.remove(paramString);
      AppMethodBeat.o(10207);
      return;
    }
    new StringBuilder("Setting handler for channel '").append(paramString).append("'");
    io.flutter.b.iAd();
    this.aaqP.put(paramString, parama);
    AppMethodBeat.o(10207);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10208);
    new StringBuilder("Sending message over channel '").append(paramString).append("'");
    io.flutter.b.iAd();
    a(paramString, paramByteBuffer, null);
    AppMethodBeat.o(10208);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10209);
    new StringBuilder("Sending message with callback over channel '").append(paramString).append("'");
    io.flutter.b.iAd();
    int i = 0;
    if (paramb != null)
    {
      i = this.aaqR;
      this.aaqR = (i + 1);
      this.aaqQ.put(Integer.valueOf(i), paramb);
    }
    if (paramByteBuffer == null)
    {
      this.aapT.dispatchEmptyPlatformMessage(paramString, i);
      AppMethodBeat.o(10209);
      return;
    }
    this.aapT.dispatchPlatformMessage(paramString, paramByteBuffer, paramByteBuffer.position(), i);
    AppMethodBeat.o(10209);
  }
  
  public final void g(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(10210);
    new StringBuilder("Received message from Dart over channel '").append(paramString).append("'");
    io.flutter.b.iAd();
    c.a locala = (c.a)this.aaqP.get(paramString);
    if (locala != null) {
      try
      {
        io.flutter.b.iAd();
        if (paramArrayOfByte == null) {}
        for (paramString = null;; paramString = ByteBuffer.wrap(paramArrayOfByte))
        {
          locala.a(paramString, new a(this.aapT, paramInt));
          AppMethodBeat.o(10210);
          return;
        }
        io.flutter.b.iAd();
      }
      catch (Exception paramString)
      {
        io.flutter.b.iAi();
        this.aapT.invokePlatformMessageEmptyResponseCallback(paramInt);
        AppMethodBeat.o(10210);
        return;
      }
      catch (Error paramString)
      {
        a(paramString);
        AppMethodBeat.o(10210);
        return;
      }
    }
    this.aapT.invokePlatformMessageEmptyResponseCallback(paramInt);
    AppMethodBeat.o(10210);
  }
  
  public final void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10211);
    io.flutter.b.iAd();
    c.b localb = (c.b)this.aaqQ.remove(Integer.valueOf(paramInt));
    if (localb != null) {
      try
      {
        io.flutter.b.iAd();
        if (paramArrayOfByte == null) {}
        for (paramArrayOfByte = null;; paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte))
        {
          localb.E(paramArrayOfByte);
          AppMethodBeat.o(10211);
          return;
        }
        AppMethodBeat.o(10211);
      }
      catch (Exception paramArrayOfByte)
      {
        io.flutter.b.iAi();
        AppMethodBeat.o(10211);
        return;
      }
      catch (Error paramArrayOfByte)
      {
        a(paramArrayOfByte);
      }
    }
  }
  
  static final class a
    implements c.b
  {
    private final FlutterJNI aapT;
    private final int aaqS;
    private final AtomicBoolean aaqT;
    
    a(FlutterJNI paramFlutterJNI, int paramInt)
    {
      AppMethodBeat.i(10215);
      this.aaqT = new AtomicBoolean(false);
      this.aapT = paramFlutterJNI;
      this.aaqS = paramInt;
      AppMethodBeat.o(10215);
    }
    
    public final void E(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(10216);
      if (this.aaqT.getAndSet(true))
      {
        paramByteBuffer = new IllegalStateException("Reply already submitted");
        AppMethodBeat.o(10216);
        throw paramByteBuffer;
      }
      if (paramByteBuffer == null)
      {
        this.aapT.invokePlatformMessageEmptyResponseCallback(this.aaqS);
        AppMethodBeat.o(10216);
        return;
      }
      this.aapT.invokePlatformMessageResponseCallback(this.aaqS, paramByteBuffer, paramByteBuffer.position());
      AppMethodBeat.o(10216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.a
 * JD-Core Version:    0.7.0.1
 */