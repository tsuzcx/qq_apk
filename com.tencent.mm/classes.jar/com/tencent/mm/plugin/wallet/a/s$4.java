package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.z.a;
import com.tencent.mm.z.c;
import java.util.Map;

final class s$4
  implements q
{
  s$4(s params) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(69192);
    if (("paymsg".equals(paramString)) && ("30".equals(paramMap.get(".sysmsg.paymsg.PayMsgType"))))
    {
      int i = bt.getInt((String)paramMap.get(".sysmsg.paymsg.WalletRedDot"), 0);
      int j = bt.getInt((String)paramMap.get(".sysmsg.paymsg.BankCardRedDot"), 0);
      parama = (String)paramMap.get(".sysmsg.paymsg.NewTagBankSerial");
      paramString = (String)paramMap.get(".sysmsg.paymsg.WalletRedDotWording");
      ad.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), parama });
      if (i != 1) {
        break label260;
      }
      c.aht().b(al.a.IAC, true);
      if (j != 1) {
        break label273;
      }
      c.aht().b(al.a.IAD, true);
    }
    for (;;)
    {
      if (!bt.isNullOrNil(paramString))
      {
        g.ajD();
        g.ajC().ajl().set(al.a.IAF, paramString);
      }
      if (!bt.isNullOrNil(parama))
      {
        g.ajD();
        paramMap = (String)g.ajC().ajl().get(al.a.IAG, "");
        paramString = parama;
        if (!bt.isNullOrNil(paramMap)) {
          paramString = paramMap + "," + parama;
        }
        g.ajD();
        g.ajC().ajl().set(al.a.IAG, paramString);
      }
      AppMethodBeat.o(69192);
      return;
      label260:
      c.aht().b(al.a.IAC, false);
      break;
      label273:
      c.aht().b(al.a.IAD, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.s.4
 * JD-Core Version:    0.7.0.1
 */