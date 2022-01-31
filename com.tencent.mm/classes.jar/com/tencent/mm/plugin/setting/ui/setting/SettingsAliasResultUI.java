package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

public class SettingsAliasResultUI
  extends MMActivity
{
  private String cMT;
  private TextView eXP;
  private TextView nTR;
  private Button nTS;
  private ImageView nTT;
  private boolean nTU;
  
  protected final int getLayoutId()
  {
    return a.g.settings_alias_result;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.modify_username);
    this.eXP = ((TextView)findViewById(a.f.desc_tv));
    this.nTR = ((TextView)findViewById(a.f.alias_tv));
    this.nTS = ((Button)findViewById(a.f.setpwd_btn));
    this.nTT = ((ImageView)findViewById(a.f.ok_iv));
    setBackBtn(new SettingsAliasResultUI.1(this));
    this.nTR.setText(this.cMT);
    if (!this.nTU)
    {
      this.nTS.setVisibility(0);
      this.eXP.setText(getString(a.i.modify_username_result_goto_setpass));
    }
    for (;;)
    {
      this.nTS.setOnClickListener(new SettingsAliasResultUI.2(this));
      return;
      this.nTS.setVisibility(8);
      this.eXP.setText(getString(a.i.modify_username_result_normal_desc));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.cMT = ((String)g.DP().Dz().get(42, null));
    this.nTU = Boolean.valueOf(getIntent().getBooleanExtra("has_pwd", true)).booleanValue();
    initView();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI
 * JD-Core Version:    0.7.0.1
 */