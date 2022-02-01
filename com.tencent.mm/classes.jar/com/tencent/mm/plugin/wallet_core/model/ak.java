package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;

public final class ak
{
  public ArrayList<Bankcard> Dsr;
  public String Dss;
  
  public ak()
  {
    AppMethodBeat.i(70472);
    this.Dsr = new ArrayList();
    AppMethodBeat.o(70472);
  }
  
  public final Bankcard aFM(String paramString)
  {
    AppMethodBeat.i(70473);
    Bankcard localBankcard;
    if (this.Dsr.size() > 0)
    {
      Iterator localIterator = this.Dsr.iterator();
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
        ae.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
      }
      for (;;)
      {
        AppMethodBeat.o(70473);
        return paramString;
        ae.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
        continue;
        ae.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
        paramString = null;
      }
    }
  }
  
  public final boolean eJt()
  {
    AppMethodBeat.i(70474);
    if (this.Dsr.size() > 0)
    {
      AppMethodBeat.o(70474);
      return true;
    }
    AppMethodBeat.o(70474);
    return false;
  }
  
  public final Bankcard eJu()
  {
    AppMethodBeat.i(70475);
    if (eJt())
    {
      if (!TextUtils.isEmpty(this.Dss))
      {
        localBankcard = aFM(this.Dss);
        AppMethodBeat.o(70475);
        return localBankcard;
      }
      ae.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
      Bankcard localBankcard = (Bankcard)this.Dsr.get(0);
      AppMethodBeat.o(70475);
      return localBankcard;
    }
    ae.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
    AppMethodBeat.o(70475);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ak
 * JD-Core Version:    0.7.0.1
 */