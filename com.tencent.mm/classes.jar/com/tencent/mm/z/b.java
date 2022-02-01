package com.tencent.mm.z;

import android.graphics.Bitmap;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/glrender/FilterRender;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "callbackThread", "Landroid/os/HandlerThread;", "getCallbackThread", "()Landroid/os/HandlerThread;", "setCallbackThread", "(Landroid/os/HandlerThread;)V", "curHeight", "", "getCurHeight", "()I", "setCurHeight", "(I)V", "curWidth", "getCurWidth", "setCurWidth", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "handlerThread", "getHandlerThread", "setHandlerThread", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "inputBitmap", "Landroid/graphics/Bitmap;", "getInputBitmap", "()Landroid/graphics/Bitmap;", "setInputBitmap", "(Landroid/graphics/Bitmap;)V", "inputTextureId", "getInputTextureId", "setInputTextureId", "mEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getMEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setMEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "outputTextureId", "getOutputTextureId", "setOutputTextureId", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "waitingList", "", "Lkotlin/Function1;", "", "getWaitingList", "()Ljava/util/List;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getXLabEffect", "()Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "setXLabEffect", "(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;)V", "allocTexutreMem", "texture", "width", "height", "checkInitOutputBuffer", "copyToByteArray", "buffer", "rowPadding", "extractBitmapBuffer", "Lkotlin/Pair;", "reader", "filter", "lutFilePath", "colorWeight", "", "callback", "initGL", "setBitmap", "bitmap", "start", "originBitmap", "context", "Landroid/content/Context;", "stop", "plugin-photoedit-sdk_release"})
public final class b
{
  final String TAG;
  public Handler callbackHandler;
  MMHandler handler;
  HandlerThread handlerThread;
  public ImageReader jUA;
  public c.b jUB;
  public Bitmap jUC;
  int jUD;
  int jUE;
  e jUF;
  int jUG;
  int jUH;
  final List<kotlin.g.a.b<Bitmap, x>> jUI;
  public HandlerThread jUz;
  
  public b()
  {
    AppMethodBeat.i(163164);
    this.TAG = "MicroMsg.FilterRender";
    this.jUI = ((List)new ArrayList());
    HandlerThread localHandlerThread = d.im("FilterRenderHandlerThread", 5);
    p.j(localHandlerThread, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
    this.handlerThread = localHandlerThread;
    this.handlerThread.start();
    this.handler = new MMHandler(this.handlerThread.getLooper());
    AppMethodBeat.o(163164);
  }
  
  public final HandlerThread aEF()
  {
    AppMethodBeat.i(163161);
    HandlerThread localHandlerThread = this.jUz;
    if (localHandlerThread == null) {
      p.bGy("callbackThread");
    }
    AppMethodBeat.o(163161);
    return localHandlerThread;
  }
  
  public final c.b aEG()
  {
    AppMethodBeat.i(163162);
    c.b localb = this.jUB;
    if (localb == null) {
      p.bGy("mEGLEnvironment");
    }
    AppMethodBeat.o(163162);
    return localb;
  }
  
  public final Bitmap aEH()
  {
    AppMethodBeat.i(163163);
    Bitmap localBitmap = this.jUC;
    if (localBitmap == null) {
      p.bGy("inputBitmap");
    }
    AppMethodBeat.o(163163);
    return localBitmap;
  }
  
  public final void initGL()
  {
    AppMethodBeat.i(260252);
    Object localObject = c.lar;
    ImageReader localImageReader = this.jUA;
    if (localImageReader == null) {
      p.bGy("imageReader");
    }
    this.jUB = c.a.a((c.a)localObject, localImageReader.getSurface(), 0, 0, null, 16);
    localObject = this.jUF;
    if (localObject != null) {
      ((e)localObject).destroy();
    }
    this.jUF = new e(this.jUG, this.jUH, 1);
    localObject = this.jUF;
    if (localObject != null) {
      ((e)localObject).DH(false);
    }
    localObject = c.lar;
    this.jUD = c.a.aVC();
    localObject = c.lar;
    this.jUE = c.a.aVC();
    localObject = c.lar;
    localObject = this.jUC;
    if (localObject == null) {
      p.bGy("inputBitmap");
    }
    c.a.d((Bitmap)localObject, this.jUD);
    int i = this.jUE;
    int j = this.jUG;
    int k = this.jUH;
    GLES20.glBindTexture(3553, i);
    GLES20.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(260252);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb, kotlin.g.a.b paramb1, String paramString, float paramFloat) {}
    
    public final void run()
    {
      AppMethodBeat.i(163158);
      synchronized (this.jUJ.jUI)
      {
        this.jUJ.jUI.add(this.jFa);
        ??? = c.lar;
        c.a.aVB();
        ??? = this.jUJ.jUF;
        if (??? != null)
        {
          ((e)???).m(this.jUK, this.jUL);
          e.a((e)???, this.jUJ.jUD, this.jUJ.jUE, false, 60);
        }
      }
      synchronized (this.jUJ.jUI)
      {
        if (this.jUJ.jUI.size() > 0)
        {
          localObject2 = c.lar;
          localObject2 = c.a.O(this.jUJ.jUE, this.jUJ.jUG, this.jUJ.jUH);
          ((kotlin.g.a.b)this.jUJ.jUI.remove(0)).invoke(localObject2);
        }
        Object localObject2 = x.aazN;
        ??? = c.lar;
        c.a.a(this.jUJ.aEG().las, this.jUJ.aEG().eglSurface);
        AppMethodBeat.o(163158);
        return;
        localObject3 = finally;
        AppMethodBeat.o(163158);
        throw localObject3;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163159);
      Log.i(this.jUJ.TAG, "initGL");
      Object localObject1 = this.jUJ;
      Object localObject2 = d.ij("FilterRenderCallbackHandlerThread", 5);
      p.j(localObject2, "SpecialThreadFactory.cre…d\", Thread.NORM_PRIORITY)");
      p.k(localObject2, "<set-?>");
      ((b)localObject1).jUz = ((HandlerThread)localObject2);
      this.jUJ.aEF().start();
      localObject1 = this.jUJ;
      localObject2 = new Handler(this.jUJ.aEF().getLooper());
      p.k(localObject2, "<set-?>");
      ((b)localObject1).callbackHandler = ((Handler)localObject2);
      localObject1 = this.jUJ;
      localObject2 = ImageReader.newInstance(this.jUJ.jUG, this.jUJ.jUH, 1, 3);
      p.j(localObject2, "ImageReader.newInstance(…PixelFormat.RGBA_8888, 3)");
      p.k(localObject2, "<set-?>");
      ((b)localObject1).jUA = ((ImageReader)localObject2);
      localObject1 = this.jUJ.jUA;
      if (localObject1 == null) {
        p.bGy("imageReader");
      }
      localObject2 = (ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader) {}
      };
      Handler localHandler = this.jUJ.callbackHandler;
      if (localHandler == null) {
        p.bGy("callbackHandler");
      }
      ((ImageReader)localObject1).setOnImageAvailableListener((ImageReader.OnImageAvailableListener)localObject2, localHandler);
      this.jUJ.initGL();
      AppMethodBeat.o(163159);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(163160);
      Object localObject = c.lar;
      c.a.a(this.jUJ.aEG());
      this.jUJ.handlerThread.quit();
      this.jUJ.aEF().quit();
      localObject = this.jUJ.jUF;
      if (localObject != null) {
        ((e)localObject).destroy();
      }
      this.jUJ.jUF = null;
      AppMethodBeat.o(163160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.z.b
 * JD-Core Version:    0.7.0.1
 */