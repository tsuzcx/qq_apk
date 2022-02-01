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
  private final a KLT;
  public final c KLU;
  public boolean KLV;
  public String KLW;
  private c KLX;
  private final c.a KLY;
  private final FlutterJNI KLj;
  private final AssetManager aDu;
  
  public DartExecutor(FlutterJNI paramFlutterJNI, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(10198);
    this.KLV = false;
    this.KLY = new c.a()
    {
      public final void a(ByteBuffer paramAnonymousByteBuffer, c.b paramAnonymousb)
      {
        AppMethodBeat.i(10205);
        paramAnonymousb = DartExecutor.this;
        p localp = p.KPf;
        DartExecutor.a(paramAnonymousb, p.O(paramAnonymousByteBuffer));
        if (DartExecutor.a(DartExecutor.this) != null)
        {
          DartExecutor.a(DartExecutor.this);
          DartExecutor.b(DartExecutor.this);
        }
        AppMethodBeat.o(10205);
      }
    };
    this.KLj = paramFlutterJNI;
    this.aDu = paramAssetManager;
    this.KLT = new a(paramFlutterJNI);
    this.KLT.a("flutter/isolate", this.KLY);
    this.KLU = new b(this.KLT, (byte)0);
    AppMethodBeat.o(10198);
  }
  
  public final void a(DartExecutor.a parama)
  {
    AppMethodBeat.i(10201);
    if (this.KLV)
    {
      io.flutter.a.fMG();
      AppMethodBeat.o(10201);
      return;
    }
    new StringBuilder("Executing Dart entrypoint: ").append(parama);
    io.flutter.a.fMD();
    this.KLj.runBundleAndSnapshotFromLibrary(parama.KMa, parama.KMb, null, this.aDu);
    this.KLV = true;
    AppMethodBeat.o(10201);
  }
  
  @Deprecated
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10204);
    this.KLU.a(paramString, parama);
    AppMethodBeat.o(10204);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10202);
    this.KLU.a(paramString, paramByteBuffer);
    AppMethodBeat.o(10202);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10203);
    this.KLU.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(10203);
  }
  
  public final boolean fNq()
  {
    return this.KLV;
  }
  
  public void onAttachedToJNI()
  {
    AppMethodBeat.i(10199);
    io.flutter.a.fMD();
    this.KLj.setPlatformMessageHandler(this.KLT);
    AppMethodBeat.o(10199);
  }
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(10200);
    io.flutter.a.fMD();
    this.KLj.setPlatformMessageHandler(null);
    AppMethodBeat.o(10200);
  }
  
  static final class b
    implements c
  {
    private final a KMc;
    
    private b(a parama)
    {
      this.KMc = parama;
    }
    
    public final void a(String paramString, c.a parama)
    {
      AppMethodBeat.i(192810);
      this.KMc.a(paramString, parama);
      AppMethodBeat.o(192810);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(192808);
      this.KMc.a(paramString, paramByteBuffer, null);
      AppMethodBeat.o(192808);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(192809);
      this.KMc.a(paramString, paramByteBuffer, paramb);
      AppMethodBeat.o(192809);
    }
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor
 * JD-Core Version:    0.7.0.1
 */