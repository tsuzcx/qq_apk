package com.tencent.mm.plugin.vlog.model;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer;", "", "()V", "TAG", "", "setup", "", "SightVideoJNIMediaMuxer", "SightVideoJNIMediaMuxerFactory", "plugin-vlog_release"})
public final class TAVKitMuxer
{
  public static final TAVKitMuxer Gzj;
  private static final String TAG = "MicroMsg.TAVKitMuxer";
  
  static
  {
    AppMethodBeat.i(190675);
    Gzj = new TAVKitMuxer();
    TAG = "MicroMsg.TAVKitMuxer";
    AppMethodBeat.o(190675);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(190674);
    MediaMuxerFactory.setMuxerCreator((MediaMuxerFactory.MediaMuxerCreator)new SightVideoJNIMediaMuxerFactory());
    AppMethodBeat.o(190674);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxer;", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "(Ljava/lang/String;I)V", "audioChannelCount", "audioFormat", "Landroid/media/MediaFormat;", "audioId", "audioSampleRate", "bufId", "dtsCount", "duration", "exportConfig", "Lcom/tencent/tav/core/ExportConfig;", "isHevc", "", "isStarted", "isUseFFMpegMuxer", "pendingVideoDts", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "softEncode", "videoBitrate", "videoFormat", "videoFps", "", "videoFrameCount", "videoHeight", "videoId", "videoWidth", "addTrack", "mediaFormat", "audioTrackIndex", "checkInitBufId", "", "checkVideoFormatValid", "configMuxerToSoftEncode", "isSoftEncode", "configToUseHevc", "doWriteVideoDts", "dts", "flushPendingVideoDts", "getBufId", "getMediaFormatInt", "key", "defVal", "ignoreHeader", "isMuxerStarted", "release", "setExportConfig", "start", "stop", "videoTrackIndex", "writeSampleData", "trackId", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "writeSampleDataTime", "isVideo", "sampleTime", "Lcom/tencent/tav/coremedia/CMTime;", "plugin-vlog_release"})
  public static final class SightVideoJNIMediaMuxer
    implements IMediaMuxer
  {
    private int audioChannelCount;
    private MediaFormat audioFormat;
    private int audioId;
    private int audioSampleRate;
    private volatile int bufId;
    private int dtsCount;
    private int duration;
    private ExportConfig exportConfig;
    private final int format;
    private boolean isHevc;
    private boolean isStarted;
    private boolean isUseFFMpegMuxer;
    private final String path;
    private ArrayList<Long> pendingVideoDts;
    private boolean softEncode;
    private int videoBitrate;
    private MediaFormat videoFormat;
    private float videoFps;
    private int videoFrameCount;
    private int videoHeight;
    private int videoId;
    private int videoWidth;
    
    public SightVideoJNIMediaMuxer(String paramString, int paramInt)
    {
      AppMethodBeat.i(190672);
      this.path = paramString;
      this.format = paramInt;
      this.bufId = -1;
      this.videoId = -1;
      this.audioId = -1;
      this.pendingVideoDts = new ArrayList();
      AppMethodBeat.o(190672);
    }
    
    private final void checkInitBufId()
    {
      AppMethodBeat.i(190660);
      TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "checkInitBufId bufId:" + this.bufId);
      int j;
      int k;
      int m;
      int n;
      float f;
      int i1;
      int i;
      if (this.bufId < 0)
      {
        if ((!this.softEncode) || (!checkVideoFormatValid())) {
          break label277;
        }
        if (this.videoFormat != null)
        {
          j = this.videoWidth;
          k = this.videoHeight;
          m = this.videoWidth;
          n = this.videoHeight;
          f = this.videoFps;
          i1 = this.videoBitrate;
          if (!this.isHevc) {
            break label272;
          }
          i = 5;
        }
      }
      label272:
      label277:
      for (this.bufId = SightVideoJNI.initDataBufferForMMSightLock(j, k, 0, m, n, f, i1, i, 8, 2, 23.0F, false, true, this.duration, false, this.isHevc, b.al(true, this.isHevc));; this.bufId = SightVideoJNI.initDataBufferForRemux(this.isHevc))
      {
        this.isUseFFMpegMuxer = b.al(this.softEncode, this.isHevc);
        localTAVKitMuxer = TAVKitMuxer.Gzj;
        Log.i(TAVKitMuxer.fBy(), "init bufId:" + this.bufId + ", isHevc:" + this.isHevc + ", softEncode:" + this.softEncode + ", video size:[" + this.videoWidth + 'x' + this.videoHeight + "], fps:" + this.videoFps + ", isUseFFMpegMuxer:" + this.isUseFFMpegMuxer);
        AppMethodBeat.o(190660);
        return;
        i = 1;
        break;
      }
    }
    
    private final boolean checkVideoFormatValid()
    {
      AppMethodBeat.i(190661);
      MediaFormat localMediaFormat = this.videoFormat;
      if ((localMediaFormat != null) && (localMediaFormat.containsKey("width") == true))
      {
        localMediaFormat = this.videoFormat;
        if ((localMediaFormat != null) && (localMediaFormat.containsKey("height") == true))
        {
          localMediaFormat = this.videoFormat;
          if ((localMediaFormat != null) && (localMediaFormat.containsKey("bitrate") == true))
          {
            localMediaFormat = this.videoFormat;
            if ((localMediaFormat != null) && (localMediaFormat.containsKey("frame-rate") == true))
            {
              AppMethodBeat.o(190661);
              return true;
            }
          }
        }
      }
      AppMethodBeat.o(190661);
      return false;
    }
    
    private final void doWriteVideoDts(long paramLong)
    {
      AppMethodBeat.i(190671);
      if (this.dtsCount == 0)
      {
        SightVideoJNI.writeDtsDataLock(this.bufId, kotlin.h.a.cR(1000.0F / this.videoFps) * -1 * 1000L);
        this.dtsCount += 1;
      }
      SightVideoJNI.writeDtsDataLock(this.bufId, paramLong);
      this.dtsCount += 1;
      AppMethodBeat.o(190671);
    }
    
    private final void flushPendingVideoDts()
    {
      AppMethodBeat.i(190670);
      Object localObject = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "flushPendingVideoDts size:" + this.pendingVideoDts.size());
      localObject = this.pendingVideoDts.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        p.g(localLong, "dts");
        doWriteVideoDts(localLong.longValue());
      }
      this.pendingVideoDts.clear();
      AppMethodBeat.o(190670);
    }
    
    private final int getMediaFormatInt(MediaFormat paramMediaFormat, String paramString, int paramInt)
    {
      AppMethodBeat.i(190667);
      if (paramMediaFormat == null)
      {
        AppMethodBeat.o(190667);
        return paramInt;
      }
      if (paramMediaFormat.containsKey(paramString))
      {
        paramInt = paramMediaFormat.getInteger(paramString);
        AppMethodBeat.o(190667);
        return paramInt;
      }
      AppMethodBeat.o(190667);
      return paramInt;
    }
    
    public final int addTrack(MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(190669);
      p.h(paramMediaFormat, "mediaFormat");
      Object localObject = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "addTrack, format:".concat(String.valueOf(paramMediaFormat)));
      if (paramMediaFormat.containsKey("mime"))
      {
        localObject = paramMediaFormat.getString("mime");
        p.g(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        if (!n.a((CharSequence)localObject, (CharSequence)"video", false)) {}
      }
      for (int i = 1; i != 0; i = 0)
      {
        this.videoFormat = paramMediaFormat;
        paramMediaFormat = paramMediaFormat.getString("mime");
        p.g(paramMediaFormat, "mime");
        this.isHevc = n.a((CharSequence)paramMediaFormat, (CharSequence)"hevc", false);
        if (this.videoId <= 0) {
          this.videoId = 1;
        }
        this.videoWidth = getMediaFormatInt(this.videoFormat, "width", 0);
        this.videoHeight = getMediaFormatInt(this.videoFormat, "height", 0);
        this.videoFps = getMediaFormatInt(this.videoFormat, "frame-rate", 0);
        this.videoBitrate = getMediaFormatInt(this.videoFormat, "bitrate", 0);
        localObject = TAVKitMuxer.Gzj;
        Log.i(TAVKitMuxer.fBy(), "add video track mime:" + paramMediaFormat + ", isHevc:" + this.isHevc);
        checkInitBufId();
        if ((this.bufId >= 0) && (!this.softEncode)) {
          flushPendingVideoDts();
        }
        i = this.videoId;
        AppMethodBeat.o(190669);
        return i;
      }
      this.audioFormat = paramMediaFormat;
      if (this.audioId <= 0) {
        this.audioId = 2;
      }
      i = this.audioId;
      AppMethodBeat.o(190669);
      return i;
    }
    
    public final int audioTrackIndex()
    {
      return this.audioId;
    }
    
    public final void configMuxerToSoftEncode(boolean paramBoolean)
    {
      AppMethodBeat.i(190659);
      this.softEncode = paramBoolean;
      TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "configMuxerToSoftEncode:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(190659);
    }
    
    public final void configToUseHevc(boolean paramBoolean)
    {
      AppMethodBeat.i(190658);
      this.isHevc = paramBoolean;
      TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "configToUseHevc: ".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(190658);
    }
    
    public final int getBufId()
    {
      return this.bufId;
    }
    
    public final boolean ignoreHeader()
    {
      return false;
    }
    
    public final boolean isMuxerStarted()
    {
      return this.isStarted;
    }
    
    public final void release()
    {
      AppMethodBeat.i(190668);
      SightVideoJNI.releaseRecorderBufferRefLock("clear");
      SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      this.isStarted = false;
      AppMethodBeat.o(190668);
    }
    
    public final void setExportConfig(ExportConfig paramExportConfig)
    {
      AppMethodBeat.i(190663);
      p.h(paramExportConfig, "exportConfig");
      this.exportConfig = paramExportConfig;
      AppMethodBeat.o(190663);
    }
    
    public final void start()
    {
      AppMethodBeat.i(190662);
      TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "start");
      this.isStarted = true;
      AppMethodBeat.o(190662);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(190664);
      Object localObject = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "stop, duration:" + this.duration + "，frameCount:" + this.videoFrameCount + ", dtsCount:" + this.dtsCount);
      localObject = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "stop videoFormat:" + this.videoFormat);
      localObject = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "stop audioFormat:" + this.audioFormat);
      if (this.duration <= 0)
      {
        localObject = TAVKitMuxer.Gzj;
        Log.e(TAVKitMuxer.fBy(), "error duration is 0");
        AppMethodBeat.o(190664);
        return;
      }
      this.audioSampleRate = getMediaFormatInt(this.audioFormat, "sample-rate", 0);
      this.audioChannelCount = getMediaFormatInt(this.audioFormat, "channel-count", 0);
      int i = getMediaFormatInt(this.videoFormat, "frame-rate", 0);
      this.videoBitrate = getMediaFormatInt(this.videoFormat, "bitrate", 0);
      float f = this.videoFrameCount * 1000.0F / this.duration;
      localObject = TAVKitMuxer.Gzj;
      Log.i(TAVKitMuxer.fBy(), "audioSampleRate:" + this.audioSampleRate + ", audioChannelCount:" + this.audioChannelCount + ", mediaFormatFps:" + i + ", videoBitrate:" + this.videoBitrate + ", duration:" + this.duration + ", countFps:" + f + ", configToSoftEncode:" + this.softEncode);
      localObject = TAVKitMuxer.Gzj;
      String str = TAVKitMuxer.fBy();
      StringBuilder localStringBuilder = new StringBuilder("exportConfig: audioSampleRate:");
      localObject = this.exportConfig;
      if (localObject != null)
      {
        localObject = Integer.valueOf(((ExportConfig)localObject).getAudioSampleRateHz());
        localStringBuilder = localStringBuilder.append(localObject).append(", audioChannelCount:");
        localObject = this.exportConfig;
        if (localObject == null) {
          break label689;
        }
        localObject = Integer.valueOf(((ExportConfig)localObject).getAudioChannelCount());
        label409:
        localStringBuilder = localStringBuilder.append(localObject).append(", videoBitrate:");
        localObject = this.exportConfig;
        if (localObject == null) {
          break label695;
        }
        localObject = Integer.valueOf(((ExportConfig)localObject).getVideoBitRate());
        label445:
        Log.i(str, localObject);
        if (!this.softEncode) {
          this.videoFps = f;
        }
        if (this.audioSampleRate <= 0)
        {
          localObject = this.exportConfig;
          if (localObject == null) {
            break label701;
          }
          i = ((ExportConfig)localObject).getAudioSampleRateHz();
          label496:
          this.audioSampleRate = i;
        }
        if (this.audioChannelCount <= 0)
        {
          localObject = this.exportConfig;
          if (localObject == null) {
            break label706;
          }
          i = ((ExportConfig)localObject).getAudioChannelCount();
          label525:
          this.audioChannelCount = i;
        }
        if (this.videoBitrate <= 0)
        {
          localObject = this.exportConfig;
          if (localObject == null) {
            break label711;
          }
          i = ((ExportConfig)localObject).getVideoBitRate();
          label554:
          this.videoBitrate = i;
        }
        if ((this.audioSampleRate > 0) || (this.audioChannelCount > 0)) {
          break label716;
        }
      }
      label689:
      label695:
      label701:
      label706:
      label711:
      label716:
      for (boolean bool = true;; bool = false)
      {
        i = SightVideoJNI.muxingLock(this.bufId, null, this.audioSampleRate, 1024, 2, this.audioChannelCount, 0L, this.path, this.videoFps, Math.max(1000, this.duration), this.videoBitrate, c.Dma, 8, 2, 23.0F, null, 0, false, bool, this.softEncode, this.isHevc, b.al(this.softEncode, this.isHevc));
        localObject = TAVKitMuxer.Gzj;
        Log.i(TAVKitMuxer.fBy(), "stop ret:".concat(String.valueOf(i)));
        this.isStarted = false;
        AppMethodBeat.o(190664);
        return;
        localObject = null;
        break;
        localObject = null;
        break label409;
        localObject = null;
        break label445;
        i = 0;
        break label496;
        i = 0;
        break label525;
        i = 0;
        break label554;
      }
    }
    
    public final int videoTrackIndex()
    {
      return this.videoId;
    }
    
    public final void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(190666);
      p.h(paramByteBuffer, "byteBuffer");
      p.h(paramBufferInfo, "bufferInfo");
      boolean bool;
      Object localObject;
      if (paramInt == this.videoId)
      {
        bool = true;
        localObject = TAVKitMuxer.Gzj;
        Log.i(TAVKitMuxer.fBy(), "writeSampleData, trackId:" + paramInt + ", isVideo:" + bool + ", pts:" + paramBufferInfo.presentationTimeUs);
        if (paramInt != this.videoId) {
          break label155;
        }
        this.videoFrameCount += 1;
        SightVideoJNI.writeH264DataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
      }
      label280:
      for (;;)
      {
        paramInt = kotlin.h.a.cR((float)paramBufferInfo.presentationTimeUs / 1000.0F);
        if (paramInt > this.duration) {
          this.duration = paramInt;
        }
        AppMethodBeat.o(190666);
        return;
        bool = false;
        break;
        label155:
        if (paramInt == this.audioId)
        {
          if (this.isUseFFMpegMuxer)
          {
            label223:
            int i;
            if (this.audioFormat != null)
            {
              localObject = this.audioFormat;
              if ((localObject != null) && (((MediaFormat)localObject).containsKey("aac-profile") == true))
              {
                localObject = this.audioFormat;
                if (localObject == null) {
                  p.hyc();
                }
                paramInt = ((MediaFormat)localObject).getInteger("aac-profile");
                if (this.audioFormat == null) {
                  break label363;
                }
                localObject = this.audioFormat;
                if ((localObject == null) || (((MediaFormat)localObject).containsKey("sample-rate") != true)) {
                  break label363;
                }
                localObject = this.audioFormat;
                if (localObject == null) {
                  p.hyc();
                }
                i = com.tencent.mm.plugin.mmsight.model.a.QL(((MediaFormat)localObject).getInteger("sample-rate"));
                if (this.audioFormat == null) {
                  break label369;
                }
                localObject = this.audioFormat;
                if ((localObject == null) || (((MediaFormat)localObject).containsKey("channel-count") != true)) {
                  break label369;
                }
                localObject = this.audioFormat;
                if (localObject == null) {
                  p.hyc();
                }
              }
            }
            label363:
            label369:
            for (int j = ((MediaFormat)localObject).getInteger("channel-count");; j = 1)
            {
              SightVideoJNI.writeAACDataWithADTSLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramInt, i, j);
              break;
              paramInt = 2;
              break label223;
              i = 4;
              break label280;
            }
          }
          SightVideoJNI.writeAACDataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
        }
      }
    }
    
    public final void writeSampleDataTime(boolean paramBoolean, CMTime paramCMTime)
    {
      AppMethodBeat.i(190665);
      p.h(paramCMTime, "sampleTime");
      if ((paramBoolean) && (!this.softEncode))
      {
        TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.Gzj;
        Log.i(TAVKitMuxer.fBy(), "write video dts:" + paramCMTime.getTimeUs());
        if (this.bufId < 0)
        {
          localTAVKitMuxer = TAVKitMuxer.Gzj;
          Log.i(TAVKitMuxer.fBy(), "save pending dts:" + paramCMTime.getTimeUs());
          this.pendingVideoDts.add(Long.valueOf(paramCMTime.getTimeUs()));
          AppMethodBeat.o(190665);
          return;
        }
        doWriteVideoDts(paramCMTime.getTimeUs());
      }
      AppMethodBeat.o(190665);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxerFactory;", "Lcom/tencent/tav/decoder/muxer/MediaMuxerFactory$MediaMuxerCreator;", "()V", "createMediaMuxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "plugin-vlog_release"})
  static final class SightVideoJNIMediaMuxerFactory
    implements MediaMuxerFactory.MediaMuxerCreator
  {
    public final IMediaMuxer createMediaMuxer(String paramString, int paramInt)
    {
      AppMethodBeat.i(190673);
      p.h(paramString, "path");
      paramString = (IMediaMuxer)new TAVKitMuxer.SightVideoJNIMediaMuxer(paramString, paramInt);
      AppMethodBeat.o(190673);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.TAVKitMuxer
 * JD-Core Version:    0.7.0.1
 */