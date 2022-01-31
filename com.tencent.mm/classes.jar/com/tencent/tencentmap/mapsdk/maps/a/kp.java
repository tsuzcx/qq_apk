package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class kp
  implements ir
{
  private kx a;
  
  public kp(kx paramkx)
  {
    this.a = paramkx;
  }
  
  public void a(iq paramiq)
  {
    AppMethodBeat.i(148975);
    if (this.a == null)
    {
      AppMethodBeat.o(148975);
      return;
    }
    if (paramiq != null) {
      this.a.a(this.a.b().j());
    }
    if (this.a.v != null) {
      this.a.v.sendEmptyMessage(0);
    }
    AppMethodBeat.o(148975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kp
 * JD-Core Version:    0.7.0.1
 */