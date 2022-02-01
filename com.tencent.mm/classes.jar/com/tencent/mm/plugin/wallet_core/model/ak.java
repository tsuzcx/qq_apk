package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;

public final class ak
{
  public ArrayList<Bankcard> DaN;
  public String DaO;
  
  public ak()
  {
    AppMethodBeat.i(70472);
    this.DaN = new ArrayList();
    AppMethodBeat.o(70472);
  }
  
  public final Bankcard aEs(String paramString)
  {
    AppMethodBeat.i(70473);
    Bankcard localBankcard;
    if (this.DaN.size() > 0)
    {
      Iterator localIterator = this.DaN.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localBankcard = (Bankcard)localIterator.next();
      } while (!localBankcard.field_bindSerial.equals(paramString));
    }
    for (paramString = localBankcard;; paramString = null)
    {
      if (paramString == null) {
        ad.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
      }
      for (;;)
      {
        AppMethodBeat.o(70473);
        return paramString;
        ad.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
        continue;
        ad.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
        paramString = null;
      }
    }
  }
  
  public final boolean eFM()
  {
    AppMethodBeat.i(70474);
    if (this.DaN.size() > 0)
    {
      AppMethodBeat.o(70474);
      return true;
    }
    AppMethodBeat.o(70474);
    return false;
  }
  
  public final Bankcard eFN()
  {
    AppMethodBeat.i(70475);
    if (eFM())
    {
      if (!TextUtils.isEmpty(this.DaO))
      {
        localBankcard = aEs(this.DaO);
        AppMethodBeat.o(70475);
        return localBankcard;
      }
      ad.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
      Bankcard localBankcard = (Bankcard)this.DaN.get(0);
      AppMethodBeat.o(70475);
      return localBankcard;
    }
    ad.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
    AppMethodBeat.o(70475);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ak
 * JD-Core Version:    0.7.0.1
 */