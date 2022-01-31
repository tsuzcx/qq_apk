package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.nearby.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bo;
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
  private int dqC = -1;
  private f screen;
  
  public int getResourceId()
  {
    return 2131165252;
  }
  
  public void initView()
  {
    AppMethodBeat.i(55491);
    setMMTitle(2131301777);
    this.screen = getPreferenceScreen();
    ((KeyValuePreference)this.screen.atx("settings_signature")).zrr = false;
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(55483);
        NearbyPersonalInfoUI.this.finish();
        AppMethodBeat.o(55483);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131297013), new NearbyPersonalInfoUI.2(this));
    ((ChoicePreference)this.screen.atx("settings_sex")).zqD = new Preference.a()
    {
      public final boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        AppMethodBeat.i(55485);
        paramAnonymousPreference = (String)paramAnonymousObject;
        if ("male".equalsIgnoreCase(paramAnonymousPreference)) {
          NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this, 1);
        }
        for (;;)
        {
          AppMethodBeat.o(55485);
          return false;
          if ("female".equalsIgnoreCase(paramAnonymousPreference)) {
            NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this, 2);
          }
        }
      }
    };
    int i = bo.a((Integer)g.RL().Ru().get(12290, null), 0);
    ChoicePreference localChoicePreference = (ChoicePreference)this.screen.atx("settings_sex");
    localChoicePreference.setTitle(Html.fromHtml(getString(2131303418) + "<font color='red'>*</font>"));
    switch (i)
    {
    default: 
      localChoicePreference.setValue("unknown");
      AppMethodBeat.o(55491);
      return;
    case 1: 
      localChoicePreference.setValue("male");
      AppMethodBeat.o(55491);
      return;
    }
    localChoicePreference.setValue("female");
    AppMethodBeat.o(55491);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55486);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(55486);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(55487);
    super.onDestroy();
    AppMethodBeat.o(55487);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(55490);
    paramf = paramPreference.mKey;
    if ("settings_district".equals(paramf))
    {
      a.gmO.b(null, this);
      AppMethodBeat.o(55490);
      return true;
    }
    if ("settings_signature".equals(paramf))
    {
      a.gmO.bk(this);
      overridePendingTransition(2131034230, 2131034229);
      AppMethodBeat.o(55490);
      return true;
    }
    AppMethodBeat.o(55490);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(55489);
    Object localObject2 = bp.aba();
    Object localObject1 = ((bp)localObject2).getProvince();
    localObject2 = ((bp)localObject2).getCity();
    Preference localPreference = this.screen.atx("settings_district");
    localPreference.setSummary(s.nG((String)localObject1) + " " + (String)localObject2);
    localPreference.setTitle(Html.fromHtml(getString(2131303238) + "<font color='red'>*</font>"));
    localPreference = this.screen.atx("settings_signature");
    localObject2 = bo.nullAsNil((String)g.RL().Ru().get(12291, null));
    localObject1 = localObject2;
    if (((String)localObject2).length() <= 0) {
      localObject1 = getString(2131303427);
    }
    localPreference.setSummary(j.b(this, (CharSequence)localObject1));
    super.onResume();
    AppMethodBeat.o(55489);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */