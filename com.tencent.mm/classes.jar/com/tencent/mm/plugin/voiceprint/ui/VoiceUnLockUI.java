package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class VoiceUnLockUI
  extends BaseVoicePrintUI
  implements q.a
{
  private com.tencent.mm.plugin.voiceprint.model.q CoG;
  
  public final void aEV(String paramString)
  {
    AppMethodBeat.i(29928);
    this.Cng = paramString;
    this.CnB.eyh();
    this.CnB.setTipText(paramString);
    this.CnB.dqN();
    this.Cny.setEnabled(true);
    AppMethodBeat.o(29928);
  }
  
  protected final void djV()
  {
    AppMethodBeat.i(29927);
    findViewById(2131304179).setVisibility(8);
    this.CnB.eyg();
    this.CnB.setTitleText(2131764734);
    this.CnB.eyi();
    this.Cny.setEnabled(false);
    AppMethodBeat.o(29927);
  }
  
  public final void exP()
  {
    AppMethodBeat.i(29931);
    exV();
    AppMethodBeat.o(29931);
  }
  
  public final void exR()
  {
    AppMethodBeat.i(29932);
    Us(2131764735);
    AppMethodBeat.o(29932);
  }
  
  protected final void exW()
  {
    AppMethodBeat.i(29926);
    ae.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[] { this.CnD });
    if ((!bu.isNullOrNil(this.CnD)) && (!bu.isNullOrNil(this.CoG.Cng)))
    {
      Object localObject = this.CoG;
      localObject = new j(this.CnD, ((com.tencent.mm.plugin.voiceprint.model.q)localObject).Cnh);
      ((j)localObject).CmQ = true;
      bc.ajj().a((n)localObject, 0);
      this.Cny.setEnabled(false);
      this.CnB.eyg();
    }
    AppMethodBeat.o(29926);
  }
  
  protected void eyf()
  {
    AppMethodBeat.i(29930);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("kscene_type", 73);
    ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(29930);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29925);
    super.onCreate(paramBundle);
    this.CoG = new com.tencent.mm.plugin.voiceprint.model.q(this);
    ae.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
    bc.ajj().a(new d(73, ""), 0);
    AppMethodBeat.o(29925);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29933);
    super.onDestroy();
    com.tencent.mm.plugin.voiceprint.model.q localq = this.CoG;
    bc.ajj().b(611, localq);
    bc.ajj().b(613, localq);
    localq.Cnx = null;
    AppMethodBeat.o(29933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void tg(boolean paramBoolean)
  {
    AppMethodBeat.i(29929);
    this.CnB.dqN();
    this.Cny.setEnabled(true);
    if (paramBoolean)
    {
      ae.d("MicroMsg.VoiceUnLockUI", "unlock success");
      eyf();
      AppMethodBeat.o(29929);
      return;
    }
    this.CnB.setErr(2131764733);
    this.CnB.eyj();
    AppMethodBeat.o(29929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI
 * JD-Core Version:    0.7.0.1
 */