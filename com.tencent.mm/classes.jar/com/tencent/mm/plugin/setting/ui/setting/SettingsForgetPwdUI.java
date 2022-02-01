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
  private Button fwU;
  
  public int getLayoutId()
  {
    return 2131495393;
  }
  
  public void initView()
  {
    AppMethodBeat.i(191029);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191026);
        SettingsForgetPwdUI.this.onBackPressed();
        AppMethodBeat.o(191026);
        return true;
      }
    });
    this.fwU = ((Button)findViewById(2131302852));
    this.fwU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191027);
        SettingsForgetPwdUI.this.onBackPressed();
        AppMethodBeat.o(191027);
      }
    });
    AppMethodBeat.o(191029);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(191028);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(191028);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsForgetPwdUI
 * JD-Core Version:    0.7.0.1
 */