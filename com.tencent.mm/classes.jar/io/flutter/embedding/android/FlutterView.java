package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.a.b;
import io.flutter.embedding.engine.b.c;
import io.flutter.embedding.engine.c.d;
import io.flutter.embedding.engine.c.h.a;
import io.flutter.embedding.engine.c.h.b;
import io.flutter.view.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FlutterView
  extends FrameLayout
{
  private FlutterSurfaceView MYO;
  private FlutterTextureView MYP;
  private c MYQ;
  public boolean MYR;
  private final Set<a> MYS;
  private a MYT;
  private b MYU;
  private io.flutter.view.a MYV;
  private final a.b MYW;
  private final a.e MYX;
  private io.flutter.plugin.b.b MYf;
  private final io.flutter.embedding.engine.b.b MYq;
  private final Set<io.flutter.embedding.engine.b.b> flutterUiDisplayListeners;
  private io.flutter.embedding.engine.a tti;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(197930);
    AppMethodBeat.o(197930);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(197932);
    AppMethodBeat.o(197932);
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterSurfaceView paramFlutterSurfaceView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(197934);
    this.flutterUiDisplayListeners = new HashSet();
    this.MYS = new HashSet();
    this.MYW = new a.b();
    this.MYX = new a.e()
    {
      public final void bc(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.MYq = new io.flutter.embedding.engine.b.b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(197941);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cSR();
        }
        AppMethodBeat.o(197941);
      }
      
      public final void cSS()
      {
        AppMethodBeat.i(197942);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cSS();
        }
        AppMethodBeat.o(197942);
      }
    };
    this.MYO = paramFlutterSurfaceView;
    this.MYQ = paramFlutterSurfaceView;
    init();
    AppMethodBeat.o(197934);
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
    AppMethodBeat.i(197935);
    this.flutterUiDisplayListeners = new HashSet();
    this.MYS = new HashSet();
    this.MYW = new a.b();
    this.MYX = new a.e()
    {
      public final void bc(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.MYq = new io.flutter.embedding.engine.b.b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(197941);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cSR();
        }
        AppMethodBeat.o(197941);
      }
      
      public final void cSS()
      {
        AppMethodBeat.i(197942);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cSS();
        }
        AppMethodBeat.o(197942);
      }
    };
    this.MYP = paramFlutterTextureView;
    this.MYQ = this.MYO;
    init();
    AppMethodBeat.o(197935);
  }
  
  @Deprecated
  public FlutterView(Context paramContext, b paramb)
  {
    super(paramContext, null);
    AppMethodBeat.i(197931);
    this.flutterUiDisplayListeners = new HashSet();
    this.MYS = new HashSet();
    this.MYW = new a.b();
    this.MYX = new a.e()
    {
      public final void bc(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.MYq = new io.flutter.embedding.engine.b.b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(197941);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cSR();
        }
        AppMethodBeat.o(197941);
      }
      
      public final void cSS()
      {
        AppMethodBeat.i(197942);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cSS();
        }
        AppMethodBeat.o(197942);
      }
    };
    if (paramb == b.MYZ) {
      this.MYO = new FlutterSurfaceView(paramContext);
    }
    for (this.MYQ = this.MYO;; this.MYQ = this.MYP)
    {
      init();
      AppMethodBeat.o(197931);
      return;
      this.MYP = new FlutterTextureView(paramContext);
    }
  }
  
  @Deprecated
  public FlutterView(Context paramContext, b paramb, c paramc)
  {
    super(paramContext, null);
    AppMethodBeat.i(197933);
    this.flutterUiDisplayListeners = new HashSet();
    this.MYS = new HashSet();
    this.MYW = new a.b();
    this.MYX = new a.e()
    {
      public final void bc(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.MYq = new io.flutter.embedding.engine.b.b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(197941);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cSR();
        }
        AppMethodBeat.o(197941);
      }
      
      public final void cSS()
      {
        AppMethodBeat.i(197942);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.d(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cSS();
        }
        AppMethodBeat.o(197942);
      }
    };
    boolean bool;
    if (paramb == b.MYZ) {
      if (paramc == c.MZd)
      {
        bool = true;
        this.MYO = new FlutterSurfaceView(paramContext, bool);
      }
    }
    for (this.MYQ = this.MYO;; this.MYQ = this.MYP)
    {
      init();
      AppMethodBeat.o(197933);
      return;
      bool = false;
      break;
      this.MYP = new FlutterTextureView(paramContext);
    }
  }
  
  private void bb(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10000);
    if (!this.tti.MYh.MZl.nativeGetIsSoftwareRenderingEnabled())
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
  
  private void gjb()
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
    for (h.b localb = h.b.Nci;; localb = h.b.Nch)
    {
      this.tti.MZu.gjH().cl(getResources().getConfiguration().fontScale).Aj(DateFormat.is24HourFormat(getContext())).a(localb).send();
      AppMethodBeat.o(10006);
      return;
      i = 0;
      break;
    }
  }
  
  private void gjc()
  {
    AppMethodBeat.i(10007);
    if (!gja())
    {
      io.flutter.a.giG();
      AppMethodBeat.o(10007);
      return;
    }
    this.MYW.NaO = getResources().getDisplayMetrics().density;
    this.tti.MYh.a(this.MYW);
    AppMethodBeat.o(10007);
  }
  
  private void init()
  {
    AppMethodBeat.i(197936);
    io.flutter.a.giD();
    if (this.MYO != null)
    {
      io.flutter.a.giD();
      addView(this.MYO);
    }
    for (;;)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      AppMethodBeat.o(197936);
      return;
      io.flutter.a.giD();
      addView(this.MYP);
    }
  }
  
  private void j(Configuration paramConfiguration)
  {
    AppMethodBeat.i(10005);
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramConfiguration = paramConfiguration.getLocales();
      int j = paramConfiguration.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramConfiguration.get(i));
        i += 1;
      }
    }
    localArrayList.add(paramConfiguration.locale);
    this.tti.MZq.jf(localArrayList);
    AppMethodBeat.o(10005);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10004);
    this.MYS.add(parama);
    AppMethodBeat.o(10004);
  }
  
  public final void a(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(197937);
    this.flutterUiDisplayListeners.add(paramb);
    AppMethodBeat.o(197937);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(197940);
    this.MYS.remove(parama);
    AppMethodBeat.o(197940);
  }
  
  public final void b(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(197938);
    this.flutterUiDisplayListeners.remove(paramb);
    AppMethodBeat.o(197938);
  }
  
  public final void c(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10001);
    new StringBuilder("Attaching to a FlutterEngine: ").append(parama);
    io.flutter.a.giD();
    if (gja())
    {
      if (parama == this.tti)
      {
        io.flutter.a.giD();
        AppMethodBeat.o(10001);
        return;
      }
      io.flutter.a.giD();
      giZ();
    }
    this.tti = parama;
    io.flutter.embedding.engine.b.a locala = this.tti.MYh;
    this.MYR = locala.NaJ;
    this.MYQ.a(locala);
    locala.addIsDisplayingFlutterUiListener(this.MYq);
    this.MYf = new io.flutter.plugin.b.b(this, this.tti.MZm, this.tti.MZx);
    this.MYT = new a(this.tti.MYe, this.MYf);
    this.MYU = new b(this.tti.MYh);
    this.MYV = new io.flutter.view.a(this, parama.MZo, (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.tti.MZx);
    this.MYV.MYX = this.MYX;
    bb(this.MYV.nA.isEnabled(), this.MYV.nA.isTouchExplorationEnabled());
    this.tti.MZx.a(this.MYV);
    this.MYf.Ndn.restartInput(this);
    gjb();
    j(getResources().getConfiguration());
    gjc();
    parama.MZx.hz(this);
    parama = this.MYS.iterator();
    while (parama.hasNext()) {
      ((a)parama.next()).gdF();
    }
    if (this.MYR) {
      this.MYq.cSR();
    }
    AppMethodBeat.o(10001);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9993);
    if (this.tti != null)
    {
      bool = this.tti.MZx.checkInputConnectionProxy(paramView);
      AppMethodBeat.o(9993);
      return bool;
    }
    boolean bool = super.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9993);
    return bool;
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9991);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.MYW.paddingTop = paramRect.top;
      this.MYW.paddingRight = paramRect.right;
      this.MYW.paddingBottom = 0;
      this.MYW.paddingLeft = paramRect.left;
      this.MYW.NaP = 0;
      this.MYW.NaQ = 0;
      this.MYW.NaR = paramRect.bottom;
      this.MYW.NaS = 0;
      new StringBuilder("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ").append(this.MYW.paddingTop).append(", Left: ").append(this.MYW.paddingLeft).append(", Right: ").append(this.MYW.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.MYW.NaR).append(", Left: ").append(this.MYW.NaS).append(", Right: ").append(this.MYW.NaQ);
      io.flutter.a.giD();
      gjc();
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
    if ((this.MYV != null) && (this.MYV.nA.isEnabled()))
    {
      io.flutter.view.a locala = this.MYV;
      AppMethodBeat.o(9999);
      return locala;
    }
    AppMethodBeat.o(9999);
    return null;
  }
  
  public io.flutter.embedding.engine.a getAttachedFlutterEngine()
  {
    return this.tti;
  }
  
  public final void giZ()
  {
    AppMethodBeat.i(10002);
    new StringBuilder("Detaching from a FlutterEngine: ").append(this.tti);
    io.flutter.a.giD();
    if (!gja())
    {
      io.flutter.a.giD();
      AppMethodBeat.o(10002);
      return;
    }
    Object localObject = this.MYS.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.tti.MZx.gjO();
    this.tti.MZx.gjN();
    this.MYV.release();
    this.MYV = null;
    this.MYf.Ndn.restartInput(this);
    this.MYf.MZx.MYf = null;
    localObject = this.tti.MYh;
    this.MYR = false;
    ((io.flutter.embedding.engine.b.a)localObject).removeIsDisplayingFlutterUiListener(this.MYq);
    ((io.flutter.embedding.engine.b.a)localObject).gjx();
    ((io.flutter.embedding.engine.b.a)localObject).gjy();
    this.MYQ.giW();
    this.tti = null;
    AppMethodBeat.o(10002);
  }
  
  public final boolean gja()
  {
    AppMethodBeat.i(10003);
    if ((this.tti != null) && (this.tti.MYh == this.MYQ.getAttachedRenderer()))
    {
      AppMethodBeat.o(10003);
      return true;
    }
    AppMethodBeat.o(10003);
    return false;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  @TargetApi(20)
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(197939);
    WindowInsets localWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    this.MYW.paddingTop = paramWindowInsets.getSystemWindowInsetTop();
    this.MYW.paddingRight = paramWindowInsets.getSystemWindowInsetRight();
    this.MYW.paddingBottom = 0;
    this.MYW.paddingLeft = paramWindowInsets.getSystemWindowInsetLeft();
    this.MYW.NaP = 0;
    this.MYW.NaQ = 0;
    this.MYW.NaR = paramWindowInsets.getSystemWindowInsetBottom();
    this.MYW.NaS = 0;
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramWindowInsets = paramWindowInsets.getSystemGestureInsets();
      this.MYW.NaT = paramWindowInsets.top;
      this.MYW.NaU = paramWindowInsets.right;
      this.MYW.NaV = paramWindowInsets.bottom;
      this.MYW.NaW = paramWindowInsets.left;
    }
    new StringBuilder("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ").append(this.MYW.paddingTop).append(", Left: ").append(this.MYW.paddingLeft).append(", Right: ").append(this.MYW.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.MYW.NaR).append(", Left: ").append(this.MYW.NaS).append(", Right: ").append(this.MYW.NaQ).append("System Gesture Insets - Left: ").append(this.MYW.NaW).append(", Top: ").append(this.MYW.NaT).append(", Right: ").append(this.MYW.NaU).append(", Bottom: ").append(this.MYW.NaR);
    io.flutter.a.giD();
    gjc();
    AppMethodBeat.o(197939);
    return localWindowInsets;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9989);
    super.onConfigurationChanged(paramConfiguration);
    if (this.tti != null)
    {
      io.flutter.a.giD();
      j(paramConfiguration);
      gjb();
    }
    AppMethodBeat.o(9989);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9992);
    if (!gja())
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      AppMethodBeat.o(9992);
      return paramEditorInfo;
    }
    paramEditorInfo = this.MYf.a(this, paramEditorInfo);
    AppMethodBeat.o(9992);
    return paramEditorInfo;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9997);
    if ((gja()) && (this.MYU.onGenericMotionEvent(paramMotionEvent))) {}
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
    if (!gja())
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(9998);
      return bool;
    }
    boolean bool = this.MYV.an(paramMotionEvent);
    AppMethodBeat.o(9998);
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9995);
    if (!gja())
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(9995);
      return bool;
    }
    this.MYT.j(paramKeyEvent);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(9995);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9994);
    if (!gja())
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(9994);
      return bool;
    }
    this.MYT.i(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9994);
    return bool;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9990);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    new StringBuilder("Size changed. Sending Flutter new viewport metrics. FlutterView was ").append(paramInt3).append(" x ").append(paramInt4).append(", it is now ").append(paramInt1).append(" x ").append(paramInt2);
    io.flutter.a.giD();
    this.MYW.width = paramInt1;
    this.MYW.height = paramInt2;
    gjc();
    AppMethodBeat.o(9990);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9996);
    if (!gja())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(9996);
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    boolean bool = this.MYU.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9996);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void gdF();
  }
  
  @Deprecated
  public static enum b
  {
    static
    {
      AppMethodBeat.i(10024);
      MYZ = new b("surface", 0);
      MZa = new b("texture", 1);
      MZb = new b[] { MYZ, MZa };
      AppMethodBeat.o(10024);
    }
    
    private b() {}
  }
  
  @Deprecated
  public static enum c
  {
    static
    {
      AppMethodBeat.i(9962);
      MZc = new c("opaque", 0);
      MZd = new c("transparent", 1);
      MZe = new c[] { MZc, MZd };
      AppMethodBeat.o(9962);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView
 * JD-Core Version:    0.7.0.1
 */