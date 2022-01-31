package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class BankRemitBankcardInputUI$27
  extends t
{
  BankRemitBankcardInputUI$27(BankRemitBankcardInputUI paramBankRemitBankcardInputUI) {}
  
  public final void bhX()
  {
    AppMethodBeat.i(44544);
    ab.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
    this.qhe.hideVKB();
    this.qhe.hideTenpayKB();
    if (BankRemitBankcardInputUI.u(this.qhe))
    {
      AppMethodBeat.o(44544);
      return;
    }
    Object localObject1 = BankRemitBankcardInputUI.n(this.qhe).getText();
    Object localObject2 = BankRemitBankcardInputUI.r(this.qhe).getText();
    if ((bo.isNullOrNil((String)localObject1)) || (((String)localObject1).trim().isEmpty()) || (bo.isNullOrNil((String)localObject2)) || (((String)localObject2).trim().isEmpty()) || (BankRemitBankcardInputUI.v(this.qhe) == null))
    {
      ab.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", new Object[] { localObject1, localObject2, BankRemitBankcardInputUI.v(this.qhe) });
      AppMethodBeat.o(44544);
      return;
    }
    ab.i("MicroMsg.BankRemitBankcardInputUI", "onRealClick() ifGetOperation:%s waitingGetOperation:%s ifAutoNext:%s", new Object[] { Boolean.valueOf(BankRemitBankcardInputUI.m(this.qhe)), Boolean.valueOf(BankRemitBankcardInputUI.x(this.qhe)), Boolean.valueOf(BankRemitBankcardInputUI.y(this.qhe)) });
    if (BankRemitBankcardInputUI.m(this.qhe))
    {
      if (BankRemitBankcardInputUI.z(this.qhe))
      {
        if (BankRemitBankcardInputUI.i(this.qhe))
        {
          ab.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
          BankRemitBankcardInputUI.A(this.qhe);
          AppMethodBeat.o(44544);
          return;
        }
        BankRemitBankcardInputUI.a(this.qhe, (String)localObject1, (String)localObject2, BankRemitBankcardInputUI.v(this.qhe).nLq, BankRemitBankcardInputUI.v(this.qhe).poq);
        AppMethodBeat.o(44544);
      }
    }
    else
    {
      BankRemitBankcardInputUI.b(this.qhe, true);
      BankRemitBankcardInputUI.a(this.qhe, (String)localObject1);
      BankRemitBankcardInputUI.b(this.qhe, (String)localObject2);
      if (BankRemitBankcardInputUI.B(this.qhe) == null) {
        break label348;
      }
      BankRemitBankcardInputUI.B(this.qhe).show();
    }
    for (;;)
    {
      if (!BankRemitBankcardInputUI.x(this.qhe)) {
        BankRemitBankcardInputUI.G(this.qhe);
      }
      AppMethodBeat.o(44544);
      return;
      label348:
      localObject1 = this.qhe;
      localObject2 = this.qhe;
      this.qhe.getString(2131296919);
      BankRemitBankcardInputUI.a((BankRemitBankcardInputUI)localObject1, h.b((Context)localObject2, this.qhe.getString(2131305479), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(44543);
          ab.i("MicroMsg.BankRemitBankcardInputUI", "coperationTipDialogNoTransparent onCancel()");
          BankRemitBankcardInputUI.b(BankRemitBankcardInputUI.27.this.qhe, false);
          BankRemitBankcardInputUI.C(BankRemitBankcardInputUI.27.this.qhe);
          if ((BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.27.this.qhe) != null) && (BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.27.this.qhe).isShowing())) {
            BankRemitBankcardInputUI.B(BankRemitBankcardInputUI.27.this.qhe).dismiss();
          }
          if ((BankRemitBankcardInputUI.D(BankRemitBankcardInputUI.27.this.qhe).getVisibility() == 8) || (BankRemitBankcardInputUI.E(BankRemitBankcardInputUI.27.this.qhe).getVisibility() == 4))
          {
            ab.i("MicroMsg.BankRemitBankcardInputUI", "usr cancel, & visibility not visiable, so finish");
            BankRemitBankcardInputUI.27.this.qhe.finish();
          }
          BankRemitBankcardInputUI.F(BankRemitBankcardInputUI.27.this.qhe);
          AppMethodBeat.o(44543);
        }
      }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitBankcardInputUI.27
 * JD-Core Version:    0.7.0.1
 */