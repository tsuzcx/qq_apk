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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "Lcom/tencent/mm/media/decoder/IMediaCodecTransDecoder;", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "startTimeMs", "", "endTimeMs", "mediaExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "surface", "Landroid/view/Surface;", "width", "", "height", "enableOutputBuffer", "", "outputFps", "init", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "succ", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/ArrayList;JJLcom/tencent/mm/media/extractor/MediaExtractorWrapper;Landroid/view/Surface;IIZILkotlin/jvm/functions/Function2;)V", "blendProvider", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "getBlendProvider", "()Lkotlin/jvm/functions/Function1;", "setBlendProvider", "(Lkotlin/jvm/functions/Function1;)V", "decodeFinish", "getDecodeFinish", "()Z", "setDecodeFinish", "(Z)V", "drawCallback", "Ljava/nio/Buffer;", "getDrawCallback", "()Lkotlin/jvm/functions/Function2;", "setDrawCallback", "(Lkotlin/jvm/functions/Function2;)V", "getEnableOutputBuffer", "glThread", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "getGlThread", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;", "setGlThread", "(Lcom/tencent/mm/plugin/recordvideo/background/image2video/GLThread;)V", "getHeight", "()I", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "imageReader", "Landroid/media/ImageReader;", "getImageReader", "()Landroid/media/ImageReader;", "setImageReader", "(Landroid/media/ImageReader;)V", "getInit", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "getRender", "()Lcom/tencent/mm/plugin/recordvideo/background/image2video/StoryImageVideoRender;", "renderOutputBuffer", "Ljava/nio/ByteBuffer;", "getRenderOutputBuffer", "()Ljava/nio/ByteBuffer;", "setRenderOutputBuffer", "(Ljava/nio/ByteBuffer;)V", "stepTime", "getStepTime", "setStepTime", "getWidth", "checkInitRenderOutputBuffer", "releaseDecoder", "requestRender", "setPauseDecoder", "pause", "setVideoBlendBitmapProvider", "blendBitmapProvider", "startDecode", "Companion", "plugin-recordvideo_release"})
public final class d
  extends com.tencent.mm.media.d.f
{
  public static final d.a BLB;
  private static final String TAG = "MicroMsg.MediaCodecFakeDecoder";
  final m<d, Boolean, x> BLA;
  final h BLs;
  c BLt;
  long BLu;
  boolean BLv;
  b<? super Long, Bitmap> BLw;
  m<? super Boolean, ? super Buffer, x> BLx;
  ArrayList<String> BLy;
  final boolean BLz;
  private final int height;
  private ImageReader hiC;
  ByteBuffer ijF;
  long pts;
  private final int width;
  
  static
  {
    AppMethodBeat.i(75276);
    BLB = new d.a((byte)0);
    TAG = "MicroMsg.MediaCodecFakeDecoder";
    AppMethodBeat.o(75276);
  }
  
  public d(ArrayList<String> paramArrayList, long paramLong1, long paramLong2, Surface paramSurface, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, m<? super d, ? super Boolean, x> paramm)
  {
    super(paramLong1, paramLong2, paramSurface, paramInt3);
    AppMethodBeat.i(75275);
    this.BLy = paramArrayList;
    this.width = paramInt1;
    this.height = paramInt2;
    this.BLz = paramBoolean;
    this.BLA = paramm;
    this.BLs = new h();
    paramArrayList = e.BNm;
    this.BLu = (1000L / e.getFrameRate());
    this.BLs.BMh = this.BLu;
    if ((this.ieD == null) && (this.BLz))
    {
      this.hiC = ImageReader.newInstance(this.width, this.height, 1, 3);
      paramArrayList = this.hiC;
      if (paramArrayList == null) {
        p.hyc();
      }
      paramArrayList.setOnImageAvailableListener((ImageReader.OnImageAvailableListener)new ImageReader.OnImageAvailableListener()
      {
        public final void onImageAvailable(ImageReader paramAnonymousImageReader)
        {
          AppMethodBeat.i(75266);
          if (paramAnonymousImageReader == null) {
            p.hyc();
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
          long l = Util.currentTicks();
          this.BLC.aMQ();
          localObject2 = this.BLC.ijF;
          if (localObject2 == null) {
            p.hyc();
          }
          ((ByteBuffer)localObject2).clear();
          localObject2 = this.BLC.ijF;
          if (localObject2 == null) {
            p.hyc();
          }
          ((ByteBuffer)localObject2).order(((ByteBuffer)localObject1).order());
          int j = 0;
          for (i = 0; j < m; i = k * 4 + i)
          {
            ((ByteBuffer)localObject1).limit(j * n + i + k * 4);
            ((ByteBuffer)localObject1).position(j * n + i);
            localObject2 = this.BLC.ijF;
            if (localObject2 == null) {
              p.hyc();
            }
            ((ByteBuffer)localObject2).put((ByteBuffer)localObject1);
            j += 1;
          }
          localObject1 = d.BLB;
          Log.i(d.access$getTAG$cp(), "copyToByteArray cost: " + Util.ticksToNow(l));
          paramAnonymousImageReader.close();
          paramAnonymousImageReader = this.BLC.BLx;
          if (paramAnonymousImageReader != null)
          {
            paramAnonymousImageReader.invoke(Boolean.TRUE, this.BLC.ijF);
            AppMethodBeat.o(75266);
            return;
          }
          AppMethodBeat.o(75266);
        }
      }, null);
      paramArrayList = this.hiC;
      if (paramArrayList == null) {
        p.hyc();
      }
      this.ieD = paramArrayList.getSurface();
    }
    this.BLt = new c(this.ieD, this.BLs);
    this.BLt.dL(this.width, this.height);
    if (this.BLz)
    {
      Log.i(TAG, "init useX264Encoder width:%s, height:%s", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
      aMQ();
      this.BLt.BLq = true;
    }
    this.BLt.start();
    this.BLt.ax((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(75267);
        m localm = this.BLC.BLA;
        if (localm != null)
        {
          localm.invoke(this.BLC, Boolean.TRUE);
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
    Log.i(TAG, "requestRender");
    if (this.BLv)
    {
      AppMethodBeat.o(75271);
      return;
    }
    this.BLt.ax((Runnable)new b(this));
    AppMethodBeat.o(75271);
  }
  
  public final void aMQ()
  {
    AppMethodBeat.i(75272);
    if ((this.width > 0) && (this.height > 0) && (this.ijF == null)) {
      this.ijF = ByteBuffer.allocateDirect(this.width * this.height * 4);
    }
    AppMethodBeat.o(75272);
  }
  
  public final void eU(boolean paramBoolean)
  {
    AppMethodBeat.i(75273);
    Log.d(TAG, "setPauseDecoder ".concat(String.valueOf(paramBoolean)));
    this.dLD = paramBoolean;
    if (!paramBoolean) {
      requestRender();
    }
    AppMethodBeat.o(75273);
  }
  
  public final void releaseDecoder()
  {
    AppMethodBeat.i(75274);
    super.releaseDecoder();
    this.BLt.stop();
    AppMethodBeat.o(75274);
  }
  
  public final void startDecode()
  {
    AppMethodBeat.i(75270);
    this.BLt.ax((Runnable)new c(this));
    requestRender();
    AppMethodBeat.o(75270);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75268);
      Object localObject = this.BLC;
      ((d)localObject).pts += this.BLC.BLu;
      this.BLC.BLs.onDrawFrame();
      localObject = this.BLC.BLw;
      if (localObject != null) {}
      for (localObject = (Bitmap)((b)localObject).invoke(Long.valueOf(this.BLC.pts * 1000L));; localObject = null)
      {
        if (localObject != null)
        {
          h localh = this.BLC.BLs;
          p.h(localObject, "bitmap");
          localh.BMj.eJh();
          localh.BMj.a(a.a.BLe, localh.mWidth, localh.mHeight, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          GLES20.glActiveTexture(33984);
          localh.BMl = f.i((Bitmap)localObject, localh.BMl);
          localh.BMj.Vz(localh.BMl);
          localObject = localh.BMj.BLK;
          if (localh.BMk) {
            Matrix.scaleM((float[])localObject, 0, 1.0F, -1.0F, 1.0F);
          }
          localh.BMj.m((float[])localObject);
          f.eJj();
        }
        this.BLC.BLt.setPresentationTime(this.BLC.pts * 1000000L);
        this.BLC.BLt.eJk();
        localObject = d.a(this.BLC);
        if (localObject != null) {
          ((r)localObject).invoke(null, Long.valueOf(this.BLC.pts * 1000L), new MediaCodec.BufferInfo(), Boolean.FALSE);
        }
        if (!this.BLC.BLz)
        {
          localObject = this.BLC.BLx;
          if (localObject != null) {
            ((m)localObject).invoke(Boolean.TRUE, this.BLC.ijF);
          }
        }
        long l = this.BLC.pts;
        localObject = e.BNm;
        if (l < e.eJs()) {
          break;
        }
        this.BLC.BLv = true;
        localObject = d.b(this.BLC);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(75269);
      this.BLC.BLs.ge((List)this.BLC.BLy);
      AppMethodBeat.o(75269);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.d
 * JD-Core Version:    0.7.0.1
 */