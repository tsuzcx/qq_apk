package com.tencent.mm.plugin.wallet.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.Map;

public final class a
{
  public static boolean bUE()
  {
    k localk = (k)g.r(k.class);
    Object localObject = new StringBuilder("mgr==null?");
    ae localae;
    StringBuilder localStringBuilder;
    if (localk == null)
    {
      bool = true;
      y.i("MicroMsg.WalletUtil", bool);
      if (localk != null) {
        y.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + localk.aSK());
      }
      p.bTK();
      localObject = p.bTL();
      localae = ((ag)localObject).bVR();
      localStringBuilder = new StringBuilder("config==null?");
      if (localae != null) {
        break label202;
      }
    }
    label202:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.WalletUtil", bool);
      if (localae != null) {
        y.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + localae.bVH());
      }
      y.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + ((ag)localObject).bVN());
      if ((localk == null) || (!localk.aSK()) || (localae == null) || (!localae.bVH()) || (!((ag)localObject).bVN())) {
        break label207;
      }
      return true;
      bool = false;
      break;
    }
    label207:
    return false;
  }
  
  public static boolean bUF()
  {
    k localk = (k)g.r(k.class);
    if (localk == null)
    {
      y.w("MicroMsg.WalletUtil", "no finger mgr!");
      return false;
    }
    p.bTK();
    ag localag = p.bTL();
    ae localae = localag.bVR();
    h.nFQ.h(916L, 0L, 1L);
    y.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", new Object[] { Boolean.valueOf(localk.aSS()), Boolean.valueOf(localae.bVH()), Boolean.valueOf(localag.bVN()) });
    return (localk.aSS()) && (localae.bVH()) && (localag.bVN());
  }
  
  public static boolean bUG()
  {
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100338");
    boolean bool;
    if (localc.isValid()) {
      if (bk.getInt((String)localc.ctr().get("enabled"), 0) == 1) {
        bool = true;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.WalletUtil", "isEnableSaveAndFetchBindQuery enabled: %b", new Object[] { Boolean.valueOf(bool) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.b.a
 * JD-Core Version:    0.7.0.1
 */