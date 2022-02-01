package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener
{
  private static final j CmI;
  private static final String TAG;
  public i CmJ;
  private GLTextureView.m CmK;
  private GLTextureView.e CmL;
  private f CmM;
  private g CmN;
  private k CmO;
  private boolean detached;
  private final WeakReference<GLTextureView> ggp;
  private int zJL;
  private int zJM;
  private boolean zJN;
  private List<TextureView.SurfaceTextureListener> zJO;
  
  static
  {
    AppMethodBeat.i(115636);
    TAG = GLTextureView.class.getSimpleName();
    CmI = new j((byte)0);
    AppMethodBeat.o(115636);
  }
  
  public GLTextureView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(216537);
    this.ggp = new WeakReference(this);
    this.zJO = new ArrayList();
    setSurfaceTextureListener(this);
    AppMethodBeat.o(216537);
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(115614);
    this.ggp = new WeakReference(this);
    this.zJO = new ArrayList();
    setSurfaceTextureListener(this);
    AppMethodBeat.o(115614);
  }
  
  private void aee()
  {
    AppMethodBeat.i(115635);
    if (this.CmJ != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(115635);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(115635);
  }
  
  public void a(SurfaceTexture arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115626);
    i locali = this.CmJ;
    for (;;)
    {
      synchronized (CmI)
      {
        locali.width = paramInt2;
        locali.height = paramInt3;
        locali.zKj = true;
        locali.zKh = true;
        locali.zKi = false;
        CmI.notifyAll();
        if ((locali.zJY) || (locali.tG) || (locali.zKi)) {
          break;
        }
        if ((locali.zKd) && (locali.zKe))
        {
          boolean bool = locali.ael();
          if (bool)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break;
            }
            try
            {
              CmI.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
      paramInt1 = 0;
    }
    AppMethodBeat.o(115626);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(115615);
    try
    {
      if (this.CmJ != null) {
        this.CmJ.dXT();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(115615);
    }
  }
  
  public int getDebugFlags()
  {
    return this.zJL;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.zJN;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(115623);
    int i = this.CmJ.getRenderMode();
    AppMethodBeat.o(115623);
    return i;
  }
  
  public void m(SurfaceTexture arg1)
  {
    AppMethodBeat.i(115624);
    i locali = this.CmJ;
    synchronized (CmI)
    {
      new StringBuilder("surfaceCreated tid=").append(locali.getId());
      locali.zKa = true;
      CmI.notifyAll();
      for (;;)
      {
        if (locali.zKc)
        {
          boolean bool = locali.zJY;
          if (!bool) {
            try
            {
              CmI.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(115624);
  }
  
  public void n(SurfaceTexture arg1)
  {
    AppMethodBeat.i(115625);
    i locali = this.CmJ;
    synchronized (CmI)
    {
      new StringBuilder("surfaceDestroyed tid=").append(locali.getId());
      locali.zKa = false;
      CmI.notifyAll();
      for (;;)
      {
        if (!locali.zKc)
        {
          boolean bool = locali.zJY;
          if (!bool) {
            try
            {
              CmI.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(115625);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(115628);
    super.onAttachedToWindow();
    if ((this.detached) && (this.CmK != null)) {
      if (this.CmJ == null) {
        break label86;
      }
    }
    label86:
    for (int i = this.CmJ.getRenderMode();; i = 1)
    {
      this.CmJ = new i(this.ggp);
      if (i != 1) {
        this.CmJ.setRenderMode(i);
      }
      this.CmJ.start();
      this.detached = false;
      AppMethodBeat.o(115628);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(115629);
    n(getSurfaceTexture());
    if (this.CmJ != null) {
      this.CmJ.dXT();
    }
    this.detached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(115629);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(115630);
    a(getSurfaceTexture(), 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    AppMethodBeat.o(115630);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115631);
    m(paramSurfaceTexture);
    a(paramSurfaceTexture, 0, paramInt1, paramInt2);
    Iterator localIterator = this.zJO.iterator();
    while (localIterator.hasNext()) {
      ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(115631);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115633);
    Iterator localIterator = this.zJO.iterator();
    while (localIterator.hasNext()) {
      ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureDestroyed(paramSurfaceTexture);
    }
    AppMethodBeat.o(115633);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115632);
    a(paramSurfaceTexture, 0, paramInt1, paramInt2);
    Iterator localIterator = this.zJO.iterator();
    while (localIterator.hasNext()) {
      ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(115632);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115634);
    Iterator localIterator = this.zJO.iterator();
    while (localIterator.hasNext()) {
      ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureUpdated(paramSurfaceTexture);
    }
    AppMethodBeat.o(115634);
  }
  
  public final void queueEvent(Runnable paramRunnable)
  {
    AppMethodBeat.i(115627);
    this.CmJ.queueEvent(paramRunnable);
    AppMethodBeat.o(115627);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.zJL = paramInt;
  }
  
  public void setEGLConfigChooser(GLTextureView.e parame)
  {
    AppMethodBeat.i(115619);
    aee();
    this.CmL = parame;
    AppMethodBeat.o(115619);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(115620);
    setEGLConfigChooser(new GLTextureView.n(this, paramBoolean));
    AppMethodBeat.o(115620);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(115621);
    aee();
    this.zJM = paramInt;
    AppMethodBeat.o(115621);
  }
  
  public void setEGLContextFactory(f paramf)
  {
    AppMethodBeat.i(115617);
    aee();
    this.CmM = paramf;
    AppMethodBeat.o(115617);
  }
  
  public void setEGLWindowSurfaceFactory(g paramg)
  {
    AppMethodBeat.i(115618);
    aee();
    this.CmN = paramg;
    AppMethodBeat.o(115618);
  }
  
  public void setGLWrapper(k paramk)
  {
    this.CmO = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.zJN = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(115622);
    this.CmJ.setRenderMode(paramInt);
    AppMethodBeat.o(115622);
  }
  
  public void setRenderer(GLTextureView.m paramm)
  {
    AppMethodBeat.i(115616);
    aee();
    if (this.CmL == null) {
      this.CmL = new GLTextureView.n(this, true);
    }
    if (this.CmM == null) {
      this.CmM = new GLTextureView.c(this, (byte)0);
    }
    if (this.CmN == null) {
      this.CmN = new d((byte)0);
    }
    this.CmK = paramm;
    this.CmJ = new i(this.ggp);
    this.CmJ.start();
    AppMethodBeat.o(115616);
  }
  
  static final class d
    implements GLTextureView.g
  {
    public final EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(115589);
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        AppMethodBeat.o(115589);
        return paramEGL10;
      }
      catch (IllegalArgumentException paramEGL10)
      {
        for (;;)
        {
          paramEGL10 = localObject;
        }
      }
    }
    
    public final void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(115590);
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
      AppMethodBeat.o(115590);
    }
  }
  
  public static abstract interface f
  {
    public abstract EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  public static abstract interface g
  {
    public abstract EGLSurface createWindowSurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void destroySurface(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  static final class h
  {
    EGL10 egl;
    EGLConfig eglConfig;
    EGLContext eglContext;
    EGLDisplay eglDisplay;
    EGLSurface eglSurface;
    WeakReference<GLTextureView> zJW;
    
    public h(WeakReference<GLTextureView> paramWeakReference)
    {
      this.zJW = paramWeakReference;
    }
    
    public static String O(String paramString, int paramInt)
    {
      AppMethodBeat.i(115594);
      paramString = paramString + " failed: " + paramInt;
      AppMethodBeat.o(115594);
      return paramString;
    }
    
    final void aeg()
    {
      AppMethodBeat.i(115591);
      if ((this.eglSurface != null) && (this.eglSurface != EGL10.EGL_NO_SURFACE))
      {
        Object localObject = this.egl;
        EGLDisplay localEGLDisplay = this.eglDisplay;
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        localObject = (GLTextureView)this.zJW.get();
        if (localObject != null) {
          GLTextureView.d((GLTextureView)localObject).destroySurface(this.egl, this.eglDisplay, this.eglSurface);
        }
        this.eglSurface = null;
      }
      AppMethodBeat.o(115591);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(115592);
      if (this.eglContext != null)
      {
        GLTextureView localGLTextureView = (GLTextureView)this.zJW.get();
        if (localGLTextureView != null) {
          GLTextureView.c(localGLTextureView).destroyContext(this.egl, this.eglDisplay, this.eglContext);
        }
        this.eglContext = null;
      }
      if (this.eglDisplay != null)
      {
        this.egl.eglTerminate(this.eglDisplay);
        this.eglDisplay = null;
      }
      AppMethodBeat.o(115592);
    }
  }
  
  public static final class i
    extends Thread
  {
    private GLTextureView.h CmQ;
    int height;
    boolean tG;
    private ArrayList<Runnable> tjA;
    int width;
    private WeakReference<GLTextureView> zJW;
    private boolean zJX;
    boolean zJY;
    private boolean zJZ;
    boolean zKa;
    private boolean zKb;
    boolean zKc;
    boolean zKd;
    boolean zKe;
    private boolean zKf;
    private int zKg;
    boolean zKh;
    boolean zKi;
    boolean zKj;
    
    i(WeakReference<GLTextureView> paramWeakReference)
    {
      AppMethodBeat.i(115595);
      this.tjA = new ArrayList();
      this.zKj = true;
      this.width = 0;
      this.height = 0;
      this.zKh = true;
      this.zKg = 1;
      this.zJW = paramWeakReference;
      AppMethodBeat.o(115595);
    }
    
    private void aeh()
    {
      AppMethodBeat.i(115597);
      if (this.zKe)
      {
        this.zKe = false;
        this.CmQ.aeg();
      }
      AppMethodBeat.o(115597);
    }
    
    private void aei()
    {
      AppMethodBeat.i(115598);
      if (this.zKd)
      {
        this.CmQ.finish();
        this.zKd = false;
        GLTextureView.eAq().c(this);
      }
      AppMethodBeat.o(115598);
    }
    
    /* Error */
    private void aej()
    {
      // Byte code:
      //   0: ldc 103
      //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: new 79	com/tencent/mm/plugin/voip/video/GLTextureView$h
      //   9: dup
      //   10: aload_0
      //   11: getfield 61	com/tencent/mm/plugin/voip/video/GLTextureView$i:zJW	Ljava/lang/ref/WeakReference;
      //   14: invokespecial 105	com/tencent/mm/plugin/voip/video/GLTextureView$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   17: putfield 77	com/tencent/mm/plugin/voip/video/GLTextureView$i:CmQ	Lcom/tencent/mm/plugin/voip/video/GLTextureView$h;
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 86	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKd	Z
      //   25: aload_0
      //   26: iconst_0
      //   27: putfield 75	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKe	Z
      //   30: iconst_0
      //   31: istore_1
      //   32: iconst_0
      //   33: istore_2
      //   34: iconst_0
      //   35: istore_3
      //   36: iconst_0
      //   37: istore 7
      //   39: iconst_0
      //   40: istore 4
      //   42: iconst_0
      //   43: istore 8
      //   45: iconst_0
      //   46: istore 5
      //   48: iconst_0
      //   49: istore 12
      //   51: iconst_0
      //   52: istore 9
      //   54: iconst_0
      //   55: istore 10
      //   57: aconst_null
      //   58: astore 22
      //   60: aconst_null
      //   61: astore 21
      //   63: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   66: astore 24
      //   68: aload 24
      //   70: monitorenter
      //   71: iload 12
      //   73: istore 11
      //   75: iload_1
      //   76: istore 6
      //   78: iload 7
      //   80: istore 12
      //   82: iload 11
      //   84: istore_1
      //   85: aload_0
      //   86: getfield 107	com/tencent/mm/plugin/voip/video/GLTextureView$i:zJX	Z
      //   89: ifeq +44 -> 133
      //   92: aload 24
      //   94: monitorexit
      //   95: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   98: astore 21
      //   100: aload 21
      //   102: monitorenter
      //   103: aload_0
      //   104: invokespecial 109	com/tencent/mm/plugin/voip/video/GLTextureView$i:aeh	()V
      //   107: aload_0
      //   108: invokespecial 111	com/tencent/mm/plugin/voip/video/GLTextureView$i:aei	()V
      //   111: aload 21
      //   113: monitorexit
      //   114: ldc 103
      //   116: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   119: return
      //   120: astore 22
      //   122: aload 21
      //   124: monitorexit
      //   125: ldc 103
      //   127: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   130: aload 22
      //   132: athrow
      //   133: aload_0
      //   134: getfield 49	com/tencent/mm/plugin/voip/video/GLTextureView$i:tjA	Ljava/util/ArrayList;
      //   137: invokevirtual 115	java/util/ArrayList:isEmpty	()Z
      //   140: ifne +71 -> 211
      //   143: aload_0
      //   144: getfield 49	com/tencent/mm/plugin/voip/video/GLTextureView$i:tjA	Ljava/util/ArrayList;
      //   147: iconst_0
      //   148: invokevirtual 119	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   151: checkcast 121	java/lang/Runnable
      //   154: astore 23
      //   156: iload_1
      //   157: istore 7
      //   159: iload 6
      //   161: istore_1
      //   162: iload_3
      //   163: istore 6
      //   165: iload 12
      //   167: istore_3
      //   168: iload 7
      //   170: istore 12
      //   172: iload_2
      //   173: istore 7
      //   175: iload 5
      //   177: istore_2
      //   178: aload 24
      //   180: monitorexit
      //   181: aload 23
      //   183: ifnull +998 -> 1181
      //   186: aload 23
      //   188: invokeinterface 124 1 0
      //   193: aconst_null
      //   194: astore 22
      //   196: iload_2
      //   197: istore 5
      //   199: iload 7
      //   201: istore_2
      //   202: iload_3
      //   203: istore 7
      //   205: iload 6
      //   207: istore_3
      //   208: goto -145 -> 63
      //   211: aload_0
      //   212: getfield 126	com/tencent/mm/plugin/voip/video/GLTextureView$i:tG	Z
      //   215: aload_0
      //   216: getfield 128	com/tencent/mm/plugin/voip/video/GLTextureView$i:zJZ	Z
      //   219: if_icmpeq +1691 -> 1910
      //   222: aload_0
      //   223: getfield 128	com/tencent/mm/plugin/voip/video/GLTextureView$i:zJZ	Z
      //   226: istore 19
      //   228: aload_0
      //   229: aload_0
      //   230: getfield 128	com/tencent/mm/plugin/voip/video/GLTextureView$i:zJZ	Z
      //   233: putfield 126	com/tencent/mm/plugin/voip/video/GLTextureView$i:tG	Z
      //   236: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   239: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   242: aload_0
      //   243: getfield 135	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKf	Z
      //   246: ifeq +1658 -> 1904
      //   249: aload_0
      //   250: invokespecial 109	com/tencent/mm/plugin/voip/video/GLTextureView$i:aeh	()V
      //   253: aload_0
      //   254: invokespecial 111	com/tencent/mm/plugin/voip/video/GLTextureView$i:aei	()V
      //   257: aload_0
      //   258: iconst_0
      //   259: putfield 135	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKf	Z
      //   262: iconst_1
      //   263: istore 7
      //   265: iload 12
      //   267: istore 11
      //   269: iload 12
      //   271: ifeq +14 -> 285
      //   274: aload_0
      //   275: invokespecial 109	com/tencent/mm/plugin/voip/video/GLTextureView$i:aeh	()V
      //   278: aload_0
      //   279: invokespecial 111	com/tencent/mm/plugin/voip/video/GLTextureView$i:aei	()V
      //   282: iconst_0
      //   283: istore 11
      //   285: iload 19
      //   287: ifeq +14 -> 301
      //   290: aload_0
      //   291: getfield 75	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKe	Z
      //   294: ifeq +7 -> 301
      //   297: aload_0
      //   298: invokespecial 109	com/tencent/mm/plugin/voip/video/GLTextureView$i:aeh	()V
      //   301: iload 19
      //   303: ifeq +48 -> 351
      //   306: aload_0
      //   307: getfield 86	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKd	Z
      //   310: ifeq +41 -> 351
      //   313: aload_0
      //   314: getfield 61	com/tencent/mm/plugin/voip/video/GLTextureView$i:zJW	Ljava/lang/ref/WeakReference;
      //   317: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   320: checkcast 6	com/tencent/mm/plugin/voip/video/GLTextureView
      //   323: astore 23
      //   325: aload 23
      //   327: ifnonnull +338 -> 665
      //   330: iconst_0
      //   331: istore 20
      //   333: iload 20
      //   335: ifeq +12 -> 347
      //   338: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   341: invokevirtual 144	com/tencent/mm/plugin/voip/video/GLTextureView$j:dXU	()Z
      //   344: ifeq +7 -> 351
      //   347: aload_0
      //   348: invokespecial 111	com/tencent/mm/plugin/voip/video/GLTextureView$i:aei	()V
      //   351: iload 19
      //   353: ifeq +19 -> 372
      //   356: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   359: invokevirtual 147	com/tencent/mm/plugin/voip/video/GLTextureView$j:dXV	()Z
      //   362: ifeq +10 -> 372
      //   365: aload_0
      //   366: getfield 77	com/tencent/mm/plugin/voip/video/GLTextureView$i:CmQ	Lcom/tencent/mm/plugin/voip/video/GLTextureView$h;
      //   369: invokevirtual 89	com/tencent/mm/plugin/voip/video/GLTextureView$h:finish	()V
      //   372: aload_0
      //   373: getfield 149	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKa	Z
      //   376: ifne +37 -> 413
      //   379: aload_0
      //   380: getfield 151	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKc	Z
      //   383: ifne +30 -> 413
      //   386: aload_0
      //   387: getfield 75	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKe	Z
      //   390: ifeq +7 -> 397
      //   393: aload_0
      //   394: invokespecial 109	com/tencent/mm/plugin/voip/video/GLTextureView$i:aeh	()V
      //   397: aload_0
      //   398: iconst_1
      //   399: putfield 151	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKc	Z
      //   402: aload_0
      //   403: iconst_0
      //   404: putfield 153	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKb	Z
      //   407: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   410: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   413: aload_0
      //   414: getfield 149	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKa	Z
      //   417: ifeq +21 -> 438
      //   420: aload_0
      //   421: getfield 151	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKc	Z
      //   424: ifeq +14 -> 438
      //   427: aload_0
      //   428: iconst_0
      //   429: putfield 151	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKc	Z
      //   432: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   435: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   438: iload 5
      //   440: istore 12
      //   442: iload 8
      //   444: istore 13
      //   446: iload 5
      //   448: ifeq +20 -> 468
      //   451: iconst_0
      //   452: istore 13
      //   454: iconst_0
      //   455: istore 12
      //   457: aload_0
      //   458: iconst_1
      //   459: putfield 155	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKi	Z
      //   462: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   465: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   468: iload_2
      //   469: istore 18
      //   471: iload 7
      //   473: istore 14
      //   475: iload 4
      //   477: istore 17
      //   479: iload_3
      //   480: istore 15
      //   482: iload 6
      //   484: istore 16
      //   486: aload_0
      //   487: invokevirtual 158	com/tencent/mm/plugin/voip/video/GLTextureView$i:ael	()Z
      //   490: ifeq +653 -> 1143
      //   493: iload 7
      //   495: istore 5
      //   497: iload 6
      //   499: istore_1
      //   500: aload_0
      //   501: getfield 86	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKd	Z
      //   504: ifne +14 -> 518
      //   507: iload 7
      //   509: ifeq +166 -> 675
      //   512: iconst_0
      //   513: istore 5
      //   515: iload 6
      //   517: istore_1
      //   518: iload_2
      //   519: istore 8
      //   521: iload 4
      //   523: istore 7
      //   525: iload_3
      //   526: istore 6
      //   528: aload_0
      //   529: getfield 86	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKd	Z
      //   532: ifeq +34 -> 566
      //   535: iload_2
      //   536: istore 8
      //   538: iload 4
      //   540: istore 7
      //   542: iload_3
      //   543: istore 6
      //   545: aload_0
      //   546: getfield 75	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKe	Z
      //   549: ifne +17 -> 566
      //   552: aload_0
      //   553: iconst_1
      //   554: putfield 75	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKe	Z
      //   557: iconst_1
      //   558: istore 8
      //   560: iconst_1
      //   561: istore 6
      //   563: iconst_1
      //   564: istore 7
      //   566: iload 8
      //   568: istore 18
      //   570: iload 5
      //   572: istore 14
      //   574: iload 7
      //   576: istore 17
      //   578: iload 6
      //   580: istore 15
      //   582: iload_1
      //   583: istore 16
      //   585: aload_0
      //   586: getfield 75	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKe	Z
      //   589: ifeq +554 -> 1143
      //   592: aload_0
      //   593: getfield 51	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKj	Z
      //   596: ifeq +1287 -> 1883
      //   599: iconst_1
      //   600: istore 4
      //   602: aload_0
      //   603: getfield 53	com/tencent/mm/plugin/voip/video/GLTextureView$i:width	I
      //   606: istore_2
      //   607: aload_0
      //   608: getfield 55	com/tencent/mm/plugin/voip/video/GLTextureView$i:height	I
      //   611: istore 9
      //   613: iconst_1
      //   614: istore 8
      //   616: iconst_1
      //   617: istore_3
      //   618: aload_0
      //   619: iconst_0
      //   620: putfield 51	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKj	Z
      //   623: aload_0
      //   624: iconst_0
      //   625: putfield 57	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKh	Z
      //   628: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   631: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   634: iload_2
      //   635: istore 13
      //   637: iload 12
      //   639: istore_2
      //   640: iload_3
      //   641: istore 7
      //   643: aload 22
      //   645: astore 23
      //   647: iload 9
      //   649: istore 10
      //   651: iload 13
      //   653: istore 9
      //   655: iload 5
      //   657: istore 12
      //   659: iload 11
      //   661: istore_3
      //   662: goto -484 -> 178
      //   665: aload 23
      //   667: invokestatic 162	com/tencent/mm/plugin/voip/video/GLTextureView:g	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)Z
      //   670: istore 20
      //   672: goto -339 -> 333
      //   675: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   678: astore 23
      //   680: aload 23
      //   682: getfield 166	com/tencent/mm/plugin/voip/video/GLTextureView$j:CmR	Lcom/tencent/mm/plugin/voip/video/GLTextureView$i;
      //   685: aload_0
      //   686: if_acmpeq +11 -> 697
      //   689: aload 23
      //   691: getfield 166	com/tencent/mm/plugin/voip/video/GLTextureView$j:CmR	Lcom/tencent/mm/plugin/voip/video/GLTextureView$i;
      //   694: ifnonnull +153 -> 847
      //   697: aload 23
      //   699: aload_0
      //   700: putfield 166	com/tencent/mm/plugin/voip/video/GLTextureView$j:CmR	Lcom/tencent/mm/plugin/voip/video/GLTextureView$i;
      //   703: aload 23
      //   705: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   708: iconst_1
      //   709: istore 8
      //   711: iload 7
      //   713: istore 5
      //   715: iload 6
      //   717: istore_1
      //   718: iload 8
      //   720: ifeq -202 -> 518
      //   723: aload_0
      //   724: getfield 77	com/tencent/mm/plugin/voip/video/GLTextureView$i:CmQ	Lcom/tencent/mm/plugin/voip/video/GLTextureView$h;
      //   727: astore 23
      //   729: aload 23
      //   731: invokestatic 172	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
      //   734: checkcast 174	javax/microedition/khronos/egl/EGL10
      //   737: putfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   740: aload 23
      //   742: aload 23
      //   744: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   747: getstatic 182	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
      //   750: invokeinterface 186 2 0
      //   755: putfield 190	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   758: aload 23
      //   760: getfield 190	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   763: getstatic 193	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   766: if_acmpne +129 -> 895
      //   769: new 102	java/lang/RuntimeException
      //   772: dup
      //   773: ldc 195
      //   775: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   778: astore 21
      //   780: ldc 103
      //   782: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   785: aload 21
      //   787: athrow
      //   788: astore 21
      //   790: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   793: aload_0
      //   794: invokevirtual 99	com/tencent/mm/plugin/voip/video/GLTextureView$j:c	(Lcom/tencent/mm/plugin/voip/video/GLTextureView$i;)V
      //   797: ldc 103
      //   799: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   802: aload 21
      //   804: athrow
      //   805: astore 21
      //   807: aload 24
      //   809: monitorexit
      //   810: ldc 103
      //   812: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   815: aload 21
      //   817: athrow
      //   818: astore 22
      //   820: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   823: astore 21
      //   825: aload 21
      //   827: monitorenter
      //   828: aload_0
      //   829: invokespecial 109	com/tencent/mm/plugin/voip/video/GLTextureView$i:aeh	()V
      //   832: aload_0
      //   833: invokespecial 111	com/tencent/mm/plugin/voip/video/GLTextureView$i:aei	()V
      //   836: aload 21
      //   838: monitorexit
      //   839: ldc 103
      //   841: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   844: aload 22
      //   846: athrow
      //   847: aload 23
      //   849: invokevirtual 201	com/tencent/mm/plugin/voip/video/GLTextureView$j:dXW	()V
      //   852: aload 23
      //   854: getfield 204	com/tencent/mm/plugin/voip/video/GLTextureView$j:zKo	Z
      //   857: ifeq +9 -> 866
      //   860: iconst_1
      //   861: istore 8
      //   863: goto -152 -> 711
      //   866: aload 23
      //   868: getfield 166	com/tencent/mm/plugin/voip/video/GLTextureView$j:CmR	Lcom/tencent/mm/plugin/voip/video/GLTextureView$i;
      //   871: ifnull +18 -> 889
      //   874: aload 23
      //   876: getfield 166	com/tencent/mm/plugin/voip/video/GLTextureView$j:CmR	Lcom/tencent/mm/plugin/voip/video/GLTextureView$i;
      //   879: iconst_1
      //   880: putfield 135	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKf	Z
      //   883: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   886: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   889: iconst_0
      //   890: istore 8
      //   892: goto -181 -> 711
      //   895: iconst_2
      //   896: newarray int
      //   898: astore 25
      //   900: aload 23
      //   902: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   905: aload 23
      //   907: getfield 190	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   910: aload 25
      //   912: invokeinterface 208 3 0
      //   917: ifne +22 -> 939
      //   920: new 102	java/lang/RuntimeException
      //   923: dup
      //   924: ldc 210
      //   926: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   929: astore 21
      //   931: ldc 103
      //   933: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   936: aload 21
      //   938: athrow
      //   939: aload 23
      //   941: getfield 211	com/tencent/mm/plugin/voip/video/GLTextureView$h:zJW	Ljava/lang/ref/WeakReference;
      //   944: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   947: checkcast 6	com/tencent/mm/plugin/voip/video/GLTextureView
      //   950: astore 25
      //   952: aload 25
      //   954: ifnonnull +105 -> 1059
      //   957: aload 23
      //   959: aconst_null
      //   960: putfield 215	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   963: aload 23
      //   965: aconst_null
      //   966: putfield 219	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   969: aload 23
      //   971: getfield 219	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   974: ifnull +14 -> 988
      //   977: aload 23
      //   979: getfield 219	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   982: getstatic 222	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
      //   985: if_acmpne +132 -> 1117
      //   988: aload 23
      //   990: aconst_null
      //   991: putfield 219	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   994: ldc 224
      //   996: aload 23
      //   998: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1001: invokeinterface 228 1 0
      //   1006: invokestatic 232	com/tencent/mm/plugin/voip/video/GLTextureView$h:O	(Ljava/lang/String;I)Ljava/lang/String;
      //   1009: astore 21
      //   1011: new 234	java/lang/StringBuilder
      //   1014: dup
      //   1015: ldc 236
      //   1017: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1020: invokestatic 241	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   1023: invokevirtual 245	java/lang/Thread:getId	()J
      //   1026: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1029: ldc 251
      //   1031: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1034: aload 21
      //   1036: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1039: pop
      //   1040: new 102	java/lang/RuntimeException
      //   1043: dup
      //   1044: aload 21
      //   1046: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1049: astore 21
      //   1051: ldc 103
      //   1053: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1056: aload 21
      //   1058: athrow
      //   1059: aload 23
      //   1061: aload 25
      //   1063: invokestatic 258	com/tencent/mm/plugin/voip/video/GLTextureView:b	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)Lcom/tencent/mm/plugin/voip/video/GLTextureView$e;
      //   1066: aload 23
      //   1068: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1071: aload 23
      //   1073: getfield 190	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1076: invokeinterface 264 3 0
      //   1081: putfield 215	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1084: aload 23
      //   1086: aload 25
      //   1088: invokestatic 267	com/tencent/mm/plugin/voip/video/GLTextureView:c	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)Lcom/tencent/mm/plugin/voip/video/GLTextureView$f;
      //   1091: aload 23
      //   1093: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1096: aload 23
      //   1098: getfield 190	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1101: aload 23
      //   1103: getfield 215	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1106: invokeinterface 272 4 0
      //   1111: putfield 219	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   1114: goto -145 -> 969
      //   1117: aload 23
      //   1119: aconst_null
      //   1120: putfield 276	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1123: aload_0
      //   1124: iconst_1
      //   1125: putfield 86	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKd	Z
      //   1128: iconst_1
      //   1129: istore_1
      //   1130: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   1133: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   1136: iload 7
      //   1138: istore 5
      //   1140: goto -622 -> 518
      //   1143: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   1146: invokevirtual 279	java/lang/Object:wait	()V
      //   1149: iload 14
      //   1151: istore_1
      //   1152: iload 12
      //   1154: istore 5
      //   1156: iload 18
      //   1158: istore_2
      //   1159: iload 13
      //   1161: istore 8
      //   1163: iload 17
      //   1165: istore 4
      //   1167: iload 11
      //   1169: istore 12
      //   1171: iload 15
      //   1173: istore_3
      //   1174: iload 16
      //   1176: istore 6
      //   1178: goto -1093 -> 85
      //   1181: iload 7
      //   1183: ifeq +693 -> 1876
      //   1186: aload_0
      //   1187: getfield 77	com/tencent/mm/plugin/voip/video/GLTextureView$i:CmQ	Lcom/tencent/mm/plugin/voip/video/GLTextureView$h;
      //   1190: astore 22
      //   1192: aload 22
      //   1194: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1197: ifnonnull +23 -> 1220
      //   1200: new 102	java/lang/RuntimeException
      //   1203: dup
      //   1204: ldc_w 281
      //   1207: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1210: astore 21
      //   1212: ldc 103
      //   1214: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1217: aload 21
      //   1219: athrow
      //   1220: aload 22
      //   1222: getfield 190	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1225: ifnonnull +23 -> 1248
      //   1228: new 102	java/lang/RuntimeException
      //   1231: dup
      //   1232: ldc_w 283
      //   1235: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1238: astore 21
      //   1240: ldc 103
      //   1242: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1245: aload 21
      //   1247: athrow
      //   1248: aload 22
      //   1250: getfield 215	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1253: ifnonnull +23 -> 1276
      //   1256: new 102	java/lang/RuntimeException
      //   1259: dup
      //   1260: ldc_w 285
      //   1263: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1266: astore 21
      //   1268: ldc 103
      //   1270: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1273: aload 21
      //   1275: athrow
      //   1276: aload 22
      //   1278: invokevirtual 82	com/tencent/mm/plugin/voip/video/GLTextureView$h:aeg	()V
      //   1281: aload 22
      //   1283: getfield 211	com/tencent/mm/plugin/voip/video/GLTextureView$h:zJW	Ljava/lang/ref/WeakReference;
      //   1286: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1289: checkcast 6	com/tencent/mm/plugin/voip/video/GLTextureView
      //   1292: astore 24
      //   1294: aload 24
      //   1296: ifnull +138 -> 1434
      //   1299: aload 24
      //   1301: invokevirtual 289	com/tencent/mm/plugin/voip/video/GLTextureView:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
      //   1304: ifnull +130 -> 1434
      //   1307: aload 22
      //   1309: aload 24
      //   1311: invokestatic 293	com/tencent/mm/plugin/voip/video/GLTextureView:d	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)Lcom/tencent/mm/plugin/voip/video/GLTextureView$g;
      //   1314: aload 22
      //   1316: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1319: aload 22
      //   1321: getfield 190	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1324: aload 22
      //   1326: getfield 215	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1329: aload 24
      //   1331: invokevirtual 289	com/tencent/mm/plugin/voip/video/GLTextureView:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
      //   1334: invokeinterface 299 5 0
      //   1339: putfield 276	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1342: aload 22
      //   1344: getfield 276	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1347: ifnull +14 -> 1361
      //   1350: aload 22
      //   1352: getfield 276	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1355: getstatic 302	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1358: if_acmpne +85 -> 1443
      //   1361: aload 22
      //   1363: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1366: invokeinterface 228 1 0
      //   1371: pop
      //   1372: iconst_0
      //   1373: istore 5
      //   1375: iload 5
      //   1377: ifne +554 -> 1931
      //   1380: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   1383: astore 22
      //   1385: aload 22
      //   1387: monitorenter
      //   1388: aload_0
      //   1389: iconst_1
      //   1390: putfield 153	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKb	Z
      //   1393: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   1396: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   1399: aload 22
      //   1401: monitorexit
      //   1402: iload_2
      //   1403: istore 5
      //   1405: iload 7
      //   1407: istore_2
      //   1408: aload 23
      //   1410: astore 22
      //   1412: iload_3
      //   1413: istore 7
      //   1415: iload 6
      //   1417: istore_3
      //   1418: goto -1355 -> 63
      //   1421: astore 21
      //   1423: aload 22
      //   1425: monitorexit
      //   1426: ldc 103
      //   1428: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1431: aload 21
      //   1433: athrow
      //   1434: aload 22
      //   1436: aconst_null
      //   1437: putfield 276	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1440: goto -98 -> 1342
      //   1443: aload 22
      //   1445: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1448: aload 22
      //   1450: getfield 190	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1453: aload 22
      //   1455: getfield 276	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1458: aload 22
      //   1460: getfield 276	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1463: aload 22
      //   1465: getfield 219	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   1468: invokeinterface 306 5 0
      //   1473: ifne +452 -> 1925
      //   1476: ldc_w 307
      //   1479: aload 22
      //   1481: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1484: invokeinterface 228 1 0
      //   1489: invokestatic 232	com/tencent/mm/plugin/voip/video/GLTextureView$h:O	(Ljava/lang/String;I)Ljava/lang/String;
      //   1492: pop
      //   1493: iconst_0
      //   1494: istore 5
      //   1496: goto -121 -> 1375
      //   1499: iload 6
      //   1501: ifeq +372 -> 1873
      //   1504: aload_0
      //   1505: getfield 77	com/tencent/mm/plugin/voip/video/GLTextureView$i:CmQ	Lcom/tencent/mm/plugin/voip/video/GLTextureView$h;
      //   1508: astore 22
      //   1510: aload 22
      //   1512: getfield 219	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   1515: invokevirtual 311	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1518: astore 21
      //   1520: aload 22
      //   1522: getfield 211	com/tencent/mm/plugin/voip/video/GLTextureView$h:zJW	Ljava/lang/ref/WeakReference;
      //   1525: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1528: checkcast 6	com/tencent/mm/plugin/voip/video/GLTextureView
      //   1531: astore 24
      //   1533: aload 21
      //   1535: astore 22
      //   1537: aload 24
      //   1539: ifnull +327 -> 1866
      //   1542: aload 24
      //   1544: invokestatic 315	com/tencent/mm/plugin/voip/video/GLTextureView:e	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)Lcom/tencent/mm/plugin/voip/video/GLTextureView$k;
      //   1547: ifnull +15 -> 1562
      //   1550: aload 24
      //   1552: invokestatic 315	com/tencent/mm/plugin/voip/video/GLTextureView:e	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)Lcom/tencent/mm/plugin/voip/video/GLTextureView$k;
      //   1555: invokeinterface 320 1 0
      //   1560: astore 21
      //   1562: aload 21
      //   1564: astore 22
      //   1566: aload 24
      //   1568: invokestatic 324	com/tencent/mm/plugin/voip/video/GLTextureView:f	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)I
      //   1571: iconst_3
      //   1572: iand
      //   1573: ifeq +293 -> 1866
      //   1576: iconst_0
      //   1577: istore 6
      //   1579: aload 24
      //   1581: invokestatic 324	com/tencent/mm/plugin/voip/video/GLTextureView:f	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)I
      //   1584: iconst_1
      //   1585: iand
      //   1586: ifeq +6 -> 1592
      //   1589: iconst_1
      //   1590: istore 6
      //   1592: aload 24
      //   1594: invokestatic 324	com/tencent/mm/plugin/voip/video/GLTextureView:f	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)I
      //   1597: iconst_2
      //   1598: iand
      //   1599: ifeq +320 -> 1919
      //   1602: new 326	com/tencent/mm/plugin/voip/video/GLTextureView$l
      //   1605: dup
      //   1606: invokespecial 327	com/tencent/mm/plugin/voip/video/GLTextureView$l:<init>	()V
      //   1609: astore 22
      //   1611: aload 21
      //   1613: iload 6
      //   1615: aload 22
      //   1617: invokestatic 333	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
      //   1620: astore 21
      //   1622: aload 21
      //   1624: checkcast 335	javax/microedition/khronos/opengles/GL10
      //   1627: astore 21
      //   1629: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   1632: aload 21
      //   1634: invokevirtual 338	com/tencent/mm/plugin/voip/video/GLTextureView$j:b	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   1637: iconst_0
      //   1638: istore 6
      //   1640: iload_1
      //   1641: istore 11
      //   1643: iload_1
      //   1644: ifeq +42 -> 1686
      //   1647: aload_0
      //   1648: getfield 61	com/tencent/mm/plugin/voip/video/GLTextureView$i:zJW	Ljava/lang/ref/WeakReference;
      //   1651: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1654: checkcast 6	com/tencent/mm/plugin/voip/video/GLTextureView
      //   1657: astore 22
      //   1659: aload 22
      //   1661: ifnull +276 -> 1937
      //   1664: aload 22
      //   1666: invokestatic 342	com/tencent/mm/plugin/voip/video/GLTextureView:h	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)Lcom/tencent/mm/plugin/voip/video/GLTextureView$m;
      //   1669: aload 21
      //   1671: aload_0
      //   1672: getfield 77	com/tencent/mm/plugin/voip/video/GLTextureView$i:CmQ	Lcom/tencent/mm/plugin/voip/video/GLTextureView$h;
      //   1675: getfield 215	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1678: invokeinterface 348 3 0
      //   1683: goto +254 -> 1937
      //   1686: iload 4
      //   1688: istore_1
      //   1689: iload 4
      //   1691: ifeq +39 -> 1730
      //   1694: aload_0
      //   1695: getfield 61	com/tencent/mm/plugin/voip/video/GLTextureView$i:zJW	Ljava/lang/ref/WeakReference;
      //   1698: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1701: checkcast 6	com/tencent/mm/plugin/voip/video/GLTextureView
      //   1704: astore 22
      //   1706: aload 22
      //   1708: ifnull +235 -> 1943
      //   1711: aload 22
      //   1713: invokestatic 342	com/tencent/mm/plugin/voip/video/GLTextureView:h	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)Lcom/tencent/mm/plugin/voip/video/GLTextureView$m;
      //   1716: aload 21
      //   1718: iload 9
      //   1720: iload 10
      //   1722: invokeinterface 352 4 0
      //   1727: goto +216 -> 1943
      //   1730: aload_0
      //   1731: getfield 61	com/tencent/mm/plugin/voip/video/GLTextureView$i:zJW	Ljava/lang/ref/WeakReference;
      //   1734: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1737: checkcast 6	com/tencent/mm/plugin/voip/video/GLTextureView
      //   1740: astore 22
      //   1742: aload 22
      //   1744: ifnull +15 -> 1759
      //   1747: aload 22
      //   1749: invokestatic 342	com/tencent/mm/plugin/voip/video/GLTextureView:h	(Lcom/tencent/mm/plugin/voip/video/GLTextureView;)Lcom/tencent/mm/plugin/voip/video/GLTextureView$m;
      //   1752: aload 21
      //   1754: invokeinterface 355 2 0
      //   1759: aload_0
      //   1760: getfield 77	com/tencent/mm/plugin/voip/video/GLTextureView$i:CmQ	Lcom/tencent/mm/plugin/voip/video/GLTextureView$h;
      //   1763: astore 22
      //   1765: aload 22
      //   1767: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1770: aload 22
      //   1772: getfield 190	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1775: aload 22
      //   1777: getfield 276	com/tencent/mm/plugin/voip/video/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1780: invokeinterface 359 3 0
      //   1785: ifne +229 -> 2014
      //   1788: aload 22
      //   1790: getfield 178	com/tencent/mm/plugin/voip/video/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1793: invokeinterface 228 1 0
      //   1798: istore 4
      //   1800: goto +148 -> 1948
      //   1803: ldc_w 360
      //   1806: iload 4
      //   1808: invokestatic 232	com/tencent/mm/plugin/voip/video/GLTextureView$h:O	(Ljava/lang/String;I)Ljava/lang/String;
      //   1811: pop
      //   1812: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   1815: astore 22
      //   1817: aload 22
      //   1819: monitorenter
      //   1820: aload_0
      //   1821: iconst_1
      //   1822: putfield 153	com/tencent/mm/plugin/voip/video/GLTextureView$i:zKb	Z
      //   1825: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   1828: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   1831: aload 22
      //   1833: monitorexit
      //   1834: iload_3
      //   1835: istore 7
      //   1837: goto +146 -> 1983
      //   1840: astore 21
      //   1842: aload 22
      //   1844: monitorexit
      //   1845: ldc 103
      //   1847: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1850: aload 21
      //   1852: athrow
      //   1853: astore 22
      //   1855: aload 21
      //   1857: monitorexit
      //   1858: ldc 103
      //   1860: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1863: aload 22
      //   1865: athrow
      //   1866: aload 22
      //   1868: astore 21
      //   1870: goto -248 -> 1622
      //   1873: goto -233 -> 1640
      //   1876: iload 7
      //   1878: istore 5
      //   1880: goto -381 -> 1499
      //   1883: iload 9
      //   1885: istore_2
      //   1886: iload 10
      //   1888: istore 9
      //   1890: iload 8
      //   1892: istore_3
      //   1893: iload 13
      //   1895: istore 8
      //   1897: iload 7
      //   1899: istore 4
      //   1901: goto -1278 -> 623
      //   1904: iload_1
      //   1905: istore 7
      //   1907: goto -1642 -> 265
      //   1910: iconst_0
      //   1911: istore 19
      //   1913: goto -1671 -> 242
      //   1916: goto +74 -> 1990
      //   1919: aconst_null
      //   1920: astore 22
      //   1922: goto -311 -> 1611
      //   1925: iconst_1
      //   1926: istore 5
      //   1928: goto -553 -> 1375
      //   1931: iconst_0
      //   1932: istore 5
      //   1934: goto -435 -> 1499
      //   1937: iconst_0
      //   1938: istore 11
      //   1940: goto -254 -> 1686
      //   1943: iconst_0
      //   1944: istore_1
      //   1945: goto -215 -> 1730
      //   1948: iload_3
      //   1949: istore 7
      //   1951: iload 4
      //   1953: lookupswitch	default:+27->1980, 12288:+30->1983, 12302:+69->2022
      //   1981: impdep2
      //   1982: iastore
      //   1983: iload 8
      //   1985: ifeq -69 -> 1916
      //   1988: iconst_1
      //   1989: istore_2
      //   1990: iload 5
      //   1992: istore_3
      //   1993: iload_2
      //   1994: istore 5
      //   1996: iload_3
      //   1997: istore_2
      //   1998: aload 23
      //   2000: astore 22
      //   2002: iload_1
      //   2003: istore 4
      //   2005: iload 6
      //   2007: istore_3
      //   2008: iload 11
      //   2010: istore_1
      //   2011: goto -1948 -> 63
      //   2014: sipush 12288
      //   2017: istore 4
      //   2019: goto -71 -> 1948
      //   2022: iconst_1
      //   2023: istore 7
      //   2025: goto -42 -> 1983
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2028	0	this	i
      //   31	1980	1	i	int
      //   33	1965	2	j	int
      //   35	1973	3	k	int
      //   40	1978	4	m	int
      //   46	1949	5	n	int
      //   76	1930	6	i1	int
      //   37	1987	7	i2	int
      //   43	1941	8	i3	int
      //   52	1837	9	i4	int
      //   55	1832	10	i5	int
      //   73	1936	11	i6	int
      //   49	1121	12	i7	int
      //   444	1450	13	i8	int
      //   473	677	14	i9	int
      //   480	692	15	i10	int
      //   484	691	16	i11	int
      //   477	687	17	i12	int
      //   469	688	18	i13	int
      //   226	1686	19	bool1	boolean
      //   331	340	20	bool2	boolean
      //   788	15	21	localRuntimeException	java.lang.RuntimeException
      //   805	11	21	localObject2	Object
      //   1421	11	21	localObject4	Object
      //   1518	235	21	localObject5	Object
      //   1840	16	21	localObject6	Object
      //   1868	1	21	localObject7	Object
      //   58	1	22	localObject8	Object
      //   120	11	22	localObject9	Object
      //   194	450	22	localObject10	Object
      //   818	27	22	localObject11	Object
      //   1853	14	22	localObject13	Object
      //   1920	81	22	localObject14	Object
      //   154	1845	23	localObject15	Object
      //   66	1527	24	localObject16	Object
      //   898	189	25	localObject17	Object
      // Exception table:
      //   from	to	target	type
      //   103	114	120	finally
      //   122	125	120	finally
      //   723	788	788	java/lang/RuntimeException
      //   895	939	788	java/lang/RuntimeException
      //   939	952	788	java/lang/RuntimeException
      //   957	969	788	java/lang/RuntimeException
      //   969	988	788	java/lang/RuntimeException
      //   988	1059	788	java/lang/RuntimeException
      //   1059	1114	788	java/lang/RuntimeException
      //   1117	1123	788	java/lang/RuntimeException
      //   85	95	805	finally
      //   133	156	805	finally
      //   178	181	805	finally
      //   211	242	805	finally
      //   242	262	805	finally
      //   274	282	805	finally
      //   290	301	805	finally
      //   306	325	805	finally
      //   338	347	805	finally
      //   347	351	805	finally
      //   356	372	805	finally
      //   372	397	805	finally
      //   397	413	805	finally
      //   413	438	805	finally
      //   457	468	805	finally
      //   486	493	805	finally
      //   500	507	805	finally
      //   528	535	805	finally
      //   545	557	805	finally
      //   585	599	805	finally
      //   602	613	805	finally
      //   618	623	805	finally
      //   623	634	805	finally
      //   665	672	805	finally
      //   675	697	805	finally
      //   697	708	805	finally
      //   723	788	805	finally
      //   790	805	805	finally
      //   807	810	805	finally
      //   847	860	805	finally
      //   866	889	805	finally
      //   895	939	805	finally
      //   939	952	805	finally
      //   957	969	805	finally
      //   969	988	805	finally
      //   988	1059	805	finally
      //   1059	1114	805	finally
      //   1117	1123	805	finally
      //   1123	1128	805	finally
      //   1130	1136	805	finally
      //   1143	1149	805	finally
      //   63	71	818	finally
      //   186	193	818	finally
      //   810	818	818	finally
      //   1186	1220	818	finally
      //   1220	1248	818	finally
      //   1248	1276	818	finally
      //   1276	1294	818	finally
      //   1299	1342	818	finally
      //   1342	1361	818	finally
      //   1361	1372	818	finally
      //   1380	1388	818	finally
      //   1426	1434	818	finally
      //   1434	1440	818	finally
      //   1443	1493	818	finally
      //   1504	1533	818	finally
      //   1542	1562	818	finally
      //   1566	1576	818	finally
      //   1579	1589	818	finally
      //   1592	1611	818	finally
      //   1611	1622	818	finally
      //   1622	1637	818	finally
      //   1647	1659	818	finally
      //   1664	1683	818	finally
      //   1694	1706	818	finally
      //   1711	1727	818	finally
      //   1730	1742	818	finally
      //   1747	1759	818	finally
      //   1759	1800	818	finally
      //   1803	1820	818	finally
      //   1845	1853	818	finally
      //   1388	1402	1421	finally
      //   1423	1426	1421	finally
      //   1820	1834	1840	finally
      //   1842	1845	1840	finally
      //   828	839	1853	finally
      //   1855	1858	1853	finally
    }
    
    final boolean ael()
    {
      return (!this.tG) && (this.zKa) && (!this.zKb) && (this.width > 0) && (this.height > 0) && ((this.zKh) || (this.zKg == 1));
    }
    
    public final void dXT()
    {
      AppMethodBeat.i(115603);
      synchronized (GLTextureView.eAq())
      {
        this.zJX = true;
        GLTextureView.eAq().notifyAll();
        for (;;)
        {
          boolean bool = this.zJY;
          if (!bool) {
            try
            {
              GLTextureView.eAq().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
      AppMethodBeat.o(115603);
    }
    
    public final int getRenderMode()
    {
      AppMethodBeat.i(115601);
      synchronized (GLTextureView.eAq())
      {
        int i = this.zKg;
        AppMethodBeat.o(115601);
        return i;
      }
    }
    
    public final void queueEvent(Runnable paramRunnable)
    {
      AppMethodBeat.i(216536);
      if (paramRunnable == null)
      {
        paramRunnable = new IllegalArgumentException("r must not be null");
        AppMethodBeat.o(216536);
        throw paramRunnable;
      }
      synchronized (GLTextureView.eAq())
      {
        this.tjA.add(paramRunnable);
        GLTextureView.eAq().notifyAll();
        AppMethodBeat.o(216536);
        return;
      }
    }
    
    public final void requestRender()
    {
      AppMethodBeat.i(115602);
      synchronized (GLTextureView.eAq())
      {
        this.zKh = true;
        GLTextureView.eAq().notifyAll();
        AppMethodBeat.o(115602);
        return;
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc_w 384
      //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: new 234	java/lang/StringBuilder
      //   10: dup
      //   11: ldc_w 386
      //   14: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   17: aload_0
      //   18: invokevirtual 387	com/tencent/mm/plugin/voip/video/GLTextureView$i:getId	()J
      //   21: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   24: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   27: invokevirtual 394	com/tencent/mm/plugin/voip/video/GLTextureView$i:setName	(Ljava/lang/String;)V
      //   30: new 234	java/lang/StringBuilder
      //   33: dup
      //   34: ldc_w 396
      //   37: invokespecial 237	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   40: aload_0
      //   41: invokevirtual 387	com/tencent/mm/plugin/voip/video/GLTextureView$i:getId	()J
      //   44: invokevirtual 249	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   47: pop
      //   48: aload_0
      //   49: invokespecial 398	com/tencent/mm/plugin/voip/video/GLTextureView$i:aej	()V
      //   52: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   55: aload_0
      //   56: invokevirtual 400	com/tencent/mm/plugin/voip/video/GLTextureView$j:b	(Lcom/tencent/mm/plugin/voip/video/GLTextureView$i;)V
      //   59: ldc_w 384
      //   62: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   65: return
      //   66: astore_1
      //   67: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   70: aload_0
      //   71: invokevirtual 400	com/tencent/mm/plugin/voip/video/GLTextureView$j:b	(Lcom/tencent/mm/plugin/voip/video/GLTextureView$i;)V
      //   74: ldc_w 384
      //   77: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   80: return
      //   81: astore_1
      //   82: invokestatic 93	com/tencent/mm/plugin/voip/video/GLTextureView:eAq	()Lcom/tencent/mm/plugin/voip/video/GLTextureView$j;
      //   85: aload_0
      //   86: invokevirtual 400	com/tencent/mm/plugin/voip/video/GLTextureView$j:b	(Lcom/tencent/mm/plugin/voip/video/GLTextureView$i;)V
      //   89: ldc_w 384
      //   92: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   95: aload_1
      //   96: athrow
      //   97: astore_1
      //   98: goto -31 -> 67
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	i
      //   66	1	1	localInterruptedException	InterruptedException
      //   81	15	1	localObject	Object
      //   97	1	1	localRuntimeException	java.lang.RuntimeException
      // Exception table:
      //   from	to	target	type
      //   48	52	66	java/lang/InterruptedException
      //   48	52	81	finally
      //   48	52	97	java/lang/RuntimeException
    }
    
    public final void setRenderMode(int paramInt)
    {
      AppMethodBeat.i(115600);
      if ((paramInt < 0) || (paramInt > 1))
      {
        ??? = new IllegalArgumentException("renderMode");
        AppMethodBeat.o(115600);
        throw ((Throwable)???);
      }
      synchronized (GLTextureView.eAq())
      {
        this.zKg = paramInt;
        GLTextureView.eAq().notifyAll();
        AppMethodBeat.o(115600);
        return;
      }
    }
  }
  
  static final class j
  {
    private static String TAG = "GLThreadManager";
    GLTextureView.i CmR;
    private boolean zKl;
    private int zKm;
    private boolean zKn;
    boolean zKo;
    private boolean zKp;
    
    public final void b(GLTextureView.i parami)
    {
      try
      {
        AppMethodBeat.i(115604);
        new StringBuilder("exiting tid=").append(parami.getId());
        GLTextureView.i.a(parami);
        if (this.CmR == parami) {
          this.CmR = null;
        }
        notifyAll();
        AppMethodBeat.o(115604);
        return;
      }
      finally {}
    }
    
    /* Error */
    public final void b(javax.microedition.khronos.opengles.GL10 paramGL10)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 70
      //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 72	com/tencent/mm/plugin/voip/video/GLTextureView$j:zKn	Z
      //   13: ifne +65 -> 78
      //   16: aload_0
      //   17: invokevirtual 75	com/tencent/mm/plugin/voip/video/GLTextureView$j:dXW	()V
      //   20: aload_1
      //   21: sipush 7937
      //   24: invokeinterface 81 2 0
      //   29: astore_1
      //   30: aload_0
      //   31: getfield 83	com/tencent/mm/plugin/voip/video/GLTextureView$j:zKm	I
      //   34: ldc 84
      //   36: if_icmpge +23 -> 59
      //   39: aload_1
      //   40: ldc 86
      //   42: invokevirtual 92	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   45: ifne +41 -> 86
      //   48: iconst_1
      //   49: istore_2
      //   50: aload_0
      //   51: iload_2
      //   52: putfield 94	com/tencent/mm/plugin/voip/video/GLTextureView$j:zKo	Z
      //   55: aload_0
      //   56: invokevirtual 65	java/lang/Object:notifyAll	()V
      //   59: aload_0
      //   60: getfield 94	com/tencent/mm/plugin/voip/video/GLTextureView$j:zKo	Z
      //   63: ifne +28 -> 91
      //   66: iload_3
      //   67: istore_2
      //   68: aload_0
      //   69: iload_2
      //   70: putfield 96	com/tencent/mm/plugin/voip/video/GLTextureView$j:zKp	Z
      //   73: aload_0
      //   74: iconst_1
      //   75: putfield 72	com/tencent/mm/plugin/voip/video/GLTextureView$j:zKn	Z
      //   78: ldc 70
      //   80: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   83: aload_0
      //   84: monitorexit
      //   85: return
      //   86: iconst_0
      //   87: istore_2
      //   88: goto -38 -> 50
      //   91: iconst_0
      //   92: istore_2
      //   93: goto -25 -> 68
      //   96: astore_1
      //   97: aload_0
      //   98: monitorexit
      //   99: aload_1
      //   100: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	101	0	this	j
      //   0	101	1	paramGL10	javax.microedition.khronos.opengles.GL10
      //   49	44	2	bool1	boolean
      //   1	66	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   4	48	96	finally
      //   50	59	96	finally
      //   59	66	96	finally
      //   68	78	96	finally
      //   78	83	96	finally
    }
    
    public final void c(GLTextureView.i parami)
    {
      AppMethodBeat.i(115605);
      if (this.CmR == parami) {
        this.CmR = null;
      }
      notifyAll();
      AppMethodBeat.o(115605);
    }
    
    public final boolean dXU()
    {
      try
      {
        boolean bool = this.zKp;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public final boolean dXV()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 102
      //   4: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: invokevirtual 75	com/tencent/mm/plugin/voip/video/GLTextureView$j:dXW	()V
      //   11: aload_0
      //   12: getfield 94	com/tencent/mm/plugin/voip/video/GLTextureView$j:zKo	Z
      //   15: ifne +14 -> 29
      //   18: iconst_1
      //   19: istore_1
      //   20: ldc 102
      //   22: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   25: aload_0
      //   26: monitorexit
      //   27: iload_1
      //   28: ireturn
      //   29: iconst_0
      //   30: istore_1
      //   31: ldc 102
      //   33: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: goto -11 -> 25
      //   39: astore_2
      //   40: aload_0
      //   41: monitorexit
      //   42: aload_2
      //   43: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	44	0	this	j
      //   19	12	1	bool	boolean
      //   39	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	18	39	finally
      //   20	25	39	finally
      //   31	36	39	finally
    }
    
    final void dXW()
    {
      if (!this.zKl) {
        this.zKl = true;
      }
    }
  }
  
  public static abstract interface k
  {
    public abstract GL aeo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.GLTextureView
 * JD-Core Version:    0.7.0.1
 */