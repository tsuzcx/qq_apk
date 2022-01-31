package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class VoicePrintFinishUI$1
  implements View.OnClickListener
{
  VoicePrintFinishUI$1(VoicePrintFinishUI paramVoicePrintFinishUI) {}
  
  public final void onClick(View paramView)
  {
    if (VoicePrintFinishUI.a(this.pMz) == 72)
    {
      paramView = new Intent();
      paramView.setClass(this.pMz, VoiceUnLockUI.class);
      paramView.putExtra("kscene_type", 73);
      this.pMz.startActivity(paramView);
    }
    this.pMz.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoicePrintFinishUI.1
 * JD-Core Version:    0.7.0.1
 */