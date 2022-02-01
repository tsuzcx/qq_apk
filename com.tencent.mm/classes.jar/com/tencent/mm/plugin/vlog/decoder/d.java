package com.tencent.mm.plugin.vlog.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.codec.DefaultDecoderFactory;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.codec.IMediaCodec;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/decoder/SoftDecodeFactory;", "Lcom/tencent/tav/codec/IDecoderFactory;", "videoSoft", "", "audioSoft", "(ZZ)V", "getAudioSoft", "()Z", "setAudioSoft", "(Z)V", "audioSoftType", "", "getAudioSoftType", "()I", "setAudioSoftType", "(I)V", "defaultFactory", "Lcom/tencent/tav/codec/DefaultDecoderFactory;", "getDefaultFactory", "()Lcom/tencent/tav/codec/DefaultDecoderFactory;", "useSoftFallback", "getUseSoftFallback", "setUseSoftFallback", "useSoftForPcm", "getUseSoftForPcm", "setUseSoftForPcm", "getVideoSoft", "setVideoSoft", "videoSoftType", "getVideoSoftType", "setVideoSoftType", "createAudioDecoder", "Lcom/tencent/tav/codec/IMediaCodec;", "mime", "", "scene", "createVideoDecoder", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements IDecoderFactory
{
  public boolean TXC;
  public boolean TXD;
  private final DefaultDecoderFactory TXE;
  private boolean TXF;
  private boolean TXG;
  public int TXH;
  public int TXI;
  
  private d()
  {
    AppMethodBeat.i(281339);
    this.TXC = false;
    this.TXD = false;
    this.TXE = new DefaultDecoderFactory();
    this.TXF = true;
    this.TXG = true;
    AppMethodBeat.o(281339);
  }
  
  public final IMediaCodec createAudioDecoder(String paramString1, String paramString2)
  {
    AppMethodBeat.i(281343);
    s.u(paramString1, "mime");
    s.u(paramString2, "scene");
    if ((this.TXF) && (n.U(paramString1, "audio/pcm", false)))
    {
      this.TXH = 3;
      paramString1 = (IMediaCodec)new a();
      AppMethodBeat.o(281343);
      return paramString1;
    }
    if (this.TXD)
    {
      this.TXH = 1;
      paramString1 = (IMediaCodec)new a();
      AppMethodBeat.o(281343);
      return paramString1;
    }
    try
    {
      paramString1 = this.TXE.createAudioDecoder(paramString1, paramString2);
      s.s(paramString1, "defaultFactory.createAudioDecoder(mime, scene)");
      AppMethodBeat.o(281343);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      if (this.TXG)
      {
        this.TXH = 2;
        paramString1 = (IMediaCodec)new a();
        AppMethodBeat.o(281343);
        return paramString1;
      }
      AppMethodBeat.o(281343);
      throw paramString1;
    }
  }
  
  public final IMediaCodec createVideoDecoder(String paramString)
  {
    AppMethodBeat.i(281349);
    s.u(paramString, "mime");
    if (this.TXC)
    {
      this.TXI = 1;
      paramString = (IMediaCodec)new f();
      AppMethodBeat.o(281349);
      return paramString;
    }
    try
    {
      paramString = this.TXE.createVideoDecoder(paramString);
      s.s(paramString, "defaultFactory.createVideoDecoder(mime)");
      AppMethodBeat.o(281349);
      return paramString;
    }
    catch (Exception paramString)
    {
      if (this.TXG)
      {
        this.TXI = 2;
        paramString = (IMediaCodec)new f();
        AppMethodBeat.o(281349);
        return paramString;
      }
      AppMethodBeat.o(281349);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.decoder.d
 * JD-Core Version:    0.7.0.1
 */