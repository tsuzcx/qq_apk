package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

public class SettingsModifyUserAuthUI
  extends MMPreference
  implements com.tencent.mm.ah.f
{
  private String appId;
  private com.tencent.mm.ui.base.p dnV;
  private com.tencent.mm.ui.base.preference.h nVb;
  private int scene;
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    if (((CheckBoxPreference)paramPreference).isChecked()) {}
    for (int i = 1;; i = 2)
    {
      paramf = new com.tencent.mm.plugin.setting.model.h(this.appId, paramPreference.mKey, i, this.scene);
      g.Dk().a(paramf, 0);
      this.dnV = com.tencent.mm.ui.base.h.b(this, getString(a.i.app_sending), true, new SettingsModifyUserAuthUI.2(this, paramf));
      return true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nVb = ((com.tencent.mm.ui.base.preference.h)this.vdd);
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
        localCheckBoxPreference.setTitle(localUserAuthItemParcelable.nRj);
        if (localUserAuthItemParcelable.scope.equals("snsapi_friend")) {
          localCheckBoxPreference.setSummary(a.i.settings_auth_close_friend_tip);
        }
        localCheckBoxPreference.setKey(localUserAuthItemParcelable.scope);
        if (localUserAuthItemParcelable.state == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.rHo = bool;
          localCheckBoxPreference.vdK = false;
          this.nVb.a(localCheckBoxPreference, -1);
          break;
        }
      }
    }
    setMMTitle(getIntent().getStringExtra("app_name"));
    setBackBtn(new SettingsModifyUserAuthUI.1(this));
  }
  
  protected void onPause()
  {
    super.onPause();
    g.Dk().b(1144, this);
  }
  
  protected void onResume()
  {
    super.onResume();
    g.Dk().a(1144, this);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = true;
    y.i("MicroMsg.SettingsModifyUserAuthUI", "errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if (this.dnV != null) {
      this.dnV.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.setting.model.h)paramm).nQI;
      paramInt1 = ((com.tencent.mm.plugin.setting.model.h)paramm).nQJ;
      if (!bk.bl(paramString))
      {
        paramString = (CheckBoxPreference)this.nVb.add(paramString);
        if (paramInt1 != 1) {
          break label96;
        }
      }
      for (;;)
      {
        paramString.rHo = bool;
        return;
        label96:
        bool = false;
      }
    }
    com.tencent.mm.ui.base.h.bC(this, paramString);
  }
  
  public final int xj()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyUserAuthUI
 * JD-Core Version:    0.7.0.1
 */