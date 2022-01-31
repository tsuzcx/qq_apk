package com.tencent.xweb.x5.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;

final class e$b
  implements QbSdk.PreInitCallback
{
  d.a BIA;
  
  public e$b(d.a parama)
  {
    this.BIA = parama;
  }
  
  public final void onCoreInitFinished() {}
  
  public final void onViewInitFinished(boolean paramBoolean)
  {
    AppMethodBeat.i(85094);
    if (this.BIA != null) {
      this.BIA.onViewInitFinished(paramBoolean);
    }
    AppMethodBeat.o(85094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */