package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.sdk.d.a;
import org.xwalk.core.Log;

final class e$1$1
  implements d.a
{
  e$1$1(e.1 param1) {}
  
  public final void onViewInitFinished(boolean paramBoolean)
  {
    AppMethodBeat.i(151403);
    Log.i("FileReaderX5", "QbSdk onViewInitFinished: ".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      e.a(this.BDi.BDg, this.BDi.val$filePath, this.BDi.hMe, this.BDi.AZC, this.BDi.BDh, this.BDi.AZE, this.BDi.AZD);
      AppMethodBeat.o(151403);
      return;
    }
    e.a(this.BDi.hMe, this.BDi.AZD, -102);
    AppMethodBeat.o(151403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.e.1.1
 * JD-Core Version:    0.7.0.1
 */