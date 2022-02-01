package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ProfileSettingUI
  extends MMPreference
  implements n.b
{
  private af oFt;
  private com.tencent.mm.plugin.profile.a.b uEr;
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(191196);
    if (((paramObject instanceof String)) && (this.oFt.field_username.equals((String)paramObject)))
    {
      az.arV();
      this.oFt = c.apM().aHY((String)paramObject);
      if (this.oFt != null)
      {
        this.uEr.oFt = this.oFt;
        initView();
      }
    }
    AppMethodBeat.o(191196);
  }
  
  public int getResourceId()
  {
    return 2131951767;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(191193);
    Preference localPreference = getPreferenceScreen().aKk("setting_remark");
    label66:
    int i;
    if (!w.tg(this.oFt.field_username)) {
      if (af.aHH(this.oFt.field_username))
      {
        localPreference.setTitle(2131757927);
        localPreference.setSummary(k.c(this, this.oFt.field_conRemark));
        localPreference = getPreferenceScreen().aKk("setting_permission");
        if ((com.tencent.mm.n.b.ls(this.oFt.field_type)) || (!getIntent().getBooleanExtra("User_Verify", false))) {
          break label479;
        }
        i = 1;
        label106:
        if (i == 0)
        {
          if (af.aHH(this.oFt.field_username))
          {
            i = j;
            if (g.Zd().getInt("SnsWxWorkPermissionEntrance", 0) == 1) {
              i = 1;
            }
            if ((i == 0) || (!af.aHH(this.oFt.field_username)) || (!"3552365301".equals(this.oFt.field_openImAppid))) {
              break label493;
            }
          }
          if ((w.tg(this.oFt.field_username)) || (!com.tencent.mm.n.b.ls(this.oFt.field_type))) {
            break label493;
          }
        }
        if (!"3552365301".equals(this.oFt.field_openImAppid)) {
          break label484;
        }
        localPreference.setTitle(2131757748);
        label219:
        localPreference = getPreferenceScreen().aKk("setting_send_card");
        if ((!com.tencent.mm.n.b.ls(this.oFt.field_type)) || (w.tg(this.oFt.field_username))) {
          break label526;
        }
        i = 2131757812;
        if (this.oFt.evp != 1) {
          break label509;
        }
        i = 2131757810;
        label274:
        localPreference.setTitle(i);
        label279:
        if ((com.tencent.mm.n.b.ls(this.oFt.field_type)) && (!w.tg(this.oFt.field_username))) {
          break label542;
        }
        getPreferenceScreen().cE("setting_star", true);
        label318:
        if (!w.tg(this.oFt.field_username)) {
          break label569;
        }
        getPreferenceScreen().cE("setting_blacklist", true);
      }
    }
    for (;;)
    {
      if ((w.tg(this.oFt.field_username)) || (!com.tencent.mm.n.b.ls(this.oFt.field_type))) {
        getPreferenceScreen().cE("setting_report", true);
      }
      if (!com.tencent.mm.n.b.ls(this.oFt.field_type)) {
        getPreferenceScreen().cE("setting_shortcut", true);
      }
      if ((!com.tencent.mm.n.b.ls(this.oFt.field_type)) || (w.tg(this.oFt.field_username))) {
        getPreferenceScreen().cE("setting_delete", true);
      }
      AppMethodBeat.o(191193);
      return;
      localPreference.setTitle(2131757731);
      break;
      getPreferenceScreen().cE("setting_remark", true);
      break label66;
      label479:
      i = 0;
      break label106;
      label484:
      localPreference.setTitle(2131761879);
      break label219;
      label493:
      getPreferenceScreen().cE("setting_permission", true);
      break label219;
      label509:
      if (this.oFt.evp != 2) {
        break label274;
      }
      i = 2131757811;
      break label274;
      label526:
      getPreferenceScreen().cE("setting_send_card", true);
      break label279;
      label542:
      ((CheckBoxPreference)getPreferenceScreen().aKk("setting_star")).lG = this.oFt.ZO();
      break label318;
      label569:
      ((CheckBoxPreference)getPreferenceScreen().aKk("setting_blacklist")).lG = this.oFt.ZM();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191192);
    super.onCreate(paramBundle);
    paramBundle = bt.nullAsNil(getIntent().getStringExtra("Contact_User"));
    az.arV();
    this.oFt = c.apM().aHY(paramBundle);
    this.uEr = new com.tencent.mm.plugin.profile.a.b(this, this.oFt);
    setMMTitle(2131766376);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191191);
        ProfileSettingUI.this.finish();
        AppMethodBeat.o(191191);
        return true;
      }
    });
    initView();
    az.arV();
    c.apM().a(this);
    AppMethodBeat.o(191192);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(191194);
    this.uEr.destroy();
    az.arV();
    c.apM().b(this);
    super.onDestroy();
    AppMethodBeat.o(191194);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(191195);
    paramf = paramPreference.mKey;
    ad.i("MicroMsg.ProfileSettingUI", paramf + " item has been clicked!");
    if (paramf.equals("setting_remark"))
    {
      this.uEr.Je(1);
      AppMethodBeat.o(191195);
      return true;
    }
    if (paramf.equals("setting_permission"))
    {
      this.uEr.Je(3);
      AppMethodBeat.o(191195);
      return true;
    }
    if (paramf.equals("setting_send_card"))
    {
      this.uEr.Je(4);
      AppMethodBeat.o(191195);
      return true;
    }
    if (paramf.equals("setting_shortcut"))
    {
      this.uEr.Je(7);
      AppMethodBeat.o(191195);
      return true;
    }
    if (paramf.equals("setting_star"))
    {
      this.uEr.Je(2);
      AppMethodBeat.o(191195);
      return true;
    }
    if (paramf.equals("setting_blacklist"))
    {
      this.uEr.Je(5);
      AppMethodBeat.o(191195);
      return true;
    }
    if (paramf.equals("setting_report"))
    {
      this.uEr.Je(9);
      AppMethodBeat.o(191195);
      return true;
    }
    if (paramf.equals("setting_delete"))
    {
      this.uEr.Je(6);
      AppMethodBeat.o(191195);
      return true;
    }
    AppMethodBeat.o(191195);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileSettingUI
 * JD-Core Version:    0.7.0.1
 */