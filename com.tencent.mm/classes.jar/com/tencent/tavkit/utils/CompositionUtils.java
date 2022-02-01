package com.tencent.tavkit.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.MutableComposition;
import com.tencent.tav.asset.MutableCompositionTrack;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.audio.TAVAudioTransition;
import com.tencent.tavkit.composition.model.TAVCompositionTimeRange;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TrackInfo;
import com.tencent.tavkit.composition.video.TAVVideoTransition;
import java.util.Iterator;
import java.util.List;

public class CompositionUtils
{
  private static final String TAG = "CompositionUtils";
  
  private static void checkScaleTimeRange(MutableCompositionTrack paramMutableCompositionTrack, CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2)
  {
    AppMethodBeat.i(218540);
    if ((!CMTime.CMTimeInvalid.equalsTo(paramCMTimeRange1.getDuration())) && (!paramCMTimeRange2.getDuration().equalsTo(paramCMTimeRange1.getDuration()))) {
      paramMutableCompositionTrack.scaleTimeRange(new CMTimeRange(paramCMTimeRange1.getStart(), paramCMTimeRange2.getDuration()), paramCMTimeRange1.getDuration());
    }
    AppMethodBeat.o(218540);
  }
  
  public static TAVEmptyResource createEmptyResource(CMTime paramCMTime)
  {
    AppMethodBeat.i(218546);
    TAVEmptyResource localTAVEmptyResource = new TAVEmptyResource(paramCMTime);
    localTAVEmptyResource.setDuration(paramCMTime);
    localTAVEmptyResource.setScaledDuration(paramCMTime);
    AppMethodBeat.o(218546);
    return localTAVEmptyResource;
  }
  
  public static void insertTimeRangeToTrack(TrackInfo paramTrackInfo, MutableCompositionTrack paramMutableCompositionTrack, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(218536);
    try
    {
      CMTimeRange localCMTimeRange = paramTrackInfo.getSelectedTimeRange();
      if (paramTrackInfo.getTrack() != null)
      {
        paramMutableCompositionTrack.insertTimeRange(localCMTimeRange, paramTrackInfo.getTrack(), paramCMTimeRange.getStart());
        checkScaleTimeRange(paramMutableCompositionTrack, paramCMTimeRange, localCMTimeRange);
        AppMethodBeat.o(218536);
        return;
      }
      if (paramTrackInfo.getCompositionTrackSegment(paramCMTimeRange) != null)
      {
        paramMutableCompositionTrack.insertCompositionTrackSegment(paramTrackInfo.getCompositionTrackSegment(paramCMTimeRange));
        AppMethodBeat.o(218536);
        return;
      }
    }
    catch (Exception paramTrackInfo)
    {
      AppMethodBeat.o(218536);
      return;
    }
    Logger.e("CompositionUtils", "insertTimeRangeToTrack: TrackInfo track and segment are null !!!");
    AppMethodBeat.o(218536);
  }
  
  public static MutableCompositionTrack mutableTrackCompatibleWithTimeRange(MutableComposition paramMutableComposition, CMTimeRange paramCMTimeRange, int paramInt)
  {
    AppMethodBeat.i(218526);
    paramMutableComposition = paramMutableComposition.tracksWithMediaType(paramInt).iterator();
    while (paramMutableComposition.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)paramMutableComposition.next();
      CMTimeRange localCMTimeRange = TAVTimeUtil.getIntersection(localMutableCompositionTrack.getTimeRange(), paramCMTimeRange);
      if ((localCMTimeRange == null) || (localCMTimeRange.getDuration().getTimeSeconds() <= 0.0F))
      {
        AppMethodBeat.o(218526);
        return localMutableCompositionTrack;
      }
    }
    AppMethodBeat.o(218526);
    return null;
  }
  
  public static void reloadAudioStartTimeWithTransitionableAudio(List<? extends TAVTransitionableAudio> paramList)
  {
    AppMethodBeat.i(218531);
    reloadStartTimeWithTransitionable(paramList, new TransitionTimeCalculator()
    {
      public final CMTime transition(int paramAnonymousInt)
      {
        AppMethodBeat.i(218534);
        Object localObject = ((TAVTransitionableAudio)this.val$transitionableAudios.get(paramAnonymousInt)).getAudioTransition();
        if (localObject != null)
        {
          localObject = ((TAVAudioTransition)localObject).getDuration();
          AppMethodBeat.o(218534);
          return localObject;
        }
        localObject = CMTime.CMTimeZero;
        AppMethodBeat.o(218534);
        return localObject;
      }
    });
    AppMethodBeat.o(218531);
  }
  
  private static void reloadStartTimeWithTransitionable(List<? extends TAVCompositionTimeRange> paramList, TransitionTimeCalculator paramTransitionTimeCalculator)
  {
    AppMethodBeat.i(218533);
    CMTime localCMTime1 = CMTime.CMTimeZero;
    Object localObject3 = CMTime.CMTimeZero;
    int i = 0;
    TAVCompositionTimeRange localTAVCompositionTimeRange;
    Object localObject1;
    if (i < paramList.size())
    {
      localTAVCompositionTimeRange = (TAVCompositionTimeRange)paramList.get(i);
      localObject1 = CMTime.CMTimeZero;
      if (paramTransitionTimeCalculator == null) {
        break label176;
      }
      localObject1 = paramTransitionTimeCalculator.transition(i);
    }
    label176:
    for (;;)
    {
      CMTime localCMTime2 = localTAVCompositionTimeRange.getTimeRange().getDuration();
      Object localObject2;
      if ((!localCMTime2.smallThan((CMTime)localObject1)) && (i < paramList.size() - 1))
      {
        localObject2 = localObject1;
        if (((TAVCompositionTimeRange)paramList.get(i + 1)).getTimeRange().getDuration().smallThan((CMTime)localObject1)) {
          localObject2 = CMTime.CMTimeZero;
        }
      }
      for (localObject1 = localObject2;; localObject1 = CMTime.CMTimeZero)
      {
        localObject2 = localCMTime1.sub((CMTime)localObject3);
        localTAVCompositionTimeRange.setStartTime((CMTime)localObject2);
        localCMTime1 = ((CMTime)localObject2).add(localCMTime2);
        i += 1;
        localObject3 = localObject1;
        break;
      }
      AppMethodBeat.o(218533);
      return;
    }
  }
  
  public static void reloadVideoStartTimeWithTransitionableVideo(List<? extends TAVTransitionableVideo> paramList)
  {
    AppMethodBeat.i(218530);
    reloadStartTimeWithTransitionable(paramList, new TransitionTimeCalculator()
    {
      public final CMTime transition(int paramAnonymousInt)
      {
        AppMethodBeat.i(218529);
        Object localObject = ((TAVTransitionableVideo)this.val$transitionableVideos.get(paramAnonymousInt)).getVideoTransition();
        if (localObject != null)
        {
          localObject = ((TAVVideoTransition)localObject).getDuration();
          AppMethodBeat.o(218529);
          return localObject;
        }
        localObject = CMTime.CMTimeZero;
        AppMethodBeat.o(218529);
        return localObject;
      }
    });
    AppMethodBeat.o(218530);
  }
  
  static abstract interface TransitionTimeCalculator
  {
    public abstract CMTime transition(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.utils.CompositionUtils
 * JD-Core Version:    0.7.0.1
 */