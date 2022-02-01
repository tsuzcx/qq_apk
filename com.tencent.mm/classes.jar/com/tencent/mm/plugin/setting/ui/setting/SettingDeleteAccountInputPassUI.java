package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountInputPassUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return b.g.setting_delete_account_input_pass;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73999);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73996);
        SettingDeleteAccountInputPassUI.this.hideVKB();
        SettingDeleteAccountInputPassUI.this.finish();
        AppMethodBeat.o(73996);
        return true;
      }
    });
    addTextOptionMenu(0, getString(b.i.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73997);
        SettingDeleteAccountInputPassUI.this.hideVKB();
        paramAnonymousMenuItem = SettingDeleteAccountInputPassUI.this;
        Object localObject = new Intent(SettingDeleteAccountInputPassUI.this, SettingDeleteAccountUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountInputPassUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountInputPassUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(73997);
        return true;
      }
    });
    AppMethodBeat.o(73999);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73998);
    super.onCreate(paramBundle);
    setMMTitle(b.i.setting_del_account_title);
    initView();
    AppMethodBeat.o(73998);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountInputPassUI
 * JD-Core Version:    0.7.0.1
 */