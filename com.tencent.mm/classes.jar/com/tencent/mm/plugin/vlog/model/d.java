package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.a.c;
import com.tencent.mm.videocomposition.b;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode.TAVAudioProcessorEffect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/AudioResampler;", "Lcom/tencent/mm/videocomposition/audio/IAudioResampleFactory;", "destSampleRate", "", "destChannelCount", "(II)V", "TAG", "", "getDestChannelCount", "()I", "getDestSampleRate", "createResampleProcessor", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "plugin-vlog_release"})
public final class d
  implements c
{
  final int NkD;
  final int NkE;
  final String TAG;
  
  public d(int paramInt1, int paramInt2)
  {
    this.NkD = paramInt1;
    this.NkE = paramInt2;
    this.TAG = "MicroMsg.AudioResampler";
  }
  
  public final TAVAudioProcessorNode.TAVAudioProcessorEffect a(final b paramb)
  {
    AppMethodBeat.i(231848);
    p.k(paramb, "track");
    paramb = (TAVAudioProcessorNode.TAVAudioProcessorEffect)new a(this, paramb);
    AppMethodBeat.o(231848);
    return paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/model/AudioResampler$createResampleProcessor$1", "Lcom/tencent/tavkit/composition/audio/TAVAudioProcessorNode$TAVAudioProcessorEffect;", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "byteBuffer", "Ljava/nio/ByteBuffer;", "getByteBuffer", "()Ljava/nio/ByteBuffer;", "setByteBuffer", "(Ljava/nio/ByteBuffer;)V", "destAudio", "Lcom/tencent/tav/decoder/AudioInfo;", "getDestAudio", "()Lcom/tencent/tav/decoder/AudioInfo;", "processor", "Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;", "getProcessor", "()Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;", "setProcessor", "(Lcom/tencent/mm/audio/mix/convert/AudioVariableConvertProcess;)V", "getDestAudioInfo", "processAudioPCM", "time", "Lcom/tencent/tav/coremedia/CMTime;", "pcmBuffer", "audioInfo", "release", "", "plugin-vlog_release"})
  public static final class a
    implements TAVAudioProcessorNode.TAVAudioProcessorEffect
  {
    private g NkF;
    private final AudioInfo NkG;
    private ByteBuffer byteBuffer;
    private byte[] moY;
    
    a(b paramb)
    {
      AppMethodBeat.i(236595);
      this.moY = new byte[0];
      this.NkG = new AudioInfo();
      this.NkG.sampleRate = paramb.NkD;
      this.NkG.channelCount = paramb.NkE;
      this.NkG.pcmEncoding = 2;
      AppMethodBeat.o(236595);
    }
    
    public final AudioInfo getDestAudioInfo()
    {
      return this.NkG;
    }
    
    public final ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
    {
      AppMethodBeat.i(236591);
      p.k(paramCMTime, "time");
      p.k(paramByteBuffer, "pcmBuffer");
      p.k(paramAudioInfo, "audioInfo");
      if (this.NkF == null)
      {
        this.NkF = new g(paramb.path, paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding, this.NkG.sampleRate, this.NkG.channelCount, this.NkG.pcmEncoding);
        Log.i(this.NkH.TAG, "processAudioPCM, create convert processor, src:" + paramAudioInfo + ", dst:" + this.NkG);
      }
      if (this.moY.length != paramByteBuffer.limit()) {
        this.moY = new byte[paramByteBuffer.limit()];
      }
      paramByteBuffer.position(0);
      paramByteBuffer.get(this.moY);
      paramByteBuffer.position(0);
      paramCMTime = this.NkF;
      if (paramCMTime != null)
      {
        paramCMTime = paramCMTime.ae(this.moY);
        if (paramCMTime != null) {}
      }
      else
      {
        AppMethodBeat.o(236591);
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
        p.j(paramByteBuffer, "newBuffer");
        AppMethodBeat.o(236591);
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
        p.iCn();
      }
      AppMethodBeat.o(236591);
      return paramCMTime;
    }
    
    public final void release()
    {
      AppMethodBeat.i(236589);
      g localg = this.NkF;
      if (localg != null)
      {
        localg.release();
        AppMethodBeat.o(236589);
        return;
      }
      AppMethodBeat.o(236589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.d
 * JD-Core Version:    0.7.0.1
 */