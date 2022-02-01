package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;

public class SettingsAliasResultUI
  extends MMActivity
{
  private TextView PrE;
  private Button PrF;
  private ImageView PrG;
  private boolean PrH;
  private String kDc;
  private TextView plr;
  
  public int getLayoutId()
  {
    return b.g.settings_alias_result;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74112);
    setMMTitle(b.i.modify_username);
    this.plr = ((TextView)findViewById(b.f.desc_tv));
    this.PrE = ((TextView)findViewById(b.f.alias_tv));
    this.PrF = ((Button)findViewById(b.f.setpwd_btn));
    this.PrG = ((ImageView)findViewById(b.f.ok_iv));
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
    this.PrE.setText(this.kDc);
    if (!this.PrH)
    {
      this.PrF.setVisibility(0);
      this.plr.setText(getString(b.i.modify_username_result_goto_setpass));
    }
    for (;;)
    {
      this.PrF.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74108);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/setting/ui/setting/SettingsAliasResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = new Intent(SettingsAliasResultUI.this.getContext(), RegByMobileSetPwdUI.class);
          paramAnonymousView.putExtra("kintent_hint", SettingsAliasResultUI.this.getString(b.i.regbymobile_reg_setpwd_tip_after_set_alias));
          SettingsAliasResultUI.this.startActivityForResult(paramAnonymousView, 0);
          a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsAliasResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(74108);
        }
      });
      AppMethodBeat.o(74112);
      return;
      this.PrF.setVisibility(8);
      this.plr.setText(getString(b.i.modify_username_result_normal_desc));
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
    this.kDc = ((String)h.baE().ban().d(42, null));
    this.PrH = getIntent().getBooleanExtra("has_pwd", true);
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