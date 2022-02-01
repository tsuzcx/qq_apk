package com.tencent.tavkit.composition.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVAudioConfiguration
{
  private VolumeEdge endVolumeEdge;
  private final List<TAVAudioProcessorNode> nodes;
  private VolumeEdge startVolumeEdge;
  private float volume;
  private List<VolumeEdge> volumeEdges;
  
  public TAVAudioConfiguration()
  {
    this(1.0F);
  }
  
  public TAVAudioConfiguration(float paramFloat)
  {
    this(paramFloat, null, null);
  }
  
  public TAVAudioConfiguration(float paramFloat, List<TAVAudioProcessorNode> paramList)
  {
    this(paramFloat, paramList, null);
  }
  
  public TAVAudioConfiguration(float paramFloat, List<TAVAudioProcessorNode> paramList, List<VolumeEdge> paramList1)
  {
    AppMethodBeat.i(212392);
    this.volume = paramFloat;
    this.nodes = new ArrayList();
    if (paramList != null) {
      this.nodes.addAll(paramList);
    }
    this.volumeEdges = new ArrayList();
    if (paramList1 != null) {
      this.volumeEdges.addAll(paramList1);
    }
    AppMethodBeat.o(212392);
  }
  
  public TAVAudioConfiguration(List<VolumeEdge> paramList)
  {
    this(1.0F, null, paramList);
  }
  
  public void addAudioProcessorNode(TAVAudioProcessorNode paramTAVAudioProcessorNode)
  {
    AppMethodBeat.i(212403);
    this.nodes.add(paramTAVAudioProcessorNode);
    AppMethodBeat.o(212403);
  }
  
  public void addVolumeEdge(VolumeEdge paramVolumeEdge)
  {
    AppMethodBeat.i(212395);
    if (paramVolumeEdge == null)
    {
      AppMethodBeat.o(212395);
      return;
    }
    if (this.volumeEdges == null) {
      this.volumeEdges = new ArrayList();
    }
    this.volumeEdges.add(0, paramVolumeEdge);
    AppMethodBeat.o(212395);
  }
  
  public TAVAudioConfiguration clone()
  {
    AppMethodBeat.i(212405);
    TAVAudioConfiguration localTAVAudioConfiguration = new TAVAudioConfiguration(this.volume, this.nodes);
    AppMethodBeat.o(212405);
    return localTAVAudioConfiguration;
  }
  
  public VolumeEdge getEndVolumeEdge()
  {
    return this.endVolumeEdge;
  }
  
  public List<TAVAudioProcessorNode> getNodes()
  {
    return this.nodes;
  }
  
  public VolumeEdge getStartVolumeEdge()
  {
    return this.startVolumeEdge;
  }
  
  public float getVolume()
  {
    return this.volume;
  }
  
  public float getVolume(CMTime paramCMTime)
  {
    AppMethodBeat.i(212399);
    if ((this.startVolumeEdge != null) && (this.startVolumeEdge.getTimeRange() != null) && (this.startVolumeEdge.getTimeRange().containsTime(paramCMTime)))
    {
      f = this.startVolumeEdge.getVolume(paramCMTime.sub(this.startVolumeEdge.getTimeRange().getStart()));
      AppMethodBeat.o(212399);
      return f;
    }
    if ((this.endVolumeEdge != null) && (this.endVolumeEdge.getTimeRange() != null) && (this.endVolumeEdge.getTimeRange().containsTime(paramCMTime)))
    {
      f = this.endVolumeEdge.getVolume(paramCMTime.sub(this.endVolumeEdge.getTimeRange().getStart()));
      AppMethodBeat.o(212399);
      return f;
    }
    if ((this.volumeEdges != null) && (!this.volumeEdges.isEmpty()))
    {
      Iterator localIterator = this.volumeEdges.iterator();
      while (localIterator.hasNext())
      {
        VolumeEdge localVolumeEdge = (VolumeEdge)localIterator.next();
        if ((localVolumeEdge != null) && (localVolumeEdge.getTimeRange() != null) && (localVolumeEdge.getTimeRange().containsTime(paramCMTime)))
        {
          f = localVolumeEdge.getVolume(paramCMTime.sub(localVolumeEdge.getTimeRange().getStart()));
          AppMethodBeat.o(212399);
          return f;
        }
      }
    }
    float f = this.volume;
    AppMethodBeat.o(212399);
    return f;
  }
  
  public void setAudioProcessorNodes(List<TAVAudioProcessorNode> paramList)
  {
    AppMethodBeat.i(212404);
    this.nodes.clear();
    if (paramList != null) {
      this.nodes.addAll(paramList);
    }
    AppMethodBeat.o(212404);
  }
  
  public void setEndVolumeEdge(VolumeEdge paramVolumeEdge)
  {
    this.endVolumeEdge = paramVolumeEdge;
  }
  
  public void setStartVolumeEdge(VolumeEdge paramVolumeEdge)
  {
    this.startVolumeEdge = paramVolumeEdge;
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
  
  public String toString()
  {
    AppMethodBeat.i(212412);
    String str = "TAVAudioConfiguration{volume=" + this.volume + ", startVolumeEdge=" + this.startVolumeEdge + ", endVolumeEdge=" + this.endVolumeEdge + ", nodes=" + this.nodes + '}';
    AppMethodBeat.o(212412);
    return str;
  }
  
  public static class VolumeEdge
  {
    private float endVolume;
    private float startVolume;
    private CMTimeRange timeRange;
    
    public VolumeEdge() {}
    
    public VolumeEdge(CMTime paramCMTime, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(212350);
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
      this.startVolume = paramFloat1;
      this.endVolume = paramFloat2;
      AppMethodBeat.o(212350);
    }
    
    public VolumeEdge(CMTimeRange paramCMTimeRange, float paramFloat1, float paramFloat2)
    {
      this.timeRange = paramCMTimeRange;
      this.startVolume = paramFloat1;
      this.endVolume = paramFloat2;
    }
    
    public CMTime getDuration()
    {
      AppMethodBeat.i(212362);
      if (this.timeRange != null)
      {
        localCMTime = this.timeRange.getDuration();
        AppMethodBeat.o(212362);
        return localCMTime;
      }
      CMTime localCMTime = CMTime.CMTimeZero;
      AppMethodBeat.o(212362);
      return localCMTime;
    }
    
    public float getEndVolume()
    {
      return this.endVolume;
    }
    
    public float getStartVolume()
    {
      return this.startVolume;
    }
    
    public CMTimeRange getTimeRange()
    {
      return this.timeRange;
    }
    
    public float getVolume(CMTime paramCMTime)
    {
      AppMethodBeat.i(212374);
      long l = paramCMTime.getTimeUs();
      float f1 = this.startVolume;
      float f2 = this.endVolume;
      float f3 = this.startVolume;
      float f4 = (float)l * 1.0F / (float)getDuration().getTimeUs();
      AppMethodBeat.o(212374);
      return f4 * (f2 - f3) + f1;
    }
    
    public void setDuration(CMTime paramCMTime)
    {
      AppMethodBeat.i(212367);
      this.timeRange = new CMTimeRange(CMTime.CMTimeZero, paramCMTime);
      AppMethodBeat.o(212367);
    }
    
    public void setEndVolume(float paramFloat)
    {
      this.endVolume = paramFloat;
    }
    
    public void setStartVolume(float paramFloat)
    {
      this.startVolume = paramFloat;
    }
    
    public void setTimeRange(CMTimeRange paramCMTimeRange)
    {
      this.timeRange = paramCMTimeRange;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVAudioConfiguration
 * JD-Core Version:    0.7.0.1
 */