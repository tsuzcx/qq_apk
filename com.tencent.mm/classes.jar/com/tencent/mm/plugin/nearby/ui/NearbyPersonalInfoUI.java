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
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.base.preference.f;

public class NearbyPersonalInfoUI
  extends MMPreference
{
  private int fuA = -1;
  private f screen;
  
  public int getResourceId()
  {
    return 2132017238;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89888);
    setMMTitle(2131763484);
    this.screen = getPreferenceScreen();
    ((KeyValuePreference)this.screen.bmg("settings_signature")).OYB = false;
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
    addTextOptionMenu(0, getString(2131755916), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89884);
        if (NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this) != -1)
        {
          paramAnonymousMenuItem = bz.aWj();
          paramAnonymousMenuItem.fuA = NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this);
          bz.a(paramAnonymousMenuItem);
        }
        paramAnonymousMenuItem = bz.aWk();
        if (paramAnonymousMenuItem == null) {
          NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(89884);
          return true;
          String str = Util.nullAsNil(paramAnonymousMenuItem.getProvince());
          Util.nullAsNil(paramAnonymousMenuItem.getCity());
          int i = paramAnonymousMenuItem.fuA;
          if ((Util.isNullOrNil(str)) || (i == 0))
          {
            NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
          }
          else
          {
            com.tencent.mm.bp.a.ih(NearbyPersonalInfoUI.this.getContext());
            paramAnonymousMenuItem = bz.aWj();
            if (i != -1) {
              paramAnonymousMenuItem.fuA = i;
            }
            ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSM().d(new k.a(1, bz.a(paramAnonymousMenuItem)));
            NearbyPersonalInfoUI.this.finish();
          }
        }
      }
    });
    ((ChoicePreference)this.screen.bmg("settings_sex")).OXy = new Preference.a()
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
    int i = Util.nullAs((Integer)g.aAh().azQ().get(12290, null), 0);
    ChoicePreference localChoicePreference = (ChoicePreference)this.screen.bmg("settings_sex");
    localChoicePreference.setTitle(Html.fromHtml(getString(2131765582) + "<font color='red'>*</font>"));
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
      com.tencent.mm.plugin.nearby.a.jRt.b(null, this);
      AppMethodBeat.o(89890);
      return true;
    }
    if ("settings_signature".equals(paramf))
    {
      com.tencent.mm.plugin.nearby.a.jRt.bX(this);
      overridePendingTransition(2130772132, 2130772131);
      AppMethodBeat.o(89890);
      return true;
    }
    AppMethodBeat.o(89890);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89889);
    Object localObject2 = bz.aWj();
    Object localObject1 = ((bz)localObject2).getProvince();
    localObject2 = ((bz)localObject2).getCity();
    Preference localPreference = this.screen.bmg("settings_district");
    localPreference.setSummary(aa.It((String)localObject1) + " " + (String)localObject2);
    localPreference.setTitle(Html.fromHtml(getString(2131765375) + "<font color='red'>*</font>"));
    localPreference = this.screen.bmg("settings_signature");
    localObject2 = Util.nullAsNil((String)g.aAh().azQ().get(12291, null));
    localObject1 = localObject2;
    if (((String)localObject2).length() <= 0) {
      localObject1 = getString(2131765591);
    }
    localPreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject1));
    super.onResume();
    AppMethodBeat.o(89889);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */