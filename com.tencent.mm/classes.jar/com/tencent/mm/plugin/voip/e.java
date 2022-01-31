package com.tencent.mm.plugin.voip;

import android.content.Context;
import com.tencent.mm.h.a.tc;
import com.tencent.mm.h.a.tc.a;

public final class e
{
  public static boolean bPA()
  {
    tc localtc = new tc();
    com.tencent.mm.sdk.b.a.udP.m(localtc);
    return localtc.ccF.ccI;
  }
  
  public static boolean bj(Context paramContext)
  {
    return com.tencent.mm.r.a.bj(paramContext);
  }
  
  public static boolean bk(Context paramContext)
  {
    return com.tencent.mm.r.a.bk(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.e
 * JD-Core Version:    0.7.0.1
 */