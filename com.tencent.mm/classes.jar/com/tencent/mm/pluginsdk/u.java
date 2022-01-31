package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class u
{
  private static boolean vJH = false;
  public String mTag = "";
  public boolean vJG = false;
  
  public u(String paramString)
  {
    this.mTag = paramString;
  }
  
  public static void dkT()
  {
    vJH = true;
  }
  
  public final boolean jdMethod_do(String paramString)
  {
    AppMethodBeat.i(105838);
    if (vJH)
    {
      ab.i("MicroMsg.SplashOptimizing", "[%s], check cancel", new Object[] { this.mTag });
      AppMethodBeat.o(105838);
      return false;
    }
    if (this.vJG)
    {
      ab.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", new Object[] { this.mTag, paramString });
      AppMethodBeat.o(105838);
      return true;
    }
    AppMethodBeat.o(105838);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.u
 * JD-Core Version:    0.7.0.1
 */