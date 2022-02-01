package com.tencent.mm.plugin.vlog.model;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.e;
import com.tencent.mm.media.util.g;
import com.tencent.mm.media.util.g.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.plugin.vlog.model.config.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer;", "", "()V", "MinFrameCount", "", "MuxMinDuration", "TAG", "", "setup", "", "SightVideoJNIMediaMuxer", "SightVideoJNIMediaMuxerFactory", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TAVKitMuxer
{
  private static final String TAG;
  public static final TAVKitMuxer Uam;
  private static int Uan;
  
  static
  {
    AppMethodBeat.i(283381);
    Uam = new TAVKitMuxer();
    TAG = "MicroMsg.TAVKitMuxer";
    b localb = b.Ubw;
    Uan = b.hRq();
    AppMethodBeat.o(283381);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(283358);
    MediaMuxerFactory.setMuxerCreator((MediaMuxerFactory.MediaMuxerCreator)new SightVideoJNIMediaMuxerFactory());
    AppMethodBeat.o(283358);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxer;", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "(Ljava/lang/String;I)V", "audioChannelCount", "audioFormat", "Landroid/media/MediaFormat;", "getAudioFormat", "()Landroid/media/MediaFormat;", "setAudioFormat", "(Landroid/media/MediaFormat;)V", "audioId", "audioSampleRate", "bufId", "dtsCount", "duration", "getDuration", "()I", "setDuration", "(I)V", "encoder", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "getEncoder", "()Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "setEncoder", "(Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;)V", "exportConfig", "Lcom/tencent/tav/core/ExportConfig;", "<set-?>", "index", "getIndex", "isHevc", "", "isStarted", "()Z", "setStarted", "(Z)V", "isUseFFMpegMuxer", "pendingVideoDts", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "softEncode", "videoBitrate", "videoFormat", "getVideoFormat", "setVideoFormat", "videoFps", "", "videoFrameCount", "getVideoFrameCount", "setVideoFrameCount", "videoHeight", "videoId", "videoWidth", "addTrack", "mediaFormat", "audioTrackIndex", "checkInitBufId", "", "checkVideoFormatValid", "clearResource", "configMuxerToSoftEncode", "isSoftEncode", "doWriteVideoDts", "dts", "ensureMuxerVideoDuration", "flushPendingVideoDts", "getBufId", "getExportConfig", "getMediaFormatInt", "key", "defVal", "ignoreHeader", "isMuxerStarted", "prepareParallelSegmentInfo", "segmentRange", "Lcom/tencent/tav/coremedia/CMTimeRange;", "allRange", "release", "setExportConfig", "setSoftEncoder", "start", "stop", "videoTrackIndex", "writeSampleData", "trackId", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "writeSampleDataTime", "isVideo", "sampleTime", "Lcom/tencent/tav/coremedia/CMTime;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class SightVideoJNIMediaMuxer
    implements IMediaMuxer
  {
    private int audioChannelCount;
    private MediaFormat audioFormat;
    private int audioId;
    private int audioSampleRate;
    private volatile int bufId;
    private int dtsCount;
    private int duration;
    private AssetWriterVideoEncoder encoder;
    private ExportConfig exportConfig;
    private final int format;
    private int index;
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
      AppMethodBeat.i(283751);
      this.path = paramString;
      this.format = paramInt;
      this.bufId = -1;
      this.videoId = -1;
      this.audioId = -1;
      this.pendingVideoDts = new ArrayList();
      this.index = -1;
      AppMethodBeat.o(283751);
    }
    
    private final boolean checkVideoFormatValid()
    {
      AppMethodBeat.i(283758);
      MediaFormat localMediaFormat = this.videoFormat;
      if ((localMediaFormat != null) && (localMediaFormat.containsKey("width") == true))
      {
        i = 1;
        if (i == 0) {
          break label132;
        }
        localMediaFormat = this.videoFormat;
        if ((localMediaFormat == null) || (localMediaFormat.containsKey("height") != true)) {
          break label117;
        }
        i = 1;
        label51:
        if (i == 0) {
          break label132;
        }
        localMediaFormat = this.videoFormat;
        if ((localMediaFormat == null) || (localMediaFormat.containsKey("bitrate") != true)) {
          break label122;
        }
        i = 1;
        label76:
        if (i == 0) {
          break label132;
        }
        localMediaFormat = this.videoFormat;
        if ((localMediaFormat == null) || (localMediaFormat.containsKey("frame-rate") != true)) {
          break label127;
        }
      }
      label117:
      label122:
      label127:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label132;
        }
        AppMethodBeat.o(283758);
        return true;
        i = 0;
        break;
        i = 0;
        break label51;
        i = 0;
        break label76;
      }
      label132:
      AppMethodBeat.o(283758);
      return false;
    }
    
    private final void doWriteVideoDts(long paramLong)
    {
      AppMethodBeat.i(283773);
      if (this.dtsCount == 0)
      {
        SightVideoJNI.writeDtsDataLock(this.bufId, kotlin.h.a.eH(1000.0F / this.videoFps) * -1 * 1000L);
        this.dtsCount += 1;
      }
      SightVideoJNI.writeDtsDataLock(this.bufId, paramLong);
      this.dtsCount += 1;
      AppMethodBeat.o(283773);
    }
    
    private final void flushPendingVideoDts()
    {
      AppMethodBeat.i(283770);
      Log.i(TAVKitMuxer.aUw(), s.X("flushPendingVideoDts size:", Integer.valueOf(this.pendingVideoDts.size())));
      Iterator localIterator = this.pendingVideoDts.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        s.s(localLong, "dts");
        doWriteVideoDts(localLong.longValue());
      }
      this.pendingVideoDts.clear();
      AppMethodBeat.o(283770);
    }
    
    private final int getMediaFormatInt(MediaFormat paramMediaFormat, String paramString, int paramInt)
    {
      AppMethodBeat.i(283762);
      if (paramMediaFormat == null)
      {
        AppMethodBeat.o(283762);
        return paramInt;
      }
      if (paramMediaFormat.containsKey(paramString))
      {
        paramInt = paramMediaFormat.getInteger(paramString);
        AppMethodBeat.o(283762);
        return paramInt;
      }
      AppMethodBeat.o(283762);
      return paramInt;
    }
    
    public int addTrack(MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(283823);
      s.u(paramMediaFormat, "mediaFormat");
      Log.i(TAVKitMuxer.aUw(), s.X("addTrack, format:", paramMediaFormat));
      if (paramMediaFormat.containsKey("mime"))
      {
        localObject = paramMediaFormat.getString("mime");
        s.checkNotNull(localObject);
        s.s(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)!!");
        if (n.a((CharSequence)localObject, (CharSequence)"video", false))
        {
          i = 1;
          if (i == 0) {
            break label370;
          }
          this.videoFormat = paramMediaFormat;
          localObject = paramMediaFormat.getString("mime");
          s.checkNotNull(localObject);
          s.s(localObject, "mediaFormat.getString(MediaFormat.KEY_MIME)!!");
          this.isHevc = n.a((CharSequence)localObject, (CharSequence)"hevc", false);
          if (this.videoId <= 0) {
            this.videoId = 1;
          }
          this.videoWidth = getMediaFormatInt(this.videoFormat, "width", 0);
          this.videoHeight = getMediaFormatInt(this.videoFormat, "height", 0);
          this.videoFps = getMediaFormatInt(this.videoFormat, "frame-rate", 0);
          this.videoBitrate = getMediaFormatInt(this.videoFormat, "bitrate", 0);
          Log.i(TAVKitMuxer.aUw(), "add video track mime:" + (String)localObject + ", isHevc:" + this.isHevc);
          if (this.videoFps <= 0.0F)
          {
            localObject = this.exportConfig;
            if (localObject != null) {
              break label360;
            }
          }
        }
      }
      label360:
      for (Object localObject = null;; localObject = ((ExportConfig)localObject).getVideoFormat())
      {
        this.videoFps = getMediaFormatInt((MediaFormat)localObject, "frame-rate", 0);
        checkInitBufId();
        if ((this.bufId >= 0) && (!this.softEncode)) {
          flushPendingVideoDts();
        }
        i = e.a(paramMediaFormat, "color-range");
        int j = e.a(paramMediaFormat, "color-standard");
        int k = e.a(paramMediaFormat, "color-transfer");
        paramMediaFormat = g.nFH;
        g.a(this.bufId, new g.a(i, j, k));
        i = this.videoId;
        AppMethodBeat.o(283823);
        return i;
        i = 0;
        break;
      }
      label370:
      this.audioFormat = paramMediaFormat;
      if (this.audioId <= 0) {
        this.audioId = 0;
      }
      int i = this.audioId;
      AppMethodBeat.o(283823);
      return i;
    }
    
    public int audioTrackIndex()
    {
      return this.audioId;
    }
    
    protected void checkInitBufId()
    {
      AppMethodBeat.i(283799);
      Log.i(TAVKitMuxer.aUw(), s.X("checkInitBufId bufId:", Integer.valueOf(this.bufId)));
      this.isUseFFMpegMuxer = c.aQ(this.softEncode, this.isHevc);
      Object localObject;
      int i;
      if (this.bufId < 0)
      {
        if ((!this.softEncode) || (!checkVideoFormatValid())) {
          break label345;
        }
        localObject = this.exportConfig;
        if (localObject != null) {
          break label304;
        }
        localObject = null;
        if ((localObject == null) || (Build.VERSION.SDK_INT < 24)) {
          break label314;
        }
        i = e.a((MediaFormat)localObject, "color-range");
        int j = e.a((MediaFormat)localObject, "color-standard");
        int k = e.a((MediaFormat)localObject, "color-transfer");
        Log.i(TAVKitMuxer.aUw(), "init bufId, colorRange:" + i + ", colorStandard:" + j + ", colorTransfer:" + k);
        i = SightVideoJNI.initSoftEncodeDataBufferLock(this.videoWidth, this.videoHeight, this.videoBitrate, this.videoFps, this.isHevc, i, j, k, this.isUseFFMpegMuxer);
      }
      label189:
      label345:
      for (this.bufId = i;; this.bufId = SightVideoJNI.initDataBufferForRemux(this.isHevc))
      {
        Log.i(TAVKitMuxer.aUw(), "init bufId:" + this.bufId + ", isHevc:" + this.isHevc + ", softEncode:" + this.softEncode + ", video size:[" + this.videoWidth + 'x' + this.videoHeight + "], fps:" + this.videoFps + ", isUseFFMpegMuxer:" + this.isUseFFMpegMuxer);
        AppMethodBeat.o(283799);
        return;
        localObject = ((ExportConfig)localObject).getVideoFormat();
        break;
        i = SightVideoJNI.initSoftEncodeDataBufferLock(this.videoWidth, this.videoHeight, this.videoBitrate, this.videoFps, this.isHevc, this.isUseFFMpegMuxer);
        break label189;
      }
    }
    
    public void clearResource() {}
    
    public final void configMuxerToSoftEncode(boolean paramBoolean)
    {
      AppMethodBeat.i(283795);
      this.softEncode = paramBoolean;
      Log.i(TAVKitMuxer.aUw(), s.X("configMuxerToSoftEncode:", Boolean.valueOf(paramBoolean)));
      AppMethodBeat.o(283795);
    }
    
    public final void ensureMuxerVideoDuration(int paramInt)
    {
      if (this.duration <= 0) {
        this.duration = paramInt;
      }
    }
    
    protected final MediaFormat getAudioFormat()
    {
      return this.audioFormat;
    }
    
    public final int getBufId()
    {
      return this.bufId;
    }
    
    protected final int getDuration()
    {
      return this.duration;
    }
    
    protected final AssetWriterVideoEncoder getEncoder()
    {
      return this.encoder;
    }
    
    public ExportConfig getExportConfig()
    {
      return this.exportConfig;
    }
    
    public final int getIndex()
    {
      return this.index;
    }
    
    protected final MediaFormat getVideoFormat()
    {
      return this.videoFormat;
    }
    
    protected final int getVideoFrameCount()
    {
      return this.videoFrameCount;
    }
    
    public boolean ignoreHeader()
    {
      return false;
    }
    
    public boolean isMuxerStarted()
    {
      return this.isStarted;
    }
    
    protected final boolean isStarted()
    {
      return this.isStarted;
    }
    
    public void prepareParallelSegmentInfo(int paramInt, CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
    {
      this.index = paramInt;
    }
    
    public void release()
    {
      AppMethodBeat.i(283815);
      SightVideoJNI.releaseRecorderBufferRefLock("clear");
      SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      this.isStarted = false;
      AppMethodBeat.o(283815);
    }
    
    protected final void setAudioFormat(MediaFormat paramMediaFormat)
    {
      this.audioFormat = paramMediaFormat;
    }
    
    protected final void setDuration(int paramInt)
    {
      this.duration = paramInt;
    }
    
    protected final void setEncoder(AssetWriterVideoEncoder paramAssetWriterVideoEncoder)
    {
      this.encoder = paramAssetWriterVideoEncoder;
    }
    
    public void setExportConfig(ExportConfig paramExportConfig)
    {
      AppMethodBeat.i(283806);
      s.u(paramExportConfig, "exportConfig");
      Log.i(TAVKitMuxer.aUw(), s.X("setExportConfig:", paramExportConfig));
      this.exportConfig = paramExportConfig;
      AppMethodBeat.o(283806);
    }
    
    public final void setSoftEncoder(AssetWriterVideoEncoder paramAssetWriterVideoEncoder)
    {
      AppMethodBeat.i(283796);
      s.u(paramAssetWriterVideoEncoder, "encoder");
      this.encoder = paramAssetWriterVideoEncoder;
      AppMethodBeat.o(283796);
    }
    
    protected final void setStarted(boolean paramBoolean)
    {
      this.isStarted = paramBoolean;
    }
    
    protected final void setVideoFormat(MediaFormat paramMediaFormat)
    {
      this.videoFormat = paramMediaFormat;
    }
    
    protected final void setVideoFrameCount(int paramInt)
    {
      this.videoFrameCount = paramInt;
    }
    
    public void start()
    {
      AppMethodBeat.i(283801);
      Log.i(TAVKitMuxer.aUw(), "start");
      this.isStarted = true;
      AppMethodBeat.o(283801);
    }
    
    public boolean stop()
    {
      Object localObject2 = null;
      AppMethodBeat.i(283808);
      Log.i(TAVKitMuxer.aUw(), "stop, duration:" + this.duration + "，frameCount:" + this.videoFrameCount + ", dtsCount:" + this.dtsCount);
      Log.i(TAVKitMuxer.aUw(), s.X("stop videoFormat:", this.videoFormat));
      Log.i(TAVKitMuxer.aUw(), s.X("stop audioFormat:", this.audioFormat));
      if (this.duration <= 0)
      {
        Log.e(TAVKitMuxer.aUw(), "error duration is 0");
        this.isStarted = false;
        AppMethodBeat.o(283808);
        return false;
      }
      this.audioSampleRate = getMediaFormatInt(this.audioFormat, "sample-rate", 0);
      this.audioChannelCount = getMediaFormatInt(this.audioFormat, "channel-count", 0);
      int i = getMediaFormatInt(this.videoFormat, "frame-rate", 0);
      this.videoBitrate = getMediaFormatInt(this.videoFormat, "bitrate", 0);
      float f = this.videoFrameCount * 1000.0F / this.duration;
      Log.i(TAVKitMuxer.aUw(), "audioSampleRate:" + this.audioSampleRate + ", audioChannelCount:" + this.audioChannelCount + ", mediaFormatFps:" + i + ", videoBitrate:" + this.videoBitrate + ", duration:" + this.duration + ", countFps:" + f + ", configToSoftEncode:" + this.softEncode);
      String str = TAVKitMuxer.aUw();
      StringBuilder localStringBuilder = new StringBuilder("exportConfig: audioSampleRate:");
      Object localObject1 = this.exportConfig;
      label354:
      boolean bool;
      if (localObject1 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(", audioChannelCount:");
        localObject1 = this.exportConfig;
        if (localObject1 != null) {
          break label592;
        }
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(", videoBitrate:");
        localObject1 = this.exportConfig;
        if (localObject1 != null) {
          break label605;
        }
        localObject1 = localObject2;
        label384:
        Log.i(str, localObject1);
        if (!this.softEncode) {
          this.videoFps = f;
        }
        if (this.audioSampleRate <= 0)
        {
          localObject1 = this.exportConfig;
          if (localObject1 != null) {
            break label618;
          }
          i = 0;
          label431:
          this.audioSampleRate = i;
        }
        if (this.audioChannelCount <= 0)
        {
          localObject1 = this.exportConfig;
          if (localObject1 != null) {
            break label627;
          }
          i = 0;
          label456:
          this.audioChannelCount = i;
        }
        if (this.videoBitrate <= 0)
        {
          localObject1 = this.exportConfig;
          if (localObject1 != null) {
            break label636;
          }
          i = 0;
          label481:
          this.videoBitrate = i;
        }
        if (((this.audioSampleRate > 0) || (this.audioChannelCount > 0)) && (this.audioFormat != null)) {
          break label645;
        }
        bool = true;
        label509:
        if ((this.duration >= TAVKitMuxer.hQV()) && (this.videoFrameCount >= 5)) {
          break label650;
        }
        Log.e(TAVKitMuxer.aUw(), "stop remux error, duration:" + this.duration + ", frameCount:" + this.videoFrameCount);
      }
      for (;;)
      {
        this.isStarted = false;
        AppMethodBeat.o(283808);
        return true;
        localObject1 = Integer.valueOf(((ExportConfig)localObject1).getAudioSampleRateHz());
        break;
        label592:
        localObject1 = Integer.valueOf(((ExportConfig)localObject1).getAudioChannelCount());
        break label354;
        label605:
        localObject1 = Integer.valueOf(((ExportConfig)localObject1).getVideoBitRate());
        break label384;
        label618:
        i = ((ExportConfig)localObject1).getAudioSampleRateHz();
        break label431;
        label627:
        i = ((ExportConfig)localObject1).getAudioChannelCount();
        break label456;
        label636:
        i = ((ExportConfig)localObject1).getVideoBitRate();
        break label481;
        label645:
        bool = false;
        break label509;
        label650:
        i = SightVideoJNI.muxingLock(this.bufId, this.path, this.audioSampleRate, this.audioChannelCount, this.videoFps, this.duration, this.videoBitrate, bool, this.isUseFFMpegMuxer);
        Log.i(TAVKitMuxer.aUw(), s.X("stop ret:", Integer.valueOf(i)));
      }
    }
    
    public int videoTrackIndex()
    {
      return this.videoId;
    }
    
    public void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
    {
      int k = 0;
      AppMethodBeat.i(283813);
      s.u(paramByteBuffer, "byteBuffer");
      s.u(paramBufferInfo, "bufferInfo");
      boolean bool;
      if (paramInt == this.videoId)
      {
        bool = true;
        Log.i(TAVKitMuxer.aUw(), "writeSampleData, trackId:" + paramInt + ", isVideo:" + bool + ", pts:" + paramBufferInfo.presentationTimeUs);
        if (paramInt != this.videoId) {
          break label160;
        }
        this.videoFrameCount += 1;
        if (!this.softEncode) {
          SightVideoJNI.writeH264DataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
        }
      }
      label264:
      label394:
      label400:
      label406:
      for (;;)
      {
        paramInt = kotlin.h.a.eH((float)paramBufferInfo.presentationTimeUs / 1000.0F);
        if (paramInt > this.duration) {
          this.duration = paramInt;
        }
        AppMethodBeat.o(283813);
        return;
        bool = false;
        break;
        label160:
        if (paramInt == this.audioId)
        {
          if (this.isUseFFMpegMuxer)
          {
            MediaFormat localMediaFormat;
            label207:
            label231:
            int i;
            if (this.audioFormat != null)
            {
              localMediaFormat = this.audioFormat;
              if ((localMediaFormat != null) && (localMediaFormat.containsKey("aac-profile") == true))
              {
                paramInt = 1;
                if (paramInt == 0) {
                  break label389;
                }
                localMediaFormat = this.audioFormat;
                s.checkNotNull(localMediaFormat);
                paramInt = localMediaFormat.getInteger("aac-profile");
                if (this.audioFormat == null) {
                  break label400;
                }
                localMediaFormat = this.audioFormat;
                if ((localMediaFormat == null) || (localMediaFormat.containsKey("sample-rate") != true)) {
                  break label394;
                }
                i = 1;
                if (i == 0) {
                  break label400;
                }
                localMediaFormat = this.audioFormat;
                s.checkNotNull(localMediaFormat);
                i = com.tencent.mm.plugin.mmsight.model.a.abb(localMediaFormat.getInteger("sample-rate"));
                label293:
                if (this.audioFormat == null) {
                  break label406;
                }
                localMediaFormat = this.audioFormat;
                j = k;
                if (localMediaFormat != null)
                {
                  j = k;
                  if (localMediaFormat.containsKey("channel-count") == true) {
                    j = 1;
                  }
                }
                if (j == 0) {
                  break label406;
                }
                localMediaFormat = this.audioFormat;
                s.checkNotNull(localMediaFormat);
              }
            }
            for (int j = localMediaFormat.getInteger("channel-count");; j = 1)
            {
              SightVideoJNI.writeAACDataWithADTSLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs, paramInt, i, j);
              break;
              paramInt = 0;
              break label207;
              paramInt = 2;
              break label231;
              i = 0;
              break label264;
              i = 4;
              break label293;
            }
          }
          SightVideoJNI.writeAACDataLock(this.bufId, paramByteBuffer, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
        }
      }
    }
    
    public void writeSampleDataTime(boolean paramBoolean, CMTime paramCMTime)
    {
      AppMethodBeat.i(283810);
      s.u(paramCMTime, "sampleTime");
      if ((paramBoolean) && (!this.softEncode))
      {
        Log.i(TAVKitMuxer.aUw(), s.X("write video dts:", Long.valueOf(paramCMTime.getTimeUs())));
        if (this.bufId < 0)
        {
          Log.i(TAVKitMuxer.aUw(), s.X("save pending dts:", Long.valueOf(paramCMTime.getTimeUs())));
          this.pendingVideoDts.add(Long.valueOf(paramCMTime.getTimeUs()));
          AppMethodBeat.o(283810);
          return;
        }
        doWriteVideoDts(paramCMTime.getTimeUs());
      }
      AppMethodBeat.o(283810);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/TAVKitMuxer$SightVideoJNIMediaMuxerFactory;", "Lcom/tencent/tav/decoder/muxer/MediaMuxerFactory$MediaMuxerCreator;", "()V", "createMediaMuxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "parallelMux", "muxers", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class SightVideoJNIMediaMuxerFactory
    implements MediaMuxerFactory.MediaMuxerCreator
  {
    public final IMediaMuxer createMediaMuxer(String paramString, int paramInt)
    {
      AppMethodBeat.i(283712);
      s.u(paramString, "path");
      paramString = (IMediaMuxer)new TAVKitMuxer.SightVideoJNIMediaMuxer(paramString, paramInt);
      AppMethodBeat.o(283712);
      return paramString;
    }
    
    public final int parallelMux(List<IMediaMuxer> paramList)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.TAVKitMuxer
 * JD-Core Version:    0.7.0.1
 */