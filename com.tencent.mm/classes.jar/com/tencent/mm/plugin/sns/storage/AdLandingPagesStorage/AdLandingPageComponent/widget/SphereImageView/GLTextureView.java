package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Writer;
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
  private static final j QUU;
  private static final String TAG;
  public i QUV;
  private m QUW;
  private e QUX;
  private f QUY;
  private g QUZ;
  private k QVa;
  private int QVb;
  private int QVc;
  private boolean QVd;
  private List<TextureView.SurfaceTextureListener> QVe;
  private boolean detached;
  private final WeakReference<GLTextureView> mcn;
  
  static
  {
    AppMethodBeat.i(97230);
    TAG = GLTextureView.class.getSimpleName();
    QUU = new j((byte)0);
    AppMethodBeat.o(97230);
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97210);
    this.mcn = new WeakReference(this);
    this.QVe = new ArrayList();
    setSurfaceTextureListener(this);
    AppMethodBeat.o(97210);
  }
  
  private void aTN()
  {
    AppMethodBeat.i(97229);
    if (this.QUV != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(97229);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(97229);
  }
  
  private void lz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97220);
    i locali = this.QUV;
    for (;;)
    {
      synchronized (QUU)
      {
        locali.width = paramInt1;
        locali.height = paramInt2;
        locali.QVy = true;
        locali.QVw = true;
        locali.QVx = false;
        QUU.notifyAll();
        if ((locali.QVo) || (locali.orA) || (locali.QVx)) {
          break;
        }
        if ((locali.QVt) && (locali.QVu))
        {
          boolean bool = locali.aTT();
          if (bool)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break;
            }
            try
            {
              QUU.wait();
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
    AppMethodBeat.o(97220);
  }
  
  public final void a(TextureView.SurfaceTextureListener paramSurfaceTextureListener)
  {
    AppMethodBeat.i(306915);
    this.QVe.add(paramSurfaceTextureListener);
    AppMethodBeat.o(306915);
  }
  
  public final void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(97221);
    i locali = this.QUV;
    if (paramRunnable == null)
    {
      paramRunnable = new IllegalArgumentException("r must not be null");
      AppMethodBeat.o(97221);
      throw paramRunnable;
    }
    synchronized (QUU)
    {
      locali.msu.add(paramRunnable);
      QUU.notifyAll();
      AppMethodBeat.o(97221);
      return;
    }
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(97211);
    try
    {
      if (this.QUV != null) {
        this.QUV.hkn();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(97211);
    }
  }
  
  public int getDebugFlags()
  {
    return this.QVb;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.QVd;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(97219);
    int i = this.QUV.getRenderMode();
    AppMethodBeat.o(97219);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(97222);
    super.onAttachedToWindow();
    if ((this.detached) && (this.QUW != null)) {
      if (this.QUV == null) {
        break label84;
      }
    }
    label84:
    for (int i = this.QUV.getRenderMode();; i = 1)
    {
      this.QUV = new i(this.mcn);
      if (i != 1) {
        this.QUV.setRenderMode(i);
      }
      this.QUV.start();
      this.detached = false;
      AppMethodBeat.o(97222);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97223);
    if (this.QUV != null) {
      this.QUV.hkn();
    }
    this.detached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(97223);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(97224);
    getSurfaceTexture();
    lz(paramInt3 - paramInt1, paramInt4 - paramInt2);
    AppMethodBeat.o(97224);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97225);
    i locali = this.QUV;
    synchronized (QUU)
    {
      locali.QVq = true;
      QUU.notifyAll();
      for (;;)
      {
        if (locali.QVs)
        {
          boolean bool = locali.QVo;
          if (!bool) {
            try
            {
              QUU.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    lz(paramInt1, paramInt2);
    ??? = this.QVe.iterator();
    while (((Iterator)???).hasNext()) {
      ((TextureView.SurfaceTextureListener)((Iterator)???).next()).onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(97225);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(97227);
    i locali = this.QUV;
    synchronized (QUU)
    {
      locali.QVq = false;
      QUU.notifyAll();
      for (;;)
      {
        if (!locali.QVs)
        {
          boolean bool = locali.QVo;
          if (!bool) {
            try
            {
              QUU.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    ??? = this.QVe.iterator();
    while (((Iterator)???).hasNext()) {
      ((TextureView.SurfaceTextureListener)((Iterator)???).next()).onSurfaceTextureDestroyed(paramSurfaceTexture);
    }
    AppMethodBeat.o(97227);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97226);
    lz(paramInt1, paramInt2);
    Iterator localIterator = this.QVe.iterator();
    while (localIterator.hasNext()) {
      ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(97226);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(97228);
    Iterator localIterator = this.QVe.iterator();
    while (localIterator.hasNext()) {
      ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureUpdated(paramSurfaceTexture);
    }
    AppMethodBeat.o(97228);
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.QVb = paramInt;
  }
  
  public void setEGLConfigChooser(e parame)
  {
    AppMethodBeat.i(97215);
    aTN();
    this.QUX = parame;
    AppMethodBeat.o(97215);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(97216);
    setEGLConfigChooser(new n(paramBoolean));
    AppMethodBeat.o(97216);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(97217);
    aTN();
    this.QVc = paramInt;
    AppMethodBeat.o(97217);
  }
  
  public void setEGLContextFactory(f paramf)
  {
    AppMethodBeat.i(97213);
    aTN();
    this.QUY = paramf;
    AppMethodBeat.o(97213);
  }
  
  public void setEGLWindowSurfaceFactory(g paramg)
  {
    AppMethodBeat.i(97214);
    aTN();
    this.QUZ = paramg;
    AppMethodBeat.o(97214);
  }
  
  public void setGLWrapper(k paramk)
  {
    this.QVa = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.QVd = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(97218);
    this.QUV.setRenderMode(paramInt);
    AppMethodBeat.o(97218);
  }
  
  public void setRenderer(m paramm)
  {
    AppMethodBeat.i(97212);
    aTN();
    if (this.QUX == null) {
      this.QUX = new n(true);
    }
    if (this.QUY == null) {
      this.QUY = new c((byte)0);
    }
    if (this.QUZ == null) {
      this.QUZ = new d((byte)0);
    }
    this.QUW = paramm;
    this.QUV = new i(this.mcn);
    this.QUV.start();
    AppMethodBeat.o(97212);
  }
  
  abstract class a
    implements GLTextureView.e
  {
    protected int[] mcz;
    
    public a(int[] paramArrayOfInt)
    {
      if (GLTextureView.a(GLTextureView.this) != 2) {}
      for (;;)
      {
        this.mcz = paramArrayOfInt;
        return;
        this$1 = new int[15];
        System.arraycopy(paramArrayOfInt, 0, GLTextureView.this, 0, 12);
        GLTextureView.this[12] = 12352;
        GLTextureView.this[13] = 4;
        GLTextureView.this[14] = 12344;
        paramArrayOfInt = GLTextureView.this;
      }
    }
    
    abstract EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
    
    public final EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
    {
      int[] arrayOfInt = new int[1];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mcz, null, 0, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig failed");
      }
      int i = arrayOfInt[0];
      if (i <= 0) {
        throw new IllegalArgumentException("No configs match configSpec");
      }
      EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
      if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.mcz, arrayOfEGLConfig, i, arrayOfInt)) {
        throw new IllegalArgumentException("eglChooseConfig#2 failed");
      }
      paramEGL10 = b(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
      if (paramEGL10 == null) {
        throw new IllegalArgumentException("No config chosen");
      }
      return paramEGL10;
    }
  }
  
  class b
    extends GLTextureView.a
  {
    protected int QVg;
    protected int QVh;
    protected int QVi;
    protected int QVj;
    protected int QVk;
    protected int QVl;
    private int[] value;
    
    public b(int paramInt)
    {
      super(new int[] { 12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, paramInt, 12326, 0, 12344 });
      AppMethodBeat.i(97180);
      this.value = new int[1];
      this.QVg = 8;
      this.QVh = 8;
      this.QVi = 8;
      this.QVj = 0;
      this.QVk = paramInt;
      this.QVl = 0;
      AppMethodBeat.o(97180);
    }
    
    private int b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt)
    {
      AppMethodBeat.i(97182);
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt, this.value))
      {
        paramInt = this.value[0];
        AppMethodBeat.o(97182);
        return paramInt;
      }
      AppMethodBeat.o(97182);
      return 0;
    }
    
    public final EGLConfig b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
    {
      AppMethodBeat.i(97181);
      int j = paramArrayOfEGLConfig.length;
      int i = 0;
      while (i < j)
      {
        EGLConfig localEGLConfig = paramArrayOfEGLConfig[i];
        int k = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12325);
        int m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12326);
        if ((k >= this.QVk) && (m >= this.QVl))
        {
          k = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12324);
          m = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12323);
          int n = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12322);
          int i1 = b(paramEGL10, paramEGLDisplay, localEGLConfig, 12321);
          if ((k == this.QVg) && (m == this.QVh) && (n == this.QVi) && (i1 == this.QVj))
          {
            AppMethodBeat.o(97181);
            return localEGLConfig;
          }
        }
        i += 1;
      }
      AppMethodBeat.o(97181);
      return null;
    }
  }
  
  final class c
    implements GLTextureView.f
  {
    private int mcH = 12440;
    
    private c() {}
    
    public final EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
    {
      AppMethodBeat.i(97183);
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.mcH;
      arrayOfInt[1] = GLTextureView.a(GLTextureView.this);
      arrayOfInt[2] = 12344;
      EGLContext localEGLContext = EGL10.EGL_NO_CONTEXT;
      if (GLTextureView.a(GLTextureView.this) != 0) {}
      for (;;)
      {
        paramEGL10 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, localEGLContext, arrayOfInt);
        AppMethodBeat.o(97183);
        return paramEGL10;
        arrayOfInt = null;
      }
    }
    
    public final void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
    {
      AppMethodBeat.i(97184);
      if (!paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext))
      {
        new StringBuilder("display:").append(paramEGLDisplay).append(" context: ").append(paramEGLContext);
        GLTextureView.h.ap("eglDestroyContex", paramEGL10.eglGetError());
      }
      AppMethodBeat.o(97184);
    }
  }
  
  static final class d
    implements GLTextureView.g
  {
    public final EGLSurface b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(97185);
      try
      {
        paramEGL10 = paramEGL10.eglCreateWindowSurface(paramEGLDisplay, paramEGLConfig, paramObject, null);
        AppMethodBeat.o(97185);
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
    
    public final void b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface)
    {
      AppMethodBeat.i(97186);
      paramEGL10.eglDestroySurface(paramEGLDisplay, paramEGLSurface);
      AppMethodBeat.o(97186);
    }
  }
  
  public static abstract interface e
  {
    public abstract EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay);
  }
  
  public static abstract interface f
  {
    public abstract EGLContext createContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig);
    
    public abstract void destroyContext(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext);
  }
  
  public static abstract interface g
  {
    public abstract EGLSurface b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, Object paramObject);
    
    public abstract void b(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLSurface paramEGLSurface);
  }
  
  static final class h
  {
    WeakReference<GLTextureView> QVm;
    EGL10 egl;
    EGLConfig eglConfig;
    EGLContext eglContext;
    EGLDisplay eglDisplay;
    EGLSurface eglSurface;
    
    public h(WeakReference<GLTextureView> paramWeakReference)
    {
      this.QVm = paramWeakReference;
    }
    
    public static void ap(String paramString, int paramInt)
    {
      AppMethodBeat.i(97189);
      paramString = new RuntimeException(aq(paramString, paramInt));
      AppMethodBeat.o(97189);
      throw paramString;
    }
    
    public static String aq(String paramString, int paramInt)
    {
      AppMethodBeat.i(97190);
      paramString = paramString + " failed: " + paramInt;
      AppMethodBeat.o(97190);
      return paramString;
    }
    
    final void aTP()
    {
      AppMethodBeat.i(97187);
      if ((this.eglSurface != null) && (this.eglSurface != EGL10.EGL_NO_SURFACE))
      {
        Object localObject = this.egl;
        EGLDisplay localEGLDisplay = this.eglDisplay;
        EGLSurface localEGLSurface = EGL10.EGL_NO_SURFACE;
        ((EGL10)localObject).eglMakeCurrent(localEGLDisplay, localEGLSurface, localEGLSurface, EGL10.EGL_NO_CONTEXT);
        localObject = (GLTextureView)this.QVm.get();
        if (localObject != null) {
          GLTextureView.d((GLTextureView)localObject).b(this.egl, this.eglDisplay, this.eglSurface);
        }
        this.eglSurface = null;
      }
      AppMethodBeat.o(97187);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(97188);
      if (this.eglContext != null)
      {
        GLTextureView localGLTextureView = (GLTextureView)this.QVm.get();
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
      AppMethodBeat.o(97188);
    }
  }
  
  public static final class i
    extends Thread
  {
    private WeakReference<GLTextureView> QVm;
    private boolean QVn;
    boolean QVo;
    private boolean QVp;
    boolean QVq;
    private boolean QVr;
    boolean QVs;
    boolean QVt;
    boolean QVu;
    private boolean QVv;
    boolean QVw;
    boolean QVx;
    boolean QVy;
    private GLTextureView.h QVz;
    int height;
    private int mWg;
    ArrayList<Runnable> msu;
    boolean orA;
    int width;
    
    i(WeakReference<GLTextureView> paramWeakReference)
    {
      AppMethodBeat.i(97191);
      this.msu = new ArrayList();
      this.QVy = true;
      this.width = 0;
      this.height = 0;
      this.QVw = true;
      this.mWg = 1;
      this.QVm = paramWeakReference;
      AppMethodBeat.o(97191);
    }
    
    private void aTQ()
    {
      AppMethodBeat.i(97193);
      if (this.QVu)
      {
        this.QVu = false;
        this.QVz.aTP();
      }
      AppMethodBeat.o(97193);
    }
    
    private void aTR()
    {
      AppMethodBeat.i(97194);
      if (this.QVt)
      {
        this.QVz.finish();
        this.QVt = false;
        GLTextureView.hkm().c(this);
      }
      AppMethodBeat.o(97194);
    }
    
    /* Error */
    private void aTS()
    {
      // Byte code:
      //   0: ldc 103
      //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: new 79	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h
      //   9: dup
      //   10: aload_0
      //   11: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVm	Ljava/lang/ref/WeakReference;
      //   14: invokespecial 105	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:<init>	(Ljava/lang/ref/WeakReference;)V
      //   17: putfield 77	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVz	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVt	Z
      //   25: aload_0
      //   26: iconst_0
      //   27: putfield 75	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVu	Z
      //   30: iconst_0
      //   31: istore 6
      //   33: iconst_0
      //   34: istore 8
      //   36: iconst_0
      //   37: istore 4
      //   39: iconst_0
      //   40: istore 5
      //   42: iconst_0
      //   43: istore 7
      //   45: iconst_0
      //   46: istore 10
      //   48: iconst_0
      //   49: istore 11
      //   51: aconst_null
      //   52: astore 20
      //   54: iconst_0
      //   55: istore_2
      //   56: iconst_0
      //   57: istore_1
      //   58: iconst_0
      //   59: istore_3
      //   60: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   63: astore 21
      //   65: aload 21
      //   67: monitorenter
      //   68: iload_1
      //   69: istore 9
      //   71: iload 5
      //   73: istore 12
      //   75: iload_2
      //   76: istore 5
      //   78: iload 8
      //   80: istore_1
      //   81: iload 4
      //   83: istore_2
      //   84: aload_0
      //   85: getfield 107	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVn	Z
      //   88: ifeq +44 -> 132
      //   91: aload 21
      //   93: monitorexit
      //   94: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   97: astore 20
      //   99: aload 20
      //   101: monitorenter
      //   102: aload_0
      //   103: invokespecial 109	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTQ	()V
      //   106: aload_0
      //   107: invokespecial 111	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTR	()V
      //   110: aload 20
      //   112: monitorexit
      //   113: ldc 103
      //   115: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   118: return
      //   119: astore 21
      //   121: aload 20
      //   123: monitorexit
      //   124: ldc 103
      //   126: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   129: aload 21
      //   131: athrow
      //   132: aload_0
      //   133: getfield 49	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:msu	Ljava/util/ArrayList;
      //   136: invokevirtual 115	java/util/ArrayList:isEmpty	()Z
      //   139: ifne +57 -> 196
      //   142: aload_0
      //   143: getfield 49	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:msu	Ljava/util/ArrayList;
      //   146: iconst_0
      //   147: invokevirtual 119	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   150: checkcast 121	java/lang/Runnable
      //   153: astore 22
      //   155: iload 5
      //   157: istore 13
      //   159: iload 12
      //   161: istore 5
      //   163: iload_1
      //   164: istore 8
      //   166: iload_2
      //   167: istore 4
      //   169: iload 9
      //   171: istore_1
      //   172: iload 13
      //   174: istore_2
      //   175: aload 21
      //   177: monitorexit
      //   178: aload 22
      //   180: ifnull +861 -> 1041
      //   183: aload 22
      //   185: invokeinterface 124 1 0
      //   190: aconst_null
      //   191: astore 20
      //   193: goto -133 -> 60
      //   196: aload_0
      //   197: getfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:orA	Z
      //   200: aload_0
      //   201: getfield 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVp	Z
      //   204: if_icmpeq +1654 -> 1858
      //   207: aload_0
      //   208: getfield 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVp	Z
      //   211: istore 14
      //   213: aload_0
      //   214: aload_0
      //   215: getfield 128	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVp	Z
      //   218: putfield 126	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:orA	Z
      //   221: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   224: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   227: aload_0
      //   228: getfield 135	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVv	Z
      //   231: ifeq +1624 -> 1855
      //   234: aload_0
      //   235: invokespecial 109	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTQ	()V
      //   238: aload_0
      //   239: invokespecial 111	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTR	()V
      //   242: aload_0
      //   243: iconst_0
      //   244: putfield 135	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVv	Z
      //   247: iconst_1
      //   248: istore 7
      //   250: iload 9
      //   252: ifeq +1596 -> 1848
      //   255: aload_0
      //   256: invokespecial 109	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTQ	()V
      //   259: aload_0
      //   260: invokespecial 111	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTR	()V
      //   263: iconst_0
      //   264: istore 4
      //   266: iload 14
      //   268: ifeq +14 -> 282
      //   271: aload_0
      //   272: getfield 75	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVu	Z
      //   275: ifeq +7 -> 282
      //   278: aload_0
      //   279: invokespecial 109	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTQ	()V
      //   282: iload 14
      //   284: ifeq +48 -> 332
      //   287: aload_0
      //   288: getfield 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVt	Z
      //   291: ifeq +41 -> 332
      //   294: aload_0
      //   295: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVm	Ljava/lang/ref/WeakReference;
      //   298: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   301: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
      //   304: astore 22
      //   306: aload 22
      //   308: ifnonnull +275 -> 583
      //   311: iconst_0
      //   312: istore 15
      //   314: iload 15
      //   316: ifeq +12 -> 328
      //   319: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   322: invokevirtual 144	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:hko	()Z
      //   325: ifeq +7 -> 332
      //   328: aload_0
      //   329: invokespecial 111	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTR	()V
      //   332: iload 14
      //   334: ifeq +19 -> 353
      //   337: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   340: invokevirtual 147	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:hkp	()Z
      //   343: ifeq +10 -> 353
      //   346: aload_0
      //   347: getfield 77	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVz	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
      //   350: invokevirtual 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:finish	()V
      //   353: aload_0
      //   354: getfield 149	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVq	Z
      //   357: ifne +37 -> 394
      //   360: aload_0
      //   361: getfield 151	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVs	Z
      //   364: ifne +30 -> 394
      //   367: aload_0
      //   368: getfield 75	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVu	Z
      //   371: ifeq +7 -> 378
      //   374: aload_0
      //   375: invokespecial 109	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTQ	()V
      //   378: aload_0
      //   379: iconst_1
      //   380: putfield 151	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVs	Z
      //   383: aload_0
      //   384: iconst_0
      //   385: putfield 153	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVr	Z
      //   388: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   391: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   394: aload_0
      //   395: getfield 149	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVq	Z
      //   398: ifeq +21 -> 419
      //   401: aload_0
      //   402: getfield 151	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVs	Z
      //   405: ifeq +14 -> 419
      //   408: aload_0
      //   409: iconst_0
      //   410: putfield 151	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVs	Z
      //   413: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   416: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   419: iload 5
      //   421: ifeq +1420 -> 1841
      //   424: iconst_0
      //   425: istore 9
      //   427: aload_0
      //   428: iconst_1
      //   429: putfield 155	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVx	Z
      //   432: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   435: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   438: iconst_0
      //   439: istore 5
      //   441: aload_0
      //   442: invokevirtual 158	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTT	()Z
      //   445: ifeq +1390 -> 1835
      //   448: iload_3
      //   449: istore 8
      //   451: aload_0
      //   452: getfield 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVt	Z
      //   455: ifne +488 -> 943
      //   458: iload 7
      //   460: ifeq +133 -> 593
      //   463: iconst_0
      //   464: istore 8
      //   466: iload_3
      //   467: istore 7
      //   469: iload 8
      //   471: istore_3
      //   472: aload_0
      //   473: getfield 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVt	Z
      //   476: ifeq +1353 -> 1829
      //   479: aload_0
      //   480: getfield 75	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVu	Z
      //   483: ifne +1346 -> 1829
      //   486: aload_0
      //   487: iconst_1
      //   488: putfield 75	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVu	Z
      //   491: iconst_1
      //   492: istore 6
      //   494: iconst_1
      //   495: istore 8
      //   497: iconst_1
      //   498: istore_2
      //   499: aload_0
      //   500: getfield 75	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVu	Z
      //   503: ifeq +508 -> 1011
      //   506: aload_0
      //   507: getfield 51	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVy	Z
      //   510: ifeq +1311 -> 1821
      //   513: aload_0
      //   514: getfield 53	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:width	I
      //   517: istore 10
      //   519: aload_0
      //   520: getfield 55	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:height	I
      //   523: istore_2
      //   524: iconst_1
      //   525: istore 6
      //   527: aload_0
      //   528: iconst_0
      //   529: putfield 51	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVy	Z
      //   532: iconst_1
      //   533: istore 9
      //   535: iconst_1
      //   536: istore_1
      //   537: aload_0
      //   538: iconst_0
      //   539: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVw	Z
      //   542: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   545: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   548: iload_2
      //   549: istore 11
      //   551: iload_3
      //   552: istore 12
      //   554: iload 5
      //   556: istore_2
      //   557: iload_1
      //   558: istore_3
      //   559: iload 4
      //   561: istore_1
      //   562: iload_3
      //   563: istore 4
      //   565: iload 7
      //   567: istore_3
      //   568: iload 9
      //   570: istore 5
      //   572: iload 12
      //   574: istore 7
      //   576: aload 20
      //   578: astore 22
      //   580: goto -405 -> 175
      //   583: aload 22
      //   585: invokestatic 162	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:g	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Z
      //   588: istore 15
      //   590: goto -276 -> 314
      //   593: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   596: astore 22
      //   598: aload 22
      //   600: getfield 166	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
      //   603: aload_0
      //   604: if_acmpeq +11 -> 615
      //   607: aload 22
      //   609: getfield 166	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
      //   612: ifnonnull +149 -> 761
      //   615: aload 22
      //   617: aload_0
      //   618: putfield 166	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
      //   621: aload 22
      //   623: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   626: iconst_1
      //   627: istore 12
      //   629: iload_3
      //   630: istore 8
      //   632: iload 12
      //   634: ifeq +309 -> 943
      //   637: aload_0
      //   638: getfield 77	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVz	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
      //   641: astore 22
      //   643: aload 22
      //   645: invokestatic 172	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
      //   648: checkcast 174	javax/microedition/khronos/egl/EGL10
      //   651: putfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   654: aload 22
      //   656: aload 22
      //   658: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   661: getstatic 182	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
      //   664: invokeinterface 186 2 0
      //   669: putfield 190	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   672: aload 22
      //   674: getfield 190	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   677: getstatic 193	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   680: if_acmpne +129 -> 809
      //   683: new 102	java/lang/RuntimeException
      //   686: dup
      //   687: ldc 195
      //   689: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   692: astore 20
      //   694: ldc 103
      //   696: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   699: aload 20
      //   701: athrow
      //   702: astore 20
      //   704: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   707: aload_0
      //   708: invokevirtual 99	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:c	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;)V
      //   711: ldc 103
      //   713: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   716: aload 20
      //   718: athrow
      //   719: astore 20
      //   721: aload 21
      //   723: monitorexit
      //   724: ldc 103
      //   726: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   729: aload 20
      //   731: athrow
      //   732: astore 21
      //   734: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   737: astore 20
      //   739: aload 20
      //   741: monitorenter
      //   742: aload_0
      //   743: invokespecial 109	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTQ	()V
      //   746: aload_0
      //   747: invokespecial 111	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTR	()V
      //   750: aload 20
      //   752: monitorexit
      //   753: ldc 103
      //   755: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   758: aload 21
      //   760: athrow
      //   761: aload 22
      //   763: invokevirtual 201	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:hkq	()V
      //   766: aload 22
      //   768: getfield 204	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVD	Z
      //   771: ifeq +9 -> 780
      //   774: iconst_1
      //   775: istore 12
      //   777: goto -148 -> 629
      //   780: aload 22
      //   782: getfield 166	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
      //   785: ifnull +18 -> 803
      //   788: aload 22
      //   790: getfield 166	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
      //   793: iconst_1
      //   794: putfield 135	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVv	Z
      //   797: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   800: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   803: iconst_0
      //   804: istore 12
      //   806: goto -177 -> 629
      //   809: iconst_2
      //   810: newarray int
      //   812: astore 23
      //   814: aload 22
      //   816: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   819: aload 22
      //   821: getfield 190	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   824: aload 23
      //   826: invokeinterface 208 3 0
      //   831: ifne +22 -> 853
      //   834: new 102	java/lang/RuntimeException
      //   837: dup
      //   838: ldc 210
      //   840: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   843: astore 20
      //   845: ldc 103
      //   847: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   850: aload 20
      //   852: athrow
      //   853: aload 22
      //   855: getfield 211	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:QVm	Ljava/lang/ref/WeakReference;
      //   858: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   861: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
      //   864: astore 23
      //   866: aload 23
      //   868: ifnonnull +85 -> 953
      //   871: aload 22
      //   873: aconst_null
      //   874: putfield 215	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   877: aload 22
      //   879: aconst_null
      //   880: putfield 219	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   883: aload 22
      //   885: getfield 219	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   888: ifnull +14 -> 902
      //   891: aload 22
      //   893: getfield 219	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   896: getstatic 222	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
      //   899: if_acmpne +24 -> 923
      //   902: aload 22
      //   904: aconst_null
      //   905: putfield 219	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   908: ldc 224
      //   910: aload 22
      //   912: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   915: invokeinterface 228 1 0
      //   920: invokestatic 232	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:ap	(Ljava/lang/String;I)V
      //   923: aload 22
      //   925: aconst_null
      //   926: putfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   929: aload_0
      //   930: iconst_1
      //   931: putfield 86	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVt	Z
      //   934: iconst_1
      //   935: istore 8
      //   937: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   940: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   943: iload 7
      //   945: istore_3
      //   946: iload 8
      //   948: istore 7
      //   950: goto -478 -> 472
      //   953: aload 22
      //   955: aload 23
      //   957: invokestatic 240	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$e;
      //   960: aload 22
      //   962: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   965: aload 22
      //   967: getfield 190	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   970: invokeinterface 246 3 0
      //   975: putfield 215	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   978: aload 22
      //   980: aload 23
      //   982: invokestatic 249	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:c	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$f;
      //   985: aload 22
      //   987: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   990: aload 22
      //   992: getfield 190	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   995: aload 22
      //   997: getfield 215	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1000: invokeinterface 254 4 0
      //   1005: putfield 219	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   1008: goto -125 -> 883
      //   1011: iload 8
      //   1013: istore_1
      //   1014: iload 7
      //   1016: istore 8
      //   1018: iload_3
      //   1019: istore 7
      //   1021: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   1024: invokevirtual 257	java/lang/Object:wait	()V
      //   1027: iload 8
      //   1029: istore_3
      //   1030: iload 9
      //   1032: istore 12
      //   1034: iload 4
      //   1036: istore 9
      //   1038: goto -954 -> 84
      //   1041: iload 6
      //   1043: ifeq +821 -> 1864
      //   1046: aload_0
      //   1047: getfield 77	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVz	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
      //   1050: astore 20
      //   1052: aload 20
      //   1054: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1057: ifnonnull +23 -> 1080
      //   1060: new 102	java/lang/RuntimeException
      //   1063: dup
      //   1064: ldc_w 259
      //   1067: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1070: astore 20
      //   1072: ldc 103
      //   1074: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1077: aload 20
      //   1079: athrow
      //   1080: aload 20
      //   1082: getfield 190	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1085: ifnonnull +23 -> 1108
      //   1088: new 102	java/lang/RuntimeException
      //   1091: dup
      //   1092: ldc_w 261
      //   1095: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1098: astore 20
      //   1100: ldc 103
      //   1102: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1105: aload 20
      //   1107: athrow
      //   1108: aload 20
      //   1110: getfield 215	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1113: ifnonnull +23 -> 1136
      //   1116: new 102	java/lang/RuntimeException
      //   1119: dup
      //   1120: ldc_w 263
      //   1123: invokespecial 198	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   1126: astore 20
      //   1128: ldc 103
      //   1130: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1133: aload 20
      //   1135: athrow
      //   1136: aload 20
      //   1138: invokevirtual 82	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:aTP	()V
      //   1141: aload 20
      //   1143: getfield 211	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:QVm	Ljava/lang/ref/WeakReference;
      //   1146: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1149: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
      //   1152: astore 21
      //   1154: aload 21
      //   1156: ifnull +105 -> 1261
      //   1159: aload 20
      //   1161: aload 21
      //   1163: invokestatic 267	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:d	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$g;
      //   1166: aload 20
      //   1168: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1171: aload 20
      //   1173: getfield 190	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1176: aload 20
      //   1178: getfield 215	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
      //   1181: aload 21
      //   1183: invokevirtual 271	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
      //   1186: invokeinterface 276 5 0
      //   1191: putfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1194: aload 20
      //   1196: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1199: ifnull +14 -> 1213
      //   1202: aload 20
      //   1204: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1207: getstatic 279	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1210: if_acmpne +60 -> 1270
      //   1213: aload 20
      //   1215: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1218: invokeinterface 228 1 0
      //   1223: pop
      //   1224: iconst_0
      //   1225: istore 9
      //   1227: iload 9
      //   1229: ifne +644 -> 1873
      //   1232: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   1235: astore 20
      //   1237: aload 20
      //   1239: monitorenter
      //   1240: aload_0
      //   1241: iconst_1
      //   1242: putfield 153	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVr	Z
      //   1245: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   1248: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   1251: aload 20
      //   1253: monitorexit
      //   1254: aload 22
      //   1256: astore 20
      //   1258: goto -1198 -> 60
      //   1261: aload 20
      //   1263: aconst_null
      //   1264: putfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1267: goto -73 -> 1194
      //   1270: aload 20
      //   1272: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1275: aload 20
      //   1277: getfield 190	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1280: aload 20
      //   1282: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1285: aload 20
      //   1287: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1290: aload 20
      //   1292: getfield 219	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   1295: invokeinterface 283 5 0
      //   1300: ifne +567 -> 1867
      //   1303: ldc_w 284
      //   1306: aload 20
      //   1308: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1311: invokeinterface 228 1 0
      //   1316: invokestatic 288	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:aq	(Ljava/lang/String;I)Ljava/lang/String;
      //   1319: pop
      //   1320: iconst_0
      //   1321: istore 9
      //   1323: goto -96 -> 1227
      //   1326: astore 21
      //   1328: aload 20
      //   1330: monitorexit
      //   1331: ldc 103
      //   1333: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1336: aload 21
      //   1338: athrow
      //   1339: iload 8
      //   1341: istore 9
      //   1343: iload 8
      //   1345: ifeq +139 -> 1484
      //   1348: aload_0
      //   1349: getfield 77	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVz	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
      //   1352: astore 21
      //   1354: aload 21
      //   1356: getfield 219	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglContext	Ljavax/microedition/khronos/egl/EGLContext;
      //   1359: invokevirtual 292	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
      //   1362: astore 20
      //   1364: aload 21
      //   1366: getfield 211	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:QVm	Ljava/lang/ref/WeakReference;
      //   1369: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1372: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
      //   1375: astore 23
      //   1377: aload 20
      //   1379: astore 21
      //   1381: aload 23
      //   1383: ifnull +431 -> 1814
      //   1386: aload 23
      //   1388: invokestatic 296	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:e	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$k;
      //   1391: ifnull +15 -> 1406
      //   1394: aload 23
      //   1396: invokestatic 296	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:e	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$k;
      //   1399: invokeinterface 301 1 0
      //   1404: astore 20
      //   1406: aload 20
      //   1408: astore 21
      //   1410: aload 23
      //   1412: invokestatic 305	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:f	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)I
      //   1415: iconst_3
      //   1416: iand
      //   1417: ifeq +397 -> 1814
      //   1420: iconst_0
      //   1421: istore 8
      //   1423: aload 23
      //   1425: invokestatic 305	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:f	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)I
      //   1428: iconst_1
      //   1429: iand
      //   1430: ifeq +6 -> 1436
      //   1433: iconst_1
      //   1434: istore 8
      //   1436: aload 23
      //   1438: invokestatic 305	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:f	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)I
      //   1441: iconst_2
      //   1442: iand
      //   1443: ifeq +365 -> 1808
      //   1446: new 307	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$l
      //   1449: dup
      //   1450: invokespecial 308	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$l:<init>	()V
      //   1453: astore 21
      //   1455: aload 20
      //   1457: iload 8
      //   1459: aload 21
      //   1461: invokestatic 314	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
      //   1464: astore 20
      //   1466: aload 20
      //   1468: checkcast 316	javax/microedition/khronos/opengles/GL10
      //   1471: astore 20
      //   1473: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   1476: aload 20
      //   1478: invokevirtual 319	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:c	(Ljavax/microedition/khronos/opengles/GL10;)V
      //   1481: iconst_0
      //   1482: istore 9
      //   1484: iload_3
      //   1485: istore 8
      //   1487: iload_3
      //   1488: ifeq +33 -> 1521
      //   1491: aload_0
      //   1492: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVm	Ljava/lang/ref/WeakReference;
      //   1495: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1498: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
      //   1501: astore 20
      //   1503: aload 20
      //   1505: ifnull +374 -> 1879
      //   1508: aload 20
      //   1510: invokestatic 323	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:h	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$m;
      //   1513: invokeinterface 328 1 0
      //   1518: goto +361 -> 1879
      //   1521: iload 4
      //   1523: istore_3
      //   1524: iload 4
      //   1526: ifeq +37 -> 1563
      //   1529: aload_0
      //   1530: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVm	Ljava/lang/ref/WeakReference;
      //   1533: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1536: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
      //   1539: astore 20
      //   1541: aload 20
      //   1543: ifnull +342 -> 1885
      //   1546: aload 20
      //   1548: invokestatic 323	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:h	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$m;
      //   1551: iload 10
      //   1553: iload 11
      //   1555: invokeinterface 332 3 0
      //   1560: goto +325 -> 1885
      //   1563: aload_0
      //   1564: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVm	Ljava/lang/ref/WeakReference;
      //   1567: invokevirtual 141	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   1570: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
      //   1573: astore 20
      //   1575: aload 20
      //   1577: ifnull +13 -> 1590
      //   1580: aload 20
      //   1582: invokestatic 323	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:h	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$m;
      //   1585: invokeinterface 335 1 0
      //   1590: invokestatic 341	java/lang/System:currentTimeMillis	()J
      //   1593: lstore 16
      //   1595: aload_0
      //   1596: getfield 77	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVz	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
      //   1599: astore 20
      //   1601: aload 20
      //   1603: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1606: aload 20
      //   1608: getfield 190	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglDisplay	Ljavax/microedition/khronos/egl/EGLDisplay;
      //   1611: aload 20
      //   1613: getfield 236	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:eglSurface	Ljavax/microedition/khronos/egl/EGLSurface;
      //   1616: invokeinterface 345 3 0
      //   1621: ifne +142 -> 1763
      //   1624: aload 20
      //   1626: getfield 178	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:egl	Ljavax/microedition/khronos/egl/EGL10;
      //   1629: invokeinterface 228 1 0
      //   1634: istore 12
      //   1636: invokestatic 341	java/lang/System:currentTimeMillis	()J
      //   1639: lstore 18
      //   1641: new 347	java/lang/StringBuilder
      //   1644: dup
      //   1645: ldc_w 349
      //   1648: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1651: lload 18
      //   1653: lload 16
      //   1655: lsub
      //   1656: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1659: ldc_w 356
      //   1662: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1665: pop
      //   1666: iload_1
      //   1667: istore 4
      //   1669: iload 12
      //   1671: lookupswitch	default:+219->1890, 12288:+59->1730, 12302:+100->1771
      //   1697: aconst_null
      //   1698: imul
      //   1699: iload 12
      //   1701: invokestatic 288	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:aq	(Ljava/lang/String;I)Ljava/lang/String;
      //   1704: pop
      //   1705: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   1708: astore 20
      //   1710: aload 20
      //   1712: monitorenter
      //   1713: aload_0
      //   1714: iconst_1
      //   1715: putfield 153	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:QVr	Z
      //   1718: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   1721: invokevirtual 133	java/lang/Object:notifyAll	()V
      //   1724: aload 20
      //   1726: monitorexit
      //   1727: iload_1
      //   1728: istore 4
      //   1730: iload 5
      //   1732: ifeq +71 -> 1803
      //   1735: iconst_1
      //   1736: istore_1
      //   1737: iload_1
      //   1738: istore_2
      //   1739: iload 4
      //   1741: istore_1
      //   1742: iload 8
      //   1744: istore 12
      //   1746: iload_3
      //   1747: istore 4
      //   1749: iload 9
      //   1751: istore 8
      //   1753: iload 12
      //   1755: istore_3
      //   1756: aload 22
      //   1758: astore 20
      //   1760: goto -1700 -> 60
      //   1763: sipush 12288
      //   1766: istore 12
      //   1768: goto -132 -> 1636
      //   1771: iconst_1
      //   1772: istore 4
      //   1774: goto -44 -> 1730
      //   1777: astore 21
      //   1779: aload 20
      //   1781: monitorexit
      //   1782: ldc 103
      //   1784: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1787: aload 21
      //   1789: athrow
      //   1790: astore 21
      //   1792: aload 20
      //   1794: monitorexit
      //   1795: ldc 103
      //   1797: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1800: aload 21
      //   1802: athrow
      //   1803: iload_2
      //   1804: istore_1
      //   1805: goto -68 -> 1737
      //   1808: aconst_null
      //   1809: astore 21
      //   1811: goto -356 -> 1455
      //   1814: aload 21
      //   1816: astore 20
      //   1818: goto -352 -> 1466
      //   1821: iload_2
      //   1822: istore_1
      //   1823: iload 11
      //   1825: istore_2
      //   1826: goto -1289 -> 537
      //   1829: iload_1
      //   1830: istore 8
      //   1832: goto -1333 -> 499
      //   1835: iload_3
      //   1836: istore 8
      //   1838: goto -817 -> 1021
      //   1841: iload 12
      //   1843: istore 9
      //   1845: goto -1404 -> 441
      //   1848: iload 9
      //   1850: istore 4
      //   1852: goto -1586 -> 266
      //   1855: goto -1605 -> 250
      //   1858: iconst_0
      //   1859: istore 14
      //   1861: goto -1634 -> 227
      //   1864: goto -525 -> 1339
      //   1867: iconst_1
      //   1868: istore 9
      //   1870: goto -643 -> 1227
      //   1873: iconst_0
      //   1874: istore 6
      //   1876: goto -537 -> 1339
      //   1879: iconst_0
      //   1880: istore 8
      //   1882: goto -361 -> 1521
      //   1885: iconst_0
      //   1886: istore_3
      //   1887: goto -324 -> 1563
      //   1890: goto -194 -> 1696
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1893	0	this	i
      //   57	1773	1	i	int
      //   55	1771	2	j	int
      //   59	1828	3	k	int
      //   37	1814	4	m	int
      //   40	1691	5	n	int
      //   31	1844	6	i1	int
      //   43	977	7	i2	int
      //   34	1847	8	i3	int
      //   69	1800	9	i4	int
      //   46	1506	10	i5	int
      //   49	1775	11	i6	int
      //   73	1769	12	i7	int
      //   157	16	13	i8	int
      //   211	1649	14	bool1	boolean
      //   312	277	15	bool2	boolean
      //   1593	61	16	l1	long
      //   1639	13	18	l2	long
      //   702	15	20	localRuntimeException	RuntimeException
      //   719	11	20	localObject2	Object
      //   63	29	21	localj	GLTextureView.j
      //   119	603	21	localObject4	Object
      //   732	27	21	localObject5	Object
      //   1152	30	21	localGLTextureView	GLTextureView
      //   1326	11	21	localObject6	Object
      //   1352	108	21	localObject7	Object
      //   1777	11	21	localObject8	Object
      //   1790	11	21	localObject9	Object
      //   1809	6	21	localObject10	Object
      //   153	1604	22	localObject11	Object
      //   812	625	23	localObject12	Object
      // Exception table:
      //   from	to	target	type
      //   102	113	119	finally
      //   637	702	702	java/lang/RuntimeException
      //   809	853	702	java/lang/RuntimeException
      //   853	866	702	java/lang/RuntimeException
      //   871	883	702	java/lang/RuntimeException
      //   883	902	702	java/lang/RuntimeException
      //   902	923	702	java/lang/RuntimeException
      //   923	929	702	java/lang/RuntimeException
      //   953	1008	702	java/lang/RuntimeException
      //   84	94	719	finally
      //   132	155	719	finally
      //   175	178	719	finally
      //   196	227	719	finally
      //   227	247	719	finally
      //   255	263	719	finally
      //   271	282	719	finally
      //   287	306	719	finally
      //   319	328	719	finally
      //   328	332	719	finally
      //   337	353	719	finally
      //   353	378	719	finally
      //   378	394	719	finally
      //   394	419	719	finally
      //   427	438	719	finally
      //   441	448	719	finally
      //   451	458	719	finally
      //   472	491	719	finally
      //   499	524	719	finally
      //   527	532	719	finally
      //   537	548	719	finally
      //   583	590	719	finally
      //   593	615	719	finally
      //   615	626	719	finally
      //   637	702	719	finally
      //   704	719	719	finally
      //   761	774	719	finally
      //   780	803	719	finally
      //   809	853	719	finally
      //   853	866	719	finally
      //   871	883	719	finally
      //   883	902	719	finally
      //   902	923	719	finally
      //   923	929	719	finally
      //   929	934	719	finally
      //   937	943	719	finally
      //   953	1008	719	finally
      //   1021	1027	719	finally
      //   60	68	732	finally
      //   183	190	732	finally
      //   721	732	732	finally
      //   1046	1080	732	finally
      //   1080	1108	732	finally
      //   1108	1136	732	finally
      //   1136	1154	732	finally
      //   1159	1194	732	finally
      //   1194	1213	732	finally
      //   1213	1224	732	finally
      //   1232	1240	732	finally
      //   1261	1267	732	finally
      //   1270	1320	732	finally
      //   1328	1339	732	finally
      //   1348	1377	732	finally
      //   1386	1406	732	finally
      //   1410	1420	732	finally
      //   1423	1433	732	finally
      //   1436	1455	732	finally
      //   1455	1466	732	finally
      //   1466	1481	732	finally
      //   1491	1503	732	finally
      //   1508	1518	732	finally
      //   1529	1541	732	finally
      //   1546	1560	732	finally
      //   1563	1575	732	finally
      //   1580	1590	732	finally
      //   1590	1636	732	finally
      //   1636	1666	732	finally
      //   1696	1713	732	finally
      //   1779	1790	732	finally
      //   1240	1254	1326	finally
      //   1713	1727	1777	finally
      //   742	753	1790	finally
    }
    
    final boolean aTT()
    {
      return (!this.orA) && (this.QVq) && (!this.QVr) && (this.width > 0) && (this.height > 0) && ((this.QVw) || (this.mWg == 1));
    }
    
    public final int getRenderMode()
    {
      AppMethodBeat.i(97197);
      synchronized (GLTextureView.hkm())
      {
        int i = this.mWg;
        AppMethodBeat.o(97197);
        return i;
      }
    }
    
    public final void hkn()
    {
      AppMethodBeat.i(97199);
      synchronized (GLTextureView.hkm())
      {
        this.QVn = true;
        GLTextureView.hkm().notifyAll();
        for (;;)
        {
          boolean bool = this.QVo;
          if (!bool) {
            try
            {
              GLTextureView.hkm().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
      AppMethodBeat.o(97199);
    }
    
    public final void requestRender()
    {
      AppMethodBeat.i(97198);
      synchronized (GLTextureView.hkm())
      {
        this.QVw = true;
        GLTextureView.hkm().notifyAll();
        AppMethodBeat.o(97198);
        return;
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc_w 376
      //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: new 347	java/lang/StringBuilder
      //   10: dup
      //   11: ldc_w 378
      //   14: invokespecial 350	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   17: aload_0
      //   18: invokevirtual 381	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:getId	()J
      //   21: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   24: invokevirtual 385	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   27: invokevirtual 388	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:setName	(Ljava/lang/String;)V
      //   30: aload_0
      //   31: invokespecial 390	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:aTS	()V
      //   34: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   37: aload_0
      //   38: invokevirtual 392	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;)V
      //   41: ldc_w 376
      //   44: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   47: return
      //   48: astore_1
      //   49: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   52: aload_0
      //   53: invokevirtual 392	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;)V
      //   56: ldc_w 376
      //   59: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   62: return
      //   63: astore_1
      //   64: invokestatic 93	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:hkm	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
      //   67: aload_0
      //   68: invokevirtual 392	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;)V
      //   71: ldc_w 376
      //   74: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   77: aload_1
      //   78: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	79	0	this	i
      //   48	1	1	localInterruptedException	InterruptedException
      //   63	15	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   30	34	48	java/lang/InterruptedException
      //   30	34	63	finally
    }
    
    public final void setRenderMode(int paramInt)
    {
      AppMethodBeat.i(97196);
      if ((paramInt < 0) || (paramInt > 1))
      {
        ??? = new IllegalArgumentException("renderMode");
        AppMethodBeat.o(97196);
        throw ((Throwable)???);
      }
      synchronized (GLTextureView.hkm())
      {
        this.mWg = paramInt;
        GLTextureView.hkm().notifyAll();
        AppMethodBeat.o(97196);
        return;
      }
    }
  }
  
  static final class j
  {
    private static String TAG = "GLThreadManager";
    private boolean QVA;
    private int QVB;
    private boolean QVC;
    boolean QVD;
    private boolean QVE;
    GLTextureView.i QVF;
    
    public final void b(GLTextureView.i parami)
    {
      try
      {
        AppMethodBeat.i(97200);
        GLTextureView.i.a(parami);
        if (this.QVF == parami) {
          this.QVF = null;
        }
        notifyAll();
        AppMethodBeat.o(97200);
        return;
      }
      finally {}
    }
    
    public final void c(GLTextureView.i parami)
    {
      AppMethodBeat.i(97201);
      if (this.QVF == parami) {
        this.QVF = null;
      }
      notifyAll();
      AppMethodBeat.o(97201);
    }
    
    /* Error */
    public final void c(javax.microedition.khronos.opengles.GL10 paramGL10)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 57
      //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 59	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVC	Z
      //   13: ifne +65 -> 78
      //   16: aload_0
      //   17: invokevirtual 62	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:hkq	()V
      //   20: aload_1
      //   21: sipush 7937
      //   24: invokeinterface 68 2 0
      //   29: astore_1
      //   30: aload_0
      //   31: getfield 70	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVB	I
      //   34: ldc 71
      //   36: if_icmpge +23 -> 59
      //   39: aload_1
      //   40: ldc 73
      //   42: invokevirtual 79	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   45: ifne +41 -> 86
      //   48: iconst_1
      //   49: istore_2
      //   50: aload_0
      //   51: iload_2
      //   52: putfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVD	Z
      //   55: aload_0
      //   56: invokevirtual 50	java/lang/Object:notifyAll	()V
      //   59: aload_0
      //   60: getfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVD	Z
      //   63: ifne +28 -> 91
      //   66: iload_3
      //   67: istore_2
      //   68: aload_0
      //   69: iload_2
      //   70: putfield 83	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVE	Z
      //   73: aload_0
      //   74: iconst_1
      //   75: putfield 59	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVC	Z
      //   78: ldc 57
      //   80: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    public final boolean hko()
    {
      try
      {
        boolean bool = this.QVE;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public final boolean hkp()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 87
      //   4: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: invokevirtual 62	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:hkq	()V
      //   11: aload_0
      //   12: getfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:QVD	Z
      //   15: ifne +14 -> 29
      //   18: iconst_1
      //   19: istore_1
      //   20: ldc 87
      //   22: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   25: aload_0
      //   26: monitorexit
      //   27: iload_1
      //   28: ireturn
      //   29: iconst_0
      //   30: istore_1
      //   31: ldc 87
      //   33: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    
    final void hkq()
    {
      if (!this.QVA) {
        this.QVA = true;
      }
    }
  }
  
  public static abstract interface k
  {
    public abstract GL aTV();
  }
  
  static final class l
    extends Writer
  {
    private StringBuilder QVG;
    
    l()
    {
      AppMethodBeat.i(97204);
      this.QVG = new StringBuilder();
      AppMethodBeat.o(97204);
    }
    
    private void GF()
    {
      AppMethodBeat.i(97208);
      if (this.QVG.length() > 0) {
        this.QVG.delete(0, this.QVG.length());
      }
      AppMethodBeat.o(97208);
    }
    
    public final void close()
    {
      AppMethodBeat.i(97205);
      GF();
      AppMethodBeat.o(97205);
    }
    
    public final void flush()
    {
      AppMethodBeat.i(97206);
      GF();
      AppMethodBeat.o(97206);
    }
    
    public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(97207);
      int i = 0;
      if (i < paramInt2)
      {
        char c = paramArrayOfChar[(paramInt1 + i)];
        if (c == '\n') {
          GF();
        }
        for (;;)
        {
          i += 1;
          break;
          this.QVG.append(c);
        }
      }
      AppMethodBeat.o(97207);
    }
  }
  
  public static abstract interface m
  {
    public abstract void hkr();
    
    public abstract void hks();
    
    public abstract void lA(int paramInt1, int paramInt2);
  }
  
  final class n
    extends GLTextureView.b
  {
    public n(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView
 * JD-Core Version:    0.7.0.1
 */