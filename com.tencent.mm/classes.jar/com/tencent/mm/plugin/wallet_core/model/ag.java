package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.wallet_core.ui.i;
import com.tencent.mm.wallet_core.ui.i.a;
import com.tencent.mm.wallet_core.ui.i.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class ag
{
  private static ag VJC = null;
  static ArrayList<l> zTV = null;
  cl.a wXR;
  
  private ag()
  {
    AppMethodBeat.i(70439);
    this.wXR = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(70436);
        paramAnonymousa = w.a(paramAnonymousa.mpN.YFG);
        Log.d("MicroMsg.WalletPushNotifyManager", "PayMsg:".concat(String.valueOf(paramAnonymousa)));
        Map localMap = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
        int i = Util.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        Object[] arrayOfObject = new Object[1];
        if (!ag.a(ag.this, i, localMap, paramAnonymousa, arrayOfObject)) {
          ag.a(i, localMap, arrayOfObject);
        }
        AppMethodBeat.o(70436);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    AppMethodBeat.o(70439);
  }
  
  private boolean a(int paramInt, final Map<String, String> paramMap, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(70441);
    if (paramMap == null)
    {
      Log.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
      AppMethodBeat.o(70441);
      return true;
    }
    if (paramInt < 0)
    {
      Log.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
      AppMethodBeat.o(70441);
      return true;
    }
    Log.i("MicroMsg.WalletPushNotifyManager", "handle paymsg type: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 12)
    {
      final int i = Util.getInt((String)paramMap.get(".sysmsg.paymsg.avail_balance"), -1);
      long l = Util.getLong((String)paramMap.get(".sysmsg.paymsg.balance_version"), -1L);
      paramMap = new i.a()
      {
        public final void bm(Map<String, Object> paramAnonymousMap)
        {
          AppMethodBeat.i(70438);
          if (paramAnonymousMap != null)
          {
            long l1 = Util.nullAs((Long)paramAnonymousMap.get("wallet_balance_version"), -1L);
            long l2 = Util.nullAs((Long)paramAnonymousMap.get("wallet_balance_last_update_time"), -1L);
            if ((l2 < 0L) || (l1 < 0L) || (l2 + this.VJF > Util.currentTicks()) || (i >= l1))
            {
              i.a(new i.c[] { new i.c("wallet_balance_version", Long.valueOf(i)), new i.c("wallet_balance_last_update_time", Long.valueOf(Util.currentTicks())), new i.c("wallet_balance", Double.valueOf(paramMap / 100.0D)) });
              ag.a(this.VJH, this.tyZ, null);
              AppMethodBeat.o(70438);
              return;
            }
            Log.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
          }
          AppMethodBeat.o(70438);
        }
      };
      i.a(new String[] { "wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance" }, paramMap);
      AppMethodBeat.o(70441);
      return true;
    }
    if (paramInt == 43)
    {
      paramMap = x.bl(paramMap);
      if (paramMap != null) {
        paramArrayOfObject[0] = paramMap;
      }
      x.bgy(paramString);
      AppMethodBeat.o(70441);
      return false;
    }
    AppMethodBeat.o(70441);
    return false;
  }
  
  public static boolean a(l paraml)
  {
    AppMethodBeat.i(70442);
    if (zTV == null) {
      zTV = new ArrayList();
    }
    zTV.add(paraml);
    AppMethodBeat.o(70442);
    return true;
  }
  
  public static boolean b(l paraml)
  {
    AppMethodBeat.i(70443);
    if (zTV == null)
    {
      Log.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
      AppMethodBeat.o(70443);
      return false;
    }
    zTV.remove(paraml);
    AppMethodBeat.o(70443);
    return true;
  }
  
  public static ag iiO()
  {
    AppMethodBeat.i(70440);
    if (VJC == null) {
      VJC = new ag();
    }
    ag localag = VJC;
    AppMethodBeat.o(70440);
    return localag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ag
 * JD-Core Version:    0.7.0.1
 */