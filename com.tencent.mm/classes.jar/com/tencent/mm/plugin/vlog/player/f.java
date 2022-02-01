package com.tencent.mm.plugin.vlog.player;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.ak;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogMediaCodecPlayer;", "Lcom/tencent/mm/plugin/vlog/player/MaterialPlayer;", "texture", "", "drawWidth", "drawHeight", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "(IIILcom/tencent/mm/plugin/vlog/model/VideoMaterial;)V", "decoder", "Landroid/media/MediaCodec;", "info", "Landroid/media/MediaCodec$BufferInfo;", "inputDone", "", "lastBufferId", "lastPts", "", "mediaExtractor", "Landroid/media/MediaExtractor;", "mime", "", "outputDone", "surface", "Landroid/view/Surface;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "trackId", "videoFormat", "Landroid/media/MediaFormat;", "drainOutputBuffer", "curTime", "enableMute", "", "mute", "feedInputBuffer", "getOffsetPts", "pts", "isMirror", "isOES", "pause", "playing", "updateTex", "prepare", "readyAt", "seekTime", "release", "resume", "stop", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends b
{
  public static final a Udm;
  private boolean Udn;
  private boolean Udo;
  private int Udp;
  private String cBw;
  private MediaCodec decoder;
  private final MediaCodec.BufferInfo info;
  private MediaExtractor mediaExtractor;
  private long nyj;
  private Surface surface;
  private SurfaceTexture surfaceTexture;
  private int trackId;
  private MediaFormat videoFormat;
  
  static
  {
    AppMethodBeat.i(110987);
    Udm = new a((byte)0);
    AppMethodBeat.o(110987);
  }
  
  public f(int paramInt1, int paramInt2, int paramInt3, ak paramak)
  {
    super(paramInt1, paramInt2, paramInt3, (com.tencent.mm.plugin.vlog.model.s)paramak);
    AppMethodBeat.i(110986);
    this.cBw = "";
    this.trackId = -1;
    this.info = new MediaCodec.BufferInfo();
    this.Udp = -1;
    this.nyj = -1L;
    AppMethodBeat.o(110986);
  }
  
  private final boolean SC()
  {
    AppMethodBeat.i(110983);
    try
    {
      MediaExtractor localMediaExtractor = this.mediaExtractor;
      if (localMediaExtractor != null)
      {
        MediaCodec localMediaCodec = this.decoder;
        if ((localMediaCodec != null) && (!this.Udn))
        {
          int i = localMediaCodec.dequeueInputBuffer(10000L);
          Log.d("MicroMsg.VLogVideoPlayer", kotlin.g.b.s.X("feedInputBuffer bufferIndex :", Integer.valueOf(i)));
          if (i >= 0)
          {
            ByteBuffer localByteBuffer = localMediaCodec.getInputBuffer(i);
            kotlin.g.b.s.checkNotNull(localByteBuffer);
            kotlin.g.b.s.s(localByteBuffer, "decoder.getInputBuffer(bufferIndex)!!");
            int j = localMediaExtractor.readSampleData(localByteBuffer, 0);
            long l = localMediaExtractor.getSampleTime();
            Log.d("MicroMsg.VLogVideoPlayer", kotlin.g.b.s.X("[debug video] [decode] input pts = ", Long.valueOf(l)));
            localMediaExtractor.advance();
            if (j > 0)
            {
              localMediaCodec.queueInputBuffer(i, 0, j, l, 0);
              AppMethodBeat.o(110983);
              return true;
            }
            this.Udn = true;
            localMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
            Log.d("MicroMsg.VLogVideoPlayer", kotlin.g.b.s.X("[debug video] [decode] input done, pts = ", Long.valueOf(l)));
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "feedInputBuffer error", new Object[0]);
      }
    }
    AppMethodBeat.o(110983);
    return false;
  }
  
  private final long wH(long paramLong)
  {
    AppMethodBeat.i(110978);
    long l = ((ak)this.UcR).Ubf;
    AppMethodBeat.o(110978);
    return l + paramLong;
  }
  
  private final boolean wI(long paramLong)
  {
    AppMethodBeat.i(110982);
    for (;;)
    {
      try
      {
        localObject = this.decoder;
        if (localObject != null)
        {
          if (this.nyj != -1L)
          {
            long l = this.nyj / 1000L;
            if (paramLong - l <= 0L)
            {
              Log.d("MicroMsg.VLogVideoPlayer", "[debug video] [draw] dura1 = " + paramLong + ", dura2 = " + l);
              if (this.Udp != -1)
              {
                ((MediaCodec)localObject).releaseOutputBuffer(this.Udp, true);
                this.Udp = -1;
              }
              AppMethodBeat.o(110982);
              return true;
            }
            Log.d("MicroMsg.VLogVideoPlayer", "[debug video] [drop] dura1 = " + paramLong + ", dura2 = " + l);
            if (this.Udp != -1)
            {
              ((MediaCodec)localObject).releaseOutputBuffer(this.Udp, false);
              this.Udp = -1;
            }
          }
          if (this.Udo) {
            continue;
          }
          i = ((MediaCodec)localObject).dequeueOutputBuffer(this.info, 10000L);
          Log.d("MicroMsg.VLogVideoPlayer", "drainoutputbuffer bufferIndex: " + i + ", flags: " + this.info.flags);
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
              this.cropLeft = i;
              if (!((MediaFormat)localObject).containsKey("crop-top")) {
                continue;
              }
              i = ((MediaFormat)localObject).getInteger("crop-top");
              this.cropTop = i;
              if (!((MediaFormat)localObject).containsKey("crop-right")) {
                continue;
              }
              i = ((MediaFormat)localObject).getInteger("crop-right");
              this.cropRight = i;
              if (!((MediaFormat)localObject).containsKey("crop-bottom")) {
                continue;
              }
              i = ((MediaFormat)localObject).getInteger("crop-bottom");
              this.cropBottom = i;
              Log.d("MicroMsg.VLogVideoPlayer", "[debug video] format change, cropLeft = " + this.cropLeft + ", cropTop = " + this.cropTop + ", cropRight = " + this.cropRight + ", cropBottom = " + this.cropBottom);
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "drainOutputBuffer error", new Object[0]);
        continue;
        paramLong = this.info.presentationTimeUs;
        Log.d("MicroMsg.VLogVideoPlayer", "[debug video] [decode] lastPts = " + this.nyj + ", pts = " + paramLong);
        this.nyj = paramLong;
        this.Udp = i;
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
          this.Udo = true;
          ((MediaCodec)localObject).releaseOutputBuffer(i, false);
          Log.d("MicroMsg.VLogVideoPlayer", kotlin.g.b.s.X("[debug video] [decode] output done, lastPts = ", Long.valueOf(this.nyj)));
          AppMethodBeat.o(110982);
          return true;
        }
      }
    }
    return true;
  }
  
  public final void FP(boolean paramBoolean) {}
  
  public final void Z(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(110981);
    Log.d("MicroMsg.VLogVideoPlayer", kotlin.g.b.s.X("VideoPlayer playing : ", Long.valueOf(wH(paramLong))));
    while (!wI(wH(paramLong))) {
      SC();
    }
    if (paramBoolean)
    {
      SurfaceTexture localSurfaceTexture = this.surfaceTexture;
      if (localSurfaceTexture != null) {
        localSurfaceTexture.updateTexImage();
      }
    }
    AppMethodBeat.o(110981);
  }
  
  public final void pause() {}
  
  public final void prepare()
  {
    AppMethodBeat.i(110979);
    this.cGv = true;
    this.surfaceTexture = new SurfaceTexture(this.TXY);
    this.surface = new Surface(this.surfaceTexture);
    th(SightVideoJNI.getMp4RotateVFS(this.UcR.path));
    MediaExtractor localMediaExtractor;
    int k;
    if (hRY() == 90)
    {
      th(3);
      localMediaExtractor = new MediaExtractor();
      localMediaExtractor.setDataSource(this.UcR.path);
      k = localMediaExtractor.getTrackCount();
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(i);
      kotlin.g.b.s.s(localMediaFormat, "mediaExtractor.getTrackFormat(i)");
      String str = localMediaFormat.getString("mime");
      kotlin.g.b.s.checkNotNull(str);
      kotlin.g.b.s.s(str, "mediaFormat.getString(MediaFormat.KEY_MIME)!!");
      if (n.U(str, "video", false))
      {
        this.width = localMediaFormat.getInteger("width");
        this.height = localMediaFormat.getInteger("height");
        str = localMediaFormat.getString("mime");
        kotlin.g.b.s.checkNotNull(str);
        kotlin.g.b.s.s(str, "mediaFormat.getString(MediaFormat.KEY_MIME)!!");
        this.cBw = str;
        this.videoFormat = localMediaFormat;
        this.trackId = i;
      }
      while (j >= k)
      {
        localMediaExtractor.release();
        Log.i("MicroMsg.VLogVideoPlayer", "prepare video, rotate = " + hRY() + ", width = " + this.width + ", height = " + this.height + ", startTime = " + this.UcR.startTime + ", endTime = " + this.UcR.endTime + ", videoStartTime = " + ((ak)this.UcR).Ubf + ", videoEndTime = " + ((ak)this.UcR).Ubg);
        AppMethodBeat.o(110979);
        return;
        if (hRY() == 180)
        {
          th(2);
          break;
        }
        if (hRY() != 270) {
          break;
        }
        th(1);
        break;
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(110985);
    this.UcS = false;
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
        Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "release error", new Object[0]);
      }
    }
    this.surface = null;
    this.surfaceTexture = null;
    this.mediaExtractor = null;
    this.decoder = null;
    this.videoFormat = null;
    this.cGv = false;
    Log.d("MicroMsg.VLogVideoPlayer", "video player release");
    AppMethodBeat.o(110985);
  }
  
  public final void resume() {}
  
  public final void stop()
  {
    AppMethodBeat.i(110984);
    this.UcS = false;
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
        Log.printErrStackTrace("MicroMsg.VLogVideoPlayer", (Throwable)localException, "stop error", new Object[0]);
      }
    }
    Log.d("MicroMsg.VLogVideoPlayer", "video player stop");
    AppMethodBeat.o(110984);
  }
  
  public final void wG(long paramLong)
  {
    AppMethodBeat.i(183780);
    if (this.UcS)
    {
      AppMethodBeat.o(183780);
      return;
    }
    this.UcS = true;
    long l = System.currentTimeMillis();
    this.mediaExtractor = new MediaExtractor();
    Object localObject = this.mediaExtractor;
    if (localObject != null) {
      ((MediaExtractor)localObject).setDataSource(this.UcR.path);
    }
    localObject = this.mediaExtractor;
    if (localObject != null) {
      ((MediaExtractor)localObject).selectTrack(this.trackId);
    }
    localObject = this.mediaExtractor;
    if (localObject != null) {
      ((MediaExtractor)localObject).seekTo(wH(paramLong) * 1000L, 0);
    }
    StringBuilder localStringBuilder = new StringBuilder("[debug video] play seekTime :").append(wH(paramLong)).append(", real seekTime: ");
    localObject = this.mediaExtractor;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((MediaExtractor)localObject).getSampleTime()))
    {
      Log.i("MicroMsg.VLogVideoPlayer", localObject);
      if (this.videoFormat != null)
      {
        this.decoder = MediaCodec.createDecoderByType(this.cBw);
        localObject = this.decoder;
        if (localObject != null) {
          ((MediaCodec)localObject).configure(this.videoFormat, this.surface, null, 0);
        }
        localObject = this.decoder;
        if (localObject != null) {
          ((MediaCodec)localObject).start();
        }
      }
      this.nyj = -1L;
      this.Udp = -1;
      this.Udn = false;
      this.Udo = false;
      Log.d("MicroMsg.VLogVideoPlayer", kotlin.g.b.s.X("[prepare] video play time = ", Long.valueOf(System.currentTimeMillis() - l)));
      AppMethodBeat.o(183780);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogMediaCodecPlayer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.f
 * JD-Core Version:    0.7.0.1
 */