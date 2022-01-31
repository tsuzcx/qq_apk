package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;

class rd$10
  implements vb.i
{
  rd$10(rd paramrd, TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener) {}
  
  public void a(sa paramsa)
  {
    if (this.a != null) {
      this.a.onMarkerDrag(rd.a(this.b, paramsa));
    }
  }
  
  public void b(sa paramsa)
  {
    if (this.a != null) {
      this.a.onMarkerDragEnd(rd.a(this.b, paramsa));
    }
  }
  
  public void c(sa paramsa)
  {
    if (this.a != null) {
      this.a.onMarkerDragStart(rd.a(this.b, paramsa));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rd.10
 * JD-Core Version:    0.7.0.1
 */