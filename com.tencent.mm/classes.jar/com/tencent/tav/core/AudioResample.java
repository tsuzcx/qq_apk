package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.IAVResample;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.factory.AVResampleFactory;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AudioResample
{
  public final String TAG;
  private IAVResample avResample;
  private final AudioInfo destAudioInfo;
  private ByteBuffer destBuffer;
  private AudioInfo srcAudioInfo;
  
  public AudioResample()
  {
    this(newDefaultDestAudioInfo());
    AppMethodBeat.i(189085);
    AppMethodBeat.o(189085);
  }
  
  public AudioResample(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(189089);
    this.TAG = ("AudioResample@" + Integer.toHexString(hashCode()));
    this.destAudioInfo = paramAudioInfo;
    Logger.i(this.TAG, "AudioResample() called with: destAudioInfo = [" + paramAudioInfo + "], thread = " + Thread.currentThread().getName());
    AppMethodBeat.o(189089);
  }
  
  private boolean compareAudioInfo(AudioInfo paramAudioInfo)
  {
    if (this.srcAudioInfo == null) {}
    while ((this.srcAudioInfo.pcmEncoding != paramAudioInfo.pcmEncoding) || (this.srcAudioInfo.channelCount != paramAudioInfo.channelCount) || (this.srcAudioInfo.sampleRate != paramAudioInfo.sampleRate)) {
      return false;
    }
    return true;
  }
  
  private static AudioInfo newDefaultDestAudioInfo()
  {
    AppMethodBeat.i(189092);
    AudioInfo localAudioInfo = new AudioInfo();
    localAudioInfo.channelCount = 1;
    localAudioInfo.sampleRate = 44100;
    localAudioInfo.pcmEncoding = 2;
    AppMethodBeat.o(189092);
    return localAudioInfo;
  }
  
  public AudioInfo getDestAudioInfo()
  {
    return this.destAudioInfo;
  }
  
  public ByteBuffer resample(ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(189099);
    Logger.v(this.TAG, "resample() called with: srcBuffer = [" + paramByteBuffer + "], srcAudioInfo = [" + paramAudioInfo + "]， thread = " + Thread.currentThread().getName());
    if ((!compareAudioInfo(paramAudioInfo)) && (AVResampleFactory.getInstance().isResampleEnable()))
    {
      this.avResample = AVResampleFactory.getInstance().newAVResample(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, this.destAudioInfo.sampleRate, this.destAudioInfo.channelCount);
      this.srcAudioInfo = paramAudioInfo;
      if (this.avResample == null) {
        break label192;
      }
    }
    label192:
    for (String str = this.avResample.getClass().getName();; str = "null")
    {
      Logger.i(this.TAG, "resample: 创建重采样库，class = " + str + ", srcAudioInfo = " + paramAudioInfo + ", thread = " + Thread.currentThread().getName());
      if (this.avResample != null) {
        break;
      }
      Logger.w(this.TAG, "resample: avResample 创建失败！");
      AppMethodBeat.o(189099);
      return null;
    }
    paramByteBuffer = this.avResample.resample(paramByteBuffer, paramByteBuffer.limit());
    if ((this.destBuffer == null) || (paramByteBuffer.length > this.destBuffer.limit()))
    {
      this.destBuffer = ByteBuffer.allocateDirect(paramByteBuffer.length);
      this.destBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }
    this.destBuffer.clear();
    this.destBuffer.put(paramByteBuffer);
    this.destBuffer.position(0);
    this.destBuffer.limit(paramByteBuffer.length);
    paramByteBuffer = this.destBuffer;
    AppMethodBeat.o(189099);
    return paramByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AudioResample
 * JD-Core Version:    0.7.0.1
 */