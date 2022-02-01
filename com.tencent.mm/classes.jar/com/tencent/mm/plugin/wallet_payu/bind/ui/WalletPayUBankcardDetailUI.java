package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;

public class WalletPayUBankcardDetailUI
  extends WalletBankcardDetailUI
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71993);
    super.onCreate(paramBundle);
    if (1 == this.VcZ.field_bankcardState)
    {
      ifF();
      findViewById(a.f.wallet_bankcard_detail_expired_bankphone_title).setVisibility(8);
      findViewById(a.f.wallet_bankcard_detail_expired_bankphone).setVisibility(8);
    }
    for (;;)
    {
      findViewById(a.f.wallet_bankcard_detail_international_default).setVisibility(8);
      ((TextView)findViewById(a.f.wallet_bankcard_detail_international_wording)).setText(a.i.wallet_bankcard_detail_international_tips_payu);
      AppMethodBeat.o(71993);
      return;
      Hq(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI
 * JD-Core Version:    0.7.0.1
 */