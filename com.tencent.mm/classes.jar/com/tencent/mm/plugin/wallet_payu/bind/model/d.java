package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class d
  extends a
{
  public final g a(MMActivity paramMMActivity, i parami)
  {
    AppMethodBeat.i(48352);
    if ((paramMMActivity instanceof WalletPayUCheckPwdUI))
    {
      paramMMActivity = new d.1(this, paramMMActivity, parami);
      AppMethodBeat.o(48352);
      return paramMMActivity;
    }
    paramMMActivity = super.a(paramMMActivity, parami);
    AppMethodBeat.o(48352);
    return paramMMActivity;
  }
  
  public final void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(48351);
    if ((paramActivity instanceof WalletBankcardDetailUI))
    {
      b(paramActivity, WalletPayUCheckPwdUI.class, paramBundle);
      AppMethodBeat.o(48351);
      return;
    }
    if ((paramActivity instanceof WalletPayUCheckPwdUI)) {
      b(paramActivity, paramBundle);
    }
    AppMethodBeat.o(48351);
  }
  
  public final void b(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48350);
    if (this.mEJ.getInt("key_errcode_payu", -1) == 0) {
      t.makeText(paramActivity, 2131305355, 0).show();
    }
    for (;;)
    {
      d(paramActivity, "mall", ".ui.MallIndexUI");
      AppMethodBeat.o(48350);
      return;
      t.makeText(paramActivity, 2131305060, 0).show();
    }
  }
  
  public final boolean c(Activity paramActivity, Bundle paramBundle)
  {
    return false;
  }
  
  public final void d(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(48349);
    b(paramActivity, WalletPayUBankcardDetailUI.class, paramBundle);
    AppMethodBeat.o(48349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.model.d
 * JD-Core Version:    0.7.0.1
 */