package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class VoiceResetUI
  extends VoiceUnLockUI
{
  protected final void eyf()
  {
    AppMethodBeat.i(29905);
    ae.d("MicroMsg.VoiceResetUI", "unlock success");
    Object localObject = new Intent(this, VoiceCreateUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/voiceprint/ui/VoiceResetUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceResetUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(29905);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceResetUI
 * JD-Core Version:    0.7.0.1
 */