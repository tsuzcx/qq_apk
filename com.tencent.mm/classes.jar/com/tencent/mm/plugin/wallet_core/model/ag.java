package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.a;
import com.tencent.mm.wallet_core.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class ag
{
  private static ag BAb = null;
  static ArrayList<l> qyC = null;
  cc.a owm;
  
  private ag()
  {
    AppMethodBeat.i(70439);
    this.owm = new ag.1(this);
    AppMethodBeat.o(70439);
  }
  
  private boolean a(int paramInt, final Map<String, String> paramMap, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(70441);
    if (paramMap == null)
    {
      ac.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
      AppMethodBeat.o(70441);
      return true;
    }
    if (paramInt < 0)
    {
      ac.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
      AppMethodBeat.o(70441);
      return true;
    }
    ac.i("MicroMsg.WalletPushNotifyManager", "handle paymsg type: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 12)
    {
      final int i = bs.getInt((String)paramMap.get(".sysmsg.paymsg.avail_balance"), -1);
      long l = bs.getLong((String)paramMap.get(".sysmsg.paymsg.balance_version"), -1L);
      paramMap = new e.a()
      {
        public final void aT(Map<String, Object> paramAnonymousMap)
        {
          AppMethodBeat.i(70438);
          if (paramAnonymousMap != null)
          {
            long l1 = bs.a((Long)paramAnonymousMap.get("wallet_balance_version"), -1L);
            long l2 = bs.a((Long)paramAnonymousMap.get("wallet_balance_last_update_time"), -1L);
            if ((l2 < 0L) || (l1 < 0L) || (l2 + this.BAf > bs.Gn()) || (i >= l1))
            {
              e.a(new e.c[] { new e.c("wallet_balance_version", Long.valueOf(i)), new e.c("wallet_balance_last_update_time", Long.valueOf(bs.Gn())), new e.c("wallet_balance", Double.valueOf(paramMap / 100.0D)) });
              ag.a(this.BAh, this.BAd, null);
              AppMethodBeat.o(70438);
              return;
            }
            ac.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
          }
          AppMethodBeat.o(70438);
        }
      };
      e.a(new String[] { "wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance" }, paramMap);
      AppMethodBeat.o(70441);
      return true;
    }
    if (paramInt == 43)
    {
      paramMap = v.aS(paramMap);
      if (paramMap != null) {
        paramArrayOfObject[0] = paramMap;
      }
      v.azg(paramString);
      AppMethodBeat.o(70441);
      return false;
    }
    AppMethodBeat.o(70441);
    return false;
  }
  
  public static boolean a(l paraml)
  {
    AppMethodBeat.i(70442);
    if (qyC == null) {
      qyC = new ArrayList();
    }
    qyC.add(paraml);
    AppMethodBeat.o(70442);
    return true;
  }
  
  public static boolean b(l paraml)
  {
    AppMethodBeat.i(70443);
    if (qyC == null)
    {
      ac.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
      AppMethodBeat.o(70443);
      return false;
    }
    qyC.remove(paraml);
    AppMethodBeat.o(70443);
    return true;
  }
  
  public static ag erK()
  {
    AppMethodBeat.i(70440);
    if (BAb == null) {
      BAb = new ag();
    }
    ag localag = BAb;
    AppMethodBeat.o(70440);
    return localag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag
 * JD-Core Version:    0.7.0.1
 */