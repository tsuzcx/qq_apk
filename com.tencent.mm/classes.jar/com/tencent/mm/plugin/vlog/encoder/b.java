package com.tencent.mm.plugin.vlog.encoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.tav.core.ExportRuntimeException;
import com.tencent.tav.decoder.AssetWriterAudioEncoder;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import com.tencent.tav.decoder.IEncoderFactory;
import com.tencent.tav.decoder.MediaCodecAssetWriterVideoEncoder;
import com.tencent.tav.decoder.MediaCodecAudioEncoder;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/encoder/SoftEncoderFactory;", "Lcom/tencent/tav/decoder/IEncoderFactory;", "videoSoft", "", "audioSoft", "(ZZ)V", "getAudioSoft", "()Z", "setAudioSoft", "(Z)V", "audioSoftType", "", "getAudioSoftType", "()I", "setAudioSoftType", "(I)V", "getVideoSoft", "setVideoSoft", "getAudioEncoder", "Lcom/tencent/tav/decoder/AssetWriterAudioEncoder;", "getVideoEncoder", "Lcom/tencent/tav/decoder/AssetWriterVideoEncoder;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements IEncoderFactory
{
  public boolean TXC;
  public boolean TXD;
  public int TXH;
  
  public b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.TXC = paramBoolean1;
    this.TXD = paramBoolean2;
  }
  
  public final AssetWriterAudioEncoder getAudioEncoder()
  {
    AppMethodBeat.i(281180);
    AssetWriterAudioEncoder localAssetWriterAudioEncoder2;
    if (this.TXD) {
      try
      {
        this.TXH = 1;
        AssetWriterAudioEncoder localAssetWriterAudioEncoder1 = (AssetWriterAudioEncoder)new a();
        AppMethodBeat.o(281180);
        return localAssetWriterAudioEncoder1;
      }
      catch (ExportRuntimeException localExportRuntimeException)
      {
        for (;;)
        {
          this.TXH = 3;
          localAssetWriterAudioEncoder2 = (AssetWriterAudioEncoder)new MediaCodecAudioEncoder();
        }
      }
    }
    try
    {
      localAssetWriterAudioEncoder2 = (AssetWriterAudioEncoder)new MediaCodecAudioEncoder();
      AppMethodBeat.o(281180);
      return localAssetWriterAudioEncoder2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.TXH = 2;
        AssetWriterAudioEncoder localAssetWriterAudioEncoder3 = (AssetWriterAudioEncoder)new a();
      }
    }
  }
  
  public final AssetWriterVideoEncoder getVideoEncoder()
  {
    AppMethodBeat.i(281184);
    if (this.TXC)
    {
      localAssetWriterVideoEncoder = (AssetWriterVideoEncoder)new g();
      AppMethodBeat.o(281184);
      return localAssetWriterVideoEncoder;
    }
    AssetWriterVideoEncoder localAssetWriterVideoEncoder = (AssetWriterVideoEncoder)new MediaCodecAssetWriterVideoEncoder();
    AppMethodBeat.o(281184);
    return localAssetWriterVideoEncoder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.encoder.b
 * JD-Core Version:    0.7.0.1
 */