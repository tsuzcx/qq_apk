package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SettingsPersonalInfoUI$2
  implements View.OnClickListener
{
  SettingsPersonalInfoUI$2(SettingsPersonalInfoUI paramSettingsPersonalInfoUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.nVl, PreviewHdHeadImg.class);
    this.nVl.mController.uMN.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.2
 * JD-Core Version:    0.7.0.1
 */