package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

public class SettingsModifyUserAuthUI
  extends MMPreference
  implements com.tencent.mm.al.f
{
  private String appId;
  private p fNb;
  private int scene;
  private com.tencent.mm.ui.base.preference.h yId;
  
  public int getResourceId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74256);
    super.onCreate(paramBundle);
    this.yId = ((com.tencent.mm.ui.base.preference.h)getPreferenceScreen());
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
        localCheckBoxPreference.setTitle(localUserAuthItemParcelable.yDs);
        if (localUserAuthItemParcelable.scope.equals("snsapi_friend")) {
          localCheckBoxPreference.setSummary(2131763174);
        }
        localCheckBoxPreference.setKey(localUserAuthItemParcelable.scope);
        if (localUserAuthItemParcelable.state == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localCheckBoxPreference.oB = bool;
          localCheckBoxPreference.JtB = false;
          this.yId.a(localCheckBoxPreference, -1);
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
    g.aiU().b(1144, this);
    AppMethodBeat.o(74259);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(74260);
    if (((CheckBoxPreference)paramPreference).isChecked()) {}
    for (int i = 1;; i = 2)
    {
      paramf = new i(this.appId, paramPreference.mKey, i, this.scene);
      g.aiU().a(paramf, 0);
      this.fNb = com.tencent.mm.ui.base.h.b(this, getString(2131755886), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(74255);
          g.aiU().a(paramf);
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
    g.aiU().a(1144, this);
    AppMethodBeat.o(74258);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    boolean bool = true;
    AppMethodBeat.i(74257);
    ad.i("MicroMsg.SettingsModifyUserAuthUI", "errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if (this.fNb != null) {
      this.fNb.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((i)paramn).yCR;
      paramInt1 = ((i)paramn).yCS;
      if (!bt.isNullOrNil(paramString))
      {
        paramString = (CheckBoxPreference)this.yId.aVD(paramString);
        if (paramInt1 != 1) {
          break label106;
        }
      }
      for (;;)
      {
        paramString.oB = bool;
        AppMethodBeat.o(74257);
        return;
        label106:
        bool = false;
      }
    }
    com.tencent.mm.ui.base.h.cl(this, paramString);
    AppMethodBeat.o(74257);
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