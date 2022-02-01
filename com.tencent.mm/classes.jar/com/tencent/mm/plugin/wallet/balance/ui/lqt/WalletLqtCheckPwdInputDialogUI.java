package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletLqtCheckPwdInputDialogUI
  extends WalletBaseUI
{
  private String Cyh;
  private String Cyy = "";
  private WcPayCashierDialog Cyz;
  private String mTitle = "";
  
  private void showDialog()
  {
    AppMethodBeat.i(68785);
    if ((this.Cyz != null) && (this.Cyz.isShowing())) {
      this.Cyz.dismiss();
    }
    this.Cyy = e.D(bt.getDouble(this.Cyy, 0.0D));
    this.Cyz = new WcPayCashierDialog(getContext());
    this.Cyz.a(this.mTitle, this.Cyy, "", null);
    this.Cyz.Dlh = new WcPayCashierDialog.a()
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
      
      public final void eCm() {}
      
      public final void onCancel()
      {
        AppMethodBeat.i(68783);
        ad.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
        WalletLqtCheckPwdInputDialogUI.this.finish();
        AppMethodBeat.o(68783);
      }
    };
    this.Cyz.show();
    addDialog(this.Cyz);
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
    this.Cyy = getIntent().getStringExtra("lqt_fetch_pwd_money");
    this.Cyh = getIntent().getStringExtra("lqt_redeem_listid");
    ad.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s, redeemListId: %s", new Object[] { bt.nullAsNil(this.Cyy), bt.nullAsNil(this.mTitle), this.Cyh });
    if ((!bt.isNullOrNil(this.mTitle)) && (!bt.isNullOrNil(this.Cyy))) {}
    while (i == 0)
    {
      h.a(getContext(), 2131765550, 0, new DialogInterface.OnClickListener()
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
    getWindow().setBackgroundDrawableResource(2131101053);
    d.yBQ.asyncReportPaySecurityInfoThroughCgi();
    showDialog();
    AppMethodBeat.o(68784);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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