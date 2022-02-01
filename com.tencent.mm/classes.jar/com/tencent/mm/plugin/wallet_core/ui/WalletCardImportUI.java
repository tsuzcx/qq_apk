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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.MMScrollView.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.LinkedList;
import java.util.List;

public class WalletCardImportUI
  extends WalletBaseUI
  implements TextView.OnEditorActionListener, WalletFormView.a
{
  private static final String[] BEr = { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT" };
  private WalletFormView BCi;
  private WalletFormView BDA;
  private CheckBox BDE;
  private String BDF;
  private WalletFormView BDR;
  private WalletFormView BDd;
  private WalletFormView BDe;
  private WalletFormView BDg;
  private WalletFormView BDh;
  private WalletFormView BDr;
  private WalletFormView BDs;
  private WalletFormView BDt;
  private WalletFormView BDu;
  private WalletFormView BDv;
  private WalletFormView BDw;
  private WalletFormView BDx;
  private WalletFormView BDz;
  private TextView BEs;
  private MMScrollView BEt;
  private Bankcard BEu;
  private CheckBox BEv;
  private BaseAdapter BEw;
  private Authen Bia;
  private WalletFormView Bmi;
  private int Bmm;
  private ElementQuery Bqm;
  private Button fwU;
  private Dialog mDialog;
  private ao mHandler;
  private PayInfo mPayInfo;
  private String ueo;
  private String uep;
  private Orders wSu;
  
  public WalletCardImportUI()
  {
    AppMethodBeat.i(70841);
    this.mDialog = null;
    this.BDz = null;
    this.mHandler = new ao();
    this.Bqm = new ElementQuery();
    this.Bia = new Authen();
    this.wSu = null;
    this.mPayInfo = null;
    this.BEu = null;
    this.Bmm = 1;
    this.BEw = new BaseAdapter()
    {
      private Integer ql(int paramAnonymousInt)
      {
        AppMethodBeat.i(70838);
        Integer localInteger = (Integer)WalletCardImportUI.c(WalletCardImportUI.this).eri().get(paramAnonymousInt);
        AppMethodBeat.o(70838);
        return localInteger;
      }
      
      public final int getCount()
      {
        AppMethodBeat.i(70837);
        if (WalletCardImportUI.c(WalletCardImportUI.this).eri() != null)
        {
          int i = WalletCardImportUI.c(WalletCardImportUI.this).eri().size();
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
        paramAnonymousView = (CheckedTextView)View.inflate(WalletCardImportUI.this, 2131495971, null);
        paramAnonymousView.setText(s.erG().aj(WalletCardImportUI.this, ql(paramAnonymousInt).intValue()));
        if (WalletCardImportUI.f(WalletCardImportUI.this) == ql(paramAnonymousInt).intValue()) {
          paramAnonymousView.setChecked(true);
        }
        for (;;)
        {
          paramAnonymousView.setBackgroundResource(2131231818);
          AppMethodBeat.o(70839);
          return paramAnonymousView;
          paramAnonymousView.setChecked(false);
        }
      }
    };
    AppMethodBeat.o(70841);
  }
  
  private boolean aRK()
  {
    AppMethodBeat.i(70850);
    if (!this.BEv.isChecked()) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool)
      {
        this.fwU.setEnabled(true);
        this.fwU.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(70850);
        return bool;
        this.fwU.setEnabled(false);
        this.fwU.setClickable(false);
      }
    }
  }
  
  private void cL()
  {
    AppMethodBeat.i(70844);
    if (this.BEu != null)
    {
      findViewById(2131306716).setVisibility(0);
      Object localObject1;
      label89:
      Object localObject2;
      label133:
      Object localObject3;
      if (!bs.isNullOrNil(getInput().getString("key_bank_username")))
      {
        localObject1 = getInput().getString("key_recommand_desc");
        if (bs.isNullOrNil((String)localObject1))
        {
          this.BDE.setText(getString(2131765129, new Object[] { this.BEu.field_bankName }));
          this.BDE.setVisibility(0);
          ets();
          if ((bs.isNullOrNil(this.BEu.field_bankcardTail)) || (!e(this.BDA, this.BEu.Buk))) {
            break label501;
          }
          localObject1 = this.BDA;
          localObject2 = this.BDA;
          if (!this.BEu.eqT()) {
            break label517;
          }
          localObject3 = getString(2131765221);
          label150:
          if ((bs.isNullOrNil(this.BEu.field_bankName)) || (!e(this.BDR, this.BEu.field_bankName + " " + (String)localObject3))) {
            break label528;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.BDR;
          }
          localObject3 = this.BDR;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (e(this.BCi, this.BEu.field_trueName))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.BCi;
          }
          localObject3 = this.BCi;
        }
        localObject2 = localObject1;
        if (e(this.BDg, s.erG().aj(getContext(), this.BEu.BtC)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.BDg;
          }
          localObject3 = this.BDg;
        }
        localObject1 = localObject2;
        if (e(this.Bmi, this.BEu.Buj))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.Bmi;
          }
          localObject3 = this.Bmi;
        }
        localObject2 = localObject1;
        if (e(this.BDh, this.BEu.field_mobile))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.BDh;
          }
          localObject3 = this.BDh;
        }
        localObject1 = localObject2;
        if (e(this.BDe, this.BEu.BtE))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.BDe;
          }
          localObject3 = this.BDe;
        }
        localObject2 = localObject1;
        if (e(this.BDd, this.BEu.Bul))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.BDd;
          }
          localObject3 = this.BDd;
        }
        ((WalletFormView)localObject2).setBackgroundResource(2131231818);
        ((WalletFormView)localObject3).setBackgroundResource(2131231818);
        if (!s.ery().esc()) {
          break label544;
        }
        this.fwU.setText(2131765141);
        AppMethodBeat.o(70844);
        return;
        this.BDE.setText((CharSequence)localObject1);
        break;
        this.BDE.setVisibility(8);
        break label89;
        label501:
        this.BDA.setVisibility(8);
        localObject2 = null;
        localObject1 = null;
        break label133;
        label517:
        localObject3 = getString(2131765241);
        break label150;
        label528:
        this.BDR.setVisibility(8);
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      label544:
      this.fwU.setText(2131765139);
      AppMethodBeat.o(70844);
      return;
    }
    AppMethodBeat.o(70844);
  }
  
  private static boolean e(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(70845);
    if (!bs.isNullOrNil(paramString))
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
  
  private void eto()
  {
    AppMethodBeat.i(70847);
    Object localObject;
    if (aRK())
    {
      f.euN();
      this.Bia = new Authen();
      getInput().putBoolean("key_is_follow_bank_username", this.BDE.isChecked());
      if ((this.BEu != null) && (!bs.isNullOrNil(this.BEu.Bux)))
      {
        this.Bia.BeX = this.BEu.Bux;
        this.Bia.vwo = this.BEu.field_bindSerial;
        this.Bia.cZz = this.BEu.field_bankcardType;
        this.Bia.BtC = this.BEu.BtC;
        this.Bia.BtA = getInput().getString("key_pwd1");
        this.Bia.token = getInput().getString("kreq_token");
        com.tencent.mm.wallet_core.a.br(this);
        if (getNetController().s(new Object[] { this.Bia, this.wSu }))
        {
          ac.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
          AppMethodBeat.o(70847);
        }
      }
      else
      {
        localObject = getInput().getString("key_card_id");
        if (this.BDA.getVisibility() != 0) {
          break label619;
        }
        localObject = this.BDA.getText();
      }
    }
    label619:
    for (;;)
    {
      this.Bia.wfX = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.Bia.BtD = ((String)localObject);
      this.Bia.cZz = this.Bqm.cZz;
      this.Bia.BtC = this.Bmm;
      this.Bia.BtA = getInput().getString("key_pwd1");
      if (!bs.isNullOrNil(this.BDe.getText())) {
        this.Bia.BtE = this.BDe.getText();
      }
      this.Bia.BoQ = this.BDh.getText();
      this.Bia.BtH = this.BDr.getText();
      this.Bia.BtI = this.BDs.getText();
      this.Bia.country = this.BDF;
      this.Bia.exV = this.ueo;
      this.Bia.exW = this.uep;
      this.Bia.hEt = this.BDu.getText();
      this.Bia.tGU = this.BDv.getText();
      this.Bia.iYE = this.BDw.getText();
      this.Bia.exO = this.BDx.getText();
      localObject = e.aSJ(this.Bia.BoQ);
      getInput().putString("key_mobile", (String)localObject);
      localObject = getInput();
      if (this.Bqm.BoU == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
        this.Bia.BtB = this.Bmi.getText();
        this.Bia.BsL = this.BCi.getText();
        this.Bia.BtF = this.BDd.getText();
        ac.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.Bia.wfX + " elemt.bankcardTag : " + this.Bqm.BoU);
        break;
      }
      ac.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70847);
      return;
    }
  }
  
  private void ets()
  {
    AppMethodBeat.i(70846);
    this.BDr.setVisibility(8);
    this.BDs.setVisibility(8);
    this.BDt.setVisibility(8);
    this.BDu.setVisibility(8);
    this.BDv.setVisibility(8);
    this.BDw.setVisibility(8);
    this.BDx.setVisibility(8);
    AppMethodBeat.o(70846);
  }
  
  public boolean getCancelable()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131495930;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70843);
    this.BDA = ((WalletFormView)findViewById(2131306708));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.BDA);
    this.BDh = ((WalletFormView)findViewById(2131302346));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.BDh);
    this.BCi = ((WalletFormView)findViewById(2131302662));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.BCi);
    this.BDg = ((WalletFormView)findViewById(2131306730));
    this.Bmi = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.Bmi);
    this.BDR = ((WalletFormView)findViewById(2131306717));
    this.BDe = ((WalletFormView)findViewById(2131298914));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.BDe);
    this.BDd = ((WalletFormView)findViewById(2131298929));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.BDd);
    this.BEs = ((TextView)findViewById(2131306817));
    this.BDr = ((WalletFormView)findViewById(2131300112));
    this.BDs = ((WalletFormView)findViewById(2131301314));
    this.BDt = ((WalletFormView)findViewById(2131296936));
    this.BDu = ((WalletFormView)findViewById(2131296479));
    this.BDv = ((WalletFormView)findViewById(2131303210));
    this.BDw = ((WalletFormView)findViewById(2131303363));
    this.BDx = ((WalletFormView)findViewById(2131299329));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.BDx);
    this.BEv = ((CheckBox)findViewById(2131296518));
    this.BDE = ((CheckBox)findViewById(2131296515));
    this.fwU = ((Button)findViewById(2131302852));
    this.BEt = ((MMScrollView)findViewById(2131306834));
    MMScrollView localMMScrollView = this.BEt;
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.BEt.setOnSizeChangeListener(new MMScrollView.b()
    {
      public final void tG(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70828);
        if (paramAnonymousBoolean) {}
        for (final int i = 8;; i = 0)
        {
          ac.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : ".concat(String.valueOf(paramAnonymousBoolean)));
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
    this.BCi.setOnInputValidChangeListener(this);
    this.BDA.setOnInputValidChangeListener(this);
    this.BDg.setOnInputValidChangeListener(this);
    this.Bmi.setOnInputValidChangeListener(this);
    this.BDh.setOnInputValidChangeListener(this);
    this.BDe.setOnInputValidChangeListener(this);
    this.BDd.setOnInputValidChangeListener(this);
    this.BDr.setOnInputValidChangeListener(this);
    this.BDs.setOnInputValidChangeListener(this);
    this.BDt.setOnInputValidChangeListener(this);
    this.BDu.setOnInputValidChangeListener(this);
    this.BDv.setOnInputValidChangeListener(this);
    this.BDw.setOnInputValidChangeListener(this);
    this.BDx.setOnInputValidChangeListener(this);
    this.BCi.setOnEditorActionListener(this);
    this.BDA.setOnEditorActionListener(this);
    this.BDg.setOnEditorActionListener(this);
    this.Bmi.setOnEditorActionListener(this);
    this.BDh.setOnEditorActionListener(this);
    this.BDe.setOnEditorActionListener(this);
    this.BDd.setOnEditorActionListener(this);
    this.BDr.setOnEditorActionListener(this);
    this.BDs.setOnEditorActionListener(this);
    this.BDt.setOnEditorActionListener(this);
    this.BDu.setOnEditorActionListener(this);
    this.BDv.setOnEditorActionListener(this);
    this.BDw.setOnEditorActionListener(this);
    this.BDx.setOnEditorActionListener(this);
    this.BDR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70829);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardImportUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putString("key_bank_type", WalletCardImportUI.c(WalletCardImportUI.this).cZz);
        paramAnonymousView.putInt("key_bankcard_type", WalletCardImportUI.c(WalletCardImportUI.this).BvY);
        com.tencent.mm.wallet_core.a.br(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        AppMethodBeat.o(70829);
      }
    });
    this.BDg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70830);
        WalletCardImportUI.this.showDialog(1);
        AppMethodBeat.o(70830);
      }
    });
    this.BEv.setChecked(true);
    this.BEv.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70831);
        WalletCardImportUI.d(WalletCardImportUI.this);
        AppMethodBeat.o(70831);
      }
    });
    this.BDE.setChecked(true);
    findViewById(2131296513).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70833);
        paramAnonymousView = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        paramAnonymousView.add(WalletCardImportUI.this.getString(2131765084));
        localLinkedList.add(Integer.valueOf(0));
        if ((WalletCardImportUI.c(WalletCardImportUI.this) != null) && (WalletCardImportUI.c(WalletCardImportUI.this).Bwq))
        {
          paramAnonymousView.add(WalletCardImportUI.this.getString(2131765082));
          localLinkedList.add(Integer.valueOf(1));
        }
        h.a(WalletCardImportUI.this, "", paramAnonymousView, localLinkedList, "", new h.d()
        {
          public final void ct(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(70832);
            Intent localIntent = new Intent();
            switch (paramAnonymous2Int1)
            {
            }
            for (;;)
            {
              localIntent.putExtra("showShare", false);
              e.al(WalletCardImportUI.this.getContext(), localIntent);
              AppMethodBeat.o(70832);
              return;
              localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131764961, new Object[] { ab.eUO() }));
              continue;
              if (WalletCardImportUI.c(WalletCardImportUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131764959, new Object[] { ab.eUO(), WalletCardImportUI.c(WalletCardImportUI.this).cZz }));
              }
            }
          }
        });
        AppMethodBeat.o(70833);
      }
    });
    this.BDt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70834);
        WalletCardImportUI.this.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
        AppMethodBeat.o(70834);
      }
    });
    this.fwU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70835);
        WalletCardImportUI.e(WalletCardImportUI.this);
        AppMethodBeat.o(70835);
      }
    });
    cL();
    aRK();
    AppMethodBeat.o(70843);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70849);
    ac.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      aRK();
      AppMethodBeat.o(70849);
      return;
      this.Bqm = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
      cL();
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.BDF = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bs.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.ueo = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.uep = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        this.BDt.setText(str1 + " " + str4);
      }
      for (;;)
      {
        if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.Bqm.Bwl)) {
          break label418;
        }
        this.BDw.setVisibility(0);
        break;
        if (!bs.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.uep = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.BDt.setText(str1 + " " + str3);
        }
        else
        {
          this.uep = this.BDF;
          this.BDt.setText(str1);
        }
      }
      label418:
      this.BDw.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70842);
    super.onCreate(paramBundle);
    setMMTitle(2131765247);
    this.Bqm = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.wSu = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.BEu = ((Bankcard)getInput().getParcelable("key_import_bankcard"));
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    ac.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    initView();
    this.BEt.pageScroll(33);
    f.a(this, getInput(), 3);
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
    Object localObject = new i(this, 2131821285);
    ((Dialog)localObject).setContentView(2131495970);
    ListView localListView = (ListView)((Dialog)localObject).findViewById(2131296471);
    localListView.setAdapter(this.BEw);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70836);
        WalletCardImportUI.this.dismissDialog(1);
        paramAnonymousInt = ((Integer)WalletCardImportUI.c(WalletCardImportUI.this).eri().get(paramAnonymousInt)).intValue();
        if (WalletCardImportUI.f(WalletCardImportUI.this) != paramAnonymousInt)
        {
          WalletCardImportUI.a(WalletCardImportUI.this, paramAnonymousInt);
          WalletCardImportUI.g(WalletCardImportUI.this).setText(((CheckedTextView)paramAnonymousView).getText().toString());
          WalletCardImportUI.b(WalletCardImportUI.h(WalletCardImportUI.this), WalletCardImportUI.f(WalletCardImportUI.this));
          WalletCardImportUI.h(WalletCardImportUI.this).dtH();
          WalletCardImportUI.i(WalletCardImportUI.this);
        }
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
    ac.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.BDz == null) {
        eto();
      }
      AppMethodBeat.o(70852);
      return false;
    }
    if (this.BDz != null) {
      if ((this.BDz.isEnabled()) && (!this.BDz.isClickable()) && (this.BDz.fAV())) {
        this.BDz.fAY();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70852);
      return true;
      this.BDz.performClick();
      continue;
      eto();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70851);
    aRK();
    AppMethodBeat.o(70851);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70848);
    ac.d("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      ac.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramn instanceof ad))
      {
        paramString.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.k(this, paramString);
        h.cg(this, getString(2131765037));
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