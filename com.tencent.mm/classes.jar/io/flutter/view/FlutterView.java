package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
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
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.android.AndroidKeyProcessor;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.MessageBuilder;
import io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler;
import io.flutter.plugin.common.BinaryMessenger.BinaryReply;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin.MouseCursorViewDelegate;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Deprecated
public class FlutterView
  extends SurfaceView
  implements BinaryMessenger, MouseCursorPlugin.MouseCursorViewDelegate, TextureRegistry
{
  private static final String TAG = "FlutterView";
  private final AndroidKeyProcessor androidKeyProcessor;
  private final AndroidTouchProcessor androidTouchProcessor;
  private final DartExecutor dartExecutor;
  private boolean didRenderFirstFrame;
  private final FlutterRenderer flutterRenderer;
  private final KeyEventChannel keyEventChannel;
  private final LifecycleChannel lifecycleChannel;
  private final LocalizationChannel localizationChannel;
  private AccessibilityBridge mAccessibilityNodeProvider;
  private final List<ActivityLifecycleListener> mActivityLifecycleListeners;
  private final List<FirstFrameListener> mFirstFrameListeners;
  private final InputMethodManager mImm;
  private boolean mIsSoftwareRenderingEnabled;
  private final LocalizationPlugin mLocalizationPlugin;
  private final ViewportMetrics mMetrics;
  private final MouseCursorPlugin mMouseCursorPlugin;
  private FlutterNativeView mNativeView;
  private final SurfaceHolder.Callback mSurfaceCallback;
  private final TextInputPlugin mTextInputPlugin;
  private final NavigationChannel navigationChannel;
  private final AtomicLong nextTextureId;
  private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
  private final PlatformChannel platformChannel;
  private final SettingsChannel settingsChannel;
  private final SystemChannel systemChannel;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9698);
    this.nextTextureId = new AtomicLong(0L);
    this.mIsSoftwareRenderingEnabled = false;
    this.didRenderFirstFrame = false;
    this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener()
    {
      public void onAccessibilityChanged(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(9829);
        FlutterView.access$000(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(9829);
      }
    };
    paramAttributeSet = getActivity(getContext());
    if (paramAttributeSet == null)
    {
      paramContext = new IllegalArgumentException("Bad context");
      AppMethodBeat.o(9698);
      throw paramContext;
    }
    if (paramFlutterNativeView == null)
    {
      this.mNativeView = new FlutterNativeView(paramAttributeSet.getApplicationContext());
      this.dartExecutor = this.mNativeView.getDartExecutor();
      this.flutterRenderer = new FlutterRenderer(this.mNativeView.getFlutterJNI());
      this.mIsSoftwareRenderingEnabled = this.mNativeView.getFlutterJNI().getIsSoftwareRenderingEnabled();
      this.mMetrics = new ViewportMetrics();
      this.mMetrics.devicePixelRatio = paramContext.getResources().getDisplayMetrics().density;
      setFocusable(true);
      setFocusableInTouchMode(true);
      this.mNativeView.attachViewAndActivity(this, paramAttributeSet);
      this.mSurfaceCallback = new SurfaceHolder.Callback()
      {
        public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(9800);
          FlutterView.this.assertAttached();
          FlutterView.this.mNativeView.getFlutterJNI().onSurfaceChanged(paramAnonymousInt2, paramAnonymousInt3);
          AppMethodBeat.o(9800);
        }
        
        public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(9799);
          FlutterView.this.assertAttached();
          FlutterView.this.mNativeView.getFlutterJNI().onSurfaceCreated(paramAnonymousSurfaceHolder.getSurface());
          AppMethodBeat.o(9799);
        }
        
        public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(9801);
          FlutterView.this.assertAttached();
          FlutterView.this.mNativeView.getFlutterJNI().onSurfaceDestroyed();
          AppMethodBeat.o(9801);
        }
      };
      getHolder().addCallback(this.mSurfaceCallback);
      this.mActivityLifecycleListeners = new ArrayList();
      this.mFirstFrameListeners = new ArrayList();
      this.navigationChannel = new NavigationChannel(this.dartExecutor);
      this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
      this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
      this.localizationChannel = new LocalizationChannel(this.dartExecutor);
      this.platformChannel = new PlatformChannel(this.dartExecutor);
      this.systemChannel = new SystemChannel(this.dartExecutor);
      this.settingsChannel = new SettingsChannel(this.dartExecutor);
      addActivityLifecycleListener(new ActivityLifecycleListener()
      {
        public void onPostResume()
        {
          AppMethodBeat.i(9680);
          this.val$platformPlugin.updateSystemUiOverlays();
          AppMethodBeat.o(9680);
        }
      });
      this.mImm = ((InputMethodManager)getContext().getSystemService("input_method"));
      paramAttributeSet = this.mNativeView.getPluginRegistry().getPlatformViewsController();
      this.mTextInputPlugin = new TextInputPlugin(this, new TextInputChannel(this.dartExecutor), paramAttributeSet);
      if (Build.VERSION.SDK_INT < 24) {
        break label568;
      }
    }
    label568:
    for (this.mMouseCursorPlugin = new MouseCursorPlugin(this, new MouseCursorChannel(this.dartExecutor));; this.mMouseCursorPlugin = null)
    {
      this.mLocalizationPlugin = new LocalizationPlugin(paramContext, this.localizationChannel);
      this.androidKeyProcessor = new AndroidKeyProcessor(this, this.keyEventChannel, this.mTextInputPlugin);
      this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterRenderer, false);
      paramAttributeSet.attachToFlutterRenderer(this.flutterRenderer);
      this.mNativeView.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(this.mTextInputPlugin);
      this.mNativeView.getFlutterJNI().setLocalizationPlugin(this.mLocalizationPlugin);
      this.mLocalizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
      sendUserPlatformSettingsToDart();
      AppMethodBeat.o(9698);
      return;
      this.mNativeView = paramFlutterNativeView;
      break;
    }
  }
  
  private ZeroSides calculateShouldZeroSides()
  {
    AppMethodBeat.i(190612);
    Object localObject = getContext();
    int i = ((Context)localObject).getResources().getConfiguration().orientation;
    int j = ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay().getRotation();
    if (i == 2)
    {
      if (j == 1)
      {
        localObject = ZeroSides.RIGHT;
        AppMethodBeat.o(190612);
        return localObject;
      }
      if (j == 3)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = ZeroSides.LEFT;
          AppMethodBeat.o(190612);
          return localObject;
        }
        localObject = ZeroSides.RIGHT;
        AppMethodBeat.o(190612);
        return localObject;
      }
      if ((j == 0) || (j == 2))
      {
        localObject = ZeroSides.BOTH;
        AppMethodBeat.o(190612);
        return localObject;
      }
    }
    localObject = ZeroSides.NONE;
    AppMethodBeat.o(190612);
    return localObject;
  }
  
  private static Activity getActivity(Context paramContext)
  {
    AppMethodBeat.i(9699);
    for (;;)
    {
      if (paramContext == null)
      {
        AppMethodBeat.o(9699);
        return null;
      }
      if ((paramContext instanceof Activity))
      {
        paramContext = (Activity)paramContext;
        AppMethodBeat.o(9699);
        return paramContext;
      }
      if (!(paramContext instanceof ContextWrapper)) {
        break;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    AppMethodBeat.o(9699);
    return null;
  }
  
  private int guessBottomKeyboardInset(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(190619);
    int i = getRootView().getHeight();
    if (paramWindowInsets.getSystemWindowInsetBottom() < i * 0.18D)
    {
      AppMethodBeat.o(190619);
      return 0;
    }
    i = paramWindowInsets.getSystemWindowInsetBottom();
    AppMethodBeat.o(190619);
    return i;
  }
  
  private boolean isAttached()
  {
    AppMethodBeat.i(9715);
    if ((this.mNativeView != null) && (this.mNativeView.isAttached()))
    {
      AppMethodBeat.o(9715);
      return true;
    }
    AppMethodBeat.o(9715);
    return false;
  }
  
  private void postRun() {}
  
  private void preRun()
  {
    AppMethodBeat.i(190630);
    resetAccessibilityTree();
    AppMethodBeat.o(190630);
  }
  
  private void releaseAccessibilityNodeProvider()
  {
    AppMethodBeat.i(190655);
    if (this.mAccessibilityNodeProvider != null)
    {
      this.mAccessibilityNodeProvider.release();
      this.mAccessibilityNodeProvider = null;
    }
    AppMethodBeat.o(190655);
  }
  
  private void resetWillNotDraw(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9724);
    if (!this.mIsSoftwareRenderingEnabled)
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
      AppMethodBeat.o(9724);
      return;
    }
    setWillNotDraw(false);
    AppMethodBeat.o(9724);
  }
  
  private void sendUserPlatformSettingsToDart()
  {
    AppMethodBeat.i(9704);
    int i;
    if ((getResources().getConfiguration().uiMode & 0x30) == 32)
    {
      i = 1;
      if (i == 0) {
        break label83;
      }
    }
    label83:
    for (SettingsChannel.PlatformBrightness localPlatformBrightness = SettingsChannel.PlatformBrightness.dark;; localPlatformBrightness = SettingsChannel.PlatformBrightness.light)
    {
      this.settingsChannel.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(localPlatformBrightness).send();
      AppMethodBeat.o(9704);
      return;
      i = 0;
      break;
    }
  }
  
  private void updateViewportMetrics()
  {
    AppMethodBeat.i(9720);
    if (!isAttached())
    {
      AppMethodBeat.o(9720);
      return;
    }
    this.mNativeView.getFlutterJNI().setViewportMetrics(this.mMetrics.devicePixelRatio, this.mMetrics.physicalWidth, this.mMetrics.physicalHeight, this.mMetrics.physicalViewPaddingTop, this.mMetrics.physicalViewPaddingRight, this.mMetrics.physicalViewPaddingBottom, this.mMetrics.physicalViewPaddingLeft, this.mMetrics.physicalViewInsetTop, this.mMetrics.physicalViewInsetRight, this.mMetrics.physicalViewInsetBottom, this.mMetrics.physicalViewInsetLeft, this.mMetrics.systemGestureInsetTop, this.mMetrics.systemGestureInsetRight, this.mMetrics.systemGestureInsetBottom, this.mMetrics.systemGestureInsetLeft);
    AppMethodBeat.o(9720);
  }
  
  public void addActivityLifecycleListener(ActivityLifecycleListener paramActivityLifecycleListener)
  {
    AppMethodBeat.i(190702);
    this.mActivityLifecycleListeners.add(paramActivityLifecycleListener);
    AppMethodBeat.o(190702);
  }
  
  public void addFirstFrameListener(FirstFrameListener paramFirstFrameListener)
  {
    AppMethodBeat.i(190729);
    this.mFirstFrameListeners.add(paramFirstFrameListener);
    AppMethodBeat.o(190729);
  }
  
  void assertAttached()
  {
    AppMethodBeat.i(9716);
    if (!isAttached())
    {
      AssertionError localAssertionError = new AssertionError("Platform view is not attached");
      AppMethodBeat.o(9716);
      throw localAssertionError;
    }
    AppMethodBeat.o(9716);
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(190803);
    this.mTextInputPlugin.autofill(paramSparseArray);
    AppMethodBeat.o(190803);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9709);
    boolean bool = this.mNativeView.getPluginRegistry().getPlatformViewsController().checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9709);
    return bool;
  }
  
  public TextureRegistry.SurfaceTextureEntry createSurfaceTexture()
  {
    AppMethodBeat.i(9729);
    Object localObject = new SurfaceTexture(0);
    ((SurfaceTexture)localObject).detachFromGLContext();
    localObject = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), (SurfaceTexture)localObject);
    this.mNativeView.getFlutterJNI().registerTexture(((SurfaceTextureRegistryEntry)localObject).id(), ((SurfaceTextureRegistryEntry)localObject).textureWrapper());
    AppMethodBeat.o(9729);
    return localObject;
  }
  
  public void destroy()
  {
    AppMethodBeat.i(9707);
    if (!isAttached())
    {
      AppMethodBeat.o(9707);
      return;
    }
    getHolder().removeCallback(this.mSurfaceCallback);
    releaseAccessibilityNodeProvider();
    this.mNativeView.destroy();
    this.mNativeView = null;
    AppMethodBeat.o(9707);
  }
  
  public FlutterNativeView detach()
  {
    AppMethodBeat.i(190768);
    if (!isAttached())
    {
      AppMethodBeat.o(190768);
      return null;
    }
    getHolder().removeCallback(this.mSurfaceCallback);
    this.mNativeView.detachFromFlutterView();
    FlutterNativeView localFlutterNativeView = this.mNativeView;
    this.mNativeView = null;
    AppMethodBeat.o(190768);
    return localFlutterNativeView;
  }
  
  public void disableTransparentBackground()
  {
    AppMethodBeat.i(190736);
    setZOrderOnTop(false);
    getHolder().setFormat(-1);
    AppMethodBeat.o(190736);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(190678);
    Log.e("FlutterView", "dispatchKeyEvent: " + paramKeyEvent.toString());
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      getKeyDispatcherState().startTracking(paramKeyEvent, this);
    }
    while (((isAttached()) && (this.androidKeyProcessor.onKeyEvent(paramKeyEvent))) || (super.dispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(190678);
      return true;
      if (paramKeyEvent.getAction() == 1) {
        getKeyDispatcherState().handleUpEvent(paramKeyEvent);
      }
    }
    AppMethodBeat.o(190678);
    return false;
  }
  
  @Deprecated
  public void enableTransparentBackground()
  {
    AppMethodBeat.i(190735);
    Log.w("FlutterView", "FlutterView in the v1 embedding is always a SurfaceView and will cover accessibility highlights when transparent. Consider migrating to the v2 Android embedding. https://github.com/flutter/flutter/wiki/Upgrading-pre-1.12-Android-projects");
    setZOrderOnTop(true);
    getHolder().setFormat(-2);
    AppMethodBeat.o(190735);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9714);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.mMetrics.physicalViewPaddingTop = paramRect.top;
      this.mMetrics.physicalViewPaddingRight = paramRect.right;
      this.mMetrics.physicalViewPaddingBottom = 0;
      this.mMetrics.physicalViewPaddingLeft = paramRect.left;
      this.mMetrics.physicalViewInsetTop = 0;
      this.mMetrics.physicalViewInsetRight = 0;
      this.mMetrics.physicalViewInsetBottom = paramRect.bottom;
      this.mMetrics.physicalViewInsetLeft = 0;
      updateViewportMetrics();
      AppMethodBeat.o(9714);
      return true;
    }
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(9714);
    return bool;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    AppMethodBeat.i(9725);
    if ((this.mAccessibilityNodeProvider != null) && (this.mAccessibilityNodeProvider.isAccessibilityEnabled()))
    {
      AccessibilityBridge localAccessibilityBridge = this.mAccessibilityNodeProvider;
      AppMethodBeat.o(9725);
      return localAccessibilityBridge;
    }
    AppMethodBeat.o(9725);
    return null;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(9719);
    assertAttached();
    Bitmap localBitmap = this.mNativeView.getFlutterJNI().getBitmap();
    AppMethodBeat.o(9719);
    return localBitmap;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.dartExecutor;
  }
  
  float getDevicePixelRatio()
  {
    return this.mMetrics.devicePixelRatio;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.mNativeView;
  }
  
  public String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(190691);
    paramString = FlutterMain.getLookupKeyForAsset(paramString);
    AppMethodBeat.o(190691);
    return paramString;
  }
  
  public String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190696);
    paramString1 = FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
    AppMethodBeat.o(190696);
    return paramString1;
  }
  
  public FlutterPluginRegistry getPluginRegistry()
  {
    AppMethodBeat.i(190687);
    FlutterPluginRegistry localFlutterPluginRegistry = this.mNativeView.getPluginRegistry();
    AppMethodBeat.o(190687);
    return localFlutterPluginRegistry;
  }
  
  public PointerIcon getSystemPointerIcon(int paramInt)
  {
    AppMethodBeat.i(190892);
    PointerIcon localPointerIcon = PointerIcon.getSystemIcon(getContext(), paramInt);
    AppMethodBeat.o(190892);
    return localPointerIcon;
  }
  
  public boolean hasRenderedFirstFrame()
  {
    return this.didRenderFirstFrame;
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    int i = 1;
    AppMethodBeat.i(190839);
    Object localObject1;
    if (Build.VERSION.SDK_INT == 29)
    {
      localObject1 = paramWindowInsets.getSystemGestureInsets();
      this.mMetrics.systemGestureInsetTop = ((Insets)localObject1).top;
      this.mMetrics.systemGestureInsetRight = ((Insets)localObject1).right;
      this.mMetrics.systemGestureInsetBottom = ((Insets)localObject1).bottom;
      this.mMetrics.systemGestureInsetLeft = ((Insets)localObject1).left;
    }
    int j;
    if ((getWindowSystemUiVisibility() & 0x4) == 0)
    {
      j = 1;
      if ((getWindowSystemUiVisibility() & 0x2) != 0) {
        break label448;
      }
      label90:
      if (Build.VERSION.SDK_INT < 30) {
        break label453;
      }
      if (i == 0) {
        break label646;
      }
    }
    label513:
    label646:
    for (i = WindowInsets.Type.navigationBars() | 0x0;; i = 0)
    {
      if (j != 0) {
        i = WindowInsets.Type.statusBars() | i;
      }
      for (;;)
      {
        localObject1 = paramWindowInsets.getInsets(i);
        this.mMetrics.physicalViewPaddingTop = ((Insets)localObject1).top;
        this.mMetrics.physicalViewPaddingRight = ((Insets)localObject1).right;
        this.mMetrics.physicalViewPaddingBottom = ((Insets)localObject1).bottom;
        this.mMetrics.physicalViewPaddingLeft = ((Insets)localObject1).left;
        localObject1 = paramWindowInsets.getInsets(WindowInsets.Type.ime());
        this.mMetrics.physicalViewInsetTop = ((Insets)localObject1).top;
        this.mMetrics.physicalViewInsetRight = ((Insets)localObject1).right;
        this.mMetrics.physicalViewInsetBottom = ((Insets)localObject1).bottom;
        this.mMetrics.physicalViewInsetLeft = ((Insets)localObject1).left;
        localObject1 = paramWindowInsets.getInsets(WindowInsets.Type.systemGestures());
        this.mMetrics.systemGestureInsetTop = ((Insets)localObject1).top;
        this.mMetrics.systemGestureInsetRight = ((Insets)localObject1).right;
        this.mMetrics.systemGestureInsetBottom = ((Insets)localObject1).bottom;
        this.mMetrics.systemGestureInsetLeft = ((Insets)localObject1).left;
        localObject1 = paramWindowInsets.getDisplayCutout();
        if (localObject1 != null)
        {
          localObject2 = ((DisplayCutout)localObject1).getWaterfallInsets();
          this.mMetrics.physicalViewPaddingTop = Math.max(Math.max(this.mMetrics.physicalViewPaddingTop, ((Insets)localObject2).top), ((DisplayCutout)localObject1).getSafeInsetTop());
          this.mMetrics.physicalViewPaddingRight = Math.max(Math.max(this.mMetrics.physicalViewPaddingRight, ((Insets)localObject2).right), ((DisplayCutout)localObject1).getSafeInsetRight());
          this.mMetrics.physicalViewPaddingBottom = Math.max(Math.max(this.mMetrics.physicalViewPaddingBottom, ((Insets)localObject2).bottom), ((DisplayCutout)localObject1).getSafeInsetBottom());
          this.mMetrics.physicalViewPaddingLeft = Math.max(Math.max(this.mMetrics.physicalViewPaddingLeft, ((Insets)localObject2).left), ((DisplayCutout)localObject1).getSafeInsetLeft());
        }
        updateViewportMetrics();
        paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
        AppMethodBeat.o(190839);
        return paramWindowInsets;
        j = 0;
        break;
        label448:
        i = 0;
        break label90;
        label453:
        localObject1 = ZeroSides.NONE;
        if (i == 0) {
          localObject1 = calculateShouldZeroSides();
        }
        Object localObject2 = this.mMetrics;
        if (j != 0)
        {
          j = paramWindowInsets.getSystemWindowInsetTop();
          label483:
          ((ViewportMetrics)localObject2).physicalViewPaddingTop = j;
          localObject2 = this.mMetrics;
          if ((localObject1 != ZeroSides.RIGHT) && (localObject1 != ZeroSides.BOTH)) {
            break label622;
          }
          j = 0;
          ((ViewportMetrics)localObject2).physicalViewPaddingRight = j;
          localObject2 = this.mMetrics;
          if ((i == 0) || (guessBottomKeyboardInset(paramWindowInsets) != 0)) {
            break label630;
          }
          i = paramWindowInsets.getSystemWindowInsetBottom();
          label542:
          ((ViewportMetrics)localObject2).physicalViewPaddingBottom = i;
          localObject2 = this.mMetrics;
          if ((localObject1 != ZeroSides.LEFT) && (localObject1 != ZeroSides.BOTH)) {
            break label635;
          }
        }
        label622:
        label630:
        label635:
        for (i = 0;; i = paramWindowInsets.getSystemWindowInsetLeft())
        {
          ((ViewportMetrics)localObject2).physicalViewPaddingLeft = i;
          this.mMetrics.physicalViewInsetTop = 0;
          this.mMetrics.physicalViewInsetRight = 0;
          this.mMetrics.physicalViewInsetBottom = guessBottomKeyboardInset(paramWindowInsets);
          this.mMetrics.physicalViewInsetLeft = 0;
          break;
          j = 0;
          break label483;
          j = paramWindowInsets.getSystemWindowInsetRight();
          break label513;
          i = 0;
          break label542;
        }
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(9722);
    super.onAttachedToWindow();
    PlatformViewsController localPlatformViewsController = getPluginRegistry().getPlatformViewsController();
    this.mAccessibilityNodeProvider = new AccessibilityBridge(this, new AccessibilityChannel(this.dartExecutor, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), localPlatformViewsController);
    this.mAccessibilityNodeProvider.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
    resetWillNotDraw(this.mAccessibilityNodeProvider.isAccessibilityEnabled(), this.mAccessibilityNodeProvider.isTouchExplorationEnabled());
    AppMethodBeat.o(9722);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9706);
    super.onConfigurationChanged(paramConfiguration);
    this.mLocalizationPlugin.sendLocalesToFlutter(paramConfiguration);
    sendUserPlatformSettingsToDart();
    AppMethodBeat.o(9706);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9708);
    paramEditorInfo = this.mTextInputPlugin.createInputConnection(this, paramEditorInfo);
    AppMethodBeat.o(9708);
    return paramEditorInfo;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(9723);
    super.onDetachedFromWindow();
    releaseAccessibilityNodeProvider();
    AppMethodBeat.o(9723);
  }
  
  public void onFirstFrame()
  {
    AppMethodBeat.i(9721);
    this.didRenderFirstFrame = true;
    Iterator localIterator = new ArrayList(this.mFirstFrameListeners).iterator();
    while (localIterator.hasNext()) {
      ((FirstFrameListener)localIterator.next()).onFirstFrame();
    }
    AppMethodBeat.o(9721);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9712);
    if ((isAttached()) && (this.androidTouchProcessor.onGenericMotionEvent(paramMotionEvent))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(9712);
      return true;
    }
    boolean bool = super.onGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(9712);
    return bool;
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9711);
    if (!isAttached())
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(9711);
      return bool;
    }
    boolean bool = this.mAccessibilityNodeProvider.onAccessibilityHoverEvent(paramMotionEvent);
    AppMethodBeat.o(9711);
    return bool;
  }
  
  public void onMemoryPressure()
  {
    AppMethodBeat.i(190723);
    this.mNativeView.getFlutterJNI().notifyLowMemoryWarning();
    this.systemChannel.sendMemoryPressureWarning();
    AppMethodBeat.o(190723);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(190713);
    this.lifecycleChannel.appIsInactive();
    AppMethodBeat.o(190713);
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9702);
    Iterator localIterator = this.mActivityLifecycleListeners.iterator();
    while (localIterator.hasNext()) {
      ((ActivityLifecycleListener)localIterator.next()).onPostResume();
    }
    this.lifecycleChannel.appIsResumed();
    AppMethodBeat.o(9702);
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(190797);
    super.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    this.mTextInputPlugin.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    AppMethodBeat.o(190797);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9713);
    this.mMetrics.physicalWidth = paramInt1;
    this.mMetrics.physicalHeight = paramInt2;
    updateViewportMetrics();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(9713);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(190707);
    this.lifecycleChannel.appIsInactive();
    AppMethodBeat.o(190707);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(190720);
    this.lifecycleChannel.appIsPaused();
    AppMethodBeat.o(190720);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9710);
    if (!isAttached())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(9710);
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    boolean bool = this.androidTouchProcessor.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9710);
    return bool;
  }
  
  public void popRoute()
  {
    AppMethodBeat.i(190749);
    this.navigationChannel.popRoute();
    AppMethodBeat.o(190749);
  }
  
  public void pushRoute(String paramString)
  {
    AppMethodBeat.i(190743);
    this.navigationChannel.pushRoute(paramString);
    AppMethodBeat.o(190743);
  }
  
  public void removeFirstFrameListener(FirstFrameListener paramFirstFrameListener)
  {
    AppMethodBeat.i(190733);
    this.mFirstFrameListeners.remove(paramFirstFrameListener);
    AppMethodBeat.o(190733);
  }
  
  void resetAccessibilityTree()
  {
    AppMethodBeat.i(9717);
    if (this.mAccessibilityNodeProvider != null) {
      this.mAccessibilityNodeProvider.reset();
    }
    AppMethodBeat.o(9717);
  }
  
  public void runFromBundle(FlutterRunArguments paramFlutterRunArguments)
  {
    AppMethodBeat.i(9718);
    assertAttached();
    preRun();
    this.mNativeView.runFromBundle(paramFlutterRunArguments);
    postRun();
    AppMethodBeat.o(9718);
  }
  
  public void send(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9726);
    send(paramString, paramByteBuffer, null);
    AppMethodBeat.o(9726);
  }
  
  public void send(String paramString, ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply)
  {
    AppMethodBeat.i(9727);
    if (!isAttached())
    {
      Log.d("FlutterView", "FlutterView.send called on a detached view, channel=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(9727);
      return;
    }
    this.mNativeView.send(paramString, paramByteBuffer, paramBinaryReply);
    AppMethodBeat.o(9727);
  }
  
  public void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(9703);
    this.navigationChannel.setInitialRoute(paramString);
    AppMethodBeat.o(9703);
  }
  
  public void setMessageHandler(String paramString, BinaryMessenger.BinaryMessageHandler paramBinaryMessageHandler)
  {
    AppMethodBeat.i(9728);
    this.mNativeView.setMessageHandler(paramString, paramBinaryMessageHandler);
    AppMethodBeat.o(9728);
  }
  
  public static abstract interface FirstFrameListener
  {
    public abstract void onFirstFrame();
  }
  
  public static abstract interface Provider
  {
    public abstract FlutterView getFlutterView();
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
      AppMethodBeat.i(9779);
      this.onFrameListener = new SurfaceTexture.OnFrameAvailableListener()
      {
        public void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(9682);
          if ((FlutterView.SurfaceTextureRegistryEntry.this.released) || (FlutterView.this.mNativeView == null))
          {
            AppMethodBeat.o(9682);
            return;
          }
          FlutterView.this.mNativeView.getFlutterJNI().markTextureFrameAvailable(FlutterView.SurfaceTextureRegistryEntry.this.id);
          AppMethodBeat.o(9682);
        }
      };
      this.id = paramLong;
      this.textureWrapper = new SurfaceTextureWrapper(paramSurfaceTexture);
      if (Build.VERSION.SDK_INT >= 21)
      {
        surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
        AppMethodBeat.o(9779);
        return;
      }
      surfaceTexture().setOnFrameAvailableListener(this.onFrameListener);
      AppMethodBeat.o(9779);
    }
    
    public final long id()
    {
      return this.id;
    }
    
    public final void release()
    {
      AppMethodBeat.i(9780);
      if (this.released)
      {
        AppMethodBeat.o(9780);
        return;
      }
      this.released = true;
      surfaceTexture().setOnFrameAvailableListener(null);
      this.textureWrapper.release();
      FlutterView.this.mNativeView.getFlutterJNI().unregisterTexture(this.id);
      AppMethodBeat.o(9780);
    }
    
    public final SurfaceTexture surfaceTexture()
    {
      AppMethodBeat.i(190615);
      SurfaceTexture localSurfaceTexture = this.textureWrapper.surfaceTexture();
      AppMethodBeat.o(190615);
      return localSurfaceTexture;
    }
    
    public final SurfaceTextureWrapper textureWrapper()
    {
      return this.textureWrapper;
    }
  }
  
  static final class ViewportMetrics
  {
    float devicePixelRatio = 1.0F;
    int physicalHeight = 0;
    int physicalViewInsetBottom = 0;
    int physicalViewInsetLeft = 0;
    int physicalViewInsetRight = 0;
    int physicalViewInsetTop = 0;
    int physicalViewPaddingBottom = 0;
    int physicalViewPaddingLeft = 0;
    int physicalViewPaddingRight = 0;
    int physicalViewPaddingTop = 0;
    int physicalWidth = 0;
    int systemGestureInsetBottom = 0;
    int systemGestureInsetLeft = 0;
    int systemGestureInsetRight = 0;
    int systemGestureInsetTop = 0;
  }
  
  static enum ZeroSides
  {
    static
    {
      AppMethodBeat.i(190598);
      NONE = new ZeroSides("NONE", 0);
      LEFT = new ZeroSides("LEFT", 1);
      RIGHT = new ZeroSides("RIGHT", 2);
      BOTH = new ZeroSides("BOTH", 3);
      $VALUES = new ZeroSides[] { NONE, LEFT, RIGHT, BOTH };
      AppMethodBeat.o(190598);
    }
    
    private ZeroSides() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.view.FlutterView
 * JD-Core Version:    0.7.0.1
 */