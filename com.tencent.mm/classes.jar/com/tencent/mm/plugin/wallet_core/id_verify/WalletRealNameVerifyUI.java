package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.d;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;

public class WalletRealNameVerifyUI
  extends WalletBaseUI
  implements View.OnClickListener, WalletFormView.a
{
  private String countryCode;
  private String dXu;
  private String dXv;
  private Button frP;
  private TextView lyN;
  private WalletFormView qrU;
  private WalletFormView qrV;
  private WalletFormView qrW;
  private WalletFormView qrX;
  private CheckBox qrY;
  private TextView qrZ;
  private Profession[] qrb;
  private ElementQuery qsa;
  private Profession qsb;
  private boolean qsc = false;
  private boolean qsd = false;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof d))
      {
        c localc = cNj();
        paramString = null;
        if (localc != null) {
          paramString = localc.kke;
        }
        paramm = ((d)paramm).token;
        y.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
        if (localc != null)
        {
          paramString.putString("key_real_name_token", paramm);
          paramString.putString("key_country_code", this.countryCode);
          paramString.putString("key_province_code", this.dXv);
          paramString.putString("key_city_code", this.dXu);
          paramString.putParcelable("key_profession", this.qsb);
          localc.a(this, 0, paramString);
        }
        return true;
      }
      if ((paramm instanceof g))
      {
        paramString = (g)paramm;
        if (paramString.qqZ == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.qsc = bool1;
          bool1 = bool2;
          if (paramString.qra == 1) {
            bool1 = true;
          }
          this.qsd = bool1;
          if (!this.qsd) {
            this.qrW.setVisibility(8);
          }
          if (!this.qsc) {
            this.qrX.setVisibility(8);
          }
          if ((this.qsc) || (this.qsd)) {
            this.qrZ.setText(a.i.wallet_real_name_verify_desc2);
          }
          this.qrb = paramString.qss;
          return true;
        }
      }
    }
    else
    {
      y.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
    }
    return false;
  }
  
  public final void gG(boolean paramBoolean)
  {
    y.d("MicroMsg.WalletRealNameVerifyUI", "check info");
    String str1 = this.qrU.getText();
    String str2 = this.qrV.getText();
    int i;
    if (bk.bl(str1)) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        this.frP.setEnabled(false);
        this.frP.setClickable(false);
        return;
        if (bk.bl(str2))
        {
          i = 0;
          continue;
        }
        if (this.qsc)
        {
          if ((!bk.bl(this.countryCode)) || (!bk.bl(this.dXv)) || (!bk.bl(this.dXu))) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label120;
            }
            i = 0;
            break;
          }
        }
        label120:
        if ((this.qsd) && (this.qsb == null)) {
          i = 0;
        }
      }
      else
      {
        this.frP.setEnabled(true);
        this.frP.setClickable(true);
        return;
      }
      i = 1;
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_real_name_verify_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_real_name_verify_title);
    this.frP = ((Button)findViewById(a.f.next_btn));
    this.qrU = ((WalletFormView)findViewById(a.f.name_et));
    this.qrV = ((WalletFormView)findViewById(a.f.card_num_et));
    this.qrW = ((WalletFormView)findViewById(a.f.private_profession_et));
    this.qrX = ((WalletFormView)findViewById(a.f.private_address_et));
    this.qrZ = ((TextView)findViewById(a.f.input_tip));
    this.qrU.setOnInputValidChangeListener(this);
    this.qrV.setOnInputValidChangeListener(this);
    this.qrW.setOnInputValidChangeListener(this);
    this.qrX.setOnInputValidChangeListener(this);
    this.qrU.setFocusable(true);
    this.qrU.getInfoIv().setVisibility(8);
    a.d(this.qrV);
    b localb = this.qrV.getLogicDelegate();
    if ((localb instanceof a.a)) {
      ((a.a)localb).Jd(1);
    }
    this.qrW.setOnClickListener(new WalletRealNameVerifyUI.1(this));
    this.qrX.setOnClickListener(new WalletRealNameVerifyUI.2(this));
    this.frP.setOnClickListener(new WalletRealNameVerifyUI.3(this));
    e(this.qrV, 1, false);
    setBackBtn(new WalletRealNameVerifyUI.4(this));
    this.qrY = ((CheckBox)findViewById(a.f.agree_wx_cb));
    this.lyN = ((TextView)findViewById(a.f.agree_tv));
    this.qrY.setChecked(true);
    this.qrY.setOnCheckedChangeListener(new WalletRealNameVerifyUI.5(this));
    this.lyN.setOnClickListener(new WalletRealNameVerifyUI.6(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      if (paramInt2 == -1)
      {
        this.qsb = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
        this.qrW.setText(this.qsb.qst);
      }
    }
    while (paramInt1 != 2)
    {
      return;
      y.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
      return;
    }
    if (paramInt2 == -1)
    {
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("ProviceName");
      String str3 = paramIntent.getStringExtra("CityName");
      this.countryCode = paramIntent.getStringExtra("Country");
      this.dXv = paramIntent.getStringExtra("Contact_Province");
      this.dXu = paramIntent.getStringExtra("Contact_City");
      paramIntent = new StringBuilder();
      if (!bk.bl(str1)) {
        paramIntent.append(str1);
      }
      if (!bk.bl(str2)) {
        paramIntent.append(" ").append(str2);
      }
      if (!bk.bl(str3)) {
        paramIntent.append(" ").append(str3);
      }
      this.qrX.setText(paramIntent.toString());
      return;
    }
    y.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.wCh.kh(1616);
    this.qsa = ((ElementQuery)this.BX.getParcelable("elemt_query"));
    initView();
    a(new g(), true, false);
  }
  
  public void onDestroy()
  {
    this.wCh.ki(1616);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI
 * JD-Core Version:    0.7.0.1
 */