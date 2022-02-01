package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.e;
import io.flutter.embedding.engine.b.f;
import io.flutter.embedding.engine.b.g;
import io.flutter.embedding.engine.b.h;
import io.flutter.embedding.engine.b.k;
import io.flutter.embedding.engine.b.k.a;
import io.flutter.embedding.engine.b.k.b;
import io.flutter.embedding.engine.b.l;
import io.flutter.embedding.engine.b.m;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.a.c.b;
import io.flutter.plugin.c.a.a;
import io.flutter.plugin.platform.PlatformViewsController;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Deprecated
public class FlutterView
  extends SurfaceView
  implements io.flutter.plugin.a.c, a.a, c
{
  private final io.flutter.embedding.engine.renderer.a aaoR;
  public FlutterNativeView aaoc;
  private final io.flutter.embedding.engine.b.c aaon;
  private final DartExecutor aapU;
  public final io.flutter.embedding.engine.b.d aapY;
  private final e aapZ;
  private final io.flutter.embedding.android.a aapo;
  private final io.flutter.embedding.android.b aapp;
  private final a.e aaps;
  public final g aaqb;
  private final h aaqd;
  private final k aaqe;
  private final l aaqf;
  private final AtomicLong aarS;
  private final InputMethodManager aavc;
  private final io.flutter.plugin.editing.d aayX;
  private final io.flutter.plugin.b.a aayY;
  private final io.flutter.plugin.c.a aayZ;
  private a aaza;
  public final SurfaceHolder.Callback aazb;
  private final d aazc;
  public final List<io.flutter.plugin.a.a> aazd;
  public final List<a> aaze;
  private boolean aazf;
  boolean aazg;
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(255178);
    this.aarS = new AtomicLong(0L);
    this.aazf = false;
    this.aazg = false;
    this.aaps = new a.e()
    {
      public final void bw(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(9829);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(9829);
      }
    };
    paramAttributeSet = mM(getContext());
    if (paramAttributeSet == null)
    {
      paramContext = new IllegalArgumentException("Bad context");
      AppMethodBeat.o(255178);
      throw paramContext;
    }
    this.aaoc = new FlutterNativeView(paramAttributeSet.getApplicationContext());
    this.aapU = this.aaoc.aapU;
    this.aaoR = new io.flutter.embedding.engine.renderer.a(this.aaoc.getFlutterJNI());
    this.aazf = this.aaoc.getFlutterJNI().getIsSoftwareRenderingEnabled();
    this.aazc = new d();
    this.aazc.aarY = paramContext.getResources().getDisplayMetrics().density;
    setFocusable(true);
    setFocusableInTouchMode(true);
    Object localObject = this.aaoc;
    ((FlutterNativeView)localObject).aaod = this;
    localObject = ((FlutterNativeView)localObject).aayQ;
    ((io.flutter.app.c)localObject).aaod = this;
    ((io.flutter.app.c)localObject).mActivity = paramAttributeSet;
    ((io.flutter.app.c)localObject).aaoe.a(paramAttributeSet, this, getDartExecutor());
    this.aazb = new SurfaceHolder.Callback()
    {
      public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(9800);
        FlutterView.this.iBE();
        FlutterView.a(FlutterView.this).getFlutterJNI().onSurfaceChanged(paramAnonymousInt2, paramAnonymousInt3);
        AppMethodBeat.o(9800);
      }
      
      public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9799);
        FlutterView.this.iBE();
        FlutterView.a(FlutterView.this).getFlutterJNI().onSurfaceCreated(paramAnonymousSurfaceHolder.getSurface());
        AppMethodBeat.o(9799);
      }
      
      public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
      {
        AppMethodBeat.i(9801);
        FlutterView.this.iBE();
        FlutterView.a(FlutterView.this).getFlutterJNI().onSurfaceDestroyed();
        AppMethodBeat.o(9801);
      }
    };
    getHolder().addCallback(this.aazb);
    this.aazd = new ArrayList();
    this.aaze = new ArrayList();
    this.aaqb = new g(this.aapU);
    this.aaon = new io.flutter.embedding.engine.b.c(this.aapU);
    this.aapY = new io.flutter.embedding.engine.b.d(this.aapU);
    this.aapZ = new e(this.aapU);
    this.aaqd = new h(this.aapU);
    this.aaqf = new l(this.aapU);
    this.aaqe = new k(this.aapU);
    paramAttributeSet = new io.flutter.plugin.a.a()
    {
      public final void onPostResume()
      {
        AppMethodBeat.i(9680);
        this.aazi.iBs();
        AppMethodBeat.o(9680);
      }
    };
    this.aazd.add(paramAttributeSet);
    this.aavc = ((InputMethodManager)getContext().getSystemService("input_method"));
    paramAttributeSet = this.aaoc.aayQ.aaoe;
    this.aayX = new io.flutter.plugin.editing.d(this, new m(this.aapU), paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 24) {}
    for (this.aayZ = new io.flutter.plugin.c.a(this, new f(this.aapU));; this.aayZ = null)
    {
      this.aayY = new io.flutter.plugin.b.a(paramContext, this.aapZ);
      this.aapo = new io.flutter.embedding.android.a(this, this.aaon, this.aayX);
      this.aapp = new io.flutter.embedding.android.b(this.aaoR, false);
      paramAttributeSet.c(this.aaoR);
      this.aaoc.aayQ.aaoe.aaoo = this.aayX;
      this.aaoc.getFlutterJNI().setLocalizationPlugin(this.aayY);
      this.aayY.i(getResources().getConfiguration());
      iBG();
      AppMethodBeat.o(255178);
      return;
    }
  }
  
  private void bv(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9724);
    if (!this.aazf)
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
  
  @TargetApi(20)
  private int c(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(255193);
    int i = getRootView().getHeight();
    if (paramWindowInsets.getSystemWindowInsetBottom() < i * 0.18D)
    {
      AppMethodBeat.o(255193);
      return 0;
    }
    i = paramWindowInsets.getSystemWindowInsetBottom();
    AppMethodBeat.o(255193);
    return i;
  }
  
  private void iBG()
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
    for (k.b localb = k.b.aatL;; localb = k.b.aatK)
    {
      this.aaqe.iBk().dl(getResources().getConfiguration().fontScale).Jc(DateFormat.is24HourFormat(getContext())).a(localb).gOA();
      AppMethodBeat.o(9704);
      return;
      i = 0;
      break;
    }
  }
  
  private void iBI()
  {
    AppMethodBeat.i(9720);
    if (!isAttached())
    {
      AppMethodBeat.o(9720);
      return;
    }
    this.aaoc.getFlutterJNI().setViewportMetrics(this.aazc.aarY, this.aazc.aazk, this.aazc.aazl, this.aazc.aazm, this.aazc.aazn, this.aazc.aazo, this.aazc.aazp, this.aazc.aazq, this.aazc.aazr, this.aazc.aazs, this.aazc.aazt, this.aazc.aash, this.aazc.aasi, this.aazc.aasj, this.aazc.aask);
    AppMethodBeat.o(9720);
  }
  
  private static Activity mM(Context paramContext)
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
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(9718);
    iBE();
    iBH();
    this.aaoc.a(paramb);
    AppMethodBeat.o(9718);
  }
  
  public final void a(String paramString, io.flutter.plugin.a.c.a parama)
  {
    AppMethodBeat.i(9728);
    this.aaoc.a(paramString, parama);
    AppMethodBeat.o(9728);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9726);
    a(paramString, paramByteBuffer, null);
    AppMethodBeat.o(9726);
  }
  
  public final void a(String paramString, ByteBuffer paramByteBuffer, c.b paramb)
  {
    AppMethodBeat.i(9727);
    if (!isAttached())
    {
      io.flutter.b.iAe();
      AppMethodBeat.o(9727);
      return;
    }
    this.aaoc.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(9727);
  }
  
  @TargetApi(24)
  public final PointerIcon aDk(int paramInt)
  {
    AppMethodBeat.i(255204);
    PointerIcon localPointerIcon = PointerIcon.getSystemIcon(getContext(), paramInt);
    AppMethodBeat.o(255204);
    return localPointerIcon;
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(255191);
    this.aayX.autofill(paramSparseArray);
    AppMethodBeat.o(255191);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9709);
    boolean bool = this.aaoc.aayQ.aaoe.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9709);
    return bool;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(255182);
    new StringBuilder("dispatchKeyEvent: ").append(paramKeyEvent.toString());
    io.flutter.b.iAh();
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      getKeyDispatcherState().startTracking(paramKeyEvent, this);
    }
    while (((isAttached()) && (this.aapo.j(paramKeyEvent))) || (super.dispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(255182);
      return true;
      if (paramKeyEvent.getAction() == 1) {
        getKeyDispatcherState().handleUpEvent(paramKeyEvent);
      }
    }
    AppMethodBeat.o(255182);
    return false;
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9714);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.aazc.aazm = paramRect.top;
      this.aazc.aazn = paramRect.right;
      this.aazc.aazo = 0;
      this.aazc.aazp = paramRect.left;
      this.aazc.aazq = 0;
      this.aazc.aazr = 0;
      this.aazc.aazs = paramRect.bottom;
      this.aazc.aazt = 0;
      iBI();
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
    if ((this.aaza != null) && (this.aaza.bEA.isEnabled()))
    {
      a locala = this.aaza;
      AppMethodBeat.o(9725);
      return locala;
    }
    AppMethodBeat.o(9725);
    return null;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(9719);
    iBE();
    Bitmap localBitmap = this.aaoc.getFlutterJNI().getBitmap();
    AppMethodBeat.o(9719);
    return localBitmap;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.aapU;
  }
  
  float getDevicePixelRatio()
  {
    return this.aazc.aarY;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.aaoc;
  }
  
  public io.flutter.app.c getPluginRegistry()
  {
    return this.aaoc.aayQ;
  }
  
  final void iBE()
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
  
  public final void iBF()
  {
    AppMethodBeat.i(255184);
    this.aaoc.getFlutterJNI().notifyLowMemoryWarning();
    this.aaqf.iBl();
    AppMethodBeat.o(255184);
  }
  
  final void iBH()
  {
    AppMethodBeat.i(9717);
    if (this.aaza != null) {
      this.aaza.reset();
    }
    AppMethodBeat.o(9717);
  }
  
  public final void iBJ()
  {
    AppMethodBeat.i(255202);
    if (this.aaza != null)
    {
      this.aaza.release();
      this.aaza = null;
    }
    AppMethodBeat.o(255202);
  }
  
  public final c.a iBa()
  {
    AppMethodBeat.i(9729);
    Object localObject = new SurfaceTexture(0);
    ((SurfaceTexture)localObject).detachFromGLContext();
    localObject = new c(this.aarS.getAndIncrement(), (SurfaceTexture)localObject);
    this.aaoc.getFlutterJNI().registerTexture(((c)localObject).id, ((c)localObject).aarV);
    AppMethodBeat.o(9729);
    return localObject;
  }
  
  public final boolean isAttached()
  {
    AppMethodBeat.i(9715);
    if ((this.aaoc != null) && (this.aaoc.aayR.isAttached()))
    {
      AppMethodBeat.o(9715);
      return true;
    }
    AppMethodBeat.o(9715);
    return false;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  @TargetApi(20)
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(255198);
    Object localObject1;
    if (Build.VERSION.SDK_INT == 29)
    {
      localObject1 = paramWindowInsets.getSystemGestureInsets();
      this.aazc.aash = ((Insets)localObject1).top;
      this.aazc.aasi = ((Insets)localObject1).right;
      this.aazc.aasj = ((Insets)localObject1).bottom;
      this.aazc.aask = ((Insets)localObject1).left;
    }
    int j;
    if ((getWindowSystemUiVisibility() & 0x4) == 0)
    {
      j = 1;
      if ((getWindowSystemUiVisibility() & 0x2) != 0) {
        break label453;
      }
      i = 1;
      label90:
      if (Build.VERSION.SDK_INT < 30) {
        break label458;
      }
      if (i == 0) {
        break label756;
      }
    }
    label453:
    label458:
    label598:
    label730:
    label735:
    label743:
    label748:
    label756:
    for (int i = WindowInsets.Type.navigationBars() | 0x0;; i = 0)
    {
      int k = i;
      if (j != 0) {
        k = i | WindowInsets.Type.statusBars();
      }
      localObject1 = paramWindowInsets.getInsets(k);
      this.aazc.aazm = ((Insets)localObject1).top;
      this.aazc.aazn = ((Insets)localObject1).right;
      this.aazc.aazo = ((Insets)localObject1).bottom;
      this.aazc.aazp = ((Insets)localObject1).left;
      localObject1 = paramWindowInsets.getInsets(WindowInsets.Type.ime());
      this.aazc.aazq = ((Insets)localObject1).top;
      this.aazc.aazr = ((Insets)localObject1).right;
      this.aazc.aazs = ((Insets)localObject1).bottom;
      this.aazc.aazt = ((Insets)localObject1).left;
      localObject1 = paramWindowInsets.getInsets(WindowInsets.Type.systemGestures());
      this.aazc.aash = ((Insets)localObject1).top;
      this.aazc.aasi = ((Insets)localObject1).right;
      this.aazc.aasj = ((Insets)localObject1).bottom;
      this.aazc.aask = ((Insets)localObject1).left;
      localObject1 = paramWindowInsets.getDisplayCutout();
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((DisplayCutout)localObject1).getWaterfallInsets();
        this.aazc.aazm = Math.max(Math.max(this.aazc.aazm, ((Insets)localObject2).top), ((DisplayCutout)localObject1).getSafeInsetTop());
        this.aazc.aazn = Math.max(Math.max(this.aazc.aazn, ((Insets)localObject2).right), ((DisplayCutout)localObject1).getSafeInsetRight());
        this.aazc.aazo = Math.max(Math.max(this.aazc.aazo, ((Insets)localObject2).bottom), ((DisplayCutout)localObject1).getSafeInsetBottom());
        this.aazc.aazp = Math.max(Math.max(this.aazc.aazp, ((Insets)localObject2).left), ((DisplayCutout)localObject1).getSafeInsetLeft());
      }
      iBI();
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      AppMethodBeat.o(255198);
      return paramWindowInsets;
      j = 0;
      break;
      i = 0;
      break label90;
      localObject1 = FlutterView.e.aazu;
      int m;
      if (i == 0)
      {
        localObject1 = getContext();
        k = ((Context)localObject1).getResources().getConfiguration().orientation;
        m = ((WindowManager)((Context)localObject1).getSystemService("window")).getDefaultDisplay().getRotation();
        if (k != 2) {
          break label722;
        }
        if (m == 1) {
          localObject1 = FlutterView.e.aazw;
        }
      }
      else
      {
        localObject2 = this.aazc;
        if (j == 0) {
          break label730;
        }
        j = paramWindowInsets.getSystemWindowInsetTop();
        ((d)localObject2).aazm = j;
        localObject2 = this.aazc;
        if ((localObject1 != FlutterView.e.aazw) && (localObject1 != FlutterView.e.aazx)) {
          break label735;
        }
        j = 0;
        ((d)localObject2).aazn = j;
        localObject2 = this.aazc;
        if ((i == 0) || (c(paramWindowInsets) != 0)) {
          break label743;
        }
        i = paramWindowInsets.getSystemWindowInsetBottom();
        ((d)localObject2).aazo = i;
        localObject2 = this.aazc;
        if ((localObject1 != FlutterView.e.aazv) && (localObject1 != FlutterView.e.aazx)) {
          break label748;
        }
      }
      for (i = 0;; i = paramWindowInsets.getSystemWindowInsetLeft())
      {
        ((d)localObject2).aazp = i;
        this.aazc.aazq = 0;
        this.aazc.aazr = 0;
        this.aazc.aazs = c(paramWindowInsets);
        this.aazc.aazt = 0;
        break;
        if (m == 3)
        {
          if (Build.VERSION.SDK_INT >= 23)
          {
            localObject1 = FlutterView.e.aazv;
            break label524;
          }
          localObject1 = FlutterView.e.aazw;
          break label524;
        }
        if ((m == 0) || (m == 2))
        {
          localObject1 = FlutterView.e.aazx;
          break label524;
        }
        localObject1 = FlutterView.e.aazu;
        break label524;
        j = 0;
        break label539;
        j = paramWindowInsets.getSystemWindowInsetRight();
        break label569;
        i = 0;
        break label598;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(9722);
    super.onAttachedToWindow();
    PlatformViewsController localPlatformViewsController = getPluginRegistry().aaoe;
    this.aaza = new a(this, new io.flutter.embedding.engine.b.a(this.aapU, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), localPlatformViewsController);
    this.aaza.aaps = this.aaps;
    bv(this.aaza.bEA.isEnabled(), this.aaza.bEA.isTouchExplorationEnabled());
    AppMethodBeat.o(9722);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9706);
    super.onConfigurationChanged(paramConfiguration);
    this.aayY.i(paramConfiguration);
    iBG();
    AppMethodBeat.o(9706);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9708);
    paramEditorInfo = this.aayX.a(this, paramEditorInfo);
    AppMethodBeat.o(9708);
    return paramEditorInfo;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(9723);
    super.onDetachedFromWindow();
    iBJ();
    AppMethodBeat.o(9723);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9712);
    if ((isAttached()) && (this.aapp.onGenericMotionEvent(paramMotionEvent))) {}
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
    boolean bool = this.aaza.aM(paramMotionEvent);
    AppMethodBeat.o(9711);
    return bool;
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(255189);
    super.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    this.aayX.a(paramViewStructure);
    AppMethodBeat.o(255189);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9713);
    this.aazc.aazk = paramInt1;
    this.aazc.aazl = paramInt2;
    iBI();
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(9713);
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
    boolean bool = this.aapp.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9710);
    return bool;
  }
  
  public void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(9703);
    this.aaqb.setInitialRoute(paramString);
    AppMethodBeat.o(9703);
  }
  
  public static abstract interface a
  {
    public abstract void onFirstFrame();
  }
  
  public static abstract interface b {}
  
  final class c
    implements c.a
  {
    final SurfaceTextureWrapper aarV;
    private SurfaceTexture.OnFrameAvailableListener aarW;
    final long id;
    boolean released;
    
    c(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(9779);
      this.aarW = new SurfaceTexture.OnFrameAvailableListener()
      {
        public final void onFrameAvailable(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(9682);
          if ((FlutterView.c.this.released) || (FlutterView.a(FlutterView.this) == null))
          {
            AppMethodBeat.o(9682);
            return;
          }
          FlutterView.a(FlutterView.this).getFlutterJNI().markTextureFrameAvailable(FlutterView.c.this.id);
          AppMethodBeat.o(9682);
        }
      };
      this.id = paramLong;
      this.aarV = new SurfaceTextureWrapper(paramSurfaceTexture);
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.aarV.surfaceTexture().setOnFrameAvailableListener(this.aarW, new Handler());
        AppMethodBeat.o(9779);
        return;
      }
      this.aarV.surfaceTexture().setOnFrameAvailableListener(this.aarW);
      AppMethodBeat.o(9779);
    }
    
    public final long dux()
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
      this.aarV.surfaceTexture().setOnFrameAvailableListener(null);
      this.aarV.release();
      FlutterView.a(FlutterView.this).getFlutterJNI().unregisterTexture(this.id);
      AppMethodBeat.o(9780);
    }
    
    public final SurfaceTexture surfaceTexture()
    {
      AppMethodBeat.i(293077);
      SurfaceTexture localSurfaceTexture = this.aarV.surfaceTexture();
      AppMethodBeat.o(293077);
      return localSurfaceTexture;
    }
  }
  
  static final class d
  {
    float aarY = 1.0F;
    int aash = 0;
    int aasi = 0;
    int aasj = 0;
    int aask = 0;
    int aazk = 0;
    int aazl = 0;
    int aazm = 0;
    int aazn = 0;
    int aazo = 0;
    int aazp = 0;
    int aazq = 0;
    int aazr = 0;
    int aazs = 0;
    int aazt = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.view.FlutterView
 * JD-Core Version:    0.7.0.1
 */