package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
{
  private static boolean XOb = false;
  public boolean XOa = false;
  public String mTag = "";
  
  public u(String paramString)
  {
    this.mTag = paramString;
  }
  
  public static void iGJ()
  {
    XOb = true;
  }
  
  public final boolean hZ(String paramString)
  {
    AppMethodBeat.i(141158);
    if (XOb)
    {
      Log.i("MicroMsg.SplashOptimizing", "[%s], check cancel", new Object[] { this.mTag });
      AppMethodBeat.o(141158);
      return false;
    }
    if (this.XOa)
    {
      Log.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", new Object[] { this.mTag, paramString });
      AppMethodBeat.o(141158);
      return true;
    }
    AppMethodBeat.o(141158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.u
 * JD-Core Version:    0.7.0.1
 */