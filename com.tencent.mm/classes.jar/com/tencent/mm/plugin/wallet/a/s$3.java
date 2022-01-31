package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import com.tencent.mm.x.c;
import java.util.Map;

final class s$3
  implements o
{
  s$3(s params) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(45851);
    if (("paymsg".equals(paramString)) && ("30".equals(paramMap.get(".sysmsg.paymsg.PayMsgType"))))
    {
      int i = bo.getInt((String)paramMap.get(".sysmsg.paymsg.WalletRedDot"), 0);
      int j = bo.getInt((String)paramMap.get(".sysmsg.paymsg.BankCardRedDot"), 0);
      parama = (String)paramMap.get(".sysmsg.paymsg.NewTagBankSerial");
      paramString = (String)paramMap.get(".sysmsg.paymsg.WalletRedDotWording");
      ab.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), parama });
      if (i != 1) {
        break label260;
      }
      c.PJ().b(ac.a.yHy, true);
      if (j != 1) {
        break label273;
      }
      c.PJ().b(ac.a.yHz, true);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramString))
      {
        g.RM();
        g.RL().Ru().set(ac.a.yHB, paramString);
      }
      if (!bo.isNullOrNil(parama))
      {
        g.RM();
        paramMap = (String)g.RL().Ru().get(ac.a.yHC, "");
        paramString = parama;
        if (!bo.isNullOrNil(paramMap)) {
          paramString = paramMap + "," + parama;
        }
        g.RM();
        g.RL().Ru().set(ac.a.yHC, paramString);
      }
      AppMethodBeat.o(45851);
      return;
      label260:
      c.PJ().b(ac.a.yHy, false);
      break;
      label273:
      c.PJ().b(ac.a.yHz, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s.3
 * JD-Core Version:    0.7.0.1
 */