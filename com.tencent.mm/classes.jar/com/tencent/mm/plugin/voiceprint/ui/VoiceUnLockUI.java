package com.tencent.mm.plugin.voiceprint.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class VoiceUnLockUI
  extends BaseVoicePrintUI
  implements q.a
{
  private q tsU;
  
  public final void aeD(String paramString)
  {
    AppMethodBeat.i(26244);
    this.tru = paramString;
    this.trO.cLx();
    this.trO.setTipText(paramString);
    this.trO.bRO();
    this.trL.setEnabled(true);
    AppMethodBeat.o(26244);
  }
  
  protected final void bMe()
  {
    AppMethodBeat.i(26243);
    findViewById(2131823890).setVisibility(8);
    this.trO.bRN();
    this.trO.setTitleText(2131304561);
    this.trO.cLy();
    this.trL.setEnabled(false);
    AppMethodBeat.o(26243);
  }
  
  public final void cLf()
  {
    AppMethodBeat.i(26247);
    cLm();
    AppMethodBeat.o(26247);
  }
  
  public final void cLg()
  {
    AppMethodBeat.i(153683);
    GY(2131304562);
    AppMethodBeat.o(153683);
  }
  
  protected final void cLn()
  {
    AppMethodBeat.i(26242);
    ab.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[] { this.trQ });
    if ((!bo.isNullOrNil(this.trQ)) && (!bo.isNullOrNil(this.tsU.tru)))
    {
      Object localObject = this.tsU;
      localObject = new j(this.trQ, ((q)localObject).trv);
      ((j)localObject).tre = true;
      aw.Rc().a((m)localObject, 0);
      this.trL.setEnabled(false);
      this.trO.bRN();
    }
    AppMethodBeat.o(26242);
  }
  
  protected void cLw()
  {
    AppMethodBeat.i(26246);
    Intent localIntent = new Intent();
    localIntent.putExtra("kscene_type", 73);
    localIntent.setClass(this, VoicePrintFinishUI.class);
    startActivity(localIntent);
    finish();
    AppMethodBeat.o(26246);
  }
  
  public final void mI(boolean paramBoolean)
  {
    AppMethodBeat.i(26245);
    this.trO.bRO();
    this.trL.setEnabled(true);
    if (paramBoolean)
    {
      ab.d("MicroMsg.VoiceUnLockUI", "unlock success");
      cLw();
      AppMethodBeat.o(26245);
      return;
    }
    this.trO.setErr(2131304560);
    this.trO.cLz();
    AppMethodBeat.o(26245);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26241);
    super.onCreate(paramBundle);
    this.tsU = new q(this);
    ab.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
    aw.Rc().a(new d(73, ""), 0);
    AppMethodBeat.o(26241);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26248);
    super.onDestroy();
    q localq = this.tsU;
    aw.Rc().b(611, localq);
    aw.Rc().b(613, localq);
    localq.trK = null;
    AppMethodBeat.o(26248);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI
 * JD-Core Version:    0.7.0.1
 */