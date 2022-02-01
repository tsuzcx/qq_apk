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
    AppMethodBeat.i(192044);
    this.builderModel = paramBuilderModel;
    this.outputInstructions = new ArrayList();
    AppMethodBeat.o(192044);
  }
  
  private TAVVideoCompositionInstruction buildInstruction(Slice paramSlice, List<TAVVideoCompositionLayerInstruction> paramList, List<List<TAVVideoCompositionLayerInstruction>> paramList1)
  {
    AppMethodBeat.i(192052);
    TAVVideoCompositionInstruction localTAVVideoCompositionInstruction = new TAVVideoCompositionInstruction(trackIDsByLayers(paramSlice.layerInstructions), paramSlice.timeRange);
    localTAVVideoCompositionInstruction.setChannelLayers(selectChannels(paramList1, paramSlice.layerInstructions));
    localTAVVideoCompositionInstruction.setOverlayLayers(selectLayers(paramList, paramSlice.layerInstructions));
    localTAVVideoCompositionInstruction.setBackgroundColor(this.builderModel.getBackgroundColor());
    localTAVVideoCompositionInstruction.setGlobalVideoEffect(this.builderModel.getTavComposition().getGlobalVideoEffect());
    localTAVVideoCompositionInstruction.setVideoMixEffect(this.builderModel.getTavComposition().getVideoMixEffect());
    localTAVVideoCompositionInstruction.setSourceVideoEffect(this.builderModel.getTavComposition().getSourceVideoEffect());
    AppMethodBeat.o(192052);
    return localTAVVideoCompositionInstruction;
  }
  
  private void buildInstructions(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1, List<Slice> paramList2)
  {
    AppMethodBeat.i(192051);
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      TAVVideoCompositionInstruction localTAVVideoCompositionInstruction = buildInstruction((Slice)paramList2.next(), paramList1, paramList);
      this.outputInstructions.add(localTAVVideoCompositionInstruction);
    }
    AppMethodBeat.o(192051);
  }
  
  private static List<Slice> calculateSlicesForLayerInstructions(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    AppMethodBeat.i(192049);
    Object localObject2 = new TreeSet(new Comparator()
    {
      public final int compare(CMTime paramAnonymousCMTime1, CMTime paramAnonymousCMTime2)
      {
        AppMethodBeat.i(192040);
        int i = (int)paramAnonymousCMTime1.sub(paramAnonymousCMTime2).getValue();
        AppMethodBeat.o(192040);
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
    AppMethodBeat.o(192049);
    return localObject3;
  }
  
  private List<TAVVideoCompositionLayerInstruction> concatAndSortLayers(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1)
  {
    AppMethodBeat.i(192050);
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
        AppMethodBeat.i(192042);
        if (paramAnonymousTAVVideoCompositionLayerInstruction1.getTimeRange().getStart().smallThan(paramAnonymousTAVVideoCompositionLayerInstruction2.getTimeRange().getStart()))
        {
          AppMethodBeat.o(192042);
          return -1;
        }
        AppMethodBeat.o(192042);
        return 1;
      }
    });
    AppMethodBeat.o(192050);
    return localArrayList;
  }
  
  private void fixLastLayerDuration(List<List<TAVVideoCompositionLayerInstruction>> paramList)
  {
    AppMethodBeat.i(192047);
    if ((paramList == null) || (paramList.size() != 1))
    {
      AppMethodBeat.o(192047);
      return;
    }
    paramList = (List)paramList.get(0);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(192047);
      return;
    }
    TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)paramList.get(paramList.size() - 1);
    CMTime localCMTime = this.builderModel.getTavComposition().getFrameDuration();
    paramList = localCMTime;
    if (localCMTime == null) {
      paramList = new CMTime(1L, 30);
    }
    localTAVVideoCompositionLayerInstruction.setTimeRange(new CMTimeRange(localTAVVideoCompositionLayerInstruction.getTimeRange().getStart(), localTAVVideoCompositionLayerInstruction.getTimeRange().getDuration().add(paramList)));
    AppMethodBeat.o(192047);
  }
  
  private List<List<TAVVideoCompositionLayerInstruction>> selectChannels(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1)
  {
    AppMethodBeat.i(192054);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = selectLayers(paramList1, (List)paramList.next());
      if (localList.size() > 0) {
        localArrayList.add(localList);
      }
    }
    AppMethodBeat.o(192054);
    return localArrayList;
  }
  
  private List<TAVVideoCompositionLayerInstruction> selectLayers(List<TAVVideoCompositionLayerInstruction> paramList1, List<TAVVideoCompositionLayerInstruction> paramList2)
  {
    AppMethodBeat.i(192055);
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)paramList1.next();
      if (paramList2.contains(localTAVVideoCompositionLayerInstruction)) {
        localArrayList.add(localTAVVideoCompositionLayerInstruction);
      }
    }
    AppMethodBeat.o(192055);
    return localArrayList;
  }
  
  private List<Integer> trackIDsByLayers(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    AppMethodBeat.i(192053);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(((TAVVideoCompositionLayerInstruction)paramList.next()).getTrackID()));
    }
    AppMethodBeat.o(192053);
    return localArrayList;
  }
  
  List<TAVVideoCompositionInstruction> build()
  {
    AppMethodBeat.i(192045);
    List localList1 = buildMainLayerInstructions();
    List localList2 = buildOverlayLayerInstructions();
    buildInstructions(localList1, localList2, calculateSlicesForLayerInstructions(concatAndSortLayers(localList1, localList2)));
    localList1 = this.outputInstructions;
    AppMethodBeat.o(192045);
    return localList1;
  }
  
  List<List<TAVVideoCompositionLayerInstruction>> buildMainLayerInstructions()
  {
    AppMethodBeat.i(192046);
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
    AppMethodBeat.o(192046);
    return localArrayList1;
  }
  
  List<TAVVideoCompositionLayerInstruction> buildOverlayLayerInstructions()
  {
    AppMethodBeat.i(192048);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.builderModel.getOverlayTrackInfo().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((VideoOverlayInfo)localIterator.next()).convertToLayerInstruction());
    }
    AppMethodBeat.o(192048);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.VideoInstructionsBuilder
 * JD-Core Version:    0.7.0.1
 */