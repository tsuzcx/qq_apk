package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

class rp$2
  implements ah.c
{
  rp$2(rp paramrp, TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener) {}
  
  public void a(pu parampu)
  {
    if (this.a != null) {
      this.a.onCameraChange(rq.a(parampu));
    }
  }
  
  public void b(pu parampu)
  {
    if (this.a != null) {
      this.a.onCameraChangeFinish(rq.a(parampu));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rp.2
 * JD-Core Version:    0.7.0.1
 */