package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class t
{
  private static boolean Fcg = false;
  public boolean Fcf = false;
  public String mTag = "";
  
  public t(String paramString)
  {
    this.mTag = paramString;
  }
  
  public static void fcM()
  {
    Fcg = true;
  }
  
  public final boolean fb(String paramString)
  {
    AppMethodBeat.i(141158);
    if (Fcg)
    {
      ae.i("MicroMsg.SplashOptimizing", "[%s], check cancel", new Object[] { this.mTag });
      AppMethodBeat.o(141158);
      return false;
    }
    if (this.Fcf)
    {
      ae.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", new Object[] { this.mTag, paramString });
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