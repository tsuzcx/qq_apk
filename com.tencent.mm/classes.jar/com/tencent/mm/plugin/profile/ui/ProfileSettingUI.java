package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
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
  private b HbV;
  private as uNk;
  
  public int getResourceId()
  {
    return R.o.eXL;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(291425);
    Preference localPreference = getPreferenceScreen().byG("setting_remark");
    label67:
    int i;
    if (!ab.QO(this.uNk.field_username)) {
      if (as.bvK(this.uNk.field_username))
      {
        localPreference.setTitle(R.l.eAq);
        localPreference.aF(l.c(this, this.uNk.field_conRemark));
        localPreference = getPreferenceScreen().byG("setting_permission");
        if ((d.rk(this.uNk.field_type)) || (!getIntent().getBooleanExtra("User_Verify", false))) {
          break label471;
        }
        i = 1;
        label107:
        if (i == 0)
        {
          if (as.bvK(this.uNk.field_username))
          {
            i = j;
            if (h.axc().getInt("SnsWxWorkPermissionEntrance", 0) == 1) {
              i = 1;
            }
            if ((i == 0) || (!as.bvK(this.uNk.field_username)) || (!"3552365301".equals(this.uNk.field_openImAppid))) {
              break label486;
            }
          }
          if ((ab.QO(this.uNk.field_username)) || (!d.rk(this.uNk.field_type))) {
            break label486;
          }
        }
        if (!"3552365301".equals(this.uNk.field_openImAppid)) {
          break label476;
        }
        localPreference.setTitle(R.l.contact_info_op_sns_permission_openim);
        label221:
        localPreference = getPreferenceScreen().byG("setting_send_card");
        if ((!d.rk(this.uNk.field_type)) || (ab.QO(this.uNk.field_username))) {
          break label520;
        }
        i = R.l.ezl;
        if (this.uNk.sex != 1) {
          break label502;
        }
        i = R.l.ezj;
        label278:
        localPreference.setTitle(i);
        label283:
        if ((d.rk(this.uNk.field_type)) && (!ab.QO(this.uNk.field_username))) {
          break label536;
        }
        getPreferenceScreen().dz("setting_star", true);
        label322:
        if (!ab.QO(this.uNk.field_username)) {
          break label563;
        }
        getPreferenceScreen().dz("setting_blacklist", true);
      }
    }
    for (;;)
    {
      if (ab.QO(this.uNk.field_username)) {
        getPreferenceScreen().dz("setting_report", true);
      }
      if (!d.rk(this.uNk.field_type)) {
        getPreferenceScreen().dz("setting_shortcut", true);
      }
      if ((!d.rk(this.uNk.field_type)) || (ab.QO(this.uNk.field_username))) {
        getPreferenceScreen().dz("setting_delete", true);
      }
      AppMethodBeat.o(291425);
      return;
      localPreference.setTitle(R.l.eyI);
      break;
      getPreferenceScreen().dz("setting_remark", true);
      break label67;
      label471:
      i = 0;
      break label107;
      label476:
      localPreference.setTitle(R.l.eOO);
      break label221;
      label486:
      getPreferenceScreen().dz("setting_permission", true);
      break label221;
      label502:
      if (this.uNk.sex != 2) {
        break label278;
      }
      i = R.l.ezk;
      break label278;
      label520:
      getPreferenceScreen().dz("setting_send_card", true);
      break label283;
      label536:
      ((CheckBoxPreference)getPreferenceScreen().byG("setting_star")).setChecked(this.uNk.ayh());
      break label322;
      label563:
      ((CheckBoxPreference)getPreferenceScreen().byG("setting_blacklist")).setChecked(this.uNk.ayc());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291424);
    super.onCreate(paramBundle);
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    if (Util.isNullOrNil(paramBundle))
    {
      Log.e("MicroMsg.ProfileSettingUI", "username is null %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(291424);
      return;
    }
    bh.beI();
    this.uNk = c.bbL().RG(paramBundle);
    this.HbV = new b(this, this.uNk);
    setMMTitle(R.l.ePV);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(290095);
        ProfileSettingUI.this.finish();
        AppMethodBeat.o(290095);
        return true;
      }
    });
    initView();
    bh.beI();
    c.bbL().add(this);
    AppMethodBeat.o(291424);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(291426);
    this.HbV.destroy();
    bh.beI();
    c.bbL().remove(this);
    super.onDestroy();
    AppMethodBeat.o(291426);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(291428);
    if (((paramObject instanceof String)) && (this.uNk.field_username.equals((String)paramObject)))
    {
      bh.beI();
      this.uNk = c.bbL().RG((String)paramObject);
      if (this.uNk != null)
      {
        this.HbV.uNk = this.uNk;
        initView();
        getPreferenceScreen().notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(291428);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(291427);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.ProfileSettingUI", paramf + " item has been clicked!");
    if (paramf.equals("setting_remark"))
    {
      this.HbV.Si(1);
      AppMethodBeat.o(291427);
      return true;
    }
    if (paramf.equals("setting_permission"))
    {
      this.HbV.Si(3);
      AppMethodBeat.o(291427);
      return true;
    }
    if (paramf.equals("setting_send_card"))
    {
      this.HbV.Si(4);
      AppMethodBeat.o(291427);
      return true;
    }
    if (paramf.equals("setting_shortcut"))
    {
      this.HbV.Si(7);
      AppMethodBeat.o(291427);
      return true;
    }
    if (paramf.equals("setting_star"))
    {
      this.HbV.Si(2);
      AppMethodBeat.o(291427);
      return true;
    }
    if (paramf.equals("setting_blacklist"))
    {
      this.HbV.Si(5);
      AppMethodBeat.o(291427);
      return true;
    }
    if (paramf.equals("setting_report"))
    {
      this.HbV.Si(9);
      AppMethodBeat.o(291427);
      return true;
    }
    if (paramf.equals("setting_delete"))
    {
      this.HbV.Si(6);
      AppMethodBeat.o(291427);
      return true;
    }
    AppMethodBeat.o(291427);
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