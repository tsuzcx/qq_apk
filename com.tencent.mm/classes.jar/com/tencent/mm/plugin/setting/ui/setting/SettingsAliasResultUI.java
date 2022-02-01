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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;

public class SettingsAliasResultUI
  extends MMActivity
{
  private String eKn;
  private TextView hJe;
  private TextView wgo;
  private Button wgp;
  private ImageView wgq;
  private boolean wgr;
  
  public int getLayoutId()
  {
    return 2131495386;
  }
  
  public void initView()
  {
    AppMethodBeat.i(74112);
    setMMTitle(2131761319);
    this.hJe = ((TextView)findViewById(2131299008));
    this.wgo = ((TextView)findViewById(2131296639));
    this.wgp = ((Button)findViewById(2131304612));
    this.wgq = ((ImageView)findViewById(2131303000));
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
    this.wgo.setText(this.eKn);
    if (!this.wgr)
    {
      this.wgp.setVisibility(0);
      this.hJe.setText(getString(2131761324));
    }
    for (;;)
    {
      this.wgp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(74108);
          paramAnonymousView = new Intent(SettingsAliasResultUI.this.getContext(), RegByMobileSetPwdUI.class);
          paramAnonymousView.putExtra("kintent_hint", SettingsAliasResultUI.this.getString(2131762358));
          SettingsAliasResultUI.this.startActivityForResult(paramAnonymousView, 0);
          AppMethodBeat.o(74108);
        }
      });
      AppMethodBeat.o(74112);
      return;
      this.wgp.setVisibility(8);
      this.hJe.setText(getString(2131761325));
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
    this.eKn = ((String)g.afB().afk().get(42, null));
    this.wgr = getIntent().getBooleanExtra("has_pwd", true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI
 * JD-Core Version:    0.7.0.1
 */