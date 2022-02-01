package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class t
{
  private static boolean QSk = false;
  public boolean QSj = false;
  public String mTag = "";
  
  public t(String paramString)
  {
    this.mTag = paramString;
  }
  
  public static void hfP()
  {
    QSk = true;
  }
  
  public final boolean gz(String paramString)
  {
    AppMethodBeat.i(141158);
    if (QSk)
    {
      Log.i("MicroMsg.SplashOptimizing", "[%s], check cancel", new Object[] { this.mTag });
      AppMethodBeat.o(141158);
      return false;
    }
    if (this.QSj)
    {
      Log.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", new Object[] { this.mTag, paramString });
      AppMethodBeat.o(141158);
      return true;
    }
    AppMethodBeat.o(141158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.t
 * JD-Core Version:    0.7.0.1
 */