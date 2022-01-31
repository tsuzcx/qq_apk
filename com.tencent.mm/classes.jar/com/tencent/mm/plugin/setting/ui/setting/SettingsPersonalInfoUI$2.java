package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SettingsPersonalInfoUI$2
  implements View.OnClickListener
{
  SettingsPersonalInfoUI$2(SettingsPersonalInfoUI paramSettingsPersonalInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127366);
    paramView = new Intent(this.qJr, PreviewHdHeadImg.class);
    this.qJr.getContext().startActivity(paramView);
    AppMethodBeat.o(127366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.2
 * JD-Core Version:    0.7.0.1
 */