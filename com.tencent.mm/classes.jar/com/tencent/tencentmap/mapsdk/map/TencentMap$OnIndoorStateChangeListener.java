package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.IndoorBuilding;

public abstract interface TencentMap$OnIndoorStateChangeListener
{
  public abstract boolean onIndoorBuildingDeactivated();
  
  public abstract boolean onIndoorBuildingFocused();
  
  public abstract boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener
 * JD-Core Version:    0.7.0.1
 */