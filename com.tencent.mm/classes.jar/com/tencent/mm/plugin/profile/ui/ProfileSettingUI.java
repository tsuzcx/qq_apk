package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.w;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ProfileSettingUI
  extends MMPreference
  implements n.b
{
  private am pMt;
  private com.tencent.mm.plugin.profile.a.b wUr;
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(193265);
    if (((paramObject instanceof String)) && (this.pMt.field_username.equals((String)paramObject)))
    {
      ba.aBQ();
      this.pMt = c.azp().Bf((String)paramObject);
      if (this.pMt != null)
      {
        this.wUr.pMt = this.pMt;
        initView();
        getPreferenceScreen().notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(193265);
  }
  
  public int getResourceId()
  {
    return 2131951767;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(193262);
    Preference localPreference = getPreferenceScreen().aVD("setting_remark");
    label66:
    int i;
    if (!w.Ag(this.pMt.field_username)) {
      if (am.aSQ(this.pMt.field_username))
      {
        localPreference.setTitle(2131757927);
        localPreference.setSummary(k.c(this, this.pMt.field_conRemark));
        localPreference = getPreferenceScreen().aVD("setting_permission");
        if ((com.tencent.mm.o.b.lM(this.pMt.field_type)) || (!getIntent().getBooleanExtra("User_Verify", false))) {
          break label479;
        }
        i = 1;
        label106:
        if (i == 0)
        {
          if (am.aSQ(this.pMt.field_username))
          {
            i = j;
            if (g.acA().getInt("SnsWxWorkPermissionEntrance", 0) == 1) {
              i = 1;
            }
            if ((i == 0) || (!am.aSQ(this.pMt.field_username)) || (!"3552365301".equals(this.pMt.field_openImAppid))) {
              break label493;
            }
          }
          if ((w.Ag(this.pMt.field_username)) || (!com.tencent.mm.o.b.lM(this.pMt.field_type))) {
            break label493;
          }
        }
        if (!"3552365301".equals(this.pMt.field_openImAppid)) {
          break label484;
        }
        localPreference.setTitle(2131757748);
        label219:
        localPreference = getPreferenceScreen().aVD("setting_send_card");
        if ((!com.tencent.mm.o.b.lM(this.pMt.field_type)) || (w.Ag(this.pMt.field_username))) {
          break label526;
        }
        i = 2131757812;
        if (this.pMt.ePk != 1) {
          break label509;
        }
        i = 2131757810;
        label274:
        localPreference.setTitle(i);
        label279:
        if ((com.tencent.mm.o.b.lM(this.pMt.field_type)) && (!w.Ag(this.pMt.field_username))) {
          break label542;
        }
        getPreferenceScreen().cP("setting_star", true);
        label318:
        if (!w.Ag(this.pMt.field_username)) {
          break label569;
        }
        getPreferenceScreen().cP("setting_blacklist", true);
      }
    }
    for (;;)
    {
      if ((w.Ag(this.pMt.field_username)) || (!com.tencent.mm.o.b.lM(this.pMt.field_type))) {
        getPreferenceScreen().cP("setting_report", true);
      }
      if (!com.tencent.mm.o.b.lM(this.pMt.field_type)) {
        getPreferenceScreen().cP("setting_shortcut", true);
      }
      if ((!com.tencent.mm.o.b.lM(this.pMt.field_type)) || (w.Ag(this.pMt.field_username))) {
        getPreferenceScreen().cP("setting_delete", true);
      }
      AppMethodBeat.o(193262);
      return;
      localPreference.setTitle(2131757731);
      break;
      getPreferenceScreen().cP("setting_remark", true);
      break label66;
      label479:
      i = 0;
      break label106;
      label484:
      localPreference.setTitle(2131761879);
      break label219;
      label493:
      getPreferenceScreen().cP("setting_permission", true);
      break label219;
      label509:
      if (this.pMt.ePk != 2) {
        break label274;
      }
      i = 2131757811;
      break label274;
      label526:
      getPreferenceScreen().cP("setting_send_card", true);
      break label279;
      label542:
      ((CheckBoxPreference)getPreferenceScreen().aVD("setting_star")).oB = this.pMt.adm();
      break label318;
      label569:
      ((CheckBoxPreference)getPreferenceScreen().aVD("setting_blacklist")).oB = this.pMt.adk();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193261);
    super.onCreate(paramBundle);
    paramBundle = bt.nullAsNil(getIntent().getStringExtra("Contact_User"));
    if (bt.isNullOrNil(paramBundle))
    {
      ad.e("MicroMsg.ProfileSettingUI", "username is null %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(193261);
      return;
    }
    ba.aBQ();
    this.pMt = c.azp().Bf(paramBundle);
    this.wUr = new com.tencent.mm.plugin.profile.a.b(this, this.pMt);
    setMMTitle(2131766376);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(193260);
        ProfileSettingUI.this.finish();
        AppMethodBeat.o(193260);
        return true;
      }
    });
    initView();
    ba.aBQ();
    c.azp().a(this);
    AppMethodBeat.o(193261);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193263);
    this.wUr.destroy();
    ba.aBQ();
    c.azp().b(this);
    super.onDestroy();
    AppMethodBeat.o(193263);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(193264);
    paramf = paramPreference.mKey;
    ad.i("MicroMsg.ProfileSettingUI", paramf + " item has been clicked!");
    if (paramf.equals("setting_remark"))
    {
      this.wUr.Fq(1);
      AppMethodBeat.o(193264);
      return true;
    }
    if (paramf.equals("setting_permission"))
    {
      this.wUr.Fq(3);
      AppMethodBeat.o(193264);
      return true;
    }
    if (paramf.equals("setting_send_card"))
    {
      this.wUr.Fq(4);
      AppMethodBeat.o(193264);
      return true;
    }
    if (paramf.equals("setting_shortcut"))
    {
      this.wUr.Fq(7);
      AppMethodBeat.o(193264);
      return true;
    }
    if (paramf.equals("setting_star"))
    {
      this.wUr.Fq(2);
      AppMethodBeat.o(193264);
      return true;
    }
    if (paramf.equals("setting_blacklist"))
    {
      this.wUr.Fq(5);
      AppMethodBeat.o(193264);
      return true;
    }
    if (paramf.equals("setting_report"))
    {
      this.wUr.Fq(9);
      AppMethodBeat.o(193264);
      return true;
    }
    if (paramf.equals("setting_delete"))
    {
      this.wUr.Fq(6);
      AppMethodBeat.o(193264);
      return true;
    }
    AppMethodBeat.o(193264);
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