package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class VoiceUnLockUI
  extends BaseVoicePrintUI
  implements q.a
{
  private com.tencent.mm.plugin.voiceprint.model.q NIO;
  
  public final void AH(boolean paramBoolean)
  {
    AppMethodBeat.i(29929);
    this.NHL.eUn();
    this.NHI.setEnabled(true);
    if (paramBoolean)
    {
      Log.d("MicroMsg.VoiceUnLockUI", "unlock success");
      gxg();
      AppMethodBeat.o(29929);
      return;
    }
    this.NHL.setErr(R.l.eUV);
    this.NHL.gxj();
    AppMethodBeat.o(29929);
  }
  
  public final void bfZ(String paramString)
  {
    AppMethodBeat.i(29928);
    this.NHq = paramString;
    this.NHL.gxh();
    this.NHL.setTipText(paramString);
    this.NHL.eUn();
    this.NHI.setEnabled(true);
    AppMethodBeat.o(29928);
  }
  
  protected final void eNb()
  {
    AppMethodBeat.i(29927);
    findViewById(R.h.right_btn).setVisibility(8);
    this.NHL.dBa();
    this.NHL.setTitleText(R.l.eUW);
    this.NHL.gxi();
    this.NHI.setEnabled(false);
    AppMethodBeat.o(29927);
  }
  
  public final void gwQ()
  {
    AppMethodBeat.i(29931);
    gwW();
    AppMethodBeat.o(29931);
  }
  
  public final void gwS()
  {
    AppMethodBeat.i(29932);
    akv(R.l.eUX);
    AppMethodBeat.o(29932);
  }
  
  protected final void gwX()
  {
    AppMethodBeat.i(29926);
    Log.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[] { this.NHN });
    if ((!Util.isNullOrNil(this.NHN)) && (!Util.isNullOrNil(this.NIO.NHq)))
    {
      Object localObject = this.NIO;
      localObject = new j(this.NHN, ((com.tencent.mm.plugin.voiceprint.model.q)localObject).NHr);
      ((j)localObject).NHc = true;
      bh.aGY().a((com.tencent.mm.an.q)localObject, 0);
      this.NHI.setEnabled(false);
      this.NHL.dBa();
    }
    AppMethodBeat.o(29926);
  }
  
  protected void gxg()
  {
    AppMethodBeat.i(29930);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("kscene_type", 73);
    ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(29930);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29925);
    super.onCreate(paramBundle);
    this.NIO = new com.tencent.mm.plugin.voiceprint.model.q(this);
    Log.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
    bh.aGY().a(new d(73, ""), 0);
    AppMethodBeat.o(29925);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29933);
    super.onDestroy();
    com.tencent.mm.plugin.voiceprint.model.q localq = this.NIO;
    bh.aGY().b(611, localq);
    bh.aGY().b(613, localq);
    localq.NHH = null;
    AppMethodBeat.o(29933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI
 * JD-Core Version:    0.7.0.1
 */