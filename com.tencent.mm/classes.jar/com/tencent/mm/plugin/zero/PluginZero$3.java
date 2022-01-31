package com.tencent.mm.plugin.zero;

import android.os.Process;
import com.tencent.f.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ab.a;

final class PluginZero$3
  implements b.a
{
  PluginZero$3(PluginZero paramPluginZero) {}
  
  public final boolean isLoggable(String paramString, int paramInt)
  {
    AppMethodBeat.i(58750);
    if ((paramInt >= 2) && (paramInt <= 7) && (PluginZero.access$100()[paramInt] >= ab.getLogLevel()))
    {
      AppMethodBeat.o(58750);
      return true;
    }
    AppMethodBeat.o(58750);
    return false;
  }
  
  public final void println(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(58749);
    if (!isLoggable(paramString1, paramInt))
    {
      AppMethodBeat.o(58749);
      return;
    }
    ab.a locala = ab.dsH();
    int i = Process.myPid();
    int j = Process.myTid();
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(58749);
      return;
    case 2: 
      locala.logV(paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(58749);
      return;
    case 3: 
      locala.logD(paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(58749);
      return;
    case 4: 
      locala.logI(paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(58749);
      return;
    case 5: 
      locala.logW(paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(58749);
      return;
    case 6: 
      locala.logE(paramString1, "", "", 0, i, j, i, paramString2);
      AppMethodBeat.o(58749);
      return;
    }
    locala.logF(paramString1, "", "", 0, i, j, i, paramString2);
    AppMethodBeat.o(58749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero.3
 * JD-Core Version:    0.7.0.1
 */