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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class FlutterNativeView
  implements io.flutter.plugin.a.c
{
  public final io.flutter.embedding.engine.renderer.b aaoE;
  public FlutterView aaod;
  public final DartExecutor aapU;
  public final io.flutter.app.c aayQ;
  public final FlutterJNI aayR;
  public boolean aayS;
  private final Context mContext;
  
  public FlutterNativeView(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private FlutterNativeView(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(9670);
    this.aaoE = new io.flutter.embedding.engine.renderer.b()
    {
      public final void epX()
      {
        AppMethodBeat.i(255073);
        if (FlutterNativeView.b(FlutterNativeView.this) == null)
        {
          AppMethodBeat.o(255073);
          return;
        }
        Object localObject = FlutterNativeView.b(FlutterNativeView.this);
        ((FlutterView)localObject).aazg = true;
        localObject = new ArrayList(((FlutterView)localObject).aaze).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((FlutterView.a)((Iterator)localObject).next()).onFirstFrame();
        }
        AppMethodBeat.o(255073);
      }
      
      public final void epY() {}
    };
    this.mContext = paramContext;
    this.aayQ = new io.flutter.app.c(this, paramContext);
    this.aayR = new FlutterJNI();
    this.aayR.addIsDisplayingFlutterUiListener(this.aaoE);
    this.aapU = new DartExecutor(this.aayR, paramContext.getAssets());
    this.aayR.addEngineLifecycleListener(new a((byte)0));
    this.aayR.attachToNative(false);
    this.aapU.onAttachedToJNI();
    iBE();
    AppMethodBeat.o(9670);
  }
  
  private void iBE()
  {
    AppMethodBeat.i(9672);
    if (!this.aayR.isAttached())
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
    if (paramb.aayV == null)
    {
      paramb = new AssertionError("An entrypoint must be specified");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    iBE();
    if (this.aayS)
    {
      paramb = new AssertionError("This Flutter engine instance is already running an application");
      AppMethodBeat.o(9673);
      throw paramb;
    }
    this.aayR.runBundleAndSnapshotFromLibrary(paramb.aayU, paramb.aayV, paramb.aayW, this.mContext.getResources().getAssets());
    this.aayS = true;
    AppMethodBeat.o(9673);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(9676);
    this.aapU.aaqF.a(paramString, parama);
    AppMethodBeat.o(9676);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9674);
    this.aapU.aaqF.a(paramString, paramByteBuffer);
    AppMethodBeat.o(9674);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(9675);
    if (!this.aayR.isAttached())
    {
      io.flutter.b.iAe();
      AppMethodBeat.o(9675);
      return;
    }
    this.aapU.aaqF.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(9675);
  }
  
  FlutterJNI getFlutterJNI()
  {
    return this.aayR;
  }
  
  final class a
    implements a.a
  {
    private a() {}
    
    public final void onPreEngineRestart()
    {
      AppMethodBeat.i(9775);
      if (FlutterNativeView.b(FlutterNativeView.this) != null) {
        FlutterNativeView.b(FlutterNativeView.this).iBH();
      }
      if (FlutterNativeView.c(FlutterNativeView.this) == null)
      {
        AppMethodBeat.o(9775);
        return;
      }
      FlutterNativeView.c(FlutterNativeView.this).aaoe.iBw();
      AppMethodBeat.o(9775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView
 * JD-Core Version:    0.7.0.1
 */