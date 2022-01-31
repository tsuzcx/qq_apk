package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;

class r$a
  implements WebStorage.QuotaUpdater
{
  QuotaUpdater a;
  
  r$a(r paramr, QuotaUpdater paramQuotaUpdater)
  {
    this.a = paramQuotaUpdater;
  }
  
  public void updateQuota(long paramLong)
  {
    AppMethodBeat.i(139068);
    this.a.updateQuota(paramLong);
    AppMethodBeat.o(139068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.r.a
 * JD-Core Version:    0.7.0.1
 */