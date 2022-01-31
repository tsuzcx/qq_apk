package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

final class WalletPwdConfirmUI$2
  implements View.OnClickListener
{
  WalletPwdConfirmUI$2(WalletPwdConfirmUI paramWalletPwdConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47539);
    Object localObject = this.usw.getInput().getString("key_new_pwd1");
    String str2 = this.usw.nID.getMd5Value();
    paramView = this.usw.getInput().getString("kreq_token");
    String str1 = this.usw.getInput().getString("key_verify_code");
    ab.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.a(this.usw) + " vertifyCode: " + str1);
    if ((localObject != null) && (((String)localObject).equals(str2)))
    {
      localObject = new u();
      ((u)localObject).gww = this.usw.nID.getText();
      ((u)localObject).pVo = WalletPwdConfirmUI.a(this.usw);
      ((u)localObject).token = paramView;
      ((u)localObject).uld = str1;
      ((u)localObject).ule = this.usw.getInput().getBoolean("key_is_bind_bankcard", true);
      if (!a.aM(this.usw).cWe()) {}
      for (((u)localObject).flag = "1";; ((u)localObject).flag = "4")
      {
        paramView = (FavorPayInfo)this.usw.getInput().getParcelable("key_favor_pay_info");
        if (paramView != null)
        {
          ((u)localObject).ufg = paramView.uhX;
          ((u)localObject).ufh = paramView.uhU;
        }
        this.usw.getNetController().p(new Object[] { localObject });
        AppMethodBeat.o(47539);
        return;
      }
    }
    a.q(this.usw, -1002);
    AppMethodBeat.o(47539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.2
 * JD-Core Version:    0.7.0.1
 */