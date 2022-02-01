package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;

public class SettingsAliasResultUI
  extends MMActivity
{
  private TextView Dbl;
  private Button Dbm;
  private ImageView Dbn;
  private boolean Dbo;
  private String fMb;
  private TextView jBR;
  
  public int getLayoutId()
  {
    return 2131496247;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74112);
    setMMTitle(2131763146);
    this.jBR = ((TextView)findViewById(2131299510));
    this.Dbl = ((TextView)findViewById(2131296716));
    this.Dbm = ((Button)findViewById(2131307664));
    this.Dbn = ((ImageView)findViewById(2131305593));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74107);
        SettingsAliasResultUI.this.finish();
        AppMethodBeat.o(74107);
        return true;
      }
    });
    this.Dbl.setText(this.fMb);
    if (!this.Dbo)
    {
      this.Dbm.setVisibility(0);
      this.jBR.setText(getString(2131763151));
    }
    for (;;)
    {
      this.Dbm.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74108);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = new Intent(SettingsAliasResultUI.this.getContext(), RegByMobileSetPwdUI.class);
          paramAnonymousView.putExtra("kintent_hint", SettingsAliasResultUI.this.getString(2131764424));
          SettingsAliasResultUI.this.startActivityForResult(paramAnonymousView, 0);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74108);
        }
      });
      AppMethodBeat.o(74112);
      return;
      this.Dbm.setVisibility(8);
      this.jBR.setText(getString(2131763152));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74113);
    if (paramInt2 == -1) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(74113);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74109);
    super.onCreate(paramBundle);
    this.fMb = ((String)g.aAh().azQ().get(42, null));
    this.Dbo = getIntent().getBooleanExtra("has_pwd", true);
    initView();
    AppMethodBeat.o(74109);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74111);
    super.onDestroy();
    AppMethodBeat.o(74111);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74110);
    super.onPause();
    AppMethodBeat.o(74110);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI
 * JD-Core Version:    0.7.0.1
 */