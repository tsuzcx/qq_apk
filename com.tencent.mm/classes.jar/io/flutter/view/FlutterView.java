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
  public FlutterNativeView MXT;
  private final io.flutter.embedding.engine.b.a MYI;
  private final io.flutter.embedding.android.a MYT;
  private final io.flutter.embedding.android.b MYU;
  private final a.e MYX;
  private final io.flutter.embedding.engine.c.b MYe;
  private final DartExecutor MZm;
  public final io.flutter.embedding.engine.c.c MZp;
  private final d MZq;
  public final e MZr;
  private final f MZs;
  private final io.flutter.embedding.engine.c.h MZu;
  public final j MZv;
  private final AtomicLong NaI;
  private final InputMethodManager Ndn;
  private final io.flutter.plugin.b.b NgB;
  private a NgC;
  public final SurfaceHolder.Callback NgD;
  private final d NgE;
  private final List<io.flutter.plugin.a.a> NgF;
  public final List<a> NgG;
  private boolean NgH;
  private boolean NgI;
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9698);
    this.NaI = new AtomicLong(0L);
    this.NgH = false;
    this.NgI = false;
    this.MYX = new a.e()
    {
      public final void bc(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(9829);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(9829);
      }
    };
    paramAttributeSet = lR(getContext());
    if (paramAttributeSet == null)
    {
      paramContext = new IllegalArgumentException("Bad context");
      AppMethodBeat.o(9698);
      throw paramContext;
    }
    if (paramFlutterNativeView == null) {}
    for (this.MXT = new FlutterNativeView(paramAttributeSet.getApplicationContext());; this.MXT = paramFlutterNativeView)
    {
      this.MZm = this.MXT.MZm;
      this.MYI = new io.flutter.embedding.engine.b.a(this.MXT.getFlutterJNI());
      this.NgH = this.MXT.getFlutterJNI().nativeGetIsSoftwareRenderingEnabled();
      this.NgE = new d();
      this.NgE.NaO = paramContext.getResources().getDisplayMetrics().density;
      setFocusable(true);
      setFocusableInTouchMode(true);
      paramContext = this.MXT;
      paramContext.MXU = this;
      paramContext = paramContext.Ngu;
      paramContext.MXU = this;
      paramContext.mActivity = paramAttributeSet;
      paramContext.MXV.a(paramAttributeSet, this, getDartExecutor());
      this.NgD = new SurfaceHolder.Callback()
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
      getHolder().addCallback(this.NgD);
      this.NgF = new ArrayList();
      this.NgG = new ArrayList();
      this.MZr = new e(this.MZm);
      this.MYe = new io.flutter.embedding.engine.c.b(this.MZm);
      this.MZp = new io.flutter.embedding.engine.c.c(this.MZm);
      this.MZq = new d(this.MZm);
      this.MZs = new f(this.MZm);
      this.MZv = new j(this.MZm);
      this.MZu = new io.flutter.embedding.engine.c.h(this.MZm);
      paramContext = new io.flutter.plugin.a.a()
      {
        public final void onPostResume()
        {
          AppMethodBeat.i(9680);
          this.NgK.gjL();
          AppMethodBeat.o(9680);
        }
      };
      this.NgF.add(paramContext);
      this.Ndn = ((InputMethodManager)getContext().getSystemService("input_method"));
      paramContext = this.MXT.Ngu.MXV;
      this.NgB = new io.flutter.plugin.b.b(this, this.MZm, paramContext);
      this.MYT = new io.flutter.embedding.android.a(this.MYe, this.NgB);
      this.MYU = new io.flutter.embedding.android.b(this.MYI);
      this.MXT.Ngu.MXV.MYf = this.NgB;
      k(getResources().getConfiguration());
      gjW();
      AppMethodBeat.o(9698);
      return;
    }
  }
  
  private void bb(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9724);
    if (!this.NgH)
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
  
  private void gjW()
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
    for (h.b localb = h.b.Nci;; localb = h.b.Nch)
    {
      this.MZu.gjH().cl(getResources().getConfiguration().fontScale).Aj(DateFormat.is24HourFormat(getContext())).a(localb).send();
      AppMethodBeat.o(9704);
      return;
      i = 0;
      break;
    }
  }
  
  private void gjY()
  {
    AppMethodBeat.i(9720);
    if (!isAttached())
    {
      AppMethodBeat.o(9720);
      return;
    }
    this.MXT.getFlutterJNI().setViewportMetrics(this.NgE.NaO, this.NgE.NgM, this.NgE.NgN, this.NgE.NgO, this.NgE.NgP, this.NgE.NgQ, this.NgE.NgR, this.NgE.NgS, this.NgE.NgT, this.NgE.NgU, this.NgE.NgV, this.NgE.NaT, this.NgE.NaU, this.NgE.NaV, this.NgE.NaW);
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
    this.MZq.jf(localArrayList);
    AppMethodBeat.o(9705);
  }
  
  private static Activity lR(Context paramContext)
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
    gjX();
    this.MXT.a(paramb);
    AppMethodBeat.o(9718);
  }
  
  public final void a(String paramString, io.flutter.plugin.a.c.a parama)
  {
    AppMethodBeat.i(9728);
    this.MXT.a(paramString, parama);
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
    this.MXT.a(paramString, paramByteBuffer, paramb);
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
    boolean bool = this.MXT.Ngu.MXV.checkInputConnectionProxy(paramView);
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
    getHolder().removeCallback(this.NgD);
    this.MXT.destroy();
    this.MXT = null;
    AppMethodBeat.o(9707);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9714);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.NgE.NgO = paramRect.top;
      this.NgE.NgP = paramRect.right;
      this.NgE.NgQ = 0;
      this.NgE.NgR = paramRect.left;
      this.NgE.NgS = 0;
      this.NgE.NgT = 0;
      this.NgE.NgU = paramRect.bottom;
      this.NgE.NgV = 0;
      gjY();
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
    if ((this.NgC != null) && (this.NgC.nA.isEnabled()))
    {
      a locala = this.NgC;
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
    Bitmap localBitmap = this.MXT.getFlutterJNI().getBitmap();
    AppMethodBeat.o(9719);
    return localBitmap;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.MZm;
  }
  
  float getDevicePixelRatio()
  {
    return this.NgE.NaO;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.MXT;
  }
  
  public io.flutter.app.c getPluginRegistry()
  {
    return this.MXT.Ngu;
  }
  
  final void gjX()
  {
    AppMethodBeat.i(9717);
    if (this.NgC != null) {
      this.NgC.reset();
    }
    AppMethodBeat.o(9717);
  }
  
  public final c.a gjw()
  {
    AppMethodBeat.i(9729);
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    c localc = new c(this.NaI.getAndIncrement(), localSurfaceTexture);
    this.MXT.getFlutterJNI().registerTexture(localc.id, localSurfaceTexture);
    AppMethodBeat.o(9729);
    return localc;
  }
  
  public final boolean isAttached()
  {
    AppMethodBeat.i(9715);
    if ((this.MXT != null) && (this.MXT.Ngv.isAttached()))
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
    AppMethodBeat.i(197818);
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
      localObject = e.NgW;
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
        localObject = e.NgY;
      }
      label91:
      d locald = this.NgE;
      if (j == 0) {
        break label389;
      }
      j = 0;
      label103:
      locald.NgO = j;
      locald = this.NgE;
      if ((localObject != e.NgY) && (localObject != e.NgZ)) {
        break label397;
      }
      j = 0;
      label133:
      locald.NgP = j;
      this.NgE.NgQ = 0;
      locald = this.NgE;
      if ((localObject != e.NgX) && (localObject != e.NgZ)) {
        break label405;
      }
      j = 0;
      label171:
      locald.NgR = j;
      this.NgE.NgS = 0;
      this.NgE.NgT = 0;
      localObject = this.NgE;
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
      ((d)localObject).NgU = i;
      this.NgE.NgV = 0;
      if (Build.VERSION.SDK_INT >= 29)
      {
        localObject = paramWindowInsets.getSystemGestureInsets();
        this.NgE.NaT = ((Insets)localObject).top;
        this.NgE.NaU = ((Insets)localObject).right;
        this.NgE.NaV = ((Insets)localObject).bottom;
        this.NgE.NaW = ((Insets)localObject).left;
      }
      gjY();
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      AppMethodBeat.o(197818);
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
          localObject = e.NgX;
          break label91;
        }
        localObject = e.NgY;
        break label91;
      }
      if ((m == 0) || (m == 2))
      {
        localObject = e.NgZ;
        break label91;
      }
      label381:
      localObject = e.NgW;
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
    io.flutter.plugin.platform.h localh = getPluginRegistry().MXV;
    this.NgC = new a(this, new io.flutter.embedding.engine.c.a(this.MZm, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), localh);
    this.NgC.MYX = this.MYX;
    bb(this.NgC.nA.isEnabled(), this.NgC.nA.isTouchExplorationEnabled());
    AppMethodBeat.o(9722);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9706);
    super.onConfigurationChanged(paramConfiguration);
    k(paramConfiguration);
    gjW();
    AppMethodBeat.o(9706);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9708);
    paramEditorInfo = this.NgB.a(this, paramEditorInfo);
    AppMethodBeat.o(9708);
    return paramEditorInfo;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(9723);
    super.onDetachedFromWindow();
    this.NgC.release();
    this.NgC = null;
    AppMethodBeat.o(9723);
  }
  
  public void onFirstFrame()
  {
    AppMethodBeat.i(9721);
    this.NgI = true;
    Iterator localIterator = new ArrayList(this.NgG).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFirstFrame();
    }
    AppMethodBeat.o(9721);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9712);
    if ((isAttached()) && (this.MYU.onGenericMotionEvent(paramMotionEvent))) {}
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
    boolean bool = this.NgC.an(paramMotionEvent);
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
    this.MYT.j(paramKeyEvent);
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
    this.MYT.i(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9700);
    return bool;
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9702);
    Iterator localIterator = this.NgF.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.plugin.a.a)localIterator.next()).onPostResume();
    }
    this.MZp.gjB();
    AppMethodBeat.o(9702);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9713);
    this.NgE.NgM = paramInt1;
    this.NgE.NgN = paramInt2;
    gjY();
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
    boolean bool = this.MYU.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9710);
    return bool;
  }
  
  public void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(9703);
    this.MZr.setInitialRoute(paramString);
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
    private SurfaceTexture.OnFrameAvailableListener NaL;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    c(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(9779);
      this.NaL = new SurfaceTexture.OnFrameAvailableListener()
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
        this.surfaceTexture.setOnFrameAvailableListener(this.NaL, new Handler());
        AppMethodBeat.o(9779);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.NaL);
      AppMethodBeat.o(9779);
    }
    
    public final long gjz()
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
    float NaO = 1.0F;
    int NaT = 0;
    int NaU = 0;
    int NaV = 0;
    int NaW = 0;
    int NgM = 0;
    int NgN = 0;
    int NgO = 0;
    int NgP = 0;
    int NgQ = 0;
    int NgR = 0;
    int NgS = 0;
    int NgT = 0;
    int NgU = 0;
    int NgV = 0;
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(197811);
      NgW = new e("NONE", 0);
      NgX = new e("LEFT", 1);
      NgY = new e("RIGHT", 2);
      NgZ = new e("BOTH", 3);
      Nha = new e[] { NgW, NgX, NgY, NgZ };
      AppMethodBeat.o(197811);
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.view.FlutterView
 * JD-Core Version:    0.7.0.1
 */