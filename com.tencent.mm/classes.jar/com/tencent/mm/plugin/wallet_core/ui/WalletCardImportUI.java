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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
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
  private static final String[] Dwn = { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT" };
  private Authen CZU;
  private WalletFormView Def;
  private int Dej;
  private ElementQuery Dif;
  private WalletFormView DuZ;
  private WalletFormView Due;
  private CheckBox DvA;
  private String DvB;
  private WalletFormView DvN;
  private WalletFormView Dva;
  private WalletFormView Dvc;
  private WalletFormView Dvd;
  private WalletFormView Dvn;
  private WalletFormView Dvo;
  private WalletFormView Dvp;
  private WalletFormView Dvq;
  private WalletFormView Dvr;
  private WalletFormView Dvs;
  private WalletFormView Dvt;
  private WalletFormView Dvv;
  private WalletFormView Dvw;
  private TextView Dwo;
  private MMScrollView Dwp;
  private Bankcard Dwq;
  private CheckBox Dwr;
  private BaseAdapter Dws;
  private Button fSn;
  private Dialog mDialog;
  private aq mHandler;
  private PayInfo mPayInfo;
  private String vte;
  private String vtf;
  private Orders yvS;
  
  public WalletCardImportUI()
  {
    AppMethodBeat.i(70841);
    this.mDialog = null;
    this.Dvv = null;
    this.mHandler = new aq();
    this.Dif = new ElementQuery();
    this.CZU = new Authen();
    this.yvS = null;
    this.mPayInfo = null;
    this.Dwq = null;
    this.Dej = 1;
    this.Dws = new BaseAdapter()
    {
      private Integer qP(int paramAnonymousInt)
      {
        AppMethodBeat.i(70838);
        Integer localInteger = (Integer)WalletCardImportUI.c(WalletCardImportUI.this).eIP().get(paramAnonymousInt);
        AppMethodBeat.o(70838);
        return localInteger;
      }
      
      public final int getCount()
      {
        AppMethodBeat.i(70837);
        if (WalletCardImportUI.c(WalletCardImportUI.this).eIP() != null)
        {
          int i = WalletCardImportUI.c(WalletCardImportUI.this).eIP().size();
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
        paramAnonymousView.setText(t.eJn().am(WalletCardImportUI.this, qP(paramAnonymousInt).intValue()));
        if (WalletCardImportUI.f(WalletCardImportUI.this) == qP(paramAnonymousInt).intValue()) {
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
  
  private boolean aVv()
  {
    AppMethodBeat.i(70850);
    if (!this.Dwr.isChecked()) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool)
      {
        this.fSn.setEnabled(true);
        this.fSn.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(70850);
        return bool;
        this.fSn.setEnabled(false);
        this.fSn.setClickable(false);
      }
    }
  }
  
  private static boolean e(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(70845);
    if (!bu.isNullOrNil(paramString))
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
  
  private void eLc()
  {
    AppMethodBeat.i(70847);
    Object localObject;
    if (aVv())
    {
      com.tencent.mm.plugin.wallet_core.utils.f.eMB();
      this.CZU = new Authen();
      getInput().putBoolean("key_is_follow_bank_username", this.DvA.isChecked());
      if ((this.Dwq != null) && (!bu.isNullOrNil(this.Dwq.Dms)))
      {
        this.CZU.CWS = this.Dwq.Dms;
        this.CZU.wRt = this.Dwq.field_bindSerial;
        this.CZU.dlT = this.Dwq.field_bankcardType;
        this.CZU.Dlx = this.Dwq.Dlx;
        this.CZU.Dlv = getInput().getString("key_pwd1");
        this.CZU.token = getInput().getString("kreq_token");
        com.tencent.mm.wallet_core.a.bs(this);
        if (getNetController().r(new Object[] { this.CZU, this.yvS }))
        {
          ae.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
          AppMethodBeat.o(70847);
        }
      }
      else
      {
        localObject = getInput().getString("key_card_id");
        if (this.Dvw.getVisibility() != 0) {
          break label615;
        }
        localObject = this.Dvw.getText();
      }
    }
    label615:
    for (;;)
    {
      this.CZU.xDC = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.CZU.Dly = ((String)localObject);
      this.CZU.dlT = this.Dif.dlT;
      this.CZU.Dlx = this.Dej;
      this.CZU.Dlv = getInput().getString("key_pwd1");
      if (!bu.isNullOrNil(this.Dva.getText())) {
        this.CZU.Dlz = this.Dva.getText();
      }
      this.CZU.DgJ = this.Dvd.getText();
      this.CZU.DlC = this.Dvn.getText();
      this.CZU.DlD = this.Dvo.getText();
      this.CZU.country = this.DvB;
      this.CZU.eRf = this.vte;
      this.CZU.eRg = this.vtf;
      this.CZU.hZQ = this.Dvq.getText();
      this.CZU.uVu = this.Dvr.getText();
      this.CZU.juG = this.Dvs.getText();
      this.CZU.eQY = this.Dvt.getText();
      localObject = com.tencent.mm.wallet_core.ui.f.bal(this.CZU.DgJ);
      getInput().putString("key_mobile", (String)localObject);
      localObject = getInput();
      if (this.Dif.DgN == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
        this.CZU.Dlw = this.Def.getText();
        this.CZU.DkG = this.Due.getText();
        this.CZU.DlA = this.DuZ.getText();
        ae.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.CZU.xDC + " elemt.bankcardTag : " + this.Dif.DgN);
        break;
      }
      ae.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70847);
      return;
    }
  }
  
  private void eLg()
  {
    AppMethodBeat.i(70846);
    this.Dvn.setVisibility(8);
    this.Dvo.setVisibility(8);
    this.Dvp.setVisibility(8);
    this.Dvq.setVisibility(8);
    this.Dvr.setVisibility(8);
    this.Dvs.setVisibility(8);
    this.Dvt.setVisibility(8);
    AppMethodBeat.o(70846);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(70844);
    if (this.Dwq != null)
    {
      findViewById(2131306716).setVisibility(0);
      Object localObject1;
      label94:
      Object localObject2;
      label138:
      Object localObject3;
      if (!bu.isNullOrNil(getInput().getString("key_bank_username")))
      {
        localObject1 = getInput().getString("key_recommand_desc");
        if (bu.isNullOrNil((String)localObject1))
        {
          this.DvA.setText(getString(2131765129, new Object[] { this.Dwq.field_bankName }));
          this.DvA.setVisibility(0);
          eLg();
          if ((bu.isNullOrNil(this.Dwq.field_bankcardTail)) || (!e(this.Dvw, this.Dwq.Dmf))) {
            break label508;
          }
          localObject1 = this.Dvw;
          localObject2 = this.Dvw;
          if (!this.Dwq.eIA()) {
            break label524;
          }
          localObject3 = getString(2131765221);
          label156:
          if ((bu.isNullOrNil(this.Dwq.field_bankName)) || (!e(this.DvN, this.Dwq.field_bankName + " " + (String)localObject3))) {
            break label535;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.DvN;
          }
          localObject3 = this.DvN;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (e(this.Due, this.Dwq.field_trueName))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.Due;
          }
          localObject3 = this.Due;
        }
        localObject2 = localObject1;
        if (e(this.Dvc, t.eJn().am(getContext(), this.Dwq.Dlx)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Dvc;
          }
          localObject3 = this.Dvc;
        }
        localObject1 = localObject2;
        if (e(this.Def, this.Dwq.Dme))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.Def;
          }
          localObject3 = this.Def;
        }
        localObject2 = localObject1;
        if (e(this.Dvd, this.Dwq.field_mobile))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Dvd;
          }
          localObject3 = this.Dvd;
        }
        localObject1 = localObject2;
        if (e(this.Dva, this.Dwq.Dlz))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.Dva;
          }
          localObject3 = this.Dva;
        }
        localObject2 = localObject1;
        if (e(this.DuZ, this.Dwq.Dmg))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.DuZ;
          }
          localObject3 = this.DuZ;
        }
        ((WalletFormView)localObject2).setBackgroundResource(2131231818);
        ((WalletFormView)localObject3).setBackgroundResource(2131231818);
        if (!t.eJf().eJJ()) {
          break label551;
        }
        this.fSn.setText(2131765141);
        AppMethodBeat.o(70844);
        return;
        this.DvA.setText((CharSequence)localObject1);
        break;
        this.DvA.setVisibility(8);
        break label94;
        label508:
        this.Dvw.setVisibility(8);
        localObject2 = null;
        localObject1 = null;
        break label138;
        label524:
        localObject3 = getString(2131765241);
        break label156;
        label535:
        this.DvN.setVisibility(8);
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      label551:
      this.fSn.setText(2131765139);
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
    return 2131495930;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70843);
    this.Dvw = ((WalletFormView)findViewById(2131306708));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Dvw);
    this.Dvd = ((WalletFormView)findViewById(2131302346));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.Dvd);
    this.Due = ((WalletFormView)findViewById(2131302662));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.Due);
    this.Dvc = ((WalletFormView)findViewById(2131306730));
    this.Def = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.Def);
    this.DvN = ((WalletFormView)findViewById(2131306717));
    this.Dva = ((WalletFormView)findViewById(2131298914));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.Dva);
    this.DuZ = ((WalletFormView)findViewById(2131298929));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.DuZ);
    this.Dwo = ((TextView)findViewById(2131306817));
    this.Dvn = ((WalletFormView)findViewById(2131300112));
    this.Dvo = ((WalletFormView)findViewById(2131301314));
    this.Dvp = ((WalletFormView)findViewById(2131296936));
    this.Dvq = ((WalletFormView)findViewById(2131296479));
    this.Dvr = ((WalletFormView)findViewById(2131303210));
    this.Dvs = ((WalletFormView)findViewById(2131303363));
    this.Dvt = ((WalletFormView)findViewById(2131299329));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.Dvt);
    this.Dwr = ((CheckBox)findViewById(2131296518));
    this.DvA = ((CheckBox)findViewById(2131296515));
    this.fSn = ((Button)findViewById(2131302852));
    this.Dwp = ((MMScrollView)findViewById(2131306834));
    MMScrollView localMMScrollView = this.Dwp;
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.Dwp.setOnSizeChangeListener(new MMScrollView.b()
    {
      public final void uy(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70828);
        if (paramAnonymousBoolean) {}
        for (final int i = 8;; i = 0)
        {
          ae.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : ".concat(String.valueOf(paramAnonymousBoolean)));
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
    this.Due.setOnInputValidChangeListener(this);
    this.Dvw.setOnInputValidChangeListener(this);
    this.Dvc.setOnInputValidChangeListener(this);
    this.Def.setOnInputValidChangeListener(this);
    this.Dvd.setOnInputValidChangeListener(this);
    this.Dva.setOnInputValidChangeListener(this);
    this.DuZ.setOnInputValidChangeListener(this);
    this.Dvn.setOnInputValidChangeListener(this);
    this.Dvo.setOnInputValidChangeListener(this);
    this.Dvp.setOnInputValidChangeListener(this);
    this.Dvq.setOnInputValidChangeListener(this);
    this.Dvr.setOnInputValidChangeListener(this);
    this.Dvs.setOnInputValidChangeListener(this);
    this.Dvt.setOnInputValidChangeListener(this);
    this.Due.setOnEditorActionListener(this);
    this.Dvw.setOnEditorActionListener(this);
    this.Dvc.setOnEditorActionListener(this);
    this.Def.setOnEditorActionListener(this);
    this.Dvd.setOnEditorActionListener(this);
    this.Dva.setOnEditorActionListener(this);
    this.DuZ.setOnEditorActionListener(this);
    this.Dvn.setOnEditorActionListener(this);
    this.Dvo.setOnEditorActionListener(this);
    this.Dvp.setOnEditorActionListener(this);
    this.Dvq.setOnEditorActionListener(this);
    this.Dvr.setOnEditorActionListener(this);
    this.Dvs.setOnEditorActionListener(this);
    this.Dvt.setOnEditorActionListener(this);
    this.DvN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70829);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardImportUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putString("key_bank_type", WalletCardImportUI.c(WalletCardImportUI.this).dlT);
        paramAnonymousView.putInt("key_bankcard_type", WalletCardImportUI.c(WalletCardImportUI.this).DnT);
        com.tencent.mm.wallet_core.a.bs(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70829);
      }
    });
    this.Dvc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70830);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletCardImportUI.this.showDialog(1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70830);
      }
    });
    this.Dwr.setChecked(true);
    this.Dwr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70831);
        WalletCardImportUI.d(WalletCardImportUI.this);
        AppMethodBeat.o(70831);
      }
    });
    this.DvA.setChecked(true);
    findViewById(2131296513).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70833);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = new LinkedList();
        localObject = new LinkedList();
        paramAnonymousView.add(WalletCardImportUI.this.getString(2131765084));
        ((List)localObject).add(Integer.valueOf(0));
        if ((WalletCardImportUI.c(WalletCardImportUI.this) != null) && (WalletCardImportUI.c(WalletCardImportUI.this).Dol))
        {
          paramAnonymousView.add(WalletCardImportUI.this.getString(2131765082));
          ((List)localObject).add(Integer.valueOf(1));
        }
        h.a(WalletCardImportUI.this, "", paramAnonymousView, (List)localObject, "", new h.d()
        {
          public final void cv(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(70832);
            Intent localIntent = new Intent();
            switch (paramAnonymous2Int1)
            {
            }
            for (;;)
            {
              localIntent.putExtra("showShare", false);
              com.tencent.mm.wallet_core.ui.f.an(WalletCardImportUI.this.getContext(), localIntent);
              AppMethodBeat.o(70832);
              return;
              localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131764961, new Object[] { com.tencent.mm.sdk.platformtools.ad.fom() }));
              continue;
              if (WalletCardImportUI.c(WalletCardImportUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131764959, new Object[] { com.tencent.mm.sdk.platformtools.ad.fom(), WalletCardImportUI.c(WalletCardImportUI.this).dlT }));
              }
            }
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70833);
      }
    });
    this.Dvp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70834);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletCardImportUI.this.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70834);
      }
    });
    this.fSn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70835);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletCardImportUI.e(WalletCardImportUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70835);
      }
    });
    updateView();
    aVv();
    AppMethodBeat.o(70843);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70849);
    ae.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      aVv();
      AppMethodBeat.o(70849);
      return;
      this.Dif = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
      updateView();
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.DvB = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bu.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.vte = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.vtf = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        this.Dvp.setText(str1 + " " + str4);
      }
      for (;;)
      {
        if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.Dif.Dog)) {
          break label418;
        }
        this.Dvs.setVisibility(0);
        break;
        if (!bu.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.vtf = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.Dvp.setText(str1 + " " + str3);
        }
        else
        {
          this.vtf = this.DvB;
          this.Dvp.setText(str1);
        }
      }
      label418:
      this.Dvs.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70842);
    super.onCreate(paramBundle);
    setMMTitle(2131765247);
    this.Dif = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.yvS = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.Dwq = ((Bankcard)getInput().getParcelable("key_import_bankcard"));
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    ae.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    initView();
    this.Dwp.pageScroll(33);
    com.tencent.mm.plugin.wallet_core.utils.f.a(this, getInput(), 3);
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
    localListView.setAdapter(this.Dws);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70836);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        WalletCardImportUI.this.dismissDialog(1);
        paramAnonymousInt = ((Integer)WalletCardImportUI.c(WalletCardImportUI.this).eIP().get(paramAnonymousInt)).intValue();
        if (WalletCardImportUI.f(WalletCardImportUI.this) != paramAnonymousInt)
        {
          WalletCardImportUI.a(WalletCardImportUI.this, paramAnonymousInt);
          WalletCardImportUI.g(WalletCardImportUI.this).setText(((CheckedTextView)paramAnonymousView).getText().toString());
          WalletCardImportUI.b(WalletCardImportUI.h(WalletCardImportUI.this), WalletCardImportUI.f(WalletCardImportUI.this));
          WalletCardImportUI.h(WalletCardImportUI.this).dHv();
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
    ae.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.Dvv == null) {
        eLc();
      }
      AppMethodBeat.o(70852);
      return false;
    }
    if (this.Dvv != null) {
      if ((this.Dvv.isEnabled()) && (!this.Dvv.isClickable()) && (this.Dvv.fWB())) {
        this.Dvv.fWE();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70852);
      return true;
      this.Dvv.performClick();
      continue;
      eLc();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70851);
    aVv();
    AppMethodBeat.o(70851);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70848);
    ae.d("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      ae.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        paramString.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.k(this, paramString);
        h.cm(this, getString(2131765037));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI
 * JD-Core Version:    0.7.0.1
 */