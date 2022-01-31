package com.tencent.mm.plugin.zero;

import android.os.Process;
import com.tencent.e.a.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.sdk.platformtools.y.a;

final class PluginZero$3
  implements b.a
{
  PluginZero$3(PluginZero paramPluginZero) {}
  
  public final boolean isLoggable(String paramString, int paramInt)
  {
    return (paramInt >= 2) && (paramInt <= 7) && (PluginZero.access$100()[paramInt] >= y.getLogLevel());
  }
  
  public final void println(int paramInt, String paramString1, String paramString2)
  {
    if (!isLoggable(paramString1, paramInt)) {
      return;
    }
    y.a locala = y.cqK();
    int i = Process.myPid();
    int j = Process.myTid();
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      locala.logV(paramString1, "", "", 0, i, j, i, paramString2);
      return;
    case 3: 
      locala.logD(paramString1, "", "", 0, i, j, i, paramString2);
      return;
    case 4: 
      locala.logI(paramString1, "", "", 0, i, j, i, paramString2);
      return;
    case 5: 
      locala.logW(paramString1, "", "", 0, i, j, i, paramString2);
      return;
    case 6: 
      locala.logE(paramString1, "", "", 0, i, j, i, paramString2);
      return;
    }
    locala.logF(paramString1, "", "", 0, i, j, i, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.PluginZero.3
 * JD-Core Version:    0.7.0.1
 */