package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountAgreementUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return 2131495378;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73995);
    final TextView localTextView = (TextView)findViewById(2131302852);
    localTextView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(73991);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        paramAnonymousView = SettingDeleteAccountAgreementUI.this;
        localObject = new Intent(SettingDeleteAccountAgreementUI.this, SettingDeleteAccountInputPassUI.class);
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(73991);
      }
    });
    final CheckedTextView localCheckedTextView = (CheckedTextView)findViewById(2131296522);
    localCheckedTextView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(73992);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        localTextView.setEnabled(localCheckedTextView.isChecked());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingDeleteAccountAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(73992);
      }
    });
    localTextView.setEnabled(localCheckedTextView.isChecked());
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73993);
        SettingDeleteAccountAgreementUI.this.hideVKB();
        SettingDeleteAccountAgreementUI.this.finish();
        AppMethodBeat.o(73993);
        return true;
      }
    });
    AppMethodBeat.o(73995);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73994);
    super.onCreate(paramBundle);
    setMMTitle(2131763105);
    initView();
    AppMethodBeat.o(73994);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingDeleteAccountAgreementUI
 * JD-Core Version:    0.7.0.1
 */