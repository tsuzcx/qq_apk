package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

public final class ad
{
  public ArrayList<Bankcard> qyY = new ArrayList();
  public String qyZ;
  
  public final Bankcard Qs(String paramString)
  {
    Bankcard localBankcard;
    if (this.qyY.size() > 0)
    {
      Iterator localIterator = this.qyY.iterator();
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
      if (paramString == null)
      {
        y.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
        return paramString;
      }
      y.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
      return paramString;
      y.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
      return null;
    }
  }
  
  public final boolean bVD()
  {
    return this.qyY.size() > 0;
  }
  
  public final Bankcard bVE()
  {
    if (bVD())
    {
      if (!TextUtils.isEmpty(this.qyZ)) {
        return Qs(this.qyZ);
      }
      y.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
      return (Bankcard)this.qyY.get(0);
    }
    y.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.ad
 * JD-Core Version:    0.7.0.1
 */