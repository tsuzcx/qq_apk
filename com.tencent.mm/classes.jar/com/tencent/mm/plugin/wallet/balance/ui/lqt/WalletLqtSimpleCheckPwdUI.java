package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@com.tencent.mm.ui.base.a(1)
public class WalletLqtSimpleCheckPwdUI
  extends WalletBaseUI
{
  private EditHintPasswdView llh;
  private r qjm;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof r))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.llh.getText();
        paramm = new Intent();
        paramm.putExtra("lqt_enc_pwd", paramString);
        setResult(-1, paramm);
        finish();
        return true;
      }
      if (this.llh != null) {
        this.llh.bvr();
      }
    }
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_lqt_simple_check_pwd_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (q.Gw()) {}
    for (paramBundle = getString(a.i.wallet_check_pwd_title_payu);; paramBundle = getString(a.i.wallet_check_pwd_title))
    {
      setMMTitle(paramBundle);
      setBackBtn(new WalletLqtSimpleCheckPwdUI.1(this));
      ((TextView)findViewById(a.f.input_tip)).setText(a.i.wallet_check_pwd_tip);
      this.llh = ((EditHintPasswdView)findViewById(a.f.input_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.llh);
      this.llh.setOnInputValidListener(new WalletLqtSimpleCheckPwdUI.2(this));
      e(this.llh, 0, false);
      return;
    }
  }
  
  public final void st(int paramInt)
  {
    super.st(paramInt);
    if (this.llh != null) {
      this.llh.bvr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSimpleCheckPwdUI
 * JD-Core Version:    0.7.0.1
 */