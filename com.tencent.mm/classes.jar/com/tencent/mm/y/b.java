package com.tencent.mm.y;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.c.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/glrender/FilterRender;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "callbackThread", "Landroid/os/HandlerThread;", "getCallbackThread", "()Landroid/os/HandlerThread;", "setCallbackThread", "(Landroid/os/HandlerThread;)V", "curHeight", "", "getCurHeight", "()I", "setCurHeight", "(I)V", "curWidth", "getCurWidth", "setCurWidth", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setHandler", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "handlerThread", "getHandlerThread", "setHandlerThread", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "inputBitmap", "Landroid/graphics/Bitmap;", "getInputBitmap", "()Landroid/graphics/Bitmap;", "setInputBitmap", "(Landroid/graphics/Bitmap;)V", "inputTextureId", "getInputTextureId", "setInputTextureId", "mEGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getMEGLEnvironment", "()Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "setMEGLEnvironment", "(Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;)V", "outputTextureId", "getOutputTextureId", "setOutputTextureId", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "waitingList", "", "Lkotlin/Function1;", "", "getWaitingList", "()Ljava/util/List;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "getXLabEffect", "()Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "setXLabEffect", "(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;)V", "allocTexutreMem", "texture", "width", "height", "checkInitOutputBuffer", "copyToByteArray", "buffer", "rowPadding", "extractBitmapBuffer", "Lkotlin/Pair;", "reader", "filter", "lutFilePath", "colorWeight", "", "callback", "initGL", "setBitmap", "bitmap", "start", "originBitmap", "context", "Landroid/content/Context;", "stop", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final String TAG;
  private MMHandler handler;
  private HandlerThread handlerThread;
  public ImageReader imageReader;
  public Handler muQ;
  public HandlerThread muR;
  public c.b muS;
  public Bitmap muT;
  private int muU;
  private int muV;
  private k muW;
  private int muX;
  private int muY;
  private final List<kotlin.g.a.b<Bitmap, ah>> muZ;
  
  public b()
  {
    AppMethodBeat.i(163164);
    this.TAG = "MicroMsg.FilterRender";
    this.muZ = ((List)new ArrayList());
    HandlerThread localHandlerThread = d.jy("FilterRenderHandlerThread", 5);
    s.s(localHandlerThread, "createRendererThread(\"Fi…d\", Thread.NORM_PRIORITY)");
    this.handlerThread = localHandlerThread;
    this.handlerThread.start();
    this.handler = new MMHandler(this.handlerThread.getLooper());
    AppMethodBeat.o(163164);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(231395);
    s.u(paramb, "this$0");
    Log.i(paramb.TAG, "initGL");
    Object localObject = d.jv("FilterRenderCallbackHandlerThread", 5);
    s.s(localObject, "createEGLThread(\"FilterR…d\", Thread.NORM_PRIORITY)");
    s.u(localObject, "<set-?>");
    paramb.muR = ((HandlerThread)localObject);
    paramb.aXJ().start();
    localObject = new Handler(paramb.aXJ().getLooper());
    s.u(localObject, "<set-?>");
    paramb.muQ = ((Handler)localObject);
    localObject = ImageReader.newInstance(paramb.muX, paramb.muY, 1, 3);
    s.s(localObject, "newInstance(curWidth, cu…PixelFormat.RGBA_8888, 3)");
    s.u(localObject, "<set-?>");
    paramb.imageReader = ((ImageReader)localObject);
    paramb.aXK().setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new a(), paramb.aXI());
    paramb.initGL();
    AppMethodBeat.o(231395);
  }
  
  private static final void a(b paramb, kotlin.g.a.b arg1, String paramString, float paramFloat)
  {
    AppMethodBeat.i(231391);
    s.u(paramb, "this$0");
    s.u(???, "$callback");
    s.u(paramString, "$lutFilePath");
    synchronized (paramb.muZ)
    {
      paramb.muZ.add(???);
      ??? = c.nFs;
      c.a.bqi();
      ??? = paramb.muW;
      if (??? != null)
      {
        ???.n(paramString, paramFloat);
        k.a(???, paramb.muU, paramb.muV, false, 60);
      }
    }
    synchronized (paramb.muZ)
    {
      if (paramb.muZ.size() > 0)
      {
        paramString = c.nFs;
        paramString = c.a.ad(paramb.muV, paramb.muX, paramb.muY);
        ((kotlin.g.a.b)paramb.muZ.remove(0)).invoke(paramString);
      }
      paramString = ah.aiuX;
      ??? = c.nFs;
      c.a.a(paramb.aXL().nFB, paramb.aXL().eglSurface);
      AppMethodBeat.o(231391);
      return;
      paramb = finally;
      AppMethodBeat.o(231391);
      throw paramb;
    }
  }
  
  private Handler aXI()
  {
    AppMethodBeat.i(231376);
    Handler localHandler = this.muQ;
    if (localHandler != null)
    {
      AppMethodBeat.o(231376);
      return localHandler;
    }
    s.bIx("callbackHandler");
    AppMethodBeat.o(231376);
    return null;
  }
  
  private HandlerThread aXJ()
  {
    AppMethodBeat.i(163161);
    HandlerThread localHandlerThread = this.muR;
    if (localHandlerThread != null)
    {
      AppMethodBeat.o(163161);
      return localHandlerThread;
    }
    s.bIx("callbackThread");
    AppMethodBeat.o(163161);
    return null;
  }
  
  private ImageReader aXK()
  {
    AppMethodBeat.i(231379);
    ImageReader localImageReader = this.imageReader;
    if (localImageReader != null)
    {
      AppMethodBeat.o(231379);
      return localImageReader;
    }
    s.bIx("imageReader");
    AppMethodBeat.o(231379);
    return null;
  }
  
  private c.b aXL()
  {
    AppMethodBeat.i(163162);
    c.b localb = this.muS;
    if (localb != null)
    {
      AppMethodBeat.o(163162);
      return localb;
    }
    s.bIx("mEGLEnvironment");
    AppMethodBeat.o(163162);
    return null;
  }
  
  private static final void b(b paramb)
  {
    AppMethodBeat.i(231398);
    s.u(paramb, "this$0");
    Object localObject = c.nFs;
    c.a.a(paramb.aXL());
    paramb.handlerThread.quit();
    paramb.aXJ().quit();
    localObject = paramb.muW;
    if (localObject != null) {
      ((k)localObject).destroy();
    }
    paramb.muW = null;
    AppMethodBeat.o(231398);
  }
  
  private void initGL()
  {
    AppMethodBeat.i(231387);
    Object localObject = c.a.a(c.nFs, aXK().getSurface(), 0, 0, null, 16);
    s.u(localObject, "<set-?>");
    this.muS = ((c.b)localObject);
    localObject = this.muW;
    if (localObject != null) {
      ((k)localObject).destroy();
    }
    this.muW = new k(this.muX, this.muY, 1);
    localObject = this.muW;
    if (localObject != null) {
      ((k)localObject).Jo(false);
    }
    localObject = c.nFs;
    this.muU = c.a.bql();
    localObject = c.nFs;
    this.muV = c.a.bql();
    localObject = c.nFs;
    c.a.c(aXM(), this.muU);
    int i = this.muV;
    int j = this.muX;
    int k = this.muY;
    GLES20.glBindTexture(3553, i);
    GLES20.glTexImage2D(3553, 0, 6408, j, k, 0, 6408, 5121, null);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(231387);
  }
  
  public final void a(Bitmap paramBitmap, Context paramContext)
  {
    AppMethodBeat.i(231409);
    s.u(paramBitmap, "originBitmap");
    s.u(paramContext, "context");
    s.u(paramBitmap, "<set-?>");
    this.muT = paramBitmap;
    this.muX = paramBitmap.getWidth();
    this.muY = paramBitmap.getHeight();
    this.handler.post(new b..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(231409);
  }
  
  public final void a(String paramString, float paramFloat, kotlin.g.a.b<? super Bitmap, ah> paramb)
  {
    AppMethodBeat.i(231403);
    s.u(paramString, "lutFilePath");
    s.u(paramb, "callback");
    this.handler.post(new b..ExternalSyntheticLambda2(this, paramb, paramString, paramFloat));
    AppMethodBeat.o(231403);
  }
  
  public final Bitmap aXM()
  {
    AppMethodBeat.i(163163);
    Bitmap localBitmap = this.muT;
    if (localBitmap != null)
    {
      AppMethodBeat.o(163163);
      return localBitmap;
    }
    s.bIx("inputBitmap");
    AppMethodBeat.o(163163);
    return null;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(231414);
    this.handler.removeCallbacksAndMessages(null);
    aXI().removeCallbacksAndMessages(null);
    this.handler.post(new b..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(231414);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/glrender/FilterRender$start$1$1", "Landroid/media/ImageReader$OnImageAvailableListener;", "onImageAvailable", "", "reader", "Landroid/media/ImageReader;", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ImageReader.OnImageAvailableListener
  {
    public final void onImageAvailable(ImageReader paramImageReader) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.y.b
 * JD-Core Version:    0.7.0.1
 */