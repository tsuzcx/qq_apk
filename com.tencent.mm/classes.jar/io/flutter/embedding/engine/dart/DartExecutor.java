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
  private final FlutterJNI SNV;
  private final a SOG;
  public final c SOH;
  public boolean SOI;
  public String SOJ;
  private c SOK;
  private final c.a SOL;
  private final AssetManager aFb;
  
  public DartExecutor(FlutterJNI paramFlutterJNI, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(10198);
    this.SOI = false;
    this.SOL = new c.a()
    {
      public final void a(ByteBuffer paramAnonymousByteBuffer, c.b paramAnonymousb)
      {
        AppMethodBeat.i(10205);
        paramAnonymousb = DartExecutor.this;
        p localp = p.SSt;
        DartExecutor.a(paramAnonymousb, p.P(paramAnonymousByteBuffer));
        if (DartExecutor.a(DartExecutor.this) != null)
        {
          DartExecutor.a(DartExecutor.this);
          DartExecutor.b(DartExecutor.this);
        }
        AppMethodBeat.o(10205);
      }
    };
    this.SNV = paramFlutterJNI;
    this.aFb = paramAssetManager;
    this.SOG = new a(paramFlutterJNI);
    this.SOG.a("flutter/isolate", this.SOL);
    this.SOH = new b(this.SOG, (byte)0);
    AppMethodBeat.o(10198);
  }
  
  public final void a(DartExecutor.a parama)
  {
    AppMethodBeat.i(10201);
    if (this.SOI)
    {
      io.flutter.a.hwf();
      AppMethodBeat.o(10201);
      return;
    }
    new StringBuilder("Executing Dart entrypoint: ").append(parama);
    io.flutter.a.hwd();
    this.SNV.runBundleAndSnapshotFromLibrary(parama.SON, parama.SOO, null, this.aFb);
    this.SOI = true;
    AppMethodBeat.o(10201);
  }
  
  @Deprecated
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10204);
    this.SOH.a(paramString, parama);
    AppMethodBeat.o(10204);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10202);
    this.SOH.a(paramString, paramByteBuffer);
    AppMethodBeat.o(10202);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10203);
    this.SOH.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(10203);
  }
  
  public final void notifyLowMemoryWarning()
  {
    AppMethodBeat.i(214963);
    if (this.SNV.isAttached()) {
      this.SNV.notifyLowMemoryWarning();
    }
    AppMethodBeat.o(214963);
  }
  
  public void onAttachedToJNI()
  {
    AppMethodBeat.i(10199);
    io.flutter.a.hwd();
    this.SNV.setPlatformMessageHandler(this.SOG);
    AppMethodBeat.o(10199);
  }
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(10200);
    io.flutter.a.hwd();
    this.SNV.setPlatformMessageHandler(null);
    AppMethodBeat.o(10200);
  }
  
  static final class b
    implements c
  {
    private final a SOP;
    
    private b(a parama)
    {
      this.SOP = parama;
    }
    
    public final void a(String paramString, c.a parama)
    {
      AppMethodBeat.i(214966);
      this.SOP.a(paramString, parama);
      AppMethodBeat.o(214966);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(214964);
      this.SOP.a(paramString, paramByteBuffer, null);
      AppMethodBeat.o(214964);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(214965);
      this.SOP.a(paramString, paramByteBuffer, paramb);
      AppMethodBeat.o(214965);
    }
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor
 * JD-Core Version:    0.7.0.1
 */