package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cj;

class jv$2
  implements Runnable
{
  jv$2(jv paramjv) {}
  
  public void run()
  {
    AppMethodBeat.i(148789);
    try
    {
      if (jv.a(this.a) != null) {
        jv.a(this.a).b();
      }
      AppMethodBeat.o(148789);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(148789);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jv.2
 * JD-Core Version:    0.7.0.1
 */