package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ProfileSettingUI
  extends MMPreference
  implements n.b
{
  private an pSY;
  private b xki;
  
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(186539);
    if (((paramObject instanceof String)) && (this.pSY.field_username.equals((String)paramObject)))
    {
      bc.aCg();
      this.pSY = com.tencent.mm.model.c.azF().BH((String)paramObject);
      if (this.pSY != null)
      {
        this.xki.pSY = this.pSY;
        initView();
        getPreferenceScreen().notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(186539);
  }
  
  public int getResourceId()
  {
    return 2131951767;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(186536);
    Preference localPreference = getPreferenceScreen().aXe("setting_remark");
    label66:
    int i;
    if (!x.AQ(this.pSY.field_username)) {
      if (an.aUq(this.pSY.field_username))
      {
        localPreference.setTitle(2131757927);
        localPreference.setSummary(k.c(this, this.pSY.field_conRemark));
        localPreference = getPreferenceScreen().aXe("setting_permission");
        if ((com.tencent.mm.contact.c.lO(this.pSY.field_type)) || (!getIntent().getBooleanExtra("User_Verify", false))) {
          break label479;
        }
        i = 1;
        label106:
        if (i == 0)
        {
          if (an.aUq(this.pSY.field_username))
          {
            i = j;
            if (g.acL().getInt("SnsWxWorkPermissionEntrance", 0) == 1) {
              i = 1;
            }
            if ((i == 0) || (!an.aUq(this.pSY.field_username)) || (!"3552365301".equals(this.pSY.field_openImAppid))) {
              break label493;
            }
          }
          if ((x.AQ(this.pSY.field_username)) || (!com.tencent.mm.contact.c.lO(this.pSY.field_type))) {
            break label493;
          }
        }
        if (!"3552365301".equals(this.pSY.field_openImAppid)) {
          break label484;
        }
        localPreference.setTitle(2131757748);
        label219:
        localPreference = getPreferenceScreen().aXe("setting_send_card");
        if ((!com.tencent.mm.contact.c.lO(this.pSY.field_type)) || (x.AQ(this.pSY.field_username))) {
          break label526;
        }
        i = 2131757812;
        if (this.pSY.eQV != 1) {
          break label509;
        }
        i = 2131757810;
        label274:
        localPreference.setTitle(i);
        label279:
        if ((com.tencent.mm.contact.c.lO(this.pSY.field_type)) && (!x.AQ(this.pSY.field_username))) {
          break label542;
        }
        getPreferenceScreen().cT("setting_star", true);
        label318:
        if (!x.AQ(this.pSY.field_username)) {
          break label569;
        }
        getPreferenceScreen().cT("setting_blacklist", true);
      }
    }
    for (;;)
    {
      if ((x.AQ(this.pSY.field_username)) || (!com.tencent.mm.contact.c.lO(this.pSY.field_type))) {
        getPreferenceScreen().cT("setting_report", true);
      }
      if (!com.tencent.mm.contact.c.lO(this.pSY.field_type)) {
        getPreferenceScreen().cT("setting_shortcut", true);
      }
      if ((!com.tencent.mm.contact.c.lO(this.pSY.field_type)) || (x.AQ(this.pSY.field_username))) {
        getPreferenceScreen().cT("setting_delete", true);
      }
      AppMethodBeat.o(186536);
      return;
      localPreference.setTitle(2131757731);
      break;
      getPreferenceScreen().cT("setting_remark", true);
      break label66;
      label479:
      i = 0;
      break label106;
      label484:
      localPreference.setTitle(2131761879);
      break label219;
      label493:
      getPreferenceScreen().cT("setting_permission", true);
      break label219;
      label509:
      if (this.pSY.eQV != 2) {
        break label274;
      }
      i = 2131757811;
      break label274;
      label526:
      getPreferenceScreen().cT("setting_send_card", true);
      break label279;
      label542:
      ((CheckBoxPreference)getPreferenceScreen().aXe("setting_star")).setChecked(this.pSY.adx());
      break label318;
      label569:
      ((CheckBoxPreference)getPreferenceScreen().aXe("setting_blacklist")).setChecked(this.pSY.adv());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186535);
    super.onCreate(paramBundle);
    paramBundle = bu.nullAsNil(getIntent().getStringExtra("Contact_User"));
    if (bu.isNullOrNil(paramBundle))
    {
      ae.e("MicroMsg.ProfileSettingUI", "username is null %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(186535);
      return;
    }
    bc.aCg();
    this.pSY = com.tencent.mm.model.c.azF().BH(paramBundle);
    this.xki = new b(this, this.pSY);
    setMMTitle(2131766376);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(186534);
        ProfileSettingUI.this.finish();
        AppMethodBeat.o(186534);
        return true;
      }
    });
    initView();
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this);
    AppMethodBeat.o(186535);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186537);
    this.xki.destroy();
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this);
    super.onDestroy();
    AppMethodBeat.o(186537);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(186538);
    paramf = paramPreference.mKey;
    ae.i("MicroMsg.ProfileSettingUI", paramf + " item has been clicked!");
    if (paramf.equals("setting_remark"))
    {
      this.xki.FN(1);
      AppMethodBeat.o(186538);
      return true;
    }
    if (paramf.equals("setting_permission"))
    {
      this.xki.FN(3);
      AppMethodBeat.o(186538);
      return true;
    }
    if (paramf.equals("setting_send_card"))
    {
      this.xki.FN(4);
      AppMethodBeat.o(186538);
      return true;
    }
    if (paramf.equals("setting_shortcut"))
    {
      this.xki.FN(7);
      AppMethodBeat.o(186538);
      return true;
    }
    if (paramf.equals("setting_star"))
    {
      this.xki.FN(2);
      AppMethodBeat.o(186538);
      return true;
    }
    if (paramf.equals("setting_blacklist"))
    {
      this.xki.FN(5);
      AppMethodBeat.o(186538);
      return true;
    }
    if (paramf.equals("setting_report"))
    {
      this.xki.FN(9);
      AppMethodBeat.o(186538);
      return true;
    }
    if (paramf.equals("setting_delete"))
    {
      this.xki.FN(6);
      AppMethodBeat.o(186538);
      return true;
    }
    AppMethodBeat.o(186538);
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