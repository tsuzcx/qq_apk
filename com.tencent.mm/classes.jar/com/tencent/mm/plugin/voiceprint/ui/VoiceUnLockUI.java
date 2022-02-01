package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class VoiceUnLockUI
  extends BaseVoicePrintUI
  implements q.a
{
  private com.tencent.mm.plugin.voiceprint.model.q AxK;
  
  public final void ayt(String paramString)
  {
    AppMethodBeat.i(29928);
    this.Awk = paramString;
    this.AwF.egQ();
    this.AwF.setTipText(paramString);
    this.AwF.der();
    this.AwC.setEnabled(true);
    AppMethodBeat.o(29928);
  }
  
  protected final void cXK()
  {
    AppMethodBeat.i(29927);
    findViewById(2131304179).setVisibility(8);
    this.AwF.egP();
    this.AwF.setTitleText(2131764734);
    this.AwF.egR();
    this.AwC.setEnabled(false);
    AppMethodBeat.o(29927);
  }
  
  protected final void egF()
  {
    AppMethodBeat.i(29926);
    ac.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[] { this.AwH });
    if ((!bs.isNullOrNil(this.AwH)) && (!bs.isNullOrNil(this.AxK.Awk)))
    {
      Object localObject = this.AxK;
      localObject = new j(this.AwH, ((com.tencent.mm.plugin.voiceprint.model.q)localObject).Awl);
      ((j)localObject).AvU = true;
      az.agi().a((n)localObject, 0);
      this.AwC.setEnabled(false);
      this.AwF.egP();
    }
    AppMethodBeat.o(29926);
  }
  
  protected void egO()
  {
    AppMethodBeat.i(29930);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("kscene_type", 73);
    ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(29930);
  }
  
  public final void egx()
  {
    AppMethodBeat.i(29931);
    egE();
    AppMethodBeat.o(29931);
  }
  
  public final void egz()
  {
    AppMethodBeat.i(29932);
    RT(2131764735);
    AppMethodBeat.o(29932);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29925);
    super.onCreate(paramBundle);
    this.AxK = new com.tencent.mm.plugin.voiceprint.model.q(this);
    ac.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
    az.agi().a(new d(73, ""), 0);
    AppMethodBeat.o(29925);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29933);
    super.onDestroy();
    com.tencent.mm.plugin.voiceprint.model.q localq = this.AxK;
    az.agi().b(611, localq);
    az.agi().b(613, localq);
    localq.AwB = null;
    AppMethodBeat.o(29933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sq(boolean paramBoolean)
  {
    AppMethodBeat.i(29929);
    this.AwF.der();
    this.AwC.setEnabled(true);
    if (paramBoolean)
    {
      ac.d("MicroMsg.VoiceUnLockUI", "unlock success");
      egO();
      AppMethodBeat.o(29929);
      return;
    }
    this.AwF.setErr(2131764733);
    this.AwF.egS();
    AppMethodBeat.o(29929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI
 * JD-Core Version:    0.7.0.1
 */