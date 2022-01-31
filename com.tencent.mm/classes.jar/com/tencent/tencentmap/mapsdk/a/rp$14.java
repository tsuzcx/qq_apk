package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;

class rp$14
  implements ah.m
{
  rp$14(rp paramrp, TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener) {}
  
  public void a(qf paramqf)
  {
    if (this.a != null) {
      this.a.onMarkerDragStart(rp.a(this.b, paramqf));
    }
  }
  
  public void b(qf paramqf)
  {
    if (this.a != null) {
      this.a.onMarkerDrag(rp.a(this.b, paramqf));
    }
  }
  
  public void c(qf paramqf)
  {
    if (this.a != null) {
      this.a.onMarkerDragEnd(rp.a(this.b, paramqf));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rp.14
 * JD-Core Version:    0.7.0.1
 */