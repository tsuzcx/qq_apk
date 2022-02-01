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
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/effect/EffectRenderControllerBase;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "eGLHandler", "Landroid/os/Handler;", "eGLPendingTasks", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "eGLThread", "Landroid/os/HandlerThread;", "<set-?>", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "effectManager", "getEffectManager", "()Lcom/tencent/mm/xeffect/effect/EffectManager;", "frameRenderCallback", "", "getFrameRenderCallback", "()Lkotlin/jvm/functions/Function1;", "setFrameRenderCallback", "(Lkotlin/jvm/functions/Function1;)V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "isEGLInited", "", "()Z", "setEGLInited", "(Z)V", "isEGLReleased", "setEGLReleased", "lastRenderPts", "outputTexture", "Lcom/tencent/tav/coremedia/TextureInfo;", "getOutputTexture", "()Lcom/tencent/tav/coremedia/TextureInfo;", "setOutputTexture", "(Lcom/tencent/tav/coremedia/TextureInfo;)V", "renderContext", "Lcom/tencent/tav/decoder/RenderContext;", "requestBitmap", "screenRenderOutput", "Lcom/tencent/mm/videocomposition/effect/EffectTextureScreenOutputRenderer;", "surface", "Landroid/view/Surface;", "surfaceSizeChanged", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "getVLogDirector", "()Lcom/tencent/mm/xeffect/VLogDirector;", "width", "getWidth", "setWidth", "allocOutputTextureMem", "collectInputTextures", "", "Lcom/tencent/mm/xeffect/InputTexture;", "pts", "createEGLEnvironment", "createEGLThread", "createVLogDirector", "destroyEGL", "initEGL", "initFromSurface", "initFromSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "initWithoutSurface", "queue", "callback", "queueFirst", "recreateOutputTexture", "release", "render", "requestNextRenderOutputBitmap", "requestRender", "setSize", "setSurface", "video_composition_release"})
public abstract class d
{
  public EffectManager ANo = new EffectManager();
  private HandlerThread GhG;
  final VLogDirector GhL = new VLogDirector();
  private final String TAG = "EffectRenderControllerBase";
  private boolean YIJ;
  f YIK;
  TextureInfo YIL;
  volatile boolean YIM;
  private volatile boolean YIN;
  private Handler YIO;
  final ArrayList<a<x>> YIP = new ArrayList();
  private volatile boolean YIQ;
  private kotlin.g.a.b<? super Bitmap, x> YIR;
  public kotlin.g.a.b<? super Long, x> YIS;
  long YIT;
  int height;
  RenderContext renderContext;
  Surface surface;
  int width;
  
  public final void WD(final long paramLong)
  {
    j((a)new d(this, paramLong));
  }
  
  protected final void WE(long paramLong)
  {
    if ((this.width <= 0) || (this.height <= 0))
    {
      getTAG();
      com.tencent.mm.videocomposition.c.b.r("render with size error " + this.width + ", " + this.height, new Object[0]);
    }
    Object localObject2;
    label350:
    for (;;)
    {
      return;
      GLES30.glViewport(0, 0, this.width, this.height);
      this.GhL.setSize(this.width, this.height);
      this.GhL.setOutputSize(this.width, this.height);
      this.GhL.nD(this.width, this.height);
      if ((this.YIJ) || (this.YIL == null))
      {
        localObject1 = this.YIL;
        if (localObject1 != null) {
          ((TextureInfo)localObject1).release();
        }
        this.YIL = CIContext.newTextureInfo(this.width, this.height);
        localObject1 = this.YIL;
        if (localObject1 != null)
        {
          GLES30.glBindTexture(3553, ((TextureInfo)localObject1).textureID);
          GLES30.glTexImage2D(3553, 0, 6408, ((TextureInfo)localObject1).width, ((TextureInfo)localObject1).height, 0, 6408, 5121, null);
          GLES30.glBindTexture(3553, 0);
        }
        this.YIJ = false;
      }
      localObject1 = this.YIL;
      if (localObject1 != null) {}
      for (int i = ((TextureInfo)localObject1).textureID;; i = 0)
      {
        if (i <= 0) {
          break label350;
        }
        localObject1 = igM();
        if (((List)localObject1).isEmpty()) {
          break;
        }
        this.GhL.a((List)localObject1, i, paramLong);
        if (!this.YIQ) {
          break label352;
        }
        localObject1 = TAVGLUtils.saveBitmap(this.YIL);
        localObject2 = this.YIR;
        if (localObject2 != null) {
          ((kotlin.g.a.b)localObject2).invoke(localObject1);
        }
        this.YIQ = false;
        this.YIR = null;
        localObject1 = this.YIS;
        if (localObject1 != null) {
          ((kotlin.g.a.b)localObject1).invoke(Long.valueOf(paramLong));
        }
        this.YIT = paramLong;
        return;
      }
    }
    label352:
    Object localObject1 = this.YIK;
    if (localObject1 != null)
    {
      localObject2 = this.YIL;
      if ((localObject2 != null) && (((TextureInfo)localObject2).textureID > 0)) {
        break label402;
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
      label402:
      GLES20.glUseProgram(((f)localObject1).program);
      RenderContext.checkEglError("glUseProgram");
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(((TextureInfo)localObject2).textureType, ((TextureInfo)localObject2).textureID);
      GLES20.glUniform1i(((f)localObject1).YIY, 0);
      ((f)localObject1).ksb.position(0);
      GLES20.glVertexAttribPointer(((f)localObject1).aPositionHandle, 2, 5126, false, 0, (Buffer)((f)localObject1).ksb);
      GLES20.glEnableVertexAttribArray(((f)localObject1).aPositionHandle);
      ((f)localObject1).vca.position(0);
      GLES20.glVertexAttribPointer(((f)localObject1).YIX, 2, 5126, false, 0, (Buffer)((f)localObject1).vca);
      GLES20.glEnableVertexAttribArray(((f)localObject1).YIX);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glBindTexture(((TextureInfo)localObject2).textureType, 0);
      GLES20.glDisableVertexAttribArray(((f)localObject1).aPositionHandle);
      GLES20.glDisableVertexAttribArray(((f)localObject1).YIX);
    }
  }
  
  public final void ag(kotlin.g.a.b<? super Bitmap, x> paramb)
  {
    p.k(paramb, "callback");
    this.YIQ = true;
    this.YIR = paramb;
    j((a)new c(this));
  }
  
  public final void ao(a<x> parama)
  {
    p.k(parama, "callback");
    if (this.YIO != null)
    {
      ??? = this.GhG;
      if ((??? != null) && (((HandlerThread)???).isAlive() == true) && (!this.YIN) && (this.YIM))
      {
        ??? = this.YIO;
        if (??? != null) {
          ((Handler)???).postAtFrontOfQueue((Runnable)new e(parama));
        }
        return;
      }
    }
    synchronized (this.YIP)
    {
      this.YIP.add(0, parama);
      parama = x.aazN;
      return;
    }
  }
  
  public final void d(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.surface = new Surface(paramSurfaceTexture);
    setSize(paramInt1, paramInt2);
    igL();
  }
  
  protected String getTAG()
  {
    return this.TAG;
  }
  
  protected void igL()
  {
    com.tencent.mm.videocomposition.c.b.i(getTAG(), "initEGL", new Object[0]);
    this.YIN = false;
    Object localObject = new HandlerThread("EffectRenderView_EGLRenderThread");
    ((HandlerThread)localObject).start();
    this.YIO = new Handler(((HandlerThread)localObject).getLooper());
    this.GhG = ((HandlerThread)localObject);
    localObject = this.YIO;
    if (localObject != null) {
      ((Handler)localObject).post((Runnable)new d.b(this));
    }
  }
  
  public abstract List<c> igM();
  
  public void igN()
  {
    com.tencent.mm.videocomposition.c.b.printInfoStack(getTAG(), "destroyEGL", new Object[0]);
    this.YIN = true;
    synchronized (this.YIP)
    {
      this.YIP.clear();
      Object localObject2 = x.aazN;
      this.YIM = false;
      ??? = this.YIO;
      localObject2 = this.GhG;
      this.GhG = null;
      this.YIO = null;
      if (??? != null) {
        ((Handler)???).post((Runnable)new a(this, (HandlerThread)localObject2));
      }
      return;
    }
  }
  
  public final void j(a<x> parama)
  {
    p.k(parama, "callback");
    if (this.YIO != null)
    {
      ??? = this.GhG;
      if ((??? != null) && (((HandlerThread)???).isAlive() == true) && (!this.YIN) && (this.YIM))
      {
        ??? = this.YIO;
        if (??? != null) {
          ((Handler)???).post((Runnable)new e(parama));
        }
        return;
      }
    }
    synchronized (this.YIP)
    {
      this.YIP.add(parama);
      return;
    }
  }
  
  public final void no(int paramInt1, int paramInt2)
  {
    setSize(paramInt1, paramInt2);
    igL();
  }
  
  public final void release()
  {
    com.tencent.mm.videocomposition.c.b.i(getTAG(), "release", new Object[0]);
    this.ANo.destroy();
    this.ANo = new EffectManager();
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != this.width) || (paramInt2 != this.height)) {
      this.YIJ = true;
    }
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final void setSurface(final Surface paramSurface)
  {
    this.surface = paramSurface;
    if (this.renderContext != null) {
      j((a)new e(this, paramSurface));
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(d paramd, HandlerThread paramHandlerThread) {}
    
    public final void run()
    {
      AppMethodBeat.i(248194);
      this.YIU.GhL.destroy();
      Object localObject = this.YIU.YIL;
      if (localObject != null) {
        ((TextureInfo)localObject).release();
      }
      localObject = this.YIU.YIK;
      if (localObject != null) {
        GLES30.glDeleteProgram(((f)localObject).program);
      }
      localObject = this.YIU.surface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      localObject = this.YIU.renderContext;
      if (localObject != null) {
        ((RenderContext)localObject).release();
      }
      localObject = this.abTg;
      if (localObject != null) {
        ((HandlerThread)localObject).quitSafely();
      }
      com.tencent.mm.videocomposition.c.b.i(this.YIU.getTAG(), "destroyEGL finished", new Object[0]);
      AppMethodBeat.o(248194);
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(d paramd, long paramLong)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 15}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(d paramd, Surface paramSurface)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.effect.d
 * JD-Core Version:    0.7.0.1
 */