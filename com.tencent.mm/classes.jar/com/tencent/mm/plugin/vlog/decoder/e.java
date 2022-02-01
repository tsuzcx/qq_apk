package com.tencent.mm.plugin.vlog.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.codec.DefaultMediaFactory;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.codec.IMediaFactory;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/decoder/SoftMediaFactory;", "", "()V", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a TXJ;
  
  static
  {
    AppMethodBeat.i(281338);
    TXJ = new a((byte)0);
    AppMethodBeat.o(281338);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/decoder/SoftMediaFactory$Companion;", "", "()V", "autoFallbackDecoder", "Lcom/tencent/tav/codec/IMediaFactory;", "softDecoder", "videoSoft", "", "audioSoft", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static IMediaFactory hQm()
    {
      AppMethodBeat.i(281358);
      IMediaFactory localIMediaFactory = (IMediaFactory)new DefaultMediaFactory(null, (IDecoderFactory)new d((byte)0));
      AppMethodBeat.o(281358);
      return localIMediaFactory;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.decoder.e
 * JD-Core Version:    0.7.0.1
 */