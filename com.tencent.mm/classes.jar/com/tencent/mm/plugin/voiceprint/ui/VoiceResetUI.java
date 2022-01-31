package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class VoiceResetUI
  extends VoiceUnLockUI
{
  protected final void cLw()
  {
    AppMethodBeat.i(26222);
    ab.d("MicroMsg.VoiceResetUI", "unlock success");
    startActivity(new Intent(this, VoiceCreateUI.class));
    finish();
    AppMethodBeat.o(26222);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceResetUI
 * JD-Core Version:    0.7.0.1
 */