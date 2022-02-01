package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ca;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.nearby.b.a;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.plugin.nearby.b.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;

public class NearbyPersonalInfoUI
  extends MMPreference
{
  private com.tencent.mm.ui.base.preference.f screen;
  private int sex = -1;
  
  public int getResourceId()
  {
    return b.h.nearby_personal_info;
  }
  
  public void initView()
  {
    AppMethodBeat.i(89888);
    setMMTitle(b.g.nearby_personal_info);
    this.screen = getPreferenceScreen();
    ((KeyValuePreference)this.screen.byG("settings_signature")).WrK = false;
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
    addTextOptionMenu(0, getString(b.g.app_nextstep), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(89884);
        if (NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this) != -1)
        {
          paramAnonymousMenuItem = ca.bfn();
          paramAnonymousMenuItem.sex = NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this);
          ca.a(paramAnonymousMenuItem);
        }
        paramAnonymousMenuItem = ca.bfo();
        if (paramAnonymousMenuItem == null) {
          NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(89884);
          return true;
          String str = Util.nullAsNil(paramAnonymousMenuItem.getProvince());
          Util.nullAsNil(paramAnonymousMenuItem.getCity());
          int i = paramAnonymousMenuItem.sex;
          if ((Util.isNullOrNil(str)) || (i == 0))
          {
            NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
          }
          else
          {
            com.tencent.mm.bw.a.jk(NearbyPersonalInfoUI.this.getContext());
            paramAnonymousMenuItem = ca.bfn();
            if (i != -1) {
              paramAnonymousMenuItem.sex = i;
            }
            ((n)h.ae(n.class)).bbK().d(new k.a(1, ca.a(paramAnonymousMenuItem)));
            NearbyPersonalInfoUI.this.finish();
          }
        }
      }
    });
    ((ChoicePreference)this.screen.byG("settings_sex")).WqI = new Preference.a()
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
    int i = Util.nullAs((Integer)h.aHG().aHp().b(12290, null), 0);
    ChoicePreference localChoicePreference = (ChoicePreference)this.screen.byG("settings_sex");
    localChoicePreference.setTitle(Html.fromHtml(getString(b.g.settings_sex) + "<font color='red'>*</font>"));
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
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(89890);
    paramf = paramPreference.mKey;
    if ("settings_district".equals(paramf))
    {
      com.tencent.mm.plugin.nearby.a.mIG.b(null, this);
      AppMethodBeat.o(89890);
      return true;
    }
    if ("settings_signature".equals(paramf))
    {
      com.tencent.mm.plugin.nearby.a.mIG.bV(this);
      overridePendingTransition(b.a.push_up_in, b.a.push_empty_out);
      AppMethodBeat.o(89890);
      return true;
    }
    AppMethodBeat.o(89890);
    return false;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(89889);
    Object localObject2 = ca.bfn();
    Object localObject1 = ((ca)localObject2).getProvince();
    localObject2 = ((ca)localObject2).getCity();
    Preference localPreference = this.screen.byG("settings_district");
    localPreference.aF(aa.PL((String)localObject1) + " " + (String)localObject2);
    localPreference.setTitle(Html.fromHtml(getString(b.g.settings_district) + "<font color='red'>*</font>"));
    localPreference = this.screen.byG("settings_signature");
    localObject2 = Util.nullAsNil((String)h.aHG().aHp().b(12291, null));
    localObject1 = localObject2;
    if (((String)localObject2).length() <= 0) {
      localObject1 = getString(b.g.settings_signature_empty);
    }
    localPreference.aF(l.c(this, (CharSequence)localObject1));
    super.onResume();
    AppMethodBeat.o(89889);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI
 * JD-Core Version:    0.7.0.1
 */