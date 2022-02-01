package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.List;

public class SettingsModifyUserAuthUI
  extends MMPreference
  implements com.tencent.mm.am.h
{
  private com.tencent.mm.ui.base.preference.h PuN;
  private String appId;
  private w psR;
  private int scene;
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74256);
    super.onCreate(paramBundle);
    this.PuN = ((com.tencent.mm.ui.base.preference.h)getPreferenceScreen());
    paramBundle = getIntent().getParcelableArrayListExtra("app_auth_items");
    this.appId = getIntent().getStringExtra("app_id");
    this.scene = getIntent().getIntExtra("modify_scene", 1);
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramBundle = paramBundle.iterator();
      if (paramBundle.hasNext())
      {
        UserAuthItemParcelable localUserAuthItemParcelable = (UserAuthItemParcelable)paramBundle.next();
        CheckBoxPreference localCheckBoxPreference = new CheckBoxPreference(this);
        localCheckBoxPreference.setTitle(localUserAuthItemParcelable.Poo);
        if (localUserAuthItemParcelable.scope.equals("snsapi_friend")) {
          localCheckBoxPreference.aBk(b.i.settings_auth_close_friend_tip);
        }
        localCheckBoxPreference.setKey(localUserAuthItemParcelable.scope);
        if (localUserAuthItemParcelable.state == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.setChecked(bool);
          localCheckBoxPreference.adZV = false;
          this.PuN.a(localCheckBoxPreference, -1);
          break;
        }
      }
    }
    setMMTitle(getIntent().getStringExtra("app_name"));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74254);
        SettingsModifyUserAuthUI.this.finish();
        AppMethodBeat.o(74254);
        return true;
      }
    });
    AppMethodBeat.o(74256);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74259);
    super.onPause();
    com.tencent.mm.kernel.h.aZW().b(1144, this);
    AppMethodBeat.o(74259);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74260);
    if (((CheckBoxPreference)paramPreference).isChecked()) {}
    for (int i = 1;; i = 2)
    {
      paramf = new m(this.appId, paramPreference.mKey, i, this.scene);
      com.tencent.mm.kernel.h.aZW().a(paramf, 0);
      this.psR = k.a(this, getString(b.i.app_sending), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(74255);
          com.tencent.mm.kernel.h.aZW().a(paramf);
          AppMethodBeat.o(74255);
        }
      });
      AppMethodBeat.o(74260);
      return true;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74258);
    super.onResume();
    com.tencent.mm.kernel.h.aZW().a(1144, this);
    AppMethodBeat.o(74258);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    boolean bool = true;
    AppMethodBeat.i(74257);
    Log.i("MicroMsg.SettingsModifyUserAuthUI", "errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if (this.psR != null) {
      this.psR.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((m)paramp).PnJ;
      paramInt1 = ((m)paramp).PnK;
      if (!Util.isNullOrNil(paramString))
      {
        paramString = (CheckBoxPreference)this.PuN.bAi(paramString);
        if (paramInt1 != 1) {
          break label106;
        }
      }
      for (;;)
      {
        paramString.setChecked(bool);
        AppMethodBeat.o(74257);
        return;
        label106:
        bool = false;
      }
    }
    k.cZ(this, paramString);
    AppMethodBeat.o(74257);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyUserAuthUI
 * JD-Core Version:    0.7.0.1
 */