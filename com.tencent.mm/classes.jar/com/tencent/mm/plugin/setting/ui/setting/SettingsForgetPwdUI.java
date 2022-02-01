package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class SettingsForgetPwdUI
  extends MMActivity
{
  private Button ftn;
  
  public int getLayoutId()
  {
    return 2131495393;
  }
  
  public void initView()
  {
    AppMethodBeat.i(186563);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(186560);
        SettingsForgetPwdUI.this.onBackPressed();
        AppMethodBeat.o(186560);
        return true;
      }
    });
    this.ftn = ((Button)findViewById(2131302852));
    this.ftn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186561);
        SettingsForgetPwdUI.this.onBackPressed();
        AppMethodBeat.o(186561);
      }
    });
    AppMethodBeat.o(186563);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(186562);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(186562);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsForgetPwdUI
 * JD-Core Version:    0.7.0.1
 */