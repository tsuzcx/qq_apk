package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletLqtCheckPwdInputDialogUI
  extends WalletBaseUI
{
  private String mTitle = "";
  private String qgb;
  private String qgn = "";
  private o qgo;
  
  private void showDialog()
  {
    if ((this.qgo != null) && (this.qgo.isShowing())) {
      this.qgo.dismiss();
    }
    if (this.qgo == null)
    {
      this.qgn = e.B(bk.getDouble(this.qgn, 0.0D));
      this.qgo = o.a(this, this.mTitle, this.qgn, "", new WalletLqtCheckPwdInputDialogUI.2(this), new WalletLqtCheckPwdInputDialogUI.3(this), new WalletLqtCheckPwdInputDialogUI.4(this));
      return;
    }
    this.qgo.bvr();
    this.qgo.show();
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    super.onCreate(paramBundle);
    vN(4);
    this.mTitle = getIntent().getStringExtra("lqt_fetch_pwd_title");
    this.qgn = getIntent().getStringExtra("lqt_fetch_pwd_money");
    this.qgb = getIntent().getStringExtra("lqt_redeem_listid");
    y.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s, redeemListId: %s", new Object[] { bk.pm(this.qgn), bk.pm(this.mTitle), this.qgb });
    if ((!bk.bl(this.mTitle)) && (!bk.bl(this.qgn))) {}
    while (i == 0)
    {
      h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new WalletLqtCheckPwdInputDialogUI.1(this));
      return;
      i = 0;
    }
    getWindow().setBackgroundDrawableResource(a.c.transparent);
    showDialog();
  }
  
  public final void st(int paramInt)
  {
    if (paramInt == 0) {
      finish();
    }
    while (paramInt != 1) {
      return;
    }
    showDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI
 * JD-Core Version:    0.7.0.1
 */