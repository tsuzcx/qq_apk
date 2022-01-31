package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class VoiceLoginUI
  extends BaseVoicePrintUI
  implements n.a
{
  private String hcm = null;
  private n pMt = null;
  
  private void goBack()
  {
    setResult(0);
    finish();
  }
  
  public final void PX(String paramString)
  {
    y.d("MicroMsg.VoiceLoginUI", "onGetText");
    this.pLy = paramString;
    this.pLS.bPs();
    this.pLS.setTipText(paramString);
    this.pLS.bPr();
    this.pLP.setEnabled(true);
  }
  
  public final void bPa()
  {
    zO(R.l.voice_print_login_network_error);
  }
  
  public final void bPc()
  {
    this.pLP.setEnabled(false);
    this.pLP.setVisibility(4);
    this.pLS.bPr();
    this.pLS.setErr(R.l.voice_print_login_blocked_by_limited);
    this.pLS.bPu();
  }
  
  protected final void bPh()
  {
    y.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[] { this.pLU });
    if ((!bk.bl(this.pLU)) && (!bk.bl(this.pLy)))
    {
      Object localObject = this.pMt;
      localObject = new com.tencent.mm.plugin.voiceprint.model.h(this.pLU, ((n)localObject).pLz, ((n)localObject).fRK);
      ((com.tencent.mm.plugin.voiceprint.model.h)localObject).pLi = true;
      au.Dk().a((m)localObject, 0);
      this.pLP.setEnabled(false);
      this.pLS.bPq();
    }
  }
  
  protected final void beK()
  {
    findViewById(R.h.right_btn).setVisibility(8);
    this.pLS.bPq();
    this.pLS.setTitleText(R.l.voice_print_auth_title);
    this.pLS.bPt();
    this.pLP.setEnabled(false);
  }
  
  public final void jO(boolean paramBoolean)
  {
    this.pLS.bPr();
    this.pLP.setEnabled(true);
    if (paramBoolean)
    {
      y.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[] { bk.aac(this.pMt.fmR) });
      Intent localIntent = new Intent();
      localIntent.putExtra("VoiceLoginAuthPwd", this.pMt.fmR);
      setResult(-1, localIntent);
      finish();
      return;
    }
    y.i("MicroMsg.VoiceLoginUI", "login failed");
    this.pLS.setErr(R.l.voice_print_auth_error);
    this.pLS.bPu();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.nFQ.f(11557, new Object[] { Integer.valueOf(1) });
    this.hcm = bk.aM(getIntent().getStringExtra("Kusername"), null);
    paramBundle = bk.aM(getIntent().getStringExtra("Kvertify_key"), null);
    y.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[] { this.hcm, Boolean.valueOf(bk.bl(paramBundle)) });
    if ((bk.bl(this.hcm)) && (bk.bl(paramBundle)))
    {
      y.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
      return;
    }
    this.pMt = new n();
    this.pMt.hcm = this.hcm;
    this.pMt.fRK = paramBundle;
    this.pMt.pLB = this;
    paramBundle = this.pMt;
    if (bk.bl(paramBundle.fRK))
    {
      paramBundle = new e(paramBundle.hcm);
      au.Dk().a(paramBundle, 0);
    }
    for (;;)
    {
      y.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(a.a(this, "android.permission.RECORD_AUDIO", 80, "", "")), bk.csb(), this });
      setBackBtn(new VoiceLoginUI.1(this));
      if (!d.gF(23)) {
        break;
      }
      getWindow().setStatusBarColor(getResources().getColor(R.e.navpage));
      czk();
      return;
      paramBundle.bPb();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.pMt != null)
    {
      n localn = this.pMt;
      au.Dk().b(618, localn);
      au.Dk().b(616, localn);
      au.Dk().b(617, localn);
      localn.pLB = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.VoiceLoginUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      bPe();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_microphone_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new VoiceLoginUI.2(this), new VoiceLoginUI.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceLoginUI
 * JD-Core Version:    0.7.0.1
 */