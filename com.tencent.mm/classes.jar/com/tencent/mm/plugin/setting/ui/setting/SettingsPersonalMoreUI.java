package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.l;
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
  private com.tencent.mm.ui.base.preference.f screen;
  private int sex = -1;
  
  private void fGw()
  {
    AppMethodBeat.i(74324);
    Preference localPreference = this.screen.byG("settings_signature");
    String str2 = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(12291, null));
    String str1 = str2;
    if (str2.length() <= 0) {
      str1 = getString(b.i.settings_signature_empty);
    }
    localPreference.aF(l.c(this, str1));
    AppMethodBeat.o(74324);
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_personal_info_more;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74321);
    setMMTitle(b.i.settings_personal_more_info);
    this.screen = getPreferenceScreen();
    setBackBtn(new SettingsPersonalMoreUI.1(this));
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
    if ((paramMStorageEx != com.tencent.mm.kernel.h.aHG().aHp()) || (i <= 0))
    {
      Log.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramMStorageEx });
      AppMethodBeat.o(74326);
      return;
    }
    if (12291 == i) {
      fGw();
    }
    AppMethodBeat.o(74326);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74323);
    super.onPause();
    ca localca = ca.bfn();
    if (this.sex != -1) {
      localca.sex = this.sex;
    }
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(1, ca.a(localca)));
    AppMethodBeat.o(74323);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74325);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_district"))
    {
      c.mIG.b(new Intent(), getContext());
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_signature"))
    {
      paramf = new Intent(this, EditSignatureUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_linkedin"))
    {
      paramf = new Intent(this, BindLinkedInUI.class);
      paramf.putExtra("oversea_entry", true);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_sex"))
    {
      paramf = new Intent(this, SelectSexUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramf.aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    this.sex = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(12290, null), 0);
    Object localObject1 = this.screen.byG("settings_sex");
    int i;
    switch (this.sex)
    {
    default: 
      Object localObject2 = ca.bfn();
      localObject1 = Util.nullAsNil(((ca)localObject2).getProvince());
      localObject2 = Util.nullAsNil(((ca)localObject2).getCity());
      this.screen.byG("settings_district").aF(aa.PL((String)localObject1) + " " + (String)localObject2);
      fGw();
      if ((z.bdn() & 0x1000000) == 0)
      {
        i = 1;
        label160:
        localObject1 = com.tencent.mm.n.h.axc().getValue("LinkedinPluginClose");
        if ((!Util.isNullOrNil((String)localObject1)) && (Util.getInt((String)localObject1, 0) != 0)) {
          break label282;
        }
      }
      break;
    }
    label282:
    for (int j = 1;; j = 0)
    {
      if (!Util.isNullOrNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(286721, null))) {
        k = 1;
      }
      if ((i != 0) && (j != 0) && (k != 0)) {
        break label287;
      }
      this.screen.dz("settings_linkedin", true);
      AppMethodBeat.o(74322);
      return;
      ((Preference)localObject1).aF(getString(b.i.sex_male));
      break;
      ((Preference)localObject1).aF(getString(b.i.sex_female));
      break;
      i = 0;
      break label160;
    }
    label287:
    localObject1 = this.screen.byG("settings_linkedin");
    if ((z.bdd() & 0x400000) == 0)
    {
      ((Preference)localObject1).aF(getString(b.i.settings_linkedin_open_not_set));
      AppMethodBeat.o(74322);
      return;
    }
    ((Preference)localObject1).aF(getString(b.i.settings_linkedin_open_set));
    AppMethodBeat.o(74322);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI
 * JD-Core Version:    0.7.0.1
 */