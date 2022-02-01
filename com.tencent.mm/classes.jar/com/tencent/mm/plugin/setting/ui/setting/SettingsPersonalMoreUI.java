package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPersonalMoreUI
  extends MMPreference
  implements n.b
{
  private int evp = -1;
  private f screen;
  
  private void dog()
  {
    AppMethodBeat.i(74324);
    Preference localPreference = this.screen.aKk("settings_signature");
    String str2 = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(12291, null));
    String str1 = str2;
    if (str2.length() <= 0) {
      str1 = getString(2131763409);
    }
    localPreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, str1));
    AppMethodBeat.o(74324);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(74326);
    int i = bt.i(paramObject, 0);
    ad.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.afB().afk()) || (i <= 0))
    {
      ad.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74326);
      return;
    }
    if (12291 == i) {
      dog();
    }
    AppMethodBeat.o(74326);
  }
  
  public int getResourceId()
  {
    return 2131951733;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74321);
    setMMTitle(2131763346);
    this.screen = getPreferenceScreen();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74319);
        SettingsPersonalMoreUI.this.hideVKB();
        SettingsPersonalMoreUI.this.finish();
        AppMethodBeat.o(74319);
        return true;
      }
    });
    AppMethodBeat.o(74321);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74320);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(74320);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74323);
    super.onPause();
    bs localbs = bs.asB();
    if (this.evp != -1) {
      localbs.evp = this.evp;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(1, bs.a(localbs)));
    AppMethodBeat.o(74323);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74325);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_district"))
    {
      b.hYt.b(new Intent(), getContext());
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_signature"))
    {
      paramf = new Intent(this, EditSignatureUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_linkedin"))
    {
      paramf = new Intent(this, BindLinkedInUI.class);
      paramf.putExtra("oversea_entry", true);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_sex"))
    {
      paramf = new Intent(this, SelectSexUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.adn(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74325);
      return true;
    }
    AppMethodBeat.o(74325);
    return false;
  }
  
  public void onResume()
  {
    int k = 0;
    AppMethodBeat.i(74322);
    super.onResume();
    this.evp = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(12290, null), 0);
    Object localObject1 = this.screen.aKk("settings_sex");
    int i;
    switch (this.evp)
    {
    default: 
      Object localObject2 = bs.asB();
      localObject1 = bt.nullAsNil(((bs)localObject2).getProvince());
      localObject2 = bt.nullAsNil(((bs)localObject2).getCity());
      this.screen.aKk("settings_district").setSummary(v.sj((String)localObject1) + " " + (String)localObject2);
      dog();
      if ((u.aqS() & 0x1000000) == 0)
      {
        i = 1;
        label160:
        localObject1 = com.tencent.mm.m.g.Zd().getValue("LinkedinPluginClose");
        if ((!bt.isNullOrNil((String)localObject1)) && (bt.getInt((String)localObject1, 0) != 0)) {
          break label281;
        }
      }
      break;
    }
    label281:
    for (int j = 1;; j = 0)
    {
      if (!bt.isNullOrNil((String)com.tencent.mm.kernel.g.afB().afk().get(286721, null))) {
        k = 1;
      }
      if ((i != 0) && (j != 0) && (k != 0)) {
        break label286;
      }
      this.screen.cE("settings_linkedin", true);
      AppMethodBeat.o(74322);
      return;
      ((Preference)localObject1).setSummary(getString(2131763533));
      break;
      ((Preference)localObject1).setSummary(getString(2131763532));
      break;
      i = 0;
      break label160;
    }
    label286:
    localObject1 = this.screen.aKk("settings_linkedin");
    if ((u.aqK() & 0x400000) == 0)
    {
      ((Preference)localObject1).setSummary(getString(2131763259));
      AppMethodBeat.o(74322);
      return;
    }
    ((Preference)localObject1).setSummary(getString(2131763260));
    AppMethodBeat.o(74322);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI
 * JD-Core Version:    0.7.0.1
 */