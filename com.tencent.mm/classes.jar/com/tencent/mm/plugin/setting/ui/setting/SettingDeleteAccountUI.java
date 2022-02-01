package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return b.g.setting_delete_account;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74003);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74000);
        SettingDeleteAccountUI.this.hideVKB();
        SettingDeleteAccountUI.this.finish();
        AppMethodBeat.o(74000);
        return true;
      }
    });
    ((TextView)findViewById(b.f.delete_account_btn)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(74001);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(74001);
      }
    });
    AppMethodBeat.o(74003);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74002);
    super.onCreate(paramBundle);
    setMMTitle(b.i.setting_del_account_title);
    initView();
    AppMethodBeat.o(74002);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountUI
 * JD-Core Version:    0.7.0.1
 */