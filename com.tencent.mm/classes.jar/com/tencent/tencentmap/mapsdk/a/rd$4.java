package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;

class rd$4
  implements vb.j
{
  rd$4(rd paramrd, TencentMap.OnScreenShotListener paramOnScreenShotListener) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (this.a != null) {
      this.a.onMapScreenShot(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rd.4
 * JD-Core Version:    0.7.0.1
 */