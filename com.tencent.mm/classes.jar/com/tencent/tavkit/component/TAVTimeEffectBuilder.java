package com.tencent.tavkit.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import com.tencent.tavkit.utils.TAVTimeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TAVTimeEffectBuilder
{
  private TAVClip clip;
  private TAVTimeEffect[] timeEffects;
  
  public TAVTimeEffectBuilder() {}
  
  public TAVTimeEffectBuilder(TAVClip paramTAVClip, List<TAVTimeEffect> paramList)
  {
    AppMethodBeat.i(218654);
    this.clip = paramTAVClip;
    this.timeEffects = ((TAVTimeEffect[])paramList.toArray());
    AppMethodBeat.o(218654);
  }
  
  public TAVTimeEffectBuilder(TAVClip paramTAVClip, TAVTimeEffect... paramVarArgs)
  {
    this.clip = paramTAVClip;
    this.timeEffects = paramVarArgs;
  }
  
  private void addSegmentToChannel(TAVClip paramTAVClip, TAVClipSegment paramTAVClipSegment, List<TAVClip> paramList)
  {
    AppMethodBeat.i(218669);
    paramTAVClip = paramTAVClip.clone();
    paramTAVClip.getResource().setSourceTimeRange(paramTAVClipSegment.timeRange);
    paramTAVClip.getResource().setScaledDuration(paramTAVClipSegment.timeRange.getDuration());
    paramList.add(paramTAVClip);
    AppMethodBeat.o(218669);
  }
  
  private void addSegmentToChannelWithTimeEffect(TAVClip paramTAVClip, TAVClipSegment paramTAVClipSegment, List<TAVClip> paramList)
  {
    AppMethodBeat.i(218680);
    int i = 0;
    if (i < paramTAVClipSegment.timeEffect.getLoopCount())
    {
      Object localObject1;
      Object localObject2;
      if ((paramTAVClip.getResource() instanceof TAVAssetTrackResource))
      {
        localObject1 = ((TAVAssetTrackResource)paramTAVClip.getResource()).getAsset();
        if (paramTAVClipSegment.timeEffect.isFreeze())
        {
          localObject1 = new TAVAssetTrackResource((Asset)localObject1);
          localObject2 = new CMTime(1L, 30);
          if (paramTAVClipSegment.timeEffect.isReverse())
          {
            ((TAVResource)localObject1).setSourceTimeRange(new CMTimeRange(paramTAVClipSegment.timeRange.getEnd().sub((CMTime)localObject2), (CMTime)localObject2));
            label111:
            if (paramTAVClipSegment.timeEffect.getLoopCount() != 0) {
              break label315;
            }
            ((TAVResource)localObject1).setScaledDuration(paramTAVClipSegment.timeRange.getDuration());
            label133:
            if (paramTAVClipSegment.timeEffect.getScaledDuration().value > 0L)
            {
              if (paramTAVClipSegment.timeEffect.getLoopCount() != 0) {
                break label341;
              }
              ((TAVResource)localObject1).setScaledDuration(paramTAVClipSegment.timeEffect.getScaledDuration());
            }
          }
        }
      }
      for (;;)
      {
        localObject2 = paramTAVClip.clone();
        ((TAVClip)localObject2).setResource((TAVResource)localObject1);
        paramList.add(localObject2);
        i += 1;
        break;
        ((TAVResource)localObject1).setSourceTimeRange(new CMTimeRange(paramTAVClipSegment.timeRange.getStart(), (CMTime)localObject2));
        break label111;
        if (paramTAVClipSegment.timeEffect.isReverse()) {}
        for (localObject1 = new TAVAssetTrackResource((Asset)localObject1);; localObject1 = new TAVAssetTrackResource((Asset)localObject1))
        {
          ((TAVResource)localObject1).setSourceTimeRange(new CMTimeRange(paramTAVClipSegment.timeRange.getStart(), paramTAVClipSegment.timeEffect.getTimeRange().getDuration().divide(paramTAVClipSegment.timeEffect.getLoopCount())));
          break;
        }
        localObject1 = paramTAVClip.getResource().clone();
        break label111;
        label315:
        ((TAVResource)localObject1).setScaledDuration(paramTAVClipSegment.timeRange.getDuration().divide(paramTAVClipSegment.timeEffect.getLoopCount()));
        break label133;
        label341:
        ((TAVResource)localObject1).setScaledDuration(paramTAVClipSegment.timeEffect.getScaledDuration().divide(paramTAVClipSegment.timeEffect.getLoopCount()));
      }
    }
    AppMethodBeat.o(218680);
  }
  
  private List<TAVTimeEffect> availableTimeEffectsFromClip(TAVClip paramTAVClip)
  {
    AppMethodBeat.i(218706);
    if (this.timeEffects == null)
    {
      AppMethodBeat.o(218706);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramTAVClip = paramTAVClip.getResource();
    TAVTimeEffect[] arrayOfTAVTimeEffect = this.timeEffects;
    int k = arrayOfTAVTimeEffect.length;
    int i = 0;
    TAVTimeEffect localTAVTimeEffect;
    if (i < k)
    {
      localTAVTimeEffect = arrayOfTAVTimeEffect[i];
      CMTimeRange localCMTimeRange1 = TAVTimeUtil.getIntersection(paramTAVClip.getSourceTimeRange(), localTAVTimeEffect.getTimeRange());
      if ((localCMTimeRange1 != null) && (localCMTimeRange1.getDuration().value > 0L))
      {
        Iterator localIterator = localArrayList.iterator();
        CMTimeRange localCMTimeRange2;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localCMTimeRange2 = TAVTimeUtil.getIntersection(((TAVTimeEffect)localIterator.next()).getTimeRange(), localCMTimeRange1);
        } while ((localCMTimeRange2 == null) || (localCMTimeRange2.getDuration().value <= 0L));
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localArrayList.add(localTAVTimeEffect);
      }
      i += 1;
      break;
      Collections.sort(localArrayList, new Comparator()
      {
        public int compare(TAVTimeEffect paramAnonymousTAVTimeEffect1, TAVTimeEffect paramAnonymousTAVTimeEffect2)
        {
          AppMethodBeat.i(218681);
          paramAnonymousTAVTimeEffect1 = paramAnonymousTAVTimeEffect1.getTimeRange().getStart();
          paramAnonymousTAVTimeEffect2 = paramAnonymousTAVTimeEffect2.getTimeRange().getStart();
          if (paramAnonymousTAVTimeEffect1.equalsTo(paramAnonymousTAVTimeEffect2))
          {
            AppMethodBeat.o(218681);
            return 0;
          }
          if (paramAnonymousTAVTimeEffect1.bigThan(paramAnonymousTAVTimeEffect2))
          {
            AppMethodBeat.o(218681);
            return 1;
          }
          AppMethodBeat.o(218681);
          return -1;
        }
      });
      AppMethodBeat.o(218706);
      return localArrayList;
    }
  }
  
  private void initChannelWithClip(TAVClip paramTAVClip, List<TAVClip> paramList)
  {
    AppMethodBeat.i(218663);
    Iterator localIterator = segmentsWithClip(paramTAVClip).iterator();
    while (localIterator.hasNext())
    {
      TAVClipSegment localTAVClipSegment = (TAVClipSegment)localIterator.next();
      if (localTAVClipSegment.timeEffect == null) {
        addSegmentToChannel(paramTAVClip, localTAVClipSegment, paramList);
      } else {
        addSegmentToChannelWithTimeEffect(paramTAVClip, localTAVClipSegment, paramList);
      }
    }
    AppMethodBeat.o(218663);
  }
  
  private List<TAVClipSegment> segmentsWithClip(TAVClip paramTAVClip)
  {
    AppMethodBeat.i(218694);
    Object localObject1 = paramTAVClip.getResource();
    Object localObject2 = ((TAVResource)localObject1).getSourceTimeRange().getStart();
    ArrayList localArrayList = new ArrayList();
    paramTAVClip = traverseTimeEffect(paramTAVClip, (TAVResource)localObject1, localArrayList, (CMTime)localObject2);
    localObject1 = ((TAVResource)localObject1).getSourceTimeRange().getEnd().sub(paramTAVClip);
    if (((CMTime)localObject1).value > 0L)
    {
      localObject2 = new TAVClipSegment(null);
      TAVClipSegment.access$102((TAVClipSegment)localObject2, new CMTimeRange(paramTAVClip, (CMTime)localObject1));
      localArrayList.add(localObject2);
    }
    AppMethodBeat.o(218694);
    return localArrayList;
  }
  
  private CMTime traverseTimeEffect(TAVClip paramTAVClip, TAVResource paramTAVResource, List<TAVClipSegment> paramList, CMTime paramCMTime)
  {
    AppMethodBeat.i(218699);
    paramTAVClip = availableTimeEffectsFromClip(paramTAVClip);
    if (paramTAVClip == null)
    {
      AppMethodBeat.o(218699);
      return paramCMTime;
    }
    paramTAVClip = paramTAVClip.iterator();
    while (paramTAVClip.hasNext())
    {
      TAVTimeEffect localTAVTimeEffect = (TAVTimeEffect)paramTAVClip.next();
      CMTime localCMTime = localTAVTimeEffect.getTimeRange().getStart().sub(paramCMTime);
      if (localCMTime.value > 0L)
      {
        TAVClipSegment localTAVClipSegment = new TAVClipSegment(null);
        TAVClipSegment.access$102(localTAVClipSegment, new CMTimeRange(paramCMTime, localCMTime));
        paramList.add(localTAVClipSegment);
      }
      paramCMTime = new TAVClipSegment(null);
      TAVClipSegment.access$102(paramCMTime, new CMTimeRange(localTAVTimeEffect.getTimeRange().getStart().add(paramTAVResource.getSourceTimeRange().getStart()), localTAVTimeEffect.getTimeRange().getDuration()));
      TAVClipSegment.access$002(paramCMTime, localTAVTimeEffect);
      paramList.add(paramCMTime);
      paramCMTime = paramCMTime.timeRange.getEnd();
    }
    AppMethodBeat.o(218699);
    return paramCMTime;
  }
  
  public List<TAVClip> build()
  {
    AppMethodBeat.i(218713);
    ArrayList localArrayList = new ArrayList();
    CMTimeRange localCMTimeRange = this.clip.getResource().getSourceTimeRange();
    if ((localCMTimeRange == null) || (localCMTimeRange.getDuration().value == 0L))
    {
      AppMethodBeat.o(218713);
      return null;
    }
    initChannelWithClip(this.clip, localArrayList);
    AppMethodBeat.o(218713);
    return localArrayList;
  }
  
  public void setClip(TAVClip paramTAVClip)
  {
    this.clip = paramTAVClip;
  }
  
  public void setTimeEffects(TAVTimeEffect[] paramArrayOfTAVTimeEffect)
  {
    this.timeEffects = paramArrayOfTAVTimeEffect;
  }
  
  static class TAVClipSegment
  {
    private TAVTimeEffect timeEffect;
    private CMTimeRange timeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVTimeEffectBuilder
 * JD-Core Version:    0.7.0.1
 */