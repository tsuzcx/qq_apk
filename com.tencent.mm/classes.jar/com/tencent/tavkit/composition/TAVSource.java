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
    AppMethodBeat.i(218831);
    String str = "TAVSource{\nasset=" + this.asset + "\nvideoComposition=" + this.videoComposition + "\naudioMix=" + this.audioMix + '}';
    AppMethodBeat.o(218831);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.TAVSource
 * JD-Core Version:    0.7.0.1
 */