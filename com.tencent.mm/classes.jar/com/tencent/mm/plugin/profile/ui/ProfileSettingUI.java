package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.k.i;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.profile.logic.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.List;

public class ProfileSettingUI
  extends MMPreference
  implements MStorageEx.IOnStorageChange
{
  private b Nad;
  private au xVS;
  
  public int getResourceId()
  {
    return R.o.hbm;
  }
  
  public void initView()
  {
    int j = 0;
    AppMethodBeat.i(305504);
    Object localObject = getPreferenceScreen().bAi("setting_remark");
    label67:
    int i;
    if (!au.bws(this.xVS.field_username)) {
      if (au.bwO(this.xVS.field_username))
      {
        ((Preference)localObject).setTitle(R.l.gDi);
        ((Preference)localObject).aS(p.b(this, this.xVS.field_conRemark));
        localObject = getPreferenceScreen().bAi("setting_permission");
        if ((d.rs(this.xVS.field_type)) || (!getIntent().getBooleanExtra("User_Verify", false))) {
          break label592;
        }
        i = 1;
        label107:
        if (i == 0)
        {
          if (au.bwO(this.xVS.field_username))
          {
            i = j;
            if (i.aRC().getInt("SnsWxWorkPermissionEntrance", 0) == 1) {
              i = 1;
            }
            if ((i == 0) || (!au.bwO(this.xVS.field_username)) || (!"3552365301".equals(this.xVS.field_openImAppid))) {
              break label607;
            }
          }
          if ((au.bws(this.xVS.field_username)) || (!d.rs(this.xVS.field_type))) {
            break label607;
          }
        }
        if (!"3552365301".equals(this.xVS.field_openImAppid)) {
          break label597;
        }
        ((Preference)localObject).setTitle(R.l.contact_info_op_sns_permission_openim);
        label221:
        localObject = getPreferenceScreen().bAi("setting_send_card");
        if ((!d.rs(this.xVS.field_type)) || (au.bws(this.xVS.field_username))) {
          break label641;
        }
        i = R.l.gCa;
        if (this.xVS.sex != 1) {
          break label623;
        }
        i = R.l.gBY;
        label278:
        ((Preference)localObject).setTitle(i);
        label283:
        if ((d.rs(this.xVS.field_type)) && (!au.bws(this.xVS.field_username))) {
          break label657;
        }
        getPreferenceScreen().eh("setting_star", true);
        label322:
        if (!au.bws(this.xVS.field_username)) {
          break label684;
        }
        getPreferenceScreen().eh("setting_blacklist", true);
      }
    }
    for (;;)
    {
      localObject = new ArrayList();
      ((List)localObject).add(Integer.valueOf(1));
      ((List)localObject).add(Integer.valueOf(2));
      ((List)localObject).add(Integer.valueOf(3));
      ((List)localObject).add(Integer.valueOf(10));
      ((List)localObject).add(Integer.valueOf(13));
      ((List)localObject).add(Integer.valueOf(15));
      ((List)localObject).add(Integer.valueOf(30));
      if ((au.bws(this.xVS.field_username)) || ((!d.rs(this.xVS.field_type)) && (((List)localObject).contains(Integer.valueOf(this.Nad.pUt))))) {
        getPreferenceScreen().eh("setting_report", true);
      }
      if (!d.rs(this.xVS.field_type)) {
        getPreferenceScreen().eh("setting_shortcut", true);
      }
      if ((!d.rs(this.xVS.field_type)) || (au.bws(this.xVS.field_username))) {
        getPreferenceScreen().eh("setting_delete", true);
      }
      AppMethodBeat.o(305504);
      return;
      ((Preference)localObject).setTitle(R.l.gBA);
      break;
      getPreferenceScreen().eh("setting_remark", true);
      break label67;
      label592:
      i = 0;
      break label107;
      label597:
      ((Preference)localObject).setTitle(R.l.gRp);
      break label221;
      label607:
      getPreferenceScreen().eh("setting_permission", true);
      break label221;
      label623:
      if (this.xVS.sex != 2) {
        break label278;
      }
      i = R.l.gBZ;
      break label278;
      label641:
      getPreferenceScreen().eh("setting_send_card", true);
      break label283;
      label657:
      ((CheckBoxPreference)getPreferenceScreen().bAi("setting_star")).setChecked(this.xVS.aSK());
      break label322;
      label684:
      ((CheckBoxPreference)getPreferenceScreen().bAi("setting_blacklist")).setChecked(this.xVS.aSF());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305501);
    super.onCreate(paramBundle);
    paramBundle = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    if (Util.isNullOrNil(paramBundle))
    {
      Log.e("MicroMsg.ProfileSettingUI", "username is null %s", new Object[] { paramBundle });
      finish();
      AppMethodBeat.o(305501);
      return;
    }
    bh.bCz();
    this.xVS = c.bzA().JE(paramBundle);
    this.Nad = new b(this, this.xVS);
    setMMTitle(R.l.gSy);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(305435);
        ProfileSettingUI.this.finish();
        AppMethodBeat.o(305435);
        return true;
      }
    });
    initView();
    bh.bCz();
    c.bzA().add(this);
    AppMethodBeat.o(305501);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(305507);
    this.Nad.destroy();
    bh.bCz();
    c.bzA().remove(this);
    super.onDestroy();
    AppMethodBeat.o(305507);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(305517);
    if (((paramObject instanceof String)) && (this.xVS.field_username.equals((String)paramObject)))
    {
      bh.bCz();
      this.xVS = c.bzA().JE((String)paramObject);
      if (this.xVS != null)
      {
        this.Nad.xVS = this.xVS;
        initView();
        getPreferenceScreen().notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(305517);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(305511);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.ProfileSettingUI", paramf + " item has been clicked!");
    if (paramf.equals("setting_remark"))
    {
      this.Nad.VB(1);
      AppMethodBeat.o(305511);
      return true;
    }
    if (paramf.equals("setting_permission"))
    {
      this.Nad.VB(3);
      AppMethodBeat.o(305511);
      return true;
    }
    if (paramf.equals("setting_send_card"))
    {
      this.Nad.VB(4);
      AppMethodBeat.o(305511);
      return true;
    }
    if (paramf.equals("setting_shortcut"))
    {
      this.Nad.VB(7);
      AppMethodBeat.o(305511);
      return true;
    }
    if (paramf.equals("setting_star"))
    {
      this.Nad.VB(2);
      AppMethodBeat.o(305511);
      return true;
    }
    if (paramf.equals("setting_blacklist"))
    {
      this.Nad.VB(5);
      AppMethodBeat.o(305511);
      return true;
    }
    if (paramf.equals("setting_report"))
    {
      this.Nad.VB(9);
      AppMethodBeat.o(305511);
      return true;
    }
    if (paramf.equals("setting_delete"))
    {
      this.Nad.VB(6);
      AppMethodBeat.o(305511);
      return true;
    }
    AppMethodBeat.o(305511);
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