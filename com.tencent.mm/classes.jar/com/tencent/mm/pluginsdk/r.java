package com.tencent.mm.pluginsdk;

import com.tencent.mm.sdk.platformtools.y;

public final class r
{
  private static boolean rSJ = false;
  public String mTag = "";
  public boolean rSI = false;
  
  public r(String paramString)
  {
    this.mTag = paramString;
  }
  
  public static void ckn()
  {
    rSJ = true;
  }
  
  public final boolean cd(String paramString)
  {
    if (rSJ) {
      y.i("MicroMsg.SplashOptimizing", "[%s], check cancel", new Object[] { this.mTag });
    }
    while (!this.rSI) {
      return false;
    }
    y.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", new Object[] { this.mTag, paramString });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.r
 * JD-Core Version:    0.7.0.1
 */