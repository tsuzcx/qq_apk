package io.flutter.embedding.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowInsets.Type;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterRenderer.ViewportMetrics;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.MessageBuilder;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin.MouseCursorViewDelegate;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.AccessibilityBridge.OnAccessibilityChangeListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlutterView
  extends FrameLayout
  implements MouseCursorPlugin.MouseCursorViewDelegate
{
  private static final String TAG = "FlutterView";
  private AccessibilityBridge accessibilityBridge;
  private AndroidKeyProcessor androidKeyProcessor;
  private AndroidTouchProcessor androidTouchProcessor;
  private FlutterEngine flutterEngine;
  private final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
  private FlutterImageView flutterImageView;
  private FlutterSurfaceView flutterSurfaceView;
  private FlutterTextureView flutterTextureView;
  private final FlutterUiDisplayListener flutterUiDisplayListener;
  private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
  private boolean isFlutterUiDisplayed;
  private LocalizationPlugin localizationPlugin;
  private MouseCursorPlugin mouseCursorPlugin;
  private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
  private RenderSurface previousRenderSurface;
  private RenderSurface renderSurface;
  private TextInputPlugin textInputPlugin;
  private final FlutterRenderer.ViewportMetrics viewportMetrics;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(190527);
    AppMethodBeat.o(190527);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(190576);
    AppMethodBeat.o(190576);
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterImageView paramFlutterImageView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(190611);
    this.flutterUiDisplayListeners = new HashSet();
    this.flutterEngineAttachmentListeners = new HashSet();
    this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
    this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener()
    {
      public void onAccessibilityChanged(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.access$000(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190493);
        FlutterView.access$102(FlutterView.this, true);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiDisplayed();
        }
        AppMethodBeat.o(190493);
      }
      
      public void onFlutterUiNoLongerDisplayed()
      {
        AppMethodBeat.i(190501);
        FlutterView.access$102(FlutterView.this, false);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiNoLongerDisplayed();
        }
        AppMethodBeat.o(190501);
      }
    };
    this.flutterImageView = paramFlutterImageView;
    this.renderSurface = paramFlutterImageView;
    init();
    AppMethodBeat.o(190611);
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterSurfaceView paramFlutterSurfaceView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(190594);
    this.flutterUiDisplayListeners = new HashSet();
    this.flutterEngineAttachmentListeners = new HashSet();
    this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
    this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener()
    {
      public void onAccessibilityChanged(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.access$000(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190493);
        FlutterView.access$102(FlutterView.this, true);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiDisplayed();
        }
        AppMethodBeat.o(190493);
      }
      
      public void onFlutterUiNoLongerDisplayed()
      {
        AppMethodBeat.i(190501);
        FlutterView.access$102(FlutterView.this, false);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiNoLongerDisplayed();
        }
        AppMethodBeat.o(190501);
      }
    };
    this.flutterSurfaceView = paramFlutterSurfaceView;
    this.renderSurface = paramFlutterSurfaceView;
    init();
    AppMethodBeat.o(190594);
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterTextureView paramFlutterTextureView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(190603);
    this.flutterUiDisplayListeners = new HashSet();
    this.flutterEngineAttachmentListeners = new HashSet();
    this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
    this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener()
    {
      public void onAccessibilityChanged(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.access$000(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190493);
        FlutterView.access$102(FlutterView.this, true);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiDisplayed();
        }
        AppMethodBeat.o(190493);
      }
      
      public void onFlutterUiNoLongerDisplayed()
      {
        AppMethodBeat.i(190501);
        FlutterView.access$102(FlutterView.this, false);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiNoLongerDisplayed();
        }
        AppMethodBeat.o(190501);
      }
    };
    this.flutterTextureView = paramFlutterTextureView;
    this.renderSurface = paramFlutterTextureView;
    init();
    AppMethodBeat.o(190603);
  }
  
  public FlutterView(Context paramContext, FlutterImageView paramFlutterImageView)
  {
    this(paramContext, null, paramFlutterImageView);
  }
  
  public FlutterView(Context paramContext, FlutterSurfaceView paramFlutterSurfaceView)
  {
    this(paramContext, null, paramFlutterSurfaceView);
  }
  
  public FlutterView(Context paramContext, FlutterTextureView paramFlutterTextureView)
  {
    this(paramContext, null, paramFlutterTextureView);
  }
  
  @Deprecated
  public FlutterView(Context paramContext, FlutterView.RenderMode paramRenderMode)
  {
    super(paramContext, null);
    AppMethodBeat.i(190536);
    this.flutterUiDisplayListeners = new HashSet();
    this.flutterEngineAttachmentListeners = new HashSet();
    this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
    this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener()
    {
      public void onAccessibilityChanged(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.access$000(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190493);
        FlutterView.access$102(FlutterView.this, true);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiDisplayed();
        }
        AppMethodBeat.o(190493);
      }
      
      public void onFlutterUiNoLongerDisplayed()
      {
        AppMethodBeat.i(190501);
        FlutterView.access$102(FlutterView.this, false);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiNoLongerDisplayed();
        }
        AppMethodBeat.o(190501);
      }
    };
    if (paramRenderMode == FlutterView.RenderMode.surface) {
      this.flutterSurfaceView = new FlutterSurfaceView(paramContext);
    }
    for (this.renderSurface = this.flutterSurfaceView;; this.renderSurface = this.flutterTextureView)
    {
      init();
      AppMethodBeat.o(190536);
      return;
      if (paramRenderMode != FlutterView.RenderMode.texture) {
        break;
      }
      this.flutterTextureView = new FlutterTextureView(paramContext);
    }
    paramContext = new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[] { paramRenderMode }));
    AppMethodBeat.o(190536);
    throw paramContext;
  }
  
  @Deprecated
  public FlutterView(Context paramContext, FlutterView.RenderMode paramRenderMode, TransparencyMode paramTransparencyMode)
  {
    super(paramContext, null);
    AppMethodBeat.i(190586);
    this.flutterUiDisplayListeners = new HashSet();
    this.flutterEngineAttachmentListeners = new HashSet();
    this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
    this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener()
    {
      public void onAccessibilityChanged(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.access$000(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.flutterUiDisplayListener = new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190493);
        FlutterView.access$102(FlutterView.this, true);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiDisplayed();
        }
        AppMethodBeat.o(190493);
      }
      
      public void onFlutterUiNoLongerDisplayed()
      {
        AppMethodBeat.i(190501);
        FlutterView.access$102(FlutterView.this, false);
        Iterator localIterator = FlutterView.this.flutterUiDisplayListeners.iterator();
        while (localIterator.hasNext()) {
          ((FlutterUiDisplayListener)localIterator.next()).onFlutterUiNoLongerDisplayed();
        }
        AppMethodBeat.o(190501);
      }
    };
    if (paramRenderMode == FlutterView.RenderMode.surface) {
      if (paramTransparencyMode == TransparencyMode.transparent) {
        this.flutterSurfaceView = new FlutterSurfaceView(paramContext, bool);
      }
    }
    for (this.renderSurface = this.flutterSurfaceView;; this.renderSurface = this.flutterTextureView)
    {
      init();
      AppMethodBeat.o(190586);
      return;
      bool = false;
      break;
      if (paramRenderMode != FlutterView.RenderMode.texture) {
        break label153;
      }
      this.flutterTextureView = new FlutterTextureView(paramContext);
    }
    label153:
    paramContext = new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[] { paramRenderMode }));
    AppMethodBeat.o(190586);
    throw paramContext;
  }
  
  @Deprecated
  public FlutterView(Context paramContext, TransparencyMode paramTransparencyMode) {}
  
  private ZeroSides calculateShouldZeroSides()
  {
    AppMethodBeat.i(190623);
    Object localObject = getContext();
    int i = ((Context)localObject).getResources().getConfiguration().orientation;
    int j = ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay().getRotation();
    if (i == 2)
    {
      if (j == 1)
      {
        localObject = ZeroSides.RIGHT;
        AppMethodBeat.o(190623);
        return localObject;
      }
      if (j == 3)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = ZeroSides.LEFT;
          AppMethodBeat.o(190623);
          return localObject;
        }
        localObject = ZeroSides.RIGHT;
        AppMethodBeat.o(190623);
        return localObject;
      }
      if ((j == 0) || (j == 2))
      {
        localObject = ZeroSides.BOTH;
        AppMethodBeat.o(190623);
        return localObject;
      }
    }
    localObject = ZeroSides.NONE;
    AppMethodBeat.o(190623);
    return localObject;
  }
  
  private int guessBottomKeyboardInset(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(190629);
    int i = getRootView().getHeight();
    if (paramWindowInsets.getSystemWindowInsetBottom() < i * 0.18D)
    {
      AppMethodBeat.o(190629);
      return 0;
    }
    i = paramWindowInsets.getSystemWindowInsetBottom();
    AppMethodBeat.o(190629);
    return i;
  }
  
  private void init()
  {
    AppMethodBeat.i(190618);
    Log.v("FlutterView", "Initializing FlutterView");
    if (this.flutterSurfaceView != null)
    {
      Log.v("FlutterView", "Internally using a FlutterSurfaceView.");
      addView(this.flutterSurfaceView);
    }
    for (;;)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      if (Build.VERSION.SDK_INT >= 26) {
        setImportantForAutofill(4);
      }
      AppMethodBeat.o(190618);
      return;
      if (this.flutterTextureView != null)
      {
        Log.v("FlutterView", "Internally using a FlutterTextureView.");
        addView(this.flutterTextureView);
      }
      else
      {
        Log.v("FlutterView", "Internally using a FlutterImageView.");
        addView(this.flutterImageView);
      }
    }
  }
  
  private void resetWillNotDraw(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10000);
    if (!this.flutterEngine.getRenderer().isSoftwareRenderingEnabled())
    {
      boolean bool1 = bool2;
      if (!paramBoolean1)
      {
        bool1 = bool2;
        if (!paramBoolean2) {
          bool1 = true;
        }
      }
      setWillNotDraw(bool1);
      AppMethodBeat.o(10000);
      return;
    }
    setWillNotDraw(false);
    AppMethodBeat.o(10000);
  }
  
  private void sendViewportMetricsToFlutter()
  {
    AppMethodBeat.i(10007);
    if (!isAttachedToFlutterEngine())
    {
      Log.w("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
      AppMethodBeat.o(10007);
      return;
    }
    this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
    this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
    AppMethodBeat.o(10007);
  }
  
  public boolean acquireLatestImageViewFrame()
  {
    AppMethodBeat.i(190767);
    if (this.flutterImageView != null)
    {
      boolean bool = this.flutterImageView.acquireLatestImage();
      AppMethodBeat.o(190767);
      return bool;
    }
    AppMethodBeat.o(190767);
    return false;
  }
  
  public void addFlutterEngineAttachmentListener(FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
  {
    AppMethodBeat.i(10004);
    this.flutterEngineAttachmentListeners.add(paramFlutterEngineAttachmentListener);
    AppMethodBeat.o(10004);
  }
  
  public void addOnFirstFrameRenderedListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    AppMethodBeat.i(190677);
    this.flutterUiDisplayListeners.add(paramFlutterUiDisplayListener);
    AppMethodBeat.o(190677);
  }
  
  public void attachOverlaySurfaceToRender(FlutterImageView paramFlutterImageView)
  {
    AppMethodBeat.i(190760);
    if (this.flutterEngine != null) {
      paramFlutterImageView.attachToRenderer(this.flutterEngine.getRenderer());
    }
    AppMethodBeat.o(190760);
  }
  
  public void attachToFlutterEngine(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(10001);
    Log.v("FlutterView", "Attaching to a FlutterEngine: ".concat(String.valueOf(paramFlutterEngine)));
    if (isAttachedToFlutterEngine())
    {
      if (paramFlutterEngine == this.flutterEngine)
      {
        Log.v("FlutterView", "Already attached to this engine. Doing nothing.");
        AppMethodBeat.o(10001);
        return;
      }
      Log.v("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
      detachFromFlutterEngine();
    }
    this.flutterEngine = paramFlutterEngine;
    Object localObject = this.flutterEngine.getRenderer();
    this.isFlutterUiDisplayed = ((FlutterRenderer)localObject).isDisplayingFlutterUi();
    this.renderSurface.attachToRenderer((FlutterRenderer)localObject);
    ((FlutterRenderer)localObject).addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    if (Build.VERSION.SDK_INT >= 24) {
      this.mouseCursorPlugin = new MouseCursorPlugin(this, this.flutterEngine.getMouseCursorChannel());
    }
    this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
    this.localizationPlugin = this.flutterEngine.getLocalizationPlugin();
    this.androidKeyProcessor = new AndroidKeyProcessor(this, this.flutterEngine.getKeyEventChannel(), this.textInputPlugin);
    this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer(), false);
    this.accessibilityBridge = new AccessibilityBridge(this, paramFlutterEngine.getAccessibilityChannel(), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
    this.accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
    resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
    this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
    this.flutterEngine.getPlatformViewsController().attachToFlutterRenderer(this.flutterEngine.getRenderer());
    this.textInputPlugin.getInputMethodManager().restartInput(this);
    sendUserSettingsToFlutter();
    this.localizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
    sendViewportMetricsToFlutter();
    paramFlutterEngine.getPlatformViewsController().attachToView(this);
    localObject = this.flutterEngineAttachmentListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FlutterEngineAttachmentListener)((Iterator)localObject).next()).onFlutterEngineAttachedToFlutterView(paramFlutterEngine);
    }
    if (this.isFlutterUiDisplayed) {
      this.flutterUiDisplayListener.onFlutterUiDisplayed();
    }
    AppMethodBeat.o(10001);
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(190816);
    this.textInputPlugin.autofill(paramSparseArray);
    AppMethodBeat.o(190816);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9993);
    if (this.flutterEngine != null)
    {
      bool = this.flutterEngine.getPlatformViewsController().checkInputConnectionProxy(paramView);
      AppMethodBeat.o(9993);
      return bool;
    }
    boolean bool = super.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9993);
    return bool;
  }
  
  public void convertToImageView()
  {
    AppMethodBeat.i(190747);
    this.renderSurface.pause();
    if (this.flutterImageView == null)
    {
      this.flutterImageView = createImageView();
      addView(this.flutterImageView);
    }
    for (;;)
    {
      this.previousRenderSurface = this.renderSurface;
      this.renderSurface = this.flutterImageView;
      if (this.flutterEngine != null) {
        this.renderSurface.attachToRenderer(this.flutterEngine.getRenderer());
      }
      AppMethodBeat.o(190747);
      return;
      this.flutterImageView.resizeIfNeeded(getWidth(), getHeight());
    }
  }
  
  public FlutterImageView createImageView()
  {
    AppMethodBeat.i(190740);
    FlutterImageView localFlutterImageView = new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    AppMethodBeat.o(190740);
    return localFlutterImageView;
  }
  
  public void detachFromFlutterEngine()
  {
    AppMethodBeat.i(10002);
    Log.v("FlutterView", "Detaching from a FlutterEngine: " + this.flutterEngine);
    if (!isAttachedToFlutterEngine())
    {
      Log.v("FlutterView", "FlutterView not attached to an engine. Not detaching.");
      AppMethodBeat.o(10002);
      return;
    }
    Object localObject = this.flutterEngineAttachmentListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((FlutterEngineAttachmentListener)((Iterator)localObject).next()).onFlutterEngineDetachedFromFlutterView();
    }
    this.flutterEngine.getPlatformViewsController().detachFromView();
    this.flutterEngine.getPlatformViewsController().detachAccessibiltyBridge();
    this.accessibilityBridge.release();
    this.accessibilityBridge = null;
    this.textInputPlugin.getInputMethodManager().restartInput(this);
    this.textInputPlugin.destroy();
    this.androidKeyProcessor.destroy();
    if (this.mouseCursorPlugin != null) {
      this.mouseCursorPlugin.destroy();
    }
    localObject = this.flutterEngine.getRenderer();
    this.isFlutterUiDisplayed = false;
    ((FlutterRenderer)localObject).removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    ((FlutterRenderer)localObject).stopRenderingToSurface();
    ((FlutterRenderer)localObject).setSemanticsEnabled(false);
    this.renderSurface.detachFromRenderer();
    this.flutterImageView = null;
    this.previousRenderSurface = null;
    this.flutterEngine = null;
    AppMethodBeat.o(10002);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(190717);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      getKeyDispatcherState().startTracking(paramKeyEvent, this);
    }
    while (((isAttachedToFlutterEngine()) && (this.androidKeyProcessor.onKeyEvent(paramKeyEvent))) || (super.dispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(190717);
      return true;
      if (paramKeyEvent.getAction() == 1) {
        getKeyDispatcherState().handleUpEvent(paramKeyEvent);
      }
    }
    AppMethodBeat.o(190717);
    return false;
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9991);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.viewportMetrics.viewPaddingTop = paramRect.top;
      this.viewportMetrics.viewPaddingRight = paramRect.right;
      this.viewportMetrics.viewPaddingBottom = 0;
      this.viewportMetrics.viewPaddingLeft = paramRect.left;
      this.viewportMetrics.viewInsetTop = 0;
      this.viewportMetrics.viewInsetRight = 0;
      this.viewportMetrics.viewInsetBottom = paramRect.bottom;
      this.viewportMetrics.viewInsetLeft = 0;
      Log.v("FlutterView", "Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight);
      sendViewportMetricsToFlutter();
      AppMethodBeat.o(9991);
      return true;
    }
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(9991);
    return bool;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    AppMethodBeat.i(9999);
    if ((this.accessibilityBridge != null) && (this.accessibilityBridge.isAccessibilityEnabled()))
    {
      AccessibilityBridge localAccessibilityBridge = this.accessibilityBridge;
      AppMethodBeat.o(9999);
      return localAccessibilityBridge;
    }
    AppMethodBeat.o(9999);
    return null;
  }
  
  public FlutterEngine getAttachedFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  public PointerIcon getSystemPointerIcon(int paramInt)
  {
    AppMethodBeat.i(190734);
    PointerIcon localPointerIcon = PointerIcon.getSystemIcon(getContext(), paramInt);
    AppMethodBeat.o(190734);
    return localPointerIcon;
  }
  
  public boolean hasRenderedFirstFrame()
  {
    return this.isFlutterUiDisplayed;
  }
  
  public boolean isAttachedToFlutterEngine()
  {
    AppMethodBeat.i(10003);
    if ((this.flutterEngine != null) && (this.flutterEngine.getRenderer() == this.renderSurface.getAttachedRenderer()))
    {
      AppMethodBeat.o(10003);
      return true;
    }
    AppMethodBeat.o(10003);
    return false;
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    int i = 1;
    AppMethodBeat.i(190699);
    WindowInsets localWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    Object localObject;
    if (Build.VERSION.SDK_INT == 29)
    {
      localObject = paramWindowInsets.getSystemGestureInsets();
      this.viewportMetrics.systemGestureInsetTop = ((Insets)localObject).top;
      this.viewportMetrics.systemGestureInsetRight = ((Insets)localObject).right;
      this.viewportMetrics.systemGestureInsetBottom = ((Insets)localObject).bottom;
      this.viewportMetrics.systemGestureInsetLeft = ((Insets)localObject).left;
    }
    int j;
    if ((getWindowSystemUiVisibility() & 0x4) == 0)
    {
      j = 1;
      if ((getWindowSystemUiVisibility() & 0x2) != 0) {
        break label615;
      }
      label97:
      if (Build.VERSION.SDK_INT < 30) {
        break label620;
      }
      if (i == 0) {
        break label813;
      }
    }
    label650:
    label680:
    label813:
    for (i = WindowInsets.Type.navigationBars() | 0x0;; i = 0)
    {
      if (j != 0) {
        i = WindowInsets.Type.statusBars() | i;
      }
      for (;;)
      {
        localObject = paramWindowInsets.getInsets(i);
        this.viewportMetrics.viewPaddingTop = ((Insets)localObject).top;
        this.viewportMetrics.viewPaddingRight = ((Insets)localObject).right;
        this.viewportMetrics.viewPaddingBottom = ((Insets)localObject).bottom;
        this.viewportMetrics.viewPaddingLeft = ((Insets)localObject).left;
        localObject = paramWindowInsets.getInsets(WindowInsets.Type.ime());
        this.viewportMetrics.viewInsetTop = ((Insets)localObject).top;
        this.viewportMetrics.viewInsetRight = ((Insets)localObject).right;
        this.viewportMetrics.viewInsetBottom = ((Insets)localObject).bottom;
        this.viewportMetrics.viewInsetLeft = ((Insets)localObject).left;
        localObject = paramWindowInsets.getInsets(WindowInsets.Type.systemGestures());
        this.viewportMetrics.systemGestureInsetTop = ((Insets)localObject).top;
        this.viewportMetrics.systemGestureInsetRight = ((Insets)localObject).right;
        this.viewportMetrics.systemGestureInsetBottom = ((Insets)localObject).bottom;
        this.viewportMetrics.systemGestureInsetLeft = ((Insets)localObject).left;
        paramWindowInsets = paramWindowInsets.getDisplayCutout();
        if (paramWindowInsets != null)
        {
          localObject = paramWindowInsets.getWaterfallInsets();
          this.viewportMetrics.viewPaddingTop = Math.max(Math.max(this.viewportMetrics.viewPaddingTop, ((Insets)localObject).top), paramWindowInsets.getSafeInsetTop());
          this.viewportMetrics.viewPaddingRight = Math.max(Math.max(this.viewportMetrics.viewPaddingRight, ((Insets)localObject).right), paramWindowInsets.getSafeInsetRight());
          this.viewportMetrics.viewPaddingBottom = Math.max(Math.max(this.viewportMetrics.viewPaddingBottom, ((Insets)localObject).bottom), paramWindowInsets.getSafeInsetBottom());
          this.viewportMetrics.viewPaddingLeft = Math.max(Math.max(this.viewportMetrics.viewPaddingLeft, ((Insets)localObject).left), paramWindowInsets.getSafeInsetLeft());
        }
        Log.v("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
        sendViewportMetricsToFlutter();
        AppMethodBeat.o(190699);
        return localWindowInsets;
        j = 0;
        break;
        label615:
        i = 0;
        break label97;
        label620:
        localObject = ZeroSides.NONE;
        if (i == 0) {
          localObject = calculateShouldZeroSides();
        }
        FlutterRenderer.ViewportMetrics localViewportMetrics = this.viewportMetrics;
        if (j != 0)
        {
          j = paramWindowInsets.getSystemWindowInsetTop();
          localViewportMetrics.viewPaddingTop = j;
          localViewportMetrics = this.viewportMetrics;
          if ((localObject != ZeroSides.RIGHT) && (localObject != ZeroSides.BOTH)) {
            break label789;
          }
          j = 0;
          localViewportMetrics.viewPaddingRight = j;
          localViewportMetrics = this.viewportMetrics;
          if ((i == 0) || (guessBottomKeyboardInset(paramWindowInsets) != 0)) {
            break label797;
          }
          i = paramWindowInsets.getSystemWindowInsetBottom();
          label709:
          localViewportMetrics.viewPaddingBottom = i;
          localViewportMetrics = this.viewportMetrics;
          if ((localObject != ZeroSides.LEFT) && (localObject != ZeroSides.BOTH)) {
            break label802;
          }
        }
        for (i = 0;; i = paramWindowInsets.getSystemWindowInsetLeft())
        {
          localViewportMetrics.viewPaddingLeft = i;
          this.viewportMetrics.viewInsetTop = 0;
          this.viewportMetrics.viewInsetRight = 0;
          this.viewportMetrics.viewInsetBottom = guessBottomKeyboardInset(paramWindowInsets);
          this.viewportMetrics.viewInsetLeft = 0;
          break;
          j = 0;
          break label650;
          j = paramWindowInsets.getSystemWindowInsetRight();
          break label680;
          i = 0;
          break label709;
        }
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9989);
    super.onConfigurationChanged(paramConfiguration);
    if (this.flutterEngine != null)
    {
      Log.v("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
      this.localizationPlugin.sendLocalesToFlutter(paramConfiguration);
      sendUserSettingsToFlutter();
    }
    AppMethodBeat.o(9989);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9992);
    if (!isAttachedToFlutterEngine())
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      AppMethodBeat.o(9992);
      return paramEditorInfo;
    }
    paramEditorInfo = this.textInputPlugin.createInputConnection(this, paramEditorInfo);
    AppMethodBeat.o(9992);
    return paramEditorInfo;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9997);
    if ((isAttachedToFlutterEngine()) && (this.androidTouchProcessor.onGenericMotionEvent(paramMotionEvent))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(9997);
      return true;
    }
    boolean bool = super.onGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(9997);
    return bool;
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9998);
    if (!isAttachedToFlutterEngine())
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(9998);
      return bool;
    }
    boolean bool = this.accessibilityBridge.onAccessibilityHoverEvent(paramMotionEvent);
    AppMethodBeat.o(9998);
    return bool;
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(190809);
    super.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    this.textInputPlugin.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    AppMethodBeat.o(190809);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9990);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.v("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + paramInt3 + " x " + paramInt4 + ", it is now " + paramInt1 + " x " + paramInt2);
    this.viewportMetrics.width = paramInt1;
    this.viewportMetrics.height = paramInt2;
    sendViewportMetricsToFlutter();
    AppMethodBeat.o(9990);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9996);
    if (!isAttachedToFlutterEngine())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(9996);
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    boolean bool = this.androidTouchProcessor.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9996);
    return bool;
  }
  
  public void removeFlutterEngineAttachmentListener(FlutterEngineAttachmentListener paramFlutterEngineAttachmentListener)
  {
    AppMethodBeat.i(190793);
    this.flutterEngineAttachmentListeners.remove(paramFlutterEngineAttachmentListener);
    AppMethodBeat.o(190793);
  }
  
  public void removeOnFirstFrameRenderedListener(FlutterUiDisplayListener paramFlutterUiDisplayListener)
  {
    AppMethodBeat.i(190683);
    this.flutterUiDisplayListeners.remove(paramFlutterUiDisplayListener);
    AppMethodBeat.o(190683);
  }
  
  public void revertImageView(final Runnable paramRunnable)
  {
    AppMethodBeat.i(190754);
    if (this.flutterImageView == null)
    {
      Log.v("FlutterView", "Tried to revert the image view, but no image view is used.");
      AppMethodBeat.o(190754);
      return;
    }
    if (this.previousRenderSurface == null)
    {
      Log.v("FlutterView", "Tried to revert the image view, but no previous surface was used.");
      AppMethodBeat.o(190754);
      return;
    }
    this.renderSurface = this.previousRenderSurface;
    this.previousRenderSurface = null;
    if (this.flutterEngine == null)
    {
      this.flutterImageView.detachFromRenderer();
      paramRunnable.run();
      AppMethodBeat.o(190754);
      return;
    }
    final FlutterRenderer localFlutterRenderer = this.flutterEngine.getRenderer();
    if (localFlutterRenderer == null)
    {
      this.flutterImageView.detachFromRenderer();
      paramRunnable.run();
      AppMethodBeat.o(190754);
      return;
    }
    this.renderSurface.attachToRenderer(localFlutterRenderer);
    localFlutterRenderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener()
    {
      public void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(190502);
        localFlutterRenderer.removeIsDisplayingFlutterUiListener(this);
        paramRunnable.run();
        FlutterView.this.flutterImageView.detachFromRenderer();
        AppMethodBeat.o(190502);
      }
      
      public void onFlutterUiNoLongerDisplayed() {}
    });
    AppMethodBeat.o(190754);
  }
  
  void sendUserSettingsToFlutter()
  {
    AppMethodBeat.i(10006);
    int i;
    if ((getResources().getConfiguration().uiMode & 0x30) == 32)
    {
      i = 1;
      if (i == 0) {
        break label86;
      }
    }
    label86:
    for (SettingsChannel.PlatformBrightness localPlatformBrightness = SettingsChannel.PlatformBrightness.dark;; localPlatformBrightness = SettingsChannel.PlatformBrightness.light)
    {
      this.flutterEngine.getSettingsChannel().startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(localPlatformBrightness).send();
      AppMethodBeat.o(10006);
      return;
      i = 0;
      break;
    }
  }
  
  public static abstract interface FlutterEngineAttachmentListener
  {
    public abstract void onFlutterEngineAttachedToFlutterView(FlutterEngine paramFlutterEngine);
    
    public abstract void onFlutterEngineDetachedFromFlutterView();
  }
  
  @Deprecated
  public static enum TransparencyMode
  {
    static
    {
      AppMethodBeat.i(9962);
      opaque = new TransparencyMode("opaque", 0);
      transparent = new TransparencyMode("transparent", 1);
      $VALUES = new TransparencyMode[] { opaque, transparent };
      AppMethodBeat.o(9962);
    }
    
    private TransparencyMode() {}
  }
  
  static enum ZeroSides
  {
    static
    {
      AppMethodBeat.i(190348);
      NONE = new ZeroSides("NONE", 0);
      LEFT = new ZeroSides("LEFT", 1);
      RIGHT = new ZeroSides("RIGHT", 2);
      BOTH = new ZeroSides("BOTH", 3);
      $VALUES = new ZeroSides[] { NONE, LEFT, RIGHT, BOTH };
      AppMethodBeat.o(190348);
    }
    
    private ZeroSides() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView
 * JD-Core Version:    0.7.0.1
 */