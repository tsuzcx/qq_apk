package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.LocaleList;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.c.a;
import io.flutter.a.a.c.b;
import io.flutter.a.c.g;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.c.d;
import io.flutter.embedding.engine.c.e;
import io.flutter.embedding.engine.c.h;
import io.flutter.embedding.engine.c.h.a;
import io.flutter.embedding.engine.c.h.b;
import io.flutter.embedding.engine.c.j;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterView
  extends SurfaceView
  implements io.flutter.a.a.c, f
{
  public FlutterNativeView IWP;
  private final io.flutter.embedding.engine.b.a IXG;
  private boolean IXO;
  private final io.flutter.embedding.android.a IXQ;
  private final io.flutter.embedding.android.b IXR;
  private final a.e IXU;
  private final io.flutter.embedding.engine.c.b IXa;
  private final DartExecutor IYe;
  public final io.flutter.embedding.engine.c.c IYi;
  private final d IYj;
  public final e IYk;
  private final io.flutter.embedding.engine.c.f IYm;
  private final h IYn;
  public final j IYo;
  private final AtomicLong IZd;
  private final InputMethodManager JbG;
  private final io.flutter.a.b.b Jff;
  private a Jfg;
  public final SurfaceHolder.Callback Jfh;
  private final d Jfi;
  private final List<io.flutter.a.a.a> Jfj;
  public final List<a> Jfk;
  private boolean Jfl;
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, null);
  }
  
  public FlutterView(Context paramContext, AttributeSet paramAttributeSet, FlutterNativeView paramFlutterNativeView)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9698);
    this.IZd = new AtomicLong(0L);
    this.Jfl = false;
    this.IXO = false;
    this.IXU = new a.e()
    {
      public final void aR(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(9829);
        FlutterView.a(FlutterView.this, paramAnonymousBoolean1, paramAnonymousBoolean2);
        AppMethodBeat.o(9829);
      }
    };
    paramAttributeSet = lk(getContext());
    if (paramAttributeSet == null)
    {
      paramContext = new IllegalArgumentException("Bad context");
      AppMethodBeat.o(9698);
      throw paramContext;
    }
    if (paramFlutterNativeView == null) {}
    for (this.IWP = new FlutterNativeView(paramAttributeSet.getApplicationContext());; this.IWP = paramFlutterNativeView)
    {
      this.IYe = this.IWP.IYe;
      this.IXG = new io.flutter.embedding.engine.b.a(this.IWP.getFlutterJNI());
      this.Jfl = FlutterJNI.nativeGetIsSoftwareRenderingEnabled();
      this.Jfi = new d();
      this.Jfi.IZi = paramContext.getResources().getDisplayMetrics().density;
      setFocusable(true);
      setFocusableInTouchMode(true);
      paramContext = this.IWP;
      paramContext.IWQ = this;
      paramContext = paramContext.JeY;
      paramContext.IWQ = this;
      paramContext.mActivity = paramAttributeSet;
      paramContext.IWR.a(paramAttributeSet, this, getDartExecutor());
      this.Jfh = new SurfaceHolder.Callback()
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
      getHolder().addCallback(this.Jfh);
      this.Jfj = new ArrayList();
      this.Jfk = new ArrayList();
      this.IYk = new e(this.IYe);
      this.IXa = new io.flutter.embedding.engine.c.b(this.IYe);
      this.IYi = new io.flutter.embedding.engine.c.c(this.IYe);
      this.IYj = new d(this.IYe);
      this.IYm = new io.flutter.embedding.engine.c.f(this.IYe);
      this.IYo = new j(this.IYe);
      this.IYn = new h(this.IYe);
      paramContext = new io.flutter.a.a.a()
      {
        public final void onPostResume()
        {
          AppMethodBeat.i(9680);
          this.Jfn.fve();
          AppMethodBeat.o(9680);
        }
      };
      this.Jfj.add(paramContext);
      this.JbG = ((InputMethodManager)getContext().getSystemService("input_method"));
      paramContext = this.IWP.JeY.IWR;
      this.Jff = new io.flutter.a.b.b(this, this.IYe, paramContext);
      this.IXQ = new io.flutter.embedding.android.a(this.IXa, this.Jff);
      this.IXR = new io.flutter.embedding.android.b(this.IXG);
      this.IWP.JeY.IWR.IXb = this.Jff;
      j(getResources().getConfiguration());
      fvp();
      AppMethodBeat.o(9698);
      return;
    }
  }
  
  private void aQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9724);
    if (!this.Jfl)
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
  
  private void fvp()
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
    for (h.b localb = h.b.JaC;; localb = h.b.JaB)
    {
      this.IYn.fva().bT(getResources().getConfiguration().fontScale).xQ(DateFormat.is24HourFormat(getContext())).a(localb).send();
      AppMethodBeat.o(9704);
      return;
      i = 0;
      break;
    }
  }
  
  private void fvr()
  {
    AppMethodBeat.i(9720);
    if (!isAttached())
    {
      AppMethodBeat.o(9720);
      return;
    }
    this.IWP.getFlutterJNI().setViewportMetrics(this.Jfi.IZi, this.Jfi.Jfp, this.Jfi.Jfq, this.Jfi.Jfr, this.Jfi.Jfs, this.Jfi.Jft, this.Jfi.Jfu, this.Jfi.Jfv, this.Jfi.Jfw, this.Jfi.Jfx, this.Jfi.Jfy, this.Jfi.IZn, this.Jfi.IZo, this.Jfi.IZp, this.Jfi.IZq);
    AppMethodBeat.o(9720);
  }
  
  private void j(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9705);
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
    this.IYj.it(localArrayList);
    AppMethodBeat.o(9705);
  }
  
  private static Activity lk(Context paramContext)
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
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(9718);
    assertAttached();
    fvq();
    this.IWP.a(paramc);
    AppMethodBeat.o(9718);
  }
  
  public final void a(String paramString, c.a parama)
  {
    AppMethodBeat.i(9728);
    this.IWP.a(paramString, parama);
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
    this.IWP.a(paramString, paramByteBuffer, paramb);
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
    boolean bool = this.IWP.JeY.IWR.checkInputConnectionProxy(paramView);
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
    getHolder().removeCallback(this.Jfh);
    this.IWP.destroy();
    this.IWP = null;
    AppMethodBeat.o(9707);
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(9714);
    if (Build.VERSION.SDK_INT <= 19)
    {
      this.Jfi.Jfr = paramRect.top;
      this.Jfi.Jfs = paramRect.right;
      this.Jfi.Jft = 0;
      this.Jfi.Jfu = paramRect.left;
      this.Jfi.Jfv = 0;
      this.Jfi.Jfw = 0;
      this.Jfi.Jfx = paramRect.bottom;
      this.Jfi.Jfy = 0;
      fvr();
      AppMethodBeat.o(9714);
      return true;
    }
    boolean bool = super.fitSystemWindows(paramRect);
    AppMethodBeat.o(9714);
    return bool;
  }
  
  public final f.a fuS()
  {
    AppMethodBeat.i(9729);
    SurfaceTexture localSurfaceTexture = new SurfaceTexture(0);
    localSurfaceTexture.detachFromGLContext();
    c localc = new c(this.IZd.getAndIncrement(), localSurfaceTexture);
    this.IWP.getFlutterJNI().registerTexture(localc.id, localSurfaceTexture);
    AppMethodBeat.o(9729);
    return localc;
  }
  
  final void fvq()
  {
    AppMethodBeat.i(9717);
    if (this.Jfg != null) {
      this.Jfg.reset();
    }
    AppMethodBeat.o(9717);
  }
  
  public AccessibilityNodeProvider getAccessibilityNodeProvider()
  {
    AppMethodBeat.i(9725);
    if ((this.Jfg != null) && (this.Jfg.kI.isEnabled()))
    {
      a locala = this.Jfg;
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
    Bitmap localBitmap = this.IWP.getFlutterJNI().getBitmap();
    AppMethodBeat.o(9719);
    return localBitmap;
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.IYe;
  }
  
  float getDevicePixelRatio()
  {
    return this.Jfi.IZi;
  }
  
  public FlutterNativeView getFlutterNativeView()
  {
    return this.IWP;
  }
  
  public io.flutter.app.c getPluginRegistry()
  {
    return this.IWP.JeY;
  }
  
  public final boolean isAttached()
  {
    AppMethodBeat.i(9715);
    if ((this.IWP != null) && (this.IWP.JeZ.isAttached()))
    {
      AppMethodBeat.o(9715);
      return true;
    }
    AppMethodBeat.o(9715);
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(9722);
    super.onAttachedToWindow();
    g localg = getPluginRegistry().IWR;
    this.Jfg = new a(this, new io.flutter.embedding.engine.c.a(this.IYe, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager)getContext().getSystemService("accessibility"), getContext().getContentResolver(), localg);
    this.Jfg.IXU = this.IXU;
    aQ(this.Jfg.kI.isEnabled(), this.Jfg.kI.isTouchExplorationEnabled());
    AppMethodBeat.o(9722);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(9706);
    super.onConfigurationChanged(paramConfiguration);
    j(paramConfiguration);
    fvp();
    AppMethodBeat.o(9706);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    AppMethodBeat.i(9708);
    paramEditorInfo = this.Jff.a(this, paramEditorInfo);
    AppMethodBeat.o(9708);
    return paramEditorInfo;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(9723);
    super.onDetachedFromWindow();
    this.Jfg.release();
    this.Jfg = null;
    AppMethodBeat.o(9723);
  }
  
  public void onFirstFrame()
  {
    AppMethodBeat.i(9721);
    this.IXO = true;
    Iterator localIterator = new ArrayList(this.Jfk).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).onFirstFrame();
    }
    AppMethodBeat.o(9721);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9712);
    if ((isAttached()) && (this.IXR.onGenericMotionEvent(paramMotionEvent))) {}
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
    boolean bool = this.Jfg.an(paramMotionEvent);
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
    this.IXQ.j(paramKeyEvent);
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
    this.IXQ.i(paramKeyEvent);
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(9700);
    return bool;
  }
  
  public void onPostResume()
  {
    AppMethodBeat.i(9702);
    Iterator localIterator = this.Jfj.iterator();
    while (localIterator.hasNext()) {
      ((io.flutter.a.a.a)localIterator.next()).onPostResume();
    }
    this.IYi.fuW();
    AppMethodBeat.o(9702);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(9713);
    this.Jfi.Jfp = paramInt1;
    this.Jfi.Jfq = paramInt2;
    fvr();
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
    boolean bool = this.IXR.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(9710);
    return bool;
  }
  
  public void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(9703);
    this.IYk.setInitialRoute(paramString);
    AppMethodBeat.o(9703);
  }
  
  public static abstract interface a
  {
    public abstract void onFirstFrame();
  }
  
  public static abstract interface b {}
  
  final class c
    implements f.a
  {
    private SurfaceTexture.OnFrameAvailableListener IZg;
    final long id;
    boolean released;
    private final SurfaceTexture surfaceTexture;
    
    c(long paramLong, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(9779);
      this.IZg = new SurfaceTexture.OnFrameAvailableListener()
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
        this.surfaceTexture.setOnFrameAvailableListener(this.IZg, new Handler());
        AppMethodBeat.o(9779);
        return;
      }
      this.surfaceTexture.setOnFrameAvailableListener(this.IZg);
      AppMethodBeat.o(9779);
    }
    
    public final long fuU()
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
    float IZi = 1.0F;
    int IZn = 0;
    int IZo = 0;
    int IZp = 0;
    int IZq = 0;
    int Jfp = 0;
    int Jfq = 0;
    int Jfr = 0;
    int Jfs = 0;
    int Jft = 0;
    int Jfu = 0;
    int Jfv = 0;
    int Jfw = 0;
    int Jfx = 0;
    int Jfy = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.view.FlutterView
 * JD-Core Version:    0.7.0.1
 */