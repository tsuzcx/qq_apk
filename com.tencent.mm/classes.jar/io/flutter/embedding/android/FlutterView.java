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
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.k;
import io.flutter.embedding.engine.b.k.a;
import io.flutter.embedding.engine.b.k.b;
import io.flutter.embedding.engine.renderer.a.b;
import io.flutter.embedding.engine.renderer.c;
import io.flutter.plugin.c.a.a;
import io.flutter.plugin.editing.d;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.a.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FlutterView
  extends FrameLayout
  implements a.a
{
  public io.flutter.embedding.engine.a BCx;
  private final io.flutter.embedding.engine.renderer.b aaoE;
  private d aaoo;
  private FlutterSurfaceView aapg;
  private FlutterTextureView aaph;
  public FlutterImageView aapi;
  private c aapj;
  private c aapk;
  public boolean aapl;
  private final Set<a> aapm;
  private io.flutter.plugin.c.a aapn;
  private a aapo;
  private b aapp;
  private io.flutter.view.a aapq;
  private final a.b aapr;
  private final a.e aaps;
  private final Set<io.flutter.embedding.engine.renderer.b> flutterUiDisplayListeners;
  private io.flutter.plugin.b.a localizationPlugin;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(253421);
    AppMethodBeat.o(253421);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(253426);
    AppMethodBeat.o(253426);
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterSurfaceView paramFlutterSurfaceView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(253431);
    this.flutterUiDisplayListeners = new HashSet();
    this.aapm = new HashSet();
    this.aapr = new a.b();
    this.aaps = new a.e()
    {
      public final void bw(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.aaoE = new io.flutter.embedding.engine.renderer.b()
    {
      public final void epX()
      {
        AppMethodBeat.i(255388);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.renderer.b)localIterator.next()).epX();
        }
        AppMethodBeat.o(255388);
      }
      
      public final void epY()
      {
        AppMethodBeat.i(255390);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.renderer.b)localIterator.next()).epY();
        }
        AppMethodBeat.o(255390);
      }
    };
    this.aapg = paramFlutterSurfaceView;
    this.aapj = paramFlutterSurfaceView;
    init();
    AppMethodBeat.o(253431);
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
    AppMethodBeat.i(253433);
    this.flutterUiDisplayListeners = new HashSet();
    this.aapm = new HashSet();
    this.aapr = new a.b();
    this.aaps = new a.e()
    {
      public final void bw(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.aaoE = new io.flutter.embedding.engine.renderer.b()
    {
      public final void epX()
      {
        AppMethodBeat.i(255388);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.renderer.b)localIterator.next()).epX();
        }
        AppMethodBeat.o(255388);
      }
      
      public final void epY()
      {
        AppMethodBeat.i(255390);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.renderer.b)localIterator.next()).epY();
        }
        AppMethodBeat.o(255390);
      }
    };
    this.aaph = paramFlutterTextureView;
    this.aapj = paramFlutterTextureView;
    init();
    AppMethodBeat.o(253433);
  }
  
  @Deprecated
  public FlutterView(Context paramContext, FlutterView.b paramb, FlutterView.c paramc)
  {
    super(paramContext, null);
    AppMethodBeat.i(253429);
    this.flutterUiDisplayListeners = new HashSet();
    this.aapm = new HashSet();
    this.aapr = new a.b();
    this.aaps = new a.e()
    {
      public final void bw(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.aaoE = new io.flutter.embedding.engine.renderer.b()
    {
      public final void epX()
      {
        AppMethodBeat.i(255388);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.renderer.b)localIterator.next()).epX();
        }
        AppMethodBeat.o(255388);
      }
      
      public final void epY()
      {
        AppMethodBeat.i(255390);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.renderer.b)localIterator.next()).epY();
        }
        AppMethodBeat.o(255390);
      }
    };
    if (paramb == FlutterView.b.aapw) {
      if (paramc == FlutterView.c.aapB) {
        this.aapg = new FlutterSurfaceView(paramContext, bool);
      }
    }
    for (this.aapj = this.aapg;; this.aapj = this.aaph)
    {
      init();
      AppMethodBeat.o(253429);
      return;
      bool = false;
      break;
      if (paramb != FlutterView.b.aapx) {
        break label153;
      }
      this.aaph = new FlutterTextureView(paramContext);
    }
    label153:
    paramContext = new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[] { paramb }));
    AppMethodBeat.o(253429);
    throw paramContext;
  }
  
  @Deprecated
  public FlutterView(Context paramContext, FlutterView.c paramc) {}
  
  private void bv(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10000);
    if (!this.BCx.aaos.aapT.getIsSoftwareRenderingEnabled())
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
  
  @TargetApi(20)
  private int c(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(253441);
    int i = getRootView().getHeight();
    if (paramWindowInsets.getSystemWindowInsetBottom() < i * 0.18D)
    {
      AppMethodBeat.o(253441);
      return 0;
    }
    i = paramWindowInsets.getSystemWindowInsetBottom();
    AppMethodBeat.o(253441);
    return i;
  }
  
  private void iAF()
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
    for (k.b localb = k.b.aatL;; localb = k.b.aatK)
    {
      this.BCx.aaqe.iBk().dl(getResources().getConfiguration().fontScale).Jc(DateFormat.is24HourFormat(getContext())).a(localb).gOA();
      AppMethodBeat.o(10006);
      return;
      i = 0;
      break;
    }
  }
  
  private void iAG()
  {
    AppMethodBeat.i(10007);
    if (!iAE())
    {
      io.flutter.b.iAf();
      AppMethodBeat.o(10007);
      return;
    }
    this.aapr.aarY = getResources().getDisplayMetrics().density;
    this.BCx.aaos.a(this.aapr);
    AppMethodBeat.o(10007);
  }
  
  private void init()
  {
    AppMethodBeat.i(253434);
    io.flutter.b.iAd();
    if (this.aapg != null)
    {
      io.flutter.b.iAd();
      addView(this.aapg);
    }
    for (;;)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      if (Build.VERSION.SDK_INT >= 26) {
        setImportantForAutofill(4);
      }
      AppMethodBeat.o(253434);
      return;
      if (this.aaph != null)
      {
        io.flutter.b.iAd();
        addView(this.aaph);
      }
      else
      {
        io.flutter.b.iAd();
        addView(this.aapi);
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10004);
    this.aapm.add(parama);
    AppMethodBeat.o(10004);
  }
  
  public final void a(io.flutter.embedding.engine.renderer.b paramb)
  {
    AppMethodBeat.i(253436);
    this.flutterUiDisplayListeners.add(paramb);
    AppMethodBeat.o(253436);
  }
  
  @TargetApi(24)
  public final PointerIcon aDk(int paramInt)
  {
    AppMethodBeat.i(253451);
    PointerIcon localPointerIcon = PointerIcon.getSystemIcon(getContext(), paramInt);
    AppMethodBeat.o(253451);
    return localPointerIcon;
  }
  
  public void autofill(SparseArray<AutofillValue> paramSparseArray)
  {
    AppMethodBeat.i(253459);
    this.aaoo.autofill(paramSparseArray);
    AppMethodBeat.o(253459);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(253455);
    this.aapm.remove(parama);
    AppMethodBeat.o(253455);
  }
  
  public final void b(io.flutter.embedding.engine.renderer.b paramb)
  {
    AppMethodBeat.i(253438);
    this.flutterUiDisplayListeners.remove(paramb);
    AppMethodBeat.o(253438);
  }
  
  public final void bk(final Runnable paramRunnable)
  {
    AppMethodBeat.i(253453);
    if (this.aapi == null)
    {
      io.flutter.b.iAd();
      AppMethodBeat.o(253453);
      return;
    }
    if (this.aapk == null)
    {
      io.flutter.b.iAd();
      AppMethodBeat.o(253453);
      return;
    }
    this.aapj = this.aapk;
    this.aapk = null;
    if (this.BCx == null)
    {
      this.aapi.iAz();
      paramRunnable.run();
      AppMethodBeat.o(253453);
      return;
    }
    final io.flutter.embedding.engine.renderer.a locala = this.BCx.aaos;
    if (locala == null)
    {
      this.aapi.iAz();
      paramRunnable.run();
      AppMethodBeat.o(253453);
      return;
    }
    this.aapj.a(locala);
    locala.addIsDisplayingFlutterUiListener(new io.flutter.embedding.engine.renderer.b()
    {
      public final void epX()
      {
        AppMethodBeat.i(255954);
        locala.removeIsDisplayingFlutterUiListener(this);
        paramRunnable.run();
        FlutterView.e(FlutterView.this).iAz();
        AppMethodBeat.o(255954);
      }
      
      public final void epY() {}
    });
    AppMethodBeat.o(253453);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9993);
    if (this.BCx != null)
    {
      bool = this.BCx.platformViewsController.checkInputConnectionProxy(paramView);
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
    io.flutter.b.iAd();
    if (iAE())
    {
      if (parama == this.BCx)
      {
        io.flutter.b.iAd();
        AppMethodBeat.o(10001);
        return;
      }
      io.flutter.b.iAd();
      iAm();
    }
    this.BCx = parama;
    io.flutter.embedding.engine.renderer.a locala = this.BCx.aaos;
    this.aapl = locala.aarT;
    this.aapj.a(locala);
    locala.addIsDisplayingFlutterUiListener(this.aaoE);
    if (Build.VERSION.SDK_INT >= 24) {
      this.aapn = new io.flutter.plugin.c.a(this, this.BCx.aaqa);
    }
    this.aaoo = new d(this, this.BCx.aaqg, this.BCx.platformViewsController);
    this.localizationPlugin = this.BCx.localizationPlugin;
    this.aapo = new a(this, this.BCx.aaon, this.aaoo);
    this.aapp = new b(this.BCx.aaos, false);
    this.aapq = new io.flutter.view.a(this, parama.aapW, (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.BCx.platformViewsController);
    this.aapq.aaps = this.aaps;
    bv(this.aapq.bEA.isEnabled(), this.aapq.bEA.isTouchExplorationEnabled());
    this.BCx.platformViewsController.a(this.aapq);
    this.BCx.platformViewsController.c(this.BCx.aaos);
    this.aaoo.aavc.restartInput(this);
    iAF();
    this.localizationPlugin.i(getResources().getConfiguration());
    iAG();
    parama.platformViewsController.jm(this);
    parama = this.aapm.iterator();
    while (parama.hasNext()) {
      ((a)parama.next()).ivI();
    }
    if (this.aapl) {
      this.aaoE.epX();
    }
    AppMethodBeat.o(10001);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(253449);
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0)) {
      getKeyDispatcherState().startTracking(paramKeyEvent, this);
    }
    while (((iAE()) && (this.aapo.j(paramKeyEvent))) || (super.dispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(253449);
      return true;
      if (paramKeyEvent.getAction() == 1) {
        getKeyDispatcherState().handleUpEvent(paramKeyEvent);
      }
    }
    AppMethodBeat.o(253449);
    return false;
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9991);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.aapr.aarZ = paramRect.top;
      this.aapr.aasa = paramRect.right;
      this.aapr.aasb = 0;
      this.aapr.aasc = paramRect.left;
      this.aapr.aasd = 0;
      this.aapr.aase = 0;
      this.aapr.aasf = paramRect.bottom;
      this.aapr.aasg = 0;
      new StringBuilder("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ").append(this.aapr.aarZ).append(", Left: ").append(this.aapr.aasc).append(", Right: ").append(this.aapr.aasa).append("\nKeyboard insets: Bottom: ").append(this.aapr.aasf).append(", Left: ").append(this.aapr.aasg).append(", Right: ").append(this.aapr.aase);
      io.flutter.b.iAd();
      iAG();
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
    if ((this.aapq != null) && (this.aapq.bEA.isEnabled()))
    {
      io.flutter.view.a locala = this.aapq;
      AppMethodBeat.o(9999);
      return locala;
    }
    AppMethodBeat.o(9999);
    return null;
  }
  
  public io.flutter.embedding.engine.a getAttachedFlutterEngine()
  {
    return this.BCx;
  }
  
  public final void iAD()
  {
    AppMethodBeat.i(253452);
    this.aapj.pause();
    if (this.aapi == null)
    {
      this.aapi = new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.a.aaoW);
      addView(this.aapi);
    }
    for (;;)
    {
      this.aapk = this.aapj;
      this.aapj = this.aapi;
      if (this.BCx != null) {
        this.aapj.a(this.BCx.aaos);
      }
      AppMethodBeat.o(253452);
      return;
      this.aapi.ok(getWidth(), getHeight());
    }
  }
  
  public final boolean iAE()
  {
    AppMethodBeat.i(10003);
    if ((this.BCx != null) && (this.BCx.aaos == this.aapj.getAttachedRenderer()))
    {
      AppMethodBeat.o(10003);
      return true;
    }
    AppMethodBeat.o(10003);
    return false;
  }
  
  public final void iAm()
  {
    AppMethodBeat.i(10002);
    new StringBuilder("Detaching from a FlutterEngine: ").append(this.BCx);
    io.flutter.b.iAd();
    if (!iAE())
    {
      io.flutter.b.iAd();
      AppMethodBeat.o(10002);
      return;
    }
    Object localObject = this.aapm.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.BCx.platformViewsController.iBv();
    this.BCx.platformViewsController.iBu();
    this.aapq.release();
    this.aapq = null;
    this.aaoo.aavc.restartInput(this);
    this.aaoo.destroy();
    this.aapo.destroy();
    if (this.aapn != null) {
      this.aapn.destroy();
    }
    localObject = this.BCx.aaos;
    this.aapl = false;
    ((io.flutter.embedding.engine.renderer.a)localObject).removeIsDisplayingFlutterUiListener(this.aaoE);
    ((io.flutter.embedding.engine.renderer.a)localObject).iBb();
    ((io.flutter.embedding.engine.renderer.a)localObject).iBc();
    this.aapj.iAz();
    this.aapi = null;
    this.aapk = null;
    this.BCx = null;
    AppMethodBeat.o(10002);
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  @TargetApi(20)
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(253445);
    WindowInsets localWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    Object localObject;
    if (Build.VERSION.SDK_INT == 29)
    {
      localObject = paramWindowInsets.getSystemGestureInsets();
      this.aapr.aash = ((Insets)localObject).top;
      this.aapr.aasi = ((Insets)localObject).right;
      this.aapr.aasj = ((Insets)localObject).bottom;
      this.aapr.aask = ((Insets)localObject).left;
    }
    int j;
    if ((getWindowSystemUiVisibility() & 0x4) == 0)
    {
      j = 1;
      if ((getWindowSystemUiVisibility() & 0x2) != 0) {
        break label616;
      }
      i = 1;
      label97:
      if (Build.VERSION.SDK_INT < 30) {
        break label621;
      }
      if (i == 0) {
        break label919;
      }
    }
    label898:
    label906:
    label911:
    label919:
    for (int i = WindowInsets.Type.navigationBars() | 0x0;; i = 0)
    {
      int k = i;
      if (j != 0) {
        k = i | WindowInsets.Type.statusBars();
      }
      localObject = paramWindowInsets.getInsets(k);
      this.aapr.aarZ = ((Insets)localObject).top;
      this.aapr.aasa = ((Insets)localObject).right;
      this.aapr.aasb = ((Insets)localObject).bottom;
      this.aapr.aasc = ((Insets)localObject).left;
      localObject = paramWindowInsets.getInsets(WindowInsets.Type.ime());
      this.aapr.aasd = ((Insets)localObject).top;
      this.aapr.aase = ((Insets)localObject).right;
      this.aapr.aasf = ((Insets)localObject).bottom;
      this.aapr.aasg = ((Insets)localObject).left;
      localObject = paramWindowInsets.getInsets(WindowInsets.Type.systemGestures());
      this.aapr.aash = ((Insets)localObject).top;
      this.aapr.aasi = ((Insets)localObject).right;
      this.aapr.aasj = ((Insets)localObject).bottom;
      this.aapr.aask = ((Insets)localObject).left;
      paramWindowInsets = paramWindowInsets.getDisplayCutout();
      if (paramWindowInsets != null)
      {
        localObject = paramWindowInsets.getWaterfallInsets();
        this.aapr.aarZ = Math.max(Math.max(this.aapr.aarZ, ((Insets)localObject).top), paramWindowInsets.getSafeInsetTop());
        this.aapr.aasa = Math.max(Math.max(this.aapr.aasa, ((Insets)localObject).right), paramWindowInsets.getSafeInsetRight());
        this.aapr.aasb = Math.max(Math.max(this.aapr.aasb, ((Insets)localObject).bottom), paramWindowInsets.getSafeInsetBottom());
        this.aapr.aasc = Math.max(Math.max(this.aapr.aasc, ((Insets)localObject).left), paramWindowInsets.getSafeInsetLeft());
      }
      new StringBuilder("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ").append(this.aapr.aarZ).append(", Left: ").append(this.aapr.aasc).append(", Right: ").append(this.aapr.aasa).append("\nKeyboard insets: Bottom: ").append(this.aapr.aasf).append(", Left: ").append(this.aapr.aasg).append(", Right: ").append(this.aapr.aase).append("System Gesture Insets - Left: ").append(this.aapr.aask).append(", Top: ").append(this.aapr.aash).append(", Right: ").append(this.aapr.aasi).append(", Bottom: ").append(this.aapr.aasf);
      io.flutter.b.iAd();
      iAG();
      AppMethodBeat.o(253445);
      return localWindowInsets;
      j = 0;
      break;
      label616:
      i = 0;
      break label97;
      label621:
      localObject = FlutterView.d.aapD;
      int m;
      label687:
      a.b localb;
      if (i == 0)
      {
        localObject = getContext();
        k = ((Context)localObject).getResources().getConfiguration().orientation;
        m = ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay().getRotation();
        if (k != 2) {
          break label885;
        }
        if (m == 1) {
          localObject = FlutterView.d.aapF;
        }
      }
      else
      {
        localb = this.aapr;
        if (j == 0) {
          break label893;
        }
        j = paramWindowInsets.getSystemWindowInsetTop();
        label702:
        localb.aarZ = j;
        localb = this.aapr;
        if ((localObject != FlutterView.d.aapF) && (localObject != FlutterView.d.aapG)) {
          break label898;
        }
        j = 0;
        label732:
        localb.aasa = j;
        localb = this.aapr;
        if ((i == 0) || (c(paramWindowInsets) != 0)) {
          break label906;
        }
        i = paramWindowInsets.getSystemWindowInsetBottom();
        label761:
        localb.aasb = i;
        localb = this.aapr;
        if ((localObject != FlutterView.d.aapE) && (localObject != FlutterView.d.aapG)) {
          break label911;
        }
      }
      for (i = 0;; i = paramWindowInsets.getSystemWindowInsetLeft())
      {
        localb.aasc = i;
        this.aapr.aasd = 0;
        this.aapr.aase = 0;
        this.aapr.aasf = c(paramWindowInsets);
        this.aapr.aasg = 0;
        break;
        if (m == 3)
        {
          if (Build.VERSION.SDK_INT >= 23)
          {
            localObject = FlutterView.d.aapE;
            break label687;
          }
          localObject = FlutterView.d.aapF;
          break label687;
        }
        if ((m == 0) || (m == 2))
        {
          localObject = FlutterView.d.aapG;
          break label687;
        }
        label885:
        localObject = FlutterView.d.aapD;
        break label687;
        label893:
        j = 0;
        break label702;
        j = paramWindowInsets.getSystemWindowInsetRight();
        break label732;
        i = 0;
        break label761;
      }
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9989);
    super.onConfigurationChanged(paramConfiguration);
    if (this.BCx != null)
    {
      io.flutter.b.iAd();
      this.localizationPlugin.i(paramConfiguration);
      iAF();
    }
    AppMethodBeat.o(9989);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9992);
    if (!iAE())
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      AppMethodBeat.o(9992);
      return paramEditorInfo;
    }
    paramEditorInfo = this.aaoo.a(this, paramEditorInfo);
    AppMethodBeat.o(9992);
    return paramEditorInfo;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9997);
    if ((iAE()) && (this.aapp.onGenericMotionEvent(paramMotionEvent))) {}
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
    if (!iAE())
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(9998);
      return bool;
    }
    boolean bool = this.aapq.aM(paramMotionEvent);
    AppMethodBeat.o(9998);
    return bool;
  }
  
  public void onProvideAutofillVirtualStructure(ViewStructure paramViewStructure, int paramInt)
  {
    AppMethodBeat.i(253458);
    super.onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    this.aaoo.a(paramViewStructure);
    AppMethodBeat.o(253458);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9990);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    new StringBuilder("Size changed. Sending Flutter new viewport metrics. FlutterView was ").append(paramInt3).append(" x ").append(paramInt4).append(", it is now ").append(paramInt1).append(" x ").append(paramInt2);
    io.flutter.b.iAd();
    this.aapr.width = paramInt1;
    this.aapr.height = paramInt2;
    iAG();
    AppMethodBeat.o(9990);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9996);
    if (!iAE())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(9996);
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    boolean bool = this.aapp.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9996);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void ivI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView
 * JD-Core Version:    0.7.0.1
 */