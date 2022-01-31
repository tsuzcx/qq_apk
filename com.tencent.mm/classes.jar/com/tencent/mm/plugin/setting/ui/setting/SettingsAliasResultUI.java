package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

public class SettingsAliasResultUI
  extends MMActivity
{
  private String dCJ;
  private TextView gpM;
  private TextView qHR;
  private Button qHS;
  private ImageView qHT;
  private boolean qHU;
  
  public int getLayoutId()
  {
    return 2130970690;
  }
  
  public void initView()
  {
    AppMethodBeat.i(127182);
    setMMTitle(2131301615);
    this.gpM = ((TextView)findViewById(2131821007));
    this.qHR = ((TextView)findViewById(2131821117));
    this.qHS = ((Button)findViewById(2131827605));
    this.qHT = ((ImageView)findViewById(2131827604));
    setBackBtn(new SettingsAliasResultUI.1(this));
    this.qHR.setText(this.dCJ);
    if (!this.qHU)
    {
      this.qHS.setVisibility(0);
      this.gpM.setText(getString(2131301620));
    }
    for (;;)
    {
      this.qHS.setOnClickListener(new SettingsAliasResultUI.2(this));
      AppMethodBeat.o(127182);
      return;
      this.qHS.setVisibility(8);
      this.gpM.setText(getString(2131301621));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(127183);
    if (paramInt2 == -1) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(127183);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127179);
    super.onCreate(paramBundle);
    this.dCJ = ((String)g.RL().Ru().get(42, null));
    this.qHU = getIntent().getBooleanExtra("has_pwd", true);
    initView();
    AppMethodBeat.o(127179);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127181);
    super.onDestroy();
    AppMethodBeat.o(127181);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(127180);
    super.onPause();
    AppMethodBeat.o(127180);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasResultUI
 * JD-Core Version:    0.7.0.1
 */