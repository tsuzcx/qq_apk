package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;

class rd$14
  implements vb.d
{
  rd$14(rd paramrd, TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener) {}
  
  public void a(ru paramru)
  {
    if (this.a != null) {
      this.a.onCameraChange(re.a(paramru));
    }
  }
  
  public void b(ru paramru)
  {
    if (this.a != null) {
      this.a.onCameraChangeFinish(re.a(paramru));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rd.14
 * JD-Core Version:    0.7.0.1
 */