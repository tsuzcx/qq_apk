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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.w;
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
  private static final String[] AlW = { "ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT" };
  private WalletFormView AjM;
  private WalletFormView AkH;
  private WalletFormView AkI;
  private WalletFormView AkK;
  private WalletFormView AkL;
  private WalletFormView AkV;
  private WalletFormView AkW;
  private WalletFormView AkX;
  private WalletFormView AkY;
  private WalletFormView AkZ;
  private TextView AlX;
  private MMScrollView AlY;
  private Bankcard AlZ;
  private WalletFormView Ala;
  private WalletFormView Alb;
  private WalletFormView Ald;
  private WalletFormView Ale;
  private CheckBox Ali;
  private String Alj;
  private WalletFormView Alw;
  private CheckBox Ama;
  private BaseAdapter Amb;
  private Button ftn;
  private Dialog mDialog;
  private ap mHandler;
  private PayInfo mPayInfo;
  private String sWb;
  private String sWc;
  private Orders vIq;
  private Authen zPG;
  private WalletFormView zTO;
  private int zTS;
  private ElementQuery zXS;
  
  public WalletCardImportUI()
  {
    AppMethodBeat.i(70841);
    this.mDialog = null;
    this.Ald = null;
    this.mHandler = new ap();
    this.zXS = new ElementQuery();
    this.zPG = new Authen();
    this.vIq = null;
    this.mPayInfo = null;
    this.AlZ = null;
    this.zTS = 1;
    this.Amb = new BaseAdapter()
    {
      private Integer py(int paramAnonymousInt)
      {
        AppMethodBeat.i(70838);
        Integer localInteger = (Integer)WalletCardImportUI.c(WalletCardImportUI.this).ebM().get(paramAnonymousInt);
        AppMethodBeat.o(70838);
        return localInteger;
      }
      
      public final int getCount()
      {
        AppMethodBeat.i(70837);
        if (WalletCardImportUI.c(WalletCardImportUI.this).ebM() != null)
        {
          int i = WalletCardImportUI.c(WalletCardImportUI.this).ebM().size();
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
        paramAnonymousView.setText(s.eck().ad(WalletCardImportUI.this, py(paramAnonymousInt).intValue()));
        if (WalletCardImportUI.f(WalletCardImportUI.this) == py(paramAnonymousInt).intValue()) {
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
  
  private boolean aKT()
  {
    AppMethodBeat.i(70850);
    if (!this.Ama.isChecked()) {}
    for (boolean bool = false;; bool = true)
    {
      if (bool)
      {
        this.ftn.setEnabled(true);
        this.ftn.setClickable(true);
      }
      for (;;)
      {
        AppMethodBeat.o(70850);
        return bool;
        this.ftn.setEnabled(false);
        this.ftn.setClickable(false);
      }
    }
  }
  
  private void cE()
  {
    AppMethodBeat.i(70844);
    if (this.AlZ != null)
    {
      findViewById(2131306716).setVisibility(0);
      Object localObject1;
      label89:
      Object localObject2;
      label133:
      Object localObject3;
      if (!bt.isNullOrNil(getInput().getString("key_bank_username")))
      {
        localObject1 = getInput().getString("key_recommand_desc");
        if (bt.isNullOrNil((String)localObject1))
        {
          this.Ali.setText(getString(2131765129, new Object[] { this.AlZ.field_bankName }));
          this.Ali.setVisibility(0);
          edX();
          if ((bt.isNullOrNil(this.AlZ.field_bankcardTail)) || (!e(this.Ale, this.AlZ.AbQ))) {
            break label501;
          }
          localObject1 = this.Ale;
          localObject2 = this.Ale;
          if (!this.AlZ.ebx()) {
            break label517;
          }
          localObject3 = getString(2131765221);
          label150:
          if ((bt.isNullOrNil(this.AlZ.field_bankName)) || (!e(this.Alw, this.AlZ.field_bankName + " " + (String)localObject3))) {
            break label528;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.Alw;
          }
          localObject3 = this.Alw;
        }
      }
      for (;;)
      {
        localObject1 = localObject2;
        if (e(this.AjM, this.AlZ.field_trueName))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.AjM;
          }
          localObject3 = this.AjM;
        }
        localObject2 = localObject1;
        if (e(this.AkK, s.eck().ad(getContext(), this.AlZ.Abi)))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.AkK;
          }
          localObject3 = this.AkK;
        }
        localObject1 = localObject2;
        if (e(this.zTO, this.AlZ.AbP))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.zTO;
          }
          localObject3 = this.zTO;
        }
        localObject2 = localObject1;
        if (e(this.AkL, this.AlZ.field_mobile))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.AkL;
          }
          localObject3 = this.AkL;
        }
        localObject1 = localObject2;
        if (e(this.AkI, this.AlZ.Abk))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = this.AkI;
          }
          localObject3 = this.AkI;
        }
        localObject2 = localObject1;
        if (e(this.AkH, this.AlZ.AbR))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = this.AkH;
          }
          localObject3 = this.AkH;
        }
        ((WalletFormView)localObject2).setBackgroundResource(2131231818);
        ((WalletFormView)localObject3).setBackgroundResource(2131231818);
        if (!s.ecc().ecH()) {
          break label544;
        }
        this.ftn.setText(2131765141);
        AppMethodBeat.o(70844);
        return;
        this.Ali.setText((CharSequence)localObject1);
        break;
        this.Ali.setVisibility(8);
        break label89;
        label501:
        this.Ale.setVisibility(8);
        localObject2 = null;
        localObject1 = null;
        break label133;
        label517:
        localObject3 = getString(2131765241);
        break label150;
        label528:
        this.Alw.setVisibility(8);
        localObject3 = localObject2;
        localObject2 = localObject1;
      }
      label544:
      this.ftn.setText(2131765139);
      AppMethodBeat.o(70844);
      return;
    }
    AppMethodBeat.o(70844);
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
  
  private void edT()
  {
    AppMethodBeat.i(70847);
    Object localObject;
    if (aKT())
    {
      f.eft();
      this.zPG = new Authen();
      getInput().putBoolean("key_is_follow_bank_username", this.Ali.isChecked());
      if ((this.AlZ != null) && (!bt.isNullOrNil(this.AlZ.Acd)))
      {
        this.zPG.zMD = this.AlZ.Acd;
        this.zPG.uns = this.AlZ.field_bindSerial;
        this.zPG.dca = this.AlZ.field_bankcardType;
        this.zPG.Abi = this.AlZ.Abi;
        this.zPG.Abg = getInput().getString("key_pwd1");
        this.zPG.token = getInput().getString("kreq_token");
        com.tencent.mm.wallet_core.a.bo(this);
        if (getNetController().q(new Object[] { this.zPG, this.vIq }))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
          AppMethodBeat.o(70847);
        }
      }
      else
      {
        localObject = getInput().getString("key_card_id");
        if (this.Ale.getVisibility() != 0) {
          break label619;
        }
        localObject = this.Ale.getText();
      }
    }
    label619:
    for (;;)
    {
      this.zPG.uXi = ((PayInfo)getInput().getParcelable("key_pay_info"));
      this.zPG.Abj = ((String)localObject);
      this.zPG.dca = this.zXS.dca;
      this.zPG.Abi = this.zTS;
      this.zPG.Abg = getInput().getString("key_pwd1");
      if (!bt.isNullOrNil(this.AkI.getText())) {
        this.zPG.Abk = this.AkI.getText();
      }
      this.zPG.zWw = this.AkL.getText();
      this.zPG.Abn = this.AkV.getText();
      this.zPG.Abo = this.AkW.getText();
      this.zPG.country = this.Alj;
      this.zPG.evz = this.sWb;
      this.zPG.evA = this.sWc;
      this.zPG.hdQ = this.AkY.getText();
      this.zPG.szk = this.AkZ.getText();
      this.zPG.iyB = this.Ala.getText();
      this.zPG.evs = this.Alb.getText();
      localObject = e.aNg(this.zPG.zWw);
      getInput().putString("key_mobile", (String)localObject);
      localObject = getInput();
      if (this.zXS.zWA == 2) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject).putBoolean("key_is_oversea", bool);
        this.zPG.Abh = this.zTO.getText();
        this.zPG.Aar = this.AjM.getText();
        this.zPG.Abl = this.AkH.getText();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.zPG.uXi + " elemt.bankcardTag : " + this.zXS.zWA);
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
      AppMethodBeat.o(70847);
      return;
    }
  }
  
  private void edX()
  {
    AppMethodBeat.i(70846);
    this.AkV.setVisibility(8);
    this.AkW.setVisibility(8);
    this.AkX.setVisibility(8);
    this.AkY.setVisibility(8);
    this.AkZ.setVisibility(8);
    this.Ala.setVisibility(8);
    this.Alb.setVisibility(8);
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
    this.Ale = ((WalletFormView)findViewById(2131306708));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.Ale);
    this.AkL = ((WalletFormView)findViewById(2131302346));
    com.tencent.mm.wallet_core.ui.formview.a.c(this, this.AkL);
    this.AjM = ((WalletFormView)findViewById(2131302662));
    com.tencent.mm.wallet_core.ui.formview.a.e(this, this.AjM);
    this.AkK = ((WalletFormView)findViewById(2131306730));
    this.zTO = ((WalletFormView)findViewById(2131300910));
    com.tencent.mm.wallet_core.ui.formview.a.d(this.zTO);
    this.Alw = ((WalletFormView)findViewById(2131306717));
    this.AkI = ((WalletFormView)findViewById(2131298914));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.AkI);
    this.AkH = ((WalletFormView)findViewById(2131298929));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.AkH);
    this.AlX = ((TextView)findViewById(2131306817));
    this.AkV = ((WalletFormView)findViewById(2131300112));
    this.AkW = ((WalletFormView)findViewById(2131301314));
    this.AkX = ((WalletFormView)findViewById(2131296936));
    this.AkY = ((WalletFormView)findViewById(2131296479));
    this.AkZ = ((WalletFormView)findViewById(2131303210));
    this.Ala = ((WalletFormView)findViewById(2131303363));
    this.Alb = ((WalletFormView)findViewById(2131299329));
    com.tencent.mm.wallet_core.ui.formview.a.e(this.Alb);
    this.Ama = ((CheckBox)findViewById(2131296518));
    this.Ali = ((CheckBox)findViewById(2131296515));
    this.ftn = ((Button)findViewById(2131302852));
    this.AlY = ((MMScrollView)findViewById(2131306834));
    MMScrollView localMMScrollView = this.AlY;
    localMMScrollView.a(localMMScrollView, localMMScrollView);
    this.AlY.setOnSizeChangeListener(new MMScrollView.b()
    {
      public final void sF(boolean paramAnonymousBoolean)
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
    this.AjM.setOnInputValidChangeListener(this);
    this.Ale.setOnInputValidChangeListener(this);
    this.AkK.setOnInputValidChangeListener(this);
    this.zTO.setOnInputValidChangeListener(this);
    this.AkL.setOnInputValidChangeListener(this);
    this.AkI.setOnInputValidChangeListener(this);
    this.AkH.setOnInputValidChangeListener(this);
    this.AkV.setOnInputValidChangeListener(this);
    this.AkW.setOnInputValidChangeListener(this);
    this.AkX.setOnInputValidChangeListener(this);
    this.AkY.setOnInputValidChangeListener(this);
    this.AkZ.setOnInputValidChangeListener(this);
    this.Ala.setOnInputValidChangeListener(this);
    this.Alb.setOnInputValidChangeListener(this);
    this.AjM.setOnEditorActionListener(this);
    this.Ale.setOnEditorActionListener(this);
    this.AkK.setOnEditorActionListener(this);
    this.zTO.setOnEditorActionListener(this);
    this.AkL.setOnEditorActionListener(this);
    this.AkI.setOnEditorActionListener(this);
    this.AkH.setOnEditorActionListener(this);
    this.AkV.setOnEditorActionListener(this);
    this.AkW.setOnEditorActionListener(this);
    this.AkX.setOnEditorActionListener(this);
    this.AkY.setOnEditorActionListener(this);
    this.AkZ.setOnEditorActionListener(this);
    this.Ala.setOnEditorActionListener(this);
    this.Alb.setOnEditorActionListener(this);
    this.Alw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70829);
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("key_support_bankcard", WalletCardImportUI.this.getInput().getInt("key_support_bankcard", 3));
        paramAnonymousView.putString("key_bank_type", WalletCardImportUI.c(WalletCardImportUI.this).dca);
        paramAnonymousView.putInt("key_bankcard_type", WalletCardImportUI.c(WalletCardImportUI.this).AdE);
        com.tencent.mm.wallet_core.a.bo(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, paramAnonymousView, 1);
        AppMethodBeat.o(70829);
      }
    });
    this.AkK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70830);
        WalletCardImportUI.this.showDialog(1);
        AppMethodBeat.o(70830);
      }
    });
    this.Ama.setChecked(true);
    this.Ama.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70831);
        WalletCardImportUI.d(WalletCardImportUI.this);
        AppMethodBeat.o(70831);
      }
    });
    this.Ali.setChecked(true);
    findViewById(2131296513).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70833);
        paramAnonymousView = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        paramAnonymousView.add(WalletCardImportUI.this.getString(2131765084));
        localLinkedList.add(Integer.valueOf(0));
        if ((WalletCardImportUI.c(WalletCardImportUI.this) != null) && (WalletCardImportUI.c(WalletCardImportUI.this).AdW))
        {
          paramAnonymousView.add(WalletCardImportUI.this.getString(2131765082));
          localLinkedList.add(Integer.valueOf(1));
        }
        h.a(WalletCardImportUI.this, "", paramAnonymousView, localLinkedList, "", new h.d()
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
              e.X(WalletCardImportUI.this.getContext(), localIntent);
              AppMethodBeat.o(70832);
              return;
              localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131764961, new Object[] { ac.eFu() }));
              continue;
              if (WalletCardImportUI.c(WalletCardImportUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletCardImportUI.this.getString(2131764959, new Object[] { ac.eFu(), WalletCardImportUI.c(WalletCardImportUI.this).dca }));
              }
            }
          }
        });
        AppMethodBeat.o(70833);
      }
    });
    this.AkX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70834);
        WalletCardImportUI.this.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
        AppMethodBeat.o(70834);
      }
    });
    this.ftn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70835);
        WalletCardImportUI.e(WalletCardImportUI.this);
        AppMethodBeat.o(70835);
      }
    });
    cE();
    aKT();
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
      aKT();
      AppMethodBeat.o(70849);
      return;
      this.zXS = ((ElementQuery)paramIntent.getParcelableExtra("elemt_query"));
      cE();
      continue;
      String str1 = paramIntent.getStringExtra("CountryName");
      String str2 = paramIntent.getStringExtra("Country");
      this.Alj = (str1 + "|" + str2);
      String str3 = paramIntent.getStringExtra("ProviceName");
      String str4 = paramIntent.getStringExtra("CityName");
      if (!bt.isNullOrNil(paramIntent.getStringExtra("Contact_City")))
      {
        this.sWb = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
        this.sWc = (str4 + "|" + paramIntent.getStringExtra("Contact_City"));
        this.AkX.setText(str1 + " " + str4);
      }
      for (;;)
      {
        if ((!"US".equals(str2)) && (!"CA".equals(str2)) && (!this.zXS.AdR)) {
          break label418;
        }
        this.Ala.setVisibility(0);
        break;
        if (!bt.isNullOrNil(paramIntent.getStringExtra("Contact_Province")))
        {
          this.sWc = (str3 + "|" + paramIntent.getStringExtra("Contact_Province"));
          this.AkX.setText(str1 + " " + str3);
        }
        else
        {
          this.sWc = this.Alj;
          this.AkX.setText(str1);
        }
      }
      label418:
      this.Ala.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70842);
    super.onCreate(paramBundle);
    setMMTitle(2131765247);
    this.zXS = ((ElementQuery)getInput().getParcelable("elemt_query"));
    this.vIq = ((Orders)getInput().getParcelable("key_orders"));
    this.mPayInfo = ((PayInfo)getInput().getParcelable("key_pay_info"));
    this.AlZ = ((Bankcard)getInput().getParcelable("key_import_bankcard"));
    if (this.mPayInfo == null) {
      this.mPayInfo = new PayInfo();
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mPayInfo);
    initView();
    this.AlY.pageScroll(33);
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
    localListView.setAdapter(this.Amb);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70836);
        WalletCardImportUI.this.dismissDialog(1);
        paramAnonymousInt = ((Integer)WalletCardImportUI.c(WalletCardImportUI.this).ebM().get(paramAnonymousInt)).intValue();
        if (WalletCardImportUI.f(WalletCardImportUI.this) != paramAnonymousInt)
        {
          WalletCardImportUI.a(WalletCardImportUI.this, paramAnonymousInt);
          WalletCardImportUI.g(WalletCardImportUI.this).setText(((CheckedTextView)paramAnonymousView).getText().toString());
          WalletCardImportUI.b(WalletCardImportUI.h(WalletCardImportUI.this), WalletCardImportUI.f(WalletCardImportUI.this));
          WalletCardImportUI.h(WalletCardImportUI.this).dga();
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      if (this.Ald == null) {
        edT();
      }
      AppMethodBeat.o(70852);
      return false;
    }
    if (this.Ald != null) {
      if ((this.Ald.isEnabled()) && (!this.Ald.isClickable()) && (this.Ald.fkF())) {
        this.Ald.fkI();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(70852);
      return true;
      this.Ald.performClick();
      continue;
      edT();
    }
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70851);
    aKT();
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
        h.cf(this, getString(2131765037));
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