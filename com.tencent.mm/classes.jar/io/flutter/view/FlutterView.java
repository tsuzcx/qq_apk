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
  public FlutterNativeView MAM;
  private final io.flutter.embedding.engine.c.b MAZ;
  private final io.flutter.embedding.engine.b.a MBD;
  private final io.flutter.embedding.android.a MBO;
  private final io.flutter.embedding.android.b MBP;
  private final a.e MBS;
  private final DartExecutor MCh;
  public final io.flutter.embedding.engine.c.c MCk;
  private final d MCl;
  public final e MCm;
  private final f MCn;
  private final io.flutter.embedding.engine.c.h MCp;
  public final j MCq;
  private final AtomicLong MDD;
  private final InputMethodManager MGi;
  public final SurfaceHolder.Callback MJA;
  private final d MJB;
  private final List<io.flutter.plugin.a.a> MJC;
  public final List<a> MJD;
  private boolean MJE;
  private boolean MJF;
  private final io.flutter.plugin.b.b MJy;
  private a MJz;
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9698);
    this.MDD = new AtomicLong(0L);
    this.MJE = false;
    this.MJF = false;
    this.MBS = new a.e()
    {
      public final void bd(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(9829);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(9829);
      }
    };
    paramAttributeSet = lL(getContext());
    if (paramAttributeSet == null)
    {
      paramContext = new IllegalArgumentException("Bad context");
      AppMethodBeat.o(9698);
      throw paramContext;
    }
    if (paramFlutterNativeView == null) {}
    for (this.MAM = new FlutterNativeView(paramAttributeSet.getApplicationContext());; this.MAM = paramFlutterNativeView)
    {
      this.MCh = this.MAM.MCh;
      this.MBD = new io.flutter.embedding.engine.b.a(this.MAM.getFlutterJNI());
      this.MJE = this.MAM.getFlutterJNI().nativeGetIsSoftwareRenderingEnabled();
      this.MJB = new d();
      this.MJB.MDI = paramContext.getResources().getDisplayMetrics().density;
      setFocusable(true);
      setFocusableInTouchMode(true);
      paramContext = this.MAM;
      paramContext.MAN = this;
      paramContext = paramContext.MJr;
      paramContext.MAN = this;
      paramContext.mActivity = paramAttributeSet;
      paramContext.MAO.a(paramAttributeSet, this, getDartExecutor());
      this.MJA = new SurfaceHolder.Callback()
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
      getHolder().addCallback(this.MJA);
      this.MJC = new ArrayList();
      this.MJD = new ArrayList();
      this.MCm = new e(this.MCh);
      this.MAZ = new io.flutter.embedding.engine.c.b(this.MCh);
      this.MCk = new io.flutter.embedding.engine.c.c(this.MCh);
      this.MCl = new d(this.MCh);
      this.MCn = new f(this.MCh);
      this.MCq = new j(this.MCh);
      this.MCp = new io.flutter.embedding.engine.c.h(this.MCh);
      paramContext = new io.flutter.plugin.a.a()
      {
        public final void onPostResume()
        {
          AppMethodBeat.i(9680);
          this.MJH.gfj();
          AppMethodBeat.o(9680);
        }
      };
      this.MJC.add(paramContext);
      this.MGi = ((InputMethodManager)getContext().getSystemService("input_method"));
      paramContext = this.MAM.MJr.MAO;
      this.MJy = new io.flutter.plugin.b.b(this, this.MCh, paramContext);
      this.MBO = new io.flutter.embedding.android.a(this.MAZ, this.MJy);
      this.MBP = new io.flutter.embedding.android.b(this.MBD);
      this.MAM.MJr.MAO.MBa = this.MJy;
      k(getResources().getConfiguration());
      gfu();
      AppMethodBeat.o(9698);
      return;
    }
  }
  
  private void bc(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9724);
    if (!this.MJE)
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
  
  private void gfu()
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
    for (h.b localb = h.b.MFc;; localb = h.b.MFb)
    {
      this.MCp.gff().cn(getResources().getConfiguration().fontScale).zW(DateFormat.is24HourFormat(getContext())).a(localb).send();
      AppMethodBeat.o(9704);
      return;
      i = 0;
      break;
    }
  }
  
  private void gfw()
  {
    AppMethodBeat.i(9720);
    if (!isAttached())
    {
      AppMethodBeat.o(9720);
      return;
    }
    this.MAM.getFlutterJNI().setViewportMetrics(this.MJB.MDI, this.MJB.MJJ, this.MJB.MJK, this.MJB.MJL, this.MJB.MJM, this.MJB.MJN, this.MJB.MJO, this.MJB.MJP, this.MJB.MJQ, this.MJB.MJR, this.MJB.MJS, this.MJB.MDN, this.MJB.MDO, this.MJB.MDP, this.MJB.MDQ);
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
    this.MCl.iW(localArrayList);
    AppMethodBeat.o(9705);
  }
  
  private static Activity lL(Context paramContext)
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
    gfv();
    this.MAM.a(paramb);
    AppMethodBeat.o(9718);
  }
  
  public final void a(String paramString, io.flutter.plugin.a.c.a parama)
  {
    AppMethodBeat.i(9728);
    this.MAM.a(paramString, parama);
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
    this.MAM.a(paramString, paramByteBuffer, paramb);
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
    boolean bool = this.MAM.MJr.MAO.checkInputConnectionProxy(paramView);
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
    getHolder().removeCallback(this.MJA);
    this.MAM.destroy();
    this.MAM = null;
    AppMethodBeat.o(9707);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9714);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.MJB.MJL = paramRect.top;
      this.MJB.MJM = paramRect.right;
      this.MJB.MJN = 0;
      this.MJB.MJO = paramRect.left;
      this.MJB.MJP = 0;
      this.MJB.MJQ = 0;
      this.MJB.MJR = paramRect.bottom;
      this.MJB.MJS = 0;
      gfw();
      AppMethodBeat.o(9714);
      return true;
    }
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(9714);
    return bool;
  }
  
  public final c.a geU()
  {
    AppMethodBeat.i(9729);
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    c localc = new c(this.MDD.getAndIncrement(), localSurfaceTexture);
    this.MAM.getFlutterJNI().registerTexture(localc.id, localSurfaceTexture);
    AppMethodBeat.o(9729);
    return localc;
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    AppMethodBeat.i(9725);
    if ((this.MJz != null) && (this.MJz.nA.isEnabled()))
    {
      a locala = this.MJz;
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
    Bitmap localBitmap = this.MAM.getFlutterJNI().getBitmap();
    AppMethodBeat.o(9719);
    return localBitmap;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.MCh;
  }
  
  float getDevicePixelRatio()
  {
    return this.MJB.MDI;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.MAM;
  }
  
  public io.flutter.app.c getPluginRegistry()
  {
    return this.MAM.MJr;
  }
  
  final void gfv()
  {
    AppMethodBeat.i(9717);
    if (this.MJz != null) {
      this.MJz.reset();
    }
    AppMethodBeat.o(9717);
  }
  
  public final boolean isAttached()
  {
    AppMethodBeat.i(9715);
    if ((this.MAM != null) && (this.MAM.MJs.isAttached()))
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
    AppMethodBeat.i(213236);
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
      localObject = FlutterView.e.MJT;
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
        localObject = FlutterView.e.MJV;
      }
      label91:
      d locald = this.MJB;
      if (j == 0) {
        break label389;
      }
      j = 0;
      label103:
      locald.MJL = j;
      locald = this.MJB;
      if ((localObject != FlutterView.e.MJV) && (localObject != FlutterView.e.MJW)) {
        break label397;
      }
      j = 0;
      label133:
      locald.MJM = j;
      this.MJB.MJN = 0;
      locald = this.MJB;
      if ((localObject != FlutterView.e.MJU) && (localObject != FlutterView.e.MJW)) {
        break label405;
      }
      j = 0;
      label171:
      locald.MJO = j;
      this.MJB.MJP = 0;
      this.MJB.MJQ = 0;
      localObject = this.MJB;
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
      ((d)localObject).MJR = i;
      this.MJB.MJS = 0;
      if (Build.VERSION.SDK_INT >= 29)
      {
        localObject = paramWindowInsets.getSystemGestureInsets();
        this.MJB.MDN = ((Insets)localObject).top;
        this.MJB.MDO = ((Insets)localObject).right;
        this.MJB.MDP = ((Insets)localObject).bottom;
        this.MJB.MDQ = ((Insets)localObject).left;
      }
      gfw();
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      AppMethodBeat.o(213236);
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
          localObject = FlutterView.e.MJU;
          break label91;
        }
        localObject = FlutterView.e.MJV;
        break label91;
      }
      if ((m == 0) || (m == 2))
      {
        localObject = FlutterView.e.MJW;
        break label91;
      }
      label381:
      localObject = FlutterView.e.MJT;
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
    io.flutter.plugin.platform.h localh = getPluginRegistry().MAO;
    this.MJz = new a(this, new io.flutter.embedding.engine.c.a(this.MCh, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), localh);
    this.MJz.MBS = this.MBS;
    bc(this.MJz.nA.isEnabled(), this.MJz.nA.isTouchExplorationEnabled());
    AppMethodBeat.o(9722);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9706);
    super.onConfigurationChanged(paramConfiguration);
    k(paramConfiguration);
    gfu();
    AppMethodBeat.o(9706);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9708);
    paramEditorInfo = this.MJy.a(this, paramEditorInfo);
    AppMethodBeat.o(9708);
    return paramEditorInfo;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(9723);
    super.onDetachedFromWindow();
    this.MJz.release();
    this.MJz = null;
    AppMethodBeat.o(9723);
  }
  
  public void onFirstFrame()
  {
    AppMethodBeat.i(9721);
    this.MJF = true;
    Iterator localIterator = new ArrayList(this.MJD).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFirstFrame();
    }
    AppMethodBeat.o(9721);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9712);
    if ((isAttached()) && (this.MBP.onGenericMotionEvent(paramMotionEvent))) {}
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
    boolean bool = this.MJz.ap(paramMotionEvent);
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
    this.MBO.j(paramKeyEvent);
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
    this.MBO.i(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9700);
    return bool;
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9702);
    Iterator localIterator = this.MJC.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.plugin.a.a)localIterator.next()).onPostResume();
    }
    this.MCk.geZ();
    AppMethodBeat.o(9702);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9713);
    this.MJB.MJJ = paramInt1;
    this.MJB.MJK = paramInt2;
    gfw();
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
    boolean bool = this.MBP.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9710);
    return bool;
  }
  
  public void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(9703);
    this.MCm.setInitialRoute(paramString);
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
    private SurfaceTexture.OnFrameAvailableListener MDG;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    c(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(9779);
      this.MDG = new SurfaceTexture.OnFrameAvailableListener()
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
        this.surfaceTexture.setOnFrameAvailableListener(this.MDG, new Handler());
        AppMethodBeat.o(9779);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.MDG);
      AppMethodBeat.o(9779);
    }
    
    public final long geX()
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
    float MDI = 1.0F;
    int MDN = 0;
    int MDO = 0;
    int MDP = 0;
    int MDQ = 0;
    int MJJ = 0;
    int MJK = 0;
    int MJL = 0;
    int MJM = 0;
    int MJN = 0;
    int MJO = 0;
    int MJP = 0;
    int MJQ = 0;
    int MJR = 0;
    int MJS = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.view.FlutterView
 * JD-Core Version:    0.7.0.1
 */