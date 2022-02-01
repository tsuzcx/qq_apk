package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.MediaCodec.BufferInfo;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "surface", "Landroid/view/Surface;", "width", "", "height", "enableOutputBuffer", "", "outputFps", "init", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "succ", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/ArrayList;JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IIZILkotlin/jvm/functions/Function2;)V", "blendProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getBlendProvider", "()Lkotlin/jvm/functions/Function1;", "setBlendProvider", "(Lkotlin/jvm/functions/Function1;)V", "decodeFinish", "getDecodeFinish", "()Z", "setDecodeFinish", "(Z)V", "drawCallback", "Ljava/nio/Buffer;", "getDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "getEnableOutputBuffer", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "getGlThread", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "setGlThread", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;)V", "getHeight", "()I", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "getInit", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "getRender", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "stepTime", "getStepTime", "setStepTime", "getWidth", "checkInitRenderOutputBuffer", "releaseDecoder", "requestRender", "setPauseDecoder", "pause", "setVideoBlendBitmapProvider", "blendBitmapProvider", "startDecode", "Companion", "plugin-recordvideo_release"})
public final class d
  extends com.tencent.mm.media.d.f
{
  private static final String TAG = "MicroMsg.MediaCodecFakeDecoder";
  public static final d.a xvA;
  private ImageReader gtg;
  private final int height;
  ByteBuffer hnw;
  long pts;
  private final int width;
  final h xvr;
  c xvs;
  long xvt;
  boolean xvu;
  b<? super Long, Bitmap> xvv;
  m<? super Boolean, ? super Buffer, z> xvw;
  ArrayList<String> xvx;
  final boolean xvy;
  final m<d, Boolean, z> xvz;
  
  static
  {
    AppMethodBeat.i(75276);
    xvA = new d.a((byte)0);
    TAG = "MicroMsg.MediaCodecFakeDecoder";
    AppMethodBeat.o(75276);
  }
  
  public d(ArrayList<String> paramArrayList, long paramLong1, long paramLong2, Surface paramSurface, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, m<? super d, ? super Boolean, z> paramm)
  {
    super(paramLong1, paramLong2, null, paramSurface, paramInt3);
    AppMethodBeat.i(75275);
    this.xvx = paramArrayList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.xvy = paramBoolean;
    this.xvz = paramm;
    this.xvr = new h();
    paramArrayList = e.xxi;
    this.xvt = (1000L / e.getFrameRate());
    this.xvr.xwe = this.xvt;
    if ((this.hiT == null) && (this.xvy))
    {
      this.gtg = ImageReader.newInstance(this.width, this.height, 1, 3);
      paramArrayList = this.gtg;
      if (paramArrayList == null) {
        p.gfZ();
      }
      paramArrayList.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader)
        {
          AppMethodBeat.i(75266);
          if (paramAnonymousImageReader == null) {
            p.gfZ();
          }
          paramAnonymousImageReader = paramAnonymousImageReader.acquireNextImage();
          p.g(paramAnonymousImageReader, "image");
          Object localObject1 = paramAnonymousImageReader.getPlanes();
          int k = paramAnonymousImageReader.getWidth();
          int m = paramAnonymousImageReader.getHeight();
          Object localObject2 = localObject1[0];
          p.g(localObject2, "planes[0]");
          int i = ((Image.Plane)localObject2).getRowStride();
          localObject2 = localObject1[0];
          p.g(localObject2, "planes[0]");
          int n = i - ((Image.Plane)localObject2).getPixelStride() * k;
          localObject1 = localObject1[0];
          p.g(localObject1, "planes[0]");
          localObject1 = ((Image.Plane)localObject1).getBuffer();
          p.g(localObject1, "planes[0].buffer");
          long l = bt.HI();
          this.xvB.aua();
          localObject2 = this.xvB.hnw;
          if (localObject2 == null) {
            p.gfZ();
          }
          ((ByteBuffer)localObject2).clear();
          localObject2 = this.xvB.hnw;
          if (localObject2 == null) {
            p.gfZ();
          }
          ((ByteBuffer)localObject2).order(((ByteBuffer)localObject1).order());
          int j = 0;
          for (i = 0; j < m; i = k * 4 + i)
          {
            ((ByteBuffer)localObject1).limit(j * n + i + k * 4);
            ((ByteBuffer)localObject1).position(j * n + i);
            localObject2 = this.xvB.hnw;
            if (localObject2 == null) {
              p.gfZ();
            }
            ((ByteBuffer)localObject2).put((ByteBuffer)localObject1);
            j += 1;
          }
          localObject1 = d.xvA;
          ad.i(d.access$getTAG$cp(), "copyToByteArray cost: " + bt.aO(l));
          paramAnonymousImageReader.close();
          paramAnonymousImageReader = this.xvB.xvw;
          if (paramAnonymousImageReader != null)
          {
            paramAnonymousImageReader.p(Boolean.TRUE, this.xvB.hnw);
            AppMethodBeat.o(75266);
            return;
          }
          AppMethodBeat.o(75266);
        }
      }, null);
      paramArrayList = this.gtg;
      if (paramArrayList == null) {
        p.gfZ();
      }
      this.hiT = paramArrayList.getSurface();
    }
    this.xvs = new c(this.hiT, this.xvr);
    this.xvs.dB(this.width, this.height);
    if (this.xvy)
    {
      ad.i(TAG, "init useX264Encoder width:%s, height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
      aua();
      this.xvs.xvp = true;
    }
    this.xvs.start();
    this.xvs.ap((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75267);
        m localm = this.xvB.xvz;
        if (localm != null)
        {
          localm.p(this.xvB, Boolean.TRUE);
          AppMethodBeat.o(75267);
          return;
        }
        AppMethodBeat.o(75267);
      }
    });
    AppMethodBeat.o(75275);
  }
  
  private void requestRender()
  {
    AppMethodBeat.i(75271);
    ad.i(TAG, "requestRender");
    if (this.xvu)
    {
      AppMethodBeat.o(75271);
      return;
    }
    this.xvs.ap((Runnable)new b(this));
    AppMethodBeat.o(75271);
  }
  
  public final void aua()
  {
    AppMethodBeat.i(75272);
    if ((this.width > 0) && (this.height > 0) && (this.hnw == null)) {
      this.hnw = ByteBuffer.allocateDirect(this.width * this.height * 4);
    }
    AppMethodBeat.o(75272);
  }
  
  public final void eb(boolean paramBoolean)
  {
    AppMethodBeat.i(75273);
    ad.d(TAG, "setPauseDecoder ".concat(String.valueOf(paramBoolean)));
    this.dtm = paramBoolean;
    if (!paramBoolean) {
      requestRender();
    }
    AppMethodBeat.o(75273);
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(75274);
    super.releaseDecoder();
    this.xvs.stop();
    AppMethodBeat.o(75274);
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(75270);
    this.xvs.ap((Runnable)new c(this));
    requestRender();
    AppMethodBeat.o(75270);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75268);
      Object localObject = this.xvB;
      ((d)localObject).pts += this.xvB.xvt;
      this.xvB.xvr.onDrawFrame();
      localObject = this.xvB.xvv;
      if (localObject != null) {}
      for (localObject = (Bitmap)((b)localObject).invoke(Long.valueOf(this.xvB.pts * 1000L));; localObject = null)
      {
        if (localObject != null)
        {
          h localh = this.xvB.xvr;
          p.h(localObject, "bitmap");
          localh.xwg.dFd();
          localh.xwg.a(a.a.xvd, localh.mWidth, localh.mHeight, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          GLES20.glActiveTexture(33984);
          localh.xwi = f.g((Bitmap)localObject, localh.xwi);
          localh.xwg.NE(localh.xwi);
          localObject = localh.xwg.xvH;
          if (localh.xwh) {
            Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
          }
          localh.xwg.m((float[])localObject);
          f.dFf();
        }
        this.xvB.xvs.dFg();
        localObject = d.a(this.xvB);
        if (localObject != null) {
          ((r)localObject).a(null, Long.valueOf(this.xvB.pts * 1000L), new MediaCodec.BufferInfo(), Boolean.FALSE);
        }
        if (!this.xvB.xvy)
        {
          localObject = this.xvB.xvw;
          if (localObject != null) {
            ((m)localObject).p(Boolean.TRUE, this.xvB.hnw);
          }
        }
        long l = this.xvB.pts;
        localObject = e.xxi;
        if (l < e.dFo()) {
          break;
        }
        this.xvB.xvu = true;
        localObject = d.b(this.xvB);
        if (localObject == null) {
          break;
        }
        ((a)localObject).invoke();
        AppMethodBeat.o(75268);
        return;
      }
      AppMethodBeat.o(75268);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75269);
      this.xvB.xvr.fa((List)this.xvB.xvx);
      AppMethodBeat.o(75269);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.d
 * JD-Core Version:    0.7.0.1
 */