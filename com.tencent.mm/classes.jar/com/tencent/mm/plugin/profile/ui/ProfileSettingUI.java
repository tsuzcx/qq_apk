package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;

public class ProfileSettingUI
  extends MMPreference
  implements MStorageEx.IOnStorageChange
{
  private b Bif;
  private as rjX;
  
  public int getResourceId()
  {
    return 2132017248;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(231895);
    Preference localPreference = getPreferenceScreen().bmg("setting_remark");
    label66:
    int i;
    if (!ab.Jv(this.rjX.field_username)) {
      if (as.bjp(this.rjX.field_username))
      {
        localPreference.setTitle(2131758167);
        localPreference.setSummary(l.c(this, this.rjX.field_conRemark));
        localPreference = getPreferenceScreen().bmg("setting_permission");
        if ((com.tencent.mm.contact.c.oR(this.rjX.field_type)) || (!getIntent().getBooleanExtra("User_Verify", false))) {
          break label479;
        }
        i = 1;
        label106:
        if (i == 0)
        {
          if (as.bjp(this.rjX.field_username))
          {
            i = j;
            if (h.aqJ().getInt("SnsWxWorkPermissionEntrance", 0) == 1) {
              i = 1;
            }
            if ((i == 0) || (!as.bjp(this.rjX.field_username)) || (!"3552365301".equals(this.rjX.field_openImAppid))) {
              break label493;
            }
          }
          if ((ab.Jv(this.rjX.field_username)) || (!com.tencent.mm.contact.c.oR(this.rjX.field_type))) {
            break label493;
          }
        }
        if (!"3552365301".equals(this.rjX.field_openImAppid)) {
          break label484;
        }
        localPreference.setTitle(2131757985);
        label219:
        localPreference = getPreferenceScreen().bmg("setting_send_card");
        if ((!com.tencent.mm.contact.c.oR(this.rjX.field_type)) || (ab.Jv(this.rjX.field_username))) {
          break label526;
        }
        i = 2131758052;
        if (this.rjX.fuA != 1) {
          break label509;
        }
        i = 2131758050;
        label274:
        localPreference.setTitle(i);
        label279:
        if ((com.tencent.mm.contact.c.oR(this.rjX.field_type)) && (!ab.Jv(this.rjX.field_username))) {
          break label542;
        }
        getPreferenceScreen().jdMethod_do("setting_star", true);
        label318:
        if (!ab.Jv(this.rjX.field_username)) {
          break label569;
        }
        getPreferenceScreen().jdMethod_do("setting_blacklist", true);
      }
    }
    for (;;)
    {
      if ((ab.Jv(this.rjX.field_username)) || (!com.tencent.mm.contact.c.oR(this.rjX.field_type))) {
        getPreferenceScreen().jdMethod_do("setting_report", true);
      }
      if (!com.tencent.mm.contact.c.oR(this.rjX.field_type)) {
        getPreferenceScreen().jdMethod_do("setting_shortcut", true);
      }
      if ((!com.tencent.mm.contact.c.oR(this.rjX.field_type)) || (ab.Jv(this.rjX.field_username))) {
        getPreferenceScreen().jdMethod_do("setting_delete", true);
      }
      AppMethodBeat.o(231895);
      return;
      localPreference.setTitle(2131757968);
      break;
      getPreferenceScreen().jdMethod_do("setting_remark", true);
      break label66;
      label479:
      i = 0;
      break label106;
      label484:
      localPreference.setTitle(2131763884);
      break label219;
      label493:
      getPreferenceScreen().jdMethod_do("setting_permission", true);
      break label219;
      label509:
      if (this.rjX.fuA != 2) {
        break label274;
      }
      i = 2131758051;
      break label274;
      label526:
      getPreferenceScreen().jdMethod_do("setting_send_card", true);
      break label279;
      label542:
      ((CheckBoxPreference)getPreferenceScreen().bmg("setting_star")).setChecked(this.rjX.arA());
      break label318;
      label569:
      ((CheckBoxPreference)getPreferenceScreen().bmg("setting_blacklist")).setChecked(this.rjX.ary());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(231894);
    super.onCreate(paramBundle);
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    if (Util.isNullOrNil(paramBundle))
    {
      Log.e("MicroMsg.ProfileSettingUI", "username is null %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(231894);
      return;
    }
    bg.aVF();
    this.rjX = com.tencent.mm.model.c.aSN().Kn(paramBundle);
    this.Bif = new b(this, this.rjX);
    setMMTitle(2131764068);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(231893);
        ProfileSettingUI.this.finish();
        AppMethodBeat.o(231893);
        return true;
      }
    });
    initView();
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this);
    AppMethodBeat.o(231894);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(231896);
    this.Bif.destroy();
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this);
    super.onDestroy();
    AppMethodBeat.o(231896);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(231898);
    if (((paramObject instanceof String)) && (this.rjX.field_username.equals((String)paramObject)))
    {
      bg.aVF();
      this.rjX = com.tencent.mm.model.c.aSN().Kn((String)paramObject);
      if (this.rjX != null)
      {
        this.Bif.rjX = this.rjX;
        initView();
        getPreferenceScreen().notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(231898);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(231897);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.ProfileSettingUI", paramf + " item has been clicked!");
    if (paramf.equals("setting_remark"))
    {
      this.Bif.Lc(1);
      AppMethodBeat.o(231897);
      return true;
    }
    if (paramf.equals("setting_permission"))
    {
      this.Bif.Lc(3);
      AppMethodBeat.o(231897);
      return true;
    }
    if (paramf.equals("setting_send_card"))
    {
      this.Bif.Lc(4);
      AppMethodBeat.o(231897);
      return true;
    }
    if (paramf.equals("setting_shortcut"))
    {
      this.Bif.Lc(7);
      AppMethodBeat.o(231897);
      return true;
    }
    if (paramf.equals("setting_star"))
    {
      this.Bif.Lc(2);
      AppMethodBeat.o(231897);
      return true;
    }
    if (paramf.equals("setting_blacklist"))
    {
      this.Bif.Lc(5);
      AppMethodBeat.o(231897);
      return true;
    }
    if (paramf.equals("setting_report"))
    {
      this.Bif.Lc(9);
      AppMethodBeat.o(231897);
      return true;
    }
    if (paramf.equals("setting_delete"))
    {
      this.Bif.Lc(6);
      AppMethodBeat.o(231897);
      return true;
    }
    AppMethodBeat.o(231897);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileSettingUI
 * JD-Core Version:    0.7.0.1
 */