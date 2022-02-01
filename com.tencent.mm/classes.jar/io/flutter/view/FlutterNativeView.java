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
  public FlutterView KKb;
  private final io.flutter.embedding.engine.b.b KKx;
  final DartExecutor KLk;
  public final io.flutter.app.c KSs;
  final FlutterJNI KSt;
  public boolean KSu;
  private final Context mContext;
  
  public FlutterNativeView(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private FlutterNativeView(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(9670);
    this.KKx = new io.flutter.embedding.engine.b.b()
    {
      public final void cHX()
      {
        AppMethodBeat.i(192791);
        if (FlutterNativeView.b(FlutterNativeView.this) == null)
        {
          AppMethodBeat.o(192791);
          return;
        }
        FlutterNativeView.b(FlutterNativeView.this).onFirstFrame();
        AppMethodBeat.o(192791);
      }
      
      public final void cHY() {}
    };
    this.mContext = paramContext;
    this.KSs = new io.flutter.app.c(this, paramContext);
    this.KSt = new FlutterJNI();
    this.KSt.addIsDisplayingFlutterUiListener(this.KKx);
    this.KLk = new DartExecutor(this.KSt, paramContext.getAssets());
    this.KSt.addEngineLifecycleListener(new a((byte)0));
    this.KSt.attachToNative(false);
    this.KLk.onAttachedToJNI();
    assertAttached();
    AppMethodBeat.o(9670);
  }
  
  private void assertAttached()
  {
    AppMethodBeat.i(9672);
    if (!this.KSt.isAttached())
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
    if (paramb.KSx == null)
    {
      paramb = new AssertionError("An entrypoint must be specified");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    assertAttached();
    if (this.KSu)
    {
      paramb = new AssertionError("This Flutter engine instance is already running an application");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    this.KSt.runBundleAndSnapshotFromLibrary(paramb.KSw, paramb.KSx, paramb.KSy, this.mContext.getResources().getAssets());
    this.KSu = true;
    AppMethodBeat.o(9673);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(9676);
    this.KLk.KLU.a(paramString, parama);
    AppMethodBeat.o(9676);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9674);
    this.KLk.KLU.a(paramString, paramByteBuffer);
    AppMethodBeat.o(9674);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(9675);
    if (!this.KSt.isAttached())
    {
      AppMethodBeat.o(9675);
      return;
    }
    this.KLk.KLU.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(9675);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(9671);
    this.KSs.KKc.fNO();
    this.KLk.onDetachedFromJNI();
    this.KKb = null;
    this.KSt.removeIsDisplayingFlutterUiListener(this.KKx);
    this.KSt.detachFromNativeAndReleaseResources();
    this.KSu = false;
    AppMethodBeat.o(9671);
  }
  
  FlutterJNI getFlutterJNI()
  {
    return this.KSt;
  }
  
  final class a
    implements a.a
  {
    private a() {}
    
    public final void onPreEngineRestart()
    {
      AppMethodBeat.i(9775);
      if (FlutterNativeView.b(FlutterNativeView.this) != null) {
        FlutterNativeView.b(FlutterNativeView.this).fNW();
      }
      if (FlutterNativeView.c(FlutterNativeView.this) == null)
      {
        AppMethodBeat.o(9775);
        return;
      }
      FlutterNativeView.c(FlutterNativeView.this).KKc.fNO();
      AppMethodBeat.o(9775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView
 * JD-Core Version:    0.7.0.1
 */