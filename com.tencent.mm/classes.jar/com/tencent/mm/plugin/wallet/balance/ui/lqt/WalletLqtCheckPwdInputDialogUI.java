package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletLqtCheckPwdInputDialogUI
  extends WalletBaseUI
{
  private String mTitle = "";
  private String tNC = "";
  private WcPayCashierDialog tND;
  private String tNn;
  
  private void showDialog()
  {
    AppMethodBeat.i(45520);
    if ((this.tND != null) && (this.tND.isShowing())) {
      this.tND.dismiss();
    }
    this.tNC = e.F(bo.getDouble(this.tNC, 0.0D));
    this.tND = new WcPayCashierDialog(getContext());
    this.tND.b(this.mTitle, this.tNC, "", null);
    this.tND.uvB = new WalletLqtCheckPwdInputDialogUI.2(this);
    this.tND.show();
    addDialog(this.tND);
    AppMethodBeat.o(45520);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(45521);
    if (paramInt == 0)
    {
      finish();
      AppMethodBeat.o(45521);
      return;
    }
    if (paramInt == 1) {
      showDialog();
    }
    AppMethodBeat.o(45521);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(45519);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.mTitle = getIntent().getStringExtra("lqt_fetch_pwd_title");
    this.tNC = getIntent().getStringExtra("lqt_fetch_pwd_money");
    this.tNn = getIntent().getStringExtra("lqt_redeem_listid");
    ab.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s, redeemListId: %s", new Object[] { bo.nullAsNil(this.tNC), bo.nullAsNil(this.mTitle), this.tNn });
    if ((!bo.isNullOrNil(this.mTitle)) && (!bo.isNullOrNil(this.tNC))) {}
    while (i == 0)
    {
      h.a(getContext(), 2131305336, 0, new WalletLqtCheckPwdInputDialogUI.1(this));
      AppMethodBeat.o(45519);
      return;
      i = 0;
    }
    getWindow().setBackgroundDrawableResource(2131690605);
    showDialog();
    AppMethodBeat.o(45519);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI
 * JD-Core Version:    0.7.0.1
 */