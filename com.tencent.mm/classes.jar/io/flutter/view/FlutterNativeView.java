package io.flutter.view;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.a.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.c.a;
import io.flutter.plugin.a.c.b;
import io.flutter.plugin.platform.h;
import java.nio.ByteBuffer;

public class FlutterNativeView
  implements io.flutter.plugin.a.c
{
  public FlutterView MAN;
  private final io.flutter.embedding.engine.b.b MBl;
  final DartExecutor MCh;
  public final io.flutter.app.c MJr;
  final FlutterJNI MJs;
  public boolean MJt;
  private final Context mContext;
  
  public FlutterNativeView(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private FlutterNativeView(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(9670);
    this.MBl = new io.flutter.embedding.engine.b.b()
    {
      public final void cQm()
      {
        AppMethodBeat.i(213238);
        if (FlutterNativeView.b(FlutterNativeView.this) == null)
        {
          AppMethodBeat.o(213238);
          return;
        }
        FlutterNativeView.b(FlutterNativeView.this).onFirstFrame();
        AppMethodBeat.o(213238);
      }
      
      public final void cQn() {}
    };
    this.mContext = paramContext;
    this.MJr = new io.flutter.app.c(this, paramContext);
    this.MJs = new FlutterJNI();
    this.MJs.addIsDisplayingFlutterUiListener(this.MBl);
    this.MCh = new DartExecutor(this.MJs, paramContext.getAssets());
    this.MJs.addEngineLifecycleListener(new a((byte)0));
    this.MJs.attachToNative(false);
    this.MCh.onAttachedToJNI();
    assertAttached();
    AppMethodBeat.o(9670);
  }
  
  private void assertAttached()
  {
    AppMethodBeat.i(9672);
    if (!this.MJs.isAttached())
    {
      AssertionError localAssertionError = new AssertionError("Platform view is not attached");
      AppMethodBeat.o(9672);
      throw localAssertionError;
    }
    AppMethodBeat.o(9672);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(9673);
    if (paramb.MJw == null)
    {
      paramb = new AssertionError("An entrypoint must be specified");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    assertAttached();
    if (this.MJt)
    {
      paramb = new AssertionError("This Flutter engine instance is already running an application");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    this.MJs.runBundleAndSnapshotFromLibrary(paramb.MJv, paramb.MJw, paramb.MJx, this.mContext.getResources().getAssets());
    this.MJt = true;
    AppMethodBeat.o(9673);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(9676);
    this.MCh.MCR.a(paramString, parama);
    AppMethodBeat.o(9676);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9674);
    this.MCh.MCR.a(paramString, paramByteBuffer);
    AppMethodBeat.o(9674);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(9675);
    if (!this.MJs.isAttached())
    {
      AppMethodBeat.o(9675);
      return;
    }
    this.MCh.MCR.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(9675);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(9671);
    this.MJr.MAO.gfn();
    this.MCh.onDetachedFromJNI();
    this.MAN = null;
    this.MJs.removeIsDisplayingFlutterUiListener(this.MBl);
    this.MJs.detachFromNativeAndReleaseResources();
    this.MJt = false;
    AppMethodBeat.o(9671);
  }
  
  FlutterJNI getFlutterJNI()
  {
    return this.MJs;
  }
  
  final class a
    implements a.a
  {
    private a() {}
    
    public final void onPreEngineRestart()
    {
      AppMethodBeat.i(9775);
      if (FlutterNativeView.b(FlutterNativeView.this) != null) {
        FlutterNativeView.b(FlutterNativeView.this).gfv();
      }
      if (FlutterNativeView.c(FlutterNativeView.this) == null)
      {
        AppMethodBeat.o(9775);
        return;
      }
      FlutterNativeView.c(FlutterNativeView.this).MAO.gfn();
      AppMethodBeat.o(9775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView
 * JD-Core Version:    0.7.0.1
 */