package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

class ef$11
  implements ah.a
{
  ef$11(ef paramef, CancelableCallback paramCancelableCallback) {}
  
  public void a()
  {
    AppMethodBeat.i(150398);
    if (this.a != null) {
      this.a.onFinish();
    }
    AppMethodBeat.o(150398);
  }
  
  public void b()
  {
    AppMethodBeat.i(150399);
    if (this.a != null) {
      this.a.onCancel();
    }
    AppMethodBeat.o(150399);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ef.11
 * JD-Core Version:    0.7.0.1
 */