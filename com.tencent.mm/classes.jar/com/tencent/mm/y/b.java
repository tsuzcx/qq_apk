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
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/glrender/FilterRender;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "callbackThread", "Landroid/os/HandlerThread;", "getCallbackThread", "()Landroid/os/HandlerThread;", "setCallbackThread", "(Landroid/os/HandlerThread;)V", "curHeight", "", "getCurHeight", "()I", "setCurHeight", "(I)V", "curWidth", "getCurWidth", "setCurWidth", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "handlerThread", "getHandlerThread", "setHandlerThread", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "inputBitmap", "Landroid/graphics/Bitmap;", "getInputBitmap", "()Landroid/graphics/Bitmap;", "setInputBitmap", "(Landroid/graphics/Bitmap;)V", "inputTextureId", "getInputTextureId", "setInputTextureId", "mEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getMEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setMEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "outputTextureId", "getOutputTextureId", "setOutputTextureId", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "waitingList", "", "Lkotlin/Function1;", "", "getWaitingList", "()Ljava/util/List;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getXLabEffect", "()Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "setXLabEffect", "(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;)V", "allocTexutreMem", "texture", "width", "height", "checkInitOutputBuffer", "copyToByteArray", "buffer", "rowPadding", "extractBitmapBuffer", "Lkotlin/Pair;", "reader", "filter", "lutFilePath", "colorWeight", "", "callback", "initGL", "setBitmap", "bitmap", "start", "originBitmap", "context", "Landroid/content/Context;", "stop", "plugin-photoedit-sdk_release"})
public final class b
{
  final String TAG;
  public Handler callbackHandler;
  public HandlerThread gtf;
  public ImageReader gtg;
  public c.b gth;
  public Bitmap gti;
  int gtj;
  int gtk;
  com.tencent.mm.plugin.xlabeffect.b gtl;
  int gtm;
  int gtn;
  final List<d.g.a.b<Bitmap, z>> gto;
  ap handler;
  HandlerThread handlerThread;
  
  public b()
  {
    AppMethodBeat.i(163164);
    this.TAG = "MicroMsg.FilterRender";
    this.gto = ((List)new ArrayList());
    HandlerThread localHandlerThread = d.gZ("FilterRenderHandlerThread", 5);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
    this.handlerThread = localHandlerThread;
    this.handlerThread.start();
    this.handler = new ap(this.handlerThread.getLooper());
    AppMethodBeat.o(163164);
  }
  
  public final HandlerThread agH()
  {
    AppMethodBeat.i(163161);
    HandlerThread localHandlerThread = this.gtf;
    if (localHandlerThread == null) {
      p.bcb("callbackThread");
    }
    AppMethodBeat.o(163161);
    return localHandlerThread;
  }
  
  public final c.b agI()
  {
    AppMethodBeat.i(163162);
    c.b localb = this.gth;
    if (localb == null) {
      p.bcb("mEGLEnvironment");
    }
    AppMethodBeat.o(163162);
    return localb;
  }
  
  public final Bitmap agJ()
  {
    AppMethodBeat.i(163163);
    Bitmap localBitmap = this.gti;
    if (localBitmap == null) {
      p.bcb("inputBitmap");
    }
    AppMethodBeat.o(163163);
    return localBitmap;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb, d.g.a.b paramb1, String paramString, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(163158);
      synchronized (this.gtp.gto)
      {
        this.gtp.gto.add(this.giT);
        ??? = c.hoP;
        c.a.aug();
        ??? = this.gtp.gtl;
        if (??? != null)
        {
          ((com.tencent.mm.plugin.xlabeffect.b)???).n(this.gtq, this.gtr);
          com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)???, this.gtp.gtj, this.gtp.gtk, false, 60);
        }
      }
      synchronized (this.gtp.gto)
      {
        if (this.gtp.gto.size() > 0)
        {
          localObject2 = c.hoP;
          int i = this.gtp.gtk;
          int j = this.gtp.gtm;
          int k = this.gtp.gtn;
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
          ((d.g.a.b)this.gtp.gto.remove(0)).invoke(localBitmap);
        }
        Object localObject2 = z.MKo;
        ??? = c.hoP;
        c.a.a(this.gtp.agI().hoQ, this.gtp.agI().eglSurface);
        AppMethodBeat.o(163158);
        return;
        localObject3 = finally;
        AppMethodBeat.o(163158);
        throw localObject3;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163159);
      ad.i(this.gtp.TAG, "initGL");
      Object localObject1 = this.gtp;
      Object localObject2 = d.gW("FilterRenderCallbackHandlerThread", 5);
      p.g(localObject2, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
      p.h(localObject2, "<set-?>");
      ((b)localObject1).gtf = ((HandlerThread)localObject2);
      this.gtp.agH().start();
      localObject1 = this.gtp;
      localObject2 = new Handler(this.gtp.agH().getLooper());
      p.h(localObject2, "<set-?>");
      ((b)localObject1).callbackHandler = ((Handler)localObject2);
      localObject1 = this.gtp;
      localObject2 = ImageReader.newInstance(this.gtp.gtm, this.gtp.gtn, 1, 3);
      p.g(localObject2, "ImageReader.newInstance(…PixelFormat.RGBA_8888, 3)");
      p.h(localObject2, "<set-?>");
      ((b)localObject1).gtg = ((ImageReader)localObject2);
      localObject1 = this.gtp.gtg;
      if (localObject1 == null) {
        p.bcb("imageReader");
      }
      localObject2 = (ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader) {}
      };
      Handler localHandler = this.gtp.callbackHandler;
      if (localHandler == null) {
        p.bcb("callbackHandler");
      }
      ((ImageReader)localObject1).setOnImageAvailableListener((ImageReader.OnImageAvailableListener)localObject2, localHandler);
      localObject1 = this.gtp;
      localObject2 = c.hoP;
      localObject2 = ((b)localObject1).gtg;
      if (localObject2 == null) {
        p.bcb("imageReader");
      }
      ((b)localObject1).gth = c.a.a(((ImageReader)localObject2).getSurface(), 0, 0, null, 16);
      localObject2 = ((b)localObject1).gtl;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject2).destroy();
      }
      ((b)localObject1).gtl = new com.tencent.mm.plugin.xlabeffect.b(((b)localObject1).gtm, ((b)localObject1).gtn, 1, 8);
      localObject2 = ((b)localObject1).gtl;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject2).vB(false);
      }
      localObject2 = c.hoP;
      ((b)localObject1).gtj = c.a.auh();
      localObject2 = c.hoP;
      ((b)localObject1).gtk = c.a.auh();
      localObject2 = c.hoP;
      localObject2 = ((b)localObject1).gti;
      if (localObject2 == null) {
        p.bcb("inputBitmap");
      }
      c.a.b((Bitmap)localObject2, ((b)localObject1).gtj);
      int i = ((b)localObject1).gtk;
      int j = ((b)localObject1).gtm;
      int k = ((b)localObject1).gtn;
      GLES20.glBindTexture(3553, i);
      GLES20.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      AppMethodBeat.o(163159);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163160);
      Object localObject = c.hoP;
      c.a.a(this.gtp.agI());
      this.gtp.handlerThread.quit();
      this.gtp.agH().quit();
      localObject = this.gtp.gtl;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.gtp.gtl = null;
      AppMethodBeat.o(163160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.y.b
 * JD-Core Version:    0.7.0.1
 */