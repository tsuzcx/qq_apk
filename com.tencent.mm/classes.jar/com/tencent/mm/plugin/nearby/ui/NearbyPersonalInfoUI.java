package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.base.preference.f;

public class NearbyPersonalInfoUI
  extends MMPreference
{
  private int exL = -1;
  private f screen;
  
  public int getResourceId()
  {
    return 2131951694;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89888);
    setMMTitle(2131761524);
    this.screen = getPreferenceScreen();
    ((KeyValuePreference)this.screen.aPN("settings_signature")).HET = false;
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89883);
        NearbyPersonalInfoUI.this.finish();
        AppMethodBeat.o(89883);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755830), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89884);
        if (NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this) != -1)
        {
          paramAnonymousMenuItem = com.tencent.mm.model.bs.azs();
          paramAnonymousMenuItem.exL = NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this);
          com.tencent.mm.model.bs.a(paramAnonymousMenuItem);
        }
        paramAnonymousMenuItem = com.tencent.mm.model.bs.azt();
        if (paramAnonymousMenuItem == null) {
          NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(89884);
          return true;
          Object localObject = com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramAnonymousMenuItem.getProvince());
          com.tencent.mm.sdk.platformtools.bs.nullAsNil(paramAnonymousMenuItem.getCity());
          int i = paramAnonymousMenuItem.exL;
          if ((com.tencent.mm.sdk.platformtools.bs.isNullOrNil((String)localObject)) || (i == 0))
          {
            NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
          }
          else
          {
            paramAnonymousMenuItem = NearbyPersonalInfoUI.this;
            localObject = new Intent(NearbyPersonalInfoUI.this, NearbyFriendsUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/nearby/ui/NearbyPersonalInfoUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/nearby/ui/NearbyPersonalInfoUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem = com.tencent.mm.model.bs.azs();
            if (i != -1) {
              paramAnonymousMenuItem.exL = i;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(1, com.tencent.mm.model.bs.a(paramAnonymousMenuItem)));
            NearbyPersonalInfoUI.this.finish();
          }
        }
      }
    });
    ((ChoicePreference)this.screen.aPN("settings_sex")).HDT = new Preference.a()
    {
      public final boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        AppMethodBeat.i(89885);
        paramAnonymousPreference = (String)paramAnonymousObject;
        if ("male".equalsIgnoreCase(paramAnonymousPreference)) {
          NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this, 1);
        }
        for (;;)
        {
          AppMethodBeat.o(89885);
          return false;
          if ("female".equalsIgnoreCase(paramAnonymousPreference)) {
            NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this, 2);
          }
        }
      }
    };
    int i = com.tencent.mm.sdk.platformtools.bs.a((Integer)g.agR().agA().get(12290, null), 0);
    ChoicePreference localChoicePreference = (ChoicePreference)this.screen.aPN("settings_sex");
    localChoicePreference.setTitle(Html.fromHtml(getString(2131763400) + "<font color='red'>*</font>"));
    switch (i)
    {
    default: 
      localChoicePreference.setValue("unknown");
      AppMethodBeat.o(89888);
      return;
    case 1: 
      localChoicePreference.setValue("male");
      AppMethodBeat.o(89888);
      return;
    }
    localChoicePreference.setValue("female");
    AppMethodBeat.o(89888);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89886);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(89886);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(89887);
    super.onDestroy();
    AppMethodBeat.o(89887);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(89890);
    paramf = paramPreference.mKey;
    if ("settings_district".equals(paramf))
    {
      com.tencent.mm.plugin.nearby.a.iyx.b(null, this);
      AppMethodBeat.o(89890);
      return true;
    }
    if ("settings_signature".equals(paramf))
    {
      com.tencent.mm.plugin.nearby.a.iyx.bB(this);
      overridePendingTransition(2130772108, 2130772107);
      AppMethodBeat.o(89890);
      return true;
    }
    AppMethodBeat.o(89890);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89889);
    Object localObject2 = com.tencent.mm.model.bs.azs();
    Object localObject1 = ((com.tencent.mm.model.bs)localObject2).getProvince();
    localObject2 = ((com.tencent.mm.model.bs)localObject2).getCity();
    Preference localPreference = this.screen.aPN("settings_district");
    localPreference.setSummary(v.wm((String)localObject1) + " " + (String)localObject2);
    localPreference.setTitle(Html.fromHtml(getString(2131763207) + "<font color='red'>*</font>"));
    localPreference = this.screen.aPN("settings_signature");
    localObject2 = com.tencent.mm.sdk.platformtools.bs.nullAsNil((String)g.agR().agA().get(12291, null));
    localObject1 = localObject2;
    if (((String)localObject2).length() <= 0) {
      localObject1 = getString(2131763409);
    }
    localPreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject1));
    super.onResume();
    AppMethodBeat.o(89889);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */