package com.tencent.tav.asset;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tav.decoder.ImageDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableCompositionTrack
  extends CompositionTrack
{
  private String extendedLanguageTag;
  private String languageCode;
  
  MutableCompositionTrack(int paramInt1, int paramInt2)
  {
    this.mediaType = paramInt1;
    this.trackID = paramInt2;
  }
  
  private int findSegmentIndexAt(CMTime paramCMTime, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(197434);
    CMTime localCMTime = CMTime.CMTimeZero;
    Iterator localIterator = this.segments.iterator();
    int i = 0;
    int j = k;
    CompositionTrackSegment localCompositionTrackSegment;
    if (localIterator.hasNext())
    {
      localCompositionTrackSegment = (CompositionTrackSegment)localIterator.next();
      if (localCompositionTrackSegment.timeRange.containsTime(paramCMTime)) {
        j = 1;
      }
    }
    else
    {
      if ((j != 0) || (!paramCMTime.equalsTo(localCMTime)) || (i <= 0) || (!paramBoolean)) {
        break label132;
      }
      j = 1;
      i -= 1;
    }
    label132:
    for (;;)
    {
      if (j != 0)
      {
        AppMethodBeat.o(197434);
        return i;
        localCMTime = localCompositionTrackSegment.timeRange.getEnd();
        i += 1;
        break;
      }
      AppMethodBeat.o(197434);
      return -1;
    }
  }
  
  private CMTime getSegmentStartCMTime(int paramInt)
  {
    AppMethodBeat.i(197436);
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while ((i < paramInt) && (i < this.segments.size()))
    {
      localCMTime = localCMTime.add(((CompositionTrackSegment)this.segments.get(i)).getScaleDuration());
      i += 1;
    }
    AppMethodBeat.o(197436);
    return localCMTime;
  }
  
  private long getSegmentStartTime(int paramInt)
  {
    AppMethodBeat.i(197435);
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while ((i < paramInt) && (i < this.segments.size()))
    {
      localCMTime = localCMTime.add(((CompositionTrackSegment)this.segments.get(i)).getScaleDuration());
      i += 1;
    }
    long l = localCMTime.getTimeUs();
    AppMethodBeat.o(197435);
    return l;
  }
  
  private void insertSegment(CompositionTrackSegment paramCompositionTrackSegment, int paramInt)
  {
    AppMethodBeat.i(197430);
    if (paramInt >= 0) {
      this.segments.add(paramInt, paramCompositionTrackSegment);
    }
    for (;;)
    {
      updateTimeRange();
      AppMethodBeat.o(197430);
      return;
      this.segments.add(paramCompositionTrackSegment);
    }
  }
  
  private void insertTimeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, AssetTrack paramAssetTrack, int paramInt)
  {
    AppMethodBeat.i(197429);
    if ((paramAssetTrack instanceof CompositionTrack))
    {
      insertTimeRange(paramCMTimeRange1, paramCMTimeRange2, (CompositionTrack)paramAssetTrack, paramInt);
      AppMethodBeat.o(197429);
      return;
    }
    if (paramAssetTrack != null)
    {
      paramCMTimeRange1 = new CompositionTrackSegment(paramAssetTrack.getSourcePath(), paramAssetTrack.getTrackID(), paramCMTimeRange1, paramCMTimeRange2, paramAssetTrack.getMediaType());
      if (paramInt < 0) {
        break label95;
      }
      this.segments.add(paramInt, paramCMTimeRange1);
    }
    for (;;)
    {
      updateTimeRange();
      AppMethodBeat.o(197429);
      return;
      paramCMTimeRange1 = new CompositionTrackSegment(paramCMTimeRange2);
      break;
      label95:
      this.segments.add(paramCMTimeRange1);
    }
  }
  
  private void insertTimeRange(CMTimeRange paramCMTimeRange1, CMTimeRange paramCMTimeRange2, CompositionTrack paramCompositionTrack, int paramInt)
  {
    AppMethodBeat.i(197431);
    CMTime localCMTime2 = paramCMTimeRange1.getStart();
    CMTime localCMTime1 = paramCMTimeRange1.getEnd();
    Object localObject1 = paramCMTimeRange2.getStart();
    float f = (float)paramCMTimeRange2.getDurationUs() * 1.0F / (float)paramCMTimeRange1.getDurationUs();
    Iterator localIterator = paramCompositionTrack.getSegments().iterator();
    paramCMTimeRange2 = (CMTimeRange)localObject1;
    while (localIterator.hasNext())
    {
      CompositionTrackSegment localCompositionTrackSegment = (CompositionTrackSegment)localIterator.next();
      paramCompositionTrack = localCompositionTrackSegment.getTimeMapping().getTarget();
      Object localObject2 = paramCompositionTrack.getStart();
      CMTime localCMTime3 = paramCompositionTrack.getEnd();
      paramCompositionTrack = ((CMTime)localObject2).clone();
      localObject1 = localCMTime3.clone();
      if (((CMTime)localObject2).smallThan(localCMTime2))
      {
        paramCompositionTrack = paramCMTimeRange1.getStart();
        label123:
        if (!localCMTime3.smallThan(localCMTime2)) {
          break label329;
        }
        localObject1 = CMTime.CMTimeInvalid;
      }
      for (;;)
      {
        if ((paramCompositionTrack.equalsTo((CMTime)localObject1)) || (paramCompositionTrack == CMTime.CMTimeInvalid) || (localObject1 == CMTime.CMTimeInvalid)) {
          break label344;
        }
        localObject2 = paramCompositionTrack.sub((CMTime)localObject2);
        localObject1 = ((CMTime)localObject1).sub(paramCompositionTrack);
        paramCompositionTrack = ((CMTime)localObject1).multi(f);
        localObject1 = new CMTimeRange(localCompositionTrackSegment.timeMapping.getSource().getStart().add(((CMTime)localObject2).divide((float)localCompositionTrackSegment.timeMapping.getTarget().getDurationUs() * 1.0F / (float)localCompositionTrackSegment.timeMapping.getSource().getDurationUs())), (CMTime)localObject1);
        localObject2 = new CMTimeRange(paramCMTimeRange2, paramCompositionTrack);
        paramCMTimeRange2 = paramCMTimeRange2.add(paramCompositionTrack);
        paramCompositionTrack = new CompositionTrackSegment(localCompositionTrackSegment.getSourcePath(), this.trackID, (CMTimeRange)localObject1, (CMTimeRange)localObject2, localCompositionTrackSegment.getSourceType());
        if (paramInt < 0) {
          break label346;
        }
        this.segments.add(paramInt, paramCompositionTrack);
        paramInt += 1;
        break;
        if (!((CMTime)localObject2).bigThan(localCMTime1)) {
          break label123;
        }
        paramCompositionTrack = CMTime.CMTimeInvalid;
        break label123;
        label329:
        if (localCMTime3.bigThan(localCMTime1)) {
          localObject1 = localCMTime1;
        }
      }
      label344:
      continue;
      label346:
      this.segments.add(paramCompositionTrack);
    }
    updateTimeRange();
    AppMethodBeat.o(197431);
  }
  
  private CompositionTrackSegment[] split(CompositionTrackSegment paramCompositionTrackSegment, CMTime paramCMTime)
  {
    AppMethodBeat.i(197437);
    if ((paramCompositionTrackSegment != null) && (!paramCompositionTrackSegment.timeRange.getDuration().smallThan(paramCMTime)))
    {
      float f = (float)paramCMTime.getTimeUs() * 1.0F / (float)paramCompositionTrackSegment.timeRange.getDurationUs();
      Object localObject = paramCompositionTrackSegment.getTimeMapping().getTarget().split(f);
      CMTimeRange[] arrayOfCMTimeRange = paramCompositionTrackSegment.getTimeMapping().getSource().split(f);
      if ((localObject != null) && (arrayOfCMTimeRange != null))
      {
        CompositionTrackSegment localCompositionTrackSegment = new CompositionTrackSegment(paramCompositionTrackSegment.getSourcePath(), paramCompositionTrackSegment.getSourceTrackID(), arrayOfCMTimeRange[0], localObject[0], paramCompositionTrackSegment.getSourceType());
        localObject = new CompositionTrackSegment(paramCompositionTrackSegment.getSourcePath(), paramCompositionTrackSegment.getSourceTrackID(), arrayOfCMTimeRange[1], localObject[1], paramCompositionTrackSegment.getSourceType());
        localCompositionTrackSegment.scaleDuration = paramCMTime;
        ((CompositionTrackSegment)localObject).scaleDuration = paramCompositionTrackSegment.scaleDuration.sub(paramCMTime);
        AppMethodBeat.o(197437);
        return new CompositionTrackSegment[] { localCompositionTrackSegment, localObject };
      }
    }
    AppMethodBeat.o(197437);
    return null;
  }
  
  private void updateSegmentStartTimeAfterInserted(CMTime paramCMTime, CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197432);
    int i = findSegmentIndexAt(paramCMTime, false);
    if ((i >= 0) && (i < this.segments.size()))
    {
      i += 1;
      while (i < this.segments.size())
      {
        paramCMTime = (CompositionTrackSegment)this.segments.get(i);
        CMTimeRange localCMTimeRange = paramCMTime.getTimeMapping().getTarget();
        paramCMTime.updateTargetTimeRange(new CMTimeRange(localCMTimeRange.getStart().add(paramCMTimeRange.getDuration()), localCMTimeRange.getDuration().clone()));
        i += 1;
      }
    }
    AppMethodBeat.o(197432);
  }
  
  private void updateSegmentsStartTimeAfterRemoved(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197433);
    int i = findSegmentIndexAt(paramCMTimeRange.getStart(), false);
    if ((i >= 0) && (i < this.segments.size())) {
      while (i < this.segments.size())
      {
        CompositionTrackSegment localCompositionTrackSegment = (CompositionTrackSegment)this.segments.get(i);
        CMTimeRange localCMTimeRange = localCompositionTrackSegment.getTimeMapping().getTarget();
        localCompositionTrackSegment.updateTargetTimeRange(new CMTimeRange(localCMTimeRange.getStart().sub(paramCMTimeRange.getDuration().add(CMTime.CMTimeOne).add(CMTime.CMTimeOne)), localCMTimeRange.getDuration().clone()));
        i += 1;
      }
    }
    AppMethodBeat.o(197433);
  }
  
  private void updateTimeRange()
  {
    AppMethodBeat.i(197428);
    if ((this.segments != null) && (this.segments.size() > 0))
    {
      this.timeRange = new CMTimeRange(((CompositionTrackSegment)this.segments.get(0)).timeRange.getStart(), getDuration());
      AppMethodBeat.o(197428);
      return;
    }
    CMTime localCMTime = CMTime.CMTimeZero;
    this.timeRange = new CMTimeRange(localCMTime, localCMTime);
    AppMethodBeat.o(197428);
  }
  
  public void clipRangeAndRemoveOutRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197427);
    if ((paramCMTimeRange == null) || (paramCMTimeRange.getDuration().getTimeUs() <= 0L) || (this.segments == null) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(197427);
      return;
    }
    Object localObject1 = paramCMTimeRange.getStart();
    Object localObject2 = paramCMTimeRange.getEnd();
    int k = findSegmentIndexAt((CMTime)localObject1, false);
    if (k == -1)
    {
      AppMethodBeat.o(197427);
      return;
    }
    int i = findSegmentIndexAt((CMTime)localObject2, false);
    if (i == -1) {
      i = this.segments.size() - 1;
    }
    label409:
    for (;;)
    {
      long l1 = getSegmentStartTime(k);
      long l2 = getSegmentStartTime(i);
      localObject1 = (CompositionTrackSegment)this.segments.get(k);
      localObject2 = (CompositionTrackSegment)this.segments.get(i);
      l2 = paramCMTimeRange.getEnd().getTimeUs() - l2;
      float f = (float)(((CompositionTrackSegment)localObject2).scaleDuration.getTimeUs() / ((CompositionTrackSegment)localObject2).timeRange.getDuration().getTimeUs());
      ((CompositionTrackSegment)localObject2).timeRange = new CMTimeRange(((CompositionTrackSegment)localObject2).timeRange.getStart(), TimeUtil.us2CMTime((f * (float)l2)));
      ((CompositionTrackSegment)localObject2).scaleDuration = TimeUtil.us2CMTime(l2);
      f = (float)(((CompositionTrackSegment)localObject1).scaleDuration.getTimeUs() / ((CompositionTrackSegment)localObject1).timeRange.getDuration().getTimeUs());
      l1 = paramCMTimeRange.getStart().getTimeUs() - l1;
      l2 = (f * (float)l1);
      ((CompositionTrackSegment)localObject1).timeRange = new CMTimeRange(TimeUtil.us2CMTime(((CompositionTrackSegment)localObject1).timeRange.getStart().getTimeUs() + l2), TimeUtil.us2CMTime(((CompositionTrackSegment)localObject1).timeRange.getDuration().getTimeUs() - l2));
      ((CompositionTrackSegment)localObject1).scaleDuration = TimeUtil.us2CMTime(((CompositionTrackSegment)localObject1).scaleDuration.getTimeUs() - l1);
      int j = this.segments.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if ((j > i) || (j < k)) {
            this.segments.remove(j);
          }
          j -= 1;
          continue;
          if (getSegmentStartTime(i) != ((CMTime)localObject2).getTimeUs()) {
            break label409;
          }
          i -= 1;
          break;
        }
      }
      AppMethodBeat.o(197427);
      return;
    }
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(197421);
    CMTime localCMTime = CMTime.CMTimeZero;
    int i = 0;
    while (i < this.segments.size())
    {
      localCMTime = localCMTime.add(((CompositionTrackSegment)this.segments.get(i)).getScaleDuration());
      i += 1;
    }
    AppMethodBeat.o(197421);
    return localCMTime;
  }
  
  public String getExtendedLanguageTag()
  {
    return this.extendedLanguageTag;
  }
  
  public String getLanguageCode()
  {
    return this.languageCode;
  }
  
  public void insertCompositionTrackSegment(CompositionTrackSegment paramCompositionTrackSegment)
  {
    AppMethodBeat.i(197423);
    if (((this.naturalSize == null) || (this.naturalSize.equals(CGSize.CGSizeZero))) && (paramCompositionTrackSegment.getSourceType() == 3) && (!TextUtils.isEmpty(paramCompositionTrackSegment.getSourcePath()))) {
      this.naturalSize = ImageDecoder.getDefaultOutputImageSize(paramCompositionTrackSegment.getSourcePath());
    }
    Object localObject2 = paramCompositionTrackSegment.timeMapping.getTarget();
    Object localObject1 = ((CMTimeRange)localObject2).getStart();
    if (this.segments.size() == 0)
    {
      if (((CMTimeRange)localObject2).getStart().value > 0L) {
        this.segments.add(new CompositionTrackSegment(new CMTimeRange(CMTime.CMTimeZero, ((CMTimeRange)localObject2).getStart())));
      }
      insertSegment(paramCompositionTrackSegment, -1);
      AppMethodBeat.o(197423);
      return;
    }
    int i = findSegmentIndexAt((CMTime)localObject1, false);
    if (i != -1)
    {
      localObject2 = getSegmentStartCMTime(i);
      if (((CMTime)localObject1).equalsTo((CMTime)localObject2)) {
        insertSegment(paramCompositionTrackSegment, i);
      }
    }
    for (;;)
    {
      paramCompositionTrackSegment = CMTime.CMTimeZero;
      localObject1 = this.segments.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CompositionTrackSegment)((Iterator)localObject1).next();
        ((CompositionTrackSegment)localObject2).updateTargetTimeRange(new CMTimeRange(paramCompositionTrackSegment, ((CompositionTrackSegment)localObject2).scaleDuration));
        paramCompositionTrackSegment = paramCompositionTrackSegment.add(((CompositionTrackSegment)localObject2).scaleDuration);
      }
      localObject1 = split((CompositionTrackSegment)this.segments.remove(i), ((CMTime)localObject1).sub((CMTime)localObject2));
      if (localObject1[1].scaleDuration.getTimeUs() > 0L) {
        this.segments.add(i, localObject1[1]);
      }
      insertSegment(paramCompositionTrackSegment, i);
      if (localObject1[0].scaleDuration.getTimeUs() > 0L)
      {
        this.segments.add(i, localObject1[0]);
        continue;
        localObject2 = getSegmentStartCMTime(this.segments.size());
        if (((CMTime)localObject1).bigThan((CMTime)localObject2)) {
          this.segments.add(new CompositionTrackSegment(new CMTimeRange((CMTime)localObject2, ((CMTime)localObject1).sub((CMTime)localObject2))));
        }
        insertSegment(paramCompositionTrackSegment, -1);
      }
    }
    updateTimeRange();
    AppMethodBeat.o(197423);
  }
  
  public void insertEmptyTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197424);
    insertTimeRange(paramCMTimeRange, null, paramCMTimeRange.getStart());
    AppMethodBeat.o(197424);
  }
  
  public boolean insertTimeRange(CMTimeRange paramCMTimeRange, AssetTrack paramAssetTrack, CMTime paramCMTime)
  {
    AppMethodBeat.i(197422);
    if (this.timeRange == null)
    {
      localObject = CMTime.CMTimeZero;
      this.timeRange = new CMTimeRange((CMTime)localObject, (CMTime)localObject);
    }
    if (((this.naturalSize == null) || (this.naturalSize.equals(CGSize.CGSizeZero))) && (paramAssetTrack != null)) {
      this.naturalSize = paramAssetTrack.naturalSize;
    }
    if ((this.preferredRotation == 0) && (paramAssetTrack != null)) {
      this.preferredRotation = paramAssetTrack.preferredRotation;
    }
    if ((paramCMTime == CMTime.CMTimeInvalid) || (paramCMTime.getValue() < 0L))
    {
      insertTimeRange(paramCMTimeRange, new CMTimeRange(this.timeRange.getDuration(), paramCMTimeRange.getDuration()), paramAssetTrack, -1);
      AppMethodBeat.o(197422);
      return true;
    }
    if (paramCMTimeRange.getDuration().value <= 0L)
    {
      AppMethodBeat.o(197422);
      return false;
    }
    Object localObject = new CMTimeRange(paramCMTime, paramCMTimeRange.getDuration());
    if (this.segments.size() == 0)
    {
      if (paramCMTime.value > 0L) {
        this.segments.add(new CompositionTrackSegment(new CMTimeRange(CMTime.CMTimeZero, paramCMTime)));
      }
      insertTimeRange(paramCMTimeRange, (CMTimeRange)localObject, paramAssetTrack, -1);
      AppMethodBeat.o(197422);
      return true;
    }
    int i = findSegmentIndexAt(paramCMTime, false);
    CMTime localCMTime;
    if (i != -1)
    {
      localCMTime = getSegmentStartCMTime(i);
      if (paramCMTime.equalsTo(localCMTime)) {
        insertTimeRange(paramCMTimeRange, (CMTimeRange)localObject, paramAssetTrack, i);
      }
    }
    for (;;)
    {
      updateTimeRange();
      AppMethodBeat.o(197422);
      return true;
      paramCMTime = split((CompositionTrackSegment)this.segments.remove(i), paramCMTime.sub(localCMTime));
      if (paramCMTime[1].scaleDuration.getTimeUs() > 0L) {
        this.segments.add(i, paramCMTime[1]);
      }
      insertTimeRange(paramCMTimeRange, paramCMTimeRange, paramAssetTrack, i);
      if (paramCMTime[0].scaleDuration.getTimeUs() > 0L)
      {
        this.segments.add(i, paramCMTime[0]);
        continue;
        localCMTime = getSegmentStartCMTime(this.segments.size());
        if (paramCMTime.bigThan(localCMTime)) {
          this.segments.add(new CompositionTrackSegment(new CMTimeRange(localCMTime, paramCMTime.sub(localCMTime))));
        }
        insertTimeRange(paramCMTimeRange, (CMTimeRange)localObject, paramAssetTrack, -1);
      }
    }
  }
  
  public void removeTimeRange(CMTimeRange paramCMTimeRange)
  {
    int i = 0;
    AppMethodBeat.i(197425);
    if ((paramCMTimeRange == null) || (!paramCMTimeRange.isLegal()))
    {
      AppMethodBeat.o(197425);
      return;
    }
    insertEmptyTimeRange(new CMTimeRange(paramCMTimeRange.getStart(), CMTime.CMTimeOne));
    insertEmptyTimeRange(new CMTimeRange(paramCMTimeRange.getEnd().add(CMTime.CMTimeOne), CMTime.CMTimeOne));
    int j = findSegmentIndexAt(paramCMTimeRange.getStart(), false);
    int k = findSegmentIndexAt(paramCMTimeRange.getEnd().add(CMTime.CMTimeOne), false);
    ArrayList localArrayList = new ArrayList();
    while (i < this.segments.size())
    {
      if ((i < j) || (i > k)) {
        localArrayList.add(this.segments.get(i));
      }
      i += 1;
    }
    this.segments = localArrayList;
    updateTimeRange();
    updateSegmentsStartTimeAfterRemoved(paramCMTimeRange);
    AppMethodBeat.o(197425);
  }
  
  public void scaleTimeRange(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    AppMethodBeat.i(197426);
    Object localObject3 = paramCMTimeRange.getStart();
    Object localObject2 = paramCMTimeRange.getEnd();
    if ((paramCMTimeRange.getDuration().getTimeUs() <= 0L) || (this.segments == null) || (this.segments.size() == 0))
    {
      AppMethodBeat.o(197426);
      return;
    }
    int j = findSegmentIndexAt(paramCMTimeRange.getStart(), false);
    if (j == -1)
    {
      AppMethodBeat.o(197426);
      return;
    }
    int i = findSegmentIndexAt(paramCMTimeRange.getEnd(), false);
    if (i == -1) {
      i = this.segments.size() - 1;
    }
    label821:
    for (;;)
    {
      CMTime localCMTime;
      Object localObject1;
      if (j == i)
      {
        localCMTime = getSegmentStartCMTime(j);
        localObject1 = (CompositionTrackSegment)this.segments.remove(j);
        paramCMTimeRange = (CMTimeRange)localObject1;
        if (((CMTime)localObject2).smallThan(localCMTime.add(((CompositionTrackSegment)localObject1).scaleDuration)))
        {
          localObject2 = split((CompositionTrackSegment)localObject1, ((CMTime)localObject3).sub(localCMTime));
          localObject1 = localObject2[0];
          paramCMTimeRange = (CMTimeRange)localObject1;
          if (localObject2[1].scaleDuration.getTimeUs() > 0L)
          {
            this.segments.add(j, localObject2[1]);
            paramCMTimeRange = (CMTimeRange)localObject1;
          }
        }
        if (((CMTime)localObject3).bigThan(localCMTime))
        {
          paramCMTimeRange = split(paramCMTimeRange, ((CMTime)localObject3).sub(localCMTime));
          paramCMTimeRange[1].scaleDuration = paramCMTime;
          if (paramCMTimeRange[1].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(j, paramCMTimeRange[1]);
          }
          if (paramCMTimeRange[0].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(j, paramCMTimeRange[0]);
          }
        }
      }
      for (;;)
      {
        paramCMTimeRange = CMTime.CMTimeZero;
        paramCMTime = this.segments.iterator();
        while (paramCMTime.hasNext())
        {
          localObject1 = (CompositionTrackSegment)paramCMTime.next();
          ((CompositionTrackSegment)localObject1).updateTargetTimeRange(new CMTimeRange(paramCMTimeRange, ((CompositionTrackSegment)localObject1).scaleDuration));
          paramCMTimeRange = paramCMTimeRange.add(((CompositionTrackSegment)localObject1).scaleDuration);
        }
        if (!getSegmentStartCMTime(i).equalsTo(paramCMTimeRange.getEnd())) {
          break label821;
        }
        i -= 1;
        break;
        paramCMTimeRange.scaleDuration = paramCMTime;
        this.segments.add(j, paramCMTimeRange);
        continue;
        localObject1 = getSegmentStartCMTime(j);
        localCMTime = getSegmentStartCMTime(i);
        if (((CMTime)localObject3).bigThan((CMTime)localObject1))
        {
          localObject3 = split((CompositionTrackSegment)this.segments.remove(j), ((CMTime)localObject3).sub((CMTime)localObject1));
          localObject3[1].scaleDuration = paramCMTime.multi(localObject3[1].scaleDuration).divide(paramCMTimeRange.getDuration());
          localObject1 = paramCMTime.sub(localObject3[1].scaleDuration);
          if (localObject3[1].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(j, localObject3[1]);
          }
          paramCMTime = (CMTime)localObject1;
          if (localObject3[0].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(j, localObject3[0]);
          }
        }
        for (paramCMTime = (CMTime)localObject1;; paramCMTime = paramCMTime.sub(((CompositionTrackSegment)localObject1).scaleDuration))
        {
          j += 1;
          while (j < i)
          {
            localObject1 = (CompositionTrackSegment)this.segments.get(j);
            ((CompositionTrackSegment)localObject1).scaleDuration = paramCMTime.multi(((CompositionTrackSegment)localObject1).scaleDuration).divide(paramCMTimeRange.getDuration());
            paramCMTime = paramCMTime.sub(((CompositionTrackSegment)localObject1).scaleDuration);
            j += 1;
          }
          localObject1 = (CompositionTrackSegment)this.segments.get(j);
          ((CompositionTrackSegment)localObject1).scaleDuration = paramCMTime.multi(((CompositionTrackSegment)localObject1).scaleDuration).divide(paramCMTimeRange.getDuration());
        }
        paramCMTimeRange = (CompositionTrackSegment)this.segments.get(i);
        if (((CMTime)localObject2).smallThan(localCMTime.add(paramCMTimeRange.scaleDuration)))
        {
          paramCMTimeRange = split((CompositionTrackSegment)this.segments.remove(i), ((CMTime)localObject2).sub(localCMTime));
          paramCMTimeRange[0].scaleDuration = paramCMTime;
          if (paramCMTimeRange[1].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(i, paramCMTimeRange[1]);
          }
          if (paramCMTimeRange[0].scaleDuration.getTimeUs() > 0L) {
            this.segments.add(i, paramCMTimeRange[0]);
          }
        }
        else
        {
          paramCMTimeRange.scaleDuration = paramCMTime;
        }
      }
      updateTimeRange();
      AppMethodBeat.o(197426);
      return;
    }
  }
  
  public void setExtendedLanguageTag(String paramString)
  {
    this.extendedLanguageTag = paramString;
  }
  
  public void setLanguageCode(String paramString)
  {
    this.languageCode = paramString;
  }
  
  void setNaturalSize(CGSize paramCGSize)
  {
    this.naturalSize = paramCGSize;
  }
  
  public void setNaturalTimeScale(int paramInt)
  {
    this.naturalTimeScale = paramInt;
  }
  
  public void setPreferredTransform(Matrix paramMatrix)
  {
    this.preferredTransform = paramMatrix;
  }
  
  public void setPreferredVolume(float paramFloat)
  {
    this.preferredVolume = paramFloat;
  }
  
  public void setSegments(List<CompositionTrackSegment> paramList)
  {
    this.segments = paramList;
  }
  
  public boolean validateTrackSegments(List<CompositionTrackSegment> paramList)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.asset.MutableCompositionTrack
 * JD-Core Version:    0.7.0.1
 */