package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.a.k;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.DialogPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;

public class SettingsPersonalMoreUI
  extends MMPreference
  implements m.b
{
  private f dnn;
  private int sex = -1;
  
  private void bzk()
  {
    Preference localPreference = this.dnn.add("settings_signature");
    String str2 = bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(12291, null));
    String str1 = str2;
    if (str2.length() <= 0) {
      str1 = getString(a.i.settings_signature_empty);
    }
    localPreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, str1));
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    int i = bk.e(paramObject, 0);
    y.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    if ((paramm != com.tencent.mm.kernel.g.DP().Dz()) || (i <= 0)) {
      y.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    while (12291 != i) {
      return;
    }
    bzk();
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_district"))
    {
      b.eUR.b(new Intent(), this.mController.uMN);
      return true;
    }
    if (paramf.equals("settings_signature"))
    {
      startActivity(new Intent(this, EditSignatureUI.class));
      return true;
    }
    if (paramf.equals("settings_linkedin"))
    {
      paramf = new Intent(this, BindLinkedInUI.class);
      paramf.putExtra("oversea_entry", true);
      startActivity(paramf);
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_personal_more_info);
    this.dnn = this.vdd;
    ((DialogPreference)this.dnn.add("settings_sex")).vcc = new SettingsPersonalMoreUI.1(this);
    setBackBtn(new SettingsPersonalMoreUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onPause()
  {
    super.onPause();
    bn localbn = bn.Id();
    if (this.sex != -1) {
      localbn.sex = this.sex;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new i.a(1, bn.a(localbn)));
  }
  
  protected void onResume()
  {
    int k = 1;
    super.onResume();
    int i = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(12290, null), 0);
    Object localObject1 = (DialogPreference)this.dnn.add("settings_sex");
    switch (i)
    {
    default: 
      ((DialogPreference)localObject1).setValue("unknown");
      Object localObject2 = bn.Id();
      localObject1 = bk.pm(((bn)localObject2).getProvince());
      localObject2 = bk.pm(((bn)localObject2).getCity());
      this.dnn.add("settings_district").setSummary(r.gX((String)localObject1) + " " + (String)localObject2);
      bzk();
      if ((q.Gu() & 0x1000000) == 0)
      {
        i = 1;
        label159:
        localObject1 = com.tencent.mm.m.g.AA().getValue("LinkedinPluginClose");
        if ((!bk.bl((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() != 0)) {
          break label239;
        }
      }
      break;
    }
    label239:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) && (j != 0)) {
        break label244;
      }
      this.dnn.bJ("settings_linkedin", true);
      return;
      ((DialogPreference)localObject1).setValue("male");
      break;
      ((DialogPreference)localObject1).setValue("female");
      break;
      i = 0;
      break label159;
    }
    label244:
    localObject1 = this.dnn.add("settings_linkedin");
    if (!bk.bl((String)com.tencent.mm.kernel.g.DP().Dz().get(286721, null))) {}
    for (i = k; i == 0; i = 0)
    {
      ((Preference)localObject1).setSummary(getString(a.i.settings_linkedin_open_not_bind));
      return;
    }
    if ((q.Gn() & 0x400000) == 0)
    {
      ((Preference)localObject1).setSummary(getString(a.i.settings_linkedin_open_not_set));
      return;
    }
    ((Preference)localObject1).setSummary(getString(a.i.settings_linkedin_open_set));
  }
  
  public final int xj()
  {
    return a.k.settings_pref_personal_info_more;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI
 * JD-Core Version:    0.7.0.1
 */