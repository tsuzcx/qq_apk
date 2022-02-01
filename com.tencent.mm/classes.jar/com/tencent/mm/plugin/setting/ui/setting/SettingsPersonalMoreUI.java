package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPersonalMoreUI
  extends MMPreference
  implements n.b
{
  private int eQV = -1;
  private f screen;
  
  private void dRr()
  {
    AppMethodBeat.i(74324);
    Preference localPreference = this.screen.aXe("settings_signature");
    String str2 = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(12291, null));
    String str1 = str2;
    if (str2.length() <= 0) {
      str1 = getString(2131763409);
    }
    localPreference.setSummary(k.c(this, str1));
    AppMethodBeat.o(74324);
  }
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(74326);
    int i = bu.m(paramObject, 0);
    ae.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.ajR().ajA()) || (i <= 0))
    {
      ae.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(74326);
      return;
    }
    if (12291 == i) {
      dRr();
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
    bv localbv = bv.aCL();
    if (this.eQV != -1) {
      localbv.eQV = this.eQV;
    }
    ((l)com.tencent.mm.kernel.g.ab(l.class)).azE().d(new k.a(1, bv.a(localbv)));
    AppMethodBeat.o(74323);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74325);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_district"))
    {
      c.iUz.b(new Intent(), getContext());
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_signature"))
    {
      paramf = new Intent(this, EditSignatureUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_linkedin"))
    {
      paramf = new Intent(this, BindLinkedInUI.class);
      paramf.putExtra("oversea_entry", true);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(74325);
      return true;
    }
    if (paramf.equals("settings_sex"))
    {
      paramf = new Intent(this, SelectSexUI.class);
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramf.ahE(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramf.mt(0));
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
    this.eQV = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(12290, null), 0);
    Object localObject1 = this.screen.aXe("settings_sex");
    int i;
    switch (this.eQV)
    {
    default: 
      Object localObject2 = bv.aCL();
      localObject1 = bu.nullAsNil(((bv)localObject2).getProvince());
      localObject2 = bu.nullAsNil(((bv)localObject2).getCity());
      this.screen.aXe("settings_district").setSummary(w.zR((String)localObject1) + " " + (String)localObject2);
      dRr();
      if ((v.aAO() & 0x1000000) == 0)
      {
        i = 1;
        label160:
        localObject1 = com.tencent.mm.n.g.acL().getValue("LinkedinPluginClose");
        if ((!bu.isNullOrNil((String)localObject1)) && (bu.getInt((String)localObject1, 0) != 0)) {
          break label281;
        }
      }
      break;
    }
    label281:
    for (int j = 1;; j = 0)
    {
      if (!bu.isNullOrNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(286721, null))) {
        k = 1;
      }
      if ((i != 0) && (j != 0) && (k != 0)) {
        break label286;
      }
      this.screen.cT("settings_linkedin", true);
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
    localObject1 = this.screen.aXe("settings_linkedin");
    if ((v.aAG() & 0x400000) == 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI
 * JD-Core Version:    0.7.0.1
 */