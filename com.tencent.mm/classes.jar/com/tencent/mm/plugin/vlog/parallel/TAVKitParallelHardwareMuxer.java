package com.tencent.mm.plugin.vlog.parallel;

import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory.MediaMuxerCreator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/parallel/TAVKitParallelHardwareMuxer;", "", "()V", "DEVICE_MAKE_B_FRAME", "", "Instance", "Lcom/tencent/mm/plugin/vlog/parallel/TAVKitParallelHardwareMuxer$SightVideoJNIMediaMuxerFactory;", "TAG", "getMediaFormatInt", "", "format", "Landroid/media/MediaFormat;", "key", "defVal", "parallelMuxImp", "", "muxers", "", "Lcom/tencent/mm/plugin/vlog/parallel/ParallelSingleHardwareWriter;", "setup", "", "SightVideoJNIMediaMuxerFactory", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TAVKitParallelHardwareMuxer
{
  public static final TAVKitParallelHardwareMuxer UcN;
  private static final SightVideoJNIMediaMuxerFactory UcO;
  
  static
  {
    AppMethodBeat.i(281282);
    UcN = new TAVKitParallelHardwareMuxer();
    UcO = new SightVideoJNIMediaMuxerFactory();
    AppMethodBeat.o(281282);
  }
  
  private static int c(MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(281254);
    if (paramMediaFormat == null)
    {
      AppMethodBeat.o(281254);
      return 0;
    }
    if (paramMediaFormat.containsKey(paramString))
    {
      int i = paramMediaFormat.getInteger(paramString);
      AppMethodBeat.o(281254);
      return i;
    }
    AppMethodBeat.o(281254);
    return 0;
  }
  
  public static void setup()
  {
    AppMethodBeat.i(281248);
    MediaMuxerFactory.setMuxerCreator((MediaMuxerFactory.MediaMuxerCreator)UcO);
    AppMethodBeat.o(281248);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/parallel/TAVKitParallelHardwareMuxer$SightVideoJNIMediaMuxerFactory;", "Lcom/tencent/tav/decoder/muxer/MediaMuxerFactory$MediaMuxerCreator;", "()V", "createMediaMuxer", "Lcom/tencent/tav/decoder/muxer/IMediaMuxer;", "path", "", "format", "", "parallelMux", "muxers", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class SightVideoJNIMediaMuxerFactory
    implements MediaMuxerFactory.MediaMuxerCreator
  {
    public final IMediaMuxer createMediaMuxer(String paramString, int paramInt)
    {
      AppMethodBeat.i(281249);
      s.u(paramString, "path");
      paramString = (IMediaMuxer)new b(paramString, paramInt);
      AppMethodBeat.o(281249);
      return paramString;
    }
    
    public final int parallelMux(List<? extends IMediaMuxer> paramList)
    {
      AppMethodBeat.i(281257);
      if ((paramList != null) && ((p.oK(paramList) instanceof b)))
      {
        TAVKitParallelHardwareMuxer localTAVKitParallelHardwareMuxer = TAVKitParallelHardwareMuxer.UcN;
        if (TAVKitParallelHardwareMuxer.lN(paramList))
        {
          AppMethodBeat.o(281257);
          return 0;
        }
        AppMethodBeat.o(281257);
        return -1;
      }
      AppMethodBeat.o(281257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.parallel.TAVKitParallelHardwareMuxer
 * JD-Core Version:    0.7.0.1
 */