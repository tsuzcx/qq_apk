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
import com.tencent.mm.model.bv;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.base.preference.f;

public class NearbyPersonalInfoUI
  extends MMPreference
{
  private int eQV = -1;
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
    ((KeyValuePreference)this.screen.aXe("settings_signature")).JNz = false;
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
          paramAnonymousMenuItem = bv.aCL();
          paramAnonymousMenuItem.eQV = NearbyPersonalInfoUI.a(NearbyPersonalInfoUI.this);
          bv.a(paramAnonymousMenuItem);
        }
        paramAnonymousMenuItem = bv.aCM();
        if (paramAnonymousMenuItem == null) {
          NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
        }
        for (;;)
        {
          AppMethodBeat.o(89884);
          return true;
          Object localObject = bu.nullAsNil(paramAnonymousMenuItem.getProvince());
          bu.nullAsNil(paramAnonymousMenuItem.getCity());
          int i = paramAnonymousMenuItem.eQV;
          if ((bu.isNullOrNil((String)localObject)) || (i == 0))
          {
            NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
          }
          else
          {
            paramAnonymousMenuItem = NearbyPersonalInfoUI.this;
            localObject = new Intent(NearbyPersonalInfoUI.this, NearbyFriendsUI.class);
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/nearby/ui/NearbyPersonalInfoUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/nearby/ui/NearbyPersonalInfoUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousMenuItem = bv.aCL();
            if (i != -1) {
              paramAnonymousMenuItem.eQV = i;
            }
            ((l)g.ab(l.class)).azE().d(new k.a(1, bv.a(paramAnonymousMenuItem)));
            NearbyPersonalInfoUI.this.finish();
          }
        }
      }
    });
    ((ChoicePreference)this.screen.aXe("settings_sex")).JMy = new Preference.a()
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
    int i = bu.a((Integer)g.ajR().ajA().get(12290, null), 0);
    ChoicePreference localChoicePreference = (ChoicePreference)this.screen.aXe("settings_sex");
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
      com.tencent.mm.plugin.nearby.a.iUz.b(null, this);
      AppMethodBeat.o(89890);
      return true;
    }
    if ("settings_signature".equals(paramf))
    {
      com.tencent.mm.plugin.nearby.a.iUz.bC(this);
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
    Object localObject2 = bv.aCL();
    Object localObject1 = ((bv)localObject2).getProvince();
    localObject2 = ((bv)localObject2).getCity();
    Preference localPreference = this.screen.aXe("settings_district");
    localPreference.setSummary(w.zR((String)localObject1) + " " + (String)localObject2);
    localPreference.setTitle(Html.fromHtml(getString(2131763207) + "<font color='red'>*</font>"));
    localPreference = this.screen.aXe("settings_signature");
    localObject2 = bu.nullAsNil((String)g.ajR().ajA().get(12291, null));
    localObject1 = localObject2;
    if (((String)localObject2).length() <= 0) {
      localObject1 = getString(2131763409);
    }
    localPreference.setSummary(k.c(this, (CharSequence)localObject1));
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