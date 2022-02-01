package com.tencent.tavkit.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.composition.VideoComposition;

public class TAVSource
{
  private Asset asset;
  private AudioMix audioMix;
  private VideoComposition videoComposition;
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public AudioMix getAudioMix()
  {
    return this.audioMix;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public void setAsset(Asset paramAsset)
  {
    this.asset = paramAsset;
  }
  
  public void setAudioMix(AudioMix paramAudioMix)
  {
    this.audioMix = paramAudioMix;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
  
  public String toString()
  {
    AppMethodBeat.i(204625);
    String str = "TAVSource{asset=" + this.asset + ", videoComposition=" + this.videoComposition + ", audioMix=" + this.audioMix + '}';
    AppMethodBeat.o(204625);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.TAVSource
 * JD-Core Version:    0.7.0.1
 */