package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SettingsVoicePrintUI$5
  implements View.OnClickListener
{
  SettingsVoicePrintUI$5(SettingsVoicePrintUI paramSettingsVoicePrintUI) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = a.a(this.pMj, "android.permission.RECORD_AUDIO", 80, "", "");
    y.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.pMj });
    if (!bool) {
      return;
    }
    SettingsVoicePrintUI.a(this.pMj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.5
 * JD-Core Version:    0.7.0.1
 */