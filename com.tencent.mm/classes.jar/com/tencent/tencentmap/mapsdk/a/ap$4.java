package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ht;

class ap$4
  implements ht
{
  boolean a;
  Handler b;
  
  ap$4(ap paramap)
  {
    AppMethodBeat.i(149648);
    this.a = false;
    this.b = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(149648);
  }
  
  public void a()
  {
    AppMethodBeat.i(149649);
    if (!this.a) {
      this.a = true;
    }
    this.b.post(new ap.4.1(this));
    AppMethodBeat.o(149649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ap.4
 * JD-Core Version:    0.7.0.1
 */