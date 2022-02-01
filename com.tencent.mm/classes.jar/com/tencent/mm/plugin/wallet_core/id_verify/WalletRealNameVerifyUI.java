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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.l;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.wallet_core.d;
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
  private boolean HRA = false;
  private boolean HRB = false;
  private WalletFormView HRs;
  private WalletFormView HRt;
  private WalletFormView HRu;
  private WalletFormView HRv;
  private CheckBox HRw;
  private TextView HRx;
  private ElementQuery HRy;
  private Profession HRz;
  private String cityCode;
  private String countryCode;
  private Button krs;
  private Profession[] mProfessions;
  private String provinceCode;
  private TextView yyx;
  
  private void q(q paramq)
  {
    AppMethodBeat.i(70061);
    d locald = getProcess();
    Bundle localBundle = null;
    if (locald != null) {
      localBundle = locald.dQL;
    }
    paramq = ((g)paramq).token;
    Log.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
    if (locald != null)
    {
      localBundle.putString("key_real_name_token", paramq);
      localBundle.putString("key_country_code", this.countryCode);
      localBundle.putString("key_province_code", this.provinceCode);
      localBundle.putString("key_city_code", this.cityCode);
      localBundle.putParcelable("key_profession", this.HRz);
      locald.a(this, 0, localBundle);
    }
    AppMethodBeat.o(70061);
  }
  
  public int getLayoutId()
  {
    return 2131496997;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70059);
    setMMTitle(2131768215);
    this.krs = ((Button)findViewById(2131305423));
    this.HRs = ((WalletFormView)findViewById(2131305216));
    this.HRt = ((WalletFormView)findViewById(2131298182));
    this.HRu = ((WalletFormView)findViewById(2131306143));
    this.HRv = ((WalletFormView)findViewById(2131306135));
    this.HRx = ((TextView)findViewById(2131302684));
    this.HRs.setOnInputValidChangeListener(this);
    this.HRt.setOnInputValidChangeListener(this);
    this.HRu.setOnInputValidChangeListener(this);
    this.HRv.setOnInputValidChangeListener(this);
    this.HRs.setFocusable(true);
    this.HRs.getInfoIv().setVisibility(8);
    com.tencent.mm.wallet_core.ui.formview.a.d(this.HRt);
    com.tencent.mm.wallet_core.ui.formview.a.b localb = this.HRt.getLogicDelegate();
    if ((localb instanceof a.a)) {
      ((a.a)localb).aqn(1);
    }
    this.HRu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70048);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent(WalletRealNameVerifyUI.this.getContext(), WalletSelectProfessionUI.class);
        paramAnonymousView.putExtra("key_profession_list", WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this));
        WalletRealNameVerifyUI.this.startActivityForResult(paramAnonymousView, 1);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70048);
      }
    });
    this.HRv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70049);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("GetAddress", true);
        paramAnonymousView.putExtra("ShowSelectedLocation", false);
        paramAnonymousView.putExtra("IsRealNameVerifyScene", true);
        paramAnonymousView.putExtra("IsNeedShowSearchBar", true);
        c.c(WalletRealNameVerifyUI.this.getContext(), ".ui.tools.MultiStageCitySelectUI", paramAnonymousView, 2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70049);
      }
    });
    this.krs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70050);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = WalletRealNameVerifyUI.b(WalletRealNameVerifyUI.this).getText();
        localObject = WalletRealNameVerifyUI.c(WalletRealNameVerifyUI.this).getText();
        WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this, paramAnonymousView, (String)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70050);
      }
    });
    setEditFocusListener(this.HRt, 1, false);
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
    this.HRw = ((CheckBox)findViewById(2131296592));
    this.yyx = ((TextView)findViewById(2131296590));
    this.HRw.setChecked(true);
    this.HRw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
    this.yyx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70054);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new LinkedList();
        localObject = new LinkedList();
        paramAnonymousView.add(WalletRealNameVerifyUI.this.getString(2131767527));
        ((List)localObject).add(Integer.valueOf(0));
        if ((WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this) != null) && (WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this).HXD))
        {
          paramAnonymousView.add(WalletRealNameVerifyUI.this.getString(2131767525));
          ((List)localObject).add(Integer.valueOf(1));
        }
        h.a(WalletRealNameVerifyUI.this, "", paramAnonymousView, (List)localObject, "", new h.e()
        {
          public final void cy(int paramAnonymous2Int1, int paramAnonymous2Int2)
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
              f.aA(WalletRealNameVerifyUI.this.getContext(), localIntent);
              AppMethodBeat.o(70053);
              return;
              localIntent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(2131767402, new Object[] { LocaleUtil.getApplicationLanguage() }));
              continue;
              if (WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this) != null) {
                localIntent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(2131767400, new Object[] { LocaleUtil.getApplicationLanguage(), WalletRealNameVerifyUI.e(WalletRealNameVerifyUI.this).dDj }));
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
        this.HRz = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
        this.HRu.setText(this.HRz.HTX);
        AppMethodBeat.o(70063);
        return;
      }
      Log.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
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
        if (!Util.isNullOrNil(str1)) {
          paramIntent.append(str1);
        }
        if (!Util.isNullOrNil(str2)) {
          paramIntent.append(" ").append(str2);
        }
        if (!Util.isNullOrNil(str3)) {
          paramIntent.append(" ").append(str3);
        }
        this.HRv.setText(paramIntent.toString());
        AppMethodBeat.o(70063);
        return;
      }
      Log.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
    }
    AppMethodBeat.o(70063);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(70062);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/id_verify/WalletRealNameVerifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(70062);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70057);
    super.onCreate(paramBundle);
    this.mNetSceneMgr.addSceneEndListener(1616);
    this.HRy = ((ElementQuery)getInput().getParcelable("elemt_query"));
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
    Log.d("MicroMsg.WalletRealNameVerifyUI", "check info");
    String str1 = this.HRs.getText();
    String str2 = this.HRt.getText();
    int i;
    if (Util.isNullOrNil(str1)) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        this.krs.setEnabled(false);
        this.krs.setClickable(false);
        AppMethodBeat.o(70064);
        return;
        if (Util.isNullOrNil(str2))
        {
          i = 0;
          continue;
        }
        if (this.HRA)
        {
          if ((!Util.isNullOrNil(this.countryCode)) || (!Util.isNullOrNil(this.provinceCode)) || (!Util.isNullOrNil(this.cityCode))) {}
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
        if ((this.HRB) && (this.HRz == null)) {
          i = 0;
        }
      }
      else
      {
        this.krs.setEnabled(true);
        this.krs.setClickable(true);
        AppMethodBeat.o(70064);
        return;
      }
      i = 1;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
  {
    boolean bool2 = false;
    AppMethodBeat.i(70060);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof g))
      {
        paramString = (g)paramq;
        if (paramString.HPz == null) {
          q(paramq);
        }
        for (;;)
        {
          AppMethodBeat.o(70060);
          return true;
          Log.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify show juveniles dialog");
          h.c(this, paramString.HPz.dQx, "", paramString.HPz.IaV, paramString.HPz.IaU, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70055);
              Log.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify dialog lOk");
              WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this, paramq);
              u.xV(1);
              AppMethodBeat.o(70055);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(70056);
              Log.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify dialog lCancel");
              u.xV(0);
              AppMethodBeat.o(70056);
            }
          });
        }
      }
      if ((paramq instanceof l))
      {
        paramString = (l)paramq;
        if (paramString.HQh == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.HRA = bool1;
          bool1 = bool2;
          if (paramString.HQi == 1) {
            bool1 = true;
          }
          this.HRB = bool1;
          if (!this.HRB) {
            this.HRu.setVisibility(8);
          }
          if (!this.HRA) {
            this.HRv.setVisibility(8);
          }
          if ((this.HRA) || (this.HRB)) {
            this.HRx.setText(2131768210);
          }
          this.mProfessions = paramString.HTV;
          AppMethodBeat.o(70060);
          return true;
        }
      }
    }
    else
    {
      Log.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
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