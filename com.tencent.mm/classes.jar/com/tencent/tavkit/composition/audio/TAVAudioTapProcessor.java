package com.tencent.tavkit.composition.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AudioTapProcessor;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TAVAudioTapProcessor
  implements AudioTapProcessor
{
  private List<TAVAudioConfigurationSegment> audioConfigurationSegmentList;
  private HashMap<String, AudioTapProcessor> audioTapProcessorHashMap;
  private AudioInfo destAudioInfo;
  
  public TAVAudioTapProcessor(List<TAVAudioConfigurationSegment> paramList)
  {
    AppMethodBeat.i(197501);
    this.audioTapProcessorHashMap = new HashMap();
    this.audioConfigurationSegmentList = paramList;
    AppMethodBeat.o(197501);
  }
  
  public AudioInfo getDestAudioInfo()
  {
    return this.destAudioInfo;
  }
  
  public ByteBuffer processAudioPCM(CMTime paramCMTime, ByteBuffer paramByteBuffer, AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(197502);
    this.destAudioInfo = paramAudioInfo;
    Iterator localIterator1 = this.audioConfigurationSegmentList.iterator();
    Object localObject = paramByteBuffer;
    while (localIterator1.hasNext())
    {
      paramByteBuffer = (TAVAudioConfigurationSegment)localIterator1.next();
      if ((paramByteBuffer != null) && (paramByteBuffer.compositionTimeRange.containsTime(paramCMTime)))
      {
        paramByteBuffer = paramByteBuffer.audioConfiguration;
        if (paramByteBuffer.getNodes() != null)
        {
          Iterator localIterator2 = paramByteBuffer.getNodes().iterator();
          paramByteBuffer = (ByteBuffer)localObject;
          for (;;)
          {
            localObject = paramByteBuffer;
            if (!localIterator2.hasNext()) {
              break;
            }
            TAVAudioProcessorNode localTAVAudioProcessorNode = (TAVAudioProcessorNode)localIterator2.next();
            String str = localTAVAudioProcessorNode.getIdentifier();
            AudioTapProcessor localAudioTapProcessor = (AudioTapProcessor)this.audioTapProcessorHashMap.get(str);
            localObject = localAudioTapProcessor;
            if (localAudioTapProcessor == null)
            {
              localObject = localTAVAudioProcessorNode.createAudioProcessor();
              this.audioTapProcessorHashMap.put(str, localObject);
            }
            if (localObject != null)
            {
              paramByteBuffer = ((AudioTapProcessor)localObject).processAudioPCM(paramCMTime, paramByteBuffer, paramAudioInfo);
              this.destAudioInfo = ((AudioTapProcessor)localObject).getDestAudioInfo();
            }
          }
        }
      }
    }
    AppMethodBeat.o(197502);
    return localObject;
  }
  
  public void release()
  {
    AppMethodBeat.i(197503);
    Iterator localIterator = this.audioTapProcessorHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((AudioTapProcessor)localIterator.next()).release();
    }
    AppMethodBeat.o(197503);
  }
  
  public String toString()
  {
    AppMethodBeat.i(197504);
    String str = "TAVAudioTapProcessor{audioConfigurationSegmentList=" + this.audioConfigurationSegmentList + ", audioTapProcessorHashMap=" + this.audioTapProcessorHashMap + '}';
    AppMethodBeat.o(197504);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.audio.TAVAudioTapProcessor
 * JD-Core Version:    0.7.0.1
 */