package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import java.util.LinkedList;
import java.util.List;

public class WalletRealNameVerifyUI
  extends WalletBaseUI
  implements View.OnClickListener, WalletFormView.a
{
  private String cityCode;
  private String countryCode;
  private Button iwY;
  private Profession[] mProfessions;
  private String provinceCode;
  private TextView sJS;
  private WalletFormView zXM;
  private WalletFormView zXN;
  private WalletFormView zXO;
  private WalletFormView zXP;
  private CheckBox zXQ;
  private TextView zXR;
  private ElementQuery zXS;
  private Profession zXT;
  private boolean zXU = false;
  private boolean zXV = false;
  
  private void p(n paramn)
  {
    AppMethodBeat.i(70061);
    com.tencent.mm.wallet_core.d locald = getProcess();
    Bundle localBundle = null;
    if (locald != null) {
      localBundle = locald.dow;
    }
    paramn = ((g)paramn).token;
    ad.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
    if (locald != null)
    {
      localBundle.putString("key_real_name_token", paramn);
      localBundle.putString("key_country_code", this.countryCode);
      localBundle.putString("key_province_code", this.provinceCode);
      localBundle.putString("key_city_code", this.cityCode);
      localBundle.putParcelable("key_profession", this.zXT);
      locald.a(this, 0, localBundle);
    }
    AppMethodBeat.o(70061);
  }
  
  public int getLayoutId()
  {
    return 2131496017;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70059);
    setMMTitle(2131765762);
    this.iwY = ((Button)findViewById(2131302852));
    this.zXM = ((WalletFormView)findViewById(2131302662));
    this.zXN = ((WalletFormView)findViewById(2131297866));
    this.zXO = ((WalletFormView)findViewById(2131303415));
    this.zXP = ((WalletFormView)findViewById(2131303412));
    this.zXR = ((TextView)findViewById(2131301034));
    this.zXM.setOnInputValidChangeListener(this);
    this.zXN.setOnInputValidChangeListener(this);
    this.zXO.setOnInputValidChangeListener(this);
    this.zXP.setOnInputValidChangeListener(this);
    this.zXM.setFocusable(true);
    this.zXM.getInfoIv().setVisibility(8);
    com.tencent.mm.wallet_core.ui.formview.a.d(this.zXN);
    b localb = this.zXN.getLogicDelegate();
    if ((localb instanceof a.a)) {
      ((a.a)localb).abz(1);
    }
    this.zXO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70048);
        paramAnonymousView = new Intent(WalletRealNameVerifyUI.this.getContext(), WalletSelectProfessionUI.class);
        paramAnonymousView.putExtra("key_profession_list", WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this));
        WalletRealNameVerifyUI.this.startActivityForResult(paramAnonymousView, 1);
        AppMethodBeat.o(70048);
      }
    });
    this.zXP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70049);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        paramAnonymousView.putExtra("IsRealNameVerifyScene", true);
        paramAnonymousView.putExtra("IsNeedShowSearchBar", true);
        com.tencent.mm.bs.d.c(WalletRealNameVerifyUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", paramAnonymousView, 2);
        AppMethodBeat.o(70049);
      }
    });
    this.iwY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70050);
        paramAnonymousView = WalletRealNameVerifyUI.b(WalletRealNameVerifyUI.this).getText();
        String str = WalletRealNameVerifyUI.c(WalletRealNameVerifyUI.this).getText();
        WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this, paramAnonymousView, str);
        AppMethodBeat.o(70050);
      }
    });
    setEditFocusListener(this.zXN, 1, false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(70051);
        paramAnonymousMenuItem = (a)WalletRealNameVerifyUI.this.getProcess();
        if (paramAnonymousMenuItem != null) {
          paramAnonymousMenuItem.g(WalletRealNameVerifyUI.this, 0);
        }
        WalletRealNameVerifyUI.this.finish();
        AppMethodBeat.o(70051);
        return true;
      }
    });
    this.zXQ = ((CheckBox)findViewById(2131296518));
    this.sJS = ((TextView)findViewById(2131296516));
    this.zXQ.setChecked(true);
    this.zXQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(70052);
        if (paramAnonymousBoolean)
        {
          WalletRealNameVerifyUI.d(WalletRealNameVerifyUI.this).setEnabled(true);
          WalletRealNameVerifyUI.d(WalletRealNameVerifyUI.this).setClickable(true);
          AppMethodBeat.o(70052);
          return;
        }
        WalletRealNameVerifyUI.d(WalletRealNameVerifyUI.this).setEnabled(false);
        WalletRealNameVerifyUI.d(WalletRealNameVerifyUI.this).setClickable(false);
        AppMethodBeat.o(70052);
      }
    });
    this.sJS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70054);
        paramAnonymousView = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        paramAnonymousView.add(WalletRealNameVerifyUI.this.getString(2131765084));
        localLinkedList.add(Integer.valueOf(0));
        if ((WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this) != null) && (WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this).AdW))
        {
          paramAnonymousView.add(WalletRealNameVerifyUI.this.getString(2131765082));
          localLinkedList.add(Integer.valueOf(1));
        }
        h.a(WalletRealNameVerifyUI.this, "", paramAnonymousView, localLinkedList, "", new h.d()
        {
          public final void cv(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(70053);
            Intent localIntent = new Intent();
            switch (paramAnonymous2Int1)
            {
            }
            for (;;)
            {
              localIntent.putExtra("showShare", false);
              localIntent.putExtra("allow_mix_content_mode", false);
              e.X(WalletRealNameVerifyUI.this.getContext(), localIntent);
              AppMethodBeat.o(70053);
              return;
              localIntent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(2131764961, new Object[] { ac.eFu() }));
              continue;
              if (WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(2131764959, new Object[] { ac.eFu(), WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this).dca }));
              }
            }
          }
        });
        AppMethodBeat.o(70054);
      }
    });
    AppMethodBeat.o(70059);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(70063);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.zXT = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
        this.zXO.setText(this.zXT.Aap);
        AppMethodBeat.o(70063);
        return;
      }
      ad.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
      AppMethodBeat.o(70063);
      return;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("CountryName");
        String str2 = paramIntent.getStringExtra("ProviceName");
        String str3 = paramIntent.getStringExtra("CityName");
        this.countryCode = paramIntent.getStringExtra("Country");
        this.provinceCode = paramIntent.getStringExtra("Contact_Province");
        this.cityCode = paramIntent.getStringExtra("Contact_City");
        paramIntent = new StringBuilder();
        if (!bt.isNullOrNil(str1)) {
          paramIntent.append(str1);
        }
        if (!bt.isNullOrNil(str2)) {
          paramIntent.append(" ").append(str2);
        }
        if (!bt.isNullOrNil(str3)) {
          paramIntent.append(" ").append(str3);
        }
        this.zXP.setText(paramIntent.toString());
        AppMethodBeat.o(70063);
        return;
      }
      ad.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
    }
    AppMethodBeat.o(70063);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(70062);
    AppMethodBeat.o(70062);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70057);
    super.onCreate(paramBundle);
    this.mNetSceneMgr.addSceneEndListener(1616);
    this.zXS = ((ElementQuery)getInput().getParcelable("elemt_query"));
    initView();
    doSceneForceProgress(new l());
    AppMethodBeat.o(70057);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(70058);
    this.mNetSceneMgr.removeSceneEndListener(1616);
    super.onDestroy();
    AppMethodBeat.o(70058);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(70064);
    ad.d("MicroMsg.WalletRealNameVerifyUI", "check info");
    String str1 = this.zXM.getText();
    String str2 = this.zXN.getText();
    int i;
    if (bt.isNullOrNil(str1)) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        this.iwY.setEnabled(false);
        this.iwY.setClickable(false);
        AppMethodBeat.o(70064);
        return;
        if (bt.isNullOrNil(str2))
        {
          i = 0;
          continue;
        }
        if (this.zXU)
        {
          if ((!bt.isNullOrNil(this.countryCode)) || (!bt.isNullOrNil(this.provinceCode)) || (!bt.isNullOrNil(this.cityCode))) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label133;
            }
            i = 0;
            break;
          }
        }
        label133:
        if ((this.zXV) && (this.zXT == null)) {
          i = 0;
        }
      }
      else
      {
        this.iwY.setEnabled(true);
        this.iwY.setClickable(true);
        AppMethodBeat.o(70064);
        return;
      }
      i = 1;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    boolean bool2 = false;
    AppMethodBeat.i(70060);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof g))
      {
        paramString = (g)paramn;
        if (paramString.zVS == null) {
          p(paramn);
        }
        for (;;)
        {
          AppMethodBeat.o(70060);
          return true;
          ad.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify show juveniles dialog");
          h.d(this, paramString.zVS.doh, "", paramString.zVS.Ahr, paramString.zVS.Ahq, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70055);
              ad.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify dialog lOk");
              WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this, paramn);
              t.sw(1);
              AppMethodBeat.o(70055);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70056);
              ad.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify dialog lCancel");
              t.sw(0);
              AppMethodBeat.o(70056);
            }
          });
        }
      }
      if ((paramn instanceof l))
      {
        paramString = (l)paramn;
        if (paramString.zWB == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.zXU = bool1;
          bool1 = bool2;
          if (paramString.zWC == 1) {
            bool1 = true;
          }
          this.zXV = bool1;
          if (!this.zXV) {
            this.zXO.setVisibility(8);
          }
          if (!this.zXU) {
            this.zXP.setVisibility(8);
          }
          if ((this.zXU) || (this.zXV)) {
            this.zXR.setText(2131765757);
          }
          this.mProfessions = paramString.Aan;
          AppMethodBeat.o(70060);
          return true;
        }
      }
    }
    else
    {
      ad.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
    }
    AppMethodBeat.o(70060);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI
 * JD-Core Version:    0.7.0.1
 */