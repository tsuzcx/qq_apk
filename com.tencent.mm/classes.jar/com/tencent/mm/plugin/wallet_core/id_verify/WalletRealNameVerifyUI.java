package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
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
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.d;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;

public class WalletRealNameVerifyUI
  extends WalletBaseUI
  implements View.OnClickListener, WalletFormView.a
{
  private String countryCode;
  private String fnB;
  private String fnC;
  private Button gJr;
  private Profession[] mProfessions;
  private TextView nVZ;
  private WalletFormView ucV;
  private WalletFormView ucW;
  private WalletFormView ucX;
  private WalletFormView ucY;
  private CheckBox ucZ;
  private TextView uda;
  private ElementQuery udb;
  private Profession udc;
  private boolean udd = false;
  private boolean ude = false;
  
  public int getLayoutId()
  {
    return 2130971240;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46629);
    setMMTitle(2131305547);
    this.gJr = ((Button)findViewById(2131822914));
    this.ucV = ((WalletFormView)findViewById(2131829013));
    this.ucW = ((WalletFormView)findViewById(2131826693));
    this.ucX = ((WalletFormView)findViewById(2131829056));
    this.ucY = ((WalletFormView)findViewById(2131829057));
    this.uda = ((TextView)findViewById(2131828908));
    this.ucV.setOnInputValidChangeListener(this);
    this.ucW.setOnInputValidChangeListener(this);
    this.ucX.setOnInputValidChangeListener(this);
    this.ucY.setOnInputValidChangeListener(this);
    this.ucV.setFocusable(true);
    this.ucV.getInfoIv().setVisibility(8);
    com.tencent.mm.wallet_core.ui.formview.a.d(this.ucW);
    b localb = this.ucW.getLogicDelegate();
    if ((localb instanceof a.a)) {
      ((a.a)localb).RY(1);
    }
    this.ucX.setOnClickListener(new WalletRealNameVerifyUI.1(this));
    this.ucY.setOnClickListener(new WalletRealNameVerifyUI.2(this));
    this.gJr.setOnClickListener(new WalletRealNameVerifyUI.3(this));
    setEditFocusListener(this.ucW, 1, false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(46623);
        paramAnonymousMenuItem = (a)WalletRealNameVerifyUI.this.getProcess();
        if (paramAnonymousMenuItem != null) {
          paramAnonymousMenuItem.e(WalletRealNameVerifyUI.this, 0);
        }
        WalletRealNameVerifyUI.this.finish();
        AppMethodBeat.o(46623);
        return true;
      }
    });
    this.ucZ = ((CheckBox)findViewById(2131829071));
    this.nVZ = ((TextView)findViewById(2131829368));
    this.ucZ.setChecked(true);
    this.ucZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46624);
        if (paramAnonymousBoolean)
        {
          WalletRealNameVerifyUI.d(WalletRealNameVerifyUI.this).setEnabled(true);
          WalletRealNameVerifyUI.d(WalletRealNameVerifyUI.this).setClickable(true);
          AppMethodBeat.o(46624);
          return;
        }
        WalletRealNameVerifyUI.d(WalletRealNameVerifyUI.this).setEnabled(false);
        WalletRealNameVerifyUI.d(WalletRealNameVerifyUI.this).setClickable(false);
        AppMethodBeat.o(46624);
      }
    });
    this.nVZ.setOnClickListener(new WalletRealNameVerifyUI.6(this));
    AppMethodBeat.o(46629);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(46631);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        this.udc = ((Profession)paramIntent.getParcelableExtra("key_select_profession"));
        this.ucX.setText(this.udc.ues);
        AppMethodBeat.o(46631);
        return;
      }
      ab.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
      AppMethodBeat.o(46631);
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
        this.fnC = paramIntent.getStringExtra("Contact_Province");
        this.fnB = paramIntent.getStringExtra("Contact_City");
        paramIntent = new StringBuilder();
        if (!bo.isNullOrNil(str1)) {
          paramIntent.append(str1);
        }
        if (!bo.isNullOrNil(str2)) {
          paramIntent.append(" ").append(str2);
        }
        if (!bo.isNullOrNil(str3)) {
          paramIntent.append(" ").append(str3);
        }
        this.ucY.setText(paramIntent.toString());
        AppMethodBeat.o(46631);
        return;
      }
      ab.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
    }
    AppMethodBeat.o(46631);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46627);
    super.onCreate(paramBundle);
    this.mNetSceneMgr.addSceneEndListener(1616);
    this.udb = ((ElementQuery)getInput().getParcelable("elemt_query"));
    initView();
    doSceneForceProgress(new g());
    AppMethodBeat.o(46627);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(46628);
    this.mNetSceneMgr.removeSceneEndListener(1616);
    super.onDestroy();
    AppMethodBeat.o(46628);
  }
  
  public final void onInputValidChange(boolean paramBoolean)
  {
    AppMethodBeat.i(46632);
    ab.d("MicroMsg.WalletRealNameVerifyUI", "check info");
    String str1 = this.ucV.getText();
    String str2 = this.ucW.getText();
    int i;
    if (bo.isNullOrNil(str1)) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        this.gJr.setEnabled(false);
        this.gJr.setClickable(false);
        AppMethodBeat.o(46632);
        return;
        if (bo.isNullOrNil(str2))
        {
          i = 0;
          continue;
        }
        if (this.udd)
        {
          if ((!bo.isNullOrNil(this.countryCode)) || (!bo.isNullOrNil(this.fnC)) || (!bo.isNullOrNil(this.fnB))) {}
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
        if ((this.ude) && (this.udc == null)) {
          i = 0;
        }
      }
      else
      {
        this.gJr.setEnabled(true);
        this.gJr.setClickable(true);
        AppMethodBeat.o(46632);
        return;
      }
      i = 1;
    }
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    AppMethodBeat.i(46630);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof d))
      {
        c localc = getProcess();
        paramString = null;
        if (localc != null) {
          paramString = localc.mEJ;
        }
        paramm = ((d)paramm).token;
        ab.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
        if (localc != null)
        {
          paramString.putString("key_real_name_token", paramm);
          paramString.putString("key_country_code", this.countryCode);
          paramString.putString("key_province_code", this.fnC);
          paramString.putString("key_city_code", this.fnB);
          paramString.putParcelable("key_profession", this.udc);
          localc.a(this, 0, paramString);
        }
        AppMethodBeat.o(46630);
        return true;
      }
      if ((paramm instanceof g))
      {
        paramString = (g)paramm;
        if (paramString.ubV == 1) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          this.udd = bool1;
          bool1 = bool2;
          if (paramString.ubW == 1) {
            bool1 = true;
          }
          this.ude = bool1;
          if (!this.ude) {
            this.ucX.setVisibility(8);
          }
          if (!this.udd) {
            this.ucY.setVisibility(8);
          }
          if ((this.udd) || (this.ude)) {
            this.uda.setText(2131305542);
          }
          this.mProfessions = paramString.ueq;
          AppMethodBeat.o(46630);
          return true;
        }
      }
    }
    else
    {
      ab.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
    }
    AppMethodBeat.o(46630);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI
 * JD-Core Version:    0.7.0.1
 */