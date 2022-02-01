package com.tencent.mm.plugin.vlog.model;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator;
import d.g.b.p;
import d.l;
import d.n.n;
import java.nio.ByteBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer;", "", "()V", "TAG", "", "setup", "", "SightVideoJNIMediaMuxer", "SightVideoJNIMediaMuxerFactory", "plugin-vlog_release"})
public final class TAVKitMuxer
{
  public static final TAVKitMuxer BGg;
  private static final String TAG = "MicroMsg.TAVKitMuxer";
  
  static
  {
    AppMethodBeat.i(195781);
    BGg = new TAVKitMuxer();
    TAG = "MicroMsg.TAVKitMuxer";
    AppMethodBeat.o(195781);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(195780);
    MediaMuxerFactory.setMuxerCreator((MediaMuxerFactory.MediaMuxerCreator)new SightVideoJNIMediaMuxerFactory());
    AppMethodBeat.o(195780);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxer;", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "(Ljava/lang/String;I)V", "audioChannelCount", "audioFormat", "Landroid/media/MediaFormat;", "audioId", "audioSampleRate", "bufId", "duration", "exportConfig", "Lcom/tencent/tav/core/ExportConfig;", "isUseFFMpegMuxer", "", "videoBitrate", "videoFormat", "videoFps", "videoFrameCount", "videoId", "addTrack", "mediaFormat", "getMediaFormatInt", "key", "defVal", "ignoreHeader", "release", "", "setExportConfig", "start", "stop", "writeSampleData", "trackId", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "plugin-vlog_release"})
  static final class SightVideoJNIMediaMuxer
    implements IMediaMuxer
  {
    private int audioChannelCount;
    private MediaFormat audioFormat;
    private int audioId;
    private int audioSampleRate;
    private int bufId;
    private int duration;
    private ExportConfig exportConfig;
    private final int format;
    private boolean isUseFFMpegMuxer;
    private final String path;
    private int videoBitrate;
    private MediaFormat videoFormat;
    private int videoFps;
    private int videoFrameCount;
    private int videoId;
    
    public SightVideoJNIMediaMuxer(String paramString, int paramInt)
    {
      AppMethodBeat.i(195778);
      this.path = paramString;
      this.format = paramInt;
      this.videoId = -1;
      this.audioId = -1;
      this.bufId = SightVideoJNI.initDataBufferForRemux(false);
      this.isUseFFMpegMuxer = b.af(false, false);
      AppMethodBeat.o(195778);
    }
    
    private final int getMediaFormatInt(MediaFormat paramMediaFormat, String paramString, int paramInt)
    {
      AppMethodBeat.i(195775);
      if (paramMediaFormat == null)
      {
        AppMethodBeat.o(195775);
        return paramInt;
      }
      if (paramMediaFormat.containsKey(paramString))
      {
        paramInt = paramMediaFormat.getInteger(paramString);
        AppMethodBeat.o(195775);
        return paramInt;
      }
      AppMethodBeat.o(195775);
      return paramInt;
    }
    
    public final int addTrack(MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(195777);
      p.h(paramMediaFormat, "mediaFormat");
      Object localObject = TAVKitMuxer.BGg;
      ad.i(TAVKitMuxer.erZ(), "addTrack, format:".concat(String.valueOf(paramMediaFormat)));
      if (paramMediaFormat.containsKey("mime"))
      {
        localObject = paramMediaFormat.getString("mime");
        p.g(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        if (!n.a((CharSequence)localObject, (CharSequence)"video", false)) {}
      }
      for (int i = 1; i != 0; i = 0)
      {
        this.videoFormat = paramMediaFormat;
        if (this.videoId <= 0) {
          this.videoId = 1;
        }
        i = this.videoId;
        AppMethodBeat.o(195777);
        return i;
      }
      this.audioFormat = paramMediaFormat;
      if (this.audioId <= 0) {
        this.audioId = 2;
      }
      i = this.audioId;
      AppMethodBeat.o(195777);
      return i;
    }
    
    public final boolean ignoreHeader()
    {
      return false;
    }
    
    public final void release()
    {
      AppMethodBeat.i(195776);
      SightVideoJNI.releaseRecorderBufferRefLock("clear");
      SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      AppMethodBeat.o(195776);
    }
    
    public final void setExportConfig(ExportConfig paramExportConfig)
    {
      AppMethodBeat.i(195772);
      p.h(paramExportConfig, "exportConfig");
      this.exportConfig = paramExportConfig;
      AppMethodBeat.o(195772);
    }
    
    public final void start()
    {
      AppMethodBeat.i(195771);
      TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.BGg;
      ad.i(TAVKitMuxer.erZ(), "start");
      AppMethodBeat.o(195771);
    }
    
    public final void stop()
    {
      AppMethodBeat.i(195773);
      Object localObject = TAVKitMuxer.BGg;
      ad.i(TAVKitMuxer.erZ(), "stop, duration:" + this.duration + "，frameCount:" + this.videoFrameCount);
      localObject = TAVKitMuxer.BGg;
      ad.i(TAVKitMuxer.erZ(), "stop videoFormat:" + this.videoFormat);
      localObject = TAVKitMuxer.BGg;
      ad.i(TAVKitMuxer.erZ(), "stop audioFormat:" + this.audioFormat);
      if (this.duration <= 0)
      {
        localObject = TAVKitMuxer.BGg;
        ad.e(TAVKitMuxer.erZ(), "error duration is 0");
        AppMethodBeat.o(195773);
        return;
      }
      this.audioSampleRate = getMediaFormatInt(this.audioFormat, "sample-rate", 0);
      this.audioChannelCount = getMediaFormatInt(this.audioFormat, "channel-count", 0);
      this.videoFps = getMediaFormatInt(this.videoFormat, "frame-rate", 0);
      this.videoBitrate = getMediaFormatInt(this.videoFormat, "bitrate", 0);
      int i = this.videoFrameCount * 1000 / this.duration;
      localObject = TAVKitMuxer.BGg;
      ad.i(TAVKitMuxer.erZ(), "audioSampleRate:" + this.audioSampleRate + ", audioChannelCount:" + this.audioChannelCount + ", videoFps:" + this.videoFps + ", videoBitrate:" + this.videoBitrate + ", duration:" + this.duration + ", countFps:" + i);
      localObject = TAVKitMuxer.BGg;
      String str = TAVKitMuxer.erZ();
      StringBuilder localStringBuilder = new StringBuilder("exportConfig: audioSampleRate:");
      localObject = this.exportConfig;
      if (localObject != null)
      {
        localObject = Integer.valueOf(((ExportConfig)localObject).getAudioSampleRateHz());
        localStringBuilder = localStringBuilder.append(localObject).append(", audioChannelCount:");
        localObject = this.exportConfig;
        if (localObject == null) {
          break label602;
        }
        localObject = Integer.valueOf(((ExportConfig)localObject).getAudioChannelCount());
        label356:
        localStringBuilder = localStringBuilder.append(localObject).append(", videoBitrate:");
        localObject = this.exportConfig;
        if (localObject == null) {
          break label607;
        }
        localObject = Integer.valueOf(((ExportConfig)localObject).getVideoBitRate());
        label386:
        ad.i(str, localObject);
        if (this.videoFps <= 0) {
          this.videoFps = i;
        }
        if (this.audioSampleRate <= 0)
        {
          localObject = this.exportConfig;
          if (localObject == null) {
            break label612;
          }
          i = ((ExportConfig)localObject).getAudioSampleRateHz();
          label433:
          this.audioSampleRate = i;
        }
        if (this.audioChannelCount <= 0)
        {
          localObject = this.exportConfig;
          if (localObject == null) {
            break label617;
          }
          i = ((ExportConfig)localObject).getAudioChannelCount();
          label459:
          this.audioChannelCount = i;
        }
        if (this.videoBitrate <= 0)
        {
          localObject = this.exportConfig;
          if (localObject == null) {
            break label622;
          }
          i = ((ExportConfig)localObject).getVideoBitRate();
          label485:
          this.videoBitrate = i;
        }
        if ((this.audioSampleRate > 0) || (this.audioChannelCount > 0)) {
          break label627;
        }
      }
      label602:
      label607:
      label612:
      label617:
      label622:
      label627:
      for (boolean bool = true;; bool = false)
      {
        i = SightVideoJNI.muxingLock(this.bufId, null, this.audioSampleRate, 1024, 2, this.audioChannelCount, 0L, this.path, this.videoFps, Math.max(1000, this.duration), this.videoBitrate, c.yQZ, 8, 2, 23.0F, null, 0, false, bool, false, false, b.af(false, false));
        localObject = TAVKitMuxer.BGg;
        ad.i(TAVKitMuxer.erZ(), "stop ret:".concat(String.valueOf(i)));
        AppMethodBeat.o(195773);
        return;
        localObject = null;
        break;
        localObject = null;
        break label356;
        localObject = null;
        break label386;
        i = 0;
        break label433;
        i = 0;
        break label459;
        i = 0;
        break label485;
      }
    }
    
    public final void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(195774);
      p.h(paramByteBuffer, "byteBuffer");
      p.h(paramBufferInfo, "bufferInfo");
      boolean bool;
      Object localObject;
      if (paramInt == this.videoId)
      {
        bool = true;
        localObject = TAVKitMuxer.BGg;
        ad.i(TAVKitMuxer.erZ(), "writeSampleData, trackId:" + paramInt + ", isVideo:" + bool + ", pts:" + paramBufferInfo.presentationTimeUs);
        if (paramInt != this.videoId) {
          break label156;
        }
        this.videoFrameCount += 1;
        SightVideoJNI.writeH264DataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
      }
      label279:
      for (;;)
      {
        paramInt = d.h.a.co((float)paramBufferInfo.presentationTimeUs / 1000.0F);
        if (paramInt > this.duration) {
          this.duration = paramInt;
        }
        AppMethodBeat.o(195774);
        return;
        bool = false;
        break;
        label156:
        if (paramInt == this.audioId)
        {
          if (this.isUseFFMpegMuxer)
          {
            label224:
            int i;
            if (this.audioFormat != null)
            {
              localObject = this.audioFormat;
              if ((localObject != null) && (((MediaFormat)localObject).containsKey("aac-profile") == true))
              {
                localObject = this.audioFormat;
                if (localObject == null) {
                  p.gfZ();
                }
                paramInt = ((MediaFormat)localObject).getInteger("aac-profile");
                if (this.audioFormat == null) {
                  break label360;
                }
                localObject = this.audioFormat;
                if ((localObject == null) || (((MediaFormat)localObject).containsKey("sample-rate") != true)) {
                  break label360;
                }
                localObject = this.audioFormat;
                if (localObject == null) {
                  p.gfZ();
                }
                i = com.tencent.mm.plugin.mmsight.model.a.Kk(((MediaFormat)localObject).getInteger("sample-rate"));
                if (this.audioFormat == null) {
                  break label366;
                }
                localObject = this.audioFormat;
                if ((localObject == null) || (((MediaFormat)localObject).containsKey("channel-count") != true)) {
                  break label366;
                }
                localObject = this.audioFormat;
                if (localObject == null) {
                  p.gfZ();
                }
              }
            }
            label360:
            label366:
            for (int j = ((MediaFormat)localObject).getInteger("channel-count");; j = 1)
            {
              SightVideoJNI.writeAACDataWithADTSLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramInt, i, j);
              break;
              paramInt = 2;
              break label224;
              i = 4;
              break label279;
            }
          }
          SightVideoJNI.writeAACDataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxerFactory;", "Lcom/tencent/tav/decoder/muxer/MediaMuxerFactory$MediaMuxerCreator;", "()V", "createMediaMuxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "plugin-vlog_release"})
  static final class SightVideoJNIMediaMuxerFactory
    implements MediaMuxerFactory.MediaMuxerCreator
  {
    public final IMediaMuxer createMediaMuxer(String paramString, int paramInt)
    {
      AppMethodBeat.i(195779);
      p.h(paramString, "path");
      paramString = (IMediaMuxer)new TAVKitMuxer.SightVideoJNIMediaMuxer(paramString, paramInt);
      AppMethodBeat.o(195779);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.TAVKitMuxer
 * JD-Core Version:    0.7.0.1
 */