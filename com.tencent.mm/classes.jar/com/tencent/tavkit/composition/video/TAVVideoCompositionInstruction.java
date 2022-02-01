package com.tencent.tavkit.composition.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.composition.VideoCompositionInstruction;
import com.tencent.tav.core.composition.VideoCompositionLayerInstruction;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVVideoCompositionInstruction
  extends VideoCompositionInstruction
{
  private static final String TAG = "TAVVideoCompositionInst";
  private List<List<TAVVideoCompositionLayerInstruction>> channelLayers;
  private TAVVideoEffect globalVideoEffect;
  private List<TAVVideoCompositionLayerInstruction> overlayLayers;
  private TAVVideoEffect sourceVideoEffect;
  private final CMTimeRange timeRange;
  private TAVVideoMixEffect videoMixEffect;
  
  public TAVVideoCompositionInstruction(List<Integer> paramList, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(218944);
    this.requiredSourceTrackIDs = paramList;
    this.timeRange = paramCMTimeRange;
    this.enablePostProcessing = false;
    this.backgroundColor = -16777216;
    this.channelLayers = new ArrayList();
    this.overlayLayers = new ArrayList();
    AppMethodBeat.o(218944);
  }
  
  public int getBackgroundColor()
  {
    return this.backgroundColor;
  }
  
  List<List<TAVVideoCompositionLayerInstruction>> getChannelLayers()
  {
    return this.channelLayers;
  }
  
  TAVVideoEffect getGlobalVideoEffect()
  {
    return this.globalVideoEffect;
  }
  
  public List<TAVVideoCompositionLayerInstruction> getLayerInstructions()
  {
    AppMethodBeat.i(218961);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.channelLayers.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((List)localIterator.next());
    }
    localArrayList.addAll(this.overlayLayers);
    AppMethodBeat.o(218961);
    return localArrayList;
  }
  
  List<TAVVideoCompositionLayerInstruction> getOverlayLayers()
  {
    return this.overlayLayers;
  }
  
  public int getPassthroughTrackID()
  {
    return -1;
  }
  
  TAVVideoEffect getSourceVideoEffect()
  {
    return this.sourceVideoEffect;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  TAVVideoMixEffect getVideoMixEffect()
  {
    return this.videoMixEffect;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundColor = paramInt;
  }
  
  public void setChannelLayers(List<List<TAVVideoCompositionLayerInstruction>> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.channelLayers = paramList;
  }
  
  public void setEnablePostProcessing(boolean paramBoolean)
  {
    this.enablePostProcessing = paramBoolean;
  }
  
  public void setGlobalVideoEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    this.globalVideoEffect = paramTAVVideoEffect;
  }
  
  public void setOverlayLayers(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    AppMethodBeat.i(218979);
    if (paramList == null)
    {
      AppMethodBeat.o(218979);
      return;
    }
    this.overlayLayers = paramList;
    this.requiredSourceTrackIDs.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCompositionLayerInstruction localVideoCompositionLayerInstruction = (VideoCompositionLayerInstruction)paramList.next();
      this.requiredSourceTrackIDs.add(Integer.valueOf(localVideoCompositionLayerInstruction.getTrackID()));
    }
    AppMethodBeat.o(218979);
  }
  
  public void setSourceVideoEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    this.sourceVideoEffect = paramTAVVideoEffect;
  }
  
  public void setVideoMixEffect(TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    this.videoMixEffect = paramTAVVideoMixEffect;
  }
  
  public String toString()
  {
    AppMethodBeat.i(219048);
    String str = "TAVVideoCompositionInstruction{timeRange=" + this.timeRange.toSimpleString() + ", backgroundColor=" + this.backgroundColor + ", overlayLayers=" + this.overlayLayers + '}';
    AppMethodBeat.o(219048);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoCompositionInstruction
 * JD-Core Version:    0.7.0.1
 */