package com.tencent.mm.x;

import android.graphics.Bitmap;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/glrender/FilterRender;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "callbackThread", "Landroid/os/HandlerThread;", "getCallbackThread", "()Landroid/os/HandlerThread;", "setCallbackThread", "(Landroid/os/HandlerThread;)V", "curHeight", "", "getCurHeight", "()I", "setCurHeight", "(I)V", "curWidth", "getCurWidth", "setCurWidth", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "handlerThread", "getHandlerThread", "setHandlerThread", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "inputBitmap", "Landroid/graphics/Bitmap;", "getInputBitmap", "()Landroid/graphics/Bitmap;", "setInputBitmap", "(Landroid/graphics/Bitmap;)V", "inputTextureId", "getInputTextureId", "setInputTextureId", "mEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getMEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setMEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "outputTextureId", "getOutputTextureId", "setOutputTextureId", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "waitingList", "", "Lkotlin/Function1;", "", "getWaitingList", "()Ljava/util/List;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getXLabEffect", "()Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "setXLabEffect", "(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;)V", "allocTexutreMem", "texture", "width", "height", "checkInitOutputBuffer", "copyToByteArray", "buffer", "rowPadding", "extractBitmapBuffer", "Lkotlin/Pair;", "reader", "filter", "lutFilePath", "colorWeight", "", "callback", "initGL", "setBitmap", "bitmap", "start", "originBitmap", "context", "Landroid/content/Context;", "stop", "plugin-photoedit-sdk_release"})
public final class b
{
  final String TAG;
  public Handler callbackHandler;
  MMHandler handler;
  HandlerThread handlerThread;
  public HandlerThread hiB;
  public ImageReader hiC;
  public c.b hiD;
  public Bitmap hiE;
  int hiF;
  int hiG;
  com.tencent.mm.plugin.xlabeffect.b hiH;
  int hiI;
  int hiJ;
  final List<kotlin.g.a.b<Bitmap, x>> hiK;
  
  public b()
  {
    AppMethodBeat.i(163164);
    this.TAG = "MicroMsg.FilterRender";
    this.hiK = ((List)new ArrayList());
    HandlerThread localHandlerThread = d.hC("FilterRenderHandlerThread", 5);
    p.g(localHandlerThread, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
    this.handlerThread = localHandlerThread;
    this.handlerThread.start();
    this.handler = new MMHandler(this.handlerThread.getLooper());
    AppMethodBeat.o(163164);
  }
  
  public final HandlerThread axi()
  {
    AppMethodBeat.i(163161);
    HandlerThread localHandlerThread = this.hiB;
    if (localHandlerThread == null) {
      p.btv("callbackThread");
    }
    AppMethodBeat.o(163161);
    return localHandlerThread;
  }
  
  public final c.b axj()
  {
    AppMethodBeat.i(163162);
    c.b localb = this.hiD;
    if (localb == null) {
      p.btv("mEGLEnvironment");
    }
    AppMethodBeat.o(163162);
    return localb;
  }
  
  public final Bitmap axk()
  {
    AppMethodBeat.i(163163);
    Bitmap localBitmap = this.hiE;
    if (localBitmap == null) {
      p.btv("inputBitmap");
    }
    AppMethodBeat.o(163163);
    return localBitmap;
  }
  
  public final void initGL()
  {
    AppMethodBeat.i(204700);
    Object localObject = c.ilt;
    ImageReader localImageReader = this.hiC;
    if (localImageReader == null) {
      p.btv("imageReader");
    }
    this.hiD = c.a.a((c.a)localObject, localImageReader.getSurface(), 0, 0, null, 16);
    localObject = this.hiH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
    }
    this.hiH = new com.tencent.mm.plugin.xlabeffect.b(this.hiI, this.hiJ);
    localObject = this.hiH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.xlabeffect.b)localObject).zG(false);
    }
    localObject = c.ilt;
    this.hiF = c.a.aMZ();
    localObject = c.ilt;
    this.hiG = c.a.aMZ();
    localObject = c.ilt;
    localObject = this.hiE;
    if (localObject == null) {
      p.btv("inputBitmap");
    }
    c.a.c((Bitmap)localObject, this.hiF);
    int i = this.hiG;
    int j = this.hiI;
    int k = this.hiJ;
    GLES20.glBindTexture(3553, i);
    GLES20.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(204700);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb, kotlin.g.a.b paramb1, String paramString, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(163158);
      synchronized (this.hiL.hiK)
      {
        this.hiL.hiK.add(this.gWe);
        ??? = c.ilt;
        c.a.aMY();
        ??? = this.hiL.hiH;
        if (??? != null)
        {
          ((com.tencent.mm.plugin.xlabeffect.b)???).m(this.hiM, this.hiN);
          com.tencent.mm.plugin.xlabeffect.b.a((com.tencent.mm.plugin.xlabeffect.b)???, this.hiL.hiF, this.hiL.hiG, false, 60);
        }
      }
      synchronized (this.hiL.hiK)
      {
        if (this.hiL.hiK.size() > 0)
        {
          localObject2 = c.ilt;
          localObject2 = c.a.L(this.hiL.hiG, this.hiL.hiI, this.hiL.hiJ);
          ((kotlin.g.a.b)this.hiL.hiK.remove(0)).invoke(localObject2);
        }
        Object localObject2 = x.SXb;
        ??? = c.ilt;
        c.a.a(this.hiL.axj().ilu, this.hiL.axj().eglSurface);
        AppMethodBeat.o(163158);
        return;
        localObject3 = finally;
        AppMethodBeat.o(163158);
        throw localObject3;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163159);
      Log.i(this.hiL.TAG, "initGL");
      Object localObject1 = this.hiL;
      Object localObject2 = d.hz("FilterRenderCallbackHandlerThread", 5);
      p.g(localObject2, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
      p.h(localObject2, "<set-?>");
      ((b)localObject1).hiB = ((HandlerThread)localObject2);
      this.hiL.axi().start();
      localObject1 = this.hiL;
      localObject2 = new Handler(this.hiL.axi().getLooper());
      p.h(localObject2, "<set-?>");
      ((b)localObject1).callbackHandler = ((Handler)localObject2);
      localObject1 = this.hiL;
      localObject2 = ImageReader.newInstance(this.hiL.hiI, this.hiL.hiJ, 1, 3);
      p.g(localObject2, "ImageReader.newInstance(…PixelFormat.RGBA_8888, 3)");
      p.h(localObject2, "<set-?>");
      ((b)localObject1).hiC = ((ImageReader)localObject2);
      localObject1 = this.hiL.hiC;
      if (localObject1 == null) {
        p.btv("imageReader");
      }
      localObject2 = (ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader) {}
      };
      Handler localHandler = this.hiL.callbackHandler;
      if (localHandler == null) {
        p.btv("callbackHandler");
      }
      ((ImageReader)localObject1).setOnImageAvailableListener((ImageReader.OnImageAvailableListener)localObject2, localHandler);
      this.hiL.initGL();
      AppMethodBeat.o(163159);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163160);
      Object localObject = c.ilt;
      c.a.a(this.hiL.axj());
      this.hiL.handlerThread.quit();
      this.hiL.axi().quit();
      localObject = this.hiL.hiH;
      if (localObject != null) {
        ((com.tencent.mm.plugin.xlabeffect.b)localObject).destroy();
      }
      this.hiL.hiH = null;
      AppMethodBeat.o(163160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.x.b
 * JD-Core Version:    0.7.0.1
 */