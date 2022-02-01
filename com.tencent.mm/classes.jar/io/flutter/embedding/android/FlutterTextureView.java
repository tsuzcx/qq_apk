package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;

public class FlutterTextureView
  extends TextureView
  implements RenderSurface
{
  private static final String TAG = "FlutterTextureView";
  private FlutterRenderer flutterRenderer;
  private boolean isAttachedToFlutterRenderer;
  private boolean isSurfaceAvailableForRendering;
  private Surface renderSurface;
  private final TextureView.SurfaceTextureListener surfaceTextureListener;
  
  public FlutterTextureView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9970);
    this.isSurfaceAvailableForRendering = false;
    this.isAttachedToFlutterRenderer = false;
    this.surfaceTextureListener = new TextureView.SurfaceTextureListener()
    {
      public void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(10019);
        Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
        FlutterTextureView.access$002(FlutterTextureView.this, true);
        if (FlutterTextureView.this.isAttachedToFlutterRenderer) {
          FlutterTextureView.access$200(FlutterTextureView.this);
        }
        AppMethodBeat.o(10019);
      }
      
      public boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        AppMethodBeat.i(10021);
        Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
        FlutterTextureView.access$002(FlutterTextureView.this, false);
        if (FlutterTextureView.this.isAttachedToFlutterRenderer) {
          FlutterTextureView.access$400(FlutterTextureView.this);
        }
        AppMethodBeat.o(10021);
        return true;
      }
      
      public void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(10020);
        Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
        if (FlutterTextureView.this.isAttachedToFlutterRenderer) {
          FlutterTextureView.access$300(FlutterTextureView.this, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(10020);
      }
      
      public void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    init();
    AppMethodBeat.o(9970);
  }
  
  private void changeSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190405);
    if (this.flutterRenderer == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(190405);
      throw localIllegalStateException;
    }
    Log.v("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + paramInt1 + " x " + paramInt2);
    this.flutterRenderer.surfaceChanged(paramInt1, paramInt2);
    AppMethodBeat.o(190405);
  }
  
  private void connectSurfaceToRenderer()
  {
    AppMethodBeat.i(9973);
    if ((this.flutterRenderer == null) || (getSurfaceTexture() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
      AppMethodBeat.o(9973);
      throw localIllegalStateException;
    }
    this.renderSurface = new Surface(getSurfaceTexture());
    this.flutterRenderer.startRenderingToSurface(this.renderSurface);
    AppMethodBeat.o(9973);
  }
  
  private void disconnectSurfaceFromRenderer()
  {
    AppMethodBeat.i(9974);
    if (this.flutterRenderer == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(9974);
      throw localIllegalStateException;
    }
    this.flutterRenderer.stopRenderingToSurface();
    if (this.renderSurface != null)
    {
      this.renderSurface.release();
      this.renderSurface = null;
    }
    AppMethodBeat.o(9974);
  }
  
  private void init()
  {
    AppMethodBeat.i(190390);
    setSurfaceTextureListener(this.surfaceTextureListener);
    AppMethodBeat.o(190390);
  }
  
  public void attachToRenderer(FlutterRenderer paramFlutterRenderer)
  {
    AppMethodBeat.i(9971);
    Log.v("FlutterTextureView", "Attaching to FlutterRenderer.");
    if (this.flutterRenderer != null)
    {
      Log.v("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
      this.flutterRenderer.stopRenderingToSurface();
    }
    this.flutterRenderer = paramFlutterRenderer;
    this.isAttachedToFlutterRenderer = true;
    if (this.isSurfaceAvailableForRendering)
    {
      Log.v("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
      connectSurfaceToRenderer();
    }
    AppMethodBeat.o(9971);
  }
  
  public void detachFromRenderer()
  {
    AppMethodBeat.i(9972);
    if (this.flutterRenderer != null)
    {
      if (getWindowToken() != null)
      {
        Log.v("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
        disconnectSurfaceFromRenderer();
      }
      this.flutterRenderer = null;
      this.isAttachedToFlutterRenderer = false;
      AppMethodBeat.o(9972);
      return;
    }
    Log.w("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    AppMethodBeat.o(9972);
  }
  
  public FlutterRenderer getAttachedRenderer()
  {
    return this.flutterRenderer;
  }
  
  public void pause()
  {
    AppMethodBeat.i(190491);
    if (this.flutterRenderer != null)
    {
      this.flutterRenderer = null;
      this.isAttachedToFlutterRenderer = false;
      AppMethodBeat.o(190491);
      return;
    }
    Log.w("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
    AppMethodBeat.o(190491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterTextureView
 * JD-Core Version:    0.7.0.1
 */