package com.tencent.mm.plugin.vlog.model;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.e;
import com.tencent.mm.media.k.g;
import com.tencent.mm.media.k.g.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer;", "", "()V", "TAG", "", "setup", "", "SightVideoJNIMediaMuxer", "SightVideoJNIMediaMuxerFactory", "plugin-vlog_release"})
public final class TAVKitMuxer
{
  public static final TAVKitMuxer NmK;
  private static final String TAG = "MicroMsg.TAVKitMuxer";
  
  static
  {
    AppMethodBeat.i(223851);
    NmK = new TAVKitMuxer();
    TAG = "MicroMsg.TAVKitMuxer";
    AppMethodBeat.o(223851);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(223849);
    MediaMuxerFactory.setMuxerCreator((MediaMuxerFactory.MediaMuxerCreator)new SightVideoJNIMediaMuxerFactory());
    AppMethodBeat.o(223849);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxer;", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "(Ljava/lang/String;I)V", "audioChannelCount", "audioFormat", "Landroid/media/MediaFormat;", "audioId", "audioSampleRate", "bufId", "dtsCount", "duration", "exportConfig", "Lcom/tencent/tav/core/ExportConfig;", "isHevc", "", "isStarted", "isUseFFMpegMuxer", "pendingVideoDts", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "softEncode", "videoBitrate", "videoFormat", "videoFps", "", "videoFrameCount", "videoHeight", "videoId", "videoWidth", "addTrack", "mediaFormat", "audioTrackIndex", "checkInitBufId", "", "checkVideoFormatValid", "configMuxerToSoftEncode", "isSoftEncode", "doWriteVideoDts", "dts", "ensureMuxerVideoDuration", "flushPendingVideoDts", "getBufId", "getMediaFormatInt", "key", "defVal", "ignoreHeader", "isMuxerStarted", "release", "setExportConfig", "start", "stop", "videoTrackIndex", "writeSampleData", "trackId", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "writeSampleDataTime", "isVideo", "sampleTime", "Lcom/tencent/tav/coremedia/CMTime;", "plugin-vlog_release"})
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
      AppMethodBeat.i(249086);
      this.path = paramString;
      this.format = paramInt;
      this.bufId = -1;
      this.videoId = -1;
      this.audioId = -1;
      this.pendingVideoDts = new ArrayList();
      AppMethodBeat.o(249086);
    }
    
    private final void checkInitBufId()
    {
      AppMethodBeat.i(249063);
      Object localObject = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "checkInitBufId bufId:" + this.bufId);
      this.isUseFFMpegMuxer = c.ax(this.softEncode, this.isHevc);
      int i;
      if (this.bufId < 0)
      {
        if ((!this.softEncode) || (!checkVideoFormatValid())) {
          break label352;
        }
        localObject = this.exportConfig;
        if (localObject == null) {
          break label315;
        }
        localObject = ((ExportConfig)localObject).getVideoFormat();
        if ((localObject == null) || (Build.VERSION.SDK_INT < 24)) {
          break label321;
        }
        i = e.a((MediaFormat)localObject, "color-range");
        int j = e.a((MediaFormat)localObject, "color-standard");
        int k = e.a((MediaFormat)localObject, "color-transfer");
        localObject = TAVKitMuxer.NmK;
        Log.i(TAVKitMuxer.gtv(), "init bufId, colorRange:" + i + ", colorStandard:" + j + ", colorTransfer:" + k);
        i = SightVideoJNI.initSoftEncodeDataBufferLock(this.videoWidth, this.videoHeight, this.videoBitrate, this.videoFps, this.isHevc, i, j, k, this.isUseFFMpegMuxer);
      }
      label202:
      label352:
      for (this.bufId = i;; this.bufId = SightVideoJNI.initDataBufferForRemux(this.isHevc))
      {
        localObject = TAVKitMuxer.NmK;
        Log.i(TAVKitMuxer.gtv(), "init bufId:" + this.bufId + ", isHevc:" + this.isHevc + ", softEncode:" + this.softEncode + ", video size:[" + this.videoWidth + 'x' + this.videoHeight + "], fps:" + this.videoFps + ", isUseFFMpegMuxer:" + this.isUseFFMpegMuxer);
        AppMethodBeat.o(249063);
        return;
        localObject = null;
        break;
        i = SightVideoJNI.initSoftEncodeDataBufferLock(this.videoWidth, this.videoHeight, this.videoBitrate, this.videoFps, this.isHevc, this.isUseFFMpegMuxer);
        break label202;
      }
    }
    
    private final boolean checkVideoFormatValid()
    {
      AppMethodBeat.i(249064);
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
              AppMethodBeat.o(249064);
              return true;
            }
          }
        }
      }
      AppMethodBeat.o(249064);
      return false;
    }
    
    private final void doWriteVideoDts(long paramLong)
    {
      AppMethodBeat.i(249084);
      if (this.dtsCount == 0)
      {
        SightVideoJNI.writeDtsDataLock(this.bufId, kotlin.h.a.dm(1000.0F / this.videoFps) * -1 * 1000L);
        this.dtsCount += 1;
      }
      SightVideoJNI.writeDtsDataLock(this.bufId, paramLong);
      this.dtsCount += 1;
      AppMethodBeat.o(249084);
    }
    
    private final void flushPendingVideoDts()
    {
      AppMethodBeat.i(249082);
      Object localObject = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "flushPendingVideoDts size:" + this.pendingVideoDts.size());
      localObject = this.pendingVideoDts.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        p.j(localLong, "dts");
        doWriteVideoDts(localLong.longValue());
      }
      this.pendingVideoDts.clear();
      AppMethodBeat.o(249082);
    }
    
    private final int getMediaFormatInt(MediaFormat paramMediaFormat, String paramString, int paramInt)
    {
      AppMethodBeat.i(249074);
      if (paramMediaFormat == null)
      {
        AppMethodBeat.o(249074);
        return paramInt;
      }
      if (paramMediaFormat.containsKey(paramString))
      {
        paramInt = paramMediaFormat.getInteger(paramString);
        AppMethodBeat.o(249074);
        return paramInt;
      }
      AppMethodBeat.o(249074);
      return paramInt;
    }
    
    public final int addTrack(MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(249080);
      p.k(paramMediaFormat, "mediaFormat");
      Object localObject = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "addTrack, format:".concat(String.valueOf(paramMediaFormat)));
      if (paramMediaFormat.containsKey("mime"))
      {
        localObject = paramMediaFormat.getString("mime");
        p.j(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)");
        if (n.a((CharSequence)localObject, (CharSequence)"video", false))
        {
          i = 1;
          if (i == 0) {
            break label373;
          }
          this.videoFormat = paramMediaFormat;
          localObject = paramMediaFormat.getString("mime");
          p.j(localObject, "mime");
          this.isHevc = n.a((CharSequence)localObject, (CharSequence)"hevc", false);
          if (this.videoId <= 0) {
            this.videoId = 1;
          }
          this.videoWidth = getMediaFormatInt(this.videoFormat, "width", 0);
          this.videoHeight = getMediaFormatInt(this.videoFormat, "height", 0);
          this.videoFps = getMediaFormatInt(this.videoFormat, "frame-rate", 0);
          this.videoBitrate = getMediaFormatInt(this.videoFormat, "bitrate", 0);
          TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.NmK;
          Log.i(TAVKitMuxer.gtv(), "add video track mime:" + (String)localObject + ", isHevc:" + this.isHevc);
          if (this.videoFps <= 0.0F)
          {
            localObject = this.exportConfig;
            if (localObject == null) {
              break label367;
            }
          }
        }
      }
      label367:
      for (localObject = ((ExportConfig)localObject).getVideoFormat();; localObject = null)
      {
        this.videoFps = getMediaFormatInt((MediaFormat)localObject, "frame-rate", 0);
        checkInitBufId();
        if ((this.bufId >= 0) && (!this.softEncode)) {
          flushPendingVideoDts();
        }
        i = e.a(paramMediaFormat, "color-range");
        int j = e.a(paramMediaFormat, "color-standard");
        int k = e.a(paramMediaFormat, "color-transfer");
        paramMediaFormat = g.laC;
        g.a(this.bufId, new g.a(i, j, k));
        i = this.videoId;
        AppMethodBeat.o(249080);
        return i;
        i = 0;
        break;
      }
      label373:
      this.audioFormat = paramMediaFormat;
      if (this.audioId <= 0) {
        this.audioId = 2;
      }
      int i = this.audioId;
      AppMethodBeat.o(249080);
      return i;
    }
    
    public final int audioTrackIndex()
    {
      return this.audioId;
    }
    
    public final void configMuxerToSoftEncode(boolean paramBoolean)
    {
      AppMethodBeat.i(249059);
      this.softEncode = paramBoolean;
      TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "configMuxerToSoftEncode:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(249059);
    }
    
    public final void ensureMuxerVideoDuration(int paramInt)
    {
      if (this.duration <= 0) {
        this.duration = paramInt;
      }
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
      AppMethodBeat.i(249076);
      SightVideoJNI.releaseRecorderBufferRefLock("clear");
      SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      this.isStarted = false;
      AppMethodBeat.o(249076);
    }
    
    public final void setExportConfig(ExportConfig paramExportConfig)
    {
      AppMethodBeat.i(249067);
      p.k(paramExportConfig, "exportConfig");
      TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "setExportConfig:".concat(String.valueOf(paramExportConfig)));
      this.exportConfig = paramExportConfig;
      AppMethodBeat.o(249067);
    }
    
    public final void start()
    {
      AppMethodBeat.i(249065);
      TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "start");
      this.isStarted = true;
      AppMethodBeat.o(249065);
    }
    
    public final void stop()
    {
      Object localObject2 = null;
      AppMethodBeat.i(249069);
      Object localObject1 = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "stop, duration:" + this.duration + "，frameCount:" + this.videoFrameCount + ", dtsCount:" + this.dtsCount);
      localObject1 = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "stop videoFormat:" + this.videoFormat);
      localObject1 = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "stop audioFormat:" + this.audioFormat);
      if (this.duration <= 0)
      {
        localObject1 = TAVKitMuxer.NmK;
        Log.e(TAVKitMuxer.gtv(), "error duration is 0");
        AppMethodBeat.o(249069);
        return;
      }
      this.audioSampleRate = getMediaFormatInt(this.audioFormat, "sample-rate", 0);
      this.audioChannelCount = getMediaFormatInt(this.audioFormat, "channel-count", 0);
      int i = getMediaFormatInt(this.videoFormat, "frame-rate", 0);
      this.videoBitrate = getMediaFormatInt(this.videoFormat, "bitrate", 0);
      float f = this.videoFrameCount * 1000.0F / this.duration;
      localObject1 = TAVKitMuxer.NmK;
      Log.i(TAVKitMuxer.gtv(), "audioSampleRate:" + this.audioSampleRate + ", audioChannelCount:" + this.audioChannelCount + ", mediaFormatFps:" + i + ", videoBitrate:" + this.videoBitrate + ", duration:" + this.duration + ", countFps:" + f + ", configToSoftEncode:" + this.softEncode);
      localObject1 = TAVKitMuxer.NmK;
      String str = TAVKitMuxer.gtv();
      StringBuilder localStringBuilder = new StringBuilder("exportConfig: audioSampleRate:");
      localObject1 = this.exportConfig;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((ExportConfig)localObject1).getAudioSampleRateHz());
        localStringBuilder = localStringBuilder.append(localObject1).append(", audioChannelCount:");
        localObject1 = this.exportConfig;
        if (localObject1 == null) {
          break label673;
        }
        localObject1 = Integer.valueOf(((ExportConfig)localObject1).getAudioChannelCount());
        label414:
        localStringBuilder = localStringBuilder.append(localObject1).append(", videoBitrate:");
        ExportConfig localExportConfig = this.exportConfig;
        localObject1 = localObject2;
        if (localExportConfig != null) {
          localObject1 = Integer.valueOf(localExportConfig.getVideoBitRate());
        }
        Log.i(str, localObject1);
        if (!this.softEncode) {
          this.videoFps = f;
        }
        if (this.audioSampleRate <= 0)
        {
          localObject1 = this.exportConfig;
          if (localObject1 == null) {
            break label679;
          }
          i = ((ExportConfig)localObject1).getAudioSampleRateHz();
          label505:
          this.audioSampleRate = i;
        }
        if (this.audioChannelCount <= 0)
        {
          localObject1 = this.exportConfig;
          if (localObject1 == null) {
            break label684;
          }
          i = ((ExportConfig)localObject1).getAudioChannelCount();
          label534:
          this.audioChannelCount = i;
        }
        if (this.videoBitrate <= 0)
        {
          localObject1 = this.exportConfig;
          if (localObject1 == null) {
            break label689;
          }
          i = ((ExportConfig)localObject1).getVideoBitRate();
          label563:
          this.videoBitrate = i;
        }
        if (((this.audioSampleRate > 0) || (this.audioChannelCount > 0)) && (this.audioFormat != null)) {
          break label694;
        }
      }
      label673:
      label679:
      label684:
      label689:
      label694:
      for (boolean bool = true;; bool = false)
      {
        i = SightVideoJNI.muxingLock(this.bufId, this.path, this.audioSampleRate, this.audioChannelCount, this.videoFps, Math.max(1000, this.duration), this.videoBitrate, bool, this.isUseFFMpegMuxer);
        localObject1 = TAVKitMuxer.NmK;
        Log.i(TAVKitMuxer.gtv(), "stop ret:".concat(String.valueOf(i)));
        this.isStarted = false;
        AppMethodBeat.o(249069);
        return;
        localObject1 = null;
        break;
        localObject1 = null;
        break label414;
        i = 0;
        break label505;
        i = 0;
        break label534;
        i = 0;
        break label563;
      }
    }
    
    public final int videoTrackIndex()
    {
      return this.videoId;
    }
    
    public final void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(249073);
      p.k(paramByteBuffer, "byteBuffer");
      p.k(paramBufferInfo, "bufferInfo");
      boolean bool;
      Object localObject;
      if (paramInt == this.videoId)
      {
        bool = true;
        localObject = TAVKitMuxer.NmK;
        Log.i(TAVKitMuxer.gtv(), "writeSampleData, trackId:" + paramInt + ", isVideo:" + bool + ", pts:" + paramBufferInfo.presentationTimeUs);
        if ((paramInt != this.videoId) || (this.softEncode)) {
          break label170;
        }
        this.videoFrameCount += 1;
        if (!this.softEncode) {
          SightVideoJNI.writeH264DataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
        }
      }
      label295:
      for (;;)
      {
        paramInt = kotlin.h.a.dm((float)paramBufferInfo.presentationTimeUs / 1000.0F);
        if (paramInt > this.duration) {
          this.duration = paramInt;
        }
        AppMethodBeat.o(249073);
        return;
        bool = false;
        break;
        label170:
        if (paramInt == this.audioId)
        {
          if (this.isUseFFMpegMuxer)
          {
            label238:
            int i;
            if (this.audioFormat != null)
            {
              localObject = this.audioFormat;
              if ((localObject != null) && (((MediaFormat)localObject).containsKey("aac-profile") == true))
              {
                localObject = this.audioFormat;
                if (localObject == null) {
                  p.iCn();
                }
                paramInt = ((MediaFormat)localObject).getInteger("aac-profile");
                if (this.audioFormat == null) {
                  break label378;
                }
                localObject = this.audioFormat;
                if ((localObject == null) || (((MediaFormat)localObject).containsKey("sample-rate") != true)) {
                  break label378;
                }
                localObject = this.audioFormat;
                if (localObject == null) {
                  p.iCn();
                }
                i = com.tencent.mm.plugin.mmsight.model.a.WZ(((MediaFormat)localObject).getInteger("sample-rate"));
                if (this.audioFormat == null) {
                  break label384;
                }
                localObject = this.audioFormat;
                if ((localObject == null) || (((MediaFormat)localObject).containsKey("channel-count") != true)) {
                  break label384;
                }
                localObject = this.audioFormat;
                if (localObject == null) {
                  p.iCn();
                }
              }
            }
            for (int j = ((MediaFormat)localObject).getInteger("channel-count");; j = 1)
            {
              SightVideoJNI.writeAACDataWithADTSLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramInt, i, j);
              break;
              paramInt = 2;
              break label238;
              label378:
              i = 4;
              break label295;
            }
          }
          SightVideoJNI.writeAACDataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
        }
      }
    }
    
    public final void writeSampleDataTime(boolean paramBoolean, CMTime paramCMTime)
    {
      AppMethodBeat.i(249071);
      p.k(paramCMTime, "sampleTime");
      if ((paramBoolean) && (!this.softEncode))
      {
        TAVKitMuxer localTAVKitMuxer = TAVKitMuxer.NmK;
        Log.i(TAVKitMuxer.gtv(), "write video dts:" + paramCMTime.getTimeUs());
        if (this.bufId < 0)
        {
          localTAVKitMuxer = TAVKitMuxer.NmK;
          Log.i(TAVKitMuxer.gtv(), "save pending dts:" + paramCMTime.getTimeUs());
          this.pendingVideoDts.add(Long.valueOf(paramCMTime.getTimeUs()));
          AppMethodBeat.o(249071);
          return;
        }
        doWriteVideoDts(paramCMTime.getTimeUs());
      }
      AppMethodBeat.o(249071);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxerFactory;", "Lcom/tencent/tav/decoder/muxer/MediaMuxerFactory$MediaMuxerCreator;", "()V", "createMediaMuxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "plugin-vlog_release"})
  static final class SightVideoJNIMediaMuxerFactory
    implements MediaMuxerFactory.MediaMuxerCreator
  {
    public final IMediaMuxer createMediaMuxer(String paramString, int paramInt)
    {
      AppMethodBeat.i(224247);
      p.k(paramString, "path");
      paramString = (IMediaMuxer)new TAVKitMuxer.SightVideoJNIMediaMuxer(paramString, paramInt);
      AppMethodBeat.o(224247);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.TAVKitMuxer
 * JD-Core Version:    0.7.0.1
 */