package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mmkv.b;
import com.tencent.mmkv.c;
import com.tencent.mmkv.d;

final class MultiProcessMMKV$1
  implements b
{
  public final void mmkvLog(c paramc, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(261396);
    Log.i("MMKV", "[%s][%d][%s] %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3 });
    AppMethodBeat.o(261396);
  }
  
  public final d onMMKVCRCCheckFail(String paramString)
  {
    AppMethodBeat.i(156250);
    Log.i("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", new Object[] { paramString });
    f.Iyx.idkeyStat(941L, 3L, 1L, true);
    paramString = d.Zbk;
    AppMethodBeat.o(156250);
    return paramString;
  }
  
  public final d onMMKVFileLengthError(String paramString)
  {
    AppMethodBeat.i(156251);
    Log.i("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", new Object[] { paramString });
    f.Iyx.idkeyStat(941L, 4L, 1L, true);
    paramString = d.Zbk;
    AppMethodBeat.o(156251);
    return paramString;
  }
  
  public final boolean wantLogRedirecting()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MultiProcessMMKV.1
 * JD-Core Version:    0.7.0.1
 */