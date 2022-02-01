package com.tencent.mm.plugin.sns.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.e;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements e
{
  public final void a(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(309640);
    Log.i("SnsAdService", "openAdCanvasById, canvasId=" + paramLong + ", source=" + paramInt + ", adInfoXml=" + paramString1 + ", extra=" + paramString2);
    m.a(paramLong, paramString1, paramString2, paramInt);
    AppMethodBeat.o(309640);
  }
  
  public final String aWg(String paramString)
  {
    AppMethodBeat.i(309646);
    paramString = m.aWg(paramString);
    AppMethodBeat.o(309646);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.c
 * JD-Core Version:    0.7.0.1
 */