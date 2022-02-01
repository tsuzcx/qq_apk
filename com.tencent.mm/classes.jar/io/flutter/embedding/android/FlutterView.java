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
  private c KKF;
  private c KKT;
  public boolean KKU;
  private final Set<a> KKV;
  private a KKW;
  private b KKX;
  private io.flutter.view.a KKY;
  private final a.b KKZ;
  private io.flutter.plugin.b.b KKm;
  private final io.flutter.embedding.engine.b.b KKx;
  private final a.e KLa;
  private b KuI;
  private final Set<io.flutter.embedding.engine.b.b> flutterUiDisplayListeners;
  private io.flutter.embedding.engine.a slN;
  
  public FlutterView(Context paramContext)
  {
    this(paramContext, null, null, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null, null);
  }
  
  private FlutterView(Context paramContext, AttributeSet paramAttributeSet, b paramb, c paramc)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9986);
    this.flutterUiDisplayListeners = new HashSet();
    this.KKV = new HashSet();
    this.KKZ = new a.b();
    this.KLa = new a.e()
    {
      public final void aV(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(10114);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(10114);
      }
    };
    this.KKx = new io.flutter.embedding.engine.b.b()
    {
      public final void cHX()
      {
        AppMethodBeat.i(192894);
        FlutterView.a(FlutterView.this, true);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cHX();
        }
        AppMethodBeat.o(192894);
      }
      
      public final void cHY()
      {
        AppMethodBeat.i(192895);
        FlutterView.a(FlutterView.this, false);
        Iterator localIterator = FlutterView.a(FlutterView.this).iterator();
        while (localIterator.hasNext()) {
          ((io.flutter.embedding.engine.b.b)localIterator.next()).cHY();
        }
        AppMethodBeat.o(192895);
      }
    };
    paramContext = paramb;
    if (paramb == null) {
      paramContext = b.KLd;
    }
    this.KuI = paramContext;
    if (paramc != null)
    {
      this.KKF = paramc;
      io.flutter.a.fMD();
      switch (3.KLc[this.KuI.ordinal()])
      {
      }
    }
    for (;;)
    {
      setFocusable(true);
      setFocusableInTouchMode(true);
      AppMethodBeat.o(9986);
      return;
      paramc = c.KLg;
      break;
      io.flutter.a.fMD();
      paramContext = getContext();
      if (this.KKF == c.KLh) {}
      for (boolean bool = true;; bool = false)
      {
        paramContext = new FlutterSurfaceView(paramContext, bool);
        this.KKT = paramContext;
        addView(paramContext);
        break;
      }
      io.flutter.a.fMD();
      paramContext = new FlutterTextureView(getContext());
      this.KKT = paramContext;
      addView(paramContext);
    }
  }
  
  public FlutterView(Context paramContext, b paramb)
  {
    this(paramContext, null, paramb, null);
  }
  
  public FlutterView(Context paramContext, b paramb, c paramc)
  {
    this(paramContext, null, paramb, paramc);
  }
  
  private void aU(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(10000);
    if (!this.slN.KKo.KLj.nativeGetIsSoftwareRenderingEnabled())
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
  
  private void fMZ()
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
    for (h.b localb = h.b.KOf;; localb = h.b.KOe)
    {
      this.slN.KLs.fNG().ci(getResources().getConfiguration().fontScale).zi(DateFormat.is24HourFormat(getContext())).a(localb).send();
      AppMethodBeat.o(10006);
      return;
      i = 0;
      break;
    }
  }
  
  private void fNa()
  {
    AppMethodBeat.i(10007);
    if (!fMY())
    {
      io.flutter.a.fMG();
      AppMethodBeat.o(10007);
      return;
    }
    this.KKZ.KML = getResources().getDisplayMetrics().density;
    this.slN.KKo.a(this.KKZ);
    AppMethodBeat.o(10007);
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
    this.slN.KLo.iI(localArrayList);
    AppMethodBeat.o(10005);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(10004);
    this.KKV.add(parama);
    AppMethodBeat.o(10004);
  }
  
  public final void a(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(192890);
    this.flutterUiDisplayListeners.add(paramb);
    AppMethodBeat.o(192890);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(192893);
    this.KKV.remove(parama);
    AppMethodBeat.o(192893);
  }
  
  public final void b(io.flutter.embedding.engine.b.b paramb)
  {
    AppMethodBeat.i(192891);
    this.flutterUiDisplayListeners.remove(paramb);
    AppMethodBeat.o(192891);
  }
  
  public final void c(io.flutter.embedding.engine.a parama)
  {
    AppMethodBeat.i(10001);
    new StringBuilder("Attaching to a FlutterEngine: ").append(parama);
    io.flutter.a.fMF();
    if (fMY())
    {
      if (parama == this.slN)
      {
        io.flutter.a.fMF();
        AppMethodBeat.o(10001);
        return;
      }
      io.flutter.a.fMF();
      fMX();
    }
    this.slN = parama;
    io.flutter.embedding.engine.b.a locala = this.slN.KKo;
    this.KKU = locala.KMH;
    this.KKT.a(locala);
    locala.addIsDisplayingFlutterUiListener(this.KKx);
    this.KKm = new io.flutter.plugin.b.b(this, this.slN.KLk, this.slN.KLv);
    this.KKW = new a(this.slN.KKl, this.KKm);
    this.KKX = new b(this.slN.KKo);
    this.KKY = new io.flutter.view.a(this, parama.KLm, (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.slN.KLv);
    this.KKY.KLa = this.KLa;
    aU(this.KKY.lH.isEnabled(), this.KKY.lH.isTouchExplorationEnabled());
    this.slN.KLv.a(this.KKY);
    this.KKm.KPk.restartInput(this);
    fMZ();
    j(getResources().getConfiguration());
    fNa();
    parama.KLv.hd(this);
    parama = this.KKV.iterator();
    while (parama.hasNext()) {
      ((a)parama.next()).fHN();
    }
    if (this.KKU) {
      this.KKx.cHX();
    }
    AppMethodBeat.o(10001);
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9993);
    if (this.slN != null)
    {
      bool = this.slN.KLv.checkInputConnectionProxy(paramView);
      AppMethodBeat.o(9993);
      return bool;
    }
    boolean bool = super.checkInputConnectionProxy(paramView);
    AppMethodBeat.o(9993);
    return bool;
  }
  
  public final void fMX()
  {
    AppMethodBeat.i(10002);
    new StringBuilder("Detaching from a FlutterEngine: ").append(this.slN);
    io.flutter.a.fMF();
    if (!fMY())
    {
      io.flutter.a.fMF();
      AppMethodBeat.o(10002);
      return;
    }
    Object localObject = this.KKV.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    this.slN.KLv.fNN();
    this.slN.KLv.fNM();
    this.KKY.release();
    this.KKY = null;
    this.KKm.KPk.restartInput(this);
    this.KKm.KLv.KKm = null;
    localObject = this.slN.KKo;
    this.KKU = false;
    ((io.flutter.embedding.engine.b.a)localObject).removeIsDisplayingFlutterUiListener(this.KKx);
    ((io.flutter.embedding.engine.b.a)localObject).fNw();
    ((io.flutter.embedding.engine.b.a)localObject).fNx();
    this.KKT.fMU();
    this.slN = null;
    AppMethodBeat.o(10002);
  }
  
  public final boolean fMY()
  {
    AppMethodBeat.i(10003);
    if ((this.slN != null) && (this.slN.KKo == this.KKT.getAttachedRenderer()))
    {
      AppMethodBeat.o(10003);
      return true;
    }
    AppMethodBeat.o(10003);
    return false;
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9991);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.KKZ.paddingTop = paramRect.top;
      this.KKZ.paddingRight = paramRect.right;
      this.KKZ.paddingBottom = 0;
      this.KKZ.paddingLeft = paramRect.left;
      this.KKZ.KMM = 0;
      this.KKZ.KMN = 0;
      this.KKZ.KMO = paramRect.bottom;
      this.KKZ.KMP = 0;
      new StringBuilder("Updating window insets (fitSystemWindows()):\nStatus bar insets: Top: ").append(this.KKZ.paddingTop).append(", Left: ").append(this.KKZ.paddingLeft).append(", Right: ").append(this.KKZ.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.KKZ.KMO).append(", Left: ").append(this.KKZ.KMP).append(", Right: ").append(this.KKZ.KMN);
      io.flutter.a.fMD();
      fNa();
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
    if ((this.KKY != null) && (this.KKY.lH.isEnabled()))
    {
      io.flutter.view.a locala = this.KKY;
      AppMethodBeat.o(9999);
      return locala;
    }
    AppMethodBeat.o(9999);
    return null;
  }
  
  public io.flutter.embedding.engine.a getAttachedFlutterEngine()
  {
    return this.slN;
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  @TargetApi(20)
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(192892);
    WindowInsets localWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    this.KKZ.paddingTop = paramWindowInsets.getSystemWindowInsetTop();
    this.KKZ.paddingRight = paramWindowInsets.getSystemWindowInsetRight();
    this.KKZ.paddingBottom = 0;
    this.KKZ.paddingLeft = paramWindowInsets.getSystemWindowInsetLeft();
    this.KKZ.KMM = 0;
    this.KKZ.KMN = 0;
    this.KKZ.KMO = paramWindowInsets.getSystemWindowInsetBottom();
    this.KKZ.KMP = 0;
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramWindowInsets = paramWindowInsets.getSystemGestureInsets();
      this.KKZ.KMQ = paramWindowInsets.top;
      this.KKZ.KMR = paramWindowInsets.right;
      this.KKZ.KMS = paramWindowInsets.bottom;
      this.KKZ.KMT = paramWindowInsets.left;
    }
    new StringBuilder("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ").append(this.KKZ.paddingTop).append(", Left: ").append(this.KKZ.paddingLeft).append(", Right: ").append(this.KKZ.paddingRight).append("\nKeyboard insets: Bottom: ").append(this.KKZ.KMO).append(", Left: ").append(this.KKZ.KMP).append(", Right: ").append(this.KKZ.KMN).append("System Gesture Insets - Left: ").append(this.KKZ.KMT).append(", Top: ").append(this.KKZ.KMQ).append(", Right: ").append(this.KKZ.KMR).append(", Bottom: ").append(this.KKZ.KMO);
    io.flutter.a.fMD();
    fNa();
    AppMethodBeat.o(192892);
    return localWindowInsets;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9989);
    super.onConfigurationChanged(paramConfiguration);
    if (this.slN != null)
    {
      io.flutter.a.fMD();
      j(paramConfiguration);
      fMZ();
    }
    AppMethodBeat.o(9989);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9992);
    if (!fMY())
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      AppMethodBeat.o(9992);
      return paramEditorInfo;
    }
    paramEditorInfo = this.KKm.a(this, paramEditorInfo);
    AppMethodBeat.o(9992);
    return paramEditorInfo;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9997);
    if ((fMY()) && (this.KKX.onGenericMotionEvent(paramMotionEvent))) {}
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
    if (!fMY())
    {
      bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(9998);
      return bool;
    }
    boolean bool = this.KKY.an(paramMotionEvent);
    AppMethodBeat.o(9998);
    return bool;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9995);
    if (!fMY())
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(9995);
      return bool;
    }
    this.KKW.j(paramKeyEvent);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(9995);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(9994);
    if (!fMY())
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(9994);
      return bool;
    }
    this.KKW.i(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9994);
    return bool;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9990);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    new StringBuilder("Size changed. Sending Flutter new viewport metrics. FlutterView was ").append(paramInt3).append(" x ").append(paramInt4).append(", it is now ").append(paramInt1).append(" x ").append(paramInt2);
    io.flutter.a.fMD();
    this.KKZ.width = paramInt1;
    this.KKZ.height = paramInt2;
    fNa();
    AppMethodBeat.o(9990);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9996);
    if (!fMY())
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(9996);
      return bool;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      requestUnbufferedDispatch(paramMotionEvent);
    }
    boolean bool = this.KKX.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9996);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void fHN();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(10024);
      KLd = new b("surface", 0);
      KLe = new b("texture", 1);
      KLf = new b[] { KLd, KLe };
      AppMethodBeat.o(10024);
    }
    
    private b() {}
  }
  
  public static enum c
  {
    static
    {
      AppMethodBeat.i(9962);
      KLg = new c("opaque", 0);
      KLh = new c("transparent", 1);
      KLi = new c[] { KLg, KLh };
      AppMethodBeat.o(9962);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterView
 * JD-Core Version:    0.7.0.1
 */