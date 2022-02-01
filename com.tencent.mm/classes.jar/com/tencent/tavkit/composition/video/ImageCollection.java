package com.tencent.tavkit.composition.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import java.util.ArrayList;
import java.util.List;

public class ImageCollection
{
  private final List<TrackImagePair> overlayImages;
  private final List<TrackImagePair> videoChannelImages;
  
  public ImageCollection()
  {
    AppMethodBeat.i(197604);
    this.videoChannelImages = new ArrayList();
    this.overlayImages = new ArrayList();
    AppMethodBeat.o(197604);
  }
  
  public void addChannelImage(CIImage paramCIImage, TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    AppMethodBeat.i(197605);
    this.videoChannelImages.add(new TrackImagePair(paramCIImage, paramTAVVideoCompositionTrack));
    AppMethodBeat.o(197605);
  }
  
  public void addOverlayImage(CIImage paramCIImage, TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    AppMethodBeat.i(197606);
    this.overlayImages.add(new TrackImagePair(paramCIImage, paramTAVVideoCompositionTrack));
    AppMethodBeat.o(197606);
  }
  
  public List<TrackImagePair> getOverlayImages()
  {
    return this.overlayImages;
  }
  
  public List<TrackImagePair> getVideoChannelImages()
  {
    return this.videoChannelImages;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197607);
    String str = "ImageCollection{videoChannelImages=" + this.videoChannelImages + ", overlayImages=" + this.overlayImages + '}';
    AppMethodBeat.o(197607);
    return str;
  }
  
  public static class TrackImagePair
  {
    private final CIImage image;
    private final TAVVideoCompositionTrack track;
    
    TrackImagePair(CIImage paramCIImage, TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
    {
      this.image = paramCIImage;
      this.track = paramTAVVideoCompositionTrack;
    }
    
    public CIImage getImage()
    {
      return this.image;
    }
    
    public TAVVideoCompositionTrack getTrack()
    {
      return this.track;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.ImageCollection
 * JD-Core Version:    0.7.0.1
 */