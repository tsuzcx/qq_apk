package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
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
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.a.b;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.c.j.a;
import io.flutter.embedding.engine.c.j.b;
import io.flutter.plugin.d.a.a;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.a.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlutterView
  extends FrameLayout
  implements a.a
{
  private final io.flutter.embedding.engine.b.b SMD;
  private io.flutter.plugin.b.c SMp;
  private FlutterSurfaceView SNi;
  private FlutterTextureView SNj;
  public g SNk;
  public io.flutter.embedding.engine.b.c SNl;
  public io.flutter.embedding.engine.b.c SNm;
  public boolean SNn;
  private final Set<a> SNo;
  private io.flutter.plugin.d.a SNp;
  private a SNq;
  private b SNr;
  private io.flutter.view.a SNs;
  private final a.b SNt;
  private final a.e SNu;
  private final Set<io.flutter.embedding.engine.b.b> flutterUiDisplayListeners;
  private io.flutter.plugin.c.a localizationPlugin;
  public io.flutter.embedding.engine.a wJi;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(215077);
    AppMethodBeat.o(215077);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(215079);
    AppMethodBeat.o(215079);
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterSurfaceView paramFlutterSurfaceView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(215081);
    this.flutterUiDisplayListeners = new HashSet();
    this.SNo = new HashSet();
    this.SNt = new a.b();
    this.SNu = new a.e()
    {
      public final void bm(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.SMD = new io.flutter.embedding.engine.b.b()
    {
      public final void dLt()
      {
        AppMethodBeat.i(215092);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).dLt();
        }
        AppMethodBeat.o(215092);
      }
      
      public final void dLu()
      {
        AppMethodBeat.i(215093);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).dLu();
        }
        AppMethodBeat.o(215093);
      }
    };
    this.SNi = paramFlutterSurfaceView;
    this.SNl = paramFlutterSurfaceView;
    init();
    AppMethodBeat.o(215081);
  }
  
  public FlutterView(Context paramContext, FlutterSurfaceView paramFlutterSurfaceView)
  {
    this(paramContext, null, paramFlutterSurfaceView);
  }
  
  public FlutterView(Context paramContext, FlutterTextureView paramFlutterTextureView)
  {
    this(paramContext, paramFlutterTextureView, (byte)0);
  }
  
  private FlutterView(Context paramContext, FlutterTextureView paramFlutterTextureView, byte paramByte)
  {
    super(paramContext, null);
    AppMethodBeat.i(215082);
    this.flutterUiDisplayListeners = new HashSet();
    this.SNo = new HashSet();
    this.SNt = new a.b();
    this.SNu = new a.e()
    {
      public final void bm(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.SMD = new io.flutter.embedding.engine.b.b()
    {
      public final void dLt()
      {
        AppMethodBeat.i(215092);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).dLt();
        }
        AppMethodBeat.o(215092);
      }
      
      public final void dLu()
      {
        AppMethodBeat.i(215093);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).dLu();
        }
        AppMethodBeat.o(215093);
      }
    };
    this.SNj = paramFlutterTextureView;
    this.SNl = paramFlutterTextureView;
    init();
    AppMethodBeat.o(215082);
  }
  
  @Deprecated
  public FlutterView(Context paramContext, FlutterView.b paramb, c paramc)
  {
    super(paramContext, null);
    AppMethodBeat.i(215080);
    this.flutterUiDisplayListeners = new HashSet();
    this.SNo = new HashSet();
    this.SNt = new a.b();
    this.SNu = new a.e()
    {
      public final void bm(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.SMD = new io.flutter.embedding.engine.b.b()
    {
      public final void dLt()
      {
        AppMethodBeat.i(215092);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).dLt();
        }
        AppMethodBeat.o(215092);
      }
      
      public final void dLu()
      {
        AppMethodBeat.i(215093);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).dLu();
        }
        AppMethodBeat.o(215093);
      }
    };
    if (paramb == FlutterView.b.SNy) {
      if (paramc == c.SND) {
        this.SNi = new FlutterSurfaceView(paramContext, bool);
      }
    }
    for (this.SNl = this.SNi;; this.SNl = this.SNj)
    {
      init();
      AppMethodBeat.o(215080);
      return;
      bool = false;
      break;
      if (paramb != FlutterView.b.SNz) {
        break label153;
      }
      this.SNj = new FlutterTextureView(paramContext);
    }
    label153:
    paramContext = new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[] { paramb }));
    AppMethodBeat.o(215080);
    throw paramContext;
  }
  
  @Deprecated
  public FlutterView(Context paramContext, c paramc) {}
  
  private void bl(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10000);
    if (!this.wJi.SMr.SNV.getIsSoftwareRenderingEnabled())
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
  
  private void hwB()
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
    for (j.b localb = j.b.SRm;; localb = j.b.SRl)
    {
      this.wJi.SOg.hxi().cQ(getResources().getConfiguration().fontScale).Ez(DateFormat.is24HourFormat(getContext())).a(localb).send();
      AppMethodBeat.o(10006);
      return;
      i = 0;
      break;
    }
  }
  
  private void hwC()
  {
    AppMethodBeat.i(10007);
    if (!hwA())
    {
      io.flutter.a.hwf();
      AppMethodBeat.o(10007);
      return;
    }
    this.SNt.SPH = getResources().getDisplayMetrics().density;
    this.wJi.SMr.a(this.SNt);
    AppMethodBeat.o(10007);
  }
  
  private void init()
  {
    AppMethodBeat.i(215083);
    io.flutter.a.hwd();
    if (this.SNi != null)
    {
      io.flutter.a.hwd();
      addView(this.SNi);
    }
    for (;;)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      if (Build.VERSION.SDK_INT >= 26) {
        setImportantForAutofill(4);
      }
      AppMethodBeat.o(215083);
      return;
      if (this.SNj != null)
      {
        io.flutter.a.hwd();
        addView(this.SNj);
      }
      else
      {
        io.flutter.a.hwd();
        addView(this.SNk);
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10004);
    this.SNo.add(parama);
    AppMethodBeat.o(10004);
  }
  
  public final void a(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(215084);
    this.flutterUiDisplayListeners.add(paramb);
    AppMethodBeat.o(215084);
  }
  
  @TargetApi(24)
  public final PointerIcon atp(int paramInt)
  {
    AppMethodBeat.i(215087);
    PointerIcon localPointerIcon = PointerIcon.getSystemIcon(getContext(), paramInt);
    AppMethodBeat.o(215087);
    return localPointerIcon;
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(215091);
    this.SMp.autofill(paramSparseArray);
    AppMethodBeat.o(215091);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(215089);
    this.SNo.remove(parama);
    AppMethodBeat.o(215089);
  }
  
  public final void b(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(215085);
    this.flutterUiDisplayListeners.remove(paramb);
    AppMethodBeat.o(215085);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9993);
    if (this.wJi != null)
    {
      bool = this.wJi.platformViewsController.checkInputConnectionProxy(paramView);
      AppMethodBeat.o(9993);
      return bool;
    }
    boolean bool = super.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9993);
    return bool;
  }
  
  public final void d(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10001);
    new StringBuilder("Attaching to a FlutterEngine: ").append(parama);
    io.flutter.a.hwd();
    if (hwA())
    {
      if (parama == this.wJi)
      {
        io.flutter.a.hwd();
        AppMethodBeat.o(10001);
        return;
      }
      io.flutter.a.hwd();
      hwy();
    }
    this.wJi = parama;
    io.flutter.embedding.engine.b.a locala = this.wJi.SMr;
    this.SNn = locala.SPD;
    this.SNl.a(locala);
    locala.addIsDisplayingFlutterUiListener(this.SMD);
    if (Build.VERSION.SDK_INT >= 24) {
      this.SNp = new io.flutter.plugin.d.a(this, this.wJi.SOb);
    }
    this.SMp = new io.flutter.plugin.b.c(this, this.wJi.SOi, this.wJi.platformViewsController);
    this.localizationPlugin = this.wJi.localizationPlugin;
    this.SNq = new a(this.wJi.SMo, this.SMp);
    this.SNr = new b(this.wJi.SMr, false);
    this.SNs = new io.flutter.view.a(this, parama.SNY, (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.wJi.platformViewsController);
    this.SNs.SNu = this.SNu;
    bl(this.SNs.nC.isEnabled(), this.SNs.nC.isTouchExplorationEnabled());
    this.wJi.platformViewsController.a(this.SNs);
    this.wJi.platformViewsController.b(this.wJi.SMr);
    this.SMp.SSy.restartInput(this);
    hwB();
    this.localizationPlugin.j(getResources().getConfiguration());
    hwC();
    parama.platformViewsController.hS(this);
    parama = this.SNo.iterator();
    while (parama.hasNext()) {
      ((a)parama.next()).hrW();
    }
    if (this.SNn) {
      this.SMD.dLt();
    }
    AppMethodBeat.o(10001);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9991);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.SNt.paddingTop = paramRect.top;
      this.SNt.paddingRight = paramRect.right;
      this.SNt.paddingBottom = 0;
      this.SNt.paddingLeft = paramRect.left;
      this.SNt.SPI = 0;
      this.SNt.SPJ = 0;
      this.SNt.SPK = paramRect.bottom;
      this.SNt.SPL = 0;
      new StringBuilder("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ").append(this.SNt.paddingTop).append(", Left: ").append(this.SNt.paddingLeft).append(", Right: ").append(this.SNt.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.SNt.SPK).append(", Left: ").append(this.SNt.SPL).append(", Right: ").append(this.SNt.SPJ);
      io.flutter.a.hwd();
      hwC();
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
    if ((this.SNs != null) && (this.SNs.nC.isEnabled()))
    {
      io.flutter.view.a locala = this.SNs;
      AppMethodBeat.o(9999);
      return locala;
    }
    AppMethodBeat.o(9999);
    return null;
  }
  
  public io.flutter.embedding.engine.a getAttachedFlutterEngine()
  {
    return this.wJi;
  }
  
  public final boolean hwA()
  {
    AppMethodBeat.i(10003);
    if ((this.wJi != null) && (this.wJi.SMr == this.SNl.getAttachedRenderer()))
    {
      AppMethodBeat.o(10003);
      return true;
    }
    AppMethodBeat.o(10003);
    return false;
  }
  
  public final void hwy()
  {
    AppMethodBeat.i(10002);
    new StringBuilder("Detaching from a FlutterEngine: ").append(this.wJi);
    io.flutter.a.hwd();
    if (!hwA())
    {
      io.flutter.a.hwd();
      AppMethodBeat.o(10002);
      return;
    }
    Object localObject = this.SNo.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.wJi.platformViewsController.hxr();
    this.wJi.platformViewsController.hxq();
    this.SNs.release();
    this.SNs = null;
    this.SMp.SSy.restartInput(this);
    this.SMp.destroy();
    localObject = this.wJi.SMr;
    this.SNn = false;
    ((io.flutter.embedding.engine.b.a)localObject).removeIsDisplayingFlutterUiListener(this.SMD);
    ((io.flutter.embedding.engine.b.a)localObject).hwZ();
    ((io.flutter.embedding.engine.b.a)localObject).hxa();
    this.SNl.hwu();
    this.SNk = null;
    this.SNm = null;
    this.wJi = null;
    AppMethodBeat.o(10002);
  }
  
  public final void hwz()
  {
    AppMethodBeat.i(215088);
    this.SNl.pause();
    if (this.SNk == null)
    {
      this.SNk = new g(getContext(), getWidth(), getHeight(), g.a.SMY);
      addView(this.SNk);
    }
    for (;;)
    {
      this.SNm = this.SNl;
      this.SNl = this.SNk;
      if (this.wJi != null) {
        this.SNl.a(this.wJi.SMr);
      }
      AppMethodBeat.o(215088);
      return;
      this.SNk.mS(getWidth(), getHeight());
    }
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  @TargetApi(20)
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(215086);
    WindowInsets localWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    int j;
    int i;
    label35:
    Object localObject;
    int m;
    if ((getWindowSystemUiVisibility() & 0x4) != 0)
    {
      j = 1;
      if ((getWindowSystemUiVisibility() & 0x2) == 0) {
        break label495;
      }
      i = 1;
      localObject = d.SNF;
      if (i != 0)
      {
        localObject = getContext();
        int k = ((Context)localObject).getResources().getConfiguration().orientation;
        m = ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay().getRotation();
        if (k != 2) {
          break label549;
        }
        if (m != 1) {
          break label500;
        }
        localObject = d.SNH;
      }
      label101:
      a.b localb = this.SNt;
      if (j == 0) {
        break label557;
      }
      j = 0;
      label113:
      localb.paddingTop = j;
      localb = this.SNt;
      if ((localObject != d.SNH) && (localObject != d.SNI)) {
        break label565;
      }
      j = 0;
      label143:
      localb.paddingRight = j;
      this.SNt.paddingBottom = 0;
      localb = this.SNt;
      if ((localObject != d.SNG) && (localObject != d.SNI)) {
        break label573;
      }
      j = 0;
      label181:
      localb.paddingLeft = j;
      this.SNt.SPI = 0;
      this.SNt.SPJ = 0;
      localObject = this.SNt;
      if (i == 0) {
        break label589;
      }
      i = getRootView().getHeight();
      if (paramWindowInsets.getSystemWindowInsetBottom() >= i * 0.18D) {
        break label581;
      }
      i = 0;
    }
    for (;;)
    {
      ((a.b)localObject).SPK = i;
      this.SNt.SPL = 0;
      if (Build.VERSION.SDK_INT >= 29)
      {
        paramWindowInsets = paramWindowInsets.getSystemGestureInsets();
        this.SNt.SPM = paramWindowInsets.top;
        this.SNt.SPN = paramWindowInsets.right;
        this.SNt.SPO = paramWindowInsets.bottom;
        this.SNt.SPP = paramWindowInsets.left;
      }
      new StringBuilder("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ").append(this.SNt.paddingTop).append(", Left: ").append(this.SNt.paddingLeft).append(", Right: ").append(this.SNt.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.SNt.SPK).append(", Left: ").append(this.SNt.SPL).append(", Right: ").append(this.SNt.SPJ).append("System Gesture Insets - Left: ").append(this.SNt.SPP).append(", Top: ").append(this.SNt.SPM).append(", Right: ").append(this.SNt.SPN).append(", Bottom: ").append(this.SNt.SPK);
      io.flutter.a.hwd();
      hwC();
      AppMethodBeat.o(215086);
      return localWindowInsets;
      j = 0;
      break;
      label495:
      i = 0;
      break label35;
      label500:
      if (m == 3)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = d.SNG;
          break label101;
        }
        localObject = d.SNH;
        break label101;
      }
      if ((m == 0) || (m == 2))
      {
        localObject = d.SNI;
        break label101;
      }
      label549:
      localObject = d.SNF;
      break label101;
      label557:
      j = paramWindowInsets.getSystemWindowInsetTop();
      break label113;
      label565:
      j = paramWindowInsets.getSystemWindowInsetRight();
      break label143;
      label573:
      j = paramWindowInsets.getSystemWindowInsetLeft();
      break label181;
      label581:
      i = paramWindowInsets.getSystemWindowInsetBottom();
      continue;
      label589:
      i = paramWindowInsets.getSystemWindowInsetBottom();
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9989);
    super.onConfigurationChanged(paramConfiguration);
    if (this.wJi != null)
    {
      io.flutter.a.hwd();
      this.localizationPlugin.j(paramConfiguration);
      hwB();
    }
    AppMethodBeat.o(9989);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9992);
    if (!hwA())
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      AppMethodBeat.o(9992);
      return paramEditorInfo;
    }
    paramEditorInfo = this.SMp.a(this, paramEditorInfo);
    AppMethodBeat.o(9992);
    return paramEditorInfo;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9997);
    if ((hwA()) && (this.SNr.onGenericMotionEvent(paramMotionEvent))) {}
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
    if (!hwA())
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(9998);
      return bool;
    }
    boolean bool = this.SNs.aE(paramMotionEvent);
    AppMethodBeat.o(9998);
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9995);
    if (!hwA())
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(9995);
      return bool;
    }
    this.SNq.k(paramKeyEvent);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(9995);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9994);
    if (!hwA())
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(9994);
      return bool;
    }
    this.SNq.j(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9994);
    return bool;
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(215090);
    super.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    this.SMp.a(paramViewStructure);
    AppMethodBeat.o(215090);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9990);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    new StringBuilder("Size changed. Sending Flutter new viewport metrics. FlutterView was ").append(paramInt3).append(" x ").append(paramInt4).append(", it is now ").append(paramInt1).append(" x ").append(paramInt2);
    io.flutter.a.hwd();
    this.SNt.width = paramInt1;
    this.SNt.height = paramInt2;
    hwC();
    AppMethodBeat.o(9990);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9996);
    if (!hwA())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(9996);
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    boolean bool = this.SNr.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9996);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void hrW();
  }
  
  @Deprecated
  public static enum c
  {
    static
    {
      AppMethodBeat.i(9962);
      SNC = new c("opaque", 0);
      SND = new c("transparent", 1);
      SNE = new c[] { SNC, SND };
      AppMethodBeat.o(9962);
    }
    
    private c() {}
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(215032);
      SNF = new d("NONE", 0);
      SNG = new d("LEFT", 1);
      SNH = new d("RIGHT", 2);
      SNI = new d("BOTH", 3);
      SNJ = new d[] { SNF, SNG, SNH, SNI };
      AppMethodBeat.o(215032);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView
 * JD-Core Version:    0.7.0.1
 */