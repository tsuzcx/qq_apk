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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
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
  private static final String[] Ify = { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT" };
  private Orders CwO;
  private Authen HFI;
  private WalletFormView HJY;
  private int HKd;
  private ElementQuery HRy;
  private WalletFormView Idq;
  private WalletFormView IeA;
  private WalletFormView IeB;
  private WalletFormView IeC;
  private WalletFormView IeD;
  private WalletFormView IeE;
  private WalletFormView IeG;
  private WalletFormView IeH;
  private CheckBox IeL;
  private String IeM;
  private WalletFormView IeY;
  private WalletFormView Iek;
  private WalletFormView Iel;
  private WalletFormView Ien;
  private WalletFormView Ieo;
  private WalletFormView Iey;
  private WalletFormView Iez;
  private MMScrollView IfA;
  private Bankcard IfB;
  private CheckBox IfC;
  private BaseAdapter IfD;
  private TextView Ifz;
  private Button gxv;
  private Dialog mDialog;
  private MMHandler mHandler;
  private PayInfo mPayInfo;
  private String yMR;
  private String yMS;
  
  public WalletCardImportUI()
  {
    AppMethodBeat.i(70841);
    this.mDialog = null;
    this.IeG = null;
    this.mHandler = new MMHandler();
    this.HRy = new ElementQuery();
    this.HFI = new Authen();
    this.CwO = null;
    this.mPayInfo = null;
    this.IfB = null;
    this.HKd = 1;
    this.IfD = new BaseAdapter()
    {
      private Integer uH(int paramAnonymousInt)
      {
        AppMethodBeat.i(70838);
        Integer localInteger = (Integer)WalletCardImportUI.c(WalletCardImportUI.this).fQs().get(paramAnonymousInt);
        AppMethodBeat.o(70838);
        return localInteger;
      }
      
      public final int getCount()
      {
        AppMethodBeat.i(70837);
        if (WalletCardImportUI.c(WalletCardImportUI.this).fQs() != null)
        {
          int i = WalletCardImportUI.c(WalletCardImportUI.this).fQs().size();
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
        paramAnonymousView = (CheckedTextView)View.inflate(WalletCardImportUI.this, 2131496951, null);
        paramAnonymousView.setText(t.fQQ().av(WalletCardImportUI.this, uH(paramAnonymousInt).intValue()));
        if (WalletCardImportUI.f(WalletCardImportUI.this) == uH(paramAnonymousInt).intValue()) {
          paramAnonymousView.setChecked(true);
        }
        for (;;)
        {
          paramAnonymousView.setBackgroundResource(2131231898);
          AppMethodBeat.o(70839);
          return paramAnonymousView;
          paramAnonymousView.setChecked(false);
        }
      }
    };
    AppMethodBeat.o(70841);
  }
  
  private boolean bqg()
  {
    AppMethodBeat.i(70850);
    if (!this.IfC.isChecked()) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool)
      {
        this.gxv.setEnabled(true);
        this.gxv.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(70850);
        return bool;
        this.gxv.setEnabled(false);
        this.gxv.setClickable(false);
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
  
  private void fSH()
  {
    AppMethodBeat.i(70847);
    Object localObject;
    if (bqg())
    {
      com.tencent.mm.plugin.wallet_core.utils.f.fUi();
      this.HFI = new Authen();
      getInput().putBoolean("key_is_follow_bank_username", this.IeL.isChecked());
      if ((this.IfB != null) && (!Util.isNullOrNil(this.IfB.HVL)))
      {
        this.HFI.HCy = this.IfB.HVL;
        this.HFI.ANo = this.IfB.field_bindSerial;
        this.HFI.dDj = this.IfB.field_bankcardType;
        this.HFI.HUQ = this.IfB.HUQ;
        this.HFI.HUO = getInput().getString("key_pwd1");
        this.HFI.token = getInput().getString("kreq_token");
        com.tencent.mm.wallet_core.a.by(this);
        if (getNetController().r(new Object[] { this.HFI, this.CwO }))
        {
          Log.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
          AppMethodBeat.o(70847);
        }
      }
      else
      {
        localObject = getInput().getString("key_card_id");
        if (this.IeH.getVisibility() != 0) {
          break label615;
        }
        localObject = this.IeH.getText();
      }
    }
    label615:
    for (;;)
    {
      this.HFI.BDB = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.HFI.HUR = ((String)localObject);
      this.HFI.dDj = this.HRy.dDj;
      this.HFI.HUQ = this.HKd;
      this.HFI.HUO = getInput().getString("key_pwd1");
      if (!Util.isNullOrNil(this.Iel.getText())) {
        this.HFI.HUS = this.Iel.getText();
      }
      this.HFI.HQc = this.Ieo.getText();
      this.HFI.HUV = this.Iey.getText();
      this.HFI.HUW = this.Iez.getText();
      this.HFI.country = this.IeM;
      this.HFI.fuJ = this.yMR;
      this.HFI.fuK = this.yMS;
      this.HFI.iUO = this.IeB.getText();
      this.HFI.ynV = this.IeC.getText();
      this.HFI.ksV = this.IeD.getText();
      this.HFI.fuD = this.IeE.getText();
      localObject = com.tencent.mm.wallet_core.ui.f.bpt(this.HFI.HQc);
      getInput().putString("key_mobile", (String)localObject);
      localObject = getInput();
      if (this.HRy.HQg == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
        this.HFI.HUP = this.HJY.getText();
        this.HFI.HTZ = this.Idq.getText();
        this.HFI.HUT = this.Iek.getText();
        Log.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.HFI.BDB + " elemt.bankcardTag : " + this.HRy.HQg);
        break;
      }
      Log.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70847);
      return;
    }
  }
  
  private void fSL()
  {
    AppMethodBeat.i(70846);
    this.Iey.setVisibility(8);
    this.Iez.setVisibility(8);
    this.IeA.setVisibility(8);
    this.IeB.setVisibility(8);
    this.IeC.setVisibility(8);
    this.IeD.setVisibility(8);
    this.IeE.setVisibility(8);
    AppMethodBeat.o(70846);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(70844);
    if (this.IfB != null)
    {
      findViewById(2131310177).setVisibility(0);
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
          this.IeL.setText(getString(2131767572, new Object[] { this.IfB.field_bankName }));
          this.IeL.setVisibility(0);
          fSL();
          if ((Util.isNullOrNil(this.IfB.field_bankcardTail)) || (!e(this.IeH, this.IfB.HVy))) {
            break label508;
          }
          localObject1 = this.IeH;
          localObject2 = this.IeH;
          if (!this.IfB.fQd()) {
            break label524;
          }
          localObject3 = getString(2131767664);
          label156:
          if ((Util.isNullOrNil(this.IfB.field_bankName)) || (!e(this.IeY, this.IfB.field_bankName + " " + (String)localObject3))) {
            break label535;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.IeY;
          }
          localObject3 = this.IeY;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (e(this.Idq, this.IfB.field_trueName))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.Idq;
          }
          localObject3 = this.Idq;
        }
        localObject2 = localObject1;
        if (e(this.Ien, t.fQQ().av(getContext(), this.IfB.HUQ)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Ien;
          }
          localObject3 = this.Ien;
        }
        localObject1 = localObject2;
        if (e(this.HJY, this.IfB.HVx))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.HJY;
          }
          localObject3 = this.HJY;
        }
        localObject2 = localObject1;
        if (e(this.Ieo, this.IfB.field_mobile))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Ieo;
          }
          localObject3 = this.Ieo;
        }
        localObject1 = localObject2;
        if (e(this.Iel, this.IfB.HUS))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.Iel;
          }
          localObject3 = this.Iel;
        }
        localObject2 = localObject1;
        if (e(this.Iek, this.IfB.HVz))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Iek;
          }
          localObject3 = this.Iek;
        }
        ((WalletFormView)localObject2).setBackgroundResource(2131231898);
        ((WalletFormView)localObject3).setBackgroundResource(2131231898);
        if (!t.fQI().fRm()) {
          break label551;
        }
        this.gxv.setText(2131767584);
        AppMethodBeat.o(70844);
        return;
        this.IeL.setText((CharSequence)localObject1);
        break;
        this.IeL.setVisibility(8);
        break label94;
        label508:
        this.IeH.setVisibility(8);
        localObject2 = null;
        localObject1 = null;
        break label138;
        label524:
        localObject3 = getString(2131767684);
        break label156;
        label535:
        this.IeY.setVisibility(8);
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      label551:
      this.gxv.setText(2131767582);
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
    return 2131496910;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70843);
    this.IeH = ((WalletFormView)findViewById(2131310169));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.IeH);
    this.Ieo = ((WalletFormView)findViewById(2131304743));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.Ieo);
    this.Idq = ((WalletFormView)findViewById(2131305216));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Idq);
    this.Ien = ((WalletFormView)findViewById(2131310192));
    this.HJY = ((WalletFormView)findViewById(2131302521));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.HJY);
    this.IeY = ((WalletFormView)findViewById(2131310178));
    this.Iel = ((WalletFormView)findViewById(2131299398));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.Iel);
    this.Iek = ((WalletFormView)findViewById(2131299413));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.Iek);
    this.Ifz = ((TextView)findViewById(2131310278));
    this.Iey = ((WalletFormView)findViewById(2131301552));
    this.Iez = ((WalletFormView)findViewById(2131303014));
    this.IeA = ((WalletFormView)findViewById(2131297042));
    this.IeB = ((WalletFormView)findViewById(2131296553));
    this.IeC = ((WalletFormView)findViewById(2131305878));
    this.IeD = ((WalletFormView)findViewById(2131306062));
    this.IeE = ((WalletFormView)findViewById(2131299941));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.IeE);
    this.IfC = ((CheckBox)findViewById(2131296592));
    this.IeL = ((CheckBox)findViewById(2131296589));
    this.gxv = ((Button)findViewById(2131305423));
    this.IfA = ((MMScrollView)findViewById(2131310296));
    MMScrollView localMMScrollView = this.IfA;
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.IfA.setOnSizeChangeListener(new MMScrollView.b()
    {
      public final void ym(boolean paramAnonymousBoolean)
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
    this.Idq.setOnInputValidChangeListener(this);
    this.IeH.setOnInputValidChangeListener(this);
    this.Ien.setOnInputValidChangeListener(this);
    this.HJY.setOnInputValidChangeListener(this);
    this.Ieo.setOnInputValidChangeListener(this);
    this.Iel.setOnInputValidChangeListener(this);
    this.Iek.setOnInputValidChangeListener(this);
    this.Iey.setOnInputValidChangeListener(this);
    this.Iez.setOnInputValidChangeListener(this);
    this.IeA.setOnInputValidChangeListener(this);
    this.IeB.setOnInputValidChangeListener(this);
    this.IeC.setOnInputValidChangeListener(this);
    this.IeD.setOnInputValidChangeListener(this);
    this.IeE.setOnInputValidChangeListener(this);
    this.Idq.setOnEditorActionListener(this);
    this.IeH.setOnEditorActionListener(this);
    this.Ien.setOnEditorActionListener(this);
    this.HJY.setOnEditorActionListener(this);
    this.Ieo.setOnEditorActionListener(this);
    this.Iel.setOnEditorActionListener(this);
    this.Iek.setOnEditorActionListener(this);
    this.Iey.setOnEditorActionListener(this);
    this.Iez.setOnEditorActionListener(this);
    this.IeA.setOnEditorActionListener(this);
    this.IeB.setOnEditorActionListener(this);
    this.IeC.setOnEditorActionListener(this);
    this.IeD.setOnEditorActionListener(this);
    this.IeE.setOnEditorActionListener(this);
    this.IeY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70829);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardImportUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putString("key_bank_type", WalletCardImportUI.c(WalletCardImportUI.this).dDj);
        paramAnonymousView.putInt("key_bankcard_type", WalletCardImportUI.c(WalletCardImportUI.this).HXl);
        com.tencent.mm.wallet_core.a.by(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70829);
      }
    });
    this.Ien.setOnClickListener(new WalletCardImportUI.3(this));
    this.IfC.setChecked(true);
    this.IfC.setOnCheckedChangeListener(new WalletCardImportUI.4(this));
    this.IeL.setChecked(true);
    findViewById(2131296587).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70833);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        paramAnonymousView = new LinkedList();
        localObject = new LinkedList();
        paramAnonymousView.add(WalletCardImportUI.this.getString(2131767527));
        ((List)localObject).add(Integer.valueOf(0));
        if ((WalletCardImportUI.c(WalletCardImportUI.this) != null) && (WalletCardImportUI.c(WalletCardImportUI.this).HXD))
        {
          paramAnonymousView.add(WalletCardImportUI.this.getString(2131767525));
          ((List)localObject).add(Integer.valueOf(1));
        }
        h.a(WalletCardImportUI.this, "", paramAnonymousView, (List)localObject, "", new h.e()
        {
          public final void cy(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(70832);
            Intent localIntent = new Intent();
            switch (paramAnonymous2Int1)
            {
            }
            for (;;)
            {
              localIntent.putExtra("showShare", false);
              com.tencent.mm.wallet_core.ui.f.aA(WalletCardImportUI.this.getContext(), localIntent);
              AppMethodBeat.o(70832);
              return;
              localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131767402, new Object[] { LocaleUtil.getApplicationLanguage() }));
              continue;
              if (WalletCardImportUI.c(WalletCardImportUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131767400, new Object[] { LocaleUtil.getApplicationLanguage(), WalletCardImportUI.c(WalletCardImportUI.this).dDj }));
              }
            }
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70833);
      }
    });
    this.IeA.setOnClickListener(new WalletCardImportUI.6(this));
    this.gxv.setOnClickListener(new WalletCardImportUI.7(this));
    updateView();
    bqg();
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
      bqg();
      AppMethodBeat.o(70849);
      return;
      this.HRy = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
      updateView();
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.IeM = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.yMR = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.yMS = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        this.IeA.setText(str1 + " " + str4);
      }
      for (;;)
      {
        if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.HRy.HXy)) {
          break label418;
        }
        this.IeD.setVisibility(0);
        break;
        if (!Util.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.yMS = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.IeA.setText(str1 + " " + str3);
        }
        else
        {
          this.yMS = this.IeM;
          this.IeA.setText(str1);
        }
      }
      label418:
      this.IeD.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70842);
    super.onCreate(paramBundle);
    setMMTitle(2131767690);
    this.HRy = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.CwO = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.IfB = ((Bankcard)getInput().getParcelable("key_import_bankcard"));
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    Log.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    initView();
    this.IfA.pageScroll(33);
    com.tencent.mm.plugin.wallet_core.utils.f.b(this, getInput(), 3);
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
    Object localObject = new i(this, 2131821323);
    ((Dialog)localObject).setContentView(2131496950);
    ListView localListView = (ListView)((Dialog)localObject).findViewById(2131296545);
    localListView.setAdapter(this.IfD);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70836);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        WalletCardImportUI.this.dismissDialog(1);
        paramAnonymousInt = ((Integer)WalletCardImportUI.c(WalletCardImportUI.this).fQs().get(paramAnonymousInt)).intValue();
        if (WalletCardImportUI.f(WalletCardImportUI.this) != paramAnonymousInt)
        {
          WalletCardImportUI.a(WalletCardImportUI.this, paramAnonymousInt);
          WalletCardImportUI.g(WalletCardImportUI.this).setText(((CheckedTextView)paramAnonymousView).getText().toString());
          WalletCardImportUI.b(WalletCardImportUI.h(WalletCardImportUI.this), WalletCardImportUI.f(WalletCardImportUI.this));
          WalletCardImportUI.h(WalletCardImportUI.this).eIj();
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
      if (this.IeG == null) {
        fSH();
      }
      AppMethodBeat.o(70852);
      return false;
    }
    if (this.IeG != null) {
      if ((this.IeG.isEnabled()) && (!this.IeG.isClickable()) && (this.IeG.hhZ())) {
        this.IeG.hic();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70852);
      return true;
      this.IeG.performClick();
      continue;
      fSH();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70851);
    bqg();
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
      if ((paramq instanceof ad))
      {
        paramString.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.l(this, paramString);
        h.cD(this, getString(2131767480));
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