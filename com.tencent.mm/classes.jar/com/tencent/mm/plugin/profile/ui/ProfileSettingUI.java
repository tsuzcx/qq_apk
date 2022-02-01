package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ProfileSettingUI
  extends MMPreference
  implements n.b
{
  private ai piT;
  private com.tencent.mm.plugin.profile.a.b vNi;
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(196017);
    if (((paramObject instanceof String)) && (this.piT.field_username.equals((String)paramObject)))
    {
      az.ayM();
      this.piT = c.awB().aNt((String)paramObject);
      if (this.piT != null)
      {
        this.vNi.piT = this.piT;
        initView();
      }
    }
    AppMethodBeat.o(196017);
  }
  
  public int getResourceId()
  {
    return 2131951767;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(196014);
    Preference localPreference = getPreferenceScreen().aPN("setting_remark");
    label66:
    int i;
    if (!w.xj(this.piT.field_username)) {
      if (ai.aNc(this.piT.field_username))
      {
        localPreference.setTitle(2131757927);
        localPreference.setSummary(k.c(this, this.piT.field_conRemark));
        localPreference = getPreferenceScreen().aPN("setting_permission");
        if ((com.tencent.mm.n.b.ln(this.piT.field_type)) || (!getIntent().getBooleanExtra("User_Verify", false))) {
          break label479;
        }
        i = 1;
        label106:
        if (i == 0)
        {
          if (ai.aNc(this.piT.field_username))
          {
            i = j;
            if (g.ZY().getInt("SnsWxWorkPermissionEntrance", 0) == 1) {
              i = 1;
            }
            if ((i == 0) || (!ai.aNc(this.piT.field_username)) || (!"3552365301".equals(this.piT.field_openImAppid))) {
              break label493;
            }
          }
          if ((w.xj(this.piT.field_username)) || (!com.tencent.mm.n.b.ln(this.piT.field_type))) {
            break label493;
          }
        }
        if (!"3552365301".equals(this.piT.field_openImAppid)) {
          break label484;
        }
        localPreference.setTitle(2131757748);
        label219:
        localPreference = getPreferenceScreen().aPN("setting_send_card");
        if ((!com.tencent.mm.n.b.ln(this.piT.field_type)) || (w.xj(this.piT.field_username))) {
          break label526;
        }
        i = 2131757812;
        if (this.piT.exL != 1) {
          break label509;
        }
        i = 2131757810;
        label274:
        localPreference.setTitle(i);
        label279:
        if ((com.tencent.mm.n.b.ln(this.piT.field_type)) && (!w.xj(this.piT.field_username))) {
          break label542;
        }
        getPreferenceScreen().cK("setting_star", true);
        label318:
        if (!w.xj(this.piT.field_username)) {
          break label569;
        }
        getPreferenceScreen().cK("setting_blacklist", true);
      }
    }
    for (;;)
    {
      if ((w.xj(this.piT.field_username)) || (!com.tencent.mm.n.b.ln(this.piT.field_type))) {
        getPreferenceScreen().cK("setting_report", true);
      }
      if (!com.tencent.mm.n.b.ln(this.piT.field_type)) {
        getPreferenceScreen().cK("setting_shortcut", true);
      }
      if ((!com.tencent.mm.n.b.ln(this.piT.field_type)) || (w.xj(this.piT.field_username))) {
        getPreferenceScreen().cK("setting_delete", true);
      }
      AppMethodBeat.o(196014);
      return;
      localPreference.setTitle(2131757731);
      break;
      getPreferenceScreen().cK("setting_remark", true);
      break label66;
      label479:
      i = 0;
      break label106;
      label484:
      localPreference.setTitle(2131761879);
      break label219;
      label493:
      getPreferenceScreen().cK("setting_permission", true);
      break label219;
      label509:
      if (this.piT.exL != 2) {
        break label274;
      }
      i = 2131757811;
      break label274;
      label526:
      getPreferenceScreen().cK("setting_send_card", true);
      break label279;
      label542:
      ((CheckBoxPreference)getPreferenceScreen().aPN("setting_star")).mF = this.piT.aaJ();
      break label318;
      label569:
      ((CheckBoxPreference)getPreferenceScreen().aPN("setting_blacklist")).mF = this.piT.aaH();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(196013);
    super.onCreate(paramBundle);
    paramBundle = bs.nullAsNil(getIntent().getStringExtra("Contact_User"));
    if (bs.isNullOrNil(paramBundle))
    {
      ac.e("MicroMsg.ProfileSettingUI", "username is null %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(196013);
      return;
    }
    az.ayM();
    this.piT = c.awB().aNt(paramBundle);
    this.vNi = new com.tencent.mm.plugin.profile.a.b(this, this.piT);
    setMMTitle(2131766376);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196012);
        ProfileSettingUI.this.finish();
        AppMethodBeat.o(196012);
        return true;
      }
    });
    initView();
    az.ayM();
    c.awB().a(this);
    AppMethodBeat.o(196013);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(196015);
    this.vNi.destroy();
    az.ayM();
    c.awB().b(this);
    super.onDestroy();
    AppMethodBeat.o(196015);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(196016);
    paramf = paramPreference.mKey;
    ac.i("MicroMsg.ProfileSettingUI", paramf + " item has been clicked!");
    if (paramf.equals("setting_remark"))
    {
      this.vNi.Ld(1);
      AppMethodBeat.o(196016);
      return true;
    }
    if (paramf.equals("setting_permission"))
    {
      this.vNi.Ld(3);
      AppMethodBeat.o(196016);
      return true;
    }
    if (paramf.equals("setting_send_card"))
    {
      this.vNi.Ld(4);
      AppMethodBeat.o(196016);
      return true;
    }
    if (paramf.equals("setting_shortcut"))
    {
      this.vNi.Ld(7);
      AppMethodBeat.o(196016);
      return true;
    }
    if (paramf.equals("setting_star"))
    {
      this.vNi.Ld(2);
      AppMethodBeat.o(196016);
      return true;
    }
    if (paramf.equals("setting_blacklist"))
    {
      this.vNi.Ld(5);
      AppMethodBeat.o(196016);
      return true;
    }
    if (paramf.equals("setting_report"))
    {
      this.vNi.Ld(9);
      AppMethodBeat.o(196016);
      return true;
    }
    if (paramf.equals("setting_delete"))
    {
      this.vNi.Ld(6);
      AppMethodBeat.o(196016);
      return true;
    }
    AppMethodBeat.o(196016);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ProfileSettingUI
 * JD-Core Version:    0.7.0.1
 */