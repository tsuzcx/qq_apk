package io.flutter.embedding.engine.renderer;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.util.ImmediateExecutor;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterRenderer
  implements TextureRegistry
{
  private static final String TAG = "FlutterRenderer";
  private Executor backgroundExecutor;
  private final FlutterJNI flutterJNI;
  private final FlutterUiDisplayListener flutterUiDisplayListener;
  private boolean isDisplayingFlutterUi;
  private final AtomicLong nextTextureId;
  private Surface surface;
  
  public FlutterRenderer(FlutterJNI paramFlutterJNI)
  {
    AppMethodBeat.i(10185);
    this.nextTextureId = new AtomicLong(0L);
    this.backgroundExecutor = new ImmediateExecutor();
    this.isDisplayingFlutterUi = false;
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190060);
        FlutterRenderer.access$002(FlutterRenderer.this, true);
        AppMethodBeat.o(190060);
      }
      
      public void onFlutterUiNoLongerDisplayed()
      {
        AppMethodBeat.i(190063);
        FlutterRenderer.access$002(FlutterRenderer.this, false);
        AppMethodBeat.o(190063);
      }
    };
    this.flutterJNI = paramFlutterJNI;
    this.flutterJNI.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    AppMethodBeat.o(10185);
  }
  
  private void markTextureFrameAvailable(long paramLong)
  {
    AppMethodBeat.i(190058);
    this.flutterJNI.markTextureFrameAvailable(paramLong);
    AppMethodBeat.o(190058);
  }
  
  private void registerTexture(long paramLong, SurfaceTextureWrapper paramSurfaceTextureWrapper)
  {
    AppMethodBeat.i(190056);
    this.flutterJNI.registerTexture(paramLong, paramSurfaceTextureWrapper);
    AppMethodBeat.o(190056);
  }
  
  private void unregisterTexture(long paramLong)
  {
    AppMethodBeat.i(190061);
    this.flutterJNI.unregisterTexture(paramLong);
    AppMethodBeat.o(190061);
  }
  
  public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    AppMethodBeat.i(190105);
    this.flutterJNI.addIsDisplayingFlutterUiListener(paramFlutterUiDisplayListener);
    if (this.isDisplayingFlutterUi) {
      paramFlutterUiDisplayListener.onFlutterUiDisplayed();
    }
    AppMethodBeat.o(190105);
  }
  
  public TextureRegistry.SurfaceTextureEntry createSurfaceTexture()
  {
    AppMethodBeat.i(10190);
    Log.v("FlutterRenderer", "Creating a SurfaceTexture.");
    Object localObject = new SurfaceTexture(0);
    ((SurfaceTexture)localObject).detachFromGLContext();
    localObject = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), (SurfaceTexture)localObject);
    Log.v("FlutterRenderer", "New SurfaceTexture ID: " + ((SurfaceTextureRegistryEntry)localObject).id());
    registerTexture(((SurfaceTextureRegistryEntry)localObject).id(), ((SurfaceTextureRegistryEntry)localObject).textureWrapper());
    AppMethodBeat.o(10190);
    return localObject;
  }
  
  public void dispatchPointerDataPacket(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(10194);
    this.flutterJNI.dispatchPointerDataPacket(paramByteBuffer, paramInt);
    AppMethodBeat.o(10194);
  }
  
  public void dispatchSemanticsAction(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3)
  {
    AppMethodBeat.i(190207);
    this.flutterJNI.dispatchSemanticsAction(paramInt1, paramInt2, paramByteBuffer, paramInt3);
    AppMethodBeat.o(190207);
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(190169);
    Bitmap localBitmap = this.flutterJNI.getBitmap();
    AppMethodBeat.o(190169);
    return localBitmap;
  }
  
  public boolean isDisplayingFlutterUi()
  {
    return this.isDisplayingFlutterUi;
  }
  
  public boolean isSoftwareRenderingEnabled()
  {
    AppMethodBeat.i(190185);
    boolean bool = this.flutterJNI.getIsSoftwareRenderingEnabled();
    AppMethodBeat.o(190185);
    return bool;
  }
  
  public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    AppMethodBeat.i(190112);
    this.flutterJNI.removeIsDisplayingFlutterUiListener(paramFlutterUiDisplayListener);
    AppMethodBeat.o(190112);
  }
  
  public void setAccessibilityFeatures(int paramInt)
  {
    AppMethodBeat.i(190192);
    this.flutterJNI.setAccessibilityFeatures(paramInt);
    AppMethodBeat.o(190192);
  }
  
  public void setBackgroundExecutor(Executor paramExecutor)
  {
    this.backgroundExecutor = paramExecutor;
  }
  
  public void setSemanticsEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(190201);
    this.flutterJNI.setSemanticsEnabled(paramBoolean);
    AppMethodBeat.o(190201);
  }
  
  public void setViewportMetrics(ViewportMetrics paramViewportMetrics)
  {
    AppMethodBeat.i(10193);
    Log.v("FlutterRenderer", "Setting viewport metrics\nSize: " + paramViewportMetrics.width + " x " + paramViewportMetrics.height + "\nPadding - L: " + paramViewportMetrics.viewPaddingLeft + ", T: " + paramViewportMetrics.viewPaddingTop + ", R: " + paramViewportMetrics.viewPaddingRight + ", B: " + paramViewportMetrics.viewPaddingBottom + "\nInsets - L: " + paramViewportMetrics.viewInsetLeft + ", T: " + paramViewportMetrics.viewInsetTop + ", R: " + paramViewportMetrics.viewInsetRight + ", B: " + paramViewportMetrics.viewInsetBottom + "\nSystem Gesture Insets - L: " + paramViewportMetrics.systemGestureInsetLeft + ", T: " + paramViewportMetrics.systemGestureInsetTop + ", R: " + paramViewportMetrics.systemGestureInsetRight + ", B: " + paramViewportMetrics.viewInsetBottom);
    this.flutterJNI.setViewportMetrics(paramViewportMetrics.devicePixelRatio, paramViewportMetrics.width, paramViewportMetrics.height, paramViewportMetrics.viewPaddingTop, paramViewportMetrics.viewPaddingRight, paramViewportMetrics.viewPaddingBottom, paramViewportMetrics.viewPaddingLeft, paramViewportMetrics.viewInsetTop, paramViewportMetrics.viewInsetRight, paramViewportMetrics.viewInsetBottom, paramViewportMetrics.viewInsetLeft, paramViewportMetrics.systemGestureInsetTop, paramViewportMetrics.systemGestureInsetRight, paramViewportMetrics.systemGestureInsetBottom, paramViewportMetrics.systemGestureInsetLeft);
    AppMethodBeat.o(10193);
  }
  
  public void startRenderingToSurface(Surface paramSurface)
  {
    AppMethodBeat.i(190129);
    if (this.surface != null) {
      stopRenderingToSurface();
    }
    this.surface = paramSurface;
    this.flutterJNI.onSurfaceCreated(paramSurface);
    AppMethodBeat.o(190129);
  }
  
  public void stopRenderingToSurface()
  {
    AppMethodBeat.i(190156);
    this.flutterJNI.onSurfaceDestroyed();
    this.surface = null;
    if (this.isDisplayingFlutterUi) {
      this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
    }
    this.isDisplayingFlutterUi = false;
    AppMethodBeat.o(190156);
  }
  
  public void surfaceChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10192);
    this.flutterJNI.onSurfaceChanged(paramInt1, paramInt2);
    AppMethodBeat.o(10192);
  }
  
  public void swapSurface(Surface paramSurface)
  {
    AppMethodBeat.i(190138);
    this.surface = paramSurface;
    this.flutterJNI.onSurfaceWindowChanged(paramSurface);
    AppMethodBeat.o(190138);
  }
  
  final class SurfaceTextureRegistryEntry
    implements TextureRegistry.SurfaceTextureEntry
  {
    private final long id;
    private SurfaceTexture.OnFrameAvailableListener onFrameListener;
    private boolean released;
    private final SurfaceTextureWrapper textureWrapper;
    
    SurfaceTextureRegistryEntry(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(10195);
      this.onFrameListener = new SurfaceTexture.OnFrameAvailableListener()
      {
        public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(10197);
          if ((FlutterRenderer.SurfaceTextureRegistryEntry.this.released) || (!FlutterRenderer.this.flutterJNI.isAttached()))
          {
            AppMethodBeat.o(10197);
            return;
          }
          FlutterRenderer.access$400(FlutterRenderer.this, FlutterRenderer.SurfaceTextureRegistryEntry.this.id);
          AppMethodBeat.o(10197);
        }
      };
      this.id = paramLong;
      this.textureWrapper = new SurfaceTextureWrapper(paramSurfaceTexture);
      if (Build.VERSION.SDK_INT >= 21)
      {
        surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
        AppMethodBeat.o(10195);
        return;
      }
      surfaceTexture().setOnFrameAvailableListener(this.onFrameListener);
      AppMethodBeat.o(10195);
    }
    
    public final long id()
    {
      return this.id;
    }
    
    public final void release()
    {
      AppMethodBeat.i(10196);
      if (this.released)
      {
        AppMethodBeat.o(10196);
        return;
      }
      Log.v("FlutterRenderer", "Releasing a SurfaceTexture (" + this.id + ").");
      FlutterRenderer.this.backgroundExecutor.execute(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(190046);
          FlutterRenderer.SurfaceTextureRegistryEntry.this.textureWrapper.release();
          AppMethodBeat.o(190046);
        }
      });
      FlutterRenderer.access$700(FlutterRenderer.this, this.id);
      this.released = true;
      AppMethodBeat.o(10196);
    }
    
    public final SurfaceTexture surfaceTexture()
    {
      AppMethodBeat.i(190077);
      SurfaceTexture localSurfaceTexture = this.textureWrapper.surfaceTexture();
      AppMethodBeat.o(190077);
      return localSurfaceTexture;
    }
    
    public final SurfaceTextureWrapper textureWrapper()
    {
      return this.textureWrapper;
    }
  }
  
  public static final class ViewportMetrics
  {
    public float devicePixelRatio = 1.0F;
    public int height = 0;
    public int systemGestureInsetBottom = 0;
    public int systemGestureInsetLeft = 0;
    public int systemGestureInsetRight = 0;
    public int systemGestureInsetTop = 0;
    public int viewInsetBottom = 0;
    public int viewInsetLeft = 0;
    public int viewInsetRight = 0;
    public int viewInsetTop = 0;
    public int viewPaddingBottom = 0;
    public int viewPaddingLeft = 0;
    public int viewPaddingRight = 0;
    public int viewPaddingTop = 0;
    public int width = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.FlutterRenderer
 * JD-Core Version:    0.7.0.1
 */