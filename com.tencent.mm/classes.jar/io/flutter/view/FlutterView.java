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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.c.d;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.c.g;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.c.j.a;
import io.flutter.embedding.engine.c.j.b;
import io.flutter.embedding.engine.c.l;
import io.flutter.embedding.engine.c.m;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.c.b;
import io.flutter.plugin.d.a.a;
import io.flutter.plugin.platform.PlatformViewsController;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterView
  extends SurfaceView
  implements io.flutter.plugin.a.c, a.a, c
{
  private final io.flutter.embedding.engine.b.a SMT;
  public FlutterNativeView SMd;
  private final io.flutter.embedding.engine.c.b SMo;
  private final DartExecutor SNW;
  public final io.flutter.embedding.engine.c.c SNZ;
  private final io.flutter.embedding.android.a SNq;
  private final io.flutter.embedding.android.b SNr;
  private final a.e SNu;
  private final d SOa;
  public final f SOc;
  private final g SOe;
  private final j SOg;
  private final l SOh;
  private final AtomicLong SPC;
  private final InputMethodManager SSy;
  private final io.flutter.plugin.b.c SWl;
  private final io.flutter.plugin.c.a SWm;
  private final io.flutter.plugin.d.a SWn;
  private a SWo;
  public final SurfaceHolder.Callback SWp;
  private final d SWq;
  private final List<io.flutter.plugin.a.a> SWr;
  public final List<a> SWs;
  private boolean SWt;
  private boolean SWu;
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9698);
    this.SPC = new AtomicLong(0L);
    this.SWt = false;
    this.SWu = false;
    this.SNu = new a.e()
    {
      public final void bm(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(9829);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(9829);
      }
    };
    paramAttributeSet = lP(getContext());
    if (paramAttributeSet == null)
    {
      paramContext = new IllegalArgumentException("Bad context");
      AppMethodBeat.o(9698);
      throw paramContext;
    }
    if (paramFlutterNativeView == null)
    {
      this.SMd = new FlutterNativeView(paramAttributeSet.getApplicationContext());
      this.SNW = this.SMd.SNW;
      this.SMT = new io.flutter.embedding.engine.b.a(this.SMd.getFlutterJNI());
      this.SWt = this.SMd.getFlutterJNI().getIsSoftwareRenderingEnabled();
      this.SWq = new d();
      this.SWq.SPH = paramContext.getResources().getDisplayMetrics().density;
      setFocusable(true);
      setFocusableInTouchMode(true);
      paramFlutterNativeView = this.SMd;
      paramFlutterNativeView.SMe = this;
      paramFlutterNativeView = paramFlutterNativeView.SWe;
      paramFlutterNativeView.SMe = this;
      paramFlutterNativeView.mActivity = paramAttributeSet;
      paramFlutterNativeView.SMf.a(paramAttributeSet, this, getDartExecutor());
      this.SWp = new SurfaceHolder.Callback()
      {
        public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(9800);
          FlutterView.this.assertAttached();
          FlutterView.a(FlutterView.this).getFlutterJNI().onSurfaceChanged(paramAnonymousInt2, paramAnonymousInt3);
          AppMethodBeat.o(9800);
        }
        
        public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(9799);
          FlutterView.this.assertAttached();
          FlutterView.a(FlutterView.this).getFlutterJNI().onSurfaceCreated(paramAnonymousSurfaceHolder.getSurface());
          AppMethodBeat.o(9799);
        }
        
        public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
        {
          AppMethodBeat.i(9801);
          FlutterView.this.assertAttached();
          FlutterView.a(FlutterView.this).getFlutterJNI().onSurfaceDestroyed();
          AppMethodBeat.o(9801);
        }
      };
      getHolder().addCallback(this.SWp);
      this.SWr = new ArrayList();
      this.SWs = new ArrayList();
      this.SOc = new f(this.SNW);
      this.SMo = new io.flutter.embedding.engine.c.b(this.SNW);
      this.SNZ = new io.flutter.embedding.engine.c.c(this.SNW);
      this.SOa = new d(this.SNW);
      this.SOe = new g(this.SNW);
      this.SOh = new l(this.SNW);
      this.SOg = new j(this.SNW);
      paramAttributeSet = new io.flutter.plugin.a.a()
      {
        public final void onPostResume()
        {
          AppMethodBeat.i(9680);
          this.SWw.hxp();
          AppMethodBeat.o(9680);
        }
      };
      this.SWr.add(paramAttributeSet);
      this.SSy = ((InputMethodManager)getContext().getSystemService("input_method"));
      paramAttributeSet = this.SMd.SWe.SMf;
      this.SWl = new io.flutter.plugin.b.c(this, new m(this.SNW), paramAttributeSet);
      if (Build.VERSION.SDK_INT < 24) {
        break label604;
      }
    }
    label604:
    for (this.SWn = new io.flutter.plugin.d.a(this, new e(this.SNW));; this.SWn = null)
    {
      this.SWm = new io.flutter.plugin.c.a(paramContext, this.SOa);
      this.SNq = new io.flutter.embedding.android.a(this.SMo, this.SWl);
      this.SNr = new io.flutter.embedding.android.b(this.SMT, false);
      paramAttributeSet.b(this.SMT);
      this.SMd.SWe.SMf.SMp = this.SWl;
      this.SMd.getFlutterJNI().setLocalizationPlugin(this.SWm);
      this.SWm.j(getResources().getConfiguration());
      hxA();
      AppMethodBeat.o(9698);
      return;
      this.SMd = paramFlutterNativeView;
      break;
    }
  }
  
  private void bl(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9724);
    if (!this.SWt)
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
  
  private void hxA()
  {
    AppMethodBeat.i(9704);
    if (!isAttached())
    {
      AppMethodBeat.o(9704);
      return;
    }
    int i;
    if ((getResources().getConfiguration().uiMode & 0x30) == 32)
    {
      i = 1;
      if (i == 0) {
        break label97;
      }
    }
    label97:
    for (j.b localb = j.b.SRm;; localb = j.b.SRl)
    {
      this.SOg.hxi().cQ(getResources().getConfiguration().fontScale).Ez(DateFormat.is24HourFormat(getContext())).a(localb).send();
      AppMethodBeat.o(9704);
      return;
      i = 0;
      break;
    }
  }
  
  private void hxC()
  {
    AppMethodBeat.i(9720);
    if (!isAttached())
    {
      AppMethodBeat.o(9720);
      return;
    }
    this.SMd.getFlutterJNI().setViewportMetrics(this.SWq.SPH, this.SWq.SWy, this.SWq.SWz, this.SWq.SWA, this.SWq.SWB, this.SWq.SWC, this.SWq.SWD, this.SWq.SWE, this.SWq.SWF, this.SWq.SWG, this.SWq.SWH, this.SWq.SPM, this.SWq.SPN, this.SWq.SPO, this.SWq.SPP);
    AppMethodBeat.o(9720);
  }
  
  private static Activity lP(Context paramContext)
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
    assertAttached();
    hxB();
    this.SMd.a(paramb);
    AppMethodBeat.o(9718);
  }
  
  public final void a(String paramString, io.flutter.plugin.a.c.a parama)
  {
    AppMethodBeat.i(9728);
    this.SMd.a(paramString, parama);
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
      AppMethodBeat.o(9727);
      return;
    }
    this.SMd.a(paramString, paramByteBuffer, paramb);
    AppMethodBeat.o(9727);
  }
  
  final void assertAttached()
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
  
  @TargetApi(24)
  public final PointerIcon atp(int paramInt)
  {
    AppMethodBeat.i(214923);
    PointerIcon localPointerIcon = PointerIcon.getSystemIcon(getContext(), paramInt);
    AppMethodBeat.o(214923);
    return localPointerIcon;
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(214921);
    this.SWl.autofill(paramSparseArray);
    AppMethodBeat.o(214921);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9709);
    boolean bool = this.SMd.SWe.SMf.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9709);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(9707);
    if (!isAttached())
    {
      AppMethodBeat.o(9707);
      return;
    }
    getHolder().removeCallback(this.SWp);
    this.SMd.destroy();
    this.SMd = null;
    AppMethodBeat.o(9707);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9714);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.SWq.SWA = paramRect.top;
      this.SWq.SWB = paramRect.right;
      this.SWq.SWC = 0;
      this.SWq.SWD = paramRect.left;
      this.SWq.SWE = 0;
      this.SWq.SWF = 0;
      this.SWq.SWG = paramRect.bottom;
      this.SWq.SWH = 0;
      hxC();
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
    if ((this.SWo != null) && (this.SWo.nC.isEnabled()))
    {
      a locala = this.SWo;
      AppMethodBeat.o(9725);
      return locala;
    }
    AppMethodBeat.o(9725);
    return null;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(9719);
    assertAttached();
    Bitmap localBitmap = this.SMd.getFlutterJNI().getBitmap();
    AppMethodBeat.o(9719);
    return localBitmap;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.SNW;
  }
  
  float getDevicePixelRatio()
  {
    return this.SWq.SPH;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.SMd;
  }
  
  public io.flutter.app.c getPluginRegistry()
  {
    return this.SMd.SWe;
  }
  
  public final c.a hwY()
  {
    AppMethodBeat.i(9729);
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    c localc = new c(this.SPC.getAndIncrement(), localSurfaceTexture);
    this.SMd.getFlutterJNI().registerTexture(localc.id, localSurfaceTexture);
    AppMethodBeat.o(9729);
    return localc;
  }
  
  final void hxB()
  {
    AppMethodBeat.i(9717);
    if (this.SWo != null) {
      this.SWo.reset();
    }
    AppMethodBeat.o(9717);
  }
  
  public final void hxz()
  {
    AppMethodBeat.i(214919);
    this.SMd.getFlutterJNI().notifyLowMemoryWarning();
    this.SOh.hxj();
    AppMethodBeat.o(214919);
  }
  
  public final boolean isAttached()
  {
    AppMethodBeat.i(9715);
    if ((this.SMd != null) && (this.SMd.SWf.isAttached()))
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
    AppMethodBeat.i(214922);
    int j;
    int i;
    label28:
    Object localObject;
    int m;
    if ((getWindowSystemUiVisibility() & 0x4) != 0)
    {
      j = 1;
      if ((getWindowSystemUiVisibility() & 0x2) == 0) {
        break label330;
      }
      i = 1;
      localObject = e.SWI;
      if (i != 0)
      {
        localObject = getContext();
        int k = ((Context)localObject).getResources().getConfiguration().orientation;
        m = ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay().getRotation();
        if (k != 2) {
          break label384;
        }
        if (m != 1) {
          break label335;
        }
        localObject = e.SWK;
      }
      label94:
      d locald = this.SWq;
      if (j == 0) {
        break label392;
      }
      j = 0;
      label106:
      locald.SWA = j;
      locald = this.SWq;
      if ((localObject != e.SWK) && (localObject != e.SWL)) {
        break label400;
      }
      j = 0;
      label136:
      locald.SWB = j;
      this.SWq.SWC = 0;
      locald = this.SWq;
      if ((localObject != e.SWJ) && (localObject != e.SWL)) {
        break label408;
      }
      j = 0;
      label174:
      locald.SWD = j;
      this.SWq.SWE = 0;
      this.SWq.SWF = 0;
      localObject = this.SWq;
      if (i == 0) {
        break label424;
      }
      i = getRootView().getHeight();
      if (paramWindowInsets.getSystemWindowInsetBottom() >= i * 0.18D) {
        break label416;
      }
      i = 0;
    }
    for (;;)
    {
      ((d)localObject).SWG = i;
      this.SWq.SWH = 0;
      if (Build.VERSION.SDK_INT >= 29)
      {
        localObject = paramWindowInsets.getSystemGestureInsets();
        this.SWq.SPM = ((Insets)localObject).top;
        this.SWq.SPN = ((Insets)localObject).right;
        this.SWq.SPO = ((Insets)localObject).bottom;
        this.SWq.SPP = ((Insets)localObject).left;
      }
      hxC();
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      AppMethodBeat.o(214922);
      return paramWindowInsets;
      j = 0;
      break;
      label330:
      i = 0;
      break label28;
      label335:
      if (m == 3)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = e.SWJ;
          break label94;
        }
        localObject = e.SWK;
        break label94;
      }
      if ((m == 0) || (m == 2))
      {
        localObject = e.SWL;
        break label94;
      }
      label384:
      localObject = e.SWI;
      break label94;
      label392:
      j = paramWindowInsets.getSystemWindowInsetTop();
      break label106;
      label400:
      j = paramWindowInsets.getSystemWindowInsetRight();
      break label136;
      label408:
      j = paramWindowInsets.getSystemWindowInsetLeft();
      break label174;
      label416:
      i = paramWindowInsets.getSystemWindowInsetBottom();
      continue;
      label424:
      i = paramWindowInsets.getSystemWindowInsetBottom();
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(9722);
    super.onAttachedToWindow();
    PlatformViewsController localPlatformViewsController = getPluginRegistry().SMf;
    this.SWo = new a(this, new io.flutter.embedding.engine.c.a(this.SNW, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), localPlatformViewsController);
    this.SWo.SNu = this.SNu;
    bl(this.SWo.nC.isEnabled(), this.SWo.nC.isTouchExplorationEnabled());
    AppMethodBeat.o(9722);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9706);
    super.onConfigurationChanged(paramConfiguration);
    this.SWm.j(paramConfiguration);
    hxA();
    AppMethodBeat.o(9706);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9708);
    paramEditorInfo = this.SWl.a(this, paramEditorInfo);
    AppMethodBeat.o(9708);
    return paramEditorInfo;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(9723);
    super.onDetachedFromWindow();
    this.SWo.release();
    this.SWo = null;
    AppMethodBeat.o(9723);
  }
  
  public void onFirstFrame()
  {
    AppMethodBeat.i(9721);
    this.SWu = true;
    Iterator localIterator = new ArrayList(this.SWs).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFirstFrame();
    }
    AppMethodBeat.o(9721);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9712);
    if ((isAttached()) && (this.SNr.onGenericMotionEvent(paramMotionEvent))) {}
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
    boolean bool = this.SWo.aE(paramMotionEvent);
    AppMethodBeat.o(9711);
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9701);
    if (!isAttached())
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(9701);
      return bool;
    }
    this.SNq.k(paramKeyEvent);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(9701);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9700);
    if (!isAttached())
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(9700);
      return bool;
    }
    this.SNq.j(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9700);
    return bool;
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9702);
    Iterator localIterator = this.SWr.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.plugin.a.a)localIterator.next()).onPostResume();
    }
    this.SNZ.hxd();
    AppMethodBeat.o(9702);
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(214920);
    super.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    this.SWl.a(paramViewStructure);
    AppMethodBeat.o(214920);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9713);
    this.SWq.SWy = paramInt1;
    this.SWq.SWz = paramInt2;
    hxC();
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
    boolean bool = this.SNr.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9710);
    return bool;
  }
  
  public void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(9703);
    this.SOc.setInitialRoute(paramString);
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
    private SurfaceTexture.OnFrameAvailableListener SPF;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    c(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(9779);
      this.SPF = new SurfaceTexture.OnFrameAvailableListener()
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
      this.surfaceTexture = paramSurfaceTexture;
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.surfaceTexture.setOnFrameAvailableListener(this.SPF, new Handler());
        AppMethodBeat.o(9779);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.SPF);
      AppMethodBeat.o(9779);
    }
    
    public final long hxb()
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
      this.surfaceTexture.setOnFrameAvailableListener(null);
      this.surfaceTexture.release();
      FlutterView.a(FlutterView.this).getFlutterJNI().unregisterTexture(this.id);
      AppMethodBeat.o(9780);
    }
    
    public final SurfaceTexture surfaceTexture()
    {
      return this.surfaceTexture;
    }
  }
  
  static final class d
  {
    float SPH = 1.0F;
    int SPM = 0;
    int SPN = 0;
    int SPO = 0;
    int SPP = 0;
    int SWA = 0;
    int SWB = 0;
    int SWC = 0;
    int SWD = 0;
    int SWE = 0;
    int SWF = 0;
    int SWG = 0;
    int SWH = 0;
    int SWy = 0;
    int SWz = 0;
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(214911);
      SWI = new e("NONE", 0);
      SWJ = new e("LEFT", 1);
      SWK = new e("RIGHT", 2);
      SWL = new e("BOTH", 3);
      SWM = new e[] { SWI, SWJ, SWK, SWL };
      AppMethodBeat.o(214911);
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.view.FlutterView
 * JD-Core Version:    0.7.0.1
 */