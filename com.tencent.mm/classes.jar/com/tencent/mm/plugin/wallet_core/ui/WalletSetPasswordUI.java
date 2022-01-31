package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@com.tencent.mm.ui.base.a(19)
public class WalletSetPasswordUI
  extends WalletBaseUI
{
  private TextView haW;
  private TextView irN;
  public EditHintPasswdView llh;
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_set_pwd;
  }
  
  protected final void initView()
  {
    this.haW = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.irN = ((TextView)findViewById(a.f.wallet_pwd_content));
    if ((this.BX.getBoolean("key_is_forgot_process", false)) && (!bk.bl(this.BX.getString("key_identity"))) && (this.BX.getInt("key_id_type", -1) != -1) && (!bk.bl(this.BX.getString("key_true_name")))) {
      this.irN.setVisibility(4);
    }
    if ((cNj() != null) && ("ModifyPwdProcess".equals(cNj().aTh()))) {
      this.haW.setText(a.i.wallet_modify_password_title);
    }
    TextView localTextView;
    if (this.BX.getInt("key_err_code", 0) == -1002)
    {
      localTextView = (TextView)findViewById(a.f.input_err);
      localTextView.setVisibility(0);
      if (!q.Gw()) {
        break label245;
      }
    }
    label245:
    for (String str = getString(a.i.wallet_set_password_no_same_payu);; str = getString(a.i.wallet_set_password_no_same))
    {
      localTextView.setText(str);
      this.BX.putInt("key_err_code", 0);
      this.llh = ((EditHintPasswdView)findViewById(a.f.input_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.llh);
      findViewById(a.f.bind_wallet_verify_hint).setVisibility(8);
      this.llh.setOnInputValidListener(new WalletSetPasswordUI.2(this));
      e(this.llh, 0, false);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    initView();
    com.tencent.mm.plugin.wallet_core.e.c.a(this, this.BX, 5);
    findViewById(a.f.close_button).setOnClickListener(new WalletSetPasswordUI.1(this));
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(a.c.white));
      if (Build.VERSION.SDK_INT >= 23) {
        paramBundle.getDecorView().setSystemUiVisibility(8192);
      }
    }
    this.mController.contentView.setFitsSystemWindows(true);
  }
  
  public void onResume()
  {
    this.llh.requestFocus();
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI
 * JD-Core Version:    0.7.0.1
 */