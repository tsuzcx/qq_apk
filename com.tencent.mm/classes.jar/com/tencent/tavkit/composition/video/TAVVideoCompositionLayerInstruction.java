package com.tencent.tavkit.composition.video;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction.CropRectangleRamp;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction.OpacityRamp;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction.TransformRamp;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;

public class TAVVideoCompositionLayerInstruction
  implements VideoCompositionLayerInstruction
{
  private final TAVVideoCompositionTrack imageSource;
  private Matrix preferredTransform;
  private CMTimeRange timeRange;
  private int trackID;
  private TAVVideoTransition transition;
  private final TAVVideoConfiguration videoConfiguration;
  
  public TAVVideoCompositionLayerInstruction(int paramInt, TAVTransitionableVideo paramTAVTransitionableVideo)
  {
    this(paramInt, paramTAVTransitionableVideo.getVideoConfiguration(), paramTAVTransitionableVideo);
    AppMethodBeat.i(200964);
    setTimeRange(paramTAVTransitionableVideo.getTimeRange());
    setTransition(paramTAVTransitionableVideo.getVideoTransition());
    AppMethodBeat.o(200964);
  }
  
  public TAVVideoCompositionLayerInstruction(int paramInt, TAVVideoConfiguration paramTAVVideoConfiguration, TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    AppMethodBeat.i(200963);
    this.trackID = paramInt;
    this.videoConfiguration = paramTAVVideoConfiguration;
    this.imageSource = paramTAVVideoCompositionTrack;
    this.preferredTransform = new Matrix();
    AppMethodBeat.o(200963);
  }
  
  public Bitmap applySourceImage(Bitmap paramBitmap, CMTime paramCMTime, CGSize paramCGSize)
  {
    return null;
  }
  
  public VideoCompositionLayerInstruction.CropRectangleRamp getCropRectangleRampForTime(CMTime paramCMTime)
  {
    return null;
  }
  
  public TAVVideoCompositionTrack getImageSource()
  {
    return this.imageSource;
  }
  
  public VideoCompositionLayerInstruction.OpacityRamp getOpacityRampForTime(CMTime paramCMTime)
  {
    return null;
  }
  
  public Matrix getPreferredTransform()
  {
    return this.preferredTransform;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public int getTrackID()
  {
    return this.trackID;
  }
  
  public VideoCompositionLayerInstruction.TransformRamp getTransformRampForTime(CMTime paramCMTime)
  {
    return null;
  }
  
  public TAVVideoTransition getTransition()
  {
    return this.transition;
  }
  
  public TAVVideoConfiguration getVideoConfiguration()
  {
    return this.videoConfiguration;
  }
  
  public void setPreferredTransform(Matrix paramMatrix)
  {
    this.preferredTransform = paramMatrix;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public void setTrackID(int paramInt)
  {
    this.trackID = paramInt;
  }
  
  public void setTransition(TAVVideoTransition paramTAVVideoTransition)
  {
    this.transition = paramTAVVideoTransition;
  }
  
  public String toString()
  {
    AppMethodBeat.i(200965);
    String str = "TAVVideoCompositionLayerInstruction{trackID=" + this.trackID + ", timeRange=" + this.timeRange.toSimpleString() + ", preferredTransform=" + this.preferredTransform + ", imageSource=" + this.imageSource + ", transition=" + this.transition + ", videoConfiguration=" + this.videoConfiguration + '}';
    AppMethodBeat.o(200965);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction
 * JD-Core Version:    0.7.0.1
 */