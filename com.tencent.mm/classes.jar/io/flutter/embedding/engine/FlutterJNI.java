package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Surface;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.FlutterView.3;
import io.flutter.embedding.android.g;
import io.flutter.embedding.android.g.a;
import io.flutter.embedding.engine.c.h.a;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.plugin.a.i;
import io.flutter.plugin.a.n;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.plugin.platform.PlatformViewsController.2;
import io.flutter.plugin.platform.d;
import io.flutter.plugin.platform.f;
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
  private static String observatoryUri;
  private static float refreshRateFPS = 0.0F;
  private AccessibilityDelegate accessibilityDelegate;
  private final Set<a.a> engineLifecycleListeners;
  private final Set<io.flutter.embedding.engine.b.b> flutterUiDisplayListeners;
  private io.flutter.plugin.c.a localizationPlugin;
  private final Looper mainLooper;
  private Long nativePlatformViewId;
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
    if (this.nativePlatformViewId == null)
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
    if (this.nativePlatformViewId != null)
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
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativeDispatchEmptyPlatformMessage(long paramLong, String paramString, int paramInt);
  
  private native void nativeDispatchPlatformMessage(long paramLong, String paramString, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  private native void nativeDispatchPointerDataPacket(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native void nativeDispatchSemanticsAction(long paramLong, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3);
  
  private native Bitmap nativeGetBitmap(long paramLong);
  
  private native boolean nativeGetIsSoftwareRenderingEnabled();
  
  public static native void nativeInit(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, long paramLong);
  
  private native void nativeInvokePlatformMessageEmptyResponseCallback(long paramLong, int paramInt);
  
  private native void nativeInvokePlatformMessageResponseCallback(long paramLong, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);
  
  public static native FlutterCallbackInformation nativeLookupCallbackInformation(long paramLong);
  
  private native void nativeMarkTextureFrameAvailable(long paramLong1, long paramLong2);
  
  private native void nativeMemoryWarning(long paramLong);
  
  private native void nativeNotifyLowMemoryWarning(long paramLong);
  
  public static native void nativeOnVsync(long paramLong1, long paramLong2, long paramLong3);
  
  public static native void nativePrefetchDefaultFontManager();
  
  private native void nativeRegisterTexture(long paramLong1, long paramLong2, SurfaceTexture paramSurfaceTexture);
  
  private native void nativeRunBundleAndSnapshotFromLibrary(long paramLong, String paramString1, String paramString2, String paramString3, AssetManager paramAssetManager);
  
  private native void nativeSetAccessibilityFeatures(long paramLong, int paramInt);
  
  private native void nativeSetSemanticsEnabled(long paramLong, boolean paramBoolean);
  
  private native void nativeSetViewportMetrics(long paramLong, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14);
  
  private native void nativeSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSurfaceCreated(long paramLong, Surface paramSurface);
  
  private native void nativeSurfaceDestroyed(long paramLong);
  
  private native void nativeSurfaceWindowChanged(long paramLong, Surface paramSurface);
  
  private native void nativeUnregisterTexture(long paramLong1, long paramLong2);
  
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
    refreshRateFPS = paramFloat;
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
  
  public void addIsDisplayingFlutterUiListener(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(214948);
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.add(paramb);
    AppMethodBeat.o(214948);
  }
  
  public void attachToNative(boolean paramBoolean)
  {
    AppMethodBeat.i(10128);
    ensureRunningOnMainThread();
    ensureNotAttachedToNative();
    this.nativePlatformViewId = Long.valueOf(performNativeAttach(this, paramBoolean));
    AppMethodBeat.o(10128);
  }
  
  String[] computePlatformResolvedLocale(String[] paramArrayOfString)
  {
    AppMethodBeat.i(214959);
    if (this.localizationPlugin == null)
    {
      AppMethodBeat.o(214959);
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
    paramArrayOfString = this.localizationPlugin.ko((List)localObject);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(214959);
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
      AppMethodBeat.o(214959);
      return localObject;
      localObject[2] = "";
    }
  }
  
  public FlutterOverlaySurface createOverlaySurface()
  {
    AppMethodBeat.i(214956);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      localObject = new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
      AppMethodBeat.o(214956);
      throw ((Throwable)localObject);
    }
    Object localObject = this.platformViewsController;
    g localg = new g(((PlatformViewsController)localObject).STk.getContext(), ((PlatformViewsController)localObject).STk.getWidth(), ((PlatformViewsController)localObject).STk.getHeight(), g.a.SMZ);
    int i = ((PlatformViewsController)localObject).STs;
    ((PlatformViewsController)localObject).STs = (i + 1);
    ((PlatformViewsController)localObject).STr.put(i, localg);
    localObject = new FlutterOverlaySurface(i, localg.getSurface());
    AppMethodBeat.o(214956);
    return localObject;
  }
  
  public void destroyOverlaySurfaces()
  {
    AppMethodBeat.i(214957);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      RuntimeException localRuntimeException = new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
      AppMethodBeat.o(214957);
      throw localRuntimeException;
    }
    this.platformViewsController.destroyOverlaySurfaces();
    AppMethodBeat.o(214957);
  }
  
  public void detachFromNativeAndReleaseResources()
  {
    AppMethodBeat.i(10129);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDestroy(this.nativePlatformViewId.longValue());
    this.nativePlatformViewId = null;
    AppMethodBeat.o(10129);
  }
  
  public void dispatchEmptyPlatformMessage(String paramString, int paramInt)
  {
    AppMethodBeat.i(10156);
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeDispatchEmptyPlatformMessage(this.nativePlatformViewId.longValue(), paramString, paramInt);
      AppMethodBeat.o(10156);
      return;
    }
    new StringBuilder("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ").append(paramString).append(". Response ID: ").append(paramInt);
    io.flutter.a.hwf();
    AppMethodBeat.o(10156);
  }
  
  public void dispatchPlatformMessage(String paramString, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10157);
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeDispatchPlatformMessage(this.nativePlatformViewId.longValue(), paramString, paramByteBuffer, paramInt1, paramInt2);
      AppMethodBeat.o(10157);
      return;
    }
    new StringBuilder("Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: ").append(paramString).append(". Response ID: ").append(paramInt2);
    io.flutter.a.hwf();
    AppMethodBeat.o(10157);
  }
  
  public void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(10140);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDispatchPointerDataPacket(this.nativePlatformViewId.longValue(), paramByteBuffer, paramInt);
    AppMethodBeat.o(10140);
  }
  
  public void dispatchSemanticsAction(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3)
  {
    AppMethodBeat.i(10146);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeDispatchSemanticsAction(this.nativePlatformViewId.longValue(), paramInt1, paramInt2, paramByteBuffer, paramInt3);
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
      localByteBuffer = n.SSp.eP(paramObject);
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
    Bitmap localBitmap = nativeGetBitmap(this.nativePlatformViewId.longValue());
    AppMethodBeat.o(10163);
    return localBitmap;
  }
  
  public boolean getIsSoftwareRenderingEnabled()
  {
    AppMethodBeat.i(214946);
    boolean bool = nativeGetIsSoftwareRenderingEnabled();
    AppMethodBeat.o(214946);
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
  
  public void invokePlatformMessageEmptyResponseCallback(int paramInt)
  {
    AppMethodBeat.i(10158);
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeInvokePlatformMessageEmptyResponseCallback(this.nativePlatformViewId.longValue(), paramInt);
      AppMethodBeat.o(10158);
      return;
    }
    "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ".concat(String.valueOf(paramInt));
    io.flutter.a.hwf();
    AppMethodBeat.o(10158);
  }
  
  public void invokePlatformMessageResponseCallback(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    AppMethodBeat.i(10159);
    ensureRunningOnMainThread();
    if (isAttached())
    {
      nativeInvokePlatformMessageResponseCallback(this.nativePlatformViewId.longValue(), paramInt1, paramByteBuffer, paramInt2);
      AppMethodBeat.o(10159);
      return;
    }
    "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: ".concat(String.valueOf(paramInt1));
    io.flutter.a.hwf();
    AppMethodBeat.o(10159);
  }
  
  public boolean isAttached()
  {
    return this.nativePlatformViewId != null;
  }
  
  public void markTextureFrameAvailable(long paramLong)
  {
    AppMethodBeat.i(10150);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeMarkTextureFrameAvailable(this.nativePlatformViewId.longValue(), paramLong);
    AppMethodBeat.o(10150);
  }
  
  public native boolean nativeFlutterTextUtilsIsEmoji(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsEmojiModifier(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsRegionalIndicator(int paramInt);
  
  public native boolean nativeFlutterTextUtilsIsVariationSelector(int paramInt);
  
  public void notifyLowMemoryWarning()
  {
    AppMethodBeat.i(214961);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeNotifyLowMemoryWarning(this.nativePlatformViewId.longValue());
    AppMethodBeat.o(214961);
  }
  
  public void onBeginFrame()
  {
    AppMethodBeat.i(214954);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      localObject = new RuntimeException("platformViewsController must be set before attempting to begin the frame");
      AppMethodBeat.o(214954);
      throw ((Throwable)localObject);
    }
    Object localObject = this.platformViewsController;
    ((PlatformViewsController)localObject).STu.clear();
    ((PlatformViewsController)localObject).STv.clear();
    AppMethodBeat.o(214954);
  }
  
  public void onDisplayOverlaySurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(214953);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      localObject = new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
      AppMethodBeat.o(214953);
      throw ((Throwable)localObject);
    }
    Object localObject = this.platformViewsController;
    ((PlatformViewsController)localObject).hxt();
    g localg = (g)((PlatformViewsController)localObject).STr.get(paramInt1);
    if (localg.getParent() == null) {
      ((FlutterView)((PlatformViewsController)localObject).STk).addView(localg);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt4, paramInt5);
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt3;
    localg.setLayoutParams(localLayoutParams);
    localg.setVisibility(0);
    localg.bringToFront();
    ((PlatformViewsController)localObject).STu.add(Integer.valueOf(paramInt1));
    AppMethodBeat.o(214953);
  }
  
  public void onDisplayPlatformView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, FlutterMutatorsStack paramFlutterMutatorsStack)
  {
    AppMethodBeat.i(214960);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      paramFlutterMutatorsStack = new RuntimeException("platformViewsController must be set before attempting to position a platform view");
      AppMethodBeat.o(214960);
      throw paramFlutterMutatorsStack;
    }
    PlatformViewsController localPlatformViewsController = this.platformViewsController;
    localPlatformViewsController.hxt();
    Object localObject2;
    if (localPlatformViewsController.STp.get(paramInt1) == null)
    {
      localObject1 = (h.a)localPlatformViewsController.STo.get(paramInt1);
      if (localObject1 == null)
      {
        paramFlutterMutatorsStack = new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        AppMethodBeat.o(214960);
        throw paramFlutterMutatorsStack;
      }
      if (!PlatformViewsController.atB(((h.a)localObject1).direction))
      {
        paramFlutterMutatorsStack = new IllegalStateException("Trying to create a view with unknown direction value: " + ((h.a)localObject1).direction + "(view id: " + paramInt1 + ")");
        AppMethodBeat.o(214960);
        throw paramFlutterMutatorsStack;
      }
      localObject2 = localPlatformViewsController.STj.bts(((h.a)localObject1).SQP);
      if (localObject2 == null)
      {
        paramFlutterMutatorsStack = new IllegalStateException("Trying to create a platform view of unregistered type: " + ((h.a)localObject1).SQP);
        AppMethodBeat.o(214960);
        throw paramFlutterMutatorsStack;
      }
      if (((h.a)localObject1).SQS == null) {
        break label542;
      }
    }
    label542:
    for (Object localObject1 = ((d)localObject2).STh.J(((h.a)localObject1).SQS);; localObject1 = null)
    {
      localObject1 = ((d)localObject2).a(localPlatformViewsController.context, paramInt1, localObject1).getView();
      if (localObject1 == null)
      {
        paramFlutterMutatorsStack = new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        AppMethodBeat.o(214960);
        throw paramFlutterMutatorsStack;
      }
      if (((View)localObject1).getParent() != null)
      {
        paramFlutterMutatorsStack = new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        AppMethodBeat.o(214960);
        throw paramFlutterMutatorsStack;
      }
      localPlatformViewsController.STp.put(paramInt1, localObject1);
      localObject2 = new io.flutter.embedding.engine.mutatorsstack.a(localPlatformViewsController.context, localPlatformViewsController.context.getResources().getDisplayMetrics().density, localPlatformViewsController.SNr);
      localPlatformViewsController.STq.put(paramInt1, localObject2);
      ((io.flutter.embedding.engine.mutatorsstack.a)localObject2).addView((View)localObject1);
      ((FlutterView)localPlatformViewsController.STk).addView((View)localObject2);
      localObject1 = (io.flutter.embedding.engine.mutatorsstack.a)localPlatformViewsController.STq.get(paramInt1);
      ((io.flutter.embedding.engine.mutatorsstack.a)localObject1).SPq = paramFlutterMutatorsStack;
      ((io.flutter.embedding.engine.mutatorsstack.a)localObject1).left = paramInt2;
      ((io.flutter.embedding.engine.mutatorsstack.a)localObject1).top = paramInt3;
      paramFlutterMutatorsStack = new FrameLayout.LayoutParams(paramInt4, paramInt5);
      paramFlutterMutatorsStack.leftMargin = paramInt2;
      paramFlutterMutatorsStack.topMargin = paramInt3;
      ((io.flutter.embedding.engine.mutatorsstack.a)localObject1).setLayoutParams(paramFlutterMutatorsStack);
      ((io.flutter.embedding.engine.mutatorsstack.a)localObject1).setWillNotDraw(false);
      ((io.flutter.embedding.engine.mutatorsstack.a)localObject1).setVisibility(0);
      ((io.flutter.embedding.engine.mutatorsstack.a)localObject1).bringToFront();
      paramFlutterMutatorsStack = new FrameLayout.LayoutParams(paramInt6, paramInt7);
      localObject1 = (View)localPlatformViewsController.STp.get(paramInt1);
      ((View)localObject1).setLayoutParams(paramFlutterMutatorsStack);
      ((View)localObject1).bringToFront();
      localPlatformViewsController.STv.add(Integer.valueOf(paramInt1));
      AppMethodBeat.o(214960);
      return;
    }
  }
  
  public void onEndFrame()
  {
    AppMethodBeat.i(214955);
    ensureRunningOnMainThread();
    if (this.platformViewsController == null)
    {
      localObject1 = new RuntimeException("platformViewsController must be set before attempting to end the frame");
      AppMethodBeat.o(214955);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = this.platformViewsController;
    Object localObject1 = (FlutterView)((PlatformViewsController)localObject2).STk;
    if ((((PlatformViewsController)localObject2).STt) && (((PlatformViewsController)localObject2).STv.isEmpty()))
    {
      ((PlatformViewsController)localObject2).STt = false;
      localObject2 = new PlatformViewsController.2((PlatformViewsController)localObject2);
      if (((FlutterView)localObject1).SNk == null)
      {
        io.flutter.a.hwd();
        AppMethodBeat.o(214955);
        return;
      }
      if (((FlutterView)localObject1).SNm == null)
      {
        io.flutter.a.hwd();
        AppMethodBeat.o(214955);
        return;
      }
      ((FlutterView)localObject1).SNl = ((FlutterView)localObject1).SNm;
      ((FlutterView)localObject1).SNm = null;
      if (((FlutterView)localObject1).wJi == null)
      {
        ((FlutterView)localObject1).SNk.hwu();
        ((Runnable)localObject2).run();
        AppMethodBeat.o(214955);
        return;
      }
      io.flutter.embedding.engine.b.a locala = ((FlutterView)localObject1).wJi.SMr;
      if (locala == null)
      {
        ((FlutterView)localObject1).SNk.hwu();
        ((Runnable)localObject2).run();
        AppMethodBeat.o(214955);
        return;
      }
      ((FlutterView)localObject1).SNl.a(locala);
      locala.addIsDisplayingFlutterUiListener(new FlutterView.3((FlutterView)localObject1, locala, (Runnable)localObject2));
      AppMethodBeat.o(214955);
      return;
    }
    if (((PlatformViewsController)localObject2).STt) {
      if (((FlutterView)localObject1).SNk != null)
      {
        bool = ((FlutterView)localObject1).SNk.hwv();
        if (!bool) {
          break label267;
        }
      }
    }
    label267:
    for (boolean bool = true;; bool = false)
    {
      ((PlatformViewsController)localObject2).EA(bool);
      AppMethodBeat.o(214955);
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
      ((io.flutter.embedding.engine.b.b)localIterator.next()).dLt();
    }
    AppMethodBeat.o(10135);
  }
  
  public void onMemoryWarning()
  {
    AppMethodBeat.i(214962);
    if (isAttached())
    {
      nativeMemoryWarning(this.nativePlatformViewId.longValue());
      AppMethodBeat.o(214962);
      return;
    }
    io.flutter.a.hwf();
    AppMethodBeat.o(214962);
  }
  
  void onRenderingStopped()
  {
    AppMethodBeat.i(214950);
    ensureRunningOnMainThread();
    Iterator localIterator = this.flutterUiDisplayListeners.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.embedding.engine.b.b)localIterator.next()).dLu();
    }
    AppMethodBeat.o(214950);
  }
  
  public void onSurfaceChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10137);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceChanged(this.nativePlatformViewId.longValue(), paramInt1, paramInt2);
    AppMethodBeat.o(10137);
  }
  
  public void onSurfaceCreated(Surface paramSurface)
  {
    AppMethodBeat.i(10136);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceCreated(this.nativePlatformViewId.longValue(), paramSurface);
    AppMethodBeat.o(10136);
  }
  
  public void onSurfaceDestroyed()
  {
    AppMethodBeat.i(10138);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    onRenderingStopped();
    nativeSurfaceDestroyed(this.nativePlatformViewId.longValue());
    AppMethodBeat.o(10138);
  }
  
  public void onSurfaceWindowChanged(Surface paramSurface)
  {
    AppMethodBeat.i(214951);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSurfaceWindowChanged(this.nativePlatformViewId.longValue(), paramSurface);
    AppMethodBeat.o(214951);
  }
  
  public long performNativeAttach(FlutterJNI paramFlutterJNI, boolean paramBoolean)
  {
    AppMethodBeat.i(214947);
    long l = nativeAttach(paramFlutterJNI, paramBoolean);
    AppMethodBeat.o(214947);
    return l;
  }
  
  public void registerTexture(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(10149);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeRegisterTexture(this.nativePlatformViewId.longValue(), paramLong, paramSurfaceTexture);
    AppMethodBeat.o(10149);
  }
  
  public void removeEngineLifecycleListener(a.a parama)
  {
    AppMethodBeat.i(10161);
    ensureRunningOnMainThread();
    this.engineLifecycleListeners.remove(parama);
    AppMethodBeat.o(10161);
  }
  
  public void removeIsDisplayingFlutterUiListener(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(214949);
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.remove(paramb);
    AppMethodBeat.o(214949);
  }
  
  public void runBundleAndSnapshotFromLibrary(String paramString1, String paramString2, String paramString3, AssetManager paramAssetManager)
  {
    AppMethodBeat.i(10152);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeRunBundleAndSnapshotFromLibrary(this.nativePlatformViewId.longValue(), paramString1, paramString2, paramString3, paramAssetManager);
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
    nativeSetAccessibilityFeatures(this.nativePlatformViewId.longValue(), paramInt);
    AppMethodBeat.o(10148);
  }
  
  public void setLocalizationPlugin(io.flutter.plugin.c.a parama)
  {
    AppMethodBeat.i(214958);
    ensureRunningOnMainThread();
    this.localizationPlugin = parama;
    AppMethodBeat.o(214958);
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
    AppMethodBeat.i(214952);
    ensureRunningOnMainThread();
    this.platformViewsController = paramPlatformViewsController;
    AppMethodBeat.o(214952);
  }
  
  public void setSemanticsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(10147);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetSemanticsEnabled(this.nativePlatformViewId.longValue(), paramBoolean);
    AppMethodBeat.o(10147);
  }
  
  public void setViewportMetrics(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14)
  {
    AppMethodBeat.i(10139);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeSetViewportMetrics(this.nativePlatformViewId.longValue(), paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14);
    AppMethodBeat.o(10139);
  }
  
  public void unregisterTexture(long paramLong)
  {
    AppMethodBeat.i(10151);
    ensureRunningOnMainThread();
    ensureAttachedToNative();
    nativeUnregisterTexture(this.nativePlatformViewId.longValue(), paramLong);
    AppMethodBeat.o(10151);
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