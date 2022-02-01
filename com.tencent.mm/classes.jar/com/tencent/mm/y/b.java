package com.tencent.mm.y;

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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/glrender/FilterRender;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "callbackThread", "Landroid/os/HandlerThread;", "getCallbackThread", "()Landroid/os/HandlerThread;", "setCallbackThread", "(Landroid/os/HandlerThread;)V", "curHeight", "", "getCurHeight", "()I", "setCurHeight", "(I)V", "curWidth", "getCurWidth", "setCurWidth", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "handlerThread", "getHandlerThread", "setHandlerThread", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "inputBitmap", "Landroid/graphics/Bitmap;", "getInputBitmap", "()Landroid/graphics/Bitmap;", "setInputBitmap", "(Landroid/graphics/Bitmap;)V", "inputTextureId", "getInputTextureId", "setInputTextureId", "mEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getMEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setMEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "outputTextureId", "getOutputTextureId", "setOutputTextureId", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "waitingList", "", "Lkotlin/Function1;", "", "getWaitingList", "()Ljava/util/List;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getXLabEffect", "()Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "setXLabEffect", "(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;)V", "allocTexutreMem", "texture", "width", "height", "checkInitOutputBuffer", "copyToByteArray", "buffer", "rowPadding", "extractBitmapBuffer", "Lkotlin/Pair;", "reader", "filter", "lutFilePath", "colorWeight", "", "callback", "initGL", "setBitmap", "bitmap", "start", "originBitmap", "context", "Landroid/content/Context;", "stop", "plugin-photoedit-sdk_release"})
public final class b
{
  final String TAG;
  public Handler callbackHandler;
  public HandlerThread fVO;
  public ImageReader fVP;
  public c.b fVQ;
  public Bitmap fVR;
  int fVS;
  int fVT;
  XLabEffect fVU;
  int fVV;
  int fVW;
  final List<d.g.a.b<Bitmap, y>> fVX;
  ap handler;
  HandlerThread handlerThread;
  
  public b()
  {
    AppMethodBeat.i(163164);
    this.TAG = "MicroMsg.FilterRender";
    this.fVX = ((List)new ArrayList());
    HandlerThread localHandlerThread = d.gx("FilterRenderHandlerThread", 5);
    k.g(localHandlerThread, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
    this.handlerThread = localHandlerThread;
    this.handlerThread.start();
    this.handler = new ap(this.handlerThread.getLooper());
    AppMethodBeat.o(163164);
  }
  
  public final HandlerThread acW()
  {
    AppMethodBeat.i(163161);
    HandlerThread localHandlerThread = this.fVO;
    if (localHandlerThread == null) {
      k.aPZ("callbackThread");
    }
    AppMethodBeat.o(163161);
    return localHandlerThread;
  }
  
  public final c.b acX()
  {
    AppMethodBeat.i(163162);
    c.b localb = this.fVQ;
    if (localb == null) {
      k.aPZ("mEGLEnvironment");
    }
    AppMethodBeat.o(163162);
    return localb;
  }
  
  public final Bitmap acY()
  {
    AppMethodBeat.i(163163);
    Bitmap localBitmap = this.fVR;
    if (localBitmap == null) {
      k.aPZ("inputBitmap");
    }
    AppMethodBeat.o(163163);
    return localBitmap;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb, d.g.a.b paramb1, String paramString, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(163158);
      synchronized (this.fVY.fVX)
      {
        this.fVY.fVX.add(this.fLH);
        ??? = c.gwl;
        c.a.akz();
        ??? = this.fVY.fVU;
        if (??? != null)
        {
          ((XLabEffect)???).m(this.fVZ, this.fWa);
          XLabEffect.a((XLabEffect)???, this.fVY.fVS, this.fVY.fVT, 0L, false, 60);
        }
      }
      synchronized (this.fVY.fVX)
      {
        if (this.fVY.fVX.size() > 0)
        {
          localObject2 = c.gwl;
          int i = this.fVY.fVT;
          int j = this.fVY.fVV;
          int k = this.fVY.fVW;
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
          ((d.g.a.b)this.fVY.fVX.remove(0)).aA(localBitmap);
        }
        Object localObject2 = y.JfV;
        ??? = c.gwl;
        c.a.a(this.fVY.acX().gwm, this.fVY.acX().eglSurface);
        AppMethodBeat.o(163158);
        return;
        localObject3 = finally;
        AppMethodBeat.o(163158);
        throw localObject3;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163159);
      ad.i(this.fVY.TAG, "initGL");
      Object localObject1 = this.fVY;
      Object localObject2 = d.gu("FilterRenderCallbackHandlerThread", 5);
      k.g(localObject2, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
      k.h(localObject2, "<set-?>");
      ((b)localObject1).fVO = ((HandlerThread)localObject2);
      this.fVY.acW().start();
      localObject1 = this.fVY;
      localObject2 = new Handler(this.fVY.acW().getLooper());
      k.h(localObject2, "<set-?>");
      ((b)localObject1).callbackHandler = ((Handler)localObject2);
      localObject1 = this.fVY;
      localObject2 = ImageReader.newInstance(this.fVY.fVV, this.fVY.fVW, 1, 3);
      k.g(localObject2, "ImageReader.newInstance(…PixelFormat.RGBA_8888, 3)");
      k.h(localObject2, "<set-?>");
      ((b)localObject1).fVP = ((ImageReader)localObject2);
      localObject1 = this.fVY.fVP;
      if (localObject1 == null) {
        k.aPZ("imageReader");
      }
      localObject2 = (ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader) {}
      };
      Handler localHandler = this.fVY.callbackHandler;
      if (localHandler == null) {
        k.aPZ("callbackHandler");
      }
      ((ImageReader)localObject1).setOnImageAvailableListener((ImageReader.OnImageAvailableListener)localObject2, localHandler);
      localObject1 = this.fVY;
      localObject2 = c.gwl;
      localObject2 = ((b)localObject1).fVP;
      if (localObject2 == null) {
        k.aPZ("imageReader");
      }
      ((b)localObject1).fVQ = c.a.a(((ImageReader)localObject2).getSurface(), 0, 0, null, 16);
      localObject2 = ((b)localObject1).fVU;
      if (localObject2 != null) {
        ((XLabEffect)localObject2).destroy();
      }
      ((b)localObject1).fVU = new XLabEffect(((b)localObject1).fVV, ((b)localObject1).fVW, 1, false, 8);
      localObject2 = ((b)localObject1).fVU;
      if (localObject2 != null) {
        ((XLabEffect)localObject2).tP(false);
      }
      localObject2 = c.gwl;
      ((b)localObject1).fVS = c.a.akA();
      localObject2 = c.gwl;
      ((b)localObject1).fVT = c.a.akA();
      localObject2 = c.gwl;
      localObject2 = ((b)localObject1).fVR;
      if (localObject2 == null) {
        k.aPZ("inputBitmap");
      }
      c.a.b((Bitmap)localObject2, ((b)localObject1).fVS);
      int i = ((b)localObject1).fVT;
      int j = ((b)localObject1).fVV;
      int k = ((b)localObject1).fVW;
      GLES20.glBindTexture(3553, i);
      GLES20.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      AppMethodBeat.o(163159);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163160);
      Object localObject = c.gwl;
      c.a.a(this.fVY.acX());
      this.fVY.handlerThread.quit();
      this.fVY.acW().quit();
      localObject = this.fVY.fVU;
      if (localObject != null) {
        ((XLabEffect)localObject).destroy();
      }
      this.fVY.fVU = null;
      AppMethodBeat.o(163160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.y.b
 * JD-Core Version:    0.7.0.1
 */