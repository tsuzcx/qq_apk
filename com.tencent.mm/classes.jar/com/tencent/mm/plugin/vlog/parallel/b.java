package com.tencent.mm.plugin.vlog.parallel;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/parallel/ParallelSingleHardwareWriter;", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "(Ljava/lang/String;I)V", "TAG", "<set-?>", "Lcom/tencent/tav/coremedia/CMTimeRange;", "allRange", "getAllRange", "()Lcom/tencent/tav/coremedia/CMTimeRange;", "exportConfig", "Lcom/tencent/tav/core/ExportConfig;", "index", "getIndex", "()I", "isFinish", "", "isSoftEncode", "()Z", "setSoftEncode", "(Z)V", "muxerStarted", "getPath", "()Ljava/lang/String;", "sampleDataFrame", "sampleTimeFrame", "segmentRange", "getSegmentRange", "tmpDtsArrayList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "trackList", "Lcom/tencent/mm/plugin/vlog/parallel/ParallelMuxTrackInfo;", "addTrack", "Landroid/media/MediaFormat;", "audioTrack", "audioTrackIndex", "clearResource", "", "getExportConfig", "ignoreHeader", "isMuxerStarted", "prepareParallelSegmentInfo", "release", "setExportConfig", "start", "stop", "videoTrack", "videoTrackIndex", "writeSampleData", "trackIndex", "byteBuf", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "writeSampleDataTime", "isVideo", "sampleTime", "Lcom/tencent/tav/coremedia/CMTime;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements IMediaMuxer
{
  private final String TAG;
  private ArrayList<a> TDz;
  CMTimeRange UcH;
  private CMTimeRange UcI;
  private int UcJ;
  private int UcK;
  private ArrayList<Long> UcL;
  private ExportConfig exportConfig;
  private final int format;
  int index;
  private boolean muxerStarted;
  private volatile boolean ooe;
  final String path;
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(281243);
    this.path = paramString;
    this.format = paramInt;
    this.TAG = ("MicroMsg.ParallelVideoJniMuxer[" + hashCode() + ']');
    this.TDz = new ArrayList();
    this.index = -1;
    this.UcL = new ArrayList();
    AppMethodBeat.o(281243);
  }
  
  public final int addTrack(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(281281);
    s.u(paramMediaFormat, "format");
    Log.i(this.TAG, "[" + hashCode() + "]add track " + paramMediaFormat.getString("mime"));
    a.a locala = a.Ucz;
    paramMediaFormat = a.a.b(paramMediaFormat, String.valueOf(hashCode()));
    this.TDz.add(paramMediaFormat);
    int i = paramMediaFormat.trackId;
    AppMethodBeat.o(281281);
    return i;
  }
  
  public final int audioTrackIndex()
  {
    AppMethodBeat.i(281318);
    a locala = hRT();
    if (locala == null)
    {
      AppMethodBeat.o(281318);
      return -1;
    }
    int i = locala.trackId;
    AppMethodBeat.o(281318);
    return i;
  }
  
  public final void clearResource()
  {
    AppMethodBeat.i(281327);
    Iterator localIterator = ((Iterable)this.TDz).iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      y.deleteFile(locala.UcC);
      Log.i(this.TAG, s.X("clearResource:", locala.UcC));
    }
    AppMethodBeat.o(281327);
  }
  
  public final ExportConfig getExportConfig()
  {
    return this.exportConfig;
  }
  
  public final a hRS()
  {
    AppMethodBeat.i(281250);
    Iterator localIterator = ((Iterable)this.TDz).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!((a)localObject).UcA);
    for (;;)
    {
      localObject = (a)localObject;
      AppMethodBeat.o(281250);
      return localObject;
      localObject = null;
    }
  }
  
  public final a hRT()
  {
    AppMethodBeat.i(281256);
    Iterator localIterator = ((Iterable)this.TDz).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!((a)localObject).UcA)
      {
        i = 1;
        label46:
        if (i == 0) {
          break label65;
        }
      }
    }
    for (;;)
    {
      localObject = (a)localObject;
      AppMethodBeat.o(281256);
      return localObject;
      i = 0;
      break label46;
      label65:
      break;
      localObject = null;
    }
  }
  
  public final boolean ignoreHeader()
  {
    return false;
  }
  
  public final boolean isMuxerStarted()
  {
    return this.muxerStarted;
  }
  
  public final void prepareParallelSegmentInfo(int paramInt, CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(281324);
    this.index = paramInt;
    this.UcH = paramCMTimeRange1;
    this.UcI = paramCMTimeRange2;
    Log.i(this.TAG, "index:" + paramInt + " segmentRange:" + paramCMTimeRange1 + " allRange:" + paramCMTimeRange2);
    AppMethodBeat.o(281324);
  }
  
  public final void release() {}
  
  public final void setExportConfig(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(281300);
    s.u(paramExportConfig, "exportConfig");
    this.exportConfig = paramExportConfig;
    AppMethodBeat.o(281300);
  }
  
  public final void start()
  {
    this.muxerStarted = true;
  }
  
  public final boolean stop()
  {
    AppMethodBeat.i(281292);
    if (!this.ooe)
    {
      Log.i(this.TAG, "muxer[" + hashCode() + "][" + this.index + "] stop  timeCount:" + this.UcJ + "  dataCount:" + this.UcK);
      Iterator localIterator = ((Iterable)this.TDz).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).hRR();
      }
      this.ooe = true;
      this.muxerStarted = false;
    }
    AppMethodBeat.o(281292);
    return true;
  }
  
  public final int videoTrackIndex()
  {
    AppMethodBeat.i(281321);
    a locala = hRS();
    if (locala == null)
    {
      AppMethodBeat.o(281321);
      return -1;
    }
    int i = locala.trackId;
    AppMethodBeat.o(281321);
    return i;
  }
  
  public final void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(281308);
    s.u(paramByteBuffer, "byteBuf");
    s.u(paramBufferInfo, "bufferInfo");
    if (this.ooe)
    {
      Log.i(this.TAG, "writeSampleData error,has finished");
      AppMethodBeat.o(281308);
      return;
    }
    Iterator localIterator = ((Iterable)this.TDz).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((a)localObject).trackId == paramInt)
      {
        i = 1;
        label92:
        if (i == 0) {
          break label243;
        }
      }
    }
    for (;;)
    {
      localObject = (a)localObject;
      if (localObject != null)
      {
        if ((((a)localObject).UcA) && (paramBufferInfo.presentationTimeUs == 0L)) {
          Log.e(this.TAG, "[" + hashCode() + "]writeSampleData pts track id:" + paramInt + "  timeUs:" + paramBufferInfo.presentationTimeUs);
        }
        ((a)localObject).k(paramByteBuffer, paramBufferInfo);
        this.UcK += 1;
        Log.d(this.TAG, "writeSampleData index:" + this.UcK + " value:" + paramBufferInfo.presentationTimeUs);
      }
      AppMethodBeat.o(281308);
      return;
      i = 0;
      break label92;
      label243:
      break;
      localObject = null;
    }
  }
  
  public final void writeSampleDataTime(boolean paramBoolean, CMTime paramCMTime)
  {
    AppMethodBeat.i(281269);
    s.u(paramCMTime, "sampleTime");
    if (this.ooe)
    {
      Log.i(this.TAG, "writeSampleDataTime error,has finished");
      AppMethodBeat.o(281269);
      return;
    }
    this.UcJ += 1;
    int i;
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      if (hRS() == null)
      {
        this.UcL.add(Long.valueOf(paramCMTime.getTimeUs()));
        AppMethodBeat.o(281269);
        return;
      }
      if (((Collection)this.UcL).isEmpty()) {
        break label404;
      }
      i = 1;
      if (i != 0)
      {
        Log.i(this.TAG, s.X("videoTrack cache dts size:", Integer.valueOf(this.UcL.size())));
        localObject1 = hRS();
        if (localObject1 != null)
        {
          localObject1 = ((a)localObject1).UcD;
          if (localObject1 != null) {
            ((ArrayList)localObject1).addAll((Collection)this.UcL);
          }
        }
        this.UcL.clear();
      }
      localObject1 = hRS();
      if (localObject1 != null)
      {
        localObject2 = ((a)localObject1).UcD;
        if (localObject2 != null)
        {
          if ((((ArrayList)localObject2).size() <= 2) || (paramCMTime.getTimeUs() > ((Number)p.oM((List)localObject2)).longValue())) {
            break label409;
          }
          long l1 = ((Number)p.oM((List)localObject2)).longValue();
          long l2 = ((Number)((ArrayList)localObject2).get(1)).longValue();
          localObject1 = ((ArrayList)localObject2).get(2);
          s.s(localObject1, "dtsList[2]");
          long l3 = ((Number)localObject1).longValue();
          Log.e(this.TAG, s.X("writeSampleDataTime error timeus:", Long.valueOf(paramCMTime.getTimeUs())));
          ((ArrayList)localObject2).add(Long.valueOf(l1 + (l2 - l3)));
          label314:
          localObject1 = this.TAG;
          localObject2 = new StringBuilder("writeSampleTime index:").append(this.UcJ).append(" value:").append(paramCMTime.getTimeUs()).append(" dtsList:").append(((ArrayList)localObject2).size()).append(" real:");
          paramCMTime = hRS();
          if (paramCMTime != null) {
            break label425;
          }
          paramCMTime = null;
        }
      }
    }
    for (;;)
    {
      Log.d((String)localObject1, paramCMTime);
      AppMethodBeat.o(281269);
      return;
      label404:
      i = 0;
      break;
      label409:
      ((ArrayList)localObject2).add(Long.valueOf(paramCMTime.getTimeUs()));
      break label314;
      label425:
      paramCMTime = paramCMTime.UcD;
      if (paramCMTime == null) {
        paramCMTime = null;
      } else {
        paramCMTime = Integer.valueOf(paramCMTime.size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.parallel.b
 * JD-Core Version:    0.7.0.1
 */