package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2130970682;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127072);
    setBackBtn(new SettingDeleteAccountUI.1(this));
    ((TextView)findViewById(2131827591)).setOnClickListener(new SettingDeleteAccountUI.2(this));
    AppMethodBeat.o(127072);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127071);
    super.onCreate(paramBundle);
    setMMTitle(2131303144);
    initView();
    AppMethodBeat.o(127071);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountUI
 * JD-Core Version:    0.7.0.1
 */