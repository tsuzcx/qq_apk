package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class ah
{
  private static ah Dau = null;
  static ArrayList<l> eO = null;
  cd.a oZH;
  
  private ah()
  {
    AppMethodBeat.i(70439);
    this.oZH = new cd.a()
    {
      public final void a(com.tencent.mm.al.e.a paramAnonymousa)
      {
        AppMethodBeat.i(70436);
        paramAnonymousa = z.a(paramAnonymousa.gqE.Fvk);
        ad.d("MicroMsg.WalletPushNotifyManager", "PayMsg:".concat(String.valueOf(paramAnonymousa)));
        Map localMap = bw.M(paramAnonymousa, "sysmsg");
        int i = bt.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        Object[] arrayOfObject = new Object[1];
        if (!ah.a(ah.this, i, localMap, paramAnonymousa, arrayOfObject)) {
          ah.a(i, localMap, arrayOfObject);
        }
        AppMethodBeat.o(70436);
      }
      
      public final void a(com.tencent.mm.al.e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(70439);
  }
  
  private boolean a(int paramInt, final Map<String, String> paramMap, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(70441);
    if (paramMap == null)
    {
      ad.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
      AppMethodBeat.o(70441);
      return true;
    }
    if (paramInt < 0)
    {
      ad.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
      AppMethodBeat.o(70441);
      return true;
    }
    ad.i("MicroMsg.WalletPushNotifyManager", "handle paymsg type: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 12)
    {
      final int i = bt.getInt((String)paramMap.get(".sysmsg.paymsg.avail_balance"), -1);
      long l = bt.getLong((String)paramMap.get(".sysmsg.paymsg.balance_version"), -1L);
      paramMap = new com.tencent.mm.wallet_core.ui.e.a()
      {
        public final void aW(Map<String, Object> paramAnonymousMap)
        {
          AppMethodBeat.i(70438);
          if (paramAnonymousMap != null)
          {
            long l1 = bt.a((Long)paramAnonymousMap.get("wallet_balance_version"), -1L);
            long l2 = bt.a((Long)paramAnonymousMap.get("wallet_balance_last_update_time"), -1L);
            if ((l2 < 0L) || (l1 < 0L) || (l2 + this.Day > bt.HI()) || (i >= l1))
            {
              e.a(new com.tencent.mm.wallet_core.ui.e.c[] { new com.tencent.mm.wallet_core.ui.e.c("wallet_balance_version", Long.valueOf(i)), new com.tencent.mm.wallet_core.ui.e.c("wallet_balance_last_update_time", Long.valueOf(bt.HI())), new com.tencent.mm.wallet_core.ui.e.c("wallet_balance", Double.valueOf(paramMap / 100.0D)) });
              ah.a(this.DaA, this.Daw, null);
              AppMethodBeat.o(70438);
              return;
            }
            ad.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
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
      paramMap = w.aV(paramMap);
      if (paramMap != null) {
        paramArrayOfObject[0] = paramMap;
      }
      w.aEo(paramString);
      AppMethodBeat.o(70441);
      return false;
    }
    AppMethodBeat.o(70441);
    return false;
  }
  
  public static boolean a(l paraml)
  {
    AppMethodBeat.i(70442);
    if (eO == null) {
      eO = new ArrayList();
    }
    eO.add(paraml);
    AppMethodBeat.o(70442);
    return true;
  }
  
  public static boolean b(l paraml)
  {
    AppMethodBeat.i(70443);
    if (eO == null)
    {
      ad.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
      AppMethodBeat.o(70443);
      return false;
    }
    eO.remove(paraml);
    AppMethodBeat.o(70443);
    return true;
  }
  
  public static ah eFK()
  {
    AppMethodBeat.i(70440);
    if (Dau == null) {
      Dau = new ah();
    }
    ah localah = Dau;
    AppMethodBeat.o(70440);
    return localah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ah
 * JD-Core Version:    0.7.0.1
 */