package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.MediaCodec.BufferInfo;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "surface", "Landroid/view/Surface;", "width", "", "height", "enableOutputBuffer", "", "outputFps", "init", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "succ", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/ArrayList;JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IIZILkotlin/jvm/functions/Function2;)V", "blendProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getBlendProvider", "()Lkotlin/jvm/functions/Function1;", "setBlendProvider", "(Lkotlin/jvm/functions/Function1;)V", "decodeFinish", "getDecodeFinish", "()Z", "setDecodeFinish", "(Z)V", "drawCallback", "Ljava/nio/Buffer;", "getDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "getEnableOutputBuffer", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "getGlThread", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "setGlThread", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;)V", "getHeight", "()I", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "getInit", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "getRender", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "stepTime", "getStepTime", "setStepTime", "getWidth", "checkInitRenderOutputBuffer", "releaseDecoder", "requestRender", "setPauseDecoder", "pause", "setVideoBlendBitmapProvider", "blendBitmapProvider", "startDecode", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.media.d.f
{
  public static final d.a NEW;
  private static final String TAG;
  private ArrayList<String> NEX;
  private final boolean NEY;
  private final m<d, Boolean, ah> NEZ;
  private final h NFa;
  private c NFb;
  private long NFc;
  private boolean NFd;
  b<? super Long, Bitmap> NFe;
  m<? super Boolean, ? super Buffer, ah> NFf;
  private final int height;
  private ImageReader imageReader;
  ByteBuffer nDH;
  private long pts;
  private final int width;
  
  static
  {
    AppMethodBeat.i(75276);
    NEW = new d.a((byte)0);
    TAG = "MicroMsg.MediaCodecFakeDecoder";
    AppMethodBeat.o(75276);
  }
  
  public d(ArrayList<String> paramArrayList, long paramLong1, long paramLong2, Surface paramSurface, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, m<? super d, ? super Boolean, ah> paramm)
  {
    super(paramLong1, paramLong2, paramSurface, paramInt3);
    AppMethodBeat.i(75275);
    this.NEX = paramArrayList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.NEY = paramBoolean;
    this.NEZ = paramm;
    this.NFa = new h();
    paramArrayList = com.tencent.mm.plugin.recordvideo.c.f.NGM;
    this.NFc = (1000L / com.tencent.mm.plugin.recordvideo.c.f.getFrameRate());
    this.NFa.NFM = this.NFc;
    if ((boR() == null) && (this.NEY))
    {
      this.imageReader = ImageReader.newInstance(this.width, this.height, 1, 3);
      paramArrayList = this.imageReader;
      s.checkNotNull(paramArrayList);
      paramArrayList.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader)
        {
          AppMethodBeat.i(75266);
          s.checkNotNull(paramAnonymousImageReader);
          paramAnonymousImageReader = paramAnonymousImageReader.acquireNextImage();
          Object localObject = paramAnonymousImageReader.getPlanes();
          int m = paramAnonymousImageReader.getWidth();
          int n = paramAnonymousImageReader.getHeight();
          int i1 = localObject[0].getRowStride() - localObject[0].getPixelStride() * m;
          localObject = localObject[0].getBuffer();
          s.s(localObject, "planes[0].buffer");
          long l = Util.currentTicks();
          this.NFg.bqa();
          ByteBuffer localByteBuffer = this.NFg.nDH;
          s.checkNotNull(localByteBuffer);
          localByteBuffer.clear();
          localByteBuffer = this.NFg.nDH;
          s.checkNotNull(localByteBuffer);
          localByteBuffer.order(((ByteBuffer)localObject).order());
          int i;
          int j;
          if (n > 0)
          {
            i = 0;
            j = 0;
          }
          for (;;)
          {
            int k = i + 1;
            ((ByteBuffer)localObject).limit(i * i1 + j + m * 4);
            ((ByteBuffer)localObject).position(i * i1 + j);
            localByteBuffer = this.NFg.nDH;
            s.checkNotNull(localByteBuffer);
            localByteBuffer.put((ByteBuffer)localObject);
            j += m * 4;
            if (k >= n)
            {
              localObject = d.NEW;
              Log.i(d.access$getTAG$cp(), s.X("copyToByteArray cost: ", Long.valueOf(Util.ticksToNow(l))));
              if (paramAnonymousImageReader != null) {
                paramAnonymousImageReader.close();
              }
              paramAnonymousImageReader = this.NFg.NFf;
              if (paramAnonymousImageReader != null) {
                paramAnonymousImageReader.invoke(Boolean.TRUE, this.NFg.nDH);
              }
              AppMethodBeat.o(75266);
              return;
            }
            i = k;
          }
        }
      }, null);
      paramArrayList = this.imageReader;
      s.checkNotNull(paramArrayList);
      k(paramArrayList.getSurface());
    }
    this.NFb = new c(boR(), this.NFa);
    this.NFb.fd(this.width, this.height);
    if (this.NEY)
    {
      Log.i(TAG, "init useX264Encoder width:%s, height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
      bqa();
      this.NFb.NEU = true;
    }
    this.NFb.start();
    this.NFb.aM(new d..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(75275);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(279496);
    s.u(paramd, "this$0");
    m localm = paramd.NEZ;
    if (localm != null) {
      localm.invoke(paramd, Boolean.TRUE);
    }
    AppMethodBeat.o(279496);
  }
  
  private static final void b(d paramd)
  {
    AppMethodBeat.i(279498);
    s.u(paramd, "this$0");
    paramd.NFa.jI((List)paramd.NEX);
    AppMethodBeat.o(279498);
  }
  
  private static final void c(d paramd)
  {
    AppMethodBeat.i(279503);
    s.u(paramd, "this$0");
    paramd.pts += paramd.NFc;
    paramd.NFa.onDrawFrame();
    Object localObject = paramd.NFe;
    if (localObject == null) {}
    int i;
    int j;
    int k;
    int m;
    float f9;
    float f10;
    float f8;
    float f7;
    float f6;
    float f4;
    for (localObject = null;; localObject = (Bitmap)((b)localObject).invoke(Long.valueOf(paramd.pts * 1000L)))
    {
      h localh;
      f localf;
      a.a locala;
      long l;
      float[] arrayOfFloat1;
      float[] arrayOfFloat2;
      if (localObject != null)
      {
        localh = paramd.NFa;
        s.u(localObject, "bitmap");
        localh.NFO.gHb();
        localf = localh.NFO;
        locala = a.a.NEJ;
        i = localh.mWidth;
        j = localh.mHeight;
        k = ((Bitmap)localObject).getWidth();
        m = ((Bitmap)localObject).getHeight();
        l = System.currentTimeMillis();
        f9 = i / k;
        f10 = j / m;
        f8 = -1.0F;
        f7 = 1.0F;
        f6 = 1.0F;
        f5 = -1.0F;
        f4 = 0.0F;
        f3 = 1.0F;
        arrayOfFloat1 = Arrays.copyOf(localf.NEM, localf.NEM.length);
        arrayOfFloat2 = Arrays.copyOf(localf.NEL, localf.NEL.length);
      }
      switch (f.1.NFo[locala.ordinal()])
      {
      default: 
        f1 = 1.0F;
        f2 = 0.0F;
        arrayOfFloat1[0] = f4;
        arrayOfFloat1[1] = f1;
        arrayOfFloat1[2] = f3;
        arrayOfFloat1[3] = f1;
        arrayOfFloat1[4] = f4;
        arrayOfFloat1[5] = f2;
        arrayOfFloat1[6] = f3;
        arrayOfFloat1[7] = f2;
        arrayOfFloat2[0] = f8;
        arrayOfFloat2[1] = f5;
        arrayOfFloat2[3] = f7;
        arrayOfFloat2[4] = f5;
        arrayOfFloat2[6] = f8;
        arrayOfFloat2[7] = f6;
        arrayOfFloat2[9] = f7;
        arrayOfFloat2[10] = f6;
        localf.NEN = ByteBuffer.allocateDirect(arrayOfFloat2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        localf.NEN.put(arrayOfFloat2).position(0);
        GLES20.glVertexAttribPointer(0, 3, 5126, false, 0, localf.NEN);
        GLES20.glEnableVertexAttribArray(0);
        localf.NEO = ByteBuffer.allocateDirect(arrayOfFloat1.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        localf.NEO.put(arrayOfFloat1).position(0);
        GLES20.glVertexAttribPointer(1, 2, 5126, false, 0, localf.NEO);
        GLES20.glEnableVertexAttribArray(1);
        new StringBuilder("scale cost:").append(System.currentTimeMillis() - l);
        GLES20.glActiveTexture(33984);
        localh.NFQ = f.i((Bitmap)localObject, localh.NFQ);
        localObject = localh.NFO;
        GLES20.glBindTexture(3553, localh.NFQ);
        GLES20.glUniform1f(((f)localObject).NEP, 0.0F);
        localObject = localh.NFO.NFn;
        if (localh.NFP) {
          Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
        }
        GLES20.glUniformMatrix4fv(localh.NFO.mPl, 1, false, (float[])localObject, 0);
        GLES20.glDrawArrays(5, 0, 4);
        localObject = paramd.NFb;
        l = paramd.pts;
        if (((c)localObject).muS != null) {
          EGLExt.eglPresentationTimeANDROID(((c)localObject).muS.nFB, ((c)localObject).muS.eglSurface, l * 1000000L);
        }
        paramd.NFb.gHd();
        localObject = paramd.nyK;
        if (localObject != null) {
          ((r)localObject).a(null, Long.valueOf(paramd.pts * 1000L), new MediaCodec.BufferInfo(), Boolean.FALSE);
        }
        if (!paramd.NEY)
        {
          localObject = paramd.NFf;
          if (localObject != null) {
            ((m)localObject).invoke(Boolean.TRUE, paramd.nDH);
          }
        }
        l = paramd.pts;
        localObject = com.tencent.mm.plugin.recordvideo.c.f.NGM;
        if (l >= com.tencent.mm.plugin.recordvideo.c.f.gHp())
        {
          paramd.NFd = true;
          paramd = paramd.nyL;
          if (paramd != null) {
            paramd.invoke();
          }
        }
        AppMethodBeat.o(279503);
        return;
      }
    }
    float f3 = 0.0F;
    float f1 = 0.0F;
    if (f9 < f10) {
      f2 = k - (int)(i / f10);
    }
    for (;;)
    {
      f4 = f2 / 2.0F / k;
      f2 = f1 / 2.0F / m;
      f1 = 1.0F - f2;
      f3 = 1.0F - f4;
      break;
      f2 = f3;
      if (f9 > f10)
      {
        f1 = m - (int)(j / f9);
        f2 = f3;
      }
    }
    float f2 = i;
    float f5 = j;
    if (f9 < f10) {
      f1 = m * f9;
    }
    for (;;)
    {
      f7 = f2 / i;
      f8 = 0.0F - f7;
      f6 = f1 / j;
      f5 = 0.0F - f6;
      f1 = 1.0F;
      f2 = 0.0F;
      break;
      f1 = f5;
      if (f9 > f10)
      {
        f2 = k * f10;
        f1 = f5;
      }
    }
  }
  
  private void requestRender()
  {
    AppMethodBeat.i(75271);
    Log.i(TAG, "requestRender");
    if (this.NFd)
    {
      AppMethodBeat.o(75271);
      return;
    }
    this.NFb.aM(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(75271);
  }
  
  public final void bqa()
  {
    AppMethodBeat.i(75272);
    if ((this.width > 0) && (this.height > 0) && (this.nDH == null)) {
      this.nDH = ByteBuffer.allocateDirect(this.width * this.height * 4);
    }
    AppMethodBeat.o(75272);
  }
  
  public final void gl(boolean paramBoolean)
  {
    AppMethodBeat.i(75273);
    Log.d(TAG, s.X("setPauseDecoder ", Boolean.valueOf(paramBoolean)));
    setPause(paramBoolean);
    if (!paramBoolean) {
      requestRender();
    }
    AppMethodBeat.o(75273);
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(75274);
    super.releaseDecoder();
    this.NFb.stop();
    AppMethodBeat.o(75274);
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(75270);
    this.NFb.aM(new d..ExternalSyntheticLambda2(this));
    requestRender();
    AppMethodBeat.o(75270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.d
 * JD-Core Version:    0.7.0.1
 */