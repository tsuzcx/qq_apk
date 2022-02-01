package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;

public class WalletBankCardTypeSelectUI
  extends MMPreference
{
  private ArrayList<String> DtQ;
  private String DtR;
  private SelectPreference DtS;
  private SelectPreference DtT;
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
    while (i < this.DtQ.size())
    {
      SelectPreference localSelectPreference = new SelectPreference(getContext());
      localSelectPreference.setKey((String)this.DtQ.get(i));
      localSelectPreference.setTitle((CharSequence)this.DtQ.get(i));
      this.screen.b(localSelectPreference);
      i += 1;
    }
    if (this.DtQ.get(0) != null)
    {
      this.DtT = ((SelectPreference)this.screen.aXe((String)this.DtQ.get(0)));
      this.DtT.isSelected = true;
      this.DtR = ((String)this.DtQ.get(0));
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
        ae.i("WalletBankCardTypeSelectUI", "item bank: %s", new Object[] { WalletBankCardTypeSelectUI.a(WalletBankCardTypeSelectUI.this) });
        WalletBankCardTypeSelectUI.this.setResult(-1, paramAnonymousMenuItem);
        WalletBankCardTypeSelectUI.this.finish();
        AppMethodBeat.o(174509);
        return true;
      }
    }, null, s.b.JwA);
    AppMethodBeat.o(70716);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70715);
    super.onCreate(paramBundle);
    setMMTitle(2131765245);
    this.DtQ = getIntent().getStringArrayListExtra("bank_type_show_list");
    initView();
    AppMethodBeat.o(70715);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(174510);
    paramPreference = paramPreference.mKey;
    int i = 0;
    while (i < this.DtQ.size())
    {
      if (paramPreference.equals(this.DtQ.get(i)))
      {
        this.DtS = ((SelectPreference)paramf.aXe((String)this.DtQ.get(i)));
        this.DtS.isSelected = true;
        this.DtR = ((String)this.DtQ.get(i));
        if (!this.DtT.mKey.equals(this.DtS.mKey))
        {
          this.DtT.isSelected = false;
          this.DtT = this.DtS;
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