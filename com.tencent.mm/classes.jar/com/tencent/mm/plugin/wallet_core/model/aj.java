package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

public final class aj
{
  public ArrayList<Bankcard> ulH;
  public String ulI;
  
  public aj()
  {
    AppMethodBeat.i(46944);
    this.ulH = new ArrayList();
    AppMethodBeat.o(46944);
  }
  
  public final Bankcard afk(String paramString)
  {
    AppMethodBeat.i(46945);
    Bankcard localBankcard;
    if (this.ulH.size() > 0)
    {
      Iterator localIterator = this.ulH.iterator();
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
        ab.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
      }
      for (;;)
      {
        AppMethodBeat.o(46945);
        return paramString;
        ab.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
        continue;
        ab.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
        paramString = null;
      }
    }
  }
  
  public final boolean cTZ()
  {
    AppMethodBeat.i(46946);
    if (this.ulH.size() > 0)
    {
      AppMethodBeat.o(46946);
      return true;
    }
    AppMethodBeat.o(46946);
    return false;
  }
  
  public final Bankcard cUa()
  {
    AppMethodBeat.i(46947);
    if (cTZ())
    {
      if (!TextUtils.isEmpty(this.ulI))
      {
        localBankcard = afk(this.ulI);
        AppMethodBeat.o(46947);
        return localBankcard;
      }
      ab.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
      Bankcard localBankcard = (Bankcard)this.ulH.get(0);
      AppMethodBeat.o(46947);
      return localBankcard;
    }
    ab.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
    AppMethodBeat.o(46947);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.aj
 * JD-Core Version:    0.7.0.1
 */