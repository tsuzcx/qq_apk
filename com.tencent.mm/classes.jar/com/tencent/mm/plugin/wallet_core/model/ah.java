package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.f.a;
import com.tencent.mm.wallet_core.ui.f.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class ah
{
  private static ah DrZ = null;
  static ArrayList<l> eO = null;
  cf.a pgl;
  
  private ah()
  {
    AppMethodBeat.i(70439);
    this.pgl = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(70436);
        paramAnonymousa = z.a(paramAnonymousa.gte.FNI);
        ae.d("MicroMsg.WalletPushNotifyManager", "PayMsg:".concat(String.valueOf(paramAnonymousa)));
        Map localMap = bx.M(paramAnonymousa, "sysmsg");
        int i = bu.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        Object[] arrayOfObject = new Object[1];
        if (!ah.a(ah.this, i, localMap, paramAnonymousa, arrayOfObject)) {
          ah.a(i, localMap, arrayOfObject);
        }
        AppMethodBeat.o(70436);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    AppMethodBeat.o(70439);
  }
  
  private boolean a(int paramInt, final Map<String, String> paramMap, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(70441);
    if (paramMap == null)
    {
      ae.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
      AppMethodBeat.o(70441);
      return true;
    }
    if (paramInt < 0)
    {
      ae.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
      AppMethodBeat.o(70441);
      return true;
    }
    ae.i("MicroMsg.WalletPushNotifyManager", "handle paymsg type: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 12)
    {
      final int i = bu.getInt((String)paramMap.get(".sysmsg.paymsg.avail_balance"), -1);
      long l = bu.getLong((String)paramMap.get(".sysmsg.paymsg.balance_version"), -1L);
      paramMap = new f.a()
      {
        public final void bc(Map<String, Object> paramAnonymousMap)
        {
          AppMethodBeat.i(70438);
          if (paramAnonymousMap != null)
          {
            long l1 = bu.a((Long)paramAnonymousMap.get("wallet_balance_version"), -1L);
            long l2 = bu.a((Long)paramAnonymousMap.get("wallet_balance_last_update_time"), -1L);
            if ((l2 < 0L) || (l1 < 0L) || (l2 + this.Dsc > bu.HQ()) || (i >= l1))
            {
              f.a(new f.c[] { new f.c("wallet_balance_version", Long.valueOf(i)), new f.c("wallet_balance_last_update_time", Long.valueOf(bu.HQ())), new f.c("wallet_balance", Double.valueOf(paramMap / 100.0D)) });
              ah.a(this.Dse, this.mhV, null);
              AppMethodBeat.o(70438);
              return;
            }
            ae.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
          }
          AppMethodBeat.o(70438);
        }
      };
      f.a(new String[] { "wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance" }, paramMap);
      AppMethodBeat.o(70441);
      return true;
    }
    if (paramInt == 43)
    {
      paramMap = w.bb(paramMap);
      if (paramMap != null) {
        paramArrayOfObject[0] = paramMap;
      }
      w.aFI(paramString);
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
      ae.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
      AppMethodBeat.o(70443);
      return false;
    }
    eO.remove(paraml);
    AppMethodBeat.o(70443);
    return true;
  }
  
  public static ah eJr()
  {
    AppMethodBeat.i(70440);
    if (DrZ == null) {
      DrZ = new ah();
    }
    ah localah = DrZ;
    AppMethodBeat.o(70440);
    return localah;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ah
 * JD-Core Version:    0.7.0.1
 */