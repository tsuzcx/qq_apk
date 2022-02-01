package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.a.c;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/AudioResampler;", "Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "destSampleRate", "", "destChannelCount", "(II)V", "TAG", "", "getDestChannelCount", "()I", "getDestSampleRate", "createResampleProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "plugin-vlog_release"})
public final class d
  implements c
{
  final int Gxb;
  final int Gxc;
  final String TAG;
  
  public d(int paramInt1, int paramInt2)
  {
    this.Gxb = paramInt1;
    this.Gxc = paramInt2;
    this.TAG = "MicroMsg.AudioResampler";
  }
  
  public final TAVAudioProcessorNode.TAVAudioProcessorEffect a(final com.tencent.mm.videocomposition.d paramd)
  {
    AppMethodBeat.i(190487);
    p.h(paramd, "track");
    paramd = (TAVAudioProcessorNode.TAVAudioProcessorEffect)new a(this, paramd);
    AppMethodBeat.o(190487);
    return paramd;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/model/AudioResampler$createResampleProcessor$1", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "getByteBuffer", "()Ljava/nio/ByteBuffer;", "setByteBuffer", "(Ljava/nio/ByteBuffer;)V", "destAudio", "Lcom/tencent/tav/decoder/AudioInfo;", "getDestAudio", "()Lcom/tencent/tav/decoder/AudioInfo;", "processor", "Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;", "getProcessor", "()Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;", "setProcessor", "(Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;)V", "getDestAudioInfo", "processAudioPCM", "time", "Lcom/tencent/tav/coremedia/CMTime;", "pcmBuffer", "audioInfo", "release", "", "plugin-vlog_release"})
  public static final class a
    implements TAVAudioProcessorNode.TAVAudioProcessorEffect
  {
    private g Gxd;
    private final AudioInfo Gxe;
    private ByteBuffer byteBuffer;
    private byte[] jzs;
    
    a(com.tencent.mm.videocomposition.d paramd)
    {
      AppMethodBeat.i(190486);
      this.jzs = new byte[0];
      this.Gxe = new AudioInfo();
      this.Gxe.sampleRate = paramd.Gxb;
      this.Gxe.channelCount = paramd.Gxc;
      this.Gxe.pcmEncoding = 2;
      AppMethodBeat.o(190486);
    }
    
    public final AudioInfo getDestAudioInfo()
    {
      return this.Gxe;
    }
    
    public final ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
    {
      AppMethodBeat.i(190485);
      p.h(paramCMTime, "time");
      p.h(paramByteBuffer, "pcmBuffer");
      p.h(paramAudioInfo, "audioInfo");
      if (this.Gxd == null)
      {
        this.Gxd = new g(paramd.path, paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding, this.Gxe.sampleRate, this.Gxe.channelCount, this.Gxe.pcmEncoding);
        Log.i(this.Gxf.TAG, "processAudioPCM, create convert processor, src:" + paramAudioInfo + ", dst:" + this.Gxe);
      }
      if (this.jzs.length != paramByteBuffer.limit()) {
        this.jzs = new byte[paramByteBuffer.limit()];
      }
      paramByteBuffer.position(0);
      paramByteBuffer.get(this.jzs);
      paramByteBuffer.position(0);
      paramCMTime = this.Gxd;
      if (paramCMTime != null)
      {
        paramCMTime = paramCMTime.X(this.jzs);
        if (paramCMTime != null) {}
      }
      else
      {
        AppMethodBeat.o(190485);
        return paramByteBuffer;
      }
      paramByteBuffer = this.byteBuffer;
      if ((paramByteBuffer == null) || (paramByteBuffer.capacity() != paramCMTime.length))
      {
        paramByteBuffer = ByteBuffer.allocateDirect(paramCMTime.length).order(ByteOrder.LITTLE_ENDIAN);
        paramByteBuffer.put(paramCMTime);
        this.byteBuffer = paramByteBuffer;
        paramCMTime = this.byteBuffer;
        if (paramCMTime != null) {
          paramCMTime.position(0);
        }
        p.g(paramByteBuffer, "newBuffer");
        AppMethodBeat.o(190485);
        return paramByteBuffer;
      }
      paramByteBuffer = this.byteBuffer;
      if (paramByteBuffer != null) {
        paramByteBuffer.position(0);
      }
      paramByteBuffer = this.byteBuffer;
      if (paramByteBuffer != null) {
        paramByteBuffer.put(paramCMTime);
      }
      paramCMTime = this.byteBuffer;
      if (paramCMTime != null) {
        paramCMTime.position(0);
      }
      paramCMTime = this.byteBuffer;
      if (paramCMTime == null) {
        p.hyc();
      }
      AppMethodBeat.o(190485);
      return paramCMTime;
    }
    
    public final void release()
    {
      AppMethodBeat.i(190484);
      g localg = this.Gxd;
      if (localg != null)
      {
        localg.release();
        AppMethodBeat.o(190484);
        return;
      }
      AppMethodBeat.o(190484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.d
 * JD-Core Version:    0.7.0.1
 */