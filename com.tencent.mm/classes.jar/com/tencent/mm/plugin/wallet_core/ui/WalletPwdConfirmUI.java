package com.tencent.mm.plugin.wallet_core.ui;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.tr;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

@com.tencent.mm.ui.base.a(19)
public class WalletPwdConfirmUI
  extends WalletBaseUI
{
  private com.tencent.mm.sdk.b.c dii = new WalletPwdConfirmUI.6(this);
  private TextView haW;
  private TextView irN;
  public EditHintPasswdView llh;
  private PayInfo nDu;
  private TextView qFm;
  private boolean qFn = false;
  private am qFo = new am(new am.a()
  {
    public final boolean tC()
    {
      if (WalletPwdConfirmUI.c(WalletPwdConfirmUI.this))
      {
        WalletPwdConfirmUI.d(WalletPwdConfirmUI.this);
        WalletPwdConfirmUI.e(WalletPwdConfirmUI.this);
      }
      return false;
    }
  }, false);
  
  private void bWO()
  {
    Bundle localBundle = this.BX;
    localBundle.putBoolean("intent_bind_end", true);
    com.tencent.mm.wallet_core.a.j(this, localBundle);
  }
  
  protected final boolean aSl()
  {
    return true;
  }
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.BX.putString("key_pwd1", this.llh.getText());
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y)) {
        if (!this.qFn) {
          bWO();
        }
      }
      for (;;)
      {
        return true;
        if ((com.tencent.mm.wallet_core.a.aj(this) != null) && (com.tencent.mm.wallet_core.a.aj(this).c(this, null)))
        {
          if (this.nDu != null) {}
          for (paramString = this.nDu.bMX;; paramString = "")
          {
            a(new com.tencent.mm.plugin.wallet_core.c.y(paramString, 22), true, false);
            paramString = new tr();
            if (com.tencent.mm.sdk.b.a.udP.T(paramString.getClass()))
            {
              this.qFn = true;
              com.tencent.mm.sdk.b.a.udP.m(paramString);
            }
            this.qFo.S(10000L, 10000L);
            break;
          }
        }
        com.tencent.mm.wallet_core.a.j(this, this.BX);
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
    return a.g.wallet_set_pwd;
  }
  
  protected final void initView()
  {
    this.haW = ((TextView)findViewById(a.f.wallet_pwd_title));
    this.irN = ((TextView)findViewById(a.f.wallet_pwd_content));
    if ((cNj() != null) && ("ModifyPwdProcess".equals(cNj().aTh()))) {
      this.haW.setText(a.i.wallet_modify_password_title);
    }
    this.irN.setText(a.i.wallet_set_password_hint_2);
    this.qFm = ((TextView)findViewById(a.f.input_finish));
    if (!bk.L(cNl())) {
      this.qFm.setText(a.i.wallet_set_password_pay_tips);
    }
    for (;;)
    {
      this.qFm.setVisibility(0);
      this.qFm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject = WalletPwdConfirmUI.this.BX.getString("key_new_pwd1");
          String str2 = WalletPwdConfirmUI.this.llh.getMd5Value();
          paramAnonymousView = WalletPwdConfirmUI.this.BX.getString("kreq_token");
          String str1 = WalletPwdConfirmUI.this.BX.getString("key_verify_code");
          com.tencent.mm.sdk.platformtools.y.d("Micromsg.WalletPwdConfirmUI", "mPayInfo " + WalletPwdConfirmUI.a(WalletPwdConfirmUI.this) + " vertifyCode: " + str1);
          if ((localObject != null) && (((String)localObject).equals(str2)))
          {
            localObject = new p();
            ((p)localObject).feN = WalletPwdConfirmUI.this.llh.getText();
            ((p)localObject).nqa = WalletPwdConfirmUI.a(WalletPwdConfirmUI.this);
            ((p)localObject).token = paramAnonymousView;
            ((p)localObject).qyu = str1;
            ((p)localObject).qyv = WalletPwdConfirmUI.this.BX.getBoolean("key_is_bind_bankcard", true);
            if (!com.tencent.mm.wallet_core.a.aj(WalletPwdConfirmUI.this).bXd()) {}
            for (((p)localObject).flag = "1";; ((p)localObject).flag = "4")
            {
              paramAnonymousView = (FavorPayInfo)WalletPwdConfirmUI.this.BX.getParcelable("key_favor_pay_info");
              if (paramAnonymousView != null)
              {
                ((p)localObject).qsT = paramAnonymousView.qvF;
                ((p)localObject).qsU = paramAnonymousView.qvC;
              }
              WalletPwdConfirmUI.this.cNk().m(new Object[] { localObject });
              return;
            }
          }
          com.tencent.mm.wallet_core.a.n(WalletPwdConfirmUI.this, -1002);
        }
      });
      this.qFm.setEnabled(false);
      this.qFm.setClickable(false);
      this.llh = ((EditHintPasswdView)findViewById(a.f.input_et));
      com.tencent.mm.wallet_core.ui.formview.a.a(this.llh);
      this.llh.setEditTextMaxLength(6);
      this.llh.setOnInputValidListener(new WalletPwdConfirmUI.3(this));
      findViewById(a.f.bind_wallet_verify_hint).setVisibility(8);
      e(this.llh, 0, false);
      this.lTH = new WalletPwdConfirmUI.4(this, (ScrollView)findViewById(a.f.root_view));
      return;
      this.qFm.setText(a.i.app_finish);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    this.nDu = ((PayInfo)this.BX.getParcelable("key_pay_info"));
    initView();
    com.tencent.mm.plugin.wallet_core.e.c.a(this, this.BX, 6);
    findViewById(a.f.close_button).setOnClickListener(new WalletPwdConfirmUI.1(this));
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
  
  public void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.b.a.udP.d(this.dii);
  }
  
  public void onResume()
  {
    this.llh.requestFocus();
    super.onResume();
    com.tencent.mm.sdk.b.a.udP.c(this.dii);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI
 * JD-Core Version:    0.7.0.1
 */