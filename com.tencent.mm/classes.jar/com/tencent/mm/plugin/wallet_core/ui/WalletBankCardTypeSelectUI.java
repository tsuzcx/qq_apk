package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;

public class WalletBankCardTypeSelectUI
  extends MMPreference
{
  private ArrayList<String> Dcm;
  private String Dcn;
  private SelectPreference Dco;
  private SelectPreference Dcp;
  private f screen;
  
  public int getResourceId()
  {
    return 2131951755;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70716);
    this.screen = getPreferenceScreen();
    int i = 0;
    while (i < this.Dcm.size())
    {
      SelectPreference localSelectPreference = new SelectPreference(getContext());
      localSelectPreference.setKey((String)this.Dcm.get(i));
      localSelectPreference.setTitle((CharSequence)this.Dcm.get(i));
      this.screen.b(localSelectPreference);
      i += 1;
    }
    if (this.Dcm.get(0) != null)
    {
      this.Dcp = ((SelectPreference)this.screen.aVD((String)this.Dcm.get(0)));
      this.Dcp.isSelected = true;
      this.Dcn = ((String)this.Dcm.get(0));
      this.screen.notifyDataSetChanged();
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(174508);
        WalletBankCardTypeSelectUI.this.hideVKB();
        WalletBankCardTypeSelectUI.this.finish();
        AppMethodBeat.o(174508);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(174509);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("bank_card_acc_name", WalletBankCardTypeSelectUI.a(WalletBankCardTypeSelectUI.this));
        ad.i("WalletBankCardTypeSelectUI", "item bank: %s", new Object[] { WalletBankCardTypeSelectUI.a(WalletBankCardTypeSelectUI.this) });
        WalletBankCardTypeSelectUI.this.setResult(-1, paramAnonymousMenuItem);
        WalletBankCardTypeSelectUI.this.finish();
        AppMethodBeat.o(174509);
        return true;
      }
    }, null, s.b.JbS);
    AppMethodBeat.o(70716);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70715);
    super.onCreate(paramBundle);
    setMMTitle(2131765245);
    this.Dcm = getIntent().getStringArrayListExtra("bank_type_show_list");
    initView();
    AppMethodBeat.o(70715);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(174510);
    paramPreference = paramPreference.mKey;
    int i = 0;
    while (i < this.Dcm.size())
    {
      if (paramPreference.equals(this.Dcm.get(i)))
      {
        this.Dco = ((SelectPreference)paramf.aVD((String)this.Dcm.get(i)));
        this.Dco.isSelected = true;
        this.Dcn = ((String)this.Dcm.get(i));
        if (!this.Dcp.mKey.equals(this.Dco.mKey))
        {
          this.Dcp.isSelected = false;
          this.Dcp = this.Dco;
        }
        paramf.notifyDataSetChanged();
      }
      i += 1;
    }
    AppMethodBeat.o(174510);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardTypeSelectUI
 * JD-Core Version:    0.7.0.1
 */