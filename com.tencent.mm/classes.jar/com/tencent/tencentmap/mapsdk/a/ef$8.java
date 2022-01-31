package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;

class ef$8
  implements ah.p
{
  ef$8(ef paramef, TencentMap.OnScreenShotListener paramOnScreenShotListener) {}
  
  public void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(150163);
    if (this.a != null) {
      this.a.onMapScreenShot(paramBitmap);
    }
    AppMethodBeat.o(150163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.8
 * JD-Core Version:    0.7.0.1
 */