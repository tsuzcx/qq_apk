package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

class rd$9
  implements vb.a
{
  rd$9(rd paramrd, TencentMap.InfoWindowAdapter paramInfoWindowAdapter) {}
  
  public View a(sa paramsa)
  {
    if (this.a != null) {
      return this.a.getInfoWindow(rd.a(this.b, paramsa));
    }
    return null;
  }
  
  public void a(sa paramsa, View paramView)
  {
    if (this.a != null) {
      this.a.onInfoWindowDettached(rd.a(this.b, paramsa), paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rd.9
 * JD-Core Version:    0.7.0.1
 */