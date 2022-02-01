package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.Collections;

@a(3)
public class WalletChangeLoanRepayBankcardUI
  extends WalletChangeBankcardUI
{
  private String Oyf;
  
  protected final void amk(int paramInt)
  {
    AppMethodBeat.i(69339);
    int i;
    Object localObject;
    if (this.OmN != null)
    {
      i = this.OmN.size();
      if ((this.OmN == null) || (paramInt >= i)) {
        break label127;
      }
      localObject = (Bankcard)this.OmN.get(paramInt);
      this.OmO = ((Bankcard)localObject);
      this.OxW.OYl = ((Bankcard)localObject).field_bindSerial;
      this.Iub.setEnabled(true);
      this.OxW.notifyDataSetChanged();
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
  
  protected final l gGX()
  {
    AppMethodBeat.i(69338);
    this.OmN = u.gJp().OTP;
    if (this.OmN != null) {
      Collections.sort(this.OmN, new WalletChangeBankcardUI.2(this));
    }
    l locall = new l(this, this.OmN, this.OxV, this.Ivh);
    locall.OYl = this.Oyf;
    AppMethodBeat.o(69338);
    return locall;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(69337);
    this.Oyf = getIntent().getStringExtra("bindSerial");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletChangeLoanRepayBankcardUI
 * JD-Core Version:    0.7.0.1
 */