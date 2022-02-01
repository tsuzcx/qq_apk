package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider;
import com.tencent.map.sdk.utilities.heatmap.HeatMapTileProvider.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.IAlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.IEmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IRotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.IScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ITranslateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public abstract interface TencentMapComponent
{
  public abstract IAlphaAnimation createAlphaAnimation(float paramFloat1, float paramFloat2);
  
  public abstract IAnimationSet createAnimationSet(boolean paramBoolean);
  
  public abstract IEmergeAnimation createEmergeAnimation(LatLng paramLatLng);
  
  public abstract HeatMapTileProvider createHeatMapTileProvider(HeatMapTileProvider.Builder paramBuilder);
  
  public abstract IRotateAnimation createRotateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);
  
  public abstract IScaleAnimation createScaleAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract ITranslateAnimation createTranslateAnimation(LatLng paramLatLng);
  
  public abstract <T extends Component> T getMapComponent(Class<T> paramClass);
  
  public abstract TencentMapServiceProtocol getMapServiceProtocol();
  
  public static abstract interface Component {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMapComponent
 * JD-Core Version:    0.7.0.1
 */