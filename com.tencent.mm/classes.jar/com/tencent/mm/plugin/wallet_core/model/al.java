package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class al
{
  public ArrayList<Bankcard> OTP;
  public String OTQ;
  
  public al()
  {
    AppMethodBeat.i(70472);
    this.OTP = new ArrayList();
    AppMethodBeat.o(70472);
  }
  
  public final Bankcard bgU(String paramString)
  {
    AppMethodBeat.i(70473);
    Bankcard localBankcard;
    if (this.OTP.size() > 0)
    {
      Iterator localIterator = this.OTP.iterator();
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
        Log.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
      }
      for (;;)
      {
        AppMethodBeat.o(70473);
        return paramString;
        Log.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
        continue;
        Log.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
        paramString = null;
      }
    }
  }
  
  public final boolean gJC()
  {
    AppMethodBeat.i(70474);
    if (this.OTP.size() > 0)
    {
      AppMethodBeat.o(70474);
      return true;
    }
    AppMethodBeat.o(70474);
    return false;
  }
  
  public final Bankcard gJD()
  {
    AppMethodBeat.i(70475);
    if (gJC())
    {
      if (!TextUtils.isEmpty(this.OTQ))
      {
        localBankcard = bgU(this.OTQ);
        AppMethodBeat.o(70475);
        return localBankcard;
      }
      Log.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
      Bankcard localBankcard = (Bankcard)this.OTP.get(0);
      AppMethodBeat.o(70475);
      return localBankcard;
    }
    Log.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
    AppMethodBeat.o(70475);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.al
 * JD-Core Version:    0.7.0.1
 */