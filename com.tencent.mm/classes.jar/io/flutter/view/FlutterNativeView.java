package io.flutter.view;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.a.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.c.a;
import io.flutter.plugin.a.c.b;
import io.flutter.plugin.platform.PlatformViewsController;
import java.nio.ByteBuffer;

public class FlutterNativeView
  implements io.flutter.plugin.a.c
{
  private final io.flutter.embedding.engine.b.b SMD;
  public FlutterView SMe;
  final DartExecutor SNW;
  public final io.flutter.app.c SWe;
  final FlutterJNI SWf;
  public boolean SWg;
  private final Context mContext;
  
  public FlutterNativeView(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private FlutterNativeView(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(9670);
    this.SMD = new io.flutter.embedding.engine.b.b()
    {
      public final void dLt()
      {
        AppMethodBeat.i(214925);
        if (FlutterNativeView.b(FlutterNativeView.this) == null)
        {
          AppMethodBeat.o(214925);
          return;
        }
        FlutterNativeView.b(FlutterNativeView.this).onFirstFrame();
        AppMethodBeat.o(214925);
      }
      
      public final void dLu() {}
    };
    this.mContext = paramContext;
    this.SWe = new io.flutter.app.c(this, paramContext);
    this.SWf = new FlutterJNI();
    this.SWf.addIsDisplayingFlutterUiListener(this.SMD);
    this.SNW = new DartExecutor(this.SWf, paramContext.getAssets());
    this.SWf.addEngineLifecycleListener(new a((byte)0));
    this.SWf.attachToNative(false);
    this.SNW.onAttachedToJNI();
    assertAttached();
    AppMethodBeat.o(9670);
  }
  
  private void assertAttached()
  {
    AppMethodBeat.i(9672);
    if (!this.SWf.isAttached())
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
    if (paramb.SWj == null)
    {
      paramb = new AssertionError("An entrypoint must be specified");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    assertAttached();
    if (this.SWg)
    {
      paramb = new AssertionError("This Flutter engine instance is already running an application");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    this.SWf.runBundleAndSnapshotFromLibrary(paramb.SWi, paramb.SWj, paramb.SWk, this.mContext.getResources().getAssets());
    this.SWg = true;
    AppMethodBeat.o(9673);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(9676);
    this.SNW.SOH.a(paramString, parama);
    AppMethodBeat.o(9676);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9674);
    this.SNW.SOH.a(paramString, paramByteBuffer);
    AppMethodBeat.o(9674);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(9675);
    if (!this.SWf.isAttached())
    {
      AppMethodBeat.o(9675);
      return;
    }
    this.SNW.SOH.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(9675);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(9671);
    this.SWe.SMf.onDetachedFromJNI();
    this.SNW.onDetachedFromJNI();
    this.SMe = null;
    this.SWf.removeIsDisplayingFlutterUiListener(this.SMD);
    this.SWf.detachFromNativeAndReleaseResources();
    this.SWg = false;
    AppMethodBeat.o(9671);
  }
  
  FlutterJNI getFlutterJNI()
  {
    return this.SWf;
  }
  
  final class a
    implements a.a
  {
    private a() {}
    
    public final void onPreEngineRestart()
    {
      AppMethodBeat.i(9775);
      if (FlutterNativeView.b(FlutterNativeView.this) != null) {
        FlutterNativeView.b(FlutterNativeView.this).hxB();
      }
      if (FlutterNativeView.c(FlutterNativeView.this) == null)
      {
        AppMethodBeat.o(9775);
        return;
      }
      FlutterNativeView.c(FlutterNativeView.this).SMf.hxs();
      AppMethodBeat.o(9775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView
 * JD-Core Version:    0.7.0.1
 */