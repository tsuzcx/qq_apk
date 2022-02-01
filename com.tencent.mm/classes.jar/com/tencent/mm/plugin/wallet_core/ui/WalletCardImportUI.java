package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.utils.m;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.MMScrollView.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.LinkedList;
import java.util.List;

public class WalletCardImportUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private static final String[] VOb = { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT" };
  private String Kju;
  private String Kjv;
  private Orders OsJ;
  private WalletFormView VLW;
  private WalletFormView VMN;
  private WalletFormView VMO;
  private WalletFormView VMQ;
  private WalletFormView VMR;
  private WalletFormView VNB;
  private WalletFormView VNb;
  private WalletFormView VNc;
  private WalletFormView VNd;
  private WalletFormView VNe;
  private WalletFormView VNf;
  private WalletFormView VNg;
  private WalletFormView VNh;
  private WalletFormView VNj;
  private WalletFormView VNk;
  private CheckBox VNo;
  private String VNp;
  private TextView VOc;
  private MMScrollView VOd;
  private Bankcard VOe;
  private CheckBox VOf;
  private BaseAdapter VOg;
  private Authen VmM;
  private WalletFormView Vre;
  private int Vrj;
  private ElementQuery Vzs;
  private Button lDJ;
  private Dialog mDialog;
  private MMHandler mHandler;
  private PayInfo mPayInfo;
  
  public WalletCardImportUI()
  {
    AppMethodBeat.i(70841);
    this.mDialog = null;
    this.VNj = null;
    this.mHandler = new MMHandler();
    this.Vzs = new ElementQuery();
    this.VmM = new Authen();
    this.OsJ = null;
    this.mPayInfo = null;
    this.VOe = null;
    this.Vrj = 1;
    this.VOg = new BaseAdapter()
    {
      private Integer xO(int paramAnonymousInt)
      {
        AppMethodBeat.i(70838);
        Integer localInteger = (Integer)WalletCardImportUI.c(WalletCardImportUI.this).iim().get(paramAnonymousInt);
        AppMethodBeat.o(70838);
        return localInteger;
      }
      
      public final int getCount()
      {
        AppMethodBeat.i(70837);
        if (WalletCardImportUI.c(WalletCardImportUI.this).iim() != null)
        {
          int i = WalletCardImportUI.c(WalletCardImportUI.this).iim().size();
          AppMethodBeat.o(70837);
          return i;
        }
        AppMethodBeat.o(70837);
        return 0;
      }
      
      public final long getItemId(int paramAnonymousInt)
      {
        return paramAnonymousInt;
      }
      
      public final View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        AppMethodBeat.i(70839);
        paramAnonymousView = (CheckedTextView)View.inflate(WalletCardImportUI.this, a.g.wallet_list_dialog_item_singlechoice, null);
        paramAnonymousView.setText(u.iiK().bf(WalletCardImportUI.this, xO(paramAnonymousInt).intValue()));
        if (WalletCardImportUI.f(WalletCardImportUI.this) == xO(paramAnonymousInt).intValue()) {
          paramAnonymousView.setChecked(true);
        }
        for (;;)
        {
          paramAnonymousView.setBackgroundResource(a.e.comm_list_item_selector);
          AppMethodBeat.o(70839);
          return paramAnonymousView;
          paramAnonymousView.setChecked(false);
        }
      }
    };
    AppMethodBeat.o(70841);
  }
  
  private boolean bZk()
  {
    AppMethodBeat.i(70850);
    if (!this.VOf.isChecked()) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool)
      {
        this.lDJ.setEnabled(true);
        this.lDJ.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(70850);
        return bool;
        this.lDJ.setEnabled(false);
        this.lDJ.setClickable(false);
      }
    }
  }
  
  private static boolean e(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(70845);
    if (!Util.isNullOrNil(paramString))
    {
      KeyListener localKeyListener = paramWalletFormView.getKeyListener();
      paramWalletFormView.setKeyListener(null);
      paramWalletFormView.setEnabled(false);
      paramWalletFormView.setClickable(false);
      paramWalletFormView.setText(paramString);
      paramWalletFormView.setKeyListener(localKeyListener);
      paramWalletFormView.setVisibility(0);
      AppMethodBeat.o(70845);
      return true;
    }
    paramWalletFormView.setVisibility(8);
    AppMethodBeat.o(70845);
    return false;
  }
  
  private void ikE()
  {
    AppMethodBeat.i(70847);
    Object localObject;
    if (bZk())
    {
      m.imd();
      this.VmM = new Authen();
      getInput().putBoolean("key_is_follow_bank_username", this.VNo.isChecked());
      if ((this.VOe != null) && (!Util.isNullOrNil(this.VOe.VDx)))
      {
        this.VmM.VjF = this.VOe.VDx;
        this.VmM.MDt = this.VOe.field_bindSerial;
        this.VmM.hAk = this.VOe.field_bankcardType;
        this.VmM.VCC = this.VOe.VCC;
        this.VmM.VCA = getInput().getString("key_pwd1");
        this.VmM.token = getInput().getString("kreq_token");
        com.tencent.mm.wallet_core.a.cm(this);
        if (getNetController().t(new Object[] { this.VmM, this.OsJ }))
        {
          Log.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
          AppMethodBeat.o(70847);
        }
      }
      else
      {
        localObject = getInput().getString("key_card_id");
        if (this.VNk.getVisibility() != 0) {
          break label615;
        }
        localObject = this.VNk.getText();
      }
    }
    label615:
    for (;;)
    {
      this.VmM.Nxi = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.VmM.VCD = ((String)localObject);
      this.VmM.hAk = this.Vzs.hAk;
      this.VmM.VCC = this.Vrj;
      this.VmM.VCA = getInput().getString("key_pwd1");
      if (!Util.isNullOrNil(this.VMO.getText())) {
        this.VmM.VCE = this.VMO.getText();
      }
      this.VmM.VxX = this.VMR.getText();
      this.VmM.VCH = this.VNb.getText();
      this.VmM.VCI = this.VNc.getText();
      this.VmM.country = this.VNp;
      this.VmM.province = this.Kju;
      this.VmM.city = this.Kjv;
      this.VmM.oDI = this.VNe.getText();
      this.VmM.JFm = this.VNf.getText();
      this.VmM.qhL = this.VNg.getText();
      this.VmM.kab = this.VNh.getText();
      localObject = com.tencent.mm.wallet_core.ui.i.bEO(this.VmM.VxX);
      getInput().putString("key_mobile", (String)localObject);
      localObject = getInput();
      if (this.Vzs.Vyb == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
        this.VmM.VCB = this.Vre.getText();
        this.VmM.VBL = this.VLW.getText();
        this.VmM.VCF = this.VMN.getText();
        Log.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.VmM.Nxi + " elemt.bankcardTag : " + this.Vzs.Vyb);
        break;
      }
      Log.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70847);
      return;
    }
  }
  
  private void ikI()
  {
    AppMethodBeat.i(70846);
    this.VNb.setVisibility(8);
    this.VNc.setVisibility(8);
    this.VNd.setVisibility(8);
    this.VNe.setVisibility(8);
    this.VNf.setVisibility(8);
    this.VNg.setVisibility(8);
    this.VNh.setVisibility(8);
    AppMethodBeat.o(70846);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(70844);
    if (this.VOe != null)
    {
      findViewById(a.f.wallet_card_safeguard_tip).setVisibility(0);
      Object localObject1;
      label94:
      Object localObject2;
      label138:
      Object localObject3;
      if (!Util.isNullOrNil(getInput().getString("key_bank_username")))
      {
        localObject1 = getInput().getString("key_recommand_desc");
        if (Util.isNullOrNil((String)localObject1))
        {
          this.VNo.setText(getString(a.i.wallet_card_follow_bank_tips, new Object[] { this.VOe.field_bankName }));
          this.VNo.setVisibility(0);
          ikI();
          if ((Util.isNullOrNil(this.VOe.field_bankcardTail)) || (!e(this.VNk, this.VOe.VDk))) {
            break label508;
          }
          localObject1 = this.VNk;
          localObject2 = this.VNk;
          if (!this.VOe.ihX()) {
            break label524;
          }
          localObject3 = getString(a.i.wallet_credit_card);
          label156:
          if ((Util.isNullOrNil(this.VOe.field_bankName)) || (!e(this.VNB, this.VOe.field_bankName + " " + (String)localObject3))) {
            break label535;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.VNB;
          }
          localObject3 = this.VNB;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (e(this.VLW, this.VOe.field_trueName))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.VLW;
          }
          localObject3 = this.VLW;
        }
        localObject2 = localObject1;
        if (e(this.VMQ, u.iiK().bf(getContext(), this.VOe.VCC)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.VMQ;
          }
          localObject3 = this.VMQ;
        }
        localObject1 = localObject2;
        if (e(this.Vre, this.VOe.VDj))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.Vre;
          }
          localObject3 = this.Vre;
        }
        localObject2 = localObject1;
        if (e(this.VMR, this.VOe.field_mobile))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.VMR;
          }
          localObject3 = this.VMR;
        }
        localObject1 = localObject2;
        if (e(this.VMO, this.VOe.VCE))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.VMO;
          }
          localObject3 = this.VMO;
        }
        localObject2 = localObject1;
        if (e(this.VMN, this.VOe.VDl))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.VMN;
          }
          localObject3 = this.VMN;
        }
        ((WalletFormView)localObject2).setBackgroundResource(a.e.comm_list_item_selector);
        ((WalletFormView)localObject3).setBackgroundResource(a.e.comm_list_item_selector);
        if (!u.iiC().ijh()) {
          break label551;
        }
        this.lDJ.setText(a.i.wallet_card_import_first);
        AppMethodBeat.o(70844);
        return;
        this.VNo.setText((CharSequence)localObject1);
        break;
        this.VNo.setVisibility(8);
        break label94;
        label508:
        this.VNk.setVisibility(8);
        localObject2 = null;
        localObject1 = null;
        break label138;
        label524:
        localObject3 = getString(a.i.wallet_deposit_card);
        break label156;
        label535:
        this.VNB.setVisibility(8);
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      label551:
      this.lDJ.setText(a.i.wallet_card_import);
      AppMethodBeat.o(70844);
      return;
    }
    AppMethodBeat.o(70844);
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_card_import_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70843);
    this.VNk = ((WalletFormView)findViewById(a.f.wallet_card_forgot_id));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.VNk);
    this.VMR = ((WalletFormView)findViewById(a.f.mobile_et));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.VMR);
    this.VLW = ((WalletFormView)findViewById(a.f.name_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.VLW);
    this.VMQ = ((WalletFormView)findViewById(a.f.wallet_cre_type));
    this.Vre = ((WalletFormView)findViewById(a.f.identity_et));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.Vre);
    this.VNB = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.VMO = ((WalletFormView)findViewById(a.f.cvv_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.VMO);
    this.VMN = ((WalletFormView)findViewById(a.f.date_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.VMN);
    this.VOc = ((TextView)findViewById(a.f.wallet_power_by_tenpay));
    this.VNb = ((WalletFormView)findViewById(a.f.first_name_et));
    this.VNc = ((WalletFormView)findViewById(a.f.last_name_et));
    this.VNd = ((WalletFormView)findViewById(a.f.area_et));
    this.VNe = ((WalletFormView)findViewById(a.f.address_et));
    this.VNf = ((WalletFormView)findViewById(a.f.phone_et));
    this.VNg = ((WalletFormView)findViewById(a.f.post_et));
    this.VNh = ((WalletFormView)findViewById(a.f.email_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.VNh);
    this.VOf = ((CheckBox)findViewById(a.f.agree_wx_cb));
    this.VNo = ((CheckBox)findViewById(a.f.agree_follow_bank_cb));
    this.lDJ = ((Button)findViewById(a.f.next_btn));
    this.VOd = ((MMScrollView)findViewById(a.f.wallet_sv));
    MMScrollView localMMScrollView = this.VOd;
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.VOd.setOnSizeChangeListener(new MMScrollView.b()
    {
      public final void HM(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70828);
        if (paramAnonymousBoolean) {}
        for (final int i = 8;; i = 0)
        {
          Log.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : ".concat(String.valueOf(paramAnonymousBoolean)));
          WalletCardImportUI.b(WalletCardImportUI.this).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(70827);
              if (i != WalletCardImportUI.a(WalletCardImportUI.this).getVisibility()) {
                WalletCardImportUI.a(WalletCardImportUI.this).setVisibility(i);
              }
              AppMethodBeat.o(70827);
            }
          });
          AppMethodBeat.o(70828);
          return;
        }
      }
    });
    this.VLW.setOnInputValidChangeListener(this);
    this.VNk.setOnInputValidChangeListener(this);
    this.VMQ.setOnInputValidChangeListener(this);
    this.Vre.setOnInputValidChangeListener(this);
    this.VMR.setOnInputValidChangeListener(this);
    this.VMO.setOnInputValidChangeListener(this);
    this.VMN.setOnInputValidChangeListener(this);
    this.VNb.setOnInputValidChangeListener(this);
    this.VNc.setOnInputValidChangeListener(this);
    this.VNd.setOnInputValidChangeListener(this);
    this.VNe.setOnInputValidChangeListener(this);
    this.VNf.setOnInputValidChangeListener(this);
    this.VNg.setOnInputValidChangeListener(this);
    this.VNh.setOnInputValidChangeListener(this);
    this.VLW.setOnEditorActionListener(this);
    this.VNk.setOnEditorActionListener(this);
    this.VMQ.setOnEditorActionListener(this);
    this.Vre.setOnEditorActionListener(this);
    this.VMR.setOnEditorActionListener(this);
    this.VMO.setOnEditorActionListener(this);
    this.VMN.setOnEditorActionListener(this);
    this.VNb.setOnEditorActionListener(this);
    this.VNc.setOnEditorActionListener(this);
    this.VNd.setOnEditorActionListener(this);
    this.VNe.setOnEditorActionListener(this);
    this.VNf.setOnEditorActionListener(this);
    this.VNg.setOnEditorActionListener(this);
    this.VNh.setOnEditorActionListener(this);
    this.VNB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70829);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardImportUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putString("key_bank_type", WalletCardImportUI.c(WalletCardImportUI.this).hAk);
        paramAnonymousView.putInt("key_bankcard_type", WalletCardImportUI.c(WalletCardImportUI.this).VFf);
        com.tencent.mm.wallet_core.a.cm(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70829);
      }
    });
    this.VMQ.setOnClickListener(new WalletCardImportUI.3(this));
    this.VOf.setChecked(true);
    this.VOf.setOnCheckedChangeListener(new WalletCardImportUI.4(this));
    this.VNo.setChecked(true);
    findViewById(a.f.agree_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70833);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        paramAnonymousView = new LinkedList();
        localObject = new LinkedList();
        paramAnonymousView.add(WalletCardImportUI.this.getString(a.i.wallet_card_aggreement_user));
        ((List)localObject).add(Integer.valueOf(0));
        if ((WalletCardImportUI.c(WalletCardImportUI.this) != null) && (WalletCardImportUI.c(WalletCardImportUI.this).VFx))
        {
          paramAnonymousView.add(WalletCardImportUI.this.getString(a.i.wallet_card_aggreement_bank));
          ((List)localObject).add(Integer.valueOf(1));
        }
        k.a(WalletCardImportUI.this, "", paramAnonymousView, (List)localObject, "", new k.e()
        {
          public final void onClick(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(70832);
            Intent localIntent = new Intent();
            switch (paramAnonymous2Int1)
            {
            }
            for (;;)
            {
              localIntent.putExtra("showShare", false);
              com.tencent.mm.wallet_core.ui.i.aS(WalletCardImportUI.this.getContext(), localIntent);
              AppMethodBeat.o(70832);
              return;
              localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(a.i.wallet_agreemnet_user, new Object[] { LocaleUtil.getApplicationLanguage() }));
              continue;
              if (WalletCardImportUI.c(WalletCardImportUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(a.i.wallet_agreemnet_bank, new Object[] { LocaleUtil.getApplicationLanguage(), WalletCardImportUI.c(WalletCardImportUI.this).hAk }));
              }
            }
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70833);
      }
    });
    this.VNd.setOnClickListener(new WalletCardImportUI.6(this));
    this.lDJ.setOnClickListener(new WalletCardImportUI.7(this));
    updateView();
    bZk();
    AppMethodBeat.o(70843);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70849);
    Log.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(70849);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      bZk();
      AppMethodBeat.o(70849);
      return;
      this.Vzs = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
      updateView();
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.VNp = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.Kju = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.Kjv = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        this.VNd.setText(str1 + " " + str4);
      }
      for (;;)
      {
        if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.Vzs.VFs)) {
          break label418;
        }
        this.VNg.setVisibility(0);
        break;
        if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.Kjv = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.VNd.setText(str1 + " " + str3);
        }
        else
        {
          this.Kjv = this.VNp;
          this.VNd.setText(str1);
        }
      }
      label418:
      this.VNg.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70842);
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_elment_title);
    this.Vzs = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.OsJ = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.VOe = ((Bankcard)getInput().getParcelable("key_import_bankcard"));
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    Log.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    initView();
    this.VOd.pageScroll(33);
    m.a(this, getInput(), 3);
    AppMethodBeat.o(70842);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(70854);
    switch (paramInt)
    {
    default: 
      localObject = super.onCreateDialog(paramInt);
      AppMethodBeat.o(70854);
      return localObject;
    }
    Object localObject = new com.tencent.mm.ui.widget.a.i(this, a.j.SelectorDialog);
    ((Dialog)localObject).setContentView(a.g.wallet_list_dialog);
    ListView localListView = (ListView)((Dialog)localObject).findViewById(a.f.address_contactlist);
    localListView.setAdapter(this.VOg);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70836);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        WalletCardImportUI.this.dismissDialog(1);
        paramAnonymousInt = ((Integer)WalletCardImportUI.c(WalletCardImportUI.this).iim().get(paramAnonymousInt)).intValue();
        if (WalletCardImportUI.f(WalletCardImportUI.this) != paramAnonymousInt)
        {
          WalletCardImportUI.a(WalletCardImportUI.this, paramAnonymousInt);
          WalletCardImportUI.g(WalletCardImportUI.this).setText(((CheckedTextView)paramAnonymousView).getText().toString());
          WalletCardImportUI.b(WalletCardImportUI.h(WalletCardImportUI.this), WalletCardImportUI.f(WalletCardImportUI.this));
          WalletCardImportUI.h(WalletCardImportUI.this).gGd();
          WalletCardImportUI.i(WalletCardImportUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(70836);
      }
    });
    AppMethodBeat.o(70854);
    return localObject;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70853);
    if ((this.mDialog != null) && (this.mDialog.isShowing()))
    {
      this.mDialog.dismiss();
      this.mDialog = null;
    }
    super.onDestroy();
    AppMethodBeat.o(70853);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(70852);
    Log.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.VNj == null) {
        ikE();
      }
      AppMethodBeat.o(70852);
      return false;
    }
    if (this.VNj != null) {
      if ((this.VNj.isEnabled()) && (!this.VNj.isClickable()) && (this.VNj.jPB())) {
        this.VNj.jPE();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70852);
      return true;
      this.VNj.performClick();
      continue;
      ikE();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70851);
    bZk();
    AppMethodBeat.o(70851);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(70848);
    Log.d("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      Log.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramp instanceof ae))
      {
        paramString.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.k(this, paramString);
        k.cZ(this, getString(a.i.wallet_bank_card_bind_success_tips));
        AppMethodBeat.o(70848);
        return true;
      }
      AppMethodBeat.o(70848);
      return false;
    }
    AppMethodBeat.o(70848);
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