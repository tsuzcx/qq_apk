package com.tencent.mm.plugin.vlog.player;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.d;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.nio.ByteBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogMediaCodecPlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "(IIILcom/tencent/mm/plugin/vlog/model/VideoMaterial;)V", "decoder", "Landroid/media/MediaCodec;", "info", "Landroid/media/MediaCodec$BufferInfo;", "inputDone", "", "lastBufferId", "lastPts", "", "mediaExtractor", "Landroid/media/MediaExtractor;", "mime", "", "outputDone", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "trackId", "videoFormat", "Landroid/media/MediaFormat;", "drainOutputBuffer", "curTime", "enableMute", "", "mute", "feedInputBuffer", "getOffsetPts", "pts", "isMirror", "isOES", "pause", "playing", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "Companion", "plugin-vlog_release"})
public final class e
  extends b
{
  public static final a zac;
  private MediaCodec decoder;
  private long gnu;
  private final MediaCodec.BufferInfo info;
  private MediaExtractor mediaExtractor;
  private String mime;
  private MediaFormat rCs;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private int trackId;
  private boolean yZZ;
  private boolean zaa;
  private int zab;
  
  static
  {
    AppMethodBeat.i(110987);
    zac = new a((byte)0);
    AppMethodBeat.o(110987);
  }
  
  public e(int paramInt1, int paramInt2, int paramInt3, i parami)
  {
    super(paramInt1, paramInt2, paramInt3, (d)parami);
    AppMethodBeat.i(110986);
    this.mime = "";
    this.trackId = -1;
    this.info = new MediaCodec.BufferInfo();
    this.zab = -1;
    this.gnu = -1L;
    AppMethodBeat.o(110986);
  }
  
  private final boolean tq()
  {
    AppMethodBeat.i(110983);
    try
    {
      MediaExtractor localMediaExtractor = this.mediaExtractor;
      if (localMediaExtractor != null)
      {
        MediaCodec localMediaCodec = this.decoder;
        if ((localMediaCodec != null) && (!this.yZZ))
        {
          int i = localMediaCodec.dequeueInputBuffer(10000L);
          ad.d("MicroMsg.VLogVideoPlayer", "feedInputBuffer bufferIndex :".concat(String.valueOf(i)));
          if (i >= 0)
          {
            ByteBuffer localByteBuffer = localMediaCodec.getInputBuffer(i);
            if (localByteBuffer == null) {
              k.fvU();
            }
            int j = localMediaExtractor.readSampleData(localByteBuffer, 0);
            long l = localMediaExtractor.getSampleTime();
            ad.d("MicroMsg.VLogVideoPlayer", "[debug video] [decode] input pts = ".concat(String.valueOf(l)));
            localMediaExtractor.advance();
            if (j > 0)
            {
              localMediaCodec.queueInputBuffer(i, 0, j, l, 0);
              AppMethodBeat.o(110983);
              return true;
            }
            this.yZZ = true;
            localMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
            ad.d("MicroMsg.VLogVideoPlayer", "[debug video] [decode] input done, pts = ".concat(String.valueOf(l)));
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "feedInputBuffer error", new Object[0]);
      }
    }
    AppMethodBeat.o(110983);
    return false;
  }
  
  private final long uh(long paramLong)
  {
    AppMethodBeat.i(110978);
    Object localObject = this.yZT;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
      AppMethodBeat.o(110978);
      throw ((Throwable)localObject);
    }
    long l = ((i)localObject).yZx;
    AppMethodBeat.o(110978);
    return l + paramLong;
  }
  
  private final boolean ui(long paramLong)
  {
    AppMethodBeat.i(110982);
    for (;;)
    {
      try
      {
        localObject = this.decoder;
        if (localObject != null)
        {
          if (this.gnu != -1L)
          {
            long l = this.gnu / 1000L;
            if (paramLong - l <= 0L)
            {
              ad.d("MicroMsg.VLogVideoPlayer", "[debug video] [draw] dura1 = " + paramLong + ", dura2 = " + l);
              if (this.zab != -1)
              {
                ((MediaCodec)localObject).releaseOutputBuffer(this.zab, true);
                this.zab = -1;
              }
              AppMethodBeat.o(110982);
              return true;
            }
            ad.d("MicroMsg.VLogVideoPlayer", "[debug video] [drop] dura1 = " + paramLong + ", dura2 = " + l);
            if (this.zab != -1)
            {
              ((MediaCodec)localObject).releaseOutputBuffer(this.zab, false);
              this.zab = -1;
            }
          }
          if (this.zaa) {
            continue;
          }
          i = ((MediaCodec)localObject).dequeueOutputBuffer(this.info, 10000L);
          ad.d("MicroMsg.VLogVideoPlayer", "drainoutputbuffer bufferIndex: " + i + ", flags: " + this.info.flags);
          if (i != -2) {
            continue;
          }
          localObject = this.decoder;
          if (localObject != null)
          {
            localObject = ((MediaCodec)localObject).getOutputFormat();
            if (localObject != null)
            {
              this.width = ((MediaFormat)localObject).getInteger("width");
              this.height = ((MediaFormat)localObject).getInteger("height");
              if (!((MediaFormat)localObject).containsKey("crop-left")) {
                continue;
              }
              i = ((MediaFormat)localObject).getInteger("crop-left");
              this.yZN = i;
              if (!((MediaFormat)localObject).containsKey("crop-top")) {
                continue;
              }
              i = ((MediaFormat)localObject).getInteger("crop-top");
              this.yZO = i;
              if (!((MediaFormat)localObject).containsKey("crop-right")) {
                continue;
              }
              i = ((MediaFormat)localObject).getInteger("crop-right");
              this.yZP = i;
              if (!((MediaFormat)localObject).containsKey("crop-bottom")) {
                continue;
              }
              i = ((MediaFormat)localObject).getInteger("crop-bottom");
              this.yZQ = i;
              ad.d("MicroMsg.VLogVideoPlayer", "[debug video] format change, cropLeft = " + this.yZN + ", cropTop = " + this.yZO + ", cropRight = " + this.yZP + ", cropBottom = " + this.yZQ);
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        ad.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "drainOutputBuffer error", new Object[0]);
        continue;
        paramLong = this.info.presentationTimeUs;
        ad.d("MicroMsg.VLogVideoPlayer", "[debug video] [decode] lastPts = " + this.gnu + ", pts = " + paramLong);
        this.gnu = paramLong;
        this.zab = i;
        continue;
        AppMethodBeat.o(110982);
      }
      AppMethodBeat.o(110982);
      return false;
      i = -1;
      continue;
      i = -1;
      continue;
      i = -1;
      continue;
      i = -1;
      continue;
      if (i >= 0) {
        if ((this.info.flags & 0x4) != 0)
        {
          this.zaa = true;
          ((MediaCodec)localObject).releaseOutputBuffer(i, false);
          ad.d("MicroMsg.VLogVideoPlayer", "[debug video] [decode] output done, lastPts = " + this.gnu);
          AppMethodBeat.o(110982);
          return true;
        }
      }
    }
    return true;
  }
  
  public final void H(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110981);
    ad.d("MicroMsg.VLogVideoPlayer", "VideoPlayer playing : " + uh(paramLong));
    while (!ui(uh(paramLong))) {
      tq();
    }
    if (paramBoolean)
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture != null)
      {
        localSurfaceTexture.updateTexImage();
        AppMethodBeat.o(110981);
        return;
      }
    }
    AppMethodBeat.o(110981);
  }
  
  public final boolean isOES()
  {
    return true;
  }
  
  public final void pause() {}
  
  public final void prepare()
  {
    AppMethodBeat.i(110979);
    this.aRL = true;
    this.surfaceTexture = new SurfaceTexture(this.yZS);
    this.surface = new Surface(this.surfaceTexture);
    this.dwp = SightVideoJNI.getMp4RotateVFS(this.yZT.path);
    Object localObject1;
    int i;
    int j;
    if (this.dwp == 90)
    {
      this.dwp = 3;
      localObject1 = new MediaExtractor();
      ((MediaExtractor)localObject1).setDataSource(this.yZT.path);
      i = 0;
      j = ((MediaExtractor)localObject1).getTrackCount();
    }
    Object localObject2;
    for (;;)
    {
      if (i < j)
      {
        localObject2 = ((MediaExtractor)localObject1).getTrackFormat(i);
        String str = ((MediaFormat)localObject2).getString("mime");
        k.g(str, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        if (n.mA(str, "video"))
        {
          this.width = ((MediaFormat)localObject2).getInteger("width");
          this.height = ((MediaFormat)localObject2).getInteger("height");
          str = ((MediaFormat)localObject2).getString("mime");
          k.g(str, "mediaFormat.getString(MediaFormat.KEY_MIME)");
          this.mime = str;
          this.rCs = ((MediaFormat)localObject2);
          this.trackId = i;
        }
      }
      else
      {
        ((MediaExtractor)localObject1).release();
        localObject1 = new StringBuilder("prepare video, rotate = ").append(this.dwp).append(", width = ").append(this.width).append(", height = ").append(this.height).append(", startTime = ").append(this.yZT.startTime).append(", endTime = ").append(this.yZT.endTime).append(", videoStartTime = ");
        localObject2 = this.yZT;
        if (localObject2 != null) {
          break label353;
        }
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoMaterial");
        AppMethodBeat.o(110979);
        throw ((Throwable)localObject1);
        if (this.dwp == 180)
        {
          this.dwp = 2;
          break;
        }
        if (this.dwp != 270) {
          break;
        }
        this.dwp = 1;
        break;
      }
      i += 1;
    }
    label353:
    ad.i("MicroMsg.VLogVideoPlayer", ((i)localObject2).yZx + ", videoEndTime = " + ((i)this.yZT).yZy);
    AppMethodBeat.o(110979);
  }
  
  public final void release()
  {
    AppMethodBeat.i(110985);
    this.yZR = false;
    try
    {
      Object localObject = this.mediaExtractor;
      if (localObject != null) {
        ((MediaExtractor)localObject).release();
      }
      localObject = this.decoder;
      if (localObject != null) {
        ((MediaCodec)localObject).stop();
      }
      localObject = this.decoder;
      if (localObject != null) {
        ((MediaCodec)localObject).release();
      }
      localObject = this.surface;
      if (localObject != null) {
        ((Surface)localObject).release();
      }
      localObject = this.surfaceTexture;
      if (localObject != null) {
        ((SurfaceTexture)localObject).release();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "release error", new Object[0]);
      }
    }
    this.surface = null;
    this.surfaceTexture = null;
    this.mediaExtractor = null;
    this.decoder = null;
    this.rCs = null;
    this.aRL = false;
    ad.d("MicroMsg.VLogVideoPlayer", "video player release");
    AppMethodBeat.o(110985);
  }
  
  public final void resume() {}
  
  public final void rl(boolean paramBoolean) {}
  
  public final void stop()
  {
    AppMethodBeat.i(110984);
    this.yZR = false;
    try
    {
      Object localObject = this.decoder;
      if (localObject != null) {
        ((MediaCodec)localObject).stop();
      }
      localObject = this.decoder;
      if (localObject != null) {
        ((MediaCodec)localObject).release();
      }
      this.decoder = null;
      localObject = this.mediaExtractor;
      if (localObject != null) {
        ((MediaExtractor)localObject).release();
      }
      this.mediaExtractor = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "stop error", new Object[0]);
      }
    }
    ad.d("MicroMsg.VLogVideoPlayer", "video player stop");
    AppMethodBeat.o(110984);
  }
  
  public final void ug(long paramLong)
  {
    AppMethodBeat.i(183780);
    if (this.yZR)
    {
      AppMethodBeat.o(183780);
      return;
    }
    this.yZR = true;
    long l = System.currentTimeMillis();
    this.mediaExtractor = new MediaExtractor();
    Object localObject = this.mediaExtractor;
    if (localObject != null) {
      ((MediaExtractor)localObject).setDataSource(this.yZT.path);
    }
    localObject = this.mediaExtractor;
    if (localObject != null) {
      ((MediaExtractor)localObject).selectTrack(this.trackId);
    }
    localObject = this.mediaExtractor;
    if (localObject != null) {
      ((MediaExtractor)localObject).seekTo(uh(paramLong) * 1000L, 0);
    }
    StringBuilder localStringBuilder = new StringBuilder("[debug video] play seekTime :").append(uh(paramLong)).append(", real seekTime: ");
    localObject = this.mediaExtractor;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((MediaExtractor)localObject).getSampleTime());; localObject = null)
    {
      ad.i("MicroMsg.VLogVideoPlayer", localObject);
      if (this.rCs != null)
      {
        this.decoder = MediaCodec.createDecoderByType(this.mime);
        localObject = this.decoder;
        if (localObject != null) {
          ((MediaCodec)localObject).configure(this.rCs, this.surface, null, 0);
        }
        localObject = this.decoder;
        if (localObject != null) {
          ((MediaCodec)localObject).start();
        }
      }
      this.gnu = -1L;
      this.zab = -1;
      this.yZZ = false;
      this.zaa = false;
      ad.d("MicroMsg.VLogVideoPlayer", "[prepare] video play time = ".concat(String.valueOf(System.currentTimeMillis() - l)));
      AppMethodBeat.o(183780);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogMediaCodecPlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.e
 * JD-Core Version:    0.7.0.1
 */