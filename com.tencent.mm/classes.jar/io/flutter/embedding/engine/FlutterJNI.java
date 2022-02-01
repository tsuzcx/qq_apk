package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterImageView.a;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.a.n;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugin.platform.PlatformViewsController.2;
import io.flutter.plugin.platform.c;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.a.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Keep
public class FlutterJNI
{
  private static final String TAG = "FlutterJNI";
  private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
  private static boolean initCalled = false;
  private static boolean loadLibraryCalled = false;
  private static String observatoryUri;
  private static boolean prefetchDefaultFontManagerCalled = false;
  private static float refreshRateFPS = 0.0F;
  private static boolean setRefreshRateFPSCalled = false;
  private AccessibilityDelegate accessibilityDelegate;
  private DeferredComponentManager deferredComponentManager;
  private final Set<a.a> engineLifecycleListeners;
  private final Set<io.flutter.embedding.engine.renderer.b> flutterUiDisplayListeners;
  private io.flutter.plugin.b.a localizationPlugin;
  private final Looper mainLooper;
  private Long nativeShellHolderId;
  private io.flutter.embedding.engine.dart.b platformMessageHandler;
  private PlatformViewsController platformViewsController;
  
  public FlutterJNI()
  {
    AppMethodBeat.i(10127);
    this.engineLifecycleListeners = new CopyOnWriteArraySet();
    this.flutterUiDisplayListeners = new CopyOnWriteArraySet();
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
  public static native void nativeInit(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, long paramLong);
  
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
  
  private native FlutterJNI nativeSpawn(long paramLong, String paramString1, String paramString2);
  
  private native void nativeSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSurfaceCreated(long paramLong, Surface paramSurface);
  
  private native void nativeSurfaceDestroyed(long paramLong);
  
  private native void nativeSurfaceWindowChanged(long paramLong, Surface paramSurface);
  
  private native void nativeUnregisterTexture(long paramLong1, long paramLong2);
  
  private native void nativeUpdateJavaAssetManager(long paramLong, AssetManager paramAssetManager, String paramString);
  
  private void onPreEngineRestart()
  {
    AppMethodBeat.i(10162);
    Iterator localIterator = this.engineLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((a.a)localIterator.next()).onPreEngineRestart();
    }
    AppMethodBeat.o(10162);
  }
  
  public static void setAsyncWaitForVsyncDelegate(AsyncWaitForVsyncDelegate paramAsyncWaitForVsyncDelegate)
  {
    asyncWaitForVsyncDelegate = paramAsyncWaitForVsyncDelegate;
  }
  
  public static void setRefreshRateFPS(float paramFloat)
  {
    AppMethodBeat.i(253956);
    if (setRefreshRateFPSCalled) {
      io.flutter.b.iAf();
    }
    refreshRateFPS = paramFloat;
    setRefreshRateFPSCalled = true;
    AppMethodBeat.o(253956);
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
  
  public void addEngineLifecycleListener(a.a parama)
  {
    AppMethodBeat.i(10160);
    ensureRunningOnMainThread();
    this.engineLifecycleListeners.add(parama);
    AppMethodBeat.o(10160);
  }
  
  public void addIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.b paramb)
  {
    AppMethodBeat.i(253971);
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.add(paramb);
    AppMethodBeat.o(253971);
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
    AppMethodBeat.i(254018);
    if (this.localizationPlugin == null)
    {
      AppMethodBeat.o(254018);
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
    paramArrayOfString = this.localizationPlugin.li((List)localObject);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(254018);
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
      AppMethodBeat.o(254018);
      return localObject;
      localObject[2] = "";
    }
  }
  
  public FlutterOverlaySurface createOverlaySurface()
  {
    AppMethodBeat.i(254012);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      localObject = new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
      AppMethodBeat.o(254012);
      throw ((Throwable)localObject);
    }
    Object localObject = this.platformViewsController;
    FlutterImageView localFlutterImageView = new FlutterImageView(((PlatformViewsController)localObject).aavX.getContext(), ((PlatformViewsController)localObject).aavX.getWidth(), ((PlatformViewsController)localObject).aavX.getHeight(), FlutterImageView.a.aaoX);
    int i = ((PlatformViewsController)localObject).aawe;
    ((PlatformViewsController)localObject).aawe = (i + 1);
    ((PlatformViewsController)localObject).aawd.put(i, localFlutterImageView);
    localObject = new FlutterOverlaySurface(i, localFlutterImageView.getSurface());
    AppMethodBeat.o(254012);
    return localObject;
  }
  
  public void deferredComponentInstallFailure(int paramInt, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(254030);
    ensureRunningOnMainThread();
    nativeDeferredComponentInstallFailure(paramInt, paramString, paramBoolean);
    AppMethodBeat.o(254030);
  }
  
  public void destroyOverlaySurfaces()
  {
    AppMethodBeat.i(254013);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      RuntimeException localRuntimeException = new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
      AppMethodBeat.o(254013);
      throw localRuntimeException;
    }
    this.platformViewsController.destroyOverlaySurfaces();
    AppMethodBeat.o(254013);
  }
  
  public void detachFromNativeAndReleaseResources()
  {
    AppMethodBeat.i(10129);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDestroy(this.nativeShellHolderId.longValue());
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
    new StringBuilder("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ").append(paramString).append(". Response ID: ").append(paramInt);
    io.flutter.b.iAf();
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
    new StringBuilder("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ").append(paramString).append(". Response ID: ").append(paramInt2);
    io.flutter.b.iAf();
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
  
  public void dispatchSemanticsAction(int paramInt, a.b paramb)
  {
    AppMethodBeat.i(10144);
    dispatchSemanticsAction(paramInt, paramb, null);
    AppMethodBeat.o(10144);
  }
  
  public void dispatchSemanticsAction(int paramInt, a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(10145);
    ensureAttachedToNative();
    ByteBuffer localByteBuffer = null;
    int i = 0;
    if (paramObject != null)
    {
      localByteBuffer = n.aauQ.eU(paramObject);
      i = localByteBuffer.position();
    }
    dispatchSemanticsAction(paramInt, paramb.value, localByteBuffer, i);
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
    AppMethodBeat.i(253954);
    boolean bool = nativeGetIsSoftwareRenderingEnabled();
    AppMethodBeat.o(253954);
    return bool;
  }
  
  public void handlePlatformMessage(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(10154);
    if (this.platformMessageHandler != null) {
      this.platformMessageHandler.g(paramString, paramArrayOfByte, paramInt);
    }
    AppMethodBeat.o(10154);
  }
  
  public void init(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(253953);
    if (initCalled) {
      io.flutter.b.iAf();
    }
    nativeInit(paramContext, paramArrayOfString, paramString1, paramString2, paramString3, paramLong);
    initCalled = true;
    AppMethodBeat.o(253953);
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
    "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ".concat(String.valueOf(paramInt));
    io.flutter.b.iAf();
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
    "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ".concat(String.valueOf(paramInt1));
    io.flutter.b.iAf();
    AppMethodBeat.o(10159);
  }
  
  public boolean isAttached()
  {
    return this.nativeShellHolderId != null;
  }
  
  public void loadDartDeferredLibrary(int paramInt, String[] paramArrayOfString)
  {
    AppMethodBeat.i(254024);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), paramInt, paramArrayOfString);
    AppMethodBeat.o(254024);
  }
  
  public void loadLibrary()
  {
    AppMethodBeat.i(253950);
    if (loadLibraryCalled) {
      io.flutter.b.iAf();
    }
    System.loadLibrary("flutter");
    loadLibraryCalled = true;
    AppMethodBeat.o(253950);
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
    AppMethodBeat.i(254036);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    AppMethodBeat.o(254036);
  }
  
  public void onBeginFrame()
  {
    AppMethodBeat.i(254009);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      localObject = new RuntimeException("platformViewsController must be set before attempting to begin the frame");
      AppMethodBeat.o(254009);
      throw ((Throwable)localObject);
    }
    Object localObject = this.platformViewsController;
    ((PlatformViewsController)localObject).aawg.clear();
    ((PlatformViewsController)localObject).aawh.clear();
    AppMethodBeat.o(254009);
  }
  
  public void onDisplayOverlaySurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(254007);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      localObject = new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
      AppMethodBeat.o(254007);
      throw ((Throwable)localObject);
    }
    Object localObject = this.platformViewsController;
    ((PlatformViewsController)localObject).iBx();
    FlutterImageView localFlutterImageView = (FlutterImageView)((PlatformViewsController)localObject).aawd.get(paramInt1);
    if (localFlutterImageView.getParent() == null) {
      ((FlutterView)((PlatformViewsController)localObject).aavX).addView(localFlutterImageView);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt4, paramInt5);
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt3;
    localFlutterImageView.setLayoutParams(localLayoutParams);
    localFlutterImageView.setVisibility(0);
    localFlutterImageView.bringToFront();
    ((PlatformViewsController)localObject).aawg.add(Integer.valueOf(paramInt1));
    AppMethodBeat.o(254007);
  }
  
  public void onDisplayPlatformView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, FlutterMutatorsStack paramFlutterMutatorsStack)
  {
    AppMethodBeat.i(254032);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      paramFlutterMutatorsStack = new RuntimeException("platformViewsController must be set before attempting to position a platform view");
      AppMethodBeat.o(254032);
      throw paramFlutterMutatorsStack;
    }
    PlatformViewsController localPlatformViewsController = this.platformViewsController;
    localPlatformViewsController.iBx();
    Object localObject = (c)localPlatformViewsController.aawb.get(paramInt1);
    if (localObject == null)
    {
      paramFlutterMutatorsStack = new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
      AppMethodBeat.o(254032);
      throw paramFlutterMutatorsStack;
    }
    if (localPlatformViewsController.aawc.get(paramInt1) == null)
    {
      if (((c)localObject).getView() == null)
      {
        paramFlutterMutatorsStack = new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        AppMethodBeat.o(254032);
        throw paramFlutterMutatorsStack;
      }
      if (((c)localObject).getView().getParent() != null)
      {
        paramFlutterMutatorsStack = new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        AppMethodBeat.o(254032);
        throw paramFlutterMutatorsStack;
      }
      io.flutter.embedding.engine.mutatorsstack.a locala = new io.flutter.embedding.engine.mutatorsstack.a(localPlatformViewsController.context, localPlatformViewsController.context.getResources().getDisplayMetrics().density, localPlatformViewsController.aapp);
      localPlatformViewsController.aawc.put(paramInt1, locala);
      locala.addView(((c)localObject).getView());
      ((FlutterView)localPlatformViewsController.aavX).addView(locala);
    }
    localObject = (io.flutter.embedding.engine.mutatorsstack.a)localPlatformViewsController.aawc.get(paramInt1);
    ((io.flutter.embedding.engine.mutatorsstack.a)localObject).aarC = paramFlutterMutatorsStack;
    ((io.flutter.embedding.engine.mutatorsstack.a)localObject).left = paramInt2;
    ((io.flutter.embedding.engine.mutatorsstack.a)localObject).top = paramInt3;
    paramFlutterMutatorsStack = new FrameLayout.LayoutParams(paramInt4, paramInt5);
    paramFlutterMutatorsStack.leftMargin = paramInt2;
    paramFlutterMutatorsStack.topMargin = paramInt3;
    ((io.flutter.embedding.engine.mutatorsstack.a)localObject).setLayoutParams(paramFlutterMutatorsStack);
    ((io.flutter.embedding.engine.mutatorsstack.a)localObject).setWillNotDraw(false);
    ((io.flutter.embedding.engine.mutatorsstack.a)localObject).setVisibility(0);
    ((io.flutter.embedding.engine.mutatorsstack.a)localObject).bringToFront();
    paramFlutterMutatorsStack = new FrameLayout.LayoutParams(paramInt6, paramInt7);
    localObject = ((c)localPlatformViewsController.aawb.get(paramInt1)).getView();
    if (localObject != null)
    {
      ((View)localObject).setLayoutParams(paramFlutterMutatorsStack);
      ((View)localObject).bringToFront();
    }
    localPlatformViewsController.aawh.add(Integer.valueOf(paramInt1));
    AppMethodBeat.o(254032);
  }
  
  public void onEndFrame()
  {
    AppMethodBeat.i(254011);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      localObject = new RuntimeException("platformViewsController must be set before attempting to end the frame");
      AppMethodBeat.o(254011);
      throw ((Throwable)localObject);
    }
    Object localObject = this.platformViewsController;
    FlutterView localFlutterView = (FlutterView)((PlatformViewsController)localObject).aavX;
    if ((((PlatformViewsController)localObject).aawf) && (((PlatformViewsController)localObject).aawh.isEmpty()))
    {
      ((PlatformViewsController)localObject).aawf = false;
      localFlutterView.bk(new PlatformViewsController.2((PlatformViewsController)localObject));
      AppMethodBeat.o(254011);
      return;
    }
    if (((PlatformViewsController)localObject).aawf) {
      if (localFlutterView.aapi != null)
      {
        bool = localFlutterView.aapi.iAA();
        if (!bool) {
          break label135;
        }
      }
    }
    label135:
    for (boolean bool = true;; bool = false)
    {
      ((PlatformViewsController)localObject).Jf(bool);
      AppMethodBeat.o(254011);
      return;
      bool = false;
      break;
    }
  }
  
  public void onFirstFrame()
  {
    AppMethodBeat.i(10135);
    ensureRunningOnMainThread();
    Iterator localIterator = this.flutterUiDisplayListeners.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.embedding.engine.renderer.b)localIterator.next()).epX();
    }
    AppMethodBeat.o(10135);
  }
  
  void onRenderingStopped()
  {
    AppMethodBeat.i(253974);
    ensureRunningOnMainThread();
    Iterator localIterator = this.flutterUiDisplayListeners.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.embedding.engine.renderer.b)localIterator.next()).epY();
    }
    AppMethodBeat.o(253974);
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
    AppMethodBeat.i(253977);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), paramSurface);
    AppMethodBeat.o(253977);
  }
  
  public long performNativeAttach(FlutterJNI paramFlutterJNI, boolean paramBoolean)
  {
    AppMethodBeat.i(253966);
    long l = nativeAttach(paramFlutterJNI, paramBoolean);
    AppMethodBeat.o(253966);
    return l;
  }
  
  public void prefetchDefaultFontManager()
  {
    AppMethodBeat.i(253952);
    if (prefetchDefaultFontManagerCalled) {
      io.flutter.b.iAf();
    }
    nativePrefetchDefaultFontManager();
    prefetchDefaultFontManagerCalled = true;
    AppMethodBeat.o(253952);
  }
  
  public void registerTexture(long paramLong, SurfaceTextureWrapper paramSurfaceTextureWrapper)
  {
    AppMethodBeat.i(253996);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeRegisterTexture(this.nativeShellHolderId.longValue(), paramLong, paramSurfaceTextureWrapper);
    AppMethodBeat.o(253996);
  }
  
  public void removeEngineLifecycleListener(a.a parama)
  {
    AppMethodBeat.i(10161);
    ensureRunningOnMainThread();
    this.engineLifecycleListeners.remove(parama);
    AppMethodBeat.o(10161);
  }
  
  public void removeIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.b paramb)
  {
    AppMethodBeat.i(253972);
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.remove(paramb);
    AppMethodBeat.o(253972);
  }
  
  public void requestDartDeferredLibrary(int paramInt)
  {
    AppMethodBeat.i(254022);
    if (this.deferredComponentManager != null)
    {
      this.deferredComponentManager.dE(paramInt, null);
      AppMethodBeat.o(254022);
      return;
    }
    io.flutter.b.iAh();
    AppMethodBeat.o(254022);
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
  
  public void setDeferredComponentManager(DeferredComponentManager paramDeferredComponentManager)
  {
    AppMethodBeat.i(254019);
    ensureRunningOnMainThread();
    this.deferredComponentManager = paramDeferredComponentManager;
    if (paramDeferredComponentManager != null) {
      paramDeferredComponentManager.setJNI(this);
    }
    AppMethodBeat.o(254019);
  }
  
  public void setLocalizationPlugin(io.flutter.plugin.b.a parama)
  {
    AppMethodBeat.i(254014);
    ensureRunningOnMainThread();
    this.localizationPlugin = parama;
    AppMethodBeat.o(254014);
  }
  
  public void setPlatformMessageHandler(io.flutter.embedding.engine.dart.b paramb)
  {
    AppMethodBeat.i(10153);
    ensureRunningOnMainThread();
    this.platformMessageHandler = paramb;
    AppMethodBeat.o(10153);
  }
  
  public void setPlatformViewsController(PlatformViewsController paramPlatformViewsController)
  {
    AppMethodBeat.i(253984);
    ensureRunningOnMainThread();
    this.platformViewsController = paramPlatformViewsController;
    AppMethodBeat.o(253984);
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
  
  public FlutterJNI spawn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253969);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    paramString1 = nativeSpawn(this.nativeShellHolderId.longValue(), paramString1, paramString2);
    if ((paramString1.nativeShellHolderId != null) && (paramString1.nativeShellHolderId.longValue() > 0L)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString1 = new IllegalStateException(String.valueOf("Failed to spawn new JNI connected shell from existing shell."));
      AppMethodBeat.o(253969);
      throw paramString1;
    }
    AppMethodBeat.o(253969);
    return paramString1;
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
    AppMethodBeat.i(254027);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), paramAssetManager, paramString);
    AppMethodBeat.o(254027);
  }
  
  public static abstract interface AccessibilityDelegate
  {
    public abstract void updateCustomAccessibilityActions(ByteBuffer paramByteBuffer, String[] paramArrayOfString);
    
    public abstract void updateSemantics(ByteBuffer paramByteBuffer, String[] paramArrayOfString);
  }
  
  public static abstract interface AsyncWaitForVsyncDelegate
  {
    public abstract void asyncWaitForVsync(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterJNI
 * JD-Core Version:    0.7.0.1
 */