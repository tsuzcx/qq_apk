package com.tencent.mm.plugin.nearby.ui;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.nearby.a;
import com.tencent.mm.plugin.nearby.b.a;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.plugin.nearby.b.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.base.preference.f;

public class NearbyPersonalInfoUI
  extends MMPreference
{
  private f dnn;
  private int sex = -1;
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    if ("settings_district".equals(paramf))
    {
      a.eUR.b(null, this);
      return true;
    }
    if ("settings_signature".equals(paramf))
    {
      a.eUR.c(null, this);
      overridePendingTransition(b.a.push_up_in, b.a.push_empty_out);
      return true;
    }
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(b.h.nearby_personal_info);
    this.dnn = this.vdd;
    ((KeyValuePreference)this.dnn.add("settings_signature")).vcS = false;
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        NearbyPersonalInfoUI.this.finish();
        return true;
      }
    });
    addTextOptionMenu(0, getString(b.h.app_nextstep), new NearbyPersonalInfoUI.2(this));
    ((ChoicePreference)this.dnn.add("settings_sex")).vcc = new Preference.a()
    {
      public final boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        paramAnonymousPreference = (String)paramAnonymousObject;
        if ("male".equalsIgnoreCase(paramAnonymousPreference)) {
          NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this, 1);
        }
        for (;;)
        {
          return false;
          if ("female".equalsIgnoreCase(paramAnonymousPreference)) {
            NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this, 2);
          }
        }
      }
    };
    int i = bk.a((Integer)g.DP().Dz().get(12290, null), 0);
    ChoicePreference localChoicePreference = (ChoicePreference)this.dnn.add("settings_sex");
    localChoicePreference.setTitle(Html.fromHtml(getString(b.h.settings_sex) + "<font color='red'>*</font>"));
    switch (i)
    {
    default: 
      localChoicePreference.setValue("unknown");
      return;
    case 1: 
      localChoicePreference.setValue("male");
      return;
    }
    localChoicePreference.setValue("female");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    Object localObject2 = bn.Id();
    Object localObject1 = ((bn)localObject2).getProvince();
    localObject2 = ((bn)localObject2).getCity();
    Preference localPreference = this.dnn.add("settings_district");
    localPreference.setSummary(r.gX((String)localObject1) + " " + (String)localObject2);
    localPreference.setTitle(Html.fromHtml(getString(b.h.settings_district) + "<font color='red'>*</font>"));
    localPreference = this.dnn.add("settings_signature");
    localObject2 = bk.pm((String)g.DP().Dz().get(12291, null));
    localObject1 = localObject2;
    if (((String)localObject2).length() <= 0) {
      localObject1 = getString(b.h.settings_signature_empty);
    }
    localPreference.setSummary(j.b(this, (CharSequence)localObject1));
    super.onResume();
  }
  
  public final int xj()
  {
    return b.i.nearby_personal_info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */