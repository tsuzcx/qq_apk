package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class VoiceUnLockUI
  extends BaseVoicePrintUI
  implements q.a
{
  private q pNa;
  
  public final void PX(String paramString)
  {
    this.pLy = paramString;
    this.pLS.bPs();
    this.pLS.setTipText(paramString);
    this.pLS.bPr();
    this.pLP.setEnabled(true);
  }
  
  public final void bPa()
  {
    bPg();
  }
  
  protected final void bPh()
  {
    y.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[] { this.pLU });
    if ((!bk.bl(this.pLU)) && (!bk.bl(this.pNa.pLy)))
    {
      Object localObject = this.pNa;
      localObject = new j(this.pLU, ((q)localObject).pLz);
      ((j)localObject).pLi = true;
      au.Dk().a((m)localObject, 0);
      this.pLP.setEnabled(false);
      this.pLS.bPq();
    }
  }
  
  protected void bPp()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("kscene_type", 73);
    localIntent.setClass(this, VoicePrintFinishUI.class);
    startActivity(localIntent);
    finish();
  }
  
  protected final void beK()
  {
    findViewById(R.h.right_btn).setVisibility(8);
    this.pLS.bPq();
    this.pLS.setTitleText(R.l.voice_print_auth_title);
    this.pLS.bPt();
    this.pLP.setEnabled(false);
  }
  
  public final void jP(boolean paramBoolean)
  {
    this.pLS.bPr();
    this.pLP.setEnabled(true);
    if (paramBoolean)
    {
      y.d("MicroMsg.VoiceUnLockUI", "unlock success");
      bPp();
      return;
    }
    this.pLS.setErr(R.l.voice_print_auth_error);
    this.pLS.bPu();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.pNa = new q(this);
    y.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
    au.Dk().a(new d(73, ""), 0);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    q localq = this.pNa;
    au.Dk().b(611, localq);
    au.Dk().b(613, localq);
    localq.pLO = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceUnLockUI
 * JD-Core Version:    0.7.0.1
 */