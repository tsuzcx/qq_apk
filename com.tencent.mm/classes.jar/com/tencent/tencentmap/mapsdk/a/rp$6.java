package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.TencentMap.OnIndoorStateChangeListener;

class rp$6
  implements ah.f
{
  rp$6(rp paramrp, TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener) {}
  
  public boolean a()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onIndoorBuildingFocused();
  }
  
  public boolean a(py parampy)
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onIndoorLevelActivated(rq.a(parampy));
  }
  
  public boolean d()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.onIndoorBuildingDeactivated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rp.6
 * JD-Core Version:    0.7.0.1
 */