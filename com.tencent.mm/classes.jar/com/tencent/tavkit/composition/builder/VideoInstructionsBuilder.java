package com.tencent.tavkit.composition.builder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.CompositionTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.video.TAVVideoCompositionInstruction;
import com.tencent.tavkit.composition.video.TAVVideoCompositionLayerInstruction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

class VideoInstructionsBuilder
{
  private final BuilderModel builderModel;
  private final List<TAVVideoCompositionInstruction> outputInstructions;
  
  VideoInstructionsBuilder(BuilderModel paramBuilderModel)
  {
    AppMethodBeat.i(204672);
    this.builderModel = paramBuilderModel;
    this.outputInstructions = new ArrayList();
    AppMethodBeat.o(204672);
  }
  
  private TAVVideoCompositionInstruction buildInstruction(Slice paramSlice, List<TAVVideoCompositionLayerInstruction> paramList, List<List<TAVVideoCompositionLayerInstruction>> paramList1)
  {
    AppMethodBeat.i(204680);
    TAVVideoCompositionInstruction localTAVVideoCompositionInstruction = new TAVVideoCompositionInstruction(trackIDsByLayers(paramSlice.layerInstructions), paramSlice.timeRange);
    localTAVVideoCompositionInstruction.setChannelLayers(selectChannels(paramList1, paramSlice.layerInstructions));
    localTAVVideoCompositionInstruction.setOverlayLayers(selectLayers(paramList, paramSlice.layerInstructions));
    localTAVVideoCompositionInstruction.setBackgroundColor(this.builderModel.getBackgroundColor());
    localTAVVideoCompositionInstruction.setGlobalVideoEffect(this.builderModel.getTavComposition().getGlobalVideoEffect());
    localTAVVideoCompositionInstruction.setVideoMixEffect(this.builderModel.getTavComposition().getVideoMixEffect());
    localTAVVideoCompositionInstruction.setSourceVideoEffect(this.builderModel.getTavComposition().getSourceVideoEffect());
    AppMethodBeat.o(204680);
    return localTAVVideoCompositionInstruction;
  }
  
  private void buildInstructions(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1, List<Slice> paramList2)
  {
    AppMethodBeat.i(204679);
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      TAVVideoCompositionInstruction localTAVVideoCompositionInstruction = buildInstruction((Slice)paramList2.next(), paramList1, paramList);
      this.outputInstructions.add(localTAVVideoCompositionInstruction);
    }
    AppMethodBeat.o(204679);
  }
  
  private static List<Slice> calculateSlicesForLayerInstructions(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    AppMethodBeat.i(204677);
    Object localObject2 = new TreeSet(new Comparator()
    {
      public final int compare(CMTime paramAnonymousCMTime1, CMTime paramAnonymousCMTime2)
      {
        AppMethodBeat.i(204668);
        int i = (int)paramAnonymousCMTime1.sub(paramAnonymousCMTime2).getValue();
        AppMethodBeat.o(204668);
        return i;
      }
    });
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (TAVVideoCompositionLayerInstruction)((Iterator)localObject1).next();
      ((TreeSet)localObject2).add(((TAVVideoCompositionLayerInstruction)localObject3).getTimeRange().getStart());
      ((TreeSet)localObject2).add(((TAVVideoCompositionLayerInstruction)localObject3).getTimeRange().getEnd());
    }
    Object localObject3 = new ArrayList();
    localObject1 = (CMTime)((TreeSet)localObject2).pollFirst();
    Iterator localIterator1 = ((TreeSet)localObject2).iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (CMTime)localIterator1.next();
      CMTimeRange localCMTimeRange = new CMTimeRange((CMTime)localObject1, ((CMTime)localObject2).sub((CMTime)localObject1));
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator2 = paramList.iterator();
      while (localIterator2.hasNext())
      {
        TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)localIterator2.next();
        if ((localTAVVideoCompositionLayerInstruction.getTimeRange().getEnd().getTimeUs() >= ((CMTime)localObject1).getTimeUs()) && (localTAVVideoCompositionLayerInstruction.getTimeRange().getStart().getTimeUs() <= ((CMTime)localObject2).getTimeUs())) {
          localArrayList.add(localTAVVideoCompositionLayerInstruction);
        }
      }
      ((ArrayList)localObject3).add(new Slice(localCMTimeRange, localArrayList));
      localObject1 = localObject2;
    }
    AppMethodBeat.o(204677);
    return localObject3;
  }
  
  private List<TAVVideoCompositionLayerInstruction> concatAndSortLayers(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1)
  {
    AppMethodBeat.i(204678);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.addAll((List)paramList.next());
    }
    localArrayList.addAll(paramList1);
    Collections.sort(localArrayList, new Comparator()
    {
      public int compare(TAVVideoCompositionLayerInstruction paramAnonymousTAVVideoCompositionLayerInstruction1, TAVVideoCompositionLayerInstruction paramAnonymousTAVVideoCompositionLayerInstruction2)
      {
        AppMethodBeat.i(204670);
        if (paramAnonymousTAVVideoCompositionLayerInstruction1.getTimeRange().getStart().smallThan(paramAnonymousTAVVideoCompositionLayerInstruction2.getTimeRange().getStart()))
        {
          AppMethodBeat.o(204670);
          return -1;
        }
        AppMethodBeat.o(204670);
        return 1;
      }
    });
    AppMethodBeat.o(204678);
    return localArrayList;
  }
  
  private void fixLastLayerDuration(List<List<TAVVideoCompositionLayerInstruction>> paramList)
  {
    AppMethodBeat.i(204675);
    if ((paramList == null) || (paramList.size() != 1))
    {
      AppMethodBeat.o(204675);
      return;
    }
    paramList = (List)paramList.get(0);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(204675);
      return;
    }
    TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)paramList.get(paramList.size() - 1);
    CMTime localCMTime = this.builderModel.getTavComposition().getFrameDuration();
    paramList = localCMTime;
    if (localCMTime == null) {
      paramList = new CMTime(1L, 30);
    }
    localTAVVideoCompositionLayerInstruction.setTimeRange(new CMTimeRange(localTAVVideoCompositionLayerInstruction.getTimeRange().getStart(), localTAVVideoCompositionLayerInstruction.getTimeRange().getDuration().add(paramList)));
    AppMethodBeat.o(204675);
  }
  
  private List<List<TAVVideoCompositionLayerInstruction>> selectChannels(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1)
  {
    AppMethodBeat.i(204682);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = selectLayers(paramList1, (List)paramList.next());
      if (localList.size() > 0) {
        localArrayList.add(localList);
      }
    }
    AppMethodBeat.o(204682);
    return localArrayList;
  }
  
  private List<TAVVideoCompositionLayerInstruction> selectLayers(List<TAVVideoCompositionLayerInstruction> paramList1, List<TAVVideoCompositionLayerInstruction> paramList2)
  {
    AppMethodBeat.i(204683);
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)paramList1.next();
      if (paramList2.contains(localTAVVideoCompositionLayerInstruction)) {
        localArrayList.add(localTAVVideoCompositionLayerInstruction);
      }
    }
    AppMethodBeat.o(204683);
    return localArrayList;
  }
  
  private List<Integer> trackIDsByLayers(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    AppMethodBeat.i(204681);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(((TAVVideoCompositionLayerInstruction)paramList.next()).getTrackID()));
    }
    AppMethodBeat.o(204681);
    return localArrayList;
  }
  
  List<TAVVideoCompositionInstruction> build()
  {
    AppMethodBeat.i(204673);
    List localList1 = buildMainLayerInstructions();
    List localList2 = buildOverlayLayerInstructions();
    buildInstructions(localList1, localList2, calculateSlicesForLayerInstructions(concatAndSortLayers(localList1, localList2)));
    localList1 = this.outputInstructions;
    AppMethodBeat.o(204673);
    return localList1;
  }
  
  List<List<TAVVideoCompositionLayerInstruction>> buildMainLayerInstructions()
  {
    AppMethodBeat.i(204674);
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.builderModel.getMainVideoTrackInfo().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (List)localIterator.next();
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject).next();
        localArrayList2.add(new TAVVideoCompositionLayerInstruction(localVideoInfo.compositionTrack.getTrackID(), localVideoInfo.clip));
      }
      localArrayList1.add(localArrayList2);
    }
    fixLastLayerDuration(localArrayList1);
    AppMethodBeat.o(204674);
    return localArrayList1;
  }
  
  List<TAVVideoCompositionLayerInstruction> buildOverlayLayerInstructions()
  {
    AppMethodBeat.i(204676);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.builderModel.getOverlayTrackInfo().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((VideoOverlayInfo)localIterator.next()).convertToLayerInstruction());
    }
    AppMethodBeat.o(204676);
    return localArrayList;
  }
  
  static class Slice
  {
    private List<TAVVideoCompositionLayerInstruction> layerInstructions;
    private CMTimeRange timeRange;
    
    Slice(CMTimeRange paramCMTimeRange, List<TAVVideoCompositionLayerInstruction> paramList)
    {
      this.timeRange = paramCMTimeRange;
      this.layerInstructions = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.VideoInstructionsBuilder
 * JD-Core Version:    0.7.0.1
 */