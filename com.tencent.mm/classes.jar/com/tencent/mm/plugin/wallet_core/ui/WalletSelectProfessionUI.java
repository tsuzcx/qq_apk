package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;

public class WalletSelectProfessionUI
  extends MMPreference
{
  private static final String TAG = "MicroMsg.WalletSelectProfessionUI";
  protected Profession[] mProfessions = null;
  private f screen;
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71230);
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_select_profession_title);
    this.screen = getPreferenceScreen();
    paramBundle = new PreferenceTitleCategory(getContext());
    paramBundle.setTitle(getString(a.i.wallet_select_profession_tips));
    paramBundle.setKey("title_category");
    this.screen.b(paramBundle);
    paramBundle = getIntent().getParcelableArrayExtra("key_profession_list");
    int i;
    if ((paramBundle != null) && (paramBundle.length > 0))
    {
      this.mProfessions = new Profession[paramBundle.length];
      i = 0;
      while (i < this.mProfessions.length)
      {
        this.mProfessions[i] = ((Profession)paramBundle[i]);
        i += 1;
      }
    }
    if (this.mProfessions != null)
    {
      paramBundle = this.mProfessions;
      int k = paramBundle.length;
      i = 0;
      int j = 0;
      while (i < k)
      {
        Object localObject = paramBundle[i];
        if ((localObject != null) && (!Util.isNullOrNil(localObject.OLY)))
        {
          Preference localPreference = new Preference(getContext());
          localPreference.setTitle(localObject.OLY);
          localPreference.setKey("index_".concat(String.valueOf(j)));
          this.screen.b(localPreference);
        }
        j += 1;
        i += 1;
      }
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(71229);
        WalletSelectProfessionUI.this.setResult(0);
        WalletSelectProfessionUI.this.finish();
        AppMethodBeat.o(71229);
        return true;
      }
    });
    AppMethodBeat.o(71230);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(71231);
    if (paramPreference.mKey.startsWith("index_"))
    {
      paramf = paramPreference.mKey.split("_");
      if (paramf.length != 2) {
        break label81;
      }
      int i = Util.getInt(paramf[1], 0);
      paramf = this.mProfessions[i];
      paramPreference = new Intent();
      paramPreference.putExtra("key_select_profession", paramf);
      setResult(-1, paramPreference);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(71231);
      return true;
      label81:
      Log.w("MicroMsg.WalletSelectProfessionUI", "error key: %s, %s", new Object[] { paramPreference.mKey, paramPreference.getTitle() });
      setResult(0);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI
 * JD-Core Version:    0.7.0.1
 */