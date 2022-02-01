package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioInfo
  implements Cloneable
{
  public int channelCount = 1;
  public int pcmEncoding = 2;
  public int sampleRate = 44100;
  
  public AudioInfo() {}
  
  public AudioInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.sampleRate = paramInt1;
    this.channelCount = paramInt2;
    this.pcmEncoding = paramInt3;
  }
  
  public AudioInfo clone()
  {
    AppMethodBeat.i(190321);
    AudioInfo localAudioInfo = new AudioInfo(this.sampleRate, this.channelCount, this.pcmEncoding);
    AppMethodBeat.o(190321);
    return localAudioInfo;
  }
  
  public String toString()
  {
    AppMethodBeat.i(190324);
    String str = "AudioInfo{sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ", pcmEncoding=" + this.pcmEncoding + '}';
    AppMethodBeat.o(190324);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioInfo
 * JD-Core Version:    0.7.0.1
 */