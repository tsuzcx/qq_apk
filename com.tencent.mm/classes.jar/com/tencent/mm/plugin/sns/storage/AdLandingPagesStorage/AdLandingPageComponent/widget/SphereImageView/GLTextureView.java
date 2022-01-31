package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

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

public class GLTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener
{
  private static final String TAG;
  private static final GLTextureView.j rzW;
  private boolean detached;
  private final WeakReference<GLTextureView> mThisWeakRef;
  private GLTextureView.f rAa;
  private GLTextureView.g rAb;
  private GLTextureView.k rAc;
  private int rAd;
  private int rAe;
  private boolean rAf;
  List<TextureView.SurfaceTextureListener> rAg;
  public GLTextureView.i rzX;
  private GLTextureView.m rzY;
  private GLTextureView.e rzZ;
  
  static
  {
    AppMethodBeat.i(145384);
    TAG = GLTextureView.class.getSimpleName();
    rzW = new GLTextureView.j((byte)0);
    AppMethodBeat.o(145384);
  }
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145364);
    this.mThisWeakRef = new WeakReference(this);
    this.rAg = new ArrayList();
    setSurfaceTextureListener(this);
    AppMethodBeat.o(145364);
  }
  
  private void checkRenderThreadState()
  {
    AppMethodBeat.i(145383);
    if (this.rzX != null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("setRenderer has already been called for this instance.");
      AppMethodBeat.o(145383);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(145383);
  }
  
  private void fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145374);
    GLTextureView.i locali = this.rzX;
    for (;;)
    {
      synchronized (rzW)
      {
        locali.width = paramInt1;
        locali.height = paramInt2;
        locali.rAH = true;
        locali.rAE = true;
        locali.rAF = false;
        rzW.notifyAll();
        if ((locali.rAv) || (locali.kH) || (locali.rAF)) {
          break;
        }
        if ((locali.rAA) && (locali.rAB))
        {
          boolean bool = locali.readyToDraw();
          if (bool)
          {
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break;
            }
            try
            {
              rzW.wait();
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
    AppMethodBeat.o(145374);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(145365);
    try
    {
      if (this.rzX != null) {
        this.rzX.requestExitAndWait();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(145365);
    }
  }
  
  public int getDebugFlags()
  {
    return this.rAd;
  }
  
  public boolean getPreserveEGLContextOnPause()
  {
    return this.rAf;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(145373);
    int i = this.rzX.getRenderMode();
    AppMethodBeat.o(145373);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(145376);
    super.onAttachedToWindow();
    if ((this.detached) && (this.rzY != null)) {
      if (this.rzX == null) {
        break label84;
      }
    }
    label84:
    for (int i = this.rzX.getRenderMode();; i = 1)
    {
      this.rzX = new GLTextureView.i(this.mThisWeakRef);
      if (i != 1) {
        this.rzX.setRenderMode(i);
      }
      this.rzX.start();
      this.detached = false;
      AppMethodBeat.o(145376);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(145377);
    if (this.rzX != null) {
      this.rzX.requestExitAndWait();
    }
    this.detached = true;
    super.onDetachedFromWindow();
    AppMethodBeat.o(145377);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(145378);
    getSurfaceTexture();
    fB(paramInt3 - paramInt1, paramInt4 - paramInt2);
    AppMethodBeat.o(145378);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145379);
    GLTextureView.i locali = this.rzX;
    synchronized (rzW)
    {
      locali.rAx = true;
      rzW.notifyAll();
      for (;;)
      {
        if (locali.rAz)
        {
          boolean bool = locali.rAv;
          if (!bool) {
            try
            {
              rzW.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    fB(paramInt1, paramInt2);
    ??? = this.rAg.iterator();
    while (((Iterator)???).hasNext()) {
      ((TextureView.SurfaceTextureListener)((Iterator)???).next()).onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(145379);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(145381);
    GLTextureView.i locali = this.rzX;
    synchronized (rzW)
    {
      locali.rAx = false;
      rzW.notifyAll();
      for (;;)
      {
        if (!locali.rAz)
        {
          boolean bool = locali.rAv;
          if (!bool) {
            try
            {
              rzW.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    ??? = this.rAg.iterator();
    while (((Iterator)???).hasNext()) {
      ((TextureView.SurfaceTextureListener)((Iterator)???).next()).onSurfaceTextureDestroyed(paramSurfaceTexture);
    }
    AppMethodBeat.o(145381);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145380);
    fB(paramInt1, paramInt2);
    Iterator localIterator = this.rAg.iterator();
    while (localIterator.hasNext()) {
      ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    }
    AppMethodBeat.o(145380);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(145382);
    Iterator localIterator = this.rAg.iterator();
    while (localIterator.hasNext()) {
      ((TextureView.SurfaceTextureListener)localIterator.next()).onSurfaceTextureUpdated(paramSurfaceTexture);
    }
    AppMethodBeat.o(145382);
  }
  
  public final void queueEvent(Runnable paramRunnable)
  {
    AppMethodBeat.i(145375);
    GLTextureView.i locali = this.rzX;
    if (paramRunnable == null)
    {
      paramRunnable = new IllegalArgumentException("r must not be null");
      AppMethodBeat.o(145375);
      throw paramRunnable;
    }
    synchronized (rzW)
    {
      locali.rAG.add(paramRunnable);
      rzW.notifyAll();
      AppMethodBeat.o(145375);
      return;
    }
  }
  
  public void setDebugFlags(int paramInt)
  {
    this.rAd = paramInt;
  }
  
  public void setEGLConfigChooser(GLTextureView.e parame)
  {
    AppMethodBeat.i(145369);
    checkRenderThreadState();
    this.rzZ = parame;
    AppMethodBeat.o(145369);
  }
  
  public void setEGLConfigChooser(boolean paramBoolean)
  {
    AppMethodBeat.i(145370);
    setEGLConfigChooser(new GLTextureView.n(this, paramBoolean));
    AppMethodBeat.o(145370);
  }
  
  public void setEGLContextClientVersion(int paramInt)
  {
    AppMethodBeat.i(145371);
    checkRenderThreadState();
    this.rAe = paramInt;
    AppMethodBeat.o(145371);
  }
  
  public void setEGLContextFactory(GLTextureView.f paramf)
  {
    AppMethodBeat.i(145367);
    checkRenderThreadState();
    this.rAa = paramf;
    AppMethodBeat.o(145367);
  }
  
  public void setEGLWindowSurfaceFactory(GLTextureView.g paramg)
  {
    AppMethodBeat.i(145368);
    checkRenderThreadState();
    this.rAb = paramg;
    AppMethodBeat.o(145368);
  }
  
  public void setGLWrapper(GLTextureView.k paramk)
  {
    this.rAc = paramk;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean)
  {
    this.rAf = paramBoolean;
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(145372);
    this.rzX.setRenderMode(paramInt);
    AppMethodBeat.o(145372);
  }
  
  public void setRenderer(GLTextureView.m paramm)
  {
    AppMethodBeat.i(145366);
    checkRenderThreadState();
    if (this.rzZ == null) {
      this.rzZ = new GLTextureView.n(this, true);
    }
    if (this.rAa == null) {
      this.rAa = new GLTextureView.c(this, (byte)0);
    }
    if (this.rAb == null) {
      this.rAb = new GLTextureView.d((byte)0);
    }
    this.rzY = paramm;
    this.rzX = new GLTextureView.i(this.mThisWeakRef);
    this.rzX.start();
    AppMethodBeat.o(145366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView
 * JD-Core Version:    0.7.0.1
 */