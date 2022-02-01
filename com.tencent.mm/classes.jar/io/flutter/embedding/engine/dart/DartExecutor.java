package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import io.flutter.plugin.common.StringCodec;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;

public class DartExecutor
  implements BinaryMessenger
{
  private static final String TAG = "DartExecutor";
  private final AssetManager assetManager;
  private final BinaryMessenger binaryMessenger;
  private final DartMessenger dartMessenger;
  private final FlutterJNI flutterJNI;
  private boolean isApplicationRunning;
  private final BinaryMessenger.BinaryMessageHandler isolateChannelMessageHandler;
  private String isolateServiceId;
  private IsolateServiceIdListener isolateServiceIdListener;
  
  public DartExecutor(FlutterJNI paramFlutterJNI, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(10198);
    this.isApplicationRunning = false;
    this.isolateChannelMessageHandler = new BinaryMessenger.BinaryMessageHandler()
    {
      public void onMessage(ByteBuffer paramAnonymousByteBuffer, BinaryMessenger.BinaryReply paramAnonymousBinaryReply)
      {
        AppMethodBeat.i(10205);
        DartExecutor.access$002(DartExecutor.this, StringCodec.INSTANCE.decodeMessage(paramAnonymousByteBuffer));
        if (DartExecutor.this.isolateServiceIdListener != null) {
          DartExecutor.this.isolateServiceIdListener.onIsolateServiceIdAvailable(DartExecutor.this.isolateServiceId);
        }
        AppMethodBeat.o(10205);
      }
    };
    this.flutterJNI = paramFlutterJNI;
    this.assetManager = paramAssetManager;
    this.dartMessenger = new DartMessenger(paramFlutterJNI);
    this.dartMessenger.setMessageHandler("flutter/isolate", this.isolateChannelMessageHandler);
    this.binaryMessenger = new DefaultBinaryMessenger(this.dartMessenger, null);
    AppMethodBeat.o(10198);
  }
  
  public void executeDartCallback(DartCallback paramDartCallback)
  {
    AppMethodBeat.i(190074);
    if (this.isApplicationRunning)
    {
      Log.w("DartExecutor", "Attempted to run a DartExecutor that is already running.");
      AppMethodBeat.o(190074);
      return;
    }
    Log.v("DartExecutor", "Executing Dart callback: ".concat(String.valueOf(paramDartCallback)));
    this.flutterJNI.runBundleAndSnapshotFromLibrary(paramDartCallback.pathToBundle, paramDartCallback.callbackHandle.callbackName, paramDartCallback.callbackHandle.callbackLibraryPath, paramDartCallback.androidAssetManager);
    this.isApplicationRunning = true;
    AppMethodBeat.o(190074);
  }
  
  public void executeDartEntrypoint(DartEntrypoint paramDartEntrypoint)
  {
    AppMethodBeat.i(10201);
    if (this.isApplicationRunning)
    {
      Log.w("DartExecutor", "Attempted to run a DartExecutor that is already running.");
      AppMethodBeat.o(10201);
      return;
    }
    Log.v("DartExecutor", "Executing Dart entrypoint: ".concat(String.valueOf(paramDartEntrypoint)));
    this.flutterJNI.runBundleAndSnapshotFromLibrary(paramDartEntrypoint.pathToBundle, paramDartEntrypoint.dartEntrypointFunctionName, paramDartEntrypoint.dartEntrypointLibrary, this.assetManager);
    this.isApplicationRunning = true;
    AppMethodBeat.o(10201);
  }
  
  public BinaryMessenger getBinaryMessenger()
  {
    return this.binaryMessenger;
  }
  
  public String getIsolateServiceId()
  {
    return this.isolateServiceId;
  }
  
  public int getPendingChannelResponseCount()
  {
    AppMethodBeat.i(190115);
    int i = this.dartMessenger.getPendingChannelResponseCount();
    AppMethodBeat.o(190115);
    return i;
  }
  
  public boolean isExecutingDart()
  {
    return this.isApplicationRunning;
  }
  
  public void notifyLowMemoryWarning()
  {
    AppMethodBeat.i(190148);
    if (this.flutterJNI.isAttached()) {
      this.flutterJNI.notifyLowMemoryWarning();
    }
    AppMethodBeat.o(190148);
  }
  
  public void onAttachedToJNI()
  {
    AppMethodBeat.i(10199);
    Log.v("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
    this.flutterJNI.setPlatformMessageHandler(this.dartMessenger);
    AppMethodBeat.o(10199);
  }
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(10200);
    Log.v("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
    this.flutterJNI.setPlatformMessageHandler(null);
    AppMethodBeat.o(10200);
  }
  
  @Deprecated
  public void send(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(10202);
    this.binaryMessenger.send(paramString, paramByteBuffer);
    AppMethodBeat.o(10202);
  }
  
  @Deprecated
  public void send(String paramString, ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    AppMethodBeat.i(10203);
    this.binaryMessenger.send(paramString, paramByteBuffer, paramBinaryReply);
    AppMethodBeat.o(10203);
  }
  
  public void setIsolateServiceIdListener(IsolateServiceIdListener paramIsolateServiceIdListener)
  {
    AppMethodBeat.i(190134);
    this.isolateServiceIdListener = paramIsolateServiceIdListener;
    if ((this.isolateServiceIdListener != null) && (this.isolateServiceId != null)) {
      this.isolateServiceIdListener.onIsolateServiceIdAvailable(this.isolateServiceId);
    }
    AppMethodBeat.o(190134);
  }
  
  @Deprecated
  public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    AppMethodBeat.i(10204);
    this.binaryMessenger.setMessageHandler(paramString, paramBinaryMessageHandler);
    AppMethodBeat.o(10204);
  }
  
  public static class DartCallback
  {
    public final AssetManager androidAssetManager;
    public final FlutterCallbackInformation callbackHandle;
    public final String pathToBundle;
    
    public DartCallback(AssetManager paramAssetManager, String paramString, FlutterCallbackInformation paramFlutterCallbackInformation)
    {
      this.androidAssetManager = paramAssetManager;
      this.pathToBundle = paramString;
      this.callbackHandle = paramFlutterCallbackInformation;
    }
    
    public String toString()
    {
      AppMethodBeat.i(190024);
      String str = "DartCallback( bundle path: " + this.pathToBundle + ", library path: " + this.callbackHandle.callbackLibraryPath + ", function: " + this.callbackHandle.callbackName + " )";
      AppMethodBeat.o(190024);
      return str;
    }
  }
  
  public static class DartEntrypoint
  {
    public final String dartEntrypointFunctionName;
    public final String dartEntrypointLibrary;
    public final String pathToBundle;
    
    public DartEntrypoint(String paramString1, String paramString2)
    {
      this.pathToBundle = paramString1;
      this.dartEntrypointLibrary = null;
      this.dartEntrypointFunctionName = paramString2;
    }
    
    public DartEntrypoint(String paramString1, String paramString2, String paramString3)
    {
      this.pathToBundle = paramString1;
      this.dartEntrypointLibrary = paramString2;
      this.dartEntrypointFunctionName = paramString3;
    }
    
    public static DartEntrypoint createDefault()
    {
      AppMethodBeat.i(190032);
      Object localObject = FlutterInjector.instance().flutterLoader();
      if (!((FlutterLoader)localObject).initialized())
      {
        localObject = new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        AppMethodBeat.o(190032);
        throw ((Throwable)localObject);
      }
      localObject = new DartEntrypoint(((FlutterLoader)localObject).findAppBundlePath(), "main");
      AppMethodBeat.o(190032);
      return localObject;
    }
    
    public boolean equals(Object paramObject)
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
      paramObject = (DartEntrypoint)paramObject;
      if (!this.pathToBundle.equals(paramObject.pathToBundle))
      {
        AppMethodBeat.o(10213);
        return false;
      }
      boolean bool = this.dartEntrypointFunctionName.equals(paramObject.dartEntrypointFunctionName);
      AppMethodBeat.o(10213);
      return bool;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(10214);
      int i = this.pathToBundle.hashCode();
      int j = this.dartEntrypointFunctionName.hashCode();
      AppMethodBeat.o(10214);
      return i * 31 + j;
    }
    
    public String toString()
    {
      AppMethodBeat.i(10212);
      String str = "DartEntrypoint( bundle path: " + this.pathToBundle + ", function: " + this.dartEntrypointFunctionName + " )";
      AppMethodBeat.o(10212);
      return str;
    }
  }
  
  static class DefaultBinaryMessenger
    implements BinaryMessenger
  {
    private final DartMessenger messenger;
    
    private DefaultBinaryMessenger(DartMessenger paramDartMessenger)
    {
      this.messenger = paramDartMessenger;
    }
    
    public void send(String paramString, ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(190044);
      this.messenger.send(paramString, paramByteBuffer, null);
      AppMethodBeat.o(190044);
    }
    
    public void send(String paramString, ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
    {
      AppMethodBeat.i(190049);
      this.messenger.send(paramString, paramByteBuffer, paramBinaryReply);
      AppMethodBeat.o(190049);
    }
    
    public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
    {
      AppMethodBeat.i(190052);
      this.messenger.setMessageHandler(paramString, paramBinaryMessageHandler);
      AppMethodBeat.o(190052);
    }
  }
  
  static abstract interface IsolateServiceIdListener
  {
    public abstract void onIsolateServiceIdAvailable(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.dart.DartExecutor
 * JD-Core Version:    0.7.0.1
 */