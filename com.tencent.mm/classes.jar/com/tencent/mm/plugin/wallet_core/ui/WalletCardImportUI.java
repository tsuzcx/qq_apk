package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.e.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletCardImportUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private static final String[] qCr = { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT" };
  private Button fpF;
  private String lJI;
  private String lJJ;
  private Dialog mDialog = null;
  private ah mHandler = new ah();
  private PayInfo nDu = null;
  private Orders nEh = null;
  private WalletFormView qAx;
  private WalletFormView qBA;
  private WalletFormView qBB;
  private WalletFormView qBC;
  private WalletFormView qBD;
  private WalletFormView qBE;
  private WalletFormView qBF;
  private WalletFormView qBG;
  private WalletFormView qBJ = null;
  private WalletFormView qBK;
  private CheckBox qBO;
  private String qBP;
  private WalletFormView qBX;
  private WalletFormView qBq;
  private WalletFormView qBr;
  private WalletFormView qBt;
  private WalletFormView qBu;
  private TextView qCs;
  private MMScrollView qCt;
  private Bankcard qCu = null;
  private CheckBox qCv;
  private BaseAdapter qCw = new WalletCardImportUI.9(this);
  private Authen qmd = new Authen();
  private WalletFormView qpk;
  private int qpo = 1;
  private ElementQuery qsa = new ElementQuery();
  
  private boolean YH()
  {
    if (!this.qCv.isChecked()) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool)
      {
        this.fpF.setEnabled(true);
        this.fpF.setClickable(true);
        return bool;
      }
      this.fpF.setEnabled(false);
      this.fpF.setClickable(false);
      return bool;
    }
  }
  
  private void aZ()
  {
    Object localObject1;
    label86:
    Object localObject2;
    label189:
    Object localObject3;
    if (this.qCu != null)
    {
      findViewById(a.f.wallet_card_safeguard_tip).setVisibility(0);
      if (bk.bl(this.BX.getString("key_bank_username"))) {
        break label543;
      }
      localObject1 = this.BX.getString("key_recommand_desc");
      if (!bk.bl((String)localObject1)) {
        break label532;
      }
      this.qBO.setText(getString(a.i.wallet_card_follow_bank_tips, new Object[] { this.qCu.field_bankName }));
      this.qBO.setVisibility(0);
      this.qBA.setVisibility(8);
      this.qBB.setVisibility(8);
      this.qBC.setVisibility(8);
      this.qBD.setVisibility(8);
      this.qBE.setVisibility(8);
      this.qBF.setVisibility(8);
      this.qBG.setVisibility(8);
      if ((bk.bl(this.qCu.field_bankcardTail)) || (!b(this.qBK, this.qCu.qtu))) {
        break label555;
      }
      localObject1 = this.qBK;
      localObject2 = this.qBK;
      if (!this.qCu.bUS()) {
        break label571;
      }
      localObject3 = getString(a.i.wallet_credit_card);
      label207:
      if ((bk.bl(this.qCu.field_bankName)) || (!b(this.qBX, this.qCu.field_bankName + " " + (String)localObject3))) {
        break label582;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.qBX;
      }
      localObject3 = this.qBX;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (b(this.qAx, this.qCu.field_trueName))
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.qAx;
        }
        localObject3 = this.qAx;
      }
      localObject2 = localObject1;
      if (b(this.qBt, o.bVA().O(this.mController.uMN, this.qCu.qsL)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.qBt;
        }
        localObject3 = this.qBt;
      }
      localObject1 = localObject2;
      if (b(this.qpk, this.qCu.qtt))
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.qpk;
        }
        localObject3 = this.qpk;
      }
      localObject2 = localObject1;
      if (b(this.qBu, this.qCu.field_mobile))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.qBu;
        }
        localObject3 = this.qBu;
      }
      localObject1 = localObject2;
      if (b(this.qBr, this.qCu.qsN))
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.qBr;
        }
        localObject3 = this.qBr;
      }
      localObject2 = localObject1;
      if (b(this.qBq, this.qCu.qtv))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this.qBq;
        }
        localObject3 = this.qBq;
      }
      ((WalletFormView)localObject2).setBackgroundResource(a.e.comm_list_item_selector);
      ((WalletFormView)localObject3).setBackgroundResource(a.e.comm_list_item_selector);
      if (!o.bVs().bVK()) {
        break label598;
      }
      this.fpF.setText(a.i.wallet_card_import_first);
      return;
      label532:
      this.qBO.setText((CharSequence)localObject1);
      break;
      label543:
      this.qBO.setVisibility(8);
      break label86;
      label555:
      this.qBK.setVisibility(8);
      localObject2 = null;
      localObject1 = null;
      break label189;
      label571:
      localObject3 = getString(a.i.wallet_deposit_card);
      break label207;
      label582:
      this.qBX.setVisibility(8);
      localObject3 = localObject2;
      localObject2 = localObject1;
    }
    label598:
    this.fpF.setText(a.i.wallet_card_import);
  }
  
  private static boolean b(WalletFormView paramWalletFormView, String paramString)
  {
    if (!bk.bl(paramString))
    {
      KeyListener localKeyListener = paramWalletFormView.getKeyListener();
      paramWalletFormView.setKeyListener(null);
      paramWalletFormView.setEnabled(false);
      paramWalletFormView.setClickable(false);
      paramWalletFormView.setText(paramString);
      paramWalletFormView.setKeyListener(localKeyListener);
      paramWalletFormView.setVisibility(0);
      return true;
    }
    paramWalletFormView.setVisibility(8);
    return false;
  }
  
  private void bWy()
  {
    if (YH())
    {
      c.bXt();
      this.qmd = new Authen();
      this.BX.putBoolean("key_is_follow_bank_username", this.qBO.isChecked());
      if ((this.qCu != null) && (!bk.bl(this.qCu.qtG)))
      {
        this.qmd.qjv = this.qCu.qtG;
        this.qmd.mOc = this.qCu.field_bindSerial;
        this.qmd.mOb = this.qCu.field_bankcardType;
        this.qmd.qsL = this.qCu.qsL;
        this.qmd.qsI = this.BX.getString("key_pwd1");
        this.qmd.token = this.BX.getString("kreq_token");
        com.tencent.mm.wallet_core.a.aj(this);
        if (!cNk().m(new Object[] { this.qmd, this.nEh })) {
          break label591;
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
      }
    }
    else
    {
      return;
    }
    Object localObject = this.BX.getString("key_card_id");
    if (this.qBK.getVisibility() == 0) {
      localObject = this.qBK.getText();
    }
    for (;;)
    {
      this.qmd.nqa = ((PayInfo)this.BX.getParcelable("key_pay_info"));
      this.qmd.qsM = ((String)localObject);
      this.qmd.mOb = this.qsa.mOb;
      this.qmd.qsL = this.qpo;
      this.qmd.qsI = this.BX.getString("key_pwd1");
      if (!bk.bl(this.qBr.getText())) {
        this.qmd.qsN = this.qBr.getText();
      }
      this.qmd.qqU = this.qBu.getText();
      this.qmd.qsR = this.qBA.getText();
      this.qmd.qsS = this.qBB.getText();
      this.qmd.country = this.qBP;
      this.qmd.cCA = this.lJI;
      this.qmd.cCB = this.lJJ;
      this.qmd.ekZ = this.qBD.getText();
      this.qmd.lnV = this.qBE.getText();
      this.qmd.ftq = this.qBF.getText();
      this.qmd.cCt = this.qBG.getText();
      localObject = e.afk(this.qmd.qqU);
      this.BX.putString("key_mobile", (String)localObject);
      localObject = this.BX;
      if (this.qsa.qqY == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
        this.qmd.qsK = this.qpk.getText();
        this.qmd.qsJ = this.qAx.getText();
        this.qmd.qsO = this.qBq.getText();
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.qmd.nqa + " elemt.bankcardTag : " + this.qsa.qqY);
        break;
      }
      label591:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      return;
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.BX;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.nDu);
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.y))
      {
        paramString.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.j(this, paramString);
        h.bC(this, getString(a.i.wallet_bank_card_bind_success_tips));
        return true;
      }
      return false;
    }
    return false;
  }
  
  public final void gG(boolean paramBoolean)
  {
    YH();
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_card_import_ui;
  }
  
  protected final void initView()
  {
    this.qBK = ((WalletFormView)findViewById(a.f.wallet_card_forgot_id));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.qBK);
    this.qBu = ((WalletFormView)findViewById(a.f.mobile_et));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.qBu);
    this.qAx = ((WalletFormView)findViewById(a.f.name_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.qAx);
    this.qBt = ((WalletFormView)findViewById(a.f.wallet_cre_type));
    this.qpk = ((WalletFormView)findViewById(a.f.identity_et));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.qpk);
    this.qBX = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.qBr = ((WalletFormView)findViewById(a.f.cvv_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.qBr);
    this.qBq = ((WalletFormView)findViewById(a.f.date_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.qBq);
    this.qCs = ((TextView)findViewById(a.f.wallet_power_by_tenpay));
    this.qBA = ((WalletFormView)findViewById(a.f.first_name_et));
    this.qBB = ((WalletFormView)findViewById(a.f.last_name_et));
    this.qBC = ((WalletFormView)findViewById(a.f.area_et));
    this.qBD = ((WalletFormView)findViewById(a.f.address_et));
    this.qBE = ((WalletFormView)findViewById(a.f.phone_et));
    this.qBF = ((WalletFormView)findViewById(a.f.post_et));
    this.qBG = ((WalletFormView)findViewById(a.f.email_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.qBG);
    this.qCv = ((CheckBox)findViewById(a.f.agree_wx_cb));
    this.qBO = ((CheckBox)findViewById(a.f.agree_follow_bank_cb));
    this.fpF = ((Button)findViewById(a.f.next_btn));
    this.qCt = ((MMScrollView)findViewById(a.f.wallet_sv));
    MMScrollView localMMScrollView = this.qCt;
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.qCt.setOnSizeChangeListener(new WalletCardImportUI.1(this));
    this.qAx.setOnInputValidChangeListener(this);
    this.qBK.setOnInputValidChangeListener(this);
    this.qBt.setOnInputValidChangeListener(this);
    this.qpk.setOnInputValidChangeListener(this);
    this.qBu.setOnInputValidChangeListener(this);
    this.qBr.setOnInputValidChangeListener(this);
    this.qBq.setOnInputValidChangeListener(this);
    this.qBA.setOnInputValidChangeListener(this);
    this.qBB.setOnInputValidChangeListener(this);
    this.qBC.setOnInputValidChangeListener(this);
    this.qBD.setOnInputValidChangeListener(this);
    this.qBE.setOnInputValidChangeListener(this);
    this.qBF.setOnInputValidChangeListener(this);
    this.qBG.setOnInputValidChangeListener(this);
    this.qAx.setOnEditorActionListener(this);
    this.qBK.setOnEditorActionListener(this);
    this.qBt.setOnEditorActionListener(this);
    this.qpk.setOnEditorActionListener(this);
    this.qBu.setOnEditorActionListener(this);
    this.qBr.setOnEditorActionListener(this);
    this.qBq.setOnEditorActionListener(this);
    this.qBA.setOnEditorActionListener(this);
    this.qBB.setOnEditorActionListener(this);
    this.qBC.setOnEditorActionListener(this);
    this.qBD.setOnEditorActionListener(this);
    this.qBE.setOnEditorActionListener(this);
    this.qBF.setOnEditorActionListener(this);
    this.qBG.setOnEditorActionListener(this);
    this.qBX.setOnClickListener(new WalletCardImportUI.2(this));
    this.qBt.setOnClickListener(new WalletCardImportUI.3(this));
    this.qCv.setChecked(true);
    this.qCv.setOnCheckedChangeListener(new WalletCardImportUI.4(this));
    this.qBO.setChecked(true);
    findViewById(a.f.agree_btn).setOnClickListener(new WalletCardImportUI.5(this));
    this.qBC.setOnClickListener(new WalletCardImportUI.6(this));
    this.fpF.setOnClickListener(new WalletCardImportUI.7(this));
    aZ();
    YH();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt2 != -1) {
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      YH();
      return;
      this.qsa = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
      aZ();
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.qBP = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bk.bl(paramIntent.getStringExtra("Contact_City")))
      {
        this.lJI = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.lJJ = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        this.qBC.setText(str1 + " " + str4);
      }
      for (;;)
      {
        if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.qsa.qvs)) {
          break label406;
        }
        this.qBF.setVisibility(0);
        break;
        if (!bk.bl(paramIntent.getStringExtra("Contact_Province")))
        {
          this.lJJ = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.qBC.setText(str1 + " " + str3);
        }
        else
        {
          this.lJJ = this.qBP;
          this.qBC.setText(str1);
        }
      }
      label406:
      this.qBF.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_elment_title);
    this.qsa = ((ElementQuery)this.BX.getParcelable("elemt_query"));
    this.nEh = ((Orders)this.BX.getParcelable("key_orders"));
    this.nDu = ((PayInfo)this.BX.getParcelable("key_pay_info"));
    this.qCu = ((Bankcard)this.BX.getParcelable("key_import_bankcard"));
    if (this.nDu == null) {
      this.nDu = new PayInfo();
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.nDu);
    initView();
    this.qCt.pageScroll(33);
    c.a(this, this.BX, 3);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    i locali = new i(this, a.j.SelectorDialog);
    locali.setContentView(a.g.wallet_list_dialog);
    ListView localListView = (ListView)locali.findViewById(a.f.address_contactlist);
    localListView.setAdapter(this.qCw);
    localListView.setOnItemClickListener(new WalletCardImportUI.8(this));
    return locali;
  }
  
  public void onDestroy()
  {
    if ((this.mDialog != null) && (this.mDialog.isShowing()))
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
    super.onDestroy();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + paramInt);
    switch (paramInt)
    {
    default: 
      if (this.qBJ == null) {
        bWy();
      }
      return false;
    }
    if (this.qBJ != null) {
      if ((this.qBJ.isEnabled()) && (!this.qBJ.isClickable()) && (this.qBJ.cNv())) {
        this.qBJ.cNx();
      }
    }
    for (;;)
    {
      return true;
      this.qBJ.performClick();
      continue;
      bWy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI
 * JD-Core Version:    0.7.0.1
 */