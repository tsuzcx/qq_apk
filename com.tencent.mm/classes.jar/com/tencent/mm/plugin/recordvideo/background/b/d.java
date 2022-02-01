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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "surface", "Landroid/view/Surface;", "width", "", "height", "enableOutputBuffer", "", "outputFps", "init", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "succ", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/ArrayList;JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IIZILkotlin/jvm/functions/Function2;)V", "blendProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getBlendProvider", "()Lkotlin/jvm/functions/Function1;", "setBlendProvider", "(Lkotlin/jvm/functions/Function1;)V", "decodeFinish", "getDecodeFinish", "()Z", "setDecodeFinish", "(Z)V", "drawCallback", "Ljava/nio/Buffer;", "getDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "getEnableOutputBuffer", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "getGlThread", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "setGlThread", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;)V", "getHeight", "()I", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "getInit", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "getRender", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "stepTime", "getStepTime", "setStepTime", "getWidth", "checkInitRenderOutputBuffer", "releaseDecoder", "requestRender", "setPauseDecoder", "pause", "setVideoBlendBitmapProvider", "blendBitmapProvider", "startDecode", "Companion", "plugin-recordvideo_release"})
public final class d
  extends com.tencent.mm.media.d.f
{
  private static final String TAG = "MicroMsg.MediaCodecFakeDecoder";
  public static final d.a xLx;
  private ImageReader gvN;
  private final int height;
  ByteBuffer hqk;
  long pts;
  private final int width;
  final h xLo;
  c xLp;
  long xLq;
  boolean xLr;
  b<? super Long, Bitmap> xLs;
  m<? super Boolean, ? super Buffer, z> xLt;
  ArrayList<String> xLu;
  final boolean xLv;
  final m<d, Boolean, z> xLw;
  
  static
  {
    AppMethodBeat.i(75276);
    xLx = new d.a((byte)0);
    TAG = "MicroMsg.MediaCodecFakeDecoder";
    AppMethodBeat.o(75276);
  }
  
  public d(ArrayList<String> paramArrayList, long paramLong1, long paramLong2, Surface paramSurface, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, m<? super d, ? super Boolean, z> paramm)
  {
    super(paramLong1, paramLong2, null, paramSurface, paramInt3);
    AppMethodBeat.i(75275);
    this.xLu = paramArrayList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.xLv = paramBoolean;
    this.xLw = paramm;
    this.xLo = new h();
    paramArrayList = e.xNf;
    this.xLq = (1000L / e.getFrameRate());
    this.xLo.xMb = this.xLq;
    if ((this.hlH == null) && (this.xLv))
    {
      this.gvN = ImageReader.newInstance(this.width, this.height, 1, 3);
      paramArrayList = this.gvN;
      if (paramArrayList == null) {
        p.gkB();
      }
      paramArrayList.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader)
        {
          AppMethodBeat.i(75266);
          if (paramAnonymousImageReader == null) {
            p.gkB();
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
          long l = bu.HQ();
          this.xLy.aup();
          localObject2 = this.xLy.hqk;
          if (localObject2 == null) {
            p.gkB();
          }
          ((ByteBuffer)localObject2).clear();
          localObject2 = this.xLy.hqk;
          if (localObject2 == null) {
            p.gkB();
          }
          ((ByteBuffer)localObject2).order(((ByteBuffer)localObject1).order());
          int j = 0;
          for (i = 0; j < m; i = k * 4 + i)
          {
            ((ByteBuffer)localObject1).limit(j * n + i + k * 4);
            ((ByteBuffer)localObject1).position(j * n + i);
            localObject2 = this.xLy.hqk;
            if (localObject2 == null) {
              p.gkB();
            }
            ((ByteBuffer)localObject2).put((ByteBuffer)localObject1);
            j += 1;
          }
          localObject1 = d.xLx;
          ae.i(d.access$getTAG$cp(), "copyToByteArray cost: " + bu.aO(l));
          paramAnonymousImageReader.close();
          paramAnonymousImageReader = this.xLy.xLt;
          if (paramAnonymousImageReader != null)
          {
            paramAnonymousImageReader.p(Boolean.TRUE, this.xLy.hqk);
            AppMethodBeat.o(75266);
            return;
          }
          AppMethodBeat.o(75266);
        }
      }, null);
      paramArrayList = this.gvN;
      if (paramArrayList == null) {
        p.gkB();
      }
      this.hlH = paramArrayList.getSurface();
    }
    this.xLp = new c(this.hlH, this.xLo);
    this.xLp.dB(this.width, this.height);
    if (this.xLv)
    {
      ae.i(TAG, "init useX264Encoder width:%s, height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
      aup();
      this.xLp.xLm = true;
    }
    this.xLp.start();
    this.xLp.an((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75267);
        m localm = this.xLy.xLw;
        if (localm != null)
        {
          localm.p(this.xLy, Boolean.TRUE);
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
    ae.i(TAG, "requestRender");
    if (this.xLr)
    {
      AppMethodBeat.o(75271);
      return;
    }
    this.xLp.an((Runnable)new b(this));
    AppMethodBeat.o(75271);
  }
  
  public final void aup()
  {
    AppMethodBeat.i(75272);
    if ((this.width > 0) && (this.height > 0) && (this.hqk == null)) {
      this.hqk = ByteBuffer.allocateDirect(this.width * this.height * 4);
    }
    AppMethodBeat.o(75272);
  }
  
  public final void ed(boolean paramBoolean)
  {
    AppMethodBeat.i(75273);
    ae.d(TAG, "setPauseDecoder ".concat(String.valueOf(paramBoolean)));
    this.dus = paramBoolean;
    if (!paramBoolean) {
      requestRender();
    }
    AppMethodBeat.o(75273);
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(75274);
    super.releaseDecoder();
    this.xLp.stop();
    AppMethodBeat.o(75274);
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(75270);
    this.xLp.an((Runnable)new c(this));
    requestRender();
    AppMethodBeat.o(75270);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75268);
      Object localObject = this.xLy;
      ((d)localObject).pts += this.xLy.xLq;
      this.xLy.xLo.onDrawFrame();
      localObject = this.xLy.xLs;
      if (localObject != null) {}
      for (localObject = (Bitmap)((b)localObject).invoke(Long.valueOf(this.xLy.pts * 1000L));; localObject = null)
      {
        if (localObject != null)
        {
          h localh = this.xLy.xLo;
          p.h(localObject, "bitmap");
          localh.xMd.dIu();
          localh.xMd.a(a.a.xLa, localh.mWidth, localh.mHeight, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          GLES20.glActiveTexture(33984);
          localh.xMf = f.g((Bitmap)localObject, localh.xMf);
          localh.xMd.Ok(localh.xMf);
          localObject = localh.xMd.xLE;
          if (localh.xMe) {
            Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
          }
          localh.xMd.m((float[])localObject);
          f.dIw();
        }
        this.xLy.xLp.dIx();
        localObject = d.a(this.xLy);
        if (localObject != null) {
          ((r)localObject).a(null, Long.valueOf(this.xLy.pts * 1000L), new MediaCodec.BufferInfo(), Boolean.FALSE);
        }
        if (!this.xLy.xLv)
        {
          localObject = this.xLy.xLt;
          if (localObject != null) {
            ((m)localObject).p(Boolean.TRUE, this.xLy.hqk);
          }
        }
        long l = this.xLy.pts;
        localObject = e.xNf;
        if (l < e.dIF()) {
          break;
        }
        this.xLy.xLr = true;
        localObject = d.b(this.xLy);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75269);
      this.xLy.xLo.fi((List)this.xLy.xLu);
      AppMethodBeat.o(75269);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.d
 * JD-Core Version:    0.7.0.1
 */