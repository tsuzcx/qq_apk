package com.tencent.tav.core.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.compositing.IVideoCompositionInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class VideoCompositionInstruction
  implements IVideoCompositionInstruction
{
  protected int backgroundColor;
  protected boolean enablePostProcessing;
  protected List<VideoCompositionLayerInstruction> layerInstructions;
  protected int passthroughTrackID;
  protected List<Integer> requiredSourceTrackIDs;
  protected CMTimeRange timeRange;
  
  public VideoCompositionInstruction()
  {
    AppMethodBeat.i(214716);
    this.layerInstructions = new ArrayList();
    this.requiredSourceTrackIDs = new ArrayList();
    this.passthroughTrackID = -1;
    AppMethodBeat.o(214716);
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  public List<? extends VideoCompositionLayerInstruction> getLayerInstructions()
  {
    return this.layerInstructions;
  }
  
  public int getPassthroughTrackID()
  {
    return this.passthroughTrackID;
  }
  
  public List<Integer> getRequiredSourceTrackIDs()
  {
    return this.requiredSourceTrackIDs;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public boolean isEnablePostProcessing()
  {
    return this.enablePostProcessing;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoCompositionInstruction
 * JD-Core Version:    0.7.0.1
 */