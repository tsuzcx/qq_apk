package com.tencent.tav.asset;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableComposition
  extends Composition<MutableCompositionTrack>
{
  public MutableComposition()
  {
    AppMethodBeat.i(217685);
    setNaturalSize(new CGSize(0.0F, 0.0F));
    AppMethodBeat.o(217685);
  }
  
  private int getCorrectTrackID(int paramInt)
  {
    AppMethodBeat.i(217699);
    Iterator localIterator = this.tracks.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((MutableCompositionTrack)localIterator.next()).getTrackID() != paramInt);
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (paramInt > 0))
      {
        AppMethodBeat.o(217699);
        return paramInt;
      }
      if (paramInt == -1)
      {
        paramInt = this.trackIndex;
        this.trackIndex = (paramInt + 1);
        AppMethodBeat.o(217699);
        return paramInt;
      }
      if (this.trackIndex >= paramInt)
      {
        paramInt = this.trackIndex;
        this.trackIndex = (paramInt + 1);
        AppMethodBeat.o(217699);
        return paramInt;
      }
      this.trackIndex = paramInt;
      paramInt = this.trackIndex;
      AppMethodBeat.o(217699);
      return paramInt;
    }
  }
  
  public MutableCompositionTrack addMutableTrackWithMediaType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217696);
    MutableCompositionTrack localMutableCompositionTrack = new MutableCompositionTrack(paramInt1, getCorrectTrackID(paramInt2));
    localMutableCompositionTrack.setNaturalSize(getNaturalSize());
    this.tracks.add(localMutableCompositionTrack);
    this.trackCount += 1;
    AppMethodBeat.o(217696);
    return localMutableCompositionTrack;
  }
  
  public CGSize getNaturalSize()
  {
    AppMethodBeat.i(217690);
    if (this.naturalSize.equals(CGSize.CGSizeZero))
    {
      localObject = this.tracks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CompositionTrack localCompositionTrack = (CompositionTrack)((Iterator)localObject).next();
        if (localCompositionTrack.enabled)
        {
          localObject = localCompositionTrack.getNaturalSize();
          AppMethodBeat.o(217690);
          return localObject;
        }
      }
    }
    Object localObject = this.naturalSize;
    AppMethodBeat.o(217690);
    return localObject;
  }
  
  public int getPreferRotation()
  {
    AppMethodBeat.i(217691);
    if (this.preferRotation == 0)
    {
      Iterator localIterator = this.tracks.iterator();
      while (localIterator.hasNext())
      {
        CompositionTrack localCompositionTrack = (CompositionTrack)localIterator.next();
        if (localCompositionTrack.enabled)
        {
          i = localCompositionTrack.getPreferredRotation();
          AppMethodBeat.o(217691);
          return i;
        }
      }
    }
    int i = this.preferRotation;
    AppMethodBeat.o(217691);
    return i;
  }
  
  public List<MutableCompositionTrack> getTracks()
  {
    AppMethodBeat.i(217688);
    new StringBuilder("getTracks finish, has track count: ").append(this.tracks);
    List localList = this.tracks;
    AppMethodBeat.o(217688);
    return localList;
  }
  
  public void insertEmptyTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(217693);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      ((MutableCompositionTrack)localIterator.next()).insertEmptyTimeRange(paramCMTimeRange);
    }
    AppMethodBeat.o(217693);
  }
  
  public boolean insertTimeRange(CMTimeRange paramCMTimeRange, Asset paramAsset, CMTime paramCMTime)
  {
    AppMethodBeat.i(217692);
    if ((paramCMTimeRange.getDuration().value <= 0L) || (paramAsset == null) || (paramAsset.getTrackCount() == 0))
    {
      AppMethodBeat.o(217692);
      return false;
    }
    Object localObject = paramAsset.getTracks();
    paramAsset = new ArrayList();
    int i = 0;
    AssetTrack localAssetTrack;
    label82:
    MutableCompositionTrack localMutableCompositionTrack;
    if (i < ((List)localObject).size())
    {
      localAssetTrack = (AssetTrack)((List)localObject).get(i);
      j = i;
      if (j >= this.tracks.size()) {
        break label313;
      }
      localMutableCompositionTrack = (MutableCompositionTrack)this.tracks.get(j);
      if (localMutableCompositionTrack.getMediaType() == localAssetTrack.getMediaType())
      {
        if (!localMutableCompositionTrack.insertTimeRange(paramCMTimeRange, localAssetTrack, paramCMTime))
        {
          AppMethodBeat.o(217692);
          return false;
        }
        paramAsset.add(Integer.valueOf(localMutableCompositionTrack.getTrackID()));
      }
    }
    label313:
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        j = localAssetTrack.getMediaType();
        int k = this.trackIndex;
        this.trackIndex = (k + 1);
        localMutableCompositionTrack = addMutableTrackWithMediaType(j, k);
        if (!localMutableCompositionTrack.insertTimeRange(paramCMTimeRange, localAssetTrack, paramCMTime))
        {
          AppMethodBeat.o(217692);
          return false;
          j += 1;
          break label82;
        }
        paramAsset.add(Integer.valueOf(localMutableCompositionTrack.getTrackID()));
      }
      i += 1;
      break;
      paramCMTime = this.tracks.iterator();
      while (paramCMTime.hasNext())
      {
        localObject = (MutableCompositionTrack)paramCMTime.next();
        if (!paramAsset.contains(Integer.valueOf(((MutableCompositionTrack)localObject).getTrackID()))) {
          ((MutableCompositionTrack)localObject).insertEmptyTimeRange(paramCMTimeRange);
        }
      }
      AppMethodBeat.o(217692);
      return true;
    }
  }
  
  public MutableCompositionTrack mutableTrackCompatibleWithTrack(AssetTrack paramAssetTrack)
  {
    AppMethodBeat.i(217698);
    if ((paramAssetTrack != null) && (paramAssetTrack.getAsset() != null))
    {
      MutableCompositionTrack localMutableCompositionTrack = new MutableCompositionTrack(paramAssetTrack.getMediaType(), getCorrectTrackID(-1));
      localMutableCompositionTrack.insertTimeRange(paramAssetTrack.getTimeRange(), paramAssetTrack, CMTime.CMTimeZero);
      localMutableCompositionTrack.setPreferredTransform(paramAssetTrack.getPreferredTransform());
      localMutableCompositionTrack.setPreferredRotation(paramAssetTrack.getPreferredRotation());
      localMutableCompositionTrack.setPreferredVolume(paramAssetTrack.getPreferredVolume());
      AppMethodBeat.o(217698);
      return localMutableCompositionTrack;
    }
    AppMethodBeat.o(217698);
    return null;
  }
  
  public void removeTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(217694);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      ((MutableCompositionTrack)localIterator.next()).removeTimeRange(paramCMTimeRange);
    }
    AppMethodBeat.o(217694);
  }
  
  public void removeTrack(CompositionTrack paramCompositionTrack)
  {
    AppMethodBeat.i(217697);
    int j;
    for (int i = 0; i < this.tracks.size(); i = j + 1)
    {
      j = i;
      if ((MutableCompositionTrack)this.tracks.get(i) == paramCompositionTrack)
      {
        this.tracks.remove(i);
        j = i - 1;
      }
    }
    AppMethodBeat.o(217697);
  }
  
  public void scaleTimeRange(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    AppMethodBeat.i(217695);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      ((MutableCompositionTrack)localIterator.next()).scaleTimeRange(paramCMTimeRange, paramCMTime);
    }
    AppMethodBeat.o(217695);
  }
  
  public void setNaturalSize(CGSize paramCGSize)
  {
    AppMethodBeat.i(217689);
    this.naturalSize = paramCGSize;
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)localIterator.next();
      if ((localMutableCompositionTrack != null) && (localMutableCompositionTrack.getMediaType() == 1) && (localMutableCompositionTrack.getNaturalSize() == null)) {
        localMutableCompositionTrack.setNaturalSize(paramCGSize);
      }
    }
    AppMethodBeat.o(217689);
  }
  
  public void setPreferRotation(int paramInt)
  {
    this.preferRotation = paramInt;
  }
  
  public void setPreferredVolume(float paramFloat)
  {
    this.preferredVolume = paramFloat;
  }
  
  public MutableCompositionTrack trackWithTrackID(int paramInt)
  {
    AppMethodBeat.i(217686);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)localIterator.next();
      if ((localMutableCompositionTrack != null) && (localMutableCompositionTrack.getTrackID() == paramInt))
      {
        AppMethodBeat.o(217686);
        return localMutableCompositionTrack;
      }
    }
    AppMethodBeat.o(217686);
    return null;
  }
  
  public List<MutableCompositionTrack> tracksWithMediaType(int paramInt)
  {
    AppMethodBeat.i(217687);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)localIterator.next();
      if ((localMutableCompositionTrack != null) && (localMutableCompositionTrack.getMediaType() == paramInt)) {
        localArrayList.add(localMutableCompositionTrack);
      }
    }
    AppMethodBeat.o(217687);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.asset.MutableComposition
 * JD-Core Version:    0.7.0.1
 */