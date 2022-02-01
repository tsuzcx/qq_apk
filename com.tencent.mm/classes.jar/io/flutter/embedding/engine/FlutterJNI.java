package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.ImmediateExecutor;
import io.flutter.util.Preconditions;
import io.flutter.view.AccessibilityBridge.Action;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

public class FlutterJNI
{
  private static final String TAG = "FlutterJNI";
  private static FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
  private static boolean initCalled = false;
  private static boolean loadLibraryCalled = false;
  private static String observatoryUri;
  private static boolean prefetchDefaultFontManagerCalled = false;
  private static float refreshRateFPS = 0.0F;
  private static boolean setRefreshRateFPSCalled = false;
  private byte _hellAccFlag_;
  private AccessibilityDelegate accessibilityDelegate;
  private Executor backgroundExecutor;
  private final Set<EngineDataReportListener> dataReportListeners;
  private DeferredComponentManager deferredComponentManager;
  private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners;
  private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
  private LocalizationPlugin localizationPlugin;
  private final Looper mainLooper;
  private Long nativeShellHolderId;
  private PlatformMessageHandler platformMessageHandler;
  private PlatformViewsController platformViewsController;
  
  public FlutterJNI()
  {
    AppMethodBeat.i(10127);
    this.engineLifecycleListeners = new CopyOnWriteArraySet();
    this.flutterUiDisplayListeners = new CopyOnWriteArraySet();
    this.backgroundExecutor = new ImmediateExecutor();
    this.dataReportListeners = new CopyOnWriteArraySet();
    this.mainLooper = Looper.getMainLooper();
    AppMethodBeat.o(10127);
  }
  
  private static void asyncWaitForVsync(long paramLong)
  {
    AppMethodBeat.i(10126);
    if (asyncWaitForVsyncDelegate != null)
    {
      asyncWaitForVsyncDelegate.asyncWaitForVsync(paramLong);
      AppMethodBeat.o(10126);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    AppMethodBeat.o(10126);
    throw localIllegalStateException;
  }
  
  private void ensureAttachedToNative()
  {
    AppMethodBeat.i(10131);
    if (this.nativeShellHolderId == null)
    {
      RuntimeException localRuntimeException = new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
      AppMethodBeat.o(10131);
      throw localRuntimeException;
    }
    AppMethodBeat.o(10131);
  }
  
  private void ensureNotAttachedToNative()
  {
    AppMethodBeat.i(10130);
    if (this.nativeShellHolderId != null)
    {
      RuntimeException localRuntimeException = new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
      AppMethodBeat.o(10130);
      throw localRuntimeException;
    }
    AppMethodBeat.o(10130);
  }
  
  private void ensureRunningOnMainThread()
  {
    AppMethodBeat.i(10164);
    if (Looper.myLooper() != this.mainLooper)
    {
      RuntimeException localRuntimeException = new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
      AppMethodBeat.o(10164);
      throw localRuntimeException;
    }
    AppMethodBeat.o(10164);
  }
  
  public static String getObservatoryUri()
  {
    return observatoryUri;
  }
  
  private void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(10155);
    if (this.platformMessageHandler != null) {
      this.platformMessageHandler.handlePlatformMessageResponse(paramInt, paramArrayOfByte);
    }
    AppMethodBeat.o(10155);
  }
  
  public static native void nativeAfterInit();
  
  private native long nativeAttach(FlutterJNI paramFlutterJNI, boolean paramBoolean);
  
  private native void nativeDeferredComponentInstallFailure(int paramInt, String paramString, boolean paramBoolean);
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativeDispatchEmptyPlatformMessage(long paramLong, String paramString, int paramInt);
  
  private native void nativeDispatchPlatformMessage(long paramLong, String paramString, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  private native void nativeDispatchPointerDataPacket(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native void nativeDispatchSemanticsAction(long paramLong, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3);
  
  private native Bitmap nativeGetBitmap(long paramLong);
  
  private native boolean nativeGetIsSoftwareRenderingEnabled();
  
  @Deprecated
  public static native void nativeInit(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, long paramLong, boolean paramBoolean);
  
  public static native void nativeInitNotInMainThread(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, long paramLong);
  
  private native void nativeInvokePlatformMessageEmptyResponseCallback(long paramLong, int paramInt);
  
  private native void nativeInvokePlatformMessageResponseCallback(long paramLong, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);
  
  private native void nativeLoadDartDeferredLibrary(long paramLong, int paramInt, String[] paramArrayOfString);
  
  public static native FlutterCallbackInformation nativeLookupCallbackInformation(long paramLong);
  
  private native void nativeMarkTextureFrameAvailable(long paramLong1, long paramLong2);
  
  private native void nativeNotifyLowMemoryWarning(long paramLong);
  
  public static native void nativeOnVsync(long paramLong1, long paramLong2, long paramLong3);
  
  @Deprecated
  public static native void nativePrefetchDefaultFontManager();
  
  private native void nativeRegisterTexture(long paramLong1, long paramLong2, SurfaceTextureWrapper paramSurfaceTextureWrapper);
  
  private native void nativeRunBundleAndSnapshotFromLibrary(long paramLong, String paramString1, String paramString2, String paramString3, AssetManager paramAssetManager);
  
  private native void nativeSetAccessibilityFeatures(long paramLong, int paramInt);
  
  private native void nativeSetSemanticsEnabled(long paramLong, boolean paramBoolean);
  
  private native void nativeSetViewportMetrics(long paramLong, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14);
  
  private native FlutterJNI nativeSpawn(long paramLong, String paramString1, String paramString2, String paramString3);
  
  private native void nativeSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSurfaceCreated(long paramLong, Surface paramSurface);
  
  private native void nativeSurfaceDestroyed(long paramLong);
  
  private native void nativeSurfaceWindowChanged(long paramLong, Surface paramSurface);
  
  private native void nativeUnregisterTexture(long paramLong1, long paramLong2);
  
  private native void nativeUpdateJavaAssetManager(long paramLong, AssetManager paramAssetManager, String paramString);
  
  private void onDataReportJSON(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(190210);
    Iterator localIterator = this.dataReportListeners.iterator();
    while (localIterator.hasNext()) {
      ((EngineDataReportListener)localIterator.next()).onReportJSON(paramArrayOfByte);
    }
    AppMethodBeat.o(190210);
  }
  
  private void onPreEngineRestart()
  {
    AppMethodBeat.i(10162);
    Iterator localIterator = this.engineLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((FlutterEngine.EngineLifecycleListener)localIterator.next()).onPreEngineRestart();
    }
    AppMethodBeat.o(10162);
  }
  
  public static void setAsyncWaitForVsyncDelegate(FlutterJNI.AsyncWaitForVsyncDelegate paramAsyncWaitForVsyncDelegate)
  {
    asyncWaitForVsyncDelegate = paramAsyncWaitForVsyncDelegate;
  }
  
  public static void setRefreshRateFPS(float paramFloat)
  {
    AppMethodBeat.i(190007);
    if (setRefreshRateFPSCalled) {
      Log.w("FlutterJNI", "FlutterJNI.setRefreshRateFPS called more than once");
    }
    refreshRateFPS = paramFloat;
    setRefreshRateFPSCalled = true;
    AppMethodBeat.o(190007);
  }
  
  private void updateCustomAccessibilityActions(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
  {
    AppMethodBeat.i(10143);
    ensureRunningOnMainThread();
    if (this.accessibilityDelegate != null) {
      this.accessibilityDelegate.updateCustomAccessibilityActions(paramByteBuffer, paramArrayOfString);
    }
    AppMethodBeat.o(10143);
  }
  
  private void updateSemantics(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
  {
    AppMethodBeat.i(10142);
    ensureRunningOnMainThread();
    if (this.accessibilityDelegate != null) {
      this.accessibilityDelegate.updateSemantics(paramByteBuffer, paramArrayOfString);
    }
    AppMethodBeat.o(10142);
  }
  
  public void addDataReportListener(EngineDataReportListener paramEngineDataReportListener)
  {
    AppMethodBeat.i(190551);
    this.dataReportListeners.add(paramEngineDataReportListener);
    AppMethodBeat.o(190551);
  }
  
  public void addEngineLifecycleListener(FlutterEngine.EngineLifecycleListener paramEngineLifecycleListener)
  {
    AppMethodBeat.i(10160);
    ensureRunningOnMainThread();
    this.engineLifecycleListeners.add(paramEngineLifecycleListener);
    AppMethodBeat.o(10160);
  }
  
  public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    AppMethodBeat.i(190370);
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.add(paramFlutterUiDisplayListener);
    AppMethodBeat.o(190370);
  }
  
  public void afterInitNotInMainThread()
  {
    AppMethodBeat.i(190301);
    nativeAfterInit();
    AppMethodBeat.o(190301);
  }
  
  public void attachToNative(boolean paramBoolean)
  {
    AppMethodBeat.i(10128);
    ensureRunningOnMainThread();
    ensureNotAttachedToNative();
    this.nativeShellHolderId = Long.valueOf(performNativeAttach(this, paramBoolean));
    AppMethodBeat.o(10128);
  }
  
  String[] computePlatformResolvedLocale(String[] paramArrayOfString)
  {
    AppMethodBeat.i(190609);
    if (this.localizationPlugin == null)
    {
      AppMethodBeat.o(190609);
      return new String[0];
    }
    Object localObject = new ArrayList();
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      String str1 = paramArrayOfString[(i + 0)];
      String str2 = paramArrayOfString[(i + 1)];
      String str3 = paramArrayOfString[(i + 2)];
      if (Build.VERSION.SDK_INT >= 21)
      {
        Locale.Builder localBuilder = new Locale.Builder();
        if (!str1.isEmpty()) {
          localBuilder.setLanguage(str1);
        }
        if (!str2.isEmpty()) {
          localBuilder.setRegion(str2);
        }
        if (!str3.isEmpty()) {
          localBuilder.setScript(str3);
        }
        ((List)localObject).add(localBuilder.build());
      }
      for (;;)
      {
        i += 3;
        break;
        ((List)localObject).add(new Locale(str1, str2));
      }
    }
    paramArrayOfString = this.localizationPlugin.resolveNativeLocale((List)localObject);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(190609);
      return new String[0];
    }
    localObject = new String[3];
    localObject[0] = paramArrayOfString.getLanguage();
    localObject[1] = paramArrayOfString.getCountry();
    if (Build.VERSION.SDK_INT >= 21) {
      localObject[2] = paramArrayOfString.getScript();
    }
    for (;;)
    {
      AppMethodBeat.o(190609);
      return localObject;
      localObject[2] = "";
    }
  }
  
  public FlutterOverlaySurface createOverlaySurface()
  {
    AppMethodBeat.i(190589);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      localObject = new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
      AppMethodBeat.o(190589);
      throw ((Throwable)localObject);
    }
    Object localObject = this.platformViewsController.createOverlaySurface();
    AppMethodBeat.o(190589);
    return localObject;
  }
  
  public void deferredComponentInstallFailure(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(190636);
    ensureRunningOnMainThread();
    nativeDeferredComponentInstallFailure(paramInt, paramString, paramBoolean);
    AppMethodBeat.o(190636);
  }
  
  public void destroyOverlaySurfaces()
  {
    AppMethodBeat.i(190597);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      RuntimeException localRuntimeException = new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
      AppMethodBeat.o(190597);
      throw localRuntimeException;
    }
    this.platformViewsController.destroyOverlaySurfaces();
    AppMethodBeat.o(190597);
  }
  
  public void detachFromNativeAndReleaseResources()
  {
    AppMethodBeat.i(10129);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    Long localLong = this.nativeShellHolderId;
    this.backgroundExecutor.execute(new FlutterJNI.1(this, localLong));
    this.nativeShellHolderId = null;
    AppMethodBeat.o(10129);
  }
  
  public void dispatchEmptyPlatformMessage(String paramString, int paramInt)
  {
    AppMethodBeat.i(10156);
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), paramString, paramInt);
      AppMethodBeat.o(10156);
      return;
    }
    Log.w("FlutterJNI", "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + paramString + ". Response ID: " + paramInt);
    AppMethodBeat.o(10156);
  }
  
  public void dispatchPlatformMessage(String paramString, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10157);
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), paramString, paramByteBuffer, paramInt1, paramInt2);
      AppMethodBeat.o(10157);
      return;
    }
    Log.w("FlutterJNI", "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + paramString + ". Response ID: " + paramInt2);
    AppMethodBeat.o(10157);
  }
  
  public void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(10140);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), paramByteBuffer, paramInt);
    AppMethodBeat.o(10140);
  }
  
  public void dispatchSemanticsAction(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3)
  {
    AppMethodBeat.i(10146);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), paramInt1, paramInt2, paramByteBuffer, paramInt3);
    AppMethodBeat.o(10146);
  }
  
  public void dispatchSemanticsAction(int paramInt, AccessibilityBridge.Action paramAction)
  {
    AppMethodBeat.i(10144);
    dispatchSemanticsAction(paramInt, paramAction, null);
    AppMethodBeat.o(10144);
  }
  
  public void dispatchSemanticsAction(int paramInt, AccessibilityBridge.Action paramAction, Object paramObject)
  {
    AppMethodBeat.i(10145);
    ensureAttachedToNative();
    ByteBuffer localByteBuffer = null;
    int i = 0;
    if (paramObject != null)
    {
      localByteBuffer = StandardMessageCodec.INSTANCE.encodeMessage(paramObject);
      i = localByteBuffer.position();
    }
    dispatchSemanticsAction(paramInt, paramAction.value, localByteBuffer, i);
    AppMethodBeat.o(10145);
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(10163);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    Bitmap localBitmap = nativeGetBitmap(this.nativeShellHolderId.longValue());
    AppMethodBeat.o(10163);
    return localBitmap;
  }
  
  public boolean getIsSoftwareRenderingEnabled()
  {
    AppMethodBeat.i(190307);
    boolean bool = nativeGetIsSoftwareRenderingEnabled();
    AppMethodBeat.o(190307);
    return bool;
  }
  
  public void handlePlatformMessage(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(10154);
    if (this.platformMessageHandler != null) {
      this.platformMessageHandler.handleMessageFromDart(paramString, paramArrayOfByte, paramInt);
    }
    AppMethodBeat.o(10154);
  }
  
  public void init(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(190288);
    if (initCalled) {
      Log.w("FlutterJNI", "FlutterJNI.init called more than once");
    }
    nativeInit(paramContext, paramArrayOfString, paramString1, paramString2, paramString3, paramLong, true);
    initCalled = true;
    AppMethodBeat.o(190288);
  }
  
  public void initNotInMainThread(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(190295);
    if (initCalled) {
      Log.w("FlutterJNI", "FlutterJNI.init called more than once");
    }
    nativeInitNotInMainThread(paramContext, paramArrayOfString, paramString1, paramString2, paramString3, paramLong);
    initCalled = true;
    AppMethodBeat.o(190295);
  }
  
  public void invokePlatformMessageEmptyResponseCallback(int paramInt)
  {
    AppMethodBeat.i(10158);
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), paramInt);
      AppMethodBeat.o(10158);
      return;
    }
    Log.w("FlutterJNI", "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(10158);
  }
  
  public void invokePlatformMessageResponseCallback(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    AppMethodBeat.i(10159);
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), paramInt1, paramByteBuffer, paramInt2);
      AppMethodBeat.o(10159);
      return;
    }
    Log.w("FlutterJNI", "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(10159);
  }
  
  public boolean isAttached()
  {
    return this.nativeShellHolderId != null;
  }
  
  public void loadDartDeferredLibrary(int paramInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(190628);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), paramInt, paramArrayOfString);
    AppMethodBeat.o(190628);
  }
  
  public void loadLibrary()
  {
    AppMethodBeat.i(190274);
    if (loadLibraryCalled) {
      Log.w("FlutterJNI", "FlutterJNI.loadLibrary called more than once");
    }
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("flutter");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "io/flutter/embedding/engine/FlutterJNI", "loadLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "io/flutter/embedding/engine/FlutterJNI", "loadLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    loadLibraryCalled = true;
    AppMethodBeat.o(190274);
  }
  
  public void markTextureFrameAvailable(long paramLong)
  {
    AppMethodBeat.i(10150);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), paramLong);
    AppMethodBeat.o(10150);
  }
  
  public native boolean nativeFlutterTextUtilsIsEmoji(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsEmojiModifier(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsRegionalIndicator(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsVariationSelector(int paramInt);
  
  public void notifyLowMemoryWarning()
  {
    AppMethodBeat.i(190651);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    AppMethodBeat.o(190651);
  }
  
  public void onBeginFrame()
  {
    AppMethodBeat.i(190574);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      RuntimeException localRuntimeException = new RuntimeException("platformViewsController must be set before attempting to begin the frame");
      AppMethodBeat.o(190574);
      throw localRuntimeException;
    }
    this.platformViewsController.onBeginFrame();
    AppMethodBeat.o(190574);
  }
  
  public void onDisplayOverlaySurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(190565);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      RuntimeException localRuntimeException = new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
      AppMethodBeat.o(190565);
      throw localRuntimeException;
    }
    this.platformViewsController.onDisplayOverlaySurface(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(190565);
  }
  
  public void onDisplayPlatformView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, FlutterMutatorsStack paramFlutterMutatorsStack)
  {
    AppMethodBeat.i(190642);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      paramFlutterMutatorsStack = new RuntimeException("platformViewsController must be set before attempting to position a platform view");
      AppMethodBeat.o(190642);
      throw paramFlutterMutatorsStack;
    }
    this.platformViewsController.onDisplayPlatformView(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramFlutterMutatorsStack);
    AppMethodBeat.o(190642);
  }
  
  public void onEndFrame()
  {
    AppMethodBeat.i(190580);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      RuntimeException localRuntimeException = new RuntimeException("platformViewsController must be set before attempting to end the frame");
      AppMethodBeat.o(190580);
      throw localRuntimeException;
    }
    this.platformViewsController.onEndFrame();
    AppMethodBeat.o(190580);
  }
  
  public void onFirstFrame()
  {
    AppMethodBeat.i(10135);
    ensureRunningOnMainThread();
    Iterator localIterator = this.flutterUiDisplayListeners.iterator();
    while (localIterator.hasNext()) {
      ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiDisplayed();
    }
    AppMethodBeat.o(10135);
  }
  
  void onRenderingStopped()
  {
    AppMethodBeat.i(190384);
    ensureRunningOnMainThread();
    Iterator localIterator = this.flutterUiDisplayListeners.iterator();
    while (localIterator.hasNext()) {
      ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiNoLongerDisplayed();
    }
    AppMethodBeat.o(190384);
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10137);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceChanged(this.nativeShellHolderId.longValue(), paramInt1, paramInt2);
    AppMethodBeat.o(10137);
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    AppMethodBeat.i(10136);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceCreated(this.nativeShellHolderId.longValue(), paramSurface);
    AppMethodBeat.o(10136);
  }
  
  public void onSurfaceDestroyed()
  {
    AppMethodBeat.i(10138);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    onRenderingStopped();
    nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    AppMethodBeat.o(10138);
  }
  
  public void onSurfaceWindowChanged(Surface paramSurface)
  {
    AppMethodBeat.i(190396);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), paramSurface);
    AppMethodBeat.o(190396);
  }
  
  public long performNativeAttach(FlutterJNI paramFlutterJNI, boolean paramBoolean)
  {
    AppMethodBeat.i(190357);
    long l = nativeAttach(paramFlutterJNI, paramBoolean);
    AppMethodBeat.o(190357);
    return l;
  }
  
  public void prefetchDefaultFontManager()
  {
    AppMethodBeat.i(190281);
    if (prefetchDefaultFontManagerCalled) {
      Log.w("FlutterJNI", "FlutterJNI.prefetchDefaultFontManager called more than once");
    }
    nativePrefetchDefaultFontManager();
    prefetchDefaultFontManagerCalled = true;
    AppMethodBeat.o(190281);
  }
  
  public void registerTexture(long paramLong, SurfaceTextureWrapper paramSurfaceTextureWrapper)
  {
    AppMethodBeat.i(190474);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeRegisterTexture(this.nativeShellHolderId.longValue(), paramLong, paramSurfaceTextureWrapper);
    AppMethodBeat.o(190474);
  }
  
  public void removeDataReportListener(EngineDataReportListener paramEngineDataReportListener)
  {
    AppMethodBeat.i(190555);
    this.dataReportListeners.remove(paramEngineDataReportListener);
    AppMethodBeat.o(190555);
  }
  
  public void removeEngineLifecycleListener(FlutterEngine.EngineLifecycleListener paramEngineLifecycleListener)
  {
    AppMethodBeat.i(10161);
    ensureRunningOnMainThread();
    this.engineLifecycleListeners.remove(paramEngineLifecycleListener);
    AppMethodBeat.o(10161);
  }
  
  public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    AppMethodBeat.i(190375);
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.remove(paramFlutterUiDisplayListener);
    AppMethodBeat.o(190375);
  }
  
  public void requestDartDeferredLibrary(int paramInt)
  {
    AppMethodBeat.i(190622);
    if (this.deferredComponentManager != null)
    {
      this.deferredComponentManager.installDeferredComponent(paramInt, null);
      AppMethodBeat.o(190622);
      return;
    }
    Log.e("FlutterJNI", "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
    AppMethodBeat.o(190622);
  }
  
  public void runBundleAndSnapshotFromLibrary(String paramString1, String paramString2, String paramString3, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(10152);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), paramString1, paramString2, paramString3, paramAssetManager);
    AppMethodBeat.o(10152);
  }
  
  public void setAccessibilityDelegate(AccessibilityDelegate paramAccessibilityDelegate)
  {
    AppMethodBeat.i(10141);
    ensureRunningOnMainThread();
    this.accessibilityDelegate = paramAccessibilityDelegate;
    AppMethodBeat.o(10141);
  }
  
  public void setAccessibilityFeatures(int paramInt)
  {
    AppMethodBeat.i(10148);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), paramInt);
    AppMethodBeat.o(10148);
  }
  
  void setBackgroundExecutor(Executor paramExecutor)
  {
    this.backgroundExecutor = paramExecutor;
  }
  
  public void setDeferredComponentManager(DeferredComponentManager paramDeferredComponentManager)
  {
    AppMethodBeat.i(190616);
    ensureRunningOnMainThread();
    this.deferredComponentManager = paramDeferredComponentManager;
    if (paramDeferredComponentManager != null) {
      paramDeferredComponentManager.setJNI(this);
    }
    AppMethodBeat.o(190616);
  }
  
  public void setLocalizationPlugin(LocalizationPlugin paramLocalizationPlugin)
  {
    AppMethodBeat.i(190602);
    ensureRunningOnMainThread();
    this.localizationPlugin = paramLocalizationPlugin;
    AppMethodBeat.o(190602);
  }
  
  public void setPlatformMessageHandler(PlatformMessageHandler paramPlatformMessageHandler)
  {
    AppMethodBeat.i(10153);
    ensureRunningOnMainThread();
    this.platformMessageHandler = paramPlatformMessageHandler;
    AppMethodBeat.o(10153);
  }
  
  public void setPlatformViewsController(PlatformViewsController paramPlatformViewsController)
  {
    AppMethodBeat.i(190421);
    ensureRunningOnMainThread();
    this.platformViewsController = paramPlatformViewsController;
    AppMethodBeat.o(190421);
  }
  
  public void setSemanticsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(10147);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), paramBoolean);
    AppMethodBeat.o(10147);
  }
  
  public void setViewportMetrics(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14)
  {
    AppMethodBeat.i(10139);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14);
    AppMethodBeat.o(10139);
  }
  
  public FlutterJNI spawn(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(190362);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    paramString1 = nativeSpawn(this.nativeShellHolderId.longValue(), paramString1, paramString2, paramString3);
    if ((paramString1.nativeShellHolderId != null) && (paramString1.nativeShellHolderId.longValue() > 0L)) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "Failed to spawn new JNI connected shell from existing shell.");
      AppMethodBeat.o(190362);
      return paramString1;
    }
  }
  
  public void unregisterTexture(long paramLong)
  {
    AppMethodBeat.i(10151);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeUnregisterTexture(this.nativeShellHolderId.longValue(), paramLong);
    AppMethodBeat.o(10151);
  }
  
  public void updateJavaAssetManager(AssetManager paramAssetManager, String paramString)
  {
    AppMethodBeat.i(190632);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), paramAssetManager, paramString);
    AppMethodBeat.o(190632);
  }
  
  public static abstract interface AccessibilityDelegate
  {
    public abstract void updateCustomAccessibilityActions(ByteBuffer paramByteBuffer, String[] paramArrayOfString);
    
    public abstract void updateSemantics(ByteBuffer paramByteBuffer, String[] paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterJNI
 * JD-Core Version:    0.7.0.1
 */