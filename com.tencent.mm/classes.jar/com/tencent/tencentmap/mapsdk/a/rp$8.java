package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;

class rp$8
  implements ah.p
{
  rp$8(rp paramrp, TencentMap.OnScreenShotListener paramOnScreenShotListener) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (this.a != null) {
      this.a.onMapScreenShot(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.rp.8
 * JD-Core Version:    0.7.0.1
 */