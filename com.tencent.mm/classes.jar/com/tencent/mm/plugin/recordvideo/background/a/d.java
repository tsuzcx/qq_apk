package com.tencent.mm.plugin.recordvideo.background.a;

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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.a.r;
import d.g.b.k;
import d.l;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "surface", "Landroid/view/Surface;", "width", "", "height", "enableOutputBuffer", "", "outputFps", "init", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "succ", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/ArrayList;JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IIZILkotlin/jvm/functions/Function2;)V", "blendProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getBlendProvider", "()Lkotlin/jvm/functions/Function1;", "setBlendProvider", "(Lkotlin/jvm/functions/Function1;)V", "decodeFinish", "getDecodeFinish", "()Z", "setDecodeFinish", "(Z)V", "drawCallback", "Ljava/nio/Buffer;", "getDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "getEnableOutputBuffer", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "getGlThread", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "setGlThread", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;)V", "getHeight", "()I", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "getInit", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "getRender", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "stepTime", "getStepTime", "setStepTime", "getWidth", "checkInitRenderOutputBuffer", "releaseDecoder", "requestRender", "setPauseDecoder", "pause", "setVideoBlendBitmapProvider", "blendBitmapProvider", "startDecode", "Companion", "plugin-recordvideo_release"})
public final class d
  extends com.tencent.mm.media.c.f
{
  private static final String TAG = "MicroMsg.MediaCodecFakeDecoder";
  public static final d.a wnK;
  private ImageReader fZK;
  ByteBuffer gVt;
  private final int height;
  long pts;
  private final int width;
  final h wnB;
  c wnC;
  long wnD;
  boolean wnE;
  b<? super Long, Bitmap> wnF;
  m<? super Boolean, ? super Buffer, y> wnG;
  ArrayList<String> wnH;
  final boolean wnI;
  final m<d, Boolean, y> wnJ;
  
  static
  {
    AppMethodBeat.i(75276);
    wnK = new d.a((byte)0);
    TAG = "MicroMsg.MediaCodecFakeDecoder";
    AppMethodBeat.o(75276);
  }
  
  public d(ArrayList<String> paramArrayList, long paramLong1, long paramLong2, Surface paramSurface, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, m<? super d, ? super Boolean, y> paramm)
  {
    super(paramLong1, paramLong2, null, paramSurface, paramInt3);
    AppMethodBeat.i(75275);
    this.wnH = paramArrayList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.wnI = paramBoolean;
    this.wnJ = paramm;
    this.wnB = new h();
    paramArrayList = e.wps;
    this.wnD = (1000L / e.getFrameRate());
    this.wnB.woo = this.wnD;
    if ((this.gOT == null) && (this.wnI))
    {
      this.fZK = ImageReader.newInstance(this.width, this.height, 1, 3);
      paramArrayList = this.fZK;
      if (paramArrayList == null) {
        k.fOy();
      }
      paramArrayList.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader)
        {
          AppMethodBeat.i(75266);
          if (paramAnonymousImageReader == null) {
            k.fOy();
          }
          paramAnonymousImageReader = paramAnonymousImageReader.acquireNextImage();
          k.g(paramAnonymousImageReader, "image");
          Object localObject1 = paramAnonymousImageReader.getPlanes();
          int k = paramAnonymousImageReader.getWidth();
          int m = paramAnonymousImageReader.getHeight();
          Object localObject2 = localObject1[0];
          k.g(localObject2, "planes[0]");
          int i = ((Image.Plane)localObject2).getRowStride();
          localObject2 = localObject1[0];
          k.g(localObject2, "planes[0]");
          int n = i - ((Image.Plane)localObject2).getPixelStride() * k;
          localObject1 = localObject1[0];
          k.g(localObject1, "planes[0]");
          localObject1 = ((Image.Plane)localObject1).getBuffer();
          k.g(localObject1, "planes[0].buffer");
          long l = bs.Gn();
          this.wnL.arn();
          localObject2 = this.wnL.gVt;
          if (localObject2 == null) {
            k.fOy();
          }
          ((ByteBuffer)localObject2).clear();
          localObject2 = this.wnL.gVt;
          if (localObject2 == null) {
            k.fOy();
          }
          ((ByteBuffer)localObject2).order(((ByteBuffer)localObject1).order());
          int j = 0;
          for (i = 0; j < m; i = k * 4 + i)
          {
            ((ByteBuffer)localObject1).limit(j * n + i + k * 4);
            ((ByteBuffer)localObject1).position(j * n + i);
            localObject2 = this.wnL.gVt;
            if (localObject2 == null) {
              k.fOy();
            }
            ((ByteBuffer)localObject2).put((ByteBuffer)localObject1);
            j += 1;
          }
          localObject1 = d.wnK;
          ac.i(d.access$getTAG$cp(), "copyToByteArray cost: " + bs.aO(l));
          paramAnonymousImageReader.close();
          paramAnonymousImageReader = this.wnL.wnG;
          if (paramAnonymousImageReader != null)
          {
            paramAnonymousImageReader.n(Boolean.TRUE, this.wnL.gVt);
            AppMethodBeat.o(75266);
            return;
          }
          AppMethodBeat.o(75266);
        }
      }, null);
      paramArrayList = this.fZK;
      if (paramArrayList == null) {
        k.fOy();
      }
      this.gOT = paramArrayList.getSurface();
    }
    this.wnC = new c(this.gOT, this.wnB);
    this.wnC.dz(this.width, this.height);
    if (this.wnI)
    {
      ac.i(TAG, "init useX264Encoder width:%s, height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
      arn();
      this.wnC.wnz = true;
    }
    this.wnC.start();
    this.wnC.aq((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75267);
        m localm = this.wnL.wnJ;
        if (localm != null)
        {
          localm.n(this.wnL, Boolean.TRUE);
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
    ac.i(TAG, "requestRender");
    if (this.wnE)
    {
      AppMethodBeat.o(75271);
      return;
    }
    this.wnC.aq((Runnable)new b(this));
    AppMethodBeat.o(75271);
  }
  
  public final void arn()
  {
    AppMethodBeat.i(75272);
    if ((this.width > 0) && (this.height > 0) && (this.gVt == null)) {
      this.gVt = ByteBuffer.allocateDirect(this.width * this.height * 4);
    }
    AppMethodBeat.o(75272);
  }
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(75273);
    ac.d(TAG, "setPauseDecoder ".concat(String.valueOf(paramBoolean)));
    this.dhO = paramBoolean;
    if (!paramBoolean) {
      requestRender();
    }
    AppMethodBeat.o(75273);
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(75274);
    super.releaseDecoder();
    this.wnC.stop();
    AppMethodBeat.o(75274);
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(75270);
    this.wnC.aq((Runnable)new c(this));
    requestRender();
    AppMethodBeat.o(75270);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75268);
      Object localObject = this.wnL;
      ((d)localObject).pts += this.wnL.wnD;
      this.wnL.wnB.onDrawFrame();
      localObject = this.wnL.wnF;
      if (localObject != null) {}
      for (localObject = (Bitmap)((b)localObject).ay(Long.valueOf(this.wnL.pts * 1000L));; localObject = null)
      {
        if (localObject != null)
        {
          h localh = this.wnL.wnB;
          k.h(localObject, "bitmap");
          localh.woq.duH();
          localh.woq.a(a.a.wnn, localh.mWidth, localh.mHeight, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          GLES20.glActiveTexture(33984);
          localh.wos = f.g((Bitmap)localObject, localh.wos);
          localh.woq.Mf(localh.wos);
          localObject = localh.woq.wnR;
          if (localh.wor) {
            Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
          }
          localh.woq.o((float[])localObject);
          f.duJ();
        }
        this.wnL.wnC.duK();
        localObject = d.a(this.wnL);
        if (localObject != null) {
          ((r)localObject).a(null, Long.valueOf(this.wnL.pts * 1000L), new MediaCodec.BufferInfo(), Boolean.FALSE);
        }
        if (!this.wnL.wnI)
        {
          localObject = this.wnL.wnG;
          if (localObject != null) {
            ((m)localObject).n(Boolean.TRUE, this.wnL.gVt);
          }
        }
        long l = this.wnL.pts;
        localObject = e.wps;
        if (l < e.duT()) {
          break;
        }
        this.wnL.wnE = true;
        localObject = d.b(this.wnL);
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75269);
      this.wnL.wnB.eL((List)this.wnL.wnH);
      AppMethodBeat.o(75269);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.d
 * JD-Core Version:    0.7.0.1
 */