package com.tencent.mm.plugin.vlog.parallel;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.mediaplus.ParallelMuxerJni;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/parallel/TAVKitParallelSoftEncodeMuxer;", "", "()V", "Instance", "Lcom/tencent/mm/plugin/vlog/parallel/TAVKitParallelSoftEncodeMuxer$SightVideoJNIMediaMuxerFactory;", "TAG", "", "VIDEO_FPS_DEFAULT", "", "getMediaFormatInt", "format", "Landroid/media/MediaFormat;", "key", "defVal", "parallelMuxImp", "muxers", "", "Lcom/tencent/mm/plugin/vlog/parallel/ParallelSingleSoftWriter;", "releaseWriters", "", "muxer", "Lcom/tencent/mm/mediaplus/ParallelMuxerJni;", "writers", "setup", "valueValidCheck", "origin", "check", "defaultValue", "SightVideoJNIMediaMuxerFactory", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TAVKitParallelSoftEncodeMuxer
{
  public static final TAVKitParallelSoftEncodeMuxer UcP;
  private static final SightVideoJNIMediaMuxerFactory UcQ;
  
  static
  {
    AppMethodBeat.i(281301);
    UcP = new TAVKitParallelSoftEncodeMuxer();
    UcQ = new SightVideoJNIMediaMuxerFactory();
    AppMethodBeat.o(281301);
  }
  
  private static void a(ParallelMuxerJni paramParallelMuxerJni, List<c> paramList)
  {
    AppMethodBeat.i(281267);
    paramParallelMuxerJni.release();
    paramParallelMuxerJni = ((Iterable)paramList).iterator();
    while (paramParallelMuxerJni.hasNext())
    {
      paramList = (c)paramParallelMuxerJni.next();
      paramList.release();
      paramList.clearResource();
    }
    AppMethodBeat.o(281267);
  }
  
  private static int bg(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  private static int c(MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(281275);
    if (paramMediaFormat == null)
    {
      AppMethodBeat.o(281275);
      return 0;
    }
    if (paramMediaFormat.containsKey(paramString))
    {
      int i = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(281275);
      return i;
    }
    AppMethodBeat.o(281275);
    return 0;
  }
  
  public static void setup()
  {
    AppMethodBeat.i(281261);
    MediaMuxerFactory.setMuxerCreator((MediaMuxerFactory.MediaMuxerCreator)UcQ);
    AppMethodBeat.o(281261);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/parallel/TAVKitParallelSoftEncodeMuxer$SightVideoJNIMediaMuxerFactory;", "Lcom/tencent/tav/decoder/muxer/MediaMuxerFactory$MediaMuxerCreator;", "()V", "createMediaMuxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "parallelMux", "muxers", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class SightVideoJNIMediaMuxerFactory
    implements MediaMuxerFactory.MediaMuxerCreator
  {
    public final IMediaMuxer createMediaMuxer(String paramString, int paramInt)
    {
      AppMethodBeat.i(281259);
      s.u(paramString, "path");
      paramString = (IMediaMuxer)new c(paramString, paramInt);
      AppMethodBeat.o(281259);
      return paramString;
    }
    
    public final int parallelMux(List<? extends IMediaMuxer> paramList)
    {
      AppMethodBeat.i(281264);
      if (paramList != null)
      {
        TAVKitParallelSoftEncodeMuxer localTAVKitParallelSoftEncodeMuxer = TAVKitParallelSoftEncodeMuxer.UcP;
        int i = TAVKitParallelSoftEncodeMuxer.lO(paramList);
        AppMethodBeat.o(281264);
        return i;
      }
      AppMethodBeat.o(281264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.parallel.TAVKitParallelSoftEncodeMuxer
 * JD-Core Version:    0.7.0.1
 */