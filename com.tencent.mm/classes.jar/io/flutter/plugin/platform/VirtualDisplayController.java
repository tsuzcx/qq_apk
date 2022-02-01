package io.flutter.plugin.platform;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;

class VirtualDisplayController
{
  private final AccessibilityEventsDelegate accessibilityEventsDelegate;
  private final Context context;
  private final int densityDpi;
  private final View.OnFocusChangeListener focusChangeListener;
  SingleViewPresentation presentation;
  private Surface surface;
  private final TextureRegistry.SurfaceTextureEntry textureEntry;
  private VirtualDisplay virtualDisplay;
  
  private VirtualDisplayController(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, VirtualDisplay paramVirtualDisplay, PlatformViewFactory paramPlatformViewFactory, Surface paramSurface, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, View.OnFocusChangeListener paramOnFocusChangeListener, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(9915);
    this.context = paramContext;
    this.accessibilityEventsDelegate = paramAccessibilityEventsDelegate;
    this.textureEntry = paramSurfaceTextureEntry;
    this.focusChangeListener = paramOnFocusChangeListener;
    this.surface = paramSurface;
    this.virtualDisplay = paramVirtualDisplay;
    this.densityDpi = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.presentation = new SingleViewPresentation(paramContext, this.virtualDisplay.getDisplay(), paramPlatformViewFactory, paramAccessibilityEventsDelegate, paramInt, paramObject, paramOnFocusChangeListener);
    this.presentation.show();
    AppMethodBeat.o(9915);
  }
  
  public static VirtualDisplayController create(Context paramContext, AccessibilityEventsDelegate paramAccessibilityEventsDelegate, PlatformViewFactory paramPlatformViewFactory, TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, int paramInt1, int paramInt2, int paramInt3, Object paramObject, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(189927);
    paramSurfaceTextureEntry.surfaceTexture().setDefaultBufferSize(paramInt1, paramInt2);
    Surface localSurface = new Surface(paramSurfaceTextureEntry.surfaceTexture());
    VirtualDisplay localVirtualDisplay = ((DisplayManager)paramContext.getSystemService("display")).createVirtualDisplay("flutter-vd", paramInt1, paramInt2, paramContext.getResources().getDisplayMetrics().densityDpi, localSurface, 0);
    if (localVirtualDisplay == null)
    {
      AppMethodBeat.o(189927);
      return null;
    }
    paramContext = new VirtualDisplayController(paramContext, paramAccessibilityEventsDelegate, localVirtualDisplay, paramPlatformViewFactory, localSurface, paramSurfaceTextureEntry, paramOnFocusChangeListener, paramInt3, paramObject);
    AppMethodBeat.o(189927);
    return paramContext;
  }
  
  public void dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(190011);
    if (this.presentation == null)
    {
      AppMethodBeat.o(190011);
      return;
    }
    this.presentation.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(190011);
  }
  
  public void dispose()
  {
    AppMethodBeat.i(9916);
    PlatformView localPlatformView = this.presentation.getView();
    this.presentation.cancel();
    this.presentation.detachState();
    localPlatformView.dispose();
    this.virtualDisplay.release();
    this.textureEntry.release();
    AppMethodBeat.o(9916);
  }
  
  public View getView()
  {
    AppMethodBeat.i(9917);
    if (this.presentation == null)
    {
      AppMethodBeat.o(9917);
      return null;
    }
    View localView = this.presentation.getView().getView();
    AppMethodBeat.o(9917);
    return localView;
  }
  
  void onFlutterViewAttached(View paramView)
  {
    AppMethodBeat.i(189967);
    if ((this.presentation == null) || (this.presentation.getView() == null))
    {
      AppMethodBeat.o(189967);
      return;
    }
    this.presentation.getView().onFlutterViewAttached(paramView);
    AppMethodBeat.o(189967);
  }
  
  void onFlutterViewDetached()
  {
    AppMethodBeat.i(189975);
    if ((this.presentation == null) || (this.presentation.getView() == null))
    {
      AppMethodBeat.o(189975);
      return;
    }
    this.presentation.getView().onFlutterViewDetached();
    AppMethodBeat.o(189975);
  }
  
  void onInputConnectionLocked()
  {
    AppMethodBeat.i(189984);
    if ((this.presentation == null) || (this.presentation.getView() == null))
    {
      AppMethodBeat.o(189984);
      return;
    }
    this.presentation.getView().onInputConnectionLocked();
    AppMethodBeat.o(189984);
  }
  
  void onInputConnectionUnlocked()
  {
    AppMethodBeat.i(189991);
    if ((this.presentation == null) || (this.presentation.getView() == null))
    {
      AppMethodBeat.o(189991);
      return;
    }
    this.presentation.getView().onInputConnectionUnlocked();
    AppMethodBeat.o(189991);
  }
  
  public void resize(int paramInt1, int paramInt2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(189949);
    boolean bool = getView().isFocused();
    SingleViewPresentation.PresentationState localPresentationState = this.presentation.detachState();
    this.virtualDisplay.setSurface(null);
    this.virtualDisplay.release();
    this.textureEntry.surfaceTexture().setDefaultBufferSize(paramInt1, paramInt2);
    this.virtualDisplay = ((DisplayManager)this.context.getSystemService("display")).createVirtualDisplay("flutter-vd", paramInt1, paramInt2, this.densityDpi, this.surface, 0);
    final View localView = getView();
    localView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public void onViewAttachedToWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(9892);
        VirtualDisplayController.OneTimeOnDrawListener.schedule(localView, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(9932);
            VirtualDisplayController.1.this.val$embeddedView.postDelayed(VirtualDisplayController.1.this.val$onNewSizeFrameAvailable, 128L);
            AppMethodBeat.o(9932);
          }
        });
        localView.removeOnAttachStateChangeListener(this);
        AppMethodBeat.o(9892);
      }
      
      public void onViewDetachedFromWindow(View paramAnonymousView) {}
    });
    paramRunnable = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, localPresentationState, this.focusChangeListener, bool);
    paramRunnable.show();
    this.presentation.cancel();
    this.presentation = paramRunnable;
    AppMethodBeat.o(189949);
  }
  
  static class OneTimeOnDrawListener
    implements ViewTreeObserver.OnDrawListener
  {
    Runnable mOnDrawRunnable;
    final View mView;
    
    OneTimeOnDrawListener(View paramView, Runnable paramRunnable)
    {
      this.mView = paramView;
      this.mOnDrawRunnable = paramRunnable;
    }
    
    static void schedule(View paramView, Runnable paramRunnable)
    {
      AppMethodBeat.i(9890);
      paramRunnable = new OneTimeOnDrawListener(paramView, paramRunnable);
      paramView.getViewTreeObserver().addOnDrawListener(paramRunnable);
      AppMethodBeat.o(9890);
    }
    
    public void onDraw()
    {
      AppMethodBeat.i(9891);
      if (this.mOnDrawRunnable == null)
      {
        AppMethodBeat.o(9891);
        return;
      }
      this.mOnDrawRunnable.run();
      this.mOnDrawRunnable = null;
      this.mView.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(9887);
          VirtualDisplayController.OneTimeOnDrawListener.this.mView.getViewTreeObserver().removeOnDrawListener(VirtualDisplayController.OneTimeOnDrawListener.this);
          AppMethodBeat.o(9887);
        }
      });
      AppMethodBeat.o(9891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.platform.VirtualDisplayController
 * JD-Core Version:    0.7.0.1
 */