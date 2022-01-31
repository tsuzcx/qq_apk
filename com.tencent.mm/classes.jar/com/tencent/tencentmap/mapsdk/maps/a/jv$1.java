package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cj;

class jv$1
  implements Runnable
{
  jv$1(jv paramjv) {}
  
  public void run()
  {
    AppMethodBeat.i(148788);
    try
    {
      if (jv.a(this.a) != null) {
        jv.a(this.a).a();
      }
      AppMethodBeat.o(148788);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(148788);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jv.1
 * JD-Core Version:    0.7.0.1
 */