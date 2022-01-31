package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.i;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.Collections;

@a(3)
public class WalletChangeLoanRepayBankcardUI
  extends WalletChangeBankcardUI
{
  protected final void In(int paramInt)
  {
    AppMethodBeat.i(45990);
    int i;
    Object localObject;
    if (this.tNG != null)
    {
      i = this.tNG.size();
      if ((this.tNG == null) || (paramInt >= i)) {
        break label127;
      }
      localObject = (Bankcard)this.tNG.get(paramInt);
      this.tNH = ((Bankcard)localObject);
      this.tVO.upz = ((Bankcard)localObject).field_bindSerial;
      this.qqy.setEnabled(true);
      this.tVO.notifyDataSetChanged();
      Intent localIntent = new Intent();
      localIntent.putExtra("bindSerial", ((Bankcard)localObject).field_bindSerial);
      localIntent.putExtra("ret", 0);
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(45990);
      return;
      i = 0;
      break;
      label127:
      if (i == paramInt)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("ret", -1003);
        setResult(-1, (Intent)localObject);
      }
    }
  }
  
  protected final i cRS()
  {
    AppMethodBeat.i(45989);
    this.tNG = t.cTO().ulH;
    if (this.tNG != null) {
      Collections.sort(this.tNG, new WalletChangeBankcardUI.2(this));
    }
    i locali = new i(this, this.tNG, this.tVN, this.qrf);
    AppMethodBeat.o(45989);
    return locali;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45988);
    super.onCreate(paramBundle);
    setBackBtn(new WalletChangeLoanRepayBankcardUI.1(this));
    AppMethodBeat.o(45988);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI
 * JD-Core Version:    0.7.0.1
 */