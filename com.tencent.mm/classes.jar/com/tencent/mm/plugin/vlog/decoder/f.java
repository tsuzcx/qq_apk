package com.tencent.mm.plugin.vlog.decoder;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.media.util.e;
import com.tencent.mm.mediaplus.VideoSoftDecoderJni;
import com.tencent.mm.mediaplus.VideoSoftDecoderJni.a;
import com.tencent.tav.codec.IMediaCodec;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.threadpool.c.d;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/decoder/VideoSoftDecoder;", "Lcom/tencent/tav/codec/IMediaCodec;", "()V", "TAG", "", "glThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "handler", "Landroid/os/Handler;", "height", "", "inputBufferQueue", "Lcom/tencent/mm/plugin/vlog/decoder/BufferQueue;", "inputSize", "outputBufferQueue", "outputSize", "ptr", "", "renderContext", "Lcom/tencent/tav/decoder/RenderContext;", "renderProc", "Lcom/tencent/mm/plugin/vlog/decoder/GLRenderProc;", "rotate", "width", "bindSurfaceTexture", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "configure", "format", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "crypto", "Landroid/media/MediaCrypto;", "flags", "createInputSurface", "dequeueInputBuffer", "timeoutUs", "dequeueOutputBuffer", "info", "Landroid/media/MediaCodec$BufferInfo;", "flush", "getInputBuffer", "Ljava/nio/ByteBuffer;", "index", "getOutputBuffer", "getOutputFormat", "queue", "r", "Lkotlin/Function0;", "Ljava/lang/Runnable;", "queueInputBuffer", "offset", "size", "presentationTimeUs", "release", "releaseOutputBuffer", "render", "", "reset", "setDataSource", "path", "signalEndOfInputStream", "start", "stop", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements IMediaCodec
{
  public static final a TXK;
  private final String TAG;
  private int TXL;
  private b TXM;
  private b TXN;
  private c TXO;
  private int dlO;
  private int hYK;
  private final Handler handler;
  private int height;
  private long ptr;
  private RenderContext renderContext;
  private int width;
  private final HandlerThread ynC;
  
  static
  {
    AppMethodBeat.i(281388);
    TXK = new a((byte)0);
    k.load("mediaplus");
    AppMethodBeat.o(281388);
  }
  
  public f()
  {
    AppMethodBeat.i(281341);
    this.TAG = "VideoSoftDecoder";
    this.ynC = d.jv("video_soft_gl", -4);
    this.TXM = new b(3, 0, "in");
    this.TXN = new b(3, 0, "out");
    this.ynC.start();
    this.handler = new Handler(this.ynC.getLooper());
    AppMethodBeat.o(281341);
  }
  
  private void K(a<ah> parama)
  {
    AppMethodBeat.i(281344);
    s.u(parama, "r");
    this.handler.post(new f..ExternalSyntheticLambda1(parama));
    AppMethodBeat.o(281344);
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(281356);
    s.u(paramf, "this$0");
    Object localObject = paramf.TXO;
    if (localObject != null)
    {
      GLES20.glDeleteTextures(3, new int[] { ((c)localObject).TXz, ((c)localObject).TXA, ((c)localObject).TXB }, 0);
      GLES20.glDeleteProgram(((c)localObject).nEC);
    }
    localObject = paramf.renderContext;
    if (localObject != null) {
      ((RenderContext)localObject).release();
    }
    paramf.ynC.quit();
    localObject = VideoSoftDecoderJni.nNi;
    VideoSoftDecoderJni.nDestroy(paramf.ptr);
    paramf.ptr = 0L;
    AppMethodBeat.o(281356);
  }
  
  private static final void aH(a parama)
  {
    AppMethodBeat.i(281350);
    s.u(parama, "$tmp0");
    parama.invoke();
    AppMethodBeat.o(281350);
  }
  
  public final void bindSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(281408);
    s.u(paramSurfaceTexture, "surfaceTexture");
    paramSurfaceTexture.setDefaultBufferSize(this.width, this.height);
    AppMethodBeat.o(281408);
  }
  
  public final void configure(MediaFormat paramMediaFormat, final Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
  {
    AppMethodBeat.i(281403);
    if ((paramMediaFormat == null) || (paramSurface == null))
    {
      com.tencent.mm.videocomposition.d.b.e(this.TAG, "format:" + paramMediaFormat + ", surface:" + paramSurface, new Object[0]);
      AppMethodBeat.o(281403);
      return;
    }
    this.width = paramMediaFormat.getInteger("width");
    this.height = paramMediaFormat.getInteger("height");
    this.hYK = e.a(paramMediaFormat, "rotation-degrees");
    this.dlO = e.a(paramMediaFormat, "max-input-size");
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "configure [" + this.width + ", " + this.height + "], " + this.hYK + ", " + this.dlO + ", " + this.TXL, new Object[0]);
    if (this.dlO <= 0) {
      this.dlO = (this.width * this.height);
    }
    this.TXM = new b(3, this.dlO, "in");
    this.TXN = new b(5, this.TXL, "out");
    K((a)new b(this, paramSurface));
    AppMethodBeat.o(281403);
  }
  
  public final Surface createInputSurface()
  {
    return null;
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(281412);
    int i = this.TXM.ww(paramLong);
    if (i >= 0)
    {
      AppMethodBeat.o(281412);
      return i;
    }
    AppMethodBeat.o(281412);
    return -1;
  }
  
  public final int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    AppMethodBeat.i(281428);
    s.u(paramBufferInfo, "info");
    int i = this.TXN.wv(paramLong);
    if (i >= 0)
    {
      b.a locala = this.TXN.apw(i);
      paramBufferInfo.presentationTimeUs = locala.bufferInfo.presentationTimeUs;
      paramBufferInfo.size = locala.bufferInfo.size;
      AppMethodBeat.o(281428);
      return i;
    }
    AppMethodBeat.o(281428);
    return -1;
  }
  
  public final void flush() {}
  
  public final ByteBuffer getInputBuffer(int paramInt)
  {
    AppMethodBeat.i(281417);
    ByteBuffer localByteBuffer = this.TXM.apw(paramInt).buffer;
    AppMethodBeat.o(281417);
    return localByteBuffer;
  }
  
  public final ByteBuffer getOutputBuffer(int paramInt)
  {
    AppMethodBeat.i(281432);
    ByteBuffer localByteBuffer = this.TXN.apw(paramInt).buffer;
    AppMethodBeat.o(281432);
    return localByteBuffer;
  }
  
  public final MediaFormat getOutputFormat()
  {
    return null;
  }
  
  public final void queueInputBuffer(int paramInt1, int paramInt2, final int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(281421);
    b.a locala = this.TXM.apw(paramInt1);
    locala.bufferInfo.presentationTimeUs = paramLong;
    locala.bufferInfo.size = paramInt3;
    this.TXM.hQl();
    K((a)new c(this, paramInt3));
    AppMethodBeat.o(281421);
  }
  
  public final void release()
  {
    AppMethodBeat.i(281458);
    this.handler.post(new f..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(281458);
  }
  
  public final void releaseOutputBuffer(final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(281435);
    if (paramBoolean)
    {
      K((a)new d(this, paramInt));
      AppMethodBeat.o(281435);
      return;
    }
    K((a)new e(this));
    AppMethodBeat.o(281435);
  }
  
  public final void reset() {}
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(281398);
    s.u(paramString, "path");
    VideoSoftDecoderJni.a locala = VideoSoftDecoderJni.nNi;
    this.ptr = VideoSoftDecoderJni.nInit(paramString);
    paramString = VideoSoftDecoderJni.nNi;
    int i = VideoSoftDecoderJni.nGetErrCode(this.ptr);
    paramString = VideoSoftDecoderJni.nNi;
    this.TXL = VideoSoftDecoderJni.nGetOutputBufferSize(this.ptr);
    com.tencent.mm.videocomposition.d.b.i(this.TAG, "init " + this.ptr + ' ' + this.TXL + ' ' + i, new Object[0]);
    paramString = VideoSoftDecoderJni.nNi;
    if (i != VideoSoftDecoderJni.bvC())
    {
      paramString = new ExportRuntimeException(new ExportErrorStatus(-201, null, ""));
      AppMethodBeat.o(281398);
      throw paramString;
    }
    AppMethodBeat.o(281398);
  }
  
  public final void signalEndOfInputStream() {}
  
  public final void start() {}
  
  public final void stop() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/decoder/VideoSoftDecoder$Companion;", "", "()V", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(f paramf, Surface paramSurface)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(f paramf, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(f paramf, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.decoder.f
 * JD-Core Version:    0.7.0.1
 */