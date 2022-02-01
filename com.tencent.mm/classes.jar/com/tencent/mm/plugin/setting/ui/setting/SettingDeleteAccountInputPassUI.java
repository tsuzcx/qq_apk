package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountInputPassUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2131495379;
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
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73997);
        SettingDeleteAccountInputPassUI.this.hideVKB();
        paramAnonymousMenuItem = SettingDeleteAccountInputPassUI.this;
        Object localObject = new Intent(SettingDeleteAccountInputPassUI.this, SettingDeleteAccountUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountInputPassUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountInputPassUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    setMMTitle(2131763105);
    initView();
    AppMethodBeat.o(73998);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountInputPassUI
 * JD-Core Version:    0.7.0.1
 */