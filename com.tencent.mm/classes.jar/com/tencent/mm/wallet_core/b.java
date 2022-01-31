package com.tencent.mm.wallet_core;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class b
{
  private static b wAd;
  
  public static b cMj()
  {
    if (wAd == null) {
      wAd = new b();
    }
    return wAd;
  }
  
  public static boolean cMk()
  {
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100368");
    if ((localc.isValid()) && ("1".equals(localc.ctr().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      y.d("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", new Object[] { Integer.valueOf(i) });
      return i > 0;
    }
  }
  
  public static boolean cMl()
  {
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100370");
    if ((localc.isValid()) && ("1".equals(localc.ctr().get("open")))) {}
    for (int i = 1;; i = 0)
    {
      y.d("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", new Object[] { Integer.valueOf(i) });
      return i > 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.b
 * JD-Core Version:    0.7.0.1
 */