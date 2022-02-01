package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t.b;
import java.util.ArrayList;

public class WalletBankCardTypeSelectUI
  extends MMPreference
{
  private ArrayList<String> Idc;
  private String Idd;
  private SelectPreference Ide;
  private SelectPreference Idf;
  private f screen;
  
  public int getResourceId()
  {
    return 2132017300;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70716);
    this.screen = getPreferenceScreen();
    int i = 0;
    while (i < this.Idc.size())
    {
      SelectPreference localSelectPreference = new SelectPreference(getContext());
      localSelectPreference.setKey((String)this.Idc.get(i));
      localSelectPreference.setTitle((CharSequence)this.Idc.get(i));
      this.screen.c(localSelectPreference);
      i += 1;
    }
    if (this.Idc.get(0) != null)
    {
      this.Idf = ((SelectPreference)this.screen.bmg((String)this.Idc.get(0)));
      this.Idf.isSelected = true;
      this.Idd = ((String)this.Idc.get(0));
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
    addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(174509);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("bank_card_acc_name", WalletBankCardTypeSelectUI.a(WalletBankCardTypeSelectUI.this));
        Log.i("WalletBankCardTypeSelectUI", "item bank: %s", new Object[] { WalletBankCardTypeSelectUI.a(WalletBankCardTypeSelectUI.this) });
        WalletBankCardTypeSelectUI.this.setResult(-1, paramAnonymousMenuItem);
        WalletBankCardTypeSelectUI.this.finish();
        AppMethodBeat.o(174509);
        return true;
      }
    }, null, t.b.OGU);
    AppMethodBeat.o(70716);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70715);
    super.onCreate(paramBundle);
    setMMTitle(2131767688);
    this.Idc = getIntent().getStringArrayListExtra("bank_type_show_list");
    initView();
    AppMethodBeat.o(70715);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(174510);
    paramPreference = paramPreference.mKey;
    int i = 0;
    while (i < this.Idc.size())
    {
      if (paramPreference.equals(this.Idc.get(i)))
      {
        this.Ide = ((SelectPreference)paramf.bmg((String)this.Idc.get(i)));
        this.Ide.isSelected = true;
        this.Idd = ((String)this.Idc.get(i));
        if (!this.Idf.mKey.equals(this.Ide.mKey))
        {
          this.Idf.isSelected = false;
          this.Idf = this.Ide;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardTypeSelectUI
 * JD-Core Version:    0.7.0.1
 */