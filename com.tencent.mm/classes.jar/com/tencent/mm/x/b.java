package com.tencent.mm.x;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/glrender/FilterRender;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "callbackThread", "Landroid/os/HandlerThread;", "getCallbackThread", "()Landroid/os/HandlerThread;", "setCallbackThread", "(Landroid/os/HandlerThread;)V", "curHeight", "", "getCurHeight", "()I", "setCurHeight", "(I)V", "curWidth", "getCurWidth", "setCurWidth", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "handlerThread", "getHandlerThread", "setHandlerThread", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "inputBitmap", "Landroid/graphics/Bitmap;", "getInputBitmap", "()Landroid/graphics/Bitmap;", "setInputBitmap", "(Landroid/graphics/Bitmap;)V", "inputTextureId", "getInputTextureId", "setInputTextureId", "mEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getMEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setMEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "outputTextureId", "getOutputTextureId", "setOutputTextureId", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "waitingList", "", "Lkotlin/Function1;", "", "getWaitingList", "()Ljava/util/List;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getXLabEffect", "()Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "setXLabEffect", "(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;)V", "allocTexutreMem", "texture", "width", "height", "checkInitOutputBuffer", "copyToByteArray", "buffer", "rowPadding", "extractBitmapBuffer", "Lkotlin/Pair;", "reader", "filter", "lutFilePath", "colorWeight", "", "callback", "initGL", "setBitmap", "bitmap", "start", "originBitmap", "context", "Landroid/content/Context;", "stop", "plugin-photoedit-sdk_release"})
public final class b
{
  final String TAG;
  public Handler callbackHandler;
  public HandlerThread gvM;
  public ImageReader gvN;
  public c.b gvO;
  public Bitmap gvP;
  int gvQ;
  int gvR;
  com.tencent.mm.plugin.xlabeffect.b gvS;
  int gvT;
  int gvU;
  final List<d.g.a.b<Bitmap, z>> gvV;
  aq handler;
  HandlerThread handlerThread;
  
  public b()
  {
    AppMethodBeat.i(163164);
    this.TAG = "MicroMsg.FilterRender";
    this.gvV = ((List)new ArrayList());
    HandlerThread localHandlerThread = d.hi("FilterRenderHandlerThread", 5);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
    this.handlerThread = localHandlerThread;
    this.handlerThread.start();
    this.handler = new aq(this.handlerThread.getLooper());
    AppMethodBeat.o(163164);
  }
  
  public final HandlerThread agW()
  {
    AppMethodBeat.i(163161);
    HandlerThread localHandlerThread = this.gvM;
    if (localHandlerThread == null) {
      p.bdF("callbackThread");
    }
    AppMethodBeat.o(163161);
    return localHandlerThread;
  }
  
  public final c.b agX()
  {
    AppMethodBeat.i(163162);
    c.b localb = this.gvO;
    if (localb == null) {
      p.bdF("mEGLEnvironment");
    }
    AppMethodBeat.o(163162);
    return localb;
  }
  
  public final Bitmap agY()
  {
    AppMethodBeat.i(163163);
    Bitmap localBitmap = this.gvP;
    if (localBitmap == null) {
      p.bdF("inputBitmap");
    }
    AppMethodBeat.o(163163);
    return localBitmap;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb, d.g.a.b paramb1, String paramString, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(163158);
      synchronized (this.gvW.gvV)
      {
        this.gvW.gvV.add(this.gll);
        ??? = c.hrD;
        c.a.auv();
        ??? = this.gvW.gvS;
        if (??? != null)
        {
          ((com.tencent.mm.plugin.xlabeffect.b)???).o(this.gvX, this.gvY);
          com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)???, this.gvW.gvQ, this.gvW.gvR, false, 60);
        }
      }
      synchronized (this.gvW.gvV)
      {
        if (this.gvW.gvV.size() > 0)
        {
          localObject2 = c.hrD;
          int i = this.gvW.gvR;
          int j = this.gvW.gvT;
          int k = this.gvW.gvU;
          localObject2 = new int[1];
          GLES30.glGenFramebuffers(1, (int[])localObject2, 0);
          GLES30.glBindFramebuffer(36160, localObject2[0]);
          GLES30.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
          ByteBuffer localByteBuffer = ByteBuffer.allocate(j * k * 4);
          GLES30.glReadPixels(0, 0, j, k, 6408, 5121, (Buffer)localByteBuffer);
          Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
          localBitmap.copyPixelsFromBuffer((Buffer)localByteBuffer);
          GLES30.glBindFramebuffer(36160, 0);
          GLES30.glDeleteFramebuffers(1, (int[])localObject2, 0);
          p.g(localBitmap, "bitmap");
          ((d.g.a.b)this.gvW.gvV.remove(0)).invoke(localBitmap);
        }
        Object localObject2 = z.Nhr;
        ??? = c.hrD;
        c.a.a(this.gvW.agX().hrE, this.gvW.agX().eglSurface);
        AppMethodBeat.o(163158);
        return;
        localObject3 = finally;
        AppMethodBeat.o(163158);
        throw localObject3;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163159);
      ae.i(this.gvW.TAG, "initGL");
      Object localObject1 = this.gvW;
      Object localObject2 = d.hf("FilterRenderCallbackHandlerThread", 5);
      p.g(localObject2, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
      p.h(localObject2, "<set-?>");
      ((b)localObject1).gvM = ((HandlerThread)localObject2);
      this.gvW.agW().start();
      localObject1 = this.gvW;
      localObject2 = new Handler(this.gvW.agW().getLooper());
      p.h(localObject2, "<set-?>");
      ((b)localObject1).callbackHandler = ((Handler)localObject2);
      localObject1 = this.gvW;
      localObject2 = ImageReader.newInstance(this.gvW.gvT, this.gvW.gvU, 1, 3);
      p.g(localObject2, "ImageReader.newInstance(…PixelFormat.RGBA_8888, 3)");
      p.h(localObject2, "<set-?>");
      ((b)localObject1).gvN = ((ImageReader)localObject2);
      localObject1 = this.gvW.gvN;
      if (localObject1 == null) {
        p.bdF("imageReader");
      }
      localObject2 = (ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader) {}
      };
      Handler localHandler = this.gvW.callbackHandler;
      if (localHandler == null) {
        p.bdF("callbackHandler");
      }
      ((ImageReader)localObject1).setOnImageAvailableListener((ImageReader.OnImageAvailableListener)localObject2, localHandler);
      localObject1 = this.gvW;
      localObject2 = c.hrD;
      localObject2 = ((b)localObject1).gvN;
      if (localObject2 == null) {
        p.bdF("imageReader");
      }
      ((b)localObject1).gvO = c.a.a(((ImageReader)localObject2).getSurface(), 0, 0, null, 16);
      localObject2 = ((b)localObject1).gvS;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject2).destroy();
      }
      ((b)localObject1).gvS = new com.tencent.mm.plugin.xlabeffect.b(((b)localObject1).gvT, ((b)localObject1).gvU, 1, 8);
      localObject2 = ((b)localObject1).gvS;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject2).vJ(false);
      }
      localObject2 = c.hrD;
      ((b)localObject1).gvQ = c.a.auw();
      localObject2 = c.hrD;
      ((b)localObject1).gvR = c.a.auw();
      localObject2 = c.hrD;
      localObject2 = ((b)localObject1).gvP;
      if (localObject2 == null) {
        p.bdF("inputBitmap");
      }
      c.a.b((Bitmap)localObject2, ((b)localObject1).gvQ);
      int i = ((b)localObject1).gvR;
      int j = ((b)localObject1).gvT;
      int k = ((b)localObject1).gvU;
      GLES20.glBindTexture(3553, i);
      GLES20.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      AppMethodBeat.o(163159);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163160);
      Object localObject = c.hrD;
      c.a.a(this.gvW.agX());
      this.gvW.handlerThread.quit();
      this.gvW.agW().quit();
      localObject = this.gvW.gvS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.gvW.gvS = null;
      AppMethodBeat.o(163160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.x.b
 * JD-Core Version:    0.7.0.1
 */