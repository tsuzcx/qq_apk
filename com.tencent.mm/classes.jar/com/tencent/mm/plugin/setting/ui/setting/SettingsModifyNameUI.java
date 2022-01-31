package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class SettingsModifyNameUI
  extends MMActivity
  implements c.a
{
  private p dnV = null;
  private com.tencent.mm.sdk.b.c dpQ = new SettingsModifyNameUI.1(this);
  private MMEditText dpn;
  private i.b nRK;
  private boolean nRM = false;
  
  public final void eP(String paramString)
  {
    y.i("MiroMsg.SettingsModifyNameUI", "Set New NickName : " + paramString);
    this.nRM = true;
    AppCompatActivity localAppCompatActivity = this.mController.uMN;
    getString(a.i.app_tip);
    this.dnV = h.b(localAppCompatActivity, getString(a.i.contact_info_change_remarkimage_save), false, null);
    this.nRK = q.n(2, paramString);
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_modify_name;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.settings_modify_name);
    this.dpn = ((MMEditText)findViewById(a.f.settings_modify_name_new_name_et));
    this.dpn.setText(j.a(this, (String)g.DP().Dz().get(4, null), this.dpn.getTextSize()));
    this.dpn.setSelection(this.dpn.getText().length());
    this.dpn.addTextChangedListener(new SettingsModifyNameUI.2(this));
    com.tencent.mm.ui.tools.a.c localc = com.tencent.mm.ui.tools.a.c.d(this.dpn).fJ(1, 32);
    localc.wfM = false;
    localc.a(null);
    a(0, getString(a.i.app_save), new SettingsModifyNameUI.3(this), s.b.uNx);
    enableOptionMenu(false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        SettingsModifyNameUI.this.XM();
        SettingsModifyNameUI.this.finish();
        return true;
      }
    });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a.udP.c(this.dpQ);
    initView();
  }
  
  protected void onDestroy()
  {
    a.udP.d(this.dpQ);
    super.onDestroy();
  }
  
  public final void xB()
  {
    h.h(this, a.i.settings_modify_name_invalid_less, a.i.settings_modify_name_title);
  }
  
  public final void xC()
  {
    h.h(this, a.i.settings_modify_name_invalid_more, a.i.settings_modify_name_title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI
 * JD-Core Version:    0.7.0.1
 */