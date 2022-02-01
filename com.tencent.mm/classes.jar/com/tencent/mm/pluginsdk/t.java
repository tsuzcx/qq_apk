package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class t
{
  private static boolean EJI = false;
  public boolean EJH = false;
  public String mTag = "";
  
  public t(String paramString)
  {
    this.mTag = paramString;
  }
  
  public static void eYY()
  {
    EJI = true;
  }
  
  public final boolean eW(String paramString)
  {
    AppMethodBeat.i(141158);
    if (EJI)
    {
      ad.i("MicroMsg.SplashOptimizing", "[%s], check cancel", new Object[] { this.mTag });
      AppMethodBeat.o(141158);
      return false;
    }
    if (this.EJH)
    {
      ad.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", new Object[] { this.mTag, paramString });
      AppMethodBeat.o(141158);
      return true;
    }
    AppMethodBeat.o(141158);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.t
 * JD-Core Version:    0.7.0.1
 */