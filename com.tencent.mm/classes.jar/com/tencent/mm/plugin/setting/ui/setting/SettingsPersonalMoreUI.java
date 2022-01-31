package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.DialogPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPersonalMoreUI
  extends MMPreference
  implements n.b
{
  private int dqC = -1;
  private f screen;
  
  private void cku()
  {
    AppMethodBeat.i(127387);
    Preference localPreference = this.screen.atx("settings_signature");
    String str2 = bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(12291, null));
    String str1 = str2;
    if (str2.length() <= 0) {
      str1 = getString(2131303427);
    }
    localPreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, str1));
    AppMethodBeat.o(127387);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(127389);
    int i = bo.f(paramObject, 0);
    ab.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramn });
    if ((paramn != com.tencent.mm.kernel.g.RL().Ru()) || (i <= 0))
    {
      ab.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramn });
      AppMethodBeat.o(127389);
      return;
    }
    if (12291 == i) {
      cku();
    }
    AppMethodBeat.o(127389);
  }
  
  public int getResourceId()
  {
    return 2131165289;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127384);
    setMMTitle(2131303364);
    this.screen = getPreferenceScreen();
    ((DialogPreference)this.screen.atx("settings_sex")).zqD = new SettingsPersonalMoreUI.1(this);
    setBackBtn(new SettingsPersonalMoreUI.2(this));
    AppMethodBeat.o(127384);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127383);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(127383);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127386);
    super.onPause();
    bp localbp = bp.aba();
    if (this.dqC != -1) {
      localbp.dqC = this.dqC;
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Yz().c(new j.a(1, bp.a(localbp)));
    AppMethodBeat.o(127386);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127388);
    paramf = paramPreference.mKey;
    if (paramf.equals("settings_district"))
    {
      b.gmO.b(new Intent(), getContext());
      AppMethodBeat.o(127388);
      return true;
    }
    if (paramf.equals("settings_signature"))
    {
      startActivity(new Intent(this, EditSignatureUI.class));
      AppMethodBeat.o(127388);
      return true;
    }
    if (paramf.equals("settings_linkedin"))
    {
      paramf = new Intent(this, BindLinkedInUI.class);
      paramf.putExtra("oversea_entry", true);
      startActivity(paramf);
      AppMethodBeat.o(127388);
      return true;
    }
    AppMethodBeat.o(127388);
    return false;
  }
  
  public void onResume()
  {
    int k = 1;
    AppMethodBeat.i(127385);
    super.onResume();
    int i = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(12290, null), 0);
    Object localObject1 = (DialogPreference)this.screen.atx("settings_sex");
    switch (i)
    {
    default: 
      ((DialogPreference)localObject1).setValue("unknown");
      Object localObject2 = bp.aba();
      localObject1 = bo.nullAsNil(((bp)localObject2).getProvince());
      localObject2 = bo.nullAsNil(((bp)localObject2).getCity());
      this.screen.atx("settings_district").setSummary(s.nG((String)localObject1) + " " + (String)localObject2);
      cku();
      if ((r.Zy() & 0x1000000) == 0)
      {
        i = 1;
        label163:
        localObject1 = com.tencent.mm.m.g.Nq().getValue("LinkedinPluginClose");
        if ((!bo.isNullOrNil((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() != 0)) {
          break label248;
        }
      }
      break;
    }
    label248:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) && (j != 0)) {
        break label253;
      }
      this.screen.cl("settings_linkedin", true);
      AppMethodBeat.o(127385);
      return;
      ((DialogPreference)localObject1).setValue("male");
      break;
      ((DialogPreference)localObject1).setValue("female");
      break;
      i = 0;
      break label163;
    }
    label253:
    localObject1 = this.screen.atx("settings_linkedin");
    if (!bo.isNullOrNil((String)com.tencent.mm.kernel.g.RL().Ru().get(286721, null))) {}
    for (i = k; i == 0; i = 0)
    {
      ((Preference)localObject1).setSummary(getString(2131303289));
      AppMethodBeat.o(127385);
      return;
    }
    if ((r.Zr() & 0x400000) == 0)
    {
      ((Preference)localObject1).setSummary(getString(2131303290));
      AppMethodBeat.o(127385);
      return;
    }
    ((Preference)localObject1).setSummary(getString(2131303291));
    AppMethodBeat.o(127385);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI
 * JD-Core Version:    0.7.0.1
 */