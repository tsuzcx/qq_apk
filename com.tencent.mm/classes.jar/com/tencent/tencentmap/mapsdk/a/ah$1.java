package com.tencent.tencentmap.mapsdk.a;

import android.location.Location;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ah$1
  implements bg.a
{
  ah$1(ah paramah) {}
  
  public void a()
  {
    AppMethodBeat.i(147102);
    this.a.c(true);
    Object localObject = this.a.k();
    if (localObject != null)
    {
      localObject = new cz(((Location)localObject).getLatitude(), ((Location)localObject).getLongitude());
      this.a.b(ac.a((cz)localObject));
    }
    AppMethodBeat.o(147102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ah.1
 * JD-Core Version:    0.7.0.1
 */