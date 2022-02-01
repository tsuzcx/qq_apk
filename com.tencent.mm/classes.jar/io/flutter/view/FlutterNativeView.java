package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import java.nio.ByteBuffer;

@Deprecated
public class FlutterNativeView
  implements BinaryMessenger
{
  private static final String TAG = "FlutterNativeView";
  private boolean applicationIsRunning;
  private final DartExecutor dartExecutor;
  private final FlutterUiDisplayListener flutterUiDisplayListener;
  private final Context mContext;
  private final FlutterJNI mFlutterJNI;
  private FlutterView mFlutterView;
  private final FlutterPluginRegistry mPluginRegistry;
  
  public FlutterNativeView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public FlutterNativeView(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(190563);
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190561);
        if (FlutterNativeView.this.mFlutterView == null)
        {
          AppMethodBeat.o(190561);
          return;
        }
        FlutterNativeView.this.mFlutterView.onFirstFrame();
        AppMethodBeat.o(190561);
      }
      
      public void onFlutterUiNoLongerDisplayed() {}
    };
    this.mContext = paramContext;
    this.mPluginRegistry = new FlutterPluginRegistry(this, paramContext);
    this.mFlutterJNI = new FlutterJNI();
    this.mFlutterJNI.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    this.dartExecutor = new DartExecutor(this.mFlutterJNI, paramContext.getAssets());
    this.mFlutterJNI.addEngineLifecycleListener(new EngineLifecycleListenerImpl(null));
    attach(this, paramBoolean);
    assertAttached();
    AppMethodBeat.o(190563);
  }
  
  private void attach(FlutterNativeView paramFlutterNativeView, boolean paramBoolean)
  {
    AppMethodBeat.i(190585);
    this.mFlutterJNI.attachToNative(paramBoolean);
    this.dartExecutor.onAttachedToJNI();
    AppMethodBeat.o(190585);
  }
  
  public static String getObservatoryUri()
  {
    AppMethodBeat.i(190572);
    String str = FlutterJNI.getObservatoryUri();
    AppMethodBeat.o(190572);
    return str;
  }
  
  public void assertAttached()
  {
    AppMethodBeat.i(9672);
    if (!isAttached())
    {
      AssertionError localAssertionError = new AssertionError("Platform view is not attached");
      AppMethodBeat.o(9672);
      throw localAssertionError;
    }
    AppMethodBeat.o(9672);
  }
  
  public void attachViewAndActivity(FlutterView paramFlutterView, Activity paramActivity)
  {
    AppMethodBeat.i(190633);
    this.mFlutterView = paramFlutterView;
    this.mPluginRegistry.attach(paramFlutterView, paramActivity);
    AppMethodBeat.o(190633);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(9671);
    this.mPluginRegistry.destroy();
    this.dartExecutor.onDetachedFromJNI();
    this.mFlutterView = null;
    this.mFlutterJNI.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    this.mFlutterJNI.detachFromNativeAndReleaseResources();
    this.applicationIsRunning = false;
    AppMethodBeat.o(9671);
  }
  
  public void detachFromFlutterView()
  {
    AppMethodBeat.i(190608);
    this.mPluginRegistry.detach();
    this.mFlutterView = null;
    AppMethodBeat.o(190608);
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.dartExecutor;
  }
  
  FlutterJNI getFlutterJNI()
  {
    return this.mFlutterJNI;
  }
  
  public FlutterPluginRegistry getPluginRegistry()
  {
    return this.mPluginRegistry;
  }
  
  public boolean isApplicationRunning()
  {
    return this.applicationIsRunning;
  }
  
  public boolean isAttached()
  {
    AppMethodBeat.i(190639);
    boolean bool = this.mFlutterJNI.isAttached();
    AppMethodBeat.o(190639);
    return bool;
  }
  
  public void runFromBundle(FlutterRunArguments paramFlutterRunArguments)
  {
    AppMethodBeat.i(9673);
    if (paramFlutterRunArguments.entrypoint == null)
    {
      paramFlutterRunArguments = new AssertionError("An entrypoint must be specified");
      AppMethodBeat.o(9673);
      throw paramFlutterRunArguments;
    }
    assertAttached();
    if (this.applicationIsRunning)
    {
      paramFlutterRunArguments = new AssertionError("This Flutter engine instance is already running an application");
      AppMethodBeat.o(9673);
      throw paramFlutterRunArguments;
    }
    this.mFlutterJNI.runBundleAndSnapshotFromLibrary(paramFlutterRunArguments.bundlePath, paramFlutterRunArguments.entrypoint, paramFlutterRunArguments.libraryPath, this.mContext.getResources().getAssets());
    this.applicationIsRunning = true;
    AppMethodBeat.o(9673);
  }
  
  public void send(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9674);
    this.dartExecutor.getBinaryMessenger().send(paramString, paramByteBuffer);
    AppMethodBeat.o(9674);
  }
  
  public void send(String paramString, ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    AppMethodBeat.i(9675);
    if (!isAttached())
    {
      Log.d("FlutterNativeView", "FlutterView.send called on a detached view, channel=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(9675);
      return;
    }
    this.dartExecutor.getBinaryMessenger().send(paramString, paramByteBuffer, paramBinaryReply);
    AppMethodBeat.o(9675);
  }
  
  public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    AppMethodBeat.i(9676);
    this.dartExecutor.getBinaryMessenger().setMessageHandler(paramString, paramBinaryMessageHandler);
    AppMethodBeat.o(9676);
  }
  
  final class EngineLifecycleListenerImpl
    implements FlutterEngine.EngineLifecycleListener
  {
    private EngineLifecycleListenerImpl() {}
    
    public final void onEngineWillDestroy() {}
    
    public final void onPreEngineRestart()
    {
      AppMethodBeat.i(9775);
      if (FlutterNativeView.this.mFlutterView != null) {
        FlutterNativeView.this.mFlutterView.resetAccessibilityTree();
      }
      if (FlutterNativeView.this.mPluginRegistry == null)
      {
        AppMethodBeat.o(9775);
        return;
      }
      FlutterNativeView.this.mPluginRegistry.onPreEngineRestart();
      AppMethodBeat.o(9775);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView
 * JD-Core Version:    0.7.0.1
 */