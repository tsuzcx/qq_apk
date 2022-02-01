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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;

public class SettingsForgetPwdUI
  extends MMActivity
{
  private Button gxv;
  
  public int getLayoutId()
  {
    return 2131496254;
  }
  
  public void initView()
  {
    AppMethodBeat.i(256545);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101424));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256542);
        SettingsForgetPwdUI.this.onBackPressed();
        AppMethodBeat.o(256542);
        return true;
      }
    });
    this.gxv = ((Button)findViewById(2131305423));
    this.gxv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256543);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsForgetPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SettingsForgetPwdUI.this.onBackPressed();
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsForgetPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256543);
      }
    });
    AppMethodBeat.o(256545);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256544);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(256544);
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