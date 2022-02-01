package io.flutter.plugin.platform;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.FlutterImageView.SurfaceKind;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.MotionEventTracker;
import io.flutter.embedding.android.MotionEventTracker.MotionEventId;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewCreationRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewResizeRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewTouch;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CustomPlatformViewsController
  extends PlatformViewsController
{
  private static final String TAG = "PlatformViewsController";
  private final AccessibilityEventsDelegate accessibilityEventsDelegate;
  private AndroidTouchProcessor androidTouchProcessor;
  protected final PlatformViewsChannel.PlatformViewsHandler channelHandler;
  protected Context context;
  private final HashMap<Context, View> contextToPlatformView;
  private HashSet<Integer> currentFrameUsedOverlayLayerIds;
  private HashSet<Integer> currentFrameUsedPlatformViewIds;
  private View flutterView;
  private boolean flutterViewConvertedToImageView;
  private final MotionEventTracker motionEventTracker;
  private int nextOverlayLayerId;
  private final SparseArray<FlutterImageView> overlayLayerViews;
  private final SparseArray<FlutterMutatorView> platformViewParent;
  private final SparseArray<PlatformView> platformViews;
  protected PlatformViewsChannel platformViewsChannel;
  private final PlatformViewRegistryImpl registry;
  private TextInputPlugin textInputPlugin;
  protected TextureRegistry textureRegistry;
  final HashMap<Integer, VirtualDisplayController> vdControllers;
  
  public CustomPlatformViewsController()
  {
    AppMethodBeat.i(189950);
    this.nextOverlayLayerId = 0;
    this.flutterViewConvertedToImageView = false;
    this.channelHandler = new PlatformViewsChannel.PlatformViewsHandler()
    {
      private void ensureValidAndroidVersion(int paramAnonymousInt)
      {
        AppMethodBeat.i(189868);
        if (Build.VERSION.SDK_INT < paramAnonymousInt)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("Trying to use platform views with API " + Build.VERSION.SDK_INT + ", required API level is: " + paramAnonymousInt);
          AppMethodBeat.o(189868);
          throw localIllegalStateException;
        }
        AppMethodBeat.o(189868);
      }
      
      public void clearFocus(int paramAnonymousInt)
      {
        AppMethodBeat.i(189925);
        ensureValidAndroidVersion(20);
        ((VirtualDisplayController)CustomPlatformViewsController.this.vdControllers.get(Integer.valueOf(paramAnonymousInt))).getView().clearFocus();
        AppMethodBeat.o(189925);
      }
      
      public void createAndroidViewForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest paramAnonymousPlatformViewCreationRequest)
      {
        AppMethodBeat.i(189874);
        ensureValidAndroidVersion(19);
        if (!CustomPlatformViewsController.access$000(paramAnonymousPlatformViewCreationRequest.direction))
        {
          paramAnonymousPlatformViewCreationRequest = new IllegalStateException("Trying to create a view with unknown direction value: " + paramAnonymousPlatformViewCreationRequest.direction + "(view id: " + paramAnonymousPlatformViewCreationRequest.viewId + ")");
          AppMethodBeat.o(189874);
          throw paramAnonymousPlatformViewCreationRequest;
        }
        PlatformViewFactory localPlatformViewFactory = CustomPlatformViewsController.this.registry.getFactory(paramAnonymousPlatformViewCreationRequest.viewType);
        if (localPlatformViewFactory == null)
        {
          paramAnonymousPlatformViewCreationRequest = new IllegalStateException("Trying to create a platform view of unregistered type: " + paramAnonymousPlatformViewCreationRequest.viewType);
          AppMethodBeat.o(189874);
          throw paramAnonymousPlatformViewCreationRequest;
        }
        Object localObject = null;
        if (paramAnonymousPlatformViewCreationRequest.params != null) {
          localObject = localPlatformViewFactory.getCreateArgsCodec().decodeMessage(paramAnonymousPlatformViewCreationRequest.params);
        }
        localObject = localPlatformViewFactory.create(CustomPlatformViewsController.this.context, paramAnonymousPlatformViewCreationRequest.viewId, localObject);
        CustomPlatformViewsController.this.platformViews.put(paramAnonymousPlatformViewCreationRequest.viewId, localObject);
        AppMethodBeat.o(189874);
      }
      
      public long createVirtualDisplayForPlatformView(PlatformViewsChannel.PlatformViewCreationRequest paramAnonymousPlatformViewCreationRequest)
      {
        AppMethodBeat.i(189896);
        ensureValidAndroidVersion(20);
        if (!CustomPlatformViewsController.access$000(paramAnonymousPlatformViewCreationRequest.direction))
        {
          paramAnonymousPlatformViewCreationRequest = new IllegalStateException("Trying to create a view with unknown direction value: " + paramAnonymousPlatformViewCreationRequest.direction + "(view id: " + paramAnonymousPlatformViewCreationRequest.viewId + ")");
          AppMethodBeat.o(189896);
          throw paramAnonymousPlatformViewCreationRequest;
        }
        if (CustomPlatformViewsController.this.vdControllers.containsKey(Integer.valueOf(paramAnonymousPlatformViewCreationRequest.viewId)))
        {
          paramAnonymousPlatformViewCreationRequest = new IllegalStateException("Trying to create an already created platform view, view id: " + paramAnonymousPlatformViewCreationRequest.viewId);
          AppMethodBeat.o(189896);
          throw paramAnonymousPlatformViewCreationRequest;
        }
        PlatformViewFactory localPlatformViewFactory = CustomPlatformViewsController.this.registry.getFactory(paramAnonymousPlatformViewCreationRequest.viewType);
        if (localPlatformViewFactory == null)
        {
          paramAnonymousPlatformViewCreationRequest = new IllegalStateException("Trying to create a platform view of unregistered type: " + paramAnonymousPlatformViewCreationRequest.viewType);
          AppMethodBeat.o(189896);
          throw paramAnonymousPlatformViewCreationRequest;
        }
        Object localObject = null;
        if (paramAnonymousPlatformViewCreationRequest.params != null) {
          localObject = localPlatformViewFactory.getCreateArgsCodec().decodeMessage(paramAnonymousPlatformViewCreationRequest.params);
        }
        int i = CustomPlatformViewsController.this.toPhysicalPixels(paramAnonymousPlatformViewCreationRequest.logicalWidth);
        int j = CustomPlatformViewsController.this.toPhysicalPixels(paramAnonymousPlatformViewCreationRequest.logicalHeight);
        CustomPlatformViewsController.this.validateVirtualDisplayDimensions(i, j);
        TextureRegistry.SurfaceTextureEntry localSurfaceTextureEntry = CustomPlatformViewsController.this.textureRegistry.createSurfaceTexture();
        localObject = VirtualDisplayController.create(CustomPlatformViewsController.this.context, CustomPlatformViewsController.this.accessibilityEventsDelegate, localPlatformViewFactory, localSurfaceTextureEntry, i, j, paramAnonymousPlatformViewCreationRequest.viewId, localObject, new CustomPlatformViewsController.1..ExternalSyntheticLambda0(this, paramAnonymousPlatformViewCreationRequest));
        if (localObject == null)
        {
          paramAnonymousPlatformViewCreationRequest = new IllegalStateException("Failed creating virtual display for a " + paramAnonymousPlatformViewCreationRequest.viewType + " with id: " + paramAnonymousPlatformViewCreationRequest.viewId);
          AppMethodBeat.o(189896);
          throw paramAnonymousPlatformViewCreationRequest;
        }
        if (CustomPlatformViewsController.this.flutterView != null) {
          ((VirtualDisplayController)localObject).onFlutterViewAttached(CustomPlatformViewsController.this.flutterView);
        }
        CustomPlatformViewsController.this.vdControllers.put(Integer.valueOf(paramAnonymousPlatformViewCreationRequest.viewId), localObject);
        localObject = ((VirtualDisplayController)localObject).getView();
        ((View)localObject).setLayoutDirection(paramAnonymousPlatformViewCreationRequest.direction);
        CustomPlatformViewsController.this.contextToPlatformView.put(((View)localObject).getContext(), localObject);
        long l = localSurfaceTextureEntry.id();
        AppMethodBeat.o(189896);
        return l;
      }
      
      public void disposeAndroidViewForPlatformView(int paramAnonymousInt)
      {
        AppMethodBeat.i(189884);
        PlatformView localPlatformView = (PlatformView)CustomPlatformViewsController.this.platformViews.get(paramAnonymousInt);
        FlutterMutatorView localFlutterMutatorView = (FlutterMutatorView)CustomPlatformViewsController.this.platformViewParent.get(paramAnonymousInt);
        if (localPlatformView != null)
        {
          if (localFlutterMutatorView != null) {
            localFlutterMutatorView.removeView(localPlatformView.getView());
          }
          CustomPlatformViewsController.this.platformViews.remove(paramAnonymousInt);
          localPlatformView.dispose();
        }
        if (localFlutterMutatorView != null)
        {
          ((ViewGroup)localFlutterMutatorView.getParent()).removeView(localFlutterMutatorView);
          CustomPlatformViewsController.this.platformViewParent.remove(paramAnonymousInt);
        }
        AppMethodBeat.o(189884);
      }
      
      public void disposeVirtualDisplayForPlatformView(int paramAnonymousInt)
      {
        AppMethodBeat.i(189900);
        ensureValidAndroidVersion(20);
        Object localObject = (VirtualDisplayController)CustomPlatformViewsController.this.vdControllers.get(Integer.valueOf(paramAnonymousInt));
        if (localObject == null)
        {
          localObject = new IllegalStateException("Trying to dispose a platform view with unknown id: ".concat(String.valueOf(paramAnonymousInt)));
          AppMethodBeat.o(189900);
          throw ((Throwable)localObject);
        }
        if (CustomPlatformViewsController.this.textInputPlugin != null) {
          CustomPlatformViewsController.this.textInputPlugin.clearPlatformViewClient(paramAnonymousInt);
        }
        CustomPlatformViewsController.this.contextToPlatformView.remove(((VirtualDisplayController)localObject).getView().getContext());
        ((VirtualDisplayController)localObject).dispose();
        CustomPlatformViewsController.this.vdControllers.remove(Integer.valueOf(paramAnonymousInt));
        AppMethodBeat.o(189900);
      }
      
      public void onTouch(PlatformViewsChannel.PlatformViewTouch paramAnonymousPlatformViewTouch)
      {
        AppMethodBeat.i(189911);
        int i = paramAnonymousPlatformViewTouch.viewId;
        float f = CustomPlatformViewsController.this.context.getResources().getDisplayMetrics().density;
        ensureValidAndroidVersion(20);
        MotionEvent localMotionEvent;
        if (CustomPlatformViewsController.this.vdControllers.containsKey(Integer.valueOf(i)))
        {
          localMotionEvent = CustomPlatformViewsController.this.toMotionEvent(f, paramAnonymousPlatformViewTouch, true);
          ((VirtualDisplayController)CustomPlatformViewsController.this.vdControllers.get(Integer.valueOf(paramAnonymousPlatformViewTouch.viewId))).dispatchTouchEvent(localMotionEvent);
          AppMethodBeat.o(189911);
          return;
        }
        if (CustomPlatformViewsController.this.platformViews.get(i) != null)
        {
          localMotionEvent = CustomPlatformViewsController.this.toMotionEvent(f, paramAnonymousPlatformViewTouch, false);
          paramAnonymousPlatformViewTouch = ((PlatformView)CustomPlatformViewsController.this.platformViews.get(paramAnonymousPlatformViewTouch.viewId)).getView();
          if (paramAnonymousPlatformViewTouch != null) {
            paramAnonymousPlatformViewTouch.dispatchTouchEvent(localMotionEvent);
          }
          AppMethodBeat.o(189911);
          return;
        }
        paramAnonymousPlatformViewTouch = new IllegalStateException("Sending touch to an unknown view with id: ".concat(String.valueOf(i)));
        AppMethodBeat.o(189911);
        throw paramAnonymousPlatformViewTouch;
      }
      
      public void resizePlatformView(PlatformViewsChannel.PlatformViewResizeRequest paramAnonymousPlatformViewResizeRequest, final Runnable paramAnonymousRunnable)
      {
        AppMethodBeat.i(189904);
        ensureValidAndroidVersion(20);
        final VirtualDisplayController localVirtualDisplayController = (VirtualDisplayController)CustomPlatformViewsController.this.vdControllers.get(Integer.valueOf(paramAnonymousPlatformViewResizeRequest.viewId));
        if (localVirtualDisplayController == null)
        {
          paramAnonymousPlatformViewResizeRequest = new IllegalStateException("Trying to resize a platform view with unknown id: " + paramAnonymousPlatformViewResizeRequest.viewId);
          AppMethodBeat.o(189904);
          throw paramAnonymousPlatformViewResizeRequest;
        }
        int i = CustomPlatformViewsController.this.toPhysicalPixels(paramAnonymousPlatformViewResizeRequest.newLogicalWidth);
        int j = CustomPlatformViewsController.this.toPhysicalPixels(paramAnonymousPlatformViewResizeRequest.newLogicalHeight);
        CustomPlatformViewsController.this.validateVirtualDisplayDimensions(i, j);
        CustomPlatformViewsController.access$800(CustomPlatformViewsController.this, localVirtualDisplayController);
        localVirtualDisplayController.resize(i, j, new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(189866);
            CustomPlatformViewsController.access$900(CustomPlatformViewsController.this, localVirtualDisplayController);
            paramAnonymousRunnable.run();
            AppMethodBeat.o(189866);
          }
        });
        AppMethodBeat.o(189904);
      }
      
      public void setDirection(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(189916);
        if (!CustomPlatformViewsController.access$000(paramAnonymousInt2))
        {
          localObject = new IllegalStateException("Trying to set unknown direction value: " + paramAnonymousInt2 + "(view id: " + paramAnonymousInt1 + ")");
          AppMethodBeat.o(189916);
          throw ((Throwable)localObject);
        }
        ensureValidAndroidVersion(20);
        Object localObject = ((VirtualDisplayController)CustomPlatformViewsController.this.vdControllers.get(Integer.valueOf(paramAnonymousInt1))).getView();
        if (localObject == null)
        {
          localObject = new IllegalStateException("Sending touch to an unknown view with id: ".concat(String.valueOf(paramAnonymousInt2)));
          AppMethodBeat.o(189916);
          throw ((Throwable)localObject);
        }
        ((View)localObject).setLayoutDirection(paramAnonymousInt2);
        AppMethodBeat.o(189916);
      }
    };
    this.registry = new PlatformViewRegistryImpl();
    this.vdControllers = new HashMap();
    this.accessibilityEventsDelegate = new AccessibilityEventsDelegate();
    this.contextToPlatformView = new HashMap();
    this.overlayLayerViews = new SparseArray();
    this.currentFrameUsedOverlayLayerIds = new HashSet();
    this.currentFrameUsedPlatformViewIds = new HashSet();
    this.platformViews = new SparseArray();
    this.platformViewParent = new SparseArray();
    this.motionEventTracker = MotionEventTracker.getInstance();
    AppMethodBeat.o(189950);
  }
  
  private void finishFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(190035);
    int i = 0;
    int j;
    Object localObject;
    if (i < this.overlayLayerViews.size())
    {
      j = this.overlayLayerViews.keyAt(i);
      localObject = (FlutterImageView)this.overlayLayerViews.valueAt(i);
      if (this.currentFrameUsedOverlayLayerIds.contains(Integer.valueOf(j)))
      {
        ((FlutterView)this.flutterView).attachOverlaySurfaceToRender((FlutterImageView)localObject);
        paramBoolean &= ((FlutterImageView)localObject).acquireLatestImage();
      }
      for (;;)
      {
        i += 1;
        break;
        if (!this.flutterViewConvertedToImageView) {
          ((FlutterImageView)localObject).detachFromRenderer();
        }
        ((FlutterImageView)localObject).setVisibility(8);
      }
    }
    i = 0;
    if (i < this.platformViewParent.size())
    {
      j = this.platformViewParent.keyAt(i);
      localObject = (View)this.platformViewParent.get(j);
      if ((paramBoolean) && (this.currentFrameUsedPlatformViewIds.contains(Integer.valueOf(j)))) {
        ((View)localObject).setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        ((View)localObject).setVisibility(8);
      }
    }
    AppMethodBeat.o(190035);
  }
  
  private void flushAllViews()
  {
    AppMethodBeat.i(190021);
    Iterator localIterator = this.vdControllers.values().iterator();
    while (localIterator.hasNext()) {
      ((VirtualDisplayController)localIterator.next()).dispose();
    }
    this.vdControllers.clear();
    while (this.platformViews.size() > 0) {
      this.channelHandler.disposeAndroidViewForPlatformView(this.platformViews.keyAt(0));
    }
    AppMethodBeat.o(190021);
  }
  
  private float getDisplayDensity()
  {
    AppMethodBeat.i(190016);
    float f = this.context.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(190016);
    return f;
  }
  
  private void initializeRootImageViewIfNeeded()
  {
    AppMethodBeat.i(190028);
    if (!this.flutterViewConvertedToImageView)
    {
      ((FlutterView)this.flutterView).convertToImageView();
      this.flutterViewConvertedToImageView = true;
    }
    AppMethodBeat.o(190028);
  }
  
  private void lockInputConnection(VirtualDisplayController paramVirtualDisplayController)
  {
    AppMethodBeat.i(189959);
    if (this.textInputPlugin == null)
    {
      AppMethodBeat.o(189959);
      return;
    }
    this.textInputPlugin.lockPlatformViewInputConnection();
    paramVirtualDisplayController.onInputConnectionLocked();
    AppMethodBeat.o(189959);
  }
  
  private static MotionEvent.PointerCoords parsePointerCoords(Object paramObject, float paramFloat)
  {
    AppMethodBeat.i(190006);
    paramObject = (List)paramObject;
    MotionEvent.PointerCoords localPointerCoords = new MotionEvent.PointerCoords();
    localPointerCoords.orientation = ((float)((Double)paramObject.get(0)).doubleValue());
    localPointerCoords.pressure = ((float)((Double)paramObject.get(1)).doubleValue());
    localPointerCoords.size = ((float)((Double)paramObject.get(2)).doubleValue());
    localPointerCoords.toolMajor = ((float)((Double)paramObject.get(3)).doubleValue() * paramFloat);
    localPointerCoords.toolMinor = ((float)((Double)paramObject.get(4)).doubleValue() * paramFloat);
    localPointerCoords.touchMajor = ((float)((Double)paramObject.get(5)).doubleValue() * paramFloat);
    localPointerCoords.touchMinor = ((float)((Double)paramObject.get(6)).doubleValue() * paramFloat);
    localPointerCoords.x = ((float)((Double)paramObject.get(7)).doubleValue() * paramFloat);
    localPointerCoords.y = ((float)((Double)paramObject.get(8)).doubleValue() * paramFloat);
    AppMethodBeat.o(190006);
    return localPointerCoords;
  }
  
  private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object paramObject, float paramFloat)
  {
    AppMethodBeat.i(189996);
    Object localObject = (List)paramObject;
    paramObject = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramObject.add(parsePointerCoords(((Iterator)localObject).next(), paramFloat));
    }
    AppMethodBeat.o(189996);
    return paramObject;
  }
  
  private static MotionEvent.PointerProperties parsePointerProperties(Object paramObject)
  {
    AppMethodBeat.i(189986);
    paramObject = (List)paramObject;
    MotionEvent.PointerProperties localPointerProperties = new MotionEvent.PointerProperties();
    localPointerProperties.id = ((Integer)paramObject.get(0)).intValue();
    localPointerProperties.toolType = ((Integer)paramObject.get(1)).intValue();
    AppMethodBeat.o(189986);
    return localPointerProperties;
  }
  
  private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object paramObject)
  {
    AppMethodBeat.i(189981);
    Object localObject = (List)paramObject;
    paramObject = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramObject.add(parsePointerProperties(((Iterator)localObject).next()));
    }
    AppMethodBeat.o(189981);
    return paramObject;
  }
  
  private void unlockInputConnection(VirtualDisplayController paramVirtualDisplayController)
  {
    AppMethodBeat.i(189965);
    if (this.textInputPlugin == null)
    {
      AppMethodBeat.o(189965);
      return;
    }
    this.textInputPlugin.unlockPlatformViewInputConnection();
    paramVirtualDisplayController.onInputConnectionUnlocked();
    AppMethodBeat.o(189965);
  }
  
  private static boolean validateDirection(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  public void attach(Context paramContext, TextureRegistry paramTextureRegistry, DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(190109);
    if (this.context != null)
    {
      paramContext = new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
      AppMethodBeat.o(190109);
      throw paramContext;
    }
    this.context = paramContext;
    this.textureRegistry = paramTextureRegistry;
    this.platformViewsChannel = new PlatformViewsChannel(paramDartExecutor);
    this.platformViewsChannel.setPlatformViewsHandler(this.channelHandler);
    AppMethodBeat.o(190109);
  }
  
  public void attachAccessibilityBridge(AccessibilityBridge paramAccessibilityBridge)
  {
    AppMethodBeat.i(190147);
    this.accessibilityEventsDelegate.setAccessibilityBridge(paramAccessibilityBridge);
    AppMethodBeat.o(190147);
  }
  
  public void attachTextInputPlugin(TextInputPlugin paramTextInputPlugin)
  {
    this.textInputPlugin = paramTextInputPlugin;
  }
  
  public void attachToFlutterRenderer(FlutterRenderer paramFlutterRenderer)
  {
    AppMethodBeat.i(190252);
    this.androidTouchProcessor = new AndroidTouchProcessor(paramFlutterRenderer, true);
    AppMethodBeat.o(190252);
  }
  
  public void attachToView(View paramView)
  {
    AppMethodBeat.i(190126);
    this.flutterView = paramView;
    Iterator localIterator = this.vdControllers.values().iterator();
    while (localIterator.hasNext()) {
      ((VirtualDisplayController)localIterator.next()).onFlutterViewAttached(paramView);
    }
    AppMethodBeat.o(190126);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(190177);
    if (paramView == null)
    {
      AppMethodBeat.o(190177);
      return false;
    }
    if (!this.contextToPlatformView.containsKey(paramView.getContext()))
    {
      AppMethodBeat.o(190177);
      return false;
    }
    View localView = (View)this.contextToPlatformView.get(paramView.getContext());
    if (localView == paramView)
    {
      AppMethodBeat.o(190177);
      return true;
    }
    boolean bool = localView.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(190177);
    return bool;
  }
  
  public FlutterOverlaySurface createOverlaySurface()
  {
    AppMethodBeat.i(190296);
    FlutterOverlaySurface localFlutterOverlaySurface = createOverlaySurface(new FlutterImageView(this.flutterView.getContext(), this.flutterView.getWidth(), this.flutterView.getHeight(), FlutterImageView.SurfaceKind.overlay));
    AppMethodBeat.o(190296);
    return localFlutterOverlaySurface;
  }
  
  public FlutterOverlaySurface createOverlaySurface(FlutterImageView paramFlutterImageView)
  {
    AppMethodBeat.i(190289);
    int i = this.nextOverlayLayerId;
    this.nextOverlayLayerId = (i + 1);
    this.overlayLayerViews.put(i, paramFlutterImageView);
    paramFlutterImageView = new FlutterOverlaySurface(i, paramFlutterImageView.getSurface());
    AppMethodBeat.o(190289);
    return paramFlutterImageView;
  }
  
  public void destroyOverlaySurfaces()
  {
    AppMethodBeat.i(190304);
    int i = 0;
    while (i < this.overlayLayerViews.size())
    {
      this.overlayLayerViews.keyAt(i);
      FlutterImageView localFlutterImageView = (FlutterImageView)this.overlayLayerViews.valueAt(i);
      localFlutterImageView.detachFromRenderer();
      ((FlutterView)this.flutterView).removeView(localFlutterImageView);
      i += 1;
    }
    this.overlayLayerViews.clear();
    AppMethodBeat.o(190304);
  }
  
  public void detach()
  {
    AppMethodBeat.i(190119);
    if (this.platformViewsChannel != null) {
      this.platformViewsChannel.setPlatformViewsHandler(null);
    }
    this.platformViewsChannel = null;
    this.context = null;
    this.textureRegistry = null;
    AppMethodBeat.o(190119);
  }
  
  public void detachAccessibiltyBridge()
  {
    AppMethodBeat.i(190157);
    this.accessibilityEventsDelegate.setAccessibilityBridge(null);
    AppMethodBeat.o(190157);
  }
  
  public void detachFromView()
  {
    AppMethodBeat.i(190135);
    this.flutterView = null;
    Iterator localIterator = this.vdControllers.values().iterator();
    while (localIterator.hasNext()) {
      ((VirtualDisplayController)localIterator.next()).onFlutterViewDetached();
    }
    AppMethodBeat.o(190135);
  }
  
  public void detachTextInputPlugin()
  {
    this.textInputPlugin = null;
  }
  
  public View getPlatformViewById(Integer paramInteger)
  {
    AppMethodBeat.i(190221);
    if (this.platformViews.get(paramInteger.intValue()) != null)
    {
      paramInteger = ((PlatformView)this.platformViews.get(paramInteger.intValue())).getView();
      AppMethodBeat.o(190221);
      return paramInteger;
    }
    paramInteger = (VirtualDisplayController)this.vdControllers.get(paramInteger);
    if (paramInteger == null)
    {
      AppMethodBeat.o(190221);
      return null;
    }
    paramInteger = paramInteger.getView();
    AppMethodBeat.o(190221);
    return paramInteger;
  }
  
  public PlatformViewRegistry getRegistry()
  {
    return this.registry;
  }
  
  void initializePlatformViewIfNeeded(int paramInt)
  {
    AppMethodBeat.i(190246);
    Object localObject = (PlatformView)this.platformViews.get(paramInt);
    if (localObject == null)
    {
      localObject = new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
      AppMethodBeat.o(190246);
      throw ((Throwable)localObject);
    }
    if (this.platformViewParent.get(paramInt) != null)
    {
      AppMethodBeat.o(190246);
      return;
    }
    if (((PlatformView)localObject).getView() == null)
    {
      localObject = new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
      AppMethodBeat.o(190246);
      throw ((Throwable)localObject);
    }
    if (((PlatformView)localObject).getView().getParent() != null)
    {
      localObject = new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
      AppMethodBeat.o(190246);
      throw ((Throwable)localObject);
    }
    FlutterMutatorView localFlutterMutatorView = new FlutterMutatorView(this.context, this.context.getResources().getDisplayMetrics().density, this.androidTouchProcessor);
    this.platformViewParent.put(paramInt, localFlutterMutatorView);
    localFlutterMutatorView.addView(((PlatformView)localObject).getView());
    ((FlutterView)this.flutterView).addView(localFlutterMutatorView);
    AppMethodBeat.o(190246);
  }
  
  public void onAttachedToJNI() {}
  
  public void onBeginFrame()
  {
    AppMethodBeat.i(190278);
    this.currentFrameUsedOverlayLayerIds.clear();
    this.currentFrameUsedPlatformViewIds.clear();
    AppMethodBeat.o(190278);
  }
  
  public void onDetachedFromJNI()
  {
    AppMethodBeat.i(190203);
    flushAllViews();
    AppMethodBeat.o(190203);
  }
  
  public void onDisplayOverlaySurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(190269);
    initializeRootImageViewIfNeeded();
    FlutterImageView localFlutterImageView = (FlutterImageView)this.overlayLayerViews.get(paramInt1);
    if (localFlutterImageView.getParent() == null) {
      ((FlutterView)this.flutterView).addView(localFlutterImageView);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt4, paramInt5);
    localLayoutParams.leftMargin = paramInt2;
    localLayoutParams.topMargin = paramInt3;
    localFlutterImageView.setLayoutParams(localLayoutParams);
    localFlutterImageView.setVisibility(0);
    localFlutterImageView.bringToFront();
    this.currentFrameUsedOverlayLayerIds.add(Integer.valueOf(paramInt1));
    AppMethodBeat.o(190269);
  }
  
  public void onDisplayPlatformView(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, FlutterMutatorsStack paramFlutterMutatorsStack)
  {
    AppMethodBeat.i(190260);
    initializeRootImageViewIfNeeded();
    initializePlatformViewIfNeeded(paramInt1);
    Object localObject = (FlutterMutatorView)this.platformViewParent.get(paramInt1);
    ((FlutterMutatorView)localObject).readyToDisplay(paramFlutterMutatorsStack, paramInt2, paramInt3, paramInt4, paramInt5);
    ((FlutterMutatorView)localObject).setVisibility(0);
    ((FlutterMutatorView)localObject).bringToFront();
    paramFlutterMutatorsStack = new FrameLayout.LayoutParams(paramInt6, paramInt7);
    localObject = ((PlatformView)this.platformViews.get(paramInt1)).getView();
    if (localObject != null)
    {
      ((View)localObject).setLayoutParams(paramFlutterMutatorsStack);
      ((View)localObject).bringToFront();
    }
    this.currentFrameUsedPlatformViewIds.add(Integer.valueOf(paramInt1));
    AppMethodBeat.o(190260);
  }
  
  public void onEndFrame()
  {
    AppMethodBeat.i(190283);
    FlutterView localFlutterView = (FlutterView)this.flutterView;
    if ((this.flutterViewConvertedToImageView) && (this.currentFrameUsedPlatformViewIds.isEmpty()))
    {
      this.flutterViewConvertedToImageView = false;
      localFlutterView.revertImageView(new CustomPlatformViewsController..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(190283);
      return;
    }
    if ((this.flutterViewConvertedToImageView) && (localFlutterView.acquireLatestImageViewFrame())) {}
    for (boolean bool = true;; bool = false)
    {
      finishFrame(bool);
      AppMethodBeat.o(190283);
      return;
    }
  }
  
  public void onPreEngineRestart()
  {
    AppMethodBeat.i(190214);
    flushAllViews();
    AppMethodBeat.o(190214);
  }
  
  public MotionEvent toMotionEvent(float paramFloat, PlatformViewsChannel.PlatformViewTouch paramPlatformViewTouch, boolean paramBoolean)
  {
    AppMethodBeat.i(190101);
    Object localObject = MotionEventTracker.MotionEventId.from(paramPlatformViewTouch.motionEventId);
    localObject = this.motionEventTracker.pop((MotionEventTracker.MotionEventId)localObject);
    MotionEvent.PointerProperties[] arrayOfPointerProperties = (MotionEvent.PointerProperties[])parsePointerPropertiesList(paramPlatformViewTouch.rawPointerPropertiesList).toArray(new MotionEvent.PointerProperties[paramPlatformViewTouch.pointerCount]);
    MotionEvent.PointerCoords[] arrayOfPointerCoords = (MotionEvent.PointerCoords[])parsePointerCoordsList(paramPlatformViewTouch.rawPointerCoords, paramFloat).toArray(new MotionEvent.PointerCoords[paramPlatformViewTouch.pointerCount]);
    if ((!paramBoolean) && (localObject != null))
    {
      paramPlatformViewTouch = MotionEvent.obtain(((MotionEvent)localObject).getDownTime(), ((MotionEvent)localObject).getEventTime(), ((MotionEvent)localObject).getAction(), paramPlatformViewTouch.pointerCount, arrayOfPointerProperties, arrayOfPointerCoords, ((MotionEvent)localObject).getMetaState(), ((MotionEvent)localObject).getButtonState(), ((MotionEvent)localObject).getXPrecision(), ((MotionEvent)localObject).getYPrecision(), ((MotionEvent)localObject).getDeviceId(), ((MotionEvent)localObject).getEdgeFlags(), ((MotionEvent)localObject).getSource(), ((MotionEvent)localObject).getFlags());
      AppMethodBeat.o(190101);
      return paramPlatformViewTouch;
    }
    paramPlatformViewTouch = MotionEvent.obtain(paramPlatformViewTouch.downTime.longValue(), paramPlatformViewTouch.eventTime.longValue(), paramPlatformViewTouch.action, paramPlatformViewTouch.pointerCount, arrayOfPointerProperties, arrayOfPointerCoords, paramPlatformViewTouch.metaState, paramPlatformViewTouch.buttonState, paramPlatformViewTouch.xPrecision, paramPlatformViewTouch.yPrecision, paramPlatformViewTouch.deviceId, paramPlatformViewTouch.edgeFlags, paramPlatformViewTouch.source, paramPlatformViewTouch.flags);
    AppMethodBeat.o(190101);
    return paramPlatformViewTouch;
  }
  
  protected int toPhysicalPixels(double paramDouble)
  {
    AppMethodBeat.i(190241);
    int i = (int)Math.round(getDisplayDensity() * paramDouble);
    AppMethodBeat.o(190241);
    return i;
  }
  
  public boolean usesVirtualDisplay(Integer paramInteger)
  {
    AppMethodBeat.i(190229);
    boolean bool = this.vdControllers.containsKey(paramInteger);
    AppMethodBeat.o(190229);
    return bool;
  }
  
  protected void validateVirtualDisplayDimensions(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190236);
    DisplayMetrics localDisplayMetrics = this.context.getResources().getDisplayMetrics();
    if ((paramInt2 > localDisplayMetrics.heightPixels) || (paramInt1 > localDisplayMetrics.widthPixels)) {
      Log.w("PlatformViewsController", "Creating a virtual display of size: [" + paramInt1 + ", " + paramInt2 + "] may result in problems(https://github.com/flutter/flutter/issues/2897).It is larger than the device screen size: [" + localDisplayMetrics.widthPixels + ", " + localDisplayMetrics.heightPixels + "].");
    }
    AppMethodBeat.o(190236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugin.platform.CustomPlatformViewsController
 * JD-Core Version:    0.7.0.1
 */