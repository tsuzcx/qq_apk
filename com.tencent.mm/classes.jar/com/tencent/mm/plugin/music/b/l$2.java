package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.BufferInfo;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.FloatBufferInfo;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;

final class l$2
  implements IAudioListener
{
  private a.a cAL;
  private int channel;
  private int samplerate;
  
  l$2(l paraml)
  {
    AppMethodBeat.i(257251);
    this.channel = 0;
    this.samplerate = 0;
    this.cAL = new a.a(2, this.FOR.fmF);
    AppMethodBeat.o(257251);
  }
  
  public final long getActualTime(long paramLong)
  {
    return 0L;
  }
  
  public final boolean isEnabled()
  {
    return this.FOR.cAJ != null;
  }
  
  public final boolean isTerminal()
  {
    return false;
  }
  
  public final boolean onPcm(BufferInfo paramBufferInfo1, BufferInfo paramBufferInfo2, long paramLong)
  {
    AppMethodBeat.i(257252);
    if (this.FOR.cAJ != null) {
      this.FOR.cAJ.a(this.cAL, this.channel, this.samplerate, paramBufferInfo1.byteBuffer);
    }
    AppMethodBeat.o(257252);
    return false;
  }
  
  public final boolean onPcm(FloatBufferInfo paramFloatBufferInfo1, FloatBufferInfo paramFloatBufferInfo2, long paramLong)
  {
    AppMethodBeat.i(257254);
    if (this.FOR.cAJ != null) {
      this.FOR.cAJ.a(this.cAL, this.channel, this.samplerate, paramFloatBufferInfo1.floatBuffer);
    }
    AppMethodBeat.o(257254);
    return false;
  }
  
  public final long onPlayerReady(int paramInt, AudioInformation paramAudioInformation, long paramLong)
  {
    AppMethodBeat.i(257255);
    this.channel = paramAudioInformation.getChannels();
    this.samplerate = ((int)paramAudioInformation.getSampleRate());
    if (this.FOR.cAJ != null) {
      this.FOR.cAJ.a(this.cAL);
    }
    AppMethodBeat.o(257255);
    return 0L;
  }
  
  public final void onPlayerSeekComplete(long paramLong) {}
  
  public final void onPlayerStopped()
  {
    AppMethodBeat.i(257256);
    if (this.FOR.cAJ != null) {
      this.FOR.cAJ.b(this.cAL);
    }
    if (this.FOR.FOF != null) {
      this.FOR.FOF.removeAudioListener(this);
    }
    AppMethodBeat.o(257256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.b.l.2
 * JD-Core Version:    0.7.0.1
 */