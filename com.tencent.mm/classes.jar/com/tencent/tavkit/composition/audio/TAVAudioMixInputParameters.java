package com.tencent.tavkit.composition.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.MutableAudioMixInputParameters;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration.VolumeEdge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVAudioMixInputParameters
  extends MutableAudioMixInputParameters
{
  private static final String TAG = "TAVAudioMixInputParameters";
  private List<TAVAudioConfigurationSegment> audioConfigurationSegmentList;
  
  public TAVAudioMixInputParameters(AssetTrack paramAssetTrack)
  {
    super(paramAssetTrack);
    AppMethodBeat.i(218790);
    this.audioConfigurationSegmentList = new ArrayList();
    AppMethodBeat.o(218790);
  }
  
  public void addAudioConfiguration(CMTimeRange paramCMTimeRange, TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    AppMethodBeat.i(218819);
    this.audioConfigurationSegmentList.add(new TAVAudioConfigurationSegment(paramCMTimeRange, paramTAVAudioConfiguration));
    AppMethodBeat.o(218819);
  }
  
  public List<TAVAudioConfigurationSegment> getAudioConfigurationSegmentList()
  {
    return this.audioConfigurationSegmentList;
  }
  
  public float getVolumeAtTime(CMTime paramCMTime)
  {
    AppMethodBeat.i(218804);
    Iterator localIterator = this.audioConfigurationSegmentList.iterator();
    while (localIterator.hasNext())
    {
      TAVAudioConfigurationSegment localTAVAudioConfigurationSegment = (TAVAudioConfigurationSegment)localIterator.next();
      if ((localTAVAudioConfigurationSegment != null) && (localTAVAudioConfigurationSegment.compositionTimeRange.containsTime(paramCMTime)))
      {
        if ((localTAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge() != null) && (localTAVAudioConfigurationSegment.compositionTimeRange.getStart().add(localTAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge().getDuration()).bigThan(paramCMTime)))
        {
          f = localTAVAudioConfigurationSegment.audioConfiguration.getStartVolumeEdge().getVolume(paramCMTime.sub(localTAVAudioConfigurationSegment.compositionTimeRange.getStart()));
          AppMethodBeat.o(218804);
          return f;
        }
        if ((localTAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge() != null) && (localTAVAudioConfigurationSegment.compositionTimeRange.getEnd().sub(localTAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge().getDuration()).smallThan(paramCMTime)))
        {
          f = localTAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge().getVolume(paramCMTime.sub(localTAVAudioConfigurationSegment.compositionTimeRange.getEnd().sub(localTAVAudioConfigurationSegment.audioConfiguration.getEndVolumeEdge().getDuration())));
          AppMethodBeat.o(218804);
          return f;
        }
        f = localTAVAudioConfigurationSegment.audioConfiguration.getVolume(paramCMTime);
        AppMethodBeat.o(218804);
        return f;
      }
    }
    Logger.e("TAVAudioMixInputParameters", "没有设置正确audioConfiguration，走到了非预想的分支");
    float f = super.getVolumeAtTime(paramCMTime);
    AppMethodBeat.o(218804);
    return f;
  }
  
  public void setAudioConfigurationSegments(List<TAVAudioConfigurationSegment> paramList)
  {
    AppMethodBeat.i(218833);
    this.audioConfigurationSegmentList.clear();
    this.audioConfigurationSegmentList.addAll(paramList);
    AppMethodBeat.o(218833);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioMixInputParameters
 * JD-Core Version:    0.7.0.1
 */