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
    AppMethodBeat.i(219841);
    this.builderModel = paramBuilderModel;
    this.outputInstructions = new ArrayList();
    AppMethodBeat.o(219841);
  }
  
  private TAVVideoCompositionInstruction buildInstruction(Slice paramSlice, List<TAVVideoCompositionLayerInstruction> paramList, List<List<TAVVideoCompositionLayerInstruction>> paramList1)
  {
    AppMethodBeat.i(219849);
    TAVVideoCompositionInstruction localTAVVideoCompositionInstruction = new TAVVideoCompositionInstruction(trackIDsByLayers(paramSlice.layerInstructions), paramSlice.timeRange);
    localTAVVideoCompositionInstruction.setChannelLayers(selectChannels(paramList1, paramSlice.layerInstructions));
    localTAVVideoCompositionInstruction.setOverlayLayers(selectLayers(paramList, paramSlice.layerInstructions));
    localTAVVideoCompositionInstruction.setBackgroundColor(this.builderModel.getBackgroundColor());
    localTAVVideoCompositionInstruction.setGlobalVideoEffect(this.builderModel.getTavComposition().getGlobalVideoEffect());
    localTAVVideoCompositionInstruction.setVideoMixEffect(this.builderModel.getTavComposition().getVideoMixEffect());
    localTAVVideoCompositionInstruction.setSourceVideoEffect(this.builderModel.getTavComposition().getSourceVideoEffect());
    AppMethodBeat.o(219849);
    return localTAVVideoCompositionInstruction;
  }
  
  private void buildInstructions(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1, List<Slice> paramList2)
  {
    AppMethodBeat.i(219848);
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      TAVVideoCompositionInstruction localTAVVideoCompositionInstruction = buildInstruction((Slice)paramList2.next(), paramList1, paramList);
      this.outputInstructions.add(localTAVVideoCompositionInstruction);
    }
    AppMethodBeat.o(219848);
  }
  
  private static List<Slice> calculateSlicesForLayerInstructions(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    AppMethodBeat.i(219846);
    Object localObject2 = new TreeSet(new Comparator()
    {
      public final int compare(CMTime paramAnonymousCMTime1, CMTime paramAnonymousCMTime2)
      {
        AppMethodBeat.i(219837);
        int i = (int)paramAnonymousCMTime1.sub(paramAnonymousCMTime2).getValue();
        AppMethodBeat.o(219837);
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
    AppMethodBeat.o(219846);
    return localObject3;
  }
  
  private List<TAVVideoCompositionLayerInstruction> concatAndSortLayers(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1)
  {
    AppMethodBeat.i(219847);
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
        AppMethodBeat.i(219839);
        paramAnonymousTAVVideoCompositionLayerInstruction1 = paramAnonymousTAVVideoCompositionLayerInstruction1.getTimeRange().getStart();
        paramAnonymousTAVVideoCompositionLayerInstruction2 = paramAnonymousTAVVideoCompositionLayerInstruction2.getTimeRange().getStart();
        if (paramAnonymousTAVVideoCompositionLayerInstruction1.equalsTo(paramAnonymousTAVVideoCompositionLayerInstruction2))
        {
          AppMethodBeat.o(219839);
          return 0;
        }
        if (paramAnonymousTAVVideoCompositionLayerInstruction1.smallThan(paramAnonymousTAVVideoCompositionLayerInstruction2))
        {
          AppMethodBeat.o(219839);
          return -1;
        }
        AppMethodBeat.o(219839);
        return 1;
      }
    });
    AppMethodBeat.o(219847);
    return localArrayList;
  }
  
  private void fixLastLayerDuration(List<List<TAVVideoCompositionLayerInstruction>> paramList)
  {
    AppMethodBeat.i(219844);
    if ((paramList == null) || (paramList.size() != 1))
    {
      AppMethodBeat.o(219844);
      return;
    }
    paramList = (List)paramList.get(0);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(219844);
      return;
    }
    TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)paramList.get(paramList.size() - 1);
    CMTime localCMTime = this.builderModel.getTavComposition().getFrameDuration();
    paramList = localCMTime;
    if (localCMTime == null) {
      paramList = new CMTime(1L, 30);
    }
    localTAVVideoCompositionLayerInstruction.setTimeRange(new CMTimeRange(localTAVVideoCompositionLayerInstruction.getTimeRange().getStart(), localTAVVideoCompositionLayerInstruction.getTimeRange().getDuration().add(paramList)));
    AppMethodBeat.o(219844);
  }
  
  private List<List<TAVVideoCompositionLayerInstruction>> selectChannels(List<List<TAVVideoCompositionLayerInstruction>> paramList, List<TAVVideoCompositionLayerInstruction> paramList1)
  {
    AppMethodBeat.i(219851);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      List localList = selectLayers(paramList1, (List)paramList.next());
      if (localList.size() > 0) {
        localArrayList.add(localList);
      }
    }
    AppMethodBeat.o(219851);
    return localArrayList;
  }
  
  private List<TAVVideoCompositionLayerInstruction> selectLayers(List<TAVVideoCompositionLayerInstruction> paramList1, List<TAVVideoCompositionLayerInstruction> paramList2)
  {
    AppMethodBeat.i(219852);
    ArrayList localArrayList = new ArrayList();
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      TAVVideoCompositionLayerInstruction localTAVVideoCompositionLayerInstruction = (TAVVideoCompositionLayerInstruction)paramList1.next();
      if (paramList2.contains(localTAVVideoCompositionLayerInstruction)) {
        localArrayList.add(localTAVVideoCompositionLayerInstruction);
      }
    }
    AppMethodBeat.o(219852);
    return localArrayList;
  }
  
  private List<Integer> trackIDsByLayers(List<TAVVideoCompositionLayerInstruction> paramList)
  {
    AppMethodBeat.i(219850);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Integer.valueOf(((TAVVideoCompositionLayerInstruction)paramList.next()).getTrackID()));
    }
    AppMethodBeat.o(219850);
    return localArrayList;
  }
  
  List<TAVVideoCompositionInstruction> build()
  {
    AppMethodBeat.i(219842);
    List localList1 = buildMainLayerInstructions();
    List localList2 = buildOverlayLayerInstructions();
    buildInstructions(localList1, localList2, calculateSlicesForLayerInstructions(concatAndSortLayers(localList1, localList2)));
    localList1 = this.outputInstructions;
    AppMethodBeat.o(219842);
    return localList1;
  }
  
  List<List<TAVVideoCompositionLayerInstruction>> buildMainLayerInstructions()
  {
    AppMethodBeat.i(219843);
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
    AppMethodBeat.o(219843);
    return localArrayList1;
  }
  
  List<TAVVideoCompositionLayerInstruction> buildOverlayLayerInstructions()
  {
    AppMethodBeat.i(219845);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.builderModel.getOverlayTrackInfo().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((VideoOverlayInfo)localIterator.next()).convertToLayerInstruction());
    }
    AppMethodBeat.o(219845);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.composition.builder.VideoInstructionsBuilder
 * JD-Core Version:    0.7.0.1
 */