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
  private Button fQh;
  
  public int getLayoutId()
  {
    return 2131495393;
  }
  
  public void initView()
  {
    AppMethodBeat.i(220996);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131101179));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(220993);
        SettingsForgetPwdUI.this.onBackPressed();
        AppMethodBeat.o(220993);
        return true;
      }
    });
    this.fQh = ((Button)findViewById(2131302852));
    this.fQh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220994);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsForgetPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        SettingsForgetPwdUI.this.onBackPressed();
        a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsForgetPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220994);
      }
    });
    AppMethodBeat.o(220996);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(220995);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(220995);
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