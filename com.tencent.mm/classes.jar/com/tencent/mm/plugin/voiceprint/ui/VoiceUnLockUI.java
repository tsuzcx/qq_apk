package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class VoiceUnLockUI
  extends BaseVoicePrintUI
  implements q.a
{
  private com.tencent.mm.plugin.voiceprint.model.q GSD;
  
  public final void aUv(String paramString)
  {
    AppMethodBeat.i(29928);
    this.GRf = paramString;
    this.GRA.fEV();
    this.GRA.setTipText(paramString);
    this.GRA.ekF();
    this.GRx.setEnabled(true);
    AppMethodBeat.o(29928);
  }
  
  protected final void edG()
  {
    AppMethodBeat.i(29927);
    findViewById(2131307087).setVisibility(8);
    this.GRA.fEU();
    this.GRA.setTitleText(2131767171);
    this.GRA.fEW();
    this.GRx.setEnabled(false);
    AppMethodBeat.o(29927);
  }
  
  public final void fED()
  {
    AppMethodBeat.i(29931);
    fEJ();
    AppMethodBeat.o(29931);
  }
  
  public final void fEF()
  {
    AppMethodBeat.i(29932);
    acL(2131767172);
    AppMethodBeat.o(29932);
  }
  
  protected final void fEK()
  {
    AppMethodBeat.i(29926);
    Log.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[] { this.GRC });
    if ((!Util.isNullOrNil(this.GRC)) && (!Util.isNullOrNil(this.GSD.GRf)))
    {
      Object localObject = this.GSD;
      localObject = new j(this.GRC, ((com.tencent.mm.plugin.voiceprint.model.q)localObject).GRg);
      ((j)localObject).GQR = true;
      bg.azz().a((com.tencent.mm.ak.q)localObject, 0);
      this.GRx.setEnabled(false);
      this.GRA.fEU();
    }
    AppMethodBeat.o(29926);
  }
  
  protected void fET()
  {
    AppMethodBeat.i(29930);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("kscene_type", 73);
    ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(29930);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29925);
    super.onCreate(paramBundle);
    this.GSD = new com.tencent.mm.plugin.voiceprint.model.q(this);
    Log.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
    bg.azz().a(new d(73, ""), 0);
    AppMethodBeat.o(29925);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29933);
    super.onDestroy();
    com.tencent.mm.plugin.voiceprint.model.q localq = this.GSD;
    bg.azz().b(611, localq);
    bg.azz().b(613, localq);
    localq.GRw = null;
    AppMethodBeat.o(29933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wP(boolean paramBoolean)
  {
    AppMethodBeat.i(29929);
    this.GRA.ekF();
    this.GRx.setEnabled(true);
    if (paramBoolean)
    {
      Log.d("MicroMsg.VoiceUnLockUI", "unlock success");
      fET();
      AppMethodBeat.o(29929);
      return;
    }
    this.GRA.setErr(2131767170);
    this.GRA.fEX();
    AppMethodBeat.o(29929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI
 * JD-Core Version:    0.7.0.1
 */