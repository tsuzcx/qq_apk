package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.c.a;
import io.flutter.plugin.a.c.b;
import io.flutter.plugin.a.p;
import java.nio.ByteBuffer;

public class DartExecutor
  implements c
{
  private final a MCQ;
  public final c MCR;
  public boolean MCS;
  public String MCT;
  private c MCU;
  private final c.a MCV;
  private final FlutterJNI MCg;
  private final AssetManager aFl;
  
  public DartExecutor(FlutterJNI paramFlutterJNI, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(10198);
    this.MCS = false;
    this.MCV = new c.a()
    {
      public final void a(ByteBuffer paramAnonymousByteBuffer, c.b paramAnonymousb)
      {
        AppMethodBeat.i(10205);
        paramAnonymousb = DartExecutor.this;
        p localp = p.MGc;
        DartExecutor.a(paramAnonymousb, p.P(paramAnonymousByteBuffer));
        if (DartExecutor.a(DartExecutor.this) != null)
        {
          DartExecutor.a(DartExecutor.this);
          DartExecutor.b(DartExecutor.this);
        }
        AppMethodBeat.o(10205);
      }
    };
    this.MCg = paramFlutterJNI;
    this.aFl = paramAssetManager;
    this.MCQ = new a(paramFlutterJNI);
    this.MCQ.a("flutter/isolate", this.MCV);
    this.MCR = new b(this.MCQ, (byte)0);
    AppMethodBeat.o(10198);
  }
  
  public final void a(DartExecutor.a parama)
  {
    AppMethodBeat.i(10201);
    if (this.MCS)
    {
      io.flutter.a.ged();
      AppMethodBeat.o(10201);
      return;
    }
    new StringBuilder("Executing Dart entrypoint: ").append(parama);
    io.flutter.a.gea();
    this.MCg.runBundleAndSnapshotFromLibrary(parama.MCX, parama.MCY, null, this.aFl);
    this.MCS = true;
    AppMethodBeat.o(10201);
  }
  
  @Deprecated
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10204);
    this.MCR.a(paramString, parama);
    AppMethodBeat.o(10204);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10202);
    this.MCR.a(paramString, paramByteBuffer);
    AppMethodBeat.o(10202);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10203);
    this.MCR.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(10203);
  }
  
  public final boolean geP()
  {
    return this.MCS;
  }
  
  public void onAttachedToJNI()
  {
    AppMethodBeat.i(10199);
    io.flutter.a.gea();
    this.MCg.setPlatformMessageHandler(this.MCQ);
    AppMethodBeat.o(10199);
  }
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(10200);
    io.flutter.a.gea();
    this.MCg.setPlatformMessageHandler(null);
    AppMethodBeat.o(10200);
  }
  
  static final class b
    implements c
  {
    private final a MCZ;
    
    private b(a parama)
    {
      this.MCZ = parama;
    }
    
    public final void a(String paramString, c.a parama)
    {
      AppMethodBeat.i(213259);
      this.MCZ.a(paramString, parama);
      AppMethodBeat.o(213259);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(213257);
      this.MCZ.a(paramString, paramByteBuffer, null);
      AppMethodBeat.o(213257);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(213258);
      this.MCZ.a(paramString, paramByteBuffer, paramb);
      AppMethodBeat.o(213258);
    }
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor
 * JD-Core Version:    0.7.0.1
 */