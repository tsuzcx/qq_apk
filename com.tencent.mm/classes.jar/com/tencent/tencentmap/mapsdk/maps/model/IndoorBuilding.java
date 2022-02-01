package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding
  implements Cloneable
{
  private int mActiveLevelIndex;
  private String mBuidlingId;
  private String mBuildingName;
  private LatLng mLatLng;
  private List<IndoorLevel> mLevels;
  
  public IndoorBuilding(String paramString1, String paramString2, LatLng paramLatLng, List<IndoorLevel> paramList, int paramInt)
  {
    this.mBuidlingId = paramString1;
    this.mBuildingName = paramString2;
    this.mLatLng = paramLatLng;
    this.mLevels = paramList;
    this.mActiveLevelIndex = paramInt;
  }
  
  protected final Object clone()
  {
    AppMethodBeat.i(173140);
    IndoorBuilding localIndoorBuilding = (IndoorBuilding)super.clone();
    if (this.mLevels != null)
    {
      localIndoorBuilding.mLevels = new ArrayList(this.mLevels.size());
      int i = 0;
      while (i < this.mLevels.size())
      {
        localIndoorBuilding.mLevels.add(new IndoorLevel(((IndoorLevel)this.mLevels.get(i)).getName()));
        i += 1;
      }
    }
    if (this.mLatLng != null) {
      localIndoorBuilding.mLatLng = new LatLng(this.mLatLng.latitude, this.mLatLng.longitude);
    }
    AppMethodBeat.o(173140);
    return localIndoorBuilding;
  }
  
  public final int getActiveLevelIndex()
  {
    return this.mActiveLevelIndex;
  }
  
  public final String getBuidlingId()
  {
    return this.mBuidlingId;
  }
  
  public final LatLng getBuildingLatLng()
  {
    return this.mLatLng;
  }
  
  public final String getBuildingName()
  {
    return this.mBuildingName;
  }
  
  public final List<IndoorLevel> getLevels()
  {
    return this.mLevels;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(173139);
    if ((this.mBuidlingId == null) || (this.mLevels == null) || (this.mLevels.size() <= this.mActiveLevelIndex))
    {
      AppMethodBeat.o(173139);
      return "";
    }
    String str = this.mBuidlingId + "_" + ((IndoorLevel)this.mLevels.get(this.mActiveLevelIndex)).getName();
    AppMethodBeat.o(173139);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding
 * JD-Core Version:    0.7.0.1
 */