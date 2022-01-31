package com.tencent.tencentmap.mapsdk.a;

import android.location.Location;

class ah$1
  implements oo.a
{
  ah$1(ah paramah) {}
  
  public void a()
  {
    this.a.c(true);
    Object localObject = this.a.k();
    if (localObject != null)
    {
      localObject = new qc(((Location)localObject).getLatitude(), ((Location)localObject).getLongitude());
      this.a.b(ad.a((qc)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ah.1
 * JD-Core Version:    0.7.0.1
 */