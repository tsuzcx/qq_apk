package com.tencent.tencentmap.mapsdk.maps;

import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import java.util.List;

public abstract interface TencentMapNavi
  extends TencentMap
{
  public abstract IntersectionOverlay addIntersectionEnlargeOverlay(IntersectionOverlayOptions paramIntersectionOverlayOptions);
  
  public abstract void addSegmentsWithRouteName(List<MapRouteSection> paramList, List<LatLng> paramList1);
  
  public abstract void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2);
  
  public abstract void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean);
  
  public abstract void animateToNaviPosition2(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean);
  
  public abstract float calNaviLevel(LatLngBounds paramLatLngBounds, float paramFloat, int paramInt, boolean paramBoolean);
  
  public abstract float calNaviLevel2(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean);
  
  public abstract float calNaviLevel3(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public abstract CameraPosition calculateZoomToSpanLevelAsync(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TencentMap.AsyncOperateCallback<CameraPosition> paramAsyncOperateCallback);
  
  public abstract void clearRouteNameSegments();
  
  public abstract boolean isNaviStateEnabled();
  
  public abstract void moveToNavPosition(CameraUpdate paramCameraUpdate, LatLng paramLatLng);
  
  public abstract void setNavCenter(int paramInt1, int paramInt2);
  
  public abstract void setNaviFixingProportion(float paramFloat1, float paramFloat2);
  
  public abstract void setNaviFixingProportion2D(float paramFloat1, float paramFloat2);
  
  public abstract void setNaviStateEnabled(boolean paramBoolean);
  
  public abstract void setOptionalResourcePath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMapNavi
 * JD-Core Version:    0.7.0.1
 */