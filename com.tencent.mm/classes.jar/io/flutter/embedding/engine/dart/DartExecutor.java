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
  private final a MZV;
  public final c MZW;
  public boolean MZX;
  public String MZY;
  private c MZZ;
  private final FlutterJNI MZl;
  private final c.a Naa;
  private final AssetManager aFl;
  
  public DartExecutor(FlutterJNI paramFlutterJNI, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(10198);
    this.MZX = false;
    this.Naa = new c.a()
    {
      public final void a(ByteBuffer paramAnonymousByteBuffer, c.b paramAnonymousb)
      {
        AppMethodBeat.i(10205);
        paramAnonymousb = DartExecutor.this;
        p localp = p.Ndi;
        DartExecutor.a(paramAnonymousb, p.P(paramAnonymousByteBuffer));
        if (DartExecutor.a(DartExecutor.this) != null)
        {
          DartExecutor.a(DartExecutor.this);
          DartExecutor.b(DartExecutor.this);
        }
        AppMethodBeat.o(10205);
      }
    };
    this.MZl = paramFlutterJNI;
    this.aFl = paramAssetManager;
    this.MZV = new a(paramFlutterJNI);
    this.MZV.a("flutter/isolate", this.Naa);
    this.MZW = new b(this.MZV, (byte)0);
    AppMethodBeat.o(10198);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10201);
    if (this.MZX)
    {
      io.flutter.a.giG();
      AppMethodBeat.o(10201);
      return;
    }
    new StringBuilder("Executing Dart entrypoint: ").append(parama);
    io.flutter.a.giD();
    this.MZl.runBundleAndSnapshotFromLibrary(parama.Nac, parama.Nad, null, this.aFl);
    this.MZX = true;
    AppMethodBeat.o(10201);
  }
  
  @Deprecated
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10204);
    this.MZW.a(paramString, parama);
    AppMethodBeat.o(10204);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10202);
    this.MZW.a(paramString, paramByteBuffer);
    AppMethodBeat.o(10202);
  }
  
  @Deprecated
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10203);
    this.MZW.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(10203);
  }
  
  public final boolean gjr()
  {
    return this.MZX;
  }
  
  public void onAttachedToJNI()
  {
    AppMethodBeat.i(10199);
    io.flutter.a.giD();
    this.MZl.setPlatformMessageHandler(this.MZV);
    AppMethodBeat.o(10199);
  }
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(10200);
    io.flutter.a.giD();
    this.MZl.setPlatformMessageHandler(null);
    AppMethodBeat.o(10200);
  }
  
  public static final class a
  {
    public final String Nac;
    public final String Nad;
    
    public a(String paramString1, String paramString2)
    {
      this.Nac = paramString1;
      this.Nad = paramString2;
    }
    
    public a(String paramString1, String paramString2, byte paramByte)
    {
      this(paramString1, paramString2);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(10213);
      if (this == paramObject)
      {
        AppMethodBeat.o(10213);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(10213);
        return false;
      }
      paramObject = (a)paramObject;
      if (!this.Nac.equals(paramObject.Nac))
      {
        AppMethodBeat.o(10213);
        return false;
      }
      boolean bool = this.Nad.equals(paramObject.Nad);
      AppMethodBeat.o(10213);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(10214);
      int i = this.Nac.hashCode();
      int j = this.Nad.hashCode();
      AppMethodBeat.o(10214);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(10212);
      String str = "DartEntrypoint( bundle path: " + this.Nac + ", function: " + this.Nad + " )";
      AppMethodBeat.o(10212);
      return str;
    }
  }
  
  static final class b
    implements c
  {
    private final a Nae;
    
    private b(a parama)
    {
      this.Nae = parama;
    }
    
    public final void a(String paramString, c.a parama)
    {
      AppMethodBeat.i(197841);
      this.Nae.a(paramString, parama);
      AppMethodBeat.o(197841);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(197839);
      this.Nae.a(paramString, paramByteBuffer, null);
      AppMethodBeat.o(197839);
    }
    
    public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
    {
      AppMethodBeat.i(197840);
      this.Nae.a(paramString, paramByteBuffer, paramb);
      AppMethodBeat.o(197840);
    }
  }
  
  static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor
 * JD-Core Version:    0.7.0.1
 */