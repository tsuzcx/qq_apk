package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

@a(3)
public class WalletLqtCheckPwdInputDialogUI
  extends WalletBaseUI
{
  private String HuD;
  private String HuW = "";
  private WcPayCashierDialog HuX;
  private String mTitle = "";
  
  private void showDialog()
  {
    AppMethodBeat.i(68785);
    if ((this.HuX != null) && (this.HuX.isShowing())) {
      this.HuX.dismiss();
    }
    this.HuW = f.D(Util.getDouble(this.HuW, 0.0D));
    this.HuX = new WcPayCashierDialog(getContext());
    this.HuX.a(this.mTitle, this.HuW, "", null);
    this.HuX.IlX = new WcPayCashierDialog.a()
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, Bankcard paramAnonymousBankcard)
      {
        AppMethodBeat.i(68782);
        paramAnonymousFavorPayInfo = new Intent();
        paramAnonymousFavorPayInfo.putExtra("lqt_fetch_enc_pwd", paramAnonymousString);
        paramAnonymousFavorPayInfo.putExtra("lqt_redeem_listid", WalletLqtCheckPwdInputDialogUI.a(WalletLqtCheckPwdInputDialogUI.this));
        WalletLqtCheckPwdInputDialogUI.this.setResult(-1, paramAnonymousFavorPayInfo);
        WalletLqtCheckPwdInputDialogUI.this.finish();
        AppMethodBeat.o(68782);
      }
      
      public final void fNc() {}
      
      public final void onCancel()
      {
        AppMethodBeat.i(68783);
        Log.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
        WalletLqtCheckPwdInputDialogUI.this.finish();
        AppMethodBeat.o(68783);
      }
    };
    this.HuX.show();
    addDialog(this.HuX);
    AppMethodBeat.o(68785);
  }
  
  public void cleanUiData(int paramInt)
  {
    AppMethodBeat.i(68786);
    if (paramInt == 0)
    {
      finish();
      AppMethodBeat.o(68786);
      return;
    }
    if (paramInt == 1) {
      showDialog();
    }
    AppMethodBeat.o(68786);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(68784);
    super.onCreate(paramBundle);
    setContentViewVisibility(4);
    this.mTitle = getIntent().getStringExtra("lqt_fetch_pwd_title");
    this.HuW = getIntent().getStringExtra("lqt_fetch_pwd_money");
    this.HuD = getIntent().getStringExtra("lqt_redeem_listid");
    Log.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s, redeemListId: %s", new Object[] { Util.nullAsNil(this.HuW), Util.nullAsNil(this.mTitle), this.HuD });
    if ((!Util.isNullOrNil(this.mTitle)) && (!Util.isNullOrNil(this.HuW))) {}
    while (i == 0)
    {
      h.a(getContext(), 2131767999, 0, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(68781);
          WalletLqtCheckPwdInputDialogUI.this.finish();
          AppMethodBeat.o(68781);
        }
      });
      AppMethodBeat.o(68784);
      return;
      i = 0;
    }
    getWindow().setBackgroundDrawableResource(2131101287);
    d.CWG.asyncReportPaySecurityInfoThroughCgi();
    showDialog();
    AppMethodBeat.o(68784);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI
 * JD-Core Version:    0.7.0.1
 */