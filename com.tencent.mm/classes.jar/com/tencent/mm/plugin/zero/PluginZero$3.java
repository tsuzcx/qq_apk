package com.tencent.mm.plugin.zero;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ae.a;
import com.tencent.stubs.logger.Log.Logger;

final class PluginZero$3
  implements Log.Logger
{
  PluginZero$3(PluginZero paramPluginZero) {}
  
  public final boolean isLoggable(String paramString, int paramInt)
  {
    AppMethodBeat.i(133000);
    if ((paramInt >= 2) && (paramInt <= 7) && (PluginZero.access$100()[paramInt] >= ae.getLogLevel()))
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
    ae.a locala = ae.fon();
    int i = Process.myPid();
    int j = Process.myTid();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(132999);
      return;
    case 2: 
      locala.logV(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    case 3: 
      locala.logD(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    case 4: 
      locala.logI(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    case 5: 
      locala.logW(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    case 6: 
      locala.logE(0L, paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(132999);
      return;
    }
    locala.logF(0L, paramString1, "", "", 0, i, j, i, paramString2);
    AppMethodBeat.o(132999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero.3
 * JD-Core Version:    0.7.0.1
 */