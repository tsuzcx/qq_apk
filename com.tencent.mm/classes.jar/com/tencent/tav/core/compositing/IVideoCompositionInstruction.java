package com.tencent.tav.core.compositing;

import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.List;

public abstract interface IVideoCompositionInstruction
{
  public abstract int getBackgroundColor();
  
  public abstract List<? extends VideoCompositionLayerInstruction> getLayerInstructions();
  
  public abstract int getPassthroughTrackID();
  
  public abstract List<Integer> getRequiredSourceTrackIDs();
  
  public abstract CMTimeRange getTimeRange();
  
  public abstract boolean isEnablePostProcessing();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.compositing.IVideoCompositionInstruction
 * JD-Core Version:    0.7.0.1
 */