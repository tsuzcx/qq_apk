package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.List;

public class WalletCardImportUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private static final String[] upb = { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT" };
  private Button gHb;
  private Dialog mDialog;
  private ak mHandler;
  private PayInfo mPayInfo;
  private String ogW;
  private String ogX;
  private Orders qrf;
  private Authen tVs;
  private int tZB;
  private WalletFormView tZx;
  private ElementQuery udb;
  private WalletFormView unh;
  private CheckBox uoA;
  private String uoB;
  private WalletFormView uoK;
  private WalletFormView uob;
  private WalletFormView uoc;
  private WalletFormView uoe;
  private WalletFormView uof;
  private WalletFormView uom;
  private WalletFormView uon;
  private WalletFormView uoo;
  private WalletFormView uop;
  private WalletFormView uoq;
  private WalletFormView uor;
  private WalletFormView uos;
  private WalletFormView uov;
  private WalletFormView uow;
  private TextView upc;
  private MMScrollView upd;
  private Bankcard upe;
  private CheckBox upf;
  private BaseAdapter upg;
  
  public WalletCardImportUI()
  {
    AppMethodBeat.i(47278);
    this.mDialog = null;
    this.uov = null;
    this.mHandler = new ak();
    this.udb = new ElementQuery();
    this.tVs = new Authen();
    this.qrf = null;
    this.mPayInfo = null;
    this.upe = null;
    this.tZB = 1;
    this.upg = new WalletCardImportUI.9(this);
    AppMethodBeat.o(47278);
  }
  
  private boolean asr()
  {
    AppMethodBeat.i(47287);
    if (!this.upf.isChecked()) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool)
      {
        this.gHb.setEnabled(true);
        this.gHb.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(47287);
        return bool;
        this.gHb.setEnabled(false);
        this.gHb.setClickable(false);
      }
    }
  }
  
  private static boolean b(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(47282);
    if (!bo.isNullOrNil(paramString))
    {
      KeyListener localKeyListener = paramWalletFormView.getKeyListener();
      paramWalletFormView.setKeyListener(null);
      paramWalletFormView.setEnabled(false);
      paramWalletFormView.setClickable(false);
      paramWalletFormView.setText(paramString);
      paramWalletFormView.setKeyListener(localKeyListener);
      paramWalletFormView.setVisibility(0);
      AppMethodBeat.o(47282);
      return true;
    }
    paramWalletFormView.setVisibility(8);
    AppMethodBeat.o(47282);
    return false;
  }
  
  private void bJ()
  {
    AppMethodBeat.i(47281);
    if (this.upe != null)
    {
      findViewById(2131829041).setVisibility(0);
      Object localObject1;
      label89:
      Object localObject2;
      label133:
      Object localObject3;
      if (!bo.isNullOrNil(getInput().getString("key_bank_username")))
      {
        localObject1 = getInput().getString("key_recommand_desc");
        if (bo.isNullOrNil((String)localObject1))
        {
          this.uoA.setText(getString(2131304937, new Object[] { this.upe.field_bankName }));
          this.uoA.setVisibility(0);
          cVA();
          if ((bo.isNullOrNil(this.upe.field_bankcardTail)) || (!b(this.uow, this.upe.ufI))) {
            break label500;
          }
          localObject1 = this.uow;
          localObject2 = this.uow;
          if (!this.upe.cTh()) {
            break label516;
          }
          localObject3 = getString(2131305029);
          label150:
          if ((bo.isNullOrNil(this.upe.field_bankName)) || (!b(this.uoK, this.upe.field_bankName + " " + (String)localObject3))) {
            break label527;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.uoK;
          }
          localObject3 = this.uoK;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (b(this.unh, this.upe.field_trueName))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.unh;
          }
          localObject3 = this.unh;
        }
        localObject2 = localObject1;
        if (b(this.uoe, t.cTV().ab(getContext(), this.upe.ueY)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.uoe;
          }
          localObject3 = this.uoe;
        }
        localObject1 = localObject2;
        if (b(this.tZx, this.upe.ufH))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.tZx;
          }
          localObject3 = this.tZx;
        }
        localObject2 = localObject1;
        if (b(this.uof, this.upe.field_mobile))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.uof;
          }
          localObject3 = this.uof;
        }
        localObject1 = localObject2;
        if (b(this.uoc, this.upe.ufa))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.uoc;
          }
          localObject3 = this.uoc;
        }
        localObject2 = localObject1;
        if (b(this.uob, this.upe.ufJ))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.uob;
          }
          localObject3 = this.uob;
        }
        ((WalletFormView)localObject2).setBackgroundResource(2130838445);
        ((WalletFormView)localObject3).setBackgroundResource(2130838445);
        if (!t.cTN().cUn()) {
          break label543;
        }
        this.gHb.setText(2131304949);
        AppMethodBeat.o(47281);
        return;
        this.uoA.setText((CharSequence)localObject1);
        break;
        this.uoA.setVisibility(8);
        break label89;
        label500:
        this.uow.setVisibility(8);
        localObject2 = null;
        localObject1 = null;
        break label133;
        label516:
        localObject3 = getString(2131305049);
        break label150;
        label527:
        this.uoK.setVisibility(8);
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      label543:
      this.gHb.setText(2131304947);
      AppMethodBeat.o(47281);
      return;
    }
    AppMethodBeat.o(47281);
  }
  
  private void cVA()
  {
    AppMethodBeat.i(47283);
    this.uom.setVisibility(8);
    this.uon.setVisibility(8);
    this.uoo.setVisibility(8);
    this.uop.setVisibility(8);
    this.uoq.setVisibility(8);
    this.uor.setVisibility(8);
    this.uos.setVisibility(8);
    AppMethodBeat.o(47283);
  }
  
  private void cVx()
  {
    AppMethodBeat.i(47284);
    Object localObject;
    if (asr())
    {
      d.cWY();
      this.tVs = new Authen();
      getInput().putBoolean("key_is_follow_bank_username", this.uoA.isChecked());
      if ((this.upe != null) && (!bo.isNullOrNil(this.upe.ufU)))
      {
        this.tVs.tSv = this.upe.ufU;
        this.tVs.por = this.upe.field_bindSerial;
        this.tVs.poq = this.upe.field_bankcardType;
        this.tVs.ueY = this.upe.ueY;
        this.tVs.ueW = getInput().getString("key_pwd1");
        this.tVs.token = getInput().getString("kreq_token");
        com.tencent.mm.wallet_core.a.aM(this);
        if (getNetController().p(new Object[] { this.tVs, this.qrf }))
        {
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
          AppMethodBeat.o(47284);
        }
      }
      else
      {
        localObject = getInput().getString("key_card_id");
        if (this.uow.getVisibility() != 0) {
          break label619;
        }
        localObject = this.uow.getText();
      }
    }
    label619:
    for (;;)
    {
      this.tVs.pVo = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.tVs.ueZ = ((String)localObject);
      this.tVs.poq = this.udb.poq;
      this.tVs.ueY = this.tZB;
      this.tVs.ueW = getInput().getString("key_pwd1");
      if (!bo.isNullOrNil(this.uoc.getText())) {
        this.tVs.ufa = this.uoc.getText();
      }
      this.tVs.ubQ = this.uof.getText();
      this.tVs.ufe = this.uom.getText();
      this.tVs.uff = this.uon.getText();
      this.tVs.country = this.uoB;
      this.tVs.province = this.ogW;
      this.tVs.city = this.ogX;
      this.tVs.fBq = this.uop.getText();
      this.tVs.nLs = this.uoq.getText();
      this.tVs.gKS = this.uor.getText();
      this.tVs.dqF = this.uos.getText();
      localObject = e.awd(this.tVs.ubQ);
      getInput().putString("key_mobile", (String)localObject);
      localObject = getInput();
      if (this.udb.ubU == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
        this.tVs.ueX = this.tZx.getText();
        this.tVs.ueu = this.unh.getText();
        this.tVs.ufb = this.uob.getText();
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.tVs.pVo + " elemt.bankcardTag : " + this.udb.ubU);
        break;
      }
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(47284);
      return;
    }
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2130971156;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47280);
    this.uow = ((WalletFormView)findViewById(2131829044));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.uow);
    this.uof = ((WalletFormView)findViewById(2131828910));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.uof);
    this.unh = ((WalletFormView)findViewById(2131829013));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.unh);
    this.uoe = ((WalletFormView)findViewById(2131829051));
    this.tZx = ((WalletFormView)findViewById(2131829052));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.tZx);
    this.uoK = ((WalletFormView)findViewById(2131823480));
    this.uoc = ((WalletFormView)findViewById(2131826695));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.uoc);
    this.uob = ((WalletFormView)findViewById(2131826697));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.uob);
    this.upc = ((TextView)findViewById(2131826699));
    this.uom = ((WalletFormView)findViewById(2131829063));
    this.uon = ((WalletFormView)findViewById(2131829064));
    this.uoo = ((WalletFormView)findViewById(2131829065));
    this.uop = ((WalletFormView)findViewById(2131829066));
    this.uoq = ((WalletFormView)findViewById(2131829067));
    this.uor = ((WalletFormView)findViewById(2131829068));
    this.uos = ((WalletFormView)findViewById(2131829069));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.uos);
    this.upf = ((CheckBox)findViewById(2131829071));
    this.uoA = ((CheckBox)findViewById(2131829072));
    this.gHb = ((Button)findViewById(2131822914));
    this.upd = ((MMScrollView)findViewById(2131823477));
    MMScrollView localMMScrollView = this.upd;
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.upd.setOnSizeChangeListener(new WalletCardImportUI.1(this));
    this.unh.setOnInputValidChangeListener(this);
    this.uow.setOnInputValidChangeListener(this);
    this.uoe.setOnInputValidChangeListener(this);
    this.tZx.setOnInputValidChangeListener(this);
    this.uof.setOnInputValidChangeListener(this);
    this.uoc.setOnInputValidChangeListener(this);
    this.uob.setOnInputValidChangeListener(this);
    this.uom.setOnInputValidChangeListener(this);
    this.uon.setOnInputValidChangeListener(this);
    this.uoo.setOnInputValidChangeListener(this);
    this.uop.setOnInputValidChangeListener(this);
    this.uoq.setOnInputValidChangeListener(this);
    this.uor.setOnInputValidChangeListener(this);
    this.uos.setOnInputValidChangeListener(this);
    this.unh.setOnEditorActionListener(this);
    this.uow.setOnEditorActionListener(this);
    this.uoe.setOnEditorActionListener(this);
    this.tZx.setOnEditorActionListener(this);
    this.uof.setOnEditorActionListener(this);
    this.uoc.setOnEditorActionListener(this);
    this.uob.setOnEditorActionListener(this);
    this.uom.setOnEditorActionListener(this);
    this.uon.setOnEditorActionListener(this);
    this.uoo.setOnEditorActionListener(this);
    this.uop.setOnEditorActionListener(this);
    this.uoq.setOnEditorActionListener(this);
    this.uor.setOnEditorActionListener(this);
    this.uos.setOnEditorActionListener(this);
    this.uoK.setOnClickListener(new WalletCardImportUI.2(this));
    this.uoe.setOnClickListener(new WalletCardImportUI.3(this));
    this.upf.setChecked(true);
    this.upf.setOnCheckedChangeListener(new WalletCardImportUI.4(this));
    this.uoA.setChecked(true);
    findViewById(2131826245).setOnClickListener(new WalletCardImportUI.5(this));
    this.uoo.setOnClickListener(new WalletCardImportUI.6(this));
    this.gHb.setOnClickListener(new WalletCardImportUI.7(this));
    bJ();
    asr();
    AppMethodBeat.o(47280);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(47286);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(47286);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      asr();
      AppMethodBeat.o(47286);
      return;
      this.udb = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
      bJ();
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.uoB = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bo.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.ogW = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.ogX = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        this.uoo.setText(str1 + " " + str4);
      }
      for (;;)
      {
        if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.udb.uhK)) {
          break label416;
        }
        this.uor.setVisibility(0);
        break;
        if (!bo.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.ogX = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.uoo.setText(str1 + " " + str3);
        }
        else
        {
          this.ogX = this.uoB;
          this.uoo.setText(str1);
        }
      }
      label416:
      this.uor.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47279);
    super.onCreate(paramBundle);
    setMMTitle(2131305055);
    this.udb = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.qrf = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.upe = ((Bankcard)getInput().getParcelable("key_import_bankcard"));
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    initView();
    this.upd.pageScroll(33);
    d.a(this, getInput(), 3);
    AppMethodBeat.o(47279);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(47291);
    switch (paramInt)
    {
    default: 
      localObject = super.onCreateDialog(paramInt);
      AppMethodBeat.o(47291);
      return localObject;
    }
    Object localObject = new i(this, 2131493562);
    ((Dialog)localObject).setContentView(2130971194);
    ListView localListView = (ListView)((Dialog)localObject).findViewById(2131821074);
    localListView.setAdapter(this.upg);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(47273);
        WalletCardImportUI.this.dismissDialog(1);
        paramAnonymousInt = ((Integer)WalletCardImportUI.c(WalletCardImportUI.this).cTw().get(paramAnonymousInt)).intValue();
        if (WalletCardImportUI.f(WalletCardImportUI.this) != paramAnonymousInt)
        {
          WalletCardImportUI.a(WalletCardImportUI.this, paramAnonymousInt);
          WalletCardImportUI.g(WalletCardImportUI.this).setText(((CheckedTextView)paramAnonymousView).getText().toString());
          WalletCardImportUI.c(WalletCardImportUI.h(WalletCardImportUI.this), WalletCardImportUI.f(WalletCardImportUI.this));
          WalletCardImportUI.h(WalletCardImportUI.this).cfK();
          WalletCardImportUI.i(WalletCardImportUI.this);
        }
        AppMethodBeat.o(47273);
      }
    });
    AppMethodBeat.o(47291);
    return localObject;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(47290);
    if ((this.mDialog != null) && (this.mDialog.isShowing()))
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
    super.onDestroy();
    AppMethodBeat.o(47290);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(47289);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.uov == null) {
        cVx();
      }
      AppMethodBeat.o(47289);
      return false;
    }
    if (this.uov != null) {
      if ((this.uov.isEnabled()) && (!this.uov.isClickable()) && (this.uov.dSZ())) {
        this.uov.dTc();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(47289);
      return true;
      this.uov.performClick();
      continue;
      cVx();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(47288);
    asr();
    AppMethodBeat.o(47288);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(47285);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ab))
      {
        paramString.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.j(this, paramString);
        h.bO(this, getString(2131304851));
        AppMethodBeat.o(47285);
        return true;
      }
      AppMethodBeat.o(47285);
      return false;
    }
    AppMethodBeat.o(47285);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI
 * JD-Core Version:    0.7.0.1
 */