package com.tencent.mm.videocomposition.effect;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.c;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.TAVGLUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/effect/EffectRenderControllerBase;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "eGLHandler", "Landroid/os/Handler;", "eGLPendingTasks", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "eGLThread", "Landroid/os/HandlerThread;", "<set-?>", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "effectManager", "getEffectManager", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "setEffectManager$video_composition_release", "(Lcom/tencent/mm/xeffect/effect/EffectManager;)V", "frameRenderCallback", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function1;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function1;)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "isEGLInited", "", "()Z", "setEGLInited", "(Z)V", "isEGLReleased", "setEGLReleased", "lastRenderPts", "outputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "getOutputTexture", "()Lcom/tencent/tav/coremedia/TextureInfo;", "setOutputTexture", "(Lcom/tencent/tav/coremedia/TextureInfo;)V", "renderContext", "Lcom/tencent/tav/decoder/RenderContext;", "reportData", "Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;", "getReportData", "()Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;", "setReportData", "(Lcom/tencent/mm/videocomposition/effect/EffectRenderReportData;)V", "requestBitmap", "screenRenderOutput", "Lcom/tencent/mm/videocomposition/effect/EffectTextureScreenOutputRenderer;", "surface", "Landroid/view/Surface;", "surfaceSizeChanged", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "getVLogDirector", "()Lcom/tencent/mm/xeffect/VLogDirector;", "width", "getWidth", "setWidth", "allocOutputTextureMem", "collectInputTextures", "", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "createEGLEnvironment", "createEGLThread", "createVLogDirector", "destroyEGL", "initEGL", "initFromSurface", "initFromSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "initWithoutSurface", "queue", "callback", "queueFirst", "recreateOutputTexture", "release", "render", "requestNextRenderOutputBitmap", "requestRender", "setSize", "setSurface", "video_composition_release"}, k=1, mv={1, 1, 15})
public abstract class d
{
  public EffectManager GpO = new EffectManager();
  private HandlerThread GvT;
  final VLogDirector GvX = new VLogDirector();
  private final String TAG = "EffectRenderControllerBase";
  public kotlin.g.a.b<? super Long, ah> agEA;
  public f agEB = new f();
  long agEC;
  private boolean agEr;
  g agEs;
  TextureInfo agEt;
  volatile boolean agEu;
  private volatile boolean agEv;
  private Handler agEw;
  final ArrayList<a<ah>> agEx = new ArrayList();
  private volatile boolean agEy;
  private kotlin.g.a.b<? super Bitmap, ah> agEz;
  int height;
  RenderContext renderContext;
  Surface surface;
  int width;
  
  protected void AO(long paramLong)
  {
    this.agEB.agEI = System.currentTimeMillis();
    if ((this.width <= 0) || (this.height <= 0))
    {
      getTAG();
      com.tencent.mm.videocomposition.d.b.s("render with size error " + this.width + ", " + this.height, new Object[0]);
      this.agEB.agEJ = true;
      return;
    }
    GLES30.glViewport(0, 0, this.width, this.height);
    this.GvX.setSize(this.width, this.height);
    this.GvX.setOutputSize(this.width, this.height);
    this.GvX.pA(this.width, this.height);
    if ((this.agEr) || (this.agEt == null))
    {
      localObject1 = this.agEt;
      if (localObject1 != null) {
        ((TextureInfo)localObject1).release();
      }
      this.agEt = CIContext.newTextureInfo(this.width, this.height);
      localObject1 = this.agEt;
      if (localObject1 != null)
      {
        GLES30.glBindTexture(3553, ((TextureInfo)localObject1).textureID);
        GLES30.glTexImage2D(3553, 0, 6408, ((TextureInfo)localObject1).width, ((TextureInfo)localObject1).height, 0, 6408, 5121, null);
        GLES30.glBindTexture(3553, 0);
      }
      this.agEr = false;
    }
    Object localObject1 = this.agEt;
    if (localObject1 != null) {}
    for (int i = ((TextureInfo)localObject1).textureID; i <= 0; i = 0)
    {
      this.agEB.agEL = true;
      return;
    }
    localObject1 = jMb();
    if (((List)localObject1).isEmpty())
    {
      this.agEB.agEK = true;
      return;
    }
    this.GvX.b((List)localObject1, i, paramLong);
    Object localObject2;
    if (this.agEy)
    {
      localObject1 = TAVGLUtils.saveBitmap(this.agEt);
      localObject2 = this.agEz;
      if (localObject2 != null) {
        ((kotlin.g.a.b)localObject2).invoke(localObject1);
      }
      this.agEy = false;
      this.agEz = null;
      localObject1 = this.agEA;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(Long.valueOf(paramLong));
      }
      this.agEC = paramLong;
      localObject1 = this.agEB;
      ((f)localObject1).nDx += 1;
      ((f)localObject1).nDw += System.currentTimeMillis() - ((f)localObject1).agEI;
      return;
    }
    localObject1 = this.agEs;
    if (localObject1 != null)
    {
      localObject2 = this.agEt;
      if ((localObject2 != null) && (((TextureInfo)localObject2).textureID > 0)) {
        break label476;
      }
    }
    for (;;)
    {
      localObject1 = this.renderContext;
      if (localObject1 == null) {
        break;
      }
      ((RenderContext)localObject1).swapBuffers();
      break;
      label476:
      GLES20.glUseProgram(((g)localObject1).program);
      RenderContext.checkEglError("glUseProgram");
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(((TextureInfo)localObject2).textureType, ((TextureInfo)localObject2).textureID);
      GLES20.glUniform1i(((g)localObject1).agER, 0);
      ((g)localObject1).mVV.position(0);
      GLES20.glVertexAttribPointer(((g)localObject1).aPositionHandle, 2, 5126, false, 0, (Buffer)((g)localObject1).mVV);
      GLES20.glEnableVertexAttribArray(((g)localObject1).aPositionHandle);
      ((g)localObject1).ynT.position(0);
      GLES20.glVertexAttribPointer(((g)localObject1).agEQ, 2, 5126, false, 0, (Buffer)((g)localObject1).ynT);
      GLES20.glEnableVertexAttribArray(((g)localObject1).agEQ);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glBindTexture(((TextureInfo)localObject2).textureType, 0);
      GLES20.glDisableVertexAttribArray(((g)localObject1).aPositionHandle);
      GLES20.glDisableVertexAttribArray(((g)localObject1).agEQ);
    }
  }
  
  public final void K(a<ah> parama)
  {
    s.t(parama, "callback");
    if (this.agEw != null)
    {
      ??? = this.GvT;
      if ((??? != null) && (((HandlerThread)???).isAlive() == true) && (!this.agEv) && (this.agEu))
      {
        ??? = this.agEw;
        if (??? != null) {
          ((Handler)???).post((Runnable)new e(parama));
        }
        return;
      }
    }
    synchronized (this.agEx)
    {
      this.agEx.add(parama);
      return;
    }
  }
  
  public final void aX(kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    s.t(paramb, "callback");
    this.agEy = true;
    this.agEz = paramb;
    K((a)new c(this));
  }
  
  public final void cf(a<ah> parama)
  {
    s.t(parama, "callback");
    if (this.agEw != null)
    {
      ??? = this.GvT;
      if ((??? != null) && (((HandlerThread)???).isAlive() == true) && (!this.agEv) && (this.agEu))
      {
        ??? = this.agEw;
        if (??? != null) {
          ((Handler)???).postAtFrontOfQueue((Runnable)new e(parama));
        }
        return;
      }
    }
    synchronized (this.agEx)
    {
      this.agEx.add(0, parama);
      parama = ah.aiuX;
      return;
    }
  }
  
  public final void d(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.surface = new Surface(paramSurfaceTexture);
    setSize(paramInt1, paramInt2);
    jMa();
  }
  
  protected String getTAG()
  {
    return this.TAG;
  }
  
  protected void jMa()
  {
    com.tencent.mm.videocomposition.d.b.i(getTAG(), "initEGL", new Object[0]);
    this.agEv = false;
    this.agEB.agEG = System.currentTimeMillis();
    Object localObject = new HandlerThread("EffectRenderView_EGLRenderThread");
    ((HandlerThread)localObject).start();
    this.agEw = new Handler(((HandlerThread)localObject).getLooper());
    this.GvT = ((HandlerThread)localObject);
    localObject = this.agEw;
    if (localObject != null) {
      ((Handler)localObject).post((Runnable)new b(this));
    }
  }
  
  public abstract List<c> jMb();
  
  public void jMc()
  {
    com.tencent.mm.videocomposition.d.b.printInfoStack(getTAG(), "destroyEGL", new Object[0]);
    this.agEv = true;
    synchronized (this.agEx)
    {
      this.agEx.clear();
      Object localObject2 = ah.aiuX;
      this.agEu = false;
      ??? = this.agEw;
      localObject2 = this.GvT;
      this.GvT = null;
      this.agEw = null;
      if (??? != null) {
        ((Handler)???).post((Runnable)new a(this, (HandlerThread)localObject2));
      }
      return;
    }
  }
  
  public final void ls(final long paramLong)
  {
    K((a)new d(this, paramLong));
  }
  
  public final void pl(int paramInt1, int paramInt2)
  {
    setSize(paramInt1, paramInt2);
    jMa();
  }
  
  public final void release()
  {
    com.tencent.mm.videocomposition.d.b.i(getTAG(), "release", new Object[0]);
    this.GpO.destroy();
    this.GpO = new EffectManager();
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.width) || (paramInt2 != this.height)) {
      this.agEr = true;
    }
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final void setSurface(final Surface paramSurface)
  {
    this.surface = paramSurface;
    if (this.renderContext != null) {
      K((a)new e(this, paramSurface));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
  static final class a
    implements Runnable
  {
    a(d paramd, HandlerThread paramHandlerThread) {}
    
    public final void run()
    {
      AppMethodBeat.i(233607);
      this.agED.GvX.destroy();
      Object localObject = this.agED.agEt;
      if (localObject != null) {
        ((TextureInfo)localObject).release();
      }
      localObject = this.agED.agEs;
      if (localObject != null) {
        GLES30.glDeleteProgram(((g)localObject).program);
      }
      localObject = this.agED.surface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      localObject = this.agED.renderContext;
      if (localObject != null) {
        ((RenderContext)localObject).release();
      }
      localObject = this.agED.agEB;
      if (((f)localObject).agEF)
      {
        kotlin.g.a.b localb = f.agEM;
        if (localb != null) {
          localb.invoke(localObject);
        }
      }
      localObject = this.agEE;
      if (localObject != null) {
        ((HandlerThread)localObject).quitSafely();
      }
      com.tencent.mm.videocomposition.d.b.i(this.agED.getTAG(), "destroyEGL finished", new Object[0]);
      AppMethodBeat.o(233607);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 15})
  static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(233606);
      d.a(this.agED);
      ??? = this.agED;
      ((d)???).GvX.init();
      ((d)???).GvX.c(((d)???).GpO);
      this.agED.agEs = new g();
      this.agED.agEu = true;
      ??? = this.agED.agEB;
      ((f)???).agEH = (System.currentTimeMillis() - ((f)???).agEG);
      synchronized (this.agED.agEx)
      {
        Iterator localIterator = ((Iterable)this.agED.agEx).iterator();
        if (localIterator.hasNext()) {
          ((a)localIterator.next()).invoke();
        }
      }
      this.agED.agEx.clear();
      ah localah = ah.aiuX;
      com.tencent.mm.videocomposition.d.b.i(this.agED.getTAG(), "initEGL finished", new Object[0]);
      AppMethodBeat.o(233606);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class c
    extends u
    implements a<ah>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class d
    extends u
    implements a<ah>
  {
    d(d paramd, long paramLong)
    {
      super();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 15})
  static final class e
    extends u
    implements a<ah>
  {
    e(d paramd, Surface paramSurface)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.d
 * JD-Core Version:    0.7.0.1
 */