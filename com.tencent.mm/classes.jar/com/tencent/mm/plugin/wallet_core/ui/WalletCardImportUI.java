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
import com.tencent.mm.al.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.utils.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static final String[] DeJ = { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT" };
  private Authen CIo;
  private int CMB;
  private WalletFormView CMx;
  private ElementQuery CQB;
  private WalletFormView DcA;
  private WalletFormView DdJ;
  private WalletFormView DdK;
  private WalletFormView DdL;
  private WalletFormView DdM;
  private WalletFormView DdN;
  private WalletFormView DdO;
  private WalletFormView DdP;
  private WalletFormView DdR;
  private WalletFormView DdS;
  private CheckBox DdW;
  private String DdX;
  private WalletFormView Ddv;
  private WalletFormView Ddw;
  private WalletFormView Ddy;
  private WalletFormView Ddz;
  private TextView DeK;
  private MMScrollView DeL;
  private Bankcard DeM;
  private CheckBox DeN;
  private BaseAdapter DeO;
  private WalletFormView Dej;
  private Button fQh;
  private Dialog mDialog;
  private ap mHandler;
  private PayInfo mPayInfo;
  private String vgX;
  private String vgY;
  private Orders ygb;
  
  public WalletCardImportUI()
  {
    AppMethodBeat.i(70841);
    this.mDialog = null;
    this.DdR = null;
    this.mHandler = new ap();
    this.CQB = new ElementQuery();
    this.CIo = new Authen();
    this.ygb = null;
    this.mPayInfo = null;
    this.DeM = null;
    this.CMB = 1;
    this.DeO = new BaseAdapter()
    {
      private Integer qM(int paramAnonymousInt)
      {
        AppMethodBeat.i(70838);
        Integer localInteger = (Integer)WalletCardImportUI.c(WalletCardImportUI.this).eFi().get(paramAnonymousInt);
        AppMethodBeat.o(70838);
        return localInteger;
      }
      
      public final int getCount()
      {
        AppMethodBeat.i(70837);
        if (WalletCardImportUI.c(WalletCardImportUI.this).eFi() != null)
        {
          int i = WalletCardImportUI.c(WalletCardImportUI.this).eFi().size();
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
        paramAnonymousView.setText(t.eFG().am(WalletCardImportUI.this, qM(paramAnonymousInt).intValue()));
        if (WalletCardImportUI.f(WalletCardImportUI.this) == qM(paramAnonymousInt).intValue()) {
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
  
  private boolean aUW()
  {
    AppMethodBeat.i(70850);
    if (!this.DeN.isChecked()) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool)
      {
        this.fQh.setEnabled(true);
        this.fQh.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(70850);
        return bool;
        this.fQh.setEnabled(false);
        this.fQh.setClickable(false);
      }
    }
  }
  
  private static boolean e(WalletFormView paramWalletFormView, String paramString)
  {
    AppMethodBeat.i(70845);
    if (!bt.isNullOrNil(paramString))
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
  
  private void eHu()
  {
    AppMethodBeat.i(70847);
    Object localObject;
    if (aUW())
    {
      f.eIT();
      this.CIo = new Authen();
      getInput().putBoolean("key_is_follow_bank_username", this.DdW.isChecked());
      if ((this.DeM != null) && (!bt.isNullOrNil(this.DeM.CUM)))
      {
        this.CIo.CFm = this.DeM.CUM;
        this.CIo.wBI = this.DeM.field_bindSerial;
        this.CIo.dkR = this.DeM.field_bankcardType;
        this.CIo.CTR = this.DeM.CTR;
        this.CIo.CTP = getInput().getString("key_pwd1");
        this.CIo.token = getInput().getString("kreq_token");
        com.tencent.mm.wallet_core.a.br(this);
        if (getNetController().s(new Object[] { this.CIo, this.ygb }))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
          AppMethodBeat.o(70847);
        }
      }
      else
      {
        localObject = getInput().getString("key_card_id");
        if (this.DdS.getVisibility() != 0) {
          break label615;
        }
        localObject = this.DdS.getText();
      }
    }
    label615:
    for (;;)
    {
      this.CIo.xnF = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.CIo.CTS = ((String)localObject);
      this.CIo.dkR = this.CQB.dkR;
      this.CIo.CTR = this.CMB;
      this.CIo.CTP = getInput().getString("key_pwd1");
      if (!bt.isNullOrNil(this.Ddw.getText())) {
        this.CIo.CTT = this.Ddw.getText();
      }
      this.CIo.CPf = this.Ddz.getText();
      this.CIo.CTW = this.DdJ.getText();
      this.CIo.CTX = this.DdK.getText();
      this.CIo.country = this.DdX;
      this.CIo.ePu = this.vgX;
      this.CIo.ePv = this.vgY;
      this.CIo.hWY = this.DdM.getText();
      this.CIo.uJH = this.DdN.getText();
      this.CIo.jrN = this.DdO.getText();
      this.CIo.ePn = this.DdP.getText();
      localObject = e.aYI(this.CIo.CPf);
      getInput().putString("key_mobile", (String)localObject);
      localObject = getInput();
      if (this.CQB.CPj == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
        this.CIo.CTQ = this.CMx.getText();
        this.CIo.CTa = this.DcA.getText();
        this.CIo.CTU = this.Ddv.getText();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.CIo.xnF + " elemt.bankcardTag : " + this.CQB.CPj);
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70847);
      return;
    }
  }
  
  private void eHy()
  {
    AppMethodBeat.i(70846);
    this.DdJ.setVisibility(8);
    this.DdK.setVisibility(8);
    this.DdL.setVisibility(8);
    this.DdM.setVisibility(8);
    this.DdN.setVisibility(8);
    this.DdO.setVisibility(8);
    this.DdP.setVisibility(8);
    AppMethodBeat.o(70846);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(70844);
    if (this.DeM != null)
    {
      findViewById(2131306716).setVisibility(0);
      Object localObject1;
      label94:
      Object localObject2;
      label138:
      Object localObject3;
      if (!bt.isNullOrNil(getInput().getString("key_bank_username")))
      {
        localObject1 = getInput().getString("key_recommand_desc");
        if (bt.isNullOrNil((String)localObject1))
        {
          this.DdW.setText(getString(2131765129, new Object[] { this.DeM.field_bankName }));
          this.DdW.setVisibility(0);
          eHy();
          if ((bt.isNullOrNil(this.DeM.field_bankcardTail)) || (!e(this.DdS, this.DeM.CUz))) {
            break label508;
          }
          localObject1 = this.DdS;
          localObject2 = this.DdS;
          if (!this.DeM.eET()) {
            break label524;
          }
          localObject3 = getString(2131765221);
          label156:
          if ((bt.isNullOrNil(this.DeM.field_bankName)) || (!e(this.Dej, this.DeM.field_bankName + " " + (String)localObject3))) {
            break label535;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Dej;
          }
          localObject3 = this.Dej;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (e(this.DcA, this.DeM.field_trueName))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.DcA;
          }
          localObject3 = this.DcA;
        }
        localObject2 = localObject1;
        if (e(this.Ddy, t.eFG().am(getContext(), this.DeM.CTR)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Ddy;
          }
          localObject3 = this.Ddy;
        }
        localObject1 = localObject2;
        if (e(this.CMx, this.DeM.CUy))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.CMx;
          }
          localObject3 = this.CMx;
        }
        localObject2 = localObject1;
        if (e(this.Ddz, this.DeM.field_mobile))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Ddz;
          }
          localObject3 = this.Ddz;
        }
        localObject1 = localObject2;
        if (e(this.Ddw, this.DeM.CTT))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.Ddw;
          }
          localObject3 = this.Ddw;
        }
        localObject2 = localObject1;
        if (e(this.Ddv, this.DeM.CUA))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Ddv;
          }
          localObject3 = this.Ddv;
        }
        ((WalletFormView)localObject2).setBackgroundResource(2131231818);
        ((WalletFormView)localObject3).setBackgroundResource(2131231818);
        if (!t.eFy().eGc()) {
          break label551;
        }
        this.fQh.setText(2131765141);
        AppMethodBeat.o(70844);
        return;
        this.DdW.setText((CharSequence)localObject1);
        break;
        this.DdW.setVisibility(8);
        break label94;
        label508:
        this.DdS.setVisibility(8);
        localObject2 = null;
        localObject1 = null;
        break label138;
        label524:
        localObject3 = getString(2131765241);
        break label156;
        label535:
        this.Dej.setVisibility(8);
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      label551:
      this.fQh.setText(2131765139);
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
    this.DdS = ((WalletFormView)findViewById(2131306708));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.DdS);
    this.Ddz = ((WalletFormView)findViewById(2131302346));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.Ddz);
    this.DcA = ((WalletFormView)findViewById(2131302662));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.DcA);
    this.Ddy = ((WalletFormView)findViewById(2131306730));
    this.CMx = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.CMx);
    this.Dej = ((WalletFormView)findViewById(2131306717));
    this.Ddw = ((WalletFormView)findViewById(2131298914));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.Ddw);
    this.Ddv = ((WalletFormView)findViewById(2131298929));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.Ddv);
    this.DeK = ((TextView)findViewById(2131306817));
    this.DdJ = ((WalletFormView)findViewById(2131300112));
    this.DdK = ((WalletFormView)findViewById(2131301314));
    this.DdL = ((WalletFormView)findViewById(2131296936));
    this.DdM = ((WalletFormView)findViewById(2131296479));
    this.DdN = ((WalletFormView)findViewById(2131303210));
    this.DdO = ((WalletFormView)findViewById(2131303363));
    this.DdP = ((WalletFormView)findViewById(2131299329));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.DdP);
    this.DeN = ((CheckBox)findViewById(2131296518));
    this.DdW = ((CheckBox)findViewById(2131296515));
    this.fQh = ((Button)findViewById(2131302852));
    this.DeL = ((MMScrollView)findViewById(2131306834));
    MMScrollView localMMScrollView = this.DeL;
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.DeL.setOnSizeChangeListener(new MMScrollView.b()
    {
      public final void uq(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70828);
        if (paramAnonymousBoolean) {}
        for (final int i = 8;; i = 0)
        {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : ".concat(String.valueOf(paramAnonymousBoolean)));
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
    this.DcA.setOnInputValidChangeListener(this);
    this.DdS.setOnInputValidChangeListener(this);
    this.Ddy.setOnInputValidChangeListener(this);
    this.CMx.setOnInputValidChangeListener(this);
    this.Ddz.setOnInputValidChangeListener(this);
    this.Ddw.setOnInputValidChangeListener(this);
    this.Ddv.setOnInputValidChangeListener(this);
    this.DdJ.setOnInputValidChangeListener(this);
    this.DdK.setOnInputValidChangeListener(this);
    this.DdL.setOnInputValidChangeListener(this);
    this.DdM.setOnInputValidChangeListener(this);
    this.DdN.setOnInputValidChangeListener(this);
    this.DdO.setOnInputValidChangeListener(this);
    this.DdP.setOnInputValidChangeListener(this);
    this.DcA.setOnEditorActionListener(this);
    this.DdS.setOnEditorActionListener(this);
    this.Ddy.setOnEditorActionListener(this);
    this.CMx.setOnEditorActionListener(this);
    this.Ddz.setOnEditorActionListener(this);
    this.Ddw.setOnEditorActionListener(this);
    this.Ddv.setOnEditorActionListener(this);
    this.DdJ.setOnEditorActionListener(this);
    this.DdK.setOnEditorActionListener(this);
    this.DdL.setOnEditorActionListener(this);
    this.DdM.setOnEditorActionListener(this);
    this.DdN.setOnEditorActionListener(this);
    this.DdO.setOnEditorActionListener(this);
    this.DdP.setOnEditorActionListener(this);
    this.Dej.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70829);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardImportUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putString("key_bank_type", WalletCardImportUI.c(WalletCardImportUI.this).dkR);
        paramAnonymousView.putInt("key_bankcard_type", WalletCardImportUI.c(WalletCardImportUI.this).CWo);
        com.tencent.mm.wallet_core.a.br(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70829);
      }
    });
    this.Ddy.setOnClickListener(new WalletCardImportUI.3(this));
    this.DeN.setChecked(true);
    this.DeN.setOnCheckedChangeListener(new WalletCardImportUI.4(this));
    this.DdW.setChecked(true);
    findViewById(2131296513).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70833);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = new LinkedList();
        localObject = new LinkedList();
        paramAnonymousView.add(WalletCardImportUI.this.getString(2131765084));
        ((List)localObject).add(Integer.valueOf(0));
        if ((WalletCardImportUI.c(WalletCardImportUI.this) != null) && (WalletCardImportUI.c(WalletCardImportUI.this).CWG))
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
              e.an(WalletCardImportUI.this.getContext(), localIntent);
              AppMethodBeat.o(70832);
              return;
              localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131764961, new Object[] { ac.fks() }));
              continue;
              if (WalletCardImportUI.c(WalletCardImportUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131764959, new Object[] { ac.fks(), WalletCardImportUI.c(WalletCardImportUI.this).dkR }));
              }
            }
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70833);
      }
    });
    this.DdL.setOnClickListener(new WalletCardImportUI.6(this));
    this.fQh.setOnClickListener(new WalletCardImportUI.7(this));
    updateView();
    aUW();
    AppMethodBeat.o(70843);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70849);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      aUW();
      AppMethodBeat.o(70849);
      return;
      this.CQB = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
      updateView();
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.DdX = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bt.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.vgX = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.vgY = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        this.DdL.setText(str1 + " " + str4);
      }
      for (;;)
      {
        if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.CQB.CWB)) {
          break label418;
        }
        this.DdO.setVisibility(0);
        break;
        if (!bt.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.vgY = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.DdL.setText(str1 + " " + str3);
        }
        else
        {
          this.vgY = this.DdX;
          this.DdL.setText(str1);
        }
      }
      label418:
      this.DdO.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70842);
    super.onCreate(paramBundle);
    setMMTitle(2131765247);
    this.CQB = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.ygb = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.DeM = ((Bankcard)getInput().getParcelable("key_import_bankcard"));
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    initView();
    this.DeL.pageScroll(33);
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
    localListView.setAdapter(this.DeO);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70836);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardImportUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        WalletCardImportUI.this.dismissDialog(1);
        paramAnonymousInt = ((Integer)WalletCardImportUI.c(WalletCardImportUI.this).eFi().get(paramAnonymousInt)).intValue();
        if (WalletCardImportUI.f(WalletCardImportUI.this) != paramAnonymousInt)
        {
          WalletCardImportUI.a(WalletCardImportUI.this, paramAnonymousInt);
          WalletCardImportUI.g(WalletCardImportUI.this).setText(((CheckedTextView)paramAnonymousView).getText().toString());
          WalletCardImportUI.b(WalletCardImportUI.h(WalletCardImportUI.this), WalletCardImportUI.f(WalletCardImportUI.this));
          WalletCardImportUI.h(WalletCardImportUI.this).dEe();
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.DdR == null) {
        eHu();
      }
      AppMethodBeat.o(70852);
      return false;
    }
    if (this.DdR != null) {
      if ((this.DdR.isEnabled()) && (!this.DdR.isClickable()) && (this.DdR.fSf())) {
        this.DdR.fSi();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70852);
      return true;
      this.DdR.performClick();
      continue;
      eHu();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70851);
    aUW();
    AppMethodBeat.o(70851);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(70848);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", " errCode: " + paramInt2 + " errMsg :" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = getInput();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mPayInfo);
      if ((paramn instanceof com.tencent.mm.plugin.wallet_core.c.ad))
      {
        paramString.putBoolean("intent_bind_end", true);
        com.tencent.mm.wallet_core.a.k(this, paramString);
        h.cl(this, getString(2131765037));
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