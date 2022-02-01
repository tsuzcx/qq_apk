package com.tencent.mm.plugin.zero;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogImp;
import com.tencent.stubs.logger.Log.Logger;

final class PluginZero$3
  implements Log.Logger
{
  PluginZero$3(PluginZero paramPluginZero) {}
  
  public final boolean isLoggable(String paramString, int paramInt)
  {
    AppMethodBeat.i(133000);
    if ((paramInt >= 2) && (paramInt <= 7) && (PluginZero.access$100()[paramInt] >= Log.getLogLevel()))
    {
      AppMethodBeat.o(133000);
      return true;
    }
    AppMethodBeat.o(133000);
    return false;
  }
  
  public final void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(132999);
    if (!isLoggable(paramString1, paramInt))
    {
      AppMethodBeat.o(132999);
      return;
    }
    Log.LogImp localLogImp = Log.getImpl();
    int i = Process.myPid();
    int j = Process.myTid();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(132999);
      return;
    case 2: 
      localLogImp.logV(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    case 3: 
      localLogImp.logD(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    case 4: 
      localLogImp.logI(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    case 5: 
      localLogImp.logW(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    case 6: 
      localLogImp.logE(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    }
    localLogImp.logF(0L, paramString1, "", "", 0, i, j, i, paramString2);
    AppMethodBeat.o(132999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero.3
 * JD-Core Version:    0.7.0.1
 */