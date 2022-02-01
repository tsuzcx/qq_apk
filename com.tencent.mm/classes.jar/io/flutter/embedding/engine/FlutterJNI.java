package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.support.annotation.Keep;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.plugin.a.n;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.a.b;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Keep
public class FlutterJNI
{
  private static final String TAG = "FlutterJNI";
  private static FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
  private static String observatoryUri;
  private static float refreshRateFPS = 0.0F;
  private AccessibilityDelegate accessibilityDelegate;
  private final Set<a.a> engineLifecycleListeners;
  private final Set<io.flutter.embedding.engine.b.b> flutterUiDisplayListeners;
  private final Looper mainLooper;
  private Long nativePlatformViewId;
  private io.flutter.embedding.engine.dart.b platformMessageHandler;
  
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
  
  private void handlePlatformMessage(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(10154);
    if (this.platformMessageHandler != null) {
      this.platformMessageHandler.g(paramString, paramArrayOfByte, paramInt);
    }
    AppMethodBeat.o(10154);
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
  
  public static native void nativeInit(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
  
  private native void nativeInvokePlatformMessageEmptyResponseCallback(long paramLong, int paramInt);
  
  private native void nativeInvokePlatformMessageResponseCallback(long paramLong, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);
  
  public static native FlutterCallbackInformation nativeLookupCallbackInformation(long paramLong);
  
  private native void nativeMarkTextureFrameAvailable(long paramLong1, long paramLong2);
  
  private native void nativeMemoryWarning(long paramLong);
  
  public static native void nativeOnVsync(long paramLong1, long paramLong2, long paramLong3);
  
  public static native void nativeRecordStartTimestamp(long paramLong);
  
  private native void nativeRegisterTexture(long paramLong1, long paramLong2, SurfaceTexture paramSurfaceTexture);
  
  private native void nativeRunBundleAndSnapshotFromLibrary(long paramLong, String paramString1, String paramString2, String paramString3, AssetManager paramAssetManager);
  
  private native void nativeSetAccessibilityFeatures(long paramLong, int paramInt);
  
  private native void nativeSetSemanticsEnabled(long paramLong, boolean paramBoolean);
  
  private native void nativeSetViewportMetrics(long paramLong, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14);
  
  private native void nativeSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSurfaceCreated(long paramLong, Surface paramSurface);
  
  private native void nativeSurfaceDestroyed(long paramLong);
  
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
  
  public static void setAsyncWaitForVsyncDelegate(FlutterJNI.AsyncWaitForVsyncDelegate paramAsyncWaitForVsyncDelegate)
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
    AppMethodBeat.i(192804);
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.add(paramb);
    AppMethodBeat.o(192804);
  }
  
  public void attachToNative(boolean paramBoolean)
  {
    AppMethodBeat.i(10128);
    ensureRunningOnMainThread();
    ensureNotAttachedToNative();
    this.nativePlatformViewId = Long.valueOf(nativeAttach(this, paramBoolean));
    AppMethodBeat.o(10128);
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
    a.fMG();
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
    a.fMG();
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
      localByteBuffer = n.KPb.eD(paramObject);
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
    a.fMG();
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
    a.fMG();
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
  
  public native boolean nativeGetIsSoftwareRenderingEnabled();
  
  void onFirstFrame()
  {
    AppMethodBeat.i(10135);
    ensureRunningOnMainThread();
    Iterator localIterator = this.flutterUiDisplayListeners.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.embedding.engine.b.b)localIterator.next()).cHX();
    }
    AppMethodBeat.o(10135);
  }
  
  public void onMemoryWarning()
  {
    AppMethodBeat.i(192807);
    if (isAttached())
    {
      nativeMemoryWarning(this.nativePlatformViewId.longValue());
      AppMethodBeat.o(192807);
      return;
    }
    a.fMG();
    AppMethodBeat.o(192807);
  }
  
  void onRenderingStopped()
  {
    AppMethodBeat.i(192806);
    ensureRunningOnMainThread();
    Iterator localIterator = this.flutterUiDisplayListeners.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.embedding.engine.b.b)localIterator.next()).cHY();
    }
    AppMethodBeat.o(192806);
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
    AppMethodBeat.i(192805);
    ensureRunningOnMainThread();
    this.flutterUiDisplayListeners.remove(paramb);
    AppMethodBeat.o(192805);
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
  
  public void setPlatformMessageHandler(io.flutter.embedding.engine.dart.b paramb)
  {
    AppMethodBeat.i(10153);
    ensureRunningOnMainThread();
    this.platformMessageHandler = paramb;
    AppMethodBeat.o(10153);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterJNI
 * JD-Core Version:    0.7.0.1
 */