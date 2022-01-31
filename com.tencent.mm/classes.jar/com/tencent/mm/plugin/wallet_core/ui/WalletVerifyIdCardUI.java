package com.tencent.mm.plugin.wallet_core.ui;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.c.l.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;

public class WalletVerifyIdCardUI
  extends WalletBaseUI
{
  private TextView haW;
  private boolean qHc = false;
  private com.tencent.mm.plugin.wallet_core.model.h qHe = new com.tencent.mm.plugin.wallet_core.model.h();
  private l.a qHf = new l.a()
  {
    public final void bXc()
    {
      WalletVerifyIdCardUI.b(WalletVerifyIdCardUI.this);
    }
  };
  private EditHintPasswdView qHl;
  
  private boolean bXd()
  {
    return this.BX.getBoolean("key_is_oversea", false);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    if ((paramm instanceof l))
    {
      if ((paramInt2 == 0) || (!((l)paramm).bZB)) {
        break label54;
      }
      com.tencent.mm.ui.base.h.a(this.mController.uMN, paramString, null, false, new WalletVerifyIdCardUI.3(this));
    }
    for (;;)
    {
      bool = true;
      return bool;
      label54:
      this.qHl.bvr();
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_verify_idcard_ui;
  }
  
  protected final void initView()
  {
    this.haW = ((TextView)findViewById(a.f.wviu_title_tv));
    this.qHl = ((EditHintPasswdView)findViewById(a.f.wviu_tail_et));
    String str1 = this.BX.getString("key_true_name");
    String str2 = this.BX.getString("key_cre_name");
    String str3 = this.BX.getString("key_cre_type");
    this.haW.setText(getString(a.i.wallet_idcard_tail_title, new Object[] { str1, str2 }));
    this.qHl.setEditTextMaxLength(4);
    this.qHl.setEditTextSize(34.0F);
    this.qHl.setOnInputValidListener(new WalletVerifyIdCardUI.2(this));
    if ("1".equals(str3))
    {
      e(this.qHl, 1, false);
      return;
    }
    e(this.qHl, 1, true);
  }
  
  public final boolean j(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.WalletVerifyIdCardUI", "onPreSceneEnd %s %s", new Object[] { Integer.valueOf(paramInt2), paramm });
    if (((paramm instanceof l)) && (paramInt2 == 0))
    {
      this.qHc = true;
      com.tencent.mm.ui.base.s.makeText(this, a.i.wallet_password_setting_digitalcert_install_verify_install_toast, 0).show();
      y.i("MicroMsg.WalletVerifyIdCardUI", "tag it isCertInstalled ok");
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qHe = new com.tencent.mm.plugin.wallet_core.model.h(this.BX);
    initView();
    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.white)));
    paramBundle = getSupportActionBar().getCustomView();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.findViewById(a.f.divider);
      if (paramBundle != null) {
        paramBundle.setBackgroundColor(getResources().getColor(a.c.transparent));
      }
    }
    if (d.gF(21))
    {
      if (!d.gF(23)) {
        break label145;
      }
      getWindow().setStatusBarColor(-1);
      getWindow().getDecorView().setSystemUiVisibility(8192);
    }
    for (;;)
    {
      setMMTitle("");
      setBackBtn(new WalletVerifyIdCardUI.1(this), a.h.actionbar_icon_dark_back);
      return;
      label145:
      getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI
 * JD-Core Version:    0.7.0.1
 */