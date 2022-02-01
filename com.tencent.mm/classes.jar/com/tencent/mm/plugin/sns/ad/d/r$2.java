package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.api.c.a;
import com.tencent.mm.sdk.platformtools.Log;

final class r$2
  implements c.a
{
  r$2(long paramLong) {}
  
  public final void csx()
  {
    AppMethodBeat.i(310102);
    Log.i("LiteAppPreviewHelper", "startLiteApp success, costTime is " + (System.currentTimeMillis() - this.POC));
    AppMethodBeat.o(310102);
  }
  
  public final void csy()
  {
    AppMethodBeat.i(310106);
    Log.i("LiteAppPreviewHelper", "startLiteApp fail, costTime is " + (System.currentTimeMillis() - this.POC));
    AppMethodBeat.o(310106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.r.2
 * JD-Core Version:    0.7.0.1
 */