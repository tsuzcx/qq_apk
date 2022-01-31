package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(3)
public class WalletChangeLoanRepayBankcardUI
  extends WalletChangeBankcardUI
{
  protected final void AJ(int paramInt)
  {
    int i;
    Object localObject;
    if (this.qgr != null)
    {
      i = this.qgr.size();
      if ((this.qgr == null) || (paramInt >= i)) {
        break label117;
      }
      localObject = (Bankcard)this.qgr.get(paramInt);
      this.qgs = ((Bankcard)localObject);
      this.qmy.qCP = ((Bankcard)localObject).field_bindSerial;
      this.nBL.setEnabled(true);
      this.qmy.notifyDataSetChanged();
      Intent localIntent = new Intent();
      localIntent.putExtra("bindSerial", ((Bankcard)localObject).field_bindSerial);
      localIntent.putExtra("ret", 0);
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      return;
      i = 0;
      break;
      label117:
      if (i == paramInt)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("ret", -1003);
        setResult(-1, (Intent)localObject);
      }
    }
  }
  
  protected final g bTX()
  {
    this.qgr = o.bVt().qyY;
    bTW();
    return new g(this, this.qgr, this.qmx, this.nEh);
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new WalletChangeLoanRepayBankcardUI.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI
 * JD-Core Version:    0.7.0.1
 */