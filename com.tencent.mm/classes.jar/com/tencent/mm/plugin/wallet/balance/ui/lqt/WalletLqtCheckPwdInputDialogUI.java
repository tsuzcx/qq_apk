package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog;
import com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDialog.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;

@com.tencent.mm.ui.base.a(3)
public class WalletLqtCheckPwdInputDialogUI
  extends WalletBaseUI
{
  private String VaV;
  private String Vbp = "";
  private WcPayCashierDialog Vbq;
  private String mTitle = "";
  
  private void fpM()
  {
    AppMethodBeat.i(68785);
    this.Vbp = i.X(Util.getDouble(this.Vbp, 0.0D));
    if (((c)h.ax(c.class)).a(c.a.yWY, 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      ITransmitKvData localITransmitKvData = ITransmitKvData.create();
      localITransmitKvData.putString("sp_name", this.mTitle);
      localITransmitKvData.putString("price", this.Vbp);
      ((com.tencent.mm.pluginsdk.wallet.a)h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).startUseCase("verifyPwdPay", localITransmitKvData, new UseCaseCallback()
      {
        public final void call(ITransmitKvData paramAnonymousITransmitKvData)
        {
          AppMethodBeat.i(316439);
          if (paramAnonymousITransmitKvData == null)
          {
            Log.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: verifyPwdPay fail, data is null");
            WalletLqtCheckPwdInputDialogUI.this.finish();
            AppMethodBeat.o(316439);
            return;
          }
          if (paramAnonymousITransmitKvData.getInt("retCode") == 0)
          {
            Intent localIntent = new Intent();
            localIntent.putExtra("lqt_fetch_enc_pwd", paramAnonymousITransmitKvData.getString("pwd"));
            localIntent.putExtra("lqt_redeem_listid", WalletLqtCheckPwdInputDialogUI.a(WalletLqtCheckPwdInputDialogUI.this));
            WalletLqtCheckPwdInputDialogUI.this.setResult(-1, localIntent);
          }
          WalletLqtCheckPwdInputDialogUI.this.finish();
          AppMethodBeat.o(316439);
        }
      });
      AppMethodBeat.o(68785);
      return;
    }
    if ((this.Vbq != null) && (this.Vbq.isShowing())) {
      this.Vbq.dismiss();
    }
    this.Vbq = new WcPayCashierDialog(getContext());
    this.Vbq.a(this.mTitle, this.Vbp, "", null);
    this.Vbq.VUX = new WcPayCashierDialog.a()
    {
      public final void a(String paramAnonymousString, FavorPayInfo paramAnonymousFavorPayInfo, Bankcard paramAnonymousBankcard)
      {
        AppMethodBeat.i(316443);
        paramAnonymousFavorPayInfo = new Intent();
        paramAnonymousFavorPayInfo.putExtra("lqt_fetch_enc_pwd", paramAnonymousString);
        paramAnonymousFavorPayInfo.putExtra("lqt_redeem_listid", WalletLqtCheckPwdInputDialogUI.a(WalletLqtCheckPwdInputDialogUI.this));
        WalletLqtCheckPwdInputDialogUI.this.setResult(-1, paramAnonymousFavorPayInfo);
        WalletLqtCheckPwdInputDialogUI.this.finish();
        AppMethodBeat.o(316443);
      }
      
      public final void ieE() {}
      
      public final void onCancel()
      {
        AppMethodBeat.i(316446);
        Log.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
        WalletLqtCheckPwdInputDialogUI.this.finish();
        AppMethodBeat.o(316446);
      }
    };
    this.Vbq.show();
    addDialog(this.Vbq);
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
      fpM();
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
    this.Vbp = getIntent().getStringExtra("lqt_fetch_pwd_money");
    this.VaV = getIntent().getStringExtra("lqt_redeem_listid");
    Log.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s, redeemListId: %s", new Object[] { Util.nullAsNil(this.Vbp), Util.nullAsNil(this.mTitle), this.VaV });
    if ((!Util.isNullOrNil(this.mTitle)) && (!Util.isNullOrNil(this.Vbp))) {}
    while (i == 0)
    {
      k.a(getContext(), a.i.wallet_order_info_err, 0, new DialogInterface.OnClickListener()
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
    getWindow().setBackgroundDrawableResource(a.c.transparent);
    d.Pmb.asyncReportPaySecurityInfoThroughCgi();
    fpM();
    AppMethodBeat.o(68784);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI
 * JD-Core Version:    0.7.0.1
 */