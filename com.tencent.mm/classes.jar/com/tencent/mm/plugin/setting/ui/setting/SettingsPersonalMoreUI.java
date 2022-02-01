package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class SettingsPersonalMoreUI
  extends MMPreference
  implements MStorageEx.IOnStorageChange
{
  private int fuA = -1;
  private com.tencent.mm.ui.base.preference.f screen;
  
  private void eTs()
  {
    AppMethodBeat.i(74324);
    Preference localPreference = this.screen.bmg("settings_signature");
    String str2 = Util.nullAsNil((String)g.aAh().azQ().get(12291, null));
    String str1 = str2;
    if (str2.length() <= 0) {
      str1 = getString(2131765591);
    }
    localPreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, str1));
    AppMethodBeat.o(74324);
  }
  
  public int getResourceId()
  {
    return 2132017278;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74321);
    setMMTitle(2131765527);
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
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(74326);
    int i = Util.nullAsInt(paramObject, 0);
    Log.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramMStorageEx });
    if ((paramMStorageEx != g.aAh().azQ()) || (i <= 0))
    {
      Log.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74326);
      return;
    }
    if (12291 == i) {
      eTs();
    }
    AppMethodBeat.o(74326);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74323);
    super.onPause();
    bz localbz = bz.aWj();
    if (this.fuA != -1) {
      localbz.fuA = this.fuA;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(1, bz.a(localbz)));
    AppMethodBeat.o(74323);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74325);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_district"))
    {
      c.jRt.b(new Intent(), getContext());
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_signature"))
    {
      paramf = new Intent(this, EditSignatureUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_linkedin"))
    {
      paramf = new Intent(this, BindLinkedInUI.class);
      paramf.putExtra("oversea_entry", true);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_sex"))
    {
      paramf = new Intent(this, SelectSexUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.pG(0));
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
    this.fuA = Util.nullAs((Integer)g.aAh().azQ().get(12290, null), 0);
    Object localObject1 = this.screen.bmg("settings_sex");
    int i;
    switch (this.fuA)
    {
    default: 
      Object localObject2 = bz.aWj();
      localObject1 = Util.nullAsNil(((bz)localObject2).getProvince());
      localObject2 = Util.nullAsNil(((bz)localObject2).getCity());
      this.screen.bmg("settings_district").setSummary(aa.It((String)localObject1) + " " + (String)localObject2);
      eTs();
      if ((z.aUl() & 0x1000000) == 0)
      {
        i = 1;
        label160:
        localObject1 = h.aqJ().getValue("LinkedinPluginClose");
        if ((!Util.isNullOrNil((String)localObject1)) && (Util.getInt((String)localObject1, 0) != 0)) {
          break label281;
        }
      }
      break;
    }
    label281:
    for (int j = 1;; j = 0)
    {
      if (!Util.isNullOrNil((String)g.aAh().azQ().get(286721, null))) {
        k = 1;
      }
      if ((i != 0) && (j != 0) && (k != 0)) {
        break label286;
      }
      this.screen.jdMethod_do("settings_linkedin", true);
      AppMethodBeat.o(74322);
      return;
      ((Preference)localObject1).setSummary(getString(2131765721));
      break;
      ((Preference)localObject1).setSummary(getString(2131765720));
      break;
      i = 0;
      break label160;
    }
    label286:
    localObject1 = this.screen.bmg("settings_linkedin");
    if ((z.aUc() & 0x400000) == 0)
    {
      ((Preference)localObject1).setSummary(getString(2131765429));
      AppMethodBeat.o(74322);
      return;
    }
    ((Preference)localObject1).setSummary(getString(2131765430));
    AppMethodBeat.o(74322);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI
 * JD-Core Version:    0.7.0.1
 */