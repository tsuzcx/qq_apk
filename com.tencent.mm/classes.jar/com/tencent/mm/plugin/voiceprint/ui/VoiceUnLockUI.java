package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class VoiceUnLockUI
  extends BaseVoicePrintUI
  implements q.a
{
  private com.tencent.mm.plugin.voiceprint.model.q BXf;
  
  public final void aDC(String paramString)
  {
    AppMethodBeat.i(29928);
    this.BVF = paramString;
    this.BWa.euB();
    this.BWa.setTipText(paramString);
    this.BWa.dnP();
    this.BVX.setEnabled(true);
    AppMethodBeat.o(29928);
  }
  
  protected final void dgW()
  {
    AppMethodBeat.i(29927);
    findViewById(2131304179).setVisibility(8);
    this.BWa.euA();
    this.BWa.setTitleText(2131764734);
    this.BWa.euC();
    this.BVX.setEnabled(false);
    AppMethodBeat.o(29927);
  }
  
  public final void euj()
  {
    AppMethodBeat.i(29931);
    eup();
    AppMethodBeat.o(29931);
  }
  
  public final void eul()
  {
    AppMethodBeat.i(29932);
    TL(2131764735);
    AppMethodBeat.o(29932);
  }
  
  protected final void euq()
  {
    AppMethodBeat.i(29926);
    ad.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[] { this.BWc });
    if ((!bt.isNullOrNil(this.BWc)) && (!bt.isNullOrNil(this.BXf.BVF)))
    {
      Object localObject = this.BXf;
      localObject = new j(this.BWc, ((com.tencent.mm.plugin.voiceprint.model.q)localObject).BVG);
      ((j)localObject).BVp = true;
      ba.aiU().a((n)localObject, 0);
      this.BVX.setEnabled(false);
      this.BWa.euA();
    }
    AppMethodBeat.o(29926);
  }
  
  protected void euz()
  {
    AppMethodBeat.i(29930);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("kscene_type", 73);
    ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(29930);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29925);
    super.onCreate(paramBundle);
    this.BXf = new com.tencent.mm.plugin.voiceprint.model.q(this);
    ad.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
    ba.aiU().a(new d(73, ""), 0);
    AppMethodBeat.o(29925);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29933);
    super.onDestroy();
    com.tencent.mm.plugin.voiceprint.model.q localq = this.BXf;
    ba.aiU().b(611, localq);
    ba.aiU().b(613, localq);
    localq.BVW = null;
    AppMethodBeat.o(29933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sZ(boolean paramBoolean)
  {
    AppMethodBeat.i(29929);
    this.BWa.dnP();
    this.BVX.setEnabled(true);
    if (paramBoolean)
    {
      ad.d("MicroMsg.VoiceUnLockUI", "unlock success");
      euz();
      AppMethodBeat.o(29929);
      return;
    }
    this.BWa.setErr(2131764733);
    this.BWa.euD();
    AppMethodBeat.o(29929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI
 * JD-Core Version:    0.7.0.1
 */