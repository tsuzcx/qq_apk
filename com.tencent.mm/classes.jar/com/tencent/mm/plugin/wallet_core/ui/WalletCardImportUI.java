package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.utils.j;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.d;
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
  private static final String[] OXN = { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT" };
  private String EqO;
  private String EqP;
  private Orders Ivh;
  private WalletFormView OBS;
  private int OBX;
  private ElementQuery OJG;
  private WalletFormView OVH;
  private WalletFormView OWA;
  private WalletFormView OWC;
  private WalletFormView OWD;
  private WalletFormView OWN;
  private WalletFormView OWO;
  private WalletFormView OWP;
  private WalletFormView OWQ;
  private WalletFormView OWR;
  private WalletFormView OWS;
  private WalletFormView OWT;
  private WalletFormView OWV;
  private WalletFormView OWW;
  private WalletFormView OWz;
  private TextView OXO;
  private MMScrollView OXP;
  private Bankcard OXQ;
  private CheckBox OXR;
  private BaseAdapter OXS;
  private CheckBox OXa;
  private String OXb;
  private WalletFormView OXn;
  private Authen OxB;
  private Button jbJ;
  private Dialog mDialog;
  private MMHandler mHandler;
  private PayInfo mPayInfo;
  
  public WalletCardImportUI()
  {
    AppMethodBeat.i(70841);
    this.mDialog = null;
    this.OWV = null;
    this.mHandler = new MMHandler();
    this.OJG = new ElementQuery();
    this.OxB = new Authen();
    this.Ivh = null;
    this.mPayInfo = null;
    this.OXQ = null;
    this.OBX = 1;
    this.OXS = new BaseAdapter()
    {
      private Integer xJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(70838);
        Integer localInteger = (Integer)WalletCardImportUI.c(WalletCardImportUI.this).gIY().get(paramAnonymousInt);
        AppMethodBeat.o(70838);
        return localInteger;
      }
      
      public final int getCount()
      {
        AppMethodBeat.i(70837);
        if (WalletCardImportUI.c(WalletCardImportUI.this).gIY() != null)
        {
          int i = WalletCardImportUI.c(WalletCardImportUI.this).gIY().size();
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
        paramAnonymousView.setText(u.gJw().aN(WalletCardImportUI.this, xJ(paramAnonymousInt).intValue()));
        if (WalletCardImportUI.f(WalletCardImportUI.this) == xJ(paramAnonymousInt).intValue()) {
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
  
  private boolean bAu()
  {
    AppMethodBeat.i(70850);
    if (!this.OXR.isChecked()) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool)
      {
        this.jbJ.setEnabled(true);
        this.jbJ.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(70850);
        return bool;
        this.jbJ.setEnabled(false);
        this.jbJ.setClickable(false);
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
  
  private void gLn()
  {
    AppMethodBeat.i(70847);
    Object localObject;
    if (bAu())
    {
      j.gMO();
      this.OxB = new Authen();
      getInput().putBoolean("key_is_follow_bank_username", this.OXa.isChecked());
      if ((this.OXQ != null) && (!Util.isNullOrNil(this.OXQ.ONM)))
      {
        this.OxB.Our = this.OXQ.ONM;
        this.OxB.GGC = this.OXQ.field_bindSerial;
        this.OxB.fvP = this.OXQ.field_bankcardType;
        this.OxB.OMR = this.OXQ.OMR;
        this.OxB.OMP = getInput().getString("key_pwd1");
        this.OxB.token = getInput().getString("kreq_token");
        com.tencent.mm.wallet_core.a.bF(this);
        if (getNetController().r(new Object[] { this.OxB, this.Ivh }))
        {
          Log.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
          AppMethodBeat.o(70847);
        }
      }
      else
      {
        localObject = getInput().getString("key_card_id");
        if (this.OWW.getVisibility() != 0) {
          break label615;
        }
        localObject = this.OWW.getText();
      }
    }
    label615:
    for (;;)
    {
      this.OxB.HzF = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.OxB.OMS = ((String)localObject);
      this.OxB.fvP = this.OJG.fvP;
      this.OxB.OMR = this.OBX;
      this.OxB.OMP = getInput().getString("key_pwd1");
      if (!Util.isNullOrNil(this.OWA.getText())) {
        this.OxB.OMT = this.OWA.getText();
      }
      this.OxB.OIl = this.OWD.getText();
      this.OxB.OMW = this.OWN.getText();
      this.OxB.OMX = this.OWO.getText();
      this.OxB.country = this.OXb;
      this.OxB.province = this.EqO;
      this.OxB.city = this.EqP;
      this.OxB.lLg = this.OWQ.getText();
      this.OxB.DNX = this.OWR.getText();
      this.OxB.nkC = this.OWS.getText();
      this.OxB.hDf = this.OWT.getText();
      localObject = com.tencent.mm.wallet_core.ui.g.bCq(this.OxB.OIl);
      getInput().putString("key_mobile", (String)localObject);
      localObject = getInput();
      if (this.OJG.OIp == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
        this.OxB.OMQ = this.OBS.getText();
        this.OxB.OMa = this.OVH.getText();
        this.OxB.OMU = this.OWz.getText();
        Log.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.OxB.HzF + " elemt.bankcardTag : " + this.OJG.OIp);
        break;
      }
      Log.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70847);
      return;
    }
  }
  
  private void gLr()
  {
    AppMethodBeat.i(70846);
    this.OWN.setVisibility(8);
    this.OWO.setVisibility(8);
    this.OWP.setVisibility(8);
    this.OWQ.setVisibility(8);
    this.OWR.setVisibility(8);
    this.OWS.setVisibility(8);
    this.OWT.setVisibility(8);
    AppMethodBeat.o(70846);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(70844);
    if (this.OXQ != null)
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
          this.OXa.setText(getString(a.i.wallet_card_follow_bank_tips, new Object[] { this.OXQ.field_bankName }));
          this.OXa.setVisibility(0);
          gLr();
          if ((Util.isNullOrNil(this.OXQ.field_bankcardTail)) || (!e(this.OWW, this.OXQ.ONz))) {
            break label508;
          }
          localObject1 = this.OWW;
          localObject2 = this.OWW;
          if (!this.OXQ.gIJ()) {
            break label524;
          }
          localObject3 = getString(a.i.wallet_credit_card);
          label156:
          if ((Util.isNullOrNil(this.OXQ.field_bankName)) || (!e(this.OXn, this.OXQ.field_bankName + " " + (String)localObject3))) {
            break label535;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.OXn;
          }
          localObject3 = this.OXn;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (e(this.OVH, this.OXQ.field_trueName))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.OVH;
          }
          localObject3 = this.OVH;
        }
        localObject2 = localObject1;
        if (e(this.OWC, u.gJw().aN(getContext(), this.OXQ.OMR)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.OWC;
          }
          localObject3 = this.OWC;
        }
        localObject1 = localObject2;
        if (e(this.OBS, this.OXQ.ONy))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.OBS;
          }
          localObject3 = this.OBS;
        }
        localObject2 = localObject1;
        if (e(this.OWD, this.OXQ.field_mobile))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.OWD;
          }
          localObject3 = this.OWD;
        }
        localObject1 = localObject2;
        if (e(this.OWA, this.OXQ.OMT))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.OWA;
          }
          localObject3 = this.OWA;
        }
        localObject2 = localObject1;
        if (e(this.OWz, this.OXQ.ONA))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.OWz;
          }
          localObject3 = this.OWz;
        }
        ((WalletFormView)localObject2).setBackgroundResource(a.e.comm_list_item_selector);
        ((WalletFormView)localObject3).setBackgroundResource(a.e.comm_list_item_selector);
        if (!u.gJo().gJS()) {
          break label551;
        }
        this.jbJ.setText(a.i.wallet_card_import_first);
        AppMethodBeat.o(70844);
        return;
        this.OXa.setText((CharSequence)localObject1);
        break;
        this.OXa.setVisibility(8);
        break label94;
        label508:
        this.OWW.setVisibility(8);
        localObject2 = null;
        localObject1 = null;
        break label138;
        label524:
        localObject3 = getString(a.i.wallet_deposit_card);
        break label156;
        label535:
        this.OXn.setVisibility(8);
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      label551:
      this.jbJ.setText(a.i.wallet_card_import);
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
    this.OWW = ((WalletFormView)findViewById(a.f.wallet_card_forgot_id));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.OWW);
    this.OWD = ((WalletFormView)findViewById(a.f.mobile_et));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.OWD);
    this.OVH = ((WalletFormView)findViewById(a.f.name_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.OVH);
    this.OWC = ((WalletFormView)findViewById(a.f.wallet_cre_type));
    this.OBS = ((WalletFormView)findViewById(a.f.identity_et));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.OBS);
    this.OXn = ((WalletFormView)findViewById(a.f.wallet_card_type));
    this.OWA = ((WalletFormView)findViewById(a.f.cvv_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.OWA);
    this.OWz = ((WalletFormView)findViewById(a.f.date_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.OWz);
    this.OXO = ((TextView)findViewById(a.f.wallet_power_by_tenpay));
    this.OWN = ((WalletFormView)findViewById(a.f.first_name_et));
    this.OWO = ((WalletFormView)findViewById(a.f.last_name_et));
    this.OWP = ((WalletFormView)findViewById(a.f.area_et));
    this.OWQ = ((WalletFormView)findViewById(a.f.address_et));
    this.OWR = ((WalletFormView)findViewById(a.f.phone_et));
    this.OWS = ((WalletFormView)findViewById(a.f.post_et));
    this.OWT = ((WalletFormView)findViewById(a.f.email_et));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.OWT);
    this.OXR = ((CheckBox)findViewById(a.f.agree_wx_cb));
    this.OXa = ((CheckBox)findViewById(a.f.agree_follow_bank_cb));
    this.jbJ = ((Button)findViewById(a.f.next_btn));
    this.OXP = ((MMScrollView)findViewById(a.f.wallet_sv));
    MMScrollView localMMScrollView = this.OXP;
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.OXP.setOnSizeChangeListener(new MMScrollView.b()
    {
      public final void Ch(boolean paramAnonymousBoolean)
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
    this.OVH.setOnInputValidChangeListener(this);
    this.OWW.setOnInputValidChangeListener(this);
    this.OWC.setOnInputValidChangeListener(this);
    this.OBS.setOnInputValidChangeListener(this);
    this.OWD.setOnInputValidChangeListener(this);
    this.OWA.setOnInputValidChangeListener(this);
    this.OWz.setOnInputValidChangeListener(this);
    this.OWN.setOnInputValidChangeListener(this);
    this.OWO.setOnInputValidChangeListener(this);
    this.OWP.setOnInputValidChangeListener(this);
    this.OWQ.setOnInputValidChangeListener(this);
    this.OWR.setOnInputValidChangeListener(this);
    this.OWS.setOnInputValidChangeListener(this);
    this.OWT.setOnInputValidChangeListener(this);
    this.OVH.setOnEditorActionListener(this);
    this.OWW.setOnEditorActionListener(this);
    this.OWC.setOnEditorActionListener(this);
    this.OBS.setOnEditorActionListener(this);
    this.OWD.setOnEditorActionListener(this);
    this.OWA.setOnEditorActionListener(this);
    this.OWz.setOnEditorActionListener(this);
    this.OWN.setOnEditorActionListener(this);
    this.OWO.setOnEditorActionListener(this);
    this.OWP.setOnEditorActionListener(this);
    this.OWQ.setOnEditorActionListener(this);
    this.OWR.setOnEditorActionListener(this);
    this.OWS.setOnEditorActionListener(this);
    this.OWT.setOnEditorActionListener(this);
    this.OXn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70829);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardImportUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putString("key_bank_type", WalletCardImportUI.c(WalletCardImportUI.this).fvP);
        paramAnonymousView.putInt("key_bankcard_type", WalletCardImportUI.c(WalletCardImportUI.this).OPl);
        com.tencent.mm.wallet_core.a.bF(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70829);
      }
    });
    this.OWC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70830);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletCardImportUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70830);
      }
    });
    this.OXR.setChecked(true);
    this.OXR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70831);
        WalletCardImportUI.d(WalletCardImportUI.this);
        AppMethodBeat.o(70831);
      }
    });
    this.OXa.setChecked(true);
    findViewById(a.f.agree_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70833);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        paramAnonymousView = new LinkedList();
        localObject = new LinkedList();
        paramAnonymousView.add(WalletCardImportUI.this.getString(a.i.wallet_card_aggreement_user));
        ((List)localObject).add(Integer.valueOf(0));
        if ((WalletCardImportUI.c(WalletCardImportUI.this) != null) && (WalletCardImportUI.c(WalletCardImportUI.this).OPD))
        {
          paramAnonymousView.add(WalletCardImportUI.this.getString(a.i.wallet_card_aggreement_bank));
          ((List)localObject).add(Integer.valueOf(1));
        }
        h.a(WalletCardImportUI.this, "", paramAnonymousView, (List)localObject, "", new h.e()
        {
          public final void cS(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(70832);
            Intent localIntent = new Intent();
            switch (paramAnonymous2Int1)
            {
            }
            for (;;)
            {
              localIntent.putExtra("showShare", false);
              com.tencent.mm.wallet_core.ui.g.aJ(WalletCardImportUI.this.getContext(), localIntent);
              AppMethodBeat.o(70832);
              return;
              localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(a.i.wallet_agreemnet_user, new Object[] { LocaleUtil.getApplicationLanguage() }));
              continue;
              if (WalletCardImportUI.c(WalletCardImportUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(a.i.wallet_agreemnet_bank, new Object[] { LocaleUtil.getApplicationLanguage(), WalletCardImportUI.c(WalletCardImportUI.this).fvP }));
              }
            }
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70833);
      }
    });
    this.OWP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70834);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletCardImportUI.this.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70834);
      }
    });
    this.jbJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70835);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletCardImportUI.e(WalletCardImportUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70835);
      }
    });
    updateView();
    bAu();
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
      bAu();
      AppMethodBeat.o(70849);
      return;
      this.OJG = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
      updateView();
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.OXb = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.EqO = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.EqP = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        this.OWP.setText(str1 + " " + str4);
      }
      for (;;)
      {
        if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.OJG.OPy)) {
          break label418;
        }
        this.OWS.setVisibility(0);
        break;
        if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.EqP = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.OWP.setText(str1 + " " + str3);
        }
        else
        {
          this.EqP = this.OXb;
          this.OWP.setText(str1);
        }
      }
      label418:
      this.OWS.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70842);
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_elment_title);
    this.OJG = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.Ivh = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.OXQ = ((Bankcard)getInput().getParcelable("key_import_bankcard"));
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    Log.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    initView();
    this.OXP.pageScroll(33);
    j.a(this, getInput(), 3);
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
    Object localObject = new i(this, a.j.SelectorDialog);
    ((Dialog)localObject).setContentView(a.g.wallet_list_dialog);
    ListView localListView = (ListView)((Dialog)localObject).findViewById(a.f.address_contactlist);
    localListView.setAdapter(this.OXS);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70836);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        WalletCardImportUI.this.dismissDialog(1);
        paramAnonymousInt = ((Integer)WalletCardImportUI.c(WalletCardImportUI.this).gIY().get(paramAnonymousInt)).intValue();
        if (WalletCardImportUI.f(WalletCardImportUI.this) != paramAnonymousInt)
        {
          WalletCardImportUI.a(WalletCardImportUI.this, paramAnonymousInt);
          WalletCardImportUI.g(WalletCardImportUI.this).setText(((CheckedTextView)paramAnonymousView).getText().toString());
          WalletCardImportUI.b(WalletCardImportUI.h(WalletCardImportUI.this), WalletCardImportUI.f(WalletCardImportUI.this));
          WalletCardImportUI.h(WalletCardImportUI.this).fuo();
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
      if (this.OWV == null) {
        gLn();
      }
      AppMethodBeat.o(70852);
      return false;
    }
    if (this.OWV != null) {
      if ((this.OWV.isEnabled()) && (!this.OWV.isClickable()) && (this.OWV.ijB())) {
        this.OWV.ijE();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70852);
      return true;
      this.OWV.performClick();
      continue;
      gLn();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70851);
    bAu();
    AppMethodBeat.o(70851);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(70848);
    Log.d("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      Log.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramq instanceof ae))
      {
        paramString.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.l(this, paramString);
        h.cO(this, getString(a.i.wallet_bank_card_bind_success_tips));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI
 * JD-Core Version:    0.7.0.1
 */