package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class VoiceUnLockUI
  extends BaseVoicePrintUI
  implements q.a
{
  private q UuQ;
  
  public final void Gg(boolean paramBoolean)
  {
    AppMethodBeat.i(29929);
    this.UtL.gdb();
    this.UtI.setEnabled(true);
    if (paramBoolean)
    {
      Log.d("MicroMsg.VoiceUnLockUI", "unlock success");
      hVd();
      AppMethodBeat.o(29929);
      return;
    }
    this.UtL.setErr(R.l.gXZ);
    this.UtL.hVg();
    AppMethodBeat.o(29929);
  }
  
  public final void bfF(String paramString)
  {
    AppMethodBeat.i(29928);
    this.Utq = paramString;
    this.UtL.hVe();
    this.UtL.setTipText(paramString);
    this.UtL.gdb();
    this.UtI.setEnabled(true);
    AppMethodBeat.o(29928);
  }
  
  protected final void fVu()
  {
    AppMethodBeat.i(29927);
    findViewById(R.h.right_btn).setVisibility(8);
    this.UtL.eAg();
    this.UtL.setTitleText(R.l.gYa);
    this.UtL.hVf();
    this.UtI.setEnabled(false);
    AppMethodBeat.o(29927);
  }
  
  public final void hUN()
  {
    AppMethodBeat.i(29931);
    hUT();
    AppMethodBeat.o(29931);
  }
  
  public final void hUP()
  {
    AppMethodBeat.i(29932);
    apQ(R.l.gYb);
    AppMethodBeat.o(29932);
  }
  
  protected final void hUU()
  {
    AppMethodBeat.i(29926);
    Log.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[] { this.UtN });
    if ((!Util.isNullOrNil(this.UtN)) && (!Util.isNullOrNil(this.UuQ.Utq)))
    {
      Object localObject = this.UuQ;
      localObject = new j(this.UtN, ((q)localObject).Utr);
      ((j)localObject).Utc = true;
      bh.aZW().a((p)localObject, 0);
      this.UtI.setEnabled(false);
      this.UtL.eAg();
    }
    AppMethodBeat.o(29926);
  }
  
  protected void hVd()
  {
    AppMethodBeat.i(29930);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("kscene_type", 73);
    ((Intent)localObject).setClass(this, VoicePrintFinishUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceUnLockUI", "onUnlockSuccess", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(29930);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29925);
    super.onCreate(paramBundle);
    this.UuQ = new q(this);
    Log.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
    bh.aZW().a(new d(73, ""), 0);
    AppMethodBeat.o(29925);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(29933);
    super.onDestroy();
    q localq = this.UuQ;
    bh.aZW().b(611, localq);
    bh.aZW().b(613, localq);
    localq.UtH = null;
    AppMethodBeat.o(29933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI
 * JD-Core Version:    0.7.0.1
 */