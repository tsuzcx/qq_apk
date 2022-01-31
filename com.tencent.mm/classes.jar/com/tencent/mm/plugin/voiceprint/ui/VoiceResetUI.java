package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

public class VoiceResetUI
  extends VoiceUnLockUI
{
  protected final void bPp()
  {
    y.d("MicroMsg.VoiceResetUI", "unlock success");
    startActivity(new Intent(this, VoiceCreateUI.class));
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceResetUI
 * JD-Core Version:    0.7.0.1
 */