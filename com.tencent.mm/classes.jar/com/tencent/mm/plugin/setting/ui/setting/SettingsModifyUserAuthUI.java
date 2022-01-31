package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

public class SettingsModifyUserAuthUI
  extends MMPreference
  implements com.tencent.mm.ai.f
{
  private String appId;
  private com.tencent.mm.ui.base.p efs;
  private com.tencent.mm.ui.base.preference.h qJg;
  private int scene;
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127319);
    super.onCreate(paramBundle);
    this.qJg = ((com.tencent.mm.ui.base.preference.h)getPreferenceScreen());
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
        localCheckBoxPreference.setTitle(localUserAuthItemParcelable.qFg);
        if (localUserAuthItemParcelable.scope.equals("snsapi_friend")) {
          localCheckBoxPreference.setSummary(2131303206);
        }
        localCheckBoxPreference.setKey(localUserAuthItemParcelable.scope);
        if (localUserAuthItemParcelable.state == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.vxW = bool;
          localCheckBoxPreference.zsk = false;
          this.qJg.a(localCheckBoxPreference, -1);
          break;
        }
      }
    }
    setMMTitle(getIntent().getStringExtra("app_name"));
    setBackBtn(new SettingsModifyUserAuthUI.1(this));
    AppMethodBeat.o(127319);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127322);
    super.onPause();
    g.Rc().b(1144, this);
    AppMethodBeat.o(127322);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(127323);
    if (((CheckBoxPreference)paramPreference).isChecked()) {}
    for (int i = 1;; i = 2)
    {
      paramf = new com.tencent.mm.plugin.setting.model.h(this.appId, paramPreference.mKey, i, this.scene);
      g.Rc().a(paramf, 0);
      this.efs = com.tencent.mm.ui.base.h.b(this, getString(2131297069), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(127318);
          g.Rc().a(paramf);
          AppMethodBeat.o(127318);
        }
      });
      AppMethodBeat.o(127323);
      return true;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(127321);
    super.onResume();
    g.Rc().a(1144, this);
    AppMethodBeat.o(127321);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = true;
    AppMethodBeat.i(127320);
    ab.i("MicroMsg.SettingsModifyUserAuthUI", "errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if (this.efs != null) {
      this.efs.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.setting.model.h)paramm).qEF;
      paramInt1 = ((com.tencent.mm.plugin.setting.model.h)paramm).qEG;
      if (!bo.isNullOrNil(paramString))
      {
        paramString = (CheckBoxPreference)this.qJg.atx(paramString);
        if (paramInt1 != 1) {
          break label106;
        }
      }
      for (;;)
      {
        paramString.vxW = bool;
        AppMethodBeat.o(127320);
        return;
        label106:
        bool = false;
      }
    }
    com.tencent.mm.ui.base.h.bO(this, paramString);
    AppMethodBeat.o(127320);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyUserAuthUI
 * JD-Core Version:    0.7.0.1
 */