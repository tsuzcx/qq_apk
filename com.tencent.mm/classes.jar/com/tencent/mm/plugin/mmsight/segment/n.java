package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bk.e;
import com.tencent.mm.sdk.platformtools.ac;

public final class n
{
  public static d m(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107690);
    ac.i("MicroMsg.ThumbFetcherFactory", "get thumb fetcher, ish265: %s", new Object[] { Boolean.valueOf(e.Et(paramString)) });
    k localk = new k();
    localk.init(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(107690);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.n
 * JD-Core Version:    0.7.0.1
 */