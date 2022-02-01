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
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import java.util.LinkedList;
import java.util.List;

public class WalletRealNameVerifyUI
  extends WalletBaseUI
  implements View.OnClickListener, WalletFormView.a
{
  private WalletFormView DhZ;
  private WalletFormView Dia;
  private WalletFormView Dib;
  private WalletFormView Dic;
  private CheckBox Did;
  private TextView Die;
  private ElementQuery Dif;
  private Profession Dig;
  private boolean Dih = false;
  private boolean Dii = false;
  private String cityCode;
  private String countryCode;
  private Button jtd;
  private Profession[] mProfessions;
  private String provinceCode;
  private TextView vfY;
  
  private void o(n paramn)
  {
    AppMethodBeat.i(70061);
    com.tencent.mm.wallet_core.d locald = getProcess();
    Bundle localBundle = null;
    if (locald != null) {
      localBundle = locald.dyY;
    }
    paramn = ((g)paramn).token;
    ae.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
    if (locald != null)
    {
      localBundle.putString("key_real_name_token", paramn);
      localBundle.putString("key_country_code", this.countryCode);
      localBundle.putString("key_province_code", this.provinceCode);
      localBundle.putString("key_city_code", this.cityCode);
      localBundle.putParcelable("key_profession", this.Dig);
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
    this.jtd = ((Button)findViewById(2131302852));
    this.DhZ = ((WalletFormView)findViewById(2131302662));
    this.Dia = ((WalletFormView)findViewById(2131297866));
    this.Dib = ((WalletFormView)findViewById(2131303415));
    this.Dic = ((WalletFormView)findViewById(2131303412));
    this.Die = ((TextView)findViewById(2131301034));
    this.DhZ.setOnInputValidChangeListener(this);
    this.Dia.setOnInputValidChangeListener(this);
    this.Dib.setOnInputValidChangeListener(this);
    this.Dic.setOnInputValidChangeListener(this);
    this.DhZ.setFocusable(true);
    this.DhZ.getInfoIv().setVisibility(8);
    com.tencent.mm.wallet_core.ui.formview.a.d(this.Dia);
    com.tencent.mm.wallet_core.ui.formview.a.b localb = this.Dia.getLogicDelegate();
    if ((localb instanceof a.a)) {
      ((a.a)localb).ahb(1);
    }
    this.Dib.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent(WalletRealNameVerifyUI.this.getContext(), WalletSelectProfessionUI.class);
        paramAnonymousView.putExtra("key_profession_list", WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this));
        WalletRealNameVerifyUI.this.startActivityForResult(paramAnonymousView, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70048);
      }
    });
    this.Dic.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70049);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        paramAnonymousView.putExtra("IsRealNameVerifyScene", true);
        paramAnonymousView.putExtra("IsNeedShowSearchBar", true);
        com.tencent.mm.br.d.c(WalletRealNameVerifyUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", paramAnonymousView, 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70049);
      }
    });
    this.jtd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70050);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = WalletRealNameVerifyUI.b(WalletRealNameVerifyUI.this).getText();
        localObject = WalletRealNameVerifyUI.c(WalletRealNameVerifyUI.this).getText();
        WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this, paramAnonymousView, (String)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70050);
      }
    });
    setEditFocusListener(this.Dia, 1, false);
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
    this.Did = ((CheckBox)findViewById(2131296518));
    this.vfY = ((TextView)findViewById(2131296516));
    this.Did.setChecked(true);
    this.Did.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
    this.vfY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70054);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = new LinkedList();
        localObject = new LinkedList();
        paramAnonymousView.add(WalletRealNameVerifyUI.this.getString(2131765084));
        ((List)localObject).add(Integer.valueOf(0));
        if ((WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this) != null) && (WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this).Dol))
        {
          paramAnonymousView.add(WalletRealNameVerifyUI.this.getString(2131765082));
          ((List)localObject).add(Integer.valueOf(1));
        }
        h.a(WalletRealNameVerifyUI.this, "", paramAnonymousView, (List)localObject, "", new h.d()
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
              f.an(WalletRealNameVerifyUI.this.getContext(), localIntent);
              AppMethodBeat.o(70053);
              return;
              localIntent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(2131764961, new Object[] { ad.fom() }));
              continue;
              if (WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(2131764959, new Object[] { ad.fom(), WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this).dlT }));
              }
            }
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        this.Dig = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
        this.Dib.setText(this.Dig.DkE);
        AppMethodBeat.o(70063);
        return;
      }
      ae.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
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
        if (!bu.isNullOrNil(str1)) {
          paramIntent.append(str1);
        }
        if (!bu.isNullOrNil(str2)) {
          paramIntent.append(" ").append(str2);
        }
        if (!bu.isNullOrNil(str3)) {
          paramIntent.append(" ").append(str3);
        }
        this.Dic.setText(paramIntent.toString());
        AppMethodBeat.o(70063);
        return;
      }
      ae.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
    }
    AppMethodBeat.o(70063);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(70062);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70062);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70057);
    super.onCreate(paramBundle);
    this.mNetSceneMgr.addSceneEndListener(1616);
    this.Dif = ((ElementQuery)getInput().getParcelable("elemt_query"));
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
    ae.d("MicroMsg.WalletRealNameVerifyUI", "check info");
    String str1 = this.DhZ.getText();
    String str2 = this.Dia.getText();
    int i;
    if (bu.isNullOrNil(str1)) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        this.jtd.setEnabled(false);
        this.jtd.setClickable(false);
        AppMethodBeat.o(70064);
        return;
        if (bu.isNullOrNil(str2))
        {
          i = 0;
          continue;
        }
        if (this.Dih)
        {
          if ((!bu.isNullOrNil(this.countryCode)) || (!bu.isNullOrNil(this.provinceCode)) || (!bu.isNullOrNil(this.cityCode))) {}
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
        if ((this.Dii) && (this.Dig == null)) {
          i = 0;
        }
      }
      else
      {
        this.jtd.setEnabled(true);
        this.jtd.setClickable(true);
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
        if (paramString.Dgg == null) {
          o(paramn);
        }
        for (;;)
        {
          AppMethodBeat.o(70060);
          return true;
          ae.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify show juveniles dialog");
          h.e(this, paramString.Dgg.dyI, "", paramString.Dgg.DrJ, paramString.Dgg.DrI, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70055);
              ae.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify dialog lOk");
              WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this, paramn);
              u.tW(1);
              AppMethodBeat.o(70055);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70056);
              ae.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify dialog lCancel");
              u.tW(0);
              AppMethodBeat.o(70056);
            }
          });
        }
      }
      if ((paramn instanceof l))
      {
        paramString = (l)paramn;
        if (paramString.DgO == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.Dih = bool1;
          bool1 = bool2;
          if (paramString.DgP == 1) {
            bool1 = true;
          }
          this.Dii = bool1;
          if (!this.Dii) {
            this.Dib.setVisibility(8);
          }
          if (!this.Dih) {
            this.Dic.setVisibility(8);
          }
          if ((this.Dih) || (this.Dii)) {
            this.Die.setText(2131765757);
          }
          this.mProfessions = paramString.DkC;
          AppMethodBeat.o(70060);
          return true;
        }
      }
    }
    else
    {
      ae.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI
 * JD-Core Version:    0.7.0.1
 */