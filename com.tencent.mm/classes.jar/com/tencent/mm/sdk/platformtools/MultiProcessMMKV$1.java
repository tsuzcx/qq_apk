package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mmkv.b;
import com.tencent.mmkv.c;
import com.tencent.mmkv.d;

class MultiProcessMMKV$1
  implements b
{
  public void mmkvLog(c paramc, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(243671);
    Log.i("MMKV", "[%s][%d][%s] %s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramString3 });
    AppMethodBeat.o(243671);
  }
  
  public d onMMKVCRCCheckFail(String paramString)
  {
    AppMethodBeat.i(156250);
    Log.i("MicroMsg.MultiProcessMMKV", "onMMKVCRCCheckFail:%s", new Object[] { paramString });
    f.Ozc.idkeyStat(941L, 3L, 1L, true);
    f.Ozc.b(24632, new Object[] { paramString, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    paramString = d.agZR;
    AppMethodBeat.o(156250);
    return paramString;
  }
  
  public d onMMKVFileLengthError(String paramString)
  {
    AppMethodBeat.i(156251);
    Log.i("MicroMsg.MultiProcessMMKV", "onMMKVFileLengthError:%s", new Object[] { paramString });
    f.Ozc.idkeyStat(941L, 4L, 1L, true);
    f.Ozc.b(24632, new Object[] { paramString, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
    paramString = d.agZR;
    AppMethodBeat.o(156251);
    return paramString;
  }
  
  public boolean wantLogRedirecting()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MultiProcessMMKV.1
 * JD-Core Version:    0.7.0.1
 */