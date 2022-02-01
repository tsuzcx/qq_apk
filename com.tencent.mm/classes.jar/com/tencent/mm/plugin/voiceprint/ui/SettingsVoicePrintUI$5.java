package com.tencent.mm.plugin.voiceprint.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class SettingsVoicePrintUI$5
  implements View.OnClickListener
{
  SettingsVoicePrintUI$5(SettingsVoicePrintUI paramSettingsVoicePrintUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29828);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.CnS, "android.permission.RECORD_AUDIO", 80, "", "");
    ae.i("MicroMsg.VoiceSettingsUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this.CnS });
    if (!bool)
    {
      a.a(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(29828);
      return;
    }
    SettingsVoicePrintUI.a(this.CnS);
    a.a(this, "com/tencent/mm/plugin/voiceprint/ui/SettingsVoicePrintUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(29828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI.5
 * JD-Core Version:    0.7.0.1
 */