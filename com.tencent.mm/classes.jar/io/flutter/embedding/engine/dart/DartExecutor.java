package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.c.a;
import io.flutter.plugin.a.c.b;
import io.flutter.plugin.a.p;
import java.nio.ByteBuffer;

public class DartExecutor
  implements c
{
  private final FlutterJNI aapT;
  private final a aaqE;
  public final c aaqF;
  public boolean aaqG;
  public String aaqH;
  private c aaqI;
  private final c.a aaqJ;
  private final AssetManager bok;
  
  public DartExecutor(FlutterJNI paramFlutterJNI, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(10198);
    this.aaqG = false;
    this.aaqJ = new c.a()
    {
      public final void a(ByteBuffer paramAnonymousByteBuffer, c.b paramAnonymousb)
      {
        AppMethodBeat.i(10205);
        paramAnonymousb = DartExecutor.this;
        p localp = p.aauU;
        DartExecutor.a(paramAnonymousb, p.L(paramAnonymousByteBuffer));
        if (DartExecutor.a(DartExecutor.this) != null)
        {
          DartExecutor.a(DartExecutor.this);
          DartExecutor.b(DartExecutor.this);
        }
        AppMethodBeat.o(10205);
      }
    };
    this.aapT = paramFlutterJNI;
    this.bok = paramAssetManager;
    this.aaqE = new a(paramFlutterJNI);
    this.aaqE.a("flutter/isolate", this.aaqJ);
    this.aaqF = new b(this.aaqE, (byte)0);
    AppMethodBeat.o(10198);
  }
  
  public final void a(DartExecutor.a parama)
  {
    AppMethodBeat.i(10201);
    if (this.aaqG)
    {
      b.iAf();
      AppMethodBeat.o(10201);
      return;
    }
    new StringBuilder("Executing Dart entrypoint: ").append(parama);
    b.iAd();
    this.aapT.runBundleAndSnapshotFromLibrary(parama.aaqL, parama.aaqN, parama.aaqM, this.bok);
    this.aaqG = true;
    AppMethodBeat.o(10201);
  }
  
  @Deprecated
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10204);
    this.aaqF.a(paramString, parama);
    AppMethodBeat.o(10204);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10202);
    this.aaqF.a(paramString, paramByteBuffer);
    AppMethodBeat.o(10202);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10203);
    this.aaqF.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(10203);
  }
  
  public final void notifyLowMemoryWarning()
  {
    AppMethodBeat.i(253497);
    if (this.aapT.isAttached()) {
      this.aapT.notifyLowMemoryWarning();
    }
    AppMethodBeat.o(253497);
  }
  
  public void onAttachedToJNI()
  {
    AppMethodBeat.i(10199);
    b.iAd();
    this.aapT.setPlatformMessageHandler(this.aaqE);
    AppMethodBeat.o(10199);
  }
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(10200);
    b.iAd();
    this.aapT.setPlatformMessageHandler(null);
    AppMethodBeat.o(10200);
  }
  
  static final class b
    implements c
  {
    private final a aaqO;
    
    private b(a parama)
    {
      this.aaqO = parama;
    }
    
    public final void a(String paramString, c.a parama)
    {
      AppMethodBeat.i(253380);
      this.aaqO.a(paramString, parama);
      AppMethodBeat.o(253380);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(253378);
      this.aaqO.a(paramString, paramByteBuffer, null);
      AppMethodBeat.o(253378);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(253379);
      this.aaqO.a(paramString, paramByteBuffer, paramb);
      AppMethodBeat.o(253379);
    }
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor
 * JD-Core Version:    0.7.0.1
 */