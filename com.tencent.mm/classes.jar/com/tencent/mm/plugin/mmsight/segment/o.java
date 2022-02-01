package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bm.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
{
  public static d p(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107690);
    Log.i("MicroMsg.ThumbFetcherFactory", "get thumb fetcher, ish265: %s", new Object[] { Boolean.valueOf(e.Yt(paramString)) });
    k localk = new k();
    localk.init(paramString, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(107690);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.o
 * JD-Core Version:    0.7.0.1
 */