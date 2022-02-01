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
  public FlutterView MXU;
  private final io.flutter.embedding.engine.b.b MYq;
  final DartExecutor MZm;
  public final io.flutter.app.c Ngu;
  final FlutterJNI Ngv;
  public boolean Ngw;
  private final Context mContext;
  
  public FlutterNativeView(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private FlutterNativeView(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(9670);
    this.MYq = new io.flutter.embedding.engine.b.b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(197820);
        if (FlutterNativeView.b(FlutterNativeView.this) == null)
        {
          AppMethodBeat.o(197820);
          return;
        }
        FlutterNativeView.b(FlutterNativeView.this).onFirstFrame();
        AppMethodBeat.o(197820);
      }
      
      public final void cSS() {}
    };
    this.mContext = paramContext;
    this.Ngu = new io.flutter.app.c(this, paramContext);
    this.Ngv = new FlutterJNI();
    this.Ngv.addIsDisplayingFlutterUiListener(this.MYq);
    this.MZm = new DartExecutor(this.Ngv, paramContext.getAssets());
    this.Ngv.addEngineLifecycleListener(new a((byte)0));
    this.Ngv.attachToNative(false);
    this.MZm.onAttachedToJNI();
    assertAttached();
    AppMethodBeat.o(9670);
  }
  
  private void assertAttached()
  {
    AppMethodBeat.i(9672);
    if (!this.Ngv.isAttached())
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
    if (paramb.Ngz == null)
    {
      paramb = new AssertionError("An entrypoint must be specified");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    assertAttached();
    if (this.Ngw)
    {
      paramb = new AssertionError("This Flutter engine instance is already running an application");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    this.Ngv.runBundleAndSnapshotFromLibrary(paramb.Ngy, paramb.Ngz, paramb.NgA, this.mContext.getResources().getAssets());
    this.Ngw = true;
    AppMethodBeat.o(9673);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(9676);
    this.MZm.MZW.a(paramString, parama);
    AppMethodBeat.o(9676);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9674);
    this.MZm.MZW.a(paramString, paramByteBuffer);
    AppMethodBeat.o(9674);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(9675);
    if (!this.Ngv.isAttached())
    {
      AppMethodBeat.o(9675);
      return;
    }
    this.MZm.MZW.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(9675);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(9671);
    this.Ngu.MXV.gjP();
    this.MZm.onDetachedFromJNI();
    this.MXU = null;
    this.Ngv.removeIsDisplayingFlutterUiListener(this.MYq);
    this.Ngv.detachFromNativeAndReleaseResources();
    this.Ngw = false;
    AppMethodBeat.o(9671);
  }
  
  FlutterJNI getFlutterJNI()
  {
    return this.Ngv;
  }
  
  final class a
    implements a.a
  {
    private a() {}
    
    public final void onPreEngineRestart()
    {
      AppMethodBeat.i(9775);
      if (FlutterNativeView.b(FlutterNativeView.this) != null) {
        FlutterNativeView.b(FlutterNativeView.this).gjX();
      }
      if (FlutterNativeView.c(FlutterNativeView.this) == null)
      {
        AppMethodBeat.o(9775);
        return;
      }
      FlutterNativeView.c(FlutterNativeView.this).MXV.gjP();
      AppMethodBeat.o(9775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView
 * JD-Core Version:    0.7.0.1
 */