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
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.c.d;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.c.f;
import io.flutter.embedding.engine.c.h.a;
import io.flutter.embedding.engine.c.h.b;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.c.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterView
  extends SurfaceView
  implements io.flutter.plugin.a.c, c
{
  private final io.flutter.embedding.engine.b.a KKO;
  private final io.flutter.embedding.android.a KKW;
  private final io.flutter.embedding.android.b KKX;
  public FlutterNativeView KKa;
  private final io.flutter.embedding.engine.c.b KKl;
  private final a.e KLa;
  private final DartExecutor KLk;
  public final io.flutter.embedding.engine.c.c KLn;
  private final d KLo;
  public final e KLp;
  private final f KLq;
  private final io.flutter.embedding.engine.c.h KLs;
  public final j KLt;
  private final AtomicLong KMG;
  private final InputMethodManager KPk;
  private a KSA;
  public final SurfaceHolder.Callback KSB;
  private final d KSC;
  private final List<io.flutter.plugin.a.a> KSD;
  public final List<a> KSE;
  private boolean KSF;
  private boolean KSG;
  private final io.flutter.plugin.b.b KSz;
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9698);
    this.KMG = new AtomicLong(0L);
    this.KSF = false;
    this.KSG = false;
    this.KLa = new a.e()
    {
      public final void aV(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(9829);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(9829);
      }
    };
    paramAttributeSet = lz(getContext());
    if (paramAttributeSet == null)
    {
      paramContext = new IllegalArgumentException("Bad context");
      AppMethodBeat.o(9698);
      throw paramContext;
    }
    if (paramFlutterNativeView == null) {}
    for (this.KKa = new FlutterNativeView(paramAttributeSet.getApplicationContext());; this.KKa = paramFlutterNativeView)
    {
      this.KLk = this.KKa.KLk;
      this.KKO = new io.flutter.embedding.engine.b.a(this.KKa.getFlutterJNI());
      this.KSF = this.KKa.getFlutterJNI().nativeGetIsSoftwareRenderingEnabled();
      this.KSC = new d();
      this.KSC.KML = paramContext.getResources().getDisplayMetrics().density;
      setFocusable(true);
      setFocusableInTouchMode(true);
      paramContext = this.KKa;
      paramContext.KKb = this;
      paramContext = paramContext.KSs;
      paramContext.KKb = this;
      paramContext.mActivity = paramAttributeSet;
      paramContext.KKc.a(paramAttributeSet, this, getDartExecutor());
      this.KSB = new SurfaceHolder.Callback()
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
      getHolder().addCallback(this.KSB);
      this.KSD = new ArrayList();
      this.KSE = new ArrayList();
      this.KLp = new e(this.KLk);
      this.KKl = new io.flutter.embedding.engine.c.b(this.KLk);
      this.KLn = new io.flutter.embedding.engine.c.c(this.KLk);
      this.KLo = new d(this.KLk);
      this.KLq = new f(this.KLk);
      this.KLt = new j(this.KLk);
      this.KLs = new io.flutter.embedding.engine.c.h(this.KLk);
      paramContext = new io.flutter.plugin.a.a()
      {
        public final void onPostResume()
        {
          AppMethodBeat.i(9680);
          this.KSI.fNK();
          AppMethodBeat.o(9680);
        }
      };
      this.KSD.add(paramContext);
      this.KPk = ((InputMethodManager)getContext().getSystemService("input_method"));
      paramContext = this.KKa.KSs.KKc;
      this.KSz = new io.flutter.plugin.b.b(this, this.KLk, paramContext);
      this.KKW = new io.flutter.embedding.android.a(this.KKl, this.KSz);
      this.KKX = new io.flutter.embedding.android.b(this.KKO);
      this.KKa.KSs.KKc.KKm = this.KSz;
      k(getResources().getConfiguration());
      fNV();
      AppMethodBeat.o(9698);
      return;
    }
  }
  
  private void aU(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9724);
    if (!this.KSF)
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
  
  private void fNV()
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
    for (h.b localb = h.b.KOf;; localb = h.b.KOe)
    {
      this.KLs.fNG().ci(getResources().getConfiguration().fontScale).zi(DateFormat.is24HourFormat(getContext())).a(localb).send();
      AppMethodBeat.o(9704);
      return;
      i = 0;
      break;
    }
  }
  
  private void fNX()
  {
    AppMethodBeat.i(9720);
    if (!isAttached())
    {
      AppMethodBeat.o(9720);
      return;
    }
    this.KKa.getFlutterJNI().setViewportMetrics(this.KSC.KML, this.KSC.KSK, this.KSC.KSL, this.KSC.KSM, this.KSC.KSN, this.KSC.KSO, this.KSC.KSP, this.KSC.KSQ, this.KSC.KSR, this.KSC.KSS, this.KSC.KST, this.KSC.KMQ, this.KSC.KMR, this.KSC.KMS, this.KSC.KMT);
    AppMethodBeat.o(9720);
  }
  
  private void k(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9705);
    if (!isAttached())
    {
      AppMethodBeat.o(9705);
      return;
    }
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
    this.KLo.iI(localArrayList);
    AppMethodBeat.o(9705);
  }
  
  private static Activity lz(Context paramContext)
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
    fNW();
    this.KKa.a(paramb);
    AppMethodBeat.o(9718);
  }
  
  public final void a(String paramString, io.flutter.plugin.a.c.a parama)
  {
    AppMethodBeat.i(9728);
    this.KKa.a(paramString, parama);
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
    this.KKa.a(paramString, paramByteBuffer, paramb);
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
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    AppMethodBeat.i(9709);
    boolean bool = this.KKa.KSs.KKc.checkInputConnectionProxy(paramView);
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
    getHolder().removeCallback(this.KSB);
    this.KKa.destroy();
    this.KKa = null;
    AppMethodBeat.o(9707);
  }
  
  final void fNW()
  {
    AppMethodBeat.i(9717);
    if (this.KSA != null) {
      this.KSA.reset();
    }
    AppMethodBeat.o(9717);
  }
  
  public final c.a fNv()
  {
    AppMethodBeat.i(9729);
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    c localc = new c(this.KMG.getAndIncrement(), localSurfaceTexture);
    this.KKa.getFlutterJNI().registerTexture(localc.id, localSurfaceTexture);
    AppMethodBeat.o(9729);
    return localc;
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9714);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.KSC.KSM = paramRect.top;
      this.KSC.KSN = paramRect.right;
      this.KSC.KSO = 0;
      this.KSC.KSP = paramRect.left;
      this.KSC.KSQ = 0;
      this.KSC.KSR = 0;
      this.KSC.KSS = paramRect.bottom;
      this.KSC.KST = 0;
      fNX();
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
    if ((this.KSA != null) && (this.KSA.lH.isEnabled()))
    {
      a locala = this.KSA;
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
    Bitmap localBitmap = this.KKa.getFlutterJNI().getBitmap();
    AppMethodBeat.o(9719);
    return localBitmap;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.KLk;
  }
  
  float getDevicePixelRatio()
  {
    return this.KSC.KML;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.KKa;
  }
  
  public io.flutter.app.c getPluginRegistry()
  {
    return this.KKa.KSs;
  }
  
  public final boolean isAttached()
  {
    AppMethodBeat.i(9715);
    if ((this.KKa != null) && (this.KKa.KSt.isAttached()))
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
    AppMethodBeat.i(192789);
    int j;
    int i;
    label28:
    Object localObject;
    int m;
    if ((getWindowSystemUiVisibility() & 0x4) != 0)
    {
      j = 1;
      if ((getWindowSystemUiVisibility() & 0x2) == 0) {
        break label327;
      }
      i = 1;
      localObject = e.KSU;
      if (i != 0)
      {
        localObject = (Activity)getContext();
        int k = ((Activity)localObject).getResources().getConfiguration().orientation;
        m = ((Activity)localObject).getWindowManager().getDefaultDisplay().getRotation();
        if (k != 2) {
          break label381;
        }
        if (m != 1) {
          break label332;
        }
        localObject = e.KSW;
      }
      label91:
      d locald = this.KSC;
      if (j == 0) {
        break label389;
      }
      j = 0;
      label103:
      locald.KSM = j;
      locald = this.KSC;
      if ((localObject != e.KSW) && (localObject != e.KSX)) {
        break label397;
      }
      j = 0;
      label133:
      locald.KSN = j;
      this.KSC.KSO = 0;
      locald = this.KSC;
      if ((localObject != e.KSV) && (localObject != e.KSX)) {
        break label405;
      }
      j = 0;
      label171:
      locald.KSP = j;
      this.KSC.KSQ = 0;
      this.KSC.KSR = 0;
      localObject = this.KSC;
      if (i == 0) {
        break label421;
      }
      i = getRootView().getHeight();
      if (paramWindowInsets.getSystemWindowInsetBottom() >= i * 0.18D) {
        break label413;
      }
      i = 0;
    }
    for (;;)
    {
      ((d)localObject).KSS = i;
      this.KSC.KST = 0;
      if (Build.VERSION.SDK_INT >= 29)
      {
        localObject = paramWindowInsets.getSystemGestureInsets();
        this.KSC.KMQ = ((Insets)localObject).top;
        this.KSC.KMR = ((Insets)localObject).right;
        this.KSC.KMS = ((Insets)localObject).bottom;
        this.KSC.KMT = ((Insets)localObject).left;
      }
      fNX();
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      AppMethodBeat.o(192789);
      return paramWindowInsets;
      j = 0;
      break;
      label327:
      i = 0;
      break label28;
      label332:
      if (m == 3)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = e.KSV;
          break label91;
        }
        localObject = e.KSW;
        break label91;
      }
      if ((m == 0) || (m == 2))
      {
        localObject = e.KSX;
        break label91;
      }
      label381:
      localObject = e.KSU;
      break label91;
      label389:
      j = paramWindowInsets.getSystemWindowInsetTop();
      break label103;
      label397:
      j = paramWindowInsets.getSystemWindowInsetRight();
      break label133;
      label405:
      j = paramWindowInsets.getSystemWindowInsetLeft();
      break label171;
      label413:
      i = paramWindowInsets.getSystemWindowInsetBottom();
      continue;
      label421:
      i = paramWindowInsets.getSystemWindowInsetBottom();
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(9722);
    super.onAttachedToWindow();
    io.flutter.plugin.platform.h localh = getPluginRegistry().KKc;
    this.KSA = new a(this, new io.flutter.embedding.engine.c.a(this.KLk, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), localh);
    this.KSA.KLa = this.KLa;
    aU(this.KSA.lH.isEnabled(), this.KSA.lH.isTouchExplorationEnabled());
    AppMethodBeat.o(9722);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9706);
    super.onConfigurationChanged(paramConfiguration);
    k(paramConfiguration);
    fNV();
    AppMethodBeat.o(9706);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9708);
    paramEditorInfo = this.KSz.a(this, paramEditorInfo);
    AppMethodBeat.o(9708);
    return paramEditorInfo;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(9723);
    super.onDetachedFromWindow();
    this.KSA.release();
    this.KSA = null;
    AppMethodBeat.o(9723);
  }
  
  public void onFirstFrame()
  {
    AppMethodBeat.i(9721);
    this.KSG = true;
    Iterator localIterator = new ArrayList(this.KSE).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFirstFrame();
    }
    AppMethodBeat.o(9721);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9712);
    if ((isAttached()) && (this.KKX.onGenericMotionEvent(paramMotionEvent))) {}
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
    boolean bool = this.KSA.an(paramMotionEvent);
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
    this.KKW.j(paramKeyEvent);
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
    this.KKW.i(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9700);
    return bool;
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9702);
    Iterator localIterator = this.KSD.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.plugin.a.a)localIterator.next()).onPostResume();
    }
    this.KLn.fNA();
    AppMethodBeat.o(9702);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9713);
    this.KSC.KSK = paramInt1;
    this.KSC.KSL = paramInt2;
    fNX();
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
    boolean bool = this.KKX.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9710);
    return bool;
  }
  
  public void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(9703);
    this.KLp.setInitialRoute(paramString);
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
    private SurfaceTexture.OnFrameAvailableListener KMJ;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    c(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(9779);
      this.KMJ = new SurfaceTexture.OnFrameAvailableListener()
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
        this.surfaceTexture.setOnFrameAvailableListener(this.KMJ, new Handler());
        AppMethodBeat.o(9779);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.KMJ);
      AppMethodBeat.o(9779);
    }
    
    public final long fNy()
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
    float KML = 1.0F;
    int KMQ = 0;
    int KMR = 0;
    int KMS = 0;
    int KMT = 0;
    int KSK = 0;
    int KSL = 0;
    int KSM = 0;
    int KSN = 0;
    int KSO = 0;
    int KSP = 0;
    int KSQ = 0;
    int KSR = 0;
    int KSS = 0;
    int KST = 0;
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(192782);
      KSU = new e("NONE", 0);
      KSV = new e("LEFT", 1);
      KSW = new e("RIGHT", 2);
      KSX = new e("BOTH", 3);
      KSY = new e[] { KSU, KSV, KSW, KSX };
      AppMethodBeat.o(192782);
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.view.FlutterView
 * JD-Core Version:    0.7.0.1
 */