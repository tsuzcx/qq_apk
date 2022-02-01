package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;

public final class aj
{
  public ArrayList<Bankcard> BAv;
  public String BAw;
  
  public aj()
  {
    AppMethodBeat.i(70472);
    this.BAv = new ArrayList();
    AppMethodBeat.o(70472);
  }
  
  public final Bankcard azk(String paramString)
  {
    AppMethodBeat.i(70473);
    Bankcard localBankcard;
    if (this.BAv.size() > 0)
    {
      Iterator localIterator = this.BAv.iterator();
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
        ac.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
      }
      for (;;)
      {
        AppMethodBeat.o(70473);
        return paramString;
        ac.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
        continue;
        ac.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
        paramString = null;
      }
    }
  }
  
  public final boolean erM()
  {
    AppMethodBeat.i(70474);
    if (this.BAv.size() > 0)
    {
      AppMethodBeat.o(70474);
      return true;
    }
    AppMethodBeat.o(70474);
    return false;
  }
  
  public final Bankcard erN()
  {
    AppMethodBeat.i(70475);
    if (erM())
    {
      if (!TextUtils.isEmpty(this.BAw))
      {
        localBankcard = azk(this.BAw);
        AppMethodBeat.o(70475);
        return localBankcard;
      }
      ac.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
      Bankcard localBankcard = (Bankcard)this.BAv.get(0);
      AppMethodBeat.o(70475);
      return localBankcard;
    }
    ac.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
    AppMethodBeat.o(70475);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aj
 * JD-Core Version:    0.7.0.1
 */