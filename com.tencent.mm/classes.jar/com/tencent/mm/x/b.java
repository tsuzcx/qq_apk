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
import com.tencent.mm.media.j.c;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/glrender/FilterRender;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "callbackThread", "Landroid/os/HandlerThread;", "getCallbackThread", "()Landroid/os/HandlerThread;", "setCallbackThread", "(Landroid/os/HandlerThread;)V", "curHeight", "", "getCurHeight", "()I", "setCurHeight", "(I)V", "curWidth", "getCurWidth", "setCurWidth", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "handlerThread", "getHandlerThread", "setHandlerThread", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "inputBitmap", "Landroid/graphics/Bitmap;", "getInputBitmap", "()Landroid/graphics/Bitmap;", "setInputBitmap", "(Landroid/graphics/Bitmap;)V", "inputTextureId", "getInputTextureId", "setInputTextureId", "mEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getMEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setMEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "outputTextureId", "getOutputTextureId", "setOutputTextureId", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "waitingList", "", "Lkotlin/Function1;", "", "getWaitingList", "()Ljava/util/List;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getXLabEffect", "()Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "setXLabEffect", "(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;)V", "allocTexutreMem", "texture", "width", "height", "checkInitOutputBuffer", "copyToByteArray", "buffer", "rowPadding", "extractBitmapBuffer", "Lkotlin/Pair;", "reader", "filter", "lutFilePath", "colorWeight", "", "callback", "initGL", "setBitmap", "bitmap", "start", "originBitmap", "context", "Landroid/content/Context;", "stop", "plugin-photoedit-sdk_release"})
public final class b
{
  final String TAG;
  public Handler callbackHandler;
  public HandlerThread fZJ;
  public ImageReader fZK;
  public c.b fZL;
  public Bitmap fZM;
  int fZN;
  int fZO;
  XLabEffect fZP;
  int fZQ;
  int fZR;
  final List<d.g.a.b<Bitmap, y>> fZS;
  ao handler;
  HandlerThread handlerThread;
  
  public b()
  {
    AppMethodBeat.i(163164);
    this.TAG = "MicroMsg.FilterRender";
    this.fZS = ((List)new ArrayList());
    HandlerThread localHandlerThread = d.gB("FilterRenderHandlerThread", 5);
    k.g(localHandlerThread, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
    this.handlerThread = localHandlerThread;
    this.handlerThread.start();
    this.handler = new ao(this.handlerThread.getLooper());
    AppMethodBeat.o(163164);
  }
  
  public final HandlerThread aec()
  {
    AppMethodBeat.i(163161);
    HandlerThread localHandlerThread = this.fZJ;
    if (localHandlerThread == null) {
      k.aVY("callbackThread");
    }
    AppMethodBeat.o(163161);
    return localHandlerThread;
  }
  
  public final c.b aed()
  {
    AppMethodBeat.i(163162);
    c.b localb = this.fZL;
    if (localb == null) {
      k.aVY("mEGLEnvironment");
    }
    AppMethodBeat.o(163162);
    return localb;
  }
  
  public final Bitmap aee()
  {
    AppMethodBeat.i(163163);
    Bitmap localBitmap = this.fZM;
    if (localBitmap == null) {
      k.aVY("inputBitmap");
    }
    AppMethodBeat.o(163163);
    return localBitmap;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb, d.g.a.b paramb1, String paramString, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(163158);
      synchronized (this.fZT.fZS)
      {
        this.fZT.fZS.add(this.fPt);
        ??? = c.gWJ;
        c.a.art();
        ??? = this.fZT.fZP;
        if (??? != null)
        {
          ((XLabEffect)???).m(this.fZU, this.fZV);
          XLabEffect.a((XLabEffect)???, this.fZT.fZN, this.fZT.fZO, 0L, false, 60);
        }
      }
      synchronized (this.fZT.fZS)
      {
        if (this.fZT.fZS.size() > 0)
        {
          localObject2 = c.gWJ;
          int i = this.fZT.fZO;
          int j = this.fZT.fZQ;
          int k = this.fZT.fZR;
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
          k.g(localBitmap, "bitmap");
          ((d.g.a.b)this.fZT.fZS.remove(0)).ay(localBitmap);
        }
        Object localObject2 = y.KTp;
        ??? = c.gWJ;
        c.a.a(this.fZT.aed().gWK, this.fZT.aed().eglSurface);
        AppMethodBeat.o(163158);
        return;
        localObject3 = finally;
        AppMethodBeat.o(163158);
        throw localObject3;
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163159);
      ac.i(this.fZT.TAG, "initGL");
      Object localObject1 = this.fZT;
      Object localObject2 = d.gy("FilterRenderCallbackHandlerThread", 5);
      k.g(localObject2, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
      k.h(localObject2, "<set-?>");
      ((b)localObject1).fZJ = ((HandlerThread)localObject2);
      this.fZT.aec().start();
      localObject1 = this.fZT;
      localObject2 = new Handler(this.fZT.aec().getLooper());
      k.h(localObject2, "<set-?>");
      ((b)localObject1).callbackHandler = ((Handler)localObject2);
      localObject1 = this.fZT;
      localObject2 = ImageReader.newInstance(this.fZT.fZQ, this.fZT.fZR, 1, 3);
      k.g(localObject2, "ImageReader.newInstance(…PixelFormat.RGBA_8888, 3)");
      k.h(localObject2, "<set-?>");
      ((b)localObject1).fZK = ((ImageReader)localObject2);
      localObject1 = this.fZT.fZK;
      if (localObject1 == null) {
        k.aVY("imageReader");
      }
      localObject2 = (ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader) {}
      };
      Handler localHandler = this.fZT.callbackHandler;
      if (localHandler == null) {
        k.aVY("callbackHandler");
      }
      ((ImageReader)localObject1).setOnImageAvailableListener((ImageReader.OnImageAvailableListener)localObject2, localHandler);
      localObject1 = this.fZT;
      localObject2 = c.gWJ;
      localObject2 = ((b)localObject1).fZK;
      if (localObject2 == null) {
        k.aVY("imageReader");
      }
      ((b)localObject1).fZL = c.a.a(((ImageReader)localObject2).getSurface(), 0, 0, null, 16);
      localObject2 = ((b)localObject1).fZP;
      if (localObject2 != null) {
        ((XLabEffect)localObject2).destroy();
      }
      ((b)localObject1).fZP = new XLabEffect(((b)localObject1).fZQ, ((b)localObject1).fZR, 1, false, 8);
      localObject2 = ((b)localObject1).fZP;
      if (localObject2 != null) {
        ((XLabEffect)localObject2).uQ(false);
      }
      localObject2 = c.gWJ;
      ((b)localObject1).fZN = c.a.aru();
      localObject2 = c.gWJ;
      ((b)localObject1).fZO = c.a.aru();
      localObject2 = c.gWJ;
      localObject2 = ((b)localObject1).fZM;
      if (localObject2 == null) {
        k.aVY("inputBitmap");
      }
      c.a.b((Bitmap)localObject2, ((b)localObject1).fZN);
      int i = ((b)localObject1).fZO;
      int j = ((b)localObject1).fZQ;
      int k = ((b)localObject1).fZR;
      GLES20.glBindTexture(3553, i);
      GLES20.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      AppMethodBeat.o(163159);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163160);
      Object localObject = c.gWJ;
      c.a.a(this.fZT.aed());
      this.fZT.handlerThread.quit();
      this.fZT.aec().quit();
      localObject = this.fZT.fZP;
      if (localObject != null) {
        ((XLabEffect)localObject).destroy();
      }
      this.fZT.fZP = null;
      AppMethodBeat.o(163160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.x.b
 * JD-Core Version:    0.7.0.1
 */