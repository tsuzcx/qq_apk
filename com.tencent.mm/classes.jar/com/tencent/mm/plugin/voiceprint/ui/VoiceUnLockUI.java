package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class VoiceUnLockUI
  extends BaseVoicePrintUI
  implements q.a
{
  private com.tencent.mm.plugin.voiceprint.model.q zfe;
  
  public final void atc(String paramString)
  {
    AppMethodBeat.i(29928);
    this.zdE = paramString;
    this.zdZ.dRF();
    this.zdZ.setTipText(paramString);
    this.zdZ.cQI();
    this.zdW.setEnabled(true);
    AppMethodBeat.o(29928);
  }
  
  protected final void cKf()
  {
    AppMethodBeat.i(29927);
    findViewById(2131304179).setVisibility(8);
    this.zdZ.cQH();
    this.zdZ.setTitleText(2131764734);
    this.zdZ.dRG();
    this.zdW.setEnabled(false);
    AppMethodBeat.o(29927);
  }
  
  protected void dRE()
  {
    AppMethodBeat.i(29930);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("kscene_type", 73);
    ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(29930);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(29931);
    dRu();
    AppMethodBeat.o(29931);
  }
  
  public final void dRp()
  {
    AppMethodBeat.i(29932);
    PK(2131764735);
    AppMethodBeat.o(29932);
  }
  
  protected final void dRv()
  {
    AppMethodBeat.i(29926);
    ad.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[] { this.zeb });
    if ((!bt.isNullOrNil(this.zeb)) && (!bt.isNullOrNil(this.zfe.zdE)))
    {
      Object localObject = this.zfe;
      localObject = new j(this.zeb, ((com.tencent.mm.plugin.voiceprint.model.q)localObject).zdF);
      ((j)localObject).zdo = true;
      az.aeS().a((n)localObject, 0);
      this.zdW.setEnabled(false);
      this.zdZ.cQH();
    }
    AppMethodBeat.o(29926);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29925);
    super.onCreate(paramBundle);
    this.zfe = new com.tencent.mm.plugin.voiceprint.model.q(this);
    ad.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
    az.aeS().a(new d(73, ""), 0);
    AppMethodBeat.o(29925);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29933);
    super.onDestroy();
    com.tencent.mm.plugin.voiceprint.model.q localq = this.zfe;
    az.aeS().b(611, localq);
    az.aeS().b(613, localq);
    localq.zdV = null;
    AppMethodBeat.o(29933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rp(boolean paramBoolean)
  {
    AppMethodBeat.i(29929);
    this.zdZ.cQI();
    this.zdW.setEnabled(true);
    if (paramBoolean)
    {
      ad.d("MicroMsg.VoiceUnLockUI", "unlock success");
      dRE();
      AppMethodBeat.o(29929);
      return;
    }
    this.zdZ.setErr(2131764733);
    this.zdZ.dRH();
    AppMethodBeat.o(29929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI
 * JD-Core Version:    0.7.0.1
 */