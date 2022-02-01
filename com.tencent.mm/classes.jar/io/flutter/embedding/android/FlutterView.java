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
  private FlutterSurfaceView MBJ;
  private FlutterTextureView MBK;
  private c MBL;
  public boolean MBM;
  private final Set<a> MBN;
  private a MBO;
  private b MBP;
  private io.flutter.view.a MBQ;
  private final a.b MBR;
  private final a.e MBS;
  private io.flutter.plugin.b.b MBa;
  private final io.flutter.embedding.engine.b.b MBl;
  private final Set<io.flutter.embedding.engine.b.b> flutterUiDisplayListeners;
  private io.flutter.embedding.engine.a tiq;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(213348);
    AppMethodBeat.o(213348);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, new FlutterSurfaceView(paramContext));
    AppMethodBeat.i(213350);
    AppMethodBeat.o(213350);
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterSurfaceView paramFlutterSurfaceView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(213352);
    this.flutterUiDisplayListeners = new HashSet();
    this.MBN = new HashSet();
    this.MBR = new a.b();
    this.MBS = new a.e()
    {
      public final void bd(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.MBl = new io.flutter.embedding.engine.b.b()
    {
      public final void cQm()
      {
        AppMethodBeat.i(213359);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cQm();
        }
        AppMethodBeat.o(213359);
      }
      
      public final void cQn()
      {
        AppMethodBeat.i(213360);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cQn();
        }
        AppMethodBeat.o(213360);
      }
    };
    this.MBJ = paramFlutterSurfaceView;
    this.MBL = paramFlutterSurfaceView;
    init();
    AppMethodBeat.o(213352);
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
    AppMethodBeat.i(213353);
    this.flutterUiDisplayListeners = new HashSet();
    this.MBN = new HashSet();
    this.MBR = new a.b();
    this.MBS = new a.e()
    {
      public final void bd(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.MBl = new io.flutter.embedding.engine.b.b()
    {
      public final void cQm()
      {
        AppMethodBeat.i(213359);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cQm();
        }
        AppMethodBeat.o(213359);
      }
      
      public final void cQn()
      {
        AppMethodBeat.i(213360);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cQn();
        }
        AppMethodBeat.o(213360);
      }
    };
    this.MBK = paramFlutterTextureView;
    this.MBL = this.MBJ;
    init();
    AppMethodBeat.o(213353);
  }
  
  @Deprecated
  public FlutterView(Context paramContext, FlutterView.b paramb)
  {
    super(paramContext, null);
    AppMethodBeat.i(213349);
    this.flutterUiDisplayListeners = new HashSet();
    this.MBN = new HashSet();
    this.MBR = new a.b();
    this.MBS = new a.e()
    {
      public final void bd(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.MBl = new io.flutter.embedding.engine.b.b()
    {
      public final void cQm()
      {
        AppMethodBeat.i(213359);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cQm();
        }
        AppMethodBeat.o(213359);
      }
      
      public final void cQn()
      {
        AppMethodBeat.i(213360);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cQn();
        }
        AppMethodBeat.o(213360);
      }
    };
    if (paramb == FlutterView.b.MBU) {
      this.MBJ = new FlutterSurfaceView(paramContext);
    }
    for (this.MBL = this.MBJ;; this.MBL = this.MBK)
    {
      init();
      AppMethodBeat.o(213349);
      return;
      this.MBK = new FlutterTextureView(paramContext);
    }
  }
  
  @Deprecated
  public FlutterView(Context paramContext, FlutterView.b paramb, FlutterView.c paramc)
  {
    super(paramContext, null);
    AppMethodBeat.i(213351);
    this.flutterUiDisplayListeners = new HashSet();
    this.MBN = new HashSet();
    this.MBR = new a.b();
    this.MBS = new a.e()
    {
      public final void bd(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.MBl = new io.flutter.embedding.engine.b.b()
    {
      public final void cQm()
      {
        AppMethodBeat.i(213359);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cQm();
        }
        AppMethodBeat.o(213359);
      }
      
      public final void cQn()
      {
        AppMethodBeat.i(213360);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cQn();
        }
        AppMethodBeat.o(213360);
      }
    };
    boolean bool;
    if (paramb == FlutterView.b.MBU) {
      if (paramc == FlutterView.c.MBY)
      {
        bool = true;
        this.MBJ = new FlutterSurfaceView(paramContext, bool);
      }
    }
    for (this.MBL = this.MBJ;; this.MBL = this.MBK)
    {
      init();
      AppMethodBeat.o(213351);
      return;
      bool = false;
      break;
      this.MBK = new FlutterTextureView(paramContext);
    }
  }
  
  private void bc(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10000);
    if (!this.tiq.MBc.MCg.nativeGetIsSoftwareRenderingEnabled())
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
  
  private void geA()
  {
    AppMethodBeat.i(10007);
    if (!gey())
    {
      io.flutter.a.ged();
      AppMethodBeat.o(10007);
      return;
    }
    this.MBR.MDI = getResources().getDisplayMetrics().density;
    this.tiq.MBc.a(this.MBR);
    AppMethodBeat.o(10007);
  }
  
  private void gez()
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
    for (h.b localb = h.b.MFc;; localb = h.b.MFb)
    {
      this.tiq.MCp.gff().cn(getResources().getConfiguration().fontScale).zW(DateFormat.is24HourFormat(getContext())).a(localb).send();
      AppMethodBeat.o(10006);
      return;
      i = 0;
      break;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(213354);
    io.flutter.a.gea();
    if (this.MBJ != null)
    {
      io.flutter.a.gea();
      addView(this.MBJ);
    }
    for (;;)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      AppMethodBeat.o(213354);
      return;
      io.flutter.a.gea();
      addView(this.MBK);
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
    this.tiq.MCl.iW(localArrayList);
    AppMethodBeat.o(10005);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10004);
    this.MBN.add(parama);
    AppMethodBeat.o(10004);
  }
  
  public final void a(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(213355);
    this.flutterUiDisplayListeners.add(paramb);
    AppMethodBeat.o(213355);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(213358);
    this.MBN.remove(parama);
    AppMethodBeat.o(213358);
  }
  
  public final void b(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(213356);
    this.flutterUiDisplayListeners.remove(paramb);
    AppMethodBeat.o(213356);
  }
  
  public final void c(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10001);
    new StringBuilder("Attaching to a FlutterEngine: ").append(parama);
    io.flutter.a.gea();
    if (gey())
    {
      if (parama == this.tiq)
      {
        io.flutter.a.gea();
        AppMethodBeat.o(10001);
        return;
      }
      io.flutter.a.gea();
      gex();
    }
    this.tiq = parama;
    io.flutter.embedding.engine.b.a locala = this.tiq.MBc;
    this.MBM = locala.MDE;
    this.MBL.a(locala);
    locala.addIsDisplayingFlutterUiListener(this.MBl);
    this.MBa = new io.flutter.plugin.b.b(this, this.tiq.MCh, this.tiq.MCs);
    this.MBO = new a(this.tiq.MAZ, this.MBa);
    this.MBP = new b(this.tiq.MBc);
    this.MBQ = new io.flutter.view.a(this, parama.MCj, (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.tiq.MCs);
    this.MBQ.MBS = this.MBS;
    bc(this.MBQ.nA.isEnabled(), this.MBQ.nA.isTouchExplorationEnabled());
    this.tiq.MCs.a(this.MBQ);
    this.MBa.MGi.restartInput(this);
    gez();
    j(getResources().getConfiguration());
    geA();
    parama.MCs.hu(this);
    parama = this.MBN.iterator();
    while (parama.hasNext()) {
      ((a)parama.next()).fZe();
    }
    if (this.MBM) {
      this.MBl.cQm();
    }
    AppMethodBeat.o(10001);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9993);
    if (this.tiq != null)
    {
      bool = this.tiq.MCs.checkInputConnectionProxy(paramView);
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
      this.MBR.paddingTop = paramRect.top;
      this.MBR.paddingRight = paramRect.right;
      this.MBR.paddingBottom = 0;
      this.MBR.paddingLeft = paramRect.left;
      this.MBR.MDJ = 0;
      this.MBR.MDK = 0;
      this.MBR.MDL = paramRect.bottom;
      this.MBR.MDM = 0;
      new StringBuilder("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ").append(this.MBR.paddingTop).append(", Left: ").append(this.MBR.paddingLeft).append(", Right: ").append(this.MBR.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.MBR.MDL).append(", Left: ").append(this.MBR.MDM).append(", Right: ").append(this.MBR.MDK);
      io.flutter.a.gea();
      geA();
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
    if ((this.MBQ != null) && (this.MBQ.nA.isEnabled()))
    {
      io.flutter.view.a locala = this.MBQ;
      AppMethodBeat.o(9999);
      return locala;
    }
    AppMethodBeat.o(9999);
    return null;
  }
  
  public io.flutter.embedding.engine.a getAttachedFlutterEngine()
  {
    return this.tiq;
  }
  
  public final void gex()
  {
    AppMethodBeat.i(10002);
    new StringBuilder("Detaching from a FlutterEngine: ").append(this.tiq);
    io.flutter.a.gea();
    if (!gey())
    {
      io.flutter.a.gea();
      AppMethodBeat.o(10002);
      return;
    }
    Object localObject = this.MBN.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.tiq.MCs.gfm();
    this.tiq.MCs.gfl();
    this.MBQ.release();
    this.MBQ = null;
    this.MBa.MGi.restartInput(this);
    this.MBa.MCs.MBa = null;
    localObject = this.tiq.MBc;
    this.MBM = false;
    ((io.flutter.embedding.engine.b.a)localObject).removeIsDisplayingFlutterUiListener(this.MBl);
    ((io.flutter.embedding.engine.b.a)localObject).geV();
    ((io.flutter.embedding.engine.b.a)localObject).geW();
    this.MBL.geu();
    this.tiq = null;
    AppMethodBeat.o(10002);
  }
  
  public final boolean gey()
  {
    AppMethodBeat.i(10003);
    if ((this.tiq != null) && (this.tiq.MBc == this.MBL.getAttachedRenderer()))
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
    AppMethodBeat.i(213357);
    WindowInsets localWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    this.MBR.paddingTop = paramWindowInsets.getSystemWindowInsetTop();
    this.MBR.paddingRight = paramWindowInsets.getSystemWindowInsetRight();
    this.MBR.paddingBottom = 0;
    this.MBR.paddingLeft = paramWindowInsets.getSystemWindowInsetLeft();
    this.MBR.MDJ = 0;
    this.MBR.MDK = 0;
    this.MBR.MDL = paramWindowInsets.getSystemWindowInsetBottom();
    this.MBR.MDM = 0;
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramWindowInsets = paramWindowInsets.getSystemGestureInsets();
      this.MBR.MDN = paramWindowInsets.top;
      this.MBR.MDO = paramWindowInsets.right;
      this.MBR.MDP = paramWindowInsets.bottom;
      this.MBR.MDQ = paramWindowInsets.left;
    }
    new StringBuilder("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ").append(this.MBR.paddingTop).append(", Left: ").append(this.MBR.paddingLeft).append(", Right: ").append(this.MBR.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.MBR.MDL).append(", Left: ").append(this.MBR.MDM).append(", Right: ").append(this.MBR.MDK).append("System Gesture Insets - Left: ").append(this.MBR.MDQ).append(", Top: ").append(this.MBR.MDN).append(", Right: ").append(this.MBR.MDO).append(", Bottom: ").append(this.MBR.MDL);
    io.flutter.a.gea();
    geA();
    AppMethodBeat.o(213357);
    return localWindowInsets;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9989);
    super.onConfigurationChanged(paramConfiguration);
    if (this.tiq != null)
    {
      io.flutter.a.gea();
      j(paramConfiguration);
      gez();
    }
    AppMethodBeat.o(9989);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9992);
    if (!gey())
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      AppMethodBeat.o(9992);
      return paramEditorInfo;
    }
    paramEditorInfo = this.MBa.a(this, paramEditorInfo);
    AppMethodBeat.o(9992);
    return paramEditorInfo;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9997);
    if ((gey()) && (this.MBP.onGenericMotionEvent(paramMotionEvent))) {}
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
    if (!gey())
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(9998);
      return bool;
    }
    boolean bool = this.MBQ.ap(paramMotionEvent);
    AppMethodBeat.o(9998);
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9995);
    if (!gey())
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(9995);
      return bool;
    }
    this.MBO.j(paramKeyEvent);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(9995);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9994);
    if (!gey())
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(9994);
      return bool;
    }
    this.MBO.i(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9994);
    return bool;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9990);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    new StringBuilder("Size changed. Sending Flutter new viewport metrics. FlutterView was ").append(paramInt3).append(" x ").append(paramInt4).append(", it is now ").append(paramInt1).append(" x ").append(paramInt2);
    io.flutter.a.gea();
    this.MBR.width = paramInt1;
    this.MBR.height = paramInt2;
    geA();
    AppMethodBeat.o(9990);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9996);
    if (!gey())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(9996);
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    boolean bool = this.MBP.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9996);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void fZe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView
 * JD-Core Version:    0.7.0.1
 */