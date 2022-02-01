package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(3)
public class WalletChangeLoanRepayBankcardUI
  extends WalletChangeBankcardUI
{
  private String Vnq;
  
  protected final void arU(int paramInt)
  {
    AppMethodBeat.i(69339);
    int i;
    Object localObject;
    if (this.Vbt != null)
    {
      i = this.Vbt.size();
      if ((this.Vbt == null) || (paramInt >= i)) {
        break label127;
      }
      localObject = (Bankcard)this.Vbt.get(paramInt);
      this.Vbu = ((Bankcard)localObject);
      this.Vnh.VOz = ((Bankcard)localObject).field_bindSerial;
      this.OrJ.setEnabled(true);
      this.Vnh.notifyDataSetChanged();
      Intent localIntent = new Intent();
      localIntent.putExtra("bindSerial", ((Bankcard)localObject).field_bindSerial);
      localIntent.putExtra("ret", 0);
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(69339);
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
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  protected final m igb()
  {
    AppMethodBeat.i(69338);
    this.Vbt = u.iiD().VJV;
    iga();
    m localm = new m(this, this.Vbt, this.Vng, this.OsJ);
    localm.VOz = this.Vnq;
    AppMethodBeat.o(69338);
    return localm;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69337);
    this.Vnq = getIntent().getStringExtra("bindSerial");
    super.onCreate(paramBundle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(69336);
        WalletChangeLoanRepayBankcardUI.this.setResult(-1, null);
        AppMethodBeat.o(69336);
        return true;
      }
    });
    AppMethodBeat.o(69337);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI
 * JD-Core Version:    0.7.0.1
 */