package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.wallet_core.ui.g.a;
import com.tencent.mm.wallet_core.ui.g.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class ai
{
  private static ai OTv = null;
  static ArrayList<l> aeb = null;
  ck.a tUv;
  
  private ai()
  {
    AppMethodBeat.i(70439);
    this.tUv = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(70436);
        paramAnonymousa = z.a(paramAnonymousa.jQG.RIF);
        Log.d("MicroMsg.WalletPushNotifyManager", "PayMsg:".concat(String.valueOf(paramAnonymousa)));
        Map localMap = XmlParser.parseXml(paramAnonymousa, "sysmsg", null);
        int i = Util.getInt((String)localMap.get(".sysmsg.paymsg.PayMsgType"), -1);
        Object[] arrayOfObject = new Object[1];
        if (!ai.a(ai.this, i, localMap, paramAnonymousa, arrayOfObject)) {
          ai.a(i, localMap, arrayOfObject);
        }
        AppMethodBeat.o(70436);
      }
      
      public final void a(h.c paramAnonymousc) {}
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
      paramMap = new g.a()
      {
        public final void aV(Map<String, Object> paramAnonymousMap)
        {
          AppMethodBeat.i(70438);
          if (paramAnonymousMap != null)
          {
            long l1 = Util.nullAs((Long)paramAnonymousMap.get("wallet_balance_version"), -1L);
            long l2 = Util.nullAs((Long)paramAnonymousMap.get("wallet_balance_last_update_time"), -1L);
            if ((l2 < 0L) || (l1 < 0L) || (l2 + this.OTy > Util.currentTicks()) || (i >= l1))
            {
              g.a(new g.c[] { new g.c("wallet_balance_version", Long.valueOf(i)), new g.c("wallet_balance_last_update_time", Long.valueOf(Util.currentTicks())), new g.c("wallet_balance", Double.valueOf(paramMap / 100.0D)) });
              ai.a(this.OTB, this.quj, null);
              AppMethodBeat.o(70438);
              return;
            }
            Log.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
          }
          AppMethodBeat.o(70438);
        }
      };
      g.a(new String[] { "wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance" }, paramMap);
      AppMethodBeat.o(70441);
      return true;
    }
    if (paramInt == 43)
    {
      paramMap = x.aU(paramMap);
      if (paramMap != null) {
        paramArrayOfObject[0] = paramMap;
      }
      x.bgQ(paramString);
      AppMethodBeat.o(70441);
      return false;
    }
    AppMethodBeat.o(70441);
    return false;
  }
  
  public static boolean a(l paraml)
  {
    AppMethodBeat.i(70442);
    if (aeb == null) {
      aeb = new ArrayList();
    }
    aeb.add(paraml);
    AppMethodBeat.o(70442);
    return true;
  }
  
  public static boolean b(l paraml)
  {
    AppMethodBeat.i(70443);
    if (aeb == null)
    {
      Log.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
      AppMethodBeat.o(70443);
      return false;
    }
    aeb.remove(paraml);
    AppMethodBeat.o(70443);
    return true;
  }
  
  public static ai gJA()
  {
    AppMethodBeat.i(70440);
    if (OTv == null) {
      OTv = new ai();
    }
    ai localai = OTv;
    AppMethodBeat.o(70440);
    return localai;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ai
 * JD-Core Version:    0.7.0.1
 */