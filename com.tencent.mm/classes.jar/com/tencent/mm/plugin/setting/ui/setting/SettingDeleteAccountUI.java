package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI
  extends MMActivity
{
  protected final int getLayoutId()
  {
    return a.g.setting_delete_account;
  }
  
  protected final void initView()
  {
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        SettingDeleteAccountUI.this.XM();
        SettingDeleteAccountUI.this.finish();
        return true;
      }
    });
    ((TextView)findViewById(a.f.delete_account_btn)).setOnClickListener(new SettingDeleteAccountUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.setting_del_account_title);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountUI
 * JD-Core Version:    0.7.0.1
 */