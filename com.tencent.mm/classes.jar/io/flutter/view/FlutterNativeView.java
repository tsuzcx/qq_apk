package io.flutter.view;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.c.a;
import io.flutter.a.a.c.b;
import io.flutter.a.c.g;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.nio.ByteBuffer;

public class FlutterNativeView
  implements io.flutter.a.a.c
{
  public FlutterView IWQ;
  final DartExecutor IYe;
  public final io.flutter.app.c JeY;
  final FlutterJNI JeZ;
  public boolean Jfa;
  private final Context mContext;
  
  public FlutterNativeView(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private FlutterNativeView(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(9670);
    this.mContext = paramContext;
    this.JeY = new io.flutter.app.c(this, paramContext);
    this.JeZ = new FlutterJNI();
    this.JeZ.setRenderSurface(new b((byte)0));
    this.IYe = new DartExecutor(this.JeZ, paramContext.getAssets());
    this.JeZ.addEngineLifecycleListener(new a((byte)0));
    this.JeZ.attachToNative(false);
    this.IYe.onAttachedToJNI();
    assertAttached();
    AppMethodBeat.o(9670);
  }
  
  private void assertAttached()
  {
    AppMethodBeat.i(9672);
    if (!this.JeZ.isAttached())
    {
      AssertionError localAssertionError = new AssertionError("Platform view is not attached");
      AppMethodBeat.o(9672);
      throw localAssertionError;
    }
    AppMethodBeat.o(9672);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9673);
    if (paramc.Jfd == null)
    {
      paramc = new AssertionError("An entrypoint must be specified");
      AppMethodBeat.o(9673);
      throw paramc;
    }
    assertAttached();
    if (this.Jfa)
    {
      paramc = new AssertionError("This Flutter engine instance is already running an application");
      AppMethodBeat.o(9673);
      throw paramc;
    }
    this.JeZ.runBundleAndSnapshotFromLibrary(paramc.Jfc, paramc.Jfd, paramc.Jfe, this.mContext.getResources().getAssets());
    this.Jfa = true;
    AppMethodBeat.o(9673);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(9676);
    this.IYe.a(paramString, parama);
    AppMethodBeat.o(9676);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9674);
    this.IYe.a(paramString, paramByteBuffer);
    AppMethodBeat.o(9674);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(9675);
    if (!this.JeZ.isAttached())
    {
      AppMethodBeat.o(9675);
      return;
    }
    this.IYe.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(9675);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(9671);
    this.JeY.IWR.fvh();
    this.IYe.onDetachedFromJNI();
    this.IWQ = null;
    this.JeZ.detachFromNativeAndReleaseResources();
    this.Jfa = false;
    AppMethodBeat.o(9671);
  }
  
  FlutterJNI getFlutterJNI()
  {
    return this.JeZ;
  }
  
  final class a
    implements io.flutter.embedding.engine.a.a
  {
    private a() {}
    
    public final void onPreEngineRestart()
    {
      AppMethodBeat.i(9775);
      if (FlutterNativeView.b(FlutterNativeView.this) != null) {
        FlutterNativeView.b(FlutterNativeView.this).fvq();
      }
      if (FlutterNativeView.c(FlutterNativeView.this) == null)
      {
        AppMethodBeat.o(9775);
        return;
      }
      FlutterNativeView.c(FlutterNativeView.this).IWR.fvh();
      AppMethodBeat.o(9775);
    }
  }
  
  final class b
    implements io.flutter.embedding.engine.b.a.a
  {
    private b() {}
    
    public final void a(a parama) {}
    
    public final void fut() {}
    
    public final void onFirstFrameRendered()
    {
      AppMethodBeat.i(9737);
      if (FlutterNativeView.b(FlutterNativeView.this) == null)
      {
        AppMethodBeat.o(9737);
        return;
      }
      FlutterNativeView.b(FlutterNativeView.this).onFirstFrame();
      AppMethodBeat.o(9737);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView
 * JD-Core Version:    0.7.0.1
 */