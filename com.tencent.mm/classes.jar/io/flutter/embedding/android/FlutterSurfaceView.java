package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;

public class FlutterSurfaceView
  extends SurfaceView
  implements RenderSurface
{
  private static final String TAG = "FlutterSurfaceView";
  private FlutterRenderer flutterRenderer;
  private final FlutterUiDisplayListener flutterUiDisplayListener;
  private boolean isAttachedToFlutterRenderer;
  private boolean isSurfaceAvailableForRendering;
  private final boolean renderTransparently;
  private final SurfaceHolder.Callback surfaceCallback;
  
  public FlutterSurfaceView(Context paramContext)
  {
    this(paramContext, null, false);
  }
  
  public FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  private FlutterSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(10010);
    this.isSurfaceAvailableForRendering = false;
    this.isAttachedToFlutterRenderer = false;
    this.surfaceCallback = new SurfaceHolder.Callback()
    {
      public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(9968);
        Log.v("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
        if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
          FlutterSurfaceView.access$300(FlutterSurfaceView.this, paramAnonymousInt2, paramAnonymousInt3);
        }
        AppMethodBeat.o(9968);
      }
      
      public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9967);
        Log.v("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
        FlutterSurfaceView.access$002(FlutterSurfaceView.this, true);
        if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
          FlutterSurfaceView.access$200(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9967);
      }
      
      public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9969);
        Log.v("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
        FlutterSurfaceView.access$002(FlutterSurfaceView.this, false);
        if (FlutterSurfaceView.this.isAttachedToFlutterRenderer) {
          FlutterSurfaceView.access$400(FlutterSurfaceView.this);
        }
        AppMethodBeat.o(9969);
      }
    };
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190353);
        Log.v("FlutterSurfaceView", "onFlutterUiDisplayed()");
        FlutterSurfaceView.this.setAlpha(1.0F);
        if (FlutterSurfaceView.this.flutterRenderer != null) {
          FlutterSurfaceView.this.flutterRenderer.removeIsDisplayingFlutterUiListener(this);
        }
        AppMethodBeat.o(190353);
      }
      
      public void onFlutterUiNoLongerDisplayed() {}
    };
    this.renderTransparently = paramBoolean;
    init();
    AppMethodBeat.o(10010);
  }
  
  public FlutterSurfaceView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
  }
  
  private void changeSurfaceSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190399);
    if (this.flutterRenderer == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(190399);
      throw localIllegalStateException;
    }
    Log.v("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + paramInt1 + " x " + paramInt2);
    this.flutterRenderer.surfaceChanged(paramInt1, paramInt2);
    AppMethodBeat.o(190399);
  }
  
  private void connectSurfaceToRenderer()
  {
    AppMethodBeat.i(10013);
    if ((this.flutterRenderer == null) || (getHolder() == null))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
      AppMethodBeat.o(10013);
      throw localIllegalStateException;
    }
    this.flutterRenderer.startRenderingToSurface(getHolder().getSurface());
    AppMethodBeat.o(10013);
  }
  
  private void disconnectSurfaceFromRenderer()
  {
    AppMethodBeat.i(10014);
    if (this.flutterRenderer == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
      AppMethodBeat.o(10014);
      throw localIllegalStateException;
    }
    this.flutterRenderer.stopRenderingToSurface();
    AppMethodBeat.o(10014);
  }
  
  private void init()
  {
    AppMethodBeat.i(190387);
    if (this.renderTransparently)
    {
      getHolder().setFormat(-2);
      setZOrderOnTop(true);
    }
    getHolder().addCallback(this.surfaceCallback);
    setAlpha(0.0F);
    AppMethodBeat.o(190387);
  }
  
  public void attachToRenderer(FlutterRenderer paramFlutterRenderer)
  {
    AppMethodBeat.i(10011);
    Log.v("FlutterSurfaceView", "Attaching to FlutterRenderer.");
    if (this.flutterRenderer != null)
    {
      Log.v("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
      this.flutterRenderer.stopRenderingToSurface();
      this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    }
    this.flutterRenderer = paramFlutterRenderer;
    this.isAttachedToFlutterRenderer = true;
    this.flutterRenderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    if (this.isSurfaceAvailableForRendering)
    {
      Log.v("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
      connectSurfaceToRenderer();
    }
    AppMethodBeat.o(10011);
  }
  
  public void detachFromRenderer()
  {
    AppMethodBeat.i(10012);
    if (this.flutterRenderer != null)
    {
      if (getWindowToken() != null)
      {
        Log.v("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
        disconnectSurfaceFromRenderer();
      }
      setAlpha(0.0F);
      this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
      this.flutterRenderer = null;
      this.isAttachedToFlutterRenderer = false;
      AppMethodBeat.o(10012);
      return;
    }
    Log.w("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
    AppMethodBeat.o(10012);
  }
  
  public boolean gatherTransparentRegion(Region paramRegion)
  {
    AppMethodBeat.i(190469);
    if (getAlpha() < 1.0F)
    {
      AppMethodBeat.o(190469);
      return false;
    }
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRegion.op(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + getRight() - getLeft(), arrayOfInt[1] + getBottom() - getTop(), Region.Op.DIFFERENCE);
    AppMethodBeat.o(190469);
    return true;
  }
  
  public FlutterRenderer getAttachedRenderer()
  {
    return this.flutterRenderer;
  }
  
  public void pause()
  {
    AppMethodBeat.i(190499);
    if (this.flutterRenderer != null)
    {
      this.flutterRenderer = null;
      this.isAttachedToFlutterRenderer = false;
      AppMethodBeat.o(190499);
      return;
    }
    Log.w("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
    AppMethodBeat.o(190499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView
 * JD-Core Version:    0.7.0.1
 */