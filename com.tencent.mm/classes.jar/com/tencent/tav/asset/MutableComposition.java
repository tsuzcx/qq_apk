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
    AppMethodBeat.i(217655);
    setNaturalSize(new CGSize(0.0F, 0.0F));
    AppMethodBeat.o(217655);
  }
  
  private int getCorrectTrackID(int paramInt)
  {
    AppMethodBeat.i(217669);
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
        AppMethodBeat.o(217669);
        return paramInt;
      }
      if (paramInt == -1)
      {
        paramInt = this.trackIndex;
        this.trackIndex = (paramInt + 1);
        AppMethodBeat.o(217669);
        return paramInt;
      }
      if (this.trackIndex >= paramInt)
      {
        paramInt = this.trackIndex;
        this.trackIndex = (paramInt + 1);
        AppMethodBeat.o(217669);
        return paramInt;
      }
      this.trackIndex = paramInt;
      paramInt = this.trackIndex;
      AppMethodBeat.o(217669);
      return paramInt;
    }
  }
  
  public MutableCompositionTrack addMutableTrackWithMediaType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217666);
    MutableCompositionTrack localMutableCompositionTrack = new MutableCompositionTrack(paramInt1, getCorrectTrackID(paramInt2));
    localMutableCompositionTrack.setNaturalSize(getNaturalSize());
    this.tracks.add(localMutableCompositionTrack);
    this.trackCount += 1;
    AppMethodBeat.o(217666);
    return localMutableCompositionTrack;
  }
  
  public CGSize getNaturalSize()
  {
    AppMethodBeat.i(217660);
    if (this.naturalSize.equals(CGSize.CGSizeZero))
    {
      localObject = this.tracks.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CompositionTrack localCompositionTrack = (CompositionTrack)((Iterator)localObject).next();
        if (localCompositionTrack.enabled)
        {
          localObject = localCompositionTrack.getNaturalSize();
          AppMethodBeat.o(217660);
          return localObject;
        }
      }
    }
    Object localObject = this.naturalSize;
    AppMethodBeat.o(217660);
    return localObject;
  }
  
  public int getPreferRotation()
  {
    AppMethodBeat.i(217661);
    if (this.preferRotation == 0)
    {
      Iterator localIterator = this.tracks.iterator();
      while (localIterator.hasNext())
      {
        CompositionTrack localCompositionTrack = (CompositionTrack)localIterator.next();
        if (localCompositionTrack.enabled)
        {
          i = localCompositionTrack.getPreferredRotation();
          AppMethodBeat.o(217661);
          return i;
        }
      }
    }
    int i = this.preferRotation;
    AppMethodBeat.o(217661);
    return i;
  }
  
  public List<MutableCompositionTrack> getTracks()
  {
    AppMethodBeat.i(217658);
    new StringBuilder("getTracks finish, has track count: ").append(this.tracks);
    List localList = this.tracks;
    AppMethodBeat.o(217658);
    return localList;
  }
  
  public void insertEmptyTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(217663);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      ((MutableCompositionTrack)localIterator.next()).insertEmptyTimeRange(paramCMTimeRange);
    }
    AppMethodBeat.o(217663);
  }
  
  public boolean insertTimeRange(CMTimeRange paramCMTimeRange, Asset paramAsset, CMTime paramCMTime)
  {
    AppMethodBeat.i(217662);
    if ((paramCMTimeRange.getDuration().value <= 0L) || (paramAsset == null) || (paramAsset.getTrackCount() == 0))
    {
      AppMethodBeat.o(217662);
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
          AppMethodBeat.o(217662);
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
          AppMethodBeat.o(217662);
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
      AppMethodBeat.o(217662);
      return true;
    }
  }
  
  public MutableCompositionTrack mutableTrackCompatibleWithTrack(AssetTrack paramAssetTrack)
  {
    AppMethodBeat.i(217668);
    if ((paramAssetTrack != null) && (paramAssetTrack.getAsset() != null))
    {
      MutableCompositionTrack localMutableCompositionTrack = new MutableCompositionTrack(paramAssetTrack.getMediaType(), getCorrectTrackID(-1));
      localMutableCompositionTrack.insertTimeRange(paramAssetTrack.getTimeRange(), paramAssetTrack, CMTime.CMTimeZero);
      localMutableCompositionTrack.setPreferredTransform(paramAssetTrack.getPreferredTransform());
      localMutableCompositionTrack.setPreferredRotation(paramAssetTrack.getPreferredRotation());
      localMutableCompositionTrack.setPreferredVolume(paramAssetTrack.getPreferredVolume());
      AppMethodBeat.o(217668);
      return localMutableCompositionTrack;
    }
    AppMethodBeat.o(217668);
    return null;
  }
  
  public void removeTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(217664);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      ((MutableCompositionTrack)localIterator.next()).removeTimeRange(paramCMTimeRange);
    }
    AppMethodBeat.o(217664);
  }
  
  public void removeTrack(CompositionTrack paramCompositionTrack)
  {
    AppMethodBeat.i(217667);
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
    AppMethodBeat.o(217667);
  }
  
  public void scaleTimeRange(CMTimeRange paramCMTimeRange, CMTime paramCMTime)
  {
    AppMethodBeat.i(217665);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext()) {
      ((MutableCompositionTrack)localIterator.next()).scaleTimeRange(paramCMTimeRange, paramCMTime);
    }
    AppMethodBeat.o(217665);
  }
  
  public void setNaturalSize(CGSize paramCGSize)
  {
    AppMethodBeat.i(217659);
    this.naturalSize = paramCGSize;
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)localIterator.next();
      if ((localMutableCompositionTrack != null) && (localMutableCompositionTrack.getMediaType() == 1) && (localMutableCompositionTrack.getNaturalSize() == null)) {
        localMutableCompositionTrack.setNaturalSize(paramCGSize);
      }
    }
    AppMethodBeat.o(217659);
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
    AppMethodBeat.i(217656);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)localIterator.next();
      if ((localMutableCompositionTrack != null) && (localMutableCompositionTrack.getTrackID() == paramInt))
      {
        AppMethodBeat.o(217656);
        return localMutableCompositionTrack;
      }
    }
    AppMethodBeat.o(217656);
    return null;
  }
  
  public List<MutableCompositionTrack> tracksWithMediaType(int paramInt)
  {
    AppMethodBeat.i(217657);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      MutableCompositionTrack localMutableCompositionTrack = (MutableCompositionTrack)localIterator.next();
      if ((localMutableCompositionTrack != null) && (localMutableCompositionTrack.getMediaType() == paramInt)) {
        localArrayList.add(localMutableCompositionTrack);
      }
    }
    AppMethodBeat.o(217657);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.asset.MutableComposition
 * JD-Core Version:    0.7.0.1
 */