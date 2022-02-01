package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.c;
import io.flutter.a.a.c.a;
import io.flutter.a.a.c.b;
import io.flutter.a.a.p;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;

public class DartExecutor
  implements c
{
  private final a IYP;
  public boolean IYQ;
  public String IYR;
  private b IYS;
  private final c.a IYT;
  private final FlutterJNI IYd;
  private final AssetManager aCD;
  
  public DartExecutor(FlutterJNI paramFlutterJNI, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(10198);
    this.IYQ = false;
    this.IYT = new c.a()
    {
      public final void a(ByteBuffer paramAnonymousByteBuffer, c.b paramAnonymousb)
      {
        AppMethodBeat.i(10205);
        paramAnonymousb = DartExecutor.this;
        p localp = p.JbB;
        DartExecutor.a(paramAnonymousb, p.O(paramAnonymousByteBuffer));
        if (DartExecutor.a(DartExecutor.this) != null)
        {
          DartExecutor.a(DartExecutor.this);
          DartExecutor.b(DartExecutor.this);
        }
        AppMethodBeat.o(10205);
      }
    };
    this.IYd = paramFlutterJNI;
    this.aCD = paramAssetManager;
    this.IYP = new a(paramFlutterJNI);
    this.IYP.a("flutter/isolate", this.IYT);
    AppMethodBeat.o(10198);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10201);
    if (this.IYQ)
    {
      io.flutter.a.ftU();
      AppMethodBeat.o(10201);
      return;
    }
    new StringBuilder("Executing Dart entrypoint: ").append(parama);
    io.flutter.a.ftS();
    this.IYd.runBundleAndSnapshotFromLibrary(parama.IYV, parama.IYW, null, this.aCD);
    this.IYQ = true;
    AppMethodBeat.o(10201);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(10204);
    this.IYP.a(paramString, parama);
    AppMethodBeat.o(10204);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10202);
    this.IYP.a(paramString, paramByteBuffer, null);
    AppMethodBeat.o(10202);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(10203);
    this.IYP.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(10203);
  }
  
  public final boolean fuQ()
  {
    return this.IYQ;
  }
  
  public void onAttachedToJNI()
  {
    AppMethodBeat.i(10199);
    io.flutter.a.ftS();
    this.IYd.setPlatformMessageHandler(this.IYP);
    AppMethodBeat.o(10199);
  }
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(10200);
    io.flutter.a.ftS();
    this.IYd.setPlatformMessageHandler(null);
    AppMethodBeat.o(10200);
  }
  
  public static final class a
  {
    public final String IYV;
    public final String IYW;
    
    public a(String paramString1, String paramString2)
    {
      this.IYV = paramString1;
      this.IYW = paramString2;
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
      if (!this.IYV.equals(paramObject.IYV))
      {
        AppMethodBeat.o(10213);
        return false;
      }
      boolean bool = this.IYW.equals(paramObject.IYW);
      AppMethodBeat.o(10213);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(10214);
      int i = this.IYV.hashCode();
      int j = this.IYW.hashCode();
      AppMethodBeat.o(10214);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(10212);
      String str = "DartEntrypoint( bundle path: " + this.IYV + ", function: " + this.IYW + " )";
      AppMethodBeat.o(10212);
      return str;
    }
  }
  
  static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor
 * JD-Core Version:    0.7.0.1
 */